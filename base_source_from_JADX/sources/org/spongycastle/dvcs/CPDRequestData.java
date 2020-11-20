package org.spongycastle.dvcs;

import org.spongycastle.asn1.dvcs.Data;

public class CPDRequestData extends DVCSRequestData {
    CPDRequestData(Data data) {
        super(data);
        initMessage();
    }

    private void initMessage() {
        if (this.data.getMessage() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.message should be specified for CPD service");
        }
    }

    public byte[] getMessage() {
        return this.data.getMessage().getOctets();
    }
}
