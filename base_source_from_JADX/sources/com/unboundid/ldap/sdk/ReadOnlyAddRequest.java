package com.unboundid.ldap.sdk;

import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldif.LDIFAddChangeRecord;
import java.util.List;

public interface ReadOnlyAddRequest extends ReadOnlyLDAPRequest {
    AddRequest duplicate();

    AddRequest duplicate(Control[] controlArr);

    Attribute getAttribute(String str);

    List<Attribute> getAttributes();

    String getDN();

    boolean hasAttribute(Attribute attribute);

    boolean hasAttribute(String str);

    boolean hasAttributeValue(String str, String str2);

    boolean hasAttributeValue(String str, String str2, MatchingRule matchingRule);

    boolean hasAttributeValue(String str, byte[] bArr);

    boolean hasAttributeValue(String str, byte[] bArr, MatchingRule matchingRule);

    boolean hasObjectClass(String str);

    Entry toEntry();

    String[] toLDIF();

    LDIFAddChangeRecord toLDIFChangeRecord();

    String toLDIFString();
}
