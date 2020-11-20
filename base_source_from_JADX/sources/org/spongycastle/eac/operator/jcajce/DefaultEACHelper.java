package org.spongycastle.eac.operator.jcajce;

import java.security.Signature;

class DefaultEACHelper extends EACHelper {
    DefaultEACHelper() {
    }

    /* access modifiers changed from: protected */
    public Signature createSignature(String str) {
        return Signature.getInstance(str);
    }
}
