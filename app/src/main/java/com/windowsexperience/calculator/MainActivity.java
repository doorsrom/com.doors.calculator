package com.windowsexperience.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        findViewById(R.id.wrap_volume).setVisibility(View.GONE);
        findViewById(R.id.wrap_length).setVisibility(View.GONE);
        findViewById(R.id.wrap_weight).setVisibility(View.GONE);
        findViewById(R.id.wrap_temperature).setVisibility(View.GONE);
        findViewById(R.id.wrap_energy).setVisibility(View.GONE);
        findViewById(R.id.wrap_area).setVisibility(View.GONE);
        findViewById(R.id.wrap_speed).setVisibility(View.GONE);
        findViewById(R.id.wrap_time).setVisibility(View.GONE);
        findViewById(R.id.wrap_power).setVisibility(View.GONE);
        findViewById(R.id.wrap_data).setVisibility(View.GONE);
        findViewById(R.id.wrap_pressure).setVisibility(View.GONE);
        findViewById(R.id.wrap_angle).setVisibility(View.GONE);
        String calcType = "";
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
                calcWrapper = R.id.wrap_volume;
                break;
            case R.id.nav_length:
                calcType = "LENGTH";
                calcWrapper = R.id.wrap_length;
                break;
            case R.id.nav_weight:
                calcType = "WEIGHT AND MASS";
                calcWrapper = R.id.wrap_weight;
                break;
            case R.id.nav_temperature:
                calcType = "TEMPERATURE";
                calcWrapper = R.id.wrap_temperature;
                break;
            case R.id.nav_energy:
                calcType = "ENERGY";
                calcWrapper = R.id.wrap_energy;
                break;
            case R.id.nav_area:
                calcType = "AREA";
                calcWrapper = R.id.wrap_area;
                break;
            case R.id.nav_speed:
                calcType = "SPEED";
                calcWrapper = R.id.wrap_speed;
                break;
            case R.id.nav_time:
                calcType = "TIME";
                calcWrapper = R.id.wrap_time;
                break;
            case R.id.nav_power:
                calcType = "POWER";
                calcWrapper = R.id.wrap_power;
                break;
            case R.id.nav_data:
                calcType = "DATA";
                calcWrapper = R.id.wrap_data;
                break;
            case R.id.nav_pressure:
                calcType = "PRESSURE";
                calcWrapper = R.id.wrap_pressure;
                break;
            case R.id.nav_angle:
                calcType = "ANGLE";
                calcWrapper = R.id.wrap_angle;
                break;
        }
        findViewById(calcWrapper).setVisibility(View.VISIBLE);
        TextView textView = (TextView) findViewById(R.id.calcMainText);
        textView.setText(calcType);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.START);
    }
}
