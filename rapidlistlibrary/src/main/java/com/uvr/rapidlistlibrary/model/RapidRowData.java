package com.uvr.rapidlistlibrary.model;

/**
 * Created by pavan on 1/17/2019.
 */

public abstract class RapidRowData {
    public final int ROW_TYPE;

    protected RapidRowData(int rowType) {
        ROW_TYPE = rowType;
    }
}
