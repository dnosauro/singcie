package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

public final class zzjh {

    /* renamed from: iv */
    public byte[] f6906iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzant;
    private int zzanu;
    private final MediaCodec.CryptoInfo zzanv;
    private final zzjj zzanw;

    public zzjh() {
        this.zzanv = zzpt.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzanw = zzpt.SDK_INT >= 24 ? new zzjj(this.zzanv) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f6906iv = bArr2;
        this.mode = i2;
        this.zzant = 0;
        this.zzanu = 0;
        if (zzpt.SDK_INT >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzanv;
            cryptoInfo.numSubSamples = this.numSubSamples;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.key;
            cryptoInfo.iv = this.f6906iv;
            cryptoInfo.mode = this.mode;
            if (zzpt.SDK_INT >= 24) {
                this.zzanw.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgj() {
        return this.zzanv;
    }
}
