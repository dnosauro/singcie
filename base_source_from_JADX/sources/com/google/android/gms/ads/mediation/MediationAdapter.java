package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter extends MediationExtrasReceiver {

    public static class zza {
        private int zzett;

        public final Bundle zzaed() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzett);
            return bundle;
        }

        public final zza zzdw(int i) {
            this.zzett = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
