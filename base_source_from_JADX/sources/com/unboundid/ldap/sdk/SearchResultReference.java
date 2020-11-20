package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;

public final class SearchResultReference implements LDAPResponse, Serializable {
    private static final long serialVersionUID = 5675961266319346053L;
    private final Control[] controls;
    private final int messageID;
    private final String[] referralURLs;

    public SearchResultReference(int i, String[] strArr, Control[] controlArr) {
        Validator.ensureNotNull(strArr);
        this.messageID = i;
        this.referralURLs = strArr;
        if (controlArr == null) {
            this.controls = NO_CONTROLS;
        } else {
            this.controls = controlArr;
        }
    }

    public SearchResultReference(String[] strArr, Control[] controlArr) {
        this(-1, strArr, controlArr);
    }

    static SearchResultReference readSearchReferenceFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        try {
            ArrayList arrayList = new ArrayList(5);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            while (beginSequence.hasMoreElements()) {
                arrayList.add(aSN1StreamReader.readString());
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            Control[] controlArr = NO_CONTROLS;
            if (aSN1StreamReaderSequence.hasMoreElements()) {
                ArrayList arrayList2 = new ArrayList(5);
                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                while (beginSequence2.hasMoreElements()) {
                    arrayList2.add(Control.readFrom(aSN1StreamReader));
                }
                controlArr = new Control[arrayList2.size()];
                arrayList2.toArray(controlArr);
            }
            return new SearchResultReference(i, strArr, controlArr);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_SEARCH_REFERENCE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
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

    public String[] getReferralURLs() {
        return this.referralURLs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchResultReference(referralURLs={");
        for (int i = 0; i < this.referralURLs.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.referralURLs[i]);
        }
        sb.append('}');
        if (this.messageID >= 0) {
            sb.append(", messageID=");
            sb.append(this.messageID);
        }
        sb.append(", controls={");
        for (int i2 = 0; i2 < this.controls.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            this.controls[i2].toString(sb);
        }
        sb.append("})");
    }
}
