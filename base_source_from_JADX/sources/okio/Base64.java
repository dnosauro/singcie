package okio;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.UnsupportedEncodingException;

final class Base64 {
    private static final byte[] MAP = {65, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 67, 68, 69, 70, 71, 72, 73, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 75, 76, 77, 78, 79, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 98, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 106, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 112, 113, 114, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 116, 117, 118, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 122, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SET_TYPE, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 67, 68, 69, 70, 71, 72, 73, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 75, 76, 77, 78, 79, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 98, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 106, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 112, 113, 114, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 116, 117, 118, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 122, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SET_TYPE, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i;
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        byte[] bArr = new byte[((int) ((((long) length) * 6) / 8))];
        int i2 = 0;
        byte b = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= 'A' && charAt <= 'Z') {
                i = charAt - 'A';
            } else if (charAt >= 'a' && charAt <= 'z') {
                i = charAt - 'G';
            } else if (charAt >= '0' && charAt <= '9') {
                i = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i = 62;
            } else if (charAt == '/' || charAt == '_') {
                i = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            b = (b << 6) | ((byte) i);
            i2++;
            if (i2 % 4 == 0) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (b >> Tnaf.POW_2_WIDTH);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (b >> 8);
                bArr[i6] = (byte) b;
                i3 = i6 + 1;
            }
        }
        int i7 = i2 % 4;
        if (i7 == 1) {
            return null;
        }
        if (i7 == 2) {
            bArr[i3] = (byte) ((b << 12) >> 16);
            i3++;
        } else if (i7 == 3) {
            int i8 = b << 6;
            int i9 = i3 + 1;
            bArr[i3] = (byte) (i8 >> 16);
            i3 = i9 + 1;
            bArr[i9] = (byte) (i8 >> 8);
        }
        if (i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        switch (bArr.length % 3) {
            case 1:
                int i8 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i9 = i8 + 1;
                bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i9] = 61;
                bArr3[i9 + 1] = 61;
                break;
            case 2:
                int i10 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i11 = i10 + 1;
                int i12 = length + 1;
                bArr3[i10] = bArr2[((bArr[length] & 3) << 4) | ((bArr[i12] & 255) >> 4)];
                bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
                bArr3[i11 + 1] = 61;
                break;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }
}
