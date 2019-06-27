package com.frabac.mm.phase;

import com.frabac.mm.logger.Logger;
import com.frabac.mm.task.NewCustomerAndNewBusiness;
import com.frabac.mm.task.Task;
import com.frabac.mm.task.executor.TaskExecutor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Day implements Phase {

  private Map<Class<? extends Task>, Integer> taskList = new HashMap<>();

  public Day() {
    taskList.put(NewCustomerAndNewBusiness.class, 50);
  }

  @Override
  public void start() {
    Logger.log(this.getClass().getSimpleName() + " started");
    TaskExecutor taskExecutor = new TaskExecutor(8);
    for (Class<? extends Task> taskClass : taskList.keySet()) {
      for (int i = 0; i < taskList.get(taskClass); i++) {
        try {
          Constructor<? extends Task> taskConstructor = taskClass.getConstructor(Integer.class);
          Task task = taskConstructor.newInstance(i+1);
          taskExecutor.addTask(task);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
      Logger.log(this.getClass().getSimpleName() + " finished passing tasks, now waiting");
      taskExecutor.waitForAllTasksToFinish();
      Logger.log(this.getClass().getSimpleName() + " all tasks completed");
    }
    Logger.log(this.getClass().getSimpleName() + " completed");
  }
}
