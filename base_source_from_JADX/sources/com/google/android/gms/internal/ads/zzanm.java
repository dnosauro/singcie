package com.google.android.gms.internal.ads;

public abstract class zzanm extends zzgw implements zzann {
    public zzanm() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* JADX WARNING: type inference failed for: r10v5, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r10v7, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0108, code lost:
        r11.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zzb(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0167, code lost:
        r11.writeNoException();
        com.google.android.gms.internal.ads.zzgv.writeBoolean(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x023a, code lost:
        r11.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0274, code lost:
        r11.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zza(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
            r8 = this;
            r12 = 0
            switch(r9) {
                case 1: goto L_0x027b;
                case 2: goto L_0x0270;
                case 3: goto L_0x023f;
                case 4: goto L_0x0237;
                case 5: goto L_0x0233;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01b6;
                case 8: goto L_0x01b1;
                case 9: goto L_0x01ac;
                case 10: goto L_0x0185;
                case 11: goto L_0x0174;
                case 12: goto L_0x016f;
                case 13: goto L_0x0163;
                case 14: goto L_0x011c;
                case 15: goto L_0x0116;
                case 16: goto L_0x0110;
                case 17: goto L_0x0104;
                case 18: goto L_0x00ff;
                case 19: goto L_0x00fa;
                case 20: goto L_0x00e5;
                case 21: goto L_0x00d8;
                case 22: goto L_0x00d2;
                case 23: goto L_0x00b9;
                case 24: goto L_0x00b3;
                case 25: goto L_0x00aa;
                case 26: goto L_0x00a4;
                case 27: goto L_0x009e;
                case 28: goto L_0x006c;
                case 29: goto L_0x0004;
                case 30: goto L_0x005f;
                case 31: goto L_0x0044;
                case 32: goto L_0x0012;
                case 33: goto L_0x000c;
                case 34: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r9 = 0
            return r9
        L_0x0006:
            com.google.android.gms.internal.ads.zzaqc r9 = r8.zzum()
            goto L_0x0108
        L_0x000c:
            com.google.android.gms.internal.ads.zzaqc r9 = r8.zzul()
            goto L_0x0108
        L_0x0012:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r0)
            com.google.android.gms.internal.ads.zzvk r0 = (com.google.android.gms.internal.ads.zzvk) r0
            java.lang.String r1 = r10.readString()
            android.os.IBinder r10 = r10.readStrongBinder()
            if (r10 != 0) goto L_0x002d
            goto L_0x003f
        L_0x002d:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r10.queryLocalInterface(r12)
            boolean r2 = r12 instanceof com.google.android.gms.internal.ads.zzano
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x003f
        L_0x003a:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r10)
        L_0x003f:
            r8.zzc(r9, r0, r1, r12)
            goto L_0x023a
        L_0x0044:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.IBinder r12 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzajb r12 = com.google.android.gms.internal.ads.zzaja.zzz(r12)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzajj> r0 = com.google.android.gms.internal.ads.zzajj.CREATOR
            java.util.ArrayList r10 = r10.createTypedArrayList(r0)
            r8.zza((com.google.android.gms.dynamic.IObjectWrapper) r9, (com.google.android.gms.internal.ads.zzajb) r12, (java.util.List<com.google.android.gms.internal.ads.zzajj>) r10)
            goto L_0x023a
        L_0x005f:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            r8.zzt(r9)
            goto L_0x023a
        L_0x006c:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r0)
            com.google.android.gms.internal.ads.zzvk r0 = (com.google.android.gms.internal.ads.zzvk) r0
            java.lang.String r1 = r10.readString()
            android.os.IBinder r10 = r10.readStrongBinder()
            if (r10 != 0) goto L_0x0087
            goto L_0x0099
        L_0x0087:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r10.queryLocalInterface(r12)
            boolean r2 = r12 instanceof com.google.android.gms.internal.ads.zzano
            if (r2 == 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x0099
        L_0x0094:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r10)
        L_0x0099:
            r8.zzb(r9, r0, r1, r12)
            goto L_0x023a
        L_0x009e:
            com.google.android.gms.internal.ads.zzaob r9 = r8.zzuk()
            goto L_0x0274
        L_0x00a4:
            com.google.android.gms.internal.ads.zzys r9 = r8.getVideoController()
            goto L_0x0274
        L_0x00aa:
            boolean r9 = com.google.android.gms.internal.ads.zzgv.zza(r10)
            r8.setImmersiveMode(r9)
            goto L_0x023a
        L_0x00b3:
            com.google.android.gms.internal.ads.zzaff r9 = r8.zzuj()
            goto L_0x0274
        L_0x00b9:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.IBinder r12 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzauw r12 = com.google.android.gms.internal.ads.zzauz.zzap(r12)
            java.util.ArrayList r10 = r10.createStringArrayList()
            r8.zza((com.google.android.gms.dynamic.IObjectWrapper) r9, (com.google.android.gms.internal.ads.zzauw) r12, (java.util.List<java.lang.String>) r10)
            goto L_0x023a
        L_0x00d2:
            boolean r9 = r8.zzui()
            goto L_0x0167
        L_0x00d8:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            r8.zzs(r9)
            goto L_0x023a
        L_0x00e5:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            com.google.android.gms.internal.ads.zzvk r9 = (com.google.android.gms.internal.ads.zzvk) r9
            java.lang.String r12 = r10.readString()
            java.lang.String r10 = r10.readString()
            r8.zza((com.google.android.gms.internal.ads.zzvk) r9, (java.lang.String) r12, (java.lang.String) r10)
            goto L_0x023a
        L_0x00fa:
            android.os.Bundle r9 = r8.zzuh()
            goto L_0x0108
        L_0x00ff:
            android.os.Bundle r9 = r8.getInterstitialAdapterInfo()
            goto L_0x0108
        L_0x0104:
            android.os.Bundle r9 = r8.zzug()
        L_0x0108:
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r11, r9)
            goto L_0x02ba
        L_0x0110:
            com.google.android.gms.internal.ads.zzanw r9 = r8.zzuf()
            goto L_0x0274
        L_0x0116:
            com.google.android.gms.internal.ads.zzanv r9 = r8.zzue()
            goto L_0x0274
        L_0x011c:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzvk r2 = (com.google.android.gms.internal.ads.zzvk) r2
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x013d
        L_0x013b:
            r5 = r12
            goto L_0x0150
        L_0x013d:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r9.queryLocalInterface(r12)
            boolean r0 = r12 instanceof com.google.android.gms.internal.ads.zzano
            if (r0 == 0) goto L_0x014a
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x013b
        L_0x014a:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r9)
            goto L_0x013b
        L_0x0150:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzadz> r9 = com.google.android.gms.internal.ads.zzadz.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r6 = r9
            com.google.android.gms.internal.ads.zzadz r6 = (com.google.android.gms.internal.ads.zzadz) r6
            java.util.ArrayList r7 = r10.createStringArrayList()
            r0 = r8
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x023a
        L_0x0163:
            boolean r9 = r8.isInitialized()
        L_0x0167:
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r11, r9)
            goto L_0x02ba
        L_0x016f:
            r8.showVideo()
            goto L_0x023a
        L_0x0174:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            com.google.android.gms.internal.ads.zzvk r9 = (com.google.android.gms.internal.ads.zzvk) r9
            java.lang.String r10 = r10.readString()
            r8.zza(r9, r10)
            goto L_0x023a
        L_0x0185:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzvk r2 = (com.google.android.gms.internal.ads.zzvk) r2
            java.lang.String r3 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.internal.ads.zzauw r4 = com.google.android.gms.internal.ads.zzauz.zzap(r9)
            java.lang.String r5 = r10.readString()
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzvk) r2, (java.lang.String) r3, (com.google.android.gms.internal.ads.zzauw) r4, (java.lang.String) r5)
            goto L_0x023a
        L_0x01ac:
            r8.resume()
            goto L_0x023a
        L_0x01b1:
            r8.pause()
            goto L_0x023a
        L_0x01b6:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzvk r2 = (com.google.android.gms.internal.ads.zzvk) r2
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x01d7
        L_0x01d5:
            r5 = r12
            goto L_0x01eb
        L_0x01d7:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzano
            if (r12 == 0) goto L_0x01e5
            r12 = r10
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x01d5
        L_0x01e5:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r9)
            goto L_0x01d5
        L_0x01eb:
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzvk) r2, (java.lang.String) r3, (java.lang.String) r4, (com.google.android.gms.internal.ads.zzano) r5)
            goto L_0x023a
        L_0x01f0:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r9 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzvn r2 = (com.google.android.gms.internal.ads.zzvn) r2
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r3 = r9
            com.google.android.gms.internal.ads.zzvk r3 = (com.google.android.gms.internal.ads.zzvk) r3
            java.lang.String r4 = r10.readString()
            java.lang.String r5 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x021a
        L_0x0218:
            r6 = r12
            goto L_0x022e
        L_0x021a:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzano
            if (r12 == 0) goto L_0x0228
            r12 = r10
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x0218
        L_0x0228:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r9)
            goto L_0x0218
        L_0x022e:
            r0 = r8
            r0.zza(r1, r2, r3, r4, r5, r6)
            goto L_0x023a
        L_0x0233:
            r8.destroy()
            goto L_0x023a
        L_0x0237:
            r8.showInterstitial()
        L_0x023a:
            r11.writeNoException()
            goto L_0x02ba
        L_0x023f:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r9 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r0)
            com.google.android.gms.internal.ads.zzvk r0 = (com.google.android.gms.internal.ads.zzvk) r0
            java.lang.String r1 = r10.readString()
            android.os.IBinder r10 = r10.readStrongBinder()
            if (r10 != 0) goto L_0x025a
            goto L_0x026c
        L_0x025a:
            java.lang.String r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r12 = r10.queryLocalInterface(r12)
            boolean r2 = r12 instanceof com.google.android.gms.internal.ads.zzano
            if (r2 == 0) goto L_0x0267
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x026c
        L_0x0267:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r10)
        L_0x026c:
            r8.zza(r9, r0, r1, r12)
            goto L_0x023a
        L_0x0270:
            com.google.android.gms.dynamic.IObjectWrapper r9 = r8.zzud()
        L_0x0274:
            r11.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r11, (android.os.IInterface) r9)
            goto L_0x02ba
        L_0x027b:
            android.os.IBinder r9 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r9)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r9 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r2 = r9
            com.google.android.gms.internal.ads.zzvn r2 = (com.google.android.gms.internal.ads.zzvn) r2
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r9 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r10, r9)
            r3 = r9
            com.google.android.gms.internal.ads.zzvk r3 = (com.google.android.gms.internal.ads.zzvk) r3
            java.lang.String r4 = r10.readString()
            android.os.IBinder r9 = r10.readStrongBinder()
            if (r9 != 0) goto L_0x02a1
        L_0x029f:
            r5 = r12
            goto L_0x02b5
        L_0x02a1:
            java.lang.String r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener"
            android.os.IInterface r10 = r9.queryLocalInterface(r10)
            boolean r12 = r10 instanceof com.google.android.gms.internal.ads.zzano
            if (r12 == 0) goto L_0x02af
            r12 = r10
            com.google.android.gms.internal.ads.zzano r12 = (com.google.android.gms.internal.ads.zzano) r12
            goto L_0x029f
        L_0x02af:
            com.google.android.gms.internal.ads.zzanq r12 = new com.google.android.gms.internal.ads.zzanq
            r12.<init>(r9)
            goto L_0x029f
        L_0x02b5:
            r0 = r8
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (com.google.android.gms.internal.ads.zzvn) r2, (com.google.android.gms.internal.ads.zzvk) r3, (java.lang.String) r4, (com.google.android.gms.internal.ads.zzano) r5)
            goto L_0x023a
        L_0x02ba:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanm.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
