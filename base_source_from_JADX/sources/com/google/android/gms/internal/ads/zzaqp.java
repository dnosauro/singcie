package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C2228R;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

public final class zzaqp extends zzaqu {
    /* access modifiers changed from: private */
    public final Context context;
    private final Map<String, String> zzczw;

    public zzaqp(zzbdv zzbdv, Map<String, String> map) {
        super(zzbdv, "storePicture");
        this.zzczw = map;
        this.context = zzbdv.zzaaj();
    }

    public final void execute() {
        if (this.context == null) {
            zzdt("Activity context is not available");
            return;
        }
        zzp.zzkq();
        if (!zzm.zzaq(this.context).zzri()) {
            zzdt("Feature is not supported by the device.");
            return;
        }
        String str = this.zzczw.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdt("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdt(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzp.zzkq();
            if (!zzm.zzek(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdt(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzp.zzku().getResources();
            zzp.zzkq();
            AlertDialog.Builder zzap = zzm.zzap(this.context);
            zzap.setTitle(resources != null ? resources.getString(C2228R.string.f6891s1) : "Save image");
            zzap.setMessage(resources != null ? resources.getString(C2228R.string.f6892s2) : "Allow Ad to store image in Picture gallery?");
            zzap.setPositiveButton(resources != null ? resources.getString(C2228R.string.f6893s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaqo(this, str, lastPathSegment));
            zzap.setNegativeButton(resources != null ? resources.getString(C2228R.string.f6894s4) : "Decline", new zzaqr(this));
            zzap.create().show();
        }
    }
}
