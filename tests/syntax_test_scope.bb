# SYNTAX TEST "Packages/BitBake/BitBake.sublime-syntax"

# Comments
# <- comment.line.bitbake punctuation.definition.comment.bitbake
#^^^^^^^^^^ comment.line.bitbake

# Variables

VARIABLE = "value"
#^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^^ variable.other.bitbake
#        ^ keyword.operator.assignment.bitbake
#          ^ meta.string.bitbake string.quoted.double.bitbake punctuation.definition.string.begin.bitbake
#           ^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                ^ punctuation.definition.string.end.bitbake

VARIABLE = 'I have a " in my value'
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^^ variable.other.bitbake
#        ^ keyword.operator.assignment.bitbake
#          ^ meta.string.bitbake string.quoted.single.bitbake punctuation.definition.string.begin.bitbake
#           ^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.single.bitbake
#                                 ^ punctuation.definition.string.end.bitbake

FOO = "bar \
       baz \
#     ^^^^^^^ string.quoted.double.bitbake
#          ^ punctuation.separator.continuation.line.bitbake
       qaz"
#^^^^^^^^^^ meta.binding.bitbake string.quoted.double.bitbake
#         ^ punctuation.definition.string.end

A = "aval"
B = "pre${A}post"
#^^^^^^^^^^^^^^^^ meta.binding.bitbake
#   ^^^^^^^^^^^^^ meta.string.bitbake
#   ^^^^ string.quoted.double.bitbake
#   ^ punctuation.definition.string.begin.bitbake
#       ^^^^ meta.interpolation.bitbake - string
#       ^ punctuation.definition.interpolation.begin.bitbake
#        ^ punctuation.section.interpolation.begin.bitbake
#         ^ variable.other.bitbake
#          ^ punctuation.section.interpolation.end.bitbake
#           ^^^^^ string.quoted.double.bitbake
#               ^ punctuation.definition.string.end

A ?= "aval"
#^^^^^^^^^^ meta.binding.bitbake
# ^^ keyword.operator.assignment.bitbake
#    ^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#    ^ punctuation.definition.string.begin.bitbake
#         ^ punctuation.definition.string.end

W ??= "x"
# <- meta.binding.bitbake variable.other.bitbake
#^^^^^^^^ meta.binding.bitbake
# ^^^ keyword.operator.assignment.bitbake
#     ^^^ meta.string.bitbake string.quoted.double.bitbake
#     ^ punctuation.definition.string.begin.bitbake
#       ^ punctuation.definition.string.end

W += "y"
# <- meta.binding.bitbake variable.other.bitbake
#^^^^^^^ meta.binding.bitbake
# ^^ keyword.operator.assignment.bitbake
#    ^^^ meta.string.bitbake string.quoted.double.bitbake
#    ^ punctuation.definition.string.begin.bitbake
#      ^ punctuation.definition.string.end

W:append = "y"
# <- meta.binding.bitbake variable.other.bitbake
#^^^^^^^^^^^^^ meta.binding.bitbake
#^ punctuation.accessor.colon.bitbake
# ^^^^^^ support.function.bitbake
#        ^ keyword.operator.assignment.bitbake
#          ^^^ meta.string.bitbake string.quoted.double.bitbake
#          ^ punctuation.definition.string.begin.bitbake
#            ^ punctuation.definition.string.end.bitbake

A := "${W}" # Immediate variable expansion
# <- meta.binding.bitbake variable.other.bitbake
#^^^^^^^^^^ meta.binding.bitbake
# ^^ keyword.operator.assignment.bitbake
#    ^^^^^^ meta.string.bitbake
#    ^ string.quoted.double.bitbake punctuation.definition.string.begin.bitbake
#     ^^^^ meta.interpolation.bitbake
#     ^ punctuation.definition.interpolation.begin.bitbake
#      ^ punctuation.section.interpolation.begin.bitbake
#       ^ variable.other.bitbake
#        ^ punctuation.section.interpolation.end.bitbake
#         ^ string.quoted.double.bitbake punctuation.definition.string.end
#           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ comment.line.bitbake
#           ^ punctuation.definition.comment.bitbake


# Directives

addhandler

addpylib /path/to/directory namespace


# 4.1.14 Inline Python Variable Expansion

DATE = "${@time.strftime('%Y%m%d',time.gmtime())}"
#      ^ meta.string.bitbake string.quoted.double.bitbake punctuation.definition.string.begin.bitbake
#       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake meta.interpolation.bitbake
#       ^ punctuation.definition.interpolation.begin.bitbake
#        ^ punctuation.section.interpolation.begin.bitbake
#         ^ punctuation.definition.expansion.bitbake
#          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ source.python
#                                               ^ punctuation.section.interpolation.end.bitbake
#                                                ^ meta.string.bitbake string.quoted.double.bitbake punctuation.definition.string.end.bitbake

PV = "${@bb.parse.vars_from_file(d.getVar('FILE', False),d)[1] or '1.0'}"
#    ^ meta.string.bitbake string.quoted.double.bitbake punctuation.definition.string.begin.bitbake
#     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake meta.interpolation.bitbake
#     ^ punctuation.definition.interpolation.begin.bitbake
#      ^ punctuation.section.interpolation.begin.bitbake
#       ^ punctuation.definition.expansion.bitbake
#        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ source.python
#                                                                      ^ punctuation.section.interpolation.end.bitbake
#                                                                       ^ meta.string.bitbake string.quoted.double.bitbake punctuation.definition.string.end.bitbake


# 4.1.15 Unsetting variables

unset DATE
#^^^^^^^^^ meta.directive.unset.bitbake
#^^^^ keyword.control.directive.bitbake
#     ^^^^ variable.other.bitbake

unset do_fetch[noexec]
#^^^^^^^^^^^^^^^^^^^^^ meta.directive.unset.bitbake
#^^^^ keyword.control.directive.bitbake
#     ^^^^^^^^ variable.other.bitbake
#             ^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#             ^ punctuation.section.brackets.begin.bitbake
#              ^^^^^^ constant.language.flag.bitbake
#                    ^ punctuation.section.brackets.end.bitbake


# 4.2 Exporting Variables to the Environment

export ENV_VARIABLE
#^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^ storage.modifier.bitbake
#      ^^^^^^^^^^^^ variable.other.bitbake

export ENV_VARIABLE
ENV_VARIABLE = "value from the environment"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^^^^^^ variable.other.bitbake
#            ^ keyword.operator.assignment.bitbake
#              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#              ^ punctuation.definition.string.begin.bitbake
#                                         ^ punctuation.definition.string.end.bitbake

export ENV_VARIABLE = "variable-value"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^ storage.modifier.bitbake
#      ^^^^^^^^^^^^ variable.other.bitbake
#                   ^ keyword.operator.assignment.bitbake
#                     ^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                     ^ punctuation.definition.string.begin.bitbake
#                                    ^ punctuation.definition.string.end.bitbake

do_foo() {
    bbplain "$ENV_VARIABLE"
# ^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#             ^^^^^^^^^^^^ variable.other
}


# 4.3.1 Conditional Metadata

OVERRIDES = "architecture:os:machine"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^^^ variable.other.bitbake
#         ^ keyword.operator.assignment.bitbake
#           ^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#           ^ punctuation.definition.string.begin.bitbake
#                                   ^ punctuation.definition.string.end.bitbake

TEST = "default"
#^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^ variable.other.bitbake
#    ^ keyword.operator.assignment.bitbake
#      ^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#      ^ punctuation.definition.string.begin.bitbake
#              ^ punctuation.definition.string.end.bitbake
TEST:os = "osspecific"
#^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^ variable.other.bitbake
#   ^ punctuation.accessor.colon.bitbake
#    ^^ storage.modifier.bitbake
#       ^ keyword.operator.assignment.bitbake
#         ^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#         ^ punctuation.definition.string.begin.bitbake
#                    ^ punctuation.definition.string.end.bitbake

TEST:nooverride = "othercondvalue"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^ variable.other.bitbake
#   ^ punctuation.accessor.colon.bitbake
#    ^^^^^^^^^^ storage.modifier.bitbake
#               ^ keyword.operator.assignment.bitbake
#                 ^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                 ^ punctuation.definition.string.begin.bitbake
#                                ^ punctuation.definition.string.end.bitbake


# 4.4 Sharing Functionality

inherit autotools rm_work
#^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^ keyword.control.directive.bitbake
#       ^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake
#                 ^^^^^^^ meta.string.bitbake string.unquoted.bitbake

inherit_defer ${VARNAME}
#^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^^^^^^^ keyword.control.directive.bitbake
#             ^^^^^^^^^^ meta.string.bitbake meta.interpolation.bitbake
#             ^ punctuation.definition.interpolation.begin.bitbake
#              ^ punctuation.section.interpolation.begin.bitbake
#               ^^^^^^^ variable.other.bitbake
#                      ^ punctuation.section.interpolation.end.bitbake

inherit_defer ${@'classname' if condition else ''}
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^^^^^^^ keyword.control.directive.bitbake
#             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake meta.interpolation.bitbake
#             ^ punctuation.definition.interpolation.begin.bitbake
#              ^ punctuation.section.interpolation.begin.bitbake
#               ^ punctuation.definition.expansion.bitbake
#                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ source.python
#                ^^^^^^^^^^^ string.quoted.single
#                ^ punctuation.definition.string.begin
#                          ^ punctuation.definition.string.end
#                            ^^ keyword.control
#                               ^^^^^^^^^ meta.generic-name, variable.other
#                                         ^^^^ keyword.control
#                                              ^^ string.quoted.single
#                                                ^ punctuation.section.interpolation.end.bitbake

inherit_defer ${@bb.utils.contains('VARIABLE', 'something', 'classname', '', d)}
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^^^^^^^ keyword.control.directive.bitbake
#             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake meta.interpolation.bitbake
#             ^ punctuation.definition.interpolation.begin.bitbake
#              ^ punctuation.section.interpolation.begin.bitbake
#               ^ punctuation.definition.expansion.bitbake
#                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ source.python
#                                                                              ^ punctuation.section.interpolation.end.bitbake


# 4.4.3 include Directive

include test_defs.inc
#^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^ keyword.control.directive.bitbake
#       ^^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake


# 4.4.4 include_all Directive

include_all conf/distro/include/maintainers.inc
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^^^^^ keyword.control.directive.bitbake
#           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake


# 4.4.5 require Directive

require foo.inc
#^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^ keyword.control.directive.bitbake
#       ^^^^^^^ meta.string.bitbake string.unquoted.bitbake


# 4.4.7 addfragments Directive


addfragments conf/fragments OE_FRAGMENTS OE_FRAGMENTS_METADATA_VARS OE_FRAGMENTS_BUILTIN
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.import.bitbake
#^^^^^^^^^^^ keyword.control.directive.bitbake
#            ^^^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake
#                           ^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake
#                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake
#                                                                   ^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.unquoted.bitbake


# 4.5.1 Shell Functions

do_foo() {
# <- meta.function.identifier.bitbake entity.name.function.bitbake
#^^^^^ meta.function.identifier.bitbake entity.name.function.bitbake
#     ^^ meta.function.parameters.bitbake meta.group.bitbake
#     ^ punctuation.section.group.begin.bitbake
#      ^ punctuation.section.group.end.bitbake
#       ^ meta.function.bitbake.bitbake
#        ^^ meta.function.body.bitbake meta.block.bitbake
#        ^ punctuation.section.block.begin.bitbake
#         ^ source.shell.embedded.bitbake
    bbplain first
#^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#   ^^^^^^^ meta.function-call variable.function
#          ^^^^^^ meta.function-call
    fn
#^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#   ^^ meta.function-call variable.function
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

fn:prepend() {
# <- meta.function.identifier.bitbake entity.name.function.bitbake
#^^^^^^^^^ meta.function.identifier.bitbake
#^ entity.name.function.bitbake
# ^ punctuation.accessor.colon.bitbake
#  ^^^^^^^ support.function.bitbake
#         ^^ meta.function.parameters.bitbake meta.group.bitbake
#         ^ punctuation.section.group.begin.bitbake
#          ^ punctuation.section.group.end.bitbake
#           ^ meta.function.bitbake.bitbake
#            ^^ meta.function.body.bitbake meta.block.bitbake
#            ^ punctuation.section.block.begin.bitbake
#             ^ source.shell.embedded.bitbake
    bbplain second
#^^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#   ^^^^^^^ meta.function-call variable.function
#          ^^^^^^^ meta.function-call
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

fn() {
# <- meta.function.identifier.bitbake entity.name.function.bitbake
#^ meta.function.identifier.bitbake entity.name.function.bitbake
# ^^ meta.function.parameters.bitbake meta.group.bitbake
# ^ punctuation.section.group.begin.bitbake
#  ^ punctuation.section.group.end.bitbake
#   ^ meta.function.bitbake.bitbake
#    ^^ meta.function.body.bitbake meta.block.bitbake
#    ^ punctuation.section.block.begin.bitbake
#     ^ source.shell.embedded.bitbake
    bbplain third
#^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#   ^^^^^^^ meta.function-call variable.function
#          ^^^^^^ meta.function-call
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

do_foo:append() {
# <- meta.function.identifier.bitbake entity.name.function.bitbake
#^^^^^^^^^^^^ meta.function.identifier.bitbake
#^^^^^ entity.name.function.bitbake
#     ^ punctuation.accessor.colon.bitbake
#      ^^^^^^ support.function.bitbake
#            ^^ meta.function.parameters.bitbake meta.group.bitbake
#            ^ punctuation.section.group.begin.bitbake
#             ^ punctuation.section.group.end.bitbake
#              ^ meta.function.bitbake.bitbake
#               ^^ meta.function.body.bitbake meta.block.bitbake
#               ^ punctuation.section.block.begin.bitbake
#                ^ source.shell.embedded.bitbake
    bbplain fourth
#^^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.shell.embedded.bitbake
#   ^^^^^^^ meta.function-call variable.function
#          ^^^^^^^ meta.function-call
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake


# 4.5.2 BitBake-Style Python Functions

python do_foo:prepend() {
#^^^^^^ meta.function.bitbake
#      ^^^^^^^^^^^^^^ meta.function.identifier.bitbake
#                    ^^ meta.function.parameters.bitbake meta.group.bitbake
#                      ^ meta.function.bitbake.bitbake
#                       ^^ meta.function.body.bitbake meta.block.bitbake
#^^^^^ storage.type.bitbake
#      ^^^^^^ entity.name.function.bitbake
#            ^ punctuation.accessor.colon.bitbake
#             ^^^^^^^ support.function.bitbake
#                    ^ punctuation.section.group.begin.bitbake
#                     ^ punctuation.section.group.end.bitbake
#                       ^ punctuation.section.block.begin.bitbake
#                        ^ source.python.embedded.bitbake
    bb.plain("first")
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

python do_foo() {
#^^^^^^ meta.function.bitbake
#      ^^^^^^ meta.function.identifier.bitbake entity.name.function.bitbake
#            ^^ meta.function.parameters.bitbake meta.group.bitbake
#              ^ meta.function.bitbake.bitbake
#               ^^ meta.function.body.bitbake meta.block.bitbake
#^^^^^ storage.type.bitbake
#            ^ punctuation.section.group.begin.bitbake
#             ^ punctuation.section.group.end.bitbake
#               ^ punctuation.section.block.begin.bitbake
#                ^ source.python.embedded.bitbake
    bb.plain("second")
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

python do_foo:append() {
#^^^^^^ meta.function.bitbake
#      ^^^^^^^^^^^^^ meta.function.identifier.bitbake
#                   ^^ meta.function.parameters.bitbake meta.group.bitbake
#                     ^ meta.function.bitbake.bitbake
#                      ^^ meta.function.body.bitbake meta.block.bitbake
#^^^^^ storage.type.bitbake
#      ^^^^^^ entity.name.function.bitbake
#            ^ punctuation.accessor.colon.bitbake
#             ^^^^^^ support.function.bitbake
#                   ^ punctuation.section.group.begin.bitbake
#                    ^ punctuation.section.group.end.bitbake
#                      ^ punctuation.section.block.begin.bitbake
#                       ^ source.python.embedded.bitbake
    bb.plain("third")
#^^^^^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.python.embedded.bitbake
#   ^^ meta.generic-name.python, variable.other.python
#     ^ punctuation.accessor.dot
#      ^^^^^ variable.function
#            ^^^^^^^ string.quoted.double
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake


# 4.5.3 Python Functions

def get_depends(d):
# <- source.python.embedded.bitbake meta.function.python keyword.declaration.function.python
#^^^^^^^^^^^^^^^^^^ source.python.embedded.bitbake
#^^^^^^^^^^^^^^ meta.function.python
#^^ keyword.declaration.function.python
#   ^^^^^^^^^^^ entity.name.function.python
#              ^^^ meta.function.parameters.python
#              ^ punctuation.section.parameters.begin.python
#               ^ variable.parameter.python
#                ^ punctuation.section.parameters.end.python
#                 ^ meta.function.python punctuation.section.block.begin.python
#                  ^ meta.function.body.python meta.block.python

def get_depends(d):
    if d.getVar('SOMECONDITION'):
    # <- source.python.embedded.bitbake meta.function.body.python meta.block.python keyword.control
        return "dependencywithcond"
    else:
    # <- source.python.embedded.bitbake meta.function.body.python meta.block.python keyword.control
        return "dependency"

SOMECONDITION = "1"
# <- meta.binding.bitbake variable.other.bitbake - source.python

DEPENDS = "${@get_depends(d)}"
# <- meta.binding.bitbake variable.other.bitbake
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^ variable.other.bitbake
#       ^ keyword.operator.assignment.bitbake
#         ^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake
#         ^ string.quoted.double.bitbake punctuation.definition.string.begin.bitbake
#          ^^^^^^^^^^^^^^^^^^ meta.interpolation.bitbake
#          ^ punctuation.definition.interpolation.begin.bitbake
#           ^ punctuation.section.interpolation.begin.bitbake
#            ^ punctuation.definition.expansion.bitbake
#             ^^^^^^^^^^^^^^ source.python meta.function-call
#                           ^ punctuation.section.interpolation.end.bitbake
#                            ^ string.quoted.double.bitbake punctuation.definition.string.end.bitbake


# 4.5.4 BitBake-Style Python Functions Versus Python Functions

bb.build.exec_func("my_bitbake_style_function", d)
#^ variable.namespace.bitbake
# ^ punctuation.accessor.dot.bitbake
#  ^^^^^ variable.namespace.bitbake
#       ^ punctuation.accessor.dot.bitbake
#        ^^^^^^^^^ meta.function-call.identifier.bitbake variable.function.bitbake
#                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.function-call.arguments.bitbake meta.group.bitbake
#                 ^ punctuation.section.group.begin.bitbake
#                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                  ^ punctuation.definition.string.begin.bitbake
#                                            ^ punctuation.definition.string.end.bitbake
#                                             ^ punctuation.separator.comma.python
#                                               ^ variable.other.bitbake
#                                                ^ punctuation.section.group.end.bitbake


# 4.5.5 Anonymous Python Function

python () {
# <- meta.function.bitbake storage.type.bitbake
#^^^^^^ meta.function.bitbake
#      ^^ meta.function.parameters.bitbake meta.group.bitbake
#        ^ meta.function.bitbake.bitbake
#         ^^ meta.function.body.bitbake meta.block.bitbake
#^^^^^ storage.type.bitbake
#      ^ punctuation.section.group.begin.bitbake
#       ^ punctuation.section.group.end.bitbake
#         ^ punctuation.section.block.begin.bitbake
#          ^ source.python.embedded.bitbake source.python
    d.setVar('FOO', 'foo 2')
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.function.body.bitbake meta.block.bitbake source.python.embedded.bitbake
#   ^ meta.generic-name.python, variable.other.python
#    ^ punctuation.accessor.dot.python
#     ^^^^^^ variable.function.python
#            ^^^^^ string.quoted.single.python
#                 ^ punctuation.separator.arguments.python
#                   ^^^^^^^ string.quoted.single.python
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake


# 4.5.6 Flexible Inheritance for Class Functions

EXPORT_FUNCTIONS functionname
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.export.bitbake
#^^^^^^^^^^^^^^^ keyword.control.directive.bitbake
#                ^^^^^^^^^^^^ entity.name.function.bitbake


# 4.6 Tasks

python do_printdate () {
    import datetime
    bb.plain('Date: %s' % (datetime.date.today()))
}

addtask printdate after do_fetch before do_build
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.task.bitbake
#^^^^^^ keyword.control.directive.bitbake
#       ^^^^^^^^^ entity.name.task.bitbake
#                 ^^^^^ keyword.control.directive.bitbake
#                       ^^^^^^^^ variable.other.bitbake
#                                ^^^^^^ keyword.control.directive.bitbake
#                                       ^^^^^^^^ variable.other.bitbake

deltask printdate
#^^^^^^^^^^^^^^^^ meta.directive.task.bitbake
#^^^^^^ keyword.control.directive.bitbake
#       ^^^^^^^^^ entity.name.task.bitbake


# 4.6.3 Passing Information Into the Build Task Environment

export BB_ENV_PASSTHROUGH_ADDITIONS="$BB_ENV_PASSTHROUGH_ADDITIONS CCACHE_DIR"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^ storage.modifier.bitbake
#      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ variable.other.bitbake
#                                  ^ keyword.operator.assignment.bitbake
#                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                                   ^ punctuation.definition.string.begin.bitbake
#                                                                            ^ punctuation.definition.string.end.bitbake


# 4.7 Variable Flags

var[cleandirs]="vak"
#  ^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^ constant.language.flag.bitbake
#            ^ punctuation.section.brackets.end.bitbake

var[depends]="vak"
#  ^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^ constant.language.flag.bitbake
#          ^ punctuation.section.brackets.end.bitbake

var[deptask]="vak"
#  ^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^ constant.language.flag.bitbake
#          ^ punctuation.section.brackets.end.bitbake

var[dirs]="vak"
#  ^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^ constant.language.flag.bitbake
#       ^ punctuation.section.brackets.end.bitbake

var[file-checksums]="vak"
#  ^^^^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^^^^ constant.language.flag.bitbake
#                 ^ punctuation.section.brackets.end.bitbake

var[lockfiles]="vak"
#  ^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^ constant.language.flag.bitbake
#            ^ punctuation.section.brackets.end.bitbake

var[network]="vak"
#  ^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^ constant.language.flag.bitbake
#          ^ punctuation.section.brackets.end.bitbake

var[noexec]="vak"
#  ^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^ constant.language.flag.bitbake
#         ^ punctuation.section.brackets.end.bitbake

var[nostamp]="vak"
#  ^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^ constant.language.flag.bitbake
#          ^ punctuation.section.brackets.end.bitbake

var[number_threads]="vak"
#  ^^^^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^^^^ constant.language.flag.bitbake
#                 ^ punctuation.section.brackets.end.bitbake

var[postfuncs]="vak"
#  ^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^ constant.language.flag.bitbake
#            ^ punctuation.section.brackets.end.bitbake

var[prefuncs]="vak"
#  ^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^ constant.language.flag.bitbake
#           ^ punctuation.section.brackets.end.bitbake

var[rdepends]="vak"
#  ^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^ constant.language.flag.bitbake
#           ^ punctuation.section.brackets.end.bitbake

var[rdeptask]="vak"
#  ^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^ constant.language.flag.bitbake
#           ^ punctuation.section.brackets.end.bitbake

var[recideptask]="vak"
#  ^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^ constant.language.flag.bitbake
#              ^ punctuation.section.brackets.end.bitbake

var[recrdeptask]="vak"
#  ^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^ constant.language.flag.bitbake
#              ^ punctuation.section.brackets.end.bitbake

var[stamp-extra-info]="vak"
#  ^^^^^^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^^^^^^ constant.language.flag.bitbake
#                   ^ punctuation.section.brackets.end.bitbake

var[umask]="vak"
#  ^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^ constant.language.flag.bitbake
#        ^ punctuation.section.brackets.end.bitbake

var[vardeps]="vak"
#  ^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^ constant.language.flag.bitbake
#          ^ punctuation.section.brackets.end.bitbake

var[vardepsexclude]="vak"
#  ^^^^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^^^^ constant.language.flag.bitbake
#                 ^ punctuation.section.brackets.end.bitbake

var[vardepvalue]="vak"
#  ^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^ constant.language.flag.bitbake
#              ^ punctuation.section.brackets.end.bitbake

var[vardepvalueexclude]="vak"
#  ^^^^^^^^^^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#  ^ punctuation.section.brackets.begin.bitbake
#   ^^^^^^^^^^^^^^^^^^ constant.language.flag.bitbake
#                      punctuation.section.brackets.end.bitbake


# 4.8 Events

python myclass_eventhandler() {
#^^^^^^ meta.function.bitbake
#      ^^^^^^^^^^^^^^^^^^^^ meta.function.identifier.bitbake entity.name.function.bitbake
#                          ^^ meta.function.parameters.bitbake meta.group.bitbake
#                            ^ meta.function.bitbake.bitbake
#                             ^^ meta.function.body.bitbake meta.block.bitbake
#^^^^^ storage.type.bitbake
#                          ^ punctuation.section.group.begin.bitbake
#                           ^ punctuation.section.group.end.bitbake
#                             ^ punctuation.section.block.begin.bitbake
#                              ^ source.python.embedded.bitbake source.python
    from bb.event import getName
    print("The name of the Event is %s" % getName(e))
    print("The file we run for is %s" % d.getVar('FILE'))
}
# <- meta.function.body.bitbake meta.block.bitbake punctuation.section.block.end.bitbake

addhandler myclass_eventhandler
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.directive.handler.bitbake
#^^^^^^^^^ keyword.control.directive.bitbake
#          ^^^^^^^^^^^^^^^^^^^^ variable.other.bitbake

myclass_eventhandler[eventmask] = "bb.event.BuildStarted"
#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ meta.binding.bitbake
#^^^^^^^^^^^^^^^^^^^ variable.other.bitbake
#                   ^^^^^^^^^^^ meta.flags.bitbake meta.brackets.bitbake
#                   ^ punctuation.section.brackets.begin.bitbake
#                    ^^^^^^^^^ constant.other.bitbake
#                             ^ punctuation.section.brackets.end.bitbake
#                               ^ keyword.operator.assignment.bitbake
#                                 ^^^^^^^^^^^^^^^^^^^^^^^ meta.string.bitbake string.quoted.double.bitbake
#                                 ^ punctuation.definition.string.begin.bitbake
#                                                       ^ punctuation.definition.string.end.bitbake
