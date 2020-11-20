package com.unboundid.asn1;

import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class ASN1Sequence extends ASN1Element {
    private static final long serialVersionUID = 7294248008273774906L;
    private final ASN1Element[] elements;
    private byte[] encodedValue;
    private volatile byte[] encodedValueGuard;

    public ASN1Sequence() {
        super(ASN1Constants.UNIVERSAL_SEQUENCE_TYPE);
        this.elements = ASN1Constants.NO_ELEMENTS;
        this.encodedValue = ASN1Constants.NO_VALUE;
    }

    public ASN1Sequence(byte b) {
        super(b);
        this.elements = ASN1Constants.NO_ELEMENTS;
        this.encodedValue = ASN1Constants.NO_VALUE;
    }

    public ASN1Sequence(byte b, Collection<? extends ASN1Element> collection) {
        super(b);
        if (collection == null || collection.isEmpty()) {
            this.elements = ASN1Constants.NO_ELEMENTS;
        } else {
            this.elements = new ASN1Element[collection.size()];
            collection.toArray(this.elements);
        }
        this.encodedValue = null;
    }

    public ASN1Sequence(byte b, ASN1Element... aSN1ElementArr) {
        super(b);
        if (aSN1ElementArr == null) {
            this.elements = ASN1Constants.NO_ELEMENTS;
        } else {
            this.elements = aSN1ElementArr;
        }
        this.encodedValue = null;
    }

    private ASN1Sequence(byte b, ASN1Element[] aSN1ElementArr, byte[] bArr) {
        super(b);
        this.elements = aSN1ElementArr;
        this.encodedValue = bArr;
    }

    public ASN1Sequence(Collection<? extends ASN1Element> collection) {
        super(ASN1Constants.UNIVERSAL_SEQUENCE_TYPE);
        if (collection == null || collection.isEmpty()) {
            this.elements = ASN1Constants.NO_ELEMENTS;
        } else {
            this.elements = new ASN1Element[collection.size()];
            collection.toArray(this.elements);
        }
        this.encodedValue = null;
    }

    public ASN1Sequence(ASN1Element... aSN1ElementArr) {
        super(ASN1Constants.UNIVERSAL_SEQUENCE_TYPE);
        this.elements = aSN1ElementArr == null ? ASN1Constants.NO_ELEMENTS : aSN1ElementArr;
        this.encodedValue = null;
    }

    public static ASN1Sequence decodeAsSequence(ASN1Element aSN1Element) {
        ArrayList arrayList = new ArrayList(5);
        byte[] value = aSN1Element.getValue();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < value.length) {
            try {
                int i4 = i2 + 1;
                byte b = value[i2];
                int i5 = i4 + 1;
                byte b2 = value[i4];
                byte b3 = b2 & Byte.MAX_VALUE;
                if (b3 != b2) {
                    int i6 = i5;
                    int i7 = 0;
                    byte b4 = 0;
                    while (i7 < b3) {
                        b4 = (b4 << 8) | (value[i6] & 255);
                        i7++;
                        i6++;
                    }
                    b3 = b4;
                    i5 = i6;
                }
                int i8 = i5 + b3;
                if (b3 < 0 || i8 < 0 || i8 > value.length) {
                    throw new ASN1Exception(ASN1Messages.ERR_SEQUENCE_DECODE_LENGTH_EXCEEDS_AVAILABLE.get(String.valueOf(aSN1Element)));
                }
                arrayList.add(new ASN1Element(b, value, i5, b3));
                i3++;
                i2 = i8;
            } catch (ASN1Exception e) {
                throw e;
            } catch (Exception e2) {
                Debug.debugException(e2);
                throw new ASN1Exception(ASN1Messages.ERR_SEQUENCE_DECODE_EXCEPTION.get(String.valueOf(aSN1Element), e2), e2);
            }
        }
        ASN1Element[] aSN1ElementArr = new ASN1Element[i3];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aSN1ElementArr[i] = (ASN1Element) it.next();
            i++;
        }
        return new ASN1Sequence(aSN1Element.getType(), aSN1ElementArr, value);
    }

    public static ASN1Sequence decodeAsSequence(byte[] bArr) {
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
                ArrayList arrayList = new ArrayList(5);
                int i4 = 0;
                int i5 = 0;
                while (i4 < bArr2.length) {
                    int i6 = i4 + 1;
                    byte b2 = bArr2[i4];
                    int i7 = i6 + 1;
                    byte b3 = bArr2[i6];
                    byte b4 = b3 & Byte.MAX_VALUE;
                    if (b4 != b3) {
                        int i8 = 0;
                        byte b5 = 0;
                        while (i8 < b4) {
                            b5 = (b5 << 8) | (bArr2[i7] & 255);
                            i8++;
                            i7++;
                        }
                        b4 = b5;
                    }
                    int i9 = i7 + b4;
                    if (b4 < 0 || i9 < 0 || i9 > bArr2.length) {
                        throw new ASN1Exception(ASN1Messages.ERR_SEQUENCE_BYTES_DECODE_LENGTH_EXCEEDS_AVAILABLE.get());
                    }
                    arrayList.add(new ASN1Element(b2, bArr2, i7, b4));
                    i5++;
                    i4 = i9;
                }
                ASN1Element[] aSN1ElementArr = new ASN1Element[i5];
                Iterator it = arrayList.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    aSN1ElementArr[i10] = (ASN1Element) it.next();
                    i10++;
                }
                return new ASN1Sequence(bArr[0], aSN1ElementArr, bArr2);
            }
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH.get(Integer.valueOf(i2), Integer.valueOf(bArr.length - i)));
        } catch (ASN1Exception e) {
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new ASN1Exception(ASN1Messages.ERR_SEQUENCE_BYTES_DECODE_EXCEPTION.get(e2), e2);
        } catch (ASN1Exception e3) {
            Debug.debugException(e3);
            throw e3;
        } catch (Exception e4) {
            Debug.debugException(e4);
            throw new ASN1Exception(ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION.get(e4), e4);
        }
    }

    static byte[] encodeElements(ASN1Element[] aSN1ElementArr) {
        if (aSN1ElementArr == null || aSN1ElementArr.length == 0) {
            return ASN1Constants.NO_VALUE;
        }
        int length = aSN1ElementArr.length;
        byte[][] bArr = new byte[length][];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = aSN1ElementArr[i2].encode();
            i += bArr[i2].length;
        }
        byte[] bArr2 = new byte[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            System.arraycopy(bArr[i4], 0, bArr2, i3, bArr[i4].length);
            i3 += bArr[i4].length;
        }
        return bArr2;
    }

    public ASN1Element[] elements() {
        return this.elements;
    }

    public void encodeTo(ByteStringBuffer byteStringBuffer) {
        byteStringBuffer.append(getType());
        if (this.elements.length == 0) {
            byteStringBuffer.append((byte) 0);
            return;
        }
        int length = byteStringBuffer.length();
        for (ASN1Element encodeTo : this.elements) {
            encodeTo.encodeTo(byteStringBuffer);
        }
        byteStringBuffer.insert(length, encodeLength(byteStringBuffer.length() - length));
    }

    public byte[] getValue() {
        if (this.encodedValue == null) {
            this.encodedValueGuard = encodeElements(this.elements);
            this.encodedValue = this.encodedValueGuard;
        }
        return this.encodedValue;
    }

    /* access modifiers changed from: package-private */
    public byte[] getValueArray() {
        return getValue();
    }

    public int getValueLength() {
        return getValue().length;
    }

    /* access modifiers changed from: package-private */
    public int getValueOffset() {
        return 0;
    }

    public void toString(StringBuilder sb) {
        sb.append('[');
        for (int i = 0; i < this.elements.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            this.elements[i].toString(sb);
        }
        sb.append(']');
    }
}
