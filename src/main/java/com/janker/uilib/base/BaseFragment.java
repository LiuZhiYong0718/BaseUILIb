package com.janker.uilib.base;


import com.janker.uilib.ViewUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 封装Fragment
 * @author cui weijie
 *
 */
public abstract class BaseFragment extends Fragment {

    protected int RESULT_OK = Activity.RESULT_OK;

	/**
     * 获得资源文件中的视图
     * @return 资源视图
     */
    protected abstract int getContentView();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getContentView(),
                container, false);
        ViewUtils.inject(this, rootView);
        return rootView;
    }

    protected void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public final void setResult(int resultCode, Intent data) {
        if (getActivity() != null) {
            getActivity().setResult(resultCode, data);
        }
    }

    public final void setResult(int resultCode) {
        if (getActivity() != null) {
            getActivity().setResult(resultCode);
        }
    }

}
