package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* renamed from: androidx.core.app.m */
public final class C0520m {

    /* renamed from: a */
    private final String f2038a;

    /* renamed from: b */
    private final CharSequence f2039b;

    /* renamed from: c */
    private final CharSequence[] f2040c;

    /* renamed from: d */
    private final boolean f2041d;

    /* renamed from: e */
    private final int f2042e;

    /* renamed from: f */
    private final Bundle f2043f;

    /* renamed from: g */
    private final Set<String> f2044g;

    /* renamed from: a */
    static RemoteInput m2054a(C0520m mVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(mVar.mo3488a()).setLabel(mVar.mo3489b()).setChoices(mVar.mo3490c()).setAllowFreeFormInput(mVar.mo3492e()).addExtras(mVar.mo3494g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(mVar.mo3493f());
        }
        return addExtras.build();
    }

    /* renamed from: a */
    static RemoteInput[] m2055a(C0520m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            remoteInputArr[i] = m2054a(mVarArr[i]);
        }
        return remoteInputArr;
    }

    /* renamed from: a */
    public String mo3488a() {
        return this.f2038a;
    }

    /* renamed from: b */
    public CharSequence mo3489b() {
        return this.f2039b;
    }

    /* renamed from: c */
    public CharSequence[] mo3490c() {
        return this.f2040c;
    }

    /* renamed from: d */
    public Set<String> mo3491d() {
        return this.f2044g;
    }

    /* renamed from: e */
    public boolean mo3492e() {
        return this.f2041d;
    }

    /* renamed from: f */
    public int mo3493f() {
        return this.f2042e;
    }

    /* renamed from: g */
    public Bundle mo3494g() {
        return this.f2043f;
    }
}
