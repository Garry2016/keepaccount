package com.garry.keepaccounts.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.garry.keepaccounts.R;
import com.garry.keepaccounts.presenter.interfaces.BasePresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;

    public abstract int getLayoutId();

    public abstract void initVariables();

    public abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();

        setContentView(layoutId);
        initVariables();
        ButterKnife.bind(this);
        initToolBar();
        initViews();
        if(mPresenter != null){
            mPresenter.onCreate();
        }
    }

    protected void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
    }


}
