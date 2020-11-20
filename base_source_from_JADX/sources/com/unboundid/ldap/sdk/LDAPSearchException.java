package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;
import java.util.List;

public final class LDAPSearchException extends LDAPException {
    private static final long serialVersionUID = 350230437196125113L;
    private final SearchResult searchResult;

    public LDAPSearchException(LDAPException lDAPException) {
        super(lDAPException.getResultCode(), lDAPException.getMessage(), lDAPException.getMatchedDN(), lDAPException.getReferralURLs(), lDAPException.getResponseControls(), lDAPException);
        if (lDAPException instanceof LDAPSearchException) {
            this.searchResult = ((LDAPSearchException) lDAPException).searchResult;
        } else {
            this.searchResult = new SearchResult(-1, lDAPException.getResultCode(), lDAPException.getMessage(), lDAPException.getMatchedDN(), lDAPException.getReferralURLs(), 0, 0, lDAPException.getResponseControls());
        }
    }

    public LDAPSearchException(ResultCode resultCode, String str) {
        super(resultCode, str);
        this.searchResult = new SearchResult(-1, resultCode, str, (String) null, StaticUtils.NO_STRINGS, 0, 0, StaticUtils.NO_CONTROLS);
    }

    public LDAPSearchException(ResultCode resultCode, String str, Throwable th) {
        super(resultCode, str, th);
        this.searchResult = new SearchResult(-1, resultCode, str, (String) null, StaticUtils.NO_STRINGS, 0, 0, StaticUtils.NO_CONTROLS);
    }

    public LDAPSearchException(SearchResult searchResult2) {
        super((LDAPResult) searchResult2);
        this.searchResult = searchResult2;
    }

    public int getEntryCount() {
        return this.searchResult.getEntryCount();
    }

    public int getReferenceCount() {
        return this.searchResult.getReferenceCount();
    }

    public List<SearchResultEntry> getSearchEntries() {
        return this.searchResult.getSearchEntries();
    }

    public List<SearchResultReference> getSearchReferences() {
        return this.searchResult.getSearchReferences();
    }

    public SearchResult getSearchResult() {
        return this.searchResult;
    }

    public SearchResult toLDAPResult() {
        return this.searchResult;
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPSearchException(resultCode=");
        sb.append(getResultCode());
        sb.append(", numEntries=");
        sb.append(this.searchResult.getEntryCount());
        sb.append(", numReferences=");
        sb.append(this.searchResult.getReferenceCount());
        String message = getMessage();
        if (message != null) {
            sb.append(", errorMessage='");
            sb.append(message);
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
