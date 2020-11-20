package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C2228R;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;
import org.spongycastle.i18n.ErrorBundle;

public final class zzaqj extends zzaqu {
    /* access modifiers changed from: private */
    public final Context context;
    private final Map<String, String> zzczw;
    private String zzdog = zzdr("description");
    private long zzdoh = zzds("start_ticks");
    private long zzdoi = zzds("end_ticks");
    private String zzdoj = zzdr(ErrorBundle.SUMMARY_ENTRY);
    private String zzdok = zzdr(FirebaseAnalytics.Param.LOCATION);

    public zzaqj(zzbdv zzbdv, Map<String, String> map) {
        super(zzbdv, "createCalendarEvent");
        this.zzczw = map;
        this.context = zzbdv.zzaaj();
    }

    private final String zzdr(String str) {
        return TextUtils.isEmpty(this.zzczw.get(str)) ? "" : this.zzczw.get(str);
    }

    private final long zzds(String str) {
        String str2 = this.zzczw.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdog);
        data.putExtra("eventLocation", this.zzdok);
        data.putExtra("description", this.zzdoj);
        long j = this.zzdoh;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdoi;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.context == null) {
            zzdt("Activity context is not available.");
            return;
        }
        zzp.zzkq();
        if (!zzm.zzaq(this.context).zzrj()) {
            zzdt("This feature is not available on the device.");
            return;
        }
        zzp.zzkq();
        AlertDialog.Builder zzap = zzm.zzap(this.context);
        Resources resources = zzp.zzku().getResources();
        zzap.setTitle(resources != null ? resources.getString(C2228R.string.f6895s5) : "Create calendar event");
        zzap.setMessage(resources != null ? resources.getString(C2228R.string.f6896s6) : "Allow Ad to create a calendar event?");
        zzap.setPositiveButton(resources != null ? resources.getString(C2228R.string.f6893s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaqi(this));
        zzap.setNegativeButton(resources != null ? resources.getString(C2228R.string.f6894s4) : "Decline", new zzaql(this));
        zzap.create().show();
    }
}
