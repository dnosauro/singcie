package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefr;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzeap {
    private static final Logger logger = Logger.getLogger(zzeap.class.getName());
    private static final ConcurrentMap<String, zza> zzhyy = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzb> zzhyz = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzhza = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdzw<?>> zzhzb = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzeao<?>> zzhzc = new ConcurrentHashMap();

    interface zza {
        Set<Class<?>> zzazw();

        <P> zzdzz<P> zzb(Class<P> cls);

        zzdzz<?> zzbaf();

        Class<?> zzbag();

        Class<?> zzbah();
    }

    interface zzb {
    }

    private zzeap() {
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private static <P> zzdzz<P> zza(String str, Class<P> cls) {
        zza zzhk = zzhk(str);
        if (cls == null) {
            return zzhk.zzbaf();
        }
        if (zzhk.zzazw().contains(cls)) {
            return zzhk.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhk.zzbag());
        Set<Class<?>> zzazw = zzhk.zzazw();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzazw) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static <P> zzeam<P> zza(zzeaf zzeaf, zzdzz<P> zzdzz, Class<P> cls) {
        Class cls2 = (Class) checkNotNull(cls);
        zzeaw.zzc(zzeaf.zzazz());
        zzeam<P> zza2 = zzeam.zza(cls2);
        for (zzefr.zza next : zzeaf.zzazz().zzbdt()) {
            if (next.zzbab() == zzefl.ENABLED) {
                zzeal<P> zza3 = zza2.zza(zza(next.zzbdx().zzbdf(), next.zzbdx().zzbdg(), cls2), next);
                if (next.zzbdy() == zzeaf.zzazz().zzbds()) {
                    zza2.zza(zza3);
                }
            }
        }
        return zza2;
    }

    private static <KeyProtoT extends zzels> zza zza(zzeae<KeyProtoT> zzeae) {
        return new zzear(zzeae);
    }

    public static synchronized zzefh zza(zzefn zzefn) {
        zzefh zzo;
        synchronized (zzeap.class) {
            zzdzz<?> zzhm = zzhm(zzefn.zzbdf());
            if (((Boolean) zzhza.get(zzefn.zzbdf())).booleanValue()) {
                zzo = zzhm.zzo(zzefn.zzbdg());
            } else {
                String valueOf = String.valueOf(zzefn.zzbdf());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static <P> P zza(zzeam<P> zzeam) {
        zzeao zzeao = (zzeao) zzhzc.get(zzeam.zzazr());
        if (zzeao != null) {
            return zzeao.zza(zzeam);
        }
        String valueOf = String.valueOf(zzeam.zzazr().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
    }

    private static <P> P zza(String str, zzeiu zzeiu, Class<P> cls) {
        return zza(str, cls).zzm(zzeiu);
    }

    public static <P> P zza(String str, zzels zzels, Class<P> cls) {
        return zza(str, (Class) checkNotNull(cls)).zza(zzels);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) {
        return zza(str, zzeiu.zzt(bArr), (Class) checkNotNull(cls));
    }

    public static synchronized <P> void zza(zzdzz<P> zzdzz, boolean z) {
        synchronized (zzeap.class) {
            if (zzdzz != null) {
                String keyType = zzdzz.getKeyType();
                zza(keyType, zzdzz.getClass(), z);
                zzhyy.putIfAbsent(keyType, new zzeas(zzdzz));
                zzhza.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzels> void zza(zzeae<KeyProtoT> zzeae, boolean z) {
        synchronized (zzeap.class) {
            String keyType = zzeae.getKeyType();
            zza(keyType, zzeae.getClass(), true);
            if (!zzhyy.containsKey(keyType)) {
                zzhyy.put(keyType, zza(zzeae));
                zzhyz.put(keyType, zzb(zzeae));
            }
            zzhza.put(keyType, true);
        }
    }

    public static synchronized <P> void zza(zzeao<P> zzeao) {
        synchronized (zzeap.class) {
            if (zzeao != null) {
                Class<P> zzazr = zzeao.zzazr();
                if (zzhzc.containsKey(zzazr)) {
                    zzeao zzeao2 = (zzeao) zzhzc.get(zzazr);
                    if (!zzeao.getClass().equals(zzeao2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzazr);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzazr.getName(), zzeao2.getClass().getName(), zzeao.getClass().getName()}));
                    }
                }
                zzhzc.put(zzazr, zzeao);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzels, PublicKeyProtoT extends zzels> void zza(zzeaq<KeyProtoT, PublicKeyProtoT> zzeaq, zzeae<PublicKeyProtoT> zzeae, boolean z) {
        Class<?> zzbah;
        synchronized (zzeap.class) {
            String keyType = zzeaq.getKeyType();
            String keyType2 = zzeae.getKeyType();
            zza(keyType, zzeaq.getClass(), true);
            zza(keyType2, zzeae.getClass(), false);
            if (!keyType.equals(keyType2)) {
                if (zzhyy.containsKey(keyType) && (zzbah = ((zza) zzhyy.get(keyType)).zzbah()) != null) {
                    if (!zzbah.equals(zzeae.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzeaq.getClass().getName(), zzbah.getName(), zzeae.getClass().getName()}));
                    }
                }
                if (!zzhyy.containsKey(keyType) || ((zza) zzhyy.get(keyType)).zzbah() == null) {
                    zzhyy.put(keyType, new zzeau(zzeaq, zzeae));
                    zzhyz.put(keyType, zzb(zzeaq));
                }
                zzhza.put(keyType, true);
                if (!zzhyy.containsKey(keyType2)) {
                    zzhyy.put(keyType2, zza(zzeae));
                }
                zzhza.put(keyType2, false);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void zza(java.lang.String r8, java.lang.Class<?> r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzeap> r0 = com.google.android.gms.internal.ads.zzeap.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzeap$zza> r1 = zzhyy     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzeap$zza> r1 = zzhyy     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzeap$zza r1 = (com.google.android.gms.internal.ads.zzeap.zza) r1     // Catch:{ all -> 0x0093 }
            java.lang.Class r2 = r1.zzbag()     // Catch:{ all -> 0x0093 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0093 }
            if (r2 != 0) goto L_0x0065
            java.util.logging.Logger r10 = logger     // Catch:{ all -> 0x0093 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r7 = r6.length()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0038
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x003e
        L_0x0038:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r5 = r6
        L_0x003e:
            r10.logp(r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0093 }
            r4 = 0
            r3[r4] = r8     // Catch:{ all -> 0x0093 }
            r8 = 1
            java.lang.Class r1 = r1.zzbag()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r1     // Catch:{ all -> 0x0093 }
            r8 = 2
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r9     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0093 }
            r10.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r10     // Catch:{ all -> 0x0093 }
        L_0x0065:
            if (r10 == 0) goto L_0x0091
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = zzhza     // Catch:{ all -> 0x0093 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x0093 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0093 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0093 }
            if (r9 != 0) goto L_0x0091
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r1 = r8.length()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0088:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r8.<init>(r10)     // Catch:{ all -> 0x0093 }
        L_0x008d:
            r9.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeap.zza(java.lang.String, java.lang.Class, boolean):void");
    }

    private static <KeyProtoT extends zzels> zzb zzb(zzeae<KeyProtoT> zzeae) {
        return new zzeat(zzeae);
    }

    public static synchronized zzels zzb(zzefn zzefn) {
        zzels zzn;
        synchronized (zzeap.class) {
            zzdzz<?> zzhm = zzhm(zzefn.zzbdf());
            if (((Boolean) zzhza.get(zzefn.zzbdf())).booleanValue()) {
                zzn = zzhm.zzn(zzefn.zzbdg());
            } else {
                String valueOf = String.valueOf(zzefn.zzbdf());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    private static synchronized zza zzhk(String str) {
        zza zza2;
        synchronized (zzeap.class) {
            if (!zzhyy.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zza2 = (zza) zzhyy.get(str);
        }
        return zza2;
    }

    @Deprecated
    public static zzdzw<?> zzhl(String str) {
        String str2;
        String str3;
        if (str != null) {
            zzdzw<?> zzdzw = (zzdzw) zzhzb.get(str.toLowerCase(Locale.US));
            if (zzdzw != null) {
                return zzdzw;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call DeterministicAeadConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call StreamingAeadConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call HybridConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call MacConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call SignatureConfig.register().";
            } else {
                if (str.toLowerCase(Locale.US).startsWith("tink")) {
                    str2 = String.valueOf(format);
                    str3 = "Maybe call TinkConfig.register().";
                }
                throw new GeneralSecurityException(format);
            }
            format = str2.concat(str3);
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static zzdzz<?> zzhm(String str) {
        return zzhk(str).zzbaf();
    }
}
