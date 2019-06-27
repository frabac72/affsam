package com.frabac.affsam.phase;

import com.frabac.affsam.logger.Logger;

public class Night implements Phase {
  @Override
  public void start() {
    Logger.log(this.getClass().getSimpleName() + " started");
    Logger.log(this.getClass().getSimpleName() + " completed");
  }
}
