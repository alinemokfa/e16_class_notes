# Packages and Access Modifiers

## Learning Objectives

- Understand that you can organise your code in packages
- Use access modifiers to encapsulate components.

## Introduction to packages.

Packages are essentially groups of classes in a folder. The purpose is to organise your classes in a structured way. You guys have already seen them when you created a new project. You had 3 packages, one to store your code, one to store your integration tests, one to store your unit tests.

Now we are going to work off a simple project that has a few packages.

```
    Hand out packages start point
```

[!] Draw a box similar to one from this site https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html 

Okay, we can see we have two packages, one for animals and one for humans. These packages will contain the respective code. A dog is inside the animal pack and has a public string name and bark, and human class inside the human package and has a teach method that accepts a dog class.

So if we we were look at the folder structure of our codebase. It would look like this (each package name is its own folder):

```

    / - codeclan
        / - com
            / - packagesexample
                / - animal
                    / - Dog.java
                / - human
                    / - Trainer.java
```

So in Ruby, when we wanted Trainer to see Dog, we would write a require_relative(./../animal/dog). In java we need to be more explicit. So we say

```
import codeclan.com.packagesexample.animal.Dog;
```

We could say

```
import codeclan.com.packagesexample.animal.*;
```

Which will import all classes from that animal package, but its considered bad practice if we only needed one. So change the import back to Dog.

We can create subpackages in packages (they will just become subfolders). 

Create a package called air inside animal. Create Bird class.

Inside Trainer, we can import the Bird like so

```
   import codeclan.com.packagesexample.animal.air.Bird; 
```

Note we cannot say 

```
    import codeclan.com.packagesexample.animal.*;     
```

To import the bird, this is because * is not recursive, only pulls it in from that folder and not subfolders.

Okay, lets discuss our access modifiers.

## Introduction to access modifiers

So we are going to explain a bit about access modifiers. They are the keywords that put in front of variables, interfaces and classes to determine who has access to them.

Warning, this has nothing to do with security I am afraid, you can easily bypass them using fancy coding techniques but it is heavily discouraged as you are not following the rules that the developers have set in place.

### Public

So we see that we have public. Public means that we have access everywhere. So for the Dog, we can call that method and set the name anywhere. For the method this is not an issue, but public variables are considered taboo as it can breaks encapsulation which could lead to bad code and bugs.

So our trainer can set the dogs name, and tell the dog to bark. So public gives access to everywhere. 

[!] Update the box you drew. (Accessible inside package, subclass (inside and outside) and everywhere else)

### Protected. 

Okay, so we are going to make a protected method and see what happens.

Inside dog.java we will create a protected method where the dog will wag its tail.

```
    protected void wagTail() {
        System.out.println("Wag!");
    }
```

And inside Trainer, when we play with the dog, the trainer will tell it to wag its tail.

```
    public void play(Dog dog) {
        dog.wagTail();
    }
```

A compiler error! Hmm, apparently the trainer cant force a dog to wag its tail. It means protected does not allow us to call that method since protected does not allow direct access outside of the package. 

What do i mean direct access? Well lets play some more. Suppose i want a new animal, a hound that extends dog. 

Inside animal package, create new class, call it Hound.java. Now make it extend Dog. Notice how i do not need to import dog as i am in the same package as dog so its all good.

```
    public class Hound extends Dog {
    }
```

Now we are going to say we can play with the hound, its public

```
    public void play() {
        super.wagTail();
    }
```

And we can see that it works, interesting. So if we extend from Dog, we get access to wagTail. If you were to ask would this still work if Hound was in a different package, the answer is yes.

Now lets do another test, if we were to create a cat.java inside animals.

```
    class Cat {

    }
```

And see if the cat can tell the dog to wag the dogs tail.

```
    public void playsWith(Dog dog) {
           dog.wagTail();
    }
```

It works too, so protected behaves like public inside its own package. Cool.

[!] Update the box, you can access protected inside package, subclasses (inside and outside) but not accessible anywhere else.

## Default access modifier

Now let me ask you a question. If I where to say 

```
    String name;
```

What access is this? public? private? protected? The answer is none of them.

This is what is called package-private. Package-private means that you can only access it inside the package. So in the case of the dog.

Dog.java
```
    int age;
```

Now, the hound can see it

Hound.java
```
    public void increaseAge(int age) {
        this.age = age;
    }
```

The cat can see it

Cat.java

```
    public void scareDog(Dog dog) {
          dog.age+=1;
    }
```

But the trainer cannot.

```
    public void scareDog(Dog dog) {
        dog.age+=1;
    }
```

Good, the trainer is too friendly to scare the dog. Happy days. 

[!] Update box for package-private (default) (accessible inside package, subclass(only inside not outside) and not anywhere else)

## Private

And last, but not lease, is my favourite, private. So private is very simple, only the class itself has access. 

Inside dog.java

```
    private String biggestFear;
```

Only the dog knows what itself is afraid of, not the cat, not the trainer, not even the hound that extends from it. 

[!] Update the box for private. (Only own class, no subclass, no outside access)

