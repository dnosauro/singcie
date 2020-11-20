package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.HashMap;

public final class SearchScope implements Serializable {
    public static final SearchScope BASE = new SearchScope("BASE", 0);
    public static final int BASE_INT_VALUE = 0;
    public static final SearchScope ONE = new SearchScope("ONE", 1);
    public static final int ONE_INT_VALUE = 1;
    public static final SearchScope SUB = new SearchScope("SUB", 2);
    public static final SearchScope SUBORDINATE_SUBTREE = new SearchScope("SUBORDINATE_SUBTREE", 3);
    public static final int SUBORDINATE_SUBTREE_INT_VALUE = 3;
    public static final int SUB_INT_VALUE = 2;
    private static final HashMap<Integer, SearchScope> UNDEFINED_SCOPES = new HashMap<>();
    private static final long serialVersionUID = 5381929718445793181L;
    private final int intValue;
    private final String name;

    private SearchScope(int i) {
        this.intValue = i;
        this.name = String.valueOf(i);
    }

    private SearchScope(String str, int i) {
        this.name = str;
        this.intValue = i;
    }

    public static SearchScope definedValueOf(int i) {
        switch (i) {
            case 0:
                return BASE;
            case 1:
                return ONE;
            case 2:
                return SUB;
            case 3:
                return SUBORDINATE_SUBTREE;
            default:
                return null;
        }
    }

    public static SearchScope valueOf(int i) {
        SearchScope searchScope;
        switch (i) {
            case 0:
                return BASE;
            case 1:
                return ONE;
            case 2:
                return SUB;
            case 3:
                return SUBORDINATE_SUBTREE;
            default:
                synchronized (UNDEFINED_SCOPES) {
                    searchScope = UNDEFINED_SCOPES.get(Integer.valueOf(i));
                    if (searchScope == null) {
                        searchScope = new SearchScope(i);
                        UNDEFINED_SCOPES.put(Integer.valueOf(i), searchScope);
                    }
                }
                return searchScope;
        }
    }

    public static SearchScope[] values() {
        return new SearchScope[]{BASE, ONE, SUB, SUBORDINATE_SUBTREE};
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof SearchScope) && this.intValue == ((SearchScope) obj).intValue;
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
