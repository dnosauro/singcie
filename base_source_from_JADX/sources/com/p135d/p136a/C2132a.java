package com.p135d.p136a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.util.Log;

/* renamed from: com.d.a.a */
public class C2132a {
    /* renamed from: a */
    public static NfcAdapter m8385a(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter != null) {
            return defaultAdapter;
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            Log.i("IsoDepReadersFactory", "Has NFC functionality");
            NfcManager nfcManager = (NfcManager) context.getSystemService("nfc");
            if (nfcManager != null) {
                NfcAdapter defaultAdapter2 = nfcManager.getDefaultAdapter();
                Log.i("IsoDepReadersFactory", "NFC  Manager working");
                return defaultAdapter2;
            }
            Log.e("IsoDepReadersFactory", "No NFC  Manager working");
            return defaultAdapter;
        }
        Log.e("IsoDepReadersFactory", "Has No NFC functionality");
        return null;
    }
}
