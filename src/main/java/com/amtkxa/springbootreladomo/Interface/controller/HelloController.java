package com.amtkxa.springbootreladomo.Interface.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

  @RequestMapping(method = RequestMethod.GET)
  public String message() {
    return "Spring Boot Reladomo";
  }

  @RequestMapping(method = RequestMethod.GET, value = "{id}")
  public String getId(@PathVariable("id") String id) {
    return id;
  }
}
