package com.unboundid.asn1;

import java.io.Serializable;

public final class ASN1BufferSet implements Serializable {
    private static final long serialVersionUID = 6686782295672518084L;
    private final ASN1Buffer buffer;
    private final int valueStartPos;

    ASN1BufferSet(ASN1Buffer aSN1Buffer) {
        this.buffer = aSN1Buffer;
        this.valueStartPos = aSN1Buffer.length();
    }

    public void end() {
        this.buffer.endSequenceOrSet(this.valueStartPos);
    }
}
