package com.frabac.mm.logger;

public class Logger {

    public static void log(String message) {
        System.out.println(String.format("%d - %s", System.currentTimeMillis(), message));
    }

}
