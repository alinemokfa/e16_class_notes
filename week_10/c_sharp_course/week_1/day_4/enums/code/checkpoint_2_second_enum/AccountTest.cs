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
            account = new Account(AccountType.Business, AccountStatus.Open);
        }

        [Test]
        public void TestType()
        {
            Assert.AreEqual(AccountType.Business, account.Type);
        }

        [Test]
        public void TestCanGetType()
        {
            Assert.AreEqual(AccountType.Business, account.Type);
        }

        [Test]
        public void TestCanGetStatus()
        {
            Assert.AreEqual(AccountStatus.Open, account.Status);
        }

        [Test]
        public void TestCanSetStatus()
        {
            account.Status = AccountStatus.Closed;
            Assert.AreEqual(AccountStatus.Closed, account.Status);
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