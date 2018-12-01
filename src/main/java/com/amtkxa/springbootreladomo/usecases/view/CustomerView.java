package com.amtkxa.springbootreladomo.usecases.view;

import com.amtkxa.springbootreladomo.domain.model.Customer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerView {
  private int customerId;
  private String firstName;
  private String lastName;
  private String country;

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
            .customerId(customer.getCustomerId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .country(customer.getCountry())
            .build();
  }
}
