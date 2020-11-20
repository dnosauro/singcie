package androidx.work;

import java.util.Set;
import java.util.UUID;

/* renamed from: androidx.work.n */
public final class C1335n {

    /* renamed from: a */
    private UUID f4109a;

    /* renamed from: b */
    private C1336a f4110b;

    /* renamed from: c */
    private C1192e f4111c;

    /* renamed from: d */
    private Set<String> f4112d;

    /* renamed from: e */
    private int f4113e;

    /* renamed from: androidx.work.n$a */
    public enum C1336a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        /* renamed from: a */
        public boolean mo6679a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1335n nVar = (C1335n) obj;
        if (this.f4113e == nVar.f4113e && this.f4109a.equals(nVar.f4109a) && this.f4110b == nVar.f4110b && this.f4111c.equals(nVar.f4111c)) {
            return this.f4112d.equals(nVar.f4112d);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f4109a.hashCode() * 31) + this.f4110b.hashCode()) * 31) + this.f4111c.hashCode()) * 31) + this.f4112d.hashCode()) * 31) + this.f4113e;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f4109a + '\'' + ", mState=" + this.f4110b + ", mOutputData=" + this.f4111c + ", mTags=" + this.f4112d + '}';
    }
}
