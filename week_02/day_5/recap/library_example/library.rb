require_relative('book.rb')

class Library
  def initialize()
    @books = []
  end

  def number_of_books()
    return @books.length()
  end

  def add_book(new_book)
    @books.push(new_book)
  end
end
