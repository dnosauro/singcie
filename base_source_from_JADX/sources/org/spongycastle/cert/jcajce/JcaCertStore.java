package org.spongycastle.cert.jcajce;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.CollectionStore;

public class JcaCertStore extends CollectionStore {
    public JcaCertStore(Collection collection) {
        super(convertCerts(collection));
    }

    private static Collection convertCerts(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next instanceof X509Certificate) {
                try {
                    arrayList.add(new X509CertificateHolder(((X509Certificate) next).getEncoded()));
                } catch (IOException e) {
                    throw new CertificateEncodingException("unable to read encoding: " + e.getMessage());
                }
            } else {
                arrayList.add((X509CertificateHolder) next);
            }
        }
        return arrayList;
    }
}
