# Array Lists

### Learning Objectives
- Know what an ArrayList is
- Understand the difference between an ArrayList and a basic array
- Be able to create ArrayLists, and add and remove items from them

## Intro

We've looked at basic arrays and let's be honest, they were a lot of work. We've been used to using the power of Ruby arrays to help us manipulate our data. 
So what is the alternative in Java? The ArrayList!

### Arraylists 

ArrayLists are much more similar to what we have seen before, complete with methods to help us out. They do have their own little quirks though, as always.

Let's rework our bear and bask in the glory of ArrayLists.

## Declaring an array list

First we need to tell our code that we want to use this class, in a similar way that we use require in Ruby.

``` java
//Bear.java
import java.util.*;
```

Yep, ArrayLists live in the java.util "namespace". Namespaces are just a way of bundling up code, like Ruby modules. Util is indeed a shocking name and it should really be "collections" or something. Don't be like Java. Don't call stuff util, or utils. For me. Please.

We can now update all of our code to use this shiny new collection.

``` java
//Bear.java
public class Bear {
  private String name;
  private ArrayList<Salmon> belly; //UPDATED

  public Bear(String name){
    this.belly = new ArrayList<Salmon>(); //UPDATED
    this.name = name;
  }
}
```

This looks a little weird, but we need a way to tell the ArrayList what it can contain and we use the angular brackets to do this.

Notice we don't need to give it a size anymore. Which is good news for mister Bear, since he can now eat as much as he wants.

## Counting the items

We want to see how much food is in the bear's belly - initially it should be zero.

Let's write the test

```java
//BearTest.java

@Test
public void bellyStartsEmpty(){
  assertEquals(0, bear.foodCount());
}
```

We now have to use a size() method instead of length, which is super helpful.

``` java
//Bear.java
public int foodCount(){
  return belly.size();
}
```

Our eat and sleep methods are about to become beautiful.

## Eating a salmon

Let's try to get our bear to eat a salmon. First, let's add a test salmon to our unit tests.

```java
//BearTest.java
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BearTest {
  Bear bear;
  Salmon salmon; //NEW

  @Before
  public void before(){
    bear = new Bear("Baloo");
    salmon = new Salmon(); //NEW
  }
  //same as before
 }
 ```

 Cool, now we can use this salmon in our tests.

```java
 //BearTest.java

 @Test
 public void canEatSalmon(){
   bear.eat(salmon);
   assertEquals(1, bear.foodCount());
 }
 ```

 Let's add the eat() method.


``` java
//Bear.java

public void eat(Salmon salmon){
  belly.add(salmon);
}
```

Resetting the array

Lastly, let's add a way for our Bear to go to sleep and let his belly settle.

```java
//BearTest.java

@Test
public void shouldEmptyBellyAfterSleeping(){
  bear.eat(salmon);
  assertEquals(bear.foodCount(), 1);
  bear.sleep();
  assertEquals(bear.foodCount(), 0);
}
```

And lets add the sleep method in the bear class.

```java
//Bear.java

public void sleep(){
  belly.clear();
}
```

So, ArrayLists are resizeable and they have useful methods, like `add()`` and `remove()`` you will find in the documentation which are worth having a little look at. However ArrayLists don't take take primitive types. If we want to make an `ArrayList` of numbers we would need to use the `Integer` class, rather than ints.




