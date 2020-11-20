package androidx.p032d.p033a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.d.a.c */
public abstract class C0697c extends C0692a {

    /* renamed from: j */
    private int f2433j;

    /* renamed from: k */
    private int f2434k;

    /* renamed from: l */
    private LayoutInflater f2435l;

    @Deprecated
    public C0697c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2434k = i;
        this.f2433j = i;
        this.f2435l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public View mo2334a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2435l.inflate(this.f2433j, viewGroup, false);
    }

    /* renamed from: b */
    public View mo3960b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2435l.inflate(this.f2434k, viewGroup, false);
    }
}
