package com.acreative99.libraries.loopcalender;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;

/**
 * For Project: ShaikhsLibraries
 * Created by shaikhshakil on 2019-12-05
 */
public class DatePickerLoop extends LinearLayout {
    private TimelineView timelineView;

    public DatePickerLoop(Context context) {
        super(context);
    }

    public DatePickerLoop(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DatePickerLoop(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DatePickerLoop(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);
    }

    void init(AttributeSet attrs, int defStyleAttr) {
        final View view = inflate(getContext(), R.layout.date_picker_timeline, this);
        timelineView = view.findViewById(R.id.timelineView);

        // load Default values
        final TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.DatePickerLoop, defStyleAttr, 0);
        timelineView.setDayTextColor(a.getColor(R.styleable.DatePickerLoop_dayTextColor, getResources().getColor(R.color.black)));
        timelineView.setDateTextColor(a.getColor(R.styleable.DatePickerLoop_dateTextColor, getResources().getColor(R.color.black)));
        timelineView.setMonthTextColor(a.getColor(R.styleable.DatePickerLoop_monthTextColor, getResources().getColor(R.color.black)));
        timelineView.setYearTextColor(a.getColor(R.styleable.DatePickerLoop_yearTextColor, getResources().getColor(R.color.black)));
        timelineView.setDisabledDateColor(a.getColor(R.styleable.DatePickerLoop_disabledColor, getResources().getColor(R.color.grey)));

//        timelineView.setMonthTextSize(a.getDimension(R.styleable.DatePickerTimeline_monthTextSize, getResources().getDimension(R.dimen.monthTextSize)));
//        timelineView.setDateTextSize(a.getDimension(R.styleable.DatePickerTimeline_dateTextSize, getResources().getDimension(R.dimen.dateTextSize)));
//        timelineView.setDayTextSize(a.getDimension(R.styleable.DatePickerTimeline_dayTextSize, getResources().getDimension(R.dimen.dayTextSize)));

        timelineView.deactivateDates(new Date[0]);
        a.recycle();
        timelineView.invalidate();
    }

    /**
     * Sets the color for date text
     * @param color the color of the date text
     */
    public void setDateTextColor(int color) {
        timelineView.setDateTextColor(color);
    }

    /**
     * Sets the color for day text
     * @param color the color of the day text
     */
    public void setDayTextColor(int color) {
        timelineView.setDayTextColor(color);
    }

    /**
     * Sets the color for year
     * @param color the color of the month text
     */
    public void setYearTextColor(int color) {
        timelineView.setYearTextColor(color);
    }

    /**
     * Sets the color for month
     * @param color the color of the month text
     */
    public void setMonthTextColor(int color) {
        timelineView.setMonthTextColor(color);
    }

    /**
     * Sets the color for disabled dates
     * @param color the color of the date
     */
    public void setDisabledDateColor(int color) {
        timelineView.setDisabledDateColor(color);
    }

    /**
     * Register a callback to be invoked when a date is selected.
     * @param listener the callback that will run
     */
    public void setOnDateSelectedListener(OnDateSelectedListener listener) {
        timelineView.setOnDateSelectedListener(listener);
    }

    /**
     * Set a Start date for the calendar (Default, 1 Jan 1970)
     * @param year start year
     * @param month start month
     * @param date start date
     */
    public void setInitialDate(int year, int month, int date) {
        month=month-1;
        timelineView.setInitialDate(year, month, date);
    }

    /**
     * setInitialDate
     * @param myear minYear
     * @param mmonth minMonth
     * @param mdate minDate
     * @param xyear maxYear
     * @param xmonth maxMonth
     * @param xdate maxDate
     */
    public void setInitialDate(int myear, int mmonth, int mdate,int xyear, int xmonth, int xdate) {
        mmonth=mmonth-1;
        xmonth=xmonth-1;
        timelineView.setInitialDate(myear, mmonth, mdate, xyear,  xmonth,  xdate);
    }

    /**
     * Set selected background to active date
     * @param date Active Date
     */
    public void setActiveDate(Calendar date) {
        timelineView.setActiveDate(date);
    }

    /**
     * Deactivate dates from the calendar. User won't be able to select
     * the deactivated date.
     * @param dates Array of Dates
     */
    public void deactivateDates(Date[] dates) {
        timelineView.deactivateDates(dates);
    }
}
