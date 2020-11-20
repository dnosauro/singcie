package com.unboundid.ldap.sdk;

import com.unboundid.ldif.LDIFModifyDNChangeRecord;

public interface ReadOnlyModifyDNRequest extends ReadOnlyLDAPRequest {
    boolean deleteOldRDN();

    ModifyDNRequest duplicate();

    ModifyDNRequest duplicate(Control[] controlArr);

    String getDN();

    String getNewRDN();

    String getNewSuperiorDN();

    String[] toLDIF();

    LDIFModifyDNChangeRecord toLDIFChangeRecord();

    String toLDIFString();
}
