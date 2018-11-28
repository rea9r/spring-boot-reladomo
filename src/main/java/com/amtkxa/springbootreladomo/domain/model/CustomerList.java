package com.amtkxa.springbootreladomo.domain.model;

import com.gs.fw.finder.Operation;

import java.util.Collection;
public class CustomerList extends CustomerListAbstract
{
	public CustomerList()
	{
		super();
	}

	public CustomerList(int initialSize)
	{
		super(initialSize);
	}

	public CustomerList(Collection c)
	{
		super(c);
	}

	public CustomerList(Operation operation)
	{
		super(operation);
	}

}
