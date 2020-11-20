package com.unboundid.ldap.sdk;

import com.unboundid.ldap.sdk.schema.Schema;
import java.util.Collection;
import java.util.List;

public interface LDAPInterface {
    LDAPResult add(AddRequest addRequest);

    LDAPResult add(Entry entry);

    LDAPResult add(ReadOnlyAddRequest readOnlyAddRequest);

    LDAPResult add(String str, Collection<Attribute> collection);

    LDAPResult add(String str, Attribute... attributeArr);

    LDAPResult add(String... strArr);

    CompareResult compare(CompareRequest compareRequest);

    CompareResult compare(ReadOnlyCompareRequest readOnlyCompareRequest);

    CompareResult compare(String str, String str2, String str3);

    LDAPResult delete(DeleteRequest deleteRequest);

    LDAPResult delete(ReadOnlyDeleteRequest readOnlyDeleteRequest);

    LDAPResult delete(String str);

    SearchResultEntry getEntry(String str);

    SearchResultEntry getEntry(String str, String... strArr);

    RootDSE getRootDSE();

    Schema getSchema();

    Schema getSchema(String str);

    LDAPResult modify(ModifyRequest modifyRequest);

    LDAPResult modify(ReadOnlyModifyRequest readOnlyModifyRequest);

    LDAPResult modify(String str, Modification modification);

    LDAPResult modify(String str, List<Modification> list);

    LDAPResult modify(String str, Modification... modificationArr);

    LDAPResult modify(String... strArr);

    LDAPResult modifyDN(ModifyDNRequest modifyDNRequest);

    LDAPResult modifyDN(ReadOnlyModifyDNRequest readOnlyModifyDNRequest);

    LDAPResult modifyDN(String str, String str2, boolean z);

    LDAPResult modifyDN(String str, String str2, boolean z, String str3);

    SearchResult search(ReadOnlySearchRequest readOnlySearchRequest);

    SearchResult search(SearchRequest searchRequest);

    SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr);

    SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr);

    SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, Filter filter, String... strArr);

    SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, String str2, String... strArr);

    SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr);

    SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr);

    SearchResult search(String str, SearchScope searchScope, Filter filter, String... strArr);

    SearchResult search(String str, SearchScope searchScope, String str2, String... strArr);

    SearchResultEntry searchForEntry(ReadOnlySearchRequest readOnlySearchRequest);

    SearchResultEntry searchForEntry(SearchRequest searchRequest);

    SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, Filter filter, String... strArr);

    SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, String str2, String... strArr);

    SearchResultEntry searchForEntry(String str, SearchScope searchScope, Filter filter, String... strArr);

    SearchResultEntry searchForEntry(String str, SearchScope searchScope, String str2, String... strArr);
}
