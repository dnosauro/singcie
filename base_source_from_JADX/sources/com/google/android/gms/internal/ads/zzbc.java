package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class zzbc {
    public static zzn zzb(zzy zzy) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        zzy zzy2 = zzy;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzy2.zzal;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long zzg = str != null ? zzg(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j2 = 0;
            int i2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j2 = 0;
            j = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long zzg2 = str3 != null ? zzg(str3) : 0;
        String str4 = map.get("Last-Modified");
        long zzg3 = str4 != null ? zzg(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i == 0) {
                Long.signum(j);
                j3 = (j * 1000) + j4;
                zzn zzn = new zzn();
                zzn.data = zzy2.data;
                zzn.zzr = str5;
                zzn.zzv = j4;
                zzn.zzu = j3;
                zzn.zzs = zzg;
                zzn.zzt = zzg3;
                zzn.zzw = map;
                zzn.zzx = zzy2.allHeaders;
                return zzn;
            }
        } else if (zzg <= 0 || zzg2 < zzg) {
            j4 = 0;
        } else {
            j3 = (zzg2 - zzg) + currentTimeMillis;
            j4 = j3;
            zzn zzn2 = new zzn();
            zzn2.data = zzy2.data;
            zzn2.zzr = str5;
            zzn2.zzv = j4;
            zzn2.zzu = j3;
            zzn2.zzs = zzg;
            zzn2.zzt = zzg3;
            zzn2.zzw = map;
            zzn2.zzx = zzy2.allHeaders;
            return zzn2;
        }
        j3 = j4;
        zzn zzn22 = new zzn();
        zzn22.data = zzy2.data;
        zzn22.zzr = str5;
        zzn22.zzv = j4;
        zzn22.zzu = j3;
        zzn22.zzs = zzg;
        zzn22.zzt = zzg3;
        zzn22.zzw = map;
        zzn22.zzx = zzy2.allHeaders;
        return zzn22;
    }

    static String zzb(long j) {
        return zzh("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static long zzg(String str) {
        try {
            return zzh("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaq.m8704v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzaq.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    private static SimpleDateFormat zzh(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
