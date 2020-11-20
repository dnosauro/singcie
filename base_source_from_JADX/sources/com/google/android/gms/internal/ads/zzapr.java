package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzapr extends zzgw implements zzapo {
    public zzapr() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzapo zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof zzapo ? (zzapo) queryLocalInterface : new zzapq(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.internal.ads.zzapt] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.internal.ads.zzape] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.ads.zzapc] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzapc] */
    /* JADX WARNING: type inference failed for: r1v18, types: [com.google.android.gms.internal.ads.zzapj] */
    /* JADX WARNING: type inference failed for: r1v19, types: [com.google.android.gms.internal.ads.zzaph] */
    /* JADX WARNING: type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzaph] */
    /* JADX WARNING: type inference failed for: r1v24, types: [com.google.android.gms.internal.ads.zzapp] */
    /* JADX WARNING: type inference failed for: r1v25, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.google.android.gms.internal.ads.zzapk] */
    /* JADX WARNING: type inference failed for: r1v31, types: [com.google.android.gms.internal.ads.zzapi] */
    /* JADX WARNING: type inference failed for: r5v15, types: [com.google.android.gms.internal.ads.zzapi] */
    /* JADX WARNING: type inference failed for: r1v36, types: [com.google.android.gms.internal.ads.zzapp] */
    /* JADX WARNING: type inference failed for: r1v37, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r5v18, types: [com.google.android.gms.internal.ads.zzapn] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fd, code lost:
        r12.writeNoException();
        com.google.android.gms.internal.ads.zzgv.writeBoolean(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01b7, code lost:
        r12.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01d0, code lost:
        r12.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zzb(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) {
        /*
            r9 = this;
            r1 = 0
            switch(r10) {
                case 1: goto L_0x01d7;
                case 2: goto L_0x01cc;
                case 3: goto L_0x01c7;
                case 4: goto L_0x0004;
                case 5: goto L_0x01bc;
                case 6: goto L_0x0004;
                case 7: goto L_0x0004;
                case 8: goto L_0x0004;
                case 9: goto L_0x0004;
                case 10: goto L_0x01ac;
                case 11: goto L_0x019c;
                case 12: goto L_0x0004;
                case 13: goto L_0x014c;
                case 14: goto L_0x0105;
                case 15: goto L_0x00f1;
                case 16: goto L_0x00aa;
                case 17: goto L_0x009d;
                case 18: goto L_0x0056;
                case 19: goto L_0x004d;
                case 20: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r0 = 0
            return r0
        L_0x0006:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r4 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzvk r4 = (com.google.android.gms.internal.ads.zzvk) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x0026
        L_0x0024:
            r6 = r1
            goto L_0x0039
        L_0x0026:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzapn
            if (r7 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzapn r1 = (com.google.android.gms.internal.ads.zzapn) r1
            goto L_0x0024
        L_0x0033:
            com.google.android.gms.internal.ads.zzapp r1 = new com.google.android.gms.internal.ads.zzapp
            r1.<init>(r6)
            goto L_0x0024
        L_0x0039:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r7 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zzb(r1, r2, r3, r4, r5, r6)
            goto L_0x01b7
        L_0x004d:
            java.lang.String r0 = r11.readString()
            r9.zzdn(r0)
            goto L_0x01b7
        L_0x0056:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r4 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzvk r4 = (com.google.android.gms.internal.ads.zzvk) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x0076
        L_0x0074:
            r6 = r1
            goto L_0x0089
        L_0x0076:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzapi
            if (r7 == 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzapi r1 = (com.google.android.gms.internal.ads.zzapi) r1
            goto L_0x0074
        L_0x0083:
            com.google.android.gms.internal.ads.zzapk r1 = new com.google.android.gms.internal.ads.zzapk
            r1.<init>(r6)
            goto L_0x0074
        L_0x0089:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r7 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzapi) r5, (com.google.android.gms.internal.ads.zzano) r6)
            goto L_0x01b7
        L_0x009d:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r9.zzaa(r0)
            goto L_0x00fd
        L_0x00aa:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r4 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzvk r4 = (com.google.android.gms.internal.ads.zzvk) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x00ca
        L_0x00c8:
            r6 = r1
            goto L_0x00dd
        L_0x00ca:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzapn
            if (r7 == 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzapn r1 = (com.google.android.gms.internal.ads.zzapn) r1
            goto L_0x00c8
        L_0x00d7:
            com.google.android.gms.internal.ads.zzapp r1 = new com.google.android.gms.internal.ads.zzapp
            r1.<init>(r6)
            goto L_0x00c8
        L_0x00dd:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r7 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzapn) r5, (com.google.android.gms.internal.ads.zzano) r6)
            goto L_0x01b7
        L_0x00f1:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r9.zzz(r0)
        L_0x00fd:
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r12, r0)
            goto L_0x0221
        L_0x0105:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r4 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzvk r4 = (com.google.android.gms.internal.ads.zzvk) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x0125
        L_0x0123:
            r6 = r1
            goto L_0x0138
        L_0x0125:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzaph
            if (r7 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzaph r1 = (com.google.android.gms.internal.ads.zzaph) r1
            goto L_0x0123
        L_0x0132:
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            r1.<init>(r6)
            goto L_0x0123
        L_0x0138:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r7 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzaph) r5, (com.google.android.gms.internal.ads.zzano) r6)
            goto L_0x01b7
        L_0x014c:
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r4 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            com.google.android.gms.internal.ads.zzvk r4 = (com.google.android.gms.internal.ads.zzvk) r4
            android.os.IBinder r5 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r6 = r11.readStrongBinder()
            if (r6 != 0) goto L_0x016c
        L_0x016a:
            r6 = r1
            goto L_0x017f
        L_0x016c:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzapc
            if (r7 == 0) goto L_0x0179
            com.google.android.gms.internal.ads.zzapc r1 = (com.google.android.gms.internal.ads.zzapc) r1
            goto L_0x016a
        L_0x0179:
            com.google.android.gms.internal.ads.zzape r1 = new com.google.android.gms.internal.ads.zzape
            r1.<init>(r6)
            goto L_0x016a
        L_0x017f:
            android.os.IBinder r1 = r11.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r7 = com.google.android.gms.internal.ads.zzanr.zzad(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r1 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r1)
            r8 = r0
            com.google.android.gms.internal.ads.zzvn r8 = (com.google.android.gms.internal.ads.zzvn) r8
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x01b7
        L_0x019c:
            java.lang.String[] r1 = r11.createStringArray()
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            java.lang.Object[] r0 = r11.createTypedArray(r2)
            android.os.Bundle[] r0 = (android.os.Bundle[]) r0
            r9.zza(r1, r0)
            goto L_0x01b7
        L_0x01ac:
            android.os.IBinder r0 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r9.zzy(r0)
        L_0x01b7:
            r12.writeNoException()
            goto L_0x0221
        L_0x01bc:
            com.google.android.gms.internal.ads.zzys r0 = r9.getVideoController()
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r12, (android.os.IInterface) r0)
            goto L_0x0221
        L_0x01c7:
            com.google.android.gms.internal.ads.zzaqc r0 = r9.zzum()
            goto L_0x01d0
        L_0x01cc:
            com.google.android.gms.internal.ads.zzaqc r0 = r9.zzul()
        L_0x01d0:
            r12.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r12, r0)
            goto L_0x0221
        L_0x01d7:
            android.os.IBinder r2 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            java.lang.String r3 = r11.readString()
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r4)
            android.os.Bundle r4 = (android.os.Bundle) r4
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r6 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r6 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, r6)
            com.google.android.gms.internal.ads.zzvn r6 = (com.google.android.gms.internal.ads.zzvn) r6
            android.os.IBinder r0 = r11.readStrongBinder()
            if (r0 != 0) goto L_0x0203
        L_0x0201:
            r7 = r1
            goto L_0x0216
        L_0x0203:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r7 = r1 instanceof com.google.android.gms.internal.ads.zzapt
            if (r7 == 0) goto L_0x0210
            com.google.android.gms.internal.ads.zzapt r1 = (com.google.android.gms.internal.ads.zzapt) r1
            goto L_0x0201
        L_0x0210:
            com.google.android.gms.internal.ads.zzapv r1 = new com.google.android.gms.internal.ads.zzapv
            r1.<init>(r0)
            goto L_0x0201
        L_0x0216:
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (java.lang.String) r2, (android.os.Bundle) r3, (android.os.Bundle) r4, (com.google.android.gms.internal.ads.zzvn) r5, (com.google.android.gms.internal.ads.zzapt) r6)
            goto L_0x01b7
        L_0x0221:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
