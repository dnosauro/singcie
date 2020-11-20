package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringEndsWith extends SubstringMatcher {
    public StringEndsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> endsWith(String str) {
        return new StringEndsWith(str);
    }

    /* access modifiers changed from: protected */
    public boolean evalSubstringOf(String str) {
        return str.endsWith(this.substring);
    }

    /* access modifiers changed from: protected */
    public String relationship() {
        return "ending with";
    }
}
