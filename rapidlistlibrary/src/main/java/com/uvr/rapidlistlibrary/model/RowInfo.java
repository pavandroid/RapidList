package com.uvr.rapidlistlibrary.model;

/**
 * Created by pavan on 1/17/2019.
 */

public class RowInfo {
    public final int rowType;
    public final int layoutId;

    public RowInfo(int rowType, int layoutId) {
        this.rowType = rowType;
        this.layoutId = layoutId;
    }

    public int getRowType() {
        return rowType;
    }

    public int getLayoutId() {
        return layoutId;
    }
}
