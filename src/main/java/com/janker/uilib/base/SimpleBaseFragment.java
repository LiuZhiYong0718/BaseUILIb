package com.janker.uilib.base;



public abstract class SimpleBaseFragment extends BaseFragment {

    public void showActivityLoadingView() {
        if (getActivity() != null && getActivity() instanceof SimpleBaseActivity) {
            ((SimpleBaseActivity) getActivity()).showLoadingView();
        }
    }

    public void showActivityLoadingView(int res) {
        if (getActivity() != null && getActivity() instanceof SimpleBaseActivity) {
            ((SimpleBaseActivity) getActivity()).showLoadingView(res);
        }
    }

    public void hideActivityLoadingView() {
        if (getActivity() != null && getActivity() instanceof SimpleBaseActivity) {
            ((SimpleBaseActivity) getActivity()).hideLoadingView();
        }
    }
}
