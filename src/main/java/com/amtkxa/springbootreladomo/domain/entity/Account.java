package com.amtkxa.springbootreladomo.domain.entity;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;

import java.sql.Timestamp;

public class Account extends AccountAbstract {
  public Account(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Account(Timestamp businessDate, int customerId, double balance) {
    super(businessDate);
    this.setCustomerId(customerId);
    this.setBalance(balance);
  }

  public Account(AccountView accountView) {
    super(accountView.getBusinessDate());
    this.setCustomerId(accountView.getCustomerId());
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
