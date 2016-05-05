package com.bartbergmans.gashistory.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.bartbergmans.gashistory.Objects.GasEntry;
import com.bartbergmans.gashistory.Views.ItemViews.GasEntryView;
import com.bartbergmans.gashistory.Views.ItemViews.GasEntryView_;
import com.bartbergmans.gashistory.Views.ItemViews.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Bart on 5-5-2016.
 */
@EBean
public class GasEntryAdapter extends RecyclerViewAdapterBase<GasEntry, GasEntryView> {

    @RootContext
    Context context;

    @Override
    protected GasEntryView onCreateItemView(ViewGroup parent, int viewType) {
        return GasEntryView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<GasEntryView> holder, int position) {
        GasEntryView view = holder.getView();
        GasEntry entry = items.get(position);

        view.bind(entry);
    }
}
