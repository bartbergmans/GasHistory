package com.bartbergmans.gashistory.Views.ItemViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Bart on 5-5-2016.
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}