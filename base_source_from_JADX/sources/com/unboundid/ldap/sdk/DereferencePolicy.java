package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.HashMap;

public final class DereferencePolicy implements Serializable {
    public static final DereferencePolicy ALWAYS = new DereferencePolicy("ALWAYS", 3);
    public static final DereferencePolicy FINDING = new DereferencePolicy("FINDING", 2);
    public static final DereferencePolicy NEVER = new DereferencePolicy("NEVER", 0);
    public static final DereferencePolicy SEARCHING = new DereferencePolicy("SEARCHING", 1);
    private static final HashMap<Integer, DereferencePolicy> UNDEFINED_POLICIES = new HashMap<>();
    private static final long serialVersionUID = 3722883359911755096L;
    private final int intValue;
    private final String name;

    private DereferencePolicy(int i) {
        this.intValue = i;
        this.name = String.valueOf(i);
    }

    private DereferencePolicy(String str, int i) {
        this.name = str;
        this.intValue = i;
    }

    public static DereferencePolicy valueOf(int i) {
        DereferencePolicy dereferencePolicy;
        switch (i) {
            case 0:
                return NEVER;
            case 1:
                return SEARCHING;
            case 2:
                return FINDING;
            case 3:
                return ALWAYS;
            default:
                synchronized (UNDEFINED_POLICIES) {
                    dereferencePolicy = UNDEFINED_POLICIES.get(Integer.valueOf(i));
                    if (dereferencePolicy == null) {
                        dereferencePolicy = new DereferencePolicy(i);
                        UNDEFINED_POLICIES.put(Integer.valueOf(i), dereferencePolicy);
                    }
                }
                return dereferencePolicy;
        }
    }

    public static DereferencePolicy[] values() {
        return new DereferencePolicy[]{NEVER, SEARCHING, FINDING, ALWAYS};
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof DereferencePolicy) && this.intValue == ((DereferencePolicy) obj).intValue;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.intValue;
    }

    public int intValue() {
        return this.intValue;
    }

    public String toString() {
        return this.name;
    }
}
