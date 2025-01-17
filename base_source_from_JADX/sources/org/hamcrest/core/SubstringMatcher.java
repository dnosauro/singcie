package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public abstract class SubstringMatcher extends TypeSafeMatcher<String> {
    protected final String substring;

    protected SubstringMatcher(String str) {
        this.substring = str;
    }

    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was \"").appendText(str).appendText("\"");
    }

    public void describeTo(Description description) {
        description.appendText("a string ").appendText(relationship()).appendText(" ").appendValue(this.substring);
    }

    /* access modifiers changed from: protected */
    public abstract boolean evalSubstringOf(String str);

    public boolean matchesSafely(String str) {
        return evalSubstringOf(str);
    }

    /* access modifiers changed from: protected */
    public abstract String relationship();
}
