package com.google.android.gms.internal.ads;

public abstract class zzxc extends zzgw implements zzwz {
    public zzxc() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzwt] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzxu] */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00c9;
                case 2: goto L_0x00ab;
                case 3: goto L_0x009c;
                case 4: goto L_0x0090;
                case 5: goto L_0x0078;
                case 6: goto L_0x006c;
                case 7: goto L_0x004e;
                case 8: goto L_0x003a;
                case 9: goto L_0x002d;
                case 10: goto L_0x0020;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x0013;
                case 14: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzajt r1 = com.google.android.gms.internal.ads.zzajs.zzab(r1)
            r0.zza((com.google.android.gms.internal.ads.zzajt) r1)
            goto L_0x00a7
        L_0x0013:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzajl> r1 = com.google.android.gms.internal.ads.zzajl.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzajl r1 = (com.google.android.gms.internal.ads.zzajl) r1
            r0.zza((com.google.android.gms.internal.ads.zzajl) r1)
            goto L_0x00a7
        L_0x0020:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafy r1 = com.google.android.gms.internal.ads.zzagb.zzx(r1)
            r0.zza((com.google.android.gms.internal.ads.zzafy) r1)
            goto L_0x00a7
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r1 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r1 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r1
            r0.zza((com.google.android.gms.ads.formats.PublisherAdViewOptions) r1)
            goto L_0x00a7
        L_0x003a:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafx r1 = com.google.android.gms.internal.ads.zzafw.zzw(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r4 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r4)
            com.google.android.gms.internal.ads.zzvn r2 = (com.google.android.gms.internal.ads.zzvn) r2
            r0.zza(r1, r2)
            goto L_0x00a7
        L_0x004e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0055
            goto L_0x0068
        L_0x0055:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzxu
            if (r4 == 0) goto L_0x0063
            r4 = r2
            com.google.android.gms.internal.ads.zzxu r4 = (com.google.android.gms.internal.ads.zzxu) r4
            goto L_0x0068
        L_0x0063:
            com.google.android.gms.internal.ads.zzxt r4 = new com.google.android.gms.internal.ads.zzxt
            r4.<init>(r1)
        L_0x0068:
            r0.zzb((com.google.android.gms.internal.ads.zzxu) r4)
            goto L_0x00a7
        L_0x006c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzadz> r1 = com.google.android.gms.internal.ads.zzadz.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzadz r1 = (com.google.android.gms.internal.ads.zzadz) r1
            r0.zza((com.google.android.gms.internal.ads.zzadz) r1)
            goto L_0x00a7
        L_0x0078:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafq r4 = com.google.android.gms.internal.ads.zzaft.zzv(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafp r2 = com.google.android.gms.internal.ads.zzafo.zzu(r2)
            r0.zza(r1, r4, r2)
            goto L_0x00a7
        L_0x0090:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafk r1 = com.google.android.gms.internal.ads.zzafn.zzt(r1)
            r0.zza((com.google.android.gms.internal.ads.zzafk) r1)
            goto L_0x00a7
        L_0x009c:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafj r1 = com.google.android.gms.internal.ads.zzafi.zzs(r1)
            r0.zza((com.google.android.gms.internal.ads.zzafj) r1)
        L_0x00a7:
            r3.writeNoException()
            goto L_0x00d3
        L_0x00ab:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00b2
            goto L_0x00c5
        L_0x00b2:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzwt
            if (r4 == 0) goto L_0x00c0
            r4 = r2
            com.google.android.gms.internal.ads.zzwt r4 = (com.google.android.gms.internal.ads.zzwt) r4
            goto L_0x00c5
        L_0x00c0:
            com.google.android.gms.internal.ads.zzwv r4 = new com.google.android.gms.internal.ads.zzwv
            r4.<init>(r1)
        L_0x00c5:
            r0.zzb((com.google.android.gms.internal.ads.zzwt) r4)
            goto L_0x00a7
        L_0x00c9:
            com.google.android.gms.internal.ads.zzwy r1 = r0.zzqj()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
        L_0x00d3:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxc.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
