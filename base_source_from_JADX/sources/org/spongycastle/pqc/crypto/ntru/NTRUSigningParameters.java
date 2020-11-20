package org.spongycastle.pqc.crypto.ntru;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class NTRUSigningParameters implements Cloneable {

    /* renamed from: B */
    public int f8198B;

    /* renamed from: N */
    public int f8199N;
    double beta;
    public double betaSq;
    int bitsF = 6;

    /* renamed from: d */
    public int f8200d;

    /* renamed from: d1 */
    public int f8201d1;

    /* renamed from: d2 */
    public int f8202d2;

    /* renamed from: d3 */
    public int f8203d3;
    public Digest hashAlg;
    double normBound;
    public double normBoundSq;

    /* renamed from: q */
    public int f8204q;
    public int signFailTolerance = 100;

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d, double d2, Digest digest) {
        this.f8199N = i;
        this.f8204q = i2;
        this.f8200d = i3;
        this.f8198B = i4;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    public NTRUSigningParameters(int i, int i2, int i3, int i4, int i5, int i6, double d, double d2, double d3, Digest digest) {
        this.f8199N = i;
        this.f8204q = i2;
        this.f8201d1 = i3;
        this.f8202d2 = i4;
        this.f8203d3 = i5;
        this.f8198B = i6;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    public NTRUSigningParameters(InputStream inputStream) {
        Digest sHA256Digest;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f8199N = dataInputStream.readInt();
        this.f8204q = dataInputStream.readInt();
        this.f8200d = dataInputStream.readInt();
        this.f8201d1 = dataInputStream.readInt();
        this.f8202d2 = dataInputStream.readInt();
        this.f8203d3 = dataInputStream.readInt();
        this.f8198B = dataInputStream.readInt();
        this.beta = dataInputStream.readDouble();
        this.normBound = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.bitsF = dataInputStream.readInt();
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
        double d = this.beta;
        this.betaSq = d * d;
        double d2 = this.normBound;
        this.normBoundSq = d2 * d2;
    }

    public NTRUSigningParameters clone() {
        return new NTRUSigningParameters(this.f8199N, this.f8204q, this.f8200d, this.f8198B, this.beta, this.normBound, this.hashAlg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningParameters)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
        if (this.f8198B != nTRUSigningParameters.f8198B || this.f8199N != nTRUSigningParameters.f8199N || Double.doubleToLongBits(this.beta) != Double.doubleToLongBits(nTRUSigningParameters.beta) || Double.doubleToLongBits(this.betaSq) != Double.doubleToLongBits(nTRUSigningParameters.betaSq) || this.bitsF != nTRUSigningParameters.bitsF || this.f8200d != nTRUSigningParameters.f8200d || this.f8201d1 != nTRUSigningParameters.f8201d1 || this.f8202d2 != nTRUSigningParameters.f8202d2 || this.f8203d3 != nTRUSigningParameters.f8203d3) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUSigningParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUSigningParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return Double.doubleToLongBits(this.normBound) == Double.doubleToLongBits(nTRUSigningParameters.normBound) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningParameters.normBoundSq) && this.f8204q == nTRUSigningParameters.f8204q && this.signFailTolerance == nTRUSigningParameters.signFailTolerance;
    }

    public int hashCode() {
        int i = ((this.f8198B + 31) * 31) + this.f8199N;
        long doubleToLongBits = Double.doubleToLongBits(this.beta);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.bitsF) * 31) + this.f8200d) * 31) + this.f8201d1) * 31) + this.f8202d2) * 31) + this.f8203d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode());
        long doubleToLongBits3 = Double.doubleToLongBits(this.normBound);
        long doubleToLongBits4 = Double.doubleToLongBits(this.normBoundSq);
        return (((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + this.f8204q) * 31) + this.signFailTolerance;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder("SignatureParameters(N=" + this.f8199N + " q=" + this.f8204q);
        sb.append(" B=" + this.f8198B + " beta=" + decimalFormat.format(this.beta) + " normBound=" + decimalFormat.format(this.normBound) + " hashAlg=" + this.hashAlg + ")");
        return sb.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f8199N);
        dataOutputStream.writeInt(this.f8204q);
        dataOutputStream.writeInt(this.f8200d);
        dataOutputStream.writeInt(this.f8201d1);
        dataOutputStream.writeInt(this.f8202d2);
        dataOutputStream.writeInt(this.f8203d3);
        dataOutputStream.writeInt(this.f8198B);
        dataOutputStream.writeDouble(this.beta);
        dataOutputStream.writeDouble(this.normBound);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeInt(this.bitsF);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }
}
