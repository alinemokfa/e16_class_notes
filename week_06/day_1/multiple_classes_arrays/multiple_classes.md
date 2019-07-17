# Basic Arrays

### Learning Objectives

- Know how to create a basic array
- Understand two kinds of for loop
- Understand `null`
- Be able to use arrays in Java

## Intro

In this lesson we are going to have a look at the most basic Java collection - the Array. We've encountered before and now we are going to see how they work in Java. They are exactly the same in principle - a container to hold a set of items.

In Ruby and many other dynamically typed languages, we could put a mixture of things into an array:

``` ruby
# irb
myArray = [1,2,3,"banana", true];
```
In Java world, we can't do this. We're going to have a look at why this is the case in this lesson.

> Give out starter code

If you have a look at the code, we have one class - Bear. This can have a name, and we have a little test to confirm this works.

Notice that we have a "Before" method, which is like our setup() method in Ruby's MiniTest, it runs before our tests so we can set up the objects we want to test.

## Array Initialization

At some point, our little bear here is going to get hungry. He quite likes to eat Salmon, so let's make a little salmon class.

``` bash
# terminal
touch Salmon.java
```

``` java
//Salmon.java
public class Salmon {

}
```

Cool, we've got a little salmon. Now, our bear is going to want to eat a salmon, and to do this he's going to need to be able to get food into his tummy.

``` java
//Bear.java
public class Bear {
  private String name;
  private Salmon[] belly; //NEW

  //same as before
}

```

We need to declare the type of things that go into the array, followed by square brackets then the name of the array variable. This means that Salmon and ONLY Salmon can be kept in this array.

We've declared the variable, but now we need to initialize it in the constructor.

``` java
//Bear.java
public Bear(String name){
  this.name = name;
  this.belly = new Salmon[5]; //UPDATED
}
```

We need to give the array a size and it can only be of this length. If we try to add more than five items, we will get an error.

The array is not empty - it is already populated with 5 null entries. This will become important later.

## Counting the items

We want to see how much food is in the bear's belly - initially it should be zero.

Let's write the test

``` java
//BearTest.java
@Test
public void bellyStartsEmpty(){
  assertEquals(0, bear.foodCount());
}
```

Bearing in mind (Bearing!!! Get it?!) that our array is not empty - it's full of 5 null values, how can we count how many items are in the bear's belly.

> Let the students have a think about it for 2 minutes

## ForEach (enhanced) loops

For loops over collections look a little strange in Java.

The standard for loop for collections is fine but JDK 1.5 introduced a new for loop known as for each loop or enhanced for loop, which enables you to traverse the complete array sequentially without using an index variable.

The syntax for this is

```
for (Type variable : collection) {
  //do something for each variable in the collection
}
```

So out collection is an array called belly and our Type is Salmon as this is what the belly holds. The variable is just a reference to each Salmon in the belly in turn.

``` java
//Bear.java
  public int foodCount(){
    for(Salmon salmon : belly){

    }
  }
```
We're going to need some kind of count so let's add that.

``` java
//Bear.java
public int foodCount(){
  int count = 0;
  for(Salmon salmon : belly){

  }
  return count;
}
```
Lastly we only want to count those entries which are not null.

``` java
//Bear.java
  public int foodCount(){
    int count = 0;
    for(Salmon salmon : belly){
      if(salmon != null){
        count++;
      }
    }
    return count;
  }
```

Cool! We should now have a passing test.

## Eating a salmon

Let's try to get our bear to eat a salmon. First, let's add a test salmon to our unit tests.

``` java
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

``` java
//BearTest.java
@Test
public void canEatSalmon(){
  bear.eat(salmon);
  assertEquals(1, bear.foodCount());
}
```

Let's add the eat() method.

``` java
# Bear.java
public class Bear {
  //same as before

  public void eat(Salmon salmon){

  }
}
```

Now, there's is some bad news. There are no methods on a primitive array to help us out. We can't add(), pop(), push(), nothing. The only way to add an item is to set it explicitly by using an index position.

``` java
//Bear.java
public void eat(Salmon salmon){
  belly[0] = salmon;
}
```
What would happen if we left it like this? Yep, we'd only ever have one Salmon in our belly and the rest of the items would be null. How are we going to fix this?

> Let them think about it for a moment

One possible solution is to keep a counter everytime we add a Salmon, so that we know where the next Salmon should be added.

``` java
//Bear.java
 public void eat(Salmon salmon){
    int foodCount = foodCount();
    belly[foodCount] = salmon;
  }
```

## Index out of bounds

We do have a little problem, however. What happens if we try to add 6 fish to the bear's belly? Let's write a little for loop that adds a salmon 10 times to our bear's belly.

> Explain this `for`-loop.

``` java
//BearTest.java
@Test
public void cannotEatSalmonWhenBellyFull(){
  for(int i = 0; i<10; i++){
    bear.eat(salmon);
  }
  assertEquals(5, bear.foodCount());
}
```

A dirty great big exception! Our Array can only have 5 items and no more. When we try to add another one, the compiler throws a hissy fit.

First, we need a new unit test. We'll comment out the canNotEat etc one for now.

``` java
//BearTest

// @Test
// public void canNotEatSalmonWhenBellyFull(){
//   for(int i = 0; i<10; i++){
//     bear.eat(salmon);
//   }
//   assertEquals(5, bear.foodCount());
// }

@Test //NEW
public void bellyIsFull(){
  for(int i = 0; i<5; i++){
    bear.eat(salmon);
  }
  assertEquals(true, bear.isBellyFull());
}
```

Let's add a guard for when the bear's belly is full.

``` java
//Bear.java
public boolean isBellyFull(){
  return foodCount() == belly.length;
}

 public void eat(Salmon salmon){
  if (isBellyFull()) {
    return; //UPDATED
  }
  int foodCounter = foodCount();
  belly[foodCounter] = salmon;
}
```

Great now we can comment back in our test and it should be passing.

## Resetting the array

Lastly, let's add a way for our Bear to go to sleep and let his belly settle.

``` java
# BearTest.java
@Test
public void shouldEmptyBellyAfterSleeping(){
  bear.eat(salmon);
  bear.sleep();
  assertEquals(0, bear.foodCount());
}
```
How do you think we can do this?

> Give the students 2 mins to think it out

``` java
//Bear.java
public void sleep(){
  for(int i = 0; i < belly.length; i++){
    belly[i] = null;
  }
}
```

Well done, you have mastered primitive arrays!
