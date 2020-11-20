package com.unboundid.ldap.sdk;

import com.unboundid.util.LDAPSDKRuntimeException;

public final class LDAPRuntimeException extends LDAPSDKRuntimeException {
    private static final long serialVersionUID = 6201514484547092642L;
    private final LDAPException ldapException;

    public LDAPRuntimeException(LDAPException lDAPException) {
        super(lDAPException.getMessage(), lDAPException.getCause());
        this.ldapException = lDAPException;
    }

    public String getDiagnosticMessage() {
        return this.ldapException.getDiagnosticMessage();
    }

    public String getExceptionMessage() {
        return this.ldapException.getExceptionMessage();
    }

    public LDAPException getLDAPException() {
        return this.ldapException;
    }

    public String getMatchedDN() {
        return this.ldapException.getMatchedDN();
    }

    public String[] getReferralURLs() {
        return this.ldapException.getReferralURLs();
    }

    public Control getResponseControl(String str) {
        return this.ldapException.getResponseControl(str);
    }

    public Control[] getResponseControls() {
        return this.ldapException.getResponseControls();
    }

    public ResultCode getResultCode() {
        return this.ldapException.getResultCode();
    }

    public boolean hasResponseControl() {
        return this.ldapException.hasResponseControl();
    }

    public boolean hasResponseControl(String str) {
        return this.ldapException.hasResponseControl(str);
    }

    public void throwLDAPException() {
        throw this.ldapException;
    }

    public LDAPResult toLDAPResult() {
        return this.ldapException.toLDAPResult();
    }

    public void toString(StringBuilder sb) {
        this.ldapException.toString(sb);
    }
}
