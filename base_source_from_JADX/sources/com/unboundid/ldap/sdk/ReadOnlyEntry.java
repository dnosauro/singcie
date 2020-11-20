package com.unboundid.ldap.sdk;

import com.unboundid.ldap.sdk.schema.Schema;
import java.util.Collection;

public class ReadOnlyEntry extends Entry {
    private static final long serialVersionUID = -6482574870325012756L;

    public ReadOnlyEntry(C3122DN dn, Schema schema, Collection<Attribute> collection) {
        super(dn, schema, collection);
    }

    public ReadOnlyEntry(C3122DN dn, Schema schema, Attribute... attributeArr) {
        super(dn, schema, attributeArr);
    }

    public ReadOnlyEntry(C3122DN dn, Collection<Attribute> collection) {
        this(dn, (Schema) null, collection);
    }

    public ReadOnlyEntry(C3122DN dn, Attribute... attributeArr) {
        this(dn, (Schema) null, attributeArr);
    }

    public ReadOnlyEntry(Entry entry) {
        super(entry.getDN(), entry.getSchema(), entry.getAttributes());
    }

    public ReadOnlyEntry(Schema schema, String... strArr) {
        super(schema, strArr);
    }

    public ReadOnlyEntry(String str, Schema schema, Collection<Attribute> collection) {
        super(str, schema, collection);
    }

    public ReadOnlyEntry(String str, Schema schema, Attribute... attributeArr) {
        super(str, schema, attributeArr);
    }

    public ReadOnlyEntry(String str, Collection<Attribute> collection) {
        this(str, (Schema) null, collection);
    }

    public ReadOnlyEntry(String str, Attribute... attributeArr) {
        this(str, (Schema) null, attributeArr);
    }

    public ReadOnlyEntry(String... strArr) {
        this((Schema) null, strArr);
    }

    public boolean addAttribute(Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    public boolean addAttribute(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAttribute(String str, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public boolean addAttribute(String str, String... strArr) {
        throw new UnsupportedOperationException();
    }

    public boolean addAttribute(String str, byte[]... bArr) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAttribute(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAttributeValue(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAttributeValue(String str, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAttributeValues(String str, String... strArr) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAttributeValues(String str, byte[]... bArr) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(String str, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(String str, String... strArr) {
        throw new UnsupportedOperationException();
    }

    public void setAttribute(String str, byte[]... bArr) {
        throw new UnsupportedOperationException();
    }

    public void setDN(C3122DN dn) {
        throw new UnsupportedOperationException();
    }

    public void setDN(String str) {
        throw new UnsupportedOperationException();
    }
}
