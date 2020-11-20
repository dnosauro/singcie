package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.C3122DN;
import com.unboundid.ldap.sdk.ChangeType;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.ModifyDNRequest;
import com.unboundid.ldap.sdk.RDN;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Arrays;
import java.util.List;

public final class LDIFModifyDNChangeRecord extends LDIFChangeRecord {
    private static final long serialVersionUID = -2356367870035948998L;
    private final boolean deleteOldRDN;
    private final String newRDN;
    private final String newSuperiorDN;
    private volatile RDN parsedNewRDN;
    private volatile C3122DN parsedNewSuperiorDN;

    public LDIFModifyDNChangeRecord(ModifyDNRequest modifyDNRequest) {
        super(modifyDNRequest.getDN());
        this.newRDN = modifyDNRequest.getNewRDN();
        this.deleteOldRDN = modifyDNRequest.deleteOldRDN();
        this.newSuperiorDN = modifyDNRequest.getNewSuperiorDN();
    }

    public LDIFModifyDNChangeRecord(String str, String str2, boolean z, String str3) {
        super(str);
        Validator.ensureNotNull(str2);
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = str3;
    }

    public boolean deleteOldRDN() {
        return this.deleteOldRDN;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LDIFModifyDNChangeRecord)) {
            return false;
        }
        LDIFModifyDNChangeRecord lDIFModifyDNChangeRecord = (LDIFModifyDNChangeRecord) obj;
        try {
            if (!getParsedDN().equals((Object) lDIFModifyDNChangeRecord.getParsedDN())) {
                return false;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            if (!StaticUtils.toLowerCase(getDN()).equals(StaticUtils.toLowerCase(lDIFModifyDNChangeRecord.getDN()))) {
                return false;
            }
        }
        try {
            if (!getParsedNewRDN().equals((Object) lDIFModifyDNChangeRecord.getParsedNewRDN())) {
                return false;
            }
        } catch (Exception e2) {
            Debug.debugException(e2);
            if (!StaticUtils.toLowerCase(this.newRDN).equals(StaticUtils.toLowerCase(lDIFModifyDNChangeRecord.newRDN))) {
                return false;
            }
        }
        if (this.newSuperiorDN == null) {
            if (lDIFModifyDNChangeRecord.newSuperiorDN != null) {
                return false;
            }
        } else if (lDIFModifyDNChangeRecord.newSuperiorDN == null) {
            return false;
        } else {
            try {
                if (!getParsedNewSuperiorDN().equals((Object) lDIFModifyDNChangeRecord.getParsedNewSuperiorDN())) {
                    return false;
                }
            } catch (Exception e3) {
                Debug.debugException(e3);
                if (!StaticUtils.toLowerCase(this.newSuperiorDN).equals(StaticUtils.toLowerCase(lDIFModifyDNChangeRecord.newSuperiorDN))) {
                    return false;
                }
            }
        }
        return this.deleteOldRDN == lDIFModifyDNChangeRecord.deleteOldRDN;
    }

    public ChangeType getChangeType() {
        return ChangeType.MODIFY_DN;
    }

    public C3122DN getNewDN() {
        if (this.newSuperiorDN != null) {
            return new C3122DN(getParsedNewRDN(), getParsedNewSuperiorDN());
        }
        C3122DN parent = getParsedDN().getParent();
        if (parent != null) {
            return new C3122DN(getParsedNewRDN(), parent);
        }
        return new C3122DN(getParsedNewRDN());
    }

    public String getNewRDN() {
        return this.newRDN;
    }

    public String getNewSuperiorDN() {
        return this.newSuperiorDN;
    }

    public RDN getParsedNewRDN() {
        if (this.parsedNewRDN == null) {
            this.parsedNewRDN = new RDN(this.newRDN);
        }
        return this.parsedNewRDN;
    }

    public C3122DN getParsedNewSuperiorDN() {
        String str;
        if (this.parsedNewSuperiorDN == null && (str = this.newSuperiorDN) != null) {
            this.parsedNewSuperiorDN = new C3122DN(str);
        }
        return this.parsedNewSuperiorDN;
    }

    public int hashCode() {
        int i;
        int i2;
        try {
            i = getParsedDN().hashCode() + getParsedNewRDN().hashCode();
            if (this.newSuperiorDN != null) {
                i2 = getParsedNewSuperiorDN().hashCode();
                i += i2;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            i = StaticUtils.toLowerCase(getDN()).hashCode() + StaticUtils.toLowerCase(this.newRDN).hashCode();
            String str = this.newSuperiorDN;
            if (str != null) {
                i2 = StaticUtils.toLowerCase(str).hashCode();
            }
        }
        return this.deleteOldRDN ? i + 1 : i;
    }

    public LDAPResult processChange(LDAPInterface lDAPInterface) {
        return lDAPInterface.modifyDN(toModifyDNRequest());
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        ASN1OctetString aSN1OctetString;
        String str;
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("moddn"), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        LDIFWriter.encodeNameAndValue("newrdn", new ASN1OctetString(this.newRDN), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        if (this.deleteOldRDN) {
            str = "deleteoldrdn";
            aSN1OctetString = new ASN1OctetString("1");
        } else {
            str = "deleteoldrdn";
            aSN1OctetString = new ASN1OctetString("0");
        }
        LDIFWriter.encodeNameAndValue(str, aSN1OctetString, byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        String str2 = this.newSuperiorDN;
        if (str2 != null) {
            LDIFWriter.encodeNameAndValue("newsuperior", new ASN1OctetString(str2), byteStringBuffer, i);
            byteStringBuffer.append(StaticUtils.EOL_BYTES);
        }
    }

    public String[] toLDIF(int i) {
        String[] strArr;
        if (this.newSuperiorDN == null) {
            strArr = new String[4];
            strArr[0] = LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()));
            strArr[1] = "changetype: moddn";
            strArr[2] = LDIFWriter.encodeNameAndValue("newrdn", new ASN1OctetString(this.newRDN));
            StringBuilder sb = new StringBuilder();
            sb.append("deleteoldrdn: ");
            sb.append(this.deleteOldRDN ? "1" : "0");
            strArr[3] = sb.toString();
        } else {
            strArr = new String[5];
            strArr[0] = LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()));
            strArr[1] = "changetype: moddn";
            strArr[2] = LDIFWriter.encodeNameAndValue("newrdn", new ASN1OctetString(this.newRDN));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteoldrdn: ");
            sb2.append(this.deleteOldRDN ? "1" : "0");
            strArr[3] = sb2.toString();
            strArr[4] = LDIFWriter.encodeNameAndValue("newsuperior", new ASN1OctetString(this.newSuperiorDN));
        }
        List<String> asList = Arrays.asList(strArr);
        if (i > 2) {
            asList = LDIFWriter.wrapLines(i, asList);
        }
        return (String[]) asList.toArray(new String[asList.size()]);
    }

    public void toLDIFString(StringBuilder sb, int i) {
        ASN1OctetString aSN1OctetString;
        String str;
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), sb, i);
        sb.append(StaticUtils.EOL);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("moddn"), sb, i);
        sb.append(StaticUtils.EOL);
        LDIFWriter.encodeNameAndValue("newrdn", new ASN1OctetString(this.newRDN), sb, i);
        sb.append(StaticUtils.EOL);
        if (this.deleteOldRDN) {
            str = "deleteoldrdn";
            aSN1OctetString = new ASN1OctetString("1");
        } else {
            str = "deleteoldrdn";
            aSN1OctetString = new ASN1OctetString("0");
        }
        LDIFWriter.encodeNameAndValue(str, aSN1OctetString, sb, i);
        sb.append(StaticUtils.EOL);
        String str2 = this.newSuperiorDN;
        if (str2 != null) {
            LDIFWriter.encodeNameAndValue("newsuperior", new ASN1OctetString(str2), sb, i);
            sb.append(StaticUtils.EOL);
        }
    }

    public ModifyDNRequest toModifyDNRequest() {
        return new ModifyDNRequest(getDN(), this.newRDN, this.deleteOldRDN, this.newSuperiorDN);
    }

    public void toString(StringBuilder sb) {
        sb.append("LDIFModifyDNChangeRecord(dn='");
        sb.append(getDN());
        sb.append("', newRDN='");
        sb.append(this.newRDN);
        sb.append("', deleteOldRDN=");
        sb.append(this.deleteOldRDN);
        if (this.newSuperiorDN != null) {
            sb.append(", newSuperiorDN='");
            sb.append(this.newSuperiorDN);
            sb.append('\'');
        }
        sb.append(')');
    }
}
