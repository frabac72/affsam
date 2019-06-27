package com.frabac.affsam.atomictask;

public class NewCustomer implements AtomicTask {

  @Override
  public void go() {
    try {
      Thread.sleep(800 + (long)(Math.random()*400));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
