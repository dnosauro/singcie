package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzyn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ResponseInfo {
    private final zzyn zzads;
    private final List<AdapterResponseInfo> zzadt = new ArrayList();

    private ResponseInfo(zzyn zzyn) {
        this.zzads = zzyn;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            try {
                List<zzvr> adapterResponses = this.zzads.getAdapterResponses();
                if (adapterResponses != null) {
                    for (zzvr zza : adapterResponses) {
                        this.zzadt.add(AdapterResponseInfo.zza(zza));
                    }
                }
            } catch (RemoteException e) {
                zzaza.zzc("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
    }

    public static ResponseInfo zza(zzyn zzyn) {
        if (zzyn != null) {
            return new ResponseInfo(zzyn);
        }
        return null;
    }

    public final List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzadt;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzads.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public final String getResponseId() {
        try {
            return this.zzads.getResponseId();
        } catch (RemoteException e) {
            zzaza.zzc("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzdr : this.zzadt) {
            jSONArray.put(zzdr.zzdr());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }
}
