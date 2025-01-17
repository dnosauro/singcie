package org.hamcrest;

public abstract class Condition<T> {
    public static final NotMatched<Object> NOT_MATCHED = new NotMatched<>();

    private static final class Matched<T> extends Condition<T> {
        private final Description mismatch;
        private final T theValue;

        private Matched(T t, Description description) {
            super();
            this.theValue = t;
            this.mismatch = description;
        }

        public <U> Condition<U> and(Step<? super T, U> step) {
            return step.apply(this.theValue, this.mismatch);
        }

        public boolean matching(Matcher<T> matcher, String str) {
            if (matcher.matches(this.theValue)) {
                return true;
            }
            this.mismatch.appendText(str);
            matcher.describeMismatch(this.theValue, this.mismatch);
            return false;
        }
    }

    private static final class NotMatched<T> extends Condition<T> {
        private NotMatched() {
            super();
        }

        public <U> Condition<U> and(Step<? super T, U> step) {
            return notMatched();
        }

        public boolean matching(Matcher<T> matcher, String str) {
            return false;
        }
    }

    public interface Step<I, O> {
        Condition<O> apply(I i, Description description);
    }

    private Condition() {
    }

    public static <T> Condition<T> matched(T t, Description description) {
        return new Matched(t, description);
    }

    public static <T> Condition<T> notMatched() {
        return NOT_MATCHED;
    }

    public abstract <U> Condition<U> and(Step<? super T, U> step);

    public final boolean matching(Matcher<T> matcher) {
        return matching(matcher, "");
    }

    public abstract boolean matching(Matcher<T> matcher, String str);

    public final <U> Condition<U> then(Step<? super T, U> step) {
        return and(step);
    }
}
