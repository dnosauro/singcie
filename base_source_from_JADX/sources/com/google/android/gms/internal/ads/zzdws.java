package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdws<E> extends zzdwk<E> {
    private int zzaht;
    @NullableDecl
    private Object[] zzhvc;

    public zzdws() {
        super(4);
    }

    zzdws(int i) {
        super(i);
        this.zzhvc = new Object[zzdwt.zzeq(i)];
    }

    public final /* synthetic */ zzdwn zza(Iterator it) {
        zzdvv.checkNotNull(it);
        while (it.hasNext()) {
            zzac(it.next());
        }
        return this;
    }

    public final /* synthetic */ zzdwk zzab(Object obj) {
        return (zzdws) zzac(obj);
    }

    public final /* synthetic */ zzdwn zzac(Object obj) {
        zzdvv.checkNotNull(obj);
        if (this.zzhvc != null) {
            int zzeq = zzdwt.zzeq(this.size);
            Object[] objArr = this.zzhvc;
            if (zzeq <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzeo = zzdwi.zzeo(hashCode);
                while (true) {
                    int i = zzeo & length;
                    Object[] objArr2 = this.zzhvc;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzeo = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzaht += hashCode;
                        super.zzac(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzhvc = null;
        super.zzac(obj);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzdxc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.internal.ads.zzdwt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.internal.ads.zzdxc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.google.android.gms.internal.ads.zzdxc} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdwt<E> zzayz() {
        /*
            r8 = this;
            int r0 = r8.size
            switch(r0) {
                case 0: goto L_0x0033;
                case 1: goto L_0x0029;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.Object[] r0 = r8.zzhvc
            r1 = 1
            if (r0 == 0) goto L_0x0049
            int r0 = r8.size
            int r0 = com.google.android.gms.internal.ads.zzdwt.zzeq(r0)
            java.lang.Object[] r2 = r8.zzhvc
            int r2 = r2.length
            if (r0 != r2) goto L_0x0049
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zzhus
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzdwt.zzw(r0, r2)
            if (r0 == 0) goto L_0x0036
            java.lang.Object[] r0 = r8.zzhus
            int r2 = r8.size
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x0038
        L_0x0029:
            java.lang.Object[] r0 = r8.zzhus
            r1 = 0
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzdwt r0 = com.google.android.gms.internal.ads.zzdwt.zzae(r0)
            return r0
        L_0x0033:
            com.google.android.gms.internal.ads.zzdxc<java.lang.Object> r0 = com.google.android.gms.internal.ads.zzdxc.zzhvo
            return r0
        L_0x0036:
            java.lang.Object[] r0 = r8.zzhus
        L_0x0038:
            r3 = r0
            com.google.android.gms.internal.ads.zzdxc r0 = new com.google.android.gms.internal.ads.zzdxc
            int r4 = r8.zzaht
            java.lang.Object[] r5 = r8.zzhvc
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.size
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0057
        L_0x0049:
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zzhus
            com.google.android.gms.internal.ads.zzdwt r0 = com.google.android.gms.internal.ads.zzdwt.zza(r0, r2)
            int r2 = r0.size()
            r8.size = r2
        L_0x0057:
            r8.zzhut = r1
            r1 = 0
            r8.zzhvc = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdws.zzayz():com.google.android.gms.internal.ads.zzdwt");
    }

    public final /* synthetic */ zzdwn zzg(Iterable iterable) {
        zzdvv.checkNotNull(iterable);
        if (this.zzhvc != null) {
            for (Object zzac : iterable) {
                zzac(zzac);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }
}
