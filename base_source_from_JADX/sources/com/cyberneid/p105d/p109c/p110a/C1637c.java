package com.cyberneid.p105d.p109c.p110a;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.signers.PSSSigner;

/* renamed from: com.cyberneid.d.c.a.c */
public final class C1637c extends FilterInputStream {

    /* renamed from: a */
    private static final byte[] f5414a = {0, Byte.MIN_VALUE, 64, -64, 32, -96, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -32, Tnaf.POW_2_WIDTH, -112, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -48, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -80, 112, -16, 8, -120, 72, -56, 40, Filter.FILTER_TYPE_APPROXIMATE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -24, 24, -104, 88, -40, 56, -72, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -8, 4, -124, 68, -60, 36, Filter.FILTER_TYPE_SUBSTRING, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -28, 20, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, 44, -84, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -20, 28, -100, 92, -36, 60, PSSSigner.TRAILER_IMPLICIT, 124, -4, 2, MatchingRule.SUBSTRING_TYPE_SUBFINAL, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -62, 34, Filter.FILTER_TYPE_NOT, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -54, 42, -86, 106, -22, 26, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, Filter.FILTER_TYPE_LESS_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -18, 30, -98, 94, -34, 62, -66, 126, -2, 1, -127, 65, -63, 33, Filter.FILTER_TYPE_OR, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, -31, 17, -111, 81, -47, ASN1Constants.UNIVERSAL_SET_TYPE, -79, 113, -15, 9, -119, 73, -55, 41, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -23, 25, -103, 89, -39, 57, -71, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -7, 5, -123, 69, -59, 37, Filter.FILTER_TYPE_GREATER_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -29, 19, -109, 83, -45, 51, -77, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -13, 11, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, 75, -53, 43, -85, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -21, 27, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -25, 23, -105, 87, -41, 55, -73, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -9, 15, -113, 79, -49, 47, -81, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -17, 31, -97, 95, -33, 63, -65, Byte.MAX_VALUE, -1};

    public C1637c(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        int read = super.read();
        return read < 0 ? read : f5414a[read] & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            int i3 = i + read;
            while (i < i3) {
                bArr[i] = f5414a[bArr[i] & 255];
                i++;
            }
        }
        return read;
    }
}
