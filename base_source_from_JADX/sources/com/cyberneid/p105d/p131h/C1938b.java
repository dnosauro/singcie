package com.cyberneid.p105d.p131h;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* renamed from: com.cyberneid.d.h.b */
public final class C1938b {

    /* renamed from: a */
    private static final String[] f6136a = {"EEEE, dd MMM yy hh:mm:ss a", "EEEE, MMM dd, yy hh:mm:ss a", "EEEE, MMM dd, yy 'at' hh:mma", "EEEE, MMM dd, yy", "EEEE MMM dd, yy HH:mm:ss", "EEEE MMM dd HH:mm:ss z yy", "EEEE MMM dd HH:mm:ss yy"};

    /* renamed from: b */
    private static final String[] f6137b = {"dd MMM yy HH:mm:ss", "dd MMM yy HH:mm", "yyyy MMM d", "yyyymmddhh:mm:ss", "H:m M/d/yy", "M/d/yy HH:mm:ss", "M/d/yy HH:mm", "M/d/yy"};

    /* renamed from: a */
    private static int m7978a(long j) {
        return (int) ((((((j + 43200000) % 86400000) + 86400000) % 86400000) - 43200000) % 43200000);
    }

    /* renamed from: a */
    static String m7979a(long j, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Z");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(m7978a(j), "unknown"));
        String format = simpleDateFormat.format(new Date());
        return format.substring(0, 3) + str + format.substring(3);
    }

    /* renamed from: a */
    public static String m7980a(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        String a = m7979a((long) (calendar.get(15) + calendar.get(16)), "'");
        return String.format(Locale.US, "D:%1$4tY%1$2tm%1$2td%1$2tH%1$2tM%1$2tS%2$s'", new Object[]{calendar, a});
    }
}
