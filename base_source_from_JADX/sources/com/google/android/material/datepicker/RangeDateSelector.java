package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.p029g.C0583d;
import androidx.core.p029g.C0588f;
import com.google.android.material.C2246R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class RangeDateSelector implements DateSelector<C0583d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Long unused = rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            Long unused2 = rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        public RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    };
    private final String invalidRangeEndError = " ";
    private String invalidRangeStartError;
    /* access modifiers changed from: private */
    public Long proposedTextEnd = null;
    /* access modifiers changed from: private */
    public Long proposedTextStart = null;
    /* access modifiers changed from: private */
    public Long selectedEndItem = null;
    /* access modifiers changed from: private */
    public Long selectedStartItem = null;

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    /* access modifiers changed from: private */
    public void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener<C0583d<Long, Long>> onSelectionChangedListener) {
        Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
        } else if (isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(C2246R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? C2246R.attr.materialCalendarTheme : C2246R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return C2246R.string.mtrl_picker_range_header_title;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public Collection<C0583d<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0583d(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    public C0583d<Long, Long> getSelection() {
        return new C0583d<>(this.selectedStartItem, this.selectedEndItem);
    }

    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        if (this.selectedStartItem == null && this.selectedEndItem == null) {
            return resources.getString(C2246R.string.mtrl_picker_range_header_unselected);
        }
        Long l = this.selectedEndItem;
        if (l == null) {
            return resources.getString(C2246R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(this.selectedStartItem.longValue())});
        }
        Long l2 = this.selectedStartItem;
        if (l2 == null) {
            return resources.getString(C2246R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(this.selectedEndItem.longValue())});
        }
        C0583d<String, String> dateRangeString = DateStrings.getDateRangeString(l2, l);
        return resources.getString(C2246R.string.mtrl_picker_range_header_selected, new Object[]{dateRangeString.f2177a, dateRangeString.f2178b});
    }

    public boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<C0583d<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(C2246R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(C2246R.C2249id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(C2246R.C2249id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isSamsungDevice()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(C2246R.string.mtrl_picker_invalid_range);
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(textInputFormat.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        SimpleDateFormat simpleDateFormat = textInputFormat;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final TextInputLayout textInputLayout3 = textInputLayout;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        C23141 r9 = r0;
        final OnSelectionChangedListener<C0583d<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        C23141 r0 = new DateFormatTextWatcher(textInputHint, simpleDateFormat, textInputLayout, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextStart = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                Long unused = RangeDateSelector.this.proposedTextStart = l;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        };
        editText.addTextChangedListener(r9);
        editText2.addTextChangedListener(new DateFormatTextWatcher(textInputHint, simpleDateFormat, textInputLayout2, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextEnd = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                Long unused = RangeDateSelector.this.proposedTextEnd = l;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j) {
        Long l = this.selectedStartItem;
        if (l != null) {
            if (this.selectedEndItem != null || !isValidRange(l.longValue(), j)) {
                this.selectedEndItem = null;
            } else {
                this.selectedEndItem = Long.valueOf(j);
                return;
            }
        }
        this.selectedStartItem = Long.valueOf(j);
    }

    public void setSelection(C0583d<Long, Long> dVar) {
        if (!(dVar.f2177a == null || dVar.f2178b == null)) {
            C0588f.m2268a(isValidRange(((Long) dVar.f2177a).longValue(), ((Long) dVar.f2178b).longValue()));
        }
        Long l = null;
        this.selectedStartItem = dVar.f2177a == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) dVar.f2177a).longValue()));
        if (dVar.f2178b != null) {
            l = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) dVar.f2178b).longValue()));
        }
        this.selectedEndItem = l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}
