package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }

    Lazy(T t) {
        this.instance = t;
    }

    public T get() {
        T t = this.instance;
        if (t == UNINITIALIZED) {
            synchronized (this) {
                t = this.instance;
                if (t == UNINITIALIZED) {
                    t = this.provider.get();
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }
}
