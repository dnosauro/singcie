package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

public final class zzapb {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (zzapa.zzdnn[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest zza(zzvk zzvk, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzvk.zzcha != null ? new HashSet(zzvk.zzcha) : null;
        Date date = new Date(zzvk.zzcgy);
        switch (zzvk.zzcgz) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzvk.zzmy);
    }
}
