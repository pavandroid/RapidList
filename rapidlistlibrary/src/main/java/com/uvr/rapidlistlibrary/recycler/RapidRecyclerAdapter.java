package com.uvr.rapidlistlibrary.recycler;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uvr.rapidlistlibrary.interfaces.OnRapidListRowSelected;
import com.uvr.rapidlistlibrary.model.RowInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pavan on 1/17/2019.
 */

public class RapidRecyclerAdapter extends RecyclerView.Adapter<RapidRecyclerAdapter.RapidViewHolder> {

    private final List mValues;
    private HashMap<Class, RowInfo> layoutsHashmap;
    private OnRapidListRowSelected listener;

    public RapidRecyclerAdapter(List items) {
        mValues = items;
    }

    public RapidRecyclerAdapter(List items, HashMap<Class, RowInfo> layoutsHashmap) {
        mValues = items;
        this.layoutsHashmap = layoutsHashmap;
    }

    public RapidRecyclerAdapter(List items, HashMap<Class, RowInfo> layoutsHashmap, OnRapidListRowSelected listener) {
        mValues = items;
        this.layoutsHashmap = layoutsHashmap;
        this.listener = listener;
    }

    @Override
    public RapidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new RapidViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        Object o = mValues.get(position);
        RowInfo info = layoutsHashmap.get(o.getClass());
        return info.getLayoutId();
    }

    @Override
    public void onBindViewHolder(RapidViewHolder holder, final int position) {
        Object object = mValues.get(position);
        RowInfo info = layoutsHashmap.get(object.getClass());
        holder.binding.setVariable(info.getRowType(), object);
        holder.binding.executePendingBindings();
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onRowSelected(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class RapidViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ViewDataBinding binding;

        public RapidViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            mView = binding.getRoot();
            this.binding = binding;
        }
    }
}
