package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;

public enum ChangeType {
    ADD("add"),
    DELETE("delete"),
    MODIFY("modify"),
    MODIFY_DN("moddn");
    
    private final String name;

    private ChangeType(String str) {
        this.name = str;
    }

    public static ChangeType forName(String str) {
        String lowerCase = StaticUtils.toLowerCase(str);
        if (lowerCase.equals("add")) {
            return ADD;
        }
        if (lowerCase.equals("delete")) {
            return DELETE;
        }
        if (lowerCase.equals("modify")) {
            return MODIFY;
        }
        if (lowerCase.equals("moddn") || lowerCase.equals("modrdn")) {
            return MODIFY_DN;
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
