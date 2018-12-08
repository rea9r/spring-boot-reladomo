package com.amtkxa.springbootreladomo.domain.entity;

import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.presentation.view.CustomerView;

import java.sql.Timestamp;

public class Customer extends CustomerAbstract {
  public Customer(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Customer(CustomerView customerView) {
    super(DateUtils.parse(customerView.getBusinessDate()));
    this.setCustomerId(customerView.getCustomerId());
    this.setFirstName(customerView.getFirstName());
    this.setLastName(customerView.getLastName());
    this.setCountry(customerView.getCountry());
  }

  public Customer(Timestamp businessDate) {
    super(businessDate);
  }
}
