
package com.windowsexperience.calculator;

import android.widget.Spinner;
import android.view.View;
import android.util.Log;

public class converter extends MainActivity {

    public void input(final View v, View topSpinner, View lowSpinner) {
        switch (v.getId()) {
            case R.id.converter_top_dropdown_icon:
                topSpinner.performClick();
                break;
            case R.id.converter_low_dropdown_icon:
                lowSpinner.performClick();
                break;
        }
    }
}