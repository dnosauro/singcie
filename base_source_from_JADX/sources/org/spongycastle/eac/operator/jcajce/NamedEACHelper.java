package org.spongycastle.eac.operator.jcajce;

import java.security.Signature;

class NamedEACHelper extends EACHelper {
    private final String providerName;

    NamedEACHelper(String str) {
        this.providerName = str;
    }

    /* access modifiers changed from: protected */
    public Signature createSignature(String str) {
        return Signature.getInstance(str, this.providerName);
    }
}
