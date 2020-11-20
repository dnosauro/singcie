package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.C0059a;

/* renamed from: androidx.appcompat.widget.v */
public class C0349v extends SeekBar {

    /* renamed from: a */
    private final C0350w f1236a;

    public C0349v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.seekBarStyle);
    }

    public C0349v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1236a = new C0350w(this);
        this.f1236a.mo2601a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1236a.mo2616c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1236a.mo2615b();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1236a.mo2613a(canvas);
    }
}
