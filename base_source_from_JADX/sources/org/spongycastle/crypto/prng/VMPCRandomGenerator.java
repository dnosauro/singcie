package org.spongycastle.crypto.prng;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.Pack;

public class VMPCRandomGenerator implements RandomGenerator {

    /* renamed from: P */
    private byte[] f7892P = {-69, 44, 98, Byte.MAX_VALUE, -75, -86, -44, 13, -127, -2, -78, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -53, -96, Filter.FILTER_TYPE_OR, 8, 24, 113, 86, -24, 73, 2, Tnaf.POW_2_WIDTH, -60, -34, 53, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -20, Byte.MIN_VALUE, 18, -72, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -38, 47, 117, -52, Filter.FILTER_TYPE_NOT, 9, 54, 3, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 45, -3, -32, -35, 5, 67, -112, -83, -56, -31, -81, 87, -101, 76, -40, 81, -82, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -123, 60, 10, -28, -13, -100, 38, 35, 83, -55, -125, -105, 70, -79, -103, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, ASN1Constants.UNIVERSAL_SET_TYPE, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -43, 29, -42, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -67, 94, -80, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 34, 56, -8, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 43, 42, -59, -45, -9, PSSSigner.TRAILER_IMPLICIT, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -33, 4, -27, -107, 62, 37, -122, Filter.FILTER_TYPE_LESS_OR_EQUAL, 11, -113, -15, 36, 14, -41, 64, -77, -49, 126, 6, 21, -102, 77, 28, -93, -37, 50, -110, 88, 17, 39, -12, 89, -48, 78, 106, 23, 91, -84, -1, 7, -64, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -4, -57, -51, 118, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 93, -25, 58, 52, 122, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 40, 15, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 1, -7, -47, -46, 25, -23, -111, -71, 90, -19, 65, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -76, -61, -98, -65, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -6, 31, 51, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 71, -119, -16, -106, 26, 95, -109, 61, 55, 75, -39, Filter.FILTER_TYPE_APPROXIMATE_MATCH, -63, 27, -10, 57, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -73, 12, 32, -50, -120, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -74, 116, -114, -115, 22, 41, -14, -121, -11, -21, 112, -29, -5, 85, -97, -58, 68, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 69, 125, -30, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, 92, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -116, -18, -124, 19, -89, 30, -99, -36, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 72, -70, 46, -26, Filter.FILTER_TYPE_SUBSTRING, -85, 124, -108, 0, 33, -17, -22, -66, -54, 114, 79, 82, -104, 63, -62, 20, 123, 59, 84};

    /* renamed from: n */
    private byte f7893n = 0;

    /* renamed from: s */
    private byte f7894s = -66;

    public void addSeedMaterial(long j) {
        addSeedMaterial(Pack.longToBigEndian(j));
    }

    public void addSeedMaterial(byte[] bArr) {
        for (byte b : bArr) {
            byte[] bArr2 = this.f7892P;
            byte b2 = this.f7894s;
            byte b3 = this.f7893n;
            this.f7894s = bArr2[(b2 + bArr2[b3 & 255] + b) & 255];
            byte b4 = bArr2[b3 & 255];
            byte b5 = this.f7894s;
            bArr2[b3 & 255] = bArr2[b5 & 255];
            bArr2[b5 & 255] = b4;
            this.f7893n = (byte) ((b3 + 1) & 255);
        }
    }

    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    public void nextBytes(byte[] bArr, int i, int i2) {
        synchronized (this.f7892P) {
            int i3 = i2 + i;
            while (i != i3) {
                this.f7894s = this.f7892P[(this.f7894s + this.f7892P[this.f7893n & 255]) & 255];
                bArr[i] = this.f7892P[(this.f7892P[this.f7892P[this.f7894s & 255] & 255] + 1) & 255];
                byte b = this.f7892P[this.f7893n & 255];
                this.f7892P[this.f7893n & 255] = this.f7892P[this.f7894s & 255];
                this.f7892P[this.f7894s & 255] = b;
                this.f7893n = (byte) ((this.f7893n + 1) & 255);
                i++;
            }
        }
    }
}
