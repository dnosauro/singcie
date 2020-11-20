package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbcq implements zzahv<zzbbe> {
    private boolean zzenw;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzwq.zzqa();
            return zzayr.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzd.zzfa(sb.toString());
            return i;
        }
    }

    private static Integer zza(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41 + String.valueOf(str2).length());
            sb.append("Video gmsg invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzd.zzfa(sb.toString());
            return null;
        }
    }

    private static void zza(zzbar zzbar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbar.zzdl(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzd.zzfa(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzbar.zzdm(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbar.zzdn(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbar.zzdo(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbar.zzdp(Integer.parseInt(str5));
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        zzbbe zzbbe = (zzbbe) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzd.zzfa("Action missing from video GMSG.");
            return;
        }
        if (zzd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzd.zzeb(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzd.zzfa("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbbe.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzd.zzfa("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzd.zzfa("No MIME types specified for decoder properties inspection.");
                    zzbar.zza(zzbbe, "missingMimeTypes");
                    return;
                }
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split(",")) {
                    hashMap.put(str4, zzca.zzes(str4.trim()));
                }
                zzbar.zza(zzbbe, (Map<String, List<Map<String, Object>>>) hashMap);
                return;
            }
            zzbax zzaag = zzbbe.zzaag();
            if (zzaag == null) {
                zzd.zzfa("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = AppSettingsData.STATUS_NEW.equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzbbe.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                int min = Math.min(zza3, zzbbe.zzaaq() - zza);
                int min2 = Math.min(zza4, zzbbe.zzaap() - zza2);
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused2) {
                    i = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzaag.zzaac() != null) {
                    zzaag.zze(zza, zza2, min, min2);
                    return;
                }
                zzaag.zza(zza, zza2, min, min2, i, parseBoolean, new zzbbf((String) map.get("flags")));
                zzbar zzaac = zzaag.zzaac();
                if (zzaac != null) {
                    zza(zzaac, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzbep zzaah = zzbbe.zzaah();
            if (zzaah != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzd.zzfa("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzaah.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused3) {
                        String valueOf = String.valueOf(str5);
                        zzd.zzfa(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                } else if ("skip".equals(str)) {
                    zzaah.zzadt();
                    return;
                }
            }
            zzbar zzaac2 = zzaag.zzaac();
            if (zzaac2 == null) {
                zzbar.zzb(zzbbe);
            } else if ("click".equals(str)) {
                Context context2 = zzbbe.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzaac2.zze(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzd.zzfa("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzaac2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                } catch (NumberFormatException unused4) {
                    String valueOf2 = String.valueOf(str6);
                    zzd.zzfa(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if ("hide".equals(str)) {
                zzaac2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzaac2.zzhy();
            } else if ("loadControl".equals(str)) {
                zza(zzaac2, (Map<String, String>) map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzaac2.zzzw();
                } else {
                    zzaac2.zzzx();
                }
            } else if ("pause".equals(str)) {
                zzaac2.pause();
            } else if ("play".equals(str)) {
                zzaac2.play();
            } else if ("show".equals(str)) {
                zzaac2.setVisibility(0);
            } else if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                Integer zza7 = zza((Map<String, String>) map, "periodicReportIntervalMs");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused5) {
                        String valueOf3 = String.valueOf(str8);
                        zzd.zzfa(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                if (zza7 != null) {
                    zzbbe.zzdq(zza7.intValue());
                }
                zzaac2.zzc(str7, strArr);
            } else if ("touchMove".equals(str)) {
                Context context3 = zzbbe.getContext();
                zzaac2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                if (!this.zzenw) {
                    zzbbe.zzvk();
                    this.zzenw = true;
                }
            } else if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzd.zzfa("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzaac2.setVolume(Float.parseFloat(str9));
                } catch (NumberFormatException unused6) {
                    String valueOf4 = String.valueOf(str9);
                    zzd.zzfa(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzaac2.zzzy();
            } else {
                String valueOf5 = String.valueOf(str);
                zzd.zzfa(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
            }
        }
    }
}
