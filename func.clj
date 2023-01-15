(FUNCTION_DECL hijack_pass_directive
  (PARM_DECL inject_propagation_commands
    (PARM_DECL cf
      (TYPE_REF ngx_conf_t))
    (PARM_DECL cmd
      (TYPE_REF ngx_command_t))
    (PARM_DECL conf))
  (PARM_DECL cf
    (TYPE_REF ngx_conf_t))
  (PARM_DECL command
    (TYPE_REF ngx_command_t))
  (PARM_DECL conf)
  (CXX_TRY_STMT
    (COMPOUND_STMT
      (DECL_STMT
        (VAR_DECL rcode
          (TYPE_REF ngx_int_t)
          (UNEXPOSED_EXPR
            (CALL_EXPR datadog_conf_handler
              (UNEXPOSED_EXPR datadog_conf_handler
                (DECL_REF_EXPR datadog_conf_handler))
              (UNEXPOSED_EXPR
                (INIT_LIST_EXPR
                  (UNEXPOSED_EXPR
                    (MEMBER_REF conf)
                    (DECL_REF_EXPR cf))
                  (UNEXPOSED_EXPR
                    (MEMBER_REF skip_this_module)
                    (CXX_BOOL_LITERAL_EXPR))))))))
      (IF_STMT
        (BINARY_OPERATOR
          (UNEXPOSED_EXPR rcode
            (DECL_REF_EXPR rcode))
          (UNEXPOSED_EXPR
            (INTEGER_LITERAL)))
        (COMPOUND_STMT
          (RETURN_STMT
            (CXX_STATIC_CAST_EXPR
              (CSTYLE_CAST_EXPR
                (UNARY_OPERATOR
                  (INTEGER_LITERAL)))))))
      (IF_STMT
        (VAR_DECL loc_conf
          (CXX_STATIC_CAST_EXPR
            (TYPE_REF struct datadog::nginx::datadog_loc_conf_t)
            (UNEXPOSED_EXPR
              (ARRAY_SUBSCRIPT_EXPR
                (UNEXPOSED_EXPR loc_conf
                  (MEMBER_REF_EXPR loc_conf
                    (PAREN_EXPR
                      (CSTYLE_CAST_EXPR
                        (TYPE_REF ngx_http_conf_ctx_t)
                        (UNEXPOSED_EXPR ctx
                          (MEMBER_REF_EXPR ctx
                            (UNEXPOSED_EXPR cf
                              (DECL_REF_EXPR cf))))))))
                (UNEXPOSED_EXPR ctx_index
                  (MEMBER_REF_EXPR ctx_index
                    (DECL_REF_EXPR ngx_http_datadog_module)))))))
        (UNEXPOSED_EXPR loc_conf
          (UNEXPOSED_EXPR loc_conf
            (DECL_REF_EXPR loc_conf)))
        (COMPOUND_STMT
          ; loc_conf->proxy_directive = command->name;
          (CALL_EXPR operator=
            (MEMBER_REF_EXPR proxy_directive
              (UNEXPOSED_EXPR loc_conf
                (DECL_REF_EXPR loc_conf)))
            (UNEXPOSED_EXPR operator=
              (DECL_REF_EXPR operator=))
            (UNEXPOSED_EXPR name
              (MEMBER_REF_EXPR name
                (UNEXPOSED_EXPR command
                  (DECL_REF_EXPR command)))))))
      (RETURN_STMT
        (CALL_EXPR inject_propagation_commands
          (UNEXPOSED_EXPR inject_propagation_commands
            (DECL_REF_EXPR inject_propagation_commands))
          (UNEXPOSED_EXPR cf
            (DECL_REF_EXPR cf))
          (UNEXPOSED_EXPR command
            (DECL_REF_EXPR command))
          (UNEXPOSED_EXPR conf
            (DECL_REF_EXPR conf)))))
    (CXX_CATCH_STMT
      (VAR_DECL e
        (NAMESPACE_REF std)
        (TYPE_REF class std::exception))
      (COMPOUND_STMT
        (IF_STMT
          (BINARY_OPERATOR
            (UNEXPOSED_EXPR log_level
              (MEMBER_REF_EXPR log_level
                (UNEXPOSED_EXPR
                  (PAREN_EXPR
                    (MEMBER_REF_EXPR log
                      (UNEXPOSED_EXPR cf
                        (DECL_REF_EXPR cf)))))))
            (UNEXPOSED_EXPR
              (INTEGER_LITERAL 4)))
          (CALL_EXPR ngx_log_error_core
            (UNEXPOSED_EXPR ngx_log_error_core
              (DECL_REF_EXPR ngx_log_error_core))
            (UNEXPOSED_EXPR
              (INTEGER_LITERAL 4))
            (UNEXPOSED_EXPR log
              (MEMBER_REF_EXPR log
                (UNEXPOSED_EXPR cf
                  (DECL_REF_EXPR cf))))
            (INTEGER_LITERAL 0)
            (UNEXPOSED_EXPR
              (STRING_LITERAL "Datadog-wrapped configuration directive %V failed: %s"))
            (CALL_EXPR
              (UNEXPOSED_EXPR name
                (MEMBER_REF_EXPR name
                  (UNEXPOSED_EXPR command
                    (DECL_REF_EXPR command)))))
            (CALL_EXPR what
              (MEMBER_REF_EXPR what
                (DECL_REF_EXPR e)))))
        (RETURN_STMT
          (CXX_STATIC_CAST_EXPR
            (CSTYLE_CAST_EXPR
              (UNARY_OPERATOR
                (INTEGER_LITERAL)))))))))