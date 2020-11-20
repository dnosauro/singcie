package org.spongycastle.dvcs;

import org.spongycastle.asn1.dvcs.Data;

public class CCPDRequestData extends DVCSRequestData {
    CCPDRequestData(Data data) {
        super(data);
        initDigest();
    }

    private void initDigest() {
        if (this.data.getMessageImprint() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.messageImprint should be specified for CCPD service");
        }
    }

    public MessageImprint getMessageImprint() {
        return new MessageImprint(this.data.getMessageImprint());
    }
}
