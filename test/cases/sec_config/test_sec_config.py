from pathlib import Path

from .. import case


class TestSecConfig(case.TestCase):
    def apply_config(self, conf_name):
        conf_path = Path(__file__).parent / f'./conf/http_{conf_name}.conf'
        conf_text = conf_path.read_text()
        status, log_lines = self.orch.nginx_replace_config(
            conf_text, conf_path.name)
        self.assertEqual(0, status, log_lines)

    def test_custom_templates(self):
        templ_json_path = Path(__file__).parent / './conf/templ.json'
        templ_html_path = Path(__file__).parent / './conf/templ.html'
        self.orch.nginx_replace_file('/tmp/templ.json', templ_json_path.read_text())
        self.orch.nginx_replace_file('/tmp/templ.html', templ_html_path.read_text())

        self.apply_config('custom_blocking_templates')

        headers = {'User-Agent': 'dd-test-scanner-log-block', 'Accept': 'text/html'}
        status, headers, body = self.orch.send_nginx_http_request(
            '/http', 80, headers)
        self.assertEqual(status, 403)
        # find content-type header:
        ct = next((v for k, v in headers if k.lower() == "content-type"), None)
        self.assertEqual(ct, 'text/html;charset=utf-8')
        self.assertTrue('My custom blocking response' in body)

        headers = {'User-Agent': 'dd-test-scanner-log-block', 'Accept': 'text/json'}
        status, headers, body = self.orch.send_nginx_http_request(
            '/http', 80, headers)
        self.assertEqual(status, 403)
        ct = next((v for k, v in headers if k.lower() == "content-type"), None)
        self.assertEqual(ct, 'application/json')
        self.assertEqual(body, '{"error": "blocked", "details": "my custom json response"}\n')

    def test_appsec_fully_disabled(self):
        self.apply_config('appsec_fully_disabled')

        headers = {'User-Agent': 'dd-test-scanner-log-block', 'Accept': 'text/json'}
        status, _, _ = self.orch.send_nginx_http_request('/', 80, headers)
        self.assertEqual(status, 200)

    def test_bad_custom_template(self):
        self.apply_config('bad_template_file')

        msg = self.orch.wait_for_log_message('nginx', '.*Initialising security library failed.*', timeout_secs=5)
        self.assertTrue('Failed to open file: /file/that/does/not/exist' in msg)

    def test_bad_rules_file(self):
        self.apply_config('bad_rules_file')

        msg = self.orch.wait_for_log_message('nginx', '.*Initialising security library failed.*', timeout_secs=5)
        self.assertTrue('Failed to open file: /bad/rules/file' in msg)

    def test_bad_pool_name(self):
        conf_path = Path(__file__).parent / 'conf/http_bad_thread_pool.conf'
        conf_text = conf_path.read_text()
        status, log_lines = self.orch.nginx_replace_config(
            conf_text, conf_path.name)
        self.assertNotEqual(0, status, log_lines)

        self.assertTrue(any('datadog_waf_thread_pool_name: "bad_thread_pool" not found' in line for line in log_lines))

    def test_multiple_pools(self):
        self.apply_config('multiple_thread_pools')

        headers = {'User-Agent': 'dd-test-scanner-log-block'}
        status, _, _ = self.orch.send_nginx_http_request('/http/a', 80, headers)
        self.assertEqual(status, 403)

        headers = {'User-Agent': 'dd-test-scanner-log-block'}
        status, _, _ = self.orch.send_nginx_http_request('/local/', 80, headers)
        self.assertEqual(status, 403)

        headers = {'User-Agent': 'dd-test-scanner-log-block'}
        status, _, _ = self.orch.send_nginx_http_request('/unmonitored/index.html', 80, headers)
        self.assertEqual(status, 200)

