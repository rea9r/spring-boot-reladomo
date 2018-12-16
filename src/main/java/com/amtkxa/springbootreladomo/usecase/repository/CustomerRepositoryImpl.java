package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.domain.entity.Customer;
import com.amtkxa.springbootreladomo.domain.entity.CustomerFinder;
import com.amtkxa.springbootreladomo.domain.entity.CustomerList;
import com.amtkxa.springbootreladomo.domain.repository.CustomerRepository;
import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.usecase.repository.operation.CustomerOperation;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link CustomerRepository} to retrieve and update account data.
 */
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

  @NonNull
  private CustomerOperation op;

  @Override
  public CustomerList findAll() {
    return CustomerFinder.findMany(op.businessDate());
  }

  @Override
  public CustomerList findByCustomerId(int customerId) {
    return CustomerFinder.findMany(op.customerId(customerId).and(op.businessDate()));
  }

  @Override
  public CustomerList create(CustomerView customerView) {
    Customer customer = new Customer(customerView);
    customer.cascadeInsert();
    return new CustomerList(customer);
  }

  @Override
  public CustomerList update(CustomerView customerView) {
    Customer customer = CustomerFinder.findOne(op.customerId(customerView).and(op.businessDate(customerView)));
    customer.setName(customerView.getName());
    customer.setCountry(customerView.getCountry());
    return new CustomerList(customer);
  }

  @Override
  public void terminate(int customerId) {
    Customer customer = CustomerFinder.findOne(op.customerId(customerId).and(op.businessDate()).and(op.processingDate()));
    customer.terminate();
  }

}
