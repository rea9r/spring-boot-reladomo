package com.amtkxa.springbootreladomo.domain.model;

import com.amtkxa.springbootreladomo.infrastructure.util.DateUtils;
import com.amtkxa.springbootreladomo.usecase.view.CustomerView;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;

public class Customer extends CustomerAbstract {
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("YYYY-MM-DD");

  public Customer(Timestamp businessDate, Timestamp processingDate) {
    super(businessDate, processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Customer(CustomerView customerView) {
    super(DateUtils.parse(customerView.getBusinessDate()));
    this.setCustomerId(customerView.getCustomerId());
    this.setFirstName(customerView.getFirstName());
    this.setLastName(customerView.getLastName());
    this.setCountry(customerView.getCountry());
  }

  public Customer(Timestamp businessDate) {
    super(businessDate);
  }

  public Timestamp parse(String dateTimeString) {
    DateTime dateTime = DATE_TIME_FORMATTER.parseDateTime(dateTimeString);
    return new Timestamp(dateTime.toDateTime().getMillis());
  }
}
