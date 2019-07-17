## Intro to Generics Homework Solution

1. What is one benefit of using generics in Java classes?
Generics allow us to specify the type of a classes argument at the point of instantiation. This makes the class flexible, which allows to keep the code DRY.
2. Name an example of a generic class that we have used in Java?
ArrayList
3. What is the syntax for declaring a generic class?
`class NameOfClass<T> {}`
4. At what point does the generic type get specified?
At the point of instantiation
5. Can generic types be of primitive type?
No, because anything that is used as a generic type has to be convertable to an object. As primitive types aren't they can't be used in generics.
6. Can a generic class take more than one type parameters?
Yes. They are separated by commas.