package com.unboundid.ldap.sdk.extensions;

import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Integer;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.sdk.AsyncRequestID;
import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.ExtendedRequest;
import com.unboundid.ldap.sdk.ExtendedResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;

public final class CancelExtendedRequest extends ExtendedRequest {
    public static final String CANCEL_REQUEST_OID = "1.3.6.1.1.8";
    private static final long serialVersionUID = -7170687636394194183L;
    private final int targetMessageID;

    public CancelExtendedRequest(int i) {
        this(i, (Control[]) null);
    }

    public CancelExtendedRequest(int i, Control[] controlArr) {
        super(CANCEL_REQUEST_OID, encodeValue(i), controlArr);
        this.targetMessageID = i;
    }

    public CancelExtendedRequest(AsyncRequestID asyncRequestID) {
        this(asyncRequestID.getMessageID(), (Control[]) null);
    }

    public CancelExtendedRequest(AsyncRequestID asyncRequestID, Control[] controlArr) {
        this(asyncRequestID.getMessageID(), controlArr);
    }

    public CancelExtendedRequest(ExtendedRequest extendedRequest) {
        super(extendedRequest);
        ASN1OctetString value = extendedRequest.getValue();
        if (value != null) {
            try {
                this.targetMessageID = ASN1Integer.decodeAsInteger(ASN1Sequence.decodeAsSequence(ASN1Element.decode(value.getValue())).elements()[0]).intValue();
            } catch (Exception e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.DECODING_ERROR, ExtOpMessages.ERR_CANCEL_REQUEST_CANNOT_DECODE.get(e), e);
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, ExtOpMessages.ERR_CANCEL_REQUEST_NO_VALUE.get());
        }
    }

    private static ASN1OctetString encodeValue(int i) {
        return new ASN1OctetString(new ASN1Sequence(new ASN1Integer(i)).encode());
    }

    public CancelExtendedRequest duplicate() {
        return duplicate(getControls());
    }

    public CancelExtendedRequest duplicate(Control[] controlArr) {
        CancelExtendedRequest cancelExtendedRequest = new CancelExtendedRequest(this.targetMessageID, controlArr);
        cancelExtendedRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return cancelExtendedRequest;
    }

    public String getExtendedRequestName() {
        return ExtOpMessages.INFO_EXTENDED_REQUEST_NAME_CANCEL.get();
    }

    public int getTargetMessageID() {
        return this.targetMessageID;
    }

    /* access modifiers changed from: protected */
    public ExtendedResult process(LDAPConnection lDAPConnection, int i) {
        if (!lDAPConnection.synchronousMode()) {
            return super.process(lDAPConnection, i);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, ExtOpMessages.ERR_CANCEL_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public void toString(StringBuilder sb) {
        sb.append("CancelExtendedRequest(targetMessageID=");
        sb.append(this.targetMessageID);
        Control[] controls = getControls();
        if (controls.length > 0) {
            sb.append(", controls={");
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
