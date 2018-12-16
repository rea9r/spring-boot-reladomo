package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

@Component
public class CustomerOperation {
  public Operation customerId(int customerId) {
    return CustomerFinder.customerId().eq(customerId);
  }

  public Operation customerId(CustomerView customerView) {
    return CustomerFinder.customerId().eq(customerView.getCustomerId());
  }

  public Operation businessDate(CustomerView customerView) {
    return CustomerFinder.businessDate().eq(customerView.getBusinessDate());
  }

  public Operation businessDate() {
    return CustomerFinder.businessDate().equalsEdgePoint();
  }

  public Operation processingDate() {
    return CustomerFinder.processingDate().equalsInfinity();
  }
}
