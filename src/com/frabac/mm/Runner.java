package com.frabac.mm;

import com.frabac.mm.phase.Day;
import com.frabac.mm.phase.Evening;
import com.frabac.mm.phase.Morning;
import com.frabac.mm.phase.Night;

public class Runner {

    private Day day;
    private Night night;
    private Morning morning;
    private Evening evening;

    public void init(){
        this.morning = new Morning();
        this.day=new Day();
        this.evening = new Evening();
        this.night = new Night();
    }


    public void go(){
        morning.start();
        day.start();
        evening.start();
        night.start();
    }
}
