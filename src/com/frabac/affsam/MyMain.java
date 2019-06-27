package com.frabac.affsam;

import com.frabac.affsam.phase.Day;

public class MyMain {

    private Day day;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.init();
        runner.go();
    }


}
