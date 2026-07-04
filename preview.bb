include test_defs.inc

# Interpolation
DEPLOY_DIR = "${TMPDIR}/deploy"
FILE_DIRNAME = "${@os.path.dirname(d.getVar('FILE', False))}"

# Conditionals
OVERRIDES = "architecture:os:machine"
TEST = "default"
TEST:os = "osspecific"
TEST:nooverride = "othercondvalue"

# Shell Functions
fn:prepend() {
    bbplain second-${TEST}
}

# Python Tasks
python do_printdate () {
    import datetime
    bb.plain('Date: %s' % (datetime.date.today()))
}

addtask printdate after do_fetch before do_build





