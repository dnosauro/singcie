package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseConfig {
    static final TaskQueue taskQueue = new TaskQueue();
    final Map<String, Object> params;

    ParseConfig() {
        this.params = Collections.unmodifiableMap(new HashMap());
    }

    ParseConfig(Map<String, Object> map) {
        this.params = Collections.unmodifiableMap(map);
    }

    static ParseConfig decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
        Map map = (Map) ((Map) parseDecoder.decode(jSONObject)).get("params");
        if (map != null) {
            return new ParseConfig(map);
        }
        throw new RuntimeException("Object did not contain the 'params' key.");
    }

    public static ParseConfig get() {
        return (ParseConfig) ParseTaskUtils.wait(getInBackground());
    }

    /* access modifiers changed from: private */
    public static Task<ParseConfig> getAsync(final Task<Void> task) {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<ParseConfig>>() {
            public Task<ParseConfig> then(Task<String> task) {
                final String result = task.getResult();
                return task.continueWithTask(new Continuation<Void, Task<ParseConfig>>() {
                    public Task<ParseConfig> then(Task<Void> task) {
                        return ParseConfig.getConfigController().getAsync(result);
                    }
                });
            }
        });
    }

    static ParseConfigController getConfigController() {
        return ParseCorePlugins.getInstance().getConfigController();
    }

    public static ParseConfig getCurrentConfig() {
        try {
            return (ParseConfig) ParseTaskUtils.wait(getConfigController().getCurrentConfigController().getCurrentConfigAsync());
        } catch (ParseException unused) {
            return new ParseConfig();
        }
    }

    public static Task<ParseConfig> getInBackground() {
        return taskQueue.enqueue(new Continuation<Void, Task<ParseConfig>>() {
            public Task<ParseConfig> then(Task<Void> task) {
                return ParseConfig.getAsync(task);
            }
        });
    }

    public static void getInBackground(ConfigCallback configCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getInBackground(), configCallback);
    }

    public Object get(String str) {
        return get(str, (Object) null);
    }

    public Object get(String str, Object obj) {
        if (!this.params.containsKey(str)) {
            return obj;
        }
        if (this.params.get(str) == JSONObject.NULL) {
            return null;
        }
        return this.params.get(str);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        if (!this.params.containsKey(str)) {
            return z;
        }
        Object obj = this.params.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public Date getDate(String str) {
        return getDate(str, (Date) null);
    }

    public Date getDate(String str, Date date) {
        if (!this.params.containsKey(str)) {
            return date;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof Date ? (Date) obj : date;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Number number = getNumber(str);
        return number != null ? number.doubleValue() : d;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Number number = getNumber(str);
        return number != null ? number.intValue() : i;
    }

    public JSONArray getJSONArray(String str) {
        return getJSONArray(str, (JSONArray) null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        List list = getList(str);
        Object encode = list != null ? PointerEncoder.get().encode(list) : null;
        return (encode == null || (encode instanceof JSONArray)) ? (JSONArray) encode : jSONArray;
    }

    public JSONObject getJSONObject(String str) {
        return getJSONObject(str, (JSONObject) null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        Map map = getMap(str);
        Object encode = map != null ? PointerEncoder.get().encode(map) : null;
        return (encode == null || (encode instanceof JSONObject)) ? (JSONObject) encode : jSONObject;
    }

    public <T> List<T> getList(String str) {
        return getList(str, (List) null);
    }

    public <T> List<T> getList(String str, List<T> list) {
        if (!this.params.containsKey(str)) {
            return list;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof List ? (List) obj : list;
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long getLong(String str, long j) {
        Number number = getNumber(str);
        return number != null ? number.longValue() : j;
    }

    public <V> Map<String, V> getMap(String str) {
        return getMap(str, (Map) null);
    }

    public <V> Map<String, V> getMap(String str, Map<String, V> map) {
        if (!this.params.containsKey(str)) {
            return map;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof Map ? (Map) obj : map;
    }

    public Number getNumber(String str) {
        return getNumber(str, (Number) null);
    }

    public Number getNumber(String str, Number number) {
        if (!this.params.containsKey(str)) {
            return number;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof Number ? (Number) obj : number;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getParams() {
        return Collections.unmodifiableMap(new HashMap(this.params));
    }

    public ParseFile getParseFile(String str) {
        return getParseFile(str, (ParseFile) null);
    }

    public ParseFile getParseFile(String str, ParseFile parseFile) {
        if (!this.params.containsKey(str)) {
            return parseFile;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof ParseFile ? (ParseFile) obj : parseFile;
    }

    public ParseGeoPoint getParseGeoPoint(String str) {
        return getParseGeoPoint(str, (ParseGeoPoint) null);
    }

    public ParseGeoPoint getParseGeoPoint(String str, ParseGeoPoint parseGeoPoint) {
        if (!this.params.containsKey(str)) {
            return parseGeoPoint;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof ParseGeoPoint ? (ParseGeoPoint) obj : parseGeoPoint;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (!this.params.containsKey(str)) {
            return str2;
        }
        Object obj = this.params.get(str);
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof String ? (String) obj : str2;
    }

    public String toString() {
        return "ParseConfig[" + this.params.toString() + "]";
    }
}
