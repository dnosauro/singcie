package org.apache.commons.p172io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p172io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.PrefixFileFilter */
public class PrefixFileFilter extends AbstractFileFilter implements Serializable {
    private final IOCase caseSensitivity;
    private final String[] prefixes;

    public PrefixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.prefixes = new String[]{str};
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The prefix must not be null");
    }

    public PrefixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(List<String> list, IOCase iOCase) {
        if (list != null) {
            this.prefixes = (String[]) list.toArray(new String[list.size()]);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The list of prefixes must not be null");
    }

    public PrefixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr != null) {
            this.prefixes = new String[strArr.length];
            System.arraycopy(strArr, 0, this.prefixes, 0, strArr.length);
            this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
            return;
        }
        throw new IllegalArgumentException("The array of prefixes must not be null");
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkStartsWith : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(name, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (String checkStartsWith : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(str, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.prefixes != null) {
            for (int i = 0; i < this.prefixes.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.prefixes[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
