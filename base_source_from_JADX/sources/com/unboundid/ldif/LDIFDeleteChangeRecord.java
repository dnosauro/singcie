package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.ChangeType;
import com.unboundid.ldap.sdk.DeleteRequest;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.util.Arrays;
import java.util.List;

public final class LDIFDeleteChangeRecord extends LDIFChangeRecord {
    private static final long serialVersionUID = 486284031156138191L;

    public LDIFDeleteChangeRecord(DeleteRequest deleteRequest) {
        super(deleteRequest.getDN());
    }

    public LDIFDeleteChangeRecord(String str) {
        super(str);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LDIFDeleteChangeRecord)) {
            return false;
        }
        LDIFDeleteChangeRecord lDIFDeleteChangeRecord = (LDIFDeleteChangeRecord) obj;
        try {
            return getParsedDN().equals((Object) lDIFDeleteChangeRecord.getParsedDN());
        } catch (Exception e) {
            Debug.debugException(e);
            return StaticUtils.toLowerCase(getDN()).equals(StaticUtils.toLowerCase(lDIFDeleteChangeRecord.getDN()));
        }
    }

    public ChangeType getChangeType() {
        return ChangeType.DELETE;
    }

    public int hashCode() {
        try {
            return getParsedDN().hashCode();
        } catch (Exception e) {
            Debug.debugException(e);
            return StaticUtils.toLowerCase(getDN()).hashCode();
        }
    }

    public LDAPResult processChange(LDAPInterface lDAPInterface) {
        return lDAPInterface.delete(toDeleteRequest());
    }

    public DeleteRequest toDeleteRequest() {
        return new DeleteRequest(getDN());
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("delete"), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
    }

    public String[] toLDIF(int i) {
        if (i > 0) {
            List<String> wrapLines = LDIFWriter.wrapLines(i, (List<String>) Arrays.asList(new String[]{LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN())), "changetype: delete"}));
            return (String[]) wrapLines.toArray(new String[wrapLines.size()]);
        }
        return new String[]{LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN())), "changetype: delete"};
    }

    public void toLDIFString(StringBuilder sb, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), sb, i);
        sb.append(StaticUtils.EOL);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("delete"), sb, i);
        sb.append(StaticUtils.EOL);
    }

    public void toString(StringBuilder sb) {
        sb.append("LDIFDeleteChangeRecord(dn='");
        sb.append(getDN());
        sb.append("')");
    }
}
