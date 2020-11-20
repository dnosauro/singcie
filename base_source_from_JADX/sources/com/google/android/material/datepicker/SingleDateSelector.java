package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.p029g.C0583d;
import com.google.android.material.C2246R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    };
    /* access modifiers changed from: private */
    public Long selectedItem;

    /* access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, C2246R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return C2246R.string.mtrl_picker_date_header_title;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    public Collection<C0583d<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    public Long getSelection() {
        return this.selectedItem;
    }

    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            return resources.getString(C2246R.string.mtrl_picker_date_header_unselected);
        }
        String yearMonthDay = DateStrings.getYearMonthDay(l.longValue());
        return resources.getString(C2246R.string.mtrl_picker_date_header_selected, new Object[]{yearMonthDay});
    }

    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(C2246R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(C2246R.C2249id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isSamsungDevice()) {
            editText.setInputType(17);
        }
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        Long l = this.selectedItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
        }
        final OnSelectionChangedListener<Long> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout, calendarConstraints) {
            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                if (l == null) {
                    SingleDateSelector.this.clearSelection();
                } else {
                    SingleDateSelector.this.select(l.longValue());
                }
                onSelectionChangedListener2.onSelectionChanged(SingleDateSelector.this.getSelection());
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    public void setSelection(Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }
}
