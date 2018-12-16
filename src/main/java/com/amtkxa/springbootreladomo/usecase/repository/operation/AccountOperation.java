package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

/**
 * The criteria with which {@link AccountFinder}s execute queries against domain models.
 */
@Component
public class AccountOperation {
  // ACCOUNT.CUSTOMER_ID:
  public Operation customerId(int customerId) {
    return AccountFinder.customerId().eq(customerId);
  }

  // ACCOUNT.ACCOUNT_ID:
  public Operation accountId(int accountId) {
    return AccountFinder.accountId().eq(accountId);
  }

  public Operation accountId(AccountView accountView) {
    return AccountFinder.accountId().eq(accountView.getAccountId());
  }

  public Operation accountId(TransactionView transactionView) {
    return AccountFinder.accountId().eq(transactionView.getAccountId());
  }

  // ACCOUNT.ACCOUNT_ID:
  public Operation businessDate(String businessDate) {
    return AccountFinder.businessDate().eq(DateUtils.parse(businessDate));
  }

  // ACCOUNT.BUSINESS_DATE_FROM, ACCOUNT.BUSINESS_DATE_TO:
  public Operation businessDate(AccountView accountView) {
    return AccountFinder.businessDate().eq(accountView.getBusinessDate());
  }

  public Operation businessDate(TransactionView transactionView) {
    return AccountFinder.businessDate().eq(transactionView.getTransactionDate());
  }

  public Operation businessDate() {
    return AccountFinder.businessDate().equalsEdgePoint();
  }

  // ACCOUNT.PROCESSING_DATE_FROM, ACCOUNT.PROCESSING_DATE_TO:
  public Operation processingDate() {
    return AccountFinder.processingDate().equalsInfinity();
  }
}
