using System;
using NUnit.Framework;

namespace Library
{
    [TestFixture]
    public class LibraryTest
    {
        Library library;

        [SetUp]
        public void Init()
        {
            library = new Library("CC Library", 10);
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
    }
}