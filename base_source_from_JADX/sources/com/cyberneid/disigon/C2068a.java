package com.cyberneid.disigon;

import android.os.Bundle;
import androidx.appcompat.app.C0094d;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.cyberneid.disigon.a */
public class C2068a {

    /* renamed from: a */
    private FirebaseAnalytics f6481a;

    public C2068a(C0094d dVar) {
        this.f6481a = FirebaseAnalytics.getInstance(dVar);
    }

    /* renamed from: a */
    public void mo8672a(String str) {
        this.f6481a.logEvent(str, (Bundle) null);
    }

    /* renamed from: a */
    public void mo8673a(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, str2);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, str3);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, str4);
        this.f6481a.logEvent(str, bundle);
    }
}
