package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class zan implements Parcelable.Creator<ResolveAccountResponse> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x003e
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0039;
                case 2: goto L_0x0034;
                case 3: goto L_0x002a;
                case 4: goto L_0x0025;
                case 5: goto L_0x0020;
                default: goto L_0x001c;
            }
        L_0x001c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000b
        L_0x0020:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r10, r1)
            goto L_0x000b
        L_0x0025:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r10, r1)
            goto L_0x000b
        L_0x002a:
            android.os.Parcelable$Creator<com.google.android.gms.common.ConnectionResult> r2 = com.google.android.gms.common.ConnectionResult.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r6 = r1
            com.google.android.gms.common.ConnectionResult r6 = (com.google.android.gms.common.ConnectionResult) r6
            goto L_0x000b
        L_0x0034:
            android.os.IBinder r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r10, r1)
            goto L_0x000b
        L_0x0039:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x000b
        L_0x003e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.common.internal.ResolveAccountResponse r10 = new com.google.android.gms.common.internal.ResolveAccountResponse
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zan.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
