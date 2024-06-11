using System.Reflection;
using System.Text;
using System.Runtime.InteropServices;

using InjectBrowserSdk;

DllMap.Register(Assembly.GetExecutingAssembly());

unsafe
{
    fixed (byte* client_token = MarshalStringToCString("foo"))
    fixed (byte* application_id = MarshalStringToCString("bar →→"))
    fixed (byte* default_privacy_level = MarshalStringToCString("allow"))
    {

        Snippet* snippet_1 = NativeMethods.snippet_create_from_struct(new Configuration
        {
            major_version = 5,
            rum = new RumConfiguration {
                client_token = client_token,
                application_id = application_id,
                default_privacy_level = default_privacy_level,
                track_resources = true,
                session_sample_rate = 42.42f,
            }
        });
        TestInjection(snippet_1);
        NativeMethods.snippet_cleanup(snippet_1);
    }




    fixed (byte* json = MarshalStringToCString(@"
        {
            ""majorVersion"": 5,
            ""rum"": {
                ""clientToken"":""foo"",
                ""applicationId"": ""bar →\u2192"",
                ""defaultPrivacyLevel"": ""allow"",
                ""trackResources"": true,
                ""sessionSampleRate"": 42.42
            }
        }
"))
    {
        Snippet* snippet_2 = NativeMethods.snippet_create_from_json(json);
        TestInjection(snippet_2);
        NativeMethods.snippet_cleanup(snippet_2);
    }
}

unsafe void TestInjection(Snippet *snippet) {
    Injector* injector = NativeMethods.injector_create(snippet);

    byte[] bytes = Encoding.UTF8.GetBytes(@"
    <html>
        <head>
            <title>foo</title>
        </head>
        <body>
            ...
        </body>
    </html>");

    List<byte> output = new List<byte>();

    fixed (byte* bytes_pointer = bytes) {
        InjectorResult result = NativeMethods.injector_write(injector, bytes_pointer, (uint) bytes.Length);

        for (int i = 0; i < result.slices_length; i += 1) {
            BytesSlice slice = result.slices[i];

            // FIXME: this does a copy, probably not needed
            byte[] slice_as_bytes = new byte[slice.length];
            Marshal.Copy((IntPtr)slice.start, slice_as_bytes, 0, (int) slice.length);

            output.AddRange(slice_as_bytes);
        }
    }

    // FIXME: this does a copy, probably not needed
    byte[] output_as_bytes = output.ToArray();
    string output_as_string = Encoding.UTF8.GetString(output_as_bytes, 0, output_as_bytes.Length);

    Console.WriteLine(output_as_string);

    NativeMethods.injector_cleanup(injector);
}

byte[] MarshalStringToCString(string input)
{

    int count = Encoding.UTF8.GetByteCount(input);
    byte[] result = new byte[count + 1];
    Encoding.UTF8.GetBytes(input, 0, input.Length, result, 0);
    return result;
}
