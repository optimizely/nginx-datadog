use serde::Serialize;
use std::io::{self, Write};

use crate::{configuration::Configuration, error::Error};

pub fn generate_snippet(configuration: &Configuration) -> Result<Vec<u8>, Error> {
    let url = format_cdn_url("rum", configuration.major_version)?;

    let mut output = Vec::new();

    output
        .write(
            br#"
<script>
(function(h,o,u,n,d) {
  h=h[d]=h[d]||{q:[],onReady:function(c){h.q.push(c)}}
  d=o.createElement(u);d.async=1;d.src=n
  n=o.getElementsByTagName(u)[0];n.parentNode.insertBefore(d,n)
})(window,document,'script','"#,
        )
        .unwrap();

    output.write(url.as_bytes()).unwrap();

    output
        .write(
            br#"','DD_RUM')
window.DD_RUM.onReady(function() {
  window.DD_RUM.init("#,
        )
        .unwrap();

    let mut serializer = serde_json::Serializer::with_formatter(&mut output, EscapeNonAscii);
    configuration.rum.serialize(&mut serializer).unwrap();

    output
        .write(
            br#");
});
</script>
"#,
        )
        .unwrap();

    Ok(output)
}

fn format_cdn_url(sdk_name: &str, major_version: u32) -> Result<String, Error> {
    if major_version != 5 {
        return Err(Error::UnsupportedMajorVersion(major_version));
    }

    Ok(format!(
        "https://www.datadoghq-browser-agent.com/us1/v{major_version}/datadog-{sdk_name}.js"
    ))
}

/// JSON Formatter that escapes all non-ASCII characters.
/// Based on https://github.com/serde-rs/json/issues/907#issuecomment-1179882369
struct EscapeNonAscii;

impl serde_json::ser::Formatter for EscapeNonAscii {
    fn write_string_fragment<W: ?Sized + Write>(
        &mut self,
        writer: &mut W,
        fragment: &str,
    ) -> io::Result<()> {
        for ch in fragment.chars() {
            if ch.is_ascii() {
                writer.write_all(ch.encode_utf8(&mut [0; 4]).as_bytes())?;
            } else {
                for escape in ch.encode_utf16(&mut [0; 2]) {
                    write!(writer, "\\u{:04x}", escape)?;
                }
            }
        }
        Ok(())
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use pretty_assertions::{assert_eq, assert_matches};
    use serde_json::json;

    #[test]
    fn test_generate_snippet() {
        assert_eq!(
            std::str::from_utf8(
                &generate_snippet(&Configuration {
                    major_version: 5,
                    rum: json!({
                        "clientToken": "foo",
                        "applicationId": "bar",
                        "defaultPrivacyLevel": "mask",
                        "trackResources": true,
                        "sessionSampleRate": 42.42
                    })
                })
                .unwrap()
            )
            .unwrap(),
            r#"
<script>
(function(h,o,u,n,d) {
  h=h[d]=h[d]||{q:[],onReady:function(c){h.q.push(c)}}
  d=o.createElement(u);d.async=1;d.src=n
  n=o.getElementsByTagName(u)[0];n.parentNode.insertBefore(d,n)
})(window,document,'script','https://www.datadoghq-browser-agent.com/us1/v5/datadog-rum.js','DD_RUM')
window.DD_RUM.onReady(function() {
  window.DD_RUM.init({"applicationId":"bar","clientToken":"foo","defaultPrivacyLevel":"mask","sessionSampleRate":42.42,"trackResources":true});
});
</script>
"#
        )
    }

    #[test]
    fn unicode_values() {
        // It is important that all non-ascii values are escaped, because we don't know the page
        // encoding.
        assert_eq!(
            std::str::from_utf8(
                &generate_snippet(&Configuration {
                    major_version: 5,
                    rum: json!({
                        "env": "☺ € é",
                    })
                })
                .unwrap()
            )
            .unwrap(),
            r#"
<script>
(function(h,o,u,n,d) {
  h=h[d]=h[d]||{q:[],onReady:function(c){h.q.push(c)}}
  d=o.createElement(u);d.async=1;d.src=n
  n=o.getElementsByTagName(u)[0];n.parentNode.insertBefore(d,n)
})(window,document,'script','https://www.datadoghq-browser-agent.com/us1/v5/datadog-rum.js','DD_RUM')
window.DD_RUM.onReady(function() {
  window.DD_RUM.init({"env":"\u263a \u20ac \u00e9"});
});
</script>
"#
        )
    }

    #[test]
    fn invalid_major_version() {
        assert_matches!(
            generate_snippet(&Configuration {
                major_version: 4,
                rum: Default::default()
            })
            .unwrap_err(),
            Error::UnsupportedMajorVersion(4)
        )
    }

    #[test]
    fn test_format_cdn_url() {
        assert_eq!(
            format_cdn_url("rum", 5).unwrap(),
            "https://www.datadoghq-browser-agent.com/us1/v5/datadog-rum.js"
        );
        assert_eq!(
            format_cdn_url("logs", 5).unwrap(),
            "https://www.datadoghq-browser-agent.com/us1/v5/datadog-logs.js"
        );
        assert_matches!(
            format_cdn_url("rum", 4).unwrap_err(),
            Error::UnsupportedMajorVersion(4)
        );
    }
}
