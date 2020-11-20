package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

public final class zzdrx {
    private final Context context;
    private final Clock zzbpw;
    private final String zzbrf;
    private final String zzciz;
    private final String zzdsu;
    private final zzef zzfpv;
    private final zzdni zzfxk;
    private final zzcum zzfze;

    public zzdrx(zzcum zzcum, zzazh zzazh, String str, String str2, Context context2, zzdni zzdni, Clock clock, zzef zzef) {
        this.zzfze = zzcum;
        this.zzbrf = zzazh.zzbrf;
        this.zzdsu = str;
        this.zzciz = str2;
        this.context = context2;
        this.zzfxk = zzdni;
        this.zzbpw = clock;
        this.zzfpv = zzef;
    }

    public static List<String> zza(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String zzc : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i2);
            arrayList.add(zzc(zzc, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    private static String zzc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzgv(String str) {
        return (TextUtils.isEmpty(str) || !zzayu.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzdmu zzdmu, List<String> list, zzauf zzauf) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        try {
            String type = zzauf.getType();
            String num = Integer.toString(zzauf.getAmount());
            zzdni zzdni = this.zzfxk;
            String zzgv = zzdni == null ? "" : zzgv(zzdni.zzdxy);
            zzdni zzdni2 = this.zzfxk;
            String zzgv2 = zzdni2 == null ? "" : zzgv(zzdni2.zzdxz);
            for (String zzc : list) {
                arrayList.add(zzaxm.zzc(zzc(zzc(zzc(zzc(zzc(zzc(zzc, "@gw_rwd_userid@", Uri.encode(zzgv)), "@gw_rwd_custom_data@", Uri.encode(zzgv2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbrf), this.context, zzdmu.zzdvo));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzd.zzc("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }

    public final List<String> zza(zzdnj zzdnj, zzdmu zzdmu, List<String> list) {
        return zza(zzdnj, zzdmu, false, "", "", list);
    }

    public final List<String> zza(zzdnj zzdnj, zzdmu zzdmu, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String zzc : list) {
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adlocid@", zzdnj.zzhij.zzfvl.zzhip), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbrf);
            if (zzdmu != null) {
                zzc2 = zzaxm.zzc(zzc(zzc(zzc(zzc2, "@gw_qdata@", zzdmu.zzdly), "@gw_adnetid@", zzdmu.f6898id), "@gw_allocid@", zzdmu.zzdkx), this.context, zzdmu.zzdvo);
            }
            String zzc3 = zzc(zzc(zzc(zzc2, "@gw_adnetstatus@", this.zzfze.zzarn()), "@gw_seqnum@", this.zzdsu), "@gw_sessid@", this.zzciz);
            boolean z2 = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzfpv.zzb(Uri.parse(zzc3))) {
                    Uri.Builder buildUpon = Uri.parse(zzc3).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc3 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc3);
        }
        return arrayList;
    }
}
