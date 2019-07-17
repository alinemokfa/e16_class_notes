require('minitest/autorun')
require('minitest/rg')
require_relative('../library.rb')
require_relative('../book.rb')

class TestLibrary < MiniTest::Test
  def setup()
    @library = Library.new()
    @book = Book.new("The Outsiders", "Somebody")
  end

  def test_library_starts_with_zero_books()
    actual = @library.number_of_books()
    assert_equal(0, actual)
  end

  def test_library_can_add_book()
    @library.add_book(@book)
    actual = @library.number_of_books()
    assert_equal(1, actual)
  end

  
end
