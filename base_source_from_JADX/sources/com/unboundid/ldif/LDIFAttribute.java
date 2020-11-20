package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.sdk.Attribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

class LDIFAttribute implements Serializable {
    private static final long serialVersionUID = -3771917482408643188L;
    private final MatchingRule matchingRule;
    private final String name;
    private LinkedHashSet<ASN1OctetString> normalizedValues;
    private final ArrayList<ASN1OctetString> values = new ArrayList<>(5);

    LDIFAttribute(String str, MatchingRule matchingRule2, ASN1OctetString aSN1OctetString) {
        this.name = str;
        this.matchingRule = matchingRule2;
        this.values.add(aSN1OctetString);
        this.normalizedValues = null;
    }

    /* access modifiers changed from: package-private */
    public boolean addValue(ASN1OctetString aSN1OctetString, DuplicateValueBehavior duplicateValueBehavior) {
        if (this.normalizedValues == null) {
            this.normalizedValues = new LinkedHashSet<>();
            Iterator<ASN1OctetString> it = this.values.iterator();
            while (it.hasNext()) {
                this.normalizedValues.add(this.matchingRule.normalize(it.next()));
            }
        }
        if (!this.normalizedValues.add(this.matchingRule.normalize(aSN1OctetString)) && duplicateValueBehavior != DuplicateValueBehavior.RETAIN) {
            return false;
        }
        this.values.add(aSN1OctetString);
        return true;
    }

    /* access modifiers changed from: package-private */
    public Attribute toAttribute() {
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[this.values.size()];
        this.values.toArray(aSN1OctetStringArr);
        return new Attribute(this.name, this.matchingRule, aSN1OctetStringArr);
    }
}
