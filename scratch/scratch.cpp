// #include <memory>

namespace ns {

struct bar_t {};

struct foo_t {
    int x;
    bar_t y;
};

} // namespace ns

namespace derp {

namespace other = ::ns;

bool do_thing(other::foo_t *foo, other::foo_t value) {
    return foo->x > value.x;
}

/*
bool foo(std::unique_ptr<other::foo_t> p) {
    return p->x > 0;
}

bool bar(std::unique_ptr<other::foo_t> p) {
    return (*p).x > 0;
}
*/

} // namespace derp
