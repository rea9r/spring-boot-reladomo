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
 * {@link CustomerRepository} for retrieving customer data.
 */
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

  @NonNull
  private CustomerOperation op;

  @Override
  public CustomerList findAll() {
    Operation ts = CustomerFinder.businessDate().equalsEdgePoint();
    return CustomerFinder.findMany(ts);
  }

  @Override
  public CustomerList findByCustomerId(int customerId) {
    return CustomerFinder.findMany(op.customerId(customerId).and(op.businessDate()));
  }

  @Override
  public CustomerList create(CustomerView customerView) {
    Customer result = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Customer customer = new Customer(customerView);
      customer.cascadeInsert();
      return customer;
    });
    return new CustomerList(result);
  }

  @Override
  public CustomerList update(CustomerView customerView) {
    Customer result = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Customer customer = CustomerFinder.findOne(op.customerId(customerView).and(op.businessDate(customerView)));
      customer.setName(customerView.getName());
      customer.setCountry(customerView.getCountry());
      return customer;
    });
    return new CustomerList(result);
  }

  @Override
  public void terminate(CustomerView customerView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Customer customer = CustomerFinder.findOne(op.customerId(customerView).and(op.businessDate(customerView)).and(op.processingDate()));
      customer.terminate();
      return null;
    });
  }

}
