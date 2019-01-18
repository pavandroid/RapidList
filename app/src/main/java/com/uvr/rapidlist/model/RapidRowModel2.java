package com.uvr.rapidlist.model;

import com.uvr.rapidlistlibrary.model.RapidRowData;

/**
 * Created by pavan on 1/17/2019.
 */

public class RapidRowModel2 extends RapidRowData {
    public String name;

    protected RapidRowModel2(int rowType, String name) {
        super(rowType);
        this.name = name;
    }
}
