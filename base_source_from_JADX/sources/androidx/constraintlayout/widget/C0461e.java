package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: androidx.constraintlayout.widget.e */
public class C0461e extends View {

    /* renamed from: a */
    private int f1887a;

    /* renamed from: b */
    private View f1888b;

    /* renamed from: c */
    private int f1889c;

    /* renamed from: a */
    public void mo3275a(ConstraintLayout constraintLayout) {
        if (this.f1887a == -1 && !isInEditMode()) {
            setVisibility(this.f1889c);
        }
        this.f1888b = constraintLayout.findViewById(this.f1887a);
        View view = this.f1888b;
        if (view != null) {
            ((ConstraintLayout.C0452a) view.getLayoutParams()).f1748aa = true;
            this.f1888b.setVisibility(0);
            setVisibility(0);
        }
    }

    /* renamed from: b */
    public void mo3276b(ConstraintLayout constraintLayout) {
        if (this.f1888b != null) {
            ConstraintLayout.C0452a aVar = (ConstraintLayout.C0452a) getLayoutParams();
            ConstraintLayout.C0452a aVar2 = (ConstraintLayout.C0452a) this.f1888b.getLayoutParams();
            aVar2.f1759al.mo3058e(0);
            aVar.f1759al.mo3070j(aVar2.f1759al.mo3081p());
            aVar.f1759al.mo3072k(aVar2.f1759al.mo3085r());
            aVar2.f1759al.mo3058e(8);
        }
    }

    public View getContent() {
        return this.f1888b;
    }

    public int getEmptyVisibility() {
        return this.f1889c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f1887a != i) {
            View view = this.f1888b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.C0452a) this.f1888b.getLayoutParams()).f1748aa = false;
                this.f1888b = null;
            }
            this.f1887a = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.f1889c = i;
    }
}
