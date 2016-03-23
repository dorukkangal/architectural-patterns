package com.dorukkangal.android.mvvm.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * @author Doruk Kangal
 */
public final class BindingUtil {

    /**
     * Default empty constructor
     */
    private BindingUtil() {
    }

    /**
     * Set item list to RecyclerView's adapter.
     *
     * @param recyclerView the recyclerView
     * @param items        the items to be represent in the recyclerView
     */
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List items) {
        ((RecyclerViewListAdapter) recyclerView.getAdapter()).setItems(items);
    }
}
