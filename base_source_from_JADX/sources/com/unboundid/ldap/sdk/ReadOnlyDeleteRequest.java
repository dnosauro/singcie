package com.unboundid.ldap.sdk;

import com.unboundid.ldif.LDIFDeleteChangeRecord;

public interface ReadOnlyDeleteRequest extends ReadOnlyLDAPRequest {
    DeleteRequest duplicate();

    DeleteRequest duplicate(Control[] controlArr);

    String getDN();

    String[] toLDIF();

    LDIFDeleteChangeRecord toLDIFChangeRecord();

    String toLDIFString();
}
