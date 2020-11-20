package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.C0059a;

/* renamed from: androidx.appcompat.widget.u */
public class C0348u extends RatingBar {

    /* renamed from: a */
    private final C0346s f1235a;

    public C0348u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.ratingBarStyle);
    }

    public C0348u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1235a = new C0346s(this);
        this.f1235a.mo2601a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1235a.mo2600a();
        if (a != null) {
            setMeasuredDimension(View.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
