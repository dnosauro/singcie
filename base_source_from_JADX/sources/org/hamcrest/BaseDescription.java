package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;

public abstract class BaseDescription implements Description {
    private Description appendList(String str, String str2, String str3, Iterator<? extends SelfDescribing> it) {
        append(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                append(str2);
            }
            appendDescriptionOf((SelfDescribing) it.next());
            z = true;
        }
        append(str3);
        return this;
    }

    private <T> Description appendValueList(String str, String str2, String str3, Iterator<T> it) {
        return appendList(str, str2, str3, (Iterator<? extends SelfDescribing>) new SelfDescribingValueIterator(it));
    }

    private String descriptionOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    private void toJavaSyntax(char c) {
        String str;
        if (c == 13) {
            str = "\\r";
        } else if (c != '\"') {
            switch (c) {
                case 9:
                    str = "\\t";
                    break;
                case 10:
                    str = "\\n";
                    break;
                default:
                    append(c);
                    return;
            }
        } else {
            str = "\\\"";
        }
        append(str);
    }

    private void toJavaSyntax(String str) {
        append('\"');
        for (int i = 0; i < str.length(); i++) {
            toJavaSyntax(str.charAt(i));
        }
        append('\"');
    }

    /* access modifiers changed from: protected */
    public abstract void append(char c);

    /* access modifiers changed from: protected */
    public void append(String str) {
        for (int i = 0; i < str.length(); i++) {
            append(str.charAt(i));
        }
    }

    public Description appendDescriptionOf(SelfDescribing selfDescribing) {
        selfDescribing.describeTo(this);
        return this;
    }

    public Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
        return appendList(str, str2, str3, iterable.iterator());
    }

    public Description appendText(String str) {
        append(str);
        return this;
    }

    public Description appendValue(Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else {
            if (obj instanceof String) {
                toJavaSyntax((String) obj);
            } else if (obj instanceof Character) {
                append('\"');
                toJavaSyntax(((Character) obj).charValue());
                append('\"');
            } else if (obj instanceof Short) {
                append('<');
                append(descriptionOf(obj));
                str = "s>";
            } else if (obj instanceof Long) {
                append('<');
                append(descriptionOf(obj));
                str = "L>";
            } else if (obj instanceof Float) {
                append('<');
                append(descriptionOf(obj));
                str = "F>";
            } else if (obj.getClass().isArray()) {
                appendValueList("[", ", ", "]", new ArrayIterator(obj));
            } else {
                append('<');
                append(descriptionOf(obj));
                append('>');
            }
            return this;
        }
        append(str);
        return this;
    }

    public <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable) {
        return appendValueList(str, str2, str3, iterable.iterator());
    }

    public <T> Description appendValueList(String str, String str2, String str3, T... tArr) {
        return appendValueList(str, str2, str3, Arrays.asList(tArr));
    }
}
