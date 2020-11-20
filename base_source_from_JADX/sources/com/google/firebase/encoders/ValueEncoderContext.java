package com.google.firebase.encoders;

public interface ValueEncoderContext {
    ValueEncoderContext add(double d);

    ValueEncoderContext add(int i);

    ValueEncoderContext add(long j);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z);

    ValueEncoderContext add(byte[] bArr);
}
