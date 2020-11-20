package com.unboundid.asn1;

public final class ASN1StreamReaderSequence {
    private final long endBytesRead;
    private final int length;
    private final ASN1StreamReader reader;
    private final byte type;

    ASN1StreamReaderSequence(ASN1StreamReader aSN1StreamReader, byte b, int i) {
        this.reader = aSN1StreamReader;
        this.type = b;
        this.length = i;
        this.endBytesRead = aSN1StreamReader.getTotalBytesRead() + ((long) i);
    }

    public int getLength() {
        return this.length;
    }

    public byte getType() {
        return this.type;
    }

    public boolean hasMoreElements() {
        long totalBytesRead = this.reader.getTotalBytesRead();
        long j = this.endBytesRead;
        if (totalBytesRead == j) {
            return false;
        }
        if (totalBytesRead < j) {
            return true;
        }
        throw new ASN1Exception(ASN1Messages.ERR_STREAM_READER_SEQUENCE_READ_PAST_END.get(Integer.valueOf(this.length), Long.valueOf(this.endBytesRead), Long.valueOf(totalBytesRead)));
    }
}
