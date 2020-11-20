package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;

public abstract class SimpleMatchingRule extends MatchingRule {
    private static final long serialVersionUID = -7221506185552250694L;

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        byte[] value = normalize(aSN1OctetString).getValue();
        byte[] value2 = normalize(aSN1OctetString2).getValue();
        int min = Math.min(value.length, value2.length);
        for (int i = 0; i < min; i++) {
            byte b = value[i] & 255;
            byte b2 = value2[i] & 255;
            if (b < b2) {
                return -1;
            }
            if (b > b2) {
                return 1;
            }
        }
        return value.length - value2.length;
    }

    public boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3) {
        int i;
        byte[] value = normalize(aSN1OctetString).getValue();
        if (aSN1OctetString2 != null) {
            byte[] value2 = normalizeSubstring(aSN1OctetString2, Byte.MIN_VALUE).getValue();
            if (value.length < value2.length) {
                return false;
            }
            for (int i2 = 0; i2 < value2.length; i2++) {
                if (value[i2] != value2[i2]) {
                    return false;
                }
            }
            i = value2.length;
        } else {
            i = 0;
        }
        if (aSN1OctetStringArr != null) {
            byte[][] bArr = new byte[aSN1OctetStringArr.length][];
            for (int i3 = 0; i3 < aSN1OctetStringArr.length; i3++) {
                bArr[i3] = normalizeSubstring(aSN1OctetStringArr[i3], (byte) -127).getValue();
            }
            int i4 = i;
            for (byte[] bArr2 : bArr) {
                if (bArr2.length != 0) {
                    int length = value.length - bArr2.length;
                    boolean z = false;
                    while (true) {
                        if (i4 > length) {
                            break;
                        }
                        int i5 = 0;
                        while (true) {
                            if (i5 >= bArr2.length) {
                                z = true;
                                break;
                            } else if (value[i4 + i5] != bArr2[i5]) {
                                z = false;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        if (z) {
                            i4 += bArr2.length;
                            break;
                        }
                        i4++;
                    }
                    if (!z) {
                        return false;
                    }
                }
            }
            i = i4;
        }
        if (aSN1OctetString3 != null) {
            byte[] value3 = normalizeSubstring(aSN1OctetString3, MatchingRule.SUBSTRING_TYPE_SUBFINAL).getValue();
            int length2 = value.length - value3.length;
            if (length2 < i) {
                return false;
            }
            int i6 = 0;
            while (i6 < value3.length) {
                if (value[length2] != value3[i6]) {
                    return false;
                }
                i6++;
                length2++;
            }
        }
        return true;
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        return normalize(aSN1OctetString).equals(normalize(aSN1OctetString2));
    }
}
