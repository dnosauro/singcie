package org.apache.commons.p172io.input;

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: org.apache.commons.io.input.ReaderInputStream */
public class ReaderInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private final CharsetEncoder encoder;
    private final CharBuffer encoderIn;
    private final ByteBuffer encoderOut;
    private boolean endOfInput;
    private CoderResult lastCoderResult;
    private final Reader reader;

    public ReaderInputStream(Reader reader2) {
        this(reader2, Charset.defaultCharset());
    }

    public ReaderInputStream(Reader reader2, String str) {
        this(reader2, str, 1024);
    }

    public ReaderInputStream(Reader reader2, String str, int i) {
        this(reader2, Charset.forName(str), i);
    }

    public ReaderInputStream(Reader reader2, Charset charset) {
        this(reader2, charset, 1024);
    }

    public ReaderInputStream(Reader reader2, Charset charset, int i) {
        this(reader2, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    public ReaderInputStream(Reader reader2, CharsetEncoder charsetEncoder) {
        this(reader2, charsetEncoder, 1024);
    }

    public ReaderInputStream(Reader reader2, CharsetEncoder charsetEncoder, int i) {
        this.reader = reader2;
        this.encoder = charsetEncoder;
        this.encoderIn = CharBuffer.allocate(i);
        this.encoderIn.flip();
        this.encoderOut = ByteBuffer.allocate(128);
        this.encoderOut.flip();
    }

    private void fillBuffer() {
        CoderResult coderResult;
        if (!this.endOfInput && ((coderResult = this.lastCoderResult) == null || coderResult.isUnderflow())) {
            this.encoderIn.compact();
            int position = this.encoderIn.position();
            int read = this.reader.read(this.encoderIn.array(), position, this.encoderIn.remaining());
            if (read == -1) {
                this.endOfInput = true;
            } else {
                this.encoderIn.position(position + read);
            }
            this.encoderIn.flip();
        }
        this.encoderOut.compact();
        this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
        this.encoderOut.flip();
    }

    public void close() {
        this.reader.close();
    }

    public int read() {
        while (!this.encoderOut.hasRemaining()) {
            fillBuffer();
            if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                return -1;
            }
        }
        return this.encoderOut.get() & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("Byte array must not be null");
        } else if (i2 < 0 || i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i + ", length=" + i2);
        } else {
            int i3 = 0;
            if (i2 == 0) {
                return 0;
            }
            while (i2 > 0) {
                if (!this.encoderOut.hasRemaining()) {
                    fillBuffer();
                    if (this.endOfInput && !this.encoderOut.hasRemaining()) {
                        break;
                    }
                } else {
                    int min = Math.min(this.encoderOut.remaining(), i2);
                    this.encoderOut.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                }
            }
            if (i3 != 0 || !this.endOfInput) {
                return i3;
            }
            return -1;
        }
    }
}