package com.amtkxa.springbootreladomo.service.impl;

import com.amtkxa.springbootreladomo.domain.entity.CustomerView;
import com.amtkxa.springbootreladomo.domain.model.CustomerFinder;
import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<? extends CustomerView> findAll() {
        CustomerList customerList = new CustomerList(CustomerFinder.all());
        return customerList
                .stream()
                .filter(c -> c != null)
                .map(c -> CustomerView.fromCustomer(c))
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends CustomerView> findByCustomerId(int customerId) {
        CustomerList customerList = CustomerFinder.findMany(CustomerFinder.customerId().eq(customerId));
        return customerList
                .stream()
                .filter(c -> c != null)
                .map(c -> CustomerView.fromCustomer(c))
                .collect(Collectors.toList());
    }
}
