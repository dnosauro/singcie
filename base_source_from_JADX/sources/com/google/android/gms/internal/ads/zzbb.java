package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzbb {
    private final int zzco;
    private final List<zzu> zzcp;
    private final int zzcq;
    private final InputStream zzcr;

    public zzbb(int i, List<zzu> list) {
        this(i, list, -1, (InputStream) null);
    }

    public zzbb(int i, List<zzu> list, int i2, InputStream inputStream) {
        this.zzco = i;
        this.zzcp = list;
        this.zzcq = i2;
        this.zzcr = inputStream;
    }

    public final InputStream getContent() {
        return this.zzcr;
    }

    public final int getContentLength() {
        return this.zzcq;
    }

    public final int getStatusCode() {
        return this.zzco;
    }

    public final List<zzu> zzq() {
        return Collections.unmodifiableList(this.zzcp);
    }
}
