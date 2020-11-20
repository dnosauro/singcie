package com.unboundid.ldap.sdk.extensions;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.ExtendedResult;
import com.unboundid.ldap.sdk.ResultCode;

public final class NoticeOfDisconnectionExtendedResult extends ExtendedResult {
    public static final String NOTICE_OF_DISCONNECTION_RESULT_OID = "1.3.6.1.4.1.1466.20036";
    private static final long serialVersionUID = -4706102471360689558L;

    public NoticeOfDisconnectionExtendedResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, Control[] controlArr) {
        super(i, resultCode, str, str2, strArr, NOTICE_OF_DISCONNECTION_RESULT_OID, (ASN1OctetString) null, controlArr);
    }

    public NoticeOfDisconnectionExtendedResult(ExtendedResult extendedResult) {
        super(extendedResult);
    }

    public String getExtendedResultName() {
        return ExtOpMessages.INFO_EXTENDED_RESULT_NAME_NOTICE_OF_DISCONNECT.get();
    }

    public void toString(StringBuilder sb) {
        sb.append("NoticeOfDisconnectionExtendedResult(resultCode=");
        sb.append(getResultCode());
        int messageID = getMessageID();
        if (messageID >= 0) {
            sb.append(", messageID=");
            sb.append(messageID);
        }
        String diagnosticMessage = getDiagnosticMessage();
        if (diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(diagnosticMessage);
            sb.append('\'');
        }
        String matchedDN = getMatchedDN();
        if (matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(matchedDN);
            sb.append('\'');
        }
        String[] referralURLs = getReferralURLs();
        if (referralURLs.length > 0) {
            sb.append(", referralURLs={");
            for (int i = 0; i < referralURLs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(referralURLs[i]);
                sb.append('\'');
            }
            sb.append('}');
        }
        sb.append(", oid=");
        sb.append(NOTICE_OF_DISCONNECTION_RESULT_OID);
        Control[] responseControls = getResponseControls();
        if (responseControls.length > 0) {
            sb.append(", responseControls={");
            for (int i2 = 0; i2 < responseControls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(responseControls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
