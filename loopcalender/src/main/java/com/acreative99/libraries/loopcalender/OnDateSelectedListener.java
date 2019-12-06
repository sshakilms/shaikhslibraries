package com.acreative99.libraries.loopcalender;

/**
 * For Project: ShaikhsLibraries
 * Created by shaikhshakil on 2019-12-05
 */

public interface OnDateSelectedListener {
    void onDateSelected(int year, int month, int day, int dayOfWeek);

    void onDisabledDateSelected(int year, int month, int day, int dayOfWeek, boolean isDisabled);
}
