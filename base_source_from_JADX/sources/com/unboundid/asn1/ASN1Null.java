package com.unboundid.asn1;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;

public final class ASN1Null extends ASN1Element {
    public static final ASN1Null UNIVERSAL_NULL_ELEMENT = new ASN1Null();
    private static final long serialVersionUID = -3264450066845549348L;

    public ASN1Null() {
        super((byte) 5);
    }

    public ASN1Null(byte b) {
        super(b);
    }

    public static ASN1Null decodeAsNull(ASN1Element aSN1Element) {
        if (aSN1Element.getValue().length == 0) {
            return new ASN1Null(aSN1Element.getType());
        }
        throw new ASN1Exception(ASN1Messages.ERR_NULL_HAS_VALUE.get());
    }

    public static ASN1Null decodeAsNull(byte[] bArr) {
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
            } else if (b == 0) {
                return new ASN1Null(bArr[0]);
            } else {
                throw new ASN1Exception(ASN1Messages.ERR_NULL_HAS_VALUE.get());
            }
        } catch (ASN1Exception e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION.get(e2), e2);
        }
    }

    public void toString(StringBuilder sb) {
        sb.append("ASN1Null(type=");
        StaticUtils.toHex(getType(), sb);
        sb.append(')');
    }
}
