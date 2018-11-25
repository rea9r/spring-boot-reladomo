package com.amtkxa.springbootreladomo.domain.model;
import java.sql.Timestamp;
public class Item extends ItemAbstract
{
	public Item(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public Item()
	{
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
	}
}
