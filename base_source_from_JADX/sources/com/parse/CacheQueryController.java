package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseQuery;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

class CacheQueryController extends AbstractQueryController {
    /* access modifiers changed from: private */
    public final NetworkQueryController networkController;

    private interface CommandDelegate<T> {
        Task<T> runFromCacheAsync();

        Task<T> runOnNetworkAsync();
    }

    public CacheQueryController(NetworkQueryController networkQueryController) {
        this.networkController = networkQueryController;
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<Integer> countFromCacheAsync(final ParseQuery.State<T> state, String str) {
        final String cacheKey = ParseRESTQueryCommand.countCommand(state, str).getCacheKey();
        return Task.call(new Callable<Integer>() {
            public Integer call() {
                JSONObject jsonFromKeyValueCache = ParseKeyValueCache.jsonFromKeyValueCache(cacheKey, state.maxCacheAge());
                if (jsonFromKeyValueCache != null) {
                    try {
                        return Integer.valueOf(jsonFromKeyValueCache.getInt("count"));
                    } catch (JSONException unused) {
                        throw new ParseException(120, "the cache contains corrupted json");
                    }
                } else {
                    throw new ParseException(120, "results not cached");
                }
            }
        }, (Executor) Task.BACKGROUND_EXECUTOR);
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<List<T>> findFromCacheAsync(final ParseQuery.State<T> state, String str) {
        final String cacheKey = ParseRESTQueryCommand.findCommand(state, str).getCacheKey();
        return Task.call(new Callable<List<T>>() {
            public List<T> call() {
                JSONObject jsonFromKeyValueCache = ParseKeyValueCache.jsonFromKeyValueCache(cacheKey, state.maxCacheAge());
                if (jsonFromKeyValueCache != null) {
                    try {
                        return CacheQueryController.this.networkController.convertFindResponse(state, jsonFromKeyValueCache);
                    } catch (JSONException unused) {
                        throw new ParseException(120, "the cache contains corrupted json");
                    }
                } else {
                    throw new ParseException(120, "results not cached");
                }
            }
        }, (Executor) Task.BACKGROUND_EXECUTOR);
    }

    private <TResult> Task<TResult> runCommandWithPolicyAsync(final CommandDelegate<TResult> commandDelegate, ParseQuery.CachePolicy cachePolicy) {
        Task<TResult> runFromCacheAsync;
        Continuation r0;
        switch (cachePolicy) {
            case IGNORE_CACHE:
            case NETWORK_ONLY:
                return commandDelegate.runOnNetworkAsync();
            case CACHE_ONLY:
                return commandDelegate.runFromCacheAsync();
            case CACHE_ELSE_NETWORK:
                runFromCacheAsync = commandDelegate.runFromCacheAsync();
                r0 = new Continuation<TResult, Task<TResult>>() {
                    public Task<TResult> then(Task<TResult> task) {
                        return task.getError() instanceof ParseException ? commandDelegate.runOnNetworkAsync() : task;
                    }
                };
                break;
            case NETWORK_ELSE_CACHE:
                runFromCacheAsync = commandDelegate.runOnNetworkAsync();
                r0 = new Continuation<TResult, Task<TResult>>() {
                    public Task<TResult> then(Task<TResult> task) {
                        Exception error = task.getError();
                        return (!(error instanceof ParseException) || ((ParseException) error).getCode() != 100) ? task : commandDelegate.runFromCacheAsync();
                    }
                };
                break;
            case CACHE_THEN_NETWORK:
                throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
            default:
                throw new RuntimeException("Unknown cache policy: " + cachePolicy);
        }
        return runFromCacheAsync.continueWithTask(r0);
    }

    public <T extends ParseObject> Task<Integer> countAsync(final ParseQuery.State<T> state, ParseUser parseUser, final Task<Void> task) {
        final String sessionToken = parseUser != null ? parseUser.getSessionToken() : null;
        return runCommandWithPolicyAsync(new CommandDelegate<Integer>() {
            public Task<Integer> runFromCacheAsync() {
                return CacheQueryController.this.countFromCacheAsync(state, sessionToken);
            }

            public Task<Integer> runOnNetworkAsync() {
                return CacheQueryController.this.networkController.countAsync(state, sessionToken, (Task<Void>) task);
            }
        }, state.cachePolicy());
    }

    public <T extends ParseObject> Task<List<T>> findAsync(final ParseQuery.State<T> state, ParseUser parseUser, final Task<Void> task) {
        final String sessionToken = parseUser != null ? parseUser.getSessionToken() : null;
        return runCommandWithPolicyAsync(new CommandDelegate<List<T>>() {
            public Task<List<T>> runFromCacheAsync() {
                return CacheQueryController.this.findFromCacheAsync(state, sessionToken);
            }

            public Task<List<T>> runOnNetworkAsync() {
                return CacheQueryController.this.networkController.findAsync(state, sessionToken, (Task<Void>) task);
            }
        }, state.cachePolicy());
    }
}
