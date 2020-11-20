package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.s */
public abstract class C0967s {

    /* renamed from: a */
    private final Map<String, Object> f3110a = new HashMap();

    /* renamed from: b */
    private volatile boolean f3111b = false;

    /* renamed from: a */
    private static void m3764a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4491a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo5141d() {
        this.f3111b = true;
        Map<String, Object> map = this.f3110a;
        if (map != null) {
            synchronized (map) {
                for (Object a : this.f3110a.values()) {
                    m3764a(a);
                }
            }
        }
        mo4491a();
    }
}
