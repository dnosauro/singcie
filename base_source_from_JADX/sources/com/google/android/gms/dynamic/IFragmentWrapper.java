package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {

        public static class zza extends zzb implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public final IObjectWrapper zza() {
                Parcel zza = zza(2, mo17030a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final void zza(Intent intent) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, (Parcelable) intent);
                zzb(25, a_);
            }

            public final void zza(Intent intent, int i) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, (Parcelable) intent);
                a_.writeInt(i);
                zzb(26, a_);
            }

            public final void zza(IObjectWrapper iObjectWrapper) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, (IInterface) iObjectWrapper);
                zzb(20, a_);
            }

            public final void zza(boolean z) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, z);
                zzb(21, a_);
            }

            public final Bundle zzb() {
                Parcel zza = zza(3, mo17030a_());
                Bundle bundle = (Bundle) zzd.zza(zza, Bundle.CREATOR);
                zza.recycle();
                return bundle;
            }

            public final void zzb(IObjectWrapper iObjectWrapper) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, (IInterface) iObjectWrapper);
                zzb(27, a_);
            }

            public final void zzb(boolean z) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, z);
                zzb(22, a_);
            }

            public final int zzc() {
                Parcel zza = zza(4, mo17030a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final void zzc(boolean z) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, z);
                zzb(23, a_);
            }

            public final IFragmentWrapper zzd() {
                Parcel zza = zza(5, mo17030a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final void zzd(boolean z) {
                Parcel a_ = mo17030a_();
                zzd.zza(a_, z);
                zzb(24, a_);
            }

            public final IObjectWrapper zze() {
                Parcel zza = zza(6, mo17030a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final boolean zzf() {
                Parcel zza = zza(7, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final String zzg() {
                Parcel zza = zza(8, mo17030a_());
                String readString = zza.readString();
                zza.recycle();
                return readString;
            }

            public final IFragmentWrapper zzh() {
                Parcel zza = zza(9, mo17030a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final int zzi() {
                Parcel zza = zza(10, mo17030a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final boolean zzj() {
                Parcel zza = zza(11, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final IObjectWrapper zzk() {
                Parcel zza = zza(12, mo17030a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final boolean zzl() {
                Parcel zza = zza(13, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzm() {
                Parcel zza = zza(14, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzn() {
                Parcel zza = zza(15, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzo() {
                Parcel zza = zza(16, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzp() {
                Parcel zza = zza(17, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzq() {
                Parcel zza = zza(18, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzr() {
                Parcel zza = zza(19, mo17030a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
            r3.writeNoException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a3, code lost:
            r3.writeNoException();
            com.google.android.gms.internal.common.zzd.zza(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
            r3.writeNoException();
            r3.writeInt(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
            r3.writeNoException();
            com.google.android.gms.internal.common.zzd.zza(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
            /*
                r0 = this;
                switch(r1) {
                    case 2: goto L_0x00ca;
                    case 3: goto L_0x00bf;
                    case 4: goto L_0x00b4;
                    case 5: goto L_0x00af;
                    case 6: goto L_0x00aa;
                    case 7: goto L_0x009f;
                    case 8: goto L_0x0094;
                    case 9: goto L_0x008f;
                    case 10: goto L_0x008a;
                    case 11: goto L_0x0085;
                    case 12: goto L_0x0080;
                    case 13: goto L_0x007b;
                    case 14: goto L_0x0076;
                    case 15: goto L_0x0071;
                    case 16: goto L_0x006c;
                    case 17: goto L_0x0067;
                    case 18: goto L_0x0062;
                    case 19: goto L_0x005d;
                    case 20: goto L_0x004d;
                    case 21: goto L_0x0045;
                    case 22: goto L_0x003d;
                    case 23: goto L_0x0035;
                    case 24: goto L_0x002d;
                    case 25: goto L_0x0021;
                    case 26: goto L_0x0011;
                    case 27: goto L_0x0005;
                    default: goto L_0x0003;
                }
            L_0x0003:
                r1 = 0
                return r1
            L_0x0005:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
                r0.zzb((com.google.android.gms.dynamic.IObjectWrapper) r1)
                goto L_0x0058
            L_0x0011:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                int r2 = r2.readInt()
                r0.zza(r1, r2)
                goto L_0x0058
            L_0x0021:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                r0.zza((android.content.Intent) r1)
                goto L_0x0058
            L_0x002d:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.zzd(r1)
                goto L_0x0058
            L_0x0035:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.zzc(r1)
                goto L_0x0058
            L_0x003d:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.zzb((boolean) r1)
                goto L_0x0058
            L_0x0045:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.zza((boolean) r1)
                goto L_0x0058
            L_0x004d:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
                r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1)
            L_0x0058:
                r3.writeNoException()
                goto L_0x00d4
            L_0x005d:
                boolean r1 = r0.zzr()
                goto L_0x00a3
            L_0x0062:
                boolean r1 = r0.zzq()
                goto L_0x00a3
            L_0x0067:
                boolean r1 = r0.zzp()
                goto L_0x00a3
            L_0x006c:
                boolean r1 = r0.zzo()
                goto L_0x00a3
            L_0x0071:
                boolean r1 = r0.zzn()
                goto L_0x00a3
            L_0x0076:
                boolean r1 = r0.zzm()
                goto L_0x00a3
            L_0x007b:
                boolean r1 = r0.zzl()
                goto L_0x00a3
            L_0x0080:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzk()
                goto L_0x00ce
            L_0x0085:
                boolean r1 = r0.zzj()
                goto L_0x00a3
            L_0x008a:
                int r1 = r0.zzi()
                goto L_0x00b8
            L_0x008f:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.zzh()
                goto L_0x00ce
            L_0x0094:
                java.lang.String r1 = r0.zzg()
                r3.writeNoException()
                r3.writeString(r1)
                goto L_0x00d4
            L_0x009f:
                boolean r1 = r0.zzf()
            L_0x00a3:
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r3, (boolean) r1)
                goto L_0x00d4
            L_0x00aa:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zze()
                goto L_0x00ce
            L_0x00af:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.zzd()
                goto L_0x00ce
            L_0x00b4:
                int r1 = r0.zzc()
            L_0x00b8:
                r3.writeNoException()
                r3.writeInt(r1)
                goto L_0x00d4
            L_0x00bf:
                android.os.Bundle r1 = r0.zzb()
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.zzb(r3, r1)
                goto L_0x00d4
            L_0x00ca:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zza()
            L_0x00ce:
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            L_0x00d4:
                r1 = 1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.IFragmentWrapper.Stub.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IObjectWrapper zza();

    void zza(Intent intent);

    void zza(Intent intent, int i);

    void zza(IObjectWrapper iObjectWrapper);

    void zza(boolean z);

    Bundle zzb();

    void zzb(IObjectWrapper iObjectWrapper);

    void zzb(boolean z);

    int zzc();

    void zzc(boolean z);

    IFragmentWrapper zzd();

    void zzd(boolean z);

    IObjectWrapper zze();

    boolean zzf();

    String zzg();

    IFragmentWrapper zzh();

    int zzi();

    boolean zzj();

    IObjectWrapper zzk();

    boolean zzl();

    boolean zzm();

    boolean zzn();

    boolean zzo();

    boolean zzp();

    boolean zzq();

    boolean zzr();
}
