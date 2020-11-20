package com.unboundid.ldap.sdk;

import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class CompactEntry implements Serializable {
    private static final long serialVersionUID = 8067151651120794058L;
    private final CompactAttribute[] attributes;

    /* renamed from: dn */
    private final String f7267dn;
    private int hashCode = -1;

    public CompactEntry(Entry entry) {
        Validator.ensureNotNull(entry);
        this.f7267dn = entry.getDN();
        Collection<Attribute> attributes2 = entry.getAttributes();
        this.attributes = new CompactAttribute[attributes2.size()];
        Iterator<Attribute> it = attributes2.iterator();
        int i = 0;
        while (true) {
            CompactAttribute[] compactAttributeArr = this.attributes;
            if (i < compactAttributeArr.length) {
                compactAttributeArr[i] = new CompactAttribute(it.next());
                i++;
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CompactEntry)) {
            return false;
        }
        return toEntry().equals(((CompactEntry) obj).toEntry());
    }

    public Attribute getAttribute(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str)) {
                return compactAttribute.toAttribute();
            }
        }
        return null;
    }

    public String getAttributeValue(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str)) {
                String[] stringValues = compactAttribute.getStringValues();
                if (stringValues.length > 0) {
                    return stringValues[0];
                }
                return null;
            }
        }
        return null;
    }

    public Boolean getAttributeValueAsBoolean(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsBoolean();
    }

    public C3122DN getAttributeValueAsDN(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsDN();
    }

    public Date getAttributeValueAsDate(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsDate();
    }

    public Integer getAttributeValueAsInteger(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsInteger();
    }

    public Long getAttributeValueAsLong(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsLong();
    }

    public byte[][] getAttributeValueByteArrays(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str)) {
                return compactAttribute.getByteValues();
            }
        }
        return null;
    }

    public byte[] getAttributeValueBytes(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str)) {
                byte[][] byteValues = compactAttribute.getByteValues();
                if (byteValues.length > 0) {
                    return byteValues[0];
                }
                return null;
            }
        }
        return null;
    }

    public String[] getAttributeValues(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str)) {
                return compactAttribute.getStringValues();
            }
        }
        return null;
    }

    public Collection<Attribute> getAttributes() {
        ArrayList arrayList = new ArrayList(this.attributes.length);
        for (CompactAttribute attribute : this.attributes) {
            arrayList.add(attribute.toAttribute());
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public List<Attribute> getAttributesWithOptions(String str, Set<String> set) {
        return toEntry().getAttributesWithOptions(str, set);
    }

    public String getDN() {
        return this.f7267dn;
    }

    public Attribute getObjectClassAttribute() {
        return getAttribute("objectClass");
    }

    public String[] getObjectClassValues() {
        return getAttributeValues("objectClass");
    }

    public C3122DN getParentDN() {
        return getParsedDN().getParent();
    }

    public String getParentDNString() {
        return getParsedDN().getParentString();
    }

    public C3122DN getParsedDN() {
        return new C3122DN(this.f7267dn);
    }

    public RDN getRDN() {
        return getParsedDN().getRDN();
    }

    public boolean hasAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        for (CompactAttribute attribute2 : this.attributes) {
            if (attribute2.toAttribute().equals(attribute)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAttribute(String str) {
        Validator.ensureNotNull(str);
        for (CompactAttribute name : this.attributes) {
            if (name.getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAttributeValue(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str) && compactAttribute.toAttribute().hasValue(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAttributeValue(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        for (CompactAttribute compactAttribute : this.attributes) {
            if (compactAttribute.getName().equalsIgnoreCase(str) && compactAttribute.toAttribute().hasValue(bArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasObjectClass(String str) {
        return hasAttributeValue("objectClass", str);
    }

    public int hashCode() {
        if (this.hashCode == -1) {
            this.hashCode = toEntry().hashCode();
        }
        return this.hashCode;
    }

    public Entry toEntry() {
        Attribute[] attributeArr = new Attribute[this.attributes.length];
        int i = 0;
        while (true) {
            CompactAttribute[] compactAttributeArr = this.attributes;
            if (i >= compactAttributeArr.length) {
                return new Entry(this.f7267dn, attributeArr);
            }
            attributeArr[i] = compactAttributeArr[i].toAttribute();
            i++;
        }
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer) {
        toLDIF(byteStringBuffer, 0);
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        toEntry().toLDIF(byteStringBuffer, i);
    }

    public String[] toLDIF() {
        return toLDIF(0);
    }

    public String[] toLDIF(int i) {
        return toEntry().toLDIF(i);
    }

    public String toLDIFString() {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, 0);
        return sb.toString();
    }

    public String toLDIFString(int i) {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, i);
        return sb.toString();
    }

    public void toLDIFString(StringBuilder sb) {
        toLDIFString(sb, 0);
    }

    public void toLDIFString(StringBuilder sb, int i) {
        toEntry().toLDIFString(sb, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("Entry(dn='");
        sb.append(this.f7267dn);
        sb.append("', attributes={");
        for (int i = 0; i < this.attributes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            this.attributes[i].toAttribute().toString(sb);
        }
        sb.append("})");
    }
}
