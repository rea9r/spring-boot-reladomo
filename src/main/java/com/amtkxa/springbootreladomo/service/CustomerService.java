package com.amtkxa.springbootreladomo.service;

import com.amtkxa.springbootreladomo.domain.entity.CustomerView;

import java.util.List;

public interface CustomerService {

    List<? extends CustomerView> findAll();

    List<? extends CustomerView> findByCustomerId(int customerId);
}
