package com.unboundid.asn1;

import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public final class ASN1Writer {
    private static final int MAX_BUFFER_LENGTH = 524288;
    private static final ThreadLocal<ByteStringBuffer> buffers = new ThreadLocal<>();

    private ASN1Writer() {
    }

    public static void writeElement(ASN1Element aSN1Element, OutputStream outputStream) {
        Debug.debugASN1Write(aSN1Element);
        ByteStringBuffer byteStringBuffer = buffers.get();
        if (byteStringBuffer == null) {
            byteStringBuffer = new ByteStringBuffer();
            buffers.set(byteStringBuffer);
        }
        aSN1Element.encodeTo(byteStringBuffer);
        try {
            byteStringBuffer.write(outputStream);
        } finally {
            if (byteStringBuffer.capacity() > 524288) {
                byteStringBuffer.setCapacity(524288);
            }
            byteStringBuffer.clear();
        }
    }

    public static void writeElement(ASN1Element aSN1Element, ByteBuffer byteBuffer) {
        Debug.debugASN1Write(aSN1Element);
        ByteStringBuffer byteStringBuffer = buffers.get();
        if (byteStringBuffer == null) {
            byteStringBuffer = new ByteStringBuffer();
            buffers.set(byteStringBuffer);
        }
        aSN1Element.encodeTo(byteStringBuffer);
        try {
            if (byteBuffer.remaining() >= byteStringBuffer.length()) {
                int position = byteBuffer.position();
                byteBuffer.put(byteStringBuffer.getBackingArray(), 0, byteStringBuffer.length());
                byteBuffer.limit(byteBuffer.position());
                byteBuffer.position(position);
                return;
            }
            throw new BufferOverflowException();
        } finally {
            if (byteStringBuffer.capacity() > 524288) {
                byteStringBuffer.setCapacity(524288);
            }
            byteStringBuffer.clear();
        }
    }
}
