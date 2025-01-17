package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.C2246R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class CalendarStyle {
    final CalendarItemStyle day;
    final CalendarItemStyle invalidDay;
    final Paint rangeFill = new Paint();
    final CalendarItemStyle selectedDay;
    final CalendarItemStyle selectedYear;
    final CalendarItemStyle todayDay;
    final CalendarItemStyle todayYear;
    final CalendarItemStyle year;

    CalendarStyle(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, C2246R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), C2246R.styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, C2246R.styleable.MaterialCalendar_rangeFillColor);
        this.year = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(C2246R.styleable.MaterialCalendar_yearTodayStyle, 0));
        this.rangeFill.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
