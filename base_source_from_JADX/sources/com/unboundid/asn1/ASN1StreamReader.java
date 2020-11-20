package com.unboundid.asn1;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import org.spongycastle.asn1.eac.CertificateBody;

public final class ASN1StreamReader {
    private boolean ignoreInitialSocketTimeout;
    private boolean ignoreSubsequentSocketTimeout;
    private final InputStream inputStream;
    private final int maxElementSize;
    private long totalBytesRead;

    public ASN1StreamReader(InputStream inputStream2) {
        this(inputStream2, Integer.MAX_VALUE);
    }

    public ASN1StreamReader(InputStream inputStream2, int i) {
        if (inputStream2.markSupported()) {
            this.inputStream = inputStream2;
        } else {
            this.inputStream = new BufferedInputStream(inputStream2);
        }
        if (i > 0) {
            this.maxElementSize = i;
        } else {
            this.maxElementSize = Integer.MAX_VALUE;
        }
        this.totalBytesRead = 0;
        this.ignoreInitialSocketTimeout = false;
        this.ignoreSubsequentSocketTimeout = false;
    }

    private int read(boolean z) {
        try {
            return this.inputStream.read();
        } catch (SocketTimeoutException e) {
            Debug.debugException(Level.FINEST, e);
            if ((!z || !this.ignoreInitialSocketTimeout) && (z || !this.ignoreSubsequentSocketTimeout)) {
                throw e;
            }
            while (true) {
                try {
                    return this.inputStream.read();
                } catch (SocketTimeoutException e2) {
                    Debug.debugException(Level.FINEST, e2);
                }
            }
        }
    }

    private int read(boolean z, byte[] bArr, int i, int i2) {
        try {
            return this.inputStream.read(bArr, i, i2);
        } catch (SocketTimeoutException e) {
            Debug.debugException(Level.FINEST, e);
            if ((!z || !this.ignoreInitialSocketTimeout) && (z || !this.ignoreSubsequentSocketTimeout)) {
                throw e;
            }
            while (true) {
                try {
                    return this.inputStream.read(bArr, i, i2);
                } catch (SocketTimeoutException e2) {
                    Debug.debugException(Level.FINEST, e2);
                }
            }
        }
    }

    private int readLength() {
        int i;
        int read = read(false);
        if (read >= 0) {
            this.totalBytesRead++;
            if (read > 127) {
                int i2 = read & CertificateBody.profileType;
                if (i2 < 1 || i2 > 4) {
                    throw new IOException(ASN1Messages.ERR_READ_LENGTH_TOO_LONG.get(Integer.valueOf(i2)));
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    int read2 = read(false);
                    if (read2 >= 0) {
                        i4 = (i4 << 8) | (read2 & 255);
                        i3++;
                    } else {
                        throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_LENGTH_END.get());
                    }
                }
                this.totalBytesRead += (long) i2;
                read = i4;
            }
            if (read >= 0 && ((i = this.maxElementSize) <= 0 || read <= i)) {
                return read;
            }
            throw new IOException(ASN1Messages.ERR_READ_LENGTH_EXCEEDS_MAX.get(Integer.valueOf(read), Integer.valueOf(this.maxElementSize)));
        }
        throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_FIRST_LENGTH.get());
    }

    private int readType() {
        int read = read(true);
        if (read < 0) {
            close();
        } else {
            this.totalBytesRead++;
        }
        return read;
    }

    private void skip(int i) {
        if (i > 0) {
            long j = (long) i;
            long skip = this.inputStream.skip(j);
            while (skip < j) {
                long skip2 = this.inputStream.skip(j - skip);
                if (skip2 <= 0) {
                    while (skip < j) {
                        if (read(false) >= 0) {
                            skip++;
                        } else {
                            throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
                        }
                    }
                    continue;
                } else {
                    skip += skip2;
                }
            }
            this.totalBytesRead += j;
        }
    }

    public ASN1StreamReaderSequence beginSequence() {
        int readType = readType();
        if (readType < 0) {
            return null;
        }
        return new ASN1StreamReaderSequence(this, (byte) readType, readLength());
    }

    public ASN1StreamReaderSet beginSet() {
        int readType = readType();
        if (readType < 0) {
            return null;
        }
        return new ASN1StreamReaderSet(this, (byte) readType, readLength());
    }

    public void close() {
        this.inputStream.close();
    }

    /* access modifiers changed from: package-private */
    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public boolean ignoreInitialSocketTimeoutException() {
        return this.ignoreInitialSocketTimeout;
    }

    @Deprecated
    public boolean ignoreSocketTimeoutException() {
        return this.ignoreInitialSocketTimeout;
    }

    public boolean ignoreSubsequentSocketTimeoutException() {
        return this.ignoreSubsequentSocketTimeout;
    }

    public int peek() {
        this.inputStream.mark(1);
        int read = read(true);
        this.inputStream.reset();
        return read;
    }

    public Boolean readBoolean() {
        if (readType() < 0) {
            return null;
        }
        int readLength = readLength();
        if (readLength == 1) {
            boolean z = false;
            int read = read(false);
            if (read >= 0) {
                this.totalBytesRead++;
                if (read != 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
        }
        skip(readLength);
        throw new ASN1Exception(ASN1Messages.ERR_BOOLEAN_INVALID_LENGTH.get());
    }

    public byte[] readBytes() {
        if (readType() < 0) {
            return null;
        }
        int readLength = readLength();
        byte[] bArr = new byte[readLength];
        int i = readLength;
        int i2 = 0;
        while (i2 < readLength) {
            int read = read(false, bArr, i2, i);
            if (read >= 0) {
                i2 += read;
                i -= read;
            } else {
                throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
            }
        }
        this.totalBytesRead += (long) readLength;
        return bArr;
    }

    public ASN1Element readElement() {
        int readType = readType();
        if (readType < 0) {
            return null;
        }
        int readLength = readLength();
        byte[] bArr = new byte[readLength];
        int i = readLength;
        int i2 = 0;
        while (i2 < readLength) {
            int read = read(false, bArr, i2, i);
            if (read >= 0) {
                i2 += read;
                i -= read;
            } else {
                throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
            }
        }
        this.totalBytesRead += (long) readLength;
        ASN1Element aSN1Element = new ASN1Element((byte) readType, bArr);
        Debug.debugASN1Read(aSN1Element);
        return aSN1Element;
    }

    public Integer readEnumerated() {
        return readInteger();
    }

    public Integer readInteger() {
        int i;
        if (readType() < 0) {
            return null;
        }
        int readLength = readLength();
        if (readLength == 0 || readLength > 4) {
            skip(readLength);
            throw new ASN1Exception(ASN1Messages.ERR_INTEGER_INVALID_LENGTH.get(Integer.valueOf(readLength)));
        }
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (i2 < readLength) {
            int read = read(false);
            if (read >= 0) {
                if (i2 == 0) {
                    z = (read & 128) != 0;
                }
                i3 = (i3 << 8) | (read & 255);
                i2++;
            } else {
                throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
            }
        }
        if (z) {
            switch (readLength) {
                case 1:
                    i3 |= -256;
                    break;
                case 2:
                    i = -65536;
                    break;
                case 3:
                    i = -16777216;
                    break;
            }
            i3 |= i;
        }
        this.totalBytesRead += (long) readLength;
        return Integer.valueOf(i3);
    }

    public Long readLong() {
        long j;
        if (readType() < 0) {
            return null;
        }
        int readLength = readLength();
        if (readLength == 0 || readLength > 8) {
            skip(readLength);
            throw new ASN1Exception(ASN1Messages.ERR_LONG_INVALID_LENGTH.get(Integer.valueOf(readLength)));
        }
        long j2 = 0;
        int i = 0;
        boolean z = false;
        while (i < readLength) {
            int read = read(false);
            if (read >= 0) {
                if (i == 0) {
                    z = (read & 128) != 0;
                }
                j2 = (j2 << 8) | (((long) read) & 255);
                i++;
            } else {
                throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
            }
        }
        if (z) {
            switch (readLength) {
                case 1:
                    j = -256;
                    break;
                case 2:
                    j = -65536;
                    break;
                case 3:
                    j = -16777216;
                    break;
                case 4:
                    j = -4294967296L;
                    break;
                case 5:
                    j = -1099511627776L;
                    break;
                case 6:
                    j = -281474976710656L;
                    break;
                case 7:
                    j = -72057594037927936L;
                    break;
            }
            j2 |= j;
        }
        this.totalBytesRead += (long) readLength;
        return Long.valueOf(j2);
    }

    public void readNull() {
        int readLength;
        if (readType() >= 0 && (readLength = readLength()) != 0) {
            skip(readLength);
            throw new ASN1Exception(ASN1Messages.ERR_NULL_HAS_VALUE.get());
        }
    }

    public String readString() {
        if (readType() < 0) {
            return null;
        }
        int readLength = readLength();
        byte[] bArr = new byte[readLength];
        int i = readLength;
        int i2 = 0;
        while (i2 < readLength) {
            int read = read(false, bArr, i2, i);
            if (read >= 0) {
                i2 += read;
                i -= read;
            } else {
                throw new IOException(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
            }
        }
        this.totalBytesRead += (long) readLength;
        return StaticUtils.toUTF8String(bArr);
    }

    @Deprecated
    public void setIgnoreSocketTimeout(boolean z) {
        this.ignoreInitialSocketTimeout = z;
        this.ignoreSubsequentSocketTimeout = z;
    }

    public void setIgnoreSocketTimeout(boolean z, boolean z2) {
        this.ignoreInitialSocketTimeout = z;
        this.ignoreSubsequentSocketTimeout = z2;
    }
}
