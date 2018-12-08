package com.amtkxa.springbootreladomo.presentation.view;

import com.amtkxa.springbootreladomo.data.entity.Customer;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CustomerView implements Serializable {
  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's first name.")
  private String firstName;

  @ApiModelProperty(value = "Customer's last name.")
  private String lastName;

  @ApiModelProperty(value = "Customer's nationality.")
  private String country;

  @ApiModelProperty(value = "Date the change actually occurred.")
  private String businessDate;

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
        .customerId(customer.getCustomerId())
        .firstName(customer.getFirstName())
        .lastName(customer.getLastName())
        .country(customer.getCountry())
        .businessDate(DateUtils.print(customer.getBusinessDate()))
        .build();
  }
}
