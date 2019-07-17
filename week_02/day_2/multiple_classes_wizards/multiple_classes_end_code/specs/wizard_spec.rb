require('minitest/autorun')
require_relative('../wizard')
require_relative('../wand')

class TestWizard < MiniTest::Test

  def setup
    @broken_wand = Wand.new("oak", "unicorn hair")
    @elder_wand = Wand.new("holly", "phoenix feather")
    @ron = Wizard.new("Ron Weasley", @broken_wand)
    @harry = Wizard.new("Harry Potter", @elder_wand)
  end

  def test_wizard_got_name
    assert_equal("Ron Weasley", @ron.name)
  end

  def test_can_cast_spell
    assert_equal("stupor", @ron.cast_spell("stupor"))
  end

  def test_can_cast_stronger_spell
    assert_equal("EXPECTO PATRONUM", @harry.cast_spell("expecto patronum"))
  end

end