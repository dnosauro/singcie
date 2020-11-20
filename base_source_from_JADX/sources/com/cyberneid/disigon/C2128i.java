package com.cyberneid.disigon;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.cyberneid.disigoncie.R;
import java.util.List;

/* renamed from: com.cyberneid.disigon.i */
public class C2128i extends BaseAdapter {

    /* renamed from: a */
    private final Context f6588a;

    /* renamed from: b */
    private LayoutInflater f6589b;

    /* renamed from: c */
    private List<Bitmap> f6590c;

    /* renamed from: com.cyberneid.disigon.i$a */
    private static class C2130a {

        /* renamed from: a */
        ImageView f6591a;

        private C2130a() {
        }
    }

    public C2128i(Context context, List<Bitmap> list) {
        this.f6589b = LayoutInflater.from(context);
        this.f6590c = list;
        this.f6588a = context;
    }

    public int getCount() {
        List<Bitmap> list = this.f6590c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        List<Bitmap> list = this.f6590c;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f6590c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2130a aVar;
        Bitmap bitmap = (Bitmap) getItem(i);
        if (bitmap != null) {
            if (view == null) {
                view = this.f6589b.inflate(R.layout.item_scanned_page, viewGroup, false);
                aVar = new C2130a();
                aVar.f6591a = (ImageView) view.findViewById(R.id.scannedPage);
                view.setTag(aVar);
            } else {
                aVar = (C2130a) view.getTag();
            }
            aVar.f6591a.setImageBitmap(bitmap);
        }
        return view;
    }
}
