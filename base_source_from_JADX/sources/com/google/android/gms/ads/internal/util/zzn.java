package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.p017a.C0395c;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;

final class zzn implements zzace {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzacf zzedh;

    zzn(zzm zzm, zzacf zzacf, Context context, Uri uri) {
        this.zzedh = zzacf;
        this.val$context = context;
        this.val$uri = uri;
    }

    public final void zzsc() {
        new C0395c.C0396a(this.zzedh.zzse()).mo2805a().mo2804a(this.val$context, this.val$uri);
        this.zzedh.zzc((Activity) this.val$context);
    }

    public final void zzsd() {
    }
}
