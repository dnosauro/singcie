package org.spongycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public final class XMSSPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    private final BDS bdsState;
    private final XMSSParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    public static class Builder {
        /* access modifiers changed from: private */
        public BDS bdsState = null;
        /* access modifiers changed from: private */
        public int index = 0;
        /* access modifiers changed from: private */
        public final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] privateKey = null;
        /* access modifiers changed from: private */
        public byte[] publicSeed = null;
        /* access modifiers changed from: private */
        public byte[] root = null;
        /* access modifiers changed from: private */
        public byte[] secretKeyPRF = null;
        /* access modifiers changed from: private */
        public byte[] secretKeySeed = null;
        /* access modifiers changed from: private */
        public XMSSParameters xmss = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.params = xMSSParameters;
        }

        public XMSSPrivateKeyParameters build() {
            return new XMSSPrivateKeyParameters(this);
        }

        public Builder withBDSState(BDS bds) {
            this.bdsState = bds;
            return this;
        }

        public Builder withIndex(int i) {
            this.index = i;
            return this;
        }

        public Builder withPrivateKey(byte[] bArr, XMSSParameters xMSSParameters) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            this.xmss = xMSSParameters;
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private XMSSPrivateKeyParameters(org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters.Builder r8) {
        /*
            r7 = this;
            r0 = 1
            r7.<init>(r0)
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r1 = r8.params
            r7.params = r1
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r1 = r7.params
            if (r1 == 0) goto L_0x0133
            int r1 = r1.getDigestSize()
            byte[] r2 = r8.privateKey
            if (r2 == 0) goto L_0x0091
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r0 = r8.xmss
            if (r0 == 0) goto L_0x0089
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r0 = r7.params
            int r0 = r0.getHeight()
            r3 = 0
            int r3 = org.spongycastle.util.Pack.bigEndianToInt(r2, r3)
            long r4 = (long) r3
            boolean r0 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.isIndexValid(r0, r4)
            if (r0 == 0) goto L_0x0081
            r0 = 4
            byte[] r4 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.extractBytesAtOffset(r2, r0, r1)
            r7.secretKeySeed = r4
            int r0 = r0 + r1
            byte[] r4 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.extractBytesAtOffset(r2, r0, r1)
            r7.secretKeyPRF = r4
            int r0 = r0 + r1
            byte[] r4 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.extractBytesAtOffset(r2, r0, r1)
            r7.publicSeed = r4
            int r0 = r0 + r1
            byte[] r4 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.extractBytesAtOffset(r2, r0, r1)
            r7.root = r4
            int r0 = r0 + r1
            int r1 = r2.length
            int r1 = r1 - r0
            byte[] r0 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.extractBytesAtOffset(r2, r0, r1)
            r1 = 0
            java.lang.Object r0 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.deserialize(r0)     // Catch:{ IOException -> 0x0060, ClassNotFoundException -> 0x005b }
            org.spongycastle.pqc.crypto.xmss.BDS r0 = (org.spongycastle.pqc.crypto.xmss.BDS) r0     // Catch:{ IOException -> 0x0060, ClassNotFoundException -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0064
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0064:
            r0 = r1
        L_0x0065:
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r8 = r8.xmss
            r0.setXMSS(r8)
            r0.validate()
            int r8 = r0.getIndex()
            if (r8 != r3) goto L_0x0079
        L_0x0075:
            r7.bdsState = r0
            goto L_0x0132
        L_0x0079:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "serialized BDS has wrong index"
            r8.<init>(r0)
            throw r8
        L_0x0081:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "index out of bounds"
            r8.<init>(r0)
            throw r8
        L_0x0089:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "xmss == null"
            r8.<init>(r0)
            throw r8
        L_0x0091:
            byte[] r4 = r8.secretKeySeed
            if (r4 == 0) goto L_0x00a5
            int r2 = r4.length
            if (r2 != r1) goto L_0x009d
            r7.secretKeySeed = r4
            goto L_0x00a9
        L_0x009d:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of secretKeySeed needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00a5:
            byte[] r2 = new byte[r1]
            r7.secretKeySeed = r2
        L_0x00a9:
            byte[] r2 = r8.secretKeyPRF
            if (r2 == 0) goto L_0x00bb
            int r3 = r2.length
            if (r3 != r1) goto L_0x00b3
            goto L_0x00bd
        L_0x00b3:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of secretKeyPRF needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00bb:
            byte[] r2 = new byte[r1]
        L_0x00bd:
            r7.secretKeyPRF = r2
            byte[] r3 = r8.publicSeed
            if (r3 == 0) goto L_0x00d3
            int r2 = r3.length
            if (r2 != r1) goto L_0x00cb
            r7.publicSeed = r3
            goto L_0x00d7
        L_0x00cb:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of publicSeed needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00d3:
            byte[] r2 = new byte[r1]
            r7.publicSeed = r2
        L_0x00d7:
            byte[] r2 = r8.root
            if (r2 == 0) goto L_0x00eb
            int r5 = r2.length
            if (r5 != r1) goto L_0x00e3
            r7.root = r2
            goto L_0x00ef
        L_0x00e3:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of root needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00eb:
            byte[] r1 = new byte[r1]
            r7.root = r1
        L_0x00ef:
            org.spongycastle.pqc.crypto.xmss.BDS r1 = r8.bdsState
            if (r1 == 0) goto L_0x00f8
            r7.bdsState = r1
            goto L_0x0132
        L_0x00f8:
            int r1 = r8.index
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r2 = r7.params
            int r2 = r2.getHeight()
            int r0 = r0 << r2
            int r0 = r0 + -2
            if (r1 >= r0) goto L_0x0125
            if (r3 == 0) goto L_0x0125
            if (r4 == 0) goto L_0x0125
            org.spongycastle.pqc.crypto.xmss.BDS r0 = new org.spongycastle.pqc.crypto.xmss.BDS
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r2 = r7.params
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r1 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder
            r1.<init>()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r1 = r1.build()
            r5 = r1
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress r5 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress) r5
            int r6 = r8.index
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0075
        L_0x0125:
            org.spongycastle.pqc.crypto.xmss.BDS r0 = new org.spongycastle.pqc.crypto.xmss.BDS
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r1 = r7.params
            int r8 = r8.index
            r0.<init>(r1, r8)
            goto L_0x0075
        L_0x0132:
            return
        L_0x0133:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "params == null"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters.<init>(org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters$Builder):void");
    }

    /* access modifiers changed from: package-private */
    public BDS getBDSState() {
        return this.bdsState;
    }

    public int getIndex() {
        return this.bdsState.getIndex();
    }

    public XMSSPrivateKeyParameters getNextKey() {
        Builder withRoot;
        BDS bds;
        if (getIndex() < (1 << this.params.getHeight()) - 1) {
            withRoot = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root);
            bds = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, (OTSHashAddress) new OTSHashAddress.Builder().build());
        } else {
            withRoot = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root);
            bds = new BDS(this.params, getIndex() + 1);
        }
        return withRoot.withBDSState(bds).build();
    }

    public XMSSParameters getParameters() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public byte[] toByteArray() {
        int digestSize = this.params.getDigestSize();
        byte[] bArr = new byte[(digestSize + 4 + digestSize + digestSize + digestSize)];
        Pack.intToBigEndian(this.bdsState.getIndex(), bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, 4);
        int i = 4 + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i);
        int i2 = i + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2);
        XMSSUtil.copyBytesAtOffset(bArr, this.root, i2 + digestSize);
        try {
            return Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
        } catch (IOException e) {
            throw new RuntimeException("error serializing bds state: " + e.getMessage());
        }
    }
}
