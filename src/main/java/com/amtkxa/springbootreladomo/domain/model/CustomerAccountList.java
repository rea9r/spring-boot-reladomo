package com.amtkxa.springbootreladomo.domain.model;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class CustomerAccountList extends CustomerAccountListAbstract {
  public CustomerAccountList() {
    super();
  }

  public CustomerAccountList(CustomerAccount customerAccount) {
    super();
    this.add(customerAccount);
  }

  public CustomerAccountList(int initialSize) {
    super(initialSize);
  }

  public CustomerAccountList(Collection c) {
    super(c);
  }

  public CustomerAccountList(Operation operation) {
    super(operation);
  }
}
