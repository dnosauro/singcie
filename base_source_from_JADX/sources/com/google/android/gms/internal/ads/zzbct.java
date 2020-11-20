package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

public final class zzbct implements zzahv<zzbbe> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbe zzbbe = (zzbbe) obj;
        zzbep zzaah = zzbbe.zzaah();
        if (zzaah == null) {
            try {
                zzbep zzbep = new zzbep(zzbbe, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbbe.zza(zzbep);
                zzaah = zzbep;
            } catch (NullPointerException | NumberFormatException e) {
                zzd.zzc("Unable to parse videoMeta message.", e);
                zzp.zzku().zza(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || 3 < parseInt) {
            parseInt = 0;
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzd.isLoggable(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(parseFloat2);
            sb.append(" , duration : ");
            sb.append(parseFloat);
            sb.append(" , isMuted : ");
            sb.append(equals);
            sb.append(" , playbackState : ");
            sb.append(parseInt);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzd.zzeb(sb.toString());
        }
        zzaah.zza(parseFloat2, parseFloat, parseInt, equals, parseFloat3);
    }
}
