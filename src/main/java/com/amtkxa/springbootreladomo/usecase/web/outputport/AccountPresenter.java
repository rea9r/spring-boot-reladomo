package com.amtkxa.springbootreladomo.usecase.web.outputport;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;

import java.util.List;

public interface AccountPresenter {
  /**
   * It retrieves data from repositories (Account model), and formats it for returns a response.
   *
   * @parm accountList
   * @return list of AccountView
   */
  List<? extends AccountView> response(AccountList accountList);
}
