package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzadw;

public class MediaView extends FrameLayout {
    private MediaContent zzbnf;
    private boolean zzbng;
    private zzadu zzbnh;
    private ImageView.ScaleType zzbni;
    private boolean zzbnj;
    private zzadw zzbnk;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbnj = true;
        this.zzbni = scaleType;
        zzadw zzadw = this.zzbnk;
        if (zzadw != null) {
            zzadw.setImageScaleType(this.zzbni);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbng = true;
        this.zzbnf = mediaContent;
        zzadu zzadu = this.zzbnh;
        if (zzadu != null) {
            zzadu.setMediaContent(mediaContent);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzadu zzadu) {
        this.zzbnh = zzadu;
        if (this.zzbng) {
            zzadu.setMediaContent(this.zzbnf);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzadw zzadw) {
        this.zzbnk = zzadw;
        if (this.zzbnj) {
            zzadw.setImageScaleType(this.zzbni);
        }
    }
}
