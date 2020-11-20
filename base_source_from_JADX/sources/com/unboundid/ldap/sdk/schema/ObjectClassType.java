package com.unboundid.ldap.sdk.schema;

public enum ObjectClassType {
    ABSTRACT("ABSTRACT"),
    STRUCTURAL("STRUCTURAL"),
    AUXILIARY("AUXILIARY");
    
    private final String name;

    private ObjectClassType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
