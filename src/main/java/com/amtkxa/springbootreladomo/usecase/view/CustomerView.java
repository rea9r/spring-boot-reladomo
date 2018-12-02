package com.amtkxa.springbootreladomo.usecase.view;

import com.amtkxa.springbootreladomo.domain.model.Customer;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerView {
  private int customerId;
  private String firstName;
  private String lastName;
  private String country;
  private String bussinesDate;

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
            .customerId(customer.getCustomerId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .country(customer.getCountry())
            .bussinesDate(DateUtils.print(customer.getBusinessDate()))
            .build();
  }
}
