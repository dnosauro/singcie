package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaux implements RewardedVideoAd {
    private final Context context;
    private final Object lock = new Object();
    private final zzaui zzdxw;
    private final zzaus zzdxx = new zzaus((RewardedVideoAdListener) null);
    private String zzdxy;
    private String zzdxz;

    public zzaux(Context context2, zzaui zzaui) {
        this.zzdxw = zzaui == null ? new zzaaa() : zzaui;
        this.context = context2.getApplicationContext();
    }

    private final void zza(String str, zzza zzza) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zza(zzvl.zza(this.context, zzza, str));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final void destroy(Context context2) {
        synchronized (this.lock) {
            this.zzdxx.setRewardedVideoAdListener((RewardedVideoAdListener) null);
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zzl(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    Bundle adMetadata = this.zzdxw.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdxz;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdxw != null) {
                return this.zzdxw.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn = null;
        try {
            if (this.zzdxw != null) {
                zzyn = this.zzdxw.zzkh();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyn);
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdxx.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdxy;
        }
        return str;
    }

    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdxw == null) {
                return false;
            }
            try {
                boolean isLoaded = this.zzdxw.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzds());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzds());
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void pause(Context context2) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zzj(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void resume(Context context2) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zzk(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zza((zzxj) new zzvh(adMetadataListener));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.setCustomData(str);
                    this.zzdxz = str;
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdxx.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.zza((zzaup) this.zzdxx);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdxy = str;
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.setUserId(str);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void show() {
        synchronized (this.lock) {
            if (this.zzdxw != null) {
                try {
                    this.zzdxw.show();
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
