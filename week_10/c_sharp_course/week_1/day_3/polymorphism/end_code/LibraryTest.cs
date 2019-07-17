using System;
using NUnit.Framework;

namespace Library
{
    [TestFixture]
    public class LibraryTest
    {
        Library library;
        Book book;
        Game game;

        [SetUp]
        public void Init()
        {
            library = new Library("CC Library", 10);
            book = new Book();
            game = new Game();
        }

        [Test]
        public void TestHasName()
        {
            Assert.AreEqual( "CC Library", library.Name );
        }

        [Test]
        public void TestHasCapacity()
        {
            Assert.AreEqual(10, library.Capacity);
        }

        [Test]
        public void TestLibraryStartsEmpty()
        {
            Assert.AreEqual(0, library.ItemCount());
        }

        [Test]
        public void TestCanAddBookToLibrary()
        {
            library.AddItem(book);
            Assert.AreEqual(1, library.ItemCount());
        }

        [Test]
        public void TestCanAddGameToLibrary()
        {
            library.AddItem(game);
            Assert.AreEqual(1, library.ItemCount());
        }

        [Test]
        public void TestCanEmptyShelves()
        {
          library.AddItem(book);
          library.AddItem(game);
          library.ClearShelves();
          Assert.AreEqual(0, library.ItemCount());
        }
    }
}