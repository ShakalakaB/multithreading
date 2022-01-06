# multithreading
Multithreading practice - based on Udemy course " [Java Multithreading, Concurrency &amp; Performance Optimization](https://www.udemy.com/course/java-multithreading-concurrency-performance-optimization/)"

----
### Thread Creation
1. Extend `Thread`
2. `Runnable` Interface Implementation

### Thread Task Creation
source: [Runnable vs. Callable in Java](https://www.baeldung.com/java-runnable-callable)
1. `Runnable` interface:  
   + `Runnable` tasks can be run using the `Thread` class or `ExecutorService`;
   + Does not accept any parameters and does return any values;
   + Does not have the `throws` clause specified, there is no way to propagate further checked exceptions;
2. `Callable` interface:  
   + Can be run only using the `ExecutorService`;
   + Returns a generic value;
   + Contains `throws Exception` clause, so we can easily propagate checked exceptions further;
   
