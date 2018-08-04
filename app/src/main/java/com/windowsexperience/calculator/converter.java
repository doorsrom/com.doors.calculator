
package com.windowsexperience.calculator;

import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Typeface;

public class converter extends MainActivity {

    public void input(final View v, Spinner topSpinner, Spinner lowSpinner, TextView topText, TextView lowText) {
        switch (v.getId()) {
            case R.id.converter_textWrapper_top:
                topText.setTypeface(Typeface.DEFAULT_BOLD);
                lowText.setTypeface(Typeface.DEFAULT);
                break;
            case R.id.converter_textWrapper_low:
                lowText.setTypeface(Typeface.DEFAULT_BOLD);
                topText.setTypeface(Typeface.DEFAULT);
                break;
            case R.id.converter_btn_CE:
                reset(topText, lowText);
                break;
            case R.id.converter_btn_DEL:
                removeChar(topText, lowText);
                break;
            case R.id.converter_btn_0:
                addChar("0", topText, lowText);
                break;
            case R.id.converter_btn_1:
                addChar("1", topText, lowText);
                break;
            case R.id.converter_btn_2:
                addChar("2", topText, lowText);
                break;
            case R.id.converter_btn_3:
                addChar("3", topText, lowText);
                break;
            case R.id.converter_btn_4:
                addChar("4", topText, lowText);
                break;
            case R.id.converter_btn_5:
                addChar("5", topText, lowText);
                break;
            case R.id.converter_btn_6:
                addChar("6", topText, lowText);
                break;
            case R.id.converter_btn_7:
                addChar("7", topText, lowText);
                break;
            case R.id.converter_btn_8:
                addChar("8", topText, lowText);
                break;
            case R.id.converter_btn_9:
                addChar("9", topText, lowText);
                break;
            case R.id.converter_btn_point:
                addChar(".", topText, lowText);
                break;
        }
    }

    private void reset(TextView topText, TextView lowText) {
        lowText.setText(String.valueOf(0));
        topText.setText(String.valueOf(0));
        calc(topText, lowText);
    }

    private void removeChar(TextView topText, TextView lowText) {
        TextView currentText;
        if (topText.getTypeface() == Typeface.DEFAULT_BOLD) {
            currentText = topText;
        } else {
            currentText = lowText;
        }
        if (currentText.length() > 1) {
            currentText.setText(currentText.getText().subSequence(0, currentText.length() - 1));
        } else {
            reset(topText, lowText);
        }
    }

    private void addChar(String toAdd, TextView topText, TextView lowText) {
        TextView currentText;
        if (topText.getTypeface() == Typeface.DEFAULT_BOLD) {
            currentText = topText;
        } else {
            currentText = lowText;
        }
        if (currentText.getText() == String.valueOf(0)) {
            if (toAdd == ".") {
                return;
            }
            currentText.setText("");
        }
        if ((String.valueOf(currentText.getText()).contains(".")) && (toAdd == ".")) {
            return;
        }
        currentText.setText(((String) currentText.getText()).concat(toAdd));
        calc(topText, lowText);
    }

    private void calc(TextView topText, TextView lowText) {
        TextView value;
        TextView result;
        if (topText.getTypeface() == Typeface.DEFAULT_BOLD) {
            value = topText;
            result = lowText;
        } else {
            value = lowText;
            result = topText;
        }
        float resultValue = convert(Float.parseFloat((value.getText()).toString()), "CATEGORY", "FROM", "TO");
        String resultString;
        if (resultValue == 0) {
            resultString = String.valueOf(0);
        } else if (resultValue == Math.floor(resultValue)) {
            String temp = String.valueOf(resultValue);
            resultString = temp.substring(0, temp.length() - 1);
        } else {
            resultString = String.valueOf(resultValue);
        }
        result.setText(resultString);
    }

    private float convert(float value, String category, String from, String to) {
        float result;
        result = 0;
        return result;
    }
}