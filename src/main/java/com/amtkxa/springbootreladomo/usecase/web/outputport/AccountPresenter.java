package com.amtkxa.springbootreladomo.usecase.web.outputport;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;

import java.util.List;

public interface AccountPresenter {
  List<? extends AccountView> response(AccountList accountList);
}
