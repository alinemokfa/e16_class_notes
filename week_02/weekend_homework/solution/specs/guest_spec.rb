require('minitest/autorun')
require('minitest/rg')
require_relative('../guest')

class GuestTest < Minitest::Test

  def setup
    @guest = Guest.new("Rick")
  end

  def test_guest_has_name
    assert_equal("Rick", @guest.name)
  end
  
end