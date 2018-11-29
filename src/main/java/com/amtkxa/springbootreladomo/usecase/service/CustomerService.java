package com.amtkxa.springbootreladomo.usecase.service;

import com.amtkxa.springbootreladomo.usecase.view.CustomerView;

import java.util.List;

public interface CustomerService {

    List<? extends CustomerView> findAll();

    List<? extends CustomerView> findByCustomerId(int customerId);
}
