package com.uvr.rapidlistlibrary.recycler;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uvr.rapidlistlibrary.interfaces.OnRapidListRowSelected;
import com.uvr.rapidlistlibrary.model.RapidRowData;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pavan on 1/17/2019.
 */

public class RapidRecyclerAdapter extends RecyclerView.Adapter<RapidRecyclerAdapter.RapidViewHolder> {

    private final List<RapidRowData> mValues;
    private HashMap<Integer, Integer> layoutsHashmap;
    private OnRapidListRowSelected listener;

    public RapidRecyclerAdapter(List<RapidRowData> items) {
        mValues = items;
    }

    public RapidRecyclerAdapter(List<RapidRowData> items, HashMap<Integer, Integer> layoutsHashmap) {
        mValues = items;
        this.layoutsHashmap = layoutsHashmap;
    }

    public RapidRecyclerAdapter(List<RapidRowData> items, HashMap<Integer, Integer> layoutsHashmap, OnRapidListRowSelected listener) {
        mValues = items;
        this.layoutsHashmap = layoutsHashmap;
        this.listener = listener;
    }

    @Override
    public RapidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutsHashmap.get(viewType), parent, false);
        return new RapidViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        RapidRowData data = mValues.get(position);
        return data.ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RapidViewHolder holder, final int position) {
        holder.binding.setVariable(mValues.get(position).ROW_TYPE, mValues.get(position));
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
