fswatch -0 -o --recursive . | xargs -0 -n1 -I{} luacheck src/*.lua spec/*.lua spec/**/*.lua
