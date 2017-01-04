package com.garry.keepaccounts.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.garry.keepaccounts.R;
import com.garry.keepaccounts.presenter.interfaces.KeepPresenter;
import com.garry.keepaccounts.view.adapter.KeepAdapter;

import butterknife.BindView;


public class KeepFragment extends BaseFragment<KeepPresenter> {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.fab)
    FloatingActionButton mFABtn;

    public KeepFragment() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_keep;
    }

    @Override
    public void initViews(View view) {
        mListener.onKeepToolBar(mToolbar);
        mViewPager.setAdapter(new KeepAdapter(getActivity(),getActivity().getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnKeepAccountListener) {
            mListener = (OnKeepAccountListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private OnKeepAccountListener mListener;

    public interface OnKeepAccountListener {
        void onKeepToolBar(Toolbar toolbar);
    }
}
