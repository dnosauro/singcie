package com.parse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

class ParseImpreciseDateFormat {
    private static final ParseImpreciseDateFormat INSTANCE = new ParseImpreciseDateFormat();
    private static final String TAG = "ParseDateFormat";
    private final DateFormat dateFormat;
    private final Object lock = new Object();

    private ParseImpreciseDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.dateFormat = simpleDateFormat;
    }

    public static ParseImpreciseDateFormat getInstance() {
        return INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public String format(Date date) {
        String format;
        synchronized (this.lock) {
            format = this.dateFormat.format(date);
        }
        return format;
    }

    /* access modifiers changed from: package-private */
    public Date parse(String str) {
        Date parse;
        synchronized (this.lock) {
            try {
                parse = this.dateFormat.parse(str);
            } catch (ParseException e) {
                PLog.m8817e(TAG, "could not parse date: " + str, e);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return parse;
    }
}
