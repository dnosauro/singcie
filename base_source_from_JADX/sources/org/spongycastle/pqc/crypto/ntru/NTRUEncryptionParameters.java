package org.spongycastle.pqc.crypto.ntru;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class NTRUEncryptionParameters implements Cloneable {

    /* renamed from: N */
    public int f8178N;
    public int bufferLenBits;
    int bufferLenTrits;

    /* renamed from: c */
    public int f8179c;

    /* renamed from: db */
    public int f8180db;

    /* renamed from: df */
    public int f8181df;
    public int df1;
    public int df2;
    public int df3;

    /* renamed from: dg */
    public int f8182dg;
    public int dm0;

    /* renamed from: dr */
    public int f8183dr;
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
    public int f8184q;
    public boolean sparse;

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f8178N = i;
        this.f8184q = i2;
        this.df1 = i3;
        this.df2 = i4;
        this.df3 = i5;
        this.f8180db = i7;
        this.dm0 = i6;
        this.f8179c = i8;
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

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f8178N = i;
        this.f8184q = i2;
        this.f8181df = i3;
        this.f8180db = i5;
        this.dm0 = i4;
        this.f8179c = i6;
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

    public NTRUEncryptionParameters(InputStream inputStream) {
        Digest sHA256Digest;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f8178N = dataInputStream.readInt();
        this.f8184q = dataInputStream.readInt();
        this.f8181df = dataInputStream.readInt();
        this.df1 = dataInputStream.readInt();
        this.df2 = dataInputStream.readInt();
        this.df3 = dataInputStream.readInt();
        this.f8180db = dataInputStream.readInt();
        this.dm0 = dataInputStream.readInt();
        this.f8179c = dataInputStream.readInt();
        this.minCallsR = dataInputStream.readInt();
        this.minCallsMask = dataInputStream.readInt();
        this.hashSeed = dataInputStream.readBoolean();
        this.oid = new byte[3];
        dataInputStream.read(this.oid);
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
        this.f8183dr = this.f8181df;
        this.dr1 = this.df1;
        this.dr2 = this.df2;
        this.dr3 = this.df3;
        int i = this.f8178N;
        this.f8182dg = i / 3;
        this.llen = 1;
        int i2 = (((i * 3) / 2) / 8) - this.llen;
        int i3 = this.f8180db;
        this.maxMsgLenBytes = (i2 - (i3 / 8)) - 1;
        this.bufferLenBits = (((((i * 3) / 2) + 7) / 8) * 8) + 1;
        this.bufferLenTrits = i - 1;
        this.pkLen = i3;
    }

    public NTRUEncryptionParameters clone() {
        if (this.polyType == 0) {
            return new NTRUEncryptionParameters(this.f8178N, this.f8184q, this.f8181df, this.dm0, this.f8180db, this.f8179c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        int i = this.f8178N;
        int i2 = this.f8184q;
        int i3 = this.df1;
        int i4 = this.df2;
        int i5 = this.df3;
        int i6 = this.dm0;
        int i7 = this.f8180db;
        int i8 = this.f8179c;
        int i9 = this.minCallsR;
        int i10 = this.minCallsMask;
        boolean z = this.hashSeed;
        byte[] bArr = this.oid;
        return new NTRUEncryptionParameters(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, z, bArr, this.sparse, this.fastFp, this.hashAlg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionParameters nTRUEncryptionParameters = (NTRUEncryptionParameters) obj;
        if (this.f8178N != nTRUEncryptionParameters.f8178N || this.bufferLenBits != nTRUEncryptionParameters.bufferLenBits || this.bufferLenTrits != nTRUEncryptionParameters.bufferLenTrits || this.f8179c != nTRUEncryptionParameters.f8179c || this.f8180db != nTRUEncryptionParameters.f8180db || this.f8181df != nTRUEncryptionParameters.f8181df || this.df1 != nTRUEncryptionParameters.df1 || this.df2 != nTRUEncryptionParameters.df2 || this.df3 != nTRUEncryptionParameters.df3 || this.f8182dg != nTRUEncryptionParameters.f8182dg || this.dm0 != nTRUEncryptionParameters.dm0 || this.f8183dr != nTRUEncryptionParameters.f8183dr || this.dr1 != nTRUEncryptionParameters.dr1 || this.dr2 != nTRUEncryptionParameters.dr2 || this.dr3 != nTRUEncryptionParameters.dr3 || this.fastFp != nTRUEncryptionParameters.fastFp) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUEncryptionParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUEncryptionParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return this.hashSeed == nTRUEncryptionParameters.hashSeed && this.llen == nTRUEncryptionParameters.llen && this.maxMsgLenBytes == nTRUEncryptionParameters.maxMsgLenBytes && this.minCallsMask == nTRUEncryptionParameters.minCallsMask && this.minCallsR == nTRUEncryptionParameters.minCallsR && Arrays.equals(this.oid, nTRUEncryptionParameters.oid) && this.pkLen == nTRUEncryptionParameters.pkLen && this.polyType == nTRUEncryptionParameters.polyType && this.f8184q == nTRUEncryptionParameters.f8184q && this.sparse == nTRUEncryptionParameters.sparse;
    }

    public int getMaxMessageLength() {
        return this.maxMsgLenBytes;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = (((((((((((((((((((((((((((((((this.f8178N + 31) * 31) + this.bufferLenBits) * 31) + this.bufferLenTrits) * 31) + this.f8179c) * 31) + this.f8180db) * 31) + this.f8181df) * 31) + this.df1) * 31) + this.df2) * 31) + this.df3) * 31) + this.f8182dg) * 31) + this.dm0) * 31) + this.f8183dr) * 31) + this.dr1) * 31) + this.dr2) * 31) + this.dr3) * 31) + (this.fastFp ? 1231 : 1237)) * 31;
        Digest digest = this.hashAlg;
        int hashCode = (((((((((((((((((((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + (this.hashSeed ? 1231 : 1237)) * 31) + this.llen) * 31) + this.maxMsgLenBytes) * 31) + this.minCallsMask) * 31) + this.minCallsR) * 31) + Arrays.hashCode(this.oid)) * 31) + this.pkLen) * 31) + this.polyType) * 31) + this.f8184q) * 31;
        if (!this.sparse) {
            i = 1237;
        }
        return hashCode + i;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder("EncryptionParameters(N=" + this.f8178N + " q=" + this.f8184q);
        if (this.polyType == 0) {
            sb = new StringBuilder();
            sb.append(" polyType=SIMPLE df=");
            i = this.f8181df;
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
        sb2.append(" dm0=" + this.dm0 + " db=" + this.f8180db + " c=" + this.f8179c + " minCallsR=" + this.minCallsR + " minCallsMask=" + this.minCallsMask + " hashSeed=" + this.hashSeed + " hashAlg=" + this.hashAlg + " oid=" + Arrays.toString(this.oid) + " sparse=" + this.sparse + ")");
        return sb2.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f8178N);
        dataOutputStream.writeInt(this.f8184q);
        dataOutputStream.writeInt(this.f8181df);
        dataOutputStream.writeInt(this.df1);
        dataOutputStream.writeInt(this.df2);
        dataOutputStream.writeInt(this.df3);
        dataOutputStream.writeInt(this.f8180db);
        dataOutputStream.writeInt(this.dm0);
        dataOutputStream.writeInt(this.f8179c);
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
