package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdul;
    private String zzetx;
    private List<NativeAd.Image> zzety;
    private String zzeua;
    private NativeAd.Image zzeuc;
    private double zzeud;
    private String zzeue;
    private String zzeuf;

    public final String getBody() {
        return this.zzdul;
    }

    public final String getCallToAction() {
        return this.zzeua;
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

    public final String getPrice() {
        return this.zzeuf;
    }

    public final double getStarRating() {
        return this.zzeud;
    }

    public final String getStore() {
        return this.zzeue;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzeuc = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzety = list;
    }

    public final void setPrice(String str) {
        this.zzeuf = str;
    }

    public final void setStarRating(double d) {
        this.zzeud = d;
    }

    public final void setStore(String str) {
        this.zzeue = str;
    }
}
