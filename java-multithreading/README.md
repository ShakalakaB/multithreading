# multithreading
Multithreading practice - based on Udemy course " [Java Multithreading, Concurrency &amp; Performance Optimization](https://www.udemy.com/course/java-multithreading-concurrency-performance-optimization/)"

----
### Thread Creation
1. Extend `Thread`
2. `Runnable` Interface Implementation

### Thread Task Creation
*source: [Runnable vs. Callable in Java](https://www.baeldung.com/java-runnable-callable)*
1. `Runnable` interface:  
   + `Runnable` tasks can be run using the `Thread` class or `ExecutorService@submit/execute`;
   + Does not accept any parameters and does return any values;
   + Does not have the `throws` clause specified, there is no way to propagate further checked exceptions;
2. `Callable` interface:  
   + Can be run only using the `ExecutorService@submit`;
   + Returns a generic value;
   + Contains `throws Exception` clause, so we can easily propagate checked exceptions further;
   
### Handling exceptions from ExecutorService Tasks
1. If async task is processed by `@submit`: (`Runnable` task and `Callable` task both work) exception is stored in `Future`, handle through try/catch 
2. If async task is processed by `@execute`: (only `Runnable` task works) exception can be handled through overriding `ThreadFactory` and exception handler
3. If async task is processed by `ThreadPoolExecutor`: (only `Runnable` task works) overriding `@afterExecute` to handle exception.
4. Use **Wrapper task** to handle exception (not covered in this repo, can refer to following article *Handling Exceptions from ExecutorService Tasks*)

*source:*
   + *[Handling Exceptions from ExecutorService Tasks](http://www.javabyexamples.com/handling-exceptions-from-executorservice-tasks)*
