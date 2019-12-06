package com.acreative99.libraries.shaikhslibraries;

import android.os.Bundle;

import com.acreative99.libraries.loopcalender.DatePickerLoop;
import com.acreative99.libraries.loopcalender.OnDateSelectedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.joda.time.DateTime;

import java.util.Date;

public class ScrollingActivity extends AppCompatActivity {

    DatePickerLoop datePickerLoop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        datePickerLoop=findViewById(R.id.datepickerloop);
        DateTime dateTimeMin=new DateTime();
        DateTime dateTimeMax=dateTimeMin.plusDays(20);
        datePickerLoop.setInitialDate(dateTimeMin.getYear(), dateTimeMin.getMonthOfYear(),dateTimeMin.getDayOfMonth(),dateTimeMax.getYear(), dateTimeMax.getMonthOfYear(), dateTimeMax.getDayOfMonth());
        datePickerLoop.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int dayOfWeek) {
                String res="Date:"+day+"/"+month+"/"+year;
                Log.d("Date",res);
            }

            @Override
            public void onDisabledDateSelected(int year, int month, int day, int dayOfWeek, boolean isDisabled) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
