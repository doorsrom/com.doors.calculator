package com.windowsexperience.calculator;

import android.widget.TextView;
import android.view.View;

public class standard extends MainActivity {
    public void input(final View v, TextView writing, TextView written) {
        switch (v.getId()) {
            case R.id.standard_btn_0:
                writing.setText(((String) writing.getText()).concat("0"));
                break;
            case R.id.standard_btn_1:
                writing.setText(((String) writing.getText()).concat("1"));
                break;
            case R.id.standard_btn_2:
                writing.setText(((String) writing.getText()).concat("2"));
                break;
            case R.id.standard_btn_3:
                writing.setText(((String) writing.getText()).concat("3"));
                break;
            case R.id.standard_btn_4:
                writing.setText(((String) writing.getText()).concat("4"));
                break;
            case R.id.standard_btn_5:
                writing.setText(((String) writing.getText()).concat("5"));
                break;
            case R.id.standard_btn_6:
                writing.setText(((String) writing.getText()).concat("6"));
                break;
            case R.id.standard_btn_7:
                writing.setText(((String) writing.getText()).concat("7"));
                break;
            case R.id.standard_btn_8:
                writing.setText(((String) writing.getText()).concat("8"));
                break;
            case R.id.standard_btn_9:
                writing.setText(((String) writing.getText()).concat("9"));
                break;
            case R.id.standard_btn_percentage:
                //DO things
                break;
            case R.id.standard_btn_sqrt:
                //DO things
                break;
            case R.id.standard_btn_sq:
                //DO things
                break;
            case R.id.standard_btn_oneTile:
                //DO things
                break;
            case R.id.standard_btn_CE:
                //DO things
                break;
            case R.id.standard_btn_C:
                //DO things
                break;
            case R.id.standard_btn_del:
                writing.setText(((String) writing.getText()).substring(0, ((String) writing.getText()).length() - 1));
                break;
            case R.id.standard_btn_minusplus:
                //DO things
                break;
            case R.id.standard_btn_divide:
                //DO things
                break;
            case R.id.standard_btn_times:
                //DO things
                break;
            case R.id.standard_btn_subtract:
                //DO things
                break;
            case R.id.standard_btn_add:
                //DO things
                break;
            case R.id.standard_btn_point:
                //DO things
                break;
            case R.id.standard_btn_calc:
                //DO things
                break;
        }
    }
}