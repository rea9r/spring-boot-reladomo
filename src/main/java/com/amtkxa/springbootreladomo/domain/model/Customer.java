package com.amtkxa.springbootreladomo.domain.model;

import com.amtkxa.springbootreladomo.usecases.view.CustomerView;
import lombok.Builder;

@Builder
public class Customer extends CustomerAbstract {
  public Customer() {
    super();
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Customer(CustomerView customerView) {
    super();
    this.setCustomerId(customerView.getCustomerId());
    this.setFirstName(customerView.getFirstName());
    this.setLastName(customerView.getLastName());
    this.setCountry(customerView.getCountry());
  }
}
