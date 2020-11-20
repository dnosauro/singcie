package com.unboundid.asn1;

import com.unboundid.util.Debug;

public final class ASN1Boolean extends ASN1Element {
    public static final ASN1Boolean UNIVERSAL_BOOLEAN_FALSE_ELEMENT = new ASN1Boolean(false);
    public static final ASN1Boolean UNIVERSAL_BOOLEAN_TRUE_ELEMENT = new ASN1Boolean(true);
    private static final long serialVersionUID = 7131700816847855524L;
    private final boolean booleanValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ASN1Boolean(byte b, boolean z) {
        super(b, z ? ASN1Constants.BOOLEAN_VALUE_TRUE : ASN1Constants.BOOLEAN_VALUE_FALSE);
        this.booleanValue = z;
    }

    private ASN1Boolean(byte b, boolean z, byte[] bArr) {
        super(b, bArr);
        this.booleanValue = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ASN1Boolean(boolean z) {
        super((byte) 1, z ? ASN1Constants.BOOLEAN_VALUE_TRUE : ASN1Constants.BOOLEAN_VALUE_FALSE);
        this.booleanValue = z;
    }

    public static ASN1Boolean decodeAsBoolean(ASN1Element aSN1Element) {
        byte[] value = aSN1Element.getValue();
        if (value.length == 1) {
            return value[0] == 0 ? new ASN1Boolean(aSN1Element.getType(), false, value) : new ASN1Boolean(aSN1Element.getType(), true, value);
        }
        throw new ASN1Exception(ASN1Messages.ERR_BOOLEAN_INVALID_LENGTH.get());
    }

    public static ASN1Boolean decodeAsBoolean(byte[] bArr) {
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
            if (bArr.length - i != b) {
                throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH.get(Integer.valueOf(b), Integer.valueOf(bArr.length - i)));
            } else if (b == 1) {
                byte[] bArr2 = {bArr[i]};
                return new ASN1Boolean(bArr[0], bArr2[0] != 0, bArr2);
            } else {
                throw new ASN1Exception(ASN1Messages.ERR_BOOLEAN_INVALID_LENGTH.get());
            }
        } catch (ASN1Exception e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION.get(e2), e2);
        }
    }

    public boolean booleanValue() {
        return this.booleanValue;
    }

    public void toString(StringBuilder sb) {
        sb.append(this.booleanValue);
    }
}
