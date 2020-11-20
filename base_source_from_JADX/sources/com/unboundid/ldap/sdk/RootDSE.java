package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;

public final class RootDSE extends ReadOnlyEntry {
    public static final String ATTR_ALT_SERVER = "altServer";
    public static final String ATTR_CHANGELOG_DN = "changelog";
    public static final String ATTR_FIRST_CHANGE_NUMBER = "firstChangeNumber";
    public static final String ATTR_LAST_CHANGE_NUMBER = "lastChangeNumber";
    public static final String ATTR_LAST_PURGED_CHANGE_NUMBER = "lastPurgedChangeNumber";
    public static final String ATTR_NAMING_CONTEXT = "namingContexts";
    public static final String ATTR_SUBSCHEMA_SUBENTRY = "subschemaSubentry";
    public static final String ATTR_SUPPORTED_AUTH_PASSWORD_STORAGE_SCHEME = "supportedAuthPasswordSchemes";
    public static final String ATTR_SUPPORTED_CONTROL = "supportedControl";
    public static final String ATTR_SUPPORTED_EXTENDED_OPERATION = "supportedExtension";
    public static final String ATTR_SUPPORTED_FEATURE = "supportedFeatures";
    public static final String ATTR_SUPPORTED_LDAP_VERSION = "supportedLDAPVersion";
    public static final String ATTR_SUPPORTED_SASL_MECHANISM = "supportedSASLMechanisms";
    public static final String ATTR_VENDOR_NAME = "vendorName";
    public static final String ATTR_VENDOR_VERSION = "vendorVersion";
    private static final String[] REQUEST_ATTRS = {"*", "+", ATTR_ALT_SERVER, ATTR_CHANGELOG_DN, ATTR_FIRST_CHANGE_NUMBER, ATTR_LAST_CHANGE_NUMBER, ATTR_LAST_PURGED_CHANGE_NUMBER, ATTR_NAMING_CONTEXT, "subschemaSubentry", ATTR_SUPPORTED_AUTH_PASSWORD_STORAGE_SCHEME, ATTR_SUPPORTED_CONTROL, ATTR_SUPPORTED_EXTENDED_OPERATION, ATTR_SUPPORTED_FEATURE, ATTR_SUPPORTED_LDAP_VERSION, ATTR_SUPPORTED_SASL_MECHANISM, ATTR_VENDOR_NAME, ATTR_VENDOR_VERSION};
    private static final long serialVersionUID = -1678182563511570981L;

    public RootDSE(Entry entry) {
        super(entry);
    }

    public static RootDSE getRootDSE(LDAPInterface lDAPInterface) {
        SearchResultEntry entry = lDAPInterface.getEntry("", REQUEST_ATTRS);
        if (entry == null) {
            return null;
        }
        return new RootDSE(entry);
    }

    public String[] getAltServerURIs() {
        return getAttributeValues(ATTR_ALT_SERVER);
    }

    public String getChangelogDN() {
        return getAttributeValue(ATTR_CHANGELOG_DN);
    }

    public Long getFirstChangeNumber() {
        return getAttributeValueAsLong(ATTR_FIRST_CHANGE_NUMBER);
    }

    public Long getLastChangeNumber() {
        return getAttributeValueAsLong(ATTR_LAST_CHANGE_NUMBER);
    }

    public Long getLastPurgedChangeNumber() {
        return getAttributeValueAsLong(ATTR_LAST_PURGED_CHANGE_NUMBER);
    }

    public String[] getNamingContextDNs() {
        return getAttributeValues(ATTR_NAMING_CONTEXT);
    }

    public String getSubschemaSubentryDN() {
        return getAttributeValue("subschemaSubentry");
    }

    public String[] getSupportedAuthPasswordSchemeNames() {
        return getAttributeValues(ATTR_SUPPORTED_AUTH_PASSWORD_STORAGE_SCHEME);
    }

    public String[] getSupportedControlOIDs() {
        return getAttributeValues(ATTR_SUPPORTED_CONTROL);
    }

    public String[] getSupportedExtendedOperationOIDs() {
        return getAttributeValues(ATTR_SUPPORTED_EXTENDED_OPERATION);
    }

    public String[] getSupportedFeatureOIDs() {
        return getAttributeValues(ATTR_SUPPORTED_FEATURE);
    }

    public int[] getSupportedLDAPVersions() {
        String[] attributeValues = getAttributeValues(ATTR_SUPPORTED_LDAP_VERSION);
        if (attributeValues == null) {
            return null;
        }
        int[] iArr = new int[attributeValues.length];
        int i = 0;
        while (i < attributeValues.length) {
            try {
                iArr[i] = Integer.parseInt(attributeValues[i]);
                i++;
            } catch (Exception e) {
                Debug.debugException(e);
                return null;
            }
        }
        return iArr;
    }

    public String[] getSupportedSASLMechanismNames() {
        return getAttributeValues(ATTR_SUPPORTED_SASL_MECHANISM);
    }

    public String getVendorName() {
        return getAttributeValue(ATTR_VENDOR_NAME);
    }

    public String getVendorVersion() {
        return getAttributeValue(ATTR_VENDOR_VERSION);
    }

    public boolean supportsAuthPasswordScheme(String str) {
        return hasAttributeValue(ATTR_SUPPORTED_AUTH_PASSWORD_STORAGE_SCHEME, str);
    }

    public boolean supportsControl(String str) {
        return hasAttributeValue(ATTR_SUPPORTED_CONTROL, str);
    }

    public boolean supportsExtendedOperation(String str) {
        return hasAttributeValue(ATTR_SUPPORTED_EXTENDED_OPERATION, str);
    }

    public boolean supportsFeature(String str) {
        return hasAttributeValue(ATTR_SUPPORTED_FEATURE, str);
    }

    public boolean supportsLDAPVersion(int i) {
        return hasAttributeValue(ATTR_SUPPORTED_LDAP_VERSION, String.valueOf(i));
    }

    public boolean supportsSASLMechanism(String str) {
        return hasAttributeValue(ATTR_SUPPORTED_SASL_MECHANISM, str);
    }
}
