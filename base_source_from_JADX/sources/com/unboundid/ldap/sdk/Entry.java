package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.sdk.schema.AttributeTypeDefinition;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.ldif.LDIFReader;
import com.unboundid.ldif.LDIFRecord;
import com.unboundid.ldif.LDIFWriter;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Entry implements LDIFRecord {
    private static final long serialVersionUID = -4438809025903729197L;
    private final LinkedHashMap<String, Attribute> attributes;

    /* renamed from: dn */
    private String f7270dn;
    private volatile C3122DN parsedDN;
    private final Schema schema;

    public Entry(C3122DN dn) {
        this(dn, (Schema) null);
    }

    public Entry(C3122DN dn, Schema schema2) {
        Validator.ensureNotNull(dn);
        this.parsedDN = dn;
        this.f7270dn = this.parsedDN.toString();
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>();
    }

    public Entry(C3122DN dn, Schema schema2, Collection<Attribute> collection) {
        Validator.ensureNotNull(dn, collection);
        this.parsedDN = dn;
        this.f7270dn = this.parsedDN.toString();
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>(collection.size());
        for (Attribute next : collection) {
            String lowerCase = StaticUtils.toLowerCase(next.getName());
            Attribute attribute = this.attributes.get(lowerCase);
            if (attribute == null) {
                this.attributes.put(lowerCase, next);
            } else {
                this.attributes.put(lowerCase, Attribute.mergeAttributes(attribute, next));
            }
        }
    }

    public Entry(C3122DN dn, Schema schema2, Attribute... attributeArr) {
        Validator.ensureNotNull(dn, attributeArr);
        this.parsedDN = dn;
        this.f7270dn = this.parsedDN.toString();
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>(attributeArr.length);
        for (Attribute attribute : attributeArr) {
            String lowerCase = StaticUtils.toLowerCase(attribute.getName());
            Attribute attribute2 = this.attributes.get(lowerCase);
            if (attribute2 == null) {
                this.attributes.put(lowerCase, attribute);
            } else {
                this.attributes.put(lowerCase, Attribute.mergeAttributes(attribute2, attribute));
            }
        }
    }

    public Entry(C3122DN dn, Collection<Attribute> collection) {
        this(dn, (Schema) null, collection);
    }

    public Entry(C3122DN dn, Attribute... attributeArr) {
        this(dn, (Schema) null, attributeArr);
    }

    public Entry(Schema schema2, String... strArr) {
        Entry decodeEntry = LDIFReader.decodeEntry(strArr);
        this.schema = schema2;
        this.f7270dn = decodeEntry.f7270dn;
        this.parsedDN = decodeEntry.parsedDN;
        this.attributes = decodeEntry.attributes;
    }

    public Entry(String str) {
        this(str, (Schema) null);
    }

    public Entry(String str, Schema schema2) {
        Validator.ensureNotNull(str);
        this.f7270dn = str;
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>();
    }

    public Entry(String str, Schema schema2, Collection<Attribute> collection) {
        Validator.ensureNotNull(str, collection);
        this.f7270dn = str;
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>(collection.size());
        for (Attribute next : collection) {
            String lowerCase = StaticUtils.toLowerCase(next.getName());
            Attribute attribute = this.attributes.get(lowerCase);
            if (attribute == null) {
                this.attributes.put(lowerCase, next);
            } else {
                this.attributes.put(lowerCase, Attribute.mergeAttributes(attribute, next));
            }
        }
    }

    public Entry(String str, Schema schema2, Attribute... attributeArr) {
        Validator.ensureNotNull(str, attributeArr);
        this.f7270dn = str;
        this.schema = schema2;
        this.attributes = new LinkedHashMap<>(attributeArr.length);
        for (Attribute attribute : attributeArr) {
            String lowerCase = StaticUtils.toLowerCase(attribute.getName());
            Attribute attribute2 = this.attributes.get(lowerCase);
            if (attribute2 == null) {
                this.attributes.put(lowerCase, attribute);
            } else {
                this.attributes.put(lowerCase, Attribute.mergeAttributes(attribute2, attribute));
            }
        }
    }

    public Entry(String str, Collection<Attribute> collection) {
        this(str, (Schema) null, collection);
    }

    public Entry(String str, Attribute... attributeArr) {
        this(str, (Schema) null, attributeArr);
    }

    public Entry(String... strArr) {
        this((Schema) null, strArr);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019b, code lost:
        if (r12 == null) goto L_0x015d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.ldap.sdk.Entry applyModifications(com.unboundid.ldap.sdk.Entry r16, boolean r17, java.util.List<com.unboundid.ldap.sdk.Modification> r18) {
        /*
            r1 = r16
            r2 = r18
            com.unboundid.util.Validator.ensureNotNull(r1, r2)
            boolean r0 = r18.isEmpty()
            com.unboundid.util.Validator.ensureFalse(r0)
            com.unboundid.ldap.sdk.Entry r3 = r16.duplicate()
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r18.size()
            r4.<init>(r0)
            r5 = 0
            com.unboundid.ldap.sdk.RDN r0 = r16.getRDN()     // Catch:{ LDAPException -> 0x0022 }
            r6 = r0
            goto L_0x0028
        L_0x0022:
            r0 = move-exception
            r6 = r0
            com.unboundid.util.Debug.debugException(r6)
            r6 = r5
        L_0x0028:
            java.util.Iterator r2 = r18.iterator()
        L_0x002c:
            boolean r0 = r2.hasNext()
            r7 = 2
            r8 = 0
            r9 = 1
            if (r0 == 0) goto L_0x020b
            java.lang.Object r0 = r2.next()
            com.unboundid.ldap.sdk.Modification r0 = (com.unboundid.ldap.sdk.Modification) r0
            java.lang.String r10 = r0.getAttributeName()
            byte[][] r11 = r0.getValueByteArrays()
            com.unboundid.ldap.sdk.ModificationType r12 = r0.getModificationType()
            int r12 = r12.intValue()
            switch(r12) {
                case 0: goto L_0x01c7;
                case 1: goto L_0x0139;
                case 2: goto L_0x0103;
                case 3: goto L_0x0062;
                default: goto L_0x004e;
            }
        L_0x004e:
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_UNKNOWN_TYPE
            java.lang.Object[] r9 = new java.lang.Object[r9]
            com.unboundid.ldap.sdk.ModificationType r0 = r0.getModificationType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r9[r8] = r0
            java.lang.String r0 = r7.get(r9)
            goto L_0x00fe
        L_0x0062:
            com.unboundid.ldap.sdk.Attribute r12 = r3.getAttribute(r10)
            if (r12 == 0) goto L_0x00f4
            boolean r13 = r12.hasValue()
            if (r13 != 0) goto L_0x0070
            goto L_0x00f4
        L_0x0070:
            int r13 = r12.size()
            if (r13 <= r9) goto L_0x007e
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_NOT_SINGLE_VALUED
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r10
            goto L_0x00fa
        L_0x007e:
            if (r6 == 0) goto L_0x00a1
            boolean r13 = r6.hasAttribute(r10)
            if (r13 == 0) goto L_0x00a1
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_TARGETS_RDN
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r9 = r16.getDN()
            r7[r8] = r9
            java.lang.String r0 = r0.get(r7)
            boolean r7 = r4.contains(r0)
            if (r7 != 0) goto L_0x009d
            r4.add(r0)
        L_0x009d:
            if (r5 != 0) goto L_0x002c
            goto L_0x0124
        L_0x00a1:
            java.math.BigInteger r13 = new java.math.BigInteger     // Catch:{ NumberFormatException -> 0x00e3 }
            java.lang.String r14 = r12.getValue()     // Catch:{ NumberFormatException -> 0x00e3 }
            r13.<init>(r14)     // Catch:{ NumberFormatException -> 0x00e3 }
            int r12 = r11.length
            if (r12 != 0) goto L_0x00b4
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_NO_MOD_VALUES
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r10
            goto L_0x00fa
        L_0x00b4:
            int r11 = r11.length
            if (r11 <= r9) goto L_0x00be
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_MULTIPLE_MOD_VALUES
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r10
            goto L_0x00fa
        L_0x00be:
            java.lang.String[] r0 = r0.getValues()
            r11 = r0[r8]
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ NumberFormatException -> 0x00d6 }
            r0.<init>(r11)     // Catch:{ NumberFormatException -> 0x00d6 }
            java.math.BigInteger r0 = r13.add(r0)
            java.lang.String r0 = r0.toString()
            r3.setAttribute((java.lang.String) r10, (java.lang.String) r0)
            goto L_0x002c
        L_0x00d6:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_MOD_VALUE_NOT_INTEGER
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r8] = r10
            r7[r9] = r11
            goto L_0x00fa
        L_0x00e3:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_ENTRY_VALUE_NOT_INTEGER
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r8] = r10
            java.lang.String r8 = r12.getValue()
            r7[r9] = r8
            goto L_0x00fa
        L_0x00f4:
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_INCREMENT_NO_SUCH_ATTR
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r10
        L_0x00fa:
            java.lang.String r0 = r0.get(r7)
        L_0x00fe:
            r4.add(r0)
            goto L_0x002c
        L_0x0103:
            if (r6 == 0) goto L_0x0128
            boolean r7 = r6.hasAttribute(r10)
            if (r7 == 0) goto L_0x0128
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_TARGETS_RDN
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r9 = r16.getDN()
            r7[r8] = r9
            java.lang.String r0 = r0.get(r7)
            boolean r7 = r4.contains(r0)
            if (r7 != 0) goto L_0x0122
            r4.add(r0)
        L_0x0122:
            if (r5 != 0) goto L_0x002c
        L_0x0124:
            com.unboundid.ldap.sdk.ResultCode r5 = com.unboundid.ldap.sdk.ResultCode.NOT_ALLOWED_ON_RDN
            goto L_0x002c
        L_0x0128:
            int r7 = r11.length
            if (r7 != 0) goto L_0x0130
            r3.removeAttribute(r10)
            goto L_0x002c
        L_0x0130:
            com.unboundid.ldap.sdk.Attribute r0 = r0.getAttribute()
            r3.setAttribute(r0)
            goto L_0x002c
        L_0x0139:
            int r12 = r11.length
            if (r12 != 0) goto L_0x0175
            if (r6 == 0) goto L_0x0162
            boolean r0 = r6.hasAttribute(r10)
            if (r0 == 0) goto L_0x0162
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_TARGETS_RDN
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r9 = r16.getDN()
            r7[r8] = r9
            java.lang.String r0 = r0.get(r7)
            boolean r7 = r4.contains(r0)
            if (r7 != 0) goto L_0x015b
            r4.add(r0)
        L_0x015b:
            if (r5 != 0) goto L_0x002c
        L_0x015d:
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.NOT_ALLOWED_ON_RDN
            r5 = r0
            goto L_0x002c
        L_0x0162:
            boolean r0 = r3.removeAttribute(r10)
            if (r17 != 0) goto L_0x002c
            if (r0 != 0) goto L_0x002c
            if (r5 != 0) goto L_0x016e
            com.unboundid.ldap.sdk.ResultCode r5 = com.unboundid.ldap.sdk.ResultCode.NO_SUCH_ATTRIBUTE
        L_0x016e:
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_DELETE_NONEXISTENT_ATTR
            java.lang.Object[] r7 = new java.lang.Object[r9]
            r7[r8] = r10
            goto L_0x00fa
        L_0x0175:
            r12 = r5
            r5 = 0
        L_0x0177:
            int r13 = r11.length
            if (r5 >= r13) goto L_0x01c4
            if (r6 == 0) goto L_0x019e
            r13 = r11[r5]
            boolean r13 = r6.hasAttributeValue((java.lang.String) r10, (byte[]) r13)
            if (r13 == 0) goto L_0x019e
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_TARGETS_RDN
            java.lang.Object[] r5 = new java.lang.Object[r9]
            java.lang.String r7 = r16.getDN()
            r5[r8] = r7
            java.lang.String r0 = r0.get(r5)
            boolean r5 = r4.contains(r0)
            if (r5 != 0) goto L_0x019b
            r4.add(r0)
        L_0x019b:
            if (r12 != 0) goto L_0x01c4
            goto L_0x015d
        L_0x019e:
            r13 = r11[r5]
            boolean r13 = r3.removeAttributeValue((java.lang.String) r10, (byte[]) r13)
            if (r17 != 0) goto L_0x01c1
            if (r13 != 0) goto L_0x01c1
            if (r12 != 0) goto L_0x01ac
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.NO_SUCH_ATTRIBUTE
        L_0x01ac:
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_DELETE_NONEXISTENT_VALUE
            java.lang.Object[] r14 = new java.lang.Object[r7]
            java.lang.String[] r15 = r0.getValues()
            r15 = r15[r5]
            r14[r8] = r15
            r14[r9] = r10
            java.lang.String r13 = r13.get(r14)
            r4.add(r13)
        L_0x01c1:
            int r5 = r5 + 1
            goto L_0x0177
        L_0x01c4:
            r5 = r12
            goto L_0x002c
        L_0x01c7:
            if (r17 == 0) goto L_0x01d2
            com.unboundid.ldap.sdk.Attribute r0 = r0.getAttribute()
            r3.addAttribute(r0)
            goto L_0x002c
        L_0x01d2:
            int r12 = r11.length
            if (r12 != 0) goto L_0x01e2
            com.unboundid.ldap.sdk.LDAPMessages r12 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_ADD_NO_VALUES
            java.lang.Object[] r13 = new java.lang.Object[r9]
            r13[r8] = r10
            java.lang.String r12 = r12.get(r13)
            r4.add(r12)
        L_0x01e2:
            r12 = r5
            r5 = 0
        L_0x01e4:
            int r13 = r11.length
            if (r5 >= r13) goto L_0x01c4
            r13 = r11[r5]
            boolean r13 = r3.addAttribute((java.lang.String) r10, (byte[]) r13)
            if (r13 != 0) goto L_0x0208
            if (r12 != 0) goto L_0x01f3
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.ATTRIBUTE_OR_VALUE_EXISTS
        L_0x01f3:
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_ADD_EXISTING
            java.lang.Object[] r14 = new java.lang.Object[r7]
            java.lang.String[] r15 = r0.getValues()
            r15 = r15[r5]
            r14[r8] = r15
            r14[r9] = r10
            java.lang.String r13 = r13.get(r14)
            r4.add(r13)
        L_0x0208:
            int r5 = r5 + 1
            goto L_0x01e4
        L_0x020b:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0212
            return r3
        L_0x0212:
            if (r5 != 0) goto L_0x0216
            com.unboundid.ldap.sdk.ResultCode r5 = com.unboundid.ldap.sdk.ResultCode.CONSTRAINT_VIOLATION
        L_0x0216:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_ENTRY_APPLY_MODS_FAILURE
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = r3.getDN()
            r2[r8] = r3
            java.lang.String r3 = com.unboundid.util.StaticUtils.concatenateStrings(r4)
            r2[r9] = r3
            java.lang.String r1 = r1.get(r2)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r5, (java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Entry.applyModifications(com.unboundid.ldap.sdk.Entry, boolean, java.util.List):com.unboundid.ldap.sdk.Entry");
    }

    public static Entry applyModifications(Entry entry, boolean z, Modification... modificationArr) {
        Validator.ensureNotNull(entry, modificationArr);
        Validator.ensureFalse(modificationArr.length == 0);
        return applyModifications(entry, z, (List<Modification>) Arrays.asList(modificationArr));
    }

    public static List<Modification> diff(Entry entry, Entry entry2, boolean z, boolean z2, String... strArr) {
        HashSet hashSet;
        RDN rdn;
        Entry entry3 = entry2;
        String[] strArr2 = strArr;
        RDN rdn2 = null;
        if (strArr2 == null || strArr2.length <= 0) {
            hashSet = null;
        } else {
            hashSet = new HashSet(strArr2.length);
            for (String lowerCase : strArr2) {
                hashSet.add(StaticUtils.toLowerCase(lowerCase));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry next : entry.attributes.entrySet()) {
            String lowerCase2 = StaticUtils.toLowerCase((String) next.getKey());
            if (hashSet == null || hashSet.contains(lowerCase2)) {
                linkedHashMap.put(lowerCase2, next.getValue());
                linkedHashMap3.put(lowerCase2, next.getValue());
            }
        }
        for (Map.Entry next2 : entry3.attributes.entrySet()) {
            String lowerCase3 = StaticUtils.toLowerCase((String) next2.getKey());
            if ((hashSet == null || hashSet.contains(lowerCase3)) && linkedHashMap.remove(lowerCase3) == null) {
                linkedHashMap2.put(lowerCase3, next2.getValue());
            }
        }
        for (String remove : linkedHashMap.keySet()) {
            linkedHashMap3.remove(remove);
        }
        if (z) {
            try {
                rdn = entry.getRDN();
            } catch (Exception e) {
                Debug.debugException(e);
                rdn = null;
            }
            try {
                rdn2 = entry2.getRDN();
            } catch (Exception e2) {
                Debug.debugException(e2);
            }
        } else {
            rdn = null;
        }
        ArrayList arrayList = new ArrayList(10);
        for (Attribute attribute : linkedHashMap.values()) {
            if (z2) {
                ASN1OctetString[] rawValues = attribute.getRawValues();
                if (rdn != null && rdn.hasAttribute(attribute.getName())) {
                    ArrayList arrayList2 = new ArrayList(rawValues.length);
                    for (ASN1OctetString aSN1OctetString : rawValues) {
                        if (!rdn.hasAttributeValue(attribute.getName(), aSN1OctetString.getValue())) {
                            arrayList2.add(aSN1OctetString);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        rawValues = new ASN1OctetString[arrayList2.size()];
                        arrayList2.toArray(rawValues);
                    }
                }
                arrayList.add(new Modification(ModificationType.DELETE, attribute.getName(), rawValues));
            } else {
                arrayList.add(new Modification(ModificationType.REPLACE, attribute.getName()));
            }
        }
        for (Attribute attribute2 : linkedHashMap2.values()) {
            ASN1OctetString[] rawValues2 = attribute2.getRawValues();
            if (rdn2 != null && rdn2.hasAttribute(attribute2.getName())) {
                ArrayList arrayList3 = new ArrayList(rawValues2.length);
                for (ASN1OctetString aSN1OctetString2 : rawValues2) {
                    if (!rdn2.hasAttributeValue(attribute2.getName(), aSN1OctetString2.getValue())) {
                        arrayList3.add(aSN1OctetString2);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    rawValues2 = new ASN1OctetString[arrayList3.size()];
                    arrayList3.toArray(rawValues2);
                }
            }
            arrayList.add(z2 ? new Modification(ModificationType.ADD, attribute2.getName(), rawValues2) : new Modification(ModificationType.REPLACE, attribute2.getName(), rawValues2));
        }
        for (Attribute attribute3 : linkedHashMap3.values()) {
            Attribute attribute4 = entry3.getAttribute(attribute3.getName());
            if (!attribute3.equals(attribute4)) {
                if (z2 || (rdn2 != null && rdn2.hasAttribute(attribute4.getName()))) {
                    ASN1OctetString[] rawValues3 = attribute3.getRawValues();
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap(rawValues3.length);
                    for (ASN1OctetString aSN1OctetString3 : rawValues3) {
                        try {
                            linkedHashMap4.put(attribute3.getMatchingRule().normalize(aSN1OctetString3), aSN1OctetString3);
                        } catch (Exception e3) {
                            Debug.debugException(e3);
                            linkedHashMap4.put(aSN1OctetString3, aSN1OctetString3);
                        }
                    }
                    ASN1OctetString[] rawValues4 = attribute4.getRawValues();
                    LinkedHashMap linkedHashMap5 = new LinkedHashMap(rawValues4.length);
                    for (ASN1OctetString aSN1OctetString4 : rawValues4) {
                        try {
                            linkedHashMap5.put(attribute3.getMatchingRule().normalize(aSN1OctetString4), aSN1OctetString4);
                        } catch (Exception e4) {
                            Debug.debugException(e4);
                            linkedHashMap5.put(aSN1OctetString4, aSN1OctetString4);
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry4 = (Map.Entry) it.next();
                        if (linkedHashMap5.remove(entry4.getKey()) != null || (rdn != null && rdn.hasAttributeValue(attribute3.getName(), ((ASN1OctetString) entry4.getValue()).getValue()))) {
                            it.remove();
                        }
                    }
                    Iterator it2 = linkedHashMap5.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry5 = (Map.Entry) it2.next();
                        if (rdn2 != null && rdn2.hasAttributeValue(attribute4.getName(), ((ASN1OctetString) entry5.getValue()).getValue())) {
                            it2.remove();
                        }
                    }
                    ArrayList arrayList4 = new ArrayList(linkedHashMap5.values());
                    ArrayList arrayList5 = new ArrayList(linkedHashMap4.values());
                    if (!arrayList4.isEmpty()) {
                        arrayList.add(new Modification(ModificationType.ADD, attribute4.getName(), (ASN1OctetString[]) arrayList4.toArray(new ASN1OctetString[arrayList4.size()])));
                    }
                    if (!arrayList5.isEmpty()) {
                        arrayList.add(new Modification(ModificationType.DELETE, attribute3.getName(), (ASN1OctetString[]) arrayList5.toArray(new ASN1OctetString[arrayList5.size()])));
                    }
                } else {
                    arrayList.add(new Modification(ModificationType.REPLACE, attribute4.getName(), attribute4.getRawValues()));
                }
            }
        }
        return arrayList;
    }

    public static List<Modification> diff(Entry entry, Entry entry2, boolean z, String... strArr) {
        return diff(entry, entry2, z, true, strArr);
    }

    public static Entry intersectEntries(Entry... entryArr) {
        Validator.ensureNotNull(entryArr);
        Validator.ensureTrue(entryArr.length > 0);
        Entry duplicate = entryArr[0].duplicate();
        for (Attribute next : entryArr[0].attributes.values()) {
            String name = next.getName();
            for (byte[] bArr : next.getValueByteArrays()) {
                int i = 1;
                while (true) {
                    if (i >= entryArr.length) {
                        break;
                    } else if (!entryArr[i].hasAttributeValue(name, bArr)) {
                        duplicate.removeAttributeValue(name, bArr);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return duplicate;
    }

    public static Entry mergeEntries(Entry... entryArr) {
        Validator.ensureNotNull(entryArr);
        Validator.ensureTrue(entryArr.length > 0);
        Entry duplicate = entryArr[0].duplicate();
        for (int i = 1; i < entryArr.length; i++) {
            for (Attribute addAttribute : entryArr[i].attributes.values()) {
                duplicate.addAttribute(addAttribute);
            }
        }
        return duplicate;
    }

    public boolean addAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        String lowerCase = StaticUtils.toLowerCase(attribute.getName());
        Attribute attribute2 = this.attributes.get(lowerCase);
        if (attribute2 == null) {
            this.attributes.put(lowerCase, attribute);
            return true;
        }
        Attribute mergeAttributes = Attribute.mergeAttributes(attribute2, attribute);
        this.attributes.put(lowerCase, mergeAttributes);
        return attribute2.getRawValues().length != mergeAttributes.getRawValues().length;
    }

    public boolean addAttribute(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        return addAttribute(new Attribute(str, this.schema, str2));
    }

    public boolean addAttribute(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        return addAttribute(new Attribute(str, this.schema, bArr));
    }

    public boolean addAttribute(String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        return addAttribute(new Attribute(str, this.schema, strArr));
    }

    public boolean addAttribute(String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        return addAttribute(new Attribute(str, this.schema, bArr));
    }

    public Entry duplicate() {
        return new Entry(this.f7270dn, this.schema, this.attributes.values());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        try {
            if (!getParsedDN().equals((Object) entry.getParsedDN())) {
                return false;
            }
        } catch (LDAPException e) {
            Debug.debugException(e);
            if (!this.f7270dn.equals(entry.f7270dn)) {
                return false;
            }
        }
        if (this.attributes.size() != entry.attributes.size()) {
            return false;
        }
        for (Attribute hasAttribute : this.attributes.values()) {
            if (!entry.hasAttribute(hasAttribute)) {
                return false;
            }
        }
        return true;
    }

    public final Attribute getAttribute(String str) {
        return getAttribute(str, this.schema);
    }

    public final Attribute getAttribute(String str, Schema schema2) {
        String str2;
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute != null || schema2 == null) {
            return attribute;
        }
        int indexOf = str.indexOf(59);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            str2 = StaticUtils.toLowerCase(str.substring(indexOf));
            str = substring;
        } else {
            str2 = "";
        }
        AttributeTypeDefinition attributeType = schema2.getAttributeType(str);
        if (attributeType == null) {
            return null;
        }
        Attribute attribute2 = this.attributes.get(StaticUtils.toLowerCase(attributeType.getOID() + str2));
        if (attribute2 == null) {
            for (String str3 : attributeType.getNames()) {
                attribute2 = this.attributes.get(StaticUtils.toLowerCase(str3) + str2);
                if (attribute2 != null) {
                    return attribute2;
                }
            }
        }
        return attribute2;
    }

    public String getAttributeValue(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    public Boolean getAttributeValueAsBoolean(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsBoolean();
    }

    public C3122DN getAttributeValueAsDN(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsDN();
    }

    public Date getAttributeValueAsDate(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsDate();
    }

    public Integer getAttributeValueAsInteger(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsInteger();
    }

    public Long getAttributeValueAsLong(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueAsLong();
    }

    public byte[][] getAttributeValueByteArrays(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueByteArrays();
    }

    public byte[] getAttributeValueBytes(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValueByteArray();
    }

    public String[] getAttributeValues(String str) {
        Validator.ensureNotNull(str);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        if (attribute == null) {
            return null;
        }
        return attribute.getValues();
    }

    public final Collection<Attribute> getAttributes() {
        return Collections.unmodifiableCollection(this.attributes.values());
    }

    public final List<Attribute> getAttributesWithOptions(String str, Set<String> set) {
        Validator.ensureNotNull(str);
        ArrayList arrayList = new ArrayList(10);
        for (Attribute next : this.attributes.values()) {
            if (next.getBaseName().equalsIgnoreCase(str)) {
                if (set != null && !set.isEmpty()) {
                    boolean z = true;
                    Iterator<String> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!next.hasOption(it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                    }
                }
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final String getDN() {
        return this.f7270dn;
    }

    public final Attribute getObjectClassAttribute() {
        return getAttribute("objectClass");
    }

    public final String[] getObjectClassValues() {
        return getAttributeValues("objectClass");
    }

    public final C3122DN getParentDN() {
        if (this.parsedDN == null) {
            this.parsedDN = new C3122DN(this.f7270dn, this.schema);
        }
        return this.parsedDN.getParent();
    }

    public final String getParentDNString() {
        if (this.parsedDN == null) {
            this.parsedDN = new C3122DN(this.f7270dn, this.schema);
        }
        C3122DN parent = this.parsedDN.getParent();
        if (parent == null) {
            return null;
        }
        return parent.toString();
    }

    public final C3122DN getParsedDN() {
        if (this.parsedDN == null) {
            this.parsedDN = new C3122DN(this.f7270dn, this.schema);
        }
        return this.parsedDN;
    }

    public final RDN getRDN() {
        return getParsedDN().getRDN();
    }

    /* access modifiers changed from: protected */
    public Schema getSchema() {
        return this.schema;
    }

    public final boolean hasAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        Attribute attribute2 = this.attributes.get(StaticUtils.toLowerCase(attribute.getName()));
        return attribute2 != null && attribute2.equals(attribute);
    }

    public final boolean hasAttribute(String str) {
        return hasAttribute(str, this.schema);
    }

    public final boolean hasAttribute(String str, Schema schema2) {
        String str2;
        Validator.ensureNotNull(str);
        if (this.attributes.containsKey(StaticUtils.toLowerCase(str))) {
            return true;
        }
        if (schema2 != null) {
            int indexOf = str.indexOf(59);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                str2 = StaticUtils.toLowerCase(str.substring(indexOf));
                str = substring;
            } else {
                str2 = "";
            }
            AttributeTypeDefinition attributeType = schema2.getAttributeType(str);
            if (attributeType != null) {
                if (this.attributes.containsKey(StaticUtils.toLowerCase(attributeType.getOID()) + str2)) {
                    return true;
                }
                for (String str3 : attributeType.getNames()) {
                    if (this.attributes.containsKey(StaticUtils.toLowerCase(str3) + str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean hasAttributeValue(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        return attribute != null && attribute.hasValue(str2);
    }

    public final boolean hasAttributeValue(String str, String str2, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, str2);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        return attribute != null && attribute.hasValue(str2, matchingRule);
    }

    public final boolean hasAttributeValue(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        return attribute != null && attribute.hasValue(bArr);
    }

    public final boolean hasAttributeValue(String str, byte[] bArr, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = this.attributes.get(StaticUtils.toLowerCase(str));
        return attribute != null && attribute.hasValue(bArr, matchingRule);
    }

    public final boolean hasObjectClass(String str) {
        return hasAttributeValue("objectClass", str);
    }

    public int hashCode() {
        int i;
        try {
            i = getParsedDN().hashCode() + 0;
        } catch (LDAPException e) {
            Debug.debugException(e);
            i = this.f7270dn.hashCode() + 0;
        }
        for (Attribute hashCode : this.attributes.values()) {
            i += hashCode.hashCode();
        }
        return i;
    }

    public boolean matchesBaseAndScope(C3122DN dn, SearchScope searchScope) {
        return getParsedDN().matchesBaseAndScope(dn, searchScope);
    }

    public boolean matchesBaseAndScope(String str, SearchScope searchScope) {
        return getParsedDN().matchesBaseAndScope(new C3122DN(str), searchScope);
    }

    public boolean removeAttribute(String str) {
        Validator.ensureNotNull(str);
        Schema schema2 = this.schema;
        if (schema2 == null) {
            return this.attributes.remove(StaticUtils.toLowerCase(str)) != null;
        }
        Attribute attribute = getAttribute(str, schema2);
        if (attribute == null) {
            return false;
        }
        this.attributes.remove(StaticUtils.toLowerCase(attribute.getName()));
        return true;
    }

    public boolean removeAttributeValue(String str, String str2) {
        return removeAttributeValue(str, str2, (MatchingRule) null);
    }

    public boolean removeAttributeValue(String str, String str2, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, str2);
        Attribute attribute = getAttribute(str, this.schema);
        if (attribute == null) {
            return false;
        }
        String lowerCase = StaticUtils.toLowerCase(attribute.getName());
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, str2), matchingRule);
        if (removeValues.hasValue()) {
            this.attributes.put(lowerCase, removeValues);
        } else {
            this.attributes.remove(lowerCase);
        }
        return attribute.getRawValues().length != removeValues.getRawValues().length;
    }

    public boolean removeAttributeValue(String str, byte[] bArr) {
        return removeAttributeValue(str, bArr, (MatchingRule) null);
    }

    public boolean removeAttributeValue(String str, byte[] bArr, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = getAttribute(str, this.schema);
        if (attribute == null) {
            return false;
        }
        String lowerCase = StaticUtils.toLowerCase(attribute.getName());
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, bArr), matchingRule);
        if (removeValues.hasValue()) {
            this.attributes.put(lowerCase, removeValues);
        } else {
            this.attributes.remove(lowerCase);
        }
        return attribute.getRawValues().length != removeValues.getRawValues().length;
    }

    public boolean removeAttributeValues(String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        Attribute attribute = getAttribute(str, this.schema);
        if (attribute == null) {
            return false;
        }
        String lowerCase = StaticUtils.toLowerCase(attribute.getName());
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, strArr));
        if (removeValues.hasValue()) {
            this.attributes.put(lowerCase, removeValues);
        } else {
            this.attributes.remove(lowerCase);
        }
        return attribute.getRawValues().length != removeValues.getRawValues().length;
    }

    public boolean removeAttributeValues(String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = getAttribute(str, this.schema);
        if (attribute == null) {
            return false;
        }
        String lowerCase = StaticUtils.toLowerCase(attribute.getName());
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, bArr));
        if (removeValues.hasValue()) {
            this.attributes.put(lowerCase, removeValues);
        } else {
            this.attributes.remove(lowerCase);
        }
        return attribute.getRawValues().length != removeValues.getRawValues().length;
    }

    public void setAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        Attribute attribute2 = getAttribute(attribute.getName(), this.schema);
        this.attributes.put(StaticUtils.toLowerCase(attribute2 == null ? attribute.getName() : attribute2.getName()), attribute);
    }

    public void setAttribute(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        setAttribute(new Attribute(str, this.schema, str2));
    }

    public void setAttribute(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        setAttribute(new Attribute(str, this.schema, bArr));
    }

    public void setAttribute(String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        setAttribute(new Attribute(str, this.schema, strArr));
    }

    public void setAttribute(String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        setAttribute(new Attribute(str, this.schema, bArr));
    }

    public void setDN(C3122DN dn) {
        Validator.ensureNotNull(dn);
        this.parsedDN = dn;
        this.f7270dn = this.parsedDN.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7270dn = str;
        this.parsedDN = null;
    }

    public final void toLDIF(ByteStringBuffer byteStringBuffer) {
        toLDIF(byteStringBuffer, 0);
    }

    public final void toLDIF(ByteStringBuffer byteStringBuffer, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(this.f7270dn), byteStringBuffer, i);
        byteStringBuffer.append(StaticUtils.EOL_BYTES);
        for (Attribute next : this.attributes.values()) {
            String name = next.getName();
            for (ASN1OctetString encodeNameAndValue : next.getRawValues()) {
                LDIFWriter.encodeNameAndValue(name, encodeNameAndValue, byteStringBuffer, i);
                byteStringBuffer.append(StaticUtils.EOL_BYTES);
            }
        }
    }

    public final String[] toLDIF() {
        return toLDIF(0);
    }

    public final String[] toLDIF(int i) {
        List arrayList = new ArrayList(this.attributes.size() * 2);
        arrayList.add(LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(this.f7270dn)));
        for (Attribute next : this.attributes.values()) {
            String name = next.getName();
            for (ASN1OctetString encodeNameAndValue : next.getRawValues()) {
                arrayList.add(LDIFWriter.encodeNameAndValue(name, encodeNameAndValue));
            }
        }
        if (i > 2) {
            arrayList = LDIFWriter.wrapLines(i, (List<String>) arrayList);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public final String toLDIFString() {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, 0);
        return sb.toString();
    }

    public final String toLDIFString(int i) {
        StringBuilder sb = new StringBuilder();
        toLDIFString(sb, i);
        return sb.toString();
    }

    public final void toLDIFString(StringBuilder sb) {
        toLDIFString(sb, 0);
    }

    public final void toLDIFString(StringBuilder sb, int i) {
        LDIFWriter.encodeNameAndValue("dn", new ASN1OctetString(this.f7270dn), sb, i);
        sb.append(StaticUtils.EOL);
        for (Attribute next : this.attributes.values()) {
            String name = next.getName();
            for (ASN1OctetString encodeNameAndValue : next.getRawValues()) {
                LDIFWriter.encodeNameAndValue(name, encodeNameAndValue, sb, i);
                sb.append(StaticUtils.EOL);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("Entry(dn='");
        sb.append(this.f7270dn);
        sb.append("', attributes={");
        Iterator<Attribute> it = this.attributes.values().iterator();
        while (it.hasNext()) {
            it.next().toString(sb);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("})");
    }
}
