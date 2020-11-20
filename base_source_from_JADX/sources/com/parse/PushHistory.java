package com.parse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.json.JSONObject;

class PushHistory {
    private static final String TAG = "com.parse.PushHistory";
    private final PriorityQueue<Entry> entries;
    private String lastTime = null;
    private final int maxHistoryLength;
    private final HashSet<String> pushIds;

    private static class Entry implements Comparable<Entry> {
        public String pushId;
        public String timestamp;

        public Entry(String str, String str2) {
            this.pushId = str;
            this.timestamp = str2;
        }

        public int compareTo(Entry entry) {
            return this.timestamp.compareTo(entry.timestamp);
        }
    }

    public PushHistory(int i, JSONObject jSONObject) {
        this.maxHistoryLength = i;
        int i2 = i + 1;
        this.entries = new PriorityQueue<>(i2);
        this.pushIds = new HashSet<>(i2);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("seen");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = optJSONObject.optString(next, (String) null);
                    if (!(next == null || optString == null)) {
                        tryInsertPush(next, optString);
                    }
                }
            }
            setLastReceivedTimestamp(jSONObject.optString("lastTime", (String) null));
        }
    }

    public String getLastReceivedTimestamp() {
        return this.lastTime;
    }

    public void setLastReceivedTimestamp(String str) {
        this.lastTime = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        if (this.entries.size() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            Iterator<Entry> it = this.entries.iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                jSONObject2.put(next.pushId, next.timestamp);
            }
            jSONObject.put("seen", jSONObject2);
        }
        jSONObject.putOpt("lastTime", this.lastTime);
        return jSONObject;
    }

    public boolean tryInsertPush(String str, String str2) {
        if (str2 != null) {
            String str3 = this.lastTime;
            if (str3 == null || str2.compareTo(str3) > 0) {
                this.lastTime = str2;
            }
            if (this.pushIds.contains(str)) {
                PLog.m8816e(TAG, "Ignored duplicate push " + str);
                return false;
            }
            this.entries.add(new Entry(str, str2));
            this.pushIds.add(str);
            while (this.entries.size() > this.maxHistoryLength) {
                this.pushIds.remove(((Entry) this.entries.remove()).pushId);
            }
            return true;
        }
        throw new IllegalArgumentException("Can't insert null pushId or timestamp into history");
    }
}
