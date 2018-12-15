package com.amtkxa.springbootreladomo.domain.entity;
import com.gs.fw.finder.Operation;
import java.util.*;
public class TransactionLogList extends TransactionLogListAbstract
{
	public TransactionLogList()
	{
		super();
	}

	public TransactionLogList(int initialSize)
	{
		super(initialSize);
	}

	public TransactionLogList(Collection c)
	{
		super(c);
	}

	public TransactionLogList(Operation operation)
	{
		super(operation);
	}
}
