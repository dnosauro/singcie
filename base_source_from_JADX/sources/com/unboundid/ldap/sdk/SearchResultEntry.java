package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class SearchResultEntry extends ReadOnlyEntry implements LDAPResponse {
    private static final long serialVersionUID = -290721544252526163L;
    private final Control[] controls;
    private final int messageID;

    public SearchResultEntry(int i, Entry entry, Control... controlArr) {
        super(entry);
        Validator.ensureNotNull(controlArr);
        this.messageID = i;
        this.controls = controlArr;
    }

    public SearchResultEntry(int i, String str, Schema schema, Collection<Attribute> collection, Control... controlArr) {
        super(str, schema, collection);
        Validator.ensureNotNull(controlArr);
        this.messageID = i;
        this.controls = controlArr;
    }

    public SearchResultEntry(int i, String str, Schema schema, Attribute[] attributeArr, Control... controlArr) {
        super(str, schema, attributeArr);
        Validator.ensureNotNull(controlArr);
        this.messageID = i;
        this.controls = controlArr;
    }

    public SearchResultEntry(int i, String str, Collection<Attribute> collection, Control... controlArr) {
        this(i, str, (Schema) null, collection, controlArr);
    }

    public SearchResultEntry(int i, String str, Attribute[] attributeArr, Control... controlArr) {
        this(i, str, (Schema) null, attributeArr, controlArr);
    }

    public SearchResultEntry(Entry entry, Control... controlArr) {
        this(-1, entry, controlArr);
    }

    public SearchResultEntry(String str, Collection<Attribute> collection, Control... controlArr) {
        this(-1, str, (Schema) null, collection, controlArr);
    }

    public SearchResultEntry(String str, Attribute[] attributeArr, Control... controlArr) {
        this(-1, str, (Schema) null, attributeArr, controlArr);
    }

    static SearchResultEntry readSearchEntryFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader, Schema schema) {
        Control[] controlArr;
        try {
            aSN1StreamReader.beginSequence();
            String readString = aSN1StreamReader.readString();
            ArrayList arrayList = new ArrayList(10);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(Attribute.readFrom(aSN1StreamReader, schema));
            }
            Control[] controlArr2 = NO_CONTROLS;
            if (aSN1StreamReaderSequence.hasMoreElements()) {
                ArrayList arrayList2 = new ArrayList(5);
                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                while (beginSequence2.hasMoreElements()) {
                    arrayList2.add(Control.readFrom(aSN1StreamReader));
                }
                Control[] controlArr3 = new Control[arrayList2.size()];
                arrayList2.toArray(controlArr3);
                controlArr = controlArr3;
            } else {
                controlArr = controlArr2;
            }
            return new SearchResultEntry(i, readString, schema, (Collection<Attribute>) arrayList, controlArr);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_SEARCH_ENTRY_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof SearchResultEntry)) {
            return false;
        }
        SearchResultEntry searchResultEntry = (SearchResultEntry) obj;
        if (this.controls.length != searchResultEntry.controls.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Control[] controlArr = this.controls;
            if (i >= controlArr.length) {
                return true;
            }
            if (!controlArr[i].equals(searchResultEntry.controls[i])) {
                return false;
            }
            i++;
        }
    }

    public Control getControl(String str) {
        for (Control control : this.controls) {
            if (control.getOID().equals(str)) {
                return control;
            }
        }
        return null;
    }

    public Control[] getControls() {
        return this.controls;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        for (Control hashCode2 : this.controls) {
            hashCode += hashCode2.hashCode();
        }
        return hashCode;
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchResultEntry(dn='");
        sb.append(getDN());
        sb.append('\'');
        if (this.messageID >= 0) {
            sb.append(", messageID=");
            sb.append(this.messageID);
        }
        sb.append(", attributes={");
        Iterator<Attribute> it = getAttributes().iterator();
        while (it.hasNext()) {
            it.next().toString(sb);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}, controls={");
        for (int i = 0; i < this.controls.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            this.controls[i].toString(sb);
        }
        sb.append("})");
    }
}
