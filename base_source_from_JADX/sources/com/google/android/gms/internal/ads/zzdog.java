package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public final class zzdog {
    public static ParcelFileDescriptor zzf(InputStream inputStream) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzazj.zzegp.execute(new zzdof(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }
}
