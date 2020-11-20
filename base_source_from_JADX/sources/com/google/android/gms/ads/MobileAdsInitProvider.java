package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzzj;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider {
    private final zzzj zzadk = new zzzj();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzadk.attachInfo(context, providerInfo);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.zzadk.delete(uri, str, strArr);
    }

    public String getType(Uri uri) {
        return this.zzadk.getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.zzadk.insert(uri, contentValues);
    }

    public boolean onCreate() {
        return this.zzadk.onCreate();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzadk.query(uri, strArr, str, strArr2, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzadk.update(uri, contentValues, str, strArr);
    }
}
