package com.amtkxa.springbootreladomo.domain;
import java.sql.Timestamp;
public class SalesOrder extends SalesOrderAbstract
{
	public SalesOrder(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public SalesOrder()
	{
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
	}
}
