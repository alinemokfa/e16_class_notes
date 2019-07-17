# Enums

### Objectives

- Know what an enum is
- Know how to use an enum

### Duration - 45 mins

# Intro

Previously, we have often used "magic strings" to represent sets of possible properties. For example, our bank account might be "personal" or "business". An order status might be "received", "dispatched" or "processing".

Let's have a look at an example

> Give out the starter code

Let's add another test.

```csharp
//AccountTest.cs

[Test]
public void TestTypeCanBeMispelled()
{
    account = new Account("Bussiness");
    Assert.AreEqual("Bussiness", account.Type);
}
```

If we were to write a method on our Bank to find an account of a given account type, it would match "Business" but not "Bussiness". What if we added it as lowercase, uppercase? It becomes a nightmare.

Let's try another little test.

```csharp
//AccountTest.cs

[Test]
public void TestTypeCanBeBanana()
{
    account = new Account("Banana");
    Assert.AreEqual("Banana", account.Type);
}
```

Uh, we've managed to set Banana as the type of the account... that's not great either. Accounts don't tend to be Banana.

If we use strings, we can't stop users passing invalid values.

This is where enums come in. Enums allow us to define a set of possible values, and nothing outside of that set is permitted. This is great news for searching and stopping unexpected things happening.

```bash
# terminal 
touch AccountType.cs
```

```csharp
//AccountType.cs

namespace EnumExample {
  public enum AccountType
  {
    Business,
    Personal
  }
}
```

The "enum" keyword sits where we used to declare a class. An enum is different, it has no properties and (usually :/) no methods like we had before. It simply acts as a container of values we can use.

We tend to Capitalise the value names.

Let's refactor our Account to use the AccountType enum.

```csharp
//Account.cs

namespace EnumExample {
  public class Account {
  
    private AccountType type; //UPDATED
  
    public AccountType Type   //UPDATED
    {
      get { return this.type; }
      set { this.type = value; }
    }
  
    public Account(AccountType type)  //UPDATED
    {
      this.type = type;
    }
  
  }
}
```

Now our tests won't compile, because we are throwing around strings all over the place. We've got a bit of work to do. Let's comment out the banana and mispell test for now.

```csharp
//AccountTest.cs

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
```


Let's go about fixing our test. We need to use our Enum instead of the string, since an enum declares a new type, in our case AccountType. AccountType is it's own thing, not a string or an int or an Account. Just like a class behaves.

To use our shiny new enum, we need to use the enum name then the key we want to access.

```csharp
//AccountTest.cs

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
            Assert.AreEqual( "Business", account.Type );
        }

        // same as before
        
    }
}
```


This will still fail, since our test is comparing it with the string "business". One way to fix this is to call ToString() on the value, but this negates the point of using an enum. We can actually just compare Enum values directly using the type itself.

```csharp
//AccountTest.cs

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
        public void TestType()
        {
            Assert.AreEqual(AccountType.Business, account.Type); //UPDATED
        }

        // same as before
        
    }
}
```

Cool we are all good!

Enums are extremely powerful for giving us more control over our code and what gets passed to our methods.

[TASK:] Create an enum for account status (e.g. Open, Closed, Dormant) that can be passed to the account