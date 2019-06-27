package com.frabac.affsam;

import com.frabac.affsam.phase.Day;
import com.frabac.affsam.phase.Evening;
import com.frabac.affsam.phase.Morning;
import com.frabac.affsam.phase.Night;

class Runner {

    private Day day;
    private Night night;
    private Morning morning;
    private Evening evening;

    void init(){
        this.morning = new Morning();
        this.day=new Day();
        this.evening = new Evening();
        this.night = new Night();
    }


    void go(){
        morning.start();
        day.start();
        evening.start();
        night.start();
    }
}
