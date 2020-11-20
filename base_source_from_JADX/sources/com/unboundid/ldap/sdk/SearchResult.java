package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import java.util.Collections;
import java.util.List;

public final class SearchResult extends LDAPResult {
    private static final long serialVersionUID = 1938208530894131198L;
    private int numEntries;
    private int numReferences;
    private List<SearchResultEntry> searchEntries;
    private List<SearchResultReference> searchReferences;

    public SearchResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, int i2, int i3, Control[] controlArr) {
        super(i, resultCode, str, str2, strArr, controlArr);
        this.numEntries = i2;
        this.numReferences = i3;
        this.searchEntries = null;
        this.searchReferences = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, List<SearchResultEntry> list, List<SearchResultReference> list2, int i2, int i3, Control[] controlArr) {
        super(i, resultCode, str, str2, strArr, controlArr);
        this.numEntries = i2;
        this.numReferences = i3;
        this.searchEntries = list;
        this.searchReferences = list2;
    }

    static SearchResult readSearchResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        LDAPResult readLDAPResultFrom = LDAPResult.readLDAPResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader);
        return new SearchResult(i, readLDAPResultFrom.getResultCode(), readLDAPResultFrom.getDiagnosticMessage(), readLDAPResultFrom.getMatchedDN(), readLDAPResultFrom.getReferralURLs(), -1, -1, readLDAPResultFrom.getResponseControls());
    }

    public int getEntryCount() {
        return this.numEntries;
    }

    public int getReferenceCount() {
        return this.numReferences;
    }

    public List<SearchResultEntry> getSearchEntries() {
        List<SearchResultEntry> list = this.searchEntries;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public SearchResultEntry getSearchEntry(String str) {
        if (this.searchEntries == null) {
            return null;
        }
        C3122DN dn = new C3122DN(str);
        for (SearchResultEntry next : this.searchEntries) {
            if (dn.equals((Object) next.getParsedDN())) {
                return next;
            }
        }
        return null;
    }

    public List<SearchResultReference> getSearchReferences() {
        List<SearchResultReference> list = this.searchReferences;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    /* access modifiers changed from: package-private */
    public void setCounts(int i, List<SearchResultEntry> list, int i2, List<SearchResultReference> list2) {
        this.numEntries = i;
        this.numReferences = i2;
        List<SearchResultReference> list3 = null;
        if (list == null) {
            this.searchEntries = null;
        } else {
            this.searchEntries = Collections.unmodifiableList(list);
        }
        if (list2 != null) {
            list3 = Collections.unmodifiableList(list2);
        }
        this.searchReferences = list3;
    }

    public void toString(StringBuilder sb) {
        sb.append("SearchResult(resultCode=");
        sb.append(getResultCode());
        int messageID = getMessageID();
        if (messageID >= 0) {
            sb.append(", messageID=");
            sb.append(messageID);
        }
        String diagnosticMessage = getDiagnosticMessage();
        if (diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(diagnosticMessage);
            sb.append('\'');
        }
        String matchedDN = getMatchedDN();
        if (matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(matchedDN);
            sb.append('\'');
        }
        String[] referralURLs = getReferralURLs();
        if (referralURLs.length > 0) {
            sb.append(", referralURLs={");
            for (int i = 0; i < referralURLs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(referralURLs[i]);
                sb.append('\'');
            }
            sb.append('}');
        }
        sb.append(", entriesReturned=");
        sb.append(this.numEntries);
        sb.append(", referencesReturned=");
        sb.append(this.numReferences);
        Control[] responseControls = getResponseControls();
        if (responseControls.length > 0) {
            sb.append(", responseControls={");
            for (int i2 = 0; i2 < responseControls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(responseControls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
