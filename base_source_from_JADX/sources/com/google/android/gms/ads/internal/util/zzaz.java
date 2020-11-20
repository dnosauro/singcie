package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzao;
import org.apache.commons.p172io.IOUtils;

final class zzaz implements zzai {
    private final /* synthetic */ String zzees;
    private final /* synthetic */ zzbe zzeet;

    zzaz(zzax zzax, String str, zzbe zzbe) {
        this.zzees = str;
        this.zzeet = zzbe;
    }

    public final void zzc(zzao zzao) {
        String str = this.zzees;
        String zzao2 = zzao.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzao2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(zzao2);
        zzd.zzfa(sb.toString());
        this.zzeet.zzb(null);
    }
}
