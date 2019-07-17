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

```java
//RingTest.java

@Test
public void metalCanBeMispelled(){
  ring = new Ring("Golllld");
  assertEquals("Golllld", ring.getMetal());
}
```

If we were to write a method on our Jewellery Store to find a ring of a given metal type, it would match "Gold" but not "Gollld". What if we added it as lowercase, uppercase? It becomes a nightmare.

Let's try another little test.

```java
//RingTest.java

@Test
public void metalCanBeBanana(){
  ring = new Ring("Banana");
  assertEquals("Banana", ring.getMetal());
}
```

Uh, we've managed to set Banana as the metal for the Ring... that's not great either. Rings don't tend to come in Banana... although that would be cool if you were hungry.

If we use strings, we can't stop users passing invalid values.

This is where enums come in. Enums allow us to define a set of possible values, and nothing outside of that set is permitted. This is great news for searching and stopping unexpected things happening.

```
#Android Studio 
Create a new class in jewellery folder called MetalType.java and set its type to enum from drop down. 

Right click > new > Java Class.
name class MetalType and in drop down change to Enum.

```

```java
//MetalType.java

public enum MetalType {
  GOLD,
  SILVER,
  PALLADIUM
}
```

The "enum" keyword sits where we used to declare a class. An enum is different, it has no properties and (usually :/) no methods like we had before. It simply acts as a container of values we can use.

We tend to use uppercase for the value names.

Let's refactor our Ring to use the MetalType enum.

```java
//Ring.java

public class Ring {

  private MetalType metal; //UPDATED

  public Ring(MetalType metal) { //UPDATED
    this.metal = metal;
  }

  public MetalType getMetal(){ //UPDATED
    return this.metal;
  }

}
```

Now our tests won't compile, because we are throwing around strings all over the place. We've got a bit of work to do. Let's comment out the banana and misspell test for now.

```java
//RingTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class RingTest {

  Ring ring;

  @Before
  public void before(){
    ring = new Ring("Gold");
  }

  @Test
  public void canGetMetal(){
    assertEquals("Gold", ring.getMetal());
  }

  // @Test
  // public void metalCanBeMispelled(){
  //   ring = new Ring("Golllld");
  //   assertEquals("Golllld", ring.getMetal());
  // }

  // @Test
  // public void metalCanBeBanana(){
  //   ring = new Ring("Banana");
  //   assertEquals("Banana", ring.getMetal());
  // }

}
```

Let's go about fixing our test. We need to use our Enum instead of the string, since an enum declares a new type, in our case MetalType. MetalType is it's own thing, not a String or an int or a Ring. Just like a class behaves.

To use our shiny new enum, we need to use the enum name then the key we want to access.

```java
//RingTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class RingTest {

  Ring ring;

  @Before
  public void before(){
    ring = new Ring(MetalType.GOLD); //UPDATED
  }

  @Test
  public void canGetMetal(){
    assertEquals("Gold", ring.getMetal());
  }

  // same as before

}
```

This will still fail, since our test is comparing it with the string "gold". One way to fix this is to call toString() on the value, but this negates the point of using an enum. We can actually just compare Enum values directly using the type itself.

```java
//RingTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class RingTest {

  Ring ring;

  @Before
  public void before(){
    ring = new Ring(MetalType.GOLD);
  }

  @Test
  public void canGetMetal(){
    assertEquals(MetalType.GOLD, ring.getMetal()); //UPDATED
  }

  // same as before

}
```

Cool we are all good!

Enums are extremely powerful for giving us more control over our code and what gets passed to our methods.

[TASK:] Create an enum for gem types that can be passed to the ring
