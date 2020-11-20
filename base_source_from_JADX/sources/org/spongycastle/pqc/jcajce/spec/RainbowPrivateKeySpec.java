package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKeySpec implements KeySpec {
    private short[][] A1inv;
    private short[][] A2inv;

    /* renamed from: b1 */
    private short[] f8236b1;

    /* renamed from: b2 */
    private short[] f8237b2;
    private Layer[] layers;

    /* renamed from: vi */
    private int[] f8238vi;

    public RainbowPrivateKeySpec(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.A1inv = sArr;
        this.f8236b1 = sArr2;
        this.A2inv = sArr3;
        this.f8237b2 = sArr4;
        this.f8238vi = iArr;
        this.layers = layerArr;
    }

    public short[] getB1() {
        return this.f8236b1;
    }

    public short[] getB2() {
        return this.f8237b2;
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.f8238vi;
    }
}
