package com.garry.keepaccounts.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.garry.keepaccounts.view.fragment.KeepItemFragment;

/**
 * Created by admin on 2017/1/3.
 */

public class KeepAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private final static int PAGE_COUNT = 4;

    public KeepAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        int type;
        switch (position){
            case 0:
                type = 0;
                break;
            case 1:
                type = 1;
                break;
            case 2:
                type = 2;
                break;
            case 3:
                type = 3;
                break;
            default:
                type = 0;
                break;
        }

        return KeepItemFragment.newInstance(type);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "记账";
            case 1:
                return "报表";
            case 2:
                return "资金";
            case 3:
                return "提醒";
            default:
                return "记账";
        }
    }
}
