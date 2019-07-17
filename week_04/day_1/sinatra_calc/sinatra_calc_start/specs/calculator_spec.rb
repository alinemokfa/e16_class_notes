require 'minitest/autorun'
require_relative '../models/calculator'

class TestCalculator < Minitest::Test

  def setup
    @calculator = Calculator.new( 4, 2 )
  end

  def test_add
    assert_equal( 6, @calculator.add() )
  end

  def test_subtract
    assert_equal( 2, @calculator.subtract() )
  end

  def test_multiply
    assert_equal( 8, @calculator.multiply() ) 
  end

  def test_divide
    assert_equal( 2, @calculator.divide() )
  end

end
