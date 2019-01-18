package com.uvr.rapidlistlibrary.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pavan on 1/17/2019.
 */

public class RapidRecyclerView extends RecyclerView {

    private ArrayList arrayList;
    private Context mContext;
    private HashMap<Integer, Integer> layoutsHashMap;

    public RapidRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public RapidRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RapidRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
    }

    public void setContentArray(ArrayList arrayList) {
        this.arrayList = arrayList;
        initSetAdapter();
    }

    public void setRowLayouts(HashMap layoutsHashMap) {
        this.layoutsHashMap = layoutsHashMap;
        initSetAdapter();
    }

    private void initSetAdapter() {
        if (arrayList != null && layoutsHashMap != null) {
            if (getAdapter() == null) {
                setAdapter(new RapidRecyclerAdapter(arrayList, layoutsHashMap));
            } else {
                getAdapter().notifyDataSetChanged();
            }
        }
    }
}
