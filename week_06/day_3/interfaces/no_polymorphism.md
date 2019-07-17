# A World Without Polymorphism

### Learning Objectives

- Understand method overloading
- Understand the need for polymorphism

## Intro

Our bear is getting a bit bored of eating Salmon. He's spotted a nice village and he's become quite interested in eating humans.

Our human is going to be a bit boring and can do nothing but speak.

Lets create a new Human class in main package.

```
#Android Studio

Open the Bear River Fish program and create a new file called Human in the main package. (example.com.codeclan.yourProgramName) 
```

```java
//Human.java

public class Human {

	public String speak(){
    	return "speaking";
  	}
}
```

## Method overloading

Now, we have a bit of a problem. Our belly can only hold Salmon, and we want to eat Humans. Also, our eat method can only take a Salmon.

[TASK:] Have a go at finding a solution to the problem. 15 mins.

Cool, so let's have a look at a really crude solution to this problem.

```java
//BearTest.java

  Bear bear;
  Salmon salmon;
  Human human; //NEW

  @Before
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon();
    human = new Human(); //NEW
  }

  @Test
  public void canEatHuman(){
    bear.eat(human);
    assertEquals(1, bear.foodCount());
  }
```

So we currently have a compiler error, since we can't pass a Human type to a method which is expecting a Salmon. The easiest way to fix this is `method overloading`. This is where we can define a method with the same name, but different parameters.

```java
//Bear.java

  public void eat(Human human){
    belly.add(human);
  }
```
We have a new problem, since our belly only accepts Salmon! The easiest way to fix this is to declare a new ArrayList to hold humans and to change our old ArrayList's name to reflect that it is, indeed, a belly for Salmon.

We'll have to change all our references to belly to bellySalmon in order for it to compile.

```java
//Bear.java

public class Bear {
  private String name;
  private ArrayList<Salmon> bellySalmon; // UPDATE
  private ArrayList<Human> bellyHuman; //NEW

  public Bear(String name){
    this.bellySalmon = new ArrayList<Salmon>(); //UPDATE
    this.bellyHuman = new ArrayList<Human>(); //NEW
    this.name = name;
  }

  public void eat(Salmon salmon){
    bellySalmon.add(salmon); //UPDATED
  }

  public void eat(Human human){
    bellyHuman.add(human); //UPDATED
  }  

 }
```

In order to make all our test pass, we have to change our foodCount method, so it adds up the amount of food in the bellySalmon and bellyHuman.

```java
//Bear.java
public int foodCount(){
  return bellySalmon.size() + bellyHuman.size(); //UPDATE
}
```

Now our test should pass. If we slightly modify our test for emptying the belly after a good sleep, we have a wee problem to fix.

```java
//BearTest.java

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon);
    bear.eat(human);
    bear.sleep();
    assertEquals(0, bear.foodCount());
  }
```
The belly still has 1 item in it! Let's go fix this.
Lastly, we need to fix the sleep method.

```java
//Bear.java

  public void sleep(){
    bellySalmon.clear(); //UPDATED
    bellyHuman.clear(); //UPDATED
  }
```

Now our tests should pass. Phew! That was a LOT of work.

## It's a bit stinky

So this has indeed solved our problem. But now we have 2 separate collections for different food types. What happens if the bear decides to eat goats, or chickens, or nuts, or a cheeseburger?? Are we going to make new collections and new method overloads every time?

Luckily, there is a better way. Polymorphism to the rescue!!
