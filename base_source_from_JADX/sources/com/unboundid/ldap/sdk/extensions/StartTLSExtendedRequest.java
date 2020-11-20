package com.unboundid.ldap.sdk.extensions;

import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.ExtendedRequest;
import com.unboundid.ldap.sdk.ExtendedResult;
import com.unboundid.ldap.sdk.InternalSDKHelper;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public final class StartTLSExtendedRequest extends ExtendedRequest {
    public static final String STARTTLS_REQUEST_OID = "1.3.6.1.4.1.1466.20037";
    private static final long serialVersionUID = -3234194603452821233L;
    private final SSLContext sslContext;

    public StartTLSExtendedRequest() {
        this((SSLContext) null, (Control[]) null);
    }

    public StartTLSExtendedRequest(ExtendedRequest extendedRequest) {
        this(extendedRequest.getControls());
        if (extendedRequest.hasValue()) {
            throw new LDAPException(ResultCode.DECODING_ERROR, ExtOpMessages.ERR_STARTTLS_REQUEST_HAS_VALUE.get());
        }
    }

    public StartTLSExtendedRequest(SSLContext sSLContext) {
        this(sSLContext, (Control[]) null);
    }

    public StartTLSExtendedRequest(SSLContext sSLContext, Control[] controlArr) {
        super(STARTTLS_REQUEST_OID, controlArr);
        if (sSLContext == null) {
            try {
                this.sslContext = SSLContext.getInstance("SSL");
                this.sslContext.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            } catch (Exception e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.LOCAL_ERROR, ExtOpMessages.ERR_STARTTLS_REQUEST_CANNOT_CREATE_DEFAULT_CONTEXT.get(e), e);
            }
        } else {
            this.sslContext = sSLContext;
        }
    }

    public StartTLSExtendedRequest(Control[] controlArr) {
        this((SSLContext) null, controlArr);
    }

    public StartTLSExtendedRequest duplicate() {
        return duplicate(getControls());
    }

    public StartTLSExtendedRequest duplicate(Control[] controlArr) {
        try {
            StartTLSExtendedRequest startTLSExtendedRequest = new StartTLSExtendedRequest(this.sslContext, controlArr);
            startTLSExtendedRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
            return startTLSExtendedRequest;
        } catch (Exception e) {
            Debug.debugException(e);
            return null;
        }
    }

    public String getExtendedRequestName() {
        return ExtOpMessages.INFO_EXTENDED_REQUEST_NAME_START_TLS.get();
    }

    public ExtendedResult process(LDAPConnection lDAPConnection, int i) {
        InternalSDKHelper.setSoTimeout(lDAPConnection, 50);
        ExtendedResult process = super.process(lDAPConnection, i);
        if (process.getResultCode() == ResultCode.SUCCESS) {
            InternalSDKHelper.convertToTLS(lDAPConnection, this.sslContext);
        }
        return process;
    }

    public void toString(StringBuilder sb) {
        sb.append("StartTLSExtendedRequest(");
        Control[] controls = getControls();
        if (controls.length > 0) {
            sb.append("controls={");
            for (int i = 0; i < controls.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(controls[i]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
