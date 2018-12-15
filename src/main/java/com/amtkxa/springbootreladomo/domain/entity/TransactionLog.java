package com.amtkxa.springbootreladomo.domain.entity;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;

public class TransactionLog extends TransactionLogAbstract {
  public TransactionLog() {
    super();
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public TransactionLog(TransactionView transactionView) {
    super();
    this.setAccountId(transactionView.getAccountId());
    this.setTransactionType(transactionView.getTransactionType().toString());
    this.setAmount(transactionView.getAmount());
    this.setProcessingDate(DateUtils.getCurrentTimestamp());
  }
}
