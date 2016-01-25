package com.janker.uilib.base;


import com.janker.uilib.ViewUtils;

import android.os.Bundle;

/**
 * 根Activity，所有Activity都继承此Activity
 */
public abstract class SimpleBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        ViewUtils.inject(this);
    }

    public abstract int getContentViewResId();

}
