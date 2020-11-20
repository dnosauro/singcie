package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

class ParseAuthenticationManager {
    private final Map<String, AuthenticationCallback> callbacks = new HashMap();
    private final ParseCurrentUserController controller;
    private final Object lock = new Object();

    public ParseAuthenticationManager(ParseCurrentUserController parseCurrentUserController) {
        this.controller = parseCurrentUserController;
    }

    public Task<Void> deauthenticateAsync(String str) {
        final AuthenticationCallback authenticationCallback;
        synchronized (this.lock) {
            authenticationCallback = this.callbacks.get(str);
        }
        return authenticationCallback != null ? Task.call(new Callable<Void>() {
            public Void call() {
                authenticationCallback.onRestore((Map<String, String>) null);
                return null;
            }
        }, ParseExecutors.m8824io()) : Task.forResult(null);
    }

    public void register(final String str, AuthenticationCallback authenticationCallback) {
        if (str != null) {
            synchronized (this.lock) {
                if (!this.callbacks.containsKey(str)) {
                    this.callbacks.put(str, authenticationCallback);
                } else {
                    throw new IllegalStateException("Callback already registered for <" + str + ">: " + this.callbacks.get(str));
                }
            }
            if (!"anonymous".equals(str)) {
                this.controller.getAsync(false).onSuccessTask(new Continuation<ParseUser, Task<Void>>() {
                    public Task<Void> then(Task<ParseUser> task) {
                        ParseUser result = task.getResult();
                        if (result != null) {
                            return result.synchronizeAuthDataAsync(str);
                        }
                        return null;
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid authType: " + null);
    }

    public Task<Boolean> restoreAuthenticationAsync(String str, final Map<String, String> map) {
        final AuthenticationCallback authenticationCallback;
        synchronized (this.lock) {
            authenticationCallback = this.callbacks.get(str);
        }
        return authenticationCallback == null ? Task.forResult(true) : Task.call(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(authenticationCallback.onRestore(map));
            }
        }, ParseExecutors.m8824io());
    }
}
