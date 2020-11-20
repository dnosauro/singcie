package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: A1 */
    private short[][] f8210A1;
    private short[][] A1inv;

    /* renamed from: A2 */
    private short[][] f8211A2;
    private short[][] A2inv;

    /* renamed from: b1 */
    private short[] f8212b1;

    /* renamed from: b2 */
    private short[] f8213b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;

    /* renamed from: sr */
    private SecureRandom f8214sr;

    /* renamed from: vi */
    private int[] f8215vi;

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        this.pub_quadratic = (short[][]) Array.newInstance(short.class, new int[]{length, ((length2 + 1) * length2) / 2});
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length2) {
                int i4 = i3;
                for (int i5 = i2; i5 < length2; i5++) {
                    if (i5 == i2) {
                        this.pub_quadratic[i][i4] = sArr[i][i2][i5];
                    } else {
                        this.pub_quadratic[i][i4] = GF2Field.addElem(sArr[i][i2][i5], sArr[i][i5][i2]);
                    }
                    i4++;
                }
                i2++;
                i3 = i4;
            }
        }
    }

    private void computePublicKey() {
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.f8215vi;
        int i = 0;
        int i2 = iArr[iArr.length - 1] - iArr[0];
        int i3 = iArr[iArr.length - 1];
        short[][][] sArr = (short[][][]) Array.newInstance(short.class, new int[]{i2, i3, i3});
        this.pub_singular = (short[][]) Array.newInstance(short.class, new int[]{i2, i3});
        this.pub_scalar = new short[i2];
        short[] sArr2 = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i4 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i4].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i4].getCoeffBeta();
            short[][] coeffGamma = this.layers[i4].getCoeffGamma();
            short[] coeffEta = this.layers[i4].getCoeffEta();
            int length = coeffAlpha[i].length;
            int length2 = coeffBeta[i].length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = 0;
                while (i7 < length) {
                    while (i < length2) {
                        int i8 = i3;
                        int i9 = i2;
                        int i10 = i7 + length2;
                        short[] multVect = computeInField.multVect(coeffAlpha[i6][i7][i], this.f8211A2[i10]);
                        int i11 = i5 + i6;
                        int i12 = i4;
                        sArr[i11] = computeInField.addSquareMatrix(sArr[i11], computeInField.multVects(multVect, this.f8211A2[i]));
                        short[] multVect2 = computeInField.multVect(this.f8213b2[i], multVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i11] = computeInField.addVect(multVect2, sArr3[i11]);
                        short[] multVect3 = computeInField.multVect(this.f8213b2[i10], computeInField.multVect(coeffAlpha[i6][i7][i], this.f8211A2[i]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i11] = computeInField.addVect(multVect3, sArr4[i11]);
                        short multElem = GF2Field.multElem(coeffAlpha[i6][i7][i], this.f8213b2[i10]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i11] = GF2Field.addElem(sArr5[i11], GF2Field.multElem(multElem, this.f8213b2[i]));
                        i++;
                        i2 = i9;
                        i3 = i8;
                        coeffAlpha = coeffAlpha;
                        i4 = i12;
                        coeffEta = coeffEta;
                    }
                    int i13 = i3;
                    int i14 = i2;
                    int i15 = i4;
                    short[][][] sArr6 = coeffAlpha;
                    short[] sArr7 = coeffEta;
                    i7++;
                    i = 0;
                }
                int i16 = i3;
                int i17 = i2;
                int i18 = i4;
                short[][][] sArr8 = coeffAlpha;
                short[] sArr9 = coeffEta;
                for (int i19 = 0; i19 < length2; i19++) {
                    for (int i20 = 0; i20 < length2; i20++) {
                        short[] multVect4 = computeInField.multVect(coeffBeta[i6][i19][i20], this.f8211A2[i19]);
                        int i21 = i5 + i6;
                        sArr[i21] = computeInField.addSquareMatrix(sArr[i21], computeInField.multVects(multVect4, this.f8211A2[i20]));
                        short[] multVect5 = computeInField.multVect(this.f8213b2[i20], multVect4);
                        short[][] sArr10 = this.pub_singular;
                        sArr10[i21] = computeInField.addVect(multVect5, sArr10[i21]);
                        short[] multVect6 = computeInField.multVect(this.f8213b2[i19], computeInField.multVect(coeffBeta[i6][i19][i20], this.f8211A2[i20]));
                        short[][] sArr11 = this.pub_singular;
                        sArr11[i21] = computeInField.addVect(multVect6, sArr11[i21]);
                        short multElem2 = GF2Field.multElem(coeffBeta[i6][i19][i20], this.f8213b2[i19]);
                        short[] sArr12 = this.pub_scalar;
                        sArr12[i21] = GF2Field.addElem(sArr12[i21], GF2Field.multElem(multElem2, this.f8213b2[i20]));
                    }
                }
                for (int i22 = 0; i22 < length2 + length; i22++) {
                    short[] multVect7 = computeInField.multVect(coeffGamma[i6][i22], this.f8211A2[i22]);
                    short[][] sArr13 = this.pub_singular;
                    int i23 = i5 + i6;
                    sArr13[i23] = computeInField.addVect(multVect7, sArr13[i23]);
                    short[] sArr14 = this.pub_scalar;
                    sArr14[i23] = GF2Field.addElem(sArr14[i23], GF2Field.multElem(coeffGamma[i6][i22], this.f8213b2[i22]));
                }
                short[] sArr15 = this.pub_scalar;
                int i24 = i5 + i6;
                sArr15[i24] = GF2Field.addElem(sArr15[i24], sArr9[i6]);
                i6++;
                i2 = i17;
                i3 = i16;
                coeffAlpha = sArr8;
                i4 = i18;
                coeffEta = sArr9;
                i = 0;
            }
            int i25 = i3;
            int i26 = i2;
            i5 += length;
            i4++;
            i = 0;
        }
        short[][][] sArr16 = (short[][][]) Array.newInstance(short.class, new int[]{i2, i3, i3});
        short[][] sArr17 = (short[][]) Array.newInstance(short.class, new int[]{i2, i3});
        short[] sArr18 = new short[i2];
        for (int i27 = 0; i27 < i2; i27++) {
            int i28 = 0;
            while (true) {
                short[][] sArr19 = this.f8210A1;
                if (i28 >= sArr19.length) {
                    break;
                }
                sArr16[i27] = computeInField.addSquareMatrix(sArr16[i27], computeInField.multMatrix(sArr19[i27][i28], sArr[i28]));
                sArr17[i27] = computeInField.addVect(sArr17[i27], computeInField.multVect(this.f8210A1[i27][i28], this.pub_singular[i28]));
                sArr18[i27] = GF2Field.addElem(sArr18[i27], GF2Field.multElem(this.f8210A1[i27][i28], this.pub_scalar[i28]));
                i28++;
            }
            sArr18[i27] = GF2Field.addElem(sArr18[i27], this.f8212b1[i27]);
        }
        this.pub_singular = sArr17;
        this.pub_scalar = sArr18;
        compactPublicKey(sArr16);
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i = 0;
        while (i < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.f8215vi;
            int i2 = i + 1;
            layerArr[i] = new Layer(iArr[i], iArr[i2], this.f8214sr);
            i = i2;
        }
    }

    private void generateL1() {
        int[] iArr = this.f8215vi;
        int i = iArr[iArr.length - 1] - iArr[0];
        this.f8210A1 = (short[][]) Array.newInstance(short.class, new int[]{i, i});
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.f8210A1[i2][i3] = (short) (this.f8214sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.f8210A1);
        }
        this.f8212b1 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.f8212b1[i4] = (short) (this.f8214sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int i;
        int[] iArr = this.f8215vi;
        int i2 = iArr[iArr.length - 1];
        this.f8211A2 = (short[][]) Array.newInstance(short.class, new int[]{i2, i2});
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (true) {
            if (this.A2inv != null) {
                break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i2; i4++) {
                    this.f8211A2[i3][i4] = (short) (this.f8214sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.f8211A2);
        }
        this.f8213b2 = new short[i2];
        for (i = 0; i < i2; i++) {
            this.f8213b2[i] = (short) (this.f8214sr.nextInt() & 255);
        }
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.f8212b1, this.A2inv, this.f8213b2, this.f8215vi, this.layers);
        int[] iArr = this.f8215vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.rainbowParams = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.f8214sr = this.rainbowParams.getRandom();
        this.f8215vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }
}
