package com.garry.keepaccounts.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.garry.keepaccounts.R;
import com.garry.keepaccounts.view.fragment.AccountsFragment;
import com.garry.keepaccounts.view.fragment.BaseFragment;
import com.garry.keepaccounts.view.fragment.ExportFragment;
import com.garry.keepaccounts.view.fragment.KeepFragment;
import com.garry.keepaccounts.view.fragment.SkinFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, KeepFragment.OnKeepAccountListener {

    private final static String CHILD_FRAGMENT_TAG_KEEP = "child_keep";
    private final static String CHILD_FRAGMENT_TAG_ACCOUNTS = "child_accounts";
    private final static String CHILD_FRAGMENT_TAG_EXPORT = "child_export";
    private final static String CHILD_FRAGMENT_TAG_SKIN = "child_skin";

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    private String mChildFragmentType;

    private KeepFragment mKeepFragment;
    private AccountsFragment mAccountsFragment;
    private ExportFragment mExportFragment;
    private SkinFragment mSkinFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariables() {
        mKeepFragment = new KeepFragment();
        mAccountsFragment = new AccountsFragment();
        mExportFragment = new ExportFragment();
        mSkinFragment = new SkinFragment();
    }

    @Override
    public void initViews() {
        mNavigationView.setNavigationItemSelectedListener(this);
        mChildFragmentType = mChildFragmentType == null ? CHILD_FRAGMENT_TAG_KEEP : mChildFragmentType;
        setDefaultFragment(mChildFragmentType);
    }

    private void setDefaultFragment(String childFragmentTag) {
        switch (childFragmentTag) {
            case CHILD_FRAGMENT_TAG_KEEP:
                mNavigationView.setCheckedItem(R.id.nav_keep);
                break;
            case CHILD_FRAGMENT_TAG_ACCOUNTS:
                mNavigationView.setCheckedItem(R.id.nav_accounts);
                break;
            case CHILD_FRAGMENT_TAG_EXPORT:
                mNavigationView.setCheckedItem(R.id.nav_export);
                break;
            case CHILD_FRAGMENT_TAG_SKIN:
                mNavigationView.setCheckedItem(R.id.nav_skin);
                break;
            default:
                mNavigationView.setCheckedItem(R.id.nav_keep);
                break;
        }
        setChildFragment(childFragmentTag);
    }

    private void setChildFragment(String childFragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (mChildFragmentType.equals(childFragmentTag)) {
            BaseFragment childFragment = (BaseFragment) fragmentManager.findFragmentByTag(childFragmentTag);
            if (childFragment == null) {
                childFragment = getChildFragmentByTag(childFragmentTag);
            } else {
                if (getChildFragmentByTag(childFragmentTag) != childFragment) {
                    fragmentTransaction.remove(childFragment);
                    childFragment = getChildFragmentByTag(childFragmentTag);
                }
            }
            if (!childFragment.isAdded()) {
                fragmentTransaction.add(R.id.show_content_layout, childFragment, childFragmentTag);
            }
            if (childFragment.isHidden()) {
                fragmentTransaction.show(childFragment);
            }
        } else {
            BaseFragment childFragment = (BaseFragment) fragmentManager.findFragmentByTag(mChildFragmentType);
            if (childFragment != null) {
                fragmentTransaction.hide(childFragment);
            }
            BaseFragment addFragment = (BaseFragment) fragmentManager.findFragmentByTag(childFragmentTag);
            if (addFragment == null) {
                addFragment = getChildFragmentByTag(childFragmentTag);
            } else {
                if (getChildFragmentByTag(childFragmentTag) != addFragment) {
                    fragmentTransaction.remove(addFragment);
                    addFragment = getChildFragmentByTag(childFragmentTag);
                }
            }
            if (!addFragment.isAdded()) {
                fragmentTransaction.add(R.id.show_content_layout, addFragment, childFragmentTag);
            }
            fragmentTransaction.show(addFragment);
        }
        mChildFragmentType = childFragmentTag;
        fragmentTransaction.commit();
    }

    private BaseFragment getChildFragmentByTag(String childFragmentTag) {
        switch (childFragmentTag) {
            case CHILD_FRAGMENT_TAG_ACCOUNTS:
                return mAccountsFragment;
            case CHILD_FRAGMENT_TAG_EXPORT:
                return mExportFragment;
            case CHILD_FRAGMENT_TAG_SKIN:
                return mSkinFragment;
            case CHILD_FRAGMENT_TAG_KEEP:
            default:
                return mKeepFragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_keep) {
            setChildFragment(CHILD_FRAGMENT_TAG_KEEP);
        } else if (id == R.id.nav_accounts) {
            setChildFragment(CHILD_FRAGMENT_TAG_ACCOUNTS);
        } else if (id == R.id.nav_export) {
            setChildFragment(CHILD_FRAGMENT_TAG_EXPORT);
        } else if (id == R.id.nav_skin) {
            setChildFragment(CHILD_FRAGMENT_TAG_SKIN);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onKeepToolBar(Toolbar toolbar) {
        toolbar.setTitle("keep");
        setToolbar(toolbar);
    }

    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }
}
