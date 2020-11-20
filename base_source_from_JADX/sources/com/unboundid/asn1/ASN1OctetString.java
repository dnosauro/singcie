package com.unboundid.asn1;

import com.unboundid.util.ByteString;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;

public final class ASN1OctetString extends ASN1Element implements ByteString {
    private static final long serialVersionUID = -7857753188341295516L;
    private int length;
    private int offset;
    private String stringValue;
    private byte[] valueBytes;
    private volatile byte[] valueBytesGuard;

    public ASN1OctetString() {
        super((byte) 4);
        this.valueBytes = StaticUtils.NO_BYTES;
        this.stringValue = "";
        this.offset = 0;
        this.length = 0;
    }

    public ASN1OctetString(byte b) {
        super(b);
        this.valueBytes = StaticUtils.NO_BYTES;
        this.stringValue = "";
        this.offset = 0;
        this.length = 0;
    }

    public ASN1OctetString(byte b, String str) {
        super(b);
        int i;
        if (str == null) {
            this.valueBytes = StaticUtils.NO_BYTES;
            this.stringValue = "";
            i = 0;
        } else {
            this.valueBytes = null;
            this.stringValue = str;
            i = -1;
        }
        this.offset = i;
        this.length = i;
    }

    public ASN1OctetString(byte b, byte[] bArr) {
        super(b);
        int i = 0;
        if (bArr == null) {
            this.valueBytes = StaticUtils.NO_BYTES;
            this.stringValue = "";
            this.offset = 0;
        } else {
            this.valueBytes = bArr;
            this.stringValue = null;
            this.offset = 0;
            i = bArr.length;
        }
        this.length = i;
    }

    public ASN1OctetString(byte b, byte[] bArr, int i, int i2) {
        super(b);
        Validator.ensureTrue(i >= 0 && i2 >= 0 && i + i2 <= bArr.length);
        this.valueBytes = bArr;
        this.stringValue = null;
        this.offset = i;
        this.length = i2;
    }

    public ASN1OctetString(String str) {
        super((byte) 4);
        int i;
        if (str == null) {
            this.valueBytes = StaticUtils.NO_BYTES;
            this.stringValue = "";
            i = 0;
        } else {
            this.valueBytes = null;
            this.stringValue = str;
            i = -1;
        }
        this.offset = i;
        this.length = i;
    }

    public ASN1OctetString(byte[] bArr) {
        super((byte) 4);
        if (bArr == null) {
            this.valueBytes = StaticUtils.NO_BYTES;
            this.stringValue = "";
            this.offset = 0;
            this.length = 0;
            return;
        }
        this.valueBytes = bArr;
        this.stringValue = null;
        this.offset = 0;
        this.length = bArr.length;
    }

    public ASN1OctetString(byte[] bArr, int i, int i2) {
        super((byte) 4);
        Validator.ensureNotNull(bArr);
        Validator.ensureTrue(i >= 0 && i2 >= 0 && i + i2 <= bArr.length);
        this.valueBytes = bArr;
        this.stringValue = null;
        this.offset = i;
        this.length = i2;
    }

    public static ASN1OctetString decodeAsOctetString(ASN1Element aSN1Element) {
        return new ASN1OctetString(aSN1Element.getType(), aSN1Element.getValue());
    }

    public static ASN1OctetString decodeAsOctetString(byte[] bArr) {
        int i;
        try {
            byte b = bArr[1] & Byte.MAX_VALUE;
            if (b != bArr[1]) {
                int i2 = 0;
                i = 2;
                byte b2 = 0;
                while (i2 < b) {
                    b2 = (b2 << 8) | (bArr[i] & 255);
                    i2++;
                    i++;
                }
                b = b2;
            } else {
                i = 2;
            }
            if (bArr.length - i == b) {
                return new ASN1OctetString(bArr[0], bArr, i, b);
            }
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH.get(Integer.valueOf(b), Integer.valueOf(bArr.length - i)));
        } catch (ASN1Exception e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION.get(e2), e2);
        }
    }

    public void appendValueTo(ByteStringBuffer byteStringBuffer) {
        byte[] bArr = this.valueBytes;
        if (bArr == null) {
            byteStringBuffer.append((CharSequence) this.stringValue);
        } else {
            byteStringBuffer.append(bArr, this.offset, this.length);
        }
    }

    public void encodeTo(ByteStringBuffer byteStringBuffer) {
        byteStringBuffer.append(getType());
        if (this.valueBytes == null) {
            int length2 = this.stringValue.length();
            int length3 = byteStringBuffer.length();
            encodeLengthTo(length2, byteStringBuffer);
            int length4 = byteStringBuffer.length();
            byteStringBuffer.append((CharSequence) this.stringValue);
            int length5 = byteStringBuffer.length() - length4;
            if (length5 != length2) {
                byte[] encodeLength = encodeLength(length5);
                if (encodeLength.length == length4 - length3) {
                    System.arraycopy(encodeLength, 0, byteStringBuffer.getBackingArray(), length3, encodeLength.length);
                    return;
                }
                byteStringBuffer.setLength(length3);
                byteStringBuffer.append(encodeLength);
                byteStringBuffer.append((CharSequence) this.stringValue);
                return;
            }
            return;
        }
        encodeLengthTo(this.length, byteStringBuffer);
        byteStringBuffer.append(this.valueBytes, this.offset, this.length);
    }

    public byte[] getValue() {
        byte[] bArr = this.valueBytes;
        if (bArr == null) {
            this.valueBytesGuard = StaticUtils.getBytes(this.stringValue);
            this.offset = 0;
            this.length = this.valueBytesGuard.length;
        } else {
            if (!(this.offset == 0 && this.length == bArr.length)) {
                int i = this.length;
                byte[] bArr2 = new byte[i];
                System.arraycopy(this.valueBytes, this.offset, bArr2, 0, i);
                this.offset = 0;
                this.valueBytesGuard = bArr2;
            }
            return this.valueBytes;
        }
        this.valueBytes = this.valueBytesGuard;
        return this.valueBytes;
    }

    /* access modifiers changed from: package-private */
    public byte[] getValueArray() {
        return getValue();
    }

    public int getValueLength() {
        return getValue().length;
    }

    /* access modifiers changed from: package-private */
    public int getValueOffset() {
        return 0;
    }

    public String stringValue() {
        if (this.stringValue == null) {
            int i = this.length;
            this.stringValue = i == 0 ? "" : StaticUtils.toUTF8String(this.valueBytes, this.offset, i);
        }
        return this.stringValue;
    }

    public ASN1OctetString toASN1OctetString() {
        return this;
    }

    public void toString(StringBuilder sb) {
        sb.append(stringValue());
    }
}
