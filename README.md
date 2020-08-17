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
6.  the criteria used by simple factory to create object can get complex with time with introduction of more and more conditions. in this case factory method design pattern is useful. as inside it the object is created by children of factory and client code does not change.

**Factory Method->**<br/>
1.	here we simply move the instantiation logic to sub-classes. If we have product instance hierarchy and possibility of future additions this pattern is preferred.
2.	We Use this pattern when we do not know in advance which class we may needed to create beforehand and also to allow new classes to be added into the system and handle their creation without affecting client code.
3.	java.util.AbstractCollection has abstract method iterator() which is example factory method pattern. here subclasses like ArrayList will give instance of iterator.
4.	pitfalls -> it is tough to re-factor existing code to use factory method pattern.Even though factory method pattern has advantage that we don't need to modify existing code of factory method, we often end up writing large number of classes whose only job is to instantiate new products. Although this is a drawback, it outweighs the other option of modifying existing code.
5.	simple factory on other hand does not uses inheritance it just has static method which create objects. in factory children of factory class create instances.

**Prototype->**<br/>
1.	When object we want to create is very complex. and we want to create many such instances of class, then we use existing instance as prototype.
2.	We can use it when object creation is very complex and we might want cloned object with initial state.
3.	If class which needs to be prototyped has several mutable fields then it gets quite complicated to keep deep cloning.
4.	Prototypes are very useful when dealing with composite and decorator pattern.
5.	To get the initial instance whose clone we wanted to return we can you registry class where initial objects are referenced and from there other codes can access to clone.
6.	Object.clone method is example of prototype design pattern as it creates prototype of the Objects that override clone method. In java Cloneable marker interface also needed to be implement.