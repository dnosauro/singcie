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

public final class NameFormDefinition extends SchemaElement {
    private static final long serialVersionUID = -816231530223449984L;
    private final String description;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String nameFormString;
    private final String[] names;
    private final String oid;
    private final String[] optionalAttributes;
    private final String[] requiredAttributes;
    private final String structuralClass;

    public NameFormDefinition(String str) {
        Validator.ensureNotNull(str);
        this.nameFormString = str.trim();
        int length = this.nameFormString.length();
        if (length != 0) {
            boolean z = false;
            if (this.nameFormString.charAt(0) == '(') {
                int skipSpaces = skipSpaces(this.nameFormString, 1, length);
                StringBuilder sb = new StringBuilder();
                int readOID = readOID(this.nameFormString, skipSpaces, length, sb);
                this.oid = sb.toString();
                ArrayList arrayList = new ArrayList(1);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str2 = null;
                String str3 = null;
                Boolean bool = null;
                while (true) {
                    int skipSpaces2 = skipSpaces(this.nameFormString, readOID, length);
                    int i = skipSpaces2;
                    while (i < length && this.nameFormString.charAt(i) != ' ') {
                        i++;
                    }
                    String substring = this.nameFormString.substring(skipSpaces2, i);
                    String lowerCase = StaticUtils.toLowerCase(substring);
                    if (lowerCase.equals(")")) {
                        if (i >= length) {
                            this.description = str2;
                            this.structuralClass = str3;
                            if (this.structuralClass != null) {
                                this.names = new String[arrayList.size()];
                                arrayList.toArray(this.names);
                                this.requiredAttributes = new String[arrayList2.size()];
                                arrayList2.toArray(this.requiredAttributes);
                                if (!arrayList2.isEmpty()) {
                                    this.optionalAttributes = new String[arrayList3.size()];
                                    arrayList3.toArray(this.optionalAttributes);
                                    this.isObsolete = bool != null ? true : z;
                                    this.extensions = Collections.unmodifiableMap(linkedHashMap);
                                    return;
                                }
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_NO_MUST.get(this.nameFormString));
                            }
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_NO_OC.get(this.nameFormString));
                        }
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_CLOSE_NOT_AT_END.get(this.nameFormString));
                    } else if (lowerCase.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        if (arrayList.isEmpty()) {
                            readOID = readQDStrings(this.nameFormString, skipSpaces(this.nameFormString, i, length), length, arrayList);
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "NAME"));
                        }
                    } else if (!lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                        if (lowerCase.equals("obsolete")) {
                            if (bool == null) {
                                bool = true;
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "OBSOLETE"));
                            }
                        } else if (lowerCase.equals("oc")) {
                            if (str3 == null) {
                                int skipSpaces3 = skipSpaces(this.nameFormString, i, length);
                                StringBuilder sb2 = new StringBuilder();
                                readOID = readOID(this.nameFormString, skipSpaces3, length, sb2);
                                str3 = sb2.toString();
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "OC"));
                            }
                        } else if (lowerCase.equals("must")) {
                            if (arrayList2.isEmpty()) {
                                readOID = readOIDs(this.nameFormString, skipSpaces(this.nameFormString, i, length), length, arrayList2);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "MUST"));
                            }
                        } else if (lowerCase.equals("may")) {
                            if (arrayList3.isEmpty()) {
                                readOID = readOIDs(this.nameFormString, skipSpaces(this.nameFormString, i, length), length, arrayList3);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "MAY"));
                            }
                        } else if (lowerCase.startsWith("x-")) {
                            int skipSpaces4 = skipSpaces(this.nameFormString, i, length);
                            ArrayList arrayList4 = new ArrayList();
                            i = readQDStrings(this.nameFormString, skipSpaces4, length, arrayList4);
                            String[] strArr = new String[arrayList4.size()];
                            arrayList4.toArray(strArr);
                            if (!linkedHashMap.containsKey(substring)) {
                                linkedHashMap.put(substring, strArr);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_DUP_EXT.get(this.nameFormString, substring));
                            }
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_UNEXPECTED_TOKEN.get(this.nameFormString, substring));
                        }
                        readOID = i;
                    } else if (str2 == null) {
                        int skipSpaces5 = skipSpaces(this.nameFormString, i, length);
                        StringBuilder sb3 = new StringBuilder();
                        readOID = readQDString(this.nameFormString, skipSpaces5, length, sb3);
                        str2 = sb3.toString();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_MULTIPLE_ELEMENTS.get(this.nameFormString, "DESC"));
                    }
                }
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_NO_OPENING_PAREN.get(this.nameFormString));
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_NF_DECODE_EMPTY.get());
        }
    }

    public NameFormDefinition(String str, String[] strArr, String str2, boolean z, String str3, String[] strArr2, String[] strArr3, Map<String, String[]> map) {
        Validator.ensureNotNull(str, str3, strArr2);
        Validator.ensureFalse(strArr2.length == 0);
        this.oid = str;
        this.isObsolete = z;
        this.description = str2;
        this.structuralClass = str3;
        this.requiredAttributes = strArr2;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        if (strArr3 == null) {
            this.optionalAttributes = StaticUtils.NO_STRINGS;
        } else {
            this.optionalAttributes = strArr3;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.nameFormString = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
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
            java.lang.String r0 = " OC "
            r11.append(r0)
            java.lang.String r0 = r10.structuralClass
            r11.append(r0)
            java.lang.String[] r0 = r10.requiredAttributes
            int r1 = r0.length
            r5 = 32
            if (r1 != r4) goto L_0x007e
            java.lang.String r0 = " MUST "
            r11.append(r0)
            java.lang.String[] r0 = r10.requiredAttributes
            r0 = r0[r3]
        L_0x007a:
            r11.append(r0)
            goto L_0x00a4
        L_0x007e:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x00a4
            java.lang.String r0 = " MUST ("
            r11.append(r0)
            r0 = 0
        L_0x0087:
            java.lang.String[] r1 = r10.requiredAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00a1
            if (r0 <= 0) goto L_0x0094
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x0097
        L_0x0094:
            r11.append(r5)
        L_0x0097:
            java.lang.String[] r1 = r10.requiredAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x0087
        L_0x00a1:
            java.lang.String r0 = " )"
            goto L_0x007a
        L_0x00a4:
            java.lang.String[] r0 = r10.optionalAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x00b6
            java.lang.String r0 = " MAY "
            r11.append(r0)
            java.lang.String[] r0 = r10.optionalAttributes
            r0 = r0[r3]
        L_0x00b2:
            r11.append(r0)
            goto L_0x00dc
        L_0x00b6:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x00dc
            java.lang.String r0 = " MAY ("
            r11.append(r0)
            r0 = 0
        L_0x00bf:
            java.lang.String[] r1 = r10.optionalAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00d9
            if (r0 <= 0) goto L_0x00cc
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x00cf
        L_0x00cc:
            r11.append(r5)
        L_0x00cf:
            java.lang.String[] r1 = r10.optionalAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x00bf
        L_0x00d9:
            java.lang.String r0 = " )"
            goto L_0x00b2
        L_0x00dc:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r10.extensions
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00e6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x013a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r1.getValue()
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 != r4) goto L_0x0115
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " '"
            r11.append(r6)
            r1 = r1[r3]
            encodeValue(r1, r11)
            r11.append(r2)
            goto L_0x00e6
        L_0x0115:
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " ("
            r11.append(r6)
            int r6 = r1.length
            r7 = 0
        L_0x0122:
            if (r7 >= r6) goto L_0x0134
            r8 = r1[r7]
            java.lang.String r9 = " '"
            r11.append(r9)
            encodeValue(r8, r11)
            r11.append(r2)
            int r7 = r7 + 1
            goto L_0x0122
        L_0x0134:
            java.lang.String r1 = " )"
            r11.append(r1)
            goto L_0x00e6
        L_0x013a:
            java.lang.String r0 = " )"
            r11.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.NameFormDefinition.createDefinitionString(java.lang.StringBuilder):void");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NameFormDefinition)) {
            return false;
        }
        NameFormDefinition nameFormDefinition = (NameFormDefinition) obj;
        return this.oid.equals(nameFormDefinition.oid) && this.structuralClass.equalsIgnoreCase(nameFormDefinition.structuralClass) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, nameFormDefinition.names) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.requiredAttributes, nameFormDefinition.requiredAttributes) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.optionalAttributes, nameFormDefinition.optionalAttributes) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, nameFormDefinition.description) && this.isObsolete == nameFormDefinition.isObsolete && extensionsEqual(this.extensions, nameFormDefinition.extensions);
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

    public String[] getOptionalAttributes() {
        return this.optionalAttributes;
    }

    public String[] getRequiredAttributes() {
        return this.requiredAttributes;
    }

    public String getStructuralClass() {
        return this.structuralClass;
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
        return this.nameFormString;
    }
}
