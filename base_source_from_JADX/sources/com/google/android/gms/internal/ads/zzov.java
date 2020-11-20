package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzov extends IOException {
    private final int type;
    private final zzoo zzbim;

    public zzov(IOException iOException, zzoo zzoo, int i) {
        super(iOException);
        this.zzbim = zzoo;
        this.type = i;
    }

    public zzov(String str, zzoo zzoo, int i) {
        super(str);
        this.zzbim = zzoo;
        this.type = 1;
    }

    public zzov(String str, IOException iOException, zzoo zzoo, int i) {
        super(str, iOException);
        this.zzbim = zzoo;
        this.type = 1;
    }
}
