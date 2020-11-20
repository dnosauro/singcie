package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.C0529a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.core.app.o */
public final class C0523o implements Iterable<Intent> {

    /* renamed from: a */
    private final ArrayList<Intent> f2046a = new ArrayList<>();

    /* renamed from: b */
    private final Context f2047b;

    /* renamed from: androidx.core.app.o$a */
    public interface C0524a {
        Intent getSupportParentActivityIntent();
    }

    private C0523o(Context context) {
        this.f2047b = context;
    }

    /* renamed from: a */
    public static C0523o m2072a(Context context) {
        return new C0523o(context);
    }

    /* renamed from: a */
    public C0523o mo3502a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof C0524a ? ((C0524a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = C0508g.m1976a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f2047b.getPackageManager());
            }
            mo3503a(component);
            mo3504a(supportParentActivityIntent);
        }
        return this;
    }

    /* renamed from: a */
    public C0523o mo3503a(ComponentName componentName) {
        int size = this.f2046a.size();
        try {
            Context context = this.f2047b;
            while (true) {
                Intent a = C0508g.m1977a(context, componentName);
                if (a == null) {
                    return this;
                }
                this.f2046a.add(size, a);
                context = this.f2047b;
                componentName = a.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public C0523o mo3504a(Intent intent) {
        this.f2046a.add(intent);
        return this;
    }

    /* renamed from: a */
    public void mo3505a() {
        mo3506a((Bundle) null);
    }

    /* renamed from: a */
    public void mo3506a(Bundle bundle) {
        if (!this.f2046a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2046a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!C0529a.m2096a(this.f2047b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f2047b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2046a.iterator();
    }
}
