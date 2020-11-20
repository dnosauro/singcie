package com.google.firebase.encoders;

public interface ObjectEncoderContext {
    ObjectEncoderContext add(String str, double d);

    ObjectEncoderContext add(String str, int i);

    ObjectEncoderContext add(String str, long j);

    ObjectEncoderContext add(String str, Object obj);

    ObjectEncoderContext add(String str, boolean z);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(String str);
}
