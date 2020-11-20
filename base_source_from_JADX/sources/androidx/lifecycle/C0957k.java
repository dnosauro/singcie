package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* renamed from: androidx.lifecycle.k */
public class C0957k extends Service implements C0952h {

    /* renamed from: a */
    private final C0965r f3099a = new C0965r(this);

    public C0947e getLifecycle() {
        return this.f3099a.mo5139e();
    }

    public IBinder onBind(Intent intent) {
        this.f3099a.mo5136b();
        return null;
    }

    public void onCreate() {
        this.f3099a.mo5135a();
        super.onCreate();
    }

    public void onDestroy() {
        this.f3099a.mo5138d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        this.f3099a.mo5137c();
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
