package com.frabac.affsam.phase;

import com.frabac.affsam.logger.Logger;

public class Morning implements Phase {

  @Override
  public void start() {
    Logger.log(this.getClass().getSimpleName() + " started");
    Logger.log(this.getClass().getSimpleName() + " completed");
  }
}
