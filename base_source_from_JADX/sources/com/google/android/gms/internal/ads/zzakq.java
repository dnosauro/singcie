package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzakq implements zzakj, zzako {
    /* access modifiers changed from: private */
    public final zzbdv zzdii;

    public zzakq(Context context, zzazh zzazh, zzef zzef, zzb zzb) {
        zzp.zzkr();
        this.zzdii = zzbed.zza(context, zzbfn.zzadv(), "", false, false, zzef, (zzacg) null, zzazh, (zzabs) null, (zzk) null, (zzb) null, zzts.zzne(), (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        this.zzdii.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwq.zzqa();
        if (zzayr.zzze()) {
            runnable.run();
        } else {
            zzm.zzedd.post(runnable);
        }
    }

    public final void destroy() {
        this.zzdii.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdii.isDestroyed();
    }

    public final void zza(zzakr zzakr) {
        zzbfg zzacs = this.zzdii.zzacs();
        zzakr.getClass();
        zzacs.zza(zzakv.zzb(zzakr));
    }

    public final void zza(String str, zzahv<? super zzalz> zzahv) {
        this.zzdii.zza(str, (zzahv<? super zzbdv>) new zzakz(this, zzahv));
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, zzahv<? super zzalz> zzahv) {
        this.zzdii.zza(str, (Predicate<zzahv<? super zzbdv>>) new zzaks(zzahv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcv(String str) {
        runOnUiThread(new zzaku(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcw(String str) {
        runOnUiThread(new zzakx(this, str));
    }

    public final void zzcx(String str) {
        runOnUiThread(new zzakw(this, str));
    }

    public final void zzcy(String str) {
        runOnUiThread(new zzakt(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdd(String str) {
        this.zzdii.zzcy(str);
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final zzaly zzts() {
        return new zzamb(this);
    }
}
