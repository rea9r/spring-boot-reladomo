package com.amtkxa.springbootreladomo.adapter.view;

import com.amtkxa.springbootreladomo.domain.entity.Customer;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerView implements Serializable {
  @JsonIgnore
  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's name.")
  private String name;

  @ApiModelProperty(value = "Customer's nationality.")
  private String country;

  @Builder.Default
  @ApiModelProperty(value = "Date the change actually occurred.")
  private Timestamp businessDate = DateUtils.getCurrentTimestamp();

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
        .customerId(customer.getCustomerId())
        .name(customer.getName())
        .country(customer.getCountry())
        .businessDate(customer.getBusinessDate())
        .build();
  }
}
