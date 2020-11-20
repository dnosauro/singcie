package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: h */
    static final PorterDuff.Mode f2194h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f2195a = -1;

    /* renamed from: b */
    Object f2196b;

    /* renamed from: c */
    public byte[] f2197c = null;

    /* renamed from: d */
    public Parcelable f2198d = null;

    /* renamed from: e */
    public int f2199e = 0;

    /* renamed from: f */
    public int f2200f = 0;

    /* renamed from: g */
    public ColorStateList f2201g = null;

    /* renamed from: i */
    PorterDuff.Mode f2202i = f2194h;

    /* renamed from: j */
    public String f2203j = null;

    public IconCompat() {
    }

    private IconCompat(int i) {
        this.f2195a = i;
    }

    /* renamed from: a */
    private static int m2303a(Icon icon) {
        String str;
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            e = e;
            str = "IconCompat";
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e(str, sb.toString(), e);
            return -1;
        } catch (InvocationTargetException e2) {
            e = e2;
            str = "IconCompat";
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e(str, sb.toString(), e);
            return -1;
        } catch (NoSuchMethodException e3) {
            e = e3;
            str = "IconCompat";
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e(str, sb.toString(), e);
            return -1;
        }
    }

    /* renamed from: a */
    static Bitmap m2304a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    /* renamed from: a */
    public static IconCompat m2305a(Resources resources, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2199e = i;
            if (resources != null) {
                try {
                    iconCompat.f2196b = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2196b = str;
            }
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    /* renamed from: a */
    private static String m2306a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: b */
    private static String m2307b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        }
    }

    /* renamed from: c */
    private static int m2308c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        }
    }

    /* renamed from: a */
    public int mo3616a() {
        return (this.f2195a != -1 || Build.VERSION.SDK_INT < 23) ? this.f2195a : m2303a((Icon) this.f2196b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r4 = r4.getBytes(java.nio.charset.Charset.forName("UTF-16"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        r3.f2197c = r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3617a(boolean r4) {
        /*
            r3 = this;
            android.graphics.PorterDuff$Mode r0 = r3.f2202i
            java.lang.String r0 = r0.name()
            r3.f2203j = r0
            int r0 = r3.f2195a
            r1 = -1
            if (r0 == r1) goto L_0x0045
            switch(r0) {
                case 1: goto L_0x002e;
                case 2: goto L_0x001d;
                case 3: goto L_0x0018;
                case 4: goto L_0x0011;
                case 5: goto L_0x002e;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x004d
        L_0x0011:
            java.lang.Object r4 = r3.f2196b
            java.lang.String r4 = r4.toString()
            goto L_0x0021
        L_0x0018:
            java.lang.Object r4 = r3.f2196b
            byte[] r4 = (byte[]) r4
            goto L_0x002b
        L_0x001d:
            java.lang.Object r4 = r3.f2196b
            java.lang.String r4 = (java.lang.String) r4
        L_0x0021:
            java.lang.String r0 = "UTF-16"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            byte[] r4 = r4.getBytes(r0)
        L_0x002b:
            r3.f2197c = r4
            goto L_0x004d
        L_0x002e:
            if (r4 == 0) goto L_0x0047
            java.lang.Object r4 = r3.f2196b
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            r2 = 90
            r4.compress(r1, r2, r0)
            byte[] r4 = r0.toByteArray()
            goto L_0x002b
        L_0x0045:
            if (r4 != 0) goto L_0x004e
        L_0x0047:
            java.lang.Object r4 = r3.f2196b
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            r3.f2198d = r4
        L_0x004d:
            return
        L_0x004e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Can't serialize Icon created with IconCompat#createFromIcon"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.mo3617a(boolean):void");
    }

    /* renamed from: b */
    public String mo3618b() {
        if (this.f2195a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2307b((Icon) this.f2196b);
        }
        if (this.f2195a == 2) {
            return ((String) this.f2196b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    /* renamed from: c */
    public int mo3619c() {
        if (this.f2195a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2308c((Icon) this.f2196b);
        }
        if (this.f2195a == 2) {
            return this.f2199e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Icon mo3620d() {
        /*
            r3 = this;
            int r0 = r3.f2195a
            r1 = -1
            if (r0 == r1) goto L_0x0063
            switch(r0) {
                case 1: goto L_0x004a;
                case 2: goto L_0x003f;
                case 3: goto L_0x0032;
                case 4: goto L_0x0029;
                case 5: goto L_0x0010;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown type"
            r0.<init>(r1)
            throw r0
        L_0x0010:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x001f
            java.lang.Object r0 = r3.f2196b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r0)
            goto L_0x0052
        L_0x001f:
            java.lang.Object r0 = r3.f2196b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r1 = 0
            android.graphics.Bitmap r0 = m2304a(r0, r1)
            goto L_0x004e
        L_0x0029:
            java.lang.Object r0 = r3.f2196b
            java.lang.String r0 = (java.lang.String) r0
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithContentUri(r0)
            goto L_0x0052
        L_0x0032:
            java.lang.Object r0 = r3.f2196b
            byte[] r0 = (byte[]) r0
            int r1 = r3.f2199e
            int r2 = r3.f2200f
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithData(r0, r1, r2)
            goto L_0x0052
        L_0x003f:
            java.lang.String r0 = r3.mo3618b()
            int r1 = r3.f2199e
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithResource(r0, r1)
            goto L_0x0052
        L_0x004a:
            java.lang.Object r0 = r3.f2196b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
        L_0x004e:
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithBitmap(r0)
        L_0x0052:
            android.content.res.ColorStateList r1 = r3.f2201g
            if (r1 == 0) goto L_0x0059
            r0.setTintList(r1)
        L_0x0059:
            android.graphics.PorterDuff$Mode r1 = r3.f2202i
            android.graphics.PorterDuff$Mode r2 = f2194h
            if (r1 == r2) goto L_0x0062
            r0.setTintMode(r1)
        L_0x0062:
            return r0
        L_0x0063:
            java.lang.Object r0 = r3.f2196b
            android.graphics.drawable.Icon r0 = (android.graphics.drawable.Icon) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.mo3620d():android.graphics.drawable.Icon");
    }

    /* renamed from: e */
    public void mo3621e() {
        Object obj;
        this.f2202i = PorterDuff.Mode.valueOf(this.f2203j);
        int i = this.f2195a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    obj = this.f2198d;
                    if (obj == null) {
                        byte[] bArr = this.f2197c;
                        this.f2196b = bArr;
                        this.f2195a = 3;
                        this.f2199e = 0;
                        this.f2200f = bArr.length;
                        return;
                    }
                    break;
                case 2:
                case 4:
                    obj = new String(this.f2197c, Charset.forName("UTF-16"));
                    break;
                case 3:
                    obj = this.f2197c;
                    break;
                default:
                    return;
            }
        } else {
            obj = this.f2198d;
            if (obj == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.f2196b = obj;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            int r0 = r5.f2195a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r5.f2196b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r5.f2195a
            java.lang.String r1 = m2306a((int) r1)
            r0.append(r1)
            int r1 = r5.f2195a
            switch(r1) {
                case 1: goto L_0x006c;
                case 2: goto L_0x0043;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006c;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008c
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r5.f2196b
            r0.append(r1)
            goto L_0x008c
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r5.f2199e
            r0.append(r1)
            int r1 = r5.f2200f
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r5.f2200f
            goto L_0x0089
        L_0x0043:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r5.mo3618b()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.String r1 = "0x%08x"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r5.mo3619c()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            goto L_0x008c
        L_0x006c:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r5.f2196b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r5.f2196b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x0089:
            r0.append(r1)
        L_0x008c:
            android.content.res.ColorStateList r1 = r5.f2201g
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r5.f2201g
            r0.append(r1)
        L_0x009a:
            android.graphics.PorterDuff$Mode r1 = r5.f2202i
            android.graphics.PorterDuff$Mode r2 = f2194h
            if (r1 == r2) goto L_0x00aa
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r5.f2202i
            r0.append(r1)
        L_0x00aa:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
