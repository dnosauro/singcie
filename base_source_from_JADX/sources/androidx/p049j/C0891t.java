package androidx.p049j;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.p172io.IOUtils;

/* renamed from: androidx.j.t */
public class C0891t {

    /* renamed from: a */
    public final Map<String, Object> f2917a = new HashMap();

    /* renamed from: b */
    public View f2918b;

    /* renamed from: c */
    final ArrayList<C0874n> f2919c = new ArrayList<>();

    @Deprecated
    public C0891t() {
    }

    public C0891t(View view) {
        this.f2918b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0891t)) {
            return false;
        }
        C0891t tVar = (C0891t) obj;
        return this.f2918b == tVar.f2918b && this.f2917a.equals(tVar.f2917a);
    }

    public int hashCode() {
        return (this.f2918b.hashCode() * 31) + this.f2917a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2918b + IOUtils.LINE_SEPARATOR_UNIX) + "    values:";
        for (String next : this.f2917a.keySet()) {
            str = str + "    " + next + ": " + this.f2917a.get(next) + IOUtils.LINE_SEPARATOR_UNIX;
        }
        return str;
    }
}
