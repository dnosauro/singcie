package com.unboundid.ldap.sdk.schema;

import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public abstract class SchemaElement implements Serializable {
    private static final long serialVersionUID = -8249972237068748580L;

    static void encodeValue(String str, StringBuilder sb) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\\' || charAt == '\'') {
                StaticUtils.hexEncode(charAt, sb);
            } else {
                sb.append(charAt);
            }
        }
    }

    protected static boolean extensionsEqual(Map<String, String[]> map, Map<String, String[]> map2) {
        if (map.isEmpty()) {
            return map2.isEmpty();
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!StaticUtils.arraysEqualOrderIndependent((String[]) next.getValue(), map2.get(next.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        r8 = -48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        r8 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        r8 = -80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        r8 = -96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a0, code lost:
        r8 = r8 | 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        r8 = r8 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        r8 = r8 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r8 = r8 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r8 = r8 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        r8 = r8 | 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        r8 = (byte) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        r8 = -16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        r8 = -32;
     */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int readEscapedHexString(java.lang.String r7, int r8, int r9, java.lang.StringBuilder r10) {
        /*
            int r0 = r9 - r8
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
        L_0x0006:
            if (r8 >= r9) goto L_0x00fc
            int r1 = r8 + 1
            char r8 = r7.charAt(r8)
            r2 = 2
            r3 = 3
            r4 = 0
            r5 = 1
            switch(r8) {
                case 48: goto L_0x006b;
                case 49: goto L_0x0068;
                case 50: goto L_0x0065;
                case 51: goto L_0x0062;
                case 52: goto L_0x005f;
                case 53: goto L_0x005c;
                case 54: goto L_0x0059;
                case 55: goto L_0x0056;
                case 56: goto L_0x0053;
                case 57: goto L_0x0050;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r8) {
                case 65: goto L_0x004d;
                case 66: goto L_0x004a;
                case 67: goto L_0x0047;
                case 68: goto L_0x0044;
                case 69: goto L_0x0041;
                case 70: goto L_0x003e;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r8) {
                case 97: goto L_0x004d;
                case 98: goto L_0x004a;
                case 99: goto L_0x0047;
                case 100: goto L_0x0044;
                case 101: goto L_0x0041;
                case 102: goto L_0x003e;
                default: goto L_0x001b;
            }
        L_0x001b:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r9 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.schema.SchemaMessages r10 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_SCHEMA_ELEM_INVALID_HEX_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r7
            int r1 = r1 - r5
            char r7 = r7.charAt(r1)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r0[r5] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            r0[r2] = r7
            java.lang.String r7 = r10.get(r0)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r9, (java.lang.String) r7)
            throw r8
        L_0x003e:
            r8 = -16
            goto L_0x006c
        L_0x0041:
            r8 = -32
            goto L_0x006c
        L_0x0044:
            r8 = -48
            goto L_0x006c
        L_0x0047:
            r8 = -64
            goto L_0x006c
        L_0x004a:
            r8 = -80
            goto L_0x006c
        L_0x004d:
            r8 = -96
            goto L_0x006c
        L_0x0050:
            r8 = -112(0xffffffffffffff90, float:NaN)
            goto L_0x006c
        L_0x0053:
            r8 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x006c
        L_0x0056:
            r8 = 112(0x70, float:1.57E-43)
            goto L_0x006c
        L_0x0059:
            r8 = 96
            goto L_0x006c
        L_0x005c:
            r8 = 80
            goto L_0x006c
        L_0x005f:
            r8 = 64
            goto L_0x006c
        L_0x0062:
            r8 = 48
            goto L_0x006c
        L_0x0065:
            r8 = 32
            goto L_0x006c
        L_0x0068:
            r8 = 16
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            if (r1 >= r9) goto L_0x00ea
            int r6 = r1 + 1
            char r1 = r7.charAt(r1)
            switch(r1) {
                case 48: goto L_0x00cd;
                case 49: goto L_0x00ca;
                case 50: goto L_0x00c7;
                case 51: goto L_0x00c4;
                case 52: goto L_0x00c1;
                case 53: goto L_0x00be;
                case 54: goto L_0x00bb;
                case 55: goto L_0x00b8;
                case 56: goto L_0x00b5;
                case 57: goto L_0x00b2;
                default: goto L_0x0077;
            }
        L_0x0077:
            switch(r1) {
                case 65: goto L_0x00af;
                case 66: goto L_0x00ac;
                case 67: goto L_0x00a9;
                case 68: goto L_0x00a6;
                case 69: goto L_0x00a3;
                case 70: goto L_0x00a0;
                default: goto L_0x007a;
            }
        L_0x007a:
            switch(r1) {
                case 97: goto L_0x00af;
                case 98: goto L_0x00ac;
                case 99: goto L_0x00a9;
                case 100: goto L_0x00a6;
                case 101: goto L_0x00a3;
                case 102: goto L_0x00a0;
                default: goto L_0x007d;
            }
        L_0x007d:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r9 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.schema.SchemaMessages r10 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_SCHEMA_ELEM_INVALID_HEX_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r7
            int r6 = r6 - r5
            char r7 = r7.charAt(r6)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r0[r5] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r0[r2] = r7
            java.lang.String r7 = r10.get(r0)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r9, (java.lang.String) r7)
            throw r8
        L_0x00a0:
            r8 = r8 | 15
            goto L_0x00cc
        L_0x00a3:
            r8 = r8 | 14
            goto L_0x00cc
        L_0x00a6:
            r8 = r8 | 13
            goto L_0x00cc
        L_0x00a9:
            r8 = r8 | 12
            goto L_0x00cc
        L_0x00ac:
            r8 = r8 | 11
            goto L_0x00cc
        L_0x00af:
            r8 = r8 | 10
            goto L_0x00cc
        L_0x00b2:
            r8 = r8 | 9
            goto L_0x00cc
        L_0x00b5:
            r8 = r8 | 8
            goto L_0x00cc
        L_0x00b8:
            r8 = r8 | 7
            goto L_0x00cc
        L_0x00bb:
            r8 = r8 | 6
            goto L_0x00cc
        L_0x00be:
            r8 = r8 | 5
            goto L_0x00cc
        L_0x00c1:
            r8 = r8 | 4
            goto L_0x00cc
        L_0x00c4:
            r8 = r8 | 3
            goto L_0x00cc
        L_0x00c7:
            r8 = r8 | 2
            goto L_0x00cc
        L_0x00ca:
            r8 = r8 | 1
        L_0x00cc:
            byte r8 = (byte) r8
        L_0x00cd:
            r0.put(r8)
            int r8 = r6 + 1
            if (r8 >= r9) goto L_0x00e8
            char r1 = r7.charAt(r6)
            r2 = 92
            if (r1 != r2) goto L_0x00e8
            char r1 = r7.charAt(r8)
            boolean r1 = com.unboundid.util.StaticUtils.isHex(r1)
            if (r1 == 0) goto L_0x00e8
            goto L_0x0006
        L_0x00e8:
            r8 = r6
            goto L_0x00fc
        L_0x00ea:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r9 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.schema.SchemaMessages r10 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_SCHEMA_ELEM_MISSING_HEX_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r4] = r7
            java.lang.String r7 = r10.get(r0)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r9, (java.lang.String) r7)
            throw r8
        L_0x00fc:
            r0.flip()
            int r7 = r0.limit()
            byte[] r7 = new byte[r7]
            r0.get(r7)
            java.lang.String r9 = com.unboundid.util.StaticUtils.toUTF8String(r7)     // Catch:{ Exception -> 0x0110 }
            r10.append(r9)     // Catch:{ Exception -> 0x0110 }
            goto L_0x011c
        L_0x0110:
            r9 = move-exception
            com.unboundid.util.Debug.debugException(r9)
            java.lang.String r9 = new java.lang.String
            r9.<init>(r7)
            r10.append(r9)
        L_0x011c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.SchemaElement.readEscapedHexString(java.lang.String, int, int, java.lang.StringBuilder):int");
    }

    static int readOID(String str, int i, int i2, StringBuilder sb) {
        boolean z = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '$' && charAt != ')') {
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || charAt == '-' || charAt == '.' || charAt == '_' || charAt == '{' || charAt == '}'))) {
                    if (charAt != '\'') {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_UNEXPECTED_CHAR_IN_OID.get(str, Integer.valueOf(i)));
                    } else if (sb.length() != 0) {
                        z = true;
                    }
                } else if (!z) {
                    sb.append(charAt);
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_UNEXPECTED_CHAR_IN_OID.get(str, Integer.valueOf(i - 1)));
                }
                i++;
            } else if (sb.length() != 0) {
                return i;
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EMPTY_OID.get(str));
            }
        }
        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_NO_SPACE_AFTER_OID.get(str));
    }

    static int readOIDs(String str, int i, int i2, ArrayList<String> arrayList) {
        StringBuilder sb;
        if (str.charAt(i) == '(') {
            int i3 = i + 1;
            while (true) {
                int skipSpaces = skipSpaces(str, i3, i2);
                char charAt = str.charAt(skipSpaces);
                if (charAt == ')') {
                    int i4 = skipSpaces + 1;
                    if (arrayList.isEmpty()) {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EMPTY_OID_LIST.get(str));
                    } else if (i4 < i2) {
                        return i4;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_NO_SPACE_AFTER_OID_LIST.get(str));
                    }
                } else {
                    if (charAt == '$') {
                        skipSpaces = skipSpaces(str, skipSpaces + 1, i2);
                        sb = new StringBuilder();
                    } else if (arrayList.isEmpty()) {
                        sb = new StringBuilder();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_UNEXPECTED_CHAR_IN_OID_LIST.get(str, Integer.valueOf(skipSpaces)));
                    }
                    i3 = readOID(str, skipSpaces, i2, sb);
                    arrayList.add(sb.toString());
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            int readOID = readOID(str, i, i2, sb2);
            arrayList.add(sb2.toString());
            return readOID;
        }
    }

    static int readQDString(String str, int i, int i2, StringBuilder sb) {
        if (str.charAt(i) == '\'') {
            int i3 = i + 1;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int i4 = i3 + 1;
                char charAt = str.charAt(i3);
                if (charAt == '\'') {
                    i3 = i4;
                    break;
                } else if (charAt != '\\') {
                    sb.append(charAt);
                    i3 = i4;
                } else if (i4 < i2) {
                    i3 = readEscapedHexString(str, i4, i2, sb);
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_ENDS_WITH_BACKSLASH.get(str));
                }
            }
            if (i3 >= i2 || !(str.charAt(i3) == ' ' || str.charAt(i3) == ')')) {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_NO_CLOSING_PAREN.get(str));
            } else if (sb.length() != 0) {
                return i3;
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EMPTY_QUOTES.get(str));
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EXPECTED_SINGLE_QUOTE.get(str, Integer.valueOf(i)));
        }
    }

    static int readQDStrings(String str, int i, int i2, ArrayList<String> arrayList) {
        char charAt = str.charAt(i);
        if (charAt == '\'') {
            StringBuilder sb = new StringBuilder();
            int readQDString = readQDString(str, i, i2, sb);
            arrayList.add(sb.toString());
            return readQDString;
        } else if (charAt == '(') {
            int i3 = i + 1;
            while (true) {
                int skipSpaces = skipSpaces(str, i3, i2);
                char charAt2 = str.charAt(skipSpaces);
                if (charAt2 == ')') {
                    int i4 = skipSpaces + 1;
                    if (arrayList.isEmpty()) {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EMPTY_STRING_LIST.get(str));
                    } else if (i4 < i2 && (str.charAt(i4) == ' ' || str.charAt(i4) == ')')) {
                        return i4;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_NO_SPACE_AFTER_QUOTE.get(str));
                    }
                } else if (charAt2 == '\'') {
                    StringBuilder sb2 = new StringBuilder();
                    i3 = readQDString(str, skipSpaces, i2, sb2);
                    arrayList.add(sb2.toString());
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EXPECTED_QUOTE_OR_PAREN.get(str, Integer.valueOf(i)));
                }
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_EXPECTED_QUOTE_OR_PAREN.get(str, Integer.valueOf(i)));
        }
    }

    static int skipSpaces(String str, int i, int i2) {
        while (i < i2 && str.charAt(i) == ' ') {
            i++;
        }
        if (i < i2) {
            return i;
        }
        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_SCHEMA_ELEM_SKIP_SPACES_NO_CLOSE_PAREN.get(str));
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract String toString();
}
