package org.spongycastle.cms;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.cms.OriginatorInfo;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.Store;

public class OriginatorInfoGenerator {
    private final List origCRLs;
    private final List origCerts;

    public OriginatorInfoGenerator(X509CertificateHolder x509CertificateHolder) {
        this.origCerts = new ArrayList(1);
        this.origCRLs = null;
        this.origCerts.add(x509CertificateHolder.toASN1Structure());
    }

    public OriginatorInfoGenerator(Store store) {
        this(store, (Store) null);
    }

    public OriginatorInfoGenerator(Store store, Store store2) {
        this.origCerts = CMSUtils.getCertificatesFromStore(store);
        this.origCRLs = store2 != null ? CMSUtils.getCRLsFromStore(store2) : null;
    }

    public OriginatorInformation generate() {
        return this.origCRLs != null ? new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), CMSUtils.createDerSetFromList(this.origCRLs))) : new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), (ASN1Set) null));
    }
}
