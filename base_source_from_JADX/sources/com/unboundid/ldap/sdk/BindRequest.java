package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Integer;

public abstract class BindRequest extends LDAPRequest {
    protected static final ASN1Integer VERSION_ELEMENT = new ASN1Integer(3);
    private static final long serialVersionUID = -1509925217235385907L;

    protected BindRequest(Control[] controlArr) {
        super(controlArr);
    }

    public abstract BindRequest duplicate();

    public abstract BindRequest duplicate(Control[] controlArr);

    public abstract String getBindType();

    public final OperationType getOperationType() {
        return OperationType.BIND;
    }

    public BindRequest getRebindRequest(String str, int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract BindResult process(LDAPConnection lDAPConnection, int i);
}
