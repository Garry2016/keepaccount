package com.garry.keepaccounts.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.garry.keepaccounts.R;

import butterknife.BindView;

/**
 * Created by admin on 2017/1/3.
 */

public class KeepItemFragment extends BaseFragment {

    private static final String ARG_KEEP_ITEM_TYPE = "ARG_KEEP_ITEM_TYPE";
    private static final String TAG = "KeepItemFragment";
    @BindView(R.id.keep_content_tv)
    TextView mContentTV;

    private int mType;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_keep_items;
    }

    @Override
    public void initViews(View view) {
        mContentTV.setText("item" + mType);
        Log.d(TAG, "initViews: "+mType);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt(ARG_KEEP_ITEM_TYPE);
    }

    public static KeepItemFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(ARG_KEEP_ITEM_TYPE, type);
        KeepItemFragment fragment = new KeepItemFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
