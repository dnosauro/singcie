package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

public final class zzduj {
    private static final HashMap<String, Class<?>> zzhsb = new HashMap<>();
    private final Context context;
    private final zzdum zzhrk;
    private final zzdsg zzhsc;
    private zzdtx zzhsd;
    private final Object zzhse = new Object();
    private final zzdsi zzvs;

    public zzduj(Context context2, zzdum zzdum, zzdsi zzdsi, zzdsg zzdsg) {
        this.context = context2;
        this.zzhrk = zzdum;
        this.zzvs = zzdsi;
        this.zzhsc = zzdsg;
    }

    private final synchronized Class<?> zza(zzdua zzdua) {
        if (zzdua.zzaxz() != null) {
            String zzdg = zzdua.zzaxz().zzdg();
            Class<?> cls = zzhsb.get(zzdg);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.zzhsc.zzb(zzdua.zzaya())) {
                    File zzayb = zzdua.zzayb();
                    if (!zzayb.exists()) {
                        zzayb.mkdirs();
                    }
                    Class<?> loadClass = new DexClassLoader(zzdua.zzaya().getAbsolutePath(), zzayb.getAbsolutePath(), (String) null, this.context.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    zzhsb.put(zzdg, loadClass);
                    return loadClass;
                }
                throw new zzduk(2026, "VM did not pass signature verification");
            } catch (GeneralSecurityException e) {
                throw new zzduk(2026, (Throwable) e);
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                throw new zzduk(2008, e2);
            }
        } else {
            throw new zzduk(4010, "mc");
        }
    }

    private final Object zza(Class<?> cls, zzdua zzdua) {
        try {
            return cls.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.context, "msa-r", zzdua.zzayc(), null, new Bundle(), 2});
        } catch (Exception e) {
            throw new zzduk(2004, (Throwable) e);
        }
    }

    public final zzdsl zzayd() {
        zzdtx zzdtx;
        synchronized (this.zzhse) {
            zzdtx = this.zzhsd;
        }
        return zzdtx;
    }

    public final zzdua zzaye() {
        synchronized (this.zzhse) {
            if (this.zzhsd == null) {
                return null;
            }
            zzdua zzaxt = this.zzhsd.zzaxt();
            return zzaxt;
        }
    }

    public final void zzb(zzdua zzdua) {
        zzdsi zzdsi;
        int zzayf;
        Exception exc;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdtx zzdtx = new zzdtx(zza(zza(zzdua), zzdua), zzdua, this.zzhrk, this.zzvs);
            if (zzdtx.zzaxu()) {
                int zzaxv = zzdtx.zzaxv();
                if (zzaxv == 0) {
                    synchronized (this.zzhse) {
                        if (this.zzhsd != null) {
                            try {
                                this.zzhsd.close();
                            } catch (zzduk e) {
                                this.zzvs.zza(e.zzayf(), -1, (Exception) e);
                            }
                        }
                        this.zzhsd = zzdtx;
                    }
                    this.zzvs.zzh(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzaxv);
                throw new zzduk(4001, sb.toString());
            }
            throw new zzduk(4000, "init failed");
        } catch (zzduk e2) {
            zzdsi = this.zzvs;
            zzayf = e2.zzayf();
            exc = e2;
            zzdsi.zza(zzayf, System.currentTimeMillis() - currentTimeMillis, exc);
        } catch (Exception e3) {
            zzdsi = this.zzvs;
            zzayf = 4010;
            exc = e3;
            zzdsi.zza(zzayf, System.currentTimeMillis() - currentTimeMillis, exc);
        }
    }
}
