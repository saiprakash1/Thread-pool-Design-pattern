
package sai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 *@author SAI
 *
 */
public class App {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  
  public static void main(String[] args) {

    LOGGER.info("Program started");

    // Create a list of tasks to be executed
    List<Task> tasks = new ArrayList<>();
    tasks.add(new PotatoPeelingTask(3));
    tasks.add(new PotatoPeelingTask(6));
    tasks.add(new CoffeeMakingTask(2));
    tasks.add(new BreadToast(2));
    tasks.add(new CoffeeMakingTask(6));
    tasks.add(new PotatoPeelingTask(4));
    tasks.add(new CoffeeMakingTask(2));
    tasks.add(new BreadToast(2));
    tasks.add(new PotatoPeelingTask(4));
    tasks.add(new CoffeeMakingTask(9));
    tasks.add(new PotatoPeelingTask(3));
    tasks.add(new BreadToast(2));
    tasks.add(new CoffeeMakingTask(2));
    tasks.add(new PotatoPeelingTask(4));
    tasks.add(new BreadToast(2));
    tasks.add(new CoffeeMakingTask(2));
    tasks.add(new CoffeeMakingTask(7));
    tasks.add(new PotatoPeelingTask(4));
    tasks.add(new BreadToast(2));
    tasks.add(new PotatoPeelingTask(5));
    tasks.add(new BreadToast(2));

    // Creates a thread pool that reuses a fixed number of threads operating off a shared
    // unbounded queue. At any point, at most nThreads threads will be active processing
    // tasks. If additional tasks are submitted when all threads are active, they will wait
    // in the queue until a thread is available.
    ExecutorService executor = Executors.newFixedThreadPool(2);

    // Allocate new worker for each task
    // The worker is executed when a thread becomes
    // available in the thread pool
    for (int i = 0; i < tasks.size(); i++) {
    	//System.out.println(i+"  Term called");
      Runnable worker = new Worker(tasks.get(i));
      executor.execute(worker);
    }
    // All tasks were executed, now shutdown
    executor.shutdown();
    while (!executor.isTerminated()) {
      Thread.yield();
    }
    LOGGER.info("Program finished");
  }
}
