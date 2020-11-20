package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.p018c.C0400a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzu {
    @VisibleForTesting
    zzgb zza = null;
    private Map<Integer, zzhc> zzb = new C0400a();

    class zza implements zzhc {
        private zzab zza;

        zza(zzab zzab) {
            this.zza = zzab;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event listener threw exception", e);
            }
        }
    }

    class zzb implements zzhd {
        private zzab zza;

        zzb(zzab zzab) {
            this.zza = zzab;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zza(zzw zzw, String str) {
        this.zza.zzh().zza(zzw, str);
    }

    public void beginAdUnitExposure(String str, long j) {
        zza();
        this.zza.zzy().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza();
        this.zza.zzg().zzc(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) {
        zza();
        this.zza.zzg().zza((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) {
        zza();
        this.zza.zzy().zzb(str, j);
    }

    public void generateEventId(zzw zzw) {
        zza();
        this.zza.zzh().zza(zzw, this.zza.zzh().zzf());
    }

    public void getAppInstanceId(zzw zzw) {
        zza();
        this.zza.zzp().zza((Runnable) new zzh(this, zzw));
    }

    public void getCachedAppInstanceId(zzw zzw) {
        zza();
        zza(zzw, this.zza.zzg().zzag());
    }

    public void getConditionalUserProperties(String str, String str2, zzw zzw) {
        zza();
        this.zza.zzp().zza((Runnable) new zzl(this, zzw, str, str2));
    }

    public void getCurrentScreenClass(zzw zzw) {
        zza();
        zza(zzw, this.zza.zzg().zzaj());
    }

    public void getCurrentScreenName(zzw zzw) {
        zza();
        zza(zzw, this.zza.zzg().zzai());
    }

    public void getGmpAppId(zzw zzw) {
        zza();
        zza(zzw, this.zza.zzg().zzak());
    }

    public void getMaxUserProperties(String str, zzw zzw) {
        zza();
        this.zza.zzg();
        Preconditions.checkNotEmpty(str);
        this.zza.zzh().zza(zzw, 25);
    }

    public void getTestFlag(zzw zzw, int i) {
        zza();
        switch (i) {
            case 0:
                this.zza.zzh().zza(zzw, this.zza.zzg().zzac());
                return;
            case 1:
                this.zza.zzh().zza(zzw, this.zza.zzg().zzad().longValue());
                return;
            case 2:
                zzkx zzh = this.zza.zzh();
                double doubleValue = this.zza.zzg().zzaf().doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    zzw.zza(bundle);
                    return;
                } catch (RemoteException e) {
                    zzh.zzy.zzq().zzh().zza("Error returning double value to wrapper", e);
                    return;
                }
            case 3:
                this.zza.zzh().zza(zzw, this.zza.zzg().zzae().intValue());
                return;
            case 4:
                this.zza.zzh().zza(zzw, this.zza.zzg().zzab().booleanValue());
                return;
            default:
                return;
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzw zzw) {
        zza();
        this.zza.zzp().zza((Runnable) new zzi(this, zzw, str, str2, z));
    }

    public void initForTests(Map map) {
        zza();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzae zzae, long j) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgb zzgb = this.zza;
        if (zzgb == null) {
            this.zza = zzgb.zza(context, zzae, Long.valueOf(j));
        } else {
            zzgb.zzq().zzh().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzw zzw) {
        zza();
        this.zza.zzp().zza((Runnable) new zzk(this, zzw));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zza();
        this.zza.zzg().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzw, long j) {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzp().zza((Runnable) new zzj(this, zzw, new zzar(str2, new zzam(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zza();
        Object obj = null;
        Object unwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object unwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzq().zza(i, true, false, str, unwrap, unwrap2, obj);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzw, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        Bundle bundle = new Bundle();
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzq().zzh().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        zza();
        zzic zzic = this.zza.zzg().zza;
        if (zzic != null) {
            this.zza.zzg().zzaa();
            zzic.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzw zzw, long j) {
        zza();
        zzw.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzab zzab) {
        zza();
        zzhc zzhc = this.zzb.get(Integer.valueOf(zzab.zza()));
        if (zzhc == null) {
            zzhc = new zza(zzab);
            this.zzb.put(Integer.valueOf(zzab.zza()), zzhc);
        }
        this.zza.zzg().zza(zzhc);
    }

    public void resetAnalyticsData(long j) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzg.zza((String) null);
        zzg.zzp().zza((Runnable) new zzho(zzg, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) {
        zza();
        if (bundle == null) {
            this.zza.zzq().zze().zza("Conditional user property must not be null");
        } else {
            this.zza.zzg().zza(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) {
        zza();
        zzhe zzg = this.zza.zzg();
        if (zzmb.zzb() && zzg.zzs().zzd((String) null, zzat.zzco)) {
            zzg.zzv();
            String zza2 = zzad.zza(bundle);
            if (zza2 != null) {
                zzg.zzq().zzj().zza("Ignoring invalid consent setting", zza2);
                zzg.zzq().zzj().zza("Valid consent values are 'granted', 'denied'");
            }
            zzg.zza(zzad.zzb(bundle), 10, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        zza();
        this.zza.zzu().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzg.zzv();
        zzg.zzp().zza((Runnable) new zzid(zzg, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzg.zzp().zza((Runnable) new zzhh(zzg, bundle == null ? null : new Bundle(bundle)));
    }

    public void setEventInterceptor(zzab zzab) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzb zzb2 = new zzb(zzab);
        zzg.zzv();
        zzg.zzp().zza((Runnable) new zzhr(zzg, zzb2));
    }

    public void setInstanceIdProvider(zzac zzac) {
        zza();
    }

    public void setMeasurementEnabled(boolean z, long j) {
        zza();
        this.zza.zzg().zza(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzg.zzp().zza((Runnable) new zzhl(zzg, j));
    }

    public void setSessionTimeoutDuration(long j) {
        zza();
        zzhe zzg = this.zza.zzg();
        zzg.zzp().zza((Runnable) new zzhk(zzg, j));
    }

    public void setUserId(String str, long j) {
        zza();
        this.zza.zzg().zza((String) null, "_id", (Object) str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        zza();
        this.zza.zzg().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzab zzab) {
        zza();
        zzhc remove = this.zzb.remove(Integer.valueOf(zzab.zza()));
        if (remove == null) {
            remove = new zza(zzab);
        }
        this.zza.zzg().zzb(remove);
    }
}
