package com.unboundid.ldap.sdk;

import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class LDAPRequest implements ReadOnlyLDAPRequest {
    static final Control[] NO_CONTROLS = new Control[0];
    private static final long serialVersionUID = -2040756188243320117L;
    private Control[] controls;
    private Boolean followReferrals;
    private IntermediateResponseListener intermediateResponseListener;
    private long responseTimeout;

    protected LDAPRequest(Control[] controlArr) {
        this.controls = controlArr == null ? NO_CONTROLS : controlArr;
        this.followReferrals = null;
        this.responseTimeout = -1;
        this.intermediateResponseListener = null;
    }

    public final boolean followReferrals(LDAPConnection lDAPConnection) {
        Boolean bool = this.followReferrals;
        return bool == null ? lDAPConnection.getConnectionOptions().followReferrals() : bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Boolean followReferralsInternal() {
        return this.followReferrals;
    }

    public final Control getControl(String str) {
        Validator.ensureNotNull(str);
        for (Control control : this.controls) {
            if (control.getOID().equals(str)) {
                return control;
            }
        }
        return null;
    }

    public final List<Control> getControlList() {
        return Collections.unmodifiableList(Arrays.asList(this.controls));
    }

    public final Control[] getControls() {
        return this.controls;
    }

    public final IntermediateResponseListener getIntermediateResponseListener() {
        return this.intermediateResponseListener;
    }

    public abstract int getLastMessageID();

    public abstract OperationType getOperationType();

    public final long getResponseTimeoutMillis(LDAPConnection lDAPConnection) {
        return (this.responseTimeout >= 0 || lDAPConnection == null) ? this.responseTimeout : lDAPConnection.getConnectionOptions().getResponseTimeoutMillis();
    }

    public final boolean hasControl() {
        return this.controls.length > 0;
    }

    public final boolean hasControl(String str) {
        Validator.ensureNotNull(str);
        for (Control oid : this.controls) {
            if (oid.getOID().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @InternalUseOnly
    public abstract LDAPResult process(LDAPConnection lDAPConnection, int i);

    /* access modifiers changed from: package-private */
    public final void setControlsInternal(Control[] controlArr) {
        this.controls = controlArr;
    }

    public final void setFollowReferrals(Boolean bool) {
        this.followReferrals = bool;
    }

    public final void setIntermediateResponseListener(IntermediateResponseListener intermediateResponseListener2) {
        this.intermediateResponseListener = intermediateResponseListener2;
    }

    public final void setResponseTimeoutMillis(long j) {
        if (j < 0) {
            j = -1;
        }
        this.responseTimeout = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public abstract void toString(StringBuilder sb);
}
