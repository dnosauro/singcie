package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

final class zzbbb implements SensorEventListener {
    private final SensorManager zzejk;
    private final Object zzejl = new Object();
    private final Display zzejm;
    private final float[] zzejn = new float[9];
    private final float[] zzejo = new float[9];
    @GuardedBy("sensorThreadLock")
    private float[] zzejp;
    private Handler zzejq;
    private zzbbd zzejr;

    zzbbb(Context context) {
        this.zzejk = (SensorManager) context.getSystemService("sensor");
        this.zzejm = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzl(int i, int i2) {
        float[] fArr = this.zzejo;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzejl) {
                if (this.zzejp == null) {
                    this.zzejp = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzejn, fArr);
            switch (this.zzejm.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.zzejn, 2, 129, this.zzejo);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.zzejn, 129, 130, this.zzejo);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.zzejn, 130, 1, this.zzejo);
                    break;
                default:
                    System.arraycopy(this.zzejn, 0, this.zzejo, 0, 9);
                    break;
            }
            zzl(1, 3);
            zzl(2, 6);
            zzl(5, 7);
            synchronized (this.zzejl) {
                System.arraycopy(this.zzejo, 0, this.zzejp, 0, 9);
            }
            zzbbd zzbbd = this.zzejr;
            if (zzbbd != null) {
                zzbbd.zzvi();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (this.zzejq == null) {
            Sensor defaultSensor = this.zzejk.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzd.zzey("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.zzejq = new zzduw(handlerThread.getLooper());
            if (!this.zzejk.registerListener(this, defaultSensor, 0, this.zzejq)) {
                zzd.zzey("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzejq != null) {
            this.zzejk.unregisterListener(this);
            this.zzejq.post(new zzbba(this));
            this.zzejq = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbbd zzbbd) {
        this.zzejr = zzbbd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzejl) {
            if (this.zzejp == null) {
                return false;
            }
            System.arraycopy(this.zzejp, 0, fArr, 0, this.zzejp.length);
            return true;
        }
    }
}
