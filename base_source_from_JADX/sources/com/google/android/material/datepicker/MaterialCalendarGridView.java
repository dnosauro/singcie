package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.p029g.C0583d;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.p031a.C0614c;
import com.google.android.material.C2246R;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(C2246R.C2249id.cancel_button);
            setNextFocusRightId(C2246R.C2249id.confirm_button);
        }
        C0656u.m2594a((View) this, (C0610a) new C0610a() {
            public void onInitializeAccessibilityNodeInfo(View view, C0614c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.mo3710a((Object) null);
            }
        });
    }

    private void gainFocus(int i, Rect rect) {
        int firstPositionInMonth;
        if (i == 33) {
            firstPositionInMonth = getAdapter().lastPositionInMonth();
        } else if (i == 130) {
            firstPositionInMonth = getAdapter().firstPositionInMonth();
        } else {
            super.onFocusChanged(true, i, rect);
            return;
        }
        setSelection(firstPositionInMonth);
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        Long item = adapter.getItem(adapter.firstPositionInMonth());
        Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (C0583d next : dateSelector.getSelectedRanges()) {
            if (next.f2177a != null) {
                if (next.f2178b == null) {
                    continue;
                } else {
                    long longValue = ((Long) next.f2177a).longValue();
                    long longValue2 = ((Long) next.f2178b).longValue();
                    if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        if (longValue < item.longValue()) {
                            i2 = adapter.firstPositionInMonth();
                            i = adapter.isFirstInRow(i2) ? 0 : materialCalendarGridView.getChildAt(i2 - 1).getRight();
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                            i2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            i = horizontalMidPoint(materialCalendarGridView.getChildAt(i2));
                        }
                        if (longValue2 > item2.longValue()) {
                            i4 = adapter.lastPositionInMonth();
                            i3 = adapter.isLastInRow(i4) ? getWidth() : materialCalendarGridView.getChildAt(i4).getRight();
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                            i4 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            i3 = horizontalMidPoint(materialCalendarGridView.getChildAt(i4));
                        }
                        int itemId = (int) adapter.getItemId(i2);
                        int itemId2 = (int) adapter.getItemId(i4);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            canvas.drawRect((float) (numColumns > i2 ? 0 : i), (float) (childAt.getTop() + calendarStyle.day.getTopInset()), (float) (i4 > numColumns2 ? getWidth() : i3), (float) (childAt.getBottom() - calendarStyle.day.getBottomInset()), calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                        }
                    } else {
                        return;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
        }
    }

    public void setSelection(int i) {
        if (i < getAdapter().firstPositionInMonth()) {
            i = getAdapter().firstPositionInMonth();
        }
        super.setSelection(i);
    }
}
