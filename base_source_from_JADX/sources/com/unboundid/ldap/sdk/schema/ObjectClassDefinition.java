package com.unboundid.ldap.sdk.schema;

import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class ObjectClassDefinition extends SchemaElement {
    private static final long serialVersionUID = -3024333376249332728L;
    private final String description;
    private final Map<String, String[]> extensions;
    private final boolean isObsolete;
    private final String[] names;
    private final String objectClassString;
    private final ObjectClassType objectClassType;
    private final String oid;
    private final String[] optionalAttributes;
    private final String[] requiredAttributes;
    private final String[] superiorClasses;

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ObjectClassDefinition(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r16.<init>()
            com.unboundid.util.Validator.ensureNotNull(r17)
            java.lang.String r1 = r17.trim()
            r0.objectClassString = r1
            java.lang.String r1 = r0.objectClassString
            int r1 = r1.length()
            if (r1 == 0) goto L_0x02f5
            java.lang.String r2 = r0.objectClassString
            r3 = 0
            char r2 = r2.charAt(r3)
            r4 = 40
            r5 = 1
            if (r2 != r4) goto L_0x02df
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r5, r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r0.objectClassString
            int r2 = readOID(r6, r2, r1, r4)
            java.lang.String r4 = r4.toString()
            r0.oid = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r5)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r5)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            r10 = 0
            r11 = r10
            r12 = r11
        L_0x0055:
            java.lang.String r13 = r0.objectClassString
            int r2 = skipSpaces(r13, r2, r1)
            r13 = r2
        L_0x005c:
            if (r13 >= r1) goto L_0x006b
            java.lang.String r14 = r0.objectClassString
            char r14 = r14.charAt(r13)
            r15 = 32
            if (r14 == r15) goto L_0x006b
            int r13 = r13 + 1
            goto L_0x005c
        L_0x006b:
            java.lang.String r14 = r0.objectClassString
            java.lang.String r2 = r14.substring(r2, r13)
            java.lang.String r14 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            java.lang.String r15 = ")"
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x00d7
            if (r13 < r1) goto L_0x00c3
            r0.description = r10
            int r1 = r4.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.names = r1
            java.lang.String[] r1 = r0.names
            r4.toArray(r1)
            int r1 = r6.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.superiorClasses = r1
            java.lang.String[] r1 = r0.superiorClasses
            r6.toArray(r1)
            int r1 = r7.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.requiredAttributes = r1
            java.lang.String[] r1 = r0.requiredAttributes
            r7.toArray(r1)
            int r1 = r8.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.optionalAttributes = r1
            java.lang.String[] r1 = r0.optionalAttributes
            r8.toArray(r1)
            if (r11 == 0) goto L_0x00b8
            r3 = 1
        L_0x00b8:
            r0.isObsolete = r3
            r0.objectClassType = r12
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r9)
            r0.extensions = r1
            return
        L_0x00c3:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_CLOSE_NOT_AT_END
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.objectClassString
            r5[r3] = r6
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x00d7:
            java.lang.String r15 = "name"
            boolean r15 = r14.equals(r15)
            r5 = 2
            if (r15 == 0) goto L_0x010d
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x00f4
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r5 = r0.objectClassString
            int r2 = readQDStrings(r5, r2, r1, r4)
            goto L_0x02ab
        L_0x00f4:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.objectClassString
            r5[r3] = r6
            java.lang.String r3 = "NAME"
            r6 = 1
            r5[r6] = r3
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x010d:
            java.lang.String r15 = "desc"
            boolean r15 = r14.equals(r15)
            if (r15 == 0) goto L_0x0148
            if (r10 != 0) goto L_0x012f
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r0.objectClassString
            int r2 = readQDString(r10, r2, r1, r5)
            java.lang.String r5 = r5.toString()
            r10 = r5
            goto L_0x02ab
        L_0x012f:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.objectClassString
            r5[r3] = r6
            java.lang.String r3 = "DESC"
            r15 = 1
            r5[r15] = r3
            java.lang.String r3 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0148:
            r15 = 1
            java.lang.String r3 = "obsolete"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x0174
            if (r11 != 0) goto L_0x015b
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)
            r11 = r2
        L_0x0158:
            r2 = r13
            goto L_0x02ab
        L_0x015b:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "OBSOLETE"
            r4[r15] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0174:
            java.lang.String r3 = "sup"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01aa
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L_0x0190
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.objectClassString
            int r2 = readOIDs(r3, r2, r1, r6)
            goto L_0x02ab
        L_0x0190:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "SUP"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x01aa:
            java.lang.String r3 = "abstract"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01ce
            if (r12 != 0) goto L_0x01b8
            com.unboundid.ldap.sdk.schema.ObjectClassType r2 = com.unboundid.ldap.sdk.schema.ObjectClassType.ABSTRACT
        L_0x01b6:
            r12 = r2
            goto L_0x0158
        L_0x01b8:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_OC_TYPES
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x01ce:
            java.lang.String r3 = "structural"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01f1
            if (r12 != 0) goto L_0x01db
            com.unboundid.ldap.sdk.schema.ObjectClassType r2 = com.unboundid.ldap.sdk.schema.ObjectClassType.STRUCTURAL
            goto L_0x01b6
        L_0x01db:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_OC_TYPES
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x01f1:
            java.lang.String r3 = "auxiliary"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x0214
            if (r12 != 0) goto L_0x01fe
            com.unboundid.ldap.sdk.schema.ObjectClassType r2 = com.unboundid.ldap.sdk.schema.ObjectClassType.AUXILIARY
            goto L_0x01b6
        L_0x01fe:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_OC_TYPES
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0214:
            java.lang.String r3 = "must"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x024a
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x0230
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.objectClassString
            int r2 = readOIDs(r3, r2, r1, r7)
            goto L_0x02ab
        L_0x0230:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "MUST"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x024a:
            java.lang.String r3 = "may"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x027f
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L_0x0265
            java.lang.String r2 = r0.objectClassString
            int r2 = skipSpaces(r2, r13, r1)
            java.lang.String r3 = r0.objectClassString
            int r2 = readOIDs(r3, r2, r1, r8)
            goto L_0x02ab
        L_0x0265:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_MULTIPLE_ELEMENTS
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = r0.objectClassString
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "MAY"
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x027f:
            java.lang.String r3 = "x-"
            boolean r3 = r14.startsWith(r3)
            if (r3 == 0) goto L_0x02c7
            java.lang.String r3 = r0.objectClassString
            int r3 = skipSpaces(r3, r13, r1)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.lang.String r14 = r0.objectClassString
            int r3 = readQDStrings(r14, r3, r1, r13)
            int r14 = r13.size()
            java.lang.String[] r14 = new java.lang.String[r14]
            r13.toArray(r14)
            boolean r13 = r9.containsKey(r2)
            if (r13 != 0) goto L_0x02af
            r9.put(r2, r14)
            r2 = r3
        L_0x02ab:
            r3 = 0
            r5 = 1
            goto L_0x0055
        L_0x02af:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_DUP_EXT
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r0.objectClassString
            r7 = 0
            r5[r7] = r6
            r6 = 1
            r5[r6] = r2
            java.lang.String r2 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r2)
            throw r1
        L_0x02c7:
            r6 = 1
            r7 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r4 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_UNEXPECTED_TOKEN
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r8 = r0.objectClassString
            r5[r7] = r8
            r5[r6] = r2
            java.lang.String r2 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r2)
            throw r1
        L_0x02df:
            r6 = 1
            r7 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_NO_OPENING_PAREN
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.String r5 = r0.objectClassString
            r4[r7] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02f5:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.schema.SchemaMessages r3 = com.unboundid.ldap.sdk.schema.SchemaMessages.ERR_OC_DECODE_EMPTY
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.ObjectClassDefinition.<init>(java.lang.String):void");
    }

    public ObjectClassDefinition(String str, String[] strArr, String str2, boolean z, String[] strArr2, ObjectClassType objectClassType2, String[] strArr3, String[] strArr4, Map<String, String[]> map) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.isObsolete = z;
        this.description = str2;
        this.objectClassType = objectClassType2;
        if (strArr == null) {
            this.names = StaticUtils.NO_STRINGS;
        } else {
            this.names = strArr;
        }
        if (strArr2 == null) {
            this.superiorClasses = StaticUtils.NO_STRINGS;
        } else {
            this.superiorClasses = strArr2;
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
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.objectClassString = sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012a  */
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
            java.lang.String[] r0 = r10.superiorClasses
            int r1 = r0.length
            r5 = 32
            if (r1 != r4) goto L_0x0074
            java.lang.String r0 = " SUP "
            r11.append(r0)
            java.lang.String[] r0 = r10.superiorClasses
            r0 = r0[r3]
        L_0x0070:
            r11.append(r0)
            goto L_0x009a
        L_0x0074:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x009a
            java.lang.String r0 = " SUP ("
            r11.append(r0)
            r0 = 0
        L_0x007d:
            java.lang.String[] r1 = r10.superiorClasses
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0097
            if (r0 <= 0) goto L_0x008a
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x008d
        L_0x008a:
            r11.append(r5)
        L_0x008d:
            java.lang.String[] r1 = r10.superiorClasses
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x0097:
            java.lang.String r0 = " )"
            goto L_0x0070
        L_0x009a:
            com.unboundid.ldap.sdk.schema.ObjectClassType r0 = r10.objectClassType
            if (r0 == 0) goto L_0x00aa
            r11.append(r5)
            com.unboundid.ldap.sdk.schema.ObjectClassType r0 = r10.objectClassType
            java.lang.String r0 = r0.getName()
            r11.append(r0)
        L_0x00aa:
            java.lang.String[] r0 = r10.requiredAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x00bc
            java.lang.String r0 = " MUST "
            r11.append(r0)
            java.lang.String[] r0 = r10.requiredAttributes
            r0 = r0[r3]
        L_0x00b8:
            r11.append(r0)
            goto L_0x00e2
        L_0x00bc:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x00e2
            java.lang.String r0 = " MUST ("
            r11.append(r0)
            r0 = 0
        L_0x00c5:
            java.lang.String[] r1 = r10.requiredAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00df
            if (r0 <= 0) goto L_0x00d2
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x00d5
        L_0x00d2:
            r11.append(r5)
        L_0x00d5:
            java.lang.String[] r1 = r10.requiredAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x00c5
        L_0x00df:
            java.lang.String r0 = " )"
            goto L_0x00b8
        L_0x00e2:
            java.lang.String[] r0 = r10.optionalAttributes
            int r1 = r0.length
            if (r1 != r4) goto L_0x00f4
            java.lang.String r0 = " MAY "
            r11.append(r0)
            java.lang.String[] r0 = r10.optionalAttributes
            r0 = r0[r3]
        L_0x00f0:
            r11.append(r0)
            goto L_0x011a
        L_0x00f4:
            int r0 = r0.length
            if (r0 <= r4) goto L_0x011a
            java.lang.String r0 = " MAY ("
            r11.append(r0)
            r0 = 0
        L_0x00fd:
            java.lang.String[] r1 = r10.optionalAttributes
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0117
            if (r0 <= 0) goto L_0x010a
            java.lang.String r1 = " $ "
            r11.append(r1)
            goto L_0x010d
        L_0x010a:
            r11.append(r5)
        L_0x010d:
            java.lang.String[] r1 = r10.optionalAttributes
            r1 = r1[r0]
            r11.append(r1)
            int r0 = r0 + 1
            goto L_0x00fd
        L_0x0117:
            java.lang.String r0 = " )"
            goto L_0x00f0
        L_0x011a:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r10.extensions
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0124:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0178
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r1.getValue()
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 != r4) goto L_0x0153
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " '"
            r11.append(r6)
            r1 = r1[r3]
            encodeValue(r1, r11)
            r11.append(r2)
            goto L_0x0124
        L_0x0153:
            r11.append(r5)
            r11.append(r6)
            java.lang.String r6 = " ("
            r11.append(r6)
            int r6 = r1.length
            r7 = 0
        L_0x0160:
            if (r7 >= r6) goto L_0x0172
            r8 = r1[r7]
            java.lang.String r9 = " '"
            r11.append(r9)
            encodeValue(r8, r11)
            r11.append(r2)
            int r7 = r7 + 1
            goto L_0x0160
        L_0x0172:
            java.lang.String r1 = " )"
            r11.append(r1)
            goto L_0x0124
        L_0x0178:
            java.lang.String r0 = " )"
            r11.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.schema.ObjectClassDefinition.createDefinitionString(java.lang.StringBuilder):void");
    }

    private static void getSuperiorClasses(Schema schema, ObjectClassDefinition objectClassDefinition, Set<ObjectClassDefinition> set) {
        for (String objectClass : objectClassDefinition.superiorClasses) {
            ObjectClassDefinition objectClass2 = schema.getObjectClass(objectClass);
            if (objectClass2 != null) {
                set.add(objectClass2);
                getSuperiorClasses(schema, objectClass2, set);
            }
        }
    }

    private static void getSuperiorOptionalAttributes(Schema schema, ObjectClassDefinition objectClassDefinition, Set<AttributeTypeDefinition> set, Set<AttributeTypeDefinition> set2) {
        for (String attributeType : objectClassDefinition.optionalAttributes) {
            AttributeTypeDefinition attributeType2 = schema.getAttributeType(attributeType);
            if (attributeType2 != null && !set2.contains(attributeType2)) {
                set.add(attributeType2);
            }
        }
        for (String objectClass : objectClassDefinition.superiorClasses) {
            getSuperiorOptionalAttributes(schema, schema.getObjectClass(objectClass), set, set2);
        }
    }

    private static void getSuperiorRequiredAttributes(Schema schema, ObjectClassDefinition objectClassDefinition, Set<AttributeTypeDefinition> set) {
        for (String attributeType : objectClassDefinition.requiredAttributes) {
            AttributeTypeDefinition attributeType2 = schema.getAttributeType(attributeType);
            if (attributeType2 != null) {
                set.add(attributeType2);
            }
        }
        for (String objectClass : objectClassDefinition.superiorClasses) {
            getSuperiorRequiredAttributes(schema, schema.getObjectClass(objectClass), set);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectClassDefinition)) {
            return false;
        }
        ObjectClassDefinition objectClassDefinition = (ObjectClassDefinition) obj;
        return this.oid.equals(objectClassDefinition.oid) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.names, objectClassDefinition.names) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.requiredAttributes, objectClassDefinition.requiredAttributes) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.optionalAttributes, objectClassDefinition.optionalAttributes) && StaticUtils.stringsEqualIgnoreCaseOrderIndependent(this.superiorClasses, objectClassDefinition.superiorClasses) && StaticUtils.bothNullOrEqual(this.objectClassType, objectClassDefinition.objectClassType) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, objectClassDefinition.description) && this.isObsolete == objectClassDefinition.isObsolete && extensionsEqual(this.extensions, objectClassDefinition.extensions);
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

    public ObjectClassType getObjectClassType() {
        return this.objectClassType;
    }

    public ObjectClassType getObjectClassType(Schema schema) {
        ObjectClassType objectClassType2 = this.objectClassType;
        if (objectClassType2 != null) {
            return objectClassType2;
        }
        for (String objectClass : this.superiorClasses) {
            ObjectClassDefinition objectClass2 = schema.getObjectClass(objectClass);
            if (objectClass2 != null) {
                return objectClass2.getObjectClassType(schema);
            }
        }
        return ObjectClassType.STRUCTURAL;
    }

    public Set<AttributeTypeDefinition> getOptionalAttributes(Schema schema, boolean z) {
        HashSet hashSet = new HashSet();
        for (String attributeType : this.optionalAttributes) {
            AttributeTypeDefinition attributeType2 = schema.getAttributeType(attributeType);
            if (attributeType2 != null) {
                hashSet.add(attributeType2);
            }
        }
        if (z) {
            Set<AttributeTypeDefinition> requiredAttributes2 = getRequiredAttributes(schema, true);
            for (AttributeTypeDefinition remove : requiredAttributes2) {
                hashSet.remove(remove);
            }
            for (String objectClass : this.superiorClasses) {
                ObjectClassDefinition objectClass2 = schema.getObjectClass(objectClass);
                if (objectClass2 != null) {
                    getSuperiorOptionalAttributes(schema, objectClass2, hashSet, requiredAttributes2);
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public String[] getOptionalAttributes() {
        return this.optionalAttributes;
    }

    public Set<AttributeTypeDefinition> getRequiredAttributes(Schema schema, boolean z) {
        HashSet hashSet = new HashSet();
        for (String attributeType : this.requiredAttributes) {
            AttributeTypeDefinition attributeType2 = schema.getAttributeType(attributeType);
            if (attributeType2 != null) {
                hashSet.add(attributeType2);
            }
        }
        if (z) {
            for (String objectClass : this.superiorClasses) {
                ObjectClassDefinition objectClass2 = schema.getObjectClass(objectClass);
                if (objectClass2 != null) {
                    getSuperiorRequiredAttributes(schema, objectClass2, hashSet);
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public String[] getRequiredAttributes() {
        return this.requiredAttributes;
    }

    public Set<ObjectClassDefinition> getSuperiorClasses(Schema schema, boolean z) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String objectClass : this.superiorClasses) {
            ObjectClassDefinition objectClass2 = schema.getObjectClass(objectClass);
            if (objectClass2 != null) {
                linkedHashSet.add(objectClass2);
                if (z) {
                    getSuperiorClasses(schema, objectClass2, linkedHashSet);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String[] getSuperiorClasses() {
        return this.superiorClasses;
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
        return this.objectClassString;
    }
}
