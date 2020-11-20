package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsInstanceOf extends DiagnosingMatcher<Object> {
    private final Class<?> expectedClass;
    private final Class<?> matchableClass;

    public IsInstanceOf(Class<?> cls) {
        this.expectedClass = cls;
        this.matchableClass = matchableClass(cls);
    }

    @Factory
    public static <T> Matcher<T> any(Class<T> cls) {
        return new IsInstanceOf(cls);
    }

    @Factory
    public static <T> Matcher<T> instanceOf(Class<?> cls) {
        return new IsInstanceOf(cls);
    }

    private static Class<?> matchableClass(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    public void describeTo(Description description) {
        description.appendText("an instance of ").appendText(this.expectedClass.getName());
    }

    /* access modifiers changed from: protected */
    public boolean matches(Object obj, Description description) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (this.matchableClass.isInstance(obj)) {
            return true;
        } else {
            description = description.appendValue(obj);
            str = " is a " + obj.getClass().getName();
        }
        description.appendText(str);
        return false;
    }
}
