package com.dorukkangal.android.mvvm.binding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * @author Doruk Kangal
 */
public class RecyclerViewBindingViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public RecyclerViewBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
