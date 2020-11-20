package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzp;

final class zzaqo implements DialogInterface.OnClickListener {
    private final /* synthetic */ String zzdpb;
    private final /* synthetic */ String zzdpc;
    private final /* synthetic */ zzaqp zzdpd;

    zzaqo(zzaqp zzaqp, String str, String str2) {
        this.zzdpd = zzaqp;
        this.zzdpb = str;
        this.zzdpc = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdpd.context.getSystemService("download");
        try {
            String str = this.zzdpb;
            String str2 = this.zzdpc;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzp.zzks();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdpd.zzdt("Could not store picture.");
        }
    }
}
