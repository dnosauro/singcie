package com.unboundid.ldap.sdk.schema;

import com.github.appintro.AppIntroBaseFragmentKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MatchingRuleDefinition extends SchemaElement {
    private static final long serialVersionUID = 8214648655449007967L;
    private final String description;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String matchingRuleString;
    private final String[] names;
    private final String oid;
    private final String syntaxOID;

    public MatchingRuleDefinition(String str) {
        Validator.ensureNotNull(str);
        this.matchingRuleString = str.trim();
        int length = this.matchingRuleString.length();
        if (length != 0) {
            boolean z = false;
            if (this.matchingRuleString.charAt(0) == '(') {
                int skipSpaces = skipSpaces(this.matchingRuleString, 1, length);
                StringBuilder sb = new StringBuilder();
                int readOID = readOID(this.matchingRuleString, skipSpaces, length, sb);
                this.oid = sb.toString();
                ArrayList arrayList = new ArrayList(1);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str2 = null;
                String str3 = null;
                Boolean bool = null;
                while (true) {
                    int skipSpaces2 = skipSpaces(this.matchingRuleString, readOID, length);
                    int i = skipSpaces2;
                    while (i < length && this.matchingRuleString.charAt(i) != ' ') {
                        i++;
                    }
                    String substring = this.matchingRuleString.substring(skipSpaces2, i);
                    String lowerCase = StaticUtils.toLowerCase(substring);
                    if (lowerCase.equals(")")) {
                        if (i >= length) {
                            this.description = str2;
                            this.syntaxOID = str3;
                            if (this.syntaxOID != null) {
                                this.names = new String[arrayList.size()];
                                arrayList.toArray(this.names);
                                this.isObsolete = bool != null ? true : z;
                                this.extensions = Collections.unmodifiableMap(linkedHashMap);
                                return;
                            }
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_NO_SYNTAX.get(this.matchingRuleString));
                        }
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_CLOSE_NOT_AT_END.get(this.matchingRuleString));
                    } else if (lowerCase.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        if (arrayList.isEmpty()) {
                            readOID = readQDStrings(this.matchingRuleString, skipSpaces(this.matchingRuleString, i, length), length, arrayList);
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleString, "NAME"));
                        }
                    } else if (!lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                        if (lowerCase.equals("obsolete")) {
                            if (bool == null) {
                                bool = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleString, "OBSOLETE"));
                            }
                        } else if (lowerCase.equals("syntax")) {
                            if (str3 == null) {
                                int skipSpaces3 = skipSpaces(this.matchingRuleString, i, length);
                                StringBuilder sb2 = new StringBuilder();
                                readOID = readOID(this.matchingRuleString, skipSpaces3, length, sb2);
                                str3 = sb2.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleString, "SYNTAX"));
                            }
                        } else if (lowerCase.startsWith("x-")) {
                            int skipSpaces4 = skipSpaces(this.matchingRuleString, i, length);
                            ArrayList arrayList2 = new ArrayList();
                            i = readQDStrings(this.matchingRuleString, skipSpaces4, length, arrayList2);
                            String[] strArr = new String[arrayList2.size()];
                            arrayList2.toArray(strArr);
                            if (!linkedHashMap.containsKey(substring)) {
                                linkedHashMap.put(substring, strArr);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_DUP_EXT.get(this.matchingRuleString, substring));
                            }
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_UNEXPECTED_TOKEN.get(this.matchingRuleString, substring));
                        }
                        readOID = i;
                    } else if (str2 == null) {
                        int skipSpaces5 = skipSpaces(this.matchingRuleString, i, length);
                        StringBuilder sb3 = new StringBuilder();
                        readOID = readQDString(this.matchingRuleString, skipSpaces5, length, sb3);
                        str2 = sb3.toString();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleString, "DESC"));
                    }
                }
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_NO_OPENING_PAREN.get(this.matchingRuleString));
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MR_DECODE_EMPTY.get());
        }
    }

    public MatchingRuleDefinition(String str, String[] strArr, String str2, boolean z, String str3, Map<String, String[]> map) {
        Validator.ensureNotNull(str, str3);
        this.oid = str;
        this.description = str2;
        this.isObsolete = z;
        this.syntaxOID = str3;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.matchingRuleString = sb.toString();
    }

    private void createDefinitionString(StringBuilder sb) {
        sb.append("( ");
        sb.append(this.oid);
        String[] strArr = this.names;
        if (strArr.length == 1) {
            sb.append(" NAME '");
            sb.append(this.names[0]);
            sb.append('\'');
        } else if (strArr.length > 1) {
            sb.append(" NAME (");
            for (String append : this.names) {
                sb.append(" '");
                sb.append(append);
                sb.append('\'');
            }
            sb.append(" )");
        }
        if (this.description != null) {
            sb.append(" DESC '");
            encodeValue(this.description, sb);
            sb.append('\'');
        }
        if (this.isObsolete) {
            sb.append(" OBSOLETE");
        }
        sb.append(" SYNTAX ");
        sb.append(this.syntaxOID);
        for (Map.Entry next : this.extensions.entrySet()) {
            String str = (String) next.getKey();
            String[] strArr2 = (String[]) next.getValue();
            if (strArr2.length == 1) {
                sb.append(' ');
                sb.append(str);
                sb.append(" '");
                encodeValue(strArr2[0], sb);
                sb.append('\'');
            } else {
                sb.append(' ');
                sb.append(str);
                sb.append(" (");
                for (String encodeValue : strArr2) {
                    sb.append(" '");
                    encodeValue(encodeValue, sb);
                    sb.append('\'');
                }
                sb.append(" )");
            }
        }
        sb.append(" )");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchingRuleDefinition)) {
            return false;
        }
        MatchingRuleDefinition matchingRuleDefinition = (MatchingRuleDefinition) obj;
        return this.oid.equals(matchingRuleDefinition.oid) && this.syntaxOID.equals(matchingRuleDefinition.syntaxOID) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, matchingRuleDefinition.names) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, matchingRuleDefinition.description) && this.isObsolete == matchingRuleDefinition.isObsolete && extensionsEqual(this.extensions, matchingRuleDefinition.extensions);
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String[]> getExtensions() {
        return this.extensions;
    }

    public String getNameOrOID() {
        String[] strArr = this.names;
        return strArr.length == 0 ? this.oid : strArr[0];
    }

    public String[] getNames() {
        return this.names;
    }

    public String getOID() {
        return this.oid;
    }

    public String getSyntaxOID() {
        return this.syntaxOID;
    }

    public boolean hasNameOrOID(String str) {
        for (String equalsIgnoreCase : this.names) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return str.equalsIgnoreCase(this.oid);
    }

    public int hashCode() {
        return this.oid.hashCode();
    }

    public boolean isObsolete() {
        return this.isObsolete;
    }

    public String toString() {
        return this.matchingRuleString;
    }
}
