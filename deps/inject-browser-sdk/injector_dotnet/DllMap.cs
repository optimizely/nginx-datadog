using System.Reflection;
using System.Runtime.InteropServices;

public static class DllMap
{
    private static Dictionary<string, string> cache = new Dictionary<string, string>();

    // Register a call-back for native library resolution.
    public static void Register(Assembly assembly)
    {
        NativeLibrary.SetDllImportResolver(assembly, MapAndLoad);
    }

    // The callback: which loads the mapped libray in place of the original
    private static IntPtr MapAndLoad(string libraryName, Assembly assembly, DllImportSearchPath? dllImportSearchPath)
    {
        string? libraryPath = "";
        if (!cache.TryGetValue(libraryName, out libraryPath))
        {
            libraryPath = MapLibraryName(libraryName);
            cache.Add(libraryName, libraryPath);
        }
        return NativeLibrary.Load(libraryPath, assembly, dllImportSearchPath);
    }

    private static string MapLibraryName(string originalLibName)
    {
        string[] targets = { "debug", "release" };
        string[] names = { "lib" + originalLibName + ".dylib", originalLibName + ".dll" };
        foreach (string target in targets)
        {
            foreach (string name in names)
            {
                string path = "../lib/target/" + target + "/" + name;
                if (Path.Exists(path))
                {
                    Console.WriteLine("Using library " + path);
                    return path;
                }
            }

        }
        Console.WriteLine("Library not found.");
        System.Environment.Exit(1);
        return null;
    }
}
