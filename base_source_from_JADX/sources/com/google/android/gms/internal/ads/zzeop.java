package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzeop implements zzbs, Closeable, Iterator<zzbp> {
    private static zzeox zzcz = zzeox.zzn(zzeop.class);
    private static final zzbp zziye = new zzeos("eof ");
    long zzawh = 0;
    long zzbgj = 0;
    protected zzeor zziyc;
    protected zzbo zziyf;
    private zzbp zziyg = null;
    long zziyh = 0;
    private List<zzbp> zziyi = new ArrayList();

    /* access modifiers changed from: private */
    /* renamed from: zzbls */
    public final zzbp next() {
        zzbp zza;
        zzbp zzbp = this.zziyg;
        if (zzbp == null || zzbp == zziye) {
            zzeor zzeor = this.zziyc;
            if (zzeor == null || this.zziyh >= this.zzawh) {
                this.zziyg = zziye;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzeor) {
                    this.zziyc.zzfc(this.zziyh);
                    zza = this.zziyf.zza(this.zziyc, this);
                    this.zziyh = this.zziyc.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zziyg = null;
            return zzbp;
        }
    }

    public void close() {
        this.zziyc.close();
    }

    public boolean hasNext() {
        zzbp zzbp = this.zziyg;
        if (zzbp == zziye) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.zziyg = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zziyg = zziye;
            return false;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zziyi.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zziyi.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzeor zzeor, long j, zzbo zzbo) {
        this.zziyc = zzeor;
        long position = zzeor.position();
        this.zzbgj = position;
        this.zziyh = position;
        zzeor.zzfc(zzeor.position() + j);
        this.zzawh = zzeor.position();
        this.zziyf = zzbo;
    }

    public final List<zzbp> zzblr() {
        return (this.zziyc == null || this.zziyg == zziye) ? this.zziyi : new zzeov(this.zziyi, this);
    }
}
