> ## How to Install Mockito on a Mac
>
> Mockito should be installed on a CodeClan laptop already, but if not, you will see `package org.mockito does not exist` errors when you compile. Use the following steps to install it:
>
> - Go to this link and download the latest stable Mockito jar:
>   - http://mvnrepository.com/artifact/org.mockito/mockito-all
> - Move the downloaded jar file to `~/junit`
> - Open `~/.zshrc` in an editor
> - Cmd + F for `CLASSPATH`, should be around line 95.
> - Add `$JUNIT_HOME/name-of-mockito-file.jar` to the `CLASSPATH` string
>   - e.g. `export CLASSPATH="$CLASSPATH:$JUNIT_HOME/junit-4.11.jar:$JUNIT_HOME/hamcrest-core-1.3.jar:$JUNIT_HOME/mockito-all-1.10.19.jar"`

# Advanced Testing

## Objectives
  - Know what mocks and stubs are
  
  - Understand how mocking and stubbing can help us control randomness and simplify tests
  
  - Be able to use mocks and stubs to write unit tests


#### Adding Mockito to Android Studio.

Create project and open build.gradle(module app)

Add following line:

```
dependencies {
    ...
  testCompile 'junit:junit:4.12'
  testCompile "org.mockito:mockito-core:1.9.5" #NEW
}
```

- You may need to clean project after this if it doesn't find mockito in test file.
build > clean project.


## Advanced Testing

So far, we have learned that coding to interfaces instead of concrete classes is a Good Thing and it makes our lives easier and happier. We've mentioned a few times that it really helps us for testing too, but we haven't really had a close look at this. We're going to do this today.

> Give out starter code

We have a really silly game here, which simply rolls a dice and if the result is greater than 2 it returns success for that turn. Whoot. Super.

If we compile this and try to run the unit tests, we are going to have a problem. 

First of all we need to add Mockito to our gradle file. 

```
gradle.build

testCompile 'junit:junit:4.12',
testCompile 'org.mockito:mockito-core:[version_number]'
}

```

Now when we run tests sometimes the test passes, and sometimes the test fails. Why?

The randomness is not being controlled. Sometimes it will roll greater than 2, and sometimes not. How can we deal with this? Luckily, we have a few weapons at our disposal.

### A new class

The most basic way we can fix our problems is through the use of a new class that implements Rollable, but always returns a fixed result from roll() that we control.
Lets add a new class to the main package called FakeDice.

```
#Android Studio
Create a new class in main package called FakeDice.java
```

```java

//FakeDice.java
public class FakeDice implements Rollable {

  int numberOfSides;

  public FakeDice(int numberOfSides) {
    this.numberOfSides = numberOfSides;
  }

  public int roll(){
    return 3;
  }
}
```

We now need to change our test to use this 'fake' dice:

```java
//GameTest.java

@Before
public void before(){
  dice = new FakeDice(6); //UPDATED
  game = new Game(dice);
}

```

Cool, now our test will always pass. We could also achieve the same thing by subclassing from our Dice object and overriding the offending method.

But what if we want to test when the test fails? Our dice always returns 3... we'd have to make a new class like FakeDiceReturn2 which is hideous!

Stubs to the rescue!

## Stubs

When we are testing, we can use stubbing to also give us more control over random behaviour, or to force a certain path through our program.

JUnit is the testing framework we have been using so far, and it doesn't support stubbing out of the box. Enter Mockito, the Java stubbing and mocking (more on this later) framework.

First we need to import the Mockito functionality into our tests.

```java
//GameTest.java
import org.mockito.*;
import static org.mockito.Mockito.*;
```

Cool now we can use this library.

Using a stub means that we can use our class just like we normally would, no need for a FakeDice, no need to Subclass Dice or implement a new Rollable to use. However, stubbing let's us override a methods return value as we need to, as many times as we like.

``` java
//GameTest.java

Game game;
Rollable spyDice; //UPDATED

@Before
public void before(){
  Rollable dice = new Dice(6); //NEW (local)
  spyDice = Mockito.spy(dice); //NEW
  game = new Game(spyDice); //NEW
}


@Test //DELETED
public void testTakeTurn(){
  boolean result = game.nextTurn();
  assertEquals(true, result);
}
```

We are putting our dice into a wrapper (a "spy") and then passing that to our game. This wrapper has given our Dice some new super powers! Now, we can alter it's return values for specific methods, while leaving the rest of the class untouched. It's called a "spy" because it spies on method calls, and can intercept and override them.

``` java
// GameTest.java
@Test
public void testTakeTurnFailureStub(){
  Mockito.when(spyDice.roll()).thenReturn(2);

  boolean result = game.nextTurn();
  assertEquals(false, result);
}
```

Because we have made a "spy" for our dice, it can intercept method calls and override the return value. Which is super cool! Now it's really easy to write the success version.

``` java
//GameTest.java
@Test
public void testTakeTurnSuccessStub(){
  Mockito.when(spyDice.roll()).thenReturn(3);

  boolean result = game.nextTurn();
  assertEquals(true, result);
}
```

## Mocking

In the last example we created a "spy" for our dice. What this is actually doing is partially mocking a portion of the dice class that we want to control... the roll() function. We are now going to look at creating a full "mock" dice using the mock() functionality of Mockito.

 Mocking is when we don't care about the actual object, we want to just pass it to the class we are testing and forget about it. We don't care what the implementation is, but we need to provide an instance of a class as a dependency to make another object actually work.

Let's slightly modify our Game

``` java
//Game.java
public class Game {
  Rollable dice;
  private int turnCount; //NEW

  public Game(Rollable dice) {
    this.dice = dice;
    this.turnCount = 0; //NEW
  }

  public boolean nextTurn(){
    int result = dice.roll();
    this.turnCount++; //NEW
    return result > 2;
  }

  public int getTurnCount() {
    return this.turnCount;
  }
}

```

We've added a little property to track how many turns have passed in our game. Now, we want to test that this property is incremented every time, and we don't care what happens with the dice. However, we still need to pass the game a valid Dice object to be able to use it. That's sad, we need to new one up, even though we don't care about it.

This is fine, when it's just a silly Dice. But imagine it was something with an active database connection, or making a real api call etc. We don't want all of that to happen in a test, that would make us sad. This is where Mocking comes in.

``` java
//Game
@Test //NEW
public void takeTurnMock(){
  Rollable diceMock = mock(Rollable.class);
  game = new Game(diceMock);  

  game.nextTurn();

  assertEquals(1, game.getTurnCount());
}
```

We've allowed Mockito to make a dumb object based on Dice, that we don't care about. We can do our test, and move on. We didn't need to new it up, or do anything with it. This would allow us to make a DatabaseConnection or API call or whatever we want, that did absolutely nothing and affected nothing outside of our test.

Mocks also have another super power.

``` java
@Test
public void takeTurnMock(){
  Rollable diceMock = mock(Rollable.class);
  game = new Game(diceMock);  

  game.nextTurn();

  assertEquals(game.getTurnCount(), 1);
  verify(diceMock, times(1)).roll(); //NEW
}

```

We can verify that a given a method was called, even though we don't care what it did. So for methods that are void return type, we can still track they got called. This is great for things like myObject.save() etc where we want to confirm that it actually happened.
