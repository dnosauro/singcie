package com.unboundid.util;

import com.unboundid.asn1.ASN1OctetString;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class ByteStringBuffer implements Serializable, Appendable {
    private static final int DEFAULT_INITIAL_CAPACITY = 20;
    private static final byte[] FALSE_VALUE_BYTES = StaticUtils.getBytes("false");
    private static final ThreadLocal<byte[]> TEMP_NUMBER_BUFFER = new ThreadLocal<>();
    private static final byte[] TRUE_VALUE_BYTES = StaticUtils.getBytes("true");
    private static final long serialVersionUID = 2899392249591230998L;
    private byte[] array;
    private int capacity;
    private int endPos;

    public ByteStringBuffer() {
        this(20);
    }

    public ByteStringBuffer(int i) {
        this.array = new byte[i];
        this.capacity = i;
        this.endPos = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getBytes(long r23) {
        /*
            java.lang.ThreadLocal<byte[]> r0 = TEMP_NUMBER_BUFFER
            java.lang.Object r0 = r0.get()
            byte[] r0 = (byte[]) r0
            r1 = 20
            if (r0 != 0) goto L_0x0013
            byte[] r0 = new byte[r1]
            java.lang.ThreadLocal<byte[]> r2 = TEMP_NUMBER_BUFFER
            r2.set(r0)
        L_0x0013:
            r2 = -9223372036854775808
            r4 = 54
            r5 = 57
            r6 = 45
            r7 = 53
            r8 = 56
            r9 = 55
            r10 = 51
            r11 = 50
            r12 = 0
            r13 = 48
            r14 = 1
            int r15 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x0076
            r0[r12] = r6
            r0[r14] = r5
            r2 = 2
            r0[r2] = r11
            r2 = 3
            r0[r2] = r11
            r2 = 4
            r0[r2] = r10
            r2 = 5
            r0[r2] = r10
            r2 = 6
            r0[r2] = r9
            r2 = 7
            r0[r2] = r11
            r2 = 8
            r0[r2] = r13
            r2 = 9
            r0[r2] = r10
            r2 = 10
            r0[r2] = r4
            r2 = 11
            r0[r2] = r8
            r2 = 12
            r0[r2] = r7
            r2 = 13
            r3 = 52
            r0[r2] = r3
            r2 = 14
            r0[r2] = r9
            r2 = 15
            r0[r2] = r9
            r2 = 16
            r0[r2] = r7
            r2 = 17
            r0[r2] = r8
            r2 = 18
            r0[r2] = r13
            r2 = 19
            r0[r2] = r8
            return r1
        L_0x0076:
            r1 = 0
            int r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x007f
            r0[r12] = r13
            return r14
        L_0x007f:
            if (r3 >= 0) goto L_0x0088
            r0[r12] = r6
            long r15 = java.lang.Math.abs(r23)
            goto L_0x008b
        L_0x0088:
            r14 = 0
            r15 = r23
        L_0x008b:
            r17 = 9
            r19 = 10
            r21 = 1
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x0099
            r17 = r21
            goto L_0x017e
        L_0x0099:
            r17 = 99
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00a3
            r17 = r19
            goto L_0x017e
        L_0x00a3:
            r17 = 999(0x3e7, double:4.936E-321)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00ad
            r17 = 100
            goto L_0x017e
        L_0x00ad:
            r17 = 9999(0x270f, double:4.94E-320)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00b7
            r17 = 1000(0x3e8, double:4.94E-321)
            goto L_0x017e
        L_0x00b7:
            r17 = 99999(0x1869f, double:4.9406E-319)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00c2
            r17 = 10000(0x2710, double:4.9407E-320)
            goto L_0x017e
        L_0x00c2:
            r17 = 999999(0xf423f, double:4.94065E-318)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00ce
            r17 = 100000(0x186a0, double:4.94066E-319)
            goto L_0x017e
        L_0x00ce:
            r17 = 9999999(0x98967f, double:4.940656E-317)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00da
            r17 = 1000000(0xf4240, double:4.940656E-318)
            goto L_0x017e
        L_0x00da:
            r17 = 99999999(0x5f5e0ff, double:4.9406564E-316)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00e6
            r17 = 10000000(0x989680, double:4.9406565E-317)
            goto L_0x017e
        L_0x00e6:
            r17 = 999999999(0x3b9ac9ff, double:4.940656453E-315)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x00f2
            r17 = 100000000(0x5f5e100, double:4.94065646E-316)
            goto L_0x017e
        L_0x00f2:
            r17 = 9999999999(0x2540be3ff, double:4.940656458E-314)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x0100
            r17 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            goto L_0x017e
        L_0x0100:
            r17 = 99999999999(0x174876e7ff, double:4.94065645836E-313)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x0110
            r17 = 10000000000(0x2540be400, double:4.9406564584E-314)
            goto L_0x017e
        L_0x0110:
            r17 = 999999999999(0xe8d4a50fff, double:4.940656458408E-312)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x011f
            r17 = 100000000000(0x174876e800, double:4.9406564584E-313)
            goto L_0x017e
        L_0x011f:
            r17 = 9999999999999(0x9184e729fff, double:4.940656458412E-311)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x012e
            r17 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            goto L_0x017e
        L_0x012e:
            r17 = 99999999999999(0x5af3107a3fff, double:4.9406564584124E-310)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x013d
            r17 = 10000000000000(0x9184e72a000, double:4.9406564584125E-311)
            goto L_0x017e
        L_0x013d:
            r17 = 999999999999999(0x38d7ea4c67fff, double:4.94065645841246E-309)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x014c
            r17 = 100000000000000(0x5af3107a4000, double:4.94065645841247E-310)
            goto L_0x017e
        L_0x014c:
            r17 = 9999999999999999(0x2386f26fc0ffff, double:5.431165199810527E-308)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x015b
            r17 = 1000000000000000(0x38d7ea4c68000, double:4.940656458412465E-309)
            goto L_0x017e
        L_0x015b:
            r17 = 99999999999999999(0x16345785d89ffff, double:5.620395787888204E-302)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x016a
            r17 = 10000000000000000(0x2386f26fc10000, double:5.431165199810528E-308)
            goto L_0x017e
        L_0x016a:
            r17 = 999999999999999999(0xde0b6b3a763ffff, double:7.832953389245684E-242)
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x0179
            r17 = 100000000000000000(0x16345785d8a0000, double:5.620395787888205E-302)
            goto L_0x017e
        L_0x0179:
            r17 = 1000000000000000000(0xde0b6b3a7640000, double:7.832953389245686E-242)
        L_0x017e:
            long r1 = r15 / r17
            int r3 = (int) r1
            switch(r3) {
                case 0: goto L_0x01b6;
                case 1: goto L_0x01af;
                case 2: goto L_0x01aa;
                case 3: goto L_0x01a5;
                case 4: goto L_0x019e;
                case 5: goto L_0x0199;
                case 6: goto L_0x0194;
                case 7: goto L_0x018f;
                case 8: goto L_0x018a;
                case 9: goto L_0x0185;
                default: goto L_0x0184;
            }
        L_0x0184:
            goto L_0x01bb
        L_0x0185:
            int r3 = r14 + 1
            r0[r14] = r5
            goto L_0x01ba
        L_0x018a:
            int r3 = r14 + 1
            r0[r14] = r8
            goto L_0x01ba
        L_0x018f:
            int r3 = r14 + 1
            r0[r14] = r9
            goto L_0x01ba
        L_0x0194:
            int r3 = r14 + 1
            r0[r14] = r4
            goto L_0x01ba
        L_0x0199:
            int r3 = r14 + 1
            r0[r14] = r7
            goto L_0x01ba
        L_0x019e:
            int r3 = r14 + 1
            r6 = 52
            r0[r14] = r6
            goto L_0x01ba
        L_0x01a5:
            int r3 = r14 + 1
            r0[r14] = r10
            goto L_0x01ba
        L_0x01aa:
            int r3 = r14 + 1
            r0[r14] = r11
            goto L_0x01ba
        L_0x01af:
            int r3 = r14 + 1
            r6 = 49
            r0[r14] = r6
            goto L_0x01ba
        L_0x01b6:
            int r3 = r14 + 1
            r0[r14] = r13
        L_0x01ba:
            r14 = r3
        L_0x01bb:
            int r3 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r3 != 0) goto L_0x01c0
            goto L_0x01d8
        L_0x01c0:
            java.lang.Long.signum(r17)
            long r1 = r1 * r17
            long r15 = r15 - r1
            r1 = 0
            int r3 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01d9
        L_0x01cc:
            int r1 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x01d8
            int r1 = r14 + 1
            r0[r14] = r13
            long r17 = r17 / r19
            r14 = r1
            goto L_0x01cc
        L_0x01d8:
            return r14
        L_0x01d9:
            long r17 = r17 / r19
            goto L_0x017e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ByteStringBuffer.getBytes(long):int");
    }

    public ByteStringBuffer append(byte b) {
        ensureCapacity(this.endPos + 1);
        byte[] bArr = this.array;
        int i = this.endPos;
        this.endPos = i + 1;
        bArr[i] = b;
        return this;
    }

    public ByteStringBuffer append(char c) {
        byte b = (byte) (c & 127);
        if (b == c) {
            ensureCapacity(this.endPos + 1);
            byte[] bArr = this.array;
            int i = this.endPos;
            this.endPos = i + 1;
            bArr[i] = b;
        } else {
            append((CharSequence) String.valueOf(c));
        }
        return this;
    }

    public ByteStringBuffer append(int i) {
        return append(TEMP_NUMBER_BUFFER.get(), 0, getBytes((long) i));
    }

    public ByteStringBuffer append(long j) {
        return append(TEMP_NUMBER_BUFFER.get(), 0, getBytes(j));
    }

    public ByteStringBuffer append(ByteString byteString) {
        if (byteString != null) {
            byteString.appendValueTo(this);
            return this;
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BYTE_STRING_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer append(ByteStringBuffer byteStringBuffer) {
        if (byteStringBuffer != null) {
            return append(byteStringBuffer.array, 0, byteStringBuffer.endPos);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BUFFER_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    public ByteStringBuffer append(CharSequence charSequence, int i, int i2) {
        if (charSequence != null) {
            int i3 = i2 - i;
            ensureCapacity(this.endPos + i3);
            while (true) {
                if (i >= i2) {
                    break;
                }
                char charAt = charSequence.charAt(i);
                byte b = (byte) (charAt & 127);
                if (b != charAt) {
                    append(StaticUtils.getBytes(charSequence.subSequence(i, i3).toString()));
                    break;
                }
                byte[] bArr = this.array;
                int i4 = this.endPos;
                this.endPos = i4 + 1;
                bArr[i4] = b;
                i++;
            }
            return this;
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_CHAR_SEQUENCE_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer append(boolean z) {
        byte[] bArr;
        int i;
        if (z) {
            bArr = TRUE_VALUE_BYTES;
            i = 4;
        } else {
            bArr = FALSE_VALUE_BYTES;
            i = 5;
        }
        return append(bArr, 0, i);
    }

    public ByteStringBuffer append(byte[] bArr) {
        if (bArr != null) {
            return append(bArr, 0, bArr.length);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer append(byte[] bArr, int i, int i2) {
        String str;
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
            Debug.debugCodingError(nullPointerException);
            throw nullPointerException;
        } else if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            if (i < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE.get(Integer.valueOf(i));
            } else if (i2 < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i2));
            } else {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else {
            if (i2 > 0) {
                ensureCapacity(this.endPos + i2);
                System.arraycopy(bArr, i, this.array, this.endPos, i2);
                this.endPos += i2;
            }
            return this;
        }
    }

    public ByteStringBuffer append(char[] cArr) {
        if (cArr != null) {
            return append(cArr, 0, cArr.length);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer append(char[] cArr, int i, int i2) {
        String str;
        int i3;
        if (cArr != null) {
            int i4 = 0;
            if (i < 0 || i2 < 0 || (i3 = i + i2) > cArr.length) {
                if (i < 0) {
                    str = UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE.get(Integer.valueOf(i));
                } else if (i2 < 0) {
                    str = UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i2));
                } else {
                    str = UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length));
                }
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
                Debug.debugCodingError(indexOutOfBoundsException);
                throw indexOutOfBoundsException;
            }
            if (i2 > 0) {
                ensureCapacity(this.endPos + i2);
                while (true) {
                    if (i4 < i2) {
                        byte b = (byte) (cArr[i] & 127);
                        if (b != cArr[i]) {
                            append((CharSequence) String.valueOf(cArr, i, i3 - i));
                            break;
                        }
                        byte[] bArr = this.array;
                        int i5 = this.endPos;
                        this.endPos = i5 + 1;
                        bArr[i5] = b;
                        i4++;
                        i++;
                    } else {
                        break;
                    }
                }
            }
            return this;
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public InputStream asInputStream() {
        return new ByteArrayInputStream(this.array, 0, this.endPos);
    }

    public int capacity() {
        return this.capacity;
    }

    public ByteStringBuffer clear() {
        this.endPos = 0;
        return this;
    }

    public ByteStringBuffer clear(boolean z) {
        this.endPos = 0;
        if (z) {
            Arrays.fill(this.array, (byte) 0);
        }
        return this;
    }

    public ByteStringBuffer delete(int i) {
        return delete(0, i);
    }

    public ByteStringBuffer delete(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE.get(Integer.valueOf(i)));
        } else if (i2 >= 0) {
            int i3 = i + i2;
            int i4 = this.endPos;
            if (i3 > i4) {
                throw new IndexOutOfBoundsException(UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.endPos)));
            } else if (i2 == 0) {
                return this;
            } else {
                if (i == 0) {
                    if (i2 == i4) {
                        this.endPos = 0;
                        return this;
                    }
                    int i5 = i4 - i2;
                    byte[] bArr = this.array;
                    System.arraycopy(bArr, i2, bArr, 0, i5);
                    this.endPos = i5;
                    return this;
                } else if (i3 == i4) {
                    this.endPos = i;
                    return this;
                } else {
                    byte[] bArr2 = this.array;
                    System.arraycopy(bArr2, i3, bArr2, i, i4 - i3);
                    this.endPos -= i2;
                    return this;
                }
            }
        } else {
            throw new IndexOutOfBoundsException(UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i2)));
        }
    }

    public ByteStringBuffer duplicate() {
        return new ByteStringBuffer(this.endPos).append(this);
    }

    public void ensureCapacity(int i) {
        int i2 = this.capacity;
        if (i2 < i) {
            int max = Math.max(i, (i2 * 2) + 2);
            byte[] bArr = new byte[max];
            System.arraycopy(this.array, 0, bArr, 0, this.capacity);
            this.array = bArr;
            this.capacity = max;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteStringBuffer)) {
            return false;
        }
        ByteStringBuffer byteStringBuffer = (ByteStringBuffer) obj;
        if (this.endPos != byteStringBuffer.endPos) {
            return false;
        }
        for (int i = 0; i < this.endPos; i++) {
            if (this.array[i] != byteStringBuffer.array[i]) {
                return false;
            }
        }
        return true;
    }

    public byte[] getBackingArray() {
        return this.array;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.endPos; i2++) {
            i += this.array[i2];
        }
        return i;
    }

    public ByteStringBuffer insert(int i, byte b) {
        String str;
        int i2;
        if (i < 0 || i > (i2 = this.endPos)) {
            if (i < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_POS_NEGATIVE.get(Integer.valueOf(i));
            } else {
                str = UtilityMessages.ERR_BS_BUFFER_POS_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(this.endPos));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else if (i == i2) {
            return append(b);
        } else {
            ensureCapacity(i2 + 1);
            byte[] bArr = this.array;
            System.arraycopy(bArr, i, bArr, i + 1, this.endPos - i);
            this.array[i] = b;
            this.endPos++;
            return this;
        }
    }

    public ByteStringBuffer insert(int i, char c) {
        String str;
        int i2;
        if (i < 0 || i > (i2 = this.endPos)) {
            if (i < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_POS_NEGATIVE.get(Integer.valueOf(i));
            } else {
                str = UtilityMessages.ERR_BS_BUFFER_POS_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(this.endPos));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else if (i == i2) {
            return append(c);
        } else {
            byte b = (byte) (c & 127);
            if (b == c) {
                ensureCapacity(i2 + 1);
                byte[] bArr = this.array;
                System.arraycopy(bArr, i, bArr, i + 1, this.endPos - i);
                this.array[i] = b;
                this.endPos++;
            } else {
                insert(i, (CharSequence) String.valueOf(c));
            }
            return this;
        }
    }

    public ByteStringBuffer insert(int i, int i2) {
        return insert(i, TEMP_NUMBER_BUFFER.get(), 0, getBytes((long) i2));
    }

    public ByteStringBuffer insert(int i, long j) {
        return insert(i, TEMP_NUMBER_BUFFER.get(), 0, getBytes(j));
    }

    public ByteStringBuffer insert(int i, ByteString byteString) {
        if (byteString != null) {
            return insert(i, byteString.getValue());
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BYTE_STRING_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer insert(int i, ByteStringBuffer byteStringBuffer) {
        if (byteStringBuffer != null) {
            return insert(i, byteStringBuffer.array, 0, byteStringBuffer.endPos);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BUFFER_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer insert(int i, CharSequence charSequence) {
        int i2;
        if (charSequence == null) {
            NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_CHAR_SEQUENCE_NULL.get());
            Debug.debugCodingError(nullPointerException);
            throw nullPointerException;
        } else if (i >= 0 && i <= (i2 = this.endPos)) {
            return i == i2 ? append(charSequence) : insert(i, StaticUtils.getBytes(charSequence.toString()));
        } else {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(i < 0 ? UtilityMessages.ERR_BS_BUFFER_POS_NEGATIVE.get(Integer.valueOf(i)) : UtilityMessages.ERR_BS_BUFFER_POS_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(this.endPos)));
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        }
    }

    public ByteStringBuffer insert(int i, boolean z) {
        byte[] bArr;
        int i2;
        if (z) {
            bArr = TRUE_VALUE_BYTES;
            i2 = 4;
        } else {
            bArr = FALSE_VALUE_BYTES;
            i2 = 5;
        }
        return insert(i, bArr, 0, i2);
    }

    public ByteStringBuffer insert(int i, byte[] bArr) {
        if (bArr != null) {
            return insert(i, bArr, 0, bArr.length);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer insert(int i, byte[] bArr, int i2, int i3) {
        String str;
        Object[] objArr;
        UtilityMessages utilityMessages;
        Object[] objArr2;
        UtilityMessages utilityMessages2;
        int i4;
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
            Debug.debugCodingError(nullPointerException);
            throw nullPointerException;
        } else if (i < 0 || i > (i4 = this.endPos) || i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            if (i < 0) {
                utilityMessages = UtilityMessages.ERR_BS_BUFFER_POS_NEGATIVE;
                objArr = new Object[]{Integer.valueOf(i)};
            } else if (i <= this.endPos) {
                if (i2 < 0) {
                    utilityMessages2 = UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE;
                    objArr2 = new Object[]{Integer.valueOf(i2)};
                } else if (i3 < 0) {
                    utilityMessages2 = UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE;
                    objArr2 = new Object[]{Integer.valueOf(i3)};
                } else {
                    str = UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
                    IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
                    Debug.debugCodingError(indexOutOfBoundsException);
                    throw indexOutOfBoundsException;
                }
                str = utilityMessages2.get(objArr2);
                IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(str);
                Debug.debugCodingError(indexOutOfBoundsException2);
                throw indexOutOfBoundsException2;
            } else {
                utilityMessages = UtilityMessages.ERR_BS_BUFFER_POS_TOO_LARGE;
                objArr = new Object[]{Integer.valueOf(i), Integer.valueOf(this.endPos)};
            }
            str = utilityMessages.get(objArr);
            IndexOutOfBoundsException indexOutOfBoundsException22 = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException22);
            throw indexOutOfBoundsException22;
        } else if (i3 == 0) {
            return this;
        } else {
            if (i == i4) {
                return append(bArr, i2, i3);
            }
            ensureCapacity(i4 + i3);
            byte[] bArr2 = this.array;
            System.arraycopy(bArr2, i, bArr2, i + i3, this.endPos - i);
            System.arraycopy(bArr, i2, this.array, i, i3);
            this.endPos += i3;
            return this;
        }
    }

    public ByteStringBuffer insert(int i, char[] cArr) {
        if (cArr != null) {
            return insert(i, (CharSequence) new String(cArr, 0, cArr.length));
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer insert(int i, char[] cArr, int i2, int i3) {
        if (cArr != null) {
            return insert(i, (CharSequence) new String(cArr, i2, i3));
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public boolean isEmpty() {
        return this.endPos == 0;
    }

    public int length() {
        return this.endPos;
    }

    public ByteStringBuffer set(byte b) {
        this.endPos = 0;
        return append(b);
    }

    public ByteStringBuffer set(char c) {
        this.endPos = 0;
        return append(c);
    }

    public ByteStringBuffer set(int i) {
        return set(TEMP_NUMBER_BUFFER.get(), 0, getBytes((long) i));
    }

    public ByteStringBuffer set(long j) {
        return set(TEMP_NUMBER_BUFFER.get(), 0, getBytes(j));
    }

    public ByteStringBuffer set(ByteString byteString) {
        if (byteString != null) {
            this.endPos = 0;
            byteString.appendValueTo(this);
            return this;
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BYTE_STRING_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer set(ByteStringBuffer byteStringBuffer) {
        if (byteStringBuffer != null) {
            this.endPos = 0;
            return append(byteStringBuffer.array, 0, byteStringBuffer.endPos);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_BUFFER_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer set(CharSequence charSequence) {
        if (charSequence != null) {
            this.endPos = 0;
            return append(charSequence);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_CHAR_SEQUENCE_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer set(boolean z) {
        byte[] bArr;
        int i;
        if (z) {
            bArr = TRUE_VALUE_BYTES;
            i = 4;
        } else {
            bArr = FALSE_VALUE_BYTES;
            i = 5;
        }
        return set(bArr, 0, i);
    }

    public ByteStringBuffer set(byte[] bArr) {
        if (bArr != null) {
            this.endPos = 0;
            return append(bArr, 0, bArr.length);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer set(byte[] bArr, int i, int i2) {
        String str;
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
            Debug.debugCodingError(nullPointerException);
            throw nullPointerException;
        } else if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            if (i < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE.get(Integer.valueOf(i));
            } else if (i2 < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i2));
            } else {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else {
            this.endPos = 0;
            return append(bArr, i, i2);
        }
    }

    public ByteStringBuffer set(char[] cArr) {
        if (cArr != null) {
            this.endPos = 0;
            return append(cArr, 0, cArr.length);
        }
        NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
        Debug.debugCodingError(nullPointerException);
        throw nullPointerException;
    }

    public ByteStringBuffer set(char[] cArr, int i, int i2) {
        String str;
        if (cArr == null) {
            NullPointerException nullPointerException = new NullPointerException(UtilityMessages.ERR_BS_BUFFER_ARRAY_NULL.get());
            Debug.debugCodingError(nullPointerException);
            throw nullPointerException;
        } else if (i < 0 || i2 < 0 || i + i2 > cArr.length) {
            if (i < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_NEGATIVE.get(Integer.valueOf(i));
            } else if (i2 < 0) {
                str = UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i2));
            } else {
                str = UtilityMessages.ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE.get(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cArr.length));
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            Debug.debugCodingError(indexOutOfBoundsException);
            throw indexOutOfBoundsException;
        } else {
            this.endPos = 0;
            return append(cArr, i, i2);
        }
    }

    public void setCapacity(int i) {
        if (i >= 0) {
            int i2 = this.capacity;
            if (i2 != i) {
                if (i2 < i) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.array, 0, bArr, 0, i2);
                    this.array = bArr;
                } else {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(this.array, 0, bArr2, 0, i);
                    this.array = bArr2;
                    this.endPos = Math.min(this.endPos, i);
                }
                this.capacity = i;
                return;
            }
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(UtilityMessages.ERR_BS_BUFFER_CAPACITY_NEGATIVE.get(Integer.valueOf(i)));
        Debug.debugCodingError(indexOutOfBoundsException);
        throw indexOutOfBoundsException;
    }

    public void setLength(int i) {
        if (i >= 0) {
            if (i > this.endPos) {
                ensureCapacity(i);
                Arrays.fill(this.array, this.endPos, i, (byte) 0);
            }
            this.endPos = i;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(UtilityMessages.ERR_BS_BUFFER_LENGTH_NEGATIVE.get(Integer.valueOf(i)));
        Debug.debugCodingError(indexOutOfBoundsException);
        throw indexOutOfBoundsException;
    }

    public byte[] toByteArray() {
        int i = this.endPos;
        byte[] bArr = new byte[i];
        System.arraycopy(this.array, 0, bArr, 0, i);
        return bArr;
    }

    public ByteString toByteString() {
        return new ASN1OctetString(toByteArray());
    }

    public String toString() {
        return StaticUtils.toUTF8String(this.array, 0, this.endPos);
    }

    public ByteStringBuffer trimToSize() {
        int i = this.endPos;
        if (i != this.capacity) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.array, 0, bArr, 0, i);
            this.array = bArr;
            this.capacity = this.endPos;
        }
        return this;
    }

    public void write(OutputStream outputStream) {
        outputStream.write(this.array, 0, this.endPos);
    }
}
