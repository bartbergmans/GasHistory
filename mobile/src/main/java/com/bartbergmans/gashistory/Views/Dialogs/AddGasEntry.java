package com.bartbergmans.gashistory.Views.Dialogs;

import android.content.Context;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bartbergmans.gashistory.Helpers.DecimalDigitsInputFilter;
import com.bartbergmans.gashistory.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Bart on 5-5-2016.
 */
@EViewGroup(R.layout.dialog_addgasentry)
public class AddGasEntry extends LinearLayout {

    @ViewById(R.id.mileage)
    EditText mMileage;

    @ViewById(R.id.price)
    EditText mPrice;

    @ViewById(R.id.gas)
    EditText mGas;


    public AddGasEntry(Context context) {
        super(context);
    }

    /**
     * Set input filter for the input fields
     */
    public void bind() {
        mMileage.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(11,2)});
        mPrice.setFilters(new InputFilter[] { new DecimalDigitsInputFilter(11,2)});
        mGas.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(11, 2)});
    }

    public float getMileage() {
        return getFloat(mMileage);
    }

    public float getPrice() {
        return getFloat(mPrice);
    }

    public float getGas() {
        return getFloat(mGas);
    }

    /**
     * Validate the input fields to make sure all fields are higher than 0.
     *
     * @return true if all input fields are higher than 0
     */
    public boolean isValid() {
        if(getMileage() > 0 && getPrice() > 0 && getGas() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Get float for a given EditText
     *
     * @param editText  an EditText that will contain a float
     * @return          float value for the given EditText
     */
    private float getFloat(EditText editText) {
        try {
            return Float.parseFloat(editText.getText().toString());
        } catch (NumberFormatException e) {
            return 0f;
        }
    }
}
