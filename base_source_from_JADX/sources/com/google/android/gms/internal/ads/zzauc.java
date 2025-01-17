package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

public final class zzauc extends ContextWrapper {
    private Context zzdxs;
    private WeakReference<Activity> zzdxt = new WeakReference<>((Object) null);

    private zzauc(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized android.content.Intent zze(android.content.Intent r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.zzdxs     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.content.ComponentName r0 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.content.ComponentName r0 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0039 }
            android.content.Context r1 = r2.zzdxs     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0039 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0020
            goto L_0x0037
        L_0x0020:
            java.lang.Object r0 = r3.clone()     // Catch:{ all -> 0x0039 }
            android.content.Intent r0 = (android.content.Intent) r0     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = super.getPackageName()     // Catch:{ all -> 0x0039 }
            android.content.ComponentName r3 = r3.getComponent()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.getClassName()     // Catch:{ all -> 0x0039 }
            r0.setClassName(r1, r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return r0
        L_0x0037:
            monitor-exit(r2)
            return r3
        L_0x0039:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauc.zze(android.content.Intent):android.content.Intent");
    }

    private final synchronized void zzf(Intent intent) {
        Activity activity = (Activity) this.zzdxt.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & -268435457);
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzp.zzku().zza(th, "");
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public static zzauc zzx(Context context) {
        return new zzauc(zzl(context));
    }

    public static Context zzy(Context context) {
        return context instanceof zzauc ? ((zzauc) context).getBaseContext() : zzl(context);
    }

    public final Context getApplicationContext() {
        return this;
    }

    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.zzdxs != null) {
            return this.zzdxs.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    public final synchronized String getPackageName() {
        if (this.zzdxs != null) {
            return this.zzdxs.getPackageName();
        }
        return super.getPackageName();
    }

    public final synchronized String getPackageResourcePath() {
        if (this.zzdxs != null) {
            return this.zzdxs.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    public final synchronized void setAppPackageName(String str) {
        this.zzdxs = super.createPackageContext(str, 0);
    }

    public final synchronized void startActivity(Intent intent) {
        zzf(zze(intent));
    }
}
