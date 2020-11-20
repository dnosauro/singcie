package com.cyberneid.disigon;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.C0094d;
import com.cyberneid.disigoncie.R;

/* renamed from: com.cyberneid.disigon.b */
public class C2072b extends C0094d {
    public void onConfigurationChanged(Configuration configuration) {
        Log.d("ONCONFIGCHANGE", "CALLED");
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(getResources().getBoolean(R.bool.landscape_only) ? 0 : 1);
    }
}
