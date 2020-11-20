package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.regex.Pattern;

public final class zzdtl {
    private final Context context;
    private final zzdsi zzvs;

    public zzdtl(Context context2, zzdsi zzdsi) {
        this.context = context2;
        this.zzvs = zzdsi;
    }

    public static boolean zza(zzgn zzgn) {
        switch (zzdto.zzhrc[zzgn.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r4 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        r4.zza(2024, 0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r4 == null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzaxn() {
        /*
            r5 = this;
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.String r1 = "i686"
            java.lang.String r2 = "armv71"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            com.google.android.gms.internal.ads.zzdwd r1 = com.google.android.gms.internal.ads.zzdwd.OS_ARCH
            java.lang.String r1 = r1.value()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0024
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0024
            return r1
        L_0x0024:
            r0 = 0
            r2 = 2024(0x7e8, float:2.836E-42)
            java.lang.Class<android.os.Build> r3 = android.os.Build.class
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r3 = r3.getField(r4)     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            if (r3 == 0) goto L_0x004f
            int r4 = r3.length     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            if (r4 <= 0) goto L_0x004f
            r4 = 0
            r0 = r3[r4]     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            return r0
        L_0x0040:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzdsi r4 = r5.zzvs
            if (r4 == 0) goto L_0x004f
        L_0x0045:
            r4.zza((int) r2, (long) r0, (java.lang.Exception) r3)
            goto L_0x004f
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzdsi r4 = r5.zzvs
            if (r4 == 0) goto L_0x004f
            goto L_0x0045
        L_0x004f:
            java.lang.String r0 = android.os.Build.CPU_ABI
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = android.os.Build.CPU_ABI
            return r0
        L_0x0056:
            java.lang.String r0 = android.os.Build.CPU_ABI2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtl.zzaxn():java.lang.String");
    }

    private final zzgn zzaxo() {
        FileInputStream fileInputStream;
        File file = new File(new File(this.context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzdsi zzdsi = this.zzvs;
            if (zzdsi != null) {
                zzdsi.zzg(5017, "No lib/");
            }
            return zzgn.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzdxl(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            zzdsi zzdsi2 = this.zzvs;
            if (zzdsi2 != null) {
                zzdsi2.zzg(5017, "No .so");
            }
            return zzgn.UNKNOWN;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            byte[] bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    zzc(bArr, (String) null);
                    zzgn zzgn = zzgn.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgn;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgn zzgn2 = zzgn.X86;
                    fileInputStream.close();
                    return zzgn2;
                } else if (s == 40) {
                    zzgn zzgn3 = zzgn.ARM7;
                    fileInputStream.close();
                    return zzgn3;
                } else if (s == 62) {
                    zzgn zzgn4 = zzgn.X86_64;
                    fileInputStream.close();
                    return zzgn4;
                } else if (s != 183) {
                    zzc(bArr, (String) null);
                    zzgn zzgn5 = zzgn.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgn5;
                } else {
                    zzgn zzgn6 = zzgn.ARM64;
                    fileInputStream.close();
                    return zzgn6;
                }
            } else {
                fileInputStream.close();
                return zzgn.UNSUPPORTED;
            }
        } catch (IOException e) {
            zzc((byte[]) null, e.toString());
        } catch (Throwable th) {
            zzeid.zza(th, th);
        }
        throw th;
    }

    private final void zzc(byte[] bArr, String str) {
        if (this.zzvs != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzdwd.OS_ARCH.value());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";");
            sb.append("CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            if (str != null) {
                sb.append("dbg:");
                sb.append(str);
                sb.append(";");
            }
            this.zzvs.zzg(4007, sb.toString());
        }
    }

    public final zzgn zzaxp() {
        zzgn zzaxo = zzaxo();
        if (zzaxo == zzgn.UNKNOWN) {
            String zzaxn = zzaxn();
            if (TextUtils.isEmpty(zzaxn)) {
                zzaxn = "Empty dev arch";
            } else if (zzaxn.equalsIgnoreCase("i686") || zzaxn.equalsIgnoreCase("x86")) {
                zzaxo = zzgn.X86;
            } else if (zzaxn.equalsIgnoreCase("x86_64")) {
                zzaxo = zzgn.X86_64;
            } else if (zzaxn.equalsIgnoreCase("arm64-v8a")) {
                zzaxo = zzgn.ARM64;
            } else if (zzaxn.equalsIgnoreCase("armeabi-v7a") || zzaxn.equalsIgnoreCase("armv71")) {
                zzaxo = zzgn.ARM7;
            }
            zzc((byte[]) null, zzaxn);
            zzaxo = zzgn.UNSUPPORTED;
        }
        zzdsi zzdsi = this.zzvs;
        if (zzdsi != null) {
            zzdsi.zzg(5018, zzaxo.name());
        }
        return zzaxo;
    }
}
