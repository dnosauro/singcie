package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

class NetworkQueryController extends AbstractQueryController {
    private static final String TAG = "NetworkQueryController";
    private final ParseHttpClient restClient;

    public NetworkQueryController(ParseHttpClient parseHttpClient) {
        this.restClient = parseHttpClient;
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> List<T> convertFindResponse(ParseQuery.State<T> state, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("results");
        if (jSONArray == null) {
            PLog.m8814d(TAG, "null results in find response");
        } else {
            String optString = jSONObject.optString("className", (String) null);
            if (optString == null) {
                optString = state.className();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                ParseObject fromJSON = ParseObject.fromJSON(jSONArray.getJSONObject(i), optString, ParseDecoder.get(), state.selectedKeys());
                arrayList.add(fromJSON);
                ParseQuery.RelationConstraint relationConstraint = (ParseQuery.RelationConstraint) state.constraints().get("$relatedTo");
                if (relationConstraint != null) {
                    relationConstraint.getRelation().addKnownObject(fromJSON);
                }
            }
        }
        return arrayList;
    }

    public <T extends ParseObject> Task<Integer> countAsync(ParseQuery.State<T> state, ParseUser parseUser, Task<Void> task) {
        return countAsync(state, parseUser != null ? parseUser.getSessionToken() : null, task);
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<Integer> countAsync(final ParseQuery.State<T> state, String str, Task<Void> task) {
        final ParseRESTQueryCommand countCommand = ParseRESTQueryCommand.countCommand(state, str);
        return countCommand.executeAsync(this.restClient, task).onSuccessTask(new Continuation<JSONObject, Task<JSONObject>>() {
            public Task<JSONObject> then(Task<JSONObject> task) {
                ParseQuery.CachePolicy cachePolicy = state.cachePolicy();
                if (!(cachePolicy == null || cachePolicy == ParseQuery.CachePolicy.IGNORE_CACHE)) {
                    ParseKeyValueCache.saveToKeyValueCache(countCommand.getCacheKey(), task.getResult().toString());
                }
                return task;
            }
        }, (Executor) Task.BACKGROUND_EXECUTOR).onSuccess(new Continuation<JSONObject, Integer>() {
            public Integer then(Task<JSONObject> task) {
                return Integer.valueOf(task.getResult().optInt("count"));
            }
        });
    }

    public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> state, ParseUser parseUser, Task<Void> task) {
        return findAsync(state, parseUser != null ? parseUser.getSessionToken() : null, task);
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> state, String str, Task<Void> task) {
        final long nanoTime = System.nanoTime();
        final ParseRESTQueryCommand findCommand = ParseRESTQueryCommand.findCommand(state, str);
        final long nanoTime2 = System.nanoTime();
        final ParseQuery.State<T> state2 = state;
        return findCommand.executeAsync(this.restClient, task).onSuccess(new Continuation<JSONObject, List<T>>() {
            public List<T> then(Task<JSONObject> task) {
                JSONObject result = task.getResult();
                ParseQuery.CachePolicy cachePolicy = state2.cachePolicy();
                if (!(cachePolicy == null || cachePolicy == ParseQuery.CachePolicy.IGNORE_CACHE)) {
                    ParseKeyValueCache.saveToKeyValueCache(findCommand.getCacheKey(), result.toString());
                }
                long nanoTime = System.nanoTime();
                List<T> convertFindResponse = NetworkQueryController.this.convertFindResponse(state2, task.getResult());
                long nanoTime2 = System.nanoTime();
                if (result.has("trace")) {
                    PLog.m8814d("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", new Object[]{Float.valueOf(((float) (nanoTime2 - nanoTime)) / 1000000.0f), result.get("trace"), Float.valueOf(((float) (nanoTime2 - nanoTime)) / 1000000.0f)}));
                }
                return convertFindResponse;
            }
        }, (Executor) Task.BACKGROUND_EXECUTOR);
    }
}
