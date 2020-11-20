package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzdul;
    private String zzetx;
    private List<NativeAd.Image> zzety;
    private NativeAd.Image zzetz;
    private String zzeua;
    private String zzeub;

    public final String getAdvertiser() {
        return this.zzeub;
    }

    public final String getBody() {
        return this.zzdul;
    }

    public final String getCallToAction() {
        return this.zzeua;
    }

    public final String getHeadline() {
        return this.zzetx;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzety;
    }

    public final NativeAd.Image getLogo() {
        return this.zzetz;
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

    public final void setHeadline(String str) {
        this.zzetx = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzety = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzetz = image;
    }
}
