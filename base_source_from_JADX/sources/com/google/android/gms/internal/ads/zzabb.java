package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzabb implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    @VisibleForTesting
    private volatile boolean zzcke = false;
    private final ConditionVariable zzcll = new ConditionVariable();
    /* access modifiers changed from: private */
    public SharedPreferences zzclm = null;
    private Context zzcln;
    private JSONObject zzclo = new JSONObject();
    private volatile boolean zzzi = false;

    private final void zzrn() {
        if (this.zzclm != null) {
            try {
                this.zzclo = new JSONObject((String) zzbu.zza(new zzabd(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void initialize(Context context) {
        if (!this.zzzi) {
            synchronized (this.lock) {
                if (!this.zzzi) {
                    if (!this.zzcke) {
                        this.zzcke = true;
                    }
                    this.zzcln = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    try {
                        this.metaData = Wrappers.packageManager(this.zzcln).getApplicationInfo(this.zzcln.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzwq.zzqc();
                            this.zzclm = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            if (this.zzclm != null) {
                                this.zzclm.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzado.zza(new zzabc(this));
                            zzrn();
                            this.zzzi = true;
                            this.zzcke = false;
                            this.zzcll.open();
                        }
                    } finally {
                        this.zzcke = false;
                        this.zzcll.open();
                    }
                }
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzrn();
        }
    }

    public final <T> T zzd(zzaaq<T> zzaaq) {
        if (!this.zzcll.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzcke) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzi || this.zzclm == null) {
            synchronized (this.lock) {
                if (this.zzzi) {
                    if (this.zzclm == null) {
                    }
                }
                T zzrk = zzaaq.zzrk();
                return zzrk;
            }
        }
        if (zzaaq.getSource() != 2) {
            return (zzaaq.getSource() != 1 || !this.zzclo.has(zzaaq.getKey())) ? zzbu.zza(new zzaba(this, zzaaq)) : zzaaq.zzb(this.zzclo);
        }
        Bundle bundle = this.metaData;
        return bundle == null ? zzaaq.zzrk() : zzaaq.zza(bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzaaq zzaaq) {
        return zzaaq.zza(this.zzclm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzro() {
        return this.zzclm.getString("flag_configuration", "{}");
    }
}
