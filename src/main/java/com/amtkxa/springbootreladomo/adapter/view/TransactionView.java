package com.amtkxa.springbootreladomo.adapter.view;

import com.amtkxa.springbootreladomo.domain.entity.TransactionType;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Builder
@Data
public class TransactionView {
  @JsonIgnore
  @Enumerated(EnumType.STRING)
  @ApiModelProperty(value = "Transaction transactionType.")
  private TransactionType transactionType;

  @ApiModelProperty(value = "Date the change actually occurred.")
  private Timestamp transactionDate;

  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Customer's balance.")
  private double amount;
}
