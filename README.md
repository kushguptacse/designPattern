# SOLID Design Principle

#####	Summary of all design pattern is present in below url-</br>
 https://drive.google.com/file/d/1p2qzVFeOfknyn_Il4N5vFVGTlRAIyb7j/view

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
*   **Structural** -> These design patterns deal with how classes and objects are arranged or composed. The concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionality.
*   **Behavioral** -> These design patterns are specifically concerned with communication between objects.

## Creational -> 
**Builder ->**<br/>
1.  It is used when we have lots of fields  by which we can create object. out of it some of them are mandatory and some are optional. or we have multiple steps to create a constructor.
2.	Instead of using multiple overloaded constructor we can use Builder api to construct objects.
3.	when we want to implement immutable class of DTO we can use builder design pattern and pick implementation where static inner class object is used. this approach is preferred even if immutable is not needed as it gives better readability. for e.g. -> we wanted to create immutable class but with facility of some optional arguments also. here Builder pattern can be used.
4.	In Java StringBuilder is a builder which builds on String and hence save memory of un-necessary concatenation. It is not 100% following builder design. java.util.Calendar.Builder is example of builder design pattern
5.	As a best practice create constructor inside builder with mandatory fields which will call DTO constructor. and non mandatory fields will be set via different chaining builder method. in this way it is sure that object cannot be created without mandatory fields.

**Simple Factory ->**<br/>
1.	here we simply move the instantiation logic to other class and most commonly to the static method of that separate class.
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

**Abstract Factory->**<br/>
1.	Abstract Factory is used When two or more objects which works together forming a set and there can be multiple sets that can be created by client code.
2.	While implementing it first categorize products into sets and create factory class for each set of products to return instances. 
3.	Abstract factory uses factory method pattern. Here an abstract class/interface will have multiple factory methods(for each product in a set).
4.	Example- Different cloud providers can have factory classes for GCE instance, EC2 instance, s3 storage, google cloud storage. but we know if we are using AWS cloud provider only AWS related resources can be used. similarly for gcp also. hence they form a set. So, Basically when we want to constrain object creation. so that they all work together then abstract factory is good design pattern.
5.	Factory can be used to implement singletons.
6.	Adding a new product to the system for e.g. Database in our example. we need to do changes in base factory as well as all the implementing factory.
7.	javax.xml.parsers.DocumentBuilderFactory is example of abstract factory design pattern.
8.	`DIFF->` factory-method hides concrete objects where as abstract Factory hides factories as well as concrete objects. Factory-method concerned with suitable objects and its sub-classes, where as AF suitable when multiple objects work together & client must use same family objects while working. 
9.	it is more complex to implement then other factories pattern.

**Singleton->**<br/>
1.	A singleton class has only 1 instance shared globally among the application.
2.	Eager Singleton - as soon as class loaded instance is created.
3.	Lazy Singleton - when first time asked instance is created.
4. 	Make private constructor.
5.	Lazy singleton - one approach is to make variable volatile and apply double checking lock to create instance inside getInstance static method.
6.	Lazy singleton - 2 approach is to create static class and inside it create static instance variable and load directly. benefit here is that no synchronization issue exists.
7.	Lazy singleton - 3 approach is to use enum directly. (Serializable safe)
8.	it is not mandatory to override clone method as our singleton does not override Cloneable interface and hence if someone call clone method on our singleton cloneNotSUpported exception will be thrown.
9.  java.lang.Runtime class is example of singleton(eager).
10.	if mutable fields are present in singleton class then it might lead to in-consistent behavior as this instance is shared globally.
11.	Logging framework uses singleton design pattern.

**Object Pool->**<br/>
1.	If cost of creating objects of class is high and we want to maintain pool of objects of this class for short duration,then we can use an object pool. like - threads, database connections.
2.	Here we either pre-create object of class or collect un-used object in an memory cache. so, when needed object is returned from this cache.
3.	It is most complicated pattern to implement efficiently (Due to multi-threading environment).
4.	Implementation - Methods to acquire and release object should be provided. after releasing object. that object state should be reset so that it can be used again.
5.	A thread-safe caching of objects should be done in pool. so that there state remain consistent.
6.	Pooling Object is only beneficial if they involve costly initialization of external resources like database connections, thread.
7.	java.util.concurrent.ThreadPoolExecutor is example of object pool. we use this method via Executors.newCachedThreadPool() and it returns ExecutorService interface. and when we submit runnable task it use threadPool to allocate new thread.
8.	Prototype Design Pattern always returns copy of object and never re-use any exiting object. where as ObjectPool uses caching to save object and can be later used when needed. in object pool object after using needs to be reset otherwise it might lead to memory leak on other hand cloned object in prototype design pattern does not additional effort to reset.
9.	`DisAdv ->`<br/>
> Difficult to use in re-factoring as client code need to change to use objectPool and original class whose objects need to be pooled also need to provide reset method logic.<br/>
> If you create objects when the code asked and none are available you need to write additional logic to maintain or trim the pool size or else you will end-up with very large pool.<br/>
> Successful implementation requires client to call reset method after finish using the object.<br/>

## Structural -> 
**Adapter ->**<br/>
1.	We have an existing object which provides the functionality that client needs.But client cannot use this object as it expect object with different interface.
2.	So, here we use adapter pattern. by using it we make exiting object work with client by adapting the object to client's expected interface.
3.	This pattern is also called Wrapper as it "wraps" object according to client need.
4.  Two Types of adapter pattern -> class adapter and object adapter.
5.	We have Adaptee (class which has method operation that fulfills client need) and target interface (whose method client invokes). so what we can do we can create a new class adapter which implements target interface.
> Class adapter: Here adapter extends Adaptee class and then call operation method directly inside overridden method of Target interface which client calls. Here we make use of inheritance.
> Object adapter: Here instead of extending Adaptee. object of Adaptee is created in constructor and then using that instance inside overridden method of target ->operation method is called. Here we make use of composition.
6.	The Amount of work adapter needs to do depends upon the difference between target interface and adaptee object. for ex-> if method arguments are similar adapter has very less work to do.
7.	Using class adapter you can override adaptee method also but don't do that as you end up with adapter that behaves differently then adaptee. which might lead to bugs.
8.	prefer object adapter over class adapter as it provide flexibility that in future we can replace adaptee with child class. If we have both target and adaptee as classes we cannot use class adapter pattern. here object adapter is used.
9.	Class adapter is also called two way adapter, since it can be used in place of target as well as adaptee.
10.	java.io.InputStreamReader and java.io.OutputStreamWritter are examples of object adapter design pattern.
11.	Here Client wants to use Reader and Writer objects and if we have InputStream and OutputStream available. in such case InputStreamReader will be adaptor class which takes InputStream in constructor argument and perform conversion to make it compatible with Reader methods.
12.	`Difference between Adapter and Decorator ->`<br/>
> Simply adapt an object to another interface without changing behavior.On other hands Decorator enhances object behavior without changing interface. <br/>
> Since the target and source are not different we cannot use adaptor inside adaptor easily. But nested decorator is possible as here interface does not change.<br/>

**Bridge ->**<br/>
1.	Our implementation and abstraction are closely bind with each other. we want them to be loosely coupled so, that changes in one will not impact other.
2.	We achieve this by making two separate inheritance hierarchy. one for implementation and one for abstraction. and then we use composition to bridge these two separate inheritance hierarchy.
3.	Abstractions here can be concrete class also. here it means we can add new method in abstraction hierarchy and it will not impact implementation hierarchy and vice versa. this is because implementation has totally different method which will serve the needs of abstraction methods.
4.	In case we have single implementation only we can skip creating abstract implementer.
5.`Example` - java.util.Collections.newSetFromMap(map) method. This method return Set which is mapped by Map. so, here changes done in map interface will not impact the set interface. similarly changes done in set interface will not impact map.
6.	`Difference between Adapter and Bridge ->`<br/>
> In Bridge intent is to make abstractions and implementations to evolve independently. In Adaptor intent is to make unrelated classes to work together.<br/>
> Bridge has to be design up-front then only we can have varying implementations and abstractions. Adaptor usually used where both classes already exists. e.g.-> legacy code need to be integrated with new code. <br/>
> In terms of code they both are quite similar-> using other class object to perform functionality which is passed in a constructor.<br/>
7. You need to have well thought and fairly clear design in front to be able design bridge pattern. 
8.	It also very tough to change existing code to support such pattern.

**Decorator ->**<br/>
1.	When you want to enhance the behavior of existing object functionality as and when needed at runtime we can use decorator design pattern.
2.	Decorator wraps object and provides same interface as wrapped object. so client does not need to change the code.
3.	Suppose client using Message interface and TextMessage implements it and provide test in plain String. we need to support base64 and html encoding to message. so, decorator class Base64EncodedMessage will implement Message and will have reference to TextMessage inside it. by this it can take plain text and return encoded Text.
4.	As we can see in decorator we have used Message object and due to it we can pass decorator also in future if needed. hence nesting decorator is also possible.
5.	If we very large base class then it is not suitable to use decorator as decorator class will not need all such info.
6.	Since decorator support recursive composition. if used it might lead to lots of small objects that add small functionality. which sometimes become difficult to debug. so keep it in mind while using recursive composition.
7.	Decorator gives more flexibility as compare to simple inheritance as we can use same reference and can pass different decorators or plain implementation object at runtime. but don't just use decorator as a replacement of inheritance. if we wanted to add lots of code which is not matching behavior of parent in such case inheritance should be used.
8.	Decorator should act like additional skin over object. they should not change behavior of existing object and should add new behavior which is related to existing object.
9.	`Example ->` java.io packages contain lots of example of decorator design pattern. BufferedOutputStream is a Decorator that decorates any OutputStream Object and adds buffering to file writing operation. This improves the disk i/o performance by reducing number of writes. see attached pdf for detail example.
10.	`Difference between Decorator and Composite ->`<br/>
> Decorator intent is to "add to" existing behavior of existing object. Composite are meant for object aggregation only.<br/>
> Decorator can be thought as degenerate composite with 1 component. Where as Composites support any number of components in aggregation (as it takes collection)<br/>

**Composite ->**<br/>