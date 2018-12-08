package com.amtkxa.springbootreladomo.usecase.repository.impl;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccount;
import com.amtkxa.springbootreladomo.domain.model.CustomerAccountFinder;
import com.amtkxa.springbootreladomo.domain.model.CustomerAccountList;
import com.amtkxa.springbootreladomo.domain.model.CustomerFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.usecase.repository.CustomerAccountRepository;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAccountRepositoryImpl implements CustomerAccountRepository {

  @Override
  public CustomerAccountList findAll() {
    Operation ts = CustomerAccountFinder.businessDate().equalsEdgePoint();
    return CustomerAccountFinder.findMany(ts);
  }

  @Override
  public CustomerAccountList findByCustomerId(int customerId) {
    Operation id = CustomerAccountFinder.customerId().eq(customerId);
    Operation ts = CustomerAccountFinder.businessDate().equalsEdgePoint();
    return CustomerAccountFinder.findMany(id.and(ts));
  }

  @Override
  public CustomerAccountList create(CustomerAccountView customerAccountView) {
    CustomerAccount customerAccount = new CustomerAccount(customerAccountView);
    customerAccount.cascadeInsert();
    return new CustomerAccountList(customerAccount);
  }

  @Override
  public CustomerAccountList update(CustomerAccountView customerAccountView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      // fetch data with businessDate
      Operation id = CustomerFinder.customerId().eq(customerAccountView.getCustomerId());
      Operation ts = CustomerFinder.businessDate().eq(DateUtils.parse(customerAccountView.getBusinessDate()));
      CustomerAccount customerAccount = CustomerAccountFinder.findOne(id.and(ts));
      // update
      customerAccount.setAccountName(customerAccountView.getAccountName());
      customerAccount.setAccountType(customerAccountView.getAccountType());
      customerAccount.setBalance(customerAccountView.getBalance());
      return null;
    });
    return findByCustomerId(customerAccountView.getCustomerId());
  }

  @Override
  public void terminate(CustomerAccountView customerAccountView) {}
}
