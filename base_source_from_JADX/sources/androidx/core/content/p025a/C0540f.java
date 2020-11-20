package androidx.core.content.p025a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.core.p029g.C0588f;

/* renamed from: androidx.core.content.a.f */
public final class C0540f {

    /* renamed from: androidx.core.content.a.f$a */
    public static abstract class C0541a {
        public final void callbackFailAsync(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    C0541a.this.onFontRetrievalFailed(i);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    C0541a.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    /* renamed from: a */
    public static Typeface m2147a(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m2149a(context, i, new TypedValue(), 0, (C0541a) null, (Handler) null, false);
    }

    /* renamed from: a */
    public static Typeface m2148a(Context context, int i, TypedValue typedValue, int i2, C0541a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m2149a(context, i, typedValue, i2, aVar, (Handler) null, true);
    }

    /* renamed from: a */
    private static Typeface m2149a(Context context, int i, TypedValue typedValue, int i2, C0541a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = m2150a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a != null || aVar != null) {
            return a;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface m2150a(android.content.Context r14, android.content.res.Resources r15, android.util.TypedValue r16, int r17, int r18, androidx.core.content.p025a.C0540f.C0541a r19, android.os.Handler r20, boolean r21) {
        /*
            r0 = r15
            r1 = r16
            r4 = r17
            r5 = r18
            r9 = r19
            r10 = r20
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x009e
            java.lang.CharSequence r1 = r1.string
            java.lang.String r11 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r11.startsWith(r1)
            r12 = 0
            r13 = -3
            if (r1 != 0) goto L_0x0025
            if (r9 == 0) goto L_0x0024
            r9.callbackFailAsync(r13, r10)
        L_0x0024:
            return r12
        L_0x0025:
            android.graphics.Typeface r1 = androidx.core.graphics.C0593c.m2293a((android.content.res.Resources) r15, (int) r4, (int) r5)
            if (r1 == 0) goto L_0x0031
            if (r9 == 0) goto L_0x0030
            r9.callbackSuccessAsync(r1, r10)
        L_0x0030:
            return r1
        L_0x0031:
            java.lang.String r1 = r11.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            if (r1 == 0) goto L_0x0065
            android.content.res.XmlResourceParser r1 = r15.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            androidx.core.content.a.c$a r2 = androidx.core.content.p025a.C0532c.m2123a((org.xmlpull.v1.XmlPullParser) r1, (android.content.res.Resources) r15)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            if (r2 != 0) goto L_0x0054
            java.lang.String r0 = "ResourcesCompat"
            java.lang.String r1 = "Failed to find font-family tag"
            android.util.Log.e(r0, r1)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            if (r9 == 0) goto L_0x0053
            r9.callbackFailAsync(r13, r10)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
        L_0x0053:
            return r12
        L_0x0054:
            r1 = r14
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.C0593c.m2292a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            return r0
        L_0x0065:
            r1 = r14
            android.graphics.Typeface r0 = androidx.core.graphics.C0593c.m2289a(r14, r15, r4, r11, r5)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            if (r9 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0072
            r9.callbackSuccessAsync(r0, r10)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
            goto L_0x0075
        L_0x0072:
            r9.callbackFailAsync(r13, r10)     // Catch:{ XmlPullParserException -> 0x0081, IOException -> 0x0076 }
        L_0x0075:
            return r0
        L_0x0076:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to read xml resource "
            goto L_0x008b
        L_0x0081:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse xml resource "
        L_0x008b:
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
            if (r9 == 0) goto L_0x009d
            r9.callbackFailAsync(r13, r10)
        L_0x009d:
            return r12
        L_0x009e:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r15.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r17)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p025a.C0540f.m2150a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.a.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Drawable m2151a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    /* renamed from: a */
    public static void m2152a(Context context, int i, C0541a aVar, Handler handler) {
        C0588f.m2266a(aVar);
        if (context.isRestricted()) {
            aVar.callbackFailAsync(-4, handler);
            return;
        }
        m2149a(context, i, new TypedValue(), 0, aVar, handler, false);
    }
}
