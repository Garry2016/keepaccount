package com.garry.keepaccounts.presenter.interfaces;


import android.support.annotation.NonNull;

import com.garry.keepaccounts.view.BaseView;

public interface BasePresenter {

    void onCreate();

    void attachView(@NonNull BaseView baseView);

    void onDestroy();

}
