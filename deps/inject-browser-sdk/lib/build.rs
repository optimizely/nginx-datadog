fn main() {
    csbindgen::Builder::default()
        .input_extern_file("src/ffi/injector.rs")
        .input_extern_file("src/ffi/snippet.rs")
        .input_extern_file("src/snippet.rs")
        .csharp_dll_name("injectbrowsersdk")
        .csharp_namespace("InjectBrowserSdk")
        .generate_csharp_file("../injector_dotnet/InjectBrowserSdk.g.cs")
        .expect("Unable to generate C# bindings");

    cbindgen::Builder::new()
        .with_crate(".")
        .with_language(cbindgen::Language::C)
        .generate()
        .expect("Unable to generate C bindings")
        .write_to_file("../injector_c/injectbrowsersdk.h");

    cbindgen::Builder::new()
        .with_crate(".")
        .generate()
        .expect("Unable to generate C++ bindings")
        .write_to_file("../injector_IIS/lib/injectbrowsersdk.h");
}
