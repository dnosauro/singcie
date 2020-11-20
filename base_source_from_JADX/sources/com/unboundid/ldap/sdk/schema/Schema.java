package com.unboundid.ldap.sdk.schema;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ReadOnlyEntry;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldif.LDIFReader;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class Schema implements Serializable {
    public static final String ATTR_ATTRIBUTE_SYNTAX = "ldapSyntaxes";
    public static final String ATTR_ATTRIBUTE_TYPE = "attributeTypes";
    public static final String ATTR_DIT_CONTENT_RULE = "dITContentRules";
    public static final String ATTR_DIT_STRUCTURE_RULE = "dITStructureRules";
    public static final String ATTR_MATCHING_RULE = "matchingRules";
    public static final String ATTR_MATCHING_RULE_USE = "matchingRuleUse";
    public static final String ATTR_NAME_FORM = "nameForms";
    public static final String ATTR_OBJECT_CLASS = "objectClasses";
    public static final String ATTR_SUBSCHEMA_SUBENTRY = "subschemaSubentry";
    private static final String DEFAULT_SCHEMA_RESOURCE_PATH = "com/unboundid/ldap/sdk/schema/standard-schema.ldif";
    private static final AtomicReference<Schema> DEFAULT_STANDARD_SCHEMA = new AtomicReference<>();
    private static final String[] SCHEMA_REQUEST_ATTRS = {ATTR_ATTRIBUTE_SYNTAX, ATTR_ATTRIBUTE_TYPE, ATTR_DIT_CONTENT_RULE, ATTR_DIT_STRUCTURE_RULE, ATTR_MATCHING_RULE, ATTR_MATCHING_RULE_USE, ATTR_NAME_FORM, ATTR_OBJECT_CLASS};
    private static final String[] SUBSCHEMA_SUBENTRY_REQUEST_ATTRS = {"subschemaSubentry"};
    private static final long serialVersionUID = 8081839633831517925L;
    private final Set<ObjectClassDefinition> abstractOCSet;
    private final Map<String, AttributeSyntaxDefinition> asMap;
    private final Set<AttributeSyntaxDefinition> asSet;
    private final Map<String, AttributeTypeDefinition> atMap;
    private final Set<AttributeTypeDefinition> atSet;
    private final Set<ObjectClassDefinition> auxiliaryOCSet;
    private final Map<String, DITContentRuleDefinition> dcrMap;
    private final Set<DITContentRuleDefinition> dcrSet;
    private final Map<Integer, DITStructureRuleDefinition> dsrMapByID;
    private final Map<String, DITStructureRuleDefinition> dsrMapByName;
    private final Map<String, DITStructureRuleDefinition> dsrMapByNameForm;
    private final Set<DITStructureRuleDefinition> dsrSet;
    private final Map<String, MatchingRuleDefinition> mrMap;
    private final Set<MatchingRuleDefinition> mrSet;
    private final Map<String, MatchingRuleUseDefinition> mruMap;
    private final Set<MatchingRuleUseDefinition> mruSet;
    private final Map<String, NameFormDefinition> nfMapByName;
    private final Map<String, NameFormDefinition> nfMapByOC;
    private final Set<NameFormDefinition> nfSet;
    private final Map<String, ObjectClassDefinition> ocMap;
    private final Set<ObjectClassDefinition> ocSet;
    private final Set<AttributeTypeDefinition> operationalATSet;
    private final ReadOnlyEntry schemaEntry;
    private final Set<ObjectClassDefinition> structuralOCSet;
    private final Map<AttributeTypeDefinition, List<AttributeTypeDefinition>> subordinateAttributeTypes;
    private final Set<AttributeTypeDefinition> userATSet;

    public Schema(Entry entry) {
        Set<AttributeSyntaxDefinition> unmodifiableSet;
        Set<AttributeTypeDefinition> unmodifiableSet2;
        Set<DITContentRuleDefinition> unmodifiableSet3;
        Set<DITStructureRuleDefinition> unmodifiableSet4;
        Set<MatchingRuleDefinition> unmodifiableSet5;
        Set<MatchingRuleUseDefinition> unmodifiableSet6;
        Set<NameFormDefinition> unmodifiableSet7;
        Set<ObjectClassDefinition> unmodifiableSet8;
        this.schemaEntry = new ReadOnlyEntry(entry);
        String[] attributeValues = entry.getAttributeValues(ATTR_ATTRIBUTE_SYNTAX);
        if (attributeValues == null) {
            this.asMap = Collections.emptyMap();
            unmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(attributeValues.length);
            LinkedHashSet linkedHashSet = new LinkedHashSet(attributeValues.length);
            for (String attributeSyntaxDefinition : attributeValues) {
                try {
                    AttributeSyntaxDefinition attributeSyntaxDefinition2 = new AttributeSyntaxDefinition(attributeSyntaxDefinition);
                    linkedHashSet.add(attributeSyntaxDefinition2);
                    linkedHashMap.put(StaticUtils.toLowerCase(attributeSyntaxDefinition2.getOID()), attributeSyntaxDefinition2);
                } catch (LDAPException e) {
                    Debug.debugException(e);
                }
            }
            this.asMap = Collections.unmodifiableMap(linkedHashMap);
            unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        this.asSet = unmodifiableSet;
        String[] attributeValues2 = entry.getAttributeValues(ATTR_ATTRIBUTE_TYPE);
        if (attributeValues2 == null) {
            this.atMap = Collections.emptyMap();
            this.atSet = Collections.emptySet();
            this.operationalATSet = Collections.emptySet();
            unmodifiableSet2 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(attributeValues2.length * 2);
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(attributeValues2.length);
            LinkedHashSet linkedHashSet3 = new LinkedHashSet(attributeValues2.length);
            LinkedHashSet linkedHashSet4 = new LinkedHashSet(attributeValues2.length);
            for (String attributeTypeDefinition : attributeValues2) {
                try {
                    AttributeTypeDefinition attributeTypeDefinition2 = new AttributeTypeDefinition(attributeTypeDefinition);
                    linkedHashSet2.add(attributeTypeDefinition2);
                    linkedHashMap2.put(StaticUtils.toLowerCase(attributeTypeDefinition2.getOID()), attributeTypeDefinition2);
                    for (String lowerCase : attributeTypeDefinition2.getNames()) {
                        linkedHashMap2.put(StaticUtils.toLowerCase(lowerCase), attributeTypeDefinition2);
                    }
                    if (attributeTypeDefinition2.isOperational()) {
                        linkedHashSet4.add(attributeTypeDefinition2);
                    } else {
                        linkedHashSet3.add(attributeTypeDefinition2);
                    }
                } catch (LDAPException e2) {
                    Debug.debugException(e2);
                }
            }
            this.atMap = Collections.unmodifiableMap(linkedHashMap2);
            this.atSet = Collections.unmodifiableSet(linkedHashSet2);
            this.operationalATSet = Collections.unmodifiableSet(linkedHashSet4);
            unmodifiableSet2 = Collections.unmodifiableSet(linkedHashSet3);
        }
        this.userATSet = unmodifiableSet2;
        String[] attributeValues3 = entry.getAttributeValues(ATTR_DIT_CONTENT_RULE);
        if (attributeValues3 == null) {
            this.dcrMap = Collections.emptyMap();
            unmodifiableSet3 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(attributeValues3.length * 2);
            LinkedHashSet linkedHashSet5 = new LinkedHashSet(attributeValues3.length);
            for (String dITContentRuleDefinition : attributeValues3) {
                try {
                    DITContentRuleDefinition dITContentRuleDefinition2 = new DITContentRuleDefinition(dITContentRuleDefinition);
                    linkedHashSet5.add(dITContentRuleDefinition2);
                    linkedHashMap3.put(StaticUtils.toLowerCase(dITContentRuleDefinition2.getOID()), dITContentRuleDefinition2);
                    for (String lowerCase2 : dITContentRuleDefinition2.getNames()) {
                        linkedHashMap3.put(StaticUtils.toLowerCase(lowerCase2), dITContentRuleDefinition2);
                    }
                } catch (LDAPException e3) {
                    Debug.debugException(e3);
                }
            }
            this.dcrMap = Collections.unmodifiableMap(linkedHashMap3);
            unmodifiableSet3 = Collections.unmodifiableSet(linkedHashSet5);
        }
        this.dcrSet = unmodifiableSet3;
        String[] attributeValues4 = entry.getAttributeValues(ATTR_DIT_STRUCTURE_RULE);
        if (attributeValues4 == null) {
            this.dsrMapByID = Collections.emptyMap();
            this.dsrMapByName = Collections.emptyMap();
            this.dsrMapByNameForm = Collections.emptyMap();
            unmodifiableSet4 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(attributeValues4.length);
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(attributeValues4.length);
            LinkedHashMap linkedHashMap6 = new LinkedHashMap(attributeValues4.length);
            LinkedHashSet linkedHashSet6 = new LinkedHashSet(attributeValues4.length);
            for (String dITStructureRuleDefinition : attributeValues4) {
                try {
                    DITStructureRuleDefinition dITStructureRuleDefinition2 = new DITStructureRuleDefinition(dITStructureRuleDefinition);
                    linkedHashSet6.add(dITStructureRuleDefinition2);
                    linkedHashMap4.put(Integer.valueOf(dITStructureRuleDefinition2.getRuleID()), dITStructureRuleDefinition2);
                    linkedHashMap6.put(StaticUtils.toLowerCase(dITStructureRuleDefinition2.getNameFormID()), dITStructureRuleDefinition2);
                    for (String lowerCase3 : dITStructureRuleDefinition2.getNames()) {
                        linkedHashMap5.put(StaticUtils.toLowerCase(lowerCase3), dITStructureRuleDefinition2);
                    }
                } catch (LDAPException e4) {
                    Debug.debugException(e4);
                }
            }
            this.dsrMapByID = Collections.unmodifiableMap(linkedHashMap4);
            this.dsrMapByName = Collections.unmodifiableMap(linkedHashMap5);
            this.dsrMapByNameForm = Collections.unmodifiableMap(linkedHashMap6);
            unmodifiableSet4 = Collections.unmodifiableSet(linkedHashSet6);
        }
        this.dsrSet = unmodifiableSet4;
        String[] attributeValues5 = entry.getAttributeValues(ATTR_MATCHING_RULE);
        if (attributeValues5 == null) {
            this.mrMap = Collections.emptyMap();
            unmodifiableSet5 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap7 = new LinkedHashMap(attributeValues5.length * 2);
            LinkedHashSet linkedHashSet7 = new LinkedHashSet(attributeValues5.length);
            for (String matchingRuleDefinition : attributeValues5) {
                try {
                    MatchingRuleDefinition matchingRuleDefinition2 = new MatchingRuleDefinition(matchingRuleDefinition);
                    linkedHashSet7.add(matchingRuleDefinition2);
                    linkedHashMap7.put(StaticUtils.toLowerCase(matchingRuleDefinition2.getOID()), matchingRuleDefinition2);
                    for (String lowerCase4 : matchingRuleDefinition2.getNames()) {
                        linkedHashMap7.put(StaticUtils.toLowerCase(lowerCase4), matchingRuleDefinition2);
                    }
                } catch (LDAPException e5) {
                    Debug.debugException(e5);
                }
            }
            this.mrMap = Collections.unmodifiableMap(linkedHashMap7);
            unmodifiableSet5 = Collections.unmodifiableSet(linkedHashSet7);
        }
        this.mrSet = unmodifiableSet5;
        String[] attributeValues6 = entry.getAttributeValues(ATTR_MATCHING_RULE_USE);
        if (attributeValues6 == null) {
            this.mruMap = Collections.emptyMap();
            unmodifiableSet6 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap8 = new LinkedHashMap(attributeValues6.length * 2);
            LinkedHashSet linkedHashSet8 = new LinkedHashSet(attributeValues6.length);
            for (String matchingRuleUseDefinition : attributeValues6) {
                try {
                    MatchingRuleUseDefinition matchingRuleUseDefinition2 = new MatchingRuleUseDefinition(matchingRuleUseDefinition);
                    linkedHashSet8.add(matchingRuleUseDefinition2);
                    linkedHashMap8.put(StaticUtils.toLowerCase(matchingRuleUseDefinition2.getOID()), matchingRuleUseDefinition2);
                    for (String lowerCase5 : matchingRuleUseDefinition2.getNames()) {
                        linkedHashMap8.put(StaticUtils.toLowerCase(lowerCase5), matchingRuleUseDefinition2);
                    }
                } catch (LDAPException e6) {
                    Debug.debugException(e6);
                }
            }
            this.mruMap = Collections.unmodifiableMap(linkedHashMap8);
            unmodifiableSet6 = Collections.unmodifiableSet(linkedHashSet8);
        }
        this.mruSet = unmodifiableSet6;
        String[] attributeValues7 = entry.getAttributeValues(ATTR_NAME_FORM);
        if (attributeValues7 == null) {
            this.nfMapByName = Collections.emptyMap();
            this.nfMapByOC = Collections.emptyMap();
            unmodifiableSet7 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap9 = new LinkedHashMap(attributeValues7.length * 2);
            LinkedHashMap linkedHashMap10 = new LinkedHashMap(attributeValues7.length);
            LinkedHashSet linkedHashSet9 = new LinkedHashSet(attributeValues7.length);
            for (String nameFormDefinition : attributeValues7) {
                try {
                    NameFormDefinition nameFormDefinition2 = new NameFormDefinition(nameFormDefinition);
                    linkedHashSet9.add(nameFormDefinition2);
                    linkedHashMap10.put(StaticUtils.toLowerCase(nameFormDefinition2.getStructuralClass()), nameFormDefinition2);
                    linkedHashMap9.put(StaticUtils.toLowerCase(nameFormDefinition2.getOID()), nameFormDefinition2);
                    for (String lowerCase6 : nameFormDefinition2.getNames()) {
                        linkedHashMap9.put(StaticUtils.toLowerCase(lowerCase6), nameFormDefinition2);
                    }
                } catch (LDAPException e7) {
                    Debug.debugException(e7);
                }
            }
            this.nfMapByName = Collections.unmodifiableMap(linkedHashMap9);
            this.nfMapByOC = Collections.unmodifiableMap(linkedHashMap10);
            unmodifiableSet7 = Collections.unmodifiableSet(linkedHashSet9);
        }
        this.nfSet = unmodifiableSet7;
        String[] attributeValues8 = entry.getAttributeValues(ATTR_OBJECT_CLASS);
        if (attributeValues8 == null) {
            this.ocMap = Collections.emptyMap();
            this.ocSet = Collections.emptySet();
            this.abstractOCSet = Collections.emptySet();
            this.auxiliaryOCSet = Collections.emptySet();
            unmodifiableSet8 = Collections.emptySet();
        } else {
            LinkedHashMap linkedHashMap11 = new LinkedHashMap(attributeValues8.length * 2);
            LinkedHashSet linkedHashSet10 = new LinkedHashSet(attributeValues8.length);
            LinkedHashSet linkedHashSet11 = new LinkedHashSet(attributeValues8.length);
            LinkedHashSet linkedHashSet12 = new LinkedHashSet(attributeValues8.length);
            LinkedHashSet linkedHashSet13 = new LinkedHashSet(attributeValues8.length);
            for (String objectClassDefinition : attributeValues8) {
                try {
                    ObjectClassDefinition objectClassDefinition2 = new ObjectClassDefinition(objectClassDefinition);
                    linkedHashSet10.add(objectClassDefinition2);
                    linkedHashMap11.put(StaticUtils.toLowerCase(objectClassDefinition2.getOID()), objectClassDefinition2);
                    for (String lowerCase7 : objectClassDefinition2.getNames()) {
                        linkedHashMap11.put(StaticUtils.toLowerCase(lowerCase7), objectClassDefinition2);
                    }
                    switch (getOCType(objectClassDefinition2, linkedHashMap11)) {
                        case ABSTRACT:
                            linkedHashSet11.add(objectClassDefinition2);
                            break;
                        case AUXILIARY:
                            linkedHashSet12.add(objectClassDefinition2);
                            break;
                        case STRUCTURAL:
                            linkedHashSet13.add(objectClassDefinition2);
                            break;
                    }
                } catch (LDAPException e8) {
                    Debug.debugException(e8);
                }
            }
            this.ocMap = Collections.unmodifiableMap(linkedHashMap11);
            this.ocSet = Collections.unmodifiableSet(linkedHashSet10);
            this.abstractOCSet = Collections.unmodifiableSet(linkedHashSet11);
            this.auxiliaryOCSet = Collections.unmodifiableSet(linkedHashSet12);
            unmodifiableSet8 = Collections.unmodifiableSet(linkedHashSet13);
        }
        this.structuralOCSet = unmodifiableSet8;
        LinkedHashMap linkedHashMap12 = new LinkedHashMap(this.atSet.size());
        for (AttributeTypeDefinition next : this.atSet) {
            AttributeTypeDefinition superiorType = next.getSuperiorType(this);
            while (superiorType != null) {
                List list = (List) linkedHashMap12.get(superiorType);
                if (list == null) {
                    list = new ArrayList(1);
                    linkedHashMap12.put(superiorType, list);
                }
                list.add(next);
                superiorType = superiorType.getSuperiorType(this);
            }
        }
        this.subordinateAttributeTypes = Collections.unmodifiableMap(linkedHashMap12);
    }

    private static ObjectClassType getOCType(ObjectClassDefinition objectClassDefinition, Map<String, ObjectClassDefinition> map) {
        ObjectClassType oCType;
        ObjectClassType objectClassType = objectClassDefinition.getObjectClassType();
        if (objectClassType != null) {
            return objectClassType;
        }
        for (String lowerCase : objectClassDefinition.getSuperiorClasses()) {
            ObjectClassDefinition objectClassDefinition2 = map.get(StaticUtils.toLowerCase(lowerCase));
            if (objectClassDefinition2 != null && (oCType = getOCType(objectClassDefinition2, map)) != null) {
                return oCType;
            }
        }
        return ObjectClassType.STRUCTURAL;
    }

    public static Schema getSchema(LDAPConnection lDAPConnection) {
        return getSchema(lDAPConnection, "");
    }

    public static Schema getSchema(LDAPConnection lDAPConnection, String str) {
        SearchResultEntry entry;
        Validator.ensureNotNull(lDAPConnection);
        if (str == null) {
            str = "";
        }
        String subschemaSubentryDN = getSubschemaSubentryDN(lDAPConnection, str);
        if (subschemaSubentryDN == null || (entry = lDAPConnection.getEntry(subschemaSubentryDN, SCHEMA_REQUEST_ATTRS)) == null) {
            return null;
        }
        return new Schema(entry);
    }

    public static Schema getSchema(List<File> list) {
        Validator.ensureNotNull(list);
        Validator.ensureFalse(list.isEmpty());
        Entry entry = null;
        for (File lDIFReader : list) {
            LDIFReader lDIFReader2 = new LDIFReader(lDIFReader);
            try {
                Entry readEntry = lDIFReader2.readEntry();
                if (readEntry != null) {
                    if (entry == null) {
                        entry = readEntry;
                    } else {
                        for (Attribute addAttribute : readEntry.getAttributes()) {
                            entry.addAttribute(addAttribute);
                        }
                    }
                }
            } finally {
                lDIFReader2.close();
            }
        }
        if (entry == null) {
            return null;
        }
        return new Schema(entry);
    }

    public static Schema getSchema(File... fileArr) {
        Validator.ensureNotNull(fileArr);
        Validator.ensureFalse(fileArr.length == 0);
        return getSchema((List<File>) Arrays.asList(fileArr));
    }

    public static Schema getSchema(String... strArr) {
        Validator.ensureNotNull(strArr);
        Validator.ensureFalse(strArr.length == 0);
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String file : strArr) {
            arrayList.add(new File(file));
        }
        return getSchema((List<File>) arrayList);
    }

    public static String getSubschemaSubentryDN(LDAPConnection lDAPConnection, String str) {
        Validator.ensureNotNull(lDAPConnection);
        if (str == null) {
            str = "";
        }
        SearchResultEntry entry = lDAPConnection.getEntry(str, SUBSCHEMA_SUBENTRY_REQUEST_ATTRS);
        if (entry == null) {
            return null;
        }
        return entry.getAttributeValue("subschemaSubentry");
    }

    public static Schema mergeSchemas(Schema... schemaArr) {
        if (schemaArr == null || schemaArr.length == 0) {
            return null;
        }
        if (schemaArr.length == 1) {
            return schemaArr[0];
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
        for (Schema schema : schemaArr) {
            for (AttributeSyntaxDefinition next : schema.asSet) {
                linkedHashMap.put(StaticUtils.toLowerCase(next.getOID()), next.toString());
            }
            for (AttributeTypeDefinition next2 : schema.atSet) {
                linkedHashMap2.put(StaticUtils.toLowerCase(next2.getOID()), next2.toString());
            }
            for (DITContentRuleDefinition next3 : schema.dcrSet) {
                linkedHashMap3.put(StaticUtils.toLowerCase(next3.getOID()), next3.toString());
            }
            for (DITStructureRuleDefinition next4 : schema.dsrSet) {
                linkedHashMap4.put(Integer.valueOf(next4.getRuleID()), next4.toString());
            }
            for (MatchingRuleDefinition next5 : schema.mrSet) {
                linkedHashMap5.put(StaticUtils.toLowerCase(next5.getOID()), next5.toString());
            }
            for (MatchingRuleUseDefinition next6 : schema.mruSet) {
                linkedHashMap6.put(StaticUtils.toLowerCase(next6.getOID()), next6.toString());
            }
            for (NameFormDefinition next7 : schema.nfSet) {
                linkedHashMap7.put(StaticUtils.toLowerCase(next7.getOID()), next7.toString());
            }
            for (ObjectClassDefinition next8 : schema.ocSet) {
                linkedHashMap8.put(StaticUtils.toLowerCase(next8.getOID()), next8.toString());
            }
        }
        Entry entry = new Entry(schemaArr[0].getSchemaEntry().getDN());
        Attribute objectClassAttribute = schemaArr[0].getSchemaEntry().getObjectClassAttribute();
        if (objectClassAttribute == null) {
            entry.addAttribute("objectClass", "top", "ldapSubEntry", "subschema");
        } else {
            entry.addAttribute(objectClassAttribute);
        }
        if (!linkedHashMap.isEmpty()) {
            entry.addAttribute(ATTR_ATTRIBUTE_SYNTAX, (String[]) linkedHashMap.values().toArray(new String[linkedHashMap.size()]));
        }
        if (!linkedHashMap5.isEmpty()) {
            entry.addAttribute(ATTR_MATCHING_RULE, (String[]) linkedHashMap5.values().toArray(new String[linkedHashMap5.size()]));
        }
        if (!linkedHashMap2.isEmpty()) {
            entry.addAttribute(ATTR_ATTRIBUTE_TYPE, (String[]) linkedHashMap2.values().toArray(new String[linkedHashMap2.size()]));
        }
        if (!linkedHashMap8.isEmpty()) {
            entry.addAttribute(ATTR_OBJECT_CLASS, (String[]) linkedHashMap8.values().toArray(new String[linkedHashMap8.size()]));
        }
        if (!linkedHashMap3.isEmpty()) {
            entry.addAttribute(ATTR_DIT_CONTENT_RULE, (String[]) linkedHashMap3.values().toArray(new String[linkedHashMap3.size()]));
        }
        if (!linkedHashMap4.isEmpty()) {
            entry.addAttribute(ATTR_DIT_STRUCTURE_RULE, (String[]) linkedHashMap4.values().toArray(new String[linkedHashMap4.size()]));
        }
        if (!linkedHashMap7.isEmpty()) {
            entry.addAttribute(ATTR_NAME_FORM, (String[]) linkedHashMap7.values().toArray(new String[linkedHashMap7.size()]));
        }
        if (!linkedHashMap6.isEmpty()) {
            entry.addAttribute(ATTR_MATCHING_RULE_USE, (String[]) linkedHashMap6.values().toArray(new String[linkedHashMap6.size()]));
        }
        return new Schema(entry);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Schema)) {
            return false;
        }
        Schema schema = (Schema) obj;
        try {
            if (!this.schemaEntry.getParsedDN().equals((Object) schema.schemaEntry.getParsedDN())) {
                return false;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            if (!this.schemaEntry.getDN().equalsIgnoreCase(schema.schemaEntry.getDN())) {
                return false;
            }
        }
        return this.asSet.equals(schema.asSet) && this.mrSet.equals(schema.mrSet) && this.atSet.equals(schema.atSet) && this.ocSet.equals(schema.ocSet) && this.nfSet.equals(schema.nfSet) && this.dcrSet.equals(schema.dcrSet) && this.dsrSet.equals(schema.dsrSet) && this.mruSet.equals(schema.mruSet);
    }

    public Set<ObjectClassDefinition> getAbstractObjectClasses() {
        return this.abstractOCSet;
    }

    public AttributeSyntaxDefinition getAttributeSyntax(String str) {
        Validator.ensureNotNull(str);
        String lowerCase = StaticUtils.toLowerCase(str);
        int indexOf = lowerCase.indexOf(123);
        return (AttributeSyntaxDefinition) (indexOf > 0 ? this.asMap.get(lowerCase.substring(0, indexOf)) : this.asMap.get(lowerCase));
    }

    public Set<AttributeSyntaxDefinition> getAttributeSyntaxes() {
        return this.asSet;
    }

    public AttributeTypeDefinition getAttributeType(String str) {
        Validator.ensureNotNull(str);
        return this.atMap.get(StaticUtils.toLowerCase(str));
    }

    public Set<AttributeTypeDefinition> getAttributeTypes() {
        return this.atSet;
    }

    public Set<ObjectClassDefinition> getAuxiliaryObjectClasses() {
        return this.auxiliaryOCSet;
    }

    public DITContentRuleDefinition getDITContentRule(String str) {
        Validator.ensureNotNull(str);
        return this.dcrMap.get(StaticUtils.toLowerCase(str));
    }

    public Set<DITContentRuleDefinition> getDITContentRules() {
        return this.dcrSet;
    }

    public DITStructureRuleDefinition getDITStructureRuleByID(int i) {
        return this.dsrMapByID.get(Integer.valueOf(i));
    }

    public DITStructureRuleDefinition getDITStructureRuleByName(String str) {
        Validator.ensureNotNull(str);
        return this.dsrMapByName.get(StaticUtils.toLowerCase(str));
    }

    public DITStructureRuleDefinition getDITStructureRuleByNameForm(String str) {
        Validator.ensureNotNull(str);
        return this.dsrMapByNameForm.get(StaticUtils.toLowerCase(str));
    }

    public Set<DITStructureRuleDefinition> getDITStructureRules() {
        return this.dsrSet;
    }

    public MatchingRuleDefinition getMatchingRule(String str) {
        Validator.ensureNotNull(str);
        return this.mrMap.get(StaticUtils.toLowerCase(str));
    }

    public MatchingRuleUseDefinition getMatchingRuleUse(String str) {
        Validator.ensureNotNull(str);
        return this.mruMap.get(StaticUtils.toLowerCase(str));
    }

    public Set<MatchingRuleUseDefinition> getMatchingRuleUses() {
        return this.mruSet;
    }

    public Set<MatchingRuleDefinition> getMatchingRules() {
        return this.mrSet;
    }

    public NameFormDefinition getNameFormByName(String str) {
        Validator.ensureNotNull(str);
        return this.nfMapByName.get(StaticUtils.toLowerCase(str));
    }

    public NameFormDefinition getNameFormByObjectClass(String str) {
        Validator.ensureNotNull(str);
        return this.nfMapByOC.get(StaticUtils.toLowerCase(str));
    }

    public Set<NameFormDefinition> getNameForms() {
        return this.nfSet;
    }

    public ObjectClassDefinition getObjectClass(String str) {
        Validator.ensureNotNull(str);
        return this.ocMap.get(StaticUtils.toLowerCase(str));
    }

    public Set<ObjectClassDefinition> getObjectClasses() {
        return this.ocSet;
    }

    public Set<AttributeTypeDefinition> getOperationalAttributeTypes() {
        return this.operationalATSet;
    }

    public ReadOnlyEntry getSchemaEntry() {
        return this.schemaEntry;
    }

    public Set<ObjectClassDefinition> getStructuralObjectClasses() {
        return this.structuralOCSet;
    }

    public List<AttributeTypeDefinition> getSubordinateAttributeTypes(AttributeTypeDefinition attributeTypeDefinition) {
        Validator.ensureNotNull(attributeTypeDefinition);
        List list = this.subordinateAttributeTypes.get(attributeTypeDefinition);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public Set<AttributeTypeDefinition> getUserAttributeTypes() {
        return this.userATSet;
    }

    public int hashCode() {
        int i;
        try {
            i = this.schemaEntry.getParsedDN().hashCode();
        } catch (Exception e) {
            Debug.debugException(e);
            i = StaticUtils.toLowerCase(this.schemaEntry.getDN()).hashCode();
        }
        Attribute attribute = this.schemaEntry.getAttribute(ATTR_ATTRIBUTE_SYNTAX);
        if (attribute != null) {
            i += attribute.hashCode();
        }
        Attribute attribute2 = this.schemaEntry.getAttribute(ATTR_MATCHING_RULE);
        if (attribute2 != null) {
            i += attribute2.hashCode();
        }
        Attribute attribute3 = this.schemaEntry.getAttribute(ATTR_ATTRIBUTE_TYPE);
        if (attribute3 != null) {
            i += attribute3.hashCode();
        }
        Attribute attribute4 = this.schemaEntry.getAttribute(ATTR_OBJECT_CLASS);
        if (attribute4 != null) {
            i += attribute4.hashCode();
        }
        Attribute attribute5 = this.schemaEntry.getAttribute(ATTR_NAME_FORM);
        if (attribute5 != null) {
            i += attribute5.hashCode();
        }
        Attribute attribute6 = this.schemaEntry.getAttribute(ATTR_DIT_CONTENT_RULE);
        if (attribute6 != null) {
            i += attribute6.hashCode();
        }
        Attribute attribute7 = this.schemaEntry.getAttribute(ATTR_DIT_STRUCTURE_RULE);
        if (attribute7 != null) {
            i += attribute7.hashCode();
        }
        Attribute attribute8 = this.schemaEntry.getAttribute(ATTR_MATCHING_RULE_USE);
        return attribute8 != null ? i + attribute8.hashCode() : i;
    }

    public String toString() {
        return this.schemaEntry.toString();
    }
}
