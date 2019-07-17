require('minitest/autorun')
require('minitest/rg')
require_relative('../book.rb')

class TestBook < MiniTest::Test
  def setup()
    @book = Book.new("Lord of the rings", "J.R.R Tolkien")
    # @book2 = Book.new("Game of Thrones", "George R.R Martin")
  end

  def test_book_has_name()
    actual = @book.title()
    assert_equal("Lord of the rings", actual)
  end

  def test_book_has_author()
    actual = @book.author()
    assert_equal("J.R.R Tolkien", actual)
  end
end
