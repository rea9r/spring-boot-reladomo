package com.amtkxa.springbootreladomo.domain.entity;

import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.presentation.view.AccountView;

import java.sql.Timestamp;

public class Account extends AccountAbstract {
  public Account(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Account(AccountView accountView) {
    super(DateUtils.parse(accountView.getBusinessDate()));
    this.setAccountId(accountView.getAccountId());
    this.setCustomerId(accountView.getCustomerId());
    this.setBalance(accountView.getBalance());
  }

  public Account(Timestamp businessDate) {
    super(businessDate);
  }
}
