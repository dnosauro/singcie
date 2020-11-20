package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcjv;
    private String zzdul;
    private View zzetv;
    private boolean zzetw;
    private String zzetx;
    private List<NativeAd.Image> zzety;
    private String zzeua;
    private String zzeub;
    private NativeAd.Image zzeuc;
    private String zzeue;
    private String zzeuf;
    private Double zzeuj;
    private View zzeuk;
    private Object zzeul;
    private boolean zzeum;
    private boolean zzeun;
    private float zzeuo;

    public View getAdChoicesContent() {
        return this.zzeuk;
    }

    public final String getAdvertiser() {
        return this.zzeub;
    }

    public final String getBody() {
        return this.zzdul;
    }

    public final String getCallToAction() {
        return this.zzeua;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getHeadline() {
        return this.zzetx;
    }

    public final NativeAd.Image getIcon() {
        return this.zzeuc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzety;
    }

    public float getMediaContentAspectRatio() {
        return this.zzeuo;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzeun;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzeum;
    }

    public final String getPrice() {
        return this.zzeuf;
    }

    public final Double getStarRating() {
        return this.zzeuj;
    }

    public final String getStore() {
        return this.zzeue;
    }

    public final VideoController getVideoController() {
        return this.zzcjv;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzetw;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.zzeuk = view;
    }

    public final void setAdvertiser(String str) {
        this.zzeub = str;
    }

    public final void setBody(String str) {
        this.zzdul = str;
    }

    public final void setCallToAction(String str) {
        this.zzeua = str;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzetw = z;
    }

    public final void setHeadline(String str) {
        this.zzetx = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzeuc = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzety = list;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzeuo = f;
    }

    public void setMediaView(View view) {
        this.zzetv = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzeun = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzeum = z;
    }

    public final void setPrice(String str) {
        this.zzeuf = str;
    }

    public final void setStarRating(Double d) {
        this.zzeuj = d;
    }

    public final void setStore(String str) {
        this.zzeue = str;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzcjv = videoController;
    }

    public final View zzaee() {
        return this.zzetv;
    }

    public final Object zzjw() {
        return this.zzeul;
    }

    public final void zzn(Object obj) {
        this.zzeul = obj;
    }
}
