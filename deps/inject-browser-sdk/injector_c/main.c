#include <stdbool.h>
#include <stdio.h>
#include <string.h>

#include "./injectbrowsersdk.h"

void test_injection(Snippet *snippet) {
  printf("=======================\n");
  printf("Snippet length: %d\n", snippet->length);
  printf("Snippet error_code: %d\n", snippet->error_code);
  printf("Snippet error_message: %s\n", snippet->error_message);
  printf("Output:\n");

  Injector *injector = injector_create(snippet);

  char *html = "\n\
    <html>\n\
        <head>\n\
            <title>foo</title>\n\
        </head>\n\
        <body>\n\
            ...\n\
        </body>\n\
    </html>";

  InjectorResult result =
      injector_write(injector, (uint8_t *)html, strlen(html));

  for (int i = 0; i < result.slices_length; i += 1) {
    BytesSlice slice = result.slices[i];
    fwrite(slice.start, sizeof(uint8_t), slice.length, stdout);
  }

  injector_cleanup(injector);
  printf("\n\n");
}

int main() {
  {
    struct Configuration configuration = {.major_version = 5,
                                          .rum = {
                                              .client_token = "foo",
                                              .application_id = "bar →→",
                                              .default_privacy_level = "allow",
                                              .track_resources = true,
                                              .session_sample_rate = 42.42,
                                          }};

    Snippet *snippet = snippet_create_from_struct(configuration);
    test_injection(snippet);
    snippet_cleanup(snippet);
  }

  {
    void *snippet = snippet_create_from_json("\
{\
  \"majorVersion\": 5,\
  \"rum\": {\
    \"clientToken\":\"foo\",\
    \"applicationId\": \"bar →\\u2192\",\
    \"defaultPrivacyLevel\": \"allow\",\
    \"trackResources\": true,\
    \"sessionSampleRate\": 42.42\
  }\
}\
");
    test_injection(snippet);
    snippet_cleanup(snippet);
  }

  {
    void *snippet = snippet_create_from_json("\
{\
  \"majorVersion\": 2,\
  \"rum\": {\
  }\
}\
");
    test_injection(snippet);
    snippet_cleanup(snippet);
  }

  {
    void *snippet = snippet_create_from_json("{}");
    test_injection(snippet);
    snippet_cleanup(snippet);
  }

  {
    void *snippet = snippet_create_from_json("");
    test_injection(snippet);
    snippet_cleanup(snippet);
  }
}
