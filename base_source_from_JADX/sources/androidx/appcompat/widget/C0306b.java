package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b */
class C0306b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1118a;

    public C0306b(ActionBarContainer actionBarContainer) {
        this.f1118a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        if (!this.f1118a.f711d) {
            if (this.f1118a.f708a != null) {
                this.f1118a.f708a.draw(canvas);
            }
            if (this.f1118a.f709b != null && this.f1118a.f712e) {
                drawable = this.f1118a.f709b;
            } else {
                return;
            }
        } else if (this.f1118a.f710c != null) {
            drawable = this.f1118a.f710c;
        } else {
            return;
        }
        drawable.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.f1118a.f711d) {
            if (this.f1118a.f710c != null) {
                drawable = this.f1118a.f710c;
            } else {
                return;
            }
        } else if (this.f1118a.f708a != null) {
            drawable = this.f1118a.f708a;
        } else {
            return;
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
