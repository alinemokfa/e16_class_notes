using System;
using NUnit.Framework;

namespace EnumExample
{
    [TestFixture]
    public class AccountTest
    {
        Account account;

        [SetUp]
        public void Init()
        {
            account = new Account("Business");
        }

        [Test]
        public void TestCanGetType()
        {
            Assert.AreEqual( "Business", account.Type );
        }
    }
}