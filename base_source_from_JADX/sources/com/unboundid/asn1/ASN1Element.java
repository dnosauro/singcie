package com.unboundid.asn1;

import com.parse.ParseException;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.spongycastle.asn1.eac.CertificateBody;

public class ASN1Element implements Serializable {
    private static final long serialVersionUID = -1871166128693521335L;
    private int hashCode = -1;
    private final byte type;
    private final byte[] value;
    private final int valueLength;
    private final int valueOffset;

    public ASN1Element(byte b) {
        this.type = b;
        this.value = ASN1Constants.NO_VALUE;
        this.valueOffset = 0;
        this.valueLength = 0;
    }

    public ASN1Element(byte b, byte[] bArr) {
        this.type = b;
        if (bArr == null) {
            this.value = ASN1Constants.NO_VALUE;
        } else {
            this.value = bArr;
        }
        this.valueOffset = 0;
        this.valueLength = this.value.length;
    }

    public ASN1Element(byte b, byte[] bArr, int i, int i2) {
        this.type = b;
        this.value = bArr;
        this.valueOffset = i;
        this.valueLength = i2;
    }

    public static ASN1Element decode(byte[] bArr) {
        int i;
        try {
            int i2 = bArr[1] & Byte.MAX_VALUE;
            if (i2 != bArr[1]) {
                int i3 = 0;
                i = 2;
                byte b = 0;
                while (i3 < i2) {
                    b = (b << 8) | (bArr[i] & 255);
                    i3++;
                    i++;
                }
                i2 = b;
            } else {
                i = 2;
            }
            if (bArr.length - i == i2) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                return new ASN1Element(bArr[0], bArr2);
            }
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH.get(Integer.valueOf(i2), Integer.valueOf(bArr.length - i)));
        } catch (ASN1Exception e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION.get(e2), e2);
        }
    }

    public static byte[] encodeLength(int i) {
        switch (i) {
            case 0:
                return ASN1Constants.LENGTH_0;
            case 1:
                return ASN1Constants.LENGTH_1;
            case 2:
                return ASN1Constants.LENGTH_2;
            case 3:
                return ASN1Constants.LENGTH_3;
            case 4:
                return ASN1Constants.LENGTH_4;
            case 5:
                return ASN1Constants.LENGTH_5;
            case 6:
                return ASN1Constants.LENGTH_6;
            case 7:
                return ASN1Constants.LENGTH_7;
            case 8:
                return ASN1Constants.LENGTH_8;
            case 9:
                return ASN1Constants.LENGTH_9;
            case 10:
                return ASN1Constants.LENGTH_10;
            case 11:
                return ASN1Constants.LENGTH_11;
            case 12:
                return ASN1Constants.LENGTH_12;
            case 13:
                return ASN1Constants.LENGTH_13;
            case 14:
                return ASN1Constants.LENGTH_14;
            case 15:
                return ASN1Constants.LENGTH_15;
            case 16:
                return ASN1Constants.LENGTH_16;
            case 17:
                return ASN1Constants.LENGTH_17;
            case 18:
                return ASN1Constants.LENGTH_18;
            case 19:
                return ASN1Constants.LENGTH_19;
            case 20:
                return ASN1Constants.LENGTH_20;
            case 21:
                return ASN1Constants.LENGTH_21;
            case 22:
                return ASN1Constants.LENGTH_22;
            case 23:
                return ASN1Constants.LENGTH_23;
            case 24:
                return ASN1Constants.LENGTH_24;
            case 25:
                return ASN1Constants.LENGTH_25;
            case 26:
                return ASN1Constants.LENGTH_26;
            case 27:
                return ASN1Constants.LENGTH_27;
            case 28:
                return ASN1Constants.LENGTH_28;
            case 29:
                return ASN1Constants.LENGTH_29;
            case 30:
                return ASN1Constants.LENGTH_30;
            case 31:
                return ASN1Constants.LENGTH_31;
            case 32:
                return ASN1Constants.LENGTH_32;
            case 33:
                return ASN1Constants.LENGTH_33;
            case 34:
                return ASN1Constants.LENGTH_34;
            case 35:
                return ASN1Constants.LENGTH_35;
            case 36:
                return ASN1Constants.LENGTH_36;
            case 37:
                return ASN1Constants.LENGTH_37;
            case 38:
                return ASN1Constants.LENGTH_38;
            case 39:
                return ASN1Constants.LENGTH_39;
            case 40:
                return ASN1Constants.LENGTH_40;
            case 41:
                return ASN1Constants.LENGTH_41;
            case 42:
                return ASN1Constants.LENGTH_42;
            case 43:
                return ASN1Constants.LENGTH_43;
            case 44:
                return ASN1Constants.LENGTH_44;
            case 45:
                return ASN1Constants.LENGTH_45;
            case 46:
                return ASN1Constants.LENGTH_46;
            case 47:
                return ASN1Constants.LENGTH_47;
            case 48:
                return ASN1Constants.LENGTH_48;
            case 49:
                return ASN1Constants.LENGTH_49;
            case 50:
                return ASN1Constants.LENGTH_50;
            case 51:
                return ASN1Constants.LENGTH_51;
            case 52:
                return ASN1Constants.LENGTH_52;
            case 53:
                return ASN1Constants.LENGTH_53;
            case 54:
                return ASN1Constants.LENGTH_54;
            case 55:
                return ASN1Constants.LENGTH_55;
            case 56:
                return ASN1Constants.LENGTH_56;
            case 57:
                return ASN1Constants.LENGTH_57;
            case 58:
                return ASN1Constants.LENGTH_58;
            case 59:
                return ASN1Constants.LENGTH_59;
            case 60:
                return ASN1Constants.LENGTH_60;
            case 61:
                return ASN1Constants.LENGTH_61;
            case 62:
                return ASN1Constants.LENGTH_62;
            case 63:
                return ASN1Constants.LENGTH_63;
            case 64:
                return ASN1Constants.LENGTH_64;
            case 65:
                return ASN1Constants.LENGTH_65;
            case 66:
                return ASN1Constants.LENGTH_66;
            case 67:
                return ASN1Constants.LENGTH_67;
            case 68:
                return ASN1Constants.LENGTH_68;
            case 69:
                return ASN1Constants.LENGTH_69;
            case 70:
                return ASN1Constants.LENGTH_70;
            case 71:
                return ASN1Constants.LENGTH_71;
            case 72:
                return ASN1Constants.LENGTH_72;
            case 73:
                return ASN1Constants.LENGTH_73;
            case 74:
                return ASN1Constants.LENGTH_74;
            case 75:
                return ASN1Constants.LENGTH_75;
            case 76:
                return ASN1Constants.LENGTH_76;
            case 77:
                return ASN1Constants.LENGTH_77;
            case 78:
                return ASN1Constants.LENGTH_78;
            case 79:
                return ASN1Constants.LENGTH_79;
            case 80:
                return ASN1Constants.LENGTH_80;
            case 81:
                return ASN1Constants.LENGTH_81;
            case 82:
                return ASN1Constants.LENGTH_82;
            case 83:
                return ASN1Constants.LENGTH_83;
            case 84:
                return ASN1Constants.LENGTH_84;
            case 85:
                return ASN1Constants.LENGTH_85;
            case 86:
                return ASN1Constants.LENGTH_86;
            case 87:
                return ASN1Constants.LENGTH_87;
            case 88:
                return ASN1Constants.LENGTH_88;
            case 89:
                return ASN1Constants.LENGTH_89;
            case 90:
                return ASN1Constants.LENGTH_90;
            case 91:
                return ASN1Constants.LENGTH_91;
            case 92:
                return ASN1Constants.LENGTH_92;
            case 93:
                return ASN1Constants.LENGTH_93;
            case 94:
                return ASN1Constants.LENGTH_94;
            case 95:
                return ASN1Constants.LENGTH_95;
            case 96:
                return ASN1Constants.LENGTH_96;
            case 97:
                return ASN1Constants.LENGTH_97;
            case 98:
                return ASN1Constants.LENGTH_98;
            case 99:
                return ASN1Constants.LENGTH_99;
            case 100:
                return ASN1Constants.LENGTH_100;
            case 101:
                return ASN1Constants.LENGTH_101;
            case 102:
                return ASN1Constants.LENGTH_102;
            case 103:
                return ASN1Constants.LENGTH_103;
            case 104:
                return ASN1Constants.LENGTH_104;
            case 105:
                return ASN1Constants.LENGTH_105;
            case 106:
                return ASN1Constants.LENGTH_106;
            case 107:
                return ASN1Constants.LENGTH_107;
            case 108:
                return ASN1Constants.LENGTH_108;
            case 109:
                return ASN1Constants.LENGTH_109;
            case 110:
                return ASN1Constants.LENGTH_110;
            case 111:
                return ASN1Constants.LENGTH_111;
            case 112:
                return ASN1Constants.LENGTH_112;
            case 113:
                return ASN1Constants.LENGTH_113;
            case 114:
                return ASN1Constants.LENGTH_114;
            case 115:
                return ASN1Constants.LENGTH_115;
            case 116:
                return ASN1Constants.LENGTH_116;
            case 117:
                return ASN1Constants.LENGTH_117;
            case 118:
                return ASN1Constants.LENGTH_118;
            case 119:
                return ASN1Constants.LENGTH_119;
            case 120:
                return ASN1Constants.LENGTH_120;
            case 121:
                return ASN1Constants.LENGTH_121;
            case 122:
                return ASN1Constants.LENGTH_122;
            case 123:
                return ASN1Constants.LENGTH_123;
            case 124:
                return ASN1Constants.LENGTH_124;
            case ParseException.INVALID_EMAIL_ADDRESS:
                return ASN1Constants.LENGTH_125;
            case 126:
                return ASN1Constants.LENGTH_126;
            case CertificateBody.profileType /*127*/:
                return ASN1Constants.LENGTH_127;
            default:
                int i2 = i & 255;
                if (i2 == i) {
                    return new byte[]{-127, (byte) i2};
                } else if ((65535 & i) == i) {
                    return new byte[]{MatchingRule.SUBSTRING_TYPE_SUBFINAL, (byte) ((i >> 8) & 255), (byte) i2};
                } else if ((16777215 & i) == i) {
                    return new byte[]{-125, (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) i2};
                } else {
                    return new byte[]{-124, (byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) i2};
                }
        }
    }

    static void encodeLengthTo(int i, ByteStringBuffer byteStringBuffer) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        if ((i & CertificateBody.profileType) == i) {
            b4 = (byte) i;
        } else {
            int i2 = i & 255;
            if (i2 == i) {
                b3 = -127;
            } else {
                if ((65535 & i) == i) {
                    b2 = MatchingRule.SUBSTRING_TYPE_SUBFINAL;
                } else {
                    if ((16777215 & i) == i) {
                        b = -125;
                    } else {
                        byteStringBuffer.append((byte) -124);
                        b = (byte) ((i >> 24) & 255);
                    }
                    byteStringBuffer.append(b);
                    b2 = (byte) ((i >> 16) & 255);
                }
                byteStringBuffer.append(b2);
                b3 = (byte) ((i >> 8) & 255);
            }
            byteStringBuffer.append(b3);
            b4 = (byte) i2;
        }
        byteStringBuffer.append(b4);
    }

    public static ASN1Element readFrom(InputStream inputStream) {
        return readFrom(inputStream, -1);
    }

    public static ASN1Element readFrom(InputStream inputStream, int i) {
        int read = inputStream.read();
        if (read < 0) {
            return null;
        }
        byte b = (byte) read;
        int read2 = inputStream.read();
        if (read2 >= 0) {
            int i2 = 0;
            if (read2 > 127) {
                int i3 = read2 & CertificateBody.profileType;
                if (i3 < 1 || i3 > 4) {
                    throw new ASN1Exception(ASN1Messages.ERR_READ_LENGTH_TOO_LONG.get(Integer.valueOf(i3)));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < i3) {
                    int read3 = inputStream.read();
                    if (read3 >= 0) {
                        i5 = (i5 << 8) | (read3 & 255);
                        i4++;
                    } else {
                        throw new ASN1Exception(ASN1Messages.ERR_READ_END_BEFORE_LENGTH_END.get());
                    }
                }
                read2 = i5;
            }
            if (read2 < 0 || (i > 0 && read2 > i)) {
                throw new ASN1Exception(ASN1Messages.ERR_READ_LENGTH_EXCEEDS_MAX.get(Integer.valueOf(read2), Integer.valueOf(i)));
            }
            byte[] bArr = new byte[read2];
            int i6 = read2;
            while (i2 < read2) {
                int read4 = inputStream.read(bArr, i2, i6);
                if (read4 >= 0) {
                    i2 += read4;
                    i6 -= read4;
                } else {
                    throw new ASN1Exception(ASN1Messages.ERR_READ_END_BEFORE_VALUE_END.get());
                }
            }
            ASN1Element aSN1Element = new ASN1Element(b, bArr);
            Debug.debugASN1Read(aSN1Element);
            return aSN1Element;
        }
        throw new ASN1Exception(ASN1Messages.ERR_READ_END_BEFORE_FIRST_LENGTH.get());
    }

    public final ASN1Boolean decodeAsBoolean() {
        return ASN1Boolean.decodeAsBoolean(this);
    }

    public final ASN1Enumerated decodeAsEnumerated() {
        return ASN1Enumerated.decodeAsEnumerated(this);
    }

    public final ASN1Integer decodeAsInteger() {
        return ASN1Integer.decodeAsInteger(this);
    }

    public final ASN1Long decodeAsLong() {
        return ASN1Long.decodeAsLong(this);
    }

    public final ASN1Null decodeAsNull() {
        return ASN1Null.decodeAsNull(this);
    }

    public final ASN1OctetString decodeAsOctetString() {
        return ASN1OctetString.decodeAsOctetString(this);
    }

    public final ASN1Sequence decodeAsSequence() {
        return ASN1Sequence.decodeAsSequence(this);
    }

    public final ASN1Set decodeAsSet() {
        return ASN1Set.decodeAsSet(this);
    }

    public final byte[] encode() {
        byte[] valueArray = getValueArray();
        int valueLength2 = getValueLength();
        int valueOffset2 = getValueOffset();
        if (valueLength2 == 0) {
            return new byte[]{this.type, 0};
        }
        byte[] encodeLength = encodeLength(valueLength2);
        byte[] bArr = new byte[(encodeLength.length + 1 + valueLength2)];
        bArr[0] = this.type;
        System.arraycopy(encodeLength, 0, bArr, 1, encodeLength.length);
        System.arraycopy(valueArray, valueOffset2, bArr, encodeLength.length + 1, valueLength2);
        return bArr;
    }

    public void encodeTo(ByteStringBuffer byteStringBuffer) {
        byte[] valueArray = getValueArray();
        int valueLength2 = getValueLength();
        int valueOffset2 = getValueOffset();
        byteStringBuffer.append(this.type);
        if (valueLength2 == 0) {
            byteStringBuffer.append((byte) 0);
            return;
        }
        encodeLengthTo(valueLength2, byteStringBuffer);
        byteStringBuffer.append(valueArray, valueOffset2, valueLength2);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            ASN1Element aSN1Element = (ASN1Element) obj;
            return this.type == aSN1Element.getType() && Arrays.equals(getValue(), aSN1Element.getValue());
        } catch (Exception e) {
            Debug.debugException(e);
            return false;
        }
    }

    public final boolean equalsIgnoreType(ASN1Element aSN1Element) {
        if (aSN1Element == null) {
            return false;
        }
        if (aSN1Element == this) {
            return true;
        }
        return Arrays.equals(getValue(), aSN1Element.getValue());
    }

    public final byte getType() {
        return this.type;
    }

    public byte[] getValue() {
        if (this.valueOffset == 0) {
            int i = this.valueLength;
            byte[] bArr = this.value;
            if (i == bArr.length) {
                return bArr;
            }
        }
        int i2 = this.valueLength;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(this.value, this.valueOffset, bArr2, 0, i2);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public byte[] getValueArray() {
        return this.value;
    }

    public int getValueLength() {
        return this.valueLength;
    }

    /* access modifiers changed from: package-private */
    public int getValueOffset() {
        return this.valueOffset;
    }

    public final int hashCode() {
        if (this.hashCode == -1) {
            int i = 0;
            for (byte b : getValue()) {
                i = (i * 31) + b;
            }
            this.hashCode = i;
        }
        return this.hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        byte[] value2 = getValue();
        sb.append("ASN1Element(type=");
        StaticUtils.toHex(this.type, sb);
        sb.append(", valueLength=");
        sb.append(value2.length);
        sb.append(", valueBytes='");
        StaticUtils.toHex(value2, sb);
        sb.append("')");
    }

    public final int writeTo(OutputStream outputStream) {
        Debug.debugASN1Write(this);
        ByteStringBuffer byteStringBuffer = new ByteStringBuffer();
        encodeTo(byteStringBuffer);
        byteStringBuffer.write(outputStream);
        return byteStringBuffer.length();
    }
}
