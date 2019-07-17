# Dictionaries

### Learning Objectives
- Know what an Dictionary is
- Understand the difference between a Dictionary and Lists/basic arrays
- Be able to create Dictionaries, and add and remove items from them

## Intro

So we've seen arrays and Lists and howLists can be much more helpful to us than simple arrays. We're now going to look at another type of Collection that C# uses - Dictionaries.

A Dictionary is a special type of list where each entry in the list is made up of two parts - a key and a value. The key is unique, i.e. there can only be one match per key, but the value associated with that key need not be unique.

Like ```List```, ```Dictionary`` is a generic collection included in the ````System.Collections.Generic``` namespace.

So let's create a simple dictionary:

```bash
#terminal

touch DictionaryExample.cs
subl .
```

First of all, let's create our boilerplate code:

```csharp
//DictionaryExample.cs
using System;
using System.Collections.Generic;

namespace DictionaryExample {
  class Program
  {
      static void Main()
      {

      }
    }
}

```

Just as when we created a List we needed to give it the type of what was contained in the list, when creating a Dictionary, we have to give it both the type of the key AND the value, i.e. we pass it TWO types.

We are going to create a simple phonebook, which contains names and phone numbers. For each entry in the dictionary the key will be a string containing the name, and an integer containing the number so we will declare our dictionary using the following:

## Creating a Dictionary

```csharp
Dictionary<string, int> phonebook = new Dictionary<string, int>();
```

```csharp
//DictionaryExample.cs
using System;
using System.Collections.Generic;

namespace DictionaryExample {
  class Program
  {
      static void Main()
      {
        Dictionary<string, int> phonebook = new Dictionary<string, int>();
      }
    }
}

```

## Adding an Entry
Now that we have our dictionary, we need to add some entries. When adding an entry to a dictionary, we can do it in one of two ways:

* by using the Add method, where we pass it two arguments. The first being the key, and the second being the value:

```csharp
phonebook.Add("Jack", 55551234);
```

* by using square brackets[] like when we add an entry to an array. Instead of using the integer array index in the square brackets we use the key instead:
```csharp
phonebook["Victor"] = 11197654;
```

## Accessing Dictionary Entries

Dictionary elements can be accessed by many ways e.g. foreach, for loop or indexer.

Use foreach or for loop to iterate access all the elements of dictionary. Just like when we iterated over a List, we can use a ```var``` for each entry in the dictionary. We can then access the Key and Value individually. 
Let's print out the entries in our phone book: 

```csharp
//DictionaryExample.cs
using System;
using System.Collections.Generic;

namespace DictionaryExample {
  class Program
  {
      static void Main()
      {
        Dictionary<string, int> phonebook = new Dictionary<string, int>();

        phonebook.Add("Jack", 55551234);
        phonebook["Victor"] = 11197654;

        foreach (var entry in phonebook) //ADDED
        {
            Console.WriteLine("Name: {0}, Phone Number: {1}", entry.Key, entry.Value);
        }
      }
    }
}
```

## Getting the Value for a Key

To get the value for the entry with a specific key we can do in just the same way as for an array, using []. We just include the key inside the brackets, rather than an index e.g.:

```csharp
int phoneNum = phonebook["Jack"];
```

> Note, if the key does not exist then using this method will throw a` ``KeyNotFoundException``` exception so a much safer way is to use the ```TryGetValue()``` method, which will return ```false``` if the key does not exist e.g.

## Checking if a Key exists.

We can check to see if a dictionary contains an entry with a given key using the ```ContainsKey``` method, where we pass it the key we want to check:

```csharp
//DictionaryExample.cs
using System;
using System.Collections.Generic;

namespace DictionaryExample {
  class Program
  {
      static void Main()
      {
        Dictionary<string, int> phonebook = new Dictionary<string, int>();

        phonebook.Add("Jack", 1415551234);
        phonebook["Victor"] = 01419990000;

        foreach (var entry in phonebook) //ADDED
        {
            Console.WriteLine("Name: {0}, Phone Number: {1}", entry.Key, entry.Value);
        }

        if (phonebook.ContainsKey("Jack")) //ADDED
        {
          Console.WriteLine(phonebook["Jack"]);
        }
        
        if (phonebook.ContainsKey("Winston"))
        {
          Console.WriteLine(phonebook["Winston"]);
        }
        else
        {
          Console.WriteLine("Winston isn't in the phone book");
        }
      }
    }
}
```

## Removing Elements From a  Dictionary:

Use the ```Remove()``` method to remove an existing item from the dictionary. Remove() has two overloads, one overload method accepts a key and the other overload method accepts a KeyValuePair<> as a parameter.

Remove() signature:

```
bool Remove(TKey key)
```

```
bool Remove(KeyValuePair<TKey,TValue>)
```

## Advanced Topic - Sorting Dictionary Items

Using Linq, and a lambda expression, we can order dictionary items. For example, if we wanted to order items by value we could write:

```csharp
Dictionary<string, int>orderedByName = phonebook.OrderBy(x => x.Value).ToDictionary(x => x.Key, x => x.Value);
```

```csharp
//DictionaryExample.cs

using System;
using System.Collections.Generic;
using System.Linq;


namespace DictionaryExample {
  class Program
  {
      static void Main()
      {
        Dictionary<string, int> phonebook = new Dictionary<string, int>();

        phonebook.Add("Jack", 5554321);
        phonebook["Victor"] = 1118898;

        foreach (var entry in phonebook)
        {
            Console.WriteLine("Name: {0}, Phone Number: {1}", entry.Key, entry.Value);
        }

        // Check if a key exists
        if (phonebook.ContainsKey("Jack"))
        {
          Console.WriteLine(phonebook["Jack"]);
        }
        
        if (phonebook.ContainsKey("Winston"))
        {
          Console.WriteLine(phonebook["Winston"]);
        }
        else
        {
          Console.WriteLine("Winston isn't in the phone book");
        }

        //Order by value

        Dictionary<string, int>orderedByPhoneNumber = phonebook.OrderBy(x => x.Value).ToDictionary(x => x.Key, x => x.Value);
        
        foreach (var entry in orderedByPhoneNumber)
        {
            Console.WriteLine("Name: {0}, Phone Number: {1}", entry.Key, entry.Value);
        }
      }    
    }
}

```

