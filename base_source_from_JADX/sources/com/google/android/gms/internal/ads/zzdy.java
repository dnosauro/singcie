package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import com.parse.ParseQuery;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzdy implements zzdv {
    protected static volatile zzfa zzwb;
    protected MotionEvent zzwt;
    protected LinkedList<MotionEvent> zzwu = new LinkedList<>();
    protected long zzwv = 0;
    protected long zzww = 0;
    protected long zzwx = 0;
    protected long zzwy = 0;
    protected long zzwz = 0;
    protected long zzxa = 0;
    protected long zzxb = 0;
    protected double zzxc;
    private double zzxd;
    private double zzxe;
    protected float zzxf;
    protected float zzxg;
    protected float zzxh;
    protected float zzxi;
    private boolean zzxj = false;
    protected boolean zzxk = false;
    protected DisplayMetrics zzxl;

    protected zzdy(Context context) {
        try {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue()) {
                zzcx.zzbo();
            } else {
                zzfd.zzb(zzwb);
            }
            this.zzxl = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdt zzdt;
        int i2;
        Context context2 = context;
        int i3 = i;
        View view2 = view;
        Activity activity2 = activity;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqw)).booleanValue();
        zzcf.zza.C3704zza zza = null;
        if (booleanValue) {
            zzdt = zzwb != null ? zzwb.zzcl() : null;
            str2 = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue() ? "be" : "te";
        } else {
            zzdt = null;
            str2 = null;
        }
        try {
            if (i3 == zzcw.zznm) {
                zza = zzc(context2, view2, activity2);
                this.zzxj = true;
                i2 = 1002;
            } else if (i3 == zzcw.zznl) {
                zza = zzb(context2, view2, activity2);
                i2 = 1008;
            } else {
                zza = zza(context2, (zzby.zza) null);
                i2 = ParseQuery.MAX_LIMIT;
            }
            if (booleanValue && zzdt != null) {
                zzdt.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            Exception exc = e;
            if (booleanValue && zzdt != null) {
                zzdt.zza(i3 == zzcw.zznm ? 1003 : i3 == zzcw.zznl ? 1009 : i3 == zzcw.zznk ? 1001 : -1, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zza != null) {
            try {
                if (((zzcf.zza) ((zzekh) zza.zzbhv())).zzbhz() != 0) {
                    String zzj = zzcx.zzj((zzcf.zza) ((zzekh) zza.zzbhv()), str);
                    if (!booleanValue || zzdt == null) {
                        return zzj;
                    }
                    zzdt.zza(i3 == zzcw.zznm ? 1006 : i3 == zzcw.zznl ? 1010 : i3 == zzcw.zznk ? 1004 : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e2) {
                Exception exc2 = e2;
                String num = Integer.toString(7);
                if (!booleanValue || zzdt == null) {
                    return num;
                }
                zzdt.zza(i3 == zzcw.zznm ? 1007 : i3 == zzcw.zznl ? 1011 : i3 == zzcw.zznk ? 1005 : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2, exc2);
                return num;
            }
        }
        return Integer.toString(5);
    }

    private final void zzbz() {
        this.zzwz = 0;
        this.zzwv = 0;
        this.zzww = 0;
        this.zzwx = 0;
        this.zzwy = 0;
        this.zzxa = 0;
        this.zzxb = 0;
        if (this.zzwu.size() > 0) {
            Iterator it = this.zzwu.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzwu.clear();
        } else {
            MotionEvent motionEvent = this.zzwt;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwt = null;
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr);

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3704zza zza(Context context, zzby.zza zza);

    public String zza(Context context, View view, Activity activity) {
        return zza(context, (String) null, zzcw.zznl, view, activity, (byte[]) null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzcw.zznm, view, activity, (byte[]) null);
    }

    public void zza(int i, int i2, int i3) {
        MotionEvent motionEvent;
        if (this.zzwt != null) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqu)).booleanValue()) {
                zzbz();
            } else {
                this.zzwt.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxl;
        if (displayMetrics != null) {
            motionEvent = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, this.zzxl.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            motionEvent = null;
        }
        this.zzwt = motionEvent;
        this.zzxk = false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(android.view.MotionEvent r13) {
        /*
            r12 = this;
            boolean r0 = r12.zzxj
            r1 = 0
            if (r0 == 0) goto L_0x000a
            r12.zzbz()
            r12.zzxj = r1
        L_0x000a:
            int r0 = r13.getAction()
            switch(r0) {
                case 0: goto L_0x0037;
                case 1: goto L_0x0012;
                case 2: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0049
        L_0x0012:
            float r0 = r13.getRawX()
            double r2 = (double) r0
            float r0 = r13.getRawY()
            double r4 = (double) r0
            double r6 = r12.zzxd
            double r6 = r2 - r6
            double r8 = r12.zzxe
            double r8 = r4 - r8
            double r10 = r12.zzxc
            double r6 = r6 * r6
            double r8 = r8 * r8
            double r6 = r6 + r8
            double r6 = java.lang.Math.sqrt(r6)
            double r10 = r10 + r6
            r12.zzxc = r10
            r12.zzxd = r2
            r12.zzxe = r4
            goto L_0x0049
        L_0x0037:
            r2 = 0
            r12.zzxc = r2
            float r0 = r13.getRawX()
            double r2 = (double) r0
            r12.zzxd = r2
            float r0 = r13.getRawY()
            double r2 = (double) r0
            r12.zzxe = r2
        L_0x0049:
            int r0 = r13.getAction()
            r2 = 1
            r4 = 1
            switch(r0) {
                case 0: goto L_0x00e6;
                case 1: goto L_0x00b0;
                case 2: goto L_0x005c;
                case 3: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0103
        L_0x0055:
            long r0 = r12.zzwy
            long r0 = r0 + r2
            r12.zzwy = r0
            goto L_0x0103
        L_0x005c:
            long r2 = r12.zzww
            int r0 = r13.getHistorySize()
            int r0 = r0 + r4
            long r5 = (long) r0
            long r2 = r2 + r5
            r12.zzww = r2
            com.google.android.gms.internal.ads.zzfg r13 = r12.zzb((android.view.MotionEvent) r13)     // Catch:{ zzet -> 0x0103 }
            if (r13 == 0) goto L_0x0077
            java.lang.Long r0 = r13.zzzr     // Catch:{ zzet -> 0x0103 }
            if (r0 == 0) goto L_0x0077
            java.lang.Long r0 = r13.zzzu     // Catch:{ zzet -> 0x0103 }
            if (r0 == 0) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            if (r0 == 0) goto L_0x008c
            long r2 = r12.zzxa     // Catch:{ zzet -> 0x0103 }
            java.lang.Long r0 = r13.zzzr     // Catch:{ zzet -> 0x0103 }
            long r5 = r0.longValue()     // Catch:{ zzet -> 0x0103 }
            java.lang.Long r0 = r13.zzzu     // Catch:{ zzet -> 0x0103 }
            long r7 = r0.longValue()     // Catch:{ zzet -> 0x0103 }
            long r5 = r5 + r7
            long r2 = r2 + r5
            r12.zzxa = r2     // Catch:{ zzet -> 0x0103 }
        L_0x008c:
            android.util.DisplayMetrics r0 = r12.zzxl     // Catch:{ zzet -> 0x0103 }
            if (r0 == 0) goto L_0x009b
            if (r13 == 0) goto L_0x009b
            java.lang.Long r0 = r13.zzzs     // Catch:{ zzet -> 0x0103 }
            if (r0 == 0) goto L_0x009b
            java.lang.Long r0 = r13.zzzv     // Catch:{ zzet -> 0x0103 }
            if (r0 == 0) goto L_0x009b
            r1 = 1
        L_0x009b:
            if (r1 == 0) goto L_0x0103
            long r0 = r12.zzxb     // Catch:{ zzet -> 0x0103 }
            java.lang.Long r2 = r13.zzzs     // Catch:{ zzet -> 0x0103 }
            long r2 = r2.longValue()     // Catch:{ zzet -> 0x0103 }
            java.lang.Long r13 = r13.zzzv     // Catch:{ zzet -> 0x0103 }
            long r5 = r13.longValue()     // Catch:{ zzet -> 0x0103 }
            long r2 = r2 + r5
            long r0 = r0 + r2
            r12.zzxb = r0     // Catch:{ zzet -> 0x0103 }
            goto L_0x0103
        L_0x00b0:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r13)
            r12.zzwt = r13
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzwu
            android.view.MotionEvent r0 = r12.zzwt
            r13.add(r0)
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzwu
            int r13 = r13.size()
            r0 = 6
            if (r13 <= r0) goto L_0x00d1
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzwu
            java.lang.Object r13 = r13.remove()
            android.view.MotionEvent r13 = (android.view.MotionEvent) r13
            r13.recycle()
        L_0x00d1:
            long r0 = r12.zzwx
            long r0 = r0 + r2
            r12.zzwx = r0
            java.lang.Throwable r13 = new java.lang.Throwable     // Catch:{ zzet -> 0x0103 }
            r13.<init>()     // Catch:{ zzet -> 0x0103 }
            java.lang.StackTraceElement[] r13 = r13.getStackTrace()     // Catch:{ zzet -> 0x0103 }
            long r0 = r12.zza((java.lang.StackTraceElement[]) r13)     // Catch:{ zzet -> 0x0103 }
            r12.zzwz = r0     // Catch:{ zzet -> 0x0103 }
            goto L_0x0103
        L_0x00e6:
            float r0 = r13.getX()
            r12.zzxf = r0
            float r0 = r13.getY()
            r12.zzxg = r0
            float r0 = r13.getRawX()
            r12.zzxh = r0
            float r13 = r13.getRawY()
            r12.zzxi = r13
            long r0 = r12.zzwv
            long r0 = r0 + r2
            r12.zzwv = r0
        L_0x0103:
            r12.zzxk = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.zza(android.view.MotionEvent):void");
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3704zza zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzfg zzb(MotionEvent motionEvent);

    public String zzb(Context context) {
        if (!zzff.isMainThread()) {
            return zza(context, (String) null, zzcw.zznk, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public void zzb(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3704zza zzc(Context context, View view, Activity activity);
}
