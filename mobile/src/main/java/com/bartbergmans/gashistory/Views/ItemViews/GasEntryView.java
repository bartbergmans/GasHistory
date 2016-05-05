package com.bartbergmans.gashistory.Views.ItemViews;

import android.content.Context;
import android.widget.LinearLayout;

import com.bartbergmans.gashistory.Objects.GasEntry;
import com.bartbergmans.gashistory.R;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Bart on 5-5-2016.
 */
@EViewGroup(R.layout.item_gasentry)
public class GasEntryView extends LinearLayout {

    public GasEntryView(Context context) {
        super(context);
    }

    GasEntry mEntry;

    /**
     * Bind a GasEntry to the view
     *
     * @param entry
     */
    public void bind(GasEntry entry) {
        mEntry = entry;
    }
}
