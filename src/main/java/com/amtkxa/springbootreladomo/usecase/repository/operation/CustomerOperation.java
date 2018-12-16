package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerFinder;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

/**
 * The criteria with which {@link CustomerFinder}s execute queries against domain models.
 */
@Component
public class CustomerOperation {
  // CUSTOMER.CUSTOMER_ID:
  public Operation customerId(int customerId) {
    return CustomerFinder.customerId().eq(customerId);
  }

  public Operation customerId(CustomerView customerView) {
    return CustomerFinder.customerId().eq(customerView.getCustomerId());
  }

  // CUSTOMER.BUSINESS_DATE_FROM, CUSTOMER.BUSINESS_DATE_TO:
  public Operation businessDate(CustomerView customerView) {
    return CustomerFinder.businessDate().eq(customerView.getBusinessDate());
  }

  public Operation businessDate() {
    return CustomerFinder.businessDate().equalsEdgePoint();
  }

  // CUSTOMER.PROCESSING_DATE_FROM, CUSTOMER.PROCESSING_DATE_TO:
  public Operation processingDate() {
    return CustomerFinder.processingDate().equalsInfinity();
  }
}
