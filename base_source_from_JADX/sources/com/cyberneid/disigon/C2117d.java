package com.cyberneid.disigon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cyberneid.disigoncie.R;
import java.util.List;

/* renamed from: com.cyberneid.disigon.d */
public class C2117d extends BaseAdapter {

    /* renamed from: a */
    private int f6563a;

    /* renamed from: b */
    private LayoutInflater f6564b;

    /* renamed from: c */
    private List<String> f6565c;

    /* renamed from: com.cyberneid.disigon.d$a */
    private static class C2119a {

        /* renamed from: a */
        TextView f6566a;

        private C2119a() {
        }
    }

    public C2117d(Context context, int i, List<String> list) {
        this.f6563a = i;
        this.f6564b = LayoutInflater.from(context);
        this.f6565c = list;
    }

    public int getCount() {
        List<String> list = this.f6565c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        List<String> list = this.f6565c;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f6565c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2119a aVar;
        String str = (String) getItem(i);
        if (str != null) {
            if (view == null) {
                view = this.f6564b.inflate(this.f6563a, viewGroup, false);
                aVar = new C2119a();
                aVar.f6566a = (TextView) view.findViewById(R.id.certificateUsername);
                view.setTag(aVar);
            } else {
                aVar = (C2119a) view.getTag();
            }
            aVar.f6566a.setText(str);
        }
        return view;
    }
}
