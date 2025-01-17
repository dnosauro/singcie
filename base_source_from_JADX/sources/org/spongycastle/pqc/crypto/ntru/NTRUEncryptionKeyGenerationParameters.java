package org.spongycastle.pqc.crypto.ntru;

import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class NTRUEncryptionKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public static final NTRUEncryptionKeyGenerationParameters APR2011_439 = new NTRUEncryptionKeyGenerationParameters(439, 2048, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 130, 128, 9, 32, 9, true, new byte[]{0, 7, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE}, true, false, new SHA256Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_439_FAST = new NTRUEncryptionKeyGenerationParameters(439, 2048, 9, 8, 5, 130, 128, 9, 32, 9, true, new byte[]{0, 7, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE}, true, true, new SHA256Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_743 = new NTRUEncryptionKeyGenerationParameters(743, 2048, 248, 220, 256, 10, 27, 14, true, new byte[]{0, 7, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE}, false, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_743_FAST = new NTRUEncryptionKeyGenerationParameters(743, 2048, 11, 11, 15, 220, 256, 10, 27, 14, true, new byte[]{0, 7, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE}, false, true, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters EES1087EP2 = new NTRUEncryptionKeyGenerationParameters(1087, 2048, 120, 120, 256, 13, 25, 14, true, new byte[]{0, 6, 3}, true, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters EES1171EP1 = new NTRUEncryptionKeyGenerationParameters(1171, 2048, 106, 106, 256, 13, 20, 15, true, new byte[]{0, 6, 4}, true, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters EES1499EP1 = new NTRUEncryptionKeyGenerationParameters(1499, 2048, 79, 79, 256, 13, 17, 19, true, new byte[]{0, 6, 5}, true, false, new SHA512Digest());

    /* renamed from: N */
    public int f8171N;
    public int bufferLenBits;
    int bufferLenTrits;

    /* renamed from: c */
    public int f8172c;

    /* renamed from: db */
    public int f8173db;

    /* renamed from: df */
    public int f8174df;
    public int df1;
    public int df2;
    public int df3;

    /* renamed from: dg */
    public int f8175dg;
    public int dm0;

    /* renamed from: dr */
    public int f8176dr;
    public int dr1;
    public int dr2;
    public int dr3;
    public boolean fastFp;
    public Digest hashAlg;
    public boolean hashSeed;
    int llen;
    public int maxMsgLenBytes;
    public int minCallsMask;
    public int minCallsR;
    public byte[] oid;
    public int pkLen;
    public int polyType;

    /* renamed from: q */
    public int f8177q;
    public boolean sparse;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(new SecureRandom(), i7);
        this.f8171N = i;
        this.f8177q = i2;
        this.df1 = i3;
        this.df2 = i4;
        this.df3 = i5;
        this.f8173db = i7;
        this.dm0 = i6;
        this.f8172c = i8;
        this.minCallsR = i9;
        this.minCallsMask = i10;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 1;
        this.hashAlg = digest;
        init();
    }

    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(new SecureRandom(), i5);
        this.f8171N = i;
        this.f8177q = i2;
        this.f8174df = i3;
        this.f8173db = i5;
        this.dm0 = i4;
        this.f8172c = i6;
        this.minCallsR = i7;
        this.minCallsMask = i8;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 0;
        this.hashAlg = digest;
        init();
    }

    public NTRUEncryptionKeyGenerationParameters(InputStream inputStream) {
        super(new SecureRandom(), -1);
        Digest sHA256Digest;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f8171N = dataInputStream.readInt();
        this.f8177q = dataInputStream.readInt();
        this.f8174df = dataInputStream.readInt();
        this.df1 = dataInputStream.readInt();
        this.df2 = dataInputStream.readInt();
        this.df3 = dataInputStream.readInt();
        this.f8173db = dataInputStream.readInt();
        this.dm0 = dataInputStream.readInt();
        this.f8172c = dataInputStream.readInt();
        this.minCallsR = dataInputStream.readInt();
        this.minCallsMask = dataInputStream.readInt();
        this.hashSeed = dataInputStream.readBoolean();
        this.oid = new byte[3];
        dataInputStream.readFully(this.oid);
        this.sparse = dataInputStream.readBoolean();
        this.fastFp = dataInputStream.readBoolean();
        this.polyType = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if (McElieceCCA2KeyGenParameterSpec.SHA512.equals(readUTF)) {
            new SHA512Digest();
        } else {
            sHA256Digest = McElieceCCA2KeyGenParameterSpec.SHA256.equals(readUTF) ? new SHA256Digest() : sHA256Digest;
            init();
        }
        this.hashAlg = sHA256Digest;
        init();
    }

    private void init() {
        this.f8176dr = this.f8174df;
        this.dr1 = this.df1;
        this.dr2 = this.df2;
        this.dr3 = this.df3;
        int i = this.f8171N;
        this.f8175dg = i / 3;
        this.llen = 1;
        int i2 = (((i * 3) / 2) / 8) - this.llen;
        int i3 = this.f8173db;
        this.maxMsgLenBytes = (i2 - (i3 / 8)) - 1;
        this.bufferLenBits = (((((i * 3) / 2) + 7) / 8) * 8) + 1;
        this.bufferLenTrits = i - 1;
        this.pkLen = i3;
    }

    public NTRUEncryptionKeyGenerationParameters clone() {
        if (this.polyType == 0) {
            return new NTRUEncryptionKeyGenerationParameters(this.f8171N, this.f8177q, this.f8174df, this.dm0, this.f8173db, this.f8172c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        int i = this.f8171N;
        int i2 = this.f8177q;
        int i3 = this.df1;
        int i4 = this.df2;
        int i5 = this.df3;
        int i6 = this.dm0;
        int i7 = this.f8173db;
        int i8 = this.f8172c;
        int i9 = this.minCallsR;
        int i10 = this.minCallsMask;
        boolean z = this.hashSeed;
        byte[] bArr = this.oid;
        return new NTRUEncryptionKeyGenerationParameters(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, z, bArr, this.sparse, this.fastFp, this.hashAlg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = (NTRUEncryptionKeyGenerationParameters) obj;
        if (this.f8171N != nTRUEncryptionKeyGenerationParameters.f8171N || this.bufferLenBits != nTRUEncryptionKeyGenerationParameters.bufferLenBits || this.bufferLenTrits != nTRUEncryptionKeyGenerationParameters.bufferLenTrits || this.f8172c != nTRUEncryptionKeyGenerationParameters.f8172c || this.f8173db != nTRUEncryptionKeyGenerationParameters.f8173db || this.f8174df != nTRUEncryptionKeyGenerationParameters.f8174df || this.df1 != nTRUEncryptionKeyGenerationParameters.df1 || this.df2 != nTRUEncryptionKeyGenerationParameters.df2 || this.df3 != nTRUEncryptionKeyGenerationParameters.df3 || this.f8175dg != nTRUEncryptionKeyGenerationParameters.f8175dg || this.dm0 != nTRUEncryptionKeyGenerationParameters.dm0 || this.f8176dr != nTRUEncryptionKeyGenerationParameters.f8176dr || this.dr1 != nTRUEncryptionKeyGenerationParameters.dr1 || this.dr2 != nTRUEncryptionKeyGenerationParameters.dr2 || this.dr3 != nTRUEncryptionKeyGenerationParameters.dr3 || this.fastFp != nTRUEncryptionKeyGenerationParameters.fastFp) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUEncryptionKeyGenerationParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUEncryptionKeyGenerationParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return this.hashSeed == nTRUEncryptionKeyGenerationParameters.hashSeed && this.llen == nTRUEncryptionKeyGenerationParameters.llen && this.maxMsgLenBytes == nTRUEncryptionKeyGenerationParameters.maxMsgLenBytes && this.minCallsMask == nTRUEncryptionKeyGenerationParameters.minCallsMask && this.minCallsR == nTRUEncryptionKeyGenerationParameters.minCallsR && Arrays.equals(this.oid, nTRUEncryptionKeyGenerationParameters.oid) && this.pkLen == nTRUEncryptionKeyGenerationParameters.pkLen && this.polyType == nTRUEncryptionKeyGenerationParameters.polyType && this.f8177q == nTRUEncryptionKeyGenerationParameters.f8177q && this.sparse == nTRUEncryptionKeyGenerationParameters.sparse;
    }

    public NTRUEncryptionParameters getEncryptionParameters() {
        if (this.polyType == 0) {
            return new NTRUEncryptionParameters(this.f8171N, this.f8177q, this.f8174df, this.dm0, this.f8173db, this.f8172c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        int i = this.f8171N;
        int i2 = this.f8177q;
        int i3 = this.df1;
        int i4 = this.df2;
        int i5 = this.df3;
        int i6 = this.dm0;
        int i7 = this.f8173db;
        int i8 = this.f8172c;
        int i9 = this.minCallsR;
        int i10 = this.minCallsMask;
        boolean z = this.hashSeed;
        byte[] bArr = this.oid;
        return new NTRUEncryptionParameters(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, z, bArr, this.sparse, this.fastFp, this.hashAlg);
    }

    public int getMaxMessageLength() {
        return this.maxMsgLenBytes;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = (((((((((((((((((((((((((((((((this.f8171N + 31) * 31) + this.bufferLenBits) * 31) + this.bufferLenTrits) * 31) + this.f8172c) * 31) + this.f8173db) * 31) + this.f8174df) * 31) + this.df1) * 31) + this.df2) * 31) + this.df3) * 31) + this.f8175dg) * 31) + this.dm0) * 31) + this.f8176dr) * 31) + this.dr1) * 31) + this.dr2) * 31) + this.dr3) * 31) + (this.fastFp ? 1231 : 1237)) * 31;
        Digest digest = this.hashAlg;
        int hashCode = (((((((((((((((((((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + (this.hashSeed ? 1231 : 1237)) * 31) + this.llen) * 31) + this.maxMsgLenBytes) * 31) + this.minCallsMask) * 31) + this.minCallsR) * 31) + Arrays.hashCode(this.oid)) * 31) + this.pkLen) * 31) + this.polyType) * 31) + this.f8177q) * 31;
        if (!this.sparse) {
            i = 1237;
        }
        return hashCode + i;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder("EncryptionParameters(N=" + this.f8171N + " q=" + this.f8177q);
        if (this.polyType == 0) {
            sb = new StringBuilder();
            sb.append(" polyType=SIMPLE df=");
            i = this.f8174df;
        } else {
            sb = new StringBuilder();
            sb.append(" polyType=PRODUCT df1=");
            sb.append(this.df1);
            sb.append(" df2=");
            sb.append(this.df2);
            sb.append(" df3=");
            i = this.df3;
        }
        sb.append(i);
        sb2.append(sb.toString());
        sb2.append(" dm0=" + this.dm0 + " db=" + this.f8173db + " c=" + this.f8172c + " minCallsR=" + this.minCallsR + " minCallsMask=" + this.minCallsMask + " hashSeed=" + this.hashSeed + " hashAlg=" + this.hashAlg + " oid=" + Arrays.toString(this.oid) + " sparse=" + this.sparse + ")");
        return sb2.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f8171N);
        dataOutputStream.writeInt(this.f8177q);
        dataOutputStream.writeInt(this.f8174df);
        dataOutputStream.writeInt(this.df1);
        dataOutputStream.writeInt(this.df2);
        dataOutputStream.writeInt(this.df3);
        dataOutputStream.writeInt(this.f8173db);
        dataOutputStream.writeInt(this.dm0);
        dataOutputStream.writeInt(this.f8172c);
        dataOutputStream.writeInt(this.minCallsR);
        dataOutputStream.writeInt(this.minCallsMask);
        dataOutputStream.writeBoolean(this.hashSeed);
        dataOutputStream.write(this.oid);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeBoolean(this.fastFp);
        dataOutputStream.write(this.polyType);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }
}
