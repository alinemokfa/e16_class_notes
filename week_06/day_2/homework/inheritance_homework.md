# Inheritance Homework. 

You have been given starter code for detailing an employee system. 

#### Apply encapsulation to the Employee class.
- Make the properties of the Employee class private.
- Remove all the setter methods except `setName`. (You will also need to remove the tests for those methods)
- Add a method named `raiseSalary` with takes in a parameter of type double to increment the salary.

#### Create a subclass of Employee called Manager in the same package.
- Add a property to store the department name in a property called `deptName`.
- Create a constructor that includes all the parameters needed for Employee and `deptName`.
- Add a getter method for `deptName`.

#### Create subclasses of Employee: Engineer and Admin.
- These should take in the same parameters as Employee and pass them to Employee constructor.

#### Create a subclass of Manager called Director.
- Add a private property to store a double value `budget`.
- Create a constructor for Director that includes the parameters needed for Manager and the `budget` parameter.
- Create a getter method for this property.


## Extensions

#### (Optional)
- Write tests for the `raiseSalary` and `setName` methods on some of your objects to make sure that those methods work.

#### (Optional) Add additional business logic (data validation) to your Employee class.
- Prevent a negative value for the `raiseSalary` method.
- Prevent a null or empty value for the `setName` method.