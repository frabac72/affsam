package com.frabac.mm.atomictask;

public class NewBusiness implements AtomicTask {

    @Override
    public void go() {
        try {
            Thread.sleep(3000 + (long)(Math.random()*2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
