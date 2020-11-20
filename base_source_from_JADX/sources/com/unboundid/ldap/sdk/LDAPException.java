package com.unboundid.ldap.sdk;

import com.unboundid.util.LDAPSDKException;
import com.unboundid.util.StaticUtils;

public class LDAPException extends LDAPSDKException {
    protected static final Control[] NO_CONTROLS = StaticUtils.NO_CONTROLS;
    protected static final String[] NO_REFERRALS = StaticUtils.NO_STRINGS;
    private static final long serialVersionUID = -4257171063946350327L;
    private final String diagnosticMessage;
    private final String matchedDN;
    private final String[] referralURLs;
    private final Control[] responseControls;
    private final ResultCode resultCode;

    public LDAPException(LDAPException lDAPException) {
        super(lDAPException.getMessage(), lDAPException.getCause());
        this.resultCode = lDAPException.getResultCode();
        this.matchedDN = lDAPException.getMatchedDN();
        this.diagnosticMessage = lDAPException.getDiagnosticMessage();
        this.referralURLs = lDAPException.getReferralURLs();
        this.responseControls = lDAPException.getResponseControls();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LDAPException(LDAPResult lDAPResult) {
        super(lDAPResult.getDiagnosticMessage() == null ? lDAPResult.getResultCode().getName() : lDAPResult.getDiagnosticMessage());
        this.resultCode = lDAPResult.getResultCode();
        this.matchedDN = lDAPResult.getMatchedDN();
        this.diagnosticMessage = lDAPResult.getDiagnosticMessage();
        this.referralURLs = lDAPResult.getReferralURLs();
        this.responseControls = lDAPResult.getResponseControls();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LDAPException(LDAPResult lDAPResult, Throwable th) {
        super(lDAPResult.getDiagnosticMessage() == null ? lDAPResult.getResultCode().getName() : lDAPResult.getDiagnosticMessage(), th);
        this.resultCode = lDAPResult.getResultCode();
        this.matchedDN = lDAPResult.getMatchedDN();
        this.diagnosticMessage = lDAPResult.getDiagnosticMessage();
        this.referralURLs = lDAPResult.getReferralURLs();
        this.responseControls = lDAPResult.getResponseControls();
    }

    public LDAPException(ResultCode resultCode2) {
        super(resultCode2.getName());
        this.resultCode = resultCode2;
        this.matchedDN = null;
        this.diagnosticMessage = null;
        this.referralURLs = NO_REFERRALS;
        this.responseControls = NO_CONTROLS;
    }

    public LDAPException(ResultCode resultCode2, String str) {
        super(str);
        this.resultCode = resultCode2;
        this.matchedDN = null;
        this.diagnosticMessage = null;
        this.referralURLs = NO_REFERRALS;
        this.responseControls = NO_CONTROLS;
    }

    public LDAPException(ResultCode resultCode2, String str, String str2, String[] strArr) {
        super(str);
        this.resultCode = resultCode2;
        this.matchedDN = str2;
        if (strArr == null) {
            this.referralURLs = NO_REFERRALS;
        } else {
            this.referralURLs = strArr;
        }
        this.diagnosticMessage = null;
        this.responseControls = NO_CONTROLS;
    }

    public LDAPException(ResultCode resultCode2, String str, String str2, String[] strArr, Throwable th) {
        super(str, th);
        this.resultCode = resultCode2;
        this.matchedDN = str2;
        if (strArr == null) {
            this.referralURLs = NO_REFERRALS;
        } else {
            this.referralURLs = strArr;
        }
        this.diagnosticMessage = null;
        this.responseControls = NO_CONTROLS;
    }

    public LDAPException(ResultCode resultCode2, String str, String str2, String[] strArr, Control[] controlArr) {
        super(str);
        this.resultCode = resultCode2;
        this.matchedDN = str2;
        this.diagnosticMessage = null;
        if (strArr == null) {
            this.referralURLs = NO_REFERRALS;
        } else {
            this.referralURLs = strArr;
        }
        if (controlArr == null) {
            this.responseControls = NO_CONTROLS;
        } else {
            this.responseControls = controlArr;
        }
    }

    public LDAPException(ResultCode resultCode2, String str, String str2, String[] strArr, Control[] controlArr, Throwable th) {
        super(str, th);
        this.resultCode = resultCode2;
        this.matchedDN = str2;
        this.diagnosticMessage = null;
        if (strArr == null) {
            this.referralURLs = NO_REFERRALS;
        } else {
            this.referralURLs = strArr;
        }
        if (controlArr == null) {
            this.responseControls = NO_CONTROLS;
        } else {
            this.responseControls = controlArr;
        }
    }

    public LDAPException(ResultCode resultCode2, String str, Throwable th) {
        super(str, th);
        this.resultCode = resultCode2;
        this.matchedDN = null;
        this.diagnosticMessage = null;
        this.referralURLs = NO_REFERRALS;
        this.responseControls = NO_CONTROLS;
    }

    public LDAPException(ResultCode resultCode2, Throwable th) {
        super(resultCode2.getName(), th);
        this.resultCode = resultCode2;
        this.matchedDN = null;
        this.diagnosticMessage = null;
        this.referralURLs = NO_REFERRALS;
        this.responseControls = NO_CONTROLS;
    }

    public final String getDiagnosticMessage() {
        return this.diagnosticMessage;
    }

    public final String getExceptionMessage() {
        return toString();
    }

    public final String getMatchedDN() {
        return this.matchedDN;
    }

    public final String[] getReferralURLs() {
        return this.referralURLs;
    }

    public final Control getResponseControl(String str) {
        for (Control control : this.responseControls) {
            if (control.getOID().equals(str)) {
                return control;
            }
        }
        return null;
    }

    public final Control[] getResponseControls() {
        return this.responseControls;
    }

    public final ResultCode getResultCode() {
        return this.resultCode;
    }

    public final boolean hasResponseControl() {
        return this.responseControls.length > 0;
    }

    public final boolean hasResponseControl(String str) {
        for (Control oid : this.responseControls) {
            if (oid.getOID().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public LDAPResult toLDAPResult() {
        return (this.diagnosticMessage != null || getMessage() == null) ? new LDAPResult(-1, this.resultCode, this.diagnosticMessage, this.matchedDN, this.referralURLs, this.responseControls) : new LDAPResult(-1, this.resultCode, getMessage(), this.matchedDN, this.referralURLs, this.responseControls);
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPException(resultCode=");
        sb.append(this.resultCode);
        String message = getMessage();
        if (message != null) {
            sb.append(", errorMessage='");
            sb.append(message);
            sb.append('\'');
        }
        if (this.matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(this.matchedDN);
            sb.append('\'');
        }
        if (this.diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(this.diagnosticMessage);
            sb.append('\'');
        }
        if (this.referralURLs.length > 0) {
            sb.append(", referralURLs={");
            for (int i = 0; i < this.referralURLs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(this.referralURLs[i]);
                sb.append('\'');
            }
            sb.append('}');
        }
        if (this.responseControls.length > 0) {
            sb.append(", responseControls={");
            for (int i2 = 0; i2 < this.responseControls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.responseControls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
