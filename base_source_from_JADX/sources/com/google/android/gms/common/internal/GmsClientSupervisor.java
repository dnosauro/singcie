package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.analytics.FirebaseAnalytics;

@KeepForSdk
public abstract class GmsClientSupervisor {
    private static int zza = 129;
    private static final Object zzb = new Object();
    private static GmsClientSupervisor zzc;

    protected static final class zza {
        private static final Uri zzf = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();
        private final String zza;
        private final String zzb;
        private final ComponentName zzc;
        private final int zzd;
        private final boolean zze;

        public zza(ComponentName componentName, int i) {
            this.zza = null;
            this.zzb = null;
            this.zzc = (ComponentName) Preconditions.checkNotNull(componentName);
            this.zzd = i;
            this.zze = false;
        }

        public zza(String str, int i) {
            this(str, "com.google.android.gms", i);
        }

        private zza(String str, String str2, int i) {
            this(str, str2, i, false);
        }

        public zza(String str, String str2, int i, boolean z) {
            this.zza = Preconditions.checkNotEmpty(str);
            this.zzb = Preconditions.checkNotEmpty(str2);
            this.zzc = null;
            this.zzd = i;
            this.zze = z;
        }

        /* JADX WARNING: type inference failed for: r5v3, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.content.Intent zzb(android.content.Context r5) {
            /*
                r4 = this;
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                java.lang.String r1 = "serviceActionBundleKey"
                java.lang.String r2 = r4.zza
                r0.putString(r1, r2)
                r1 = 0
                android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x001a }
                android.net.Uri r2 = zzf     // Catch:{ IllegalArgumentException -> 0x001a }
                java.lang.String r3 = "serviceIntentCall"
                android.os.Bundle r5 = r5.call(r2, r3, r1, r0)     // Catch:{ IllegalArgumentException -> 0x001a }
                goto L_0x0040
            L_0x001a:
                r5 = move-exception
                java.lang.String r0 = "ConnectionStatusConfig"
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r2 = java.lang.String.valueOf(r5)
                int r2 = r2.length()
                int r2 = r2 + 34
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Dynamic intent resolution failed: "
                r3.append(r2)
                r3.append(r5)
                java.lang.String r5 = r3.toString()
                android.util.Log.w(r0, r5)
                r5 = r1
            L_0x0040:
                if (r5 != 0) goto L_0x0043
                goto L_0x004c
            L_0x0043:
                java.lang.String r0 = "serviceResponseIntentKey"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x004c:
                if (r1 != 0) goto L_0x006c
                java.lang.String r5 = "ConnectionStatusConfig"
                java.lang.String r0 = "Dynamic lookup for intent failed for action: "
                java.lang.String r2 = r4.zza
                java.lang.String r2 = java.lang.String.valueOf(r2)
                int r3 = r2.length()
                if (r3 == 0) goto L_0x0063
                java.lang.String r0 = r0.concat(r2)
                goto L_0x0069
            L_0x0063:
                java.lang.String r2 = new java.lang.String
                r2.<init>(r0)
                r0 = r2
            L_0x0069:
                android.util.Log.w(r5, r0)
            L_0x006c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientSupervisor.zza.zzb(android.content.Context):android.content.Intent");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            return Objects.equal(this.zza, zza2.zza) && Objects.equal(this.zzb, zza2.zzb) && Objects.equal(this.zzc, zza2.zzc) && this.zzd == zza2.zzd && this.zze == zza2.zze;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd), Boolean.valueOf(this.zze));
        }

        public final String toString() {
            String str = this.zza;
            if (str != null) {
                return str;
            }
            Preconditions.checkNotNull(this.zzc);
            return this.zzc.flattenToString();
        }

        public final Intent zza(Context context) {
            if (this.zza == null) {
                return new Intent().setComponent(this.zzc);
            }
            Intent zzb2 = this.zze ? zzb(context) : null;
            return zzb2 == null ? new Intent(this.zza).setPackage(this.zzb) : zzb2;
        }

        public final String zza() {
            return this.zzb;
        }

        public final ComponentName zzb() {
            return this.zzc;
        }

        public final int zzc() {
            return this.zzd;
        }
    }

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return zza;
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzb) {
            if (zzc == null) {
                zzc = new zzf(context.getApplicationContext());
            }
        }
        return zzc;
    }

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzb(zza zza2, ServiceConnection serviceConnection, String str);
}
