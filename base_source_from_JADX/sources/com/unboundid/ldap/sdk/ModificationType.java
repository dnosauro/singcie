package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.HashMap;

public final class ModificationType implements Serializable {
    public static final ModificationType ADD = new ModificationType("ADD", 0);
    public static final int ADD_INT_VALUE = 0;
    public static final ModificationType DELETE = new ModificationType("DELETE", 1);
    public static final int DELETE_INT_VALUE = 1;
    public static final ModificationType INCREMENT = new ModificationType("INCREMENT", 3);
    public static final int INCREMENT_INT_VALUE = 3;
    public static final ModificationType REPLACE = new ModificationType("REPLACE", 2);
    public static final int REPLACE_INT_VALUE = 2;
    private static final HashMap<Integer, ModificationType> UNDEFINED_MOD_TYPES = new HashMap<>();
    private static final long serialVersionUID = -7863114394728980308L;
    private final int intValue;
    private final String name;

    private ModificationType(int i) {
        this.intValue = i;
        this.name = String.valueOf(i);
    }

    private ModificationType(String str, int i) {
        this.name = str;
        this.intValue = i;
    }

    public static ModificationType definedValueOf(int i) {
        switch (i) {
            case 0:
                return ADD;
            case 1:
                return DELETE;
            case 2:
                return REPLACE;
            case 3:
                return INCREMENT;
            default:
                return null;
        }
    }

    public static ModificationType valueOf(int i) {
        ModificationType modificationType;
        switch (i) {
            case 0:
                return ADD;
            case 1:
                return DELETE;
            case 2:
                return REPLACE;
            case 3:
                return INCREMENT;
            default:
                synchronized (UNDEFINED_MOD_TYPES) {
                    modificationType = UNDEFINED_MOD_TYPES.get(Integer.valueOf(i));
                    if (modificationType == null) {
                        modificationType = new ModificationType(i);
                        UNDEFINED_MOD_TYPES.put(Integer.valueOf(i), modificationType);
                    }
                }
                return modificationType;
        }
    }

    public static ModificationType[] values() {
        return new ModificationType[]{ADD, DELETE, REPLACE, INCREMENT};
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof ModificationType) && this.intValue == ((ModificationType) obj).intValue;
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
