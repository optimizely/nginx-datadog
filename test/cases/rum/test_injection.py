from .. import case
from pathlib import Path


class TestRUMInjection(case.TestCase):
    def load_conf(self, conf_file):
        conf_path = Path(__file__).parent / "conf" / conf_file
        return self.orch.nginx_replace_config(conf_path.read_text(), conf_path.name)

    def assertInjection(self, headers, body):
        """
        The plugin inject:
           - `x-datadog-sdk-injected` header.
           - HTML RUM SDK scripts.
        """
        import pdb

        pdb.set_trace()
        headers = {k.lower(): v for k, v in headers}
        assert headers["content-length"] != "0"
        assert headers["x-datadog-sdk-injected"] == "1"
        assert headers.get("transfer-encoding", "") != "chunked"

        assert "datadog-rum.js" in body

    def test_injection(self):
        status, lines = self.load_conf("rum_enabled.conf")
        self.assertEqual(0, status, lines)

        status, headers, body = self.orch.send_nginx_http_request("/")
        self.assertEqual(200, status)
        self.assertInjection(headers, body)
