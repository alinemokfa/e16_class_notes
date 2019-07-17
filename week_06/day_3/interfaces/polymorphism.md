# Polymorphism to the rescue

### Learning Objectives

- Understand the power of polymorphism
- Use polymorphic methods and collections

# Intro

So we saw a solution to let the bear eat both Humans and Salmon. However, we weren't very happy with it since it wasn't very DRY and or scaleable.

We can solve all of our problems with "polymorphism". This isn't as scary as it sounds, it just means we can wrap our objects up in an enclosing type that defines a contract between them all.

Huh?

I know... let's just look at an example.

## Interfaces

Now, the natural thing to do might be to pull out a superclass. We are not going to do that. Inheritance is fraught with problems and we can quickly get into a mess. Luckily, statically typed languages offer us another construct we can use - interfaces.

An interface allows us to give a super power to our class. It gains the type of the interface without having a horrible inheritance chain. We can have as many interfaces as we like, too. Rather than just one super class.

Let's have an interface that both of our edible types implement from. Both a Human and a Salmon are edible.

> Give out starter code.

Lets create a new interface called Edible in the main package. 

```
#Android Studio

Create a new interface in the main package called Edible. 
```

```java
//Edible.java
public interface Edible {

}
```

We use this interface with the "implements" keyword.

```java
//Salmon.java
public class Salmon implements Edible {

  public String swim(){
    return "swimming";
  }
}
```

Let's do the same thing to the Human class.

> Give the students 2 mins to try it themselves

```java
//Human.java
public class Human implements Edible {

  public String speak(){
    return "speaking";
  }
}
```

Great. Now, in Ruby this didn't really mean much since we could pass anything to any method, and put anything we wanted into Arrays. In Java, this concept is extremely important. Our Salmon is both a Salmon AND an Edible. Our Human is both a Human AND an edible.

What does this mean for us though? Let's revist our bear's belly.

## Polymorphic collections

We can now delete some of our stinky code!

```java
//Bear.java

public class Bear {
  private String name;
  private ArrayList<Salmon> bellySalmon; //DELETED
  private ArrayList<Human> bellyHuman;

  public Bear(String name){
    this.bellySalmon = new ArrayList<Salmon>(); //DELETED LINE
    this.bellyHuman = new ArrayList<Human>();
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return bellySalmon.size() + bellyHuman.size(); //DELETED LINE
  }

  public void eat(Salmon salmon){ //DELETED FULL METHOD
    bellySalmon.add(salmon);
  }

  public void eat(Human human){
    bellyHuman.add(human);
  }

  public void sleep(){
    bellySalmon.clear(); //DELETED LINE
    bellyHuman.clear();
  }


}
```

After deletion:

```java
//Bear.java

public class Bear {
  private String name;
  private ArrayList<Human> bellyHuman;

  public Bear(String name){
    this.bellyHuman = new ArrayList<Human>();
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int foodCount(){

  }

  public void eat(Human human){
    bellyHuman.add(human);
  }

  public void sleep(){
    bellyHuman.clear();
  }


}

```

Didn't that feel good?? Now we can fix our code to be nice and polymorphic. Our ArrayList can just be a belly again.

```java
//Bear.java

public class Bear {
  private String name;
  private ArrayList<Human> belly; //UPDATED

  public Bear(String name){
    this.belly = new ArrayList<Human>(); //UPDATED
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int foodCount(){

  }

  public void eat(Human human){
    belly.add(human); //UPDATED
  }

  public void sleep(){
    belly.clear(); //UPDATED
  }

}

```

Our foodCount() method can go back to just returning the size of the belly ArrayList.

```java
//Bear.java

  public int foodCount(){
    return belly.size();
  }
```

We are going to do something controversial - we are going to make our ArrayList contain Edible, NOT Salmon or Humans.

```java
//Bear.java

  private String name;
  private ArrayList<Edible> belly; //UPDATED

  public Bear(String name){
    this.belly = new ArrayList<Edible>(); //UPDATED
    this.name = name;
  }

```
Similarly, our eat() method is going to accept Edible.

```java
//Bear.java

  public void eat(Edible food){
    belly.add(food);
  }
```

Believe or not, all of our tests still pass!!!!

How can this be?

## Magic

The beauty of "polymorphism" is that any type can behave as if it is any of it's super class types as well as it own. Our Salmon can be both a Salmon and an Edible, like we mentioned earlier. So anything accepting Edible can accept a Salmon.

However, it does NOT apply the other way round. Anything accepting a Salmon does NOT accept an Edible. Not every Edible is a Salmon! But every Salmon is an Edible.
