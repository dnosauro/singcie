package org.spongycastle.cms;

public interface SignerInformationVerifierProvider {
    SignerInformationVerifier get(SignerId signerId);
}
