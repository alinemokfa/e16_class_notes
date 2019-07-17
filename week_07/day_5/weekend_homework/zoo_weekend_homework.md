# Zoo Manager Homework

You have been asked to create a zoo management system so that we can manage our elephants, giraffes, lions and any other animals that we might have.

Remember to read the brief thoroughly and draw some class diagrams before attempting to code!

## MVP

Create an Animal superclass and a few less generic subclasses.

All Animals should have a cash value.

A Zoo should have a collection of generic Enclosures that can take Animals of any particular type. An Enclosure should only be able to hold Animals of one type.

A Zoo should be able add and remove Enclosures.

An Enclosure should be able to add and remove Animals.

A Zoo should be able to calculate the total number of Animals within it's enclosures.

A Zoo should be able to sell an Animal, removing them from their Enclosure (hint: You will have to figure out which enclosure the Animal is in first. The `ArrayList`'s `contains()` method might help) and receiving some money in exhange for them.

## Extensions

A Zoo should have a ticket price.

A Visitor should be able to buy tickets and visit the Zoo. A Zoo should have a collection of Visitors who are currently in the Zoo.

A Zoo should be able to calculate the total value of it's Animals.