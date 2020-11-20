package com.unboundid.asn1;

import java.io.Serializable;

public final class ASN1BufferSequence implements Serializable {
    private static final long serialVersionUID = 7219098399193345629L;
    private final ASN1Buffer buffer;
    private final int valueStartPos;

    ASN1BufferSequence(ASN1Buffer aSN1Buffer) {
        this.buffer = aSN1Buffer;
        this.valueStartPos = aSN1Buffer.length();
    }

    public void end() {
        this.buffer.endSequenceOrSet(this.valueStartPos);
    }
}
