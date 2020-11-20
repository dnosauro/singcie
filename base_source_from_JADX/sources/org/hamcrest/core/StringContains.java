package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringContains extends SubstringMatcher {
    public StringContains(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> containsString(String str) {
        return new StringContains(str);
    }

    /* access modifiers changed from: protected */
    public boolean evalSubstringOf(String str) {
        return str.indexOf(this.substring) >= 0;
    }

    /* access modifiers changed from: protected */
    public String relationship() {
        return "containing";
    }
}
