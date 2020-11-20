package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzczo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzcyx extends zzaxt {
    private static final List<String> zzgxf = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));
    private static final List<String> zzgxg = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    private static final List<String> zzgxh = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));
    private static final List<String> zzgxi = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    private Context context;
    /* access modifiers changed from: private */
    public zzazh zzbos;
    private final ScheduledExecutorService zzfpq;
    private zzef zzfpv;
    private Point zzgba = new Point();
    private Point zzgbb = new Point();
    private final zzdzc zzggb;
    private zzdod<zzcgh> zzgsj;
    private zzbgm zzgxj;
    private zzasl zzgxk;

    public zzcyx(zzbgm zzbgm, Context context2, zzef zzef, zzazh zzazh, zzdod<zzcgh> zzdod, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService) {
        this.zzgxj = zzbgm;
        this.context = context2;
        this.zzfpv = zzef;
        this.zzbos = zzazh;
        this.zzgsj = zzdod;
        this.zzggb = zzdzc;
        this.zzfpq = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) {
        try {
            uri = this.zzfpv.zza(uri, this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzei e) {
            zzaza.zzd("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzk(uri) && !TextUtils.isEmpty(str)) {
                uri = zza(uri, "nas", str);
            }
            arrayList.add(uri);
        }
        return arrayList;
    }

    private static boolean zza(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final boolean zzasi() {
        zzasl zzasl = this.zzgxk;
        return (zzasl == null || zzasl.zzdse == null || this.zzgxk.zzdse.isEmpty()) ? false : true;
    }

    static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    private final zzdyz<String> zzgo(String str) {
        zzcgh[] zzcghArr = new zzcgh[1];
        zzdyz<O> zzb = zzdyr.zzb(this.zzgsj.zzaux(), new zzczi(this, zzcghArr, str), (Executor) this.zzggb);
        zzb.addListener(new zzczh(this, zzcghArr), this.zzggb);
        return zzdyi.zzg(zzb).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcya)).intValue(), TimeUnit.MILLISECONDS, this.zzfpq).zza(zzczg.zzdza, this.zzggb).zza(Exception.class, zzczf.zzdza, (Executor) this.zzggb);
    }

    private static boolean zzk(Uri uri) {
        return zza(uri, zzgxh, zzgxi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzcgh[] zzcghArr, String str, zzcgh zzcgh) {
        zzcghArr[0] = zzcgh;
        JSONObject zza = zzbq.zza(this.context, this.zzgxk.zzdse, this.zzgxk.zzdse, this.zzgxk.zzaaq);
        JSONObject zza2 = zzbq.zza(this.context, this.zzgxk.zzaaq);
        JSONObject zzt = zzbq.zzt(this.zzgxk.zzaaq);
        JSONObject zzb = zzbq.zzb(this.context, this.zzgxk.zzaaq);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbq.zza((String) null, this.context, this.zzgbb, this.zzgba));
        }
        return zzcgh.zzc(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) {
        String str = "";
        if (this.zzfpv.zzca() != null) {
            str = this.zzfpv.zzca().zza(this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        }
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzk(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzd.zzfa(sb.toString());
                } else {
                    uri = zza(uri, "ms", str);
                }
                arrayList.add(uri);
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaxw zzaxw, zzaxp zzaxp) {
        this.context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Context context2 = this.context;
        String str = zzaxw.zzbum;
        String str2 = zzaxw.zzbrc;
        zzvn zzvn = zzaxw.zzead;
        zzvk zzvk = zzaxw.zzeae;
        zzcyy zzafa = this.zzgxj.zzafa();
        zzbrg.zza zzcg = new zzbrg.zza().zzcg(context2);
        zzdnp zzdnp = new zzdnp();
        if (str == null) {
            str = "adUnitId";
        }
        zzdnp zzgq = zzdnp.zzgq(str);
        if (zzvk == null) {
            zzvk = new zzvj().zzpn();
        }
        zzdnp zzh = zzgq.zzh(zzvk);
        if (zzvn == null) {
            zzvn = new zzvn();
        }
        zzdyr.zza(zzafa.zzg(zzcg.zza(zzh.zzf(zzvn).zzaus()).zzakx()).zza(new zzczo(new zzczo.zza().zzgp(str2))).zzg(new zzbwp.zza().zzalt()).zzahp().zzahv(), new zzczk(this, zzaxp), this.zzgxj.zzaek());
    }

    public final void zza(zzasl zzasl) {
        this.zzgxk = zzasl;
        this.zzgsj.ensureSize(1);
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
            try {
                zzasa.onError("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzaza.zzc("", e);
            }
        } else {
            zzdyz zze = this.zzggb.zze(new zzcza(this, list, iObjectWrapper));
            if (zzasi()) {
                zze = zzdyr.zzb(zze, new zzcyz(this), (Executor) this.zzggb);
            } else {
                zzd.zzez("Asset view map is empty.");
            }
            zzdyr.zza(zze, new zzczj(this, zzasa), this.zzgxj.zzaek());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcgh[] zzcghArr) {
        if (zzcghArr[0] != null) {
            this.zzgsj.zzd(zzdyr.zzag(zzcghArr[0]));
        }
    }

    public final void zzan(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzasl zzasl = this.zzgxk;
            this.zzgba = zzbq.zza(motionEvent, zzasl == null ? null : zzasl.zzaaq);
            if (motionEvent.getAction() == 0) {
                this.zzgbb = this.zzgba;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzgba.x, (float) this.zzgba.y);
            this.zzfpv.zza(obtain);
            obtain.recycle();
        }
    }

    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzb(ArrayList arrayList) {
        return zzdyr.zzb(zzgo("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzcze(this, arrayList), (Executor) this.zzggb);
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        try {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
                zzasa.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzasa.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zza(uri, zzgxf, zzgxg)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzd.zzfa(sb.toString());
                    zzasa.onSuccess(list);
                    return;
                }
                zzdyz zze = this.zzggb.zze(new zzczc(this, uri, iObjectWrapper));
                if (zzasi()) {
                    zze = zzdyr.zzb(zze, new zzczb(this), (Executor) this.zzggb);
                } else {
                    zzd.zzez("Asset view map is empty.");
                }
                zzdyr.zza(zze, new zzczm(this, zzasa), this.zzgxj.zzaek());
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzl(Uri uri) {
        return zzdyr.zzb(zzgo("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzczd(this, uri), (Executor) this.zzggb);
    }
}
