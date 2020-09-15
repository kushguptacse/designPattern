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
10.	`Example ->`java.io.InputStreamReader and java.io.OutputStreamWritter are examples of object adapter design pattern.
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
3.	Suppose client using Message interface and TextMessage implements it and provide text in plain String. we need to support base64 and HTML encoding to message. so, decorator class Base64EncodedMessage will implement Message and will have reference to TextMessage inside it. by this it can take plain text and return encoded Text.
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
1.	We have a tree structure type of inheritance hierarchy of objects and we want them to be treated uniformly.
2. 	In this design pattern base class/interface should have all the methods needed by any child. so sometimes it is not suitable to use as it forces all child's to provide body to those methods. 
3.	Leaf will provide actual implementation and composite class delegates call to all the child's.
4.	composite design pattern allows to write algorithms without worrying about whether node is leaf or composite.
5. `Example-` Composite are used in many ui frameworks to represent tree of ui controls like JSF. In JSF we have UIViewRoot which act as composite class and other UIComponent implementations like UIOutput,UIMessage acts as a leaves. all classes extends common base class UIComponentBase which has methods like addChilderen and getChildCount. these methods body is provided by composite UIViewRoot. leaves classes like UIMessage provide empty body for such methods.
6.	`Difference between Decorator and Composite ->`<br/>
> Decorator deals with single object. Composite deals with tree structure of objects<br/>
> Decorator used to add or modify single object behavior. In composite leaves and composite class have same interface and composite simply delegates operation to the children. <br/>
7. Sometimes when we have variety of child, it is not possible to add all methods in component class and if add it to leaf itself then client need to check instance type using if else. this make it less useful.<br/>

**FACADE ->**<br/>
1.	When client has to interact with multiple classes/interfaces in a subsystem. In such case client is tightly coupled with those classes/interfaces. facade solves this problem.
2.	It provide simple interface to the subsystem. Client will interact with just the facade now to get the same result.
3.	It simplify the usage of functionality provided by sub-system.
4.	`Implementation Steps -` Start by creating a Facade class<br/>
> We determine all the use-cases/Tasks for which the subsystem is used for by client code.<br/>
> We write methods that exposes each use-case.<br/>
> these methods takes care of working with different classes of sub-system.<br/>
5.	For example EMailFacade can be created and it can provide sendEmail method which take Order object. so, client just need to now call single method instead of calling different methods of different classes at various stages (like email template,email builder,stationary etc).
6.	You can also create interface or abstract class for facade and client can use different classes to interact with different subsystem implementations.
7.	If intention is just to provide loose coupling of classes of subsystem with client code and not worried about simplification provided by facade, the use can use abstract factory design pattern directly.
8.	java.net.URL class is great example of Facade. This class provide simple method openStream() and we get an input stream to resource pointed by that URL object.<br/>
URL url = new URL("http://google.com");<br/>
url.openStream();<br/>
9. This openStream method deals with various classes of java.net package and some internal sun packages.
10.	`Difference between Facade and Adaptor ->`<br/>
> Facade intent is to simplify usage of subsystem for client.Adaptor is simply to adapt an object to different interface that client uses.<br/>
> Adaptor uses existing object and provide all the methods used by Client target. It always written to confirm to particular interface that client uses. On other hand Facade does not need to follow any target interface. it's aim is to provide simple method that simplify complex operations behind the scene.<br/>
11.	Facade are often added over existing legacy code to simplify code usage & reduce coupling of client code to legacy code.

**flyweight ->**<br/>
1.	Our System uses large number of objects of a particular class and maintaining these instances is performance concern. here flyweight can be used.
2.	flyweight allows us to share an object in multiple contexts.But instead of sharing entire state of object, which may not be feasible, we divide object state into two parts: 1. intrinsic (state that is shared in every context and will be immutable) and 2. extrinsic (context specific state).We create objects with only intrinsic state and share them in multiple context.
3.	Client or user of object provides extrinsic state to carry out its functionality.
4.	We use factory pattern along with that so that client can get different fly-weight classes objects.
5.	`Implementations ->` We start by defining intrinsic and extrinsic state of an object-><br/>
5.1	we create interface flyweight to provide common methods that accept extrinsic state.<br/>
5.2	In Implementation of shared flyweight we add intrinsic state and also implement methods.<br/>
5.3	In Implementation of un-shared flyweight we ignore the extrinsic object as we have all state with-in object.<br/>
5.4 flyweight factory class will provide caching of flyweights and also provides method to get them.(it is must in flyweight as client need easy way to get shared objects)<br/>
5.5 client code will either maintain extrinsic state or compute it dynamically using flyweight.<br/>
6.	Best example can be related to games where graphic images serves as intrinsic state and will remain same and cached by factory. on other hand location where image need to be draw serve as extrinsic states.
7.	flyweight intrinsic state should be immutable for successful use of flyweight pattern.
8.	It is useful only if you can extract out extrinsic fields out of object without any issue.
9.	Some other design pattern like state and strategy can make use of flyweight.
10.	`Example->` java.lang.Integer,Short,Byte,Character uses flyweight and keep copy of cached objects. for example in Integer class objects in range -127 to 128 are already cached and when asked via method valueOf it return cached object is value passed is in this range else new object is returned.
11. String constant pool is also another example of flyweight. by calling intern method it will always return object from pool.
12.	`Difference b/w flyweight and object-pool->`<br/>
> Flyweight state is divided into two parts.client must provide part of state to it. ObjectPool contains all of its state encapsulated to itself.<br/>
> Client will not modify the intrinsic state of flyweight instance as it is shared.In object pool client will change state of cached objects.<br/>
13.	`Pitfalls->` <br/>
> Runtime cost is added as client has to maintain extrinsic state. client has to store it or need to create every time it needs to use flyweight. <br/>
> Apart from graphical applications it is very tough to find this pattern use in web applications. <br/>

**Proxy ->**<br/>
1.	We use it when we want to provide place holder of real object.<br/>
> Protection proxy -> Control access to original object.<br/>
> Remote proxy -> provide local representation of original object.<br/>
> Virtual proxy -> Delay construction of original object until necessary.<br/>
2.	`Implementation ->`<br/>
> proxy must implement same interface as the real subject.<br/>
> we can create actual object when required or can ask it out via constructor.<br/>
> In method implementation of proxy we implement proxy's functionality before delegating to real object.<br/>
3.	To provide proxy object we can use factory or compose design pattern.
4.	we can also implement dynamic proxy in java.In such case proxy instance is created by client using java.lang.reflect.Proxy. Java reflection api need our subject class to implement some interface to create proxy (as it create class proxy which implement that same interface).
5.	In Dynamic proxy class need to implement java.lang.reflect.InvocationHandler. it has invoke method which is called on every method invocation of proxy object.
6. 	In case of authentication original object is passed via constructor of proxy itself. in such case we don't need to hold extra memory for fields.
7.	In Hibernate lazy loading of classes uses proxy object using virtual implementation and original entity object is only created when asked.
8.	Spring uses proxy pattern to provide support for feature like aop, transactions, caching.
9.	Spring and Hibernate can create proxy of classes which do not implement interfaces also. for that they use third party frameworks like cglib, aspectJ to create DynamicProxies at runtime.
10.	`Difference b/w Decorator and Proxy->`<br/>
> Proxy does not need actual object all the time for all operations. Decorator cannot work at all without hold on original Object.<br/>
> Decorator adds extra feature to original object and used for that. Proxy purpose is to add feature which is independent of original object. it does not enhance original. it just do some extra common functionality like logging, auditing, authentication.<br/>

## Behavioral -> 
**Chain Of Responsibility ->**<br/>
1.	When you want to decouple a request's sender and receiver it is used.
2.	It is used to achieve loose coupling in where a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.
3.	Handlers can allow send request to filter in every case also. like Servlet filter chain allow request to propagate to each filter for dedicated work.
4.	All Servlet implements javax.servlet.Filter interface which defines void doFilter(serveltReq,servletResp,FilterChain) method.
5.	Implementations will use FilterChain object and call doFilter method to pass object to next handler.
6.	`Difference b/w Chain Of Responsibility and Command->`<br/>
> If handler can't handle request it can forward it to next handler. In Command there is no passing of request to next handler, Command handle it by itself.<br/>
> It might be possible that request is not handled by any handler. In command request is handled always.<br/>
> We cannot track handler and cannot undo action done by previous handler.Commands are Trackable, we can store the order in which commands executed and can't undo actions also.<br/>

**Command ->**<br/>
1.	When you want a method call to be treated like an object, Command is used.Actual info like arguments and actual operation is encapsulated inside an object called command. 
2.	Advantage of command is that what would have been a method call now an object and can be stored in a collection and actual operation can be executed later.
3.	In command Undo or Redo support is present for particular object. if supporting such operations keep track of duration of queued objects as the size of may get increased in such case. 
4.	Command can inherit from command if they require to re-use some code from parent.
5.	For implementing undo feature in Command Memento design pattern can be used.it allows to store state of receiver without knowing internal objects used by receiver.
6.	`Example->` java.lang.Runnable is Command.<br/>
> we create object of class implementing Runnable and provide all the detail its needed<br/>
> In run method we call actual operation on Receiver<br/>
> we can also send the object to other parts of code for later execution when needed<br/>
7.	`Difference b/w Command and Strategy->`<br/>
> Command contains operation which is executed by the receiver(just like delegating a call to operation of receiver using receiver object).Strategy contains how the operation is carried out.<br/>
> Command encapsulates operation that needed to be performed.Strategy encapsulates particular algorithm<br/>
8.	Error handling is difficult to implement in command.similarly return value of command is also tough. as client does not have such information available.

**Interpreter ->**<br/>
1.	We use it when we want to process a "language" with simple rules or grammar. e.g.-> File access require user role and Admin role.
2.	Interpreter allows rule of language to be represented as data structure and then interpret sentences in that language.
3.	Each class in this pattern represents a rule in the language. Classes also provide method to interpret expression.
4.	Apart from interpreting expressions you can also do other things like pretty printing that uses already built interpreter.
5.	parsing logic is not defined by this design pattern. you have to think that logic.
6.	Context object can be used to store and access state of interpreter.
7.	java.util.regex.Pattern is example of Interpreter design pattern. here in compile method of Pattern abstract syntax tree is created representing the Grammar rule. and pattern.matcher takes takes String to be interpreted using the grammar rule.
8.	`Difference b/w Interpreter and Visitor->`<br/>
> Grammar rules are represented as object structure. visitor represents operations to be performed as object structure.<br/>
> Has access to properties it needs for interpretation.In visitor observable and observer are used to make property available.<br/>
9.	for every rule a separate class needed which can leads to large number of classes.
10.	for complex language rules this design pattern is not suitable.

**Mediator ->**<br/>
1.	Mediator encapsulates how a set of objects interact with each others. Due to this encapsulation there is a loose coupling between the interacting objects.
2.	So when one object wants to call a method on another object. so instead of having reference to object2. object1 will call mediator method and mediator will then call object2 method.
3.	So, in case one object perform some changes and then inform mediator. Now mediator will inform every other object that want's to listen to the changes in the first object. in such case if one object has slow performance it might impact overall performance of entire system.
4.	with time sometimes meditor code grows to much and become complex as all the logic of informing various other controls of value change is on mediator.
5.	We can use observer design pattern to implement notification mechanism through which object can notify mediator about there value change.
6.	`Example->` <br/>
> front controller like dispatcher servlet in Spring is an example of Mediator. It is specialized version of mediator as here instead of verify every other object in the system, only the desired controller is informed and served the request.<br/>
> javax.swing.ButtonGroup is another example of mediator. if one button is selected then all other buttons in the group is informed and they update there state to not selected.<br/>
7.	`Difference b/w Mediator and Observer->`<br/>
> In Mediator if any object changes all other objects are notified about the changes. In Observer there is one to many relationship only i.e. on change of desired object all listener will get notified but changes done to any listener object will not be notified to each other.<br/>
> Mediator implementation are specific to the object being mediated. observer totally works on interfaces and hence once implemented it can be used with any classes<br/>

**Iterator ->**<br/>
1.	Iterator allows way to access elements of an aggregate object in sequence while hiding actual internal data structure used.
2.	In java Collection framework java.util.Iterator is used. it allows to iterate over any collection in sequence irrespective of internal data structure used like array or list.
3.	Iterator keeps track of position so that they can provide data correctly.
4.	Iterator can go out of sync if underlying collection is changed while iterator is currently in use.
5.	We implement Iterator as an inner class. in this way iterator got hold to a internal data structure used by that class to give elements.
6.	Iterator design pattern can also be used to read lines from file sequentially.
7.	java.util.Scanner class also is an example of iterator design pattern. scannerObj.nextInt() gives next int from input stream.
8.	`DisAdvantage->` Need to explicitly handle scenerio's where someone changes collection over which iterator is working currently.

**Memento ->**<br/>
1.	It is used when we want to store's object state for latter use without exposing the internal details of the state.
2.	undo functionality is one of the use-case of memento design pattern. we can also use saved state to restore state of object back.
3.	this pattern is combined with command design pattern to provide undo functionality.
4.	In it originator object state is saved in memento. this memento class can be read and write only by originator class. Originator will provide method to return snapshot out. which will return instance of memento.
5.	Similarly it provides reset method also which takes memento object as argument and will reset its own state according to memento object state. 
6. it is often combined with command design pattern to provide undo functionality.
7.	If state which is saved in memento is large. then we might need a solution to discard older states to avoid too much memory used.
8.	resetting to previous state might impact objects that uses that state. so be careful while doing undo.
9.	If there is a fixed way of creating memento then we can only store incremental state instead of entire state.
10.	`Example->` undo support provided by javax.swing.text.JTextComponent and it's child like JTextField, JTextArea. javax.swing.undo.UndoManager act as care-taker and implementations of java.swing.undo.UndoableEdit interface act as mementos. The javax.swing.text.Document implementation which is model for text components act as originator. 
11. java.lang.Serializable is not an example of Memento design pattern. we can use serialization to save state of originator in memento inner class.
12.	`Difference b/w memento and command` -><br/>
> memento is used to store object state for later use. command is used to make operations/actions behave as objects.<br/>
> memento requires state to be saved. if undo operation is not needed command does not need to save the state<br/>
> memento state is sealed and can be read by originator only.command can be read by anyone<br/>
13.	If originator state has nested hierarchy of objects then deep copy is needed to save state.

**Observer ->**<br/>
1. when we want to notify state change in one object to all the interested objects this design pattern can be used. it is also called pub-sub or publisher-subscriber.
2.	Here one-to-many relationship is established. where listeners and publishers are not tightly coupled.
3.	mostly it is used like that-> publisher tells observers that something has changed in object (subject is called observable here). then each observer according to need ask for the changes done and do modifications.this make it more generic.