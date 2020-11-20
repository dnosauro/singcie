package com.google.android.gms.common.api.internal;

abstract class zaau implements Runnable {
    private final /* synthetic */ zaak zagj;

    private zaau(zaak zaak) {
        this.zagj = zaak;
    }

    /* synthetic */ zaau(zaak zaak, zaal zaal) {
        this(zaak);
    }

    public void run() {
        this.zagj.zaeo.lock();
        try {
            if (!Thread.interrupted()) {
                zaan();
            }
        } catch (RuntimeException e) {
            this.zagj.zaft.zab(e);
        } catch (Throwable th) {
            this.zagj.zaeo.unlock();
            throw th;
        }
        this.zagj.zaeo.unlock();
    }

    /* access modifiers changed from: protected */
    public abstract void zaan();
}
