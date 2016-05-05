package com.bartbergmans.gashistory.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.bartbergmans.gashistory.Models.GasModel;
import com.bartbergmans.gashistory.Objects.GasEntry;
import com.bartbergmans.gashistory.R;
import com.bartbergmans.gashistory.Views.Dialogs.AddGasEntry;
import com.bartbergmans.gashistory.Views.Dialogs.AddGasEntry_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends PageActivity {

    @Bean
    GasModel mGasModel;

    @AfterViews
    protected void afterViews() {
        List<GasEntry> gasEntryList = mGasModel.getGasEntryList();
        for(GasEntry entry : gasEntryList) {
            Log.d("Entry", "Mileage: " + entry.getMileage() + ", Gas: " + entry.getGas() + ", Price: " + entry.getPrice() + " (" + entry.getDate().getTime() + ")" );
        }
    }

    @Click(R.id.fab)
    protected void clickAddEntryButton() {
        final AddGasEntry addGasEntryView = AddGasEntry_.build(MainActivity.this);
        addGasEntryView.bind();

        final AlertDialog addDialog = new AlertDialog.Builder(MainActivity.this)
                .setView(addGasEntryView)
                .setCancelable(false)
                .setPositiveButton(R.string.save, null)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        addDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button button = addDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(addGasEntryView.isValid()) {
                            mGasModel.saveGasEntry(
                                    addGasEntryView.getMileage(),
                                    addGasEntryView.getGas(),
                                    addGasEntryView.getPrice()
                            );
                            addDialog.dismiss();
                        } else {

                        }
                    }
                });
            }
        });

        addDialog.show();
    }
}
