package com.unboundid.ldap.sdk.schema;

import com.github.appintro.AppIntroBaseFragmentKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AttributeTypeDefinition extends SchemaElement {
    private static final long serialVersionUID = -6688185196734362719L;
    private final String attributeTypeString;
    private final String description;
    private final String equalityMatchingRule;
    private final Map<String, String[]> extensions;
    private final boolean isCollective;
    private final boolean isNoUserModification;
    private final boolean isObsolete;
    private final boolean isSingleValued;
    private final String[] names;
    private final String oid;
    private final String orderingMatchingRule;
    private final String substringMatchingRule;
    private final String superiorType;
    private final String syntaxOID;
    private final AttributeUsage usage;

    public AttributeTypeDefinition(String str) {
        AttributeUsage attributeUsage;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        AttributeUsage attributeUsage2;
        Validator.ensureNotNull(str);
        this.attributeTypeString = str.trim();
        int length = this.attributeTypeString.length();
        if (length == 0) {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_EMPTY.get());
        } else if (this.attributeTypeString.charAt(0) == '(') {
            int skipSpaces = skipSpaces(this.attributeTypeString, 1, length);
            StringBuilder sb = new StringBuilder();
            int readOID = readOID(this.attributeTypeString, skipSpaces, length, sb);
            this.oid = sb.toString();
            ArrayList arrayList = new ArrayList(1);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            String str2 = null;
            AttributeUsage attributeUsage3 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            Boolean bool = null;
            Boolean bool2 = null;
            Boolean bool3 = null;
            Boolean bool4 = null;
            while (true) {
                int skipSpaces2 = skipSpaces(this.attributeTypeString, readOID, length);
                int i = skipSpaces2;
                while (true) {
                    if (i >= length) {
                        attributeUsage = attributeUsage3;
                        linkedHashMap = linkedHashMap3;
                        break;
                    }
                    linkedHashMap = linkedHashMap3;
                    attributeUsage = attributeUsage3;
                    if (this.attributeTypeString.charAt(i) == ' ') {
                        break;
                    }
                    i++;
                    linkedHashMap3 = linkedHashMap;
                    attributeUsage3 = attributeUsage;
                }
                String substring = this.attributeTypeString.substring(skipSpaces2, i);
                String lowerCase = StaticUtils.toLowerCase(substring);
                if (!lowerCase.equals(")")) {
                    AttributeUsage attributeUsage4 = attributeUsage;
                    String str8 = substring;
                    AttributeUsage attributeUsage5 = attributeUsage4;
                    if (lowerCase.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        if (arrayList.isEmpty()) {
                            readOID = readQDStrings(this.attributeTypeString, skipSpaces(this.attributeTypeString, i, length), length, arrayList);
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "NAME"));
                        }
                    } else if (!lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                        if (lowerCase.equals("obsolete")) {
                            if (bool == null) {
                                bool = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "OBSOLETE"));
                            }
                        } else if (lowerCase.equals("sup")) {
                            if (str6 == null) {
                                int skipSpaces3 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb2 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces3, length, sb2);
                                str6 = sb2.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "SUP"));
                            }
                        } else if (lowerCase.equals("equality")) {
                            if (str3 == null) {
                                int skipSpaces4 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb3 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces4, length, sb3);
                                str3 = sb3.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "EQUALITY"));
                            }
                        } else if (lowerCase.equals("ordering")) {
                            if (str4 == null) {
                                int skipSpaces5 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb4 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces5, length, sb4);
                                str4 = sb4.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "ORDERING"));
                            }
                        } else if (lowerCase.equals("substr")) {
                            if (str5 == null) {
                                int skipSpaces6 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb5 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces6, length, sb5);
                                str5 = sb5.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "SUBSTR"));
                            }
                        } else if (lowerCase.equals("syntax")) {
                            if (str7 == null) {
                                int skipSpaces7 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb6 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces7, length, sb6);
                                str7 = sb6.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "SYNTAX"));
                            }
                        } else if (lowerCase.equals("single-value")) {
                            if (bool2 == null) {
                                bool2 = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "SINGLE-VALUE"));
                            }
                        } else if (lowerCase.equals("collective")) {
                            if (bool3 == null) {
                                bool3 = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "COLLECTIVE"));
                            }
                        } else if (lowerCase.equals("no-user-modification")) {
                            if (bool4 == null) {
                                bool4 = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "NO-USER-MODIFICATION"));
                            }
                        } else if (lowerCase.equals("usage")) {
                            if (attributeUsage5 == null) {
                                int skipSpaces8 = skipSpaces(this.attributeTypeString, i, length);
                                StringBuilder sb7 = new StringBuilder();
                                readOID = readOID(this.attributeTypeString, skipSpaces8, length, sb7);
                                String lowerCase2 = StaticUtils.toLowerCase(sb7.toString());
                                if (lowerCase2.equals("userapplications")) {
                                    attributeUsage2 = AttributeUsage.USER_APPLICATIONS;
                                } else if (lowerCase2.equals("directoryoperation")) {
                                    attributeUsage2 = AttributeUsage.DIRECTORY_OPERATION;
                                } else if (lowerCase2.equals("distributedoperation")) {
                                    attributeUsage2 = AttributeUsage.DISTRIBUTED_OPERATION;
                                } else if (lowerCase2.equals("dsaoperation")) {
                                    attributeUsage2 = AttributeUsage.DSA_OPERATION;
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_INVALID_USAGE.get(this.attributeTypeString, lowerCase2));
                                }
                                attributeUsage5 = attributeUsage2;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "USAGE"));
                            }
                        } else if (lowerCase.startsWith("x-")) {
                            int skipSpaces9 = skipSpaces(this.attributeTypeString, i, length);
                            ArrayList arrayList2 = new ArrayList();
                            readOID = readQDStrings(this.attributeTypeString, skipSpaces9, length, arrayList2);
                            String[] strArr = new String[arrayList2.size()];
                            arrayList2.toArray(strArr);
                            linkedHashMap2 = linkedHashMap;
                            String str9 = str8;
                            if (!linkedHashMap2.containsKey(str9)) {
                                linkedHashMap2.put(str9, strArr);
                                linkedHashMap3 = linkedHashMap2;
                                attributeUsage3 = attributeUsage5;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_DUP_EXT.get(this.attributeTypeString, str9));
                            }
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_UNEXPECTED_TOKEN.get(this.attributeTypeString, str8));
                        }
                        readOID = i;
                    } else if (str2 == null) {
                        int skipSpaces10 = skipSpaces(this.attributeTypeString, i, length);
                        StringBuilder sb8 = new StringBuilder();
                        readOID = readQDString(this.attributeTypeString, skipSpaces10, length, sb8);
                        str2 = sb8.toString();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS.get(this.attributeTypeString, "DESC"));
                    }
                    linkedHashMap2 = linkedHashMap;
                    linkedHashMap3 = linkedHashMap2;
                    attributeUsage3 = attributeUsage5;
                } else if (i >= length) {
                    this.description = str2;
                    this.equalityMatchingRule = str3;
                    this.orderingMatchingRule = str4;
                    this.substringMatchingRule = str5;
                    this.superiorType = str6;
                    this.syntaxOID = str7;
                    this.names = new String[arrayList.size()];
                    arrayList.toArray(this.names);
                    this.isObsolete = bool != null;
                    this.isSingleValued = bool2 != null;
                    this.isCollective = bool3 != null;
                    this.isNoUserModification = bool4 != null;
                    if (attributeUsage == null) {
                        this.usage = AttributeUsage.USER_APPLICATIONS;
                    } else {
                        this.usage = attributeUsage;
                    }
                    this.extensions = Collections.unmodifiableMap(linkedHashMap);
                    return;
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_CLOSE_NOT_AT_END.get(this.attributeTypeString));
                }
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRTYPE_DECODE_NO_OPENING_PAREN.get(this.attributeTypeString));
        }
    }

    public AttributeTypeDefinition(String str, String[] strArr, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, boolean z2, boolean z3, boolean z4, AttributeUsage attributeUsage, Map<String, String[]> map) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.description = str2;
        this.isObsolete = z;
        this.superiorType = str3;
        this.equalityMatchingRule = str4;
        this.orderingMatchingRule = str5;
        this.substringMatchingRule = str6;
        this.syntaxOID = str7;
        this.isSingleValued = z2;
        this.isCollective = z3;
        this.isNoUserModification = z4;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        if (attributeUsage == null) {
            this.usage = AttributeUsage.USER_APPLICATIONS;
        } else {
            this.usage = attributeUsage;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.attributeTypeString = sb.toString();
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
        if (this.superiorType != null) {
            sb.append(" SUP ");
            sb.append(this.superiorType);
        }
        if (this.equalityMatchingRule != null) {
            sb.append(" EQUALITY ");
            sb.append(this.equalityMatchingRule);
        }
        if (this.orderingMatchingRule != null) {
            sb.append(" ORDERING ");
            sb.append(this.orderingMatchingRule);
        }
        if (this.substringMatchingRule != null) {
            sb.append(" SUBSTR ");
            sb.append(this.substringMatchingRule);
        }
        if (this.syntaxOID != null) {
            sb.append(" SYNTAX ");
            sb.append(this.syntaxOID);
        }
        if (this.isSingleValued) {
            sb.append(" SINGLE-VALUE");
        }
        if (this.isCollective) {
            sb.append(" COLLECTIVE");
        }
        if (this.isNoUserModification) {
            sb.append(" NO-USER-MODIFICATION");
        }
        sb.append(" USAGE ");
        sb.append(this.usage.getName());
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

    public static String getBaseSyntaxOID(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(123);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static int getSyntaxMinimumUpperBound(String str) {
        int indexOf;
        if (str != null && (indexOf = str.indexOf(123)) > 0 && str.endsWith("}")) {
            try {
                return Integer.parseInt(str.substring(indexOf + 1, str.length() - 1));
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeTypeDefinition)) {
            return false;
        }
        AttributeTypeDefinition attributeTypeDefinition = (AttributeTypeDefinition) obj;
        return this.oid.equals(attributeTypeDefinition.oid) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, attributeTypeDefinition.names) && StaticUtils.bothNullOrEqual(this.usage, attributeTypeDefinition.usage) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, attributeTypeDefinition.description) && StaticUtils.bothNullOrEqualIgnoreCase(this.equalityMatchingRule, attributeTypeDefinition.equalityMatchingRule) && StaticUtils.bothNullOrEqualIgnoreCase(this.orderingMatchingRule, attributeTypeDefinition.orderingMatchingRule) && StaticUtils.bothNullOrEqualIgnoreCase(this.substringMatchingRule, attributeTypeDefinition.substringMatchingRule) && StaticUtils.bothNullOrEqualIgnoreCase(this.superiorType, attributeTypeDefinition.superiorType) && StaticUtils.bothNullOrEqualIgnoreCase(this.syntaxOID, attributeTypeDefinition.syntaxOID) && this.isCollective == attributeTypeDefinition.isCollective && this.isNoUserModification == attributeTypeDefinition.isNoUserModification && this.isObsolete == attributeTypeDefinition.isObsolete && this.isSingleValued == attributeTypeDefinition.isSingleValued && extensionsEqual(this.extensions, attributeTypeDefinition.extensions);
    }

    public String getBaseSyntaxOID() {
        return getBaseSyntaxOID(this.syntaxOID);
    }

    public String getBaseSyntaxOID(Schema schema) {
        return getBaseSyntaxOID(getSyntaxOID(schema));
    }

    public String getDescription() {
        return this.description;
    }

    public String getEqualityMatchingRule() {
        return this.equalityMatchingRule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getSuperiorType(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getEqualityMatchingRule(com.unboundid.ldap.sdk.schema.Schema r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.equalityMatchingRule
            if (r0 != 0) goto L_0x000f
            com.unboundid.ldap.sdk.schema.AttributeTypeDefinition r0 = r1.getSuperiorType(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r2 = r0.getEqualityMatchingRule(r2)
            return r2
        L_0x000f:
            java.lang.String r2 = r1.equalityMatchingRule
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.AttributeTypeDefinition.getEqualityMatchingRule(com.unboundid.ldap.sdk.schema.Schema):java.lang.String");
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

    public String getOrderingMatchingRule() {
        return this.orderingMatchingRule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getSuperiorType(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getOrderingMatchingRule(com.unboundid.ldap.sdk.schema.Schema r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.orderingMatchingRule
            if (r0 != 0) goto L_0x000f
            com.unboundid.ldap.sdk.schema.AttributeTypeDefinition r0 = r1.getSuperiorType(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r2 = r0.getOrderingMatchingRule(r2)
            return r2
        L_0x000f:
            java.lang.String r2 = r1.orderingMatchingRule
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.AttributeTypeDefinition.getOrderingMatchingRule(com.unboundid.ldap.sdk.schema.Schema):java.lang.String");
    }

    public String getSubstringMatchingRule() {
        return this.substringMatchingRule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getSuperiorType(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSubstringMatchingRule(com.unboundid.ldap.sdk.schema.Schema r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.substringMatchingRule
            if (r0 != 0) goto L_0x000f
            com.unboundid.ldap.sdk.schema.AttributeTypeDefinition r0 = r1.getSuperiorType(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r2 = r0.getSubstringMatchingRule(r2)
            return r2
        L_0x000f:
            java.lang.String r2 = r1.substringMatchingRule
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.AttributeTypeDefinition.getSubstringMatchingRule(com.unboundid.ldap.sdk.schema.Schema):java.lang.String");
    }

    public AttributeTypeDefinition getSuperiorType(Schema schema) {
        String str = this.superiorType;
        if (str != null) {
            return schema.getAttributeType(str);
        }
        return null;
    }

    public String getSuperiorType() {
        return this.superiorType;
    }

    public int getSyntaxMinimumUpperBound() {
        return getSyntaxMinimumUpperBound(this.syntaxOID);
    }

    public int getSyntaxMinimumUpperBound(Schema schema) {
        return getSyntaxMinimumUpperBound(getSyntaxOID(schema));
    }

    public String getSyntaxOID() {
        return this.syntaxOID;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getSuperiorType(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSyntaxOID(com.unboundid.ldap.sdk.schema.Schema r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.syntaxOID
            if (r0 != 0) goto L_0x000f
            com.unboundid.ldap.sdk.schema.AttributeTypeDefinition r0 = r1.getSuperiorType(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r2 = r0.getSyntaxOID(r2)
            return r2
        L_0x000f:
            java.lang.String r2 = r1.syntaxOID
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.AttributeTypeDefinition.getSyntaxOID(com.unboundid.ldap.sdk.schema.Schema):java.lang.String");
    }

    public AttributeUsage getUsage() {
        return this.usage;
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

    public boolean isCollective() {
        return this.isCollective;
    }

    public boolean isNoUserModification() {
        return this.isNoUserModification;
    }

    public boolean isObsolete() {
        return this.isObsolete;
    }

    public boolean isOperational() {
        return this.usage.isOperational();
    }

    public boolean isSingleValued() {
        return this.isSingleValued;
    }

    public String toString() {
        return this.attributeTypeString;
    }
}
