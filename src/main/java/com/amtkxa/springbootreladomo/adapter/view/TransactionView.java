package com.amtkxa.springbootreladomo.adapter.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionView {
  @ApiModelProperty(value = "Transaction type.")
  private String type;

  @ApiModelProperty(value = "Date the change actually occurred.")
  private String transactionDate;

  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Customer's balance.")
  private double amount;
}
