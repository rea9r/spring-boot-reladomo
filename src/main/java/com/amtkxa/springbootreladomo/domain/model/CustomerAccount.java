package com.amtkxa.springbootreladomo.domain.model;

import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;

import java.sql.Timestamp;

public class CustomerAccount extends CustomerAccountAbstract {
  public CustomerAccount(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public CustomerAccount(CustomerAccountView customerAccountView) {
    super(DateUtils.parse(customerAccountView.getBusinessDate()));
    this.setAccountId(customerAccountView.getAccountId());
    this.setCustomerId(customerAccountView.getCustomerId());
    this.setAccountName(customerAccountView.getAccountName());
    this.setAccountType(customerAccountView.getAccountType());
    this.setBalance(customerAccountView.getBalance());
  }

  public CustomerAccount(Timestamp businessDate) {
    super(businessDate);
  }
}
