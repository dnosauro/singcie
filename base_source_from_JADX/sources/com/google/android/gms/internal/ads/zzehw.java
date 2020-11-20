package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

public final class zzehw implements zzedb {
    private final ThreadLocal<Mac> zziht = new zzehv(this);
    /* access modifiers changed from: private */
    public final String zzihu;
    /* access modifiers changed from: private */
    public final Key zzihv;
    private final int zzihw;

    public zzehw(String str, Key key) {
        int i;
        this.zzihu = str;
        this.zzihv = key;
        if (key.getEncoded().length >= 16) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode != 392316170) {
                        if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                            c = 3;
                        }
                    } else if (str.equals("HMACSHA384")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    i = 20;
                    break;
                case 1:
                    i = 32;
                    break;
                case 2:
                    i = 48;
                    break;
                case 3:
                    i = 64;
                    break;
                default:
                    String valueOf = String.valueOf(str);
                    throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
            }
            this.zzihw = i;
            this.zziht.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    public final byte[] zzd(byte[] bArr, int i) {
        if (i <= this.zzihw) {
            this.zziht.get().update(bArr);
            return Arrays.copyOf(this.zziht.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
