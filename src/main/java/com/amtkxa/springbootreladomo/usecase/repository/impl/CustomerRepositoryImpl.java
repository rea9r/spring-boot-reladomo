package com.amtkxa.springbootreladomo.usecase.repository.impl;

import com.amtkxa.springbootreladomo.domain.model.Customer;
import com.amtkxa.springbootreladomo.domain.model.CustomerFinder;
import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.usecase.repository.CustomerRepository;
import com.amtkxa.springbootreladomo.usecase.view.CustomerView;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  @Override
  public CustomerList findAll() {
    CustomerList customerList = new CustomerList(CustomerFinder.businessDate().equalsEdgePoint());
    return customerList == null ? null : customerList;
  }

  @Override
  public CustomerList findByCustomerId(int customerId) {
    Operation id = CustomerFinder.customerId().eq(customerId);
    Operation ts = CustomerFinder.businessDate().equalsEdgePoint();
    return CustomerFinder.findMany(id.and(ts));
  }

  @Override
  public CustomerList create(CustomerView customerView) {
    Customer customer = new Customer(customerView);
    customer.cascadeInsert();
    return new CustomerList(customer);
  }

  @Override
  public CustomerList update(CustomerView customerView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      // fetch data with businessDate
      Operation id = CustomerFinder.customerId().eq(customerView.getCustomerId());
      Operation ts = CustomerFinder.businessDate().eq(DateUtils.parse(customerView.getBussinesDate()));
      Customer customer = CustomerFinder.findOne(id.and(ts));
      // update
      customer.setFirstName(customerView.getFirstName());
      customer.setLastName(customerView.getLastName());
      customer.setCountry(customerView.getCountry());
      return null;
    });
    return findByCustomerId(customerView.getCustomerId());
  }
}
