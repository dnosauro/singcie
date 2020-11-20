package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Boolean;
import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Enumerated;
import com.unboundid.asn1.ASN1Integer;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;

public final class SearchRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlySearchRequest, ResponseAcceptor {
    public static final String ALL_OPERATIONAL_ATTRIBUTES = "+";
    public static final String ALL_USER_ATTRIBUTES = "*";
    public static final String NO_ATTRIBUTES = "1.1";
    public static final String[] REQUEST_ATTRS_DEFAULT = StaticUtils.NO_STRINGS;
    private static final long serialVersionUID = 1500219434086474893L;
    private String[] attributes;
    private String baseDN;
    private DereferencePolicy derefPolicy;
    private Filter filter;
    private int messageID;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue;
    private SearchScope scope;
    private final SearchResultListener searchResultListener;
    private int sizeLimit;
    private int timeLimit;
    private boolean typesOnly;

    public SearchRequest(SearchResultListener searchResultListener2, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter2, String... strArr) {
        this(searchResultListener2, (Control[]) null, str, searchScope, dereferencePolicy, i, i2, z, filter2, strArr);
    }

    public SearchRequest(SearchResultListener searchResultListener2, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        this(searchResultListener2, (Control[]) null, str, searchScope, dereferencePolicy, i, i2, z, Filter.create(str2), strArr);
    }

    public SearchRequest(SearchResultListener searchResultListener2, String str, SearchScope searchScope, Filter filter2, String... strArr) {
        this(searchResultListener2, (Control[]) null, str, searchScope, DereferencePolicy.NEVER, 0, 0, false, filter2, strArr);
    }

    public SearchRequest(SearchResultListener searchResultListener2, String str, SearchScope searchScope, String str2, String... strArr) {
        this(searchResultListener2, (Control[]) null, str, searchScope, DereferencePolicy.NEVER, 0, 0, false, Filter.create(str2), strArr);
    }

    public SearchRequest(SearchResultListener searchResultListener2, Control[] controlArr, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter2, String... strArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>(50);
        Validator.ensureNotNull(str, filter2);
        this.baseDN = str;
        this.scope = searchScope;
        this.derefPolicy = dereferencePolicy;
        this.typesOnly = z;
        this.filter = filter2;
        this.searchResultListener = searchResultListener2;
        if (i < 0) {
            this.sizeLimit = 0;
        } else {
            this.sizeLimit = i;
        }
        if (i2 < 0) {
            this.timeLimit = 0;
        } else {
            this.timeLimit = i2;
        }
        if (strArr == null) {
            this.attributes = REQUEST_ATTRS_DEFAULT;
        } else {
            this.attributes = strArr;
        }
    }

    public SearchRequest(SearchResultListener searchResultListener2, Control[] controlArr, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        this(searchResultListener2, controlArr, str, searchScope, dereferencePolicy, i, i2, z, Filter.create(str2), strArr);
    }

    public SearchRequest(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter2, String... strArr) {
        this((SearchResultListener) null, (Control[]) null, str, searchScope, dereferencePolicy, i, i2, z, filter2, strArr);
    }

    public SearchRequest(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        this((SearchResultListener) null, (Control[]) null, str, searchScope, dereferencePolicy, i, i2, z, Filter.create(str2), strArr);
    }

    public SearchRequest(String str, SearchScope searchScope, Filter filter2, String... strArr) {
        this((SearchResultListener) null, (Control[]) null, str, searchScope, DereferencePolicy.NEVER, 0, 0, false, filter2, strArr);
    }

    public SearchRequest(String str, SearchScope searchScope, String str2, String... strArr) {
        this((SearchResultListener) null, (Control[]) null, str, searchScope, DereferencePolicy.NEVER, 0, 0, false, Filter.create(str2), strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.unboundid.ldap.sdk.SearchResult followReferral(com.unboundid.ldap.sdk.SearchResult r18, com.unboundid.ldap.sdk.LDAPConnection r19, int r20) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String[] r2 = r18.getReferralURLs()
            int r3 = r2.length
            r0 = 0
            r4 = 0
        L_0x0009:
            if (r4 >= r3) goto L_0x00a0
            r0 = r2[r4]
            com.unboundid.ldap.sdk.LDAPURL r5 = new com.unboundid.ldap.sdk.LDAPURL     // Catch:{ LDAPException -> 0x0089 }
            r5.<init>(r0)     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String r0 = r5.getHost()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 != 0) goto L_0x001c
            r7 = r19
            goto L_0x009b
        L_0x001c:
            boolean r0 = r5.baseDNProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x002b
            com.unboundid.ldap.sdk.DN r0 = r5.getBaseDN()     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String r0 = r0.toString()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = r1.baseDN     // Catch:{ LDAPException -> 0x0089 }
        L_0x002d:
            r9 = r0
            boolean r0 = r5.scopeProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x0039
            com.unboundid.ldap.sdk.SearchScope r0 = r5.getScope()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x003b
        L_0x0039:
            com.unboundid.ldap.sdk.SearchScope r0 = r1.scope     // Catch:{ LDAPException -> 0x0089 }
        L_0x003b:
            r10 = r0
            boolean r0 = r5.filterProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x0047
            com.unboundid.ldap.sdk.Filter r0 = r5.getFilter()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x0049
        L_0x0047:
            com.unboundid.ldap.sdk.Filter r0 = r1.filter     // Catch:{ LDAPException -> 0x0089 }
        L_0x0049:
            r15 = r0
            com.unboundid.ldap.sdk.SearchRequest r0 = new com.unboundid.ldap.sdk.SearchRequest     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.SearchResultListener r7 = r1.searchResultListener     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.Control[] r8 = r17.getControls()     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.DereferencePolicy r11 = r1.derefPolicy     // Catch:{ LDAPException -> 0x0089 }
            int r12 = r1.sizeLimit     // Catch:{ LDAPException -> 0x0089 }
            int r13 = r1.timeLimit     // Catch:{ LDAPException -> 0x0089 }
            boolean r14 = r1.typesOnly     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String[] r6 = r1.attributes     // Catch:{ LDAPException -> 0x0089 }
            r16 = r6
            r6 = r0
            r6.<init>((com.unboundid.ldap.sdk.SearchResultListener) r7, (com.unboundid.ldap.sdk.Control[]) r8, (java.lang.String) r9, (com.unboundid.ldap.sdk.SearchScope) r10, (com.unboundid.ldap.sdk.DereferencePolicy) r11, (int) r12, (int) r13, (boolean) r14, (com.unboundid.ldap.sdk.Filter) r15, (java.lang.String[]) r16)     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.ReferralConnector r6 = r19.getReferralConnector()     // Catch:{ LDAPException -> 0x0089 }
            r7 = r19
            com.unboundid.ldap.sdk.LDAPConnection r5 = r6.getReferralConnection(r5, r7)     // Catch:{ LDAPException -> 0x0087 }
            int r6 = r20 + 1
            r8 = 0
            com.unboundid.ldap.sdk.SearchResult r0 = r0.process((com.unboundid.ldap.sdk.LDAPConnection) r5, (int) r6)     // Catch:{ all -> 0x007c }
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.REFERRAL     // Catch:{ LDAPException -> 0x0087 }
            r5.setDisconnectInfo(r6, r8, r8)     // Catch:{ LDAPException -> 0x0087 }
            r5.close()     // Catch:{ LDAPException -> 0x0087 }
            return r0
        L_0x007c:
            r0 = move-exception
            r6 = r0
            com.unboundid.ldap.sdk.DisconnectType r0 = com.unboundid.ldap.sdk.DisconnectType.REFERRAL     // Catch:{ LDAPException -> 0x0087 }
            r5.setDisconnectInfo(r0, r8, r8)     // Catch:{ LDAPException -> 0x0087 }
            r5.close()     // Catch:{ LDAPException -> 0x0087 }
            throw r6     // Catch:{ LDAPException -> 0x0087 }
        L_0x0087:
            r0 = move-exception
            goto L_0x008c
        L_0x0089:
            r0 = move-exception
            r7 = r19
        L_0x008c:
            com.unboundid.util.Debug.debugException(r0)
            com.unboundid.ldap.sdk.ResultCode r5 = r0.getResultCode()
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.REFERRAL_LIMIT_EXCEEDED
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x009f
        L_0x009b:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x009f:
            throw r0
        L_0x00a0:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.SearchRequest.followReferral(com.unboundid.ldap.sdk.SearchResult, com.unboundid.ldap.sdk.LDAPConnection, int):com.unboundid.ldap.sdk.SearchResult");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.unboundid.ldap.sdk.LDAPResult followSearchReference(int r18, com.unboundid.ldap.sdk.SearchResultReference r19, com.unboundid.ldap.sdk.LDAPConnection r20, int r21) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String[] r2 = r19.getReferralURLs()
            int r3 = r2.length
            r0 = 0
            r4 = 0
        L_0x0009:
            if (r4 >= r3) goto L_0x00a0
            r0 = r2[r4]
            com.unboundid.ldap.sdk.LDAPURL r5 = new com.unboundid.ldap.sdk.LDAPURL     // Catch:{ LDAPException -> 0x0089 }
            r5.<init>(r0)     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String r0 = r5.getHost()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 != 0) goto L_0x001c
            r7 = r20
            goto L_0x009b
        L_0x001c:
            boolean r0 = r5.baseDNProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x002b
            com.unboundid.ldap.sdk.DN r0 = r5.getBaseDN()     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String r0 = r0.toString()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = r1.baseDN     // Catch:{ LDAPException -> 0x0089 }
        L_0x002d:
            r9 = r0
            boolean r0 = r5.scopeProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x0039
            com.unboundid.ldap.sdk.SearchScope r0 = r5.getScope()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x003b
        L_0x0039:
            com.unboundid.ldap.sdk.SearchScope r0 = r1.scope     // Catch:{ LDAPException -> 0x0089 }
        L_0x003b:
            r10 = r0
            boolean r0 = r5.filterProvided()     // Catch:{ LDAPException -> 0x0089 }
            if (r0 == 0) goto L_0x0047
            com.unboundid.ldap.sdk.Filter r0 = r5.getFilter()     // Catch:{ LDAPException -> 0x0089 }
            goto L_0x0049
        L_0x0047:
            com.unboundid.ldap.sdk.Filter r0 = r1.filter     // Catch:{ LDAPException -> 0x0089 }
        L_0x0049:
            r15 = r0
            com.unboundid.ldap.sdk.SearchRequest r0 = new com.unboundid.ldap.sdk.SearchRequest     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.SearchResultListener r7 = r1.searchResultListener     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.Control[] r8 = r17.getControls()     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.DereferencePolicy r11 = r1.derefPolicy     // Catch:{ LDAPException -> 0x0089 }
            int r12 = r1.sizeLimit     // Catch:{ LDAPException -> 0x0089 }
            int r13 = r1.timeLimit     // Catch:{ LDAPException -> 0x0089 }
            boolean r14 = r1.typesOnly     // Catch:{ LDAPException -> 0x0089 }
            java.lang.String[] r6 = r1.attributes     // Catch:{ LDAPException -> 0x0089 }
            r16 = r6
            r6 = r0
            r6.<init>((com.unboundid.ldap.sdk.SearchResultListener) r7, (com.unboundid.ldap.sdk.Control[]) r8, (java.lang.String) r9, (com.unboundid.ldap.sdk.SearchScope) r10, (com.unboundid.ldap.sdk.DereferencePolicy) r11, (int) r12, (int) r13, (boolean) r14, (com.unboundid.ldap.sdk.Filter) r15, (java.lang.String[]) r16)     // Catch:{ LDAPException -> 0x0089 }
            com.unboundid.ldap.sdk.ReferralConnector r6 = r20.getReferralConnector()     // Catch:{ LDAPException -> 0x0089 }
            r7 = r20
            com.unboundid.ldap.sdk.LDAPConnection r5 = r6.getReferralConnection(r5, r7)     // Catch:{ LDAPException -> 0x0087 }
            int r6 = r21 + 1
            r8 = 0
            com.unboundid.ldap.sdk.SearchResult r0 = r0.process((com.unboundid.ldap.sdk.LDAPConnection) r5, (int) r6)     // Catch:{ all -> 0x007c }
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.REFERRAL     // Catch:{ LDAPException -> 0x0087 }
            r5.setDisconnectInfo(r6, r8, r8)     // Catch:{ LDAPException -> 0x0087 }
            r5.close()     // Catch:{ LDAPException -> 0x0087 }
            return r0
        L_0x007c:
            r0 = move-exception
            r6 = r0
            com.unboundid.ldap.sdk.DisconnectType r0 = com.unboundid.ldap.sdk.DisconnectType.REFERRAL     // Catch:{ LDAPException -> 0x0087 }
            r5.setDisconnectInfo(r0, r8, r8)     // Catch:{ LDAPException -> 0x0087 }
            r5.close()     // Catch:{ LDAPException -> 0x0087 }
            throw r6     // Catch:{ LDAPException -> 0x0087 }
        L_0x0087:
            r0 = move-exception
            goto L_0x008c
        L_0x0089:
            r0 = move-exception
            r7 = r20
        L_0x008c:
            com.unboundid.util.Debug.debugException(r0)
            com.unboundid.ldap.sdk.ResultCode r5 = r0.getResultCode()
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.REFERRAL_LIMIT_EXCEEDED
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x009f
        L_0x009b:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x009f:
            throw r0
        L_0x00a0:
            com.unboundid.ldap.sdk.SearchResult r0 = new com.unboundid.ldap.sdk.SearchResult
            com.unboundid.ldap.sdk.ResultCode r7 = com.unboundid.ldap.sdk.ResultCode.REFERRAL
            r8 = 0
            r9 = 0
            java.lang.String[] r10 = r19.getReferralURLs()
            r11 = 0
            r12 = 0
            r13 = 0
            r5 = r0
            r6 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.SearchRequest.followSearchReference(int, com.unboundid.ldap.sdk.SearchResultReference, com.unboundid.ldap.sdk.LDAPConnection, int):com.unboundid.ldap.sdk.LDAPResult");
    }

    private SearchResult handleResponse(LDAPConnection lDAPConnection, LDAPResponse lDAPResponse, long j, int i, int i2, int i3, List<SearchResultEntry> list, List<SearchResultReference> list2, ResultCode resultCode) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        lDAPConnection.getConnectionStatistics().incrementNumSearchResponses(i5, i6, System.nanoTime() - j);
        SearchResult searchResult = (SearchResult) lDAPResponse;
        searchResult.setCounts(i5, list, i6, list2);
        if (searchResult.getResultCode().equals(ResultCode.REFERRAL) && followReferrals(lDAPConnection)) {
            if (i4 >= lDAPConnection.getConnectionOptions().getReferralHopLimit()) {
                return new SearchResult(this.messageID, ResultCode.REFERRAL_LIMIT_EXCEEDED, LDAPMessages.ERR_TOO_MANY_REFERRALS.get(), searchResult.getMatchedDN(), searchResult.getReferralURLs(), list, list2, i2, i3, searchResult.getResponseControls());
            }
            LDAPConnection lDAPConnection2 = lDAPConnection;
            searchResult = followReferral(searchResult, lDAPConnection, i4);
        }
        if (searchResult.getResultCode().equals(ResultCode.SUCCESS)) {
            if (!resultCode.equals(ResultCode.SUCCESS)) {
                return new SearchResult(this.messageID, resultCode, searchResult.getDiagnosticMessage(), searchResult.getMatchedDN(), searchResult.getReferralURLs(), list, list2, i2, i3, searchResult.getResponseControls());
            }
        }
        return searchResult;
    }

    private SearchResult processSync(LDAPConnection lDAPConnection, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        LDAPConnection lDAPConnection2 = lDAPConnection;
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
        try {
            lDAPConnection.getConnectionInternals().getSocket().setSoTimeout((int) responseTimeoutMillis);
        } catch (Exception e) {
            Debug.debugException(e);
        }
        long nanoTime = System.nanoTime();
        Debug.debugLDAPRequest(this);
        lDAPConnection.getConnectionStatistics().incrementNumSearchRequests();
        lDAPConnection2.sendMessage(lDAPMessage);
        if (this.searchResultListener == null) {
            arrayList2 = new ArrayList(5);
            arrayList = new ArrayList(5);
        } else {
            arrayList2 = null;
            arrayList = null;
        }
        ResultCode resultCode = ResultCode.SUCCESS;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                LDAPResponse readResponse = lDAPConnection2.readResponse(this.messageID);
                if (readResponse == null) {
                    if (lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                        lDAPConnection2.abandon(this.messageID, new Control[0]);
                    }
                    throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_SEARCH_CLIENT_TIMEOUT.get(Long.valueOf(responseTimeoutMillis), lDAPConnection.getHostPort()));
                } else if (readResponse instanceof ConnectionClosedResponse) {
                    ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) readResponse;
                    String message = connectionClosedResponse.getMessage();
                    if (message == null) {
                        throw new LDAPSearchException(new SearchResult(this.messageID, connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_SEARCH_RESPONSE.get(lDAPConnection.getHostPort(), toString()), (String) null, (String[]) null, arrayList2, arrayList, i2, i3, (Control[]) null));
                    }
                    throw new LDAPSearchException(new SearchResult(this.messageID, connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_SEARCH_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message), (String) null, (String[]) null, arrayList2, arrayList, i2, i3, (Control[]) null));
                } else {
                    if (readResponse instanceof IntermediateResponse) {
                        IntermediateResponseListener intermediateResponseListener = getIntermediateResponseListener();
                        if (intermediateResponseListener != null) {
                            intermediateResponseListener.intermediateResponseReturned((IntermediateResponse) readResponse);
                        }
                    } else if (readResponse instanceof SearchResultEntry) {
                        SearchResultEntry searchResultEntry = (SearchResultEntry) readResponse;
                        i2++;
                        SearchResultListener searchResultListener2 = this.searchResultListener;
                        if (searchResultListener2 == null) {
                            arrayList2.add(searchResultEntry);
                        } else {
                            searchResultListener2.searchEntryReturned(searchResultEntry);
                        }
                    } else if (readResponse instanceof SearchResultReference) {
                        SearchResultReference searchResultReference = (SearchResultReference) readResponse;
                        if (followReferrals(lDAPConnection)) {
                            LDAPResult followSearchReference = followSearchReference(this.messageID, searchResultReference, lDAPConnection2, i);
                            if (!followSearchReference.getResultCode().equals(ResultCode.SUCCESS)) {
                                i3++;
                                SearchResultListener searchResultListener3 = this.searchResultListener;
                                if (searchResultListener3 == null) {
                                    arrayList.add(searchResultReference);
                                } else {
                                    searchResultListener3.searchReferenceReturned(searchResultReference);
                                }
                                if (resultCode.equals(ResultCode.SUCCESS)) {
                                    resultCode = followSearchReference.getResultCode();
                                }
                            } else if (followSearchReference instanceof SearchResult) {
                                SearchResult searchResult = (SearchResult) followSearchReference;
                                i2 += searchResult.getEntryCount();
                                if (this.searchResultListener == null) {
                                    arrayList2.addAll(searchResult.getSearchEntries());
                                }
                            }
                        } else {
                            int i4 = i;
                            i3++;
                            SearchResultListener searchResultListener4 = this.searchResultListener;
                            if (searchResultListener4 == null) {
                                arrayList.add(searchResultReference);
                            } else {
                                searchResultListener4.searchReferenceReturned(searchResultReference);
                            }
                        }
                    } else {
                        int i5 = i;
                        return handleResponse(lDAPConnection, readResponse, nanoTime, i, i2, i3, arrayList2, arrayList, resultCode);
                    }
                    int i6 = i;
                }
            } catch (LDAPException e2) {
                Debug.debugException(e2);
                if (e2.getResultCode() == ResultCode.TIMEOUT && lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                    lDAPConnection2.abandon(this.messageID, new Control[0]);
                }
                throw e2;
            }
        }
    }

    public SearchRequest duplicate() {
        return duplicate(getControls());
    }

    public SearchRequest duplicate(Control[] controlArr) {
        SearchRequest searchRequest = new SearchRequest(this.searchResultListener, controlArr, this.baseDN, this.scope, this.derefPolicy, this.sizeLimit, this.timeLimit, this.typesOnly, this.filter, this.attributes);
        if (followReferralsInternal() != null) {
            searchRequest.setFollowReferrals(followReferralsInternal());
        }
        searchRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return searchRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        ASN1Element[] aSN1ElementArr = new ASN1Element[this.attributes.length];
        for (int i = 0; i < aSN1ElementArr.length; i++) {
            aSN1ElementArr[i] = new ASN1OctetString(this.attributes[i]);
        }
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, new ASN1OctetString(this.baseDN), new ASN1Enumerated(this.scope.intValue()), new ASN1Enumerated(this.derefPolicy.intValue()), new ASN1Integer(this.sizeLimit), new ASN1Integer(this.timeLimit), new ASN1Boolean(this.typesOnly), this.filter.encode(), new ASN1Sequence(aSN1ElementArr));
    }

    public List<String> getAttributeList() {
        return Collections.unmodifiableList(Arrays.asList(this.attributes));
    }

    public String[] getAttributes() {
        return this.attributes;
    }

    public String getBaseDN() {
        return this.baseDN;
    }

    public DereferencePolicy getDereferencePolicy() {
        return this.derefPolicy;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public OperationType getOperationType() {
        return OperationType.SEARCH;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST;
    }

    public SearchScope getScope() {
        return this.scope;
    }

    public SearchResultListener getSearchResultListener() {
        return this.searchResultListener;
    }

    public int getSizeLimit() {
        return this.sizeLimit;
    }

    public int getTimeLimitSeconds() {
        return this.timeLimit;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r20.getConnectionOptions().abandonOnTimeout() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        r2.abandon(r1.messageID, new com.unboundid.ldap.sdk.Control[r8]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        r3 = r1.messageID;
        r10 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT;
        r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_SEARCH_CLIENT_TIMEOUT;
        r11 = new java.lang.Object[2];
        r11[r8] = java.lang.Long.valueOf(r6);
        r11[1] = r20.getHostPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        throw new com.unboundid.ldap.sdk.LDAPSearchException(new com.unboundid.ldap.sdk.SearchResult(r3, r10, r4.get(r11), (java.lang.String) null, (java.lang.String[]) null, r14, r15, r5, r13, (com.unboundid.ldap.sdk.Control[]) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017d, code lost:
        r20.getConnectionStatistics().incrementNumSearchResponses(r5, r13, java.lang.System.nanoTime() - r3);
        r11 = (com.unboundid.ldap.sdk.SearchResult) r11;
        r11.setCounts(r5, r14, r13, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0198, code lost:
        if (r11.getResultCode().equals(com.unboundid.ldap.sdk.ResultCode.REFERRAL) == false) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019e, code lost:
        if (followReferrals(r20) == false) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a8, code lost:
        if (r0 < r20.getConnectionOptions().getReferralHopLimit()) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01aa, code lost:
        r8 = new com.unboundid.ldap.sdk.SearchResult(r1.messageID, com.unboundid.ldap.sdk.ResultCode.REFERRAL_LIMIT_EXCEEDED, com.unboundid.ldap.sdk.LDAPMessages.ERR_TOO_MANY_REFERRALS.get(), r11.getMatchedDN(), r11.getReferralURLs(), r14, r15, r5, r13, r11.getResponseControls());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01cd, code lost:
        r2.deregisterResponseAcceptor(r1.messageID);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d2, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d3, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r11 = followReferral(r11, r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d9, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e4, code lost:
        if (r11.getResultCode().equals(com.unboundid.ldap.sdk.ResultCode.SUCCESS) == false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ec, code lost:
        if (r10.equals(com.unboundid.ldap.sdk.ResultCode.SUCCESS) != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ee, code lost:
        r8 = new com.unboundid.ldap.sdk.SearchResult(r1.messageID, r10, r11.getDiagnosticMessage(), r11.getMatchedDN(), r11.getReferralURLs(), r14, r15, r5, r3, r11.getResponseControls());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x020c, code lost:
        r2.deregisterResponseAcceptor(r1.messageID);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0211, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.unboundid.ldap.sdk.SearchResult process(com.unboundid.ldap.sdk.LDAPConnection r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r0 = r21
            boolean r3 = r20.synchronousMode()
            if (r3 == 0) goto L_0x0011
            com.unboundid.ldap.sdk.SearchResult r0 = r19.processSync(r20, r21)
            return r0
        L_0x0011:
            long r3 = java.lang.System.nanoTime()
            r5 = 0
            r1.processAsync(r2, r5)
            com.unboundid.ldap.sdk.SearchResultListener r6 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            if (r6 != 0) goto L_0x002b
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x022e }
            r6 = 5
            r5.<init>(r6)     // Catch:{ all -> 0x022e }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x022e }
            r7.<init>(r6)     // Catch:{ all -> 0x022e }
            r14 = r5
            r15 = r7
            goto L_0x002d
        L_0x002b:
            r14 = r5
            r15 = r14
        L_0x002d:
            com.unboundid.ldap.sdk.ResultCode r5 = com.unboundid.ldap.sdk.ResultCode.SUCCESS     // Catch:{ all -> 0x022e }
            long r6 = r19.getResponseTimeoutMillis(r20)     // Catch:{ all -> 0x022e }
            r8 = 0
            r10 = r5
            r5 = 0
            r13 = 0
        L_0x0037:
            r11 = 0
            r9 = 1
            int r16 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r16 <= 0) goto L_0x0049
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.protocol.LDAPResponse> r11 = r1.responseQueue     // Catch:{ InterruptedException -> 0x0212 }
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0212 }
            java.lang.Object r11 = r11.poll(r6, r12)     // Catch:{ InterruptedException -> 0x0212 }
        L_0x0046:
            com.unboundid.ldap.protocol.LDAPResponse r11 = (com.unboundid.ldap.protocol.LDAPResponse) r11     // Catch:{ InterruptedException -> 0x0212 }
            goto L_0x0050
        L_0x0049:
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.protocol.LDAPResponse> r11 = r1.responseQueue     // Catch:{ InterruptedException -> 0x0212 }
            java.lang.Object r11 = r11.take()     // Catch:{ InterruptedException -> 0x0212 }
            goto L_0x0046
        L_0x0050:
            r12 = 2
            if (r11 != 0) goto L_0x0093
            com.unboundid.ldap.sdk.LDAPConnectionOptions r0 = r20.getConnectionOptions()     // Catch:{ all -> 0x022e }
            boolean r0 = r0.abandonOnTimeout()     // Catch:{ all -> 0x022e }
            if (r0 == 0) goto L_0x0064
            int r0 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.Control[] r3 = new com.unboundid.ldap.sdk.Control[r8]     // Catch:{ all -> 0x022e }
            r2.abandon((int) r0, (com.unboundid.ldap.sdk.Control[]) r3)     // Catch:{ all -> 0x022e }
        L_0x0064:
            com.unboundid.ldap.sdk.SearchResult r0 = new com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            int r3 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r10 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_SEARCH_CLIENT_TIMEOUT     // Catch:{ all -> 0x022e }
            java.lang.Object[] r11 = new java.lang.Object[r12]     // Catch:{ all -> 0x022e }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x022e }
            r11[r8] = r6     // Catch:{ all -> 0x022e }
            java.lang.String r6 = r20.getHostPort()     // Catch:{ all -> 0x022e }
            r11[r9] = r6     // Catch:{ all -> 0x022e }
            java.lang.String r11 = r4.get(r11)     // Catch:{ all -> 0x022e }
            r12 = 0
            r4 = 0
            r18 = 0
            r8 = r0
            r9 = r3
            r3 = r13
            r13 = r4
            r16 = r5
            r17 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPSearchException r3 = new com.unboundid.ldap.sdk.LDAPSearchException     // Catch:{ all -> 0x022e }
            r3.<init>((com.unboundid.ldap.sdk.SearchResult) r0)     // Catch:{ all -> 0x022e }
            throw r3     // Catch:{ all -> 0x022e }
        L_0x0093:
            boolean r9 = r11 instanceof com.unboundid.ldap.sdk.ConnectionClosedResponse     // Catch:{ all -> 0x022e }
            if (r9 == 0) goto L_0x0103
            com.unboundid.ldap.sdk.ConnectionClosedResponse r11 = (com.unboundid.ldap.sdk.ConnectionClosedResponse) r11     // Catch:{ all -> 0x022e }
            java.lang.String r0 = r11.getMessage()     // Catch:{ all -> 0x022e }
            if (r0 != 0) goto L_0x00d0
            com.unboundid.ldap.sdk.SearchResult r0 = new com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            int r9 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r10 = r11.getResultCode()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_SEARCH_RESPONSE     // Catch:{ all -> 0x022e }
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ all -> 0x022e }
            java.lang.String r6 = r20.getHostPort()     // Catch:{ all -> 0x022e }
            r4[r8] = r6     // Catch:{ all -> 0x022e }
            java.lang.String r6 = r19.toString()     // Catch:{ all -> 0x022e }
            r7 = 1
            r4[r7] = r6     // Catch:{ all -> 0x022e }
            java.lang.String r11 = r3.get(r4)     // Catch:{ all -> 0x022e }
            r12 = 0
            r3 = 0
            r18 = 0
            r8 = r0
            r4 = r13
            r13 = r3
            r16 = r5
            r17 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPSearchException r3 = new com.unboundid.ldap.sdk.LDAPSearchException     // Catch:{ all -> 0x022e }
            r3.<init>((com.unboundid.ldap.sdk.SearchResult) r0)     // Catch:{ all -> 0x022e }
            throw r3     // Catch:{ all -> 0x022e }
        L_0x00d0:
            r4 = r13
            com.unboundid.ldap.sdk.SearchResult r3 = new com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            int r9 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r10 = r11.getResultCode()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPMessages r6 = com.unboundid.ldap.sdk.LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_SEARCH_RESPONSE_WITH_MESSAGE     // Catch:{ all -> 0x022e }
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x022e }
            java.lang.String r11 = r20.getHostPort()     // Catch:{ all -> 0x022e }
            r7[r8] = r11     // Catch:{ all -> 0x022e }
            java.lang.String r8 = r19.toString()     // Catch:{ all -> 0x022e }
            r11 = 1
            r7[r11] = r8     // Catch:{ all -> 0x022e }
            r7[r12] = r0     // Catch:{ all -> 0x022e }
            java.lang.String r11 = r6.get(r7)     // Catch:{ all -> 0x022e }
            r12 = 0
            r13 = 0
            r18 = 0
            r8 = r3
            r16 = r5
            r17 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPSearchException r0 = new com.unboundid.ldap.sdk.LDAPSearchException     // Catch:{ all -> 0x022e }
            r0.<init>((com.unboundid.ldap.sdk.SearchResult) r3)     // Catch:{ all -> 0x022e }
            throw r0     // Catch:{ all -> 0x022e }
        L_0x0103:
            boolean r9 = r11 instanceof com.unboundid.ldap.sdk.SearchResultEntry     // Catch:{ all -> 0x022e }
            if (r9 == 0) goto L_0x0119
            com.unboundid.ldap.sdk.SearchResultEntry r11 = (com.unboundid.ldap.sdk.SearchResultEntry) r11     // Catch:{ all -> 0x022e }
            int r5 = r5 + 1
            com.unboundid.ldap.sdk.SearchResultListener r9 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            if (r9 != 0) goto L_0x0113
            r14.add(r11)     // Catch:{ all -> 0x022e }
            goto L_0x017a
        L_0x0113:
            com.unboundid.ldap.sdk.SearchResultListener r9 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            r9.searchEntryReturned(r11)     // Catch:{ all -> 0x022e }
            goto L_0x017a
        L_0x0119:
            boolean r9 = r11 instanceof com.unboundid.ldap.sdk.SearchResultReference     // Catch:{ all -> 0x022e }
            if (r9 == 0) goto L_0x017d
            com.unboundid.ldap.sdk.SearchResultReference r11 = (com.unboundid.ldap.sdk.SearchResultReference) r11     // Catch:{ all -> 0x022e }
            boolean r9 = r19.followReferrals(r20)     // Catch:{ all -> 0x022e }
            if (r9 == 0) goto L_0x016b
            int r9 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPResult r9 = r1.followSearchReference(r9, r11, r2, r0)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r12 = r9.getResultCode()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.SUCCESS     // Catch:{ all -> 0x022e }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x022e }
            if (r8 != 0) goto L_0x0154
            int r13 = r13 + 1
            com.unboundid.ldap.sdk.SearchResultListener r8 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            if (r8 != 0) goto L_0x0141
            r15.add(r11)     // Catch:{ all -> 0x022e }
            goto L_0x0146
        L_0x0141:
            com.unboundid.ldap.sdk.SearchResultListener r8 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            r8.searchReferenceReturned(r11)     // Catch:{ all -> 0x022e }
        L_0x0146:
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.SUCCESS     // Catch:{ all -> 0x022e }
            boolean r8 = r10.equals(r8)     // Catch:{ all -> 0x022e }
            if (r8 == 0) goto L_0x017a
            com.unboundid.ldap.sdk.ResultCode r8 = r9.getResultCode()     // Catch:{ all -> 0x022e }
            r10 = r8
            goto L_0x017a
        L_0x0154:
            boolean r8 = r9 instanceof com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            if (r8 == 0) goto L_0x017a
            com.unboundid.ldap.sdk.SearchResult r9 = (com.unboundid.ldap.sdk.SearchResult) r9     // Catch:{ all -> 0x022e }
            int r8 = r9.getEntryCount()     // Catch:{ all -> 0x022e }
            int r5 = r5 + r8
            com.unboundid.ldap.sdk.SearchResultListener r8 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            if (r8 != 0) goto L_0x017a
            java.util.List r8 = r9.getSearchEntries()     // Catch:{ all -> 0x022e }
            r14.addAll(r8)     // Catch:{ all -> 0x022e }
            goto L_0x017a
        L_0x016b:
            int r13 = r13 + 1
            com.unboundid.ldap.sdk.SearchResultListener r8 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            if (r8 != 0) goto L_0x0175
            r15.add(r11)     // Catch:{ all -> 0x022e }
            goto L_0x017a
        L_0x0175:
            com.unboundid.ldap.sdk.SearchResultListener r8 = r1.searchResultListener     // Catch:{ all -> 0x022e }
            r8.searchReferenceReturned(r11)     // Catch:{ all -> 0x022e }
        L_0x017a:
            r8 = 0
            goto L_0x0037
        L_0x017d:
            com.unboundid.ldap.sdk.LDAPConnectionStatistics r6 = r20.getConnectionStatistics()     // Catch:{ all -> 0x022e }
            long r7 = java.lang.System.nanoTime()     // Catch:{ all -> 0x022e }
            long r7 = r7 - r3
            r6.incrementNumSearchResponses(r5, r13, r7)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.SearchResult r11 = (com.unboundid.ldap.sdk.SearchResult) r11     // Catch:{ all -> 0x022e }
            r11.setCounts(r5, r14, r13, r15)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r3 = r11.getResultCode()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r4 = com.unboundid.ldap.sdk.ResultCode.REFERRAL     // Catch:{ all -> 0x022e }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x01d9
            boolean r3 = r19.followReferrals(r20)     // Catch:{ all -> 0x022e }
            if (r3 == 0) goto L_0x01d9
            com.unboundid.ldap.sdk.LDAPConnectionOptions r3 = r20.getConnectionOptions()     // Catch:{ all -> 0x022e }
            int r3 = r3.getReferralHopLimit()     // Catch:{ all -> 0x022e }
            if (r0 < r3) goto L_0x01d3
            com.unboundid.ldap.sdk.SearchResult r0 = new com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            int r9 = r1.messageID     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r10 = com.unboundid.ldap.sdk.ResultCode.REFERRAL_LIMIT_EXCEEDED     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_TOO_MANY_REFERRALS     // Catch:{ all -> 0x022e }
            java.lang.String r3 = r3.get()     // Catch:{ all -> 0x022e }
            java.lang.String r12 = r11.getMatchedDN()     // Catch:{ all -> 0x022e }
            java.lang.String[] r4 = r11.getReferralURLs()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.Control[] r18 = r11.getResponseControls()     // Catch:{ all -> 0x022e }
            r8 = r0
            r11 = r3
            r3 = r13
            r13 = r4
            r16 = r5
            r17 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x022e }
        L_0x01cd:
            int r3 = r1.messageID
            r2.deregisterResponseAcceptor(r3)
            return r0
        L_0x01d3:
            r3 = r13
            com.unboundid.ldap.sdk.SearchResult r11 = r1.followReferral(r11, r2, r0)     // Catch:{ all -> 0x022e }
            goto L_0x01da
        L_0x01d9:
            r3 = r13
        L_0x01da:
            com.unboundid.ldap.sdk.ResultCode r0 = r11.getResultCode()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r4 = com.unboundid.ldap.sdk.ResultCode.SUCCESS     // Catch:{ all -> 0x022e }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x022e }
            if (r0 == 0) goto L_0x020c
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.SUCCESS     // Catch:{ all -> 0x022e }
            boolean r0 = r10.equals(r0)     // Catch:{ all -> 0x022e }
            if (r0 != 0) goto L_0x020c
            com.unboundid.ldap.sdk.SearchResult r0 = new com.unboundid.ldap.sdk.SearchResult     // Catch:{ all -> 0x022e }
            int r9 = r1.messageID     // Catch:{ all -> 0x022e }
            java.lang.String r4 = r11.getDiagnosticMessage()     // Catch:{ all -> 0x022e }
            java.lang.String r12 = r11.getMatchedDN()     // Catch:{ all -> 0x022e }
            java.lang.String[] r13 = r11.getReferralURLs()     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.Control[] r18 = r11.getResponseControls()     // Catch:{ all -> 0x022e }
            r8 = r0
            r11 = r4
            r16 = r5
            r17 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x022e }
            goto L_0x01cd
        L_0x020c:
            int r0 = r1.messageID
            r2.deregisterResponseAcceptor(r0)
            return r11
        L_0x0212:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPException r3 = new com.unboundid.ldap.sdk.LDAPException     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.ResultCode r4 = com.unboundid.ldap.sdk.ResultCode.LOCAL_ERROR     // Catch:{ all -> 0x022e }
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_SEARCH_INTERRUPTED     // Catch:{ all -> 0x022e }
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x022e }
            java.lang.String r7 = r20.getHostPort()     // Catch:{ all -> 0x022e }
            r8 = 0
            r6[r8] = r7     // Catch:{ all -> 0x022e }
            java.lang.String r5 = r5.get(r6)     // Catch:{ all -> 0x022e }
            r3.<init>(r4, r5, r0)     // Catch:{ all -> 0x022e }
            throw r3     // Catch:{ all -> 0x022e }
        L_0x022e:
            r0 = move-exception
            int r3 = r1.messageID
            r2.deregisterResponseAcceptor(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.SearchRequest.process(com.unboundid.ldap.sdk.LDAPConnection, int):com.unboundid.ldap.sdk.SearchResult");
    }

    /* access modifiers changed from: package-private */
    public AsyncRequestID processAsync(LDAPConnection lDAPConnection, AsyncSearchResultListener asyncSearchResultListener) {
        AsyncRequestID asyncRequestID;
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        if (asyncSearchResultListener == null) {
            asyncRequestID = null;
            lDAPConnection.registerResponseAcceptor(this.messageID, this);
        } else {
            AsyncSearchHelper asyncSearchHelper = new AsyncSearchHelper(lDAPConnection, this.messageID, asyncSearchResultListener, getIntermediateResponseListener());
            lDAPConnection.registerResponseAcceptor(this.messageID, asyncSearchHelper);
            asyncRequestID = asyncSearchHelper.getAsyncRequestID();
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            if (responseTimeoutMillis > 0) {
                Timer timer = lDAPConnection.getTimer();
                AsyncTimeoutTimerTask asyncTimeoutTimerTask = new AsyncTimeoutTimerTask(asyncSearchHelper);
                timer.schedule(asyncTimeoutTimerTask, responseTimeoutMillis);
                asyncRequestID.setTimerTask(asyncTimeoutTimerTask);
            }
        }
        try {
            Debug.debugLDAPRequest(this);
            lDAPConnection.getConnectionStatistics().incrementNumSearchRequests();
            lDAPConnection.sendMessage(lDAPMessage);
            return asyncRequestID;
        } catch (LDAPException e) {
            Debug.debugException(e);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw e;
        }
    }

    @InternalUseOnly
    public void responseReceived(LDAPResponse lDAPResponse) {
        try {
            this.responseQueue.put(lDAPResponse);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_EXCEPTION_HANDLING_RESPONSE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public void setAttributes(List<String> list) {
        if (list == null) {
            this.attributes = REQUEST_ATTRS_DEFAULT;
            return;
        }
        this.attributes = new String[list.size()];
        int i = 0;
        while (true) {
            String[] strArr = this.attributes;
            if (i < strArr.length) {
                strArr[i] = list.get(i);
                i++;
            } else {
                return;
            }
        }
    }

    public void setAttributes(String... strArr) {
        if (strArr == null) {
            strArr = REQUEST_ATTRS_DEFAULT;
        }
        this.attributes = strArr;
    }

    public void setBaseDN(C3122DN dn) {
        Validator.ensureNotNull(dn);
        this.baseDN = dn.toString();
    }

    public void setBaseDN(String str) {
        Validator.ensureNotNull(str);
        this.baseDN = str;
    }

    public void setDerefPolicy(DereferencePolicy dereferencePolicy) {
        this.derefPolicy = dereferencePolicy;
    }

    public void setFilter(Filter filter2) {
        Validator.ensureNotNull(filter2);
        this.filter = filter2;
    }

    public void setFilter(String str) {
        Validator.ensureNotNull(str);
        this.filter = Filter.create(str);
    }

    public void setScope(SearchScope searchScope) {
        this.scope = searchScope;
    }

    public void setSizeLimit(int i) {
        if (i < 0) {
            i = 0;
        }
        this.sizeLimit = i;
    }

    public void setTimeLimitSeconds(int i) {
        if (i < 0) {
            i = 0;
        }
        this.timeLimit = i;
    }

    public void setTypesOnly(boolean z) {
        this.typesOnly = z;
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchRequest(baseDN='");
        sb.append(this.baseDN);
        sb.append("', scope=");
        sb.append(this.scope);
        sb.append(", deref=");
        sb.append(this.derefPolicy);
        sb.append(", sizeLimit=");
        sb.append(this.sizeLimit);
        sb.append(", timeLimit=");
        sb.append(this.timeLimit);
        sb.append(", filter='");
        sb.append(this.filter);
        sb.append("', attrs={");
        for (int i = 0; i < this.attributes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.attributes[i]);
        }
        sb.append('}');
        Control[] controls = getControls();
        if (controls.length > 0) {
            sb.append(", controls={");
            for (int i2 = 0; i2 < controls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(controls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public boolean typesOnly() {
        return this.typesOnly;
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST);
        aSN1Buffer.addOctetString(this.baseDN);
        aSN1Buffer.addEnumerated(this.scope.intValue());
        aSN1Buffer.addEnumerated(this.derefPolicy.intValue());
        aSN1Buffer.addInteger(this.sizeLimit);
        aSN1Buffer.addInteger(this.timeLimit);
        aSN1Buffer.addBoolean(this.typesOnly);
        this.filter.writeTo(aSN1Buffer);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        for (String addOctetString : this.attributes) {
            aSN1Buffer.addOctetString(addOctetString);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
