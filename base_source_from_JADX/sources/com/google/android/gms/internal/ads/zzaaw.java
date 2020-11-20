package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public final class zzaaw {
    private final Collection<zzaaq<?>> zzcle = new ArrayList();
    private final Collection<zzaaq<String>> zzclf = new ArrayList();
    private final Collection<zzaaq<String>> zzclg = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaaq next : this.zzcle) {
            if (next.getSource() == 1) {
                next.zza(editor, next.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzaza.zzey("Flag Json is null.");
        }
    }

    public final void zza(zzaaq zzaaq) {
        this.zzcle.add(zzaaq);
    }

    public final void zzb(zzaaq<String> zzaaq) {
        this.zzclf.add(zzaaq);
    }

    public final void zzc(zzaaq<String> zzaaq) {
        this.zzclg.add(zzaaq);
    }

    public final List<String> zzrl() {
        ArrayList arrayList = new ArrayList();
        for (zzaaq<String> zzd : this.zzclf) {
            String str = (String) zzwq.zzqe().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzabg.zzrp());
        return arrayList;
    }

    public final List<String> zzrm() {
        List<String> zzrl = zzrl();
        for (zzaaq<String> zzd : this.zzclg) {
            String str = (String) zzwq.zzqe().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                zzrl.add(str);
            }
        }
        zzrl.addAll(zzabg.zzrq());
        return zzrl;
    }
}
