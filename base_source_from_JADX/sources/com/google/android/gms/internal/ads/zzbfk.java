package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

public final class zzbfk extends MutableContextWrapper {
    private Context zzaaa;
    private Activity zzefq;
    private Context zzetc;

    public zzbfk(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.zzetc.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.zzaaa = context.getApplicationContext();
        this.zzefq = context instanceof Activity ? (Activity) context : null;
        this.zzetc = context;
        super.setBaseContext(this.zzaaa);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zzefq;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzaaa.startActivity(intent);
    }

    public final Activity zzaaj() {
        return this.zzefq;
    }

    public final Context zzacn() {
        return this.zzetc;
    }
}
