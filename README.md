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
3.	In Java - Collection interface has own methods and List has it's own specific methods. if a new method needs to be added into List. it will not be added into Collection interface because this new method might not have any significance in Set interface. 
4.	For example - While re-factoring collect everything which cannot be change and make abstract parent class out of it and make abstract methods of behavior which can be changed. these method will be provided by children and hence they are open for extension. and parent class fields and methods will never be changed and hence closed for extension.

# Design Pattern
There are three categories of design patterns  - 
*   **Creational** -> These design patterns provide ways to create objects while hiding the creation logic, instead of instantiating objects directly using the new operator. This gives the program more flexibility in deciding which objects need to be created for a given use case.
*   **Behavioural** -> These design patterns are specifically concerned with communication between objects.
*   **Structural** -> These design patterns deal with class and object composition. The concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionality.

## Creational -> 
**Builder ->**<br/>
1.  It is used when we have lots of fields  by which we can create object. out of it some of them are mandatory and some are optional.
2.	Instead of using multiple overloaded constructor we can use Builder api to construct objects.
3.	In Java StringBuilder is a builder which builds on String and hence save memory of un-necessary concatenation.

