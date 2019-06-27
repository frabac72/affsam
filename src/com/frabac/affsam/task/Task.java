package com.frabac.affsam.task;

import java.util.Collection;
import java.util.HashSet;

/**
 * A Runnable that notifies when done and imposes subclasses to have a method where they "do their thing"
 */
public abstract class Task implements Runnable{

  private Collection<TaskCompletedListener> listeners = new HashSet<>();

  public void addListener(TaskCompletedListener listener) {
    listeners.add(listener);
  }

  @Override
  public void run() {
    doRun();
    notifyAllListeners();
  }

  private void notifyAllListeners() {
    for (TaskCompletedListener listener : listeners) {
      listener.taskCompleted();
    }
  }

  protected abstract void doRun();
}
