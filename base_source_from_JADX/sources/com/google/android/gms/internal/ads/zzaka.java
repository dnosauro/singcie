package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzaka extends zzakn<zzalz> implements zzakj, zzako {
    private final zzbgb zzdhx;
    /* access modifiers changed from: private */
    public zzakr zzdhy;

    public zzaka(Context context, zzazh zzazh) {
        try {
            this.zzdhx = new zzbgb(context, new zzakg(this));
            this.zzdhx.setWillNotDraw(true);
            this.zzdhx.addJavascriptInterface(new zzakh(this), "GoogleJsInterface");
            zzp.zzkq().zza(context, zzazh.zzbrf, this.zzdhx.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbeh("Init failed.", th);
        }
    }

    public final void destroy() {
        this.zzdhx.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdhx.isDestroyed();
    }

    public final void zza(zzakr zzakr) {
        this.zzdhy = zzakr;
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcv(String str) {
        zzcw(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzcw(String str) {
        zzazj.zzegt.execute(new zzakd(this, str));
    }

    public final void zzcx(String str) {
        zzazj.zzegt.execute(new zzakc(this, str));
    }

    public final void zzcy(String str) {
        zzazj.zzegt.execute(new zzakf(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcz(String str) {
        this.zzdhx.zzcy(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzda(String str) {
        this.zzdhx.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdb(String str) {
        this.zzdhx.loadData(str, "text/html", "UTF-8");
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final zzaly zzts() {
        return new zzamb(this);
    }
}
