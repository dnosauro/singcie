package org.hamcrest.core;

import java.util.ArrayList;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CombinableMatcher<T> extends TypeSafeDiagnosingMatcher<T> {
    private final Matcher<? super T> matcher;

    public static final class CombinableBothMatcher<X> {
        private final Matcher<? super X> first;

        public CombinableBothMatcher(Matcher<? super X> matcher) {
            this.first = matcher;
        }

        public CombinableMatcher<X> and(Matcher<? super X> matcher) {
            return new CombinableMatcher(this.first).and(matcher);
        }
    }

    public static final class CombinableEitherMatcher<X> {
        private final Matcher<? super X> first;

        public CombinableEitherMatcher(Matcher<? super X> matcher) {
            this.first = matcher;
        }

        /* renamed from: or */
        public CombinableMatcher<X> mo27209or(Matcher<? super X> matcher) {
            return new CombinableMatcher(this.first).mo27207or(matcher);
        }
    }

    public CombinableMatcher(Matcher<? super T> matcher2) {
        this.matcher = matcher2;
    }

    @Factory
    public static <LHS> CombinableBothMatcher<LHS> both(Matcher<? super LHS> matcher2) {
        return new CombinableBothMatcher<>(matcher2);
    }

    @Factory
    public static <LHS> CombinableEitherMatcher<LHS> either(Matcher<? super LHS> matcher2) {
        return new CombinableEitherMatcher<>(matcher2);
    }

    private ArrayList<Matcher<? super T>> templatedListWith(Matcher<? super T> matcher2) {
        ArrayList<Matcher<? super T>> arrayList = new ArrayList<>();
        arrayList.add(this.matcher);
        arrayList.add(matcher2);
        return arrayList;
    }

    public CombinableMatcher<T> and(Matcher<? super T> matcher2) {
        return new CombinableMatcher<>(new AllOf(templatedListWith(matcher2)));
    }

    public void describeTo(Description description) {
        description.appendDescriptionOf(this.matcher);
    }

    /* access modifiers changed from: protected */
    public boolean matchesSafely(T t, Description description) {
        if (this.matcher.matches(t)) {
            return true;
        }
        this.matcher.describeMismatch(t, description);
        return false;
    }

    /* renamed from: or */
    public CombinableMatcher<T> mo27207or(Matcher<? super T> matcher2) {
        return new CombinableMatcher<>(new AnyOf(templatedListWith(matcher2)));
    }
}
