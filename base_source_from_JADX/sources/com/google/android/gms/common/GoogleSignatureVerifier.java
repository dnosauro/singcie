package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@ShowFirstParty
@CheckReturnValue
@KeepForSdk
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    private GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzc.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    private static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdArr.length; i++) {
            if (zzdArr[i].equals(zzg)) {
                return zzdArr[i];
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzl zza(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0009
            java.lang.String r8 = "null pkg"
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zza((java.lang.String) r8)
            return r8
        L_0x0009:
            java.lang.String r0 = r7.zzc
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zza()
            return r8
        L_0x0016:
            android.content.Context r0 = r7.zzb     // Catch:{ NameNotFoundException -> 0x0077 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0077 }
            r1 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r8, r1)     // Catch:{ NameNotFoundException -> 0x0077 }
            android.content.Context r1 = r7.zzb
            boolean r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r1)
            if (r0 != 0) goto L_0x0031
            java.lang.String r0 = "null pkg"
        L_0x002c:
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzl.zza((java.lang.String) r0)
            goto L_0x0070
        L_0x0031:
            android.content.pm.Signature[] r2 = r0.signatures
            if (r2 == 0) goto L_0x006d
            android.content.pm.Signature[] r2 = r0.signatures
            int r2 = r2.length
            r3 = 1
            if (r2 == r3) goto L_0x003c
            goto L_0x006d
        L_0x003c:
            com.google.android.gms.common.zzg r2 = new com.google.android.gms.common.zzg
            android.content.pm.Signature[] r4 = r0.signatures
            r5 = 0
            r4 = r4[r5]
            byte[] r4 = r4.toByteArray()
            r2.<init>(r4)
            java.lang.String r4 = r0.packageName
            com.google.android.gms.common.zzl r1 = com.google.android.gms.common.zzc.zza(r4, r2, r1, r5)
            boolean r6 = r1.zza
            if (r6 == 0) goto L_0x006b
            android.content.pm.ApplicationInfo r6 = r0.applicationInfo
            if (r6 == 0) goto L_0x006b
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 == 0) goto L_0x006b
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzc.zza(r4, r2, r5, r3)
            boolean r0 = r0.zza
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = "debuggable release cert app rejected"
            goto L_0x002c
        L_0x006b:
            r0 = r1
            goto L_0x0070
        L_0x006d:
            java.lang.String r0 = "single cert required"
            goto L_0x002c
        L_0x0070:
            boolean r1 = r0.zza
            if (r1 == 0) goto L_0x0076
            r7.zzc = r8
        L_0x0076:
            return r0
        L_0x0077:
            java.lang.String r0 = "no pkg "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0089
            java.lang.String r8 = r0.concat(r8)
            goto L_0x008e
        L_0x0089:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r0)
        L_0x008e:
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zza((java.lang.String) r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zza(java.lang.String):com.google.android.gms.common.zzl");
    }

    private final zzl zza(String str, int i) {
        try {
            PackageInfo zza2 = Wrappers.packageManager(this.zzb).zza(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
            if (zza2 == null) {
                return zzl.zza("null pkg");
            }
            if (zza2.signatures != null) {
                if (zza2.signatures.length == 1) {
                    zzg zzg = new zzg(zza2.signatures[0].toByteArray());
                    String str2 = zza2.packageName;
                    zzl zza3 = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                    return (!zza3.zza || zza2.applicationInfo == null || (zza2.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zza) ? zza3 : zzl.zza("debuggable release cert app rejected");
                }
            }
            return zzl.zza("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzl.zza(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (zza(packageInfo, z ? zzi.zza : new zzd[]{zzi.zza[0]}) != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzl zza2 = zza(str);
        zza2.zzc();
        return zza2.zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.google.android.gms.common.zzl} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isUidGoogleSigned(int r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)
            java.lang.String[] r0 = r0.zza(r6)
            if (r0 == 0) goto L_0x002b
            int r1 = r0.length
            if (r1 != 0) goto L_0x0010
            goto L_0x002b
        L_0x0010:
            r1 = 0
            int r2 = r0.length
            r3 = 0
        L_0x0013:
            if (r3 >= r2) goto L_0x0023
            r1 = r0[r3]
            com.google.android.gms.common.zzl r1 = r5.zza((java.lang.String) r1, (int) r6)
            boolean r4 = r1.zza
            if (r4 == 0) goto L_0x0020
            goto L_0x0031
        L_0x0020:
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0023:
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            r1 = r6
            com.google.android.gms.common.zzl r1 = (com.google.android.gms.common.zzl) r1
            goto L_0x0031
        L_0x002b:
            java.lang.String r6 = "no pkgs"
            com.google.android.gms.common.zzl r1 = com.google.android.gms.common.zzl.zza((java.lang.String) r6)
        L_0x0031:
            r1.zzc()
            boolean r6 = r1.zza
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.isUidGoogleSigned(int):boolean");
    }
}
