package com.dorukkangal.android.mvvm.binding;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Doruk Kangal
 */
public abstract class RecyclerViewListAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    private List<T> items;

    public RecyclerViewListAdapter() {
        this(new ArrayList<T>());
    }

    public RecyclerViewListAdapter(List<T> items) {
        this.items = items;
    }

    public T getItem(int position) {
        return getItems().get(position);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
