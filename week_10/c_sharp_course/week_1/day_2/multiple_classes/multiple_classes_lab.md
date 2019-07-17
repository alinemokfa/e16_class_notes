# Multiple Classes Lab

Using TDD, your task is to model a Bus which can pick up and drop off passengers.

## Part A
### Step 1
- Create a Bus class. 
- The Bus should have a route number (e.g. 22) and a destination (e.g. "Ocean Terminal").
- The Bus should have a drive method that returns a string (e.g. "Brum brum").

### Step 2
- Create a Person class.
- The Person class should have attributes of a name and age.

## Part B
- Give the Bus class a new property, 'passengers'. This should be a List of People, which starts off empty. 
- Add a method to the Bus class which returns how many passengers are on the bus. 
- Add a method to the Bus class which takes in a Person and adds it to the List of passengers. The method could look something like `bus.PickUp(passenger1)` 
- Add a method that drops off a passenger and removes them from the List. This could look like `bus.DropOff(passenger2)`
- Add an 'empty' method to remove all of the passengers - this might be used when the bus reaches its destination, or if the bus breaks down. It should remove all of the passengers from the array. 