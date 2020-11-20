package com.cyberneid.disigon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.C0339l;
import com.cyberneid.disigoncie.R;

public class PinEntryEditText extends C0339l {

    /* renamed from: a */
    int[][] f6398a = {new int[]{16842913}, new int[]{16842908}, new int[]{-16842908}};

    /* renamed from: b */
    int[] f6399b = {-65536, -16711936, -7829368};

    /* renamed from: c */
    ColorStateList f6400c = new ColorStateList(this.f6398a, this.f6399b);

    /* renamed from: d */
    private float f6401d = 10.0f;

    /* renamed from: e */
    private float f6402e;

    /* renamed from: f */
    private float f6403f = 4.0f;

    /* renamed from: g */
    private float f6404g = 8.0f;

    /* renamed from: h */
    private int f6405h = 4;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f6406i;

    /* renamed from: j */
    private float f6407j = 1.0f;

    /* renamed from: k */
    private float f6408k = 2.0f;

    /* renamed from: l */
    private Paint f6409l;

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8197a(context, attributeSet);
    }

    /* renamed from: a */
    private int m8195a(int... iArr) {
        return this.f6400c.getColorForState(iArr, -7829368);
    }

    /* renamed from: a */
    private void m8197a(Context context, AttributeSet attributeSet) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f6407j *= f;
        this.f6408k *= f;
        this.f6409l = new Paint(getPaint());
        this.f6409l.setStrokeWidth(this.f6407j);
        if (!isInEditMode()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorControlActivated, typedValue, true);
            this.f6399b[0] = typedValue.data;
            context.getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);
            this.f6399b[1] = typedValue.data;
            context.getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true);
            this.f6399b[2] = typedValue.data;
        }
        setBackgroundResource(0);
        this.f6401d *= f;
        this.f6404g = f * this.f6404g;
        this.f6405h = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 4);
        this.f6403f = (float) this.f6405h;
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        super.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                if (PinEntryEditText.this.f6406i != null) {
                    PinEntryEditText.this.f6406i.onClick(view);
                }
            }
        });
    }

    /* renamed from: a */
    private void m8198a(boolean z) {
        Paint paint;
        int[] iArr;
        if (isFocused()) {
            this.f6409l.setStrokeWidth(this.f6408k);
            this.f6409l.setColor(m8195a(16842908));
            if (z) {
                paint = this.f6409l;
                iArr = new int[]{16842913};
            } else {
                return;
            }
        } else {
            this.f6409l.setStrokeWidth(this.f6407j);
            paint = this.f6409l;
            iArr = new int[]{-16842908};
        }
        paint.setColor(m8195a(iArr));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        float f2 = this.f6401d;
        if (f2 < 0.0f) {
            f = ((float) width) / ((this.f6403f * 2.0f) - 1.0f);
        } else {
            float f3 = this.f6403f;
            f = (((float) width) - (f2 * (f3 - 1.0f))) / f3;
        }
        this.f6402e = f;
        int paddingLeft = getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        int length = getText().length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(getText(), 0, length, fArr);
        int i = paddingLeft;
        int i2 = 0;
        while (((float) i2) < this.f6403f) {
            m8198a(i2 == length);
            float f4 = (float) i;
            float f5 = (float) height;
            canvas.drawLine(f4, f5, f4 + this.f6402e, f5, this.f6409l);
            if (getText().length() > i2) {
                canvas.drawText("*", 0, 1, ((this.f6402e / 2.0f) + f4) - (fArr[0] / 2.0f), f5 - this.f6404g, getPaint());
            }
            float f6 = this.f6401d;
            i = (int) (f6 < 0.0f ? f4 + (this.f6402e * 2.0f) : f4 + this.f6402e + f6);
            i2++;
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6406i = onClickListener;
    }
}
