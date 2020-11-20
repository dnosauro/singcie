package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1BufferSet;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Enumerated;
import com.unboundid.asn1.ASN1Exception;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.asn1.ASN1Set;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSet;
import com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.util.Base64;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;

public final class Modification implements Serializable {
    private static final byte[][] NO_BYTE_VALUES = new byte[0][];
    private static final ASN1OctetString[] NO_VALUES = new ASN1OctetString[0];
    private static final long serialVersionUID = 5170107037390858876L;
    private final String attributeName;
    private final ModificationType modificationType;
    private final ASN1OctetString[] values;

    public Modification(ModificationType modificationType2, String str) {
        Validator.ensureNotNull(str);
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = NO_VALUES;
    }

    public Modification(ModificationType modificationType2, String str, String str2) {
        Validator.ensureNotNull(str, str2);
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = new ASN1OctetString[]{new ASN1OctetString(str2)};
    }

    public Modification(ModificationType modificationType2, String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = new ASN1OctetString[]{new ASN1OctetString(bArr)};
    }

    public Modification(ModificationType modificationType2, String str, ASN1OctetString[] aSN1OctetStringArr) {
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = aSN1OctetStringArr;
    }

    public Modification(ModificationType modificationType2, String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = new ASN1OctetString[strArr.length];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.values;
            if (i < aSN1OctetStringArr.length) {
                aSN1OctetStringArr[i] = new ASN1OctetString(strArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public Modification(ModificationType modificationType2, String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        this.modificationType = modificationType2;
        this.attributeName = str;
        this.values = new ASN1OctetString[bArr.length];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.values;
            if (i < aSN1OctetStringArr.length) {
                aSN1OctetStringArr[i] = new ASN1OctetString(bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public static Modification decode(ASN1Sequence aSN1Sequence) {
        Validator.ensureNotNull(aSN1Sequence);
        ASN1Element[] elements = aSN1Sequence.elements();
        if (elements.length == 2) {
            try {
                int intValue = ASN1Enumerated.decodeAsEnumerated(elements[0]).intValue();
                try {
                    ASN1Element[] elements2 = ASN1Sequence.decodeAsSequence(elements[1]).elements();
                    if (elements2.length == 2) {
                        String stringValue = ASN1OctetString.decodeAsOctetString(elements2[0]).stringValue();
                        try {
                            ASN1Element[] elements3 = ASN1Set.decodeAsSet(elements2[1]).elements();
                            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[elements3.length];
                            for (int i = 0; i < aSN1OctetStringArr.length; i++) {
                                aSN1OctetStringArr[i] = ASN1OctetString.decodeAsOctetString(elements3[i]);
                            }
                            return new Modification(ModificationType.valueOf(intValue), stringValue, aSN1OctetStringArr);
                        } catch (ASN1Exception e) {
                            Debug.debugException(e);
                            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_DECODE_CANNOT_PARSE_ATTR_VALUE_SET.get(StaticUtils.getExceptionMessage(e)), e);
                        }
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_DECODE_INVALID_ATTR_ELEMENT_COUNT.get(Integer.valueOf(elements2.length)));
                    }
                } catch (ASN1Exception e2) {
                    Debug.debugException(e2);
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_DECODE_CANNOT_PARSE_ATTR.get(StaticUtils.getExceptionMessage(e2)), e2);
                }
            } catch (ASN1Exception e3) {
                Debug.debugException(e3);
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_DECODE_CANNOT_PARSE_MOD_TYPE.get(StaticUtils.getExceptionMessage(e3)), e3);
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_DECODE_INVALID_ELEMENT_COUNT.get(Integer.valueOf(elements.length)));
        }
    }

    private boolean needsBase64Encoding() {
        for (ASN1OctetString value : this.values) {
            if (Attribute.needsBase64Encoding(value.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static Modification readFrom(ASN1StreamReader aSN1StreamReader) {
        try {
            Validator.ensureNotNull(aSN1StreamReader.beginSequence());
            ModificationType valueOf = ModificationType.valueOf(aSN1StreamReader.readEnumerated().intValue());
            Validator.ensureNotNull(aSN1StreamReader.beginSequence());
            String readString = aSN1StreamReader.readString();
            ArrayList arrayList = new ArrayList(5);
            ASN1StreamReaderSet beginSet = aSN1StreamReader.beginSet();
            while (beginSet.hasMoreElements()) {
                arrayList.add(new ASN1OctetString(aSN1StreamReader.readBytes()));
            }
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[arrayList.size()];
            arrayList.toArray(aSN1OctetStringArr);
            return new Modification(valueOf, readString, aSN1OctetStringArr);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_MOD_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public ASN1Sequence encode() {
        return new ASN1Sequence(new ASN1Enumerated(this.modificationType.intValue()), new ASN1Sequence(new ASN1OctetString(this.attributeName), new ASN1Set((ASN1Element[]) this.values)));
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Modification)) {
            return false;
        }
        Modification modification = (Modification) obj;
        if (this.modificationType != modification.modificationType || !this.attributeName.equalsIgnoreCase(modification.attributeName)) {
            return false;
        }
        ASN1OctetString[] aSN1OctetStringArr = this.values;
        if (aSN1OctetStringArr.length != modification.values.length) {
            return false;
        }
        for (ASN1OctetString aSN1OctetString : aSN1OctetStringArr) {
            int i = 0;
            while (true) {
                ASN1OctetString[] aSN1OctetStringArr2 = modification.values;
                if (i >= aSN1OctetStringArr2.length) {
                    z = false;
                    break;
                } else if (aSN1OctetString.equalsIgnoreType(aSN1OctetStringArr2[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public Attribute getAttribute() {
        return new Attribute(this.attributeName, (MatchingRule) CaseIgnoreStringMatchingRule.getInstance(), this.values);
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public ModificationType getModificationType() {
        return this.modificationType;
    }

    public ASN1OctetString[] getRawValues() {
        return this.values;
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

    public boolean hasValue() {
        return this.values.length > 0;
    }

    public int hashCode() {
        int intValue = this.modificationType.intValue() + StaticUtils.toLowerCase(this.attributeName).hashCode();
        for (ASN1OctetString hashCode : this.values) {
            intValue += hashCode.hashCode();
        }
        return intValue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        String str;
        sb.append("LDAPModification(type=");
        switch (this.modificationType.intValue()) {
            case 0:
                str = "add";
                break;
            case 1:
                str = "delete";
                break;
            case 2:
                str = "replace";
                break;
            case 3:
                str = "increment";
                break;
            default:
                sb.append(this.modificationType);
                break;
        }
        sb.append(str);
        sb.append(", attr=");
        sb.append(this.attributeName);
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
        aSN1Buffer.addEnumerated(this.modificationType.intValue());
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        aSN1Buffer.addOctetString(this.attributeName);
        ASN1BufferSet beginSet = aSN1Buffer.beginSet();
        for (ASN1OctetString addElement : this.values) {
            aSN1Buffer.addElement(addElement);
        }
        beginSet.end();
        beginSequence2.end();
        beginSequence.end();
    }
}
