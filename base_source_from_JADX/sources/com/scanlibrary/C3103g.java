package com.scanlibrary;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.scanlibrary.C3076d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.scanlibrary.g */
public class C3103g extends Fragment {

    /* renamed from: a */
    private ImageButton f7203a;

    /* renamed from: b */
    private ImageButton f7204b;

    /* renamed from: c */
    private ImageButton f7205c;

    /* renamed from: d */
    private ImageView f7206d;

    /* renamed from: e */
    private FrameLayout f7207e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PolygonView f7208f;

    /* renamed from: g */
    private View f7209g;

    /* renamed from: h */
    private C3074c f7210h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C3069a f7211i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Bitmap f7212j;

    /* renamed from: com.scanlibrary.g$a */
    private class C3105a implements View.OnClickListener {
        private C3105a() {
        }

        public void onClick(View view) {
            C3103g.this.f7211i.mo23925a();
        }
    }

    /* renamed from: com.scanlibrary.g$b */
    private class C3106b implements View.OnClickListener {
        private C3106b() {
        }

        public void onClick(View view) {
            Bitmap a = C3103g.m8913a(C3103g.this.f7212j, 90);
            C3103g.this.f7212j.recycle();
            Bitmap unused = C3103g.this.f7212j = a;
            C3103g gVar = C3103g.this;
            gVar.m8920a(gVar.f7212j);
        }
    }

    /* renamed from: com.scanlibrary.g$c */
    private class C3107c extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: b */
        private Map<Integer, PointF> f7217b;

        public C3107c(Map<Integer, PointF> map) {
            this.f7217b = map;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            C3103g gVar = C3103g.this;
            Bitmap a = gVar.m8915a(gVar.f7212j, this.f7217b);
            C3103g.this.f7211i.mo23928b(C3111i.m8940a((Context) C3103g.this.getActivity(), a));
            return a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            bitmap.recycle();
            C3103g.this.mo23970a();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C3103g gVar = C3103g.this;
            gVar.mo23971a(gVar.getString(C3076d.C3082f.scanning));
        }
    }

    /* renamed from: com.scanlibrary.g$d */
    private class C3108d implements View.OnClickListener {
        private C3108d() {
        }

        public void onClick(View view) {
            Map<Integer, PointF> points = C3103g.this.f7208f.getPoints();
            if (C3103g.this.m8922a(points)) {
                new C3107c(points).execute(new Void[0]);
            } else {
                C3103g.this.m8934e();
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m8913a(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: a */
    private Bitmap m8914a(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), new RectF(0.0f, 0.0f, (float) i, (float) i2), Matrix.ScaleToFit.CENTER);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m8915a(Bitmap bitmap, Map<Integer, PointF> map) {
        Map<Integer, PointF> map2 = map;
        bitmap.getWidth();
        bitmap.getHeight();
        float width = ((float) bitmap.getWidth()) / ((float) this.f7206d.getWidth());
        float height = ((float) bitmap.getHeight()) / ((float) this.f7206d.getHeight());
        float f = map2.get(0).x * width;
        float f2 = map2.get(1).x * width;
        float f3 = map2.get(2).x * width;
        float f4 = map2.get(3).x * width;
        float f5 = map2.get(0).y * height;
        float f6 = map2.get(1).y * height;
        float f7 = map2.get(2).y * height;
        float f8 = map2.get(3).y * height;
        Log.d("", "POints(" + f + "," + f5 + ")(" + f2 + "," + f6 + ")(" + f3 + "," + f7 + ")(" + f4 + "," + f8 + ")");
        return ((ScanActivity) getActivity()).getScannedBitmap(bitmap, f, f5, f2, f6, f3, f7, f4, f8);
    }

    /* renamed from: a */
    private Map<Integer, PointF> m8919a(Bitmap bitmap, List<PointF> list) {
        Map<Integer, PointF> a = this.f7208f.mo23916a(list);
        return !this.f7208f.mo23917a(a) ? m8931d(bitmap) : a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8920a(Bitmap bitmap) {
        this.f7206d.setImageBitmap(m8914a(bitmap, this.f7207e.getWidth(), this.f7207e.getHeight()));
        Bitmap bitmap2 = ((BitmapDrawable) this.f7206d.getDrawable()).getBitmap();
        this.f7208f.setPoints(m8924b(bitmap2));
        this.f7208f.setVisibility(0);
        int dimension = ((int) getResources().getDimension(C3076d.C3078b.scanPadding)) * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bitmap2.getWidth() + dimension, bitmap2.getHeight() + dimension);
        layoutParams.gravity = 17;
        this.f7208f.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8922a(Map<Integer, PointF> map) {
        return map.size() == 4;
    }

    /* renamed from: b */
    private Map<Integer, PointF> m8924b(Bitmap bitmap) {
        return m8919a(bitmap, m8929c(bitmap));
    }

    /* renamed from: b */
    private void m8925b() {
        this.f7206d = (ImageView) this.f7209g.findViewById(C3076d.C3080d.sourceImageView);
        this.f7203a = (ImageButton) this.f7209g.findViewById(C3076d.C3080d.scanButton);
        this.f7203a.setOnClickListener(new C3108d());
        this.f7204b = (ImageButton) this.f7209g.findViewById(C3076d.C3080d.cancelButton);
        this.f7204b.setOnClickListener(new C3105a());
        this.f7205c = (ImageButton) this.f7209g.findViewById(C3076d.C3080d.rotateButton);
        this.f7205c.setOnClickListener(new C3106b());
        this.f7207e = (FrameLayout) this.f7209g.findViewById(C3076d.C3080d.sourceFrame);
        this.f7208f = (PolygonView) this.f7209g.findViewById(C3076d.C3080d.polygonView);
        this.f7207e.post(new Runnable() {
            public void run() {
                C3103g gVar = C3103g.this;
                Bitmap unused = gVar.f7212j = gVar.m8927c();
                if (C3103g.this.f7212j != null) {
                    C3103g gVar2 = C3103g.this;
                    gVar2.m8920a(gVar2.f7212j);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Bitmap m8927c() {
        Uri d = m8930d();
        try {
            Bitmap a = C3111i.m8939a((Context) getActivity(), d);
            getActivity().getContentResolver().delete(d, (String) null, (String[]) null);
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private List<PointF> m8929c(Bitmap bitmap) {
        float[] points = ((ScanActivity) getActivity()).getPoints(bitmap);
        float f = points[0];
        float f2 = points[1];
        float f3 = points[2];
        float f4 = points[3];
        float f5 = points[4];
        float f6 = points[5];
        float f7 = points[6];
        float f8 = points[7];
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(f, f5));
        arrayList.add(new PointF(f2, f6));
        arrayList.add(new PointF(f3, f7));
        arrayList.add(new PointF(f4, f8));
        return arrayList;
    }

    /* renamed from: d */
    private Uri m8930d() {
        return (Uri) getArguments().getParcelable("selectedBitmap");
    }

    /* renamed from: d */
    private Map<Integer, PointF> m8931d(Bitmap bitmap) {
        HashMap hashMap = new HashMap();
        hashMap.put(0, new PointF(0.0f, 0.0f));
        hashMap.put(1, new PointF((float) bitmap.getWidth(), 0.0f));
        hashMap.put(2, new PointF(0.0f, (float) bitmap.getHeight()));
        hashMap.put(3, new PointF((float) bitmap.getWidth(), (float) bitmap.getHeight()));
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8934e() {
        new C3109h(C3076d.C3082f.f7167ok, getString(C3076d.C3082f.cantCrop), "Error", true).show(getActivity().getFragmentManager(), C3109h.class.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23970a() {
        this.f7210h.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23971a(String str) {
        this.f7210h = new C3074c(str);
        this.f7210h.show(getFragmentManager(), C3074c.class.toString());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C3069a) {
            this.f7211i = (C3069a) activity;
            return;
        }
        throw new ClassCastException("Activity must implement IScanner");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7209g = layoutInflater.inflate(C3076d.C3081e.scan_fragment_layout, (ViewGroup) null);
        m8925b();
        return this.f7209g;
    }
}
