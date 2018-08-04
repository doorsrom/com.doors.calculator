package com.windowsexperience.calculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openNavBar(final View v) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(Gravity.LEFT);
    }

    public void closeNavBar(final View v) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.START);
    }

    public void openCalc(final View v) {
        final int id = v.getId();
        findViewById(R.id.wrap_standard).setVisibility(View.GONE);
        findViewById(R.id.wrap_scientific).setVisibility(View.GONE);
        findViewById(R.id.wrap_programmer).setVisibility(View.GONE);
        findViewById(R.id.wrap_converter).setVisibility(View.GONE);
        String calcType = "";
        int calcList = 0;
        int calcWrapper = 0;
        switch (id) {
            case R.id.nav_standard:
                calcType = "STANDARD";
                calcWrapper = R.id.wrap_standard;
                break;
            case R.id.nav_scientific:
                calcType = "SCIENTIFIC";
                calcWrapper = R.id.wrap_scientific;
                break;
            case R.id.nav_programmer:
                calcType = "PROGRAMMER";
                calcWrapper = R.id.wrap_programmer;
                break;
            case R.id.nav_volume:
                calcType = "VOLUME";
                calcList = R.array.converter_volume;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_length:
                calcType = "LENGTH";
                calcList = R.array.converter_length;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_weight:
                calcType = "WEIGHT AND MASS";
                calcList = R.array.converter_weight;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_temperature:
                calcType = "TEMPERATURE";
                calcList = R.array.converter_temperature;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_energy:
                calcType = "ENERGY";
                calcList = R.array.converter_energy;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_area:
                calcType = "AREA";
                calcList = R.array.converter_area;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_speed:
                calcType = "SPEED";
                calcList = R.array.converter_speed;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_time:
                calcType = "TIME";
                calcList = R.array.converter_time;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_power:
                calcType = "POWER";
                calcList = R.array.converter_power;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_data:
                calcType = "DATA";
                calcList = R.array.converter_data;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_pressure:
                calcType = "PRESSURE";
                calcList = R.array.converter_pressure;
                calcWrapper = R.id.wrap_converter;
                break;
            case R.id.nav_angle:
                calcType = "ANGLE";
                calcList = R.array.converter_angle;
                calcWrapper = R.id.wrap_converter;
                break;
        }
        findViewById(calcWrapper).setVisibility(View.VISIBLE);
        TextView textView = (TextView) findViewById(R.id.calcMainText);
        textView.setText(calcType);
        if (calcWrapper == R.id.wrap_converter) {
            Spinner topSpinner = (Spinner) findViewById(R.id.converter_top_dropdown);
            Spinner lowSpinner = (Spinner) findViewById(R.id.converter_low_dropdown);
            String[] convertedCalcList = getResources().getStringArray(calcList);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner, R.id.SpinnerID, convertedCalcList);
            adapter.setDropDownViewResource(R.layout.spinner_dropdown);
            topSpinner.setAdapter(adapter);
            lowSpinner.setAdapter(adapter);
            TextView topText = findViewById(R.id.converter_text_top);
            TextView lowText = findViewById(R.id.converter_text_low);
            topText.setTypeface(Typeface.DEFAULT_BOLD);
            lowText.setTypeface(Typeface.DEFAULT);
            topText.setText(String.valueOf(0));
            lowText.setText(String.valueOf(0));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.START);
    }

    public void newInput(final View v) {
        //standard standardClass = new standard();
        converter converterClass = new converter();
        TextView calcMainText = (TextView) findViewById(R.id.calcMainText);
        String currentCategory = (String) calcMainText.getText();
        switch (currentCategory) {
            case "STANDARD":
                //TextView writing = (TextView) findViewById(R.id.standard_text_writing);
                //TextView written = (TextView) findViewById(R.id.standard_text_written);
                //standardClass.input(v, writing, written);
                break;
            case "SCIENTIFIC":
                //standard.input(v);
                break;
            case "PROGRAMMER":
                //standard.input(v);
                break;
            default:
                TextView topText = (TextView) findViewById(R.id.converter_text_top);
                TextView lowText = (TextView) findViewById(R.id.converter_text_low);
                Spinner topDrop = (Spinner) findViewById(R.id.converter_top_dropdown);
                Spinner lowDrop = (Spinner) findViewById(R.id.converter_low_dropdown);
                converterClass.input(v, topDrop, lowDrop, topText, lowText);
                break;
        }
    }
}

