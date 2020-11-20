package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfk {
    private final String zza;
    private final Bundle zzb = new Bundle();
    private boolean zzc;
    private Bundle zzd;
    private final /* synthetic */ zzfj zze;

    public zzfk(zzfj zzfj, String str, Bundle bundle) {
        this.zze = zzfj;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    private final String zzb(Bundle bundle) {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str3);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        str = "t";
                        str2 = "s";
                    } else if (obj instanceof Long) {
                        str = "t";
                        str2 = "l";
                    } else if (obj instanceof Double) {
                        str = "t";
                        str2 = "d";
                    } else {
                        this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONObject.put(str, str2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:31|32|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r11.zze.zzq().zze().zza("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r11 = this;
            boolean r0 = r11.zzc
            if (r0 != 0) goto L_0x00ce
            r0 = 1
            r11.zzc = r0
            com.google.android.gms.measurement.internal.zzfj r1 = r11.zze
            android.content.SharedPreferences r1 = r1.zzf()
            java.lang.String r2 = r11.zza
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto L_0x00c6
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x00b7 }
            r2.<init>()     // Catch:{ JSONException -> 0x00b7 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00b7 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00b7 }
            r1 = 0
            r4 = 0
        L_0x0022:
            int r5 = r3.length()     // Catch:{ JSONException -> 0x00b7 }
            if (r4 >= r5) goto L_0x00b4
            org.json.JSONObject r5 = r3.getJSONObject(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            java.lang.String r6 = "n"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            java.lang.String r7 = "t"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            r8 = -1
            int r9 = r7.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            r10 = 100
            if (r9 == r10) goto L_0x005e
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0054
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x004a
            goto L_0x0067
        L_0x004a:
            java.lang.String r9 = "s"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            if (r9 == 0) goto L_0x0067
            r8 = 0
            goto L_0x0067
        L_0x0054:
            java.lang.String r9 = "l"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            if (r9 == 0) goto L_0x0067
            r8 = 2
            goto L_0x0067
        L_0x005e:
            java.lang.String r9 = "d"
            boolean r9 = r7.equals(r9)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            if (r9 == 0) goto L_0x0067
            r8 = 1
        L_0x0067:
            switch(r8) {
                case 0: goto L_0x0089;
                case 1: goto L_0x007b;
                case 2: goto L_0x006d;
                default: goto L_0x006a;
            }     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
        L_0x006a:
            com.google.android.gms.measurement.internal.zzfj r5 = r11.zze     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            goto L_0x0093
        L_0x006d:
            java.lang.String r7 = "v"
            java.lang.String r5 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            long r7 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            r2.putLong(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            goto L_0x00b0
        L_0x007b:
            java.lang.String r7 = "v"
            java.lang.String r5 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            double r7 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            r2.putDouble(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            goto L_0x00b0
        L_0x0089:
            java.lang.String r7 = "v"
            java.lang.String r5 = r5.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            r2.putString(r6, r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            goto L_0x00b0
        L_0x0093:
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zze()     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            java.lang.String r6 = "Unrecognized persisted bundle type. Type"
            r5.zza(r6, r7)     // Catch:{ NumberFormatException | JSONException -> 0x00a1 }
            goto L_0x00b0
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfj r5 = r11.zze     // Catch:{ JSONException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzq()     // Catch:{ JSONException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zze()     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r6 = "Error reading value from SharedPreferences. Value dropped"
            r5.zza(r6)     // Catch:{ JSONException -> 0x00b7 }
        L_0x00b0:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x00b4:
            r11.zzd = r2     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00c6
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzfj r0 = r11.zze
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        L_0x00c6:
            android.os.Bundle r0 = r11.zzd
            if (r0 != 0) goto L_0x00ce
            android.os.Bundle r0 = r11.zzb
            r11.zzd = r0
        L_0x00ce:
            android.os.Bundle r0 = r11.zzd
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfk.zza():android.os.Bundle");
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle));
        }
        edit.apply();
        this.zzd = bundle;
    }
}
