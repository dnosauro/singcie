package com.unboundid.ldap.sdk;

import com.unboundid.ldap.sdk.extensions.StartTLSExtendedRequest;
import com.unboundid.util.Validator;
import javax.net.ssl.SSLContext;

public final class StartTLSPostConnectProcessor implements PostConnectProcessor {
    private final SSLContext sslContext;

    public StartTLSPostConnectProcessor(SSLContext sSLContext) {
        Validator.ensureNotNull(sSLContext);
        this.sslContext = sSLContext;
    }

    public void processPostAuthenticatedConnection(LDAPConnection lDAPConnection) {
    }

    public void processPreAuthenticatedConnection(LDAPConnection lDAPConnection) {
        ExtendedResult processExtendedOperation = lDAPConnection.processExtendedOperation((ExtendedRequest) new StartTLSExtendedRequest(this.sslContext));
        if (!processExtendedOperation.getResultCode().equals(ResultCode.SUCCESS)) {
            throw new LDAPException((LDAPResult) processExtendedOperation);
        }
    }
}
