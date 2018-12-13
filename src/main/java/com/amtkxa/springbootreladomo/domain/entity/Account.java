package com.amtkxa.springbootreladomo.domain.entity;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;

import java.sql.Timestamp;

public class Account extends AccountAbstract {
  public Account(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Account(AccountView accountView) {
    super(DateUtils.parse(accountView.getBusinessDate()));
    this.setBalance(accountView.getBalance());
  }

  public Account(Timestamp businessDate) {
    super(businessDate);
  }

  public void deposit(TransactionView transactionView) {
    this.incrementBalance(transactionView.getAmount());
  }

  public void withdrawal(TransactionView transactionView) {
    this.incrementBalance(transactionView.getAmount() * -1);
  }
}
