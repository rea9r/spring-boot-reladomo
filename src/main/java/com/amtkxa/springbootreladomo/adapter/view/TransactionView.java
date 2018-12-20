package com.amtkxa.springbootreladomo.adapter.view;

import com.amtkxa.springbootreladomo.domain.entity.TransactionType;
import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionView implements Serializable {
  @JsonIgnore
  @ApiModelProperty(value = "Transaction ID.")
  private int transactionId;

  @JsonIgnore
  @Enumerated(EnumType.STRING)
  @ApiModelProperty(value = "The type of transaction.")
  private TransactionType transactionType;

  @Builder.Default
  @ApiModelProperty(value = "Date the change actually occurred.")
  private Timestamp transactionDate = DateUtils.getCurrentTimestamp();

  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Transaction amount.")
  private double amount;

}
