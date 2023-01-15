(translation_unit /home/david/src/nginx-datadog/scratch/scratch.cpp
  ; /home/david/src/nginx-datadog/scratch/scratch.cpp
  (namespace ns
    (struct_decl bar_t)
    (struct_decl foo_t
      (field_decl x)
      (field_decl y
        (type_ref struct ns::bar_t))))
  ; /home/david/src/nginx-datadog/scratch/scratch.cpp
  (namespace derp
    (namespace_alias other
      (namespace_ref ns))
    (function_decl do_thing
      (parm_decl foo
        (namespace_ref other)
        (type_ref struct ns::foo_t))
      (parm_decl value
        (namespace_ref other)
        (type_ref struct ns::foo_t))
      (compound_stmt
        (return_stmt
          (binary_operator
            (member_ref_expr x
              (decl_ref_expr foo))
            (member_ref_expr x
              (decl_ref_expr value))))))))

