package org.spongycastle.dvcs;

import org.spongycastle.asn1.dvcs.Data;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.CMSSignedData;

public class VSDRequestData extends DVCSRequestData {
    private CMSSignedData doc;

    VSDRequestData(Data data) {
        super(data);
        initDocument();
    }

    private void initDocument() {
        if (this.doc != null) {
            return;
        }
        if (this.data.getMessage() != null) {
            try {
                this.doc = new CMSSignedData(this.data.getMessage().getOctets());
            } catch (CMSException e) {
                throw new DVCSConstructionException("Can't read CMS SignedData from input", e);
            }
        } else {
            throw new DVCSConstructionException("DVCSRequest.data.message should be specified for VSD service");
        }
    }

    public byte[] getMessage() {
        return this.data.getMessage().getOctets();
    }

    public CMSSignedData getParsedMessage() {
        return this.doc;
    }
}
