package com.dorukkangal.android.mvvm.binding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author Doruk Kangal
 */
public class RecyclerViewListBindingAdapter<T> extends RecyclerViewListAdapter<T, RecyclerViewBindingViewHolder> {

    private final int layoutResId;
    private final int bindingVariableId;

    public RecyclerViewListBindingAdapter(int layoutResId, int bindingVariableId) {
        super();

        this.layoutResId = layoutResId;
        this.bindingVariableId = bindingVariableId;
    }

    @Override
    public RecyclerViewBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                layoutResId,
                parent,
                false
        );

        return new RecyclerViewBindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewBindingViewHolder holder, int position) {
        holder.getBinding().setVariable(bindingVariableId, getItem(position));
    }
}
