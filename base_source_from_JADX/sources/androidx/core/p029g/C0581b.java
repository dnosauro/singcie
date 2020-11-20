package androidx.core.p029g;

import android.util.Log;
import java.io.Writer;

/* renamed from: androidx.core.g.b */
public class C0581b extends Writer {

    /* renamed from: a */
    private final String f2175a;

    /* renamed from: b */
    private StringBuilder f2176b = new StringBuilder(128);

    public C0581b(String str) {
        this.f2175a = str;
    }

    /* renamed from: a */
    private void m2254a() {
        if (this.f2176b.length() > 0) {
            Log.d(this.f2175a, this.f2176b.toString());
            StringBuilder sb = this.f2176b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        m2254a();
    }

    public void flush() {
        m2254a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m2254a();
            } else {
                this.f2176b.append(c);
            }
        }
    }
}
