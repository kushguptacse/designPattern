# SOLID Design Principle

####	Single Responsibility Principle ->
1.  (SRP) states that there should never be more than one reason for a class to change.
2.  It means class should be highly cohesive. example if we have created a single class which make connection with the server. so our class code will change if protocol changes (i.e. from https to http) OR payload changes (json to xml) OR security changes. 
3.	The above example violates SRP. better way would be to create three different classes for above three cases i.e. protocol, payload type and security.
4.	**Project example** could be that in a single Rest controller. object validation and persistence both are done inside controller. so if new validation needed to be added or database changes we need to do change in Controller.
5.	But the UserController should not have any business logic init. it's responsibility should be to take user request and return output. the reason of doing change in UserController only should be if payload changes.

####	Open-Closed Principle ->
1.	The Open-Closed Principle (OCP) states that classes should be open for extension but closed for modification.
2.	It means that there should not be new changes done in the existing tested Parent class. but yes you can create new subclass and add new feature in child class. 
3.	For example - While re-factoring collect everything which cannot be change and make abstract parent class out of it and make abstract methods of behavior which can be changed. these method will be provided by children and hence they are open for extension. and parent class fields and methods will never be changed and hence closed for modification.

####	Liskov Substitution Principle (LSP) ->
1.	(LSP) applies to inheritance hierarchies, specifying that you should design your classes such that parent dependency can be substituted with subclasses without effecting the original behavior.
2.	Suppose we have Rectangle and Square class. where Square is a child of Rectangle. by making above inheritance if we create a method that takes Rectangle as a argument and validate height and width to be different. above method will work if rectangle is passed but this method fail if square is passed.
3. Above code issue is that by introducing child class we have changed the desired behavior which is height and width is not always same. Solution in this case is to avoid Inheritance.

####	Interface Segregation Principle ->
1.	Clients should not be forced to depend upon interfaces that they do not use.
2.	It means interface should be highly cohesive. Clients should not be forced to override method which is totally irrelevant just because someone has added a new method into the parent interface.
3.	Solution is to extract out new child interface which will have that newly added method.

####	Dependency Inversion Principle ->
1.	High level module should not depend upon low level module. both should depend upon abstractions. Abstractions should not depend upon details.details should depend upon abstractions.
2.  For example - Instead of creating objects inside a method it is better to pass dependency via argument. argument type can be interface. so that method behavior will not be bind to any child.
3.	spring dependency injection is one way of DI.


# Design Pattern
There are three categories of design patterns  - 
*   **Creational** -> These design patterns provide ways to create objects while hiding the creation logic, instead of instantiating objects directly using the new operator. This gives the program more flexibility in deciding which objects need to be created for a given use case. Deals with how objects are created. It deals with how classes and objects communicates with each other.
*   **Behavioral** -> These design patterns are specifically concerned with communication between objects.
*   **Structural** -> These design patterns deal with class and object composition. The concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionality.	It deals with how classes and objects are arranged.

## Creational -> 
**Builder ->**<br/>
1.  It is used when we have lots of fields  by which we can create object. out of it some of them are mandatory and some are optional. or we have multiple steps to create a constructor.
2.	Instead of using multiple overloaded constructor we can use Builder api to construct objects.
3.	when we want to implement immutable class of DTO we can use builder design pattern and pick implementation where static inner class object is used. this approach is preferred even if immutable is not needed as it gives better readability. for e.g. -> we wanted to create immutable class but with facility of some optional arguments also. here Builder pattern can be used.
4.	In Java StringBuilder is a builder which builds on String and hence save memory of un-necessary concatenation. It is not 100% following builder design. java.util.Calendar.Builder is example of builder design pattern
5.	As a best practice create constructor inside builder with mandatory fields which will call DTO constructor. and non mandatory fields will be set via different chaining builder method. in this way it is sure that object cannot be created without mandatory fields.

**Simple Factory ->**<br/>
1.	here we simply move the instantiation logic to other class and most commonly to the static method of that seperate class.
2.  It is used when we want to create different instances according to some fields passed as arguments to the static method conditionally.
3.  It is different then Factory design pattern.
4.  java.test.NumberFormat is example of simple factory.
5.	you can also combine other design pattern with it. for example factory will give builder instance.
6.  the criteria used by simple factory to create object can get complex with time with introduction of more and more conditions. in this case factory method design pattern is useful. as inside it the object is created by childrens of factory.
6.

