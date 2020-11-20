package com.github.appintro.internal;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;
import p157d.p165f.C3268b;

public final class LogHelper {
    public static final LogHelper INSTANCE = new LogHelper();

    private LogHelper() {
    }

    private final String cutTagLength(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        int i2 = i - 1;
        if (str != null) {
            String substring = str.substring(0, i2);
            C3250h.m9053a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new C3266f("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: d */
    public static final int m8403d(@NotNull String str, @NotNull String str2) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        return Log.d(str, str2);
    }

    /* renamed from: e */
    public static final void m8404e(@NotNull String str, @NotNull String str2) {
        e$default(str, str2, (Throwable) null, 4, (Object) null);
    }

    /* renamed from: e */
    public static final void m8405e(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        Log.e(str, str2, th);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m8405e(str, str2, th);
    }

    /* renamed from: i */
    public static final int m8406i(@NotNull String str, @NotNull String str2) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        return Log.i(str, str2);
    }

    @NotNull
    public static final String makeLogTag(@NotNull Class<?> cls) {
        C3250h.m9056b(cls, "cls");
        StringBuilder sb = new StringBuilder();
        sb.append("Log: ");
        LogHelper logHelper = INSTANCE;
        String simpleName = cls.getSimpleName();
        C3250h.m9053a((Object) simpleName, "cls.simpleName");
        sb.append(logHelper.cutTagLength(simpleName, 18));
        return sb.toString();
    }

    /* renamed from: v */
    public static final int m8407v(@NotNull String str, @NotNull String str2) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        return Log.v(str, str2);
    }

    /* renamed from: w */
    public static final void m8408w(@NotNull String str, @NotNull String str2) {
        w$default(str, str2, (Throwable) null, 4, (Object) null);
    }

    /* renamed from: w */
    public static final void m8409w(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        Log.w(str, str2, th);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m8409w(str, str2, th);
    }

    public static final void wtf(@NotNull String str, @NotNull String str2) {
        wtf$default(str, str2, (Throwable) null, 4, (Object) null);
    }

    public static final void wtf(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        C3250h.m9056b(str, "tag");
        C3250h.m9056b(str2, "message");
        Log.wtf(str, str2, th);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    @NotNull
    public final String makeLogTag(@NotNull C3268b<?> bVar) {
        C3250h.m9056b(bVar, "cls");
        StringBuilder sb = new StringBuilder();
        sb.append("Log: ");
        String b = bVar.mo25693b();
        if (b == null) {
            b = "";
        }
        sb.append(cutTagLength(b, 18));
        return sb.toString();
    }
}
