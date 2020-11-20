package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@InternalUseOnly
public final class LDAPMessage implements Serializable {
    public static final byte MESSAGE_TYPE_CONTROLS = -96;
    public static final byte PROTOCOL_OP_TYPE_ABANDON_REQUEST = 80;
    public static final byte PROTOCOL_OP_TYPE_ADD_REQUEST = 104;
    public static final byte PROTOCOL_OP_TYPE_ADD_RESPONSE = 105;
    public static final byte PROTOCOL_OP_TYPE_BIND_REQUEST = 96;
    public static final byte PROTOCOL_OP_TYPE_BIND_RESPONSE = 97;
    public static final byte PROTOCOL_OP_TYPE_COMPARE_REQUEST = 110;
    public static final byte PROTOCOL_OP_TYPE_COMPARE_RESPONSE = 111;
    public static final byte PROTOCOL_OP_TYPE_DELETE_REQUEST = 74;
    public static final byte PROTOCOL_OP_TYPE_DELETE_RESPONSE = 107;
    public static final byte PROTOCOL_OP_TYPE_EXTENDED_REQUEST = 119;
    public static final byte PROTOCOL_OP_TYPE_EXTENDED_RESPONSE = 120;
    public static final byte PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE = 121;
    public static final byte PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST = 108;
    public static final byte PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE = 109;
    public static final byte PROTOCOL_OP_TYPE_MODIFY_REQUEST = 102;
    public static final byte PROTOCOL_OP_TYPE_MODIFY_RESPONSE = 103;
    public static final byte PROTOCOL_OP_TYPE_SEARCH_REQUEST = 99;
    public static final byte PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE = 101;
    public static final byte PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY = 100;
    public static final byte PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE = 115;
    public static final byte PROTOCOL_OP_TYPE_UNBIND_REQUEST = 66;
    private static final long serialVersionUID = 909272448857832592L;
    private final List<Control> controls;
    private final int messageID;
    private final ProtocolOp protocolOp;

    public LDAPMessage(int i, ProtocolOp protocolOp2, List<Control> list) {
        this.messageID = i;
        this.protocolOp = protocolOp2;
        this.controls = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public LDAPMessage(int i, ProtocolOp protocolOp2, Control... controlArr) {
        this.messageID = i;
        this.protocolOp = protocolOp2;
        this.controls = controlArr == null ? Collections.emptyList() : Collections.unmodifiableList(Arrays.asList(controlArr));
    }

    public static LDAPMessage readFrom(ASN1StreamReader aSN1StreamReader, boolean z) {
        ProtocolOp protocolOp2;
        try {
            aSN1StreamReader.setIgnoreSocketTimeout(false, z);
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            if (beginSequence == null) {
                return null;
            }
            try {
                aSN1StreamReader.setIgnoreSocketTimeout(z, z);
                int intValue = aSN1StreamReader.readInteger().intValue();
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek == 66) {
                    protocolOp2 = new UnbindRequestProtocolOp(aSN1StreamReader);
                } else if (peek == 74) {
                    protocolOp2 = new DeleteRequestProtocolOp(aSN1StreamReader);
                } else if (peek == 80) {
                    protocolOp2 = new AbandonRequestProtocolOp(aSN1StreamReader);
                } else if (peek != 115) {
                    switch (peek) {
                        case 96:
                            protocolOp2 = new BindRequestProtocolOp(aSN1StreamReader);
                            break;
                        case 97:
                            protocolOp2 = new BindResponseProtocolOp(aSN1StreamReader);
                            break;
                        default:
                            switch (peek) {
                                case 99:
                                    protocolOp2 = new SearchRequestProtocolOp(aSN1StreamReader);
                                    break;
                                case 100:
                                    protocolOp2 = new SearchResultEntryProtocolOp(aSN1StreamReader);
                                    break;
                                case 101:
                                    protocolOp2 = new SearchResultDoneProtocolOp(aSN1StreamReader);
                                    break;
                                case 102:
                                    protocolOp2 = new ModifyRequestProtocolOp(aSN1StreamReader);
                                    break;
                                case 103:
                                    protocolOp2 = new ModifyResponseProtocolOp(aSN1StreamReader);
                                    break;
                                case 104:
                                    protocolOp2 = new AddRequestProtocolOp(aSN1StreamReader);
                                    break;
                                case 105:
                                    protocolOp2 = new AddResponseProtocolOp(aSN1StreamReader);
                                    break;
                                default:
                                    switch (peek) {
                                        case 107:
                                            protocolOp2 = new DeleteResponseProtocolOp(aSN1StreamReader);
                                            break;
                                        case 108:
                                            protocolOp2 = new ModifyDNRequestProtocolOp(aSN1StreamReader);
                                            break;
                                        case 109:
                                            protocolOp2 = new ModifyDNResponseProtocolOp(aSN1StreamReader);
                                            break;
                                        case 110:
                                            protocolOp2 = new CompareRequestProtocolOp(aSN1StreamReader);
                                            break;
                                        case 111:
                                            protocolOp2 = new CompareResponseProtocolOp(aSN1StreamReader);
                                            break;
                                        default:
                                            switch (peek) {
                                                case 119:
                                                    protocolOp2 = new ExtendedRequestProtocolOp(aSN1StreamReader);
                                                    break;
                                                case 120:
                                                    protocolOp2 = new ExtendedResponseProtocolOp(aSN1StreamReader);
                                                    break;
                                                case 121:
                                                    protocolOp2 = new IntermediateResponseProtocolOp(aSN1StreamReader);
                                                    break;
                                                default:
                                                    throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_MESSAGE_INVALID_PROTOCOL_OP_TYPE.get(StaticUtils.toHex(peek)));
                                            }
                                    }
                            }
                    }
                } else {
                    protocolOp2 = new SearchResultReferenceProtocolOp(aSN1StreamReader);
                }
                ArrayList arrayList = new ArrayList(5);
                if (beginSequence.hasMoreElements()) {
                    ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                    while (beginSequence2.hasMoreElements()) {
                        arrayList.add(Control.readFrom(aSN1StreamReader));
                    }
                }
                return new LDAPMessage(intValue, protocolOp2, (List<Control>) arrayList);
            } catch (LDAPException e) {
                Debug.debugException(e);
                throw e;
            } catch (SocketTimeoutException e2) {
                Debug.debugException(e2);
                throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)));
            } catch (IOException e3) {
                Debug.debugException(e3);
                throw new LDAPException(ResultCode.SERVER_DOWN, ProtocolMessages.ERR_MESSAGE_IO_ERROR.get(StaticUtils.getExceptionMessage(e3)), e3);
            } catch (Exception e4) {
                Debug.debugException(e4);
                throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e4)), e4);
            }
        } catch (IOException e5) {
            if (!(e5 instanceof SocketTimeoutException)) {
                Debug.debugException(e5);
            }
            throw new LDAPException(ResultCode.SERVER_DOWN, ProtocolMessages.ERR_MESSAGE_IO_ERROR.get(StaticUtils.getExceptionMessage(e5)), e5);
        } catch (Exception e6) {
            Debug.debugException(e6);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e6)), e6);
        }
    }

    public static LDAPResponse readLDAPResponseFrom(ASN1StreamReader aSN1StreamReader, boolean z) {
        return readLDAPResponseFrom(aSN1StreamReader, z, (Schema) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        return com.unboundid.ldap.sdk.InternalSDKHelper.readLDAPResultFrom(r6, r2, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.ldap.protocol.LDAPResponse readLDAPResponseFrom(com.unboundid.asn1.ASN1StreamReader r5, boolean r6, com.unboundid.ldap.sdk.schema.Schema r7) {
        /*
            r0 = 1
            r1 = 0
            r5.setIgnoreSocketTimeout(r1, r6)     // Catch:{ IOException -> 0x00fa, Exception -> 0x00e0 }
            com.unboundid.asn1.ASN1StreamReaderSequence r2 = r5.beginSequence()     // Catch:{ IOException -> 0x00fa, Exception -> 0x00e0 }
            if (r2 != 0) goto L_0x000d
            r5 = 0
            return r5
        L_0x000d:
            r5.setIgnoreSocketTimeout(r6, r6)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.Integer r6 = r5.readInteger()     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            int r6 = r6.intValue()     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            int r3 = r5.peek()     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            byte r3 = (byte) r3     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            r4 = 66
            if (r3 == r4) goto L_0x0077
            r4 = 74
            if (r3 == r4) goto L_0x0077
            r4 = 80
            if (r3 == r4) goto L_0x0077
            r4 = 115(0x73, float:1.61E-43)
            if (r3 == r4) goto L_0x0072
            switch(r3) {
                case 96: goto L_0x0077;
                case 97: goto L_0x006d;
                default: goto L_0x0030;
            }     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x0030:
            switch(r3) {
                case 99: goto L_0x0077;
                case 100: goto L_0x0068;
                case 101: goto L_0x0063;
                case 102: goto L_0x0077;
                case 103: goto L_0x005e;
                case 104: goto L_0x0077;
                case 105: goto L_0x005e;
                default: goto L_0x0033;
            }     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x0033:
            switch(r3) {
                case 107: goto L_0x005e;
                case 108: goto L_0x0077;
                case 109: goto L_0x005e;
                case 110: goto L_0x0077;
                case 111: goto L_0x0059;
                default: goto L_0x0036;
            }     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x0036:
            switch(r3) {
                case 119: goto L_0x0077;
                case 120: goto L_0x0054;
                case 121: goto L_0x004f;
                default: goto L_0x0039;
            }     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x0039:
            com.unboundid.ldap.sdk.LDAPException r5 = new com.unboundid.ldap.sdk.LDAPException     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            com.unboundid.ldap.protocol.ProtocolMessages r7 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_INVALID_PROTOCOL_OP_TYPE     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.String r3 = com.unboundid.util.StaticUtils.toHex((byte) r3)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            r2[r1] = r3     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.String r7 = r7.get(r2)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            r5.<init>((com.unboundid.ldap.sdk.ResultCode) r6, (java.lang.String) r7)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            throw r5     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x004f:
            com.unboundid.ldap.sdk.IntermediateResponse r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readIntermediateResponseFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0054:
            com.unboundid.ldap.sdk.ExtendedResult r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readExtendedResultFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0059:
            com.unboundid.ldap.sdk.CompareResult r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readCompareResultFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x005e:
            com.unboundid.ldap.sdk.LDAPResult r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readLDAPResultFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0063:
            com.unboundid.ldap.sdk.SearchResult r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readSearchResultFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0068:
            com.unboundid.ldap.sdk.SearchResultEntry r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readSearchResultEntryFrom(r6, r2, r5, r7)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x006d:
            com.unboundid.ldap.sdk.BindResult r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readBindResultFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0072:
            com.unboundid.ldap.sdk.SearchResultReference r5 = com.unboundid.ldap.sdk.InternalSDKHelper.readSearchResultReferenceFrom(r6, r2, r5)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            return r5
        L_0x0077:
            com.unboundid.ldap.sdk.LDAPException r5 = new com.unboundid.ldap.sdk.LDAPException     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            com.unboundid.ldap.protocol.ProtocolMessages r7 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_PROTOCOL_OP_TYPE_NOT_RESPONSE     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.String r3 = com.unboundid.util.StaticUtils.toHex((byte) r3)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            r2[r1] = r3     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            java.lang.String r7 = r7.get(r2)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            r5.<init>((com.unboundid.ldap.sdk.ResultCode) r6, (java.lang.String) r7)     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
            throw r5     // Catch:{ LDAPException -> 0x00db, SocketTimeoutException -> 0x00c1, IOException -> 0x00a7, Exception -> 0x008d }
        L_0x008d:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.protocol.ProtocolMessages r2 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)
            r0[r1] = r3
            java.lang.String r0 = r2.get(r0)
            r6.<init>(r7, r0, r5)
            throw r6
        L_0x00a7:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN
            com.unboundid.ldap.protocol.ProtocolMessages r2 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_IO_ERROR
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)
            r0[r1] = r3
            java.lang.String r0 = r2.get(r0)
            r6.<init>(r7, r0, r5)
            throw r6
        L_0x00c1:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.protocol.ProtocolMessages r2 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)
            r0[r1] = r5
            java.lang.String r5 = r2.get(r0)
            r6.<init>((com.unboundid.ldap.sdk.ResultCode) r7, (java.lang.String) r5)
            throw r6
        L_0x00db:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)
            throw r5
        L_0x00e0:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.protocol.ProtocolMessages r2 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_CANNOT_DECODE
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)
            r0[r1] = r3
            java.lang.String r0 = r2.get(r0)
            r6.<init>(r7, r0, r5)
            throw r6
        L_0x00fa:
            r5 = move-exception
            boolean r6 = r5 instanceof java.net.SocketTimeoutException
            if (r6 != 0) goto L_0x0102
            com.unboundid.util.Debug.debugException(r5)
        L_0x0102:
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN
            com.unboundid.ldap.protocol.ProtocolMessages r2 = com.unboundid.ldap.protocol.ProtocolMessages.ERR_MESSAGE_IO_ERROR
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)
            r0[r1] = r3
            java.lang.String r0 = r2.get(r0)
            r6.<init>(r7, r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.protocol.LDAPMessage.readLDAPResponseFrom(com.unboundid.asn1.ASN1StreamReader, boolean, com.unboundid.ldap.sdk.schema.Schema):com.unboundid.ldap.protocol.LDAPResponse");
    }

    public AbandonRequestProtocolOp getAbandonRequestProtocolOp() {
        return (AbandonRequestProtocolOp) this.protocolOp;
    }

    public AddRequestProtocolOp getAddRequestProtocolOp() {
        return (AddRequestProtocolOp) this.protocolOp;
    }

    public AddResponseProtocolOp getAddResponseProtocolOp() {
        return (AddResponseProtocolOp) this.protocolOp;
    }

    public BindRequestProtocolOp getBindRequestProtocolOp() {
        return (BindRequestProtocolOp) this.protocolOp;
    }

    public BindResponseProtocolOp getBindResponseProtocolOp() {
        return (BindResponseProtocolOp) this.protocolOp;
    }

    public CompareRequestProtocolOp getCompareRequestProtocolOp() {
        return (CompareRequestProtocolOp) this.protocolOp;
    }

    public CompareResponseProtocolOp getCompareResponseProtocolOp() {
        return (CompareResponseProtocolOp) this.protocolOp;
    }

    public List<Control> getControls() {
        return this.controls;
    }

    public DeleteRequestProtocolOp getDeleteRequestProtocolOp() {
        return (DeleteRequestProtocolOp) this.protocolOp;
    }

    public DeleteResponseProtocolOp getDeleteResponseProtocolOp() {
        return (DeleteResponseProtocolOp) this.protocolOp;
    }

    public ExtendedRequestProtocolOp getExtendedRequestProtocolOp() {
        return (ExtendedRequestProtocolOp) this.protocolOp;
    }

    public ExtendedResponseProtocolOp getExtendedResponseProtocolOp() {
        return (ExtendedResponseProtocolOp) this.protocolOp;
    }

    public IntermediateResponseProtocolOp getIntermediateResponseProtocolOp() {
        return (IntermediateResponseProtocolOp) this.protocolOp;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public ModifyDNRequestProtocolOp getModifyDNRequestProtocolOp() {
        return (ModifyDNRequestProtocolOp) this.protocolOp;
    }

    public ModifyDNResponseProtocolOp getModifyDNResponseProtocolOp() {
        return (ModifyDNResponseProtocolOp) this.protocolOp;
    }

    public ModifyRequestProtocolOp getModifyRequestProtocolOp() {
        return (ModifyRequestProtocolOp) this.protocolOp;
    }

    public ModifyResponseProtocolOp getModifyResponseProtocolOp() {
        return (ModifyResponseProtocolOp) this.protocolOp;
    }

    public ProtocolOp getProtocolOp() {
        return this.protocolOp;
    }

    public byte getProtocolOpType() {
        return this.protocolOp.getProtocolOpType();
    }

    public SearchRequestProtocolOp getSearchRequestProtocolOp() {
        return (SearchRequestProtocolOp) this.protocolOp;
    }

    public SearchResultDoneProtocolOp getSearchResultDoneProtocolOp() {
        return (SearchResultDoneProtocolOp) this.protocolOp;
    }

    public SearchResultEntryProtocolOp getSearchResultEntryProtocolOp() {
        return (SearchResultEntryProtocolOp) this.protocolOp;
    }

    public SearchResultReferenceProtocolOp getSearchResultReferenceProtocolOp() {
        return (SearchResultReferenceProtocolOp) this.protocolOp;
    }

    public UnbindRequestProtocolOp getUnbindRequestProtocolOp() {
        return (UnbindRequestProtocolOp) this.protocolOp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPMessage(msgID=");
        sb.append(this.messageID);
        sb.append(", protocolOp=");
        this.protocolOp.toString(sb);
        if (!this.controls.isEmpty()) {
            sb.append(", controls={");
            Iterator<Control> it = this.controls.iterator();
            while (it.hasNext()) {
                it.next().toString(sb);
                if (it.hasNext()) {
                    sb.append(',');
                }
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence();
        aSN1Buffer.addInteger(this.messageID);
        this.protocolOp.writeTo(aSN1Buffer);
        if (!this.controls.isEmpty()) {
            ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence((byte) -96);
            for (Control writeTo : this.controls) {
                writeTo.writeTo(aSN1Buffer);
            }
            beginSequence2.end();
        }
        beginSequence.end();
    }
}
