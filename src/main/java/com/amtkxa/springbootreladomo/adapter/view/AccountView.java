package com.amtkxa.springbootreladomo.adapter.view;

import com.amtkxa.springbootreladomo.domain.entity.Account;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AccountView implements Serializable {
  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's balance.")
  private double balance;

  @Builder.Default
  @JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Tokyo")
  @ApiModelProperty(value = "Date the change actually occurred.")
  private Timestamp businessDate = DateUtils.getCurrentTimestamp();

  public static AccountView fromAccount(Account account) {
    return AccountView.builder()
        .customerId(account.getCustomerId())
        .balance(account.getBalance())
        .businessDate(account.getBusinessDate())
        .build();
  }
}
