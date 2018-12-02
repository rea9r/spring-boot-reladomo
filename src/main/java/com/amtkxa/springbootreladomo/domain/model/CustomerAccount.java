package com.amtkxa.springbootreladomo.domain.model;
import java.sql.Timestamp;
public class CustomerAccount extends CustomerAccountAbstract
{
	public CustomerAccount(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public CustomerAccount(Timestamp businessDate)
	{
		super(businessDate);
	}
}
