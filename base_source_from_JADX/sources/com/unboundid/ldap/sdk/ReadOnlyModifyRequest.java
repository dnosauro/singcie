package com.unboundid.ldap.sdk;

import com.unboundid.ldif.LDIFModifyChangeRecord;
import java.util.List;

public interface ReadOnlyModifyRequest extends ReadOnlyLDAPRequest {
    ModifyRequest duplicate();

    ModifyRequest duplicate(Control[] controlArr);

    String getDN();

    List<Modification> getModifications();

    String[] toLDIF();

    LDIFModifyChangeRecord toLDIFChangeRecord();

    String toLDIFString();
}
