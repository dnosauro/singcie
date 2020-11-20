package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.ads.internal.util.zzd;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzahc {
    public static final zzahv<zzbdv> zzdft = zzahf.zzdgn;
    public static final zzahv<zzbdv> zzdfu = zzahe.zzdgn;
    public static final zzahv<zzbdv> zzdfv = zzahh.zzdgn;
    public static final zzahv<zzbdv> zzdfw = zzahg.zzdgn;
    public static final zzahv<zzbdv> zzdfx = new zzahl();
    public static final zzahv<zzbdv> zzdfy = new zzahn();
    public static final zzahv<zzbdv> zzdfz = zzahj.zzdgn;
    public static final zzahv<Object> zzdga = new zzahm();
    public static final zzahv<zzbdv> zzdgb = new zzahp();
    public static final zzahv<zzbdv> zzdgc = zzahi.zzdgn;
    public static final zzahv<zzbdv> zzdgd = new zzaho();
    public static final zzahv<zzbdv> zzdge = new zzahr();
    public static final zzahv<zzbbe> zzdgf = new zzbcq();
    public static final zzahv<zzbbe> zzdgg = new zzbct();
    public static final zzahv<zzbdv> zzdgh = new zzahd();
    public static final zzaif zzdgi = new zzaif();
    public static final zzahv<zzbdv> zzdgj = new zzahq();
    public static final zzahv<zzbdv> zzdgk = new zzaht();
    public static final zzahv<zzbdv> zzdgl = new zzahs();
    public static final zzahv<zzbdv> zzdgm = new zzahk();

    public static <T extends zzbex & zzbff & zzbfh> String zza(T t, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzef zzacv = ((zzbff) t).zzacv();
            if (zzacv != null && zzacv.zzb(parse)) {
                parse = zzacv.zza(parse, t.getContext(), ((zzbfh) t).getView(), t.zzaaj());
            }
        } catch (zzei unused) {
            String valueOf = String.valueOf(str);
            zzd.zzfa(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        return zzaxm.zzb(parse, t.getContext());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzbex, com.google.android.gms.internal.ads.zzbdk] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzbdk r2, java.util.Map r3) {
        /*
            java.lang.String r0 = "u"
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0010
            java.lang.String r2 = "URL missing from click GMSG."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r2)
            return
        L_0x0010:
            java.lang.String r3 = zza(r2, (java.lang.String) r3)
            com.google.android.gms.ads.internal.util.zzbp r0 = new com.google.android.gms.ads.internal.util.zzbp
            r1 = r2
            com.google.android.gms.internal.ads.zzbex r1 = (com.google.android.gms.internal.ads.zzbex) r1
            android.content.Context r1 = r1.getContext()
            com.google.android.gms.internal.ads.zzbfe r2 = (com.google.android.gms.internal.ads.zzbfe) r2
            com.google.android.gms.internal.ads.zzazh r2 = r2.zzaao()
            java.lang.String r2 = r2.zzbrf
            r0.<init>(r1, r2, r3)
            r0.zzxl()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahc.zza(com.google.android.gms.internal.ads.zzbdk, java.util.Map):void");
    }

    static final /* synthetic */ void zza(zzbex zzbex, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzfa("URL missing from httpTrack GMSG.");
        } else {
            new zzbp(zzbex.getContext(), ((zzbfe) zzbex).zzaao().zzbrf, str).zzxl();
        }
    }

    static final /* synthetic */ void zza(zzbff zzbff, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzef zzacv = zzbff.zzacv();
            if (zzacv != null) {
                zzacv.zzca().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzd.zzfa("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zzb(zzbex zzbex, Map map) {
        JSONException jSONException;
        String str;
        PackageManager packageManager = zzbex.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String valueOf = String.valueOf(optString7);
                                zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, PKIFailureInfo.notAuthorized) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            jSONException = e2;
                            str = "Error constructing openable urls response.";
                        }
                    } catch (JSONException e3) {
                        jSONException = e3;
                        str = "Error parsing the intent data.";
                        zzd.zzc(str, jSONException);
                    }
                }
                ((zzakb) zzbex).zzb("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzakb) zzbex).zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzakb) zzbex).zzb("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbex zzbex, Map map) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyw)).booleanValue()) {
            zzd.zzfa("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzd.zzfa("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Boolean.valueOf(zzbex.getContext().getPackageManager().getLaunchIntentForPackage(str) != null));
        ((zzakb) zzbex).zza("openableApp", hashMap);
    }

    static final /* synthetic */ void zzd(zzbex zzbex, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzd.zzfa("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbex.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), PKIFailureInfo.notAuthorized) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzakb) zzbex).zza("openableURLs", hashMap);
    }
}
