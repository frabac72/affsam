package com.frabac.mm;

import com.frabac.mm.phase.Day;

public class MyMain {

    private Day day;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.init();
        runner.go();
    }


}
