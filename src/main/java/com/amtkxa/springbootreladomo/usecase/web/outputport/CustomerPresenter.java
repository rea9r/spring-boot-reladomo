package com.amtkxa.springbootreladomo.usecase.web.outputport;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerList;

import java.util.List;

public interface CustomerPresenter {
  List<? extends CustomerView> response(CustomerList customerList);
}
