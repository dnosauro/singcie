package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsNot<T> extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public IsNot(Matcher<T> matcher2) {
        this.matcher = matcher2;
    }

    @Factory
    public static <T> Matcher<T> not(T t) {
        return not(IsEqual.equalTo(t));
    }

    @Factory
    public static <T> Matcher<T> not(Matcher<T> matcher2) {
        return new IsNot(matcher2);
    }

    public void describeTo(Description description) {
        description.appendText("not ").appendDescriptionOf(this.matcher);
    }

    public boolean matches(Object obj) {
        return !this.matcher.matches(obj);
    }
}
