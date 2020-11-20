package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.ChangeType;
import com.unboundid.ldap.sdk.LDAPInterface;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.Modification;
import com.unboundid.ldap.sdk.ModifyRequest;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LDIFModifyChangeRecord extends LDIFChangeRecord {
    private static final long serialVersionUID = 6317289692291736272L;
    private final Modification[] modifications;

    public LDIFModifyChangeRecord(ModifyRequest modifyRequest) {
        super(modifyRequest.getDN());
        List<Modification> modifications2 = modifyRequest.getModifications();
        this.modifications = new Modification[modifications2.size()];
        Iterator<Modification> it = modifications2.iterator();
        int i = 0;
        while (true) {
            Modification[] modificationArr = this.modifications;
            if (i < modificationArr.length) {
                modificationArr[i] = it.next();
                i++;
            } else {
                return;
            }
        }
    }

    public LDIFModifyChangeRecord(String str, List<Modification> list) {
        super(str);
        Validator.ensureNotNull(list);
        Validator.ensureFalse(list.isEmpty(), "LDIFModifyChangeRecord.modifications must not be empty.");
        this.modifications = new Modification[list.size()];
        list.toArray(this.modifications);
    }

    public LDIFModifyChangeRecord(String str, Modification... modificationArr) {
        super(str);
        Validator.ensureNotNull(modificationArr);
        Validator.ensureTrue(modificationArr.length > 0, "LDIFModifyChangeRecord.modifications must not be empty.");
        this.modifications = modificationArr;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LDIFModifyChangeRecord)) {
            return false;
        }
        LDIFModifyChangeRecord lDIFModifyChangeRecord = (LDIFModifyChangeRecord) obj;
        try {
            if (!getParsedDN().equals((Object) lDIFModifyChangeRecord.getParsedDN())) {
                return false;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            if (!StaticUtils.toLowerCase(getDN()).equals(StaticUtils.toLowerCase(lDIFModifyChangeRecord.getDN()))) {
                return false;
            }
        }
        if (this.modifications.length != lDIFModifyChangeRecord.modifications.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Modification[] modificationArr = this.modifications;
            if (i >= modificationArr.length) {
                return true;
            }
            if (!modificationArr[i].equals(lDIFModifyChangeRecord.modifications[i])) {
                return false;
            }
            i++;
        }
    }

    public ChangeType getChangeType() {
        return ChangeType.MODIFY;
    }

    public Modification[] getModifications() {
        return this.modifications;
    }

    public int hashCode() {
        int i;
        try {
            i = getParsedDN().hashCode();
        } catch (Exception e) {
            Debug.debugException(e);
            i = StaticUtils.toLowerCase(getDN()).hashCode();
        }
        for (Modification hashCode : this.modifications) {
            i += hashCode.hashCode();
        }
        return i;
    }

    public LDAPResult processChange(LDAPInterface lDAPInterface) {
        return lDAPInterface.modify(toModifyRequest());
    }

    public void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        ASN1OctetString aSN1OctetString;
        String str;
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("modify"), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        int i2 = 0;
        while (true) {
            Modification[] modificationArr = this.modifications;
            if (i2 < modificationArr.length) {
                String attributeName = modificationArr[i2].getAttributeName();
                switch (this.modifications[i2].getModificationType().intValue()) {
                    case 0:
                        str = "add";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 1:
                        str = "delete";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 2:
                        str = "replace";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 3:
                        str = "increment";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                }
                LDIFWriter.encodeNameAndValue(str, aSN1OctetString, byteStringBuffer, i);
                byteStringBuffer.append(StaticUtils.EOL_BYTES);
                for (ASN1OctetString encodeNameAndValue : this.modifications[i2].getRawValues()) {
                    LDIFWriter.encodeNameAndValue(attributeName, encodeNameAndValue, byteStringBuffer, i);
                    byteStringBuffer.append(StaticUtils.EOL_BYTES);
                }
                if (i2 < this.modifications.length - 1) {
                    byteStringBuffer.append('-');
                    byteStringBuffer.append(StaticUtils.EOL_BYTES);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public String[] toLDIF(int i) {
        String str;
        StringBuilder sb;
        List arrayList = new ArrayList(this.modifications.length * 4);
        arrayList.add(LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN())));
        arrayList.add("changetype: modify");
        int i2 = 0;
        while (true) {
            Modification[] modificationArr = this.modifications;
            if (i2 < modificationArr.length) {
                String attributeName = modificationArr[i2].getAttributeName();
                switch (this.modifications[i2].getModificationType().intValue()) {
                    case 0:
                        sb = new StringBuilder();
                        str = "add: ";
                        break;
                    case 1:
                        sb = new StringBuilder();
                        str = "delete: ";
                        break;
                    case 2:
                        sb = new StringBuilder();
                        str = "replace: ";
                        break;
                    case 3:
                        sb = new StringBuilder();
                        str = "increment: ";
                        break;
                }
                sb.append(str);
                sb.append(attributeName);
                arrayList.add(sb.toString());
                for (ASN1OctetString encodeNameAndValue : this.modifications[i2].getRawValues()) {
                    arrayList.add(LDIFWriter.encodeNameAndValue(attributeName, encodeNameAndValue));
                }
                if (i2 < this.modifications.length - 1) {
                    arrayList.add("-");
                }
                i2++;
            } else {
                if (i > 2) {
                    arrayList = LDIFWriter.wrapLines(i, (List<String>) arrayList);
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                return strArr;
            }
        }
    }

    public void toLDIFString(StringBuilder sb, int i) {
        ASN1OctetString aSN1OctetString;
        String str;
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(getDN()), sb, i);
        sb.append(StaticUtils.EOL);
        LDIFWriter.encodeNameAndValue("changetype", new ASN1OctetString("modify"), sb, i);
        sb.append(StaticUtils.EOL);
        int i2 = 0;
        while (true) {
            Modification[] modificationArr = this.modifications;
            if (i2 < modificationArr.length) {
                String attributeName = modificationArr[i2].getAttributeName();
                switch (this.modifications[i2].getModificationType().intValue()) {
                    case 0:
                        str = "add";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 1:
                        str = "delete";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 2:
                        str = "replace";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                    case 3:
                        str = "increment";
                        aSN1OctetString = new ASN1OctetString(attributeName);
                        break;
                }
                LDIFWriter.encodeNameAndValue(str, aSN1OctetString, sb, i);
                sb.append(StaticUtils.EOL);
                for (ASN1OctetString encodeNameAndValue : this.modifications[i2].getRawValues()) {
                    LDIFWriter.encodeNameAndValue(attributeName, encodeNameAndValue, sb, i);
                    sb.append(StaticUtils.EOL);
                }
                if (i2 < this.modifications.length - 1) {
                    sb.append('-');
                    sb.append(StaticUtils.EOL);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public ModifyRequest toModifyRequest() {
        return new ModifyRequest(getDN(), this.modifications);
    }

    public void toString(StringBuilder sb) {
        sb.append("LDIFModifyChangeRecord(dn='");
        sb.append(getDN());
        sb.append("', mods={");
        for (int i = 0; i < this.modifications.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            this.modifications[i].toString(sb);
        }
        sb.append("})");
    }
}
