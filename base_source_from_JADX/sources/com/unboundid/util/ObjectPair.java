package com.unboundid.util;

import java.io.Serializable;

public final class ObjectPair<F, S> implements Serializable {
    private static final long serialVersionUID = -8610279945233778440L;
    private final F first;
    private final S second;

    public ObjectPair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectPair)) {
            return false;
        }
        ObjectPair objectPair = (ObjectPair) obj;
        F f = this.first;
        if (f == null) {
            if (objectPair.first != null) {
                return false;
            }
        } else if (!f.equals(objectPair.first)) {
            return false;
        }
        S s = this.second;
        if (s == null) {
            if (objectPair.second != null) {
                return false;
            }
        } else if (!s.equals(objectPair.second)) {
            return false;
        }
        return true;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public int hashCode() {
        F f = this.first;
        int i = 0;
        if (f != null) {
            i = 0 + f.hashCode();
        }
        S s = this.second;
        return s != null ? i + s.hashCode() : i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ObjectPair(first=");
        sb.append(String.valueOf(this.first));
        sb.append(", second=");
        sb.append(String.valueOf(this.second));
        sb.append(')');
    }
}
