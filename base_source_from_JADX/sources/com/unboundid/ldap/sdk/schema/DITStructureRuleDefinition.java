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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class DITStructureRuleDefinition extends SchemaElement {
    private static final int[] NO_INTS = new int[0];
    private static final long serialVersionUID = -3233223742542121140L;
    private final String description;
    private final String ditStructureRuleString;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String nameFormID;
    private final String[] names;
    private final int ruleID;
    private final int[] superiorRuleIDs;

    public DITStructureRuleDefinition(int i, String[] strArr, String str, boolean z, String str2, int[] iArr, Map<String, String[]> map) {
        Validator.ensureNotNull(str2);
        this.ruleID = i;
        this.description = str;
        this.isObsolete = z;
        this.nameFormID = str2;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        if (iArr == null) {
            this.superiorRuleIDs = NO_INTS;
        } else {
            this.superiorRuleIDs = iArr;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.ditStructureRuleString = sb.toString();
    }

    public DITStructureRuleDefinition(String str) {
        Validator.ensureNotNull(str);
        this.ditStructureRuleString = str.trim();
        int length = this.ditStructureRuleString.length();
        if (length != 0) {
            boolean z = false;
            if (this.ditStructureRuleString.charAt(0) == '(') {
                int skipSpaces = skipSpaces(this.ditStructureRuleString, 1, length);
                StringBuilder sb = new StringBuilder();
                int readOID = readOID(this.ditStructureRuleString, skipSpaces, length, sb);
                try {
                    this.ruleID = Integer.parseInt(sb.toString());
                    ArrayList arrayList = new ArrayList(1);
                    ArrayList arrayList2 = new ArrayList(1);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    String str2 = null;
                    String str3 = null;
                    Boolean bool = null;
                    while (true) {
                        int skipSpaces2 = skipSpaces(this.ditStructureRuleString, readOID, length);
                        int i = skipSpaces2;
                        while (i < length && this.ditStructureRuleString.charAt(i) != ' ') {
                            i++;
                        }
                        String substring = this.ditStructureRuleString.substring(skipSpaces2, i);
                        String lowerCase = StaticUtils.toLowerCase(substring);
                        if (lowerCase.equals(")")) {
                            if (i >= length) {
                                this.description = str2;
                                this.nameFormID = str3;
                                if (this.nameFormID != null) {
                                    this.names = new String[arrayList2.size()];
                                    arrayList2.toArray(this.names);
                                    this.superiorRuleIDs = new int[arrayList.size()];
                                    int i2 = 0;
                                    while (true) {
                                        int[] iArr = this.superiorRuleIDs;
                                        if (i2 >= iArr.length) {
                                            break;
                                        }
                                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                                        i2++;
                                    }
                                    this.isObsolete = bool != null ? true : z;
                                    this.extensions = Collections.unmodifiableMap(linkedHashMap);
                                    return;
                                }
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_NO_FORM.get(this.ditStructureRuleString));
                            }
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_CLOSE_NOT_AT_END.get(this.ditStructureRuleString));
                        } else if (lowerCase.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                            if (arrayList2.isEmpty()) {
                                readOID = readQDStrings(this.ditStructureRuleString, skipSpaces(this.ditStructureRuleString, i, length), length, arrayList2);
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_MULTIPLE_ELEMENTS.get(this.ditStructureRuleString, "NAME"));
                            }
                        } else if (!lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                            if (lowerCase.equals("obsolete")) {
                                if (bool == null) {
                                    bool = true;
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_MULTIPLE_ELEMENTS.get(this.ditStructureRuleString, "OBSOLETE"));
                                }
                            } else if (lowerCase.equals("form")) {
                                if (str3 == null) {
                                    int skipSpaces3 = skipSpaces(this.ditStructureRuleString, i, length);
                                    StringBuilder sb2 = new StringBuilder();
                                    readOID = readOID(this.ditStructureRuleString, skipSpaces3, length, sb2);
                                    str3 = sb2.toString();
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_MULTIPLE_ELEMENTS.get(this.ditStructureRuleString, "FORM"));
                                }
                            } else if (lowerCase.equals("sup")) {
                                if (arrayList.isEmpty()) {
                                    ArrayList arrayList3 = new ArrayList(1);
                                    i = readOIDs(this.ditStructureRuleString, skipSpaces(this.ditStructureRuleString, i, length), length, arrayList3);
                                    arrayList.ensureCapacity(arrayList3.size());
                                    Iterator it = arrayList3.iterator();
                                    while (it.hasNext()) {
                                        try {
                                            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
                                        } catch (NumberFormatException e) {
                                            Debug.debugException(e);
                                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_SUP_ID_NOT_INT.get(this.ditStructureRuleString), e);
                                        }
                                    }
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_MULTIPLE_ELEMENTS.get(this.ditStructureRuleString, "SUP"));
                                }
                            } else if (lowerCase.startsWith("x-")) {
                                int skipSpaces4 = skipSpaces(this.ditStructureRuleString, i, length);
                                ArrayList arrayList4 = new ArrayList();
                                i = readQDStrings(this.ditStructureRuleString, skipSpaces4, length, arrayList4);
                                String[] strArr = new String[arrayList4.size()];
                                arrayList4.toArray(strArr);
                                if (!linkedHashMap.containsKey(substring)) {
                                    linkedHashMap.put(substring, strArr);
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_DUP_EXT.get(this.ditStructureRuleString, substring));
                                }
                            } else {
                                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_UNEXPECTED_TOKEN.get(this.ditStructureRuleString, substring));
                            }
                            readOID = i;
                        } else if (str2 == null) {
                            int skipSpaces5 = skipSpaces(this.ditStructureRuleString, i, length);
                            StringBuilder sb3 = new StringBuilder();
                            readOID = readQDString(this.ditStructureRuleString, skipSpaces5, length, sb3);
                            str2 = sb3.toString();
                        } else {
                            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_MULTIPLE_ELEMENTS.get(this.ditStructureRuleString, "DESC"));
                        }
                    }
                } catch (NumberFormatException e2) {
                    Debug.debugException(e2);
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_RULE_ID_NOT_INT.get(this.ditStructureRuleString), e2);
                }
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_NO_OPENING_PAREN.get(this.ditStructureRuleString));
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_DSR_DECODE_EMPTY.get());
        }
    }

    private void createDefinitionString(StringBuilder sb) {
        sb.append("( ");
        sb.append(this.ruleID);
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
        sb.append(" FORM ");
        sb.append(this.nameFormID);
        int[] iArr = this.superiorRuleIDs;
        if (iArr.length == 1) {
            sb.append(" SUP ");
            sb.append(this.superiorRuleIDs[0]);
        } else if (iArr.length > 1) {
            sb.append(" SUP (");
            for (int append2 : this.superiorRuleIDs) {
                sb.append(" $ ");
                sb.append(append2);
            }
            sb.append(" )");
        }
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
        if (!(obj instanceof DITStructureRuleDefinition)) {
            return false;
        }
        DITStructureRuleDefinition dITStructureRuleDefinition = (DITStructureRuleDefinition) obj;
        if (this.ruleID != dITStructureRuleDefinition.ruleID || !this.nameFormID.equalsIgnoreCase(dITStructureRuleDefinition.nameFormID) || !StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, dITStructureRuleDefinition.names) || this.isObsolete != dITStructureRuleDefinition.isObsolete || !extensionsEqual(this.extensions, dITStructureRuleDefinition.extensions)) {
            return false;
        }
        int[] iArr = this.superiorRuleIDs;
        if (iArr.length != dITStructureRuleDefinition.superiorRuleIDs.length) {
            return false;
        }
        HashSet hashSet = new HashSet(iArr.length);
        HashSet hashSet2 = new HashSet(this.superiorRuleIDs.length);
        for (int valueOf : this.superiorRuleIDs) {
            hashSet.add(Integer.valueOf(valueOf));
        }
        for (int valueOf2 : dITStructureRuleDefinition.superiorRuleIDs) {
            hashSet2.add(Integer.valueOf(valueOf2));
        }
        return hashSet.equals(hashSet2);
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String[]> getExtensions() {
        return this.extensions;
    }

    public String getNameFormID() {
        return this.nameFormID;
    }

    public String getNameOrRuleID() {
        String[] strArr = this.names;
        return strArr.length == 0 ? String.valueOf(this.ruleID) : strArr[0];
    }

    public String[] getNames() {
        return this.names;
    }

    public int getRuleID() {
        return this.ruleID;
    }

    public int[] getSuperiorRuleIDs() {
        return this.superiorRuleIDs;
    }

    public boolean hasNameOrRuleID(String str) {
        for (String equalsIgnoreCase : this.names) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return str.equalsIgnoreCase(String.valueOf(this.ruleID));
    }

    public int hashCode() {
        return this.ruleID;
    }

    public boolean isObsolete() {
        return this.isObsolete;
    }

    public String toString() {
        return this.ditStructureRuleString;
    }
}
