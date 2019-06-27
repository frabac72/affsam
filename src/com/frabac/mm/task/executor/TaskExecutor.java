package com.frabac.mm.task.executor;

import com.frabac.mm.task.Task;
import com.frabac.mm.task.TaskCompletedListener;

import java.util.ArrayList;
import java.util.List;

public class TaskExecutor implements TaskCompletedListener {

  private int maxThreads;
  private int runningThreads = 0;
  //    private int maxRuns;
  private List<Thread> startedThreads = new ArrayList<>();
  private List<Thread> readyToGoThreads = new ArrayList<>();

  public TaskExecutor(int maxThreads/*, int maxRuns*/) {
    this.maxThreads = maxThreads;
//        this.maxRuns = maxRuns;
  }

  public synchronized void addTask(Task task) {
    task.addListener(this);
    Thread thread = new Thread(task);
    if (runningThreads < maxThreads) {
      thread.start();
      startedThreads.add(thread);
      runningThreads++;
    } else {
      readyToGoThreads.add(thread);
    }
  }

  public void waitForAllTasksToFinish() {
    while (!readyToGoThreads.isEmpty()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    for (Thread thread :
        startedThreads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public synchronized void taskCompleted() {
    runningThreads--;
    if (runningThreads < maxThreads && !
        readyToGoThreads.isEmpty()) {
      // take the first ready thread and start it
      Thread newTask = readyToGoThreads.get(0);
      readyToGoThreads.remove(0);
      newTask.start();
      startedThreads.add(newTask);
      runningThreads++;
    }
  }
}
