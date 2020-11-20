package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1BufferSet;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Exception;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.asn1.ASN1Set;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSet;
import com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Base64;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Attribute implements Serializable {
    private static final byte[][] NO_BYTE_VALUES = new byte[0][];
    private static final ASN1OctetString[] NO_VALUES = new ASN1OctetString[0];
    private static final long serialVersionUID = 5867076498293567612L;
    private int hashCode;
    private final MatchingRule matchingRule;
    private final String name;
    private final ASN1OctetString[] values;

    public Attribute(String str) {
        this.hashCode = -1;
        Validator.ensureNotNull(str);
        this.name = str;
        this.values = NO_VALUES;
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, MatchingRule matchingRule2) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = NO_VALUES;
    }

    public Attribute(String str, MatchingRule matchingRule2, String str2) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2, str2);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = new ASN1OctetString[]{new ASN1OctetString(str2)};
    }

    public Attribute(String str, MatchingRule matchingRule2, Collection<String> collection) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2, collection);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = new ASN1OctetString[collection.size()];
        int i = 0;
        for (String aSN1OctetString : collection) {
            this.values[i] = new ASN1OctetString(aSN1OctetString);
            i++;
        }
    }

    public Attribute(String str, MatchingRule matchingRule2, byte[] bArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2, bArr);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = new ASN1OctetString[]{new ASN1OctetString(bArr)};
    }

    public Attribute(String str, MatchingRule matchingRule2, ASN1OctetString[] aSN1OctetStringArr) {
        this.hashCode = -1;
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = aSN1OctetStringArr;
    }

    public Attribute(String str, MatchingRule matchingRule2, String... strArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2, strArr);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = new ASN1OctetString[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.values[i] = new ASN1OctetString(strArr[i]);
        }
    }

    public Attribute(String str, MatchingRule matchingRule2, byte[]... bArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, matchingRule2, bArr);
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values = new ASN1OctetString[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            this.values[i] = new ASN1OctetString(bArr[i]);
        }
    }

    public Attribute(String str, Schema schema, Collection<String> collection) {
        this(str, MatchingRule.selectEqualityMatchingRule(str, schema), collection);
    }

    public Attribute(String str, Schema schema, ASN1OctetString[] aSN1OctetStringArr) {
        this(str, MatchingRule.selectEqualityMatchingRule(str, schema), aSN1OctetStringArr);
    }

    public Attribute(String str, Schema schema, String... strArr) {
        this(str, MatchingRule.selectEqualityMatchingRule(str, schema), strArr);
    }

    public Attribute(String str, Schema schema, byte[]... bArr) {
        this(str, MatchingRule.selectEqualityMatchingRule(str, schema), bArr);
    }

    public Attribute(String str, String str2) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, str2);
        this.name = str;
        this.values = new ASN1OctetString[]{new ASN1OctetString(str2)};
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, Collection<String> collection) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, collection);
        this.name = str;
        this.values = new ASN1OctetString[collection.size()];
        int i = 0;
        for (String aSN1OctetString : collection) {
            this.values[i] = new ASN1OctetString(aSN1OctetString);
            i++;
        }
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, byte[] bArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, bArr);
        this.name = str;
        this.values = new ASN1OctetString[]{new ASN1OctetString(bArr)};
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, ASN1OctetString... aSN1OctetStringArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, aSN1OctetStringArr);
        this.name = str;
        this.values = aSN1OctetStringArr;
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, String... strArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, strArr);
        this.name = str;
        this.values = new ASN1OctetString[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.values[i] = new ASN1OctetString(strArr[i]);
        }
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public Attribute(String str, byte[]... bArr) {
        this.hashCode = -1;
        Validator.ensureNotNull(str, bArr);
        this.name = str;
        this.values = new ASN1OctetString[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            this.values[i] = new ASN1OctetString(bArr[i]);
        }
        this.matchingRule = CaseIgnoreStringMatchingRule.getInstance();
    }

    public static Attribute decode(ASN1Sequence aSN1Sequence) {
        Validator.ensureNotNull(aSN1Sequence);
        ASN1Element[] elements = aSN1Sequence.elements();
        if (elements.length == 2) {
            String stringValue = ASN1OctetString.decodeAsOctetString(elements[0]).stringValue();
            try {
                ASN1Set decodeAsSet = ASN1Set.decodeAsSet(elements[1]);
                ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[decodeAsSet.elements().length];
                for (int i = 0; i < aSN1OctetStringArr.length; i++) {
                    aSN1OctetStringArr[i] = ASN1OctetString.decodeAsOctetString(decodeAsSet.elements()[i]);
                }
                return new Attribute(stringValue, (MatchingRule) CaseIgnoreStringMatchingRule.getInstance(), aSN1OctetStringArr);
            } catch (ASN1Exception e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_ATTR_DECODE_VALUE_SET.get(StaticUtils.getExceptionMessage(e)), e);
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_ATTR_DECODE_INVALID_COUNT.get(Integer.valueOf(elements.length)));
        }
    }

    public static String getBaseName(String str) {
        int indexOf = str.indexOf(59);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static Set<String> getOptions(String str) {
        int indexOf = str.indexOf(59);
        if (indexOf <= 0) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(59, i);
            if (indexOf2 > 0) {
                linkedHashSet.add(str.substring(i, indexOf2));
                indexOf = indexOf2;
            } else {
                linkedHashSet.add(str.substring(i));
                return Collections.unmodifiableSet(linkedHashSet);
            }
        }
    }

    public static boolean hasOption(String str, String str2) {
        for (String equalsIgnoreCase : getOptions(str)) {
            if (equalsIgnoreCase.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasOptions(String str) {
        return str.indexOf(59) > 0;
    }

    public static Attribute mergeAttributes(Attribute attribute, Attribute attribute2) {
        ASN1OctetString[] aSN1OctetStringArr;
        boolean z;
        Validator.ensureNotNull(attribute, attribute2);
        String str = attribute.name;
        Validator.ensureTrue(str.equalsIgnoreCase(attribute2.name));
        MatchingRule matchingRule2 = attribute.matchingRule;
        ASN1OctetString[] aSN1OctetStringArr2 = attribute.values;
        ASN1OctetString[] aSN1OctetStringArr3 = new ASN1OctetString[(aSN1OctetStringArr2.length + attribute2.values.length)];
        System.arraycopy(aSN1OctetStringArr2, 0, aSN1OctetStringArr3, 0, aSN1OctetStringArr2.length);
        int length = attribute.values.length;
        int i = length;
        for (ASN1OctetString aSN1OctetString : attribute2.values) {
            ASN1OctetString[] aSN1OctetStringArr4 = attribute.values;
            int length2 = aSN1OctetStringArr4.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                }
                try {
                    if (matchingRule2.valuesMatch(aSN1OctetStringArr4[i2], aSN1OctetString)) {
                        z = true;
                        break;
                    }
                    i2++;
                } catch (Exception e) {
                    Debug.debugException(e);
                }
            }
            if (!z) {
                aSN1OctetStringArr3[i] = aSN1OctetString;
                i++;
            }
        }
        if (i != aSN1OctetStringArr3.length) {
            aSN1OctetStringArr = new ASN1OctetString[i];
            System.arraycopy(aSN1OctetStringArr3, 0, aSN1OctetStringArr, 0, i);
        } else {
            aSN1OctetStringArr = aSN1OctetStringArr3;
        }
        return new Attribute(str, matchingRule2, aSN1OctetStringArr);
    }

    public static boolean nameIsValid(String str) {
        return nameIsValid(str, true);
    }

    public static boolean nameIsValid(String str, boolean z) {
        int length;
        char charAt;
        if (str == null || (length = str.length()) == 0 || (((charAt = str.charAt(0)) < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z'))) {
            return false;
        }
        boolean z2 = false;
        for (int i = 1; i < length; i++) {
            char charAt2 = str.charAt(i);
            if ((charAt2 < 'a' || charAt2 > 'z') && (charAt2 < 'A' || charAt2 > 'Z')) {
                if ((charAt2 < '0' || charAt2 > '9') && charAt2 != '-') {
                    if (charAt2 != ';' || z2 || !z) {
                        return false;
                    }
                    z2 = true;
                } else if (z2) {
                    return false;
                }
            }
            z2 = false;
        }
        return !z2;
    }

    public static boolean needsBase64Encoding(String str) {
        return needsBase64Encoding(StaticUtils.getBytes(str));
    }

    public static boolean needsBase64Encoding(byte[] bArr) {
        if (bArr.length == 0) {
            return false;
        }
        byte b = bArr[0] & 255;
        if (b == 32 || b == 58 || b == 60 || (bArr[bArr.length - 1] & 255) == 32) {
            return true;
        }
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 == 0 || b3 == 10 || b3 == 13 || (b2 & 128) != 0) {
                return true;
            }
        }
        return false;
    }

    public static Attribute readFrom(ASN1StreamReader aSN1StreamReader) {
        return readFrom(aSN1StreamReader, (Schema) null);
    }

    public static Attribute readFrom(ASN1StreamReader aSN1StreamReader, Schema schema) {
        try {
            Validator.ensureNotNull(aSN1StreamReader.beginSequence());
            String readString = aSN1StreamReader.readString();
            Validator.ensureNotNull(readString);
            MatchingRule selectEqualityMatchingRule = MatchingRule.selectEqualityMatchingRule(readString, schema);
            ArrayList arrayList = new ArrayList();
            ASN1StreamReaderSet beginSet = aSN1StreamReader.beginSet();
            while (beginSet.hasMoreElements()) {
                arrayList.add(new ASN1OctetString(aSN1StreamReader.readBytes()));
            }
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[arrayList.size()];
            arrayList.toArray(aSN1OctetStringArr);
            return new Attribute(readString, selectEqualityMatchingRule, aSN1OctetStringArr);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_ATTR_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public static Attribute removeValues(Attribute attribute, Attribute attribute2) {
        return removeValues(attribute, attribute2, attribute.matchingRule);
    }

    public static Attribute removeValues(Attribute attribute, Attribute attribute2, MatchingRule matchingRule2) {
        Validator.ensureNotNull(attribute, attribute2);
        String str = attribute.name;
        Validator.ensureTrue(str.equalsIgnoreCase(attribute2.name));
        if (matchingRule2 == null) {
            matchingRule2 = attribute.matchingRule;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(attribute.values));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (attribute2.hasValue((ASN1OctetString) it.next(), matchingRule2)) {
                it.remove();
            }
        }
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[arrayList.size()];
        arrayList.toArray(aSN1OctetStringArr);
        return new Attribute(str, matchingRule2, aSN1OctetStringArr);
    }

    public ASN1Sequence encode() {
        return new ASN1Sequence(new ASN1OctetString(this.name), new ASN1Set((ASN1Element[]) this.values));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (!this.name.equalsIgnoreCase(attribute.name)) {
            return false;
        }
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length != attribute.values.length) {
            return false;
        }
        for (ASN1OctetString hasValue : aSN1OctetStringArr) {
            if (!attribute.hasValue(hasValue)) {
                return false;
            }
        }
        return true;
    }

    public String getBaseName() {
        return getBaseName(this.name);
    }

    public MatchingRule getMatchingRule() {
        return this.matchingRule;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getOptions() {
        return getOptions(this.name);
    }

    public ASN1OctetString[] getRawValues() {
        return this.values;
    }

    public String getValue() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        return aSN1OctetStringArr[0].stringValue();
    }

    public Boolean getValueAsBoolean() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        String lowerCase = StaticUtils.toLowerCase(aSN1OctetStringArr[0].stringValue());
        if (lowerCase.equals("true") || lowerCase.equals("t") || lowerCase.equals("yes") || lowerCase.equals("y") || lowerCase.equals("on") || lowerCase.equals("1")) {
            return Boolean.TRUE;
        }
        if (lowerCase.equals("false") || lowerCase.equals("f") || lowerCase.equals("no") || lowerCase.equals("n") || lowerCase.equals("off") || lowerCase.equals("0")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public C3122DN getValueAsDN() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        try {
            return new C3122DN(aSN1OctetStringArr[0].stringValue());
        } catch (Exception e) {
            Debug.debugException(e);
            return null;
        }
    }

    public Date getValueAsDate() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        try {
            return StaticUtils.decodeGeneralizedTime(aSN1OctetStringArr[0].stringValue());
        } catch (Exception e) {
            Debug.debugException(e);
            return null;
        }
    }

    public Integer getValueAsInteger() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        try {
            return Integer.valueOf(aSN1OctetStringArr[0].stringValue());
        } catch (NumberFormatException e) {
            Debug.debugException(e);
            return null;
        }
    }

    public Long getValueAsLong() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        try {
            return Long.valueOf(aSN1OctetStringArr[0].stringValue());
        } catch (NumberFormatException e) {
            Debug.debugException(e);
            return null;
        }
    }

    public byte[] getValueByteArray() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return null;
        }
        return aSN1OctetStringArr[0].getValue();
    }

    public byte[][] getValueByteArrays() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return NO_BYTE_VALUES;
        }
        byte[][] bArr = new byte[aSN1OctetStringArr.length][];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr2 = this.values;
            if (i >= aSN1OctetStringArr2.length) {
                return bArr;
            }
            bArr[i] = aSN1OctetStringArr2[i].getValue();
            i++;
        }
    }

    public String[] getValues() {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length == 0) {
            return StaticUtils.NO_STRINGS;
        }
        String[] strArr = new String[aSN1OctetStringArr.length];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr2 = this.values;
            if (i >= aSN1OctetStringArr2.length) {
                return strArr;
            }
            strArr[i] = aSN1OctetStringArr2[i].stringValue();
            i++;
        }
    }

    public boolean hasOption(String str) {
        return hasOption(this.name, str);
    }

    public boolean hasOptions() {
        return hasOptions(this.name);
    }

    public boolean hasValue() {
        return this.values.length > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean hasValue(ASN1OctetString aSN1OctetString) {
        return hasValue(aSN1OctetString, this.matchingRule);
    }

    /* access modifiers changed from: package-private */
    public boolean hasValue(ASN1OctetString aSN1OctetString, MatchingRule matchingRule2) {
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        int length = aSN1OctetStringArr.length;
        int i = 0;
        while (i < length) {
            try {
                if (matchingRule2.valuesMatch(aSN1OctetStringArr[i], aSN1OctetString)) {
                    return true;
                }
                i++;
            } catch (LDAPException e) {
                Debug.debugException(e);
            }
        }
        return false;
    }

    public boolean hasValue(String str) {
        Validator.ensureNotNull(str);
        return hasValue(new ASN1OctetString(str), this.matchingRule);
    }

    public boolean hasValue(String str, MatchingRule matchingRule2) {
        Validator.ensureNotNull(str);
        return hasValue(new ASN1OctetString(str), matchingRule2);
    }

    public boolean hasValue(byte[] bArr) {
        Validator.ensureNotNull(bArr);
        return hasValue(new ASN1OctetString(bArr), this.matchingRule);
    }

    public boolean hasValue(byte[] bArr, MatchingRule matchingRule2) {
        Validator.ensureNotNull(bArr);
        return hasValue(new ASN1OctetString(bArr), matchingRule2);
    }

    public int hashCode() {
        int i;
        if (this.hashCode == -1) {
            int hashCode2 = StaticUtils.toLowerCase(this.name).hashCode();
            for (ASN1OctetString aSN1OctetString : this.values) {
                try {
                    i = this.matchingRule.normalize(aSN1OctetString).hashCode();
                } catch (LDAPException e) {
                    Debug.debugException(e);
                    i = aSN1OctetString.hashCode();
                }
                hashCode2 += i;
            }
            this.hashCode = hashCode2;
        }
        return this.hashCode;
    }

    public boolean nameIsValid() {
        return nameIsValid(this.name, true);
    }

    public boolean needsBase64Encoding() {
        for (ASN1OctetString value : this.values) {
            if (needsBase64Encoding(value.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.values.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("Attribute(name=");
        sb.append(this.name);
        if (this.values.length == 0) {
            sb.append(", values={");
        } else {
            int i = 0;
            if (needsBase64Encoding()) {
                sb.append(", base64Values={'");
                while (i < this.values.length) {
                    if (i > 0) {
                        sb.append("', '");
                    }
                    sb.append(Base64.encode(this.values[i].getValue()));
                    i++;
                }
            } else {
                sb.append(", values={'");
                while (i < this.values.length) {
                    if (i > 0) {
                        sb.append("', '");
                    }
                    sb.append(this.values[i].stringValue());
                    i++;
                }
            }
            sb.append('\'');
        }
        sb.append("})");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence();
        aSN1Buffer.addOctetString(this.name);
        ASN1BufferSet beginSet = aSN1Buffer.beginSet();
        for (ASN1OctetString addElement : this.values) {
            aSN1Buffer.addElement(addElement);
        }
        beginSet.end();
        beginSequence.end();
    }
}
