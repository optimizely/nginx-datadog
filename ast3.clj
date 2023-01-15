(translation_unit /home/david/src/nginx-datadog/src/defer.cpp
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/x86_64-linux-gnu/c++/11/bits/c++config.h
  (namespace std
    (typedef_decl size_t)
    (typedef_decl ptrdiff_t)
    (typedef_decl nullptr_t
      (cxx_null_ptr_literal_expr)))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/x86_64-linux-gnu/c++/11/bits/c++config.h
  (namespace std
    ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/x86_64-linux-gnu/c++/11/bits/c++config.h
    (namespace __cxx11))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/x86_64-linux-gnu/c++/11/bits/c++config.h
  (namespace __gnu_cxx
    ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/x86_64-linux-gnu/c++/11/bits/c++config.h
    (namespace __cxx11))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/bits/stl_relops.h
  (namespace std
    (visibility_attr default)
    ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/bits/stl_relops.h
    (namespace rel_ops
      (function_template operator!=
        (template_type_parameter _Tp)
        (parm_decl __x
          (type_ref _Tp))
        (parm_decl __y
          (type_ref _Tp))
        (compound_stmt
          (return_stmt
            (unary_operator
              (paren_expr
                (binary_operator
                  (decl_ref_expr __x)
                  (decl_ref_expr __y)))))))
      (function_template operator>
        (template_type_parameter _Tp)
        (parm_decl __x
          (type_ref _Tp))
        (parm_decl __y
          (type_ref _Tp))
        (compound_stmt
          (return_stmt
            (binary_operator
              (decl_ref_expr __y)
              (decl_ref_expr __x)))))
      (function_template operator<=
        (template_type_parameter _Tp)
        (parm_decl __x
          (type_ref _Tp))
        (parm_decl __y
          (type_ref _Tp))
        (compound_stmt
          (return_stmt
            (unary_operator
              (paren_expr
                (binary_operator
                  (decl_ref_expr __y)
                  (decl_ref_expr __x)))))))
      (function_template operator>=
        (template_type_parameter _Tp)
        (parm_decl __x
          (type_ref _Tp))
        (parm_decl __y
          (type_ref _Tp))
        (compound_stmt
          (return_stmt
            (unary_operator
              (paren_expr
                (binary_operator
                  (decl_ref_expr __x)
                  (decl_ref_expr __y)))))))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/bits/move.h
  (namespace std
    (visibility_attr default)
    (function_template __addressof
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __r
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr __builtin_addressof
            (decl_ref_expr __builtin_addressof)
            (decl_ref_expr __r))))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/type_traits
  (namespace std
    (visibility_attr default)
    (class_template tuple
      (template_type_parameter _Elements))
    (class_template reference_wrapper
      (template_type_parameter _Tp))
    (class_template integral_constant
      (template_type_parameter _Tp)
      (template_non_type_parameter __v
        (type_ref _Tp))
      (var_decl value
        (type_ref _Tp)
        (decl_ref_expr __v))
      (typedef_decl value_type
        (type_ref _Tp))
      (typedef_decl type
        (template_ref integral_constant)
        (type_ref _Tp)
        (decl_ref_expr __v))
      (conversion_function operator type-parameter-0-0
        (type_ref std::integral_constant::value_type)
        (compound_stmt
          (return_stmt
            (decl_ref_expr value))))
      (cxx_method operator()
        (type_ref std::integral_constant::value_type)
        (compound_stmt
          (return_stmt
            (decl_ref_expr value)))))
    (var_decl value
      (template_type_parameter _Tp)
      (template_non_type_parameter __v
        (type_ref _Tp))
      (type_ref _Tp)
      (template_ref integral_constant)
      (type_ref _Tp)
      (decl_ref_expr __v))
    (type_alias_decl true_type
      (template_ref integral_constant)
      (cxx_bool_literal_expr))
    (type_alias_decl false_type
      (template_ref integral_constant)
      (cxx_bool_literal_expr))
    (type_alias_template_decl __bool_constant
      (template_non_type_parameter __v)
      (type_alias_decl __bool_constant
        (template_ref integral_constant)
        (decl_ref_expr __v)))
    (class_template conditional
      (template_non_type_parameter)
      (template_type_parameter)
      (template_type_parameter))
    (class_template __type_identity
      (template_type_parameter _Type)
      (type_alias_decl type
        (type_ref _Type)))
    (type_alias_template_decl __type_identity_t
      (template_type_parameter _Tp)
      (type_alias_decl __type_identity_t
        (template_ref __type_identity)
        (type_ref _Tp)))
    (class_template __or_
      (template_type_parameter))
    (struct_decl __or_
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __or_
      (template_type_parameter _B1)
      (type_ref _B1)
      (cxx_base_specifier _B1
        (type_ref _B1)))
    (class_template_partial_specialization __or_
      (template_type_parameter _B1)
      (template_type_parameter _B2)
      (type_ref _B1)
      (type_ref _B2)
      (cxx_base_specifier conditional<_B1::value, _B1, _B2>::type
        (template_ref conditional)
        (decl_ref_expr
          (type_ref _B1))
        (type_ref _B1)
        (type_ref _B2)))
    (class_template_partial_specialization __or_
      (template_type_parameter _B1)
      (template_type_parameter _B2)
      (template_type_parameter _B3)
      (template_type_parameter _Bn)
      (type_ref _B1)
      (type_ref _B2)
      (type_ref _B3)
      (type_ref _Bn)
      (cxx_base_specifier conditional<_B1::value, _B1, __or_<_B2, _B3, _Bn...> >::type
        (template_ref conditional)
        (decl_ref_expr
          (type_ref _B1))
        (type_ref _B1)
        (template_ref __or_)
        (type_ref _B2)
        (type_ref _B3)
        (type_ref _Bn)))
    (class_template __and_
      (template_type_parameter))
    (struct_decl __and_
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template_partial_specialization __and_
      (template_type_parameter _B1)
      (type_ref _B1)
      (cxx_base_specifier _B1
        (type_ref _B1)))
    (class_template_partial_specialization __and_
      (template_type_parameter _B1)
      (template_type_parameter _B2)
      (type_ref _B1)
      (type_ref _B2)
      (cxx_base_specifier conditional<_B1::value, _B2, _B1>::type
        (template_ref conditional)
        (decl_ref_expr
          (type_ref _B1))
        (type_ref _B2)
        (type_ref _B1)))
    (class_template_partial_specialization __and_
      (template_type_parameter _B1)
      (template_type_parameter _B2)
      (template_type_parameter _B3)
      (template_type_parameter _Bn)
      (type_ref _B1)
      (type_ref _B2)
      (type_ref _B3)
      (type_ref _Bn)
      (cxx_base_specifier conditional<_B1::value, __and_<_B2, _B3, _Bn...>, _B1>::type
        (template_ref conditional)
        (decl_ref_expr
          (type_ref _B1))
        (template_ref __and_)
        (type_ref _B2)
        (type_ref _B3)
        (type_ref _Bn)
        (type_ref _B1)))
    (class_template __not_
      (template_type_parameter _Pp)
      (cxx_base_specifier __bool_constant<!_Bool(_Pp::value)>
        (template_ref __bool_constant)
        (unary_operator
          (call_expr
            (decl_ref_expr
              (type_ref _Pp))))))
    (class_template is_reference
      (template_type_parameter))
    (class_template is_function
      (template_type_parameter))
    (class_template is_void
      (template_type_parameter))
    (class_template remove_cv
      (template_type_parameter))
    (class_template is_const
      (template_type_parameter))
    (class_template __is_array_unknown_bounds
      (template_type_parameter))
    (function_template __is_complete_or_unbounded
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (type_ref std::size_t)
        (cxx_unary_expr
          (type_ref _Tp)))
      (type_ref std::true_type)
      (parm_decl
        (template_ref __type_identity)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (init_list_expr))))
    (function_template __is_complete_or_unbounded
      (template_type_parameter _TypeIdentity)
      (template_type_parameter _NestedType
        (type_ref _TypeIdentity))
      (template_ref __or_)
      (template_ref is_reference)
      (type_ref _NestedType)
      (template_ref is_function)
      (type_ref _NestedType)
      (template_ref is_void)
      (type_ref _NestedType)
      (template_ref __is_array_unknown_bounds)
      (type_ref _NestedType)
      (parm_decl
        (type_ref _TypeIdentity))
      (compound_stmt
        (return_stmt
          (init_list_expr))))
    (class_template __success_type
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (struct_decl __failure_type)
    (type_alias_template_decl __remove_cv_t
      (template_type_parameter _Tp)
      (type_alias_decl __remove_cv_t
        (template_ref remove_cv)
        (type_ref _Tp)))
    (class_template __is_void_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (struct_decl __is_void_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_void
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_void_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_void_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template __is_integral_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_integral_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_integral
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_integral_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_integral_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template __is_floating_point_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (struct_decl __is_floating_point_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_floating_point_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_floating_point_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (struct_decl __is_floating_point_helper
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_floating_point
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_floating_point_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_floating_point_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template is_array
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_array
      (template_type_parameter _Tp)
      (template_non_type_parameter _Size
        (namespace_ref std)
        (type_ref std::size_t))
      (type_ref _Tp)
      (decl_ref_expr _Size)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template_partial_specialization is_array
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template __is_pointer_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_pointer_helper
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_pointer_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_pointer_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template is_lvalue_reference
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_lvalue_reference
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_rvalue_reference
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_rvalue_reference
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template __is_member_object_pointer_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_member_object_pointer_helper
      (template_type_parameter _Tp)
      (template_type_parameter _Cp)
      (type_ref _Tp)
      (cxx_base_specifier __not_<is_function<_Tp> >::type
        (template_ref __not_)
        (template_ref is_function)
        (type_ref _Tp)))
    (class_template is_member_object_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_member_object_pointer_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_member_object_pointer_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template __is_member_function_pointer_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_member_function_pointer_helper
      (template_type_parameter _Tp)
      (template_type_parameter _Cp)
      (type_ref _Tp)
      (cxx_base_specifier is_function<_Tp>::type
        (template_ref is_function)
        (type_ref _Tp)))
    (class_template is_member_function_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_member_function_pointer_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_member_function_pointer_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template is_enum
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_enum(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_union
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_union(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_class
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_class(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_function
      (template_type_parameter _Tp)
      (cxx_base_specifier __bool_constant<!is_const<const _Tp>::value>
        (template_ref __bool_constant)
        (unary_operator
          (decl_ref_expr
            (template_ref is_const)
            (type_ref _Tp)))))
    (class_template_partial_specialization is_function
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_function
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template __is_null_pointer_helper
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (struct_decl __is_null_pointer_helper
      (namespace_ref std)
      (type_ref std::nullptr_t)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_null_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_null_pointer_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_null_pointer_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template __is_nullptr_t
      (template_type_parameter _Tp)
      (cxx_base_specifier is_null_pointer<_Tp>
        (template_ref is_null_pointer)
        (type_ref _Tp)))
    (class_template is_reference
      (template_type_parameter _Tp)
      (cxx_base_specifier __or_<is_lvalue_reference<_Tp>, is_rvalue_reference<_Tp> >::type
        (template_ref __or_)
        (template_ref is_lvalue_reference)
        (type_ref _Tp)
        (template_ref is_rvalue_reference)
        (type_ref _Tp)))
    (class_template is_arithmetic
      (template_type_parameter _Tp)
      (cxx_base_specifier __or_<is_integral<_Tp>, is_floating_point<_Tp> >::type
        (template_ref __or_)
        (template_ref is_integral)
        (type_ref _Tp)
        (template_ref is_floating_point)
        (type_ref _Tp)))
    (class_template is_fundamental
      (template_type_parameter _Tp)
      (cxx_base_specifier __or_<is_arithmetic<_Tp>, is_void<_Tp>, is_null_pointer<_Tp> >::type
        (template_ref __or_)
        (template_ref is_arithmetic)
        (type_ref _Tp)
        (template_ref is_void)
        (type_ref _Tp)
        (template_ref is_null_pointer)
        (type_ref _Tp)))
    (class_template is_object
      (template_type_parameter _Tp)
      (cxx_base_specifier __not_<__or_<is_function<_Tp>, is_reference<_Tp>, is_void<_Tp> > >::type
        (template_ref __not_)
        (template_ref __or_)
        (template_ref is_function)
        (type_ref _Tp)
        (template_ref is_reference)
        (type_ref _Tp)
        (template_ref is_void)
        (type_ref _Tp)))
    (class_template is_member_pointer
      (template_type_parameter))
    (class_template is_scalar
      (template_type_parameter _Tp)
      (cxx_base_specifier __or_<is_arithmetic<_Tp>, is_enum<_Tp>, is_pointer<_Tp>, is_member_pointer<_Tp>, is_null_pointer<_Tp> >::type
        (template_ref __or_)
        (template_ref is_arithmetic)
        (type_ref _Tp)
        (template_ref is_enum)
        (type_ref _Tp)
        (template_ref is_pointer)
        (type_ref _Tp)
        (template_ref is_member_pointer)
        (type_ref _Tp)
        (template_ref is_null_pointer)
        (type_ref _Tp)))
    (class_template is_compound
      (template_type_parameter _Tp)
      (cxx_base_specifier __not_<is_fundamental<_Tp> >::type
        (template_ref __not_)
        (template_ref is_fundamental)
        (type_ref _Tp)))
    (class_template __is_member_pointer_helper
      (template_type_parameter _Tp)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_member_pointer_helper
      (template_type_parameter _Tp)
      (template_type_parameter _Cp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_member_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_member_pointer_helper<__remove_cv_t<_Tp> >::type
        (template_ref __is_member_pointer_helper)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template is_same
      (template_type_parameter)
      (template_type_parameter))
    (type_alias_template_decl __is_one_of
      (template_type_parameter _Tp)
      (template_type_parameter _Types)
      (type_alias_decl __is_one_of
        (template_ref __or_)
        (template_ref is_same)
        (type_ref _Tp)
        (type_ref _Types)))
    (type_alias_template_decl __is_signed_integer
      (template_type_parameter _Tp)
      (type_alias_decl __is_signed_integer
        (template_ref __is_one_of)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (type_alias_template_decl __is_unsigned_integer
      (template_type_parameter _Tp)
      (type_alias_decl __is_unsigned_integer
        (template_ref __is_one_of)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (type_alias_template_decl __is_standard_integer
      (template_type_parameter _Tp)
      (type_alias_decl __is_standard_integer
        (template_ref __or_)
        (template_ref __is_signed_integer)
        (type_ref _Tp)
        (template_ref __is_unsigned_integer)
        (type_ref _Tp)))
    (type_alias_template_decl __void_t
      (template_type_parameter)
      (type_alias_decl __void_t))
    (class_template __is_referenceable
      (template_type_parameter _Tp)
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_referenceable
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (template_ref __void_t)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_const
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_const
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_volatile
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization is_volatile
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_trivial
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_trivial(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_trivially_copyable
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_trivially_copyable(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_standard_layout
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_standard_layout(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_pod
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_pod(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_literal_type
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_literal(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_empty
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_empty(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_polymorphic
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_polymorphic(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_final
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_final(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template is_abstract
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __is_abstract(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp)))
    (class_template __is_signed_helper
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref is_arithmetic)
          (type_ref _Tp)))
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_signed_helper
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier integral_constant<_Bool, _Tp(-1) < _Tp(0)>
        (template_ref integral_constant)
        (binary_operator
          (call_expr
            (type_ref _Tp)
            (unary_operator
              (integer_literal 1)))
          (call_expr
            (type_ref _Tp)
            (integer_literal 0)))))
    (class_template is_signed
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_signed_helper<_Tp>::type
        (template_ref __is_signed_helper)
        (type_ref _Tp)))
    (class_template is_unsigned
      (template_type_parameter _Tp)
      (cxx_base_specifier __and_<is_arithmetic<_Tp>, __not_<is_signed<_Tp> > >
        (template_ref __and_)
        (template_ref is_arithmetic)
        (type_ref _Tp)
        (template_ref __not_)
        (template_ref is_signed)
        (type_ref _Tp)))
    (function_template __declval
      (template_type_parameter _Tp)
      (template_type_parameter _Up
        (type_ref _Tp))
      (type_ref _Up)
      (parm_decl))
    (function_template __declval
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl))
    (function_template declval
      (template_type_parameter _Tp)
      (call_expr
        (decl_ref_expr
          (overloaded_decl_ref __declval)
          (type_ref _Tp))
        (integer_literal 0)))
    (class_template extent
      (template_type_parameter)
      (template_non_type_parameter
        (integer_literal 0)))
    (class_template remove_all_extents
      (template_type_parameter))
    (class_template __is_array_known_bounds
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, (extent<_Tp>::value > 0)>
        (template_ref integral_constant)
        (paren_expr
          (binary_operator
            (decl_ref_expr
              (template_ref extent)
              (type_ref _Tp))
            (integer_literal 0)))))
    (class_template __is_array_unknown_bounds
      (template_type_parameter _Tp)
      (cxx_base_specifier __and_<is_array<_Tp>, __not_<extent<_Tp> > >
        (template_ref __and_)
        (template_ref is_array)
        (type_ref _Tp)
        (template_ref __not_)
        (template_ref extent)
        (type_ref _Tp)))
    (struct_decl __do_is_destructible_impl
      (function_template __test
        (template_type_parameter _Tp)
        (template_type_parameter
          (call_expr
            (member_ref_expr
              (call_expr
                (decl_ref_expr
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))
              (type_ref _Tp))))
        (type_ref std::true_type)
        (parm_decl))
      (function_template __test
        (template_type_parameter)
        (type_ref std::false_type)))
    (class_template __is_destructible_impl
      (template_type_parameter _Tp)
      (cxx_base_specifier struct std::__do_is_destructible_impl
        (type_ref struct std::__do_is_destructible_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template __is_destructible_safe
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_void)
          (type_ref _Tp)
          (template_ref __is_array_unknown_bounds)
          (type_ref _Tp)
          (template_ref is_function)
          (type_ref _Tp)))
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_reference)
          (type_ref _Tp)
          (template_ref is_scalar)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_destructible_impl<typename remove_all_extents<_Tp>::type>::type
        (template_ref __is_destructible_impl)
        (template_ref remove_all_extents)
        (type_ref _Tp)))
    (class_template_partial_specialization __is_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_destructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_destructible_safe<_Tp>::type
        (template_ref __is_destructible_safe)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (struct_decl __do_is_nt_destructible_impl
      (function_template __test
        (template_type_parameter _Tp)
        (template_ref __bool_constant)
        (cxx_unary_expr
          (call_expr
            (member_ref_expr
              (call_expr
                (decl_ref_expr
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))
              (type_ref _Tp))))
        (parm_decl))
      (function_template __test
        (template_type_parameter)
        (type_ref std::false_type)))
    (class_template __is_nt_destructible_impl
      (template_type_parameter _Tp)
      (cxx_base_specifier struct std::__do_is_nt_destructible_impl
        (type_ref struct std::__do_is_nt_destructible_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template __is_nt_destructible_safe
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_void)
          (type_ref _Tp)
          (template_ref __is_array_unknown_bounds)
          (type_ref _Tp)
          (template_ref is_function)
          (type_ref _Tp)))
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_reference)
          (type_ref _Tp)
          (template_ref is_scalar)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_nt_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_nt_destructible_impl<typename remove_all_extents<_Tp>::type>::type
        (template_ref __is_nt_destructible_impl)
        (template_ref remove_all_extents)
        (type_ref _Tp)))
    (class_template_partial_specialization __is_nt_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_nt_destructible_safe
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template is_nothrow_destructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nt_destructible_safe<_Tp>::type
        (template_ref __is_nt_destructible_safe)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_constructible_impl
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (cxx_base_specifier __bool_constant<__is_constructible(_Tp, _Args...)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Args)))
    (class_template is_constructible
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (cxx_base_specifier __is_constructible_impl<_Tp, _Args...>
        (template_ref __is_constructible_impl)
        (type_ref _Tp)
        (type_ref _Args))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_default_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_constructible_impl<_Tp>::type
        (template_ref __is_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_copy_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_constructible_impl<_Tp, const _Tp &>
        (template_ref __is_constructible_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_copy_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_copy_constructible_impl<_Tp>
        (template_ref __is_copy_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_move_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_constructible_impl<_Tp, _Tp &&>
        (template_ref __is_constructible_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_move_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_move_constructible_impl<_Tp>
        (template_ref __is_move_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (type_alias_template_decl __is_nothrow_constructible_impl
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (type_alias_decl __is_nothrow_constructible_impl
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Args)))
    (class_template is_nothrow_constructible
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (cxx_base_specifier __is_nothrow_constructible_impl<_Tp, _Args...>::type
        (template_ref __is_nothrow_constructible_impl)
        (type_ref _Tp)
        (type_ref _Args))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_nothrow_default_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __bool_constant<__is_nothrow_constructible(_Tp)>
        (template_ref __bool_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_nothrow_copy_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_nothrow_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_nothrow_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_nothrow_constructible_impl<_Tp, const _Tp &>
        (template_ref __is_nothrow_constructible_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_nothrow_copy_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nothrow_copy_constructible_impl<_Tp>::type
        (template_ref __is_nothrow_copy_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_nothrow_move_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_nothrow_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_nothrow_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_nothrow_constructible_impl<_Tp, _Tp &&>
        (template_ref __is_nothrow_constructible_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_nothrow_move_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nothrow_move_constructible_impl<_Tp>::type
        (template_ref __is_nothrow_move_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_assignable
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __bool_constant<__is_assignable(_Tp, _Up)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Up))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_copy_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __bool_constant<__is_assignable(_Tp &, const _Tp &)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_copy_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_copy_assignable_impl<_Tp>::type
        (template_ref __is_copy_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_move_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __bool_constant<__is_assignable(_Tp &, _Tp &&)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_move_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_move_assignable_impl<_Tp>::type
        (template_ref __is_move_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (type_alias_template_decl __is_nothrow_assignable_impl
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_alias_decl __is_nothrow_assignable_impl
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Up)))
    (class_template is_nothrow_assignable
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __is_nothrow_assignable_impl<_Tp, _Up>
        (template_ref __is_nothrow_assignable_impl)
        (type_ref _Tp)
        (type_ref _Up))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_nt_copy_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_nt_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_nt_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_nothrow_assignable_impl<_Tp &, const _Tp &>
        (template_ref __is_nothrow_assignable_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_nothrow_copy_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nt_copy_assignable_impl<_Tp>
        (template_ref __is_nt_copy_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_nt_move_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_nt_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_nt_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __is_nothrow_assignable_impl<_Tp &, _Tp &&>
        (template_ref __is_nothrow_assignable_impl)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_nothrow_move_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nt_move_assignable_impl<_Tp>
        (template_ref __is_nt_move_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_trivially_constructible
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (cxx_base_specifier __bool_constant<__is_trivially_constructible(_Tp, _Args...)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Args))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_trivially_default_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __bool_constant<__is_trivially_constructible(_Tp)>
        (template_ref __bool_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (struct_decl __do_is_implicitly_default_constructible_impl
      (function_template __helper
        (template_type_parameter _Tp)
        (parm_decl
          (type_ref _Tp)))
      (function_template __test
        (template_type_parameter _Tp)
        (type_ref std::true_type)
        (parm_decl
          (type_ref _Tp))
        (parm_decl
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref __helper)
              (type_ref _Tp))
            (init_list_expr))
          (integer_literal 0)))
      (cxx_method __test
        (type_ref std::false_type)))
    (class_template __is_implicitly_default_constructible_impl
      (template_type_parameter _Tp)
      (cxx_base_specifier struct std::__do_is_implicitly_default_constructible_impl
        (type_ref struct std::__do_is_implicitly_default_constructible_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test))
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref declval)
              (type_ref _Tp))))))
    (class_template __is_implicitly_default_constructible_safe
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_implicitly_default_constructible_impl<_Tp>::type
        (template_ref __is_implicitly_default_constructible_impl)
        (type_ref _Tp)))
    (class_template __is_implicitly_default_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __and_<__is_constructible_impl<_Tp>, __is_implicitly_default_constructible_safe<_Tp> >
        (template_ref __and_)
        (template_ref __is_constructible_impl)
        (type_ref _Tp)
        (template_ref __is_implicitly_default_constructible_safe)
        (type_ref _Tp)))
    (class_template __is_trivially_copy_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_trivially_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_trivially_copy_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __and_<__is_copy_constructible_impl<_Tp>, integral_constant<_Bool, __is_trivially_constructible(_Tp, const _Tp &)> >
        (template_ref __and_)
        (template_ref __is_copy_constructible_impl)
        (type_ref _Tp)
        (template_ref integral_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_trivially_copy_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_trivially_copy_constructible_impl<_Tp>
        (template_ref __is_trivially_copy_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_trivially_move_constructible_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_trivially_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_trivially_move_constructible_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __and_<__is_move_constructible_impl<_Tp>, integral_constant<_Bool, __is_trivially_constructible(_Tp, _Tp &&)> >
        (template_ref __and_)
        (template_ref __is_move_constructible_impl)
        (type_ref _Tp)
        (template_ref integral_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_trivially_move_constructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_trivially_move_constructible_impl<_Tp>
        (template_ref __is_trivially_move_constructible_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_trivially_assignable
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __bool_constant<__is_trivially_assignable(_Tp, _Up)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Up))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_trivially_copy_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_trivially_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_trivially_copy_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __bool_constant<__is_trivially_assignable(_Tp &, const _Tp &)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_trivially_copy_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_trivially_copy_assignable_impl<_Tp>
        (template_ref __is_trivially_copy_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template __is_trivially_move_assignable_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp))))
    (class_template_partial_specialization __is_trivially_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_trivially_move_assignable_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_base_specifier __bool_constant<__is_trivially_assignable(_Tp &, _Tp &&)>
        (template_ref __bool_constant)
        (type_ref _Tp)
        (type_ref _Tp)))
    (class_template is_trivially_move_assignable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_trivially_move_assignable_impl<_Tp>
        (template_ref __is_trivially_move_assignable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_trivially_destructible
      (template_type_parameter _Tp)
      (cxx_base_specifier __and_<__is_destructible_safe<_Tp>, __bool_constant<__has_trivial_destructor(_Tp)> >
        (template_ref __and_)
        (template_ref __is_destructible_safe)
        (type_ref _Tp)
        (template_ref __bool_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template has_virtual_destructor
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<_Bool, __has_virtual_destructor(_Tp)>
        (template_ref integral_constant)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template alignment_of
      (template_type_parameter _Tp)
      (cxx_base_specifier integral_constant<std::size_t, __alignof(_Tp)>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (cxx_unary_expr
          (type_ref _Tp)))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template rank
      (template_type_parameter)
      (cxx_base_specifier integral_constant<std::size_t, 0>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (integer_literal 0)))
    (class_template_partial_specialization rank
      (template_type_parameter _Tp)
      (template_non_type_parameter _Size
        (namespace_ref std)
        (type_ref std::size_t))
      (type_ref _Tp)
      (decl_ref_expr _Size)
      (cxx_base_specifier integral_constant<std::size_t, 1 + rank<_Tp>::value>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (binary_operator
          (integer_literal 1)
          (decl_ref_expr
            (template_ref rank)
            (type_ref _Tp)))))
    (class_template_partial_specialization rank
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_base_specifier integral_constant<std::size_t, 1 + rank<_Tp>::value>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (binary_operator
          (integer_literal 1)
          (decl_ref_expr
            (template_ref rank)
            (type_ref _Tp)))))
    (class_template extent
      (template_type_parameter)
      (template_non_type_parameter _Uint)
      (cxx_base_specifier integral_constant<std::size_t, 0>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (integer_literal 0)))
    (class_template_partial_specialization extent
      (template_type_parameter _Tp)
      (template_non_type_parameter _Uint)
      (template_non_type_parameter _Size
        (namespace_ref std)
        (type_ref std::size_t))
      (type_ref _Tp)
      (decl_ref_expr _Size)
      (decl_ref_expr _Uint)
      (cxx_base_specifier integral_constant<std::size_t, _Uint == 0 ? _Size : extent<_Tp, _Uint - 1>::value>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (conditional_operator
          (binary_operator
            (decl_ref_expr _Uint)
            (integer_literal 0))
          (decl_ref_expr _Size)
          (decl_ref_expr
            (template_ref extent)
            (type_ref _Tp)
            (binary_operator
              (decl_ref_expr _Uint)
              (integer_literal 1))))))
    (class_template_partial_specialization extent
      (template_type_parameter _Tp)
      (template_non_type_parameter _Uint)
      (type_ref _Tp)
      (decl_ref_expr _Uint)
      (cxx_base_specifier integral_constant<std::size_t, _Uint == 0 ? 0 : extent<_Tp, _Uint - 1>::value>
        (template_ref integral_constant)
        (namespace_ref std)
        (type_ref std::size_t)
        (conditional_operator
          (binary_operator
            (decl_ref_expr _Uint)
            (integer_literal 0))
          (integer_literal 0)
          (decl_ref_expr
            (template_ref extent)
            (type_ref _Tp)
            (binary_operator
              (decl_ref_expr _Uint)
              (integer_literal 1))))))
    (class_template is_same
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier integral_constant<_Bool, __is_same(_Tp, _Up)>
        (template_ref integral_constant)
        (type_ref _Tp)
        (type_ref _Up)))
    (class_template is_base_of
      (template_type_parameter _Base)
      (template_type_parameter _Derived)
      (cxx_base_specifier integral_constant<_Bool, __is_base_of(_Base, _Derived)>
        (template_ref integral_constant)
        (type_ref _Base)
        (type_ref _Derived)))
    (class_template __is_convertible_helper
      (template_type_parameter _From)
      (template_type_parameter _To)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_void)
          (type_ref _From)
          (template_ref is_function)
          (type_ref _To)
          (template_ref is_array)
          (type_ref _To)))
      (typedef_decl type
        (template_ref is_void)
        (type_ref _To)))
    (class_template_partial_specialization __is_convertible_helper
      (template_type_parameter _From)
      (template_type_parameter _To)
      (type_ref _From)
      (type_ref _To)
      (cxx_bool_literal_expr)
      (function_template __test_aux
        (template_type_parameter _To1)
        (parm_decl
          (type_ref _To1)))
      (function_template __test
        (template_type_parameter _From1)
        (template_type_parameter _To1)
        (template_type_parameter
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref __test_aux)
              (type_ref _To1))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _From1)))))
        (type_ref std::true_type)
        (parm_decl))
      (function_template __test
        (template_type_parameter)
        (template_type_parameter)
        (type_ref std::false_type))
      (cxx_access_spec_decl)
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _From)
            (type_ref _To))
          (integer_literal 0))))
    (class_template is_convertible
      (template_type_parameter _From)
      (template_type_parameter _To)
      (cxx_base_specifier __is_convertible_helper<_From, _To>::type
        (template_ref __is_convertible_helper)
        (type_ref _From)
        (type_ref _To)))
    (type_alias_template_decl __is_array_convertible
      (template_type_parameter _ToElementType)
      (template_type_parameter _FromElementType)
      (type_alias_decl __is_array_convertible
        (template_ref is_convertible)
        (type_ref _FromElementType)
        (type_ref _ToElementType)))
    (class_template __is_nt_convertible_helper
      (template_type_parameter _From)
      (template_type_parameter _To)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_void)
          (type_ref _From)
          (template_ref is_function)
          (type_ref _To)
          (template_ref is_array)
          (type_ref _To)))
      (cxx_base_specifier is_void<_To>
        (template_ref is_void)
        (type_ref _To)))
    (class_template_partial_specialization __is_nt_convertible_helper
      (template_type_parameter _From)
      (template_type_parameter _To)
      (type_ref _From)
      (type_ref _To)
      (cxx_bool_literal_expr)
      (function_template __test_aux
        (template_type_parameter _To1)
        (parm_decl
          (type_ref _To1)))
      (function_template __test
        (template_type_parameter _From1)
        (template_type_parameter _To1)
        (template_ref __bool_constant)
        (cxx_unary_expr
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref __test_aux)
              (type_ref _To1))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _From1)))))
        (parm_decl))
      (function_template __test
        (template_type_parameter)
        (template_type_parameter)
        (type_ref std::false_type))
      (cxx_access_spec_decl)
      (type_alias_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _From)
            (type_ref _To))
          (integer_literal 0))))
    (class_template __is_nothrow_convertible
      (template_type_parameter _From)
      (template_type_parameter _To)
      (cxx_base_specifier __is_nt_convertible_helper<_From, _To>::type
        (template_ref __is_nt_convertible_helper)
        (type_ref _From)
        (type_ref _To)))
    (class_template remove_const
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_const
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template remove_volatile
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_volatile
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template remove_cv
      (template_type_parameter _Tp)
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_cv
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_cv
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_cv
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template add_const
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template add_volatile
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template add_cv
      (template_type_parameter _Tp)
      (typedef_decl type
        (template_ref add_const)
        (template_ref add_volatile)
        (type_ref _Tp)))
    (type_alias_template_decl remove_const_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_const_t
        (template_ref remove_const)
        (type_ref _Tp)))
    (type_alias_template_decl remove_volatile_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_volatile_t
        (template_ref remove_volatile)
        (type_ref _Tp)))
    (type_alias_template_decl remove_cv_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_cv_t
        (template_ref remove_cv)
        (type_ref _Tp)))
    (type_alias_template_decl add_const_t
      (template_type_parameter _Tp)
      (type_alias_decl add_const_t
        (template_ref add_const)
        (type_ref _Tp)))
    (type_alias_template_decl add_volatile_t
      (template_type_parameter _Tp)
      (type_alias_decl add_volatile_t
        (template_ref add_volatile)
        (type_ref _Tp)))
    (type_alias_template_decl add_cv_t
      (template_type_parameter _Tp)
      (type_alias_decl add_cv_t
        (template_ref add_cv)
        (type_ref _Tp)))
    (class_template remove_reference
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_reference
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_reference
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template __add_lvalue_reference_helper
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp)))
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __add_lvalue_reference_helper
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template add_lvalue_reference
      (template_type_parameter _Tp)
      (cxx_base_specifier __add_lvalue_reference_helper<_Tp>
        (template_ref __add_lvalue_reference_helper)
        (type_ref _Tp)))
    (class_template __add_rvalue_reference_helper
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __is_referenceable)
          (type_ref _Tp)))
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __add_rvalue_reference_helper
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template add_rvalue_reference
      (template_type_parameter _Tp)
      (cxx_base_specifier __add_rvalue_reference_helper<_Tp>
        (template_ref __add_rvalue_reference_helper)
        (type_ref _Tp)))
    (type_alias_template_decl remove_reference_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_reference_t
        (template_ref remove_reference)
        (type_ref _Tp)))
    (type_alias_template_decl add_lvalue_reference_t
      (template_type_parameter _Tp)
      (type_alias_decl add_lvalue_reference_t
        (template_ref add_lvalue_reference)
        (type_ref _Tp)))
    (type_alias_template_decl add_rvalue_reference_t
      (template_type_parameter _Tp)
      (type_alias_decl add_rvalue_reference_t
        (template_ref add_rvalue_reference)
        (type_ref _Tp)))
    (class_template __cv_selector
      (template_type_parameter _Unqualified)
      (template_non_type_parameter _IsConst)
      (template_non_type_parameter _IsVol))
    (class_template_partial_specialization __cv_selector
      (template_type_parameter _Unqualified)
      (type_ref _Unqualified)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (type_ref _Unqualified)))
    (class_template_partial_specialization __cv_selector
      (template_type_parameter _Unqualified)
      (type_ref _Unqualified)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (type_ref _Unqualified)))
    (class_template_partial_specialization __cv_selector
      (template_type_parameter _Unqualified)
      (type_ref _Unqualified)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (type_ref _Unqualified)))
    (class_template_partial_specialization __cv_selector
      (template_type_parameter _Unqualified)
      (type_ref _Unqualified)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (type_ref _Unqualified)))
    (class_template __match_cv_qualifiers
      (template_type_parameter _Qualified)
      (template_type_parameter _Unqualified)
      (template_non_type_parameter _IsConst
        (decl_ref_expr
          (template_ref is_const)
          (type_ref _Qualified)))
      (template_non_type_parameter _IsVol
        (decl_ref_expr
          (template_ref is_volatile)
          (type_ref _Qualified)))
      (typedef_decl __match
        (template_ref __cv_selector)
        (type_ref _Unqualified)
        (decl_ref_expr _IsConst)
        (decl_ref_expr _IsVol))
      (cxx_access_spec_decl)
      (typedef_decl __type
        (type_ref std::__match_cv_qualifiers::__match)))
    (class_template __make_unsigned
      (template_type_parameter _Tp)
      (typedef_decl __type
        (type_ref _Tp)))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (struct_decl __make_unsigned
      (typedef_decl __type))
    (class_template __make_unsigned_selector
      (template_type_parameter _Tp)
      (template_non_type_parameter _IsInt
        (decl_ref_expr
          (template_ref is_integral)
          (type_ref _Tp)))
      (template_non_type_parameter _IsEnum
        (decl_ref_expr
          (template_ref is_enum)
          (type_ref _Tp))))
    (class_template_partial_specialization __make_unsigned_selector
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (type_alias_decl __unsigned_type
        (template_ref __make_unsigned)
        (template_ref __remove_cv_t)
        (type_ref _Tp))
      (cxx_access_spec_decl)
      (type_alias_decl __type
        (template_ref __match_cv_qualifiers)
        (type_ref _Tp)
        (type_ref std::__make_unsigned_selector<type-parameter-0-0, true, false>::__unsigned_type)))
    (class_decl __make_unsigned_selector_base
      (cxx_access_spec_decl)
      (class_template _List
        (template_type_parameter))
      (class_template_partial_specialization _List
        (template_type_parameter _Tp)
        (template_type_parameter _Up)
        (type_ref _Tp)
        (type_ref _Up)
        (cxx_base_specifier _List<_Up...>
          (template_ref _List)
          (type_ref _Up))
        (var_decl __size
          (type_ref std::size_t)
          (cxx_unary_expr
            (type_ref _Tp))))
      (class_template __select
        (template_non_type_parameter _Sz
          (type_ref std::size_t))
        (template_type_parameter _Tp)
        (template_non_type_parameter
          (paren_expr
            (binary_operator
              (decl_ref_expr _Sz)
              (decl_ref_expr
                (type_ref _Tp))))))
      (class_template_partial_specialization __select
        (template_non_type_parameter _Sz
          (type_ref std::size_t))
        (template_type_parameter _Uint)
        (template_type_parameter _UInts)
        (decl_ref_expr _Sz)
        (template_ref _List)
        (type_ref _Uint)
        (type_ref _UInts)
        (cxx_bool_literal_expr)
        (type_alias_decl __type
          (type_ref _Uint)))
      (class_template_partial_specialization __select
        (template_non_type_parameter _Sz
          (type_ref std::size_t))
        (template_type_parameter _Uint)
        (template_type_parameter _UInts)
        (decl_ref_expr _Sz)
        (template_ref _List)
        (type_ref _Uint)
        (type_ref _UInts)
        (cxx_bool_literal_expr)
        (cxx_base_specifier __select<_Sz, _List<_UInts...> >
          (template_ref __select)
          (decl_ref_expr _Sz)
          (template_ref _List)
          (type_ref _UInts))))
    (class_template_partial_specialization __make_unsigned_selector
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (cxx_base_specifier class std::__make_unsigned_selector_base
        (type_ref class std::__make_unsigned_selector_base))
      (type_alias_decl _UInts
        (template_ref _List))
      (type_alias_decl __unsigned_type
        (template_ref __select)
        (cxx_unary_expr
          (type_ref _Tp))
        (type_ref std::__make_unsigned_selector<type-parameter-0-0, false, true>::_UInts))
      (cxx_access_spec_decl)
      (type_alias_decl __type
        (template_ref __match_cv_qualifiers)
        (type_ref _Tp)
        (type_ref std::__make_unsigned_selector<type-parameter-0-0, false, true>::__unsigned_type)))
    (struct_decl __make_unsigned
      (type_alias_decl __type
        (template_ref __make_unsigned_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_unsigned_selector<wchar_t, false, true>::__type)))
    (var_decl value
      (template_ref integral_constant)
      (decl_ref_expr
        (cxx_bool_literal_expr)))
    (struct_decl __make_unsigned
      (type_alias_decl __type
        (template_ref __make_unsigned_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_unsigned_selector<char16_t, false, true>::__type)))
    (struct_decl __make_unsigned
      (type_alias_decl __type
        (template_ref __make_unsigned_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_unsigned_selector<char32_t, false, true>::__type)))
    (class_template make_unsigned
      (template_type_parameter _Tp)
      (typedef_decl type
        (template_ref __make_unsigned_selector)
        (type_ref _Tp)))
    (struct_decl make_unsigned)
    (class_template __make_signed
      (template_type_parameter _Tp)
      (typedef_decl __type
        (type_ref _Tp)))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (struct_decl __make_signed
      (typedef_decl __type))
    (class_template __make_signed_selector
      (template_type_parameter _Tp)
      (template_non_type_parameter _IsInt
        (decl_ref_expr
          (template_ref is_integral)
          (type_ref _Tp)))
      (template_non_type_parameter _IsEnum
        (decl_ref_expr
          (template_ref is_enum)
          (type_ref _Tp))))
    (class_template_partial_specialization __make_signed_selector
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (type_alias_decl __signed_type
        (template_ref __make_signed)
        (template_ref __remove_cv_t)
        (type_ref _Tp))
      (cxx_access_spec_decl)
      (type_alias_decl __type
        (template_ref __match_cv_qualifiers)
        (type_ref _Tp)
        (type_ref std::__make_signed_selector<type-parameter-0-0, true, false>::__signed_type)))
    (class_template_partial_specialization __make_signed_selector
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __unsigned_type
        (template_ref __make_unsigned_selector)
        (type_ref _Tp))
      (cxx_access_spec_decl)
      (typedef_decl __type
        (template_ref __make_signed_selector)
        (type_ref std::__make_signed_selector<type-parameter-0-0, false, true>::__unsigned_type)))
    (struct_decl __make_signed
      (type_alias_decl __type
        (template_ref __make_signed_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_signed_selector<wchar_t, false, true>::__type)))
    (var_decl value
      (template_ref integral_constant)
      (decl_ref_expr
        (cxx_bool_literal_expr)))
    (struct_decl __make_signed
      (type_alias_decl __type
        (template_ref __make_signed_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_signed_selector<char16_t, false, true>::__type)))
    (struct_decl __make_signed
      (type_alias_decl __type
        (template_ref __make_signed_selector)
        (cxx_bool_literal_expr)
        (cxx_bool_literal_expr)
        (type_ref std::__make_signed_selector<char32_t, false, true>::__type)))
    (class_template make_signed
      (template_type_parameter _Tp)
      (typedef_decl type
        (template_ref __make_signed_selector)
        (type_ref _Tp)))
    (struct_decl make_signed)
    (type_alias_template_decl make_signed_t
      (template_type_parameter _Tp)
      (type_alias_decl make_signed_t
        (template_ref make_signed)
        (type_ref _Tp)))
    (type_alias_template_decl make_unsigned_t
      (template_type_parameter _Tp)
      (type_alias_decl make_unsigned_t
        (template_ref make_unsigned)
        (type_ref _Tp)))
    (class_template remove_extent
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_extent
      (template_type_parameter _Tp)
      (template_non_type_parameter _Size
        (namespace_ref std)
        (type_ref std::size_t))
      (type_ref _Tp)
      (decl_ref_expr _Size)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_extent
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template remove_all_extents
      (template_type_parameter _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization remove_all_extents
      (template_type_parameter _Tp)
      (template_non_type_parameter _Size
        (namespace_ref std)
        (type_ref std::size_t))
      (type_ref _Tp)
      (decl_ref_expr _Size)
      (typedef_decl type
        (template_ref remove_all_extents)
        (type_ref _Tp)))
    (class_template_partial_specialization remove_all_extents
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (typedef_decl type
        (template_ref remove_all_extents)
        (type_ref _Tp)))
    (type_alias_template_decl remove_extent_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_extent_t
        (template_ref remove_extent)
        (type_ref _Tp)))
    (type_alias_template_decl remove_all_extents_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_all_extents_t
        (template_ref remove_all_extents)
        (type_ref _Tp)))
    (class_template __remove_pointer_helper
      (template_type_parameter _Tp)
      (template_type_parameter)
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __remove_pointer_helper
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (type_ref _Up)
      (typedef_decl type
        (type_ref _Up)))
    (class_template remove_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __remove_pointer_helper<_Tp, __remove_cv_t<_Tp> >
        (template_ref __remove_pointer_helper)
        (type_ref _Tp)
        (template_ref __remove_cv_t)
        (type_ref _Tp)))
    (class_template __add_pointer_helper
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref __or_)
          (template_ref __is_referenceable)
          (type_ref _Tp)
          (template_ref is_void)
          (type_ref _Tp)))
      (typedef_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __add_pointer_helper
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr)
      (typedef_decl type
        (template_ref remove_reference)
        (type_ref _Tp)))
    (class_template add_pointer
      (template_type_parameter _Tp)
      (cxx_base_specifier __add_pointer_helper<_Tp>
        (template_ref __add_pointer_helper)
        (type_ref _Tp)))
    (type_alias_template_decl remove_pointer_t
      (template_type_parameter _Tp)
      (type_alias_decl remove_pointer_t
        (template_ref remove_pointer)
        (type_ref _Tp)))
    (type_alias_template_decl add_pointer_t
      (template_type_parameter _Tp)
      (type_alias_decl add_pointer_t
        (template_ref add_pointer)
        (type_ref _Tp)))
    (class_template __aligned_storage_msa
      (template_non_type_parameter _Len
        (namespace_ref std)
        (type_ref std::size_t))
      (union_decl __type
        (field_decl __data
          (decl_ref_expr _Len))
        (struct_decl
          (aligned_attr))
        (field_decl __align
          (struct_decl
            (aligned_attr)))))
    (class_template aligned_storage
      (template_non_type_parameter _Len
        (namespace_ref std)
        (type_ref std::size_t))
      (template_non_type_parameter _Align
        (namespace_ref std)
        (type_ref std::size_t)
        (cxx_unary_expr
          (template_ref __aligned_storage_msa)
          (decl_ref_expr _Len)))
      (union_decl type
        (field_decl __data
          (decl_ref_expr _Len))
        (struct_decl
          (aligned_attr))
        (field_decl __align
          (struct_decl
            (aligned_attr)))))
    (class_template __strictest_alignment
      (template_type_parameter _Types)
      (var_decl _S_alignment
        (type_ref std::size_t)
        (integer_literal 0))
      (var_decl _S_size
        (type_ref std::size_t)
        (integer_literal 0)))
    (class_template_partial_specialization __strictest_alignment
      (template_type_parameter _Tp)
      (template_type_parameter _Types)
      (type_ref _Tp)
      (type_ref _Types)
      (var_decl _S_alignment
        (type_ref std::size_t)
        (conditional_operator
          (binary_operator
            (cxx_unary_expr
              (type_ref _Tp))
            (decl_ref_expr
              (template_ref __strictest_alignment)
              (type_ref _Types)))
          (cxx_unary_expr
            (type_ref _Tp))
          (decl_ref_expr
            (template_ref __strictest_alignment)
            (type_ref _Types))))
      (var_decl _S_size
        (type_ref std::size_t)
        (conditional_operator
          (binary_operator
            (cxx_unary_expr
              (type_ref _Tp))
            (decl_ref_expr
              (template_ref __strictest_alignment)
              (type_ref _Types)))
          (cxx_unary_expr
            (type_ref _Tp))
          (decl_ref_expr
            (template_ref __strictest_alignment)
            (type_ref _Types)))))
    (class_template aligned_union
      (template_non_type_parameter _Len
        (type_ref std::size_t))
      (template_type_parameter _Types)
      (cxx_access_spec_decl)
      (static_assert
        (binary_operator
          (size_of_pack_expr
            (type_ref _Types))
          (integer_literal 0))
        (string_literal "At least one type is required"))
      (type_alias_decl __strictest
        (template_ref __strictest_alignment)
        (type_ref _Types))
      (var_decl _S_len
        (type_ref std::size_t)
        (conditional_operator
          (binary_operator
            (decl_ref_expr _Len)
            (decl_ref_expr
              (type_ref std::aligned_union::__strictest)))
          (decl_ref_expr _Len)
          (decl_ref_expr
            (type_ref std::aligned_union::__strictest))))
      (cxx_access_spec_decl)
      (var_decl alignment_value
        (type_ref std::size_t)
        (decl_ref_expr
          (type_ref std::aligned_union::__strictest)))
      (typedef_decl type
        (template_ref aligned_storage)
        (decl_ref_expr _S_len)
        (decl_ref_expr alignment_value)))
    (var_decl alignment_value
      (template_non_type_parameter _Len
        (type_ref std::size_t))
      (template_type_parameter _Types)
      (type_ref std::size_t)
      (template_ref aligned_union)
      (decl_ref_expr _Len)
      (type_ref _Types))
    (class_template __decay_selector
      (template_type_parameter _Up)
      (template_non_type_parameter _IsArray
        (decl_ref_expr
          (template_ref is_array)
          (type_ref _Up)))
      (template_non_type_parameter _IsFunction
        (decl_ref_expr
          (template_ref is_function)
          (type_ref _Up))))
    (class_template_partial_specialization __decay_selector
      (template_type_parameter _Up)
      (type_ref _Up)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (template_ref __remove_cv_t)
        (type_ref _Up)))
    (class_template_partial_specialization __decay_selector
      (template_type_parameter _Up)
      (type_ref _Up)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (template_ref remove_extent)
        (type_ref _Up)))
    (class_template_partial_specialization __decay_selector
      (template_type_parameter _Up)
      (type_ref _Up)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (typedef_decl __type
        (template_ref add_pointer)
        (type_ref _Up)))
    (class_template decay
      (template_type_parameter _Tp)
      (typedef_decl __remove_type
        (template_ref remove_reference)
        (type_ref _Tp))
      (cxx_access_spec_decl)
      (typedef_decl type
        (template_ref __decay_selector)
        (type_ref std::decay::__remove_type)))
    (class_template __strip_reference_wrapper
      (template_type_parameter _Tp)
      (typedef_decl __type
        (type_ref _Tp)))
    (class_template_partial_specialization __strip_reference_wrapper
      (template_type_parameter _Tp)
      (template_ref reference_wrapper)
      (type_ref _Tp)
      (typedef_decl __type
        (type_ref _Tp)))
    (type_alias_template_decl __decay_t
      (template_type_parameter _Tp)
      (type_alias_decl __decay_t
        (template_ref decay)
        (type_ref _Tp)))
    (type_alias_template_decl __decay_and_strip
      (template_type_parameter _Tp)
      (type_alias_decl __decay_and_strip
        (template_ref __strip_reference_wrapper)
        (template_ref __decay_t)
        (type_ref _Tp)))
    (class_template enable_if
      (template_non_type_parameter)
      (template_type_parameter _Tp))
    (class_template_partial_specialization enable_if
      (template_type_parameter _Tp)
      (cxx_bool_literal_expr)
      (type_ref _Tp)
      (typedef_decl type
        (type_ref _Tp)))
    (type_alias_template_decl __enable_if_t
      (template_non_type_parameter _Cond)
      (template_type_parameter _Tp)
      (type_alias_decl __enable_if_t
        (template_ref enable_if)
        (decl_ref_expr _Cond)
        (type_ref _Tp)))
    (type_alias_template_decl _Require
      (template_type_parameter _Cond)
      (type_alias_decl _Require
        (template_ref __enable_if_t)
        (decl_ref_expr
          (template_ref __and_)
          (type_ref _Cond))))
    (type_alias_template_decl __remove_cvref_t
      (template_type_parameter _Tp)
      (type_alias_decl __remove_cvref_t
        (template_ref remove_cv)
        (template_ref remove_reference)
        (type_ref _Tp)))
    (class_template conditional
      (template_non_type_parameter _Cond)
      (template_type_parameter _Iftrue)
      (template_type_parameter _Iffalse)
      (typedef_decl type
        (type_ref _Iftrue)))
    (class_template_partial_specialization conditional
      (template_type_parameter _Iftrue)
      (template_type_parameter _Iffalse)
      (cxx_bool_literal_expr)
      (type_ref _Iftrue)
      (type_ref _Iffalse)
      (typedef_decl type
        (type_ref _Iffalse)))
    (class_template common_type
      (template_type_parameter _Tp))
    (struct_decl __do_common_type_impl
      (type_alias_template_decl __cond_t
        (template_type_parameter _Tp)
        (template_type_parameter _Up)
        (type_alias_decl __cond_t
          (conditional_operator
            (cxx_bool_literal_expr)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _Tp)))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _Up))))))
      (function_template _S_test
        (template_type_parameter _Tp)
        (template_type_parameter _Up)
        (template_ref __success_type)
        (template_ref __decay_t)
        (template_ref __cond_t)
        (type_ref _Tp)
        (type_ref _Up)
        (parm_decl))
      (function_template _S_test_2
        (template_type_parameter)
        (template_type_parameter)
        (type_ref struct std::__failure_type))
      (function_template _S_test
        (template_type_parameter _Tp)
        (template_type_parameter _Up)
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test_2)
            (type_ref _Tp)
            (type_ref _Up))
          (integer_literal 0))))
    (struct_decl common_type)
    (class_template_partial_specialization common_type
      (template_type_parameter _Tp0)
      (type_ref _Tp0)
      (cxx_base_specifier common_type<_Tp0, _Tp0>
        (template_ref common_type)
        (type_ref _Tp0)
        (type_ref _Tp0)))
    (class_template __common_type_impl
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_type_parameter _Dp1
        (template_ref __decay_t)
        (type_ref _Tp1))
      (template_type_parameter _Dp2
        (template_ref __decay_t)
        (type_ref _Tp2))
      (type_alias_decl type
        (template_ref common_type)
        (type_ref _Dp1)
        (type_ref _Dp2)))
    (class_template_partial_specialization __common_type_impl
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (cxx_base_specifier struct std::__do_common_type_impl
        (type_ref struct std::__do_common_type_impl))
      (type_alias_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _Tp1)
            (type_ref _Tp2))
          (integer_literal 0))))
    (class_template_partial_specialization common_type
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (cxx_base_specifier __common_type_impl<_Tp1, _Tp2>::type
        (template_ref __common_type_impl)
        (type_ref _Tp1)
        (type_ref _Tp2)))
    (class_template __common_type_pack
      (template_type_parameter))
    (class_template __common_type_fold
      (template_type_parameter)
      (template_type_parameter)
      (template_type_parameter))
    (class_template_partial_specialization common_type
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_type_parameter _Rp)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (type_ref _Rp)
      (cxx_base_specifier __common_type_fold<common_type<_Tp1, _Tp2>, __common_type_pack<_Rp...> >
        (template_ref __common_type_fold)
        (template_ref common_type)
        (type_ref _Tp1)
        (type_ref _Tp2)
        (template_ref __common_type_pack)
        (type_ref _Rp)))
    (class_template_partial_specialization __common_type_fold
      (template_type_parameter _CTp)
      (template_type_parameter _Rp)
      (type_ref _CTp)
      (template_ref __common_type_pack)
      (type_ref _Rp)
      (template_ref __void_t)
      (type_ref _CTp)
      (cxx_base_specifier common_type<typename _CTp::type, _Rp...>
        (template_ref common_type)
        (type_ref _CTp)
        (type_ref _Rp)))
    (class_template_partial_specialization __common_type_fold
      (template_type_parameter _CTp)
      (template_type_parameter _Rp)
      (type_ref _CTp)
      (type_ref _Rp))
    (class_template __underlying_type_impl
      (template_type_parameter _Tp)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref is_enum)
          (type_ref _Tp)))
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __underlying_type_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (cxx_bool_literal_expr))
    (class_template underlying_type
      (template_type_parameter _Tp)
      (cxx_base_specifier __underlying_type_impl<_Tp>
        (template_ref __underlying_type_impl)
        (type_ref _Tp)))
    (class_template __declval_protector
      (template_type_parameter _Tp)
      (var_decl __stop
        (cxx_bool_literal_expr)))
    (function_template declval
      (template_type_parameter _Tp)
      (call_expr
        (decl_ref_expr
          (overloaded_decl_ref __declval)
          (type_ref _Tp))
        (integer_literal 0))
      (compound_stmt
        (decl_stmt
          (static_assert
            (decl_ref_expr
              (template_ref __declval_protector)
              (type_ref _Tp))
            (string_literal "declval() must not be used!")))
        (return_stmt
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref __declval)
              (type_ref _Tp))
            (integer_literal 0)))))
    (class_template result_of
      (template_type_parameter _Signature))
    (struct_decl __invoke_memfun_ref)
    (struct_decl __invoke_memfun_deref)
    (struct_decl __invoke_memobj_ref)
    (struct_decl __invoke_memobj_deref)
    (struct_decl __invoke_other)
    (class_template __result_of_success
      (template_type_parameter _Tp)
      (template_type_parameter _Tag)
      (cxx_base_specifier __success_type<_Tp>
        (template_ref __success_type)
        (type_ref _Tp))
      (type_alias_decl __invoke_type
        (type_ref _Tag)))
    (struct_decl __result_of_memfun_ref_impl
      (function_template _S_test
        (template_type_parameter _Fp)
        (template_type_parameter _Tp1)
        (template_type_parameter _Args)
        (template_ref __result_of_success)
        (call_expr
          (paren_expr
            (binary_operator
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp1)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Fp)))))
          (pack_expansion_expr
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _Args)))))
        (type_ref struct std::__invoke_memfun_ref)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter)
        (type_ref struct std::__failure_type)))
    (class_template __result_of_memfun_ref
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (template_type_parameter _Args)
      (cxx_base_specifier struct std::__result_of_memfun_ref_impl
        (type_ref struct std::__result_of_memfun_ref_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _MemPtr)
            (type_ref _Arg)
            (type_ref _Args))
          (integer_literal 0))))
    (struct_decl __result_of_memfun_deref_impl
      (function_template _S_test
        (template_type_parameter _Fp)
        (template_type_parameter _Tp1)
        (template_type_parameter _Args)
        (template_ref __result_of_success)
        (call_expr
          (paren_expr
            (binary_operator
              (paren_expr
                (unary_operator
                  (call_expr
                    (decl_ref_expr
                      (namespace_ref std)
                      (overloaded_decl_ref declval)
                      (type_ref _Tp1)))))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Fp)))))
          (pack_expansion_expr
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _Args)))))
        (type_ref struct std::__invoke_memfun_deref)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter)
        (type_ref struct std::__failure_type)))
    (class_template __result_of_memfun_deref
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (template_type_parameter _Args)
      (cxx_base_specifier struct std::__result_of_memfun_deref_impl
        (type_ref struct std::__result_of_memfun_deref_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _MemPtr)
            (type_ref _Arg)
            (type_ref _Args))
          (integer_literal 0))))
    (struct_decl __result_of_memobj_ref_impl
      (function_template _S_test
        (template_type_parameter _Fp)
        (template_type_parameter _Tp1)
        (template_ref __result_of_success)
        (binary_operator
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref declval)
              (type_ref _Tp1)))
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref declval)
              (type_ref _Fp))))
        (type_ref struct std::__invoke_memobj_ref)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter)
        (template_type_parameter)
        (type_ref struct std::__failure_type)))
    (class_template __result_of_memobj_ref
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (cxx_base_specifier struct std::__result_of_memobj_ref_impl
        (type_ref struct std::__result_of_memobj_ref_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _MemPtr)
            (type_ref _Arg))
          (integer_literal 0))))
    (struct_decl __result_of_memobj_deref_impl
      (function_template _S_test
        (template_type_parameter _Fp)
        (template_type_parameter _Tp1)
        (template_ref __result_of_success)
        (binary_operator
          (paren_expr
            (unary_operator
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp1)))))
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref declval)
              (type_ref _Fp))))
        (type_ref struct std::__invoke_memobj_deref)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter)
        (template_type_parameter)
        (type_ref struct std::__failure_type)))
    (class_template __result_of_memobj_deref
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (cxx_base_specifier struct std::__result_of_memobj_deref_impl
        (type_ref struct std::__result_of_memobj_deref_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _MemPtr)
            (type_ref _Arg))
          (integer_literal 0))))
    (class_template __result_of_memobj
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg))
    (class_template_partial_specialization __result_of_memobj
      (template_type_parameter _Res)
      (template_type_parameter _Class)
      (template_type_parameter _Arg)
      (type_ref _Res)
      (type_ref _Arg)
      (typedef_decl _Argval
        (template_ref __remove_cvref_t)
        (type_ref _Arg))
      (typedef_decl _MemPtr
        (type_ref _Res))
      (typedef_decl type
        (template_ref conditional)
        (decl_ref_expr
          (template_ref __or_)
          (template_ref is_same)
          (type_ref std::__result_of_memobj<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2>::_Argval)
          (type_ref _Class)
          (template_ref is_base_of)
          (type_ref _Class)
          (type_ref std::__result_of_memobj<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2>::_Argval))
        (template_ref __result_of_memobj_ref)
        (type_ref std::__result_of_memobj<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2>::_MemPtr)
        (type_ref _Arg)
        (template_ref __result_of_memobj_deref)
        (type_ref std::__result_of_memobj<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2>::_MemPtr)
        (type_ref _Arg)))
    (class_template __result_of_memfun
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (template_type_parameter _Args))
    (class_template_partial_specialization __result_of_memfun
      (template_type_parameter _Res)
      (template_type_parameter _Class)
      (template_type_parameter _Arg)
      (template_type_parameter _Args)
      (type_ref _Res)
      (type_ref _Arg)
      (type_ref _Args)
      (typedef_decl _Argval
        (template_ref remove_reference)
        (type_ref _Arg))
      (typedef_decl _MemPtr
        (type_ref _Res))
      (typedef_decl type
        (template_ref conditional)
        (decl_ref_expr
          (template_ref is_base_of)
          (type_ref _Class)
          (type_ref std::__result_of_memfun<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2, type-parameter-0-3...>::_Argval))
        (template_ref __result_of_memfun_ref)
        (type_ref std::__result_of_memfun<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2, type-parameter-0-3...>::_MemPtr)
        (type_ref _Arg)
        (type_ref _Args)
        (template_ref __result_of_memfun_deref)
        (type_ref std::__result_of_memfun<type-parameter-0-0 type-parameter-0-1::*, type-parameter-0-2, type-parameter-0-3...>::_MemPtr)
        (type_ref _Arg)
        (type_ref _Args)))
    (class_template __inv_unwrap
      (template_type_parameter _Tp)
      (template_type_parameter _Up
        (template_ref __remove_cvref_t)
        (type_ref _Tp))
      (type_alias_decl type
        (type_ref _Tp)))
    (class_template_partial_specialization __inv_unwrap
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (template_ref reference_wrapper)
      (type_ref _Up)
      (type_alias_decl type
        (type_ref _Up)))
    (class_template __result_of_impl
      (template_non_type_parameter)
      (template_non_type_parameter)
      (template_type_parameter _Functor)
      (template_type_parameter _ArgTypes)
      (typedef_decl type
        (type_ref struct std::__failure_type)))
    (class_template_partial_specialization __result_of_impl
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (type_ref _MemPtr)
      (type_ref _Arg)
      (cxx_base_specifier __result_of_memobj<__decay_t<_MemPtr>, typename __inv_unwrap<_Arg>::type>
        (template_ref __result_of_memobj)
        (template_ref __decay_t)
        (type_ref _MemPtr)
        (template_ref __inv_unwrap)
        (type_ref _Arg)))
    (class_template_partial_specialization __result_of_impl
      (template_type_parameter _MemPtr)
      (template_type_parameter _Arg)
      (template_type_parameter _Args)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (type_ref _MemPtr)
      (type_ref _Arg)
      (type_ref _Args)
      (cxx_base_specifier __result_of_memfun<__decay_t<_MemPtr>, typename __inv_unwrap<_Arg>::type, _Args...>
        (template_ref __result_of_memfun)
        (template_ref __decay_t)
        (type_ref _MemPtr)
        (template_ref __inv_unwrap)
        (type_ref _Arg)
        (type_ref _Args)))
    (struct_decl __result_of_other_impl
      (function_template _S_test
        (template_type_parameter _Fn)
        (template_type_parameter _Args)
        (template_ref __result_of_success)
        (call_expr
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref declval)
              (type_ref _Fn)))
          (pack_expansion_expr
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref declval)
                (type_ref _Args)))))
        (type_ref struct std::__invoke_other)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter)
        (type_ref struct std::__failure_type)))
    (class_template_partial_specialization __result_of_impl
      (template_type_parameter _Functor)
      (template_type_parameter _ArgTypes)
      (cxx_bool_literal_expr)
      (cxx_bool_literal_expr)
      (type_ref _Functor)
      (type_ref _ArgTypes)
      (cxx_base_specifier struct std::__result_of_other_impl
        (type_ref struct std::__result_of_other_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _Functor)
            (type_ref _ArgTypes))
          (integer_literal 0))))
    (class_template __invoke_result
      (template_type_parameter _Functor)
      (template_type_parameter _ArgTypes)
      (cxx_base_specifier __result_of_impl<is_member_object_pointer<typename remove_reference<_Functor>::type>::value, is_member_function_pointer<typename remove_reference<_Functor>::type>::value, _Functor, _ArgTypes...>::type
        (template_ref __result_of_impl)
        (decl_ref_expr
          (template_ref is_member_object_pointer)
          (template_ref remove_reference)
          (type_ref _Functor))
        (decl_ref_expr
          (template_ref is_member_function_pointer)
          (template_ref remove_reference)
          (type_ref _Functor))
        (type_ref _Functor)
        (type_ref _ArgTypes)))
    (class_template_partial_specialization result_of
      (template_type_parameter _Functor)
      (template_type_parameter _ArgTypes)
      (type_ref _Functor)
      (parm_decl
        (type_ref _ArgTypes))
      (cxx_base_specifier __invoke_result<_Functor, _ArgTypes...>
        (template_ref __invoke_result)
        (type_ref _Functor)
        (type_ref _ArgTypes)))
    (type_alias_template_decl aligned_storage_t
      (template_non_type_parameter _Len
        (type_ref std::size_t))
      (template_non_type_parameter _Align
        (type_ref std::size_t)
        (cxx_unary_expr
          (template_ref __aligned_storage_msa)
          (decl_ref_expr _Len)))
      (type_alias_decl aligned_storage_t
        (template_ref aligned_storage)
        (decl_ref_expr _Len)
        (decl_ref_expr _Align)))
    (type_alias_template_decl aligned_union_t
      (template_non_type_parameter _Len
        (type_ref std::size_t))
      (template_type_parameter _Types)
      (type_alias_decl aligned_union_t
        (template_ref aligned_union)
        (decl_ref_expr _Len)
        (type_ref _Types)))
    (type_alias_template_decl decay_t
      (template_type_parameter _Tp)
      (type_alias_decl decay_t
        (template_ref decay)
        (type_ref _Tp)))
    (type_alias_template_decl enable_if_t
      (template_non_type_parameter _Cond)
      (template_type_parameter _Tp)
      (type_alias_decl enable_if_t
        (template_ref enable_if)
        (decl_ref_expr _Cond)
        (type_ref _Tp)))
    (type_alias_template_decl conditional_t
      (template_non_type_parameter _Cond)
      (template_type_parameter _Iftrue)
      (template_type_parameter _Iffalse)
      (type_alias_decl conditional_t
        (template_ref conditional)
        (decl_ref_expr _Cond)
        (type_ref _Iftrue)
        (type_ref _Iffalse)))
    (type_alias_template_decl common_type_t
      (template_type_parameter _Tp)
      (type_alias_decl common_type_t
        (template_ref common_type)
        (type_ref _Tp)))
    (type_alias_template_decl underlying_type_t
      (template_type_parameter _Tp)
      (type_alias_decl underlying_type_t
        (template_ref underlying_type)
        (type_ref _Tp)))
    (type_alias_template_decl result_of_t
      (template_type_parameter _Tp)
      (type_alias_decl result_of_t
        (template_ref result_of)
        (type_ref _Tp)))
    (type_alias_template_decl void_t
      (template_type_parameter)
      (type_alias_decl void_t))
    (class_template __detector
      (template_type_parameter _Default)
      (template_type_parameter _AlwaysVoid)
      (template_template_parameter _Op
        (template_type_parameter))
      (template_type_parameter _Args)
      (type_alias_decl value_t
        (type_ref std::false_type))
      (type_alias_decl type
        (type_ref _Default)))
    (class_template_partial_specialization __detector
      (template_type_parameter _Default)
      (template_template_parameter _Op
        (template_type_parameter))
      (template_type_parameter _Args)
      (type_ref _Default)
      (template_ref __void_t)
      (template_ref _Op)
      (type_ref _Args)
      (template_ref _Op)
      (type_ref _Args)
      (type_alias_decl value_t
        (type_ref std::true_type))
      (type_alias_decl type
        (template_ref _Op)
        (type_ref _Args)))
    (type_alias_template_decl __detected_or
      (template_type_parameter _Default)
      (template_template_parameter _Op
        (template_type_parameter))
      (template_type_parameter _Args)
      (type_alias_decl __detected_or
        (template_ref __detector)
        (type_ref _Default)
        (template_ref _Op)
        (type_ref _Args)))
    (type_alias_template_decl __detected_or_t
      (template_type_parameter _Default)
      (template_template_parameter _Op
        (template_type_parameter))
      (template_type_parameter _Args)
      (type_alias_decl __detected_or_t
        (template_ref __detected_or)
        (type_ref _Default)
        (template_ref _Op)
        (type_ref _Args)))
    (class_template __is_swappable
      (template_type_parameter _Tp))
    (class_template __is_nothrow_swappable
      (template_type_parameter _Tp))
    (class_template __is_tuple_like_impl
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_tuple_like_impl
      (template_type_parameter _Tps)
      (template_ref tuple)
      (type_ref _Tps)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template __is_tuple_like
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_tuple_like_impl<__remove_cvref_t<_Tp> >::type
        (template_ref __is_tuple_like_impl)
        (template_ref __remove_cvref_t)
        (type_ref _Tp)))
    (function_template swap
      (template_type_parameter _Tp)
      (template_ref _Require)
      (template_ref __not_)
      (template_ref __is_tuple_like)
      (type_ref _Tp)
      (template_ref is_move_constructible)
      (type_ref _Tp)
      (template_ref is_move_assignable)
      (type_ref _Tp)
      (parm_decl
        (type_ref _Tp))
      (parm_decl
        (type_ref _Tp)))
    (function_template swap
      (template_type_parameter _Tp)
      (template_non_type_parameter _Nm
        (type_ref std::size_t))
      (template_ref __enable_if_t)
      (decl_ref_expr
        (template_ref __is_swappable)
        (type_ref _Tp))
      (parm_decl __a
        (type_ref _Tp)
        (decl_ref_expr _Nm))
      (parm_decl __b
        (type_ref _Tp)
        (decl_ref_expr _Nm)))
    ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/type_traits
    (namespace __swappable_details
      (using_declaration swap
        (namespace_ref std)
        (overloaded_decl_ref swap))
      (struct_decl __do_is_swappable_impl
        (function_template __test
          (template_type_parameter _Tp)
          (template_type_parameter
            (call_expr
              (decl_ref_expr
                (overloaded_decl_ref swap))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))))
          (type_ref std::true_type)
          (parm_decl))
        (function_template __test
          (template_type_parameter)
          (type_ref std::false_type)))
      (struct_decl __do_is_nothrow_swappable_impl
        (function_template __test
          (template_type_parameter _Tp)
          (template_ref __bool_constant)
          (cxx_unary_expr
            (call_expr
              (decl_ref_expr
                (overloaded_decl_ref swap))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))))
          (parm_decl))
        (function_template __test
          (template_type_parameter)
          (type_ref std::false_type))))
    (class_template __is_swappable_impl
      (template_type_parameter _Tp)
      (cxx_base_specifier __swappable_details::__do_is_swappable_impl
        (namespace_ref __swappable_details)
        (type_ref struct std::__swappable_details::__do_is_swappable_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template __is_nothrow_swappable_impl
      (template_type_parameter _Tp)
      (cxx_base_specifier __swappable_details::__do_is_nothrow_swappable_impl
        (namespace_ref __swappable_details)
        (type_ref struct std::__swappable_details::__do_is_nothrow_swappable_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template __is_swappable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_swappable_impl<_Tp>::type
        (template_ref __is_swappable_impl)
        (type_ref _Tp)))
    (class_template __is_nothrow_swappable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nothrow_swappable_impl<_Tp>::type
        (template_ref __is_nothrow_swappable_impl)
        (type_ref _Tp)))
    (class_template is_swappable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_swappable_impl<_Tp>::type
        (template_ref __is_swappable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    (class_template is_nothrow_swappable
      (template_type_parameter _Tp)
      (cxx_base_specifier __is_nothrow_swappable_impl<_Tp>::type
        (template_ref __is_nothrow_swappable_impl)
        (type_ref _Tp))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "template argument must be a complete class or an unbounded array")))
    ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/type_traits
    (namespace __swappable_with_details
      (using_declaration swap
        (namespace_ref std)
        (overloaded_decl_ref swap))
      (struct_decl __do_is_swappable_with_impl
        (function_template __test
          (template_type_parameter _Tp)
          (template_type_parameter _Up)
          (template_type_parameter
            (call_expr
              (decl_ref_expr
                (overloaded_decl_ref swap))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Up)))))
          (template_type_parameter
            (call_expr
              (decl_ref_expr
                (overloaded_decl_ref swap))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Up)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Tp)))))
          (type_ref std::true_type)
          (parm_decl))
        (function_template __test
          (template_type_parameter)
          (template_type_parameter)
          (type_ref std::false_type)))
      (struct_decl __do_is_nothrow_swappable_with_impl
        (function_template __test
          (template_type_parameter _Tp)
          (template_type_parameter _Up)
          (template_ref __bool_constant)
          (binary_operator
            (cxx_unary_expr
              (call_expr
                (decl_ref_expr
                  (overloaded_decl_ref swap))
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Tp)))
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Up)))))
            (cxx_unary_expr
              (call_expr
                (decl_ref_expr
                  (overloaded_decl_ref swap))
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Up)))
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Tp))))))
          (parm_decl))
        (function_template __test
          (template_type_parameter)
          (template_type_parameter)
          (type_ref std::false_type))))
    (class_template __is_swappable_with_impl
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __swappable_with_details::__do_is_swappable_with_impl
        (namespace_ref __swappable_with_details)
        (type_ref struct std::__swappable_with_details::__do_is_swappable_with_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp)
            (type_ref _Up))
          (integer_literal 0))))
    (class_template_partial_specialization __is_swappable_with_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (type_ref _Tp)
      (cxx_base_specifier __swappable_details::__do_is_swappable_impl
        (namespace_ref __swappable_details)
        (type_ref struct std::__swappable_details::__do_is_swappable_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template __is_nothrow_swappable_with_impl
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __swappable_with_details::__do_is_nothrow_swappable_with_impl
        (namespace_ref __swappable_with_details)
        (type_ref struct std::__swappable_with_details::__do_is_nothrow_swappable_with_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp)
            (type_ref _Up))
          (integer_literal 0))))
    (class_template_partial_specialization __is_nothrow_swappable_with_impl
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (type_ref _Tp)
      (cxx_base_specifier __swappable_details::__do_is_nothrow_swappable_impl
        (namespace_ref __swappable_details)
        (type_ref struct std::__swappable_details::__do_is_nothrow_swappable_impl))
      (typedef_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref __test)
            (type_ref _Tp))
          (integer_literal 0))))
    (class_template is_swappable_with
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __is_swappable_with_impl<_Tp, _Up>::type
        (template_ref __is_swappable_with_impl)
        (type_ref _Tp)
        (type_ref _Up))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "first template argument must be a complete class or an unbounded array"))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Up)
            (init_list_expr)))
        (string_literal "second template argument must be a complete class or an unbounded array")))
    (class_template is_nothrow_swappable_with
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (cxx_base_specifier __is_nothrow_swappable_with_impl<_Tp, _Up>::type
        (template_ref __is_nothrow_swappable_with_impl)
        (type_ref _Tp)
        (type_ref _Up))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Tp)
            (init_list_expr)))
        (string_literal "first template argument must be a complete class or an unbounded array"))
      (static_assert
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __is_complete_or_unbounded))
          (call_expr
            (template_ref __type_identity)
            (type_ref _Up)
            (init_list_expr)))
        (string_literal "second template argument must be a complete class or an unbounded array")))
    (class_template __is_invocable_impl
      (template_type_parameter _Result)
      (template_type_parameter _Ret)
      (template_non_type_parameter
        (decl_ref_expr
          (template_ref is_void)
          (type_ref _Ret)))
      (template_type_parameter)
      (cxx_base_specifier std::false_type
        (type_ref std::false_type)))
    (class_template_partial_specialization __is_invocable_impl
      (template_type_parameter _Result)
      (template_type_parameter _Ret)
      (type_ref _Result)
      (type_ref _Ret)
      (cxx_bool_literal_expr)
      (template_ref __void_t)
      (type_ref _Result)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template_partial_specialization __is_invocable_impl
      (template_type_parameter _Result)
      (template_type_parameter _Ret)
      (type_ref _Result)
      (type_ref _Ret)
      (cxx_bool_literal_expr)
      (template_ref __void_t)
      (type_ref _Result)
      (cxx_access_spec_decl)
      (cxx_method _S_get
        (type_ref _Result))
      (function_template _S_conv
        (template_type_parameter _Tp)
        (parm_decl
          (type_ref _Tp)))
      (function_template _S_test
        (template_type_parameter _Tp)
        (template_type_parameter
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref _S_conv)
              (type_ref _Tp))
            (call_expr _S_get
              (decl_ref_expr _S_get))))
        (type_ref std::true_type)
        (parm_decl))
      (function_template _S_test
        (template_type_parameter _Tp)
        (type_ref std::false_type))
      (cxx_access_spec_decl)
      (type_alias_decl type
        (call_expr
          (decl_ref_expr
            (overloaded_decl_ref _S_test)
            (type_ref _Ret))
          (integer_literal 1))))
    (class_template __is_invocable
      (template_type_parameter _Fn)
      (template_type_parameter _ArgTypes)
      (cxx_base_specifier __is_invocable_impl<__invoke_result<_Fn, _ArgTypes...>, void>::type
        (template_ref __is_invocable_impl)
        (template_ref __invoke_result)
        (type_ref _Fn)
        (type_ref _ArgTypes)))
    (function_template __call_is_nt
      (template_type_parameter _Fn)
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (parm_decl
        (type_ref struct std::__invoke_memfun_ref))
      (compound_stmt
        (decl_stmt
          (type_alias_decl _Up
            (template_ref __inv_unwrap)
            (type_ref _Tp)))
        (return_stmt
          (cxx_unary_expr
            (call_expr
              (paren_expr
                (binary_operator
                  (call_expr
                    (decl_ref_expr
                      (namespace_ref std)
                      (overloaded_decl_ref declval)
                      (type_ref _Up)))
                  (call_expr
                    (decl_ref_expr
                      (namespace_ref std)
                      (overloaded_decl_ref declval)
                      (type_ref _Fn)))))
              (pack_expansion_expr
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Args)))))))))
    (function_template __call_is_nt
      (template_type_parameter _Fn)
      (template_type_parameter _Tp)
      (template_type_parameter _Args)
      (parm_decl
        (type_ref struct std::__invoke_memfun_deref))
      (compound_stmt
        (return_stmt
          (cxx_unary_expr
            (call_expr
              (paren_expr
                (binary_operator
                  (paren_expr
                    (unary_operator
                      (call_expr
                        (decl_ref_expr
                          (namespace_ref std)
                          (overloaded_decl_ref declval)
                          (type_ref _Tp)))))
                  (call_expr
                    (decl_ref_expr
                      (namespace_ref std)
                      (overloaded_decl_ref declval)
                      (type_ref _Fn)))))
              (pack_expansion_expr
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Args)))))))))
    (function_template __call_is_nt
      (template_type_parameter _Fn)
      (template_type_parameter _Tp)
      (parm_decl
        (type_ref struct std::__invoke_memobj_ref))
      (compound_stmt
        (decl_stmt
          (type_alias_decl _Up
            (template_ref __inv_unwrap)
            (type_ref _Tp)))
        (return_stmt
          (cxx_unary_expr
            (binary_operator
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Up)))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Fn))))))))
    (function_template __call_is_nt
      (template_type_parameter _Fn)
      (template_type_parameter _Tp)
      (parm_decl
        (type_ref struct std::__invoke_memobj_deref))
      (compound_stmt
        (return_stmt
          (cxx_unary_expr
            (binary_operator
              (paren_expr
                (unary_operator
                  (call_expr
                    (decl_ref_expr
                      (namespace_ref std)
                      (overloaded_decl_ref declval)
                      (type_ref _Tp)))))
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Fn))))))))
    (function_template __call_is_nt
      (template_type_parameter _Fn)
      (template_type_parameter _Args)
      (parm_decl
        (type_ref struct std::__invoke_other))
      (compound_stmt
        (return_stmt
          (cxx_unary_expr
            (call_expr
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref declval)
                  (type_ref _Fn)))
              (pack_expansion_expr
                (call_expr
                  (decl_ref_expr
                    (namespace_ref std)
                    (overloaded_decl_ref declval)
                    (type_ref _Args)))))))))
    (class_template __call_is_nothrow
      (template_type_parameter _Result)
      (template_type_parameter _Fn)
      (template_type_parameter _Args)
      (cxx_base_specifier __bool_constant<std::__call_is_nt<_Fn, _Args...>(typename _Result::__invoke_type({}))>
        (template_ref __bool_constant)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref __call_is_nt)
            (type_ref _Fn)
            (type_ref _Args))
          (call_expr
            (type_ref _Result)
            (init_list_expr)))))
    (type_alias_template_decl __call_is_nothrow_
      (template_type_parameter _Fn)
      (template_type_parameter _Args)
      (type_alias_decl __call_is_nothrow_
        (template_ref __call_is_nothrow)
        (template_ref __invoke_result)
        (type_ref _Fn)
        (type_ref _Args)
        (type_ref _Fn)
        (type_ref _Args)))
    (class_template __is_nothrow_invocable
      (template_type_parameter _Fn)
      (template_type_parameter _Args)
      (cxx_base_specifier __and_<__is_invocable<_Fn, _Args...>, __call_is_nothrow_<_Fn, _Args...> >::type
        (template_ref __and_)
        (template_ref __is_invocable)
        (type_ref _Fn)
        (type_ref _Args)
        (template_ref __call_is_nothrow_)
        (type_ref _Fn)
        (type_ref _Args)))
    (struct_decl __nonesuchbase)
    (struct_decl __nonesuch
      (cxx_base_specifier struct std::__nonesuchbase
        (type_ref struct std::__nonesuchbase))
      (destructor ~__nonesuch)
      (constructor __nonesuch
        (parm_decl
          (type_ref struct std::__nonesuch)))
      (cxx_method operator=
        (parm_decl
          (type_ref struct std::__nonesuch)))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/bits/move.h
  (namespace std
    (visibility_attr default)
    (function_template forward
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __t
        (namespace_ref std)
        (template_ref remove_reference)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (cxx_static_cast_expr
            (type_ref _Tp)
            (decl_ref_expr __t)))))
    (function_template forward
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __t
        (namespace_ref std)
        (template_ref remove_reference)
        (type_ref _Tp))
      (compound_stmt
        (decl_stmt
          (static_assert
            (unary_operator
              (decl_ref_expr
                (namespace_ref std)
                (template_ref is_lvalue_reference)
                (type_ref _Tp)))
            (string_literal "std::forward must not be used to convert an rvalue to an lvalue")))
        (return_stmt
          (cxx_static_cast_expr
            (type_ref _Tp)
            (decl_ref_expr __t)))))
    (function_template move
      (template_type_parameter _Tp)
      (namespace_ref std)
      (template_ref remove_reference)
      (type_ref _Tp)
      (parm_decl __t
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (cxx_static_cast_expr
            (namespace_ref std)
            (template_ref remove_reference)
            (type_ref _Tp)
            (decl_ref_expr __t)))))
    (class_template __move_if_noexcept_cond
      (template_type_parameter _Tp)
      (cxx_base_specifier __and_<__not_<is_nothrow_move_constructible<_Tp> >, is_copy_constructible<_Tp> >::type
        (template_ref __and_)
        (template_ref __not_)
        (template_ref is_nothrow_move_constructible)
        (type_ref _Tp)
        (template_ref is_copy_constructible)
        (type_ref _Tp)))
    (function_template move_if_noexcept
      (template_type_parameter _Tp)
      (template_ref conditional)
      (decl_ref_expr
        (template_ref __move_if_noexcept_cond)
        (type_ref _Tp))
      (type_ref _Tp)
      (type_ref _Tp)
      (parm_decl __x
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (decl_ref_expr __x)))))
    (function_template addressof
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __r
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref __addressof))
            (decl_ref_expr __r)))))
    (function_template addressof
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl
        (type_ref _Tp)))
    (function_template __exchange
      (template_type_parameter _Tp)
      (template_type_parameter _Up
        (type_ref _Tp))
      (type_ref _Tp)
      (parm_decl __obj
        (type_ref _Tp))
      (parm_decl __new_val
        (type_ref _Up))
      (compound_stmt
        (decl_stmt
          (var_decl __old_val
            (type_ref _Tp)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref move))
              (decl_ref_expr __obj))))
        (binary_operator
          (decl_ref_expr __obj)
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref forward)
              (type_ref _Up))
            (decl_ref_expr __new_val)))
        (return_stmt
          (decl_ref_expr __old_val))))
    (function_template swap
      (template_type_parameter _Tp)
      (template_ref enable_if)
      (decl_ref_expr
        (template_ref __and_)
        (template_ref __not_)
        (template_ref __is_tuple_like)
        (type_ref _Tp)
        (template_ref is_move_constructible)
        (type_ref _Tp)
        (template_ref is_move_assignable)
        (type_ref _Tp))
      (parm_decl __a
        (type_ref _Tp))
      (parm_decl __b
        (type_ref _Tp))
      (compound_stmt
        (decl_stmt
          (var_decl __tmp
            (type_ref _Tp)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref move))
              (decl_ref_expr __a))))
        (binary_operator
          (decl_ref_expr __a)
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (decl_ref_expr __b)))
        (binary_operator
          (decl_ref_expr __b)
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (decl_ref_expr __tmp)))))
    (function_template swap
      (template_type_parameter _Tp)
      (template_non_type_parameter _Nm
        (type_ref std::size_t))
      (template_ref enable_if)
      (decl_ref_expr
        (template_ref __is_swappable)
        (type_ref _Tp))
      (parm_decl __a
        (type_ref _Tp)
        (decl_ref_expr _Nm))
      (parm_decl __b
        (type_ref _Tp)
        (decl_ref_expr _Nm))
      (compound_stmt
        (for_stmt
          (decl_stmt
            (var_decl __n
              (type_ref std::size_t)
              (integer_literal 0)))
          (binary_operator
            (decl_ref_expr __n)
            (decl_ref_expr _Nm))
          (unary_operator
            (decl_ref_expr __n))
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref swap))
            (array_subscript_expr
              (decl_ref_expr __a)
              (decl_ref_expr __n))
            (array_subscript_expr
              (decl_ref_expr __b)
              (decl_ref_expr __n)))))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/bits/stl_pair.h
  (namespace std
    (visibility_attr default)
    (struct_decl piecewise_construct_t
      (constructor piecewise_construct_t))
    (var_decl piecewise_construct
      (type_ref struct std::piecewise_construct_t)
      (call_expr
        (call_expr piecewise_construct_t
          (type_ref struct std::piecewise_construct_t))))
    (class_template tuple
      (template_type_parameter))
    (class_template _Index_tuple
      (template_non_type_parameter
        (type_ref std::size_t)))
    (class_template _PCC
      (template_non_type_parameter)
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (function_template _ConstructiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_constructible)
              (type_ref _T1)
              (type_ref _U1)
              (template_ref is_constructible)
              (type_ref _T2)
              (type_ref _U2)))))
      (function_template _ImplicitlyConvertiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_convertible)
              (type_ref _U1)
              (type_ref _T1)
              (template_ref is_convertible)
              (type_ref _U2)
              (type_ref _T2)))))
      (function_template _MoveConstructiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_constructible)
              (type_ref _T1)
              (type_ref _U1)
              (template_ref is_constructible)
              (type_ref _T2)
              (type_ref _U2)))))
      (function_template _ImplicitlyMoveConvertiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_convertible)
              (type_ref _U1)
              (type_ref _T1)
              (template_ref is_convertible)
              (type_ref _U2)
              (type_ref _T2)))))
      (function_template _CopyMovePair
        (template_non_type_parameter __implicit)
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (decl_stmt
            (type_alias_decl __do_converts
              (template_ref __and_)
              (template_ref is_convertible)
              (type_ref _U1)
              (type_ref _T1)
              (template_ref is_convertible)
              (type_ref _U2)
              (type_ref _T2)))
          (decl_stmt
            (type_alias_decl __converts
              (template_ref conditional)
              (decl_ref_expr __implicit)
              (type_ref __do_converts)
              (template_ref __not_)
              (type_ref __do_converts)))
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_constructible)
              (type_ref _T1)
              (type_ref _U1)
              (template_ref is_constructible)
              (type_ref _T2)
              (type_ref _U2)
              (type_ref __converts)))))
      (function_template _MoveCopyPair
        (template_non_type_parameter __implicit)
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (decl_stmt
            (type_alias_decl __do_converts
              (template_ref __and_)
              (template_ref is_convertible)
              (type_ref _U1)
              (type_ref _T1)
              (template_ref is_convertible)
              (type_ref _U2)
              (type_ref _T2)))
          (decl_stmt
            (type_alias_decl __converts
              (template_ref conditional)
              (decl_ref_expr __implicit)
              (type_ref __do_converts)
              (template_ref __not_)
              (type_ref __do_converts)))
          (return_stmt
            (decl_ref_expr
              (template_ref __and_)
              (template_ref is_constructible)
              (type_ref _T1)
              (type_ref _U1)
              (template_ref is_constructible)
              (type_ref _T2)
              (type_ref _U2)
              (type_ref __converts))))))
    (class_template_partial_specialization _PCC
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (cxx_bool_literal_expr)
      (type_ref _T1)
      (type_ref _T2)
      (function_template _ConstructiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (cxx_bool_literal_expr))))
      (function_template _ImplicitlyConvertiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (cxx_bool_literal_expr))))
      (function_template _MoveConstructiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (cxx_bool_literal_expr))))
      (function_template _ImplicitlyMoveConvertiblePair
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (compound_stmt
          (return_stmt
            (cxx_bool_literal_expr)))))
    (class_template __pair_base
      (template_type_parameter _U1)
      (template_type_parameter _U2)
      (friend_decl
        (class_template pair
          (template_type_parameter _T1)
          (template_type_parameter _T2)))
      (constructor __pair_base<_U1, _U2>)
      (destructor ~__pair_base<_U1, _U2>)
      (constructor __pair_base<_U1, _U2>
        (parm_decl
          (type_ref __pair_base<_U1, _U2>)))
      (cxx_method operator=
        (type_ref __pair_base<_U1, _U2>)
        (parm_decl
          (type_ref __pair_base<_U1, _U2>))))
    (class_template pair
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (cxx_base_specifier __pair_base<_T1, _T2>
        (template_ref __pair_base)
        (type_ref _T1)
        (type_ref _T2))
      (typedef_decl first_type
        (type_ref _T1))
      (typedef_decl second_type
        (type_ref _T2))
      (field_decl first
        (type_ref _T1))
      (field_decl second
        (type_ref _T2))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1
          (type_ref _T1))
        (template_type_parameter _U2
          (type_ref _T2))
        (template_non_type_parameter
          (template_ref enable_if)
          (decl_ref_expr
            (template_ref __and_)
            (template_ref __is_implicitly_default_constructible)
            (type_ref _U1)
            (template_ref __is_implicitly_default_constructible)
            (type_ref _U2))
          (cxx_bool_literal_expr))
        (member_ref first)
        (member_ref second)
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1
          (type_ref _T1))
        (template_type_parameter _U2
          (type_ref _T2))
        (template_non_type_parameter
          (template_ref enable_if)
          (decl_ref_expr
            (template_ref __and_)
            (template_ref is_default_constructible)
            (type_ref _U1)
            (template_ref is_default_constructible)
            (type_ref _U2)
            (template_ref __not_)
            (template_ref __and_)
            (template_ref __is_implicitly_default_constructible)
            (type_ref _U1)
            (template_ref __is_implicitly_default_constructible)
            (type_ref _U2))
          (cxx_bool_literal_expr))
        (member_ref first)
        (member_ref second)
        (compound_stmt))
      (type_alias_decl _PCCP
        (template_ref _PCC)
        (cxx_bool_literal_expr)
        (type_ref _T1)
        (type_ref _T2))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1
          (type_ref _T1))
        (template_type_parameter _U2
          (type_ref _T2))
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2)))
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2))))
          (cxx_bool_literal_expr))
        (parm_decl __a
          (type_ref _T1))
        (parm_decl __b
          (type_ref _T2))
        (member_ref first)
        (decl_ref_expr __a)
        (member_ref second)
        (decl_ref_expr __b)
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1
          (type_ref _T1))
        (template_type_parameter _U2
          (type_ref _T2))
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2)))
            (unary_operator
              (call_expr
                (decl_ref_expr
                  (type_ref std::pair::_PCCP)
                  (type_ref _U1)
                  (type_ref _U2)))))
          (cxx_bool_literal_expr))
        (parm_decl __a
          (type_ref _T1))
        (parm_decl __b
          (type_ref _T2))
        (member_ref first)
        (decl_ref_expr __a)
        (member_ref second)
        (decl_ref_expr __b)
        (compound_stmt))
      (type_alias_template_decl _PCCFP
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (type_alias_decl _PCCFP
          (template_ref _PCC)
          (binary_operator
            (unary_operator
              (decl_ref_expr
                (template_ref is_same)
                (type_ref _T1)
                (type_ref _U1)))
            (unary_operator
              (decl_ref_expr
                (template_ref is_same)
                (type_ref _T2)
                (type_ref _U2))))
          (type_ref _T1)
          (type_ref _T2)))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2)))
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2))))
          (cxx_bool_literal_expr))
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (member_ref first)
        (member_ref_expr
          (decl_ref_expr __p))
        (member_ref second)
        (member_ref_expr
          (decl_ref_expr __p))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2)))
            (unary_operator
              (call_expr
                (decl_ref_expr
                  (template_ref _PCCFP)
                  (type_ref _U1)
                  (type_ref _U2)
                  (type_ref _U1)
                  (type_ref _U2)))))
          (cxx_bool_literal_expr))
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (member_ref first)
        (member_ref_expr
          (decl_ref_expr __p))
        (member_ref second)
        (member_ref_expr
          (decl_ref_expr __p))
        (compound_stmt))
      (constructor pair<_T1, _T2>
        (parm_decl
          (type_ref pair<_T1, _T2>)))
      (constructor pair<_T1, _T2>
        (parm_decl
          (type_ref pair<_T1, _T2>)))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_non_type_parameter
          (template_ref enable_if)
          (call_expr
            (decl_ref_expr
              (type_ref std::pair::_PCCP)
              (cxx_bool_literal_expr)
              (type_ref _U1)
              (type_ref _T2)))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _U1))
        (parm_decl __y
          (type_ref _T2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (decl_ref_expr __x))
        (member_ref second)
        (decl_ref_expr __y)
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_non_type_parameter
          (template_ref enable_if)
          (call_expr
            (decl_ref_expr
              (type_ref std::pair::_PCCP)
              (cxx_bool_literal_expr)
              (type_ref _U1)
              (type_ref _T2)))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _U1))
        (parm_decl __y
          (type_ref _T2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (decl_ref_expr __x))
        (member_ref second)
        (decl_ref_expr __y)
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (call_expr
            (decl_ref_expr
              (type_ref std::pair::_PCCP)
              (cxx_bool_literal_expr)
              (type_ref _T1)
              (type_ref _U2)))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _T1))
        (parm_decl __y
          (type_ref _U2))
        (member_ref first)
        (decl_ref_expr __x)
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (decl_ref_expr __y))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (call_expr
            (decl_ref_expr
              (type_ref std::pair::_PCCP)
              (cxx_bool_literal_expr)
              (type_ref _T1)
              (type_ref _U2)))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _T1))
        (parm_decl __y
          (type_ref _U2))
        (member_ref first)
        (decl_ref_expr __x)
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (decl_ref_expr __y))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2)))
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2))))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _U1))
        (parm_decl __y
          (type_ref _U2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (decl_ref_expr __x))
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (decl_ref_expr __y))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (type_ref std::pair::_PCCP)
                (type_ref _U1)
                (type_ref _U2)))
            (unary_operator
              (call_expr
                (decl_ref_expr
                  (type_ref std::pair::_PCCP)
                  (type_ref _U1)
                  (type_ref _U2)))))
          (cxx_bool_literal_expr))
        (parm_decl __x
          (type_ref _U1))
        (parm_decl __y
          (type_ref _U2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (decl_ref_expr __x))
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (decl_ref_expr __y))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2)))
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2))))
          (cxx_bool_literal_expr))
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (member_ref_expr
            (decl_ref_expr __p)))
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (member_ref_expr
            (decl_ref_expr __p)))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_non_type_parameter
          (template_ref enable_if)
          (binary_operator
            (call_expr
              (decl_ref_expr
                (template_ref _PCCFP)
                (type_ref _U1)
                (type_ref _U2)
                (type_ref _U1)
                (type_ref _U2)))
            (unary_operator
              (call_expr
                (decl_ref_expr
                  (template_ref _PCCFP)
                  (type_ref _U1)
                  (type_ref _U2)
                  (type_ref _U1)
                  (type_ref _U2)))))
          (cxx_bool_literal_expr))
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (member_ref first)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U1))
          (member_ref_expr
            (decl_ref_expr __p)))
        (member_ref second)
        (call_expr
          (decl_ref_expr
            (namespace_ref std)
            (overloaded_decl_ref forward)
            (type_ref _U2))
          (member_ref_expr
            (decl_ref_expr __p)))
        (compound_stmt))
      (function_template pair<_T1, _T2>
        (template_type_parameter _Args1)
        (template_type_parameter _Args2)
        (parm_decl
          (type_ref struct std::piecewise_construct_t))
        (parm_decl
          (template_ref tuple)
          (type_ref _Args1))
        (parm_decl
          (template_ref tuple)
          (type_ref _Args2)))
      (cxx_method operator=
        (type_ref pair<_T1, _T2>)
        (parm_decl __p
          (template_ref conditional)
          (decl_ref_expr
            (template_ref __and_)
            (template_ref is_copy_assignable)
            (type_ref _T1)
            (template_ref is_copy_assignable)
            (type_ref _T2))
          (type_ref pair<_T1, _T2>)
          (type_ref struct std::__nonesuch))
        (compound_stmt
          (binary_operator
            (member_ref_expr first)
            (member_ref_expr
              (decl_ref_expr __p)))
          (binary_operator
            (member_ref_expr second)
            (member_ref_expr
              (decl_ref_expr __p)))
          (return_stmt
            (unary_operator
              (cxx_this_expr)))))
      (cxx_method operator=
        (type_ref pair<_T1, _T2>)
        (parm_decl __p
          (template_ref conditional)
          (decl_ref_expr
            (template_ref __and_)
            (template_ref is_move_assignable)
            (type_ref _T1)
            (template_ref is_move_assignable)
            (type_ref _T2))
          (type_ref pair<_T1, _T2>)
          (type_ref struct std::__nonesuch))
        (compound_stmt
          (binary_operator
            (member_ref_expr first)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref std::pair::first_type))
              (member_ref_expr
                (decl_ref_expr __p))))
          (binary_operator
            (member_ref_expr second)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref std::pair::second_type))
              (member_ref_expr
                (decl_ref_expr __p))))
          (return_stmt
            (unary_operator
              (cxx_this_expr)))))
      (function_template operator=
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_ref enable_if)
        (decl_ref_expr
          (template_ref __and_)
          (template_ref is_assignable)
          (type_ref _T1)
          (type_ref _U1)
          (template_ref is_assignable)
          (type_ref _T2)
          (type_ref _U2))
        (type_ref pair<_T1, _T2>)
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (compound_stmt
          (binary_operator
            (member_ref_expr first)
            (member_ref_expr
              (decl_ref_expr __p)))
          (binary_operator
            (member_ref_expr second)
            (member_ref_expr
              (decl_ref_expr __p)))
          (return_stmt
            (unary_operator
              (cxx_this_expr)))))
      (function_template operator=
        (template_type_parameter _U1)
        (template_type_parameter _U2)
        (template_ref enable_if)
        (decl_ref_expr
          (template_ref __and_)
          (template_ref is_assignable)
          (type_ref _T1)
          (type_ref _U1)
          (template_ref is_assignable)
          (type_ref _T2)
          (type_ref _U2))
        (type_ref pair<_T1, _T2>)
        (parm_decl __p
          (template_ref pair)
          (type_ref _U1)
          (type_ref _U2))
        (compound_stmt
          (binary_operator
            (member_ref_expr first)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _U1))
              (member_ref_expr
                (decl_ref_expr __p))))
          (binary_operator
            (member_ref_expr second)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _U2))
              (member_ref_expr
                (decl_ref_expr __p))))
          (return_stmt
            (unary_operator
              (cxx_this_expr)))))
      (cxx_method swap
        (parm_decl __p
          (type_ref pair<_T1, _T2>))
        (compound_stmt
          (decl_stmt
            (using_declaration swap
              (namespace_ref std)
              (overloaded_decl_ref swap)))
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref swap))
            (member_ref_expr first)
            (member_ref_expr
              (decl_ref_expr __p)))
          (call_expr
            (decl_ref_expr
              (overloaded_decl_ref swap))
            (member_ref_expr second)
            (member_ref_expr
              (decl_ref_expr __p)))))
      (cxx_access_spec_decl)
      (function_template pair<_T1, _T2>
        (template_type_parameter _Args1)
        (template_non_type_parameter _Indexes1
          (type_ref std::size_t))
        (template_type_parameter _Args2)
        (template_non_type_parameter _Indexes2
          (type_ref std::size_t))
        (parm_decl
          (template_ref tuple)
          (type_ref _Args1))
        (parm_decl
          (template_ref tuple)
          (type_ref _Args2))
        (parm_decl
          (template_ref _Index_tuple)
          (pack_expansion_expr
            (decl_ref_expr _Indexes1)))
        (parm_decl
          (template_ref _Index_tuple)
          (pack_expansion_expr
            (decl_ref_expr _Indexes2)))))
    (function_template operator==
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (binary_operator
            (call_expr
              (member_ref_expr
                (decl_ref_expr __x))
              (decl_ref_expr
                (overloaded_decl_ref operator==))
              (member_ref_expr
                (decl_ref_expr __y)))
            (call_expr
              (member_ref_expr
                (decl_ref_expr __x))
              (decl_ref_expr
                (overloaded_decl_ref operator==))
              (member_ref_expr
                (decl_ref_expr __y)))))))
    (function_template operator<
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (binary_operator
            (call_expr
              (member_ref_expr
                (decl_ref_expr __x))
              (decl_ref_expr
                (overloaded_decl_ref operator<))
              (member_ref_expr
                (decl_ref_expr __y)))
            (paren_expr
              (binary_operator
                (unary_operator
                  (paren_expr
                    (call_expr
                      (member_ref_expr
                        (decl_ref_expr __y))
                      (decl_ref_expr
                        (overloaded_decl_ref operator<))
                      (member_ref_expr
                        (decl_ref_expr __x)))))
                (call_expr
                  (member_ref_expr
                    (decl_ref_expr __x))
                  (decl_ref_expr
                    (overloaded_decl_ref operator<))
                  (member_ref_expr
                    (decl_ref_expr __y)))))))))
    (function_template operator!=
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (unary_operator
            (paren_expr
              (call_expr
                (decl_ref_expr __x)
                (decl_ref_expr
                  (overloaded_decl_ref operator==))
                (decl_ref_expr __y)))))))
    (function_template operator>
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr __y)
            (decl_ref_expr
              (overloaded_decl_ref operator<))
            (decl_ref_expr __x)))))
    (function_template operator<=
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (unary_operator
            (paren_expr
              (call_expr
                (decl_ref_expr __y)
                (decl_ref_expr
                  (overloaded_decl_ref operator<))
                (decl_ref_expr __x)))))))
    (function_template operator>=
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (return_stmt
          (unary_operator
            (paren_expr
              (call_expr
                (decl_ref_expr __x)
                (decl_ref_expr
                  (overloaded_decl_ref operator<))
                (decl_ref_expr __y)))))))
    (function_template swap
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (template_ref enable_if)
      (decl_ref_expr
        (template_ref __and_)
        (template_ref __is_swappable)
        (type_ref _T1)
        (template_ref __is_swappable)
        (type_ref _T2))
      (parm_decl __x
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl __y
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (compound_stmt
        (call_expr
          (member_ref_expr
            (decl_ref_expr __x))
          (decl_ref_expr __y))))
    (function_template swap
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (template_ref enable_if)
      (unary_operator
        (decl_ref_expr
          (template_ref __and_)
          (template_ref __is_swappable)
          (type_ref _T1)
          (template_ref __is_swappable)
          (type_ref _T2)))
      (parm_decl
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2))
      (parm_decl
        (template_ref pair)
        (type_ref _T1)
        (type_ref _T2)))
    (function_template make_pair
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (template_ref pair)
      (template_ref __decay_and_strip)
      (type_ref _T1)
      (template_ref __decay_and_strip)
      (type_ref _T2)
      (parm_decl __x
        (type_ref _T1))
      (parm_decl __y
        (type_ref _T2))
      (compound_stmt
        (decl_stmt
          (typedef_decl __ds_type1
            (template_ref __decay_and_strip)
            (type_ref _T1)))
        (decl_stmt
          (typedef_decl __ds_type2
            (template_ref __decay_and_strip)
            (type_ref _T2)))
        (decl_stmt
          (typedef_decl __pair_type
            (template_ref pair)
            (type_ref __ds_type1)
            (type_ref __ds_type2)))
        (return_stmt
          (call_expr
            (type_ref __pair_type)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _T1))
              (decl_ref_expr __x))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _T2))
              (decl_ref_expr __y)))))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/initializer_list
  (namespace std
    (class_template initializer_list
      (template_type_parameter _E)
      (cxx_access_spec_decl)
      (typedef_decl value_type
        (type_ref _E))
      (typedef_decl reference
        (type_ref _E))
      (typedef_decl const_reference
        (type_ref _E))
      (typedef_decl size_type
        (type_ref std::size_t))
      (typedef_decl iterator
        (type_ref _E))
      (typedef_decl const_iterator
        (type_ref _E))
      (cxx_access_spec_decl)
      (field_decl _M_array
        (type_ref std::initializer_list::iterator))
      (field_decl _M_len
        (type_ref std::initializer_list::size_type))
      (constructor initializer_list<_E>
        (parm_decl __a
          (type_ref std::initializer_list::const_iterator))
        (parm_decl __l
          (type_ref std::initializer_list::size_type))
        (member_ref _M_array)
        (decl_ref_expr __a)
        (member_ref _M_len)
        (decl_ref_expr __l)
        (compound_stmt))
      (cxx_access_spec_decl)
      (constructor initializer_list<_E>
        (member_ref _M_array)
        (integer_literal 0)
        (member_ref _M_len)
        (integer_literal 0)
        (compound_stmt))
      (cxx_method size
        (type_ref std::initializer_list::size_type)
        (compound_stmt
          (return_stmt
            (member_ref_expr _M_len))))
      (cxx_method begin
        (type_ref std::initializer_list::const_iterator)
        (compound_stmt
          (return_stmt
            (member_ref_expr _M_array))))
      (cxx_method end
        (type_ref std::initializer_list::const_iterator)
        (compound_stmt
          (return_stmt
            (binary_operator
              (call_expr begin
                (member_ref_expr begin))
              (call_expr size
                (member_ref_expr size)))))))
    (function_template begin
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __ils
        (template_ref initializer_list)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (member_ref_expr
              (decl_ref_expr __ils))))))
    (function_template end
      (template_type_parameter _Tp)
      (type_ref _Tp)
      (parm_decl __ils
        (template_ref initializer_list)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (member_ref_expr
              (decl_ref_expr __ils)))))))
  ; /../lib/gcc/x86_64-linux-gnu/11/../../../../include/c++/11/utility
  (namespace std
    (visibility_attr default)
    (class_template tuple_size
      (template_type_parameter _Tp))
    (type_alias_template_decl __enable_if_has_tuple_size
      (template_type_parameter _Tp)
      (template_type_parameter _Up
        (template_ref remove_cv)
        (type_ref _Tp))
      (template_type_parameter
        (template_ref enable_if)
        (decl_ref_expr
          (template_ref is_same)
          (type_ref _Tp)
          (type_ref _Up)))
      (template_non_type_parameter
        (type_ref std::size_t)
        (decl_ref_expr
          (template_ref tuple_size)
          (type_ref _Tp)))
      (type_alias_decl __enable_if_has_tuple_size
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_size
      (template_type_parameter _Tp)
      (template_ref __enable_if_has_tuple_size)
      (type_ref _Tp)
      (cxx_base_specifier tuple_size<_Tp>
        (template_ref tuple_size)
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_size
      (template_type_parameter _Tp)
      (template_ref __enable_if_has_tuple_size)
      (type_ref _Tp)
      (cxx_base_specifier tuple_size<_Tp>
        (template_ref tuple_size)
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_size
      (template_type_parameter _Tp)
      (template_ref __enable_if_has_tuple_size)
      (type_ref _Tp)
      (cxx_base_specifier tuple_size<_Tp>
        (template_ref tuple_size)
        (type_ref _Tp)))
    (class_template tuple_element
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp))
    (type_alias_template_decl __tuple_element_t
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp)
      (type_alias_decl __tuple_element_t
        (template_ref tuple_element)
        (decl_ref_expr __i)
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_element
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp)
      (decl_ref_expr __i)
      (type_ref _Tp)
      (typedef_decl type
        (template_ref add_const)
        (template_ref __tuple_element_t)
        (decl_ref_expr __i)
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_element
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp)
      (decl_ref_expr __i)
      (type_ref _Tp)
      (typedef_decl type
        (template_ref add_volatile)
        (template_ref __tuple_element_t)
        (decl_ref_expr __i)
        (type_ref _Tp)))
    (class_template_partial_specialization tuple_element
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp)
      (decl_ref_expr __i)
      (type_ref _Tp)
      (typedef_decl type
        (template_ref add_cv)
        (template_ref __tuple_element_t)
        (decl_ref_expr __i)
        (type_ref _Tp)))
    (type_alias_template_decl tuple_element_t
      (template_non_type_parameter __i
        (type_ref std::size_t))
      (template_type_parameter _Tp)
      (type_alias_decl tuple_element_t
        (template_ref tuple_element)
        (decl_ref_expr __i)
        (type_ref _Tp)))
    (class_template_partial_specialization __is_tuple_like_impl
      (template_type_parameter _T1)
      (template_type_parameter _T2)
      (template_ref pair)
      (type_ref _T1)
      (type_ref _T2)
      (cxx_base_specifier std::true_type
        (type_ref std::true_type)))
    (class_template_partial_specialization tuple_size
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (cxx_base_specifier integral_constant<std::size_t, 2>
        (template_ref integral_constant)
        (type_ref std::size_t)
        (integer_literal 2)))
    (class_template_partial_specialization tuple_element
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (integer_literal 0)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (typedef_decl type
        (type_ref _Tp1)))
    (class_template_partial_specialization tuple_element
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (integer_literal 1)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (typedef_decl type
        (type_ref _Tp2)))
    (class_template __pair_get
      (template_non_type_parameter _Int
        (type_ref std::size_t)))
    (struct_decl __pair_get
      (integer_literal 0)
      (function_template __get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp1)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (member_ref_expr
              (decl_ref_expr __pair)))))
      (function_template __move_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp1)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _Tp1))
              (member_ref_expr
                (decl_ref_expr __pair))))))
      (function_template __const_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp1)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (member_ref_expr
              (decl_ref_expr __pair)))))
      (function_template __const_move_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp1)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _Tp1))
              (member_ref_expr
                (decl_ref_expr __pair)))))))
    (struct_decl __pair_get
      (integer_literal 1)
      (function_template __get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp2)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (member_ref_expr
              (decl_ref_expr __pair)))))
      (function_template __move_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp2)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _Tp2))
              (member_ref_expr
                (decl_ref_expr __pair))))))
      (function_template __const_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp2)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (member_ref_expr
              (decl_ref_expr __pair)))))
      (function_template __const_move_get
        (template_type_parameter _Tp1)
        (template_type_parameter _Tp2)
        (type_ref _Tp2)
        (parm_decl __pair
          (template_ref pair)
          (type_ref _Tp1)
          (type_ref _Tp2))
        (compound_stmt
          (return_stmt
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _Tp2))
              (member_ref_expr
                (decl_ref_expr __pair)))))))
    (function_template get
      (template_non_type_parameter _Int
        (type_ref std::size_t))
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_ref tuple_element)
      (decl_ref_expr _Int)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (parm_decl __in
        (template_ref pair)
        (type_ref _Tp1)
        (type_ref _Tp2))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (template_ref __pair_get)
              (decl_ref_expr _Int))
            (decl_ref_expr __in)))))
    (function_template get
      (template_non_type_parameter _Int
        (type_ref std::size_t))
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_ref tuple_element)
      (decl_ref_expr _Int)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (parm_decl __in
        (template_ref pair)
        (type_ref _Tp1)
        (type_ref _Tp2))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (template_ref __pair_get)
              (decl_ref_expr _Int))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref move))
              (decl_ref_expr __in))))))
    (function_template get
      (template_non_type_parameter _Int
        (type_ref std::size_t))
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_ref tuple_element)
      (decl_ref_expr _Int)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (parm_decl __in
        (template_ref pair)
        (type_ref _Tp1)
        (type_ref _Tp2))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (template_ref __pair_get)
              (decl_ref_expr _Int))
            (decl_ref_expr __in)))))
    (function_template get
      (template_non_type_parameter _Int
        (type_ref std::size_t))
      (template_type_parameter _Tp1)
      (template_type_parameter _Tp2)
      (template_ref tuple_element)
      (decl_ref_expr _Int)
      (template_ref pair)
      (type_ref _Tp1)
      (type_ref _Tp2)
      (parm_decl __in
        (template_ref pair)
        (type_ref _Tp1)
        (type_ref _Tp2))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (template_ref __pair_get)
              (decl_ref_expr _Int))
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref move))
              (decl_ref_expr __in))))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Tp)
        (type_ref _Up))
      (compound_stmt
        (return_stmt
          (member_ref_expr
            (decl_ref_expr __p)))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Tp)
        (type_ref _Up))
      (compound_stmt
        (return_stmt
          (member_ref_expr
            (decl_ref_expr __p)))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Tp)
        (type_ref _Up))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (member_ref_expr
              (decl_ref_expr __p))))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Tp)
        (type_ref _Up))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (member_ref_expr
              (decl_ref_expr __p))))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Up)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (member_ref_expr
            (decl_ref_expr __p)))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Up)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (member_ref_expr
            (decl_ref_expr __p)))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Up)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (member_ref_expr
              (decl_ref_expr __p))))))
    (function_template get
      (template_type_parameter _Tp)
      (template_type_parameter _Up)
      (type_ref _Tp)
      (parm_decl __p
        (template_ref pair)
        (type_ref _Up)
        (type_ref _Tp))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (member_ref_expr
              (decl_ref_expr __p))))))
    (function_template exchange
      (template_type_parameter _Tp)
      (template_type_parameter _Up
        (type_ref _Tp))
      (type_ref _Tp)
      (parm_decl __obj
        (type_ref _Tp))
      (parm_decl __new_val
        (type_ref _Up))
      (compound_stmt
        (return_stmt
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref __exchange))
            (decl_ref_expr __obj)
            (call_expr
              (decl_ref_expr
                (namespace_ref std)
                (overloaded_decl_ref forward)
                (type_ref _Up))
              (decl_ref_expr __new_val))))))
    (class_template _Index_tuple
      (template_non_type_parameter _Indexes
        (type_ref std::size_t)))
    (class_template _Build_index_tuple
      (template_non_type_parameter _Num
        (type_ref std::size_t))
      (type_alias_template_decl _IdxTuple
        (template_type_parameter)
        (template_non_type_parameter _Indices
          (type_ref std::size_t))
        (type_alias_decl _IdxTuple
          (template_ref _Index_tuple)
          (pack_expansion_expr
            (decl_ref_expr _Indices))))
      (type_alias_decl __type
        (template_ref __make_integer_seq)
        (template_ref _IdxTuple)
        (type_ref std::size_t)
        (decl_ref_expr _Num)))
    (class_template integer_sequence
      (template_type_parameter _Tp)
      (template_non_type_parameter _Idx
        (type_ref _Tp))
      (typedef_decl value_type
        (type_ref _Tp))
      (cxx_method size
        (type_ref std::size_t)
        (compound_stmt
          (return_stmt
            (size_of_pack_expr _Idx)))))
    (type_alias_template_decl make_integer_sequence
      (template_type_parameter _Tp)
      (template_non_type_parameter _Num
        (type_ref _Tp))
      (type_alias_decl make_integer_sequence
        (template_ref __make_integer_seq)
        (template_ref integer_sequence)
        (type_ref _Tp)
        (decl_ref_expr _Num)))
    (type_alias_template_decl index_sequence
      (template_non_type_parameter _Idx
        (type_ref std::size_t))
      (type_alias_decl index_sequence
        (template_ref integer_sequence)
        (type_ref std::size_t)
        (pack_expansion_expr
          (decl_ref_expr _Idx))))
    (type_alias_template_decl make_index_sequence
      (template_non_type_parameter _Num
        (type_ref std::size_t))
      (type_alias_decl make_index_sequence
        (template_ref make_integer_sequence)
        (type_ref std::size_t)
        (decl_ref_expr _Num)))
    (type_alias_template_decl index_sequence_for
      (template_type_parameter _Types)
      (type_alias_decl index_sequence_for
        (template_ref make_index_sequence)
        (size_of_pack_expr
          (type_ref _Types)))))
  ; /home/david/src/nginx-datadog/src/defer.h
  (namespace datadog
    ; /home/david/src/nginx-datadog/src/defer.h
    (namespace nginx
      (class_template CleanupFuncGuard
        (template_type_parameter Func)
        (field_decl on_destroy_
          (type_ref Func))
        (field_decl active_)
        (cxx_access_spec_decl)
        (constructor CleanupFuncGuard<Func>
          (parm_decl func
            (type_ref Func))
          (member_ref on_destroy_)
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (decl_ref_expr func))
          (member_ref active_)
          (cxx_bool_literal_expr)
          (compound_stmt))
        (constructor CleanupFuncGuard<Func>
          (parm_decl other
            (type_ref CleanupFuncGuard<Func>))
          (member_ref on_destroy_)
          (call_expr
            (decl_ref_expr
              (namespace_ref std)
              (overloaded_decl_ref move))
            (member_ref_expr
              (decl_ref_expr other)))
          (member_ref active_)
          (cxx_bool_literal_expr)
          (compound_stmt
            (binary_operator
              (member_ref_expr
                (decl_ref_expr other))
              (cxx_bool_literal_expr))))
        (constructor CleanupFuncGuard<Func>
          (parm_decl
            (type_ref CleanupFuncGuard<Func>)))
        (destructor ~CleanupFuncGuard<Func>
          (compound_stmt
            (if_stmt
              (member_ref_expr active_)
              (compound_stmt
                (call_expr on_destroy_
                  (member_ref_expr on_destroy_)))))))
      (function_template defer
        (template_type_parameter Func)
        (template_ref CleanupFuncGuard)
        (type_ref Func)
        (parm_decl func
          (type_ref Func))
        (compound_stmt
          (return_stmt
            (call_expr
              (template_ref CleanupFuncGuard)
              (type_ref Func)
              (call_expr
                (decl_ref_expr
                  (namespace_ref std)
                  (overloaded_decl_ref forward)
                  (type_ref Func))
                (decl_ref_expr func)))))))))

