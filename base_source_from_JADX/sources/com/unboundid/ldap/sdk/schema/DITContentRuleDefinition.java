package com.unboundid.ldap.sdk.schema;

import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Collections;
import java.util.Map;

public final class DITContentRuleDefinition extends SchemaElement {
    private static final long serialVersionUID = 3224440505307817586L;
    private final String[] auxiliaryClasses;
    private final String description;
    private final String ditContentRuleString;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String[] names;
    private final String oid;
    private final String[] optionalAttributes;
    private final String[] prohibitedAttributes;
    private final String[] requiredAttributes;

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DITContentRuleDefinition(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r16.<init>()
            com.unboundid.util.Validator.ensureNotNull(r17)
            java.lang.String r1 = r17.trim()
            r0.ditContentRuleString = r1
            java.lang.String r1 = r0.ditContentRuleString
            int r1 = r1.length()
            if (r1 == 0) goto L_0x02d0
            java.lang.String r2 = r0.ditContentRuleString
            r3 = 0
            char r2 = r2.charAt(r3)
            r4 = 40
            r5 = 1
            if (r2 != r4) goto L_0x02ba
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r5, r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.ditContentRuleString
            int r2 = readOID(r6, r2, r1, r4)
            java.lang.String r4 = r4.toString()
            r0.oid = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            r11 = 0
            r12 = r11
        L_0x0059:
            java.lang.String r13 = r0.ditContentRuleString
            int r2 = skipSpaces(r13, r2, r1)
            r13 = r2
        L_0x0060:
            if (r13 >= r1) goto L_0x006f
            java.lang.String r14 = r0.ditContentRuleString
            char r14 = r14.charAt(r13)
            r15 = 32
            if (r14 == r15) goto L_0x006f
            int r13 = r13 + 1
            goto L_0x0060
        L_0x006f:
            java.lang.String r14 = r0.ditContentRuleString
            java.lang.String r2 = r14.substring(r2, r13)
            java.lang.String r14 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            java.lang.String r15 = ")"
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00e6
            if (r13 < r1) goto L_0x00d2
            r0.description = r11
            int r1 = r4.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.names = r1
            java.lang.String[] r1 = r0.names
            r4.toArray(r1)
            int r1 = r9.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.auxiliaryClasses = r1
            java.lang.String[] r1 = r0.auxiliaryClasses
            r9.toArray(r1)
            int r1 = r6.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.requiredAttributes = r1
            java.lang.String[] r1 = r0.requiredAttributes
            r6.toArray(r1)
            int r1 = r7.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.optionalAttributes = r1
            java.lang.String[] r1 = r0.optionalAttributes
            r7.toArray(r1)
            int r1 = r8.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.prohibitedAttributes = r1
            java.lang.String[] r1 = r0.prohibitedAttributes
            r8.toArray(r1)
            if (r12 == 0) goto L_0x00c9
            r3 = 1
        L_0x00c9:
            r0.isObsolete = r3
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r10)
            r0.extensions = r1
            return
        L_0x00d2:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_CLOSE_NOT_AT_END
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.ditContentRuleString
            r5[r3] = r6
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x00e6:
            java.lang.String r15 = "name"
            boolean r15 = r14.equals(r15)
            r5 = 2
            if (r15 == 0) goto L_0x011c
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0103
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r5 = r0.ditContentRuleString
            int r2 = readQDStrings(r5, r2, r1, r4)
            goto L_0x0286
        L_0x0103:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.ditContentRuleString
            r5[r3] = r6
            java.lang.String r3 = "NAME"
            r6 = 1
            r5[r6] = r3
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x011c:
            java.lang.String r15 = "desc"
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x0157
            if (r11 != 0) goto L_0x013e
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = r0.ditContentRuleString
            int r2 = readQDString(r11, r2, r1, r5)
            java.lang.String r5 = r5.toString()
            r11 = r5
            goto L_0x0286
        L_0x013e:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.ditContentRuleString
            r5[r3] = r6
            java.lang.String r3 = "DESC"
            r15 = 1
            r5[r15] = r3
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0157:
            r15 = 1
            java.lang.String r3 = "obsolete"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x0183
            if (r12 != 0) goto L_0x016a
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            r12 = r2
            r2 = r13
            goto L_0x0286
        L_0x016a:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.ditContentRuleString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "OBSOLETE"
            r4[r15] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0183:
            java.lang.String r3 = "aux"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01b9
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x019f
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.ditContentRuleString
            int r2 = readOIDs(r3, r2, r1, r9)
            goto L_0x0286
        L_0x019f:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.ditContentRuleString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "AUX"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x01b9:
            java.lang.String r3 = "must"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01ef
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L_0x01d5
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.ditContentRuleString
            int r2 = readOIDs(r3, r2, r1, r6)
            goto L_0x0286
        L_0x01d5:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.ditContentRuleString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "MUST"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x01ef:
            java.lang.String r3 = "may"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x0225
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x020b
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.ditContentRuleString
            int r2 = readOIDs(r3, r2, r1, r7)
            goto L_0x0286
        L_0x020b:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.ditContentRuleString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "MAY"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0225:
            java.lang.String r3 = "not"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x025a
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L_0x0240
            java.lang.String r2 = r0.ditContentRuleString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.ditContentRuleString
            int r2 = readOIDs(r3, r2, r1, r8)
            goto L_0x0286
        L_0x0240:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.ditContentRuleString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "NOT"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x025a:
            java.lang.String r3 = "x-"
            boolean r3 = r14.startsWith(r3)
            if (r3 == 0) goto L_0x02a2
            java.lang.String r3 = r0.ditContentRuleString
            int r3 = skipSpaces(r3, r13, r1)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.lang.String r14 = r0.ditContentRuleString
            int r3 = readQDStrings(r14, r3, r1, r13)
            int r14 = r13.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r13.toArray(r14)
            boolean r13 = r10.containsKey(r2)
            if (r13 != 0) goto L_0x028a
            r10.put(r2, r14)
            r2 = r3
        L_0x0286:
            r3 = 0
            r5 = 1
            goto L_0x0059
        L_0x028a:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_DUP_EXT
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.ditContentRuleString
            r7 = 0
            r5[r7] = r6
            r6 = 1
            r5[r6] = r2
            java.lang.String r2 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r2)
            throw r1
        L_0x02a2:
            r6 = 1
            r7 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_DUP_EXT
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r8 = r0.ditContentRuleString
            r5[r7] = r8
            r5[r6] = r2
            java.lang.String r2 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r2)
            throw r1
        L_0x02ba:
            r6 = 1
            r7 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_NO_OPENING_PAREN
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.String r5 = r0.ditContentRuleString
            r4[r7] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02d0:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_DCR_DECODE_EMPTY
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.DITContentRuleDefinition.<init>(java.lang.String):void");
    }

    public DITContentRuleDefinition(String str, String[] strArr, String str2, boolean z, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, Map<String, String[]> map) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.isObsolete = z;
        this.description = str2;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        if (strArr2 == null) {
            this.auxiliaryClasses = StaticUtils.NO_STRINGS;
        } else {
            this.auxiliaryClasses = strArr2;
        }
        if (strArr3 == null) {
            this.requiredAttributes = StaticUtils.NO_STRINGS;
        } else {
            this.requiredAttributes = strArr3;
        }
        if (strArr4 == null) {
            this.optionalAttributes = StaticUtils.NO_STRINGS;
        } else {
            this.optionalAttributes = strArr4;
        }
        if (strArr5 == null) {
            this.prohibitedAttributes = StaticUtils.NO_STRINGS;
        } else {
            this.prohibitedAttributes = strArr5;
        }
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.ditContentRuleString = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0152  */
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
            java.lang.String[] r0 = r10.auxiliaryClasses
            int r1 = r0.length
            r5 = 32
            if (r1 != r4) goto L_0x0074
            java.lang.String r0 = " AUX "
            r11.append(r0)
            java.lang.String[] r0 = r10.auxiliaryClasses
            r0 = r0[r3]
        L_0x0070:
            r11.append(r0)
            goto L_0x009a
        L_0x0074:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x009a
            java.lang.String r0 = " AUX ("
            r11.append(r0)
            r0 = 0
        L_0x007d:
            java.lang.String[] r1 = r10.auxiliaryClasses
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0097
            if (r0 <= 0) goto L_0x008a
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x008d
        L_0x008a:
            r11.append(r5)
        L_0x008d:
            java.lang.String[] r1 = r10.auxiliaryClasses
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x0097:
            java.lang.String r0 = " )"
            goto L_0x0070
        L_0x009a:
            java.lang.String[] r0 = r10.requiredAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x00ac
            java.lang.String r0 = " MUST "
            r11.append(r0)
            java.lang.String[] r0 = r10.requiredAttributes
            r0 = r0[r3]
        L_0x00a8:
            r11.append(r0)
            goto L_0x00d2
        L_0x00ac:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x00d2
            java.lang.String r0 = " MUST ("
            r11.append(r0)
            r0 = 0
        L_0x00b5:
            java.lang.String[] r1 = r10.requiredAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00cf
            if (r0 <= 0) goto L_0x00c2
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x00c5
        L_0x00c2:
            r11.append(r5)
        L_0x00c5:
            java.lang.String[] r1 = r10.requiredAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x00b5
        L_0x00cf:
            java.lang.String r0 = " )"
            goto L_0x00a8
        L_0x00d2:
            java.lang.String[] r0 = r10.optionalAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x00e4
            java.lang.String r0 = " MAY "
            r11.append(r0)
            java.lang.String[] r0 = r10.optionalAttributes
            r0 = r0[r3]
        L_0x00e0:
            r11.append(r0)
            goto L_0x010a
        L_0x00e4:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x010a
            java.lang.String r0 = " MAY ("
            r11.append(r0)
            r0 = 0
        L_0x00ed:
            java.lang.String[] r1 = r10.optionalAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0107
            if (r0 <= 0) goto L_0x00fa
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x00fd
        L_0x00fa:
            r11.append(r5)
        L_0x00fd:
            java.lang.String[] r1 = r10.optionalAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x00ed
        L_0x0107:
            java.lang.String r0 = " )"
            goto L_0x00e0
        L_0x010a:
            java.lang.String[] r0 = r10.prohibitedAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x011c
            java.lang.String r0 = " NOT "
            r11.append(r0)
            java.lang.String[] r0 = r10.prohibitedAttributes
            r0 = r0[r3]
        L_0x0118:
            r11.append(r0)
            goto L_0x0142
        L_0x011c:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x0142
            java.lang.String r0 = " NOT ("
            r11.append(r0)
            r0 = 0
        L_0x0125:
            java.lang.String[] r1 = r10.prohibitedAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x013f
            if (r0 <= 0) goto L_0x0132
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x0135
        L_0x0132:
            r11.append(r5)
        L_0x0135:
            java.lang.String[] r1 = r10.prohibitedAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x0125
        L_0x013f:
            java.lang.String r0 = " )"
            goto L_0x0118
        L_0x0142:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r10.extensions
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x014c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01a0
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r1.getValue()
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 != r4) goto L_0x017b
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " '"
            r11.append(r6)
            r1 = r1[r3]
            encodeValue(r1, r11)
            r11.append(r2)
            goto L_0x014c
        L_0x017b:
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " ("
            r11.append(r6)
            int r6 = r1.length
            r7 = 0
        L_0x0188:
            if (r7 >= r6) goto L_0x019a
            r8 = r1[r7]
            java.lang.String r9 = " '"
            r11.append(r9)
            encodeValue(r8, r11)
            r11.append(r2)
            int r7 = r7 + 1
            goto L_0x0188
        L_0x019a:
            java.lang.String r1 = " )"
            r11.append(r1)
            goto L_0x014c
        L_0x01a0:
            java.lang.String r0 = " )"
            r11.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.DITContentRuleDefinition.createDefinitionString(java.lang.StringBuilder):void");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DITContentRuleDefinition)) {
            return false;
        }
        DITContentRuleDefinition dITContentRuleDefinition = (DITContentRuleDefinition) obj;
        return this.oid.equals(dITContentRuleDefinition.oid) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, dITContentRuleDefinition.names) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.auxiliaryClasses, dITContentRuleDefinition.auxiliaryClasses) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.requiredAttributes, dITContentRuleDefinition.requiredAttributes) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.optionalAttributes, dITContentRuleDefinition.optionalAttributes) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.prohibitedAttributes, dITContentRuleDefinition.prohibitedAttributes) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, dITContentRuleDefinition.description) && this.isObsolete == dITContentRuleDefinition.isObsolete && extensionsEqual(this.extensions, dITContentRuleDefinition.extensions);
    }

    public String[] getAuxiliaryClasses() {
        return this.auxiliaryClasses;
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

    public String[] getProhibitedAttributes() {
        return this.prohibitedAttributes;
    }

    public String[] getRequiredAttributes() {
        return this.requiredAttributes;
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
        return this.ditContentRuleString;
    }
}
