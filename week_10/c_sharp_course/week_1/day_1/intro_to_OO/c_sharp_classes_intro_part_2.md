# OO Intro - Part 2

## Getters and Setters

As we have seen, instance variables are ```private```, so we cannot access them from outside the object. But this means our test is failing since we cannot see the bank account's ```name```

So how do we fix this? One way would be to declare the instance variables as ```public```, like the constructor method. This however is not good practice as it means we are allowing direct access to the instance variables through the object. This means that other objects can get unrestricted access to an object's state and alter it - which is dangerous and risky.

By convention, the state of an object (the instance variables) should only be altered by the objects behavior (the instance methods).

### Getters

In order to access our instance variables, we need to create "getter" methods. This allows us to give people access to the properties, but they cannot update them. Let's add a getter for the name.

```csharp
//BankAccountTest.cs

namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    ... 

    public string GetName() {  //ADDED
      return this.name;        //ADDED
    }                          //ADDED
  }
}
```


```csharp
//BankAccountTest.cs

[Test]
public void TestHasName()
{
    BankAccount account = new BankAccount("John",500, "business");
    Assert.AreEqual( "John", account.GetName() ); //MODIFIED
}
```

Now our test will pass, since we have allowed access to our object's name. Let's do the same for a bank account's amount and type:

> [Task:] Write getters for the amount and the type of account, with tests first.

```csharp
//BankAccountTest.cs

using System;
using NUnit.Framework;

namespace Bank
{
    [TestFixture]
    public class BankAccountTest
    {

      [Test]
      public void TestHasName()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "John", account.GetName() );
      }

      [Test]
      public void TestHasAmount()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( 500, account.GetAmount() ); 
      }

      [Test]
      public void TestHasType()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "business", account.GetType() ); 
      }
    }
}

```

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    public BankAccount(string name, int amount, string type) {
      this.name = name;
      this.amount = amount;
      this.type = type;
    }

    public string GetName() {
      return this.name;
    }

    public int GetAmount() {
      return this.amount;
    }

    public string GetType() {
      return this.type;
    }
  }
}
```

### Setters

Equally, we can write methods to set the value of our properties. We call these "setters". Let's add a setter.

We'll start, as usual, by writing our test:

```csharp
//BankAccountTest.cs

[Test]
public void TestCanSetName()
{
    BankAccount account = new BankAccount("John",500, "business");
    account.SetName("Tony");
    Assert.AreEqual( "Tony", account.GetName() );
}

```

If we compile this, then we will get a error saying that `Bank.BankAccount' does not contain a definition for `SetName'. Let's sort that:

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    public BankAccount(string name, int amount, string type) {
      this.name = name;
      this.amount = amount;
      this.type = type;
    }

    ...

    public void SetName(string name) { //ADDED
      this.name = name;                //ADDED
    }                                  //ADDED
  }
  
}

```

And we can write setters for the account amount and type:

> [Task:] Make setters for the value and type.

```csharp
//BankAccountTest.cs

using System;
using NUnit.Framework;

namespace Bank
{
    [TestFixture]
    public class BankAccountTest
    {

      [Test]
      public void TestHasName()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "John", account.GetName() );
      }

      [Test]
      public void TestHasAmount()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( 500, account.GetAmount() ); 
      }

      [Test]
      public void TestHasType()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "business", account.GetType() ); 
      }

      [Test]
      public void TestCanSetName()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.SetName("Tony");
          Assert.AreEqual( "Tony", account.GetName() );
      }

      [Test]
      public void TestCanSetAmount()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.SetAmount(1000);
          Assert.AreEqual( 1000, account.GetAmount() );
      }

      [Test]
      public void TestCanSetType()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.SetType("personal");
          Assert.AreEqual( "personal", account.GetType() );
      }

    }
}
```

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    public BankAccount(string name, int amount, string type) {
      this.name = name;
      this.amount = amount;
      this.type = type;
    }

    public string GetName() {
      return this.name;
    }

    public int GetAmount() {
      return this.amount;
    }

    public string GetType() {
      return this.type;
    }

    public void SetName(string name) {
      this.name = name;
    }

    public void SetAmount(int amount) {
      this.amount = amount;
    }

    public void SetType(string type) {
      this.type = type;
    }
  }

}
```

## Getter / Setter method shortcuts

I'm sure you will agree that it is getting a bit tedious by now, adding the methods for getting and setting properties. The good news is that C# provides us with a shortcut we can use - ___properties___.

We can delete our name getters and setters, and replace them with this at the top of the file.

```csharp
//BankAccount.cs

public string Name {
  get
  {
      return this.name;
  }
  set
  {
      this.name = value;
  }
}
```

The really cool thing about properties is that, rather than using method calls like we were doing previously, we can now access the properties almost as if we were accessing the properties directly. For example, our test for the getter can now be changed to:

```csharp
//BankAccountTest.cs

[Test]
public void TestHasName()
{
    BankAccount account = new BankAccount("John",500, "business");
    Assert.AreEqual( "John", account.Name ); //MODIFIED
}
```

Likewise the test for our setter can now be changed to:

```csharp
//BankAccountTest.cs

[Test]
public void TestCanSetName()
{
    BankAccount account = new BankAccount("John",500, "business");
    account.Name = "Tony";                   //MODIFIED
    Assert.AreEqual( "Tony", account.Name ); //MODIFIED
}
```

> Note the use of the '=' to set the name.

Let's do the same for all our properties:

>[Task:] Convert the other getters and setters to use properties
```csharp
//BankAccountTest.cs

using System;
using NUnit.Framework;

namespace Bank
{
    [TestFixture]
    public class BankAccountTest
    {

      [Test]
      public void TestHasName()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "John", account.Name );
      }

      [Test]
      public void TestHasAmount()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( 500, account.Amount ); 
      }

      [Test]
      public void TestHasType()
      {
          BankAccount account = new BankAccount("John",500, "business");
          Assert.AreEqual( "business", account.Type ); 
      }

      [Test]
      public void TestCanSetName()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.Name = "Tony";
          Assert.AreEqual( "Tony", account.Name );
      }

      [Test]
      public void TestCanSetAmount()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.Amount = 1000;
          Assert.AreEqual( 1000, account.Amount );
      }

      [Test]
      public void TestCanSetType()
      {
          BankAccount account = new BankAccount("John",500, "business");
          account.Type = "personal";
          Assert.AreEqual( "personal", account.Type );
      }

    }
}
```

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    public string Name {
      get
      {
          return this.name;
      }
      set
      {
          this.name = value;
      }
    }

    public int Amount {
      get
      {
          return this.amount;
      }
      set
      {
          this.amount = value;
      }
    }

    public string Type {
      get
      {
          return this.type;
      }
      set
      {
          this.type = value;
      }
    }

    public BankAccount(string name, int amount, string type) {
      this.name = name;
      this.amount = amount;
      this.type = type;
    }
    
  }
}
```

## Further Behaviour - not a setter

Let's define some further behaviour on the BankAccount, where we can update the value of the account.

```csharp
//BankAccountTest.cs

[Test]
public void TestCanPayIntoAccount()
{
    BankAccount account = new BankAccount("John",500, "business");
    account.PayIn(50);
    Assert.AreEqual( 550, account.Amount );
}

```

If we try to compiler this, the test will fail and say it can't find the method 'PayIn'. Which is correct, we need to go and add this to our class.

```csharp
//BankAccount.cs

public void PayIn(int amount)
{
  this.amount += amount;
}

```

This is not a setter or a getter, it's not simply updating the value or retrieving the value. It's modifying it with some logic.

## Conditional state

We sometimes want instances to behave slightly differently depending on their state (instance variables). Let's make a little pay monthly method, which subtracts 50 off the value of the account.

> [Task:] Make a pay_monthly_fee method, which reduces the value of the account by 50. Write the test first.

```csharp
//BankAccountTest.cs

[Test]
public void TestMonthlyFee()
{
    BankAccount account = new BankAccount("John",500, "business");
    account.PayMonthlyFee();
    Assert.AreEqual( 450, account.Amount );
}
```

```csharp
//BankAccount.cs

public void PayMonthlyFee()
{
  this.amount -= 50;
}
```

Our bank account currently isn't very fair, since personal users pay the same fee as a business user. Change the monthly fee method to deduct only 10 for a personal account, and 50 for a business account. You will need to update the tests.

>[Task:] Take a few minutes to do this

```csharp
//BankAccountTest.cs

[Test]
public void TestMonthlyFeeBusiness()
{
    BankAccount account = new BankAccount("John",500, "business");
    account.PayMonthlyFee();
    Assert.AreEqual( 450, account.Amount );
}

[Test]
public void TestMonthlyFeePersonal()
{
    BankAccount account = new BankAccount("John",100, "personal");
    account.PayMonthlyFee();
    Assert.AreEqual( 90, account.Amount );
}
```

```csharp
//BankAccount.cs

public void PayMonthlyFee()
{
  if (this.type.Equals("business")) 
  {
    this.amount -= 50;
  } else if (this.type.Equals("personal"))
  {
    this.amount -= 10;
  }
}
```