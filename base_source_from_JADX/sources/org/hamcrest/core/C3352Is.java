package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* renamed from: org.hamcrest.core.Is */
public class C3352Is<T> extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public C3352Is(Matcher<T> matcher2) {
        this.matcher = matcher2;
    }

    @Deprecated
    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m9126is(Class<T> cls) {
        return m9128is(IsInstanceOf.instanceOf(cls));
    }

    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m9127is(T t) {
        return m9128is(IsEqual.equalTo(t));
    }

    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m9128is(Matcher<T> matcher2) {
        return new C3352Is(matcher2);
    }

    @Factory
    public static <T> Matcher<T> isA(Class<T> cls) {
        return m9128is(IsInstanceOf.instanceOf(cls));
    }

    public void describeMismatch(Object obj, Description description) {
        this.matcher.describeMismatch(obj, description);
    }

    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    public boolean matches(Object obj) {
        return this.matcher.matches(obj);
    }
}
