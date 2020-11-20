package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehk;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzehh<T_WRAPPER extends zzehk<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzehh.class.getName());
    private static final List<Provider> zzihc;
    public static final zzehh<zzehj, Cipher> zzihd = new zzehh<>(new zzehj());
    public static final zzehh<zzehn, Mac> zzihe = new zzehh<>(new zzehn());
    private static final zzehh<zzehp, Signature> zzihf = new zzehh<>(new zzehp());
    private static final zzehh<zzehq, MessageDigest> zzihg = new zzehh<>(new zzehq());
    public static final zzehh<zzehm, KeyAgreement> zzihh = new zzehh<>(new zzehm());
    public static final zzehh<zzeho, KeyPairGenerator> zzihi = new zzehh<>(new zzeho());
    public static final zzehh<zzehl, KeyFactory> zzihj = new zzehh<>(new zzehl());
    private T_WRAPPER zzihk;
    private List<Provider> zzihl = zzihc;
    private boolean zzihm = true;

    static {
        if (zzehz.zzbfe()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzihc = arrayList;
        } else {
            zzihc = new ArrayList();
        }
    }

    private zzehh(T_WRAPPER t_wrapper) {
        this.zzihk = t_wrapper;
    }

    public final T_ENGINE zzhq(String str) {
        Exception exc = null;
        for (Provider zza : this.zzihl) {
            try {
                return this.zzihk.zza(str, zza);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzihm) {
            return this.zzihk.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
