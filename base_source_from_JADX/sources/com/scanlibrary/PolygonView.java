package com.scanlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.scanlibrary.C3076d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolygonView extends FrameLayout {

    /* renamed from: a */
    protected Context f7138a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Paint f7139b;

    /* renamed from: c */
    private ImageView f7140c;

    /* renamed from: d */
    private ImageView f7141d;

    /* renamed from: e */
    private ImageView f7142e;

    /* renamed from: f */
    private ImageView f7143f;

    /* renamed from: g */
    private ImageView f7144g;

    /* renamed from: h */
    private ImageView f7145h;

    /* renamed from: i */
    private ImageView f7146i;

    /* renamed from: j */
    private ImageView f7147j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public PolygonView f7148k;

    /* renamed from: com.scanlibrary.PolygonView$a */
    private class C3067a implements View.OnTouchListener {

        /* renamed from: a */
        PointF f7149a = new PointF();

        /* renamed from: b */
        PointF f7150b = new PointF();

        /* renamed from: d */
        private ImageView f7152d;

        /* renamed from: e */
        private ImageView f7153e;

        public C3067a(ImageView imageView, ImageView imageView2) {
            this.f7152d = imageView;
            this.f7153e = imageView2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i;
            Resources resources;
            switch (motionEvent.getAction()) {
                case 0:
                    this.f7149a.x = motionEvent.getX();
                    this.f7149a.y = motionEvent.getY();
                    this.f7150b = new PointF(view.getX(), view.getY());
                    break;
                case 1:
                    PolygonView polygonView = PolygonView.this;
                    if (polygonView.mo23917a(polygonView.getPoints())) {
                        resources = PolygonView.this.getResources();
                        i = C3076d.C3077a.blue;
                    } else {
                        resources = PolygonView.this.getResources();
                        i = C3076d.C3077a.orange;
                    }
                    PolygonView.this.f7139b.setColor(resources.getColor(i));
                    break;
                case 2:
                    PointF pointF = new PointF(motionEvent.getX() - this.f7149a.x, motionEvent.getY() - this.f7149a.y);
                    if (Math.abs(this.f7152d.getX() - this.f7153e.getX()) <= Math.abs(this.f7152d.getY() - this.f7153e.getY())) {
                        if (this.f7153e.getX() + pointF.x + ((float) view.getWidth()) < ((float) PolygonView.this.f7148k.getWidth()) && this.f7153e.getX() + pointF.x > 0.0f) {
                            view.setX((float) ((int) (this.f7150b.x + pointF.x)));
                            this.f7150b = new PointF(view.getX(), view.getY());
                            ImageView imageView = this.f7153e;
                            imageView.setX((float) ((int) (imageView.getX() + pointF.x)));
                        }
                        if (this.f7152d.getX() + pointF.x + ((float) view.getWidth()) < ((float) PolygonView.this.f7148k.getWidth()) && this.f7152d.getX() + pointF.x > 0.0f) {
                            view.setX((float) ((int) (this.f7150b.x + pointF.x)));
                            this.f7150b = new PointF(view.getX(), view.getY());
                            ImageView imageView2 = this.f7152d;
                            imageView2.setX((float) ((int) (imageView2.getX() + pointF.x)));
                            break;
                        }
                    } else {
                        if (this.f7153e.getY() + pointF.y + ((float) view.getHeight()) < ((float) PolygonView.this.f7148k.getHeight()) && this.f7153e.getY() + pointF.y > 0.0f) {
                            view.setX((float) ((int) (this.f7150b.y + pointF.y)));
                            this.f7150b = new PointF(view.getX(), view.getY());
                            ImageView imageView3 = this.f7153e;
                            imageView3.setY((float) ((int) (imageView3.getY() + pointF.y)));
                        }
                        if (this.f7152d.getY() + pointF.y + ((float) view.getHeight()) < ((float) PolygonView.this.f7148k.getHeight()) && this.f7152d.getY() + pointF.y > 0.0f) {
                            view.setX((float) ((int) (this.f7150b.y + pointF.y)));
                            this.f7150b = new PointF(view.getX(), view.getY());
                            ImageView imageView4 = this.f7152d;
                            imageView4.setY((float) ((int) (imageView4.getY() + pointF.y)));
                            break;
                        }
                    }
            }
            PolygonView.this.f7148k.invalidate();
            return true;
        }
    }

    /* renamed from: com.scanlibrary.PolygonView$b */
    private class C3068b implements View.OnTouchListener {

        /* renamed from: a */
        PointF f7154a;

        /* renamed from: b */
        PointF f7155b;

        private C3068b() {
            this.f7154a = new PointF();
            this.f7155b = new PointF();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r0 = r5.getAction()
                switch(r0) {
                    case 0: goto L_0x00c0;
                    case 1: goto L_0x0095;
                    case 2: goto L_0x0009;
                    default: goto L_0x0007;
                }
            L_0x0007:
                goto L_0x00df
            L_0x0009:
                android.graphics.PointF r0 = new android.graphics.PointF
                float r1 = r5.getX()
                android.graphics.PointF r2 = r3.f7154a
                float r2 = r2.x
                float r1 = r1 - r2
                float r5 = r5.getY()
                android.graphics.PointF r2 = r3.f7154a
                float r2 = r2.y
                float r5 = r5 - r2
                r0.<init>(r1, r5)
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.x
                float r1 = r0.x
                float r5 = r5 + r1
                int r1 = r4.getWidth()
                float r1 = (float) r1
                float r5 = r5 + r1
                com.scanlibrary.PolygonView r1 = com.scanlibrary.PolygonView.this
                com.scanlibrary.PolygonView r1 = r1.f7148k
                int r1 = r1.getWidth()
                float r1 = (float) r1
                int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r5 >= 0) goto L_0x00df
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.y
                float r1 = r0.y
                float r5 = r5 + r1
                int r1 = r4.getHeight()
                float r1 = (float) r1
                float r5 = r5 + r1
                com.scanlibrary.PolygonView r1 = com.scanlibrary.PolygonView.this
                com.scanlibrary.PolygonView r1 = r1.f7148k
                int r1 = r1.getHeight()
                float r1 = (float) r1
                int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r5 >= 0) goto L_0x00df
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.x
                float r1 = r0.x
                float r5 = r5 + r1
                r1 = 0
                int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x00df
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.y
                float r2 = r0.y
                float r5 = r5 + r2
                int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x00df
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.x
                float r1 = r0.x
                float r5 = r5 + r1
                int r5 = (int) r5
                float r5 = (float) r5
                r4.setX(r5)
                android.graphics.PointF r5 = r3.f7155b
                float r5 = r5.y
                float r0 = r0.y
                float r5 = r5 + r0
                int r5 = (int) r5
                float r5 = (float) r5
                r4.setY(r5)
                android.graphics.PointF r5 = new android.graphics.PointF
                float r0 = r4.getX()
                float r4 = r4.getY()
                r5.<init>(r0, r4)
                goto L_0x00dd
            L_0x0095:
                com.scanlibrary.PolygonView r4 = com.scanlibrary.PolygonView.this
                java.util.Map r5 = r4.getPoints()
                boolean r4 = r4.mo23917a((java.util.Map<java.lang.Integer, android.graphics.PointF>) r5)
                if (r4 == 0) goto L_0x00aa
                com.scanlibrary.PolygonView r4 = com.scanlibrary.PolygonView.this
                android.content.res.Resources r4 = r4.getResources()
                int r5 = com.scanlibrary.C3076d.C3077a.blue
                goto L_0x00b2
            L_0x00aa:
                com.scanlibrary.PolygonView r4 = com.scanlibrary.PolygonView.this
                android.content.res.Resources r4 = r4.getResources()
                int r5 = com.scanlibrary.C3076d.C3077a.orange
            L_0x00b2:
                int r4 = r4.getColor(r5)
                com.scanlibrary.PolygonView r5 = com.scanlibrary.PolygonView.this
                android.graphics.Paint r5 = r5.f7139b
                r5.setColor(r4)
                goto L_0x00df
            L_0x00c0:
                android.graphics.PointF r0 = r3.f7154a
                float r1 = r5.getX()
                r0.x = r1
                android.graphics.PointF r0 = r3.f7154a
                float r5 = r5.getY()
                r0.y = r5
                android.graphics.PointF r5 = new android.graphics.PointF
                float r0 = r4.getX()
                float r4 = r4.getY()
                r5.<init>(r0, r4)
            L_0x00dd:
                r3.f7155b = r5
            L_0x00df:
                com.scanlibrary.PolygonView r4 = com.scanlibrary.PolygonView.this
                com.scanlibrary.PolygonView r4 = r4.f7148k
                r4.invalidate()
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scanlibrary.PolygonView.C3068b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public PolygonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7138a = context;
        m8882a();
    }

    /* renamed from: a */
    private ImageView m8880a(int i, int i2) {
        ImageView imageView = new ImageView(this.f7138a);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setImageResource(C3076d.C3079c.circle);
        imageView.setX((float) i);
        imageView.setY((float) i2);
        imageView.setOnTouchListener(new C3068b());
        return imageView;
    }

    /* renamed from: a */
    private void m8882a() {
        this.f7148k = this;
        this.f7140c = m8880a(0, 0);
        this.f7141d = m8880a(getWidth(), 0);
        this.f7142e = m8880a(0, getHeight());
        this.f7143f = m8880a(getWidth(), getHeight());
        this.f7144g = m8880a(0, getHeight() / 2);
        this.f7144g.setOnTouchListener(new C3067a(this.f7140c, this.f7142e));
        this.f7145h = m8880a(0, getWidth() / 2);
        this.f7145h.setOnTouchListener(new C3067a(this.f7140c, this.f7141d));
        this.f7146i = m8880a(0, getHeight() / 2);
        this.f7146i.setOnTouchListener(new C3067a(this.f7142e, this.f7143f));
        this.f7147j = m8880a(0, getHeight() / 2);
        this.f7147j.setOnTouchListener(new C3067a(this.f7141d, this.f7143f));
        addView(this.f7140c);
        addView(this.f7141d);
        addView(this.f7144g);
        addView(this.f7145h);
        addView(this.f7146i);
        addView(this.f7147j);
        addView(this.f7142e);
        addView(this.f7143f);
        m8884b();
    }

    /* renamed from: b */
    private void m8884b() {
        this.f7139b = new Paint();
        this.f7139b.setColor(getResources().getColor(C3076d.C3077a.blue));
        this.f7139b.setStrokeWidth(2.0f);
        this.f7139b.setAntiAlias(true);
    }

    private void setPointsCoordinates(Map<Integer, PointF> map) {
        this.f7140c.setX(map.get(0).x);
        this.f7140c.setY(map.get(0).y);
        this.f7141d.setX(map.get(1).x);
        this.f7141d.setY(map.get(1).y);
        this.f7142e.setX(map.get(2).x);
        this.f7142e.setY(map.get(2).y);
        this.f7143f.setX(map.get(3).x);
        this.f7143f.setY(map.get(3).y);
    }

    /* renamed from: a */
    public Map<Integer, PointF> mo23916a(List<PointF> list) {
        PointF pointF = new PointF();
        int size = list.size();
        for (PointF next : list) {
            float f = (float) size;
            pointF.x += next.x / f;
            pointF.y += next.y / f;
        }
        HashMap hashMap = new HashMap();
        for (PointF next2 : list) {
            int i = -1;
            if (next2.x < pointF.x && next2.y < pointF.y) {
                i = 0;
            } else if (next2.x > pointF.x && next2.y < pointF.y) {
                i = 1;
            } else if (next2.x < pointF.x && next2.y > pointF.y) {
                i = 2;
            } else if (next2.x > pointF.x && next2.y > pointF.y) {
                i = 3;
            }
            hashMap.put(Integer.valueOf(i), next2);
        }
        return hashMap;
    }

    /* renamed from: a */
    public boolean mo23917a(Map<Integer, PointF> map) {
        return map.size() == 4;
    }

    /* access modifiers changed from: protected */
    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawLine(this.f7140c.getX() + ((float) (this.f7140c.getWidth() / 2)), this.f7140c.getY() + ((float) (this.f7140c.getHeight() / 2)), this.f7142e.getX() + ((float) (this.f7142e.getWidth() / 2)), this.f7142e.getY() + ((float) (this.f7142e.getHeight() / 2)), this.f7139b);
        canvas2.drawLine(this.f7140c.getX() + ((float) (this.f7140c.getWidth() / 2)), this.f7140c.getY() + ((float) (this.f7140c.getHeight() / 2)), this.f7141d.getX() + ((float) (this.f7141d.getWidth() / 2)), this.f7141d.getY() + ((float) (this.f7141d.getHeight() / 2)), this.f7139b);
        canvas2.drawLine(this.f7141d.getX() + ((float) (this.f7141d.getWidth() / 2)), this.f7141d.getY() + ((float) (this.f7141d.getHeight() / 2)), this.f7143f.getX() + ((float) (this.f7143f.getWidth() / 2)), this.f7143f.getY() + ((float) (this.f7143f.getHeight() / 2)), this.f7139b);
        canvas2.drawLine(this.f7142e.getX() + ((float) (this.f7142e.getWidth() / 2)), this.f7142e.getY() + ((float) (this.f7142e.getHeight() / 2)), this.f7143f.getX() + ((float) (this.f7143f.getWidth() / 2)), this.f7143f.getY() + ((float) (this.f7143f.getHeight() / 2)), this.f7139b);
        this.f7144g.setX(this.f7142e.getX() - ((this.f7142e.getX() - this.f7140c.getX()) / 2.0f));
        this.f7144g.setY(this.f7142e.getY() - ((this.f7142e.getY() - this.f7140c.getY()) / 2.0f));
        this.f7147j.setX(this.f7143f.getX() - ((this.f7143f.getX() - this.f7141d.getX()) / 2.0f));
        this.f7147j.setY(this.f7143f.getY() - ((this.f7143f.getY() - this.f7141d.getY()) / 2.0f));
        this.f7146i.setX(this.f7143f.getX() - ((this.f7143f.getX() - this.f7142e.getX()) / 2.0f));
        this.f7146i.setY(this.f7143f.getY() - ((this.f7143f.getY() - this.f7142e.getY()) / 2.0f));
        this.f7145h.setX(this.f7141d.getX() - ((this.f7141d.getX() - this.f7140c.getX()) / 2.0f));
        this.f7145h.setY(this.f7141d.getY() - ((this.f7141d.getY() - this.f7140c.getY()) / 2.0f));
    }

    public Map<Integer, PointF> getPoints() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(this.f7140c.getX(), this.f7140c.getY()));
        arrayList.add(new PointF(this.f7141d.getX(), this.f7141d.getY()));
        arrayList.add(new PointF(this.f7142e.getX(), this.f7142e.getY()));
        arrayList.add(new PointF(this.f7143f.getX(), this.f7143f.getY()));
        return mo23916a((List<PointF>) arrayList);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPoints(Map<Integer, PointF> map) {
        if (map.size() == 4) {
            setPointsCoordinates(map);
        }
    }
}
