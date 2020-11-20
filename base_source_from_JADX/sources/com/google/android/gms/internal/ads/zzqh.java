package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zzqh implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqh zzbms = new zzqh();
    private final Handler handler;
    public volatile long zzbmr;
    private final HandlerThread zzbmt = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zzbmu;
    private int zzbmv;

    private zzqh() {
        this.zzbmt.start();
        this.handler = new Handler(this.zzbmt.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public static zzqh zzjp() {
        return zzbms;
    }

    public final void doFrame(long j) {
        this.zzbmr = j;
        this.zzbmu.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.zzbmu = Choreographer.getInstance();
                return true;
            case 1:
                this.zzbmv++;
                if (this.zzbmv == 1) {
                    this.zzbmu.postFrameCallback(this);
                }
                return true;
            case 2:
                this.zzbmv--;
                if (this.zzbmv == 0) {
                    this.zzbmu.removeFrameCallback(this);
                    this.zzbmr = 0;
                }
                return true;
            default:
                return false;
        }
    }

    public final void removeObserver() {
        this.handler.sendEmptyMessage(2);
    }

    public final void zzjq() {
        this.handler.sendEmptyMessage(1);
    }
}
