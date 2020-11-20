package org.spongycastle.operator.p189bc;

import java.io.OutputStream;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Digest;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.operator.DigestCalculatorProvider;

/* renamed from: org.spongycastle.operator.bc.BcDigestCalculatorProvider */
public class BcDigestCalculatorProvider implements DigestCalculatorProvider {
    private BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;

    /* renamed from: org.spongycastle.operator.bc.BcDigestCalculatorProvider$DigestOutputStream */
    private class DigestOutputStream extends OutputStream {
        private Digest dig;

        DigestOutputStream(Digest digest) {
            this.dig = digest;
        }

        /* access modifiers changed from: package-private */
        public byte[] getDigest() {
            byte[] bArr = new byte[this.dig.getDigestSize()];
            this.dig.doFinal(bArr, 0);
            return bArr;
        }

        public void write(int i) {
            this.dig.update((byte) i);
        }

        public void write(byte[] bArr) {
            this.dig.update(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.dig.update(bArr, i, i2);
        }
    }

    public DigestCalculator get(final AlgorithmIdentifier algorithmIdentifier) {
        final DigestOutputStream digestOutputStream = new DigestOutputStream(this.digestProvider.get(algorithmIdentifier));
        return new DigestCalculator() {
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            public byte[] getDigest() {
                return digestOutputStream.getDigest();
            }

            public OutputStream getOutputStream() {
                return digestOutputStream;
            }
        };
    }
}
