package org.spongycastle.operator.p189bc;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.ExtendedDigest;

/* renamed from: org.spongycastle.operator.bc.BcDigestProvider */
public interface BcDigestProvider {
    ExtendedDigest get(AlgorithmIdentifier algorithmIdentifier);
}
