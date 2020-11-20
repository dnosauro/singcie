package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldap.sdk.extensions.CancelExtendedRequest;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.InternalUseOnly;
import javax.net.ssl.SSLContext;

@InternalUseOnly
public final class InternalSDKHelper {
    private InternalSDKHelper() {
    }

    @InternalUseOnly
    public static void cancel(LDAPConnection lDAPConnection, int i, Control... controlArr) {
        lDAPConnection.sendMessage(new LDAPMessage(lDAPConnection.nextMessageID(), (ProtocolOp) new ExtendedRequest((ExtendedRequest) new CancelExtendedRequest(i)), controlArr));
    }

    @InternalUseOnly
    public static void convertToTLS(LDAPConnection lDAPConnection, SSLContext sSLContext) {
        lDAPConnection.convertToTLS(sSLContext);
    }

    @InternalUseOnly
    public static AsyncRequestID createAsyncRequestID(int i, LDAPConnection lDAPConnection) {
        return new AsyncRequestID(i, lDAPConnection);
    }

    @InternalUseOnly
    public static Boolean followReferralsInternal(LDAPRequest lDAPRequest) {
        return lDAPRequest.followReferralsInternal();
    }

    @InternalUseOnly
    public static int nextMessageID(LDAPConnection lDAPConnection) {
        return lDAPConnection.nextMessageID();
    }

    @InternalUseOnly
    public static BindResult readBindResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return BindResult.readBindResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static CompareResult readCompareResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return CompareResult.readCompareResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static ExtendedResult readExtendedResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return ExtendedResult.readExtendedResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static IntermediateResponse readIntermediateResponseFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return IntermediateResponse.readFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static LDAPResult readLDAPResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return LDAPResult.readLDAPResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static SearchResultEntry readSearchResultEntryFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader, Schema schema) {
        return SearchResultEntry.readSearchEntryFrom(i, aSN1StreamReaderSequence, aSN1StreamReader, schema);
    }

    @InternalUseOnly
    public static SearchResult readSearchResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return SearchResult.readSearchResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static SearchResultReference readSearchResultReferenceFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return SearchResultReference.readSearchReferenceFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
    }

    @InternalUseOnly
    public static void setSoTimeout(LDAPConnection lDAPConnection, int i) {
        LDAPConnectionReader connectionReader = lDAPConnection.getConnectionInternals().getConnectionReader();
        if (connectionReader != null) {
            connectionReader.setSoTimeout(i);
        }
    }
}
