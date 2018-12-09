package com.amtkxa.springbootreladomo.adapter.view;

import com.amtkxa.springbootreladomo.domain.entity.Customer;
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

  @ApiModelProperty(value = "Customer's name.")
  private String name;

  @ApiModelProperty(value = "Customer's nationality.")
  private String country;

  @ApiModelProperty(value = "Date the change actually occurred.")
  private String businessDate;

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
        .customerId(customer.getCustomerId())
        .name(customer.getName())
        .country(customer.getCountry())
        .businessDate(DateUtils.print(customer.getBusinessDate()))
        .build();
  }
}
