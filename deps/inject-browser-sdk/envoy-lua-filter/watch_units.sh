fswatch -0 -o --recursive . | xargs -0 -n1 -I{} busted -v --suppress-pending

