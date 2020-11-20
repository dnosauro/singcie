package com.unboundid.asn1;

import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.spongycastle.asn1.eac.CertificateBody;

public final class ASN1Buffer implements Serializable {
    private static final int DEFAULT_MAX_BUFFER_SIZE = 1048576;
    private static final byte[] MULTIBYTE_LENGTH_HEADER_PLUS_FOUR = {-124, 0, 0, 0, 0};
    private static final byte[] MULTIBYTE_LENGTH_HEADER_PLUS_ONE = {-127, 0};
    private static final byte[] MULTIBYTE_LENGTH_HEADER_PLUS_THREE = {-125, 0, 0, 0};
    private static final byte[] MULTIBYTE_LENGTH_HEADER_PLUS_TWO = {MatchingRule.SUBSTRING_TYPE_SUBFINAL, 0, 0};
    private static final long serialVersionUID = -4898230771376551562L;
    private final ByteStringBuffer buffer;
    private final int maxBufferSize;
    private final AtomicBoolean zeroBufferOnClear;

    public ASN1Buffer() {
        this(1048576);
    }

    public ASN1Buffer(int i) {
        this.maxBufferSize = i;
        this.buffer = new ByteStringBuffer();
        this.zeroBufferOnClear = new AtomicBoolean(false);
    }

    public void addBoolean(byte b, boolean z) {
        byte b2;
        ByteStringBuffer byteStringBuffer;
        this.buffer.append(b);
        this.buffer.append((byte) 1);
        if (z) {
            byteStringBuffer = this.buffer;
            b2 = -1;
        } else {
            byteStringBuffer = this.buffer;
            b2 = 0;
        }
        byteStringBuffer.append(b2);
    }

    public void addBoolean(boolean z) {
        addBoolean((byte) 1, z);
    }

    public void addElement(ASN1Element aSN1Element) {
        aSN1Element.encodeTo(this.buffer);
    }

    public void addEnumerated(byte b, int i) {
        addInteger(b, i);
    }

    public void addEnumerated(int i) {
        addInteger((byte) 10, i);
    }

    public void addInteger(byte b, int i) {
        ByteStringBuffer byteStringBuffer;
        int i2;
        ByteStringBuffer byteStringBuffer2;
        int i3;
        ByteStringBuffer byteStringBuffer3;
        int i4;
        byte b2;
        ByteStringBuffer byteStringBuffer4;
        this.buffer.append(b);
        if (i >= 0) {
            int i5 = i & CertificateBody.profileType;
            if (i5 == i) {
                this.buffer.append((byte) 1);
                byteStringBuffer4 = this.buffer;
                b2 = (byte) i5;
                byteStringBuffer4.append(b2);
            } else if ((i & 32767) == i) {
                this.buffer.append((byte) 2);
                byteStringBuffer3 = this.buffer;
                i4 = (i >> 8) & CertificateBody.profileType;
                byteStringBuffer3.append((byte) i4);
            } else if ((8388607 & i) == i) {
                this.buffer.append((byte) 3);
                byteStringBuffer = this.buffer;
                i2 = (i >> 16) & CertificateBody.profileType;
                byteStringBuffer.append((byte) i2);
                byteStringBuffer3 = this.buffer;
                i4 = (i >> 8) & 255;
                byteStringBuffer3.append((byte) i4);
            } else {
                this.buffer.append((byte) 4);
                byteStringBuffer2 = this.buffer;
                i3 = (i >> 24) & CertificateBody.profileType;
                byteStringBuffer2.append((byte) i3);
                byteStringBuffer = this.buffer;
                i2 = (i >> 16) & 255;
                byteStringBuffer.append((byte) i2);
                byteStringBuffer3 = this.buffer;
                i4 = (i >> 8) & 255;
                byteStringBuffer3.append((byte) i4);
            }
        } else if ((i & -128) == -128) {
            this.buffer.append((byte) 1);
        } else if ((i & -32768) == -32768) {
            this.buffer.append((byte) 2);
            byteStringBuffer3 = this.buffer;
            i4 = (i >> 8) & 255;
            byteStringBuffer3.append((byte) i4);
        } else if ((i & -8388608) == -8388608) {
            this.buffer.append((byte) 3);
            byteStringBuffer = this.buffer;
            i2 = (i >> 16) & 255;
            byteStringBuffer.append((byte) i2);
            byteStringBuffer3 = this.buffer;
            i4 = (i >> 8) & 255;
            byteStringBuffer3.append((byte) i4);
        } else {
            this.buffer.append((byte) 4);
            byteStringBuffer2 = this.buffer;
            i3 = (i >> 24) & 255;
            byteStringBuffer2.append((byte) i3);
            byteStringBuffer = this.buffer;
            i2 = (i >> 16) & 255;
            byteStringBuffer.append((byte) i2);
            byteStringBuffer3 = this.buffer;
            i4 = (i >> 8) & 255;
            byteStringBuffer3.append((byte) i4);
        }
        byteStringBuffer4 = this.buffer;
        b2 = (byte) (i & 255);
        byteStringBuffer4.append(b2);
    }

    public void addInteger(byte b, long j) {
        long j2;
        ByteStringBuffer byteStringBuffer;
        byte b2;
        byte b3;
        ByteStringBuffer byteStringBuffer2;
        long j3;
        long j4;
        ByteStringBuffer byteStringBuffer3;
        byte b4;
        long j5;
        ByteStringBuffer byteStringBuffer4;
        byte b5;
        long j6;
        ByteStringBuffer byteStringBuffer5;
        long j7;
        ByteStringBuffer byteStringBuffer6;
        long j8;
        ByteStringBuffer byteStringBuffer7;
        byte b6;
        ByteStringBuffer byteStringBuffer8;
        this.buffer.append(b);
        byte b7 = 2;
        if (j >= 0) {
            long j9 = j & 127;
            if (j9 == j) {
                this.buffer.append((byte) 1);
                byteStringBuffer8 = this.buffer;
                b6 = (byte) ((int) j9);
                byteStringBuffer8.append(b6);
            } else if ((j & 32767) == j) {
                this.buffer.append((byte) 2);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 127;
                byteStringBuffer7.append((byte) ((int) j8));
            } else if ((j & 8388607) == j) {
                this.buffer.append((byte) 3);
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 127;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            } else if ((j & 2147483647L) == j) {
                this.buffer.append((byte) 4);
                byteStringBuffer5 = this.buffer;
                j6 = (j >> 24) & 127;
                byteStringBuffer5.append((byte) ((int) j6));
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 255;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            } else if ((j & 549755813887L) == j) {
                this.buffer.append((byte) 5);
                byteStringBuffer4 = this.buffer;
                j5 = (j >> 32) & 127;
                b5 = (byte) ((int) j5);
                byteStringBuffer4.append(b5);
                byteStringBuffer5 = this.buffer;
                j6 = (j >> 24) & 255;
                byteStringBuffer5.append((byte) ((int) j6));
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 255;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            } else if ((j & 140737488355327L) == j) {
                this.buffer.append((byte) 6);
                byteStringBuffer3 = this.buffer;
                j4 = (j >> 40) & 127;
                b4 = (byte) ((int) j4);
                byteStringBuffer3.append(b4);
                byteStringBuffer4 = this.buffer;
                j5 = (j >> 32) & 255;
                b5 = (byte) ((int) j5);
                byteStringBuffer4.append(b5);
                byteStringBuffer5 = this.buffer;
                j6 = (j >> 24) & 255;
                byteStringBuffer5.append((byte) ((int) j6));
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 255;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            } else if ((j & 36028797018963967L) == j) {
                this.buffer.append((byte) 7);
                byteStringBuffer = this.buffer;
                j2 = (j >> 48) & 127;
                b2 = (byte) ((int) j2);
                byteStringBuffer.append(b2);
                byteStringBuffer3 = this.buffer;
                j4 = (j >> 40) & 255;
                b4 = (byte) ((int) j4);
                byteStringBuffer3.append(b4);
                byteStringBuffer4 = this.buffer;
                j5 = (j >> 32) & 255;
                b5 = (byte) ((int) j5);
                byteStringBuffer4.append(b5);
                byteStringBuffer5 = this.buffer;
                j6 = (j >> 24) & 255;
                byteStringBuffer5.append((byte) ((int) j6));
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 255;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            } else {
                this.buffer.append((byte) 8);
                byteStringBuffer2 = this.buffer;
                j3 = (j >> 56) & 127;
                b3 = (byte) ((int) j3);
                byteStringBuffer2.append(b3);
                byteStringBuffer = this.buffer;
                j2 = (j >> 48) & 255;
                b2 = (byte) ((int) j2);
                byteStringBuffer.append(b2);
                byteStringBuffer3 = this.buffer;
                j4 = (j >> 40) & 255;
                b4 = (byte) ((int) j4);
                byteStringBuffer3.append(b4);
                byteStringBuffer4 = this.buffer;
                j5 = (j >> 32) & 255;
                b5 = (byte) ((int) j5);
                byteStringBuffer4.append(b5);
                byteStringBuffer5 = this.buffer;
                j6 = (j >> 24) & 255;
                byteStringBuffer5.append((byte) ((int) j6));
                byteStringBuffer6 = this.buffer;
                j7 = (j >> 16) & 255;
                b7 = (byte) ((int) j7);
                byteStringBuffer6.append(b7);
                byteStringBuffer7 = this.buffer;
                j8 = (j >> 8) & 255;
                byteStringBuffer7.append((byte) ((int) j8));
            }
        } else if ((j & -128) == -128) {
            this.buffer.append((byte) 1);
        } else if ((j & -32768) == -32768) {
            byteStringBuffer6 = this.buffer;
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else if ((j & -8388608) == -8388608) {
            this.buffer.append((byte) 3);
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else if ((j & -2147483648L) == -2147483648L) {
            byteStringBuffer4 = this.buffer;
            b5 = 4;
            byteStringBuffer4.append(b5);
            byteStringBuffer5 = this.buffer;
            j6 = (j >> 24) & 255;
            byteStringBuffer5.append((byte) ((int) j6));
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else if ((j & -549755813888L) == -549755813888L) {
            byteStringBuffer3 = this.buffer;
            b4 = 5;
            byteStringBuffer3.append(b4);
            byteStringBuffer4 = this.buffer;
            j5 = (j >> 32) & 255;
            b5 = (byte) ((int) j5);
            byteStringBuffer4.append(b5);
            byteStringBuffer5 = this.buffer;
            j6 = (j >> 24) & 255;
            byteStringBuffer5.append((byte) ((int) j6));
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else if ((j & -140737488355328L) == -140737488355328L) {
            byteStringBuffer = this.buffer;
            b2 = 6;
            byteStringBuffer.append(b2);
            byteStringBuffer3 = this.buffer;
            j4 = (j >> 40) & 255;
            b4 = (byte) ((int) j4);
            byteStringBuffer3.append(b4);
            byteStringBuffer4 = this.buffer;
            j5 = (j >> 32) & 255;
            b5 = (byte) ((int) j5);
            byteStringBuffer4.append(b5);
            byteStringBuffer5 = this.buffer;
            j6 = (j >> 24) & 255;
            byteStringBuffer5.append((byte) ((int) j6));
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else if ((j & -36028797018963968L) == -36028797018963968L) {
            byteStringBuffer2 = this.buffer;
            b3 = 7;
            byteStringBuffer2.append(b3);
            byteStringBuffer = this.buffer;
            j2 = (j >> 48) & 255;
            b2 = (byte) ((int) j2);
            byteStringBuffer.append(b2);
            byteStringBuffer3 = this.buffer;
            j4 = (j >> 40) & 255;
            b4 = (byte) ((int) j4);
            byteStringBuffer3.append(b4);
            byteStringBuffer4 = this.buffer;
            j5 = (j >> 32) & 255;
            b5 = (byte) ((int) j5);
            byteStringBuffer4.append(b5);
            byteStringBuffer5 = this.buffer;
            j6 = (j >> 24) & 255;
            byteStringBuffer5.append((byte) ((int) j6));
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        } else {
            this.buffer.append((byte) 8);
            byteStringBuffer2 = this.buffer;
            j3 = (j >> 56) & 255;
            b3 = (byte) ((int) j3);
            byteStringBuffer2.append(b3);
            byteStringBuffer = this.buffer;
            j2 = (j >> 48) & 255;
            b2 = (byte) ((int) j2);
            byteStringBuffer.append(b2);
            byteStringBuffer3 = this.buffer;
            j4 = (j >> 40) & 255;
            b4 = (byte) ((int) j4);
            byteStringBuffer3.append(b4);
            byteStringBuffer4 = this.buffer;
            j5 = (j >> 32) & 255;
            b5 = (byte) ((int) j5);
            byteStringBuffer4.append(b5);
            byteStringBuffer5 = this.buffer;
            j6 = (j >> 24) & 255;
            byteStringBuffer5.append((byte) ((int) j6));
            byteStringBuffer6 = this.buffer;
            j7 = (j >> 16) & 255;
            b7 = (byte) ((int) j7);
            byteStringBuffer6.append(b7);
            byteStringBuffer7 = this.buffer;
            j8 = (j >> 8) & 255;
            byteStringBuffer7.append((byte) ((int) j8));
        }
        byteStringBuffer8 = this.buffer;
        b6 = (byte) ((int) (j & 255));
        byteStringBuffer8.append(b6);
    }

    public void addInteger(int i) {
        addInteger((byte) 2, i);
    }

    public void addInteger(long j) {
        addInteger((byte) 2, j);
    }

    public void addNull() {
        addNull((byte) 5);
    }

    public void addNull(byte b) {
        this.buffer.append(b);
        this.buffer.append((byte) 0);
    }

    public void addOctetString() {
        addOctetString((byte) 4);
    }

    public void addOctetString(byte b) {
        this.buffer.append(b);
        this.buffer.append((byte) 0);
    }

    public void addOctetString(byte b, CharSequence charSequence) {
        if (charSequence == null) {
            addOctetString(b);
        } else {
            addOctetString(b, charSequence.toString());
        }
    }

    public void addOctetString(byte b, String str) {
        this.buffer.append(b);
        if (str == null) {
            this.buffer.append((byte) 0);
            return;
        }
        int length = this.buffer.length();
        ASN1Element.encodeLengthTo(str.length(), this.buffer);
        int length2 = this.buffer.length();
        this.buffer.append((CharSequence) str);
        if (this.buffer.length() != str.length() + length2) {
            byte[] bArr = new byte[(this.buffer.length() - length2)];
            System.arraycopy(this.buffer.getBackingArray(), length2, bArr, 0, bArr.length);
            this.buffer.setLength(length);
            ASN1Element.encodeLengthTo(bArr.length, this.buffer);
            this.buffer.append(bArr);
        }
    }

    public void addOctetString(byte b, byte[] bArr) {
        this.buffer.append(b);
        if (bArr == null) {
            this.buffer.append((byte) 0);
            return;
        }
        ASN1Element.encodeLengthTo(bArr.length, this.buffer);
        this.buffer.append(bArr);
    }

    public void addOctetString(CharSequence charSequence) {
        if (charSequence == null) {
            addOctetString((byte) 4);
        } else {
            addOctetString((byte) 4, charSequence.toString());
        }
    }

    public void addOctetString(String str) {
        addOctetString((byte) 4, str);
    }

    public void addOctetString(byte[] bArr) {
        addOctetString((byte) 4, bArr);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.buffer.getBackingArray(), 0, this.buffer.length());
    }

    public ASN1BufferSequence beginSequence() {
        return beginSequence(ASN1Constants.UNIVERSAL_SEQUENCE_TYPE);
    }

    public ASN1BufferSequence beginSequence(byte b) {
        this.buffer.append(b);
        return new ASN1BufferSequence(this);
    }

    public ASN1BufferSet beginSet() {
        return beginSet(ASN1Constants.UNIVERSAL_SET_TYPE);
    }

    public ASN1BufferSet beginSet(byte b) {
        this.buffer.append(b);
        return new ASN1BufferSet(this);
    }

    public void clear() {
        int i;
        this.buffer.clear(this.zeroBufferOnClear.getAndSet(false));
        if (this.maxBufferSize > 0 && this.buffer.capacity() > (i = this.maxBufferSize)) {
            this.buffer.setCapacity(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void endSequenceOrSet(int i) {
        int length = this.buffer.length() - i;
        if (length == 0) {
            this.buffer.append((byte) 0);
        } else if ((length & CertificateBody.profileType) == length) {
            this.buffer.insert(i, (byte) length);
        } else {
            int i2 = length & 255;
            if (i2 == length) {
                this.buffer.insert(i, MULTIBYTE_LENGTH_HEADER_PLUS_ONE);
                this.buffer.getBackingArray()[i + 1] = (byte) i2;
            } else if ((65535 & length) == length) {
                this.buffer.insert(i, MULTIBYTE_LENGTH_HEADER_PLUS_TWO);
                byte[] backingArray = this.buffer.getBackingArray();
                backingArray[i + 1] = (byte) ((length >> 8) & 255);
                backingArray[i + 2] = (byte) i2;
            } else if ((16777215 & length) == length) {
                this.buffer.insert(i, MULTIBYTE_LENGTH_HEADER_PLUS_THREE);
                byte[] backingArray2 = this.buffer.getBackingArray();
                backingArray2[i + 1] = (byte) ((length >> 16) & 255);
                backingArray2[i + 2] = (byte) ((length >> 8) & 255);
                backingArray2[i + 3] = (byte) i2;
            } else {
                this.buffer.insert(i, MULTIBYTE_LENGTH_HEADER_PLUS_FOUR);
                byte[] backingArray3 = this.buffer.getBackingArray();
                backingArray3[i + 1] = (byte) ((length >> 24) & 255);
                backingArray3[i + 2] = (byte) ((length >> 16) & 255);
                backingArray3[i + 3] = (byte) ((length >> 8) & 255);
                backingArray3[i + 4] = (byte) i2;
            }
        }
    }

    public int length() {
        return this.buffer.length();
    }

    public void setZeroBufferOnClear() {
        this.zeroBufferOnClear.set(true);
    }

    public byte[] toByteArray() {
        return this.buffer.toByteArray();
    }

    public void writeTo(OutputStream outputStream) {
        if (Debug.debugEnabled(DebugType.ASN1)) {
            Debug.debugASN1Write(this);
        }
        this.buffer.write(outputStream);
    }

    public boolean zeroBufferOnClear() {
        return this.zeroBufferOnClear.get();
    }
}
