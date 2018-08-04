
package com.windowsexperience.calculator;

import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

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
        calc(topText, lowText, topSpinner, lowSpinner);
    }

    private void reset(TextView topText, TextView lowText) {
        lowText.setText(String.valueOf(0));
        topText.setText(String.valueOf(0));
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
    }

    private void calc(TextView topText, TextView lowText, Spinner topDrop, Spinner lowDrop) {
        TextView value;
        TextView result;
        Spinner FromDrop;
        Spinner ToDrop;
        if (topText.getTypeface() == Typeface.DEFAULT_BOLD) {
            value = topText;
            result = lowText;
            FromDrop = topDrop;
            ToDrop = lowDrop;
        } else {
            value = lowText;
            result = topText;
            FromDrop = lowDrop;
            ToDrop = topDrop;
        }
        String from = String.valueOf(FromDrop.getSelectedItem());
        String to = String.valueOf(ToDrop.getSelectedItem());
        double resultValue = convert(Double.parseDouble((value.getText()).toString()), "CATEGORY", from, to);
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

    private double convert(double value, String category, String from, String to) {
        double FromScore;
        double ToScore;
        FromScore = getScore(category, from);
        ToScore = getScore(category, to);
        return value / FromScore * ToScore;
    }

    private double getScore(String category, String field) {
        Map<String, Double> map = new HashMap<String, Double>();
        //Volume
        map.put("Milliliters", 1.0);
        map.put("Cubic centimeters", 1.0);
        map.put("Liters", 0.001);
        map.put("Cubic meters", 0.000001);
        map.put("Teaspoons (US)", 0.202884);//not accurate?
        map.put("Tablespoons (US)", 0.067628);//not accurate?
        map.put("Fluid ounces (US)", 0.033814);//not accurate?
        map.put("Cups (US)", 0.004227);//not accurate?
        map.put("Pints (US)", 0.002113);//not accurate?
        map.put("Quarts (US)", 0.001057);//not accurate?
        map.put("Gallons (US)", 0.000264);//not accurate?
        map.put("Cubic inches", 0.061024);//not accurate?
        map.put("Cubic feet", 0.000035);//not accurate?
        map.put("Cubic yards", 0.0000137905);//not accurate?
        map.put("Teaspoons (UK)", 0.168936);//not accurate?
        map.put("Tablespoons (UK)", 0.056312);//not accurate?
        map.put("Fluid ounces (UK)", 0.035195);//not accurate?
        map.put("Pints(UK)", 0.00176);//not accurate?
        map.put("Quarts (UK)", 0.00088);//not accurate?
        map.put("Gallons (UK)", 0.00022);//not accurate?
        //Length
        map.put("Nanometers", 10000000.0);
        map.put("Microns", 10000.0);
        map.put("Millimeters", 10.0);
        map.put("Centimeters", 1.0);
        map.put("Meters", 0.01);
        map.put("Kilometers", 0.00001);
        map.put("Inches", 0.393701);//not accurate?
        map.put("Feet", 0.032808);//not accurate?
        map.put("Yards", 0.010936);//not accurate?
        map.put("Miles", 0.000006);//not accurate?
        map.put("Nautical Miles", 0.000005);//not accurate?
        //Weight
        map.put("Carats", 5.0);
        map.put("Milligrams", 1000.0);
        map.put("Centigrams", 100.0);
        map.put("Decigrams", 10.0);
        map.put("Grams", 1.0);
        map.put("Dekagrams", 0.1);
        map.put("Hectograms", 0.01);
        map.put("Kilograms", 0.001);
        map.put("Metric tonnes", 0.000001);//not accurate?
        map.put("Ounces", 0.035274);//not accurate?
        map.put("Pounds", 0.002205);//not accurate?
        map.put("Stone", 0.000157);//not accurate?
        map.put("Short tons (US)", 0.000001);//not accurate?
        map.put("Long tons (UK)", 0.00000098420653);//not accurate?
        //TODO SPECIAL THING!////Temperature
        //TODO SPECIAL THING!//map.put("Celsius",);
        //TODO SPECIAL THING!//map.put("Fahrenheit",);
        //TODO SPECIAL THING!//map.put("Kelvin",);
        //Energy
        map.put("Electron volts", 6241509000000000000.0);//not accurate?
        map.put("Joules", 1.0);
        map.put("Kilojoules", 0.001);
        map.put("Thermal calories", 0.239006);//not accurate?
        map.put("Food calories", 0.000239);//not accurate?
        map.put("Foot-pounds", 0.737562);//not accurate?
        map.put("British thermal units", 0.000948);//not accurate?
        //Area
        map.put("Square millimeters", 1000000.0);
        map.put("Square centimeters", 10.000);
        map.put("Square meters", 1.0);
        map.put("Hectares", 0.0001);
        map.put("Square kilometers", 0.000001);
        map.put("Square inches", 1550.003);//not accurate?
        map.put("Square feet", 10.76391);//not accurate?
        map.put("Square yards", 1.19599);//not accurate?
        map.put("Acres", 0.000247);//not accurate?
        map.put("Square miles", 0.00000038610216);//not accurate?
        //Speed
        map.put("Centimeters per second", 27.777778);//not accurate?
        map.put("Meters per second", 0.277778);//not accurate?
        map.put("Kilometers per hour", 1.0);
        map.put("Feet per second", 0.911344);//not accurate?
        map.put("Miles per hour", 0.621427);//not accurate?
        map.put("Knots", 0.540003);//not accurate?
        map.put("Mach", 0.000816);//not accurate?
        //Time
        map.put("Microseconds", 604800000000.0);
        map.put("Milliseconds", 604800000.0);
        map.put("Seconds", 604800.0);
        map.put("Minutes", 10080.0);
        map.put("Hours", 168.0);
        map.put("Days", 7.0);
        map.put("Weeks", 1.0);
        map.put("Years", 0.019165);//not accurate?
        //Power
        map.put("Watts", 1.0);
        map.put("Kilowatts", 0.001);
        map.put("Horsepower (US)", 0.001341);//not accurate?
        map.put("Foot-pounds/minute", 44.25373);//not accurate?
        map.put("BTUs/minute", 0.056869);//not accurate?
        //Data
        map.put("Bits", 8000000000.0);
        map.put("Bytes", 1000000000.0);
        map.put("Kilobits", 8000000.0);
        map.put("Kibibits", 7812500.0);//not accurate?
        map.put("Kilobytes", 1000000.0);
        map.put("Kibibytes", 976562.5);//not accurate?
        map.put("Megabits", 8000.0);
        map.put("Mebibits", 7629.395);//not accurate?
        map.put("Megabytes", 1000.0);
        map.put("Mebibytes", 953.6743);//not accurate?
        map.put("Gigabits", 8.0);
        map.put("Gibibits", 7.450581);//not accurate?
        map.put("Gigabytes", 1.0);
        map.put("Gibibytes", 0.931323);//not accurate?
        map.put("Terabits", 0.008);
        map.put("Tebibits", 0.007276);//not accurate?
        map.put("Terabytes", 0.001);
        map.put("Tebibytes", 0.000909);//not accurate?
        map.put("Petabits", 0.000008);
        map.put("Pebibits", 0.000007);//not accurate?
        map.put("Petabytes", 0.000001);
        map.put("Pebibytes", 0.00000088817842);//not accurate?
        map.put("Exabits", 0.000000008);
        map.put("Exibits", 0.00000000693889);//not accurate?
        map.put("Exabytes", 0.000000001);
        map.put("Exbibytes", 0.000000000086736);//not accurate?
        map.put("Zetabits", 0.000000000008);
        map.put("Zebibits", 0.00000000000678);//not accurate?
        map.put("Zetabytes", 0.000000000001);
        map.put("Zebibytes", 0.00000000000085);//not accurate?
        map.put("Yottabit", 0.000000000000008);//not accurate?
        map.put("Yobibit", 0.000000000000006617445);//not accurate?
        map.put("Yottabyte", 0.000000000000001);//not accurate?
        map.put("Yobibytes", 0.0000000000000008271806);//not accurate?
        //Pressure
        map.put("Atmospheres", 0.986923);
        map.put("Bars", 1.0);
        map.put("Kilopascals", 100.0);
        map.put("Millimeters of mercury", 750.1875);//not accurate?
        map.put("Pascals", 100000.0);
        map.put("Pounds per square inch", 14.50377);//not accurate?
        //Angle
        map.put("Degrees", 57.29578);//not accurate?
        map.put("Radians", 1.0);
        map.put("Gradians", 63.66198);//not accurate?
        return map.get(field);
    }
}