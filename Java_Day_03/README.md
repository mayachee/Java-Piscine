# Creating and Starting a Thread

There are two ways to create a thread in Java -

## 1. By extending Thread class

You can create a new thread simply by extending your class from Thread and overriding it’s run() method.

The run() method contains the code that is executed inside the new thread. Once a thread is created, you can start it by calling the start() method.

``` java
public class ThreadExample extends Thread {

    // run() method contains the code that is executed by the thread.
    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating thread...");
        Thread thread = new ThreadExample();

        System.out.println("Starting thread...");
        thread.start();
    }
}
```

Output:

```
    # Output
    Inside : main
    Creating thread...
    Starting thread...
    Inside : Thread-0
```

Thread.currentThread() returns a reference to the thread that is currently executing. In the above example, I’ve used thread’s getName() method to print the name of the current thread.

Every thread has a name. you can create a thread with a custom name using Thread(String name) constructor. If no name is specified then a new name is automatically chosen for the thread.

## 2. By providing a Runnable object

Runnable interface is the primary template for any object that is intended to be executed by a thread. It defines a single method run(), which is meant to contain the code that is executed by the thread.

Any class whose instance needs to be executed by a thread should implement the Runnable interface.

The Thread class itself implements Runnable with an empty implementation of run() method.

For creating a new thread, create an instance of the class that implements Runnable interface and then pass that instance to Thread(Runnable target) constructor.

```java

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
    }
}

```

Output:

```
    # Output
    Inside : main
    Creating Runnable...
    Creating Thread...
    Starting Thread...
    Inside : Thread-0
```

## What is different between  implements Runnable and extends thread

If you want to implements or extends any other class then Runnable interface is most preferable, otherwise, if you do not want any other class to extend or implement then Thread class is preferable.

### The most common difference is

![vLRdp](https://github.com/siiine-764/Java-Piscine/assets/80540449/3d21e586-b6a2-4972-88ad-2189401cdadb)

When you extends Thread class, after that you can’t extend any other class which you required. (As you know, Java does not allow inheriting more than one class).

When you implements Runnable, you can save space for your class to extend any other class in the future or now.

## different between wait and notify

Object.wait() to suspend a thread

Object.notify() to wake a thread up


<img src="https://www.baeldung.com/wp-content/uploads/2018/02/Java_-_Wait_and_Notify.png" />
