package com.unboundid.util;

public enum DebugType {
    ASN1("asn1"),
    CONNECT("connect"),
    EXCEPTION("exception"),
    LDAP("ldap"),
    LDIF("ldif"),
    MONITOR("monitor"),
    CODING_ERROR("coding-error"),
    OTHER("other");
    
    private final String name;

    private DebugType(String str) {
        this.name = str;
    }

    public static DebugType forName(String str) {
        String lowerCase = StaticUtils.toLowerCase(str);
        if (lowerCase.equals("asn1")) {
            return ASN1;
        }
        if (lowerCase.equals("connect")) {
            return CONNECT;
        }
        if (lowerCase.equals("exception")) {
            return EXCEPTION;
        }
        if (lowerCase.equals("ldap")) {
            return LDAP;
        }
        if (lowerCase.equals("ldif")) {
            return LDIF;
        }
        if (lowerCase.equals("monitor")) {
            return MONITOR;
        }
        if (lowerCase.equals("coding-error")) {
            return CODING_ERROR;
        }
        if (lowerCase.equals("other")) {
            return OTHER;
        }
        return null;
    }

    public static String getTypeNameList() {
        StringBuilder sb = new StringBuilder();
        DebugType[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(values[i].getName());
        }
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
