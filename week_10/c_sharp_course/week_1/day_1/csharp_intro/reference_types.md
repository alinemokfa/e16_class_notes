# Primitive Types v Reference Types

When we talk about types in C# we need to make a distinction between two different kinds of type - primitive types and reference types.

In C# there are eight primitive types. You might also hear these called value types. This is because all they do is hold a value, and have no other methods available. 

The types are: 

* bool (for true/false)
* char (for unicode single characters, use single quotes) 
* byte, int, long, sbyte, short, uint, ulong, ushort (for whole numbers)
* decimal, double, float (for float/decimal point numbers)
* enum
* struct

All have a set amount of memory they take up. 

In C# conversion of number sizes is done automatically and the appropriate amount of memory is allocated. 

> Write up on board - info table for reference: https://msdn.microsoft.com/en-us/library/1dhd7f2x.aspx ) 

The other data types are known as reference types. The big difference between these and primitive/value types is that when you assign a variable to one of these they just make a REFERENCE to the information, rather than actually HOLDING the value themselves. This is important because if you make a copy of a reference type variable, such as when you pass some data in as an argument to a function, it is only copying a new reference to the same data, rather than making a clone of the data, which happens if you pass a primitive type in as an argument. Therefore if you do anything to change the data using this copied reference, it also changes the original data set, which can cause problems. 


Link to docs for anyone who's particularly interested: https://msdn.microsoft.com/en-us/library/490f96s2.aspx