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
            account = new Account(AccountType.Business);
        }

        [Test]
        public void TestCanGetType()
        {
            Assert.AreEqual(AccountType.Business, account.Type);
        }

        // [Test]
        // public void TestTypeCanBeMispelled()
        // {
        //     account = new Account("Bussiness");
        //     Assert.AreEqual("Bussiness", account.Type);
        // }

        // [Test]
        // public void TestTypeCanBeBanana()
        // {
        //     account = new Account("Banana");
        //     Assert.AreEqual("Banana", account.Type);
        // }
    }
}