package com.amtkxa.springbootreladomo.usecase.web.outputport;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerList;

import java.util.List;

public interface CustomerPresenter {
  /**
   * It retrieves data from repositories (Customer model), and formats it for returns a response.
   *
   * @parm customerList
   * @return list of CustomerView
   */
  List<? extends CustomerView> response(CustomerList customerList);
}
