# Composition

## Objectives

- Understand how to compose objects using interfaces

## Intro

We've seen how Interfaces are awesome and allow us to give our objects superpowers. We're going to look at this a bit more in depth today and how we can use the power of 'composition' to make our objects very flexible.

>: Give out starter code.

Get the students to read it for 45 mins to an hour.

### Code runners
Now that we have multiple tests and our classes in different files our build process becomes more complicated.  Later, you will see a development environment that will take care of the build for us, for now there is a shell script we use to build the files.  Don't worry about the internals of this file.

To build the files:
```zsh
#terminal

zsh build.sh
```

To run the tests:
```zsh
#terminal

nunit Program.exe
```

> n.b. Starter code contains abstract classes

The students should:
- draw a diagram of the classes and how they are related.
- figure out how to build the code and run the tests

## The problem

Key point:

We want the wizard to fly a dragon. Or a magic carpet. Or anything that flies and he feels confident climbing on.

- Pair up and discuss it

Possible solutions:
- Common superclass for flying types? Nope, already existing class heirarchy so it doesn't make sense.
- Ancestor for all objects? We don't want everything to fly!
- Multiple inheritance? It's not supported and there's all sorts of issues. If two superclasses have the same method, which does it use?

We want a common set of abilities that our things can do without polluting their class heirarchy which things that don't concern it.

More than that, we don't want this magical thing to have any clue about that behaviour, just to make sure that it exists on our object. A dragon NEEDS to fly, a magic carpet NEEDS to fly but we don't want our structure to care HOW they fly.

## Interfaces to the rescue

To solve our problem we are going to

- Add a flyable interface, IFly
- Dragon, Magic Carpet, Broomstick all implement it
- Change to IFly in the wizard

First things first, let's add the IFly interface.

```bash
# terminal

mkdir behaviours #same level as wizard_management
touch behaviours/IFly.cs
```

We also now need to change our build script so it compiles code in this new directory:

```bash

mcs -reference:nunit.framework.dll  Main.cs wizard_management/*.cs wizard_management_specs/*.cs behaviours/*.cs //MODIFIED
```

```csharp
//IFly.cs

namespace Behaviours {
  public interface IFly {
    string Fly();
  }
}
```

Now, we need to make our Dragon and Broomstick implement it.

```csharp
//Dragon.cs
using Behaviours; //ADDED

namespace WizardManagement {
  public class Dragon : MythicalBeast, IFly { /* UPDATED */ }
}
```

```csharp
//Broomstick.cs

using Behaviours; //ADDED

namespace WizardManagement {
  public class Broomstick : CleaningImplement, IFly { /*UPDATED */ }
}
```

We already have tests to see if these things fly, so if we run them they should all still pass.

Let's now add the test for flying the Dragon.

```csharp
//WizartTest.cs

[Test]
public void CanFlyDragon()
{
  Dragon dragon = new Dragon("Tilly");
  wizard = new Wizard("Toby", dragon);
  Assert.AreEqual("Standing up tall, beating wings, lift off!", wizard.Fly());
}
```

If we build this, we will see an error "Incompatible types: Dragon cannot be converted to Broomstick". This is quite correct, a Dragon and Broomstick are completely unrelated and we are passing a Dragon to a method which is expecting a Broomstick. We need to change this to be IFly in the method signature.

```csharp
//Wizard.cs

using Behaviours; //ADDED

namespace WizardManagement
{
  public class Wizard
  {
    private string name;
    private IFly ride; //MODIFIED

    public string Name 
    {
      get { return name; }
      set { name = value; }
    }

    public IFly Ride //MODIFIED
    {
      get { return ride; }
      set { ride = value; }
    }
    
    public Wizard(string name, IFly ride) //MODIFIED
    {
      this.name = name;
      this.ride = ride;
    }

    public string Fly()
    {
      return this.ride.Fly();
    }
  }
}
```

Since we have changed the name of getBroomstick, we need to go update our test. We'll need to use our new casting powers we gained yesterday!

```csharp
//WizardTest.cs

[Test]
public void HasBroomstick()
{
  Broomstick ride = (Broomstick) wizard.Ride;
  Assert.AreEqual("Nimbus", ride.Brand);
}
```

Whoot! We have successfully ridden a dragon. Let's see if he can fly a magic carpet.

```csharp
//WizardTest.cs
[Test]
public void CanFlyMagicCarpet(){
  MagicCarpet carpet = new MagicCarpet("Purple");
  wizard = new Wizard("Toby", carpet);
  Assert.AreEqual("Hovering up, straightening out, flying off!", wizard.Fly());
}

```

This fails, since MagicCarpet is not an IFly. Let's go fix that!

```csharp
//MagicCarpet.cs

using Behaviours; //ADDED

namespace WizardManagement {
  public  class MagicCarpet : Carpet, IFly { /*UPDATED */ }
}
```

## Strategy Pattern

Wouldn't it be nice if we could set the ride on the wizard? Then on the same instance of a wizard we could swap out the broomstick for a dragon and vice versa. We are no longer tied to one ride for the life of the wizard object.

```csharp
//WizardTest.cs

[Test]
public void CanSetRide()
{
  Dragon dragon = new Dragon("Erik");
  wizard.Ride = dragon;
  Assert.AreEqual("Standing up tall, beating wings, lift off!",wizard.Fly());
}
```

This is a fairly easy change.

```csharp
//Wizard.cs

public IFly Ride
{
  get { return ride; }
  set { ride = value; } //ADDED
}

```

This ability to set the behaviour of the wizard's fly method (using the setter) is an example of an architectural pattern. In this case, it's the Strategy Pattern. That is, we know our wizard can `fly` and by setting the `IFly` object that they ride, we can change the 'strategy' they use to do so.

e.g. `save` method, with `Storage` interface, so can either `save` to cloud or to hard drive, by using a `setStorage` method.