package com.unboundid.ldif;

import com.unboundid.ldap.sdk.C3122DN;
import com.unboundid.ldap.sdk.ChangeType;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Validator;

public abstract class LDIFChangeRecord implements LDIFRecord {
    private static final long serialVersionUID = 2394617613961232499L;

    /* renamed from: dn */
    private final String f7273dn;
    private volatile C3122DN parsedDN;

    protected LDIFChangeRecord(String str) {
        Validator.ensureNotNull(str);
        this.f7273dn = str;
    }

    public abstract boolean equals(Object obj);

    public abstract ChangeType getChangeType();

    public final String getDN() {
        return this.f7273dn;
    }

    public final C3122DN getParsedDN() {
        if (this.parsedDN == null) {
            this.parsedDN = new C3122DN(this.f7273dn);
        }
        return this.parsedDN;
    }

    public abstract int hashCode();

    public abstract LDAPResult processChange(LDAPInterface lDAPInterface);

    /* access modifiers changed from: package-private */
    public final Entry toEntry() {
        return new Entry(toLDIF());
    }

    public final void toLDIF(ByteStringBuffer byteStringBuffer) {
        toLDIF(byteStringBuffer, 0);
    }

    public abstract void toLDIF(ByteStringBuffer byteStringBuffer, int i);

    public final String[] toLDIF() {
        return toLDIF(0);
    }

    public abstract String[] toLDIF(int i);

    public final String toLDIFString() {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, 0);
        return sb.toString();
    }

    public final String toLDIFString(int i) {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, i);
        return sb.toString();
    }

    public final void toLDIFString(StringBuilder sb) {
        toLDIFString(sb, 0);
    }

    public abstract void toLDIFString(StringBuilder sb, int i);

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public abstract void toString(StringBuilder sb);
}
