package com.frabac.mm.phase;

import com.frabac.mm.logger.Logger;

public class Night implements Phase {
  @Override
  public void start() {
    Logger.log(this.getClass().getSimpleName() + " started");
    Logger.log(this.getClass().getSimpleName() + " completed");
  }
}
