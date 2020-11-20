package p167e.p168a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.p172io.IOUtils;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: e.a.a */
public final class C3292a {

    /* renamed from: a */
    static volatile C3294a[] f7328a = f7329b;

    /* renamed from: b */
    private static final C3294a[] f7329b = new C3294a[0];

    /* renamed from: c */
    private static final List<C3294a> f7330c = new ArrayList();

    /* renamed from: d */
    private static final C3294a f7331d = new C3294a() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo25720a(int i, String str, @NotNull String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        /* renamed from: a */
        public void mo25721a(String str, Object... objArr) {
            for (C3294a a : C3292a.f7328a) {
                a.mo25721a(str, objArr);
            }
        }
    };

    /* renamed from: e.a.a$a */
    public static abstract class C3294a {

        /* renamed from: a */
        final ThreadLocal<String> f7332a = new ThreadLocal<>();

        /* renamed from: a */
        private String m9106a(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        /* renamed from: a */
        private void m9107a(int i, Throwable th, String str, Object... objArr) {
            String a = mo25722a();
            if (mo25724a(a, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = mo25725b(str, objArr);
                    }
                    if (th != null) {
                        str = str + IOUtils.LINE_SEPARATOR_UNIX + m9106a(th);
                    }
                } else if (th != null) {
                    str = m9106a(th);
                } else {
                    return;
                }
                mo25720a(i, a, str, th);
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public String mo25722a() {
            String str = this.f7332a.get();
            if (str != null) {
                this.f7332a.remove();
            }
            return str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo25720a(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th);

        /* renamed from: a */
        public void mo25721a(String str, Object... objArr) {
            m9107a(3, (Throwable) null, str, objArr);
        }

        /* access modifiers changed from: protected */
        @Deprecated
        /* renamed from: a */
        public boolean mo25723a(int i) {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo25724a(@Nullable String str, int i) {
            return mo25723a(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo25725b(@NotNull String str, @NotNull Object[] objArr) {
            return String.format(str, objArr);
        }
    }

    /* renamed from: a */
    public static void m9103a(@NonNls String str, Object... objArr) {
        f7331d.mo25721a(str, objArr);
    }
}
