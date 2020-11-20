package com.google.android.gms.internal.ads;

public final class zzpe {
    private boolean isOpen;

    public final synchronized void block() {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zziu() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }
}
