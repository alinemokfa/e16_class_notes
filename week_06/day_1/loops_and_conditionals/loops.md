# Java Loops and conditionals

## Learning Objectives
  - Describe If Statements
  - Describe Switch statements
  - Describe While loops
  - Describe Standard For loops

We have already seen loops and if statements in action in Ruby.

Java has the same loop types again just written slightly differently.

## If - else statements

An if statement can be followed by an optional else statement, which executes when the Boolean expression is false.

```java
public class Test {

   public static void main(String args[]) {
      int x = 30;

      if( x < 20 ) {
        System.out.print("This is if statement");
      } else {
        System.out.print("This is else statement");
      }
   }
}
```

If the boolean expression evaluates to true, then the if block of code will be executed, otherwise else block of code will be executed.


## Switch statements

A switch statement allows a variable to be tested for equality against a list of values. Each value is called a case, and the variable being switched on is checked for each case.

```java
public class Test {

  public static void main(String args[]) {
    // char grade = args[0].charAt(0);
    char grade = 'C';

    switch(grade) {
      case 'A':
        System.out.println("Excellent!");
        break;
      case 'B':
      case 'C':
        System.out.println("Well done");
        break;
      case 'D':
        System.out.println("You passed");
      case 'F':
        System.out.println("Better try again");
        break;
      default :
        System.out.println("Invalid grade");
    }
    System.out.println("Your grade is " + grade);
  }
}
```

## While Loop

A while loop statement in Java programming language repeatedly executes a target statement as long as a given condition is true.

```java
public class Test {

  public static void main(String args[]) {
    int x = 10;

    while( x < 20 ) {
      System.out.print("value of x : " + x );
      x++;
      System.out.print("\n");
    }
  }
}
```

The key point of the while loop is that the loop might not ever run. When the expression is tested and the result is false, the loop body will be skipped and the first statement after the while loop will be executed.

## Do...While Loops

A do...while loop is similar to a while loop, except that a do...while loop is guaranteed to execute at least one time.

```java
public class Test {

  public static void main(String args[]) {
    int x = 10;

    do {
      System.out.print("value of x : " + x);
      x++;
      System.out.print("\n");
    } while( x < 20 );
  }
}
```
If the Boolean expression is true, the control jumps back up to do statement, and the statements in the loop execute again. This process repeats until the Boolean expression is false.


## For Loops

A for loop is a repetition control structure that allows you to efficiently write a loop that needs to be executed a specific number of times.

A for loop is useful when you know how many times a task is to be repeated.

The first kind to look at is a standard for loop.

The syntax of a for loop is −

```java
for(initialization; Boolean expression; update) {
  // Statements
}
```

```java
public class Test {

  public static void main(String args[]) {

    for(int x = 10; x < 20; x++) {
      System.out.println(x);
    }
  }
}
```

In the above loop an initialization step is executed first, and only once. This step allows you to declare and initialize any loop control variables.

Next, the Boolean expression is evaluated. If it is true, the body of the loop is executed. If it is false, the body of the loop will not be executed and control jumps to the next statement past the for loop.

After the body of the for loop gets executed, the control jumps back up to the update statement. This statement allows you to update any loop control variables.

The Boolean expression is evaluated again and the body of the loop executed again until the condition is false.

We can also use this to loop through arrays or any other list.

```java
public class Test{

  public static void main(String[] args) {
    double[] myList = {1.9, 2.9, 3.4, 3.5};

    for(int i = 0; i < myList.length(); i++){
      System.out.println(myList[i]);
    }
  }
}
```


There is another type of loop we can use called an Enhanced For loop that was introduced in Java 5. But we will look at this when we start to cover Arrays.
