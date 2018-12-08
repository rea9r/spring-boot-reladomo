package com.amtkxa.springbootreladomo.usecase.aggregate;

import com.amtkxa.springbootreladomo.domain.entity.Account;
import com.amtkxa.springbootreladomo.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.domain.repository.AccountRepository;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Repository;

/**
 * {@link AccountRepository} for retrieving account data.
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Override
  public AccountList findAll() {
    Operation ts = AccountFinder.businessDate().equalsEdgePoint();
    return AccountFinder.findMany(ts);
  }

  @Override
  public AccountList findByAccountId(int accountId) {
    Operation id = AccountFinder.customerId().eq(accountId);
    Operation ts = AccountFinder.businessDate().equalsEdgePoint();
    return AccountFinder.findMany(id.and(ts));
  }

  @Override
  public AccountList create(AccountView accountView) {
    Account account = new Account(accountView);
    account.cascadeInsert();
    return new AccountList(account);
  }

  @Override
  public AccountList update(AccountView accountView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      // fetch data with businessDate
      Operation id = AccountFinder.customerId().eq(accountView.getCustomerId());
      Operation ts = AccountFinder.businessDate().eq(DateUtils.parse(accountView.getBusinessDate()));
      Account account = AccountFinder.findOne(id.and(ts));
      // update
      account.setBalance(accountView.getBalance());
      return null;
    });
    return findByAccountId(accountView.getCustomerId());
  }

  @Override
  public void terminate(AccountView accountView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Operation id = AccountFinder.customerId().eq(accountView.getCustomerId());
      Operation bts = AccountFinder.businessDate().eq(DateUtils.parse(accountView.getBusinessDate()));
      Operation pts = AccountFinder.processingDate().equalsInfinity();
      Account account = AccountFinder.findOne(id.and(bts).and(pts));
      account.terminate();
      return null;
    });
  }
}
