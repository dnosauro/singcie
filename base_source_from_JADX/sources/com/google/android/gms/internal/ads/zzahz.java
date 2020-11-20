package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.impl.C2228R;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzva;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public final class zzahz<T extends zzva & zzbdk & zzbeq & zzbex & zzbew & zzbfa & zzbff & zzbfh> implements zzahv<T> {
    private final zza zzdgo;
    private final zzaqk zzdgp;
    private final zzckq zzdgx;
    private final zzaze zzdgy = new zzaze();
    private final zzcqo zzdgz;

    public zzahz(zza zza, zzaqk zzaqk, zzcqo zzcqo, zzckq zzckq) {
        this.zzdgo = zza;
        this.zzdgp = zzaqk;
        this.zzdgz = zzcqo;
        this.zzdgx = zzckq;
    }

    @VisibleForTesting
    static Uri zza(Context context, zzef zzef, Uri uri, View view, Activity activity) {
        if (zzef == null) {
            return uri;
        }
        try {
            return zzef.zzc(uri) ? zzef.zza(uri, context, view, activity) : uri;
        } catch (zzei unused) {
            return uri;
        } catch (Exception e) {
            zzp.zzku().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    private final boolean zza(T t, Context context, String str, String str2) {
        String str3;
        String str4;
        Context context2 = context;
        String str5 = str2;
        zzp.zzkq();
        boolean zzbc = zzm.zzbc(context);
        zzp.zzkq();
        zzbf zzbf = zzm.zzbf(context);
        zzckq zzckq = this.zzdgx;
        if (zzckq != null) {
            zzcqy.zza(context2, zzckq, this.zzdgz, str5, "offline_open");
        }
        if (zzbc) {
            this.zzdgz.zzb(this.zzdgy, str5);
            return false;
        }
        zzp.zzkq();
        if (zzm.zzbe(context) && zzbf != null) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcze)).booleanValue()) {
                zzp.zzkq();
                AlertDialog.Builder zzap = zzm.zzap(context);
                Resources resources = zzp.zzku().getResources();
                zzap.setTitle(resources == null ? "Open ad when you're back online." : resources.getString(C2228R.string.offline_opt_in_title)).setMessage(resources == null ? "We'll send you a notification with a link to the advertiser site." : resources.getString(C2228R.string.offline_opt_in_message)).setPositiveButton(resources == null ? "OK" : resources.getString(C2228R.string.offline_opt_in_confirm), new zzahy(this, context, str2, zzbf, str, resources)).setNegativeButton(resources == null ? "No thanks" : resources.getString(C2228R.string.offline_opt_in_decline), new zzaib(this, str5, context2)).setOnCancelListener(new zzaia(this, str5, context2));
                zzap.create().show();
                zzckq zzckq2 = this.zzdgx;
                if (zzckq2 != null) {
                    zzcqy.zza(context2, zzckq2, this.zzdgz, str5, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzdgz.zzgk(str5);
        if (this.zzdgx != null) {
            HashMap hashMap = new HashMap();
            zzp.zzkq();
            if (!zzm.zzbe(context)) {
                str3 = "dialog_not_shown_reason";
                str4 = "notifications_disabled";
            } else if (zzbf == null) {
                str3 = "dialog_not_shown_reason";
                str4 = "work_manager_unavailable";
            } else {
                str3 = "dialog_not_shown_reason";
                str4 = "notification_flow_disabled";
            }
            hashMap.put(str3, str4);
            zzcqy.zza(context, this.zzdgx, this.zzdgz, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    private final void zzab(boolean z) {
        zzaqk zzaqk = this.zzdgp;
        if (zzaqk != null) {
            zzaqk.zzac(z);
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzp.zzks();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzp.zzks();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzp.zzks().zzyj();
        } else {
            return -1;
        }
    }

    private final void zzda(int i) {
        zzckq zzckq = this.zzdgx;
        if (zzckq != null) {
            zzckq.zzaqg().zzr("action", "cct_action").zzr("cct_open_status", zzach.zzdau[i - 1]).zzaqd();
        }
    }

    @VisibleForTesting
    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzd.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Context context, String str, zzbf zzbf, String str2, Resources resources, DialogInterface dialogInterface, int i) {
        if (this.zzdgx != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "confirm");
            zzcqy.zza(context, this.zzdgx, this.zzdgz, str, "dialog_click", hashMap);
        }
        boolean z = false;
        try {
            z = zzbf.zzd(ObjectWrapper.wrap(context), str2, str);
        } catch (RemoteException e) {
            zzd.zzc("Failed to schedule offline notification poster.", e);
        }
        if (!z) {
            this.zzdgz.zzgk(str);
            zzckq zzckq = this.zzdgx;
            if (zzckq != null) {
                zzcqy.zza(context, zzckq, this.zzdgz, str, "offline_notification_worker_not_scheduled");
            }
        }
        zzp.zzkq();
        AlertDialog.Builder zzap = zzm.zzap(context);
        zzap.setMessage(resources == null ? "You'll get a notification with the link when you're back online" : resources.getString(C2228R.string.offline_opt_in_confirmation));
        AlertDialog create = zzap.create();
        create.show();
        Timer timer = new Timer();
        timer.schedule(new zzaid(this, create, timer), 3000);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        String str;
        boolean z;
        Map map2 = map;
        zzva zzva = (zzva) obj;
        zzbex zzbex = (zzbex) zzva;
        String zzc = zzaxm.zzc((String) map2.get("u"), zzbex.getContext(), true);
        String str2 = (String) map2.get("a");
        if (str2 == null) {
            zzd.zzfa("Action missing from an open GMSG.");
            return;
        }
        zza zza = this.zzdgo;
        if (zza == null || zza.zzjy()) {
            zzdmu zzabw = ((zzbdk) zzva).zzabw();
            zzdmz zzadk = ((zzbeq) zzva).zzadk();
            if (zzabw == null || zzadk == null) {
                str = "";
                z = false;
            } else {
                z = zzabw.zzhhq;
                str = zzadk.zzbvf;
            }
            if ("expand".equalsIgnoreCase(str2)) {
                if (((zzbew) zzva).zzacx()) {
                    zzd.zzfa("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzab(false);
                ((zzbfa) zzva).zzb(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str2)) {
                zzab(false);
                if (zzc != null) {
                    ((zzbfa) zzva).zza(zzc(map), zzd(map), zzc);
                } else {
                    ((zzbfa) zzva).zza(zzc(map), zzd(map), (String) map2.get("html"), (String) map2.get("baseurl"));
                }
            } else {
                if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctp)).booleanValue()) {
                        zzab(true);
                        if (TextUtils.isEmpty(zzc)) {
                            zzd.zzfa("Cannot open browser with null or empty url");
                            zzda(zzach.zzdar);
                            return;
                        }
                        Uri zze = zze(zza(zzbex.getContext(), ((zzbff) zzva).zzacv(), Uri.parse(zzc), ((zzbfh) zzva).getView(), zzbex.zzaaj()));
                        if (!z || this.zzdgz == null || !zza(zzva, zzbex.getContext(), zze.toString(), str)) {
                            try {
                                zzda(zzp.zzkq().zza((Context) ((zzbex) zzva).zzaaj(), zze));
                                return;
                            } catch (ActivityNotFoundException e) {
                                zzd.zzfa(e.getMessage());
                                zzda(5);
                                return;
                            } catch (Throwable th) {
                                zzda(7);
                                throw th;
                            }
                        } else {
                            return;
                        }
                    }
                }
                if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                    zzab(true);
                    Intent zze2 = new zzaic(zzbex.getContext(), ((zzbff) zzva).zzacv(), ((zzbfh) zzva).getView()).zze(map2);
                    if (!z || this.zzdgz == null || zze2 == null || !zza(zzva, zzbex.getContext(), zze2.getData().toString(), str)) {
                        try {
                            ((zzbfa) zzva).zza(new zzb(zze2));
                        } catch (ActivityNotFoundException e2) {
                            zzd.zzfa(e2.getMessage());
                        }
                    }
                } else if ("open_app".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyw)).booleanValue()) {
                        zzab(true);
                        String str3 = (String) map2.get("p");
                        if (str3 == null) {
                            zzd.zzfa("Package name missing from open app action.");
                        } else if (!z || this.zzdgz == null || !zza(zzva, zzbex.getContext(), str3, str)) {
                            PackageManager packageManager = zzbex.getContext().getPackageManager();
                            if (packageManager == null) {
                                zzd.zzfa("Cannot get package manager from open app action.");
                                return;
                            }
                            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                            if (launchIntentForPackage != null) {
                                ((zzbfa) zzva).zza(new zzb(launchIntentForPackage));
                            }
                        }
                    }
                } else {
                    zzab(true);
                    String str4 = (String) map2.get("intent_url");
                    Intent intent = null;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            intent = Intent.parseUri(str4, 0);
                        } catch (URISyntaxException e3) {
                            URISyntaxException uRISyntaxException = e3;
                            String valueOf = String.valueOf(str4);
                            zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                        }
                    }
                    if (!(intent == null || intent.getData() == null)) {
                        Uri data = intent.getData();
                        if (!Uri.EMPTY.equals(data)) {
                            Uri zze3 = zze(zza(zzbex.getContext(), ((zzbff) zzva).zzacv(), data, ((zzbfh) zzva).getView(), zzbex.zzaaj()));
                            if (!TextUtils.isEmpty(intent.getType())) {
                                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyx)).booleanValue()) {
                                    intent.setDataAndType(zze3, intent.getType());
                                }
                            }
                            intent.setData(zze3);
                        }
                    }
                    if (intent == null) {
                        if (!TextUtils.isEmpty(zzc)) {
                            zzc = zze(zza(zzbex.getContext(), ((zzbff) zzva).zzacv(), Uri.parse(zzc), ((zzbfh) zzva).getView(), zzbex.zzaaj())).toString();
                        }
                        String str5 = zzc;
                        if (!z || this.zzdgz == null || !zza(zzva, zzbex.getContext(), str5, str)) {
                            ((zzbfa) zzva).zza(new zzb((String) map2.get("i"), str5, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e")));
                        }
                    } else if (!z || this.zzdgz == null || !zza(zzva, zzbex.getContext(), intent.getData().toString(), str)) {
                        ((zzbfa) zzva).zza(new zzb(intent));
                    }
                }
            }
        } else {
            this.zzdgo.zzbk(zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, Context context, DialogInterface dialogInterface) {
        this.zzdgz.zzgk(str);
        if (this.zzdgx != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.zza(context, this.zzdgx, this.zzdgz, str, "dialog_click", hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, Context context, DialogInterface dialogInterface, int i) {
        this.zzdgz.zzgk(str);
        if (this.zzdgx != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.zza(context, this.zzdgx, this.zzdgz, str, "dialog_click", hashMap);
        }
    }
}
