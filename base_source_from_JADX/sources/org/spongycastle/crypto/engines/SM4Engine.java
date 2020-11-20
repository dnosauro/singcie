package org.spongycastle.crypto.engines;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.Pack;

public class SM4Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: CK */
    private static final int[] f7716CK = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    /* renamed from: FK */
    private static final int[] f7717FK = {-1548633402, 1453994832, 1736282519, -1301273892};
    private static final byte[] Sbox = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, 63, Filter.FILTER_TYPE_LESS_OR_EQUAL, 71, 7, -89, -4, -13, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 23, -70, -125, 89, 60, 25, -26, -123, 79, Filter.FILTER_TYPE_APPROXIMATE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -127, -78, 113, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -38, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 88, -47, Filter.FILTER_TYPE_NOT, 37, 34, 124, 59, 1, 33, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 21, Filter.FILTER_TYPE_OR, -32, -82, 93, Filter.FILTER_TYPE_SUBSTRING, -101, 52, 26, 85, -83, -109, 50, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -11, -116, -79, -29, 29, -10, -30, 46, MatchingRule.SUBSTRING_TYPE_SUBFINAL, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -54, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -64, 41, 35, -85, 13, 83, 78, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 91, 81, -115, 27, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, Byte.MAX_VALUE, 17, -39, 92, 65, 31, Tnaf.POW_2_WIDTH, 90, -40, 10, -63, ASN1Constants.UNIVERSAL_SET_TYPE, -120, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -105, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 12, -106, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 126, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -71, -15, 9, -59, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: X */
    private final int[] f7718X = new int[4];

    /* renamed from: rk */
    private int[] f7719rk;

    /* renamed from: F0 */
    private int m9206F0(int[] iArr, int i) {
        return m9212T((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i) ^ iArr[0];
    }

    /* renamed from: F1 */
    private int m9207F1(int[] iArr, int i) {
        return m9212T((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i) ^ iArr[1];
    }

    /* renamed from: F2 */
    private int m9208F2(int[] iArr, int i) {
        return m9212T((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i) ^ iArr[2];
    }

    /* renamed from: F3 */
    private int m9209F3(int[] iArr, int i) {
        return m9212T((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i) ^ iArr[3];
    }

    /* renamed from: L */
    private int m9210L(int i) {
        return rotateLeft(i, 24) ^ (((rotateLeft(i, 2) ^ i) ^ rotateLeft(i, 10)) ^ rotateLeft(i, 18));
    }

    private int L_ap(int i) {
        return rotateLeft(i, 23) ^ (rotateLeft(i, 13) ^ i);
    }

    /* renamed from: R */
    private void m9211R(int[] iArr, int i) {
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 3;
        iArr[i] = iArr[i] ^ iArr[i4];
        iArr[i4] = iArr[i] ^ iArr[i4];
        iArr[i] = iArr[i4] ^ iArr[i];
        iArr[i2] = iArr[i2] ^ iArr[i3];
        iArr[i3] = iArr[i2] ^ iArr[i3];
        iArr[i2] = iArr[i2] ^ iArr[i3];
    }

    /* renamed from: T */
    private int m9212T(int i) {
        return m9210L(tau(i));
    }

    private int T_ap(int i) {
        return L_ap(tau(i));
    }

    private int[] expandKey(boolean z, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {Pack.bigEndianToInt(bArr, 0), Pack.bigEndianToInt(bArr, 4), Pack.bigEndianToInt(bArr, 8), Pack.bigEndianToInt(bArr, 12)};
        int i = iArr2[0];
        int[] iArr3 = f7717FK;
        int[] iArr4 = {i ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z) {
            iArr[0] = iArr4[0] ^ T_ap(((iArr4[1] ^ iArr4[2]) ^ iArr4[3]) ^ f7716CK[0]);
            iArr[1] = iArr4[1] ^ T_ap(((iArr4[2] ^ iArr4[3]) ^ iArr[0]) ^ f7716CK[1]);
            iArr[2] = iArr4[2] ^ T_ap(((iArr4[3] ^ iArr[0]) ^ iArr[1]) ^ f7716CK[2]);
            iArr[3] = iArr4[3] ^ T_ap(((iArr[0] ^ iArr[1]) ^ iArr[2]) ^ f7716CK[3]);
            for (int i2 = 4; i2 < 32; i2++) {
                iArr[i2] = iArr[i2 - 4] ^ T_ap(((iArr[i2 - 3] ^ iArr[i2 - 2]) ^ iArr[i2 - 1]) ^ f7716CK[i2]);
            }
        } else {
            iArr[31] = iArr4[0] ^ T_ap(((iArr4[1] ^ iArr4[2]) ^ iArr4[3]) ^ f7716CK[0]);
            iArr[30] = iArr4[1] ^ T_ap(((iArr4[2] ^ iArr4[3]) ^ iArr[31]) ^ f7716CK[1]);
            iArr[29] = iArr4[2] ^ T_ap(((iArr4[3] ^ iArr[31]) ^ iArr[30]) ^ f7716CK[2]);
            iArr[28] = iArr4[3] ^ T_ap(((iArr[30] ^ iArr[31]) ^ iArr[29]) ^ f7716CK[3]);
            for (int i3 = 27; i3 >= 0; i3--) {
                iArr[i3] = iArr[i3 + 4] ^ T_ap(((iArr[i3 + 3] ^ iArr[i3 + 2]) ^ iArr[i3 + 1]) ^ f7716CK[31 - i3]);
            }
        }
        return iArr;
    }

    private int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private int tau(int i) {
        byte[] bArr = Sbox;
        return (bArr[i & 255] & 255) | ((bArr[(i >> 24) & 255] & 255) << 24) | ((bArr[(i >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[(i >> 8) & 255] & 255) << 8);
    }

    public String getAlgorithmName() {
        return "SM4";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.f7719rk = expandKey(z, key);
                return;
            }
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f7719rk == null) {
            throw new IllegalStateException("SM4 not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            this.f7718X[0] = Pack.bigEndianToInt(bArr, i);
            this.f7718X[1] = Pack.bigEndianToInt(bArr, i + 4);
            this.f7718X[2] = Pack.bigEndianToInt(bArr, i + 8);
            this.f7718X[3] = Pack.bigEndianToInt(bArr, i + 12);
            for (int i3 = 0; i3 < 32; i3 += 4) {
                int[] iArr = this.f7718X;
                iArr[0] = m9206F0(iArr, this.f7719rk[i3]);
                int[] iArr2 = this.f7718X;
                iArr2[1] = m9207F1(iArr2, this.f7719rk[i3 + 1]);
                int[] iArr3 = this.f7718X;
                iArr3[2] = m9208F2(iArr3, this.f7719rk[i3 + 2]);
                int[] iArr4 = this.f7718X;
                iArr4[3] = m9209F3(iArr4, this.f7719rk[i3 + 3]);
            }
            m9211R(this.f7718X, 0);
            Pack.intToBigEndian(this.f7718X[0], bArr2, i2);
            Pack.intToBigEndian(this.f7718X[1], bArr2, i2 + 4);
            Pack.intToBigEndian(this.f7718X[2], bArr2, i2 + 8);
            Pack.intToBigEndian(this.f7718X[3], bArr2, i2 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
