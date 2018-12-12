package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

@Component
public class AccountOperation {
  public Operation id(int accountId) {
    return AccountFinder.accountId().eq(accountId);
  }

  public Operation id(AccountView accountView) {
    return AccountFinder.accountId().eq(accountView.getAccountId());
  }

  public Operation id(TransactionView transactionView) {
    return AccountFinder.accountId().eq(transactionView.getAccountId());
  }

  public Operation bDate(String businessDate) {
    return AccountFinder.businessDate().eq(DateUtils.parse(businessDate));
  }

  public Operation bDate(AccountView accountView) {
    return AccountFinder.businessDate().eq(DateUtils.parse(accountView.getBusinessDate()));
  }

  public Operation bDate(TransactionView transactionView) {
    return AccountFinder.businessDate().eq(DateUtils.parse(transactionView.getTransactionDate()));
  }

  public Operation bDate() {
    return AccountFinder.businessDate().equalsEdgePoint();
  }

  public Operation pDate() {
    return AccountFinder.processingDate().equalsInfinity();
  }
}
