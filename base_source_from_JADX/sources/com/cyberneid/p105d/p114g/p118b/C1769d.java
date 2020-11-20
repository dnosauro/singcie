package com.cyberneid.p105d.p114g.p118b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cyberneid.d.g.b.d */
final class C1769d {
    /* renamed from: a */
    static MessageDigest m7088a() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    static MessageDigest m7089b() {
        try {
            return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
