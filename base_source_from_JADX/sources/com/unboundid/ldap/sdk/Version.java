package com.unboundid.ldap.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Version {
    public static final String BUILD_TIMESTAMP = "20120502164733Z";
    public static final String FULL_VERSION_STRING = "UnboundID LDAP SDK for Java 2.3.1";
    public static final int MAJOR_VERSION = 2;
    public static final int MINOR_VERSION = 3;
    public static final String NUMERIC_VERSION_STRING = "2.3.1";
    public static final int POINT_VERSION = 1;
    public static final String PRODUCT_NAME = "UnboundID LDAP SDK for Java";
    public static final String REPOSITORY_PATH = "/directory/trunk/ldapsdk";
    public static final long REVISION_NUMBER = 11802;
    public static final String SHORT_NAME = "unboundid-ldapsdk";
    public static final String SHORT_VERSION_STRING = "unboundid-ldapsdk-2.3.1";
    public static final String VERSION_QUALIFIER = "";

    private Version() {
    }

    public static List<String> getVersionLines() {
        ArrayList arrayList = new ArrayList(11);
        arrayList.add("Full Version String:   UnboundID LDAP SDK for Java 2.3.1");
        arrayList.add("Short Version String:  unboundid-ldapsdk-2.3.1");
        arrayList.add("Product Name:          UnboundID LDAP SDK for Java");
        arrayList.add("Short Name:            unboundid-ldapsdk");
        arrayList.add("Major Version:         2");
        arrayList.add("Minor Version:         3");
        arrayList.add("Point Version:         1");
        arrayList.add("Version Qualifier:     ");
        arrayList.add("Build Timestamp:       20120502164733Z");
        arrayList.add("Repository Path:       /directory/trunk/ldapsdk");
        arrayList.add("Revision Number:       11802");
        return Collections.unmodifiableList(arrayList);
    }

    public static void main(String... strArr) {
        for (String println : getVersionLines()) {
            System.out.println(println);
        }
    }
}
