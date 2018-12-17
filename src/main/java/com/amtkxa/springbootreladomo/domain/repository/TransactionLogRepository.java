package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.TransactionLog;
import com.amtkxa.springbootreladomo.domain.entity.TransactionLogList;

/**
 * Interface that represents a Repository for getting {@link TransactionLog} related data.
 */
public interface TransactionLogRepository {

  TransactionLogList findByAccountId(int accountId);

  TransactionLogList create(TransactionView transactionView);

}
