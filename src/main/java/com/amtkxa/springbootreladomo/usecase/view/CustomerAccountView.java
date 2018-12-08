package com.amtkxa.springbootreladomo.usecase.view;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccount;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CustomerAccountView implements Serializable {
  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's account name.")
  private String accountName;

  @ApiModelProperty(value = "Customer's account type.")
  private String accountType;

  @ApiModelProperty(value = "Customer's balance.")
  private double balance;

  @ApiModelProperty(value = "Date the change actually occurred.")
  private String businessDate;

  public static CustomerAccountView fromCustomerAccount(CustomerAccount customerAccount) {
    return CustomerAccountView.builder()
        .accountId(customerAccount.getAccountId())
        .customerId(customerAccount.getCustomerId())
        .accountName(customerAccount.getAccountName())
        .accountType(customerAccount.getAccountType())
        .balance(customerAccount.getBalance())
        .businessDate(DateUtils.print(customerAccount.getBusinessDate()))
        .build();
  }
}
