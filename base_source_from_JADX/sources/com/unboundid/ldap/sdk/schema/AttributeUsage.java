package com.unboundid.ldap.sdk.schema;

public enum AttributeUsage {
    USER_APPLICATIONS("userApplications", false),
    DIRECTORY_OPERATION("directoryOperation", true),
    DISTRIBUTED_OPERATION("distributedOperation", true),
    DSA_OPERATION("dSAOperation", true);
    
    private final boolean isOperational;
    private final String name;

    private AttributeUsage(String str, boolean z) {
        this.name = str;
        this.isOperational = z;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOperational() {
        return this.isOperational;
    }

    public String toString() {
        return this.name;
    }
}
