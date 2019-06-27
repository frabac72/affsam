package com.frabac.mm.task;

import com.frabac.mm.atomictask.NewBusiness;
import com.frabac.mm.atomictask.NewCustomer;
import com.frabac.mm.logger.Logger;

public class NewCustomerAndNewBusiness extends Task{

  private NewCustomer newCustomer;
  private NewBusiness newBusiness;
  private int id;

  public NewCustomerAndNewBusiness(Integer id) {
    this.newCustomer = new NewCustomer();
    this.newBusiness = new NewBusiness();
    this.id=id;
  }

  @Override
  public void doRun() {
    Logger.log(String.format("%s %d started", this.getClass().getSimpleName(), id));
    newCustomer.go();
    newBusiness.go();
    Logger.log(String.format("%s %d completed", this.getClass().getSimpleName(), id));
  }
}
