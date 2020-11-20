package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.p172io.IOUtils;

public final class LDAPURL implements Serializable {
    private static final String[] DEFAULT_ATTRIBUTES = StaticUtils.NO_STRINGS;
    private static final C3122DN DEFAULT_BASE_DN = C3122DN.NULL_DN;
    private static final Filter DEFAULT_FILTER = Filter.createPresenceFilter("objectClass");
    public static final int DEFAULT_LDAPI_PORT = 0;
    public static final int DEFAULT_LDAPS_PORT = 636;
    public static final int DEFAULT_LDAP_PORT = 389;
    private static final SearchScope DEFAULT_SCOPE = SearchScope.BASE;
    private static final long serialVersionUID = 3420786933570240493L;
    private final String[] attributes;
    private final boolean attributesProvided;
    private final C3122DN baseDN;
    private final boolean baseDNProvided;
    private final Filter filter;
    private final boolean filterProvided;
    private final String host;
    private volatile String normalizedURLString;
    private final int port;
    private final boolean portProvided;
    private final String scheme;
    private final SearchScope scope;
    private final boolean scopeProvided;
    private final String urlString;

    public LDAPURL(String str) {
        int i;
        SearchScope searchScope;
        SearchScope searchScope2;
        Validator.ensureNotNull(str);
        this.urlString = str;
        int indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            boolean z = false;
            this.scheme = StaticUtils.toLowerCase(str.substring(0, indexOf));
            if (this.scheme.equals("ldap")) {
                i = DEFAULT_LDAP_PORT;
            } else if (this.scheme.equals("ldaps")) {
                i = DEFAULT_LDAPS_PORT;
            } else if (this.scheme.equals("ldapi")) {
                i = 0;
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_SCHEME.get(this.scheme));
            }
            int i2 = indexOf + 3;
            int indexOf2 = str.indexOf(47, i2);
            if (indexOf2 < 0) {
                this.baseDN = DEFAULT_BASE_DN;
                this.baseDNProvided = false;
                this.attributes = DEFAULT_ATTRIBUTES;
                this.attributesProvided = false;
                this.scope = DEFAULT_SCOPE;
                this.scopeProvided = false;
                this.filter = DEFAULT_FILTER;
                this.filterProvided = false;
                String substring = str.substring(i2);
                StringBuilder sb = new StringBuilder(substring.length());
                int decodeHostPort = decodeHostPort(substring, sb);
                if (decodeHostPort < 0) {
                    this.port = i;
                    this.portProvided = false;
                } else {
                    this.port = decodeHostPort;
                    this.portProvided = true;
                }
                if (sb.length() == 0) {
                    this.host = null;
                } else {
                    this.host = sb.toString();
                }
            } else {
                String substring2 = str.substring(i2, indexOf2);
                StringBuilder sb2 = new StringBuilder(substring2.length());
                int decodeHostPort2 = decodeHostPort(substring2, sb2);
                if (decodeHostPort2 < 0) {
                    this.port = i;
                    this.portProvided = false;
                } else {
                    this.port = decodeHostPort2;
                    this.portProvided = true;
                }
                if (sb2.length() == 0) {
                    this.host = null;
                } else {
                    this.host = sb2.toString();
                }
                int i3 = indexOf2 + 1;
                int indexOf3 = str.indexOf(63, i3);
                if (indexOf3 < 0) {
                    this.attributes = DEFAULT_ATTRIBUTES;
                    this.attributesProvided = false;
                    this.scope = DEFAULT_SCOPE;
                    this.scopeProvided = false;
                    this.filter = DEFAULT_FILTER;
                    this.filterProvided = false;
                    this.baseDN = new C3122DN(percentDecode(str.substring(i3)));
                    this.baseDNProvided = !this.baseDN.isNullDN();
                    return;
                }
                this.baseDN = new C3122DN(percentDecode(str.substring(i3, indexOf3)));
                this.baseDNProvided = !this.baseDN.isNullDN();
                int i4 = indexOf3 + 1;
                int indexOf4 = str.indexOf(63, i4);
                if (indexOf4 < 0) {
                    this.scope = DEFAULT_SCOPE;
                    this.scopeProvided = false;
                    this.filter = DEFAULT_FILTER;
                    this.filterProvided = false;
                    this.attributes = decodeAttributes(str.substring(i4));
                    this.attributesProvided = this.attributes.length > 0 ? true : z;
                    return;
                }
                this.attributes = decodeAttributes(str.substring(i4, indexOf4));
                this.attributesProvided = this.attributes.length > 0;
                int i5 = indexOf4 + 1;
                int indexOf5 = str.indexOf(63, i5);
                if (indexOf5 < 0) {
                    this.filter = DEFAULT_FILTER;
                    this.filterProvided = false;
                    String lowerCase = StaticUtils.toLowerCase(str.substring(i5));
                    if (lowerCase.length() == 0) {
                        this.scope = SearchScope.BASE;
                        this.scopeProvided = false;
                        return;
                    }
                    if (lowerCase.equals("base")) {
                        searchScope2 = SearchScope.BASE;
                    } else if (lowerCase.equals("one")) {
                        searchScope2 = SearchScope.ONE;
                    } else if (lowerCase.equals("sub")) {
                        searchScope2 = SearchScope.SUB;
                    } else if (lowerCase.equals("subord") || lowerCase.equals("subordinates")) {
                        searchScope2 = SearchScope.SUBORDINATE_SUBTREE;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_SCOPE.get(lowerCase));
                    }
                    this.scope = searchScope2;
                    this.scopeProvided = true;
                    return;
                }
                String lowerCase2 = StaticUtils.toLowerCase(str.substring(i5, indexOf5));
                if (lowerCase2.length() == 0) {
                    this.scope = SearchScope.BASE;
                    this.scopeProvided = false;
                } else {
                    if (lowerCase2.equals("base")) {
                        searchScope = SearchScope.BASE;
                    } else if (lowerCase2.equals("one")) {
                        searchScope = SearchScope.ONE;
                    } else if (lowerCase2.equals("sub")) {
                        searchScope = SearchScope.SUB;
                    } else if (lowerCase2.equals("subord") || lowerCase2.equals("subordinates")) {
                        searchScope = SearchScope.SUBORDINATE_SUBTREE;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_SCOPE.get(lowerCase2));
                    }
                    this.scope = searchScope;
                    this.scopeProvided = true;
                }
                String percentDecode = percentDecode(str.substring(indexOf5 + 1));
                if (percentDecode.length() == 0) {
                    this.filter = DEFAULT_FILTER;
                    this.filterProvided = false;
                    return;
                }
                this.filter = Filter.create(percentDecode);
                this.filterProvided = true;
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_NO_COLON_SLASHES.get());
        }
    }

    public LDAPURL(String str, String str2, Integer num, C3122DN dn, String[] strArr, SearchScope searchScope, Filter filter2) {
        int i;
        String str3;
        Validator.ensureNotNull(str);
        StringBuilder sb = new StringBuilder();
        this.scheme = StaticUtils.toLowerCase(str);
        if (str.equals("ldap")) {
            i = DEFAULT_LDAP_PORT;
        } else if (str.equals("ldaps")) {
            i = DEFAULT_LDAPS_PORT;
        } else if (str.equals("ldapi")) {
            i = 0;
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_SCHEME.get(str));
        }
        sb.append(str);
        sb.append("://");
        if (str2 == null || str2.length() == 0) {
            this.host = null;
        } else {
            this.host = str2;
            sb.append(str2);
        }
        if (num == null) {
            this.port = i;
            this.portProvided = false;
        } else {
            this.port = num.intValue();
            this.portProvided = true;
            sb.append(':');
            sb.append(num);
            if (num.intValue() < 1 || num.intValue() > 65535) {
                throw new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_PORT.get(num));
            }
        }
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        if (dn == null) {
            this.baseDN = DEFAULT_BASE_DN;
            this.baseDNProvided = false;
        } else {
            this.baseDN = dn;
            this.baseDNProvided = true;
            percentEncode(dn.toString(), sb);
        }
        boolean z = ((strArr == null || strArr.length == 0) && searchScope == null && filter2 == null) ? false : true;
        if (z) {
            sb.append('?');
        }
        if (strArr == null || strArr.length == 0) {
            this.attributes = DEFAULT_ATTRIBUTES;
            this.attributesProvided = false;
        } else {
            this.attributes = strArr;
            this.attributesProvided = true;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    sb.append(',');
                }
                sb.append(strArr[i2]);
            }
        }
        if (z) {
            sb.append('?');
        }
        if (searchScope == null) {
            this.scope = DEFAULT_SCOPE;
            this.scopeProvided = false;
        } else {
            switch (searchScope.intValue()) {
                case 0:
                    this.scope = searchScope;
                    this.scopeProvided = true;
                    str3 = "base";
                    break;
                case 1:
                    this.scope = searchScope;
                    this.scopeProvided = true;
                    str3 = "one";
                    break;
                case 2:
                    this.scope = searchScope;
                    this.scopeProvided = true;
                    str3 = "sub";
                    break;
                case 3:
                    this.scope = searchScope;
                    this.scopeProvided = true;
                    str3 = "subordinates";
                    break;
                default:
                    throw new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_SCOPE_VALUE.get(searchScope));
            }
            sb.append(str3);
        }
        if (z) {
            sb.append('?');
        }
        if (filter2 == null) {
            this.filter = DEFAULT_FILTER;
            this.filterProvided = false;
        } else {
            this.filter = filter2;
            this.filterProvided = true;
            percentEncode(filter2.toString(), sb);
        }
        this.urlString = sb.toString();
    }

    private static String[] decodeAttributes(String str) {
        int length = str.length();
        if (length == 0) {
            return DEFAULT_ATTRIBUTES;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            if (i < length) {
                int indexOf = str.indexOf(44, i);
                if (indexOf < 0) {
                    String trim = str.substring(i).trim();
                    if (trim.length() != 0) {
                        arrayList.add(trim);
                    } else if (arrayList.isEmpty()) {
                        return DEFAULT_ATTRIBUTES;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_ATTRLIST_ENDS_WITH_COMMA.get());
                    }
                } else {
                    String trim2 = str.substring(i, indexOf).trim();
                    if (trim2.length() != 0) {
                        arrayList.add(trim2);
                        i = indexOf + 1;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_ATTRLIST_EMPTY_ATTRIBUTE.get());
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            return strArr;
        } while (i < length);
        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_ATTRLIST_ENDS_WITH_COMMA.get());
    }

    private static int decodeHostPort(String str, StringBuilder sb) {
        int length = str.length();
        if (length == 0) {
            return -1;
        }
        if (str.charAt(0) == '[') {
            int indexOf = str.indexOf(93);
            if (indexOf >= 0) {
                sb.append(str.substring(1, indexOf).trim());
                if (sb.length() == 0) {
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_IPV6_HOST_EMPTY.get());
                } else if (indexOf == length - 1) {
                    return -1;
                } else {
                    int i = indexOf + 1;
                    if (str.charAt(i) == ':') {
                        try {
                            int parseInt = Integer.parseInt(str.substring(indexOf + 2));
                            if (parseInt >= 1 && parseInt <= 65535) {
                                return parseInt;
                            }
                            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_PORT.get(Integer.valueOf(parseInt)));
                        } catch (NumberFormatException e) {
                            Debug.debugException(e);
                            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_PORT_NOT_INT.get(str), e);
                        }
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_IPV6_HOST_UNEXPECTED_CHAR.get(Character.valueOf(str.charAt(i))));
                    }
                }
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_IPV6_HOST_MISSING_BRACKET.get());
            }
        } else {
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0) {
                sb.append(str);
                return -1;
            }
            try {
                int parseInt2 = Integer.parseInt(str.substring(indexOf2 + 1));
                if (parseInt2 < 1 || parseInt2 > 65535) {
                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_INVALID_PORT.get(Integer.valueOf(parseInt2)));
                }
                sb.append(str.substring(0, indexOf2));
                return parseInt2;
            } catch (NumberFormatException e2) {
                Debug.debugException(e2);
                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_LDAPURL_PORT_NOT_INT.get(str), e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r5 = -16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r5 = -32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        r5 = -48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        r5 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r5 = -80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r5 = -96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r5 = r5 | 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c2, code lost:
        r5 = r5 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c5, code lost:
        r5 = r5 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c8, code lost:
        r5 = r5 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cb, code lost:
        r5 = r5 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ce, code lost:
        r5 = r5 | 10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String percentDecode(java.lang.String r9) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = 0
        L_0x0006:
            r3 = 37
            if (r2 >= r0) goto L_0x0014
            char r4 = r9.charAt(r2)
            if (r4 != r3) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0014:
            r2 = -1
        L_0x0015:
            if (r2 >= 0) goto L_0x0018
            return r9
        L_0x0018:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r5 = r0 * 2
            r4.<init>(r5)
            java.lang.String r5 = r9.substring(r1, r2)
            r4.append(r5)
        L_0x0026:
            if (r2 >= r0) goto L_0x013d
            int r5 = r2 + 1
            char r2 = r9.charAt(r2)
            if (r2 != r3) goto L_0x0137
            r2 = 1
            if (r5 >= r0) goto L_0x0125
            int r6 = r0 - r5
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)
        L_0x0039:
            if (r5 >= r0) goto L_0x0111
            int r7 = r5 + 1
            char r5 = r9.charAt(r5)
            switch(r5) {
                case 48: goto L_0x0092;
                case 49: goto L_0x008f;
                case 50: goto L_0x008c;
                case 51: goto L_0x0089;
                case 52: goto L_0x0086;
                case 53: goto L_0x0083;
                case 54: goto L_0x0080;
                case 55: goto L_0x007d;
                case 56: goto L_0x007a;
                case 57: goto L_0x0077;
                default: goto L_0x0044;
            }
        L_0x0044:
            switch(r5) {
                case 65: goto L_0x0074;
                case 66: goto L_0x0071;
                case 67: goto L_0x006e;
                case 68: goto L_0x006b;
                case 69: goto L_0x0068;
                case 70: goto L_0x0065;
                default: goto L_0x0047;
            }
        L_0x0047:
            switch(r5) {
                case 97: goto L_0x0074;
                case 98: goto L_0x0071;
                case 99: goto L_0x006e;
                case 100: goto L_0x006b;
                case 101: goto L_0x0068;
                case 102: goto L_0x0065;
                default: goto L_0x004a;
            }
        L_0x004a:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_LDAPURL_INVALID_HEX_CHAR
            java.lang.Object[] r5 = new java.lang.Object[r2]
            int r7 = r7 - r2
            char r9 = r9.charAt(r7)
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            r5[r1] = r9
            java.lang.String r9 = r4.get(r5)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r9)
            throw r0
        L_0x0065:
            r5 = -16
            goto L_0x0093
        L_0x0068:
            r5 = -32
            goto L_0x0093
        L_0x006b:
            r5 = -48
            goto L_0x0093
        L_0x006e:
            r5 = -64
            goto L_0x0093
        L_0x0071:
            r5 = -80
            goto L_0x0093
        L_0x0074:
            r5 = -96
            goto L_0x0093
        L_0x0077:
            r5 = -112(0xffffffffffffff90, float:NaN)
            goto L_0x0093
        L_0x007a:
            r5 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x0093
        L_0x007d:
            r5 = 112(0x70, float:1.57E-43)
            goto L_0x0093
        L_0x0080:
            r5 = 96
            goto L_0x0093
        L_0x0083:
            r5 = 80
            goto L_0x0093
        L_0x0086:
            r5 = 64
            goto L_0x0093
        L_0x0089:
            r5 = 48
            goto L_0x0093
        L_0x008c:
            r5 = 32
            goto L_0x0093
        L_0x008f:
            r5 = 16
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            if (r7 >= r0) goto L_0x00ff
            int r8 = r7 + 1
            char r7 = r9.charAt(r7)
            switch(r7) {
                case 48: goto L_0x00ec;
                case 49: goto L_0x00e9;
                case 50: goto L_0x00e6;
                case 51: goto L_0x00e3;
                case 52: goto L_0x00e0;
                case 53: goto L_0x00dd;
                case 54: goto L_0x00da;
                case 55: goto L_0x00d7;
                case 56: goto L_0x00d4;
                case 57: goto L_0x00d1;
                default: goto L_0x009e;
            }
        L_0x009e:
            switch(r7) {
                case 65: goto L_0x00ce;
                case 66: goto L_0x00cb;
                case 67: goto L_0x00c8;
                case 68: goto L_0x00c5;
                case 69: goto L_0x00c2;
                case 70: goto L_0x00bf;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            switch(r7) {
                case 97: goto L_0x00ce;
                case 98: goto L_0x00cb;
                case 99: goto L_0x00c8;
                case 100: goto L_0x00c5;
                case 101: goto L_0x00c2;
                case 102: goto L_0x00bf;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_LDAPURL_INVALID_HEX_CHAR
            java.lang.Object[] r5 = new java.lang.Object[r2]
            int r8 = r8 - r2
            char r9 = r9.charAt(r8)
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            r5[r1] = r9
            java.lang.String r9 = r4.get(r5)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r9)
            throw r0
        L_0x00bf:
            r5 = r5 | 15
            goto L_0x00ee
        L_0x00c2:
            r5 = r5 | 14
            goto L_0x00ee
        L_0x00c5:
            r5 = r5 | 13
            goto L_0x00ee
        L_0x00c8:
            r5 = r5 | 12
            goto L_0x00ee
        L_0x00cb:
            r5 = r5 | 11
            goto L_0x00ee
        L_0x00ce:
            r5 = r5 | 10
            goto L_0x00ee
        L_0x00d1:
            r5 = r5 | 9
            goto L_0x00ee
        L_0x00d4:
            r5 = r5 | 8
            goto L_0x00ee
        L_0x00d7:
            r5 = r5 | 7
            goto L_0x00ee
        L_0x00da:
            r5 = r5 | 6
            goto L_0x00ee
        L_0x00dd:
            r5 = r5 | 5
            goto L_0x00ee
        L_0x00e0:
            r5 = r5 | 4
            goto L_0x00ee
        L_0x00e3:
            r5 = r5 | 3
            goto L_0x00ee
        L_0x00e6:
            r5 = r5 | 2
            goto L_0x00ee
        L_0x00e9:
            r5 = r5 | 1
            goto L_0x00ee
        L_0x00ec:
            r5 = r5 | 0
        L_0x00ee:
            byte r5 = (byte) r5
            r6.put(r5)
            if (r8 >= r0) goto L_0x00fc
            char r5 = r9.charAt(r8)
            if (r5 == r3) goto L_0x00fc
            r5 = r8
            goto L_0x0111
        L_0x00fc:
            r5 = r8
            goto L_0x0039
        L_0x00ff:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_LDAPURL_HEX_STRING_TOO_SHORT
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r9
            java.lang.String r9 = r4.get(r2)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r9)
            throw r0
        L_0x0111:
            r6.flip()
            int r2 = r6.limit()
            byte[] r2 = new byte[r2]
            r6.get(r2)
            java.lang.String r2 = com.unboundid.util.StaticUtils.toUTF8String(r2)
            r4.append(r2)
            goto L_0x013a
        L_0x0125:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_LDAPURL_HEX_STRING_TOO_SHORT
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r9
            java.lang.String r9 = r4.get(r2)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r9)
            throw r0
        L_0x0137:
            r4.append(r2)
        L_0x013a:
            r2 = r5
            goto L_0x0026
        L_0x013d:
            java.lang.String r9 = r4.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPURL.percentDecode(java.lang.String):java.lang.String");
    }

    private static void percentEncode(String str, StringBuilder sb) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '!' || charAt == '$' || charAt == ';' || charAt == '=' || charAt == '_' || charAt == '~')) {
                switch (charAt) {
                    case '&':
                    case '\'':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                        break;
                    default:
                        switch (charAt) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                switch (charAt) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                        break;
                                    default:
                                        switch (charAt) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                            case 'g':
                                            case 'h':
                                            case 'i':
                                            case 'j':
                                            case 'k':
                                            case 'l':
                                            case 'm':
                                            case 'n':
                                            case 'o':
                                            case 'p':
                                            case 'q':
                                            case 'r':
                                            case 's':
                                            case 't':
                                            case 'u':
                                            case 'v':
                                            case 'w':
                                            case 'x':
                                            case 'y':
                                            case 'z':
                                                break;
                                            default:
                                                for (byte hex : StaticUtils.getBytes(new String(new char[]{charAt}))) {
                                                    sb.append('%');
                                                    StaticUtils.toHex(hex, sb);
                                                }
                                                continue;
                                                continue;
                                                continue;
                                                continue;
                                        }
                                }
                        }
                }
            }
            sb.append(charAt);
        }
    }

    public boolean attributesProvided() {
        return this.attributesProvided;
    }

    public boolean baseDNProvided() {
        return this.baseDNProvided;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LDAPURL)) {
            return false;
        }
        return toNormalizedString().equals(((LDAPURL) obj).toNormalizedString());
    }

    public boolean filterProvided() {
        return this.filterProvided;
    }

    public String[] getAttributes() {
        return this.attributes;
    }

    public C3122DN getBaseDN() {
        return this.baseDN;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getScheme() {
        return this.scheme;
    }

    public SearchScope getScope() {
        return this.scope;
    }

    public int hashCode() {
        return toNormalizedString().hashCode();
    }

    public boolean hostProvided() {
        return this.host != null;
    }

    public boolean portProvided() {
        return this.portProvided;
    }

    public boolean scopeProvided() {
        return this.scopeProvided;
    }

    public String toNormalizedString() {
        if (this.normalizedURLString == null) {
            StringBuilder sb = new StringBuilder();
            toNormalizedString(sb);
            this.normalizedURLString = sb.toString();
        }
        return this.normalizedURLString;
    }

    public void toNormalizedString(StringBuilder sb) {
        String str;
        sb.append(this.scheme);
        sb.append("://");
        String str2 = this.host;
        if (str2 != null) {
            if (str2.indexOf(58) >= 0) {
                sb.append('[');
                sb.append(StaticUtils.toLowerCase(this.host));
                sb.append(']');
            } else {
                sb.append(StaticUtils.toLowerCase(this.host));
            }
        }
        if (!this.scheme.equals("ldapi")) {
            sb.append(':');
            sb.append(this.port);
        }
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        percentEncode(this.baseDN.toNormalizedString(), sb);
        sb.append('?');
        for (int i = 0; i < this.attributes.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(StaticUtils.toLowerCase(this.attributes[i]));
        }
        sb.append('?');
        switch (this.scope.intValue()) {
            case 0:
                str = "base";
                break;
            case 1:
                str = "one";
                break;
            case 2:
                str = "sub";
                break;
            case 3:
                str = "subordinates";
                break;
            default:
                sb.append('?');
                percentEncode(this.filter.toNormalizedString(), sb);
        }
        sb.append(str);
        sb.append('?');
        percentEncode(this.filter.toNormalizedString(), sb);
    }

    public SearchRequest toSearchRequest() {
        return new SearchRequest(this.baseDN.toString(), this.scope, this.filter, this.attributes);
    }

    public String toString() {
        return this.urlString;
    }
}
