package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

@Component
public class CustomerOperation {
  public Operation id(int customerId) {
    return CustomerFinder.customerId().eq(customerId);
  }

  public Operation id(CustomerView customerView) {
    return CustomerFinder.customerId().eq(customerView.getCustomerId());
  }

  public Operation bDate(CustomerView customerView) {
    return CustomerFinder.businessDate().eq(DateUtils.parse(customerView.getBusinessDate()));
  }

  public Operation pDate() {
    return CustomerFinder.processingDate().equalsInfinity();
  }
}
