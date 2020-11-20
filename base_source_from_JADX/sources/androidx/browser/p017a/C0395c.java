package androidx.browser.p017a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.C0504e;
import androidx.core.content.C0529a;
import java.util.ArrayList;

/* renamed from: androidx.browser.a.c */
public final class C0395c {

    /* renamed from: a */
    public final Intent f1348a;

    /* renamed from: b */
    public final Bundle f1349b;

    /* renamed from: androidx.browser.a.c$a */
    public static final class C0396a {

        /* renamed from: a */
        private final Intent f1350a;

        /* renamed from: b */
        private ArrayList<Bundle> f1351b;

        /* renamed from: c */
        private Bundle f1352c;

        /* renamed from: d */
        private ArrayList<Bundle> f1353d;

        /* renamed from: e */
        private boolean f1354e;

        public C0396a() {
            this((C0399e) null);
        }

        public C0396a(C0399e eVar) {
            this.f1350a = new Intent("android.intent.action.VIEW");
            IBinder iBinder = null;
            this.f1351b = null;
            this.f1352c = null;
            this.f1353d = null;
            this.f1354e = true;
            if (eVar != null) {
                this.f1350a.setPackage(eVar.mo2809b().getPackageName());
            }
            Bundle bundle = new Bundle();
            C0504e.m1973a(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.mo2808a() : iBinder);
            this.f1350a.putExtras(bundle);
        }

        /* renamed from: a */
        public C0395c mo2805a() {
            ArrayList<Bundle> arrayList = this.f1351b;
            if (arrayList != null) {
                this.f1350a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1353d;
            if (arrayList2 != null) {
                this.f1350a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1350a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1354e);
            return new C0395c(this.f1350a, this.f1352c);
        }
    }

    C0395c(Intent intent, Bundle bundle) {
        this.f1348a = intent;
        this.f1349b = bundle;
    }

    /* renamed from: a */
    public void mo2804a(Context context, Uri uri) {
        this.f1348a.setData(uri);
        C0529a.m2095a(context, this.f1348a, this.f1349b);
    }
}
