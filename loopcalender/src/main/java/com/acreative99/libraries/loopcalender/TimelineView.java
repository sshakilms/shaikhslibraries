package com.acreative99.libraries.loopcalender;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.acreative99.libraries.loopcalender.adaptor.TimelineAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * For Project: ShaikhsLibraries
 * Created by shaikhshakil on 2019-12-05
 */

public class TimelineView extends RecyclerView {
    private static final String TAG = "TimelineView";
    private TimelineAdapter adapter;

    private int yearTextColor,monthTextColor, dateTextColor, dayTextColor, selectedColor, disabledColor;
    //    private float monthTextSize, dateTextSize, dayTextSize;
    private int minYear, minMonth, minDate;
    private int maxYear, maxMonth, maxDate;

    public TimelineView(@NonNull Context context) {
        super(context);
        init();
    }

    public TimelineView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimelineView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    void init() {

        minYear = 1970;
        minMonth = 0;
        minDate = 1;

        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false));
        adapter = new TimelineAdapter(this, -1);
        setAdapter(adapter);
    }

    public int getYearTextColor() {
        return yearTextColor;
    }

    public void setYearTextColor(int color) {
        this.yearTextColor = color;
    }

    public int getMonthTextColor() {
        return monthTextColor;
    }

    public void setMonthTextColor(int color) {
        this.monthTextColor = color;
    }

    public int getDateTextColor() {
        return dateTextColor;
    }

    public void setDateTextColor(int color) {
        this.dateTextColor = color;
    }

    public int getDayTextColor() {
        return dayTextColor;
    }

    public void setDayTextColor(int color) {
        this.dayTextColor = color;
    }

    public void setDisabledDateColor(int color) {
        this.disabledColor = color;
    }

    public int getDisabledDateColor() {
        return disabledColor;
    };

    public int getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(int color) {
        this.selectedColor = color;
    }

    public int getMinYear() {
        return minYear;
    }

    public int getMinMonth() {
        return minMonth;
    }

    public int getMinDate() {
        return minDate;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public int getMaxMonth() {
        return maxMonth;
    }

    public void setMaxMonth(int maxMonth) {
        this.maxMonth = maxMonth;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int maxDate) {
        this.maxDate = maxDate;
    }

    public void setOnDateSelectedListener(OnDateSelectedListener listener) {
        adapter.setDateSelectedListener(listener);
    }

    public void setInitialDate(int minYear, int minMonth, int minDate) {
        this.minYear = minYear;
        this.minMonth = minMonth;
        this.minDate = minDate;
        invalidate();
    }

    public void setInitialDate(int minYear, int minMonth, int minDate,int maxYear, int maxMonth, int maxDate) {
        this.minYear = minYear;
        this.minMonth = minMonth;
        this.minDate = minDate;
        this.maxYear = maxYear;
        this.maxMonth = maxMonth;
        this.maxDate = maxDate;
        invalidate();
    }

    /**
     * Calculates the minDate position and set the selected background on that minDate
     * @param activeDate active Date
     */
    public void setActiveDate(Calendar activeDate) {
        try {
            Date initialDate = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(minYear + "-" + (minMonth + 1) + "-" + this.minDate);
            long diff =  activeDate.getTime().getTime() - initialDate.getTime();
            int position = (int) (diff / (1000 * 60 * 60 * 24));
            adapter.setSelectedPosition(position);
            invalidate();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void deactivateDates(Date[] deactivatedDates) {
        adapter.disableDates(deactivatedDates);
    }
}