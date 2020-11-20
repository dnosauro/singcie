package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.AddRequest;
import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.ChangeType;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class LDIFAddChangeRecord extends LDIFChangeRecord {
    private static final long serialVersionUID = 5717427836786488295L;
    private final Attribute[] attributes;

    public LDIFAddChangeRecord(AddRequest addRequest) {
        super(addRequest.getDN());
        List<Attribute> attributes2 = addRequest.getAttributes();
        this.attributes = new Attribute[attributes2.size()];
        Iterator<Attribute> it = attributes2.iterator();
        int i = 0;
        while (true) {
            Attribute[] attributeArr = this.attributes;
            if (i < attributeArr.length) {
                attributeArr[i] = it.next();
                i++;
            } else {
                return;
            }
        }
    }

    public LDIFAddChangeRecord(Entry entry) {
        super(entry.getDN());
        Collection<Attribute> attributes2 = entry.getAttributes();
        this.attributes = new Attribute[attributes2.size()];
        Iterator<Attribute> it = attributes2.iterator();
        int i = 0;
        while (true) {
            Attribute[] attributeArr = this.attributes;
            if (i < attributeArr.length) {
                attributeArr[i] = it.next();
                i++;
            } else {
                return;
            }
        }
    }

    public LDIFAddChangeRecord(String str, List<Attribute> list) {
        super(str);
        Validator.ensureNotNull(list);
        Validator.ensureFalse(list.isEmpty(), "LDIFAddChangeRecord.attributes must not be empty.");
        this.attributes = new Attribute[list.size()];
        list.toArray(this.attributes);
    }

    public LDIFAddChangeRecord(String str, Attribute... attributeArr) {
        super(str);
        Validator.ensureNotNull(attributeArr);
        Validator.ensureTrue(attributeArr.length > 0, "LDIFAddChangeRecord.attributes must not be empty.");
        this.attributes = attributeArr;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LDIFAddChangeRecord)) {
            return false;
        }
        LDIFAddChangeRecord lDIFAddChangeRecord = (LDIFAddChangeRecord) obj;
        return new Entry(getDN(), this.attributes).equals(new Entry(lDIFAddChangeRecord.getDN(), lDIFAddChangeRecord.attributes));
    }

    public Attribute[] getAttributes() {
        return this.attributes;
    }

    public ChangeType getChangeType() {
        return ChangeType.ADD;
    }

    public int hashCode() {
        try {
            int hashCode = getParsedDN().hashCode();
            for (Attribute hashCode2 : this.attributes) {
                hashCode += hashCode2.hashCode();
            }
            return hashCode;
        } catch (Exception e) {
            Debug.debugException(e);
            return new Entry(getDN(), this.attributes).hashCode();
        }
    }

    public LDAPResult processChange(LDAPInterface lDAPInterface) {
        return lDAPInterface.add(toAddRequest());
    }

    public AddRequest toAddRequest() {
        return new AddRequest(getDN(), this.attributes);
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("add"), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        for (Attribute attribute : this.attributes) {
            String name = attribute.getName();
            for (ASN1OctetString encodeNameAndValue : attribute.getRawValues()) {
                LDIFWriter.encodeNameAndValue(name, encodeNameAndValue, byteStringBuffer, i);
                byteStringBuffer.append(StaticUtils.EOL_BYTES);
            }
        }
    }

    public String[] toLDIF(int i) {
        List arrayList = new ArrayList(this.attributes.length * 2);
        arrayList.add(LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN())));
        arrayList.add("changetype: add");
        for (Attribute attribute : this.attributes) {
            String name = attribute.getName();
            for (ASN1OctetString encodeNameAndValue : attribute.getRawValues()) {
                arrayList.add(LDIFWriter.encodeNameAndValue(name, encodeNameAndValue));
            }
        }
        if (i > 2) {
            arrayList = LDIFWriter.wrapLines(i, (List<String>) arrayList);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public void toLDIFString(StringBuilder sb, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), sb, i);
        sb.append(StaticUtils.EOL);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("add"), sb, i);
        sb.append(StaticUtils.EOL);
        for (Attribute attribute : this.attributes) {
            String name = attribute.getName();
            for (ASN1OctetString encodeNameAndValue : attribute.getRawValues()) {
                LDIFWriter.encodeNameAndValue(name, encodeNameAndValue, sb, i);
                sb.append(StaticUtils.EOL);
            }
        }
    }

    public void toString(StringBuilder sb) {
        sb.append("LDIFAddChangeRecord(dn='");
        sb.append(getDN());
        sb.append("', attrs={");
        for (int i = 0; i < this.attributes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            this.attributes[i].toString(sb);
        }
        sb.append("})");
    }
}
