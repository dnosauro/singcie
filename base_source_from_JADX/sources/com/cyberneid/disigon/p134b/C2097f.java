package com.cyberneid.disigon.p134b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.C1831e;
import com.cyberneid.p105d.p114g.C1867f;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p122e.p125c.C1861e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.cyberneid.disigon.b.f */
public class C2097f {

    /* renamed from: a */
    static final String[] f6523a = {"/data/bin/", "/system/bin/", "/system/xbin/", "/sbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

    /* renamed from: b */
    private static final StringBuilder f6524b = new StringBuilder(50);

    /* renamed from: c */
    private static final Formatter f6525c = new Formatter(f6524b, Locale.getDefault());

    /* renamed from: a */
    public static C1783c m8311a(Bitmap bitmap) {
        C1783c cVar = new C1783c();
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        C1831e eVar = new C1831e(new C1763f(width, height));
        cVar.mo8057a(eVar);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C1861e a = C1861e.m7709a(cVar, byteArray, "signature" + System.currentTimeMillis());
        C1867f fVar = new C1867f(cVar, eVar);
        fVar.mo8322a(a, 0.0f, 0.0f, width, height);
        fVar.close();
        return cVar;
    }

    /* renamed from: a */
    public static C1783c m8312a(ArrayList<Bitmap> arrayList) {
        C1783c cVar = new C1783c();
        Iterator<Bitmap> it = arrayList.iterator();
        while (it.hasNext()) {
            Bitmap next = it.next();
            float width = (float) next.getWidth();
            float height = (float) next.getHeight();
            C1831e eVar = new C1831e(new C1763f(width, height));
            cVar.mo8057a(eVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            next.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C1861e a = C1861e.m7709a(cVar, byteArray, "page" + System.currentTimeMillis());
            C1867f fVar = new C1867f(cVar, eVar);
            fVar.mo8322a(a, 0.0f, 0.0f, width, height);
            fVar.close();
        }
        return cVar;
    }

    /* renamed from: a */
    public static String m8313a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        String str = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
            } finally {
                query.close();
            }
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m8314a() {
        return Build.VERSION.SDK_INT >= 16;
    }

    /* renamed from: b */
    public static Uri m8315b(Context context, Uri uri) {
        String a = m8313a(context, uri);
        if (a == null) {
            a = uri.getLastPathSegment();
        }
        C1783c a2 = m8311a(BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri)));
        File file = new File(context.getFilesDir(), a + ".pdf");
        a2.mo8060a(file);
        a2.close();
        Uri fromFile = Uri.fromFile(file);
        System.out.println(fromFile);
        return fromFile;
    }

    /* renamed from: b */
    public static boolean m8316b() {
        return Build.VERSION.SDK_INT >= 17;
    }

    /* renamed from: c */
    public static Bitmap m8317c(Context context, Uri uri) {
        return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
    }

    /* renamed from: c */
    public static boolean m8318c() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: d */
    public static boolean m8319d() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
