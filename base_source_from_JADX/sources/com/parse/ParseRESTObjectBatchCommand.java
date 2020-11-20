package com.parse;

import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTObjectBatchCommand extends ParseRESTCommand {
    public static final int COMMAND_OBJECT_BATCH_MAX_SIZE = 50;
    private static final String KEY_RESULTS = "results";

    private ParseRESTObjectBatchCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        super(str, method, jSONObject, str2);
    }

    public static List<Task<JSONObject>> executeBatch(ParseHttpClient parseHttpClient, List<ParseRESTObjectCommand> list, String str) {
        final int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        if (size == 1) {
            arrayList.add(list.get(0).executeAsync(parseHttpClient));
            return arrayList;
        } else if (size > 50) {
            List<List<T>> partition = Lists.partition(list, 50);
            int size2 = partition.size();
            while (i < size2) {
                arrayList.addAll(executeBatch(parseHttpClient, partition.get(i), str));
                i++;
            }
            return arrayList;
        } else {
            final ArrayList arrayList2 = new ArrayList(size);
            while (i < size) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                arrayList2.add(taskCompletionSource);
                arrayList.add(taskCompletionSource.getTask());
                i++;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (ParseRESTObjectCommand next : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(FirebaseAnalytics.Param.METHOD, next.method.toString());
                    jSONObject2.put("path", new URL(server, next.httpPath).getPath());
                    JSONObject jSONObject3 = next.jsonParameters;
                    if (jSONObject3 != null) {
                        jSONObject2.put("body", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("requests", jSONArray);
                new ParseRESTObjectBatchCommand("batch", ParseHttpRequest.Method.POST, jSONObject, str).executeAsync(parseHttpClient).continueWith(new Continuation<JSONObject, Void>() {
                    public Void then(Task<JSONObject> task) {
                        if (task.isFaulted() || task.isCancelled()) {
                            for (int i = 0; i < size; i++) {
                                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayList2.get(i);
                                if (task.isFaulted()) {
                                    taskCompletionSource.setError(task.getError());
                                } else {
                                    taskCompletionSource.setCancelled();
                                }
                            }
                        }
                        JSONArray jSONArray = task.getResult().getJSONArray(ParseRESTObjectBatchCommand.KEY_RESULTS);
                        int length = jSONArray.length();
                        if (length != size) {
                            for (int i2 = 0; i2 < size; i2++) {
                                ((TaskCompletionSource) arrayList2.get(i2)).setError(new IllegalStateException("Batch command result count expected: " + size + " but was: " + length));
                            }
                        }
                        for (int i3 = 0; i3 < size; i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            TaskCompletionSource taskCompletionSource2 = (TaskCompletionSource) arrayList2.get(i3);
                            if (jSONObject.has(FirebaseAnalytics.Param.SUCCESS)) {
                                taskCompletionSource2.setResult(jSONObject.getJSONObject(FirebaseAnalytics.Param.SUCCESS));
                            } else if (jSONObject.has("error")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                                taskCompletionSource2.setError(new ParseException(jSONObject2.getInt("code"), jSONObject2.getString("error")));
                            }
                        }
                        return null;
                    }
                });
                return arrayList;
            } catch (MalformedURLException | JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Task<JSONObject> onResponseAsync(ParseHttpResponse parseHttpResponse, ProgressCallback progressCallback) {
        InputStream inputStream = null;
        try {
            inputStream = parseHttpResponse.getContent();
            try {
                JSONArray jSONArray = new JSONArray(new String(ParseIOUtils.toByteArray(inputStream)));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_RESULTS, jSONArray);
                return Task.forResult(jSONObject);
            } catch (JSONException e) {
                return Task.forError(newTemporaryException("bad json response", (Throwable) e));
            }
        } catch (IOException e2) {
            return Task.forError(e2);
        } finally {
            ParseIOUtils.closeQuietly(inputStream);
        }
    }
}
