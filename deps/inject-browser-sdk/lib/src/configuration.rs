use serde::Deserialize;
use serde_json::Value;

#[derive(Deserialize)]
#[serde(rename_all = "camelCase")]
#[cfg_attr(test, derive(Debug))]
pub struct Configuration {
    pub major_version: u32,
    pub rum: Value,
}

#[cfg(test)]
mod test {
    use pretty_assertions::assert_eq;
    use serde_json::json;

    use super::*;

    #[test]
    fn from_json() {
        let configuration: Configuration = serde_json::from_slice(
            br#"
{
  "majorVersion": 5,
  "rum": {
    "clientToken": "foo",
    "applicationId": "bar"
  }
}
"#,
        )
        .unwrap();

        assert_eq!(configuration.major_version, 5);
        assert_eq!(
            configuration.rum,
            json!({ "clientToken": "foo", "applicationId": "bar" })
        );
    }
}
