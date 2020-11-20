package com.nambimobile.widgets.efab;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: com.nambimobile.widgets.efab.a */
public final class C2585a {
    @NotNull
    /* renamed from: a */
    public static final /* synthetic */ Void m8796a(@NotNull String str, @Nullable Throwable th) {
        C3250h.m9056b(str, "message");
        throw new IllegalStateException(str, th);
    }

    /* renamed from: a */
    public static /* synthetic */ Void m8797a(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return m8796a(str, th);
    }

    @NotNull
    /* renamed from: b */
    public static final /* synthetic */ Void m8798b(@NotNull String str, @Nullable Throwable th) {
        C3250h.m9056b(str, "message");
        throw new IllegalArgumentException(str, th);
    }

    /* renamed from: b */
    public static /* synthetic */ Void m8799b(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return m8798b(str, th);
    }
}
