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

public final class MatchingRuleUseDefinition extends SchemaElement {
    private static final long serialVersionUID = 2366143311976256897L;
    private final String[] applicableTypes;
    private final String description;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String matchingRuleUseString;
    private final String[] names;
    private final String oid;

    public MatchingRuleUseDefinition(String str) {
        Validator.ensureNotNull(str);
        this.matchingRuleUseString = str.trim();
        int length = this.matchingRuleUseString.length();
        if (length != 0) {
            boolean z = false;
            if (this.matchingRuleUseString.charAt(0) == '(') {
                int skipSpaces = skipSpaces(this.matchingRuleUseString, 1, length);
                StringBuilder sb = new StringBuilder();
                int readOID = readOID(this.matchingRuleUseString, skipSpaces, length, sb);
                this.oid = sb.toString();
                ArrayList arrayList = new ArrayList(1);
                ArrayList arrayList2 = new ArrayList(1);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str2 = null;
                Boolean bool = null;
                while (true) {
                    int skipSpaces2 = skipSpaces(this.matchingRuleUseString, readOID, length);
                    int i = skipSpaces2;
                    while (i < length && this.matchingRuleUseString.charAt(i) != ' ') {
                        i++;
                    }
                    String substring = this.matchingRuleUseString.substring(skipSpaces2, i);
                    String lowerCase = StaticUtils.toLowerCase(substring);
                    if (lowerCase.equals(")")) {
                        if (i >= length) {
                            this.description = str2;
                            this.names = new String[arrayList.size()];
                            arrayList.toArray(this.names);
                            if (!arrayList2.isEmpty()) {
                                this.applicableTypes = new String[arrayList2.size()];
                                arrayList2.toArray(this.applicableTypes);
                                this.isObsolete = bool != null ? true : z;
                                this.extensions = Collections.unmodifiableMap(linkedHashMap);
                                return;
                            }
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_NO_APPLIES.get(this.matchingRuleUseString));
                        }
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_CLOSE_NOT_AT_END.get(this.matchingRuleUseString));
                    } else if (lowerCase.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        if (arrayList.isEmpty()) {
                            readOID = readQDStrings(this.matchingRuleUseString, skipSpaces(this.matchingRuleUseString, i, length), length, arrayList);
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleUseString, "NAME"));
                        }
                    } else if (!lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                        if (lowerCase.equals("obsolete")) {
                            if (bool == null) {
                                bool = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleUseString, "OBSOLETE"));
                            }
                        } else if (lowerCase.equals("applies")) {
                            if (arrayList2.isEmpty()) {
                                readOID = readOIDs(this.matchingRuleUseString, skipSpaces(this.matchingRuleUseString, i, length), length, arrayList2);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleUseString, "APPLIES"));
                            }
                        } else if (lowerCase.startsWith("x-")) {
                            int skipSpaces3 = skipSpaces(this.matchingRuleUseString, i, length);
                            ArrayList arrayList3 = new ArrayList();
                            i = readQDStrings(this.matchingRuleUseString, skipSpaces3, length, arrayList3);
                            String[] strArr = new String[arrayList3.size()];
                            arrayList3.toArray(strArr);
                            if (!linkedHashMap.containsKey(substring)) {
                                linkedHashMap.put(substring, strArr);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_DUP_EXT.get(this.matchingRuleUseString, substring));
                            }
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_UNEXPECTED_TOKEN.get(this.matchingRuleUseString, substring));
                        }
                        readOID = i;
                    } else if (str2 == null) {
                        int skipSpaces4 = skipSpaces(this.matchingRuleUseString, i, length);
                        StringBuilder sb2 = new StringBuilder();
                        readOID = readQDString(this.matchingRuleUseString, skipSpaces4, length, sb2);
                        str2 = sb2.toString();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_MULTIPLE_ELEMENTS.get(this.matchingRuleUseString, "DESC"));
                    }
                }
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_NO_OPENING_PAREN.get(this.matchingRuleUseString));
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_MRU_DECODE_EMPTY.get());
        }
    }

    public MatchingRuleUseDefinition(String str, String[] strArr, String str2, boolean z, String[] strArr2, Map<String, String[]> map) {
        Validator.ensureNotNull(str, strArr2);
        Validator.ensureFalse(strArr2.length == 0);
        this.oid = str;
        this.description = str2;
        this.isObsolete = z;
        this.applicableTypes = strArr2;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.matchingRuleUseString = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createDefinitionString(java.lang.StringBuilder r11) {
        /*
            r10 = this;
            java.lang.String r0 = "( "
            r11.append(r0)
            java.lang.String r0 = r10.oid
            r11.append(r0)
            java.lang.String[] r0 = r10.names
            int r1 = r0.length
            r2 = 39
            r3 = 0
            r4 = 1
            if (r1 != r4) goto L_0x0023
            java.lang.String r0 = " NAME '"
            r11.append(r0)
            java.lang.String[] r0 = r10.names
            r0 = r0[r3]
            r11.append(r0)
            r11.append(r2)
            goto L_0x0046
        L_0x0023:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x0046
            java.lang.String r0 = " NAME ("
            r11.append(r0)
            java.lang.String[] r0 = r10.names
            int r1 = r0.length
            r5 = 0
        L_0x002f:
            if (r5 >= r1) goto L_0x0041
            r6 = r0[r5]
            java.lang.String r7 = " '"
            r11.append(r7)
            r11.append(r6)
            r11.append(r2)
            int r5 = r5 + 1
            goto L_0x002f
        L_0x0041:
            java.lang.String r0 = " )"
            r11.append(r0)
        L_0x0046:
            java.lang.String r0 = r10.description
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = " DESC '"
            r11.append(r0)
            java.lang.String r0 = r10.description
            encodeValue(r0, r11)
            r11.append(r2)
        L_0x0057:
            boolean r0 = r10.isObsolete
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = " OBSOLETE"
            r11.append(r0)
        L_0x0060:
            java.lang.String[] r0 = r10.applicableTypes
            int r1 = r0.length
            r5 = 32
            if (r1 != r4) goto L_0x0074
            java.lang.String r0 = " APPLIES "
            r11.append(r0)
            java.lang.String[] r0 = r10.applicableTypes
            r0 = r0[r3]
        L_0x0070:
            r11.append(r0)
            goto L_0x0099
        L_0x0074:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x0099
            java.lang.String r0 = " APPLIES ("
            r11.append(r0)
            r0 = 0
        L_0x007d:
            java.lang.String[] r1 = r10.applicableTypes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0096
            if (r0 <= 0) goto L_0x0089
            java.lang.String r1 = " $"
            r11.append(r1)
        L_0x0089:
            r11.append(r5)
            java.lang.String[] r1 = r10.applicableTypes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x0096:
            java.lang.String r0 = " )"
            goto L_0x0070
        L_0x0099:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r10.extensions
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00a3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f7
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r1.getValue()
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 != r4) goto L_0x00d2
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " '"
            r11.append(r6)
            r1 = r1[r3]
            encodeValue(r1, r11)
            r11.append(r2)
            goto L_0x00a3
        L_0x00d2:
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " ("
            r11.append(r6)
            int r6 = r1.length
            r7 = 0
        L_0x00df:
            if (r7 >= r6) goto L_0x00f1
            r8 = r1[r7]
            java.lang.String r9 = " '"
            r11.append(r9)
            encodeValue(r8, r11)
            r11.append(r2)
            int r7 = r7 + 1
            goto L_0x00df
        L_0x00f1:
            java.lang.String r1 = " )"
            r11.append(r1)
            goto L_0x00a3
        L_0x00f7:
            java.lang.String r0 = " )"
            r11.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.MatchingRuleUseDefinition.createDefinitionString(java.lang.StringBuilder):void");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchingRuleUseDefinition)) {
            return false;
        }
        MatchingRuleUseDefinition matchingRuleUseDefinition = (MatchingRuleUseDefinition) obj;
        return this.oid.equals(matchingRuleUseDefinition.oid) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, matchingRuleUseDefinition.names) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.applicableTypes, matchingRuleUseDefinition.applicableTypes) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, matchingRuleUseDefinition.description) && this.isObsolete == matchingRuleUseDefinition.isObsolete && extensionsEqual(this.extensions, matchingRuleUseDefinition.extensions);
    }

    public String[] getApplicableAttributeTypes() {
        return this.applicableTypes;
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
        return this.matchingRuleUseString;
    }
}
