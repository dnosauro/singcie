package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzard {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzdpq = false;
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzzi = false;
    @VisibleForTesting
    private zzdse zzdpr;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcul)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return zza(r15, r16, r17, r18, r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        return r14.zzdpr.zzb(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), r17, r18, r19, r20, r21.toString(), r22.toString(), r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        com.google.android.gms.internal.ads.zzaza.zze("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.dynamic.IObjectWrapper zza(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzarg r21, com.google.android.gms.internal.ads.zzare r22, java.lang.String r23) {
        /*
            r14 = this;
            java.lang.Object r1 = lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcui     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r0 == 0) goto L_0x005b
            boolean r0 = zzzi     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x001b
            goto L_0x005b
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcul
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.dynamic.IObjectWrapper r0 = r14.zza(r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0033:
            r3 = r14
            com.google.android.gms.internal.ads.zzdse r4 = r3.zzdpr     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r11 = r21.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r12 = r22.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r13 = r23
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzb(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x0055
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzaza.zze(r1, r0)
            return r2
        L_0x005b:
            r3 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            return r2
        L_0x005e:
            r0 = move-exception
            r3 = r14
        L_0x0060:
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            throw r0
        L_0x0062:
            r0 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zza(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzarg, com.google.android.gms.internal.ads.zzare, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    @VisibleForTesting
    private final void zzn(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue() && !zzdpq) {
                try {
                    zzdpq = true;
                    this.zzdpr = (zzdse) zzazd.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzarf.zzbxv);
                } catch (zzazf e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
            return null;
        }
        try {
            zzn(context);
            String valueOf = String.valueOf(this.zzdpr.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, zzarg zzarg, zzare zzare, String str5) {
        return zza(str, webView, str2, str3, str4, "Google", zzarg, zzare, str5);
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                    if (zzzi) {
                        try {
                            return this.zzdpr.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzaza.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                if (zzzi) {
                    try {
                        this.zzdpr.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzaza.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                if (zzzi) {
                    try {
                        this.zzdpr.zzab(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzaza.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                if (zzzi) {
                    try {
                        this.zzdpr.zzac(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzaza.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwq.zzqe().zzd(com.google.android.gms.internal.ads.zzabf.zzcum)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return zza(r15, r16, r17, r18, r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        return r14.zzdpr.zza(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), r17, r18, r19, r20, r21.toString(), r22.toString(), r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        com.google.android.gms.internal.ads.zzaza.zze("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.dynamic.IObjectWrapper zzb(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzarg r21, com.google.android.gms.internal.ads.zzare r22, java.lang.String r23) {
        /*
            r14 = this;
            java.lang.Object r1 = lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcui     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r0 == 0) goto L_0x005b
            boolean r0 = zzzi     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x001b
            goto L_0x005b
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcum
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.dynamic.IObjectWrapper r0 = r14.zza(r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0033:
            r3 = r14
            com.google.android.gms.internal.ads.zzdse r4 = r3.zzdpr     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r11 = r21.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r12 = r22.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r13 = r23
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x0055
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzaza.zze(r1, r0)
            return r2
        L_0x005b:
            r3 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            return r2
        L_0x005e:
            r0 = move-exception
            r3 = r14
        L_0x0060:
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            throw r0
        L_0x0062:
            r0 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zzb(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzarg, com.google.android.gms.internal.ads.zzare, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                if (zzzi) {
                    try {
                        this.zzdpr.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzaza.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final boolean zzm(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue()) {
                return false;
            }
            if (zzzi) {
                return true;
            }
            try {
                zzn(context);
                boolean zzav = this.zzdpr.zzav(ObjectWrapper.wrap(context));
                zzzi = zzav;
                return zzav;
            } catch (RemoteException e) {
                e = e;
                zzaza.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzaza.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }
}
