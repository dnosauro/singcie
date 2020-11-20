package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.p030h.C0638d;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0953i;
import androidx.lifecycle.C0963q;
import androidx.p018c.C0413g;

/* renamed from: androidx.core.app.f */
public class C0506f extends Activity implements C0638d.C0639a, C0952h {
    private C0413g<Class<? extends C0507a>, C0507a> mExtraDataMap = new C0413g<>();
    private C0953i mLifecycleRegistry = new C0953i(this);

    @Deprecated
    /* renamed from: androidx.core.app.f$a */
    public static class C0507a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0638d.m2525a(decorView, keyEvent)) {
            return C0638d.m2526a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0638d.m2525a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends C0507a> T getExtraData(Class<T> cls) {
        return (C0507a) this.mExtraDataMap.get(cls);
    }

    public C0947e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0963q.m3750a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.mo5116a(C0947e.C0949b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(C0507a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
