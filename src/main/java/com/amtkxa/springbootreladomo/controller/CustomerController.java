package com.amtkxa.springbootreladomo.controller;

import com.amtkxa.springbootreladomo.domain.entity.CustomerView;
import com.amtkxa.springbootreladomo.service.impl.CustomerServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    @NonNull
    private final CustomerServiceImpl customerServiceImpl;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<? extends CustomerView> getCustomerAll() {
        return customerServiceImpl.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<? extends CustomerView> getCustomerById(@PathVariable("id") int customerId) {
        return customerServiceImpl.findByCustomerId(customerId);
    }
}
