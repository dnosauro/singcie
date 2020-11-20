package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdfd implements zzdfi<zzdfj<Bundle>> {
    private final Context zzaaa;
    private final zzdzc zzggb;

    zzdfd(zzdzc zzdzc, Context context) {
        this.zzggb = zzdzc;
        this.zzaaa = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            switch (optJSONObject.optInt("type", -1)) {
                case 0:
                    i = zzdfh.zzhbi;
                    break;
                case 1:
                    i = zzdfh.zzhbj;
                    break;
                case 2:
                    i = zzdfh.zzhbk;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    switch (zzdfe.zzhbg[i - 1]) {
                        case 1:
                            if (!(obj instanceof String)) {
                                break;
                            } else {
                                bundle.putString(optString, (String) obj);
                                break;
                            }
                        case 2:
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Long)) {
                                    if (!(obj instanceof Float)) {
                                        break;
                                    } else {
                                        bundle.putFloat(optString, ((Float) obj).floatValue());
                                        break;
                                    }
                                } else {
                                    bundle.putLong(optString, ((Long) obj).longValue());
                                    break;
                                }
                            } else {
                                bundle.putInt(optString, ((Integer) obj).intValue());
                                break;
                            }
                        case 3:
                            if (!(obj instanceof Boolean)) {
                                break;
                            } else {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                                break;
                            }
                    }
                }
            }
        }
        return bundle;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return this.zzggb.zze(new zzdfc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfj zzatd() {
        String str = (String) zzwq.zzqe().zzd(zzabf.zzcwq);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzdff(zza(this.zzaaa, new JSONArray(str)));
        } catch (JSONException e) {
            zzd.zzb("JSON parsing error", e);
            return null;
        }
    }
}
