package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzp;

final class zzan implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzao zzeea;

    zzan(zzao zzao) {
        this.zzeea = zzao;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzp.zzkq();
        zzm.zzb(this.zzeea.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
