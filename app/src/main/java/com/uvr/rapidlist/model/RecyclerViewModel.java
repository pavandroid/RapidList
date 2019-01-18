package com.uvr.rapidlist.model;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uvr.rapidlist.BR;
import com.uvr.rapidlist.R;
import com.uvr.rapidlistlibrary.model.RapidRowData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pavan on 1/17/2019.
 */

public class RecyclerViewModel {
    public ArrayList<RapidRowData> arrayList = new ArrayList<>();
    public HashMap<Integer, Integer> layoutsHashMap = new HashMap<>();
    public RecyclerView.LayoutManager linearLayoutManager;

    public RecyclerViewModel(Activity mContext) {

        linearLayoutManager = new LinearLayoutManager(mContext);
        ((LinearLayoutManager)linearLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        arrayList.add(new RapidRowModel1(BR.row1, "Am from Row#1 A"));
        arrayList.add(new RapidRowModel2(BR.row2, "Am from Row#2 A"));
        arrayList.add(new RapidRowModel3(BR.row3, "Am from Row#3 A"));
        arrayList.add(new RapidRowModel1(BR.row1, "Am from Row#1 B"));
        arrayList.add(new RapidRowModel2(BR.row2, "Am from Row#2 B"));
        arrayList.add(new RapidRowModel3(BR.row3, "Am from Row#3 B"));
        arrayList.add(new RapidRowModel1(BR.row1, "Am from Row#1 C"));
        arrayList.add(new RapidRowModel2(BR.row2, "Am from Row#2 C"));
        arrayList.add(new RapidRowModel3(BR.row3, "Am from Row#3 C"));

        layoutsHashMap.put(BR.row1, R.layout.layout_row_1);
        layoutsHashMap.put(BR.row2, R.layout.layout_row_2);
        layoutsHashMap.put(BR.row3, R.layout.layout_row_3);
    }
}
