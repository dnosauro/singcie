package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzu extends zzc implements zzv {
    public zzu() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzv asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzx(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v16, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v26, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v34, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v39, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v44, types: [com.google.android.gms.internal.measurement.zzac] */
    /* JADX WARNING: type inference failed for: r1v49, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v54, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v59, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v64, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v83, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v88, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v94, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r1v99, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r1v104, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r1v109, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v114, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r1v123 */
    /* JADX WARNING: type inference failed for: r1v124 */
    /* JADX WARNING: type inference failed for: r1v125 */
    /* JADX WARNING: type inference failed for: r1v126 */
    /* JADX WARNING: type inference failed for: r1v127 */
    /* JADX WARNING: type inference failed for: r1v128 */
    /* JADX WARNING: type inference failed for: r1v129 */
    /* JADX WARNING: type inference failed for: r1v130 */
    /* JADX WARNING: type inference failed for: r1v131 */
    /* JADX WARNING: type inference failed for: r1v132 */
    /* JADX WARNING: type inference failed for: r1v133 */
    /* JADX WARNING: type inference failed for: r1v134 */
    /* JADX WARNING: type inference failed for: r1v135 */
    /* JADX WARNING: type inference failed for: r1v136 */
    /* JADX WARNING: type inference failed for: r1v137 */
    /* JADX WARNING: type inference failed for: r1v138 */
    /* JADX WARNING: type inference failed for: r1v139 */
    /* JADX WARNING: type inference failed for: r1v140 */
    /* JADX WARNING: type inference failed for: r1v141 */
    /* JADX WARNING: type inference failed for: r1v142 */
    /* JADX WARNING: type inference failed for: r1v143 */
    /* JADX WARNING: type inference failed for: r1v144 */
    /* JADX WARNING: type inference failed for: r1v145 */
    /* JADX WARNING: type inference failed for: r1v146 */
    /* JADX WARNING: type inference failed for: r1v147 */
    /* JADX WARNING: type inference failed for: r1v148 */
    /* JADX WARNING: type inference failed for: r1v149 */
    /* JADX WARNING: type inference failed for: r1v150 */
    /* JADX WARNING: type inference failed for: r1v151 */
    /* JADX WARNING: type inference failed for: r1v152 */
    /* JADX WARNING: type inference failed for: r1v153 */
    /* JADX WARNING: type inference failed for: r1v154 */
    /* JADX WARNING: type inference failed for: r1v155 */
    /* JADX WARNING: type inference failed for: r1v156 */
    /* JADX WARNING: type inference failed for: r1v157 */
    /* JADX WARNING: type inference failed for: r1v158 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
            r8 = this;
            r1 = 0
            switch(r9) {
                case 1: goto L_0x040c;
                case 2: goto L_0x03eb;
                case 3: goto L_0x03b2;
                case 4: goto L_0x0394;
                case 5: goto L_0x036a;
                case 6: goto L_0x0348;
                case 7: goto L_0x033b;
                case 8: goto L_0x032a;
                case 9: goto L_0x0315;
                case 10: goto L_0x02ef;
                case 11: goto L_0x02e2;
                case 12: goto L_0x02d9;
                case 13: goto L_0x02d0;
                case 14: goto L_0x02c7;
                case 15: goto L_0x02ad;
                case 16: goto L_0x028f;
                case 17: goto L_0x0271;
                case 18: goto L_0x0253;
                case 19: goto L_0x0235;
                case 20: goto L_0x0217;
                case 21: goto L_0x01f9;
                case 22: goto L_0x01db;
                case 23: goto L_0x01ce;
                case 24: goto L_0x01c1;
                case 25: goto L_0x01b0;
                case 26: goto L_0x019f;
                case 27: goto L_0x0186;
                case 28: goto L_0x0175;
                case 29: goto L_0x0164;
                case 30: goto L_0x0153;
                case 31: goto L_0x0129;
                case 32: goto L_0x00ff;
                case 33: goto L_0x00d9;
                case 34: goto L_0x00bb;
                case 35: goto L_0x009d;
                case 36: goto L_0x007f;
                case 37: goto L_0x0076;
                case 38: goto L_0x0054;
                case 39: goto L_0x004b;
                case 40: goto L_0x002d;
                case 41: goto L_0x0004;
                case 42: goto L_0x0020;
                case 43: goto L_0x0017;
                case 44: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r0 = 0
            return r0
        L_0x0006:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            r8.setConsent(r1, r2)
            goto L_0x0423
        L_0x0017:
            long r0 = r10.readLong()
            r8.clearMeasurementEnabled(r0)
            goto L_0x0423
        L_0x0020:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r1)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r8.setDefaultEventParameters(r0)
            goto L_0x0423
        L_0x002d:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0034
            goto L_0x0046
        L_0x0034:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0041
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0046
        L_0x0041:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x0046:
            r8.isDataCollectionEnabled(r1)
            goto L_0x0423
        L_0x004b:
            boolean r0 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            r8.setDataCollectionEnabled(r0)
            goto L_0x0423
        L_0x0054:
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x005b
            goto L_0x006d
        L_0x005b:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0068
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x006d
        L_0x0068:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r2)
        L_0x006d:
            int r0 = r10.readInt()
            r8.getTestFlag(r1, r0)
            goto L_0x0423
        L_0x0076:
            java.util.HashMap r0 = com.google.android.gms.internal.measurement.zzb.zzb(r10)
            r8.initForTests(r0)
            goto L_0x0423
        L_0x007f:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0086
            goto L_0x0098
        L_0x0086:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x0093
            com.google.android.gms.internal.measurement.zzab r1 = (com.google.android.gms.internal.measurement.zzab) r1
            goto L_0x0098
        L_0x0093:
            com.google.android.gms.internal.measurement.zzad r1 = new com.google.android.gms.internal.measurement.zzad
            r1.<init>(r0)
        L_0x0098:
            r8.unregisterOnMeasurementEventListener(r1)
            goto L_0x0423
        L_0x009d:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x00a4
            goto L_0x00b6
        L_0x00a4:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x00b1
            com.google.android.gms.internal.measurement.zzab r1 = (com.google.android.gms.internal.measurement.zzab) r1
            goto L_0x00b6
        L_0x00b1:
            com.google.android.gms.internal.measurement.zzad r1 = new com.google.android.gms.internal.measurement.zzad
            r1.<init>(r0)
        L_0x00b6:
            r8.registerOnMeasurementEventListener(r1)
            goto L_0x0423
        L_0x00bb:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x00c2
            goto L_0x00d4
        L_0x00c2:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzab r1 = (com.google.android.gms.internal.measurement.zzab) r1
            goto L_0x00d4
        L_0x00cf:
            com.google.android.gms.internal.measurement.zzad r1 = new com.google.android.gms.internal.measurement.zzad
            r1.<init>(r0)
        L_0x00d4:
            r8.setEventInterceptor(r1)
            goto L_0x0423
        L_0x00d9:
            int r1 = r10.readInt()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r0 = r8
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x0423
        L_0x00ff:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x010e
            goto L_0x0120
        L_0x010e:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r3.queryLocalInterface(r1)
            boolean r4 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r4 == 0) goto L_0x011b
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0120
        L_0x011b:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r3)
        L_0x0120:
            long r3 = r10.readLong()
            r8.performAction(r2, r1, r3)
            goto L_0x0423
        L_0x0129:
            android.os.IBinder r2 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r3.queryLocalInterface(r1)
            boolean r4 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r4 == 0) goto L_0x0145
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x014a
        L_0x0145:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r3)
        L_0x014a:
            long r3 = r10.readLong()
            r8.onActivitySaveInstanceState(r2, r1, r3)
            goto L_0x0423
        L_0x0153:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r10.readLong()
            r8.onActivityResumed(r1, r2)
            goto L_0x0423
        L_0x0164:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r10.readLong()
            r8.onActivityPaused(r1, r2)
            goto L_0x0423
        L_0x0175:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r10.readLong()
            r8.onActivityDestroyed(r1, r2)
            goto L_0x0423
        L_0x0186:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r10.readLong()
            r8.onActivityCreated(r1, r2, r3)
            goto L_0x0423
        L_0x019f:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r10.readLong()
            r8.onActivityStopped(r1, r2)
            goto L_0x0423
        L_0x01b0:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r10.readLong()
            r8.onActivityStarted(r1, r2)
            goto L_0x0423
        L_0x01c1:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            r8.endAdUnitExposure(r1, r2)
            goto L_0x0423
        L_0x01ce:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            r8.beginAdUnitExposure(r1, r2)
            goto L_0x0423
        L_0x01db:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x01e2
            goto L_0x01f4
        L_0x01e2:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x01ef
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x01f4
        L_0x01ef:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x01f4:
            r8.generateEventId(r1)
            goto L_0x0423
        L_0x01f9:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0200
            goto L_0x0212
        L_0x0200:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x020d
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0212
        L_0x020d:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x0212:
            r8.getGmpAppId(r1)
            goto L_0x0423
        L_0x0217:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x021e
            goto L_0x0230
        L_0x021e:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x022b
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0230
        L_0x022b:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x0230:
            r8.getAppInstanceId(r1)
            goto L_0x0423
        L_0x0235:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x023c
            goto L_0x024e
        L_0x023c:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0249
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x024e
        L_0x0249:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x024e:
            r8.getCachedAppInstanceId(r1)
            goto L_0x0423
        L_0x0253:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x025a
            goto L_0x026c
        L_0x025a:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzac
            if (r2 == 0) goto L_0x0267
            com.google.android.gms.internal.measurement.zzac r1 = (com.google.android.gms.internal.measurement.zzac) r1
            goto L_0x026c
        L_0x0267:
            com.google.android.gms.internal.measurement.zzaf r1 = new com.google.android.gms.internal.measurement.zzaf
            r1.<init>(r0)
        L_0x026c:
            r8.setInstanceIdProvider(r1)
            goto L_0x0423
        L_0x0271:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0278
            goto L_0x028a
        L_0x0278:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0285
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x028a
        L_0x0285:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x028a:
            r8.getCurrentScreenClass(r1)
            goto L_0x0423
        L_0x028f:
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0296
            goto L_0x02a8
        L_0x0296:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x02a3
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x02a8
        L_0x02a3:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x02a8:
            r8.getCurrentScreenName(r1)
            goto L_0x0423
        L_0x02ad:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            long r4 = r10.readLong()
            r0 = r8
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x0423
        L_0x02c7:
            long r0 = r10.readLong()
            r8.setSessionTimeoutDuration(r0)
            goto L_0x0423
        L_0x02d0:
            long r0 = r10.readLong()
            r8.setMinimumSessionDuration(r0)
            goto L_0x0423
        L_0x02d9:
            long r0 = r10.readLong()
            r8.resetAnalyticsData(r0)
            goto L_0x0423
        L_0x02e2:
            boolean r1 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            long r2 = r10.readLong()
            r8.setMeasurementEnabled(r1, r2)
            goto L_0x0423
        L_0x02ef:
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x02fe
            goto L_0x0310
        L_0x02fe:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r4 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r4 == 0) goto L_0x030b
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0310
        L_0x030b:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x0310:
            r8.getConditionalUserProperties(r2, r3, r1)
            goto L_0x0423
        L_0x0315:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r8.clearConditionalUserProperty(r1, r2, r0)
            goto L_0x0423
        L_0x032a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            r8.setConditionalUserProperty(r1, r2)
            goto L_0x0423
        L_0x033b:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            r8.setUserId(r1, r2)
            goto L_0x0423
        L_0x0348:
            java.lang.String r2 = r10.readString()
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x0353
            goto L_0x0365
        L_0x0353:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0360
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x0365
        L_0x0360:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x0365:
            r8.getMaxUserProperties(r2, r1)
            goto L_0x0423
        L_0x036a:
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            android.os.IBinder r0 = r10.readStrongBinder()
            if (r0 != 0) goto L_0x037d
            goto L_0x038f
        L_0x037d:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r5 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r5 == 0) goto L_0x038a
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x038f
        L_0x038a:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r0)
        L_0x038f:
            r8.getUserProperties(r2, r3, r4, r1)
            goto L_0x0423
        L_0x0394:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            long r5 = r10.readLong()
            r0 = r8
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x0423
        L_0x03b2:
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r4)
            android.os.Bundle r4 = (android.os.Bundle) r4
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x03ca
        L_0x03c8:
            r5 = r1
            goto L_0x03dd
        L_0x03ca:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)
            boolean r6 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r6 == 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzw r1 = (com.google.android.gms.internal.measurement.zzw) r1
            goto L_0x03c8
        L_0x03d7:
            com.google.android.gms.internal.measurement.zzy r1 = new com.google.android.gms.internal.measurement.zzy
            r1.<init>(r5)
            goto L_0x03c8
        L_0x03dd:
            long r6 = r10.readLong()
            r0 = r8
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x0423
        L_0x03eb:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            boolean r5 = com.google.android.gms.internal.measurement.zzb.zza(r10)
            long r6 = r10.readLong()
            r0 = r8
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x0423
        L_0x040c:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzae> r2 = com.google.android.gms.internal.measurement.zzae.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r10, r2)
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            long r3 = r10.readLong()
            r8.initialize(r1, r2, r3)
        L_0x0423:
            r11.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzu.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
