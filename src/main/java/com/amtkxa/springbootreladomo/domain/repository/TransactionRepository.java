package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.Transaction;
import com.amtkxa.springbootreladomo.domain.entity.TransactionList;

/**
 * Interface that represents a Repository for getting {@link Transaction} related data.
 */
public interface TransactionRepository {

  TransactionList findByAccountId(int accountId);

  TransactionList create(TransactionView transactionView);

}
