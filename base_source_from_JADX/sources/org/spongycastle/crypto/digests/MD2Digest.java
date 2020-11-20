package org.spongycastle.crypto.digests;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.Memoable;

public class MD2Digest implements ExtendedDigest, Memoable {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: S */
    private static final byte[] f7527S = {41, 46, 67, -55, Filter.FILTER_TYPE_NOT, -40, 124, 1, 61, 54, 84, Filter.FILTER_TYPE_OR, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -116, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -54, 30, -101, 87, 60, -3, -44, -32, 22, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 24, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 23, -27, 18, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -111, 21, -78, 7, 63, -108, -62, Tnaf.POW_2_WIDTH, -119, 11, 34, 95, 33, Byte.MIN_VALUE, Byte.MAX_VALUE, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -77, 72, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, Filter.FILTER_TYPE_SUBSTRING, 125, -74, 118, -4, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -30, -100, 116, 4, -15, 69, -99, 112, 89, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 113, -121, 32, -122, 91, -49, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -26, 45, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 2, 27, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 37, -83, -82, -80, -71, -10, 28, 70, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, 13, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -63, -85, -6, 36, -31, 123, 8, 12, -67, -79, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -120, -107, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -29, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -24, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 88, -48, -28, Filter.FILTER_TYPE_LESS_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 114, -8, -21, 117, 75, 10, ASN1Constants.UNIVERSAL_SET_TYPE, 68, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20};

    /* renamed from: C */
    private byte[] f7528C = new byte[16];
    private int COff;

    /* renamed from: M */
    private byte[] f7529M = new byte[16];

    /* renamed from: X */
    private byte[] f7530X = new byte[48];
    private int mOff;
    private int xOff;

    public MD2Digest() {
        reset();
    }

    public MD2Digest(MD2Digest mD2Digest) {
        copyIn(mD2Digest);
    }

    private void copyIn(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.f7530X;
        System.arraycopy(bArr, 0, this.f7530X, 0, bArr.length);
        this.xOff = mD2Digest.xOff;
        byte[] bArr2 = mD2Digest.f7529M;
        System.arraycopy(bArr2, 0, this.f7529M, 0, bArr2.length);
        this.mOff = mD2Digest.mOff;
        byte[] bArr3 = mD2Digest.f7528C;
        System.arraycopy(bArr3, 0, this.f7528C, 0, bArr3.length);
        this.COff = mD2Digest.COff;
    }

    public Memoable copy() {
        return new MD2Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        int length = this.f7529M.length;
        int i2 = this.mOff;
        byte b = (byte) (length - i2);
        while (true) {
            byte[] bArr2 = this.f7529M;
            if (i2 < bArr2.length) {
                bArr2[i2] = b;
                i2++;
            } else {
                processCheckSum(bArr2);
                processBlock(this.f7529M);
                processBlock(this.f7528C);
                System.arraycopy(this.f7530X, this.xOff, bArr, i, 16);
                reset();
                return 16;
            }
        }
    }

    public String getAlgorithmName() {
        return "MD2";
    }

    public int getByteLength() {
        return 16;
    }

    public int getDigestSize() {
        return 16;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processBlock(byte[] r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 16
            if (r1 >= r2) goto L_0x001b
            byte[] r2 = r6.f7530X
            int r3 = r1 + 16
            byte r4 = r7[r1]
            r2[r3] = r4
            int r3 = r1 + 32
            byte r4 = r7[r1]
            byte r5 = r2[r1]
            r4 = r4 ^ r5
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 1
            goto L_0x0002
        L_0x001b:
            r7 = 0
            r1 = 0
        L_0x001d:
            r2 = 18
            if (r7 >= r2) goto L_0x003e
            r2 = r1
            r1 = 0
        L_0x0023:
            r3 = 48
            if (r1 >= r3) goto L_0x0038
            byte[] r3 = r6.f7530X
            byte r4 = r3[r1]
            byte[] r5 = f7527S
            byte r2 = r5[r2]
            r2 = r2 ^ r4
            byte r2 = (byte) r2
            r3[r1] = r2
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r1 = r1 + 1
            goto L_0x0023
        L_0x0038:
            int r2 = r2 + r7
            int r1 = r2 % 256
            int r7 = r7 + 1
            goto L_0x001d
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.digests.MD2Digest.processBlock(byte[]):void");
    }

    /* access modifiers changed from: protected */
    public void processCheckSum(byte[] bArr) {
        byte b = this.f7528C[15];
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.f7528C;
            bArr2[i] = (byte) (f7527S[(b ^ bArr[i]) & 255] ^ bArr2[i]);
            b = bArr2[i];
        }
    }

    public void reset() {
        this.xOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f7530X;
            if (i == bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.mOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f7529M;
            if (i2 == bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        this.COff = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f7528C;
            if (i3 != bArr3.length) {
                bArr3[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((MD2Digest) memoable);
    }

    public void update(byte b) {
        byte[] bArr = this.f7529M;
        int i = this.mOff;
        this.mOff = i + 1;
        bArr[i] = b;
        if (this.mOff == 16) {
            processCheckSum(bArr);
            processBlock(this.f7529M);
            this.mOff = 0;
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.mOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > 16) {
            System.arraycopy(bArr, i, this.f7529M, 0, 16);
            processCheckSum(this.f7529M);
            processBlock(this.f7529M);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
