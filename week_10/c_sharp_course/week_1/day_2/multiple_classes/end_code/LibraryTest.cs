using System;
using NUnit.Framework;

namespace Library
{
    [TestFixture]
    public class LibraryTest
    {
        Library library;
        Book book;

        [SetUp]
        public void Init()
        {
            library = new Library("CC Library", 10);
            book = new Book();
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
        public void TestCannotAddBookWhenFull()
        {
          for (int i = 0; i < 20; i++)
          {
            library.AddItem(book);;
          }
          Assert.AreEqual(10, library.ItemCount());
        }

        [Test]
        public void TestLibraryFull()
        {
          for (int i = 0; i < library.Capacity; i++)
          {
            library.AddItem(book);
          }
          Assert.AreEqual(true, library.ShelvesFull());
        }

        [Test]
        public void TestCanEmptyShelves()
        {
          library.AddItem(book);
          library.ClearShelves();
          Assert.AreEqual(0, library.ItemCount());
        }
    }
}