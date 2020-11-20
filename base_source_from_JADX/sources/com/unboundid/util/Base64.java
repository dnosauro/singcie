package com.unboundid.util;

import java.io.IOException;
import java.text.ParseException;

public final class Base64 {
    private static final char[] BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
    private static final char[] BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i;
        Validator.ensureNotNull(str);
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        if (length % 4 == 0) {
            int i2 = (length / 4) * 3;
            if (str.charAt(length - 2) == '=') {
                i2 -= 2;
            } else if (str.charAt(length - 1) == '=') {
                i2--;
            }
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4 = i) {
                i = i4;
                int i5 = 0;
                int i6 = 0;
                while (i5 < 4) {
                    int i7 = i6 << 6;
                    int i8 = i + 1;
                    char charAt = str.charAt(i);
                    if (charAt == '+') {
                        i6 = i7 | 62;
                    } else if (charAt != '=') {
                        switch (charAt) {
                            case '/':
                                i6 = i7 | 63;
                                break;
                            case '0':
                                i6 = i7 | 52;
                                break;
                            case '1':
                                i6 = i7 | 53;
                                break;
                            case '2':
                                i6 = i7 | 54;
                                break;
                            case '3':
                                i6 = i7 | 55;
                                break;
                            case '4':
                                i6 = i7 | 56;
                                break;
                            case '5':
                                i6 = i7 | 57;
                                break;
                            case '6':
                                i6 = i7 | 58;
                                break;
                            case '7':
                                i6 = i7 | 59;
                                break;
                            case '8':
                                i6 = i7 | 60;
                                break;
                            case '9':
                                i6 = i7 | 61;
                                break;
                            default:
                                switch (charAt) {
                                    case 'A':
                                        i6 = i7 | 0;
                                        break;
                                    case 'B':
                                        i6 = i7 | 1;
                                        break;
                                    case 'C':
                                        i6 = i7 | 2;
                                        break;
                                    case 'D':
                                        i6 = i7 | 3;
                                        break;
                                    case 'E':
                                        i6 = i7 | 4;
                                        break;
                                    case 'F':
                                        i6 = i7 | 5;
                                        break;
                                    case 'G':
                                        i6 = i7 | 6;
                                        break;
                                    case 'H':
                                        i6 = i7 | 7;
                                        break;
                                    case 'I':
                                        i6 = i7 | 8;
                                        break;
                                    case 'J':
                                        i6 = i7 | 9;
                                        break;
                                    case 'K':
                                        i6 = i7 | 10;
                                        break;
                                    case 'L':
                                        i6 = i7 | 11;
                                        break;
                                    case 'M':
                                        i6 = i7 | 12;
                                        break;
                                    case 'N':
                                        i6 = i7 | 13;
                                        break;
                                    case 'O':
                                        i6 = i7 | 14;
                                        break;
                                    case 'P':
                                        i6 = i7 | 15;
                                        break;
                                    case 'Q':
                                        i6 = i7 | 16;
                                        break;
                                    case 'R':
                                        i6 = i7 | 17;
                                        break;
                                    case 'S':
                                        i6 = i7 | 18;
                                        break;
                                    case 'T':
                                        i6 = i7 | 19;
                                        break;
                                    case 'U':
                                        i6 = i7 | 20;
                                        break;
                                    case 'V':
                                        i6 = i7 | 21;
                                        break;
                                    case 'W':
                                        i6 = i7 | 22;
                                        break;
                                    case 'X':
                                        i6 = i7 | 23;
                                        break;
                                    case 'Y':
                                        i6 = i7 | 24;
                                        break;
                                    case 'Z':
                                        i6 = i7 | 25;
                                        break;
                                    default:
                                        switch (charAt) {
                                            case 'a':
                                                i6 = i7 | 26;
                                                break;
                                            case 'b':
                                                i6 = i7 | 27;
                                                break;
                                            case 'c':
                                                i6 = i7 | 28;
                                                break;
                                            case 'd':
                                                i6 = i7 | 29;
                                                break;
                                            case 'e':
                                                i6 = i7 | 30;
                                                break;
                                            case 'f':
                                                i6 = i7 | 31;
                                                break;
                                            case 'g':
                                                i6 = i7 | 32;
                                                break;
                                            case 'h':
                                                i6 = i7 | 33;
                                                break;
                                            case 'i':
                                                i6 = i7 | 34;
                                                break;
                                            case 'j':
                                                i6 = i7 | 35;
                                                break;
                                            case 'k':
                                                i6 = i7 | 36;
                                                break;
                                            case 'l':
                                                i6 = i7 | 37;
                                                break;
                                            case 'm':
                                                i6 = i7 | 38;
                                                break;
                                            case 'n':
                                                i6 = i7 | 39;
                                                break;
                                            case 'o':
                                                i6 = i7 | 40;
                                                break;
                                            case 'p':
                                                i6 = i7 | 41;
                                                break;
                                            case 'q':
                                                i6 = i7 | 42;
                                                break;
                                            case 'r':
                                                i6 = i7 | 43;
                                                break;
                                            case 's':
                                                i6 = i7 | 44;
                                                break;
                                            case 't':
                                                i6 = i7 | 45;
                                                break;
                                            case 'u':
                                                i6 = i7 | 46;
                                                break;
                                            case 'v':
                                                i6 = i7 | 47;
                                                break;
                                            case 'w':
                                                i6 = i7 | 48;
                                                break;
                                            case 'x':
                                                i6 = i7 | 49;
                                                break;
                                            case 'y':
                                                i6 = i7 | 50;
                                                break;
                                            case 'z':
                                                i6 = i7 | 51;
                                                break;
                                            default:
                                                int i9 = i8 - 1;
                                                throw new ParseException(UtilityMessages.ERR_BASE64_DECODE_UNEXPECTED_CHAR.get(Character.valueOf(str.charAt(i9))), i9);
                                        }
                                }
                        }
                    } else {
                        switch (length - i8) {
                            case 0:
                                int i10 = i7 >> 8;
                                bArr[i3] = (byte) ((i10 >> 8) & 255);
                                bArr[i3 + 1] = (byte) (i10 & 255);
                                return bArr;
                            case 1:
                                bArr[i3] = (byte) ((i7 >> 10) & 255);
                                return bArr;
                            default:
                                int i11 = i8 - 1;
                                throw new ParseException(UtilityMessages.ERR_BASE64_DECODE_UNEXPECTED_EQUAL.get(Integer.valueOf(i11)), i11);
                        }
                    }
                    i5++;
                    i = i8;
                }
                int i12 = i3 + 1;
                bArr[i3] = (byte) ((i6 >> 16) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((i6 >> 8) & 255);
                bArr[i13] = (byte) (i6 & 255);
                i3 = i13 + 1;
            }
            return bArr;
        }
        throw new ParseException(UtilityMessages.ERR_BASE64_DECODE_INVALID_LENGTH.get(), length);
    }

    public static String decodeToString(String str) {
        Validator.ensureNotNull(str);
        return StaticUtils.toUTF8String(decode(str));
    }

    public static String encode(String str) {
        Validator.ensureNotNull(str);
        return encode(StaticUtils.getBytes(str));
    }

    public static String encode(byte[] bArr) {
        Validator.ensureNotNull(bArr);
        StringBuilder sb = new StringBuilder(((bArr.length * 4) / 3) + 1);
        encode(BASE64_ALPHABET, bArr, 0, bArr.length, sb, "=");
        return sb.toString();
    }

    public static void encode(String str, ByteStringBuffer byteStringBuffer) {
        Validator.ensureNotNull(str);
        encode(StaticUtils.getBytes(str), byteStringBuffer);
    }

    public static void encode(String str, StringBuilder sb) {
        Validator.ensureNotNull(str);
        encode(StaticUtils.getBytes(str), sb);
    }

    public static void encode(byte[] bArr, int i, int i2, ByteStringBuffer byteStringBuffer) {
        encode(BASE64_ALPHABET, bArr, i, i2, byteStringBuffer, "=");
    }

    public static void encode(byte[] bArr, int i, int i2, StringBuilder sb) {
        encode(BASE64_ALPHABET, bArr, i, i2, sb, "=");
    }

    public static void encode(byte[] bArr, ByteStringBuffer byteStringBuffer) {
        encode(BASE64_ALPHABET, bArr, 0, bArr.length, byteStringBuffer, "=");
    }

    public static void encode(byte[] bArr, StringBuilder sb) {
        encode(BASE64_ALPHABET, bArr, 0, bArr.length, sb, "=");
    }

    private static void encode(char[] cArr, byte[] bArr, int i, int i2, Appendable appendable, String str) {
        Validator.ensureNotNull(bArr);
        int i3 = 0;
        boolean z = true;
        Validator.ensureTrue(bArr.length >= i);
        int i4 = i + i2;
        if (bArr.length < i4) {
            z = false;
        }
        Validator.ensureTrue(z);
        if (i2 != 0) {
            while (i3 < i2 / 3) {
                try {
                    int i5 = i + 1;
                    int i6 = i5 + 1;
                    byte b = ((bArr[i] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                    appendable.append(cArr[(b >> 18) & 63]);
                    appendable.append(cArr[(b >> 12) & 63]);
                    appendable.append(cArr[(b >> 6) & 63]);
                    appendable.append(cArr[b & 63]);
                    i3++;
                    i = i6 + 1;
                } catch (IOException e) {
                    Debug.debugException(e);
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            switch (i4 - i) {
                case 1:
                    int i7 = (bArr[i] & 255) << Tnaf.POW_2_WIDTH;
                    appendable.append(cArr[(i7 >> 18) & 63]);
                    appendable.append(cArr[(i7 >> 12) & 63]);
                    if (str != null) {
                        appendable.append(str);
                        appendable.append(str);
                        return;
                    }
                    return;
                case 2:
                    int i8 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << Tnaf.POW_2_WIDTH);
                    appendable.append(cArr[(i8 >> 18) & 63]);
                    appendable.append(cArr[(i8 >> 12) & 63]);
                    appendable.append(cArr[(i8 >> 6) & 63]);
                    if (str != null) {
                        appendable.append(str);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static byte[] urlDecode(String str) {
        int i;
        char c;
        int i2;
        int i3;
        Validator.ensureNotNull(str);
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        ByteStringBuffer byteStringBuffer = new ByteStringBuffer(length);
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                int i5 = i4;
                int i6 = 0;
                int i7 = 0;
                while (i6 < 4) {
                    if (i5 >= length) {
                        i = i5 + 1;
                        c = '=';
                    } else {
                        i = i5 + 1;
                        c = str.charAt(i5);
                    }
                    i2 = i7 << 6;
                    if (c != '%') {
                        if (c == '-') {
                            i7 = i2 | 62;
                        } else if (c != '=') {
                            if (c != '_') {
                                switch (c) {
                                    case '0':
                                        i7 = i2 | 52;
                                        break;
                                    case '1':
                                        i7 = i2 | 53;
                                        break;
                                    case '2':
                                        i7 = i2 | 54;
                                        break;
                                    case '3':
                                        i7 = i2 | 55;
                                        break;
                                    case '4':
                                        i7 = i2 | 56;
                                        break;
                                    case '5':
                                        i7 = i2 | 57;
                                        break;
                                    case '6':
                                        i7 = i2 | 58;
                                        break;
                                    case '7':
                                        i7 = i2 | 59;
                                        break;
                                    case '8':
                                        i7 = i2 | 60;
                                        break;
                                    case '9':
                                        i7 = i2 | 61;
                                        break;
                                    default:
                                        switch (c) {
                                            case 'A':
                                                i7 = i2 | 0;
                                                break;
                                            case 'B':
                                                i7 = i2 | 1;
                                                break;
                                            case 'C':
                                                i7 = i2 | 2;
                                                break;
                                            case 'D':
                                                i7 = i2 | 3;
                                                break;
                                            case 'E':
                                                i7 = i2 | 4;
                                                break;
                                            case 'F':
                                                i7 = i2 | 5;
                                                break;
                                            case 'G':
                                                i7 = i2 | 6;
                                                break;
                                            case 'H':
                                                i7 = i2 | 7;
                                                break;
                                            case 'I':
                                                i7 = i2 | 8;
                                                break;
                                            case 'J':
                                                i7 = i2 | 9;
                                                break;
                                            case 'K':
                                                i7 = i2 | 10;
                                                break;
                                            case 'L':
                                                i7 = i2 | 11;
                                                break;
                                            case 'M':
                                                i7 = i2 | 12;
                                                break;
                                            case 'N':
                                                i7 = i2 | 13;
                                                break;
                                            case 'O':
                                                i7 = i2 | 14;
                                                break;
                                            case 'P':
                                                i7 = i2 | 15;
                                                break;
                                            case 'Q':
                                                i7 = i2 | 16;
                                                break;
                                            case 'R':
                                                i7 = i2 | 17;
                                                break;
                                            case 'S':
                                                i7 = i2 | 18;
                                                break;
                                            case 'T':
                                                i7 = i2 | 19;
                                                break;
                                            case 'U':
                                                i7 = i2 | 20;
                                                break;
                                            case 'V':
                                                i7 = i2 | 21;
                                                break;
                                            case 'W':
                                                i7 = i2 | 22;
                                                break;
                                            case 'X':
                                                i7 = i2 | 23;
                                                break;
                                            case 'Y':
                                                i7 = i2 | 24;
                                                break;
                                            case 'Z':
                                                i7 = i2 | 25;
                                                break;
                                            default:
                                                switch (c) {
                                                    case 'a':
                                                        i7 = i2 | 26;
                                                        break;
                                                    case 'b':
                                                        i7 = i2 | 27;
                                                        break;
                                                    case 'c':
                                                        i7 = i2 | 28;
                                                        break;
                                                    case 'd':
                                                        i7 = i2 | 29;
                                                        break;
                                                    case 'e':
                                                        i7 = i2 | 30;
                                                        break;
                                                    case 'f':
                                                        i7 = i2 | 31;
                                                        break;
                                                    case 'g':
                                                        i7 = i2 | 32;
                                                        break;
                                                    case 'h':
                                                        i7 = i2 | 33;
                                                        break;
                                                    case 'i':
                                                        i7 = i2 | 34;
                                                        break;
                                                    case 'j':
                                                        i7 = i2 | 35;
                                                        break;
                                                    case 'k':
                                                        i7 = i2 | 36;
                                                        break;
                                                    case 'l':
                                                        i7 = i2 | 37;
                                                        break;
                                                    case 'm':
                                                        i7 = i2 | 38;
                                                        break;
                                                    case 'n':
                                                        i7 = i2 | 39;
                                                        break;
                                                    case 'o':
                                                        i7 = i2 | 40;
                                                        break;
                                                    case 'p':
                                                        i7 = i2 | 41;
                                                        break;
                                                    case 'q':
                                                        i7 = i2 | 42;
                                                        break;
                                                    case 'r':
                                                        i7 = i2 | 43;
                                                        break;
                                                    case 's':
                                                        i7 = i2 | 44;
                                                        break;
                                                    case 't':
                                                        i7 = i2 | 45;
                                                        break;
                                                    case 'u':
                                                        i7 = i2 | 46;
                                                        break;
                                                    case 'v':
                                                        i7 = i2 | 47;
                                                        break;
                                                    case 'w':
                                                        i7 = i2 | 48;
                                                        break;
                                                    case 'x':
                                                        i7 = i2 | 49;
                                                        break;
                                                    case 'y':
                                                        i7 = i2 | 50;
                                                        break;
                                                    case 'z':
                                                        i7 = i2 | 51;
                                                        break;
                                                    default:
                                                        int i8 = i - 1;
                                                        throw new ParseException(UtilityMessages.ERR_BASE64_DECODE_UNEXPECTED_CHAR.get(Character.valueOf(str.charAt(i8))), i8);
                                                }
                                        }
                                }
                            } else {
                                i7 = i2 | 63;
                            }
                        }
                        i6++;
                        i5 = i;
                    }
                }
                byteStringBuffer.append((byte) ((i7 >> 16) & 255));
                byteStringBuffer.append((byte) ((i7 >> 8) & 255));
                byteStringBuffer.append((byte) (i7 & 255));
                i4 = i5;
            }
        }
        int i9 = i - 1;
        switch (i9 % 4) {
            case 2:
                i3 = i2 >> 10;
                break;
            case 3:
                i3 = i2 >> 8;
                byteStringBuffer.append((byte) ((i3 >> 8) & 255));
                break;
            default:
                throw new ParseException(UtilityMessages.ERR_BASE64_URLDECODE_INVALID_LENGTH.get(), i9);
        }
        byteStringBuffer.append((byte) (i3 & 255));
        return byteStringBuffer.toByteArray();
    }

    public static String urlDecodeToString(String str) {
        Validator.ensureNotNull(str);
        return StaticUtils.toUTF8String(urlDecode(str));
    }

    public static String urlEncode(String str, boolean z) {
        return urlEncode(StaticUtils.getBytes(str), z);
    }

    public static String urlEncode(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder(((bArr.length * 4) / 3) + 6);
        encode(BASE64URL_ALPHABET, bArr, 0, bArr.length, sb, z ? "%3d" : null);
        return sb.toString();
    }

    public static void urlEncode(String str, ByteStringBuffer byteStringBuffer, boolean z) {
        byte[] bytes = StaticUtils.getBytes(str);
        encode(BASE64_ALPHABET, bytes, 0, bytes.length, byteStringBuffer, z ? "%3d" : null);
    }

    public static void urlEncode(String str, StringBuilder sb, boolean z) {
        byte[] bytes = StaticUtils.getBytes(str);
        encode(BASE64_ALPHABET, bytes, 0, bytes.length, sb, z ? "%3d" : null);
    }

    public static void urlEncode(byte[] bArr, int i, int i2, ByteStringBuffer byteStringBuffer, boolean z) {
        encode(BASE64URL_ALPHABET, bArr, i, i2, byteStringBuffer, z ? "%3d" : null);
    }

    public static void urlEncode(byte[] bArr, int i, int i2, StringBuilder sb, boolean z) {
        encode(BASE64URL_ALPHABET, bArr, i, i2, sb, z ? "%3d" : null);
    }
}
