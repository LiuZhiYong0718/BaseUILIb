package com.janker.uilib.base;


import com.janker.uilib.view.LoadingView;

import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * 根Activity，所有Activity都继承此Activity
 */
public abstract class BaseActivity extends FragmentActivity {

    protected boolean isDestroy;
    private LoadingView mLoadingView;

    @Override
    protected void onDestroy() {
        isDestroy = true;
        super.onDestroy();
    }
   
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        addLoadingLayout();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        addLoadingLayout();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        addLoadingLayout();
    }

    private void addLoadingLayout() {
        mLoadingView = new LoadingView(getBaseContext());
        mLoadingView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        hideLoadingView();
        addContentView(mLoadingView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void showLoadingView() {
        showLoadingView(null);
    }

    public void showLoadingView(int res) {
        showLoadingView(getString(res));
    }

    public void showLoadingView(String msg) {
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingView.setMsg(msg);
    }

    public void hideLoadingView() {
        mLoadingView.setVisibility(View.GONE);
    }
    

}
