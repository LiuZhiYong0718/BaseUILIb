package com.janker.uilib.base;


import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import com.janker.uilib.util.ListUtil;


public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected List<T> mData;
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected boolean isEdit = false;
    protected SparseIntArray mSelectedArray;

    public BaseAdapter(Context context) {
        this(context, null);
    }

    public BaseAdapter(Context context, List<T> data) {
        mData = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        mSelectedArray = new SparseIntArray();
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
    }

    public void clearData() {
        mData.clear();
    }

    public void addAllData(List<T> list) {
        if (!ListUtil.isEmpty(list)) {
            mData.addAll(list);
        }
    }

    public void addAllDataAndNorify(List<T> list) {
        this.addAllData(list);
        this.notifyDataSetChanged();
    }

    public void addDataAndNorify(T item) {
        mData.add(item);
        this.notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
        this.mSelectedArray.clear();
    }

    public boolean getEdit() {
        return isEdit;
    }

    public void doSelected(int position) {
        if (mSelectedArray.get(position) > 0) {
            mSelectedArray.put(position, 0);
        } else {
            mSelectedArray.put(position, 1);
        }
    }

    public SparseIntArray getSelectedArray() {
        return mSelectedArray;
    }

    public List<T> getSelectedObjects() {
        List<T> mSelectedList = new ArrayList<T>();
        for (int i = 0; i < getCount(); i++) {
            if (mSelectedArray.get(i) > 0) {
                mSelectedList.add(getItem(i));
            }
        }

        return mSelectedList;
    }

    public int getSelectNum() {
        int num = 0;
        for (int i = 0; i < getCount(); i++) {
            if (mSelectedArray.get(i) > 0) {
                num++;
            }
        }

        return num;
    }

    public void selectAll(boolean isSelected) {
        for (int i = 0; i < getCount(); i++) {
            if (isSelected)
                mSelectedArray.put(i, 1);
            else
                mSelectedArray.put(i, 0);
        }
    }
}
