package com.garry.keepaccounts.view.fragment;

import android.view.View;

import com.garry.keepaccounts.R;
import com.garry.keepaccounts.presenter.interfaces.AccountsPresenter;

/**
 * Created by admin on 2017/1/3.
 */

public class AccountsFragment extends BaseFragment<AccountsPresenter> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_accounts;
    }

    @Override
    public void initViews(View view) {

    }
}
