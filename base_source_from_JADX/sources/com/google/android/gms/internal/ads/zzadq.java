package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.parse.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

public final class zzadq extends zzaea {
    private static final int zzdea = Color.rgb(12, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, ParseException.SESSION_MISSING);
    private static final int zzdeb;
    private static final int zzdec;
    private static final int zzded = zzdea;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzdee;
    private final List<zzadv> zzdef = new ArrayList();
    private final List<zzaej> zzdeg = new ArrayList();
    private final int zzdeh;
    private final int zzdei;
    private final boolean zzdej;

    static {
        int rgb = Color.rgb(ParseException.EMAIL_MISSING, ParseException.EMAIL_MISSING, ParseException.EMAIL_MISSING);
        zzdeb = rgb;
        zzdec = rgb;
    }

    public zzadq(String str, List<zzadv> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzdee = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadv zzadv = list.get(i3);
                this.zzdef.add(zzadv);
                this.zzdeg.add(zzadv);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzdec;
        this.textColor = num2 != null ? num2.intValue() : zzded;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzdeh = i;
        this.zzdei = i2;
        this.zzdej = z;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getText() {
        return this.zzdee;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final List<zzaej> zzsm() {
        return this.zzdeg;
    }

    public final List<zzadv> zzsn() {
        return this.zzdef;
    }

    public final int zzso() {
        return this.zzdeh;
    }

    public final int zzsp() {
        return this.zzdei;
    }
}
