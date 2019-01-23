package com.uvr.rapidlist.model;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uvr.rapidlist.BR;
import com.uvr.rapidlist.R;
import com.uvr.rapidlistlibrary.model.RowInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pavan on 1/17/2019.
 */

public class RecyclerViewModel {
    public ArrayList<Object> arrayList = new ArrayList<>();
    public HashMap<Class, RowInfo> layoutsHashMap = new HashMap<>();
    public RecyclerView.LayoutManager linearLayoutManager;

    public RecyclerViewModel(Activity mContext) {

        linearLayoutManager = new LinearLayoutManager(mContext);
        ((LinearLayoutManager) linearLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        arrayList.add(new RapidRowModel1("Am from Row @Left #1 A"));
        arrayList.add(new RapidRowModel2("Am from Row @Right #2 A"));
        arrayList.add(new RapidRowModel3("Am from Row @Center #3 A"));
        arrayList.add(new RapidRowModel1("Am from Row @Left #1 B"));
        arrayList.add(new RapidRowModel2("Am from Row @Right #2 B"));
        arrayList.add(new RapidRowModel3("Am from Row @Center #3 B"));
        arrayList.add(new RapidRowModel1("Am from Row @Left #1 C"));
        arrayList.add(new RapidRowModel2("Am from Row @Right #2 C"));
        arrayList.add(new RapidRowModel3("Am from Row @Center #3 C"));

        layoutsHashMap.put(RapidRowModel1.class, new RowInfo(BR.row1, R.layout.layout_row_1));
        layoutsHashMap.put(RapidRowModel2.class, new RowInfo(BR.row2, R.layout.layout_row_2));
        layoutsHashMap.put(RapidRowModel3.class, new RowInfo(BR.row3, R.layout.layout_row_3));
    }
}
