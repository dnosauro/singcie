package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseQuery;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePush {
    static String KEY_DATA_MESSAGE = "alert";
    private static final String TAG = "com.parse.ParsePush";
    final State.Builder builder;

    static class State {
        private final Set<String> channelSet;
        private final JSONObject data;
        private final Long expirationTime;
        private final Long expirationTimeInterval;
        private final Long pushTime;
        private final ParseQuery.State<ParseInstallation> queryState;

        static class Builder {
            /* access modifiers changed from: private */
            public Set<String> channelSet;
            /* access modifiers changed from: private */
            public JSONObject data;
            /* access modifiers changed from: private */
            public Long expirationTime;
            /* access modifiers changed from: private */
            public Long expirationTimeInterval;
            /* access modifiers changed from: private */
            public Long pushTime;
            /* access modifiers changed from: private */
            public ParseQuery<ParseInstallation> query;

            public Builder() {
            }

            public Builder(State state) {
                JSONObject jSONObject;
                this.channelSet = state.channelSet() == null ? null : Collections.unmodifiableSet(new HashSet(state.channelSet()));
                this.query = state.queryState() == null ? null : new ParseQuery<>(new ParseQuery.State.Builder((ParseQuery.State) state.queryState()));
                this.expirationTime = state.expirationTime();
                this.expirationTimeInterval = state.expirationTimeInterval();
                this.pushTime = state.pushTime();
                try {
                    jSONObject = new JSONObject(state.data().toString());
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                this.data = jSONObject;
            }

            public State build() {
                if (this.data != null) {
                    return new State(this);
                }
                throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
            }

            public Builder channelSet(Collection<String> collection) {
                ParsePush.checkArgument(collection != null, "channels collection cannot be null");
                for (String str : collection) {
                    ParsePush.checkArgument(str != null, "channel cannot be null");
                }
                this.channelSet = new HashSet(collection);
                this.query = null;
                return this;
            }

            public Builder data(JSONObject jSONObject) {
                this.data = jSONObject;
                return this;
            }

            public Builder expirationTime(Long l) {
                this.expirationTime = l;
                this.expirationTimeInterval = null;
                return this;
            }

            public Builder expirationTimeInterval(Long l) {
                this.expirationTimeInterval = l;
                this.expirationTime = null;
                return this;
            }

            public Builder pushTime(Long l) {
                if (l != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    boolean z = true;
                    ParsePush.checkArgument(l.longValue() > currentTimeMillis, "Scheduled push time can not be in the past");
                    if (l.longValue() >= currentTimeMillis + 1209600) {
                        z = false;
                    }
                    ParsePush.checkArgument(z, "Scheduled push time can not be more than two weeks in the future");
                }
                this.pushTime = l;
                return this;
            }

            public Builder query(ParseQuery<ParseInstallation> parseQuery) {
                ParsePush.checkArgument(parseQuery != null, "Cannot target a null query");
                ParsePush.checkArgument(parseQuery.getClassName().equals(ParsePush.getSubclassingController().getClassName(ParseInstallation.class)), "Can only push to a query for Installations");
                this.channelSet = null;
                this.query = parseQuery;
                return this;
            }
        }

        private State(Builder builder) {
            JSONObject jSONObject;
            this.channelSet = builder.channelSet == null ? null : Collections.unmodifiableSet(new HashSet(builder.channelSet));
            this.queryState = builder.query == null ? null : builder.query.getBuilder().build();
            this.expirationTime = builder.expirationTime;
            this.expirationTimeInterval = builder.expirationTimeInterval;
            this.pushTime = builder.pushTime;
            try {
                jSONObject = new JSONObject(builder.data.toString());
            } catch (JSONException unused) {
                jSONObject = null;
            }
            this.data = jSONObject;
        }

        public Set<String> channelSet() {
            return this.channelSet;
        }

        public JSONObject data() {
            try {
                return new JSONObject(this.data.toString());
            } catch (JSONException unused) {
                return null;
            }
        }

        public Long expirationTime() {
            return this.expirationTime;
        }

        public Long expirationTimeInterval() {
            return this.expirationTimeInterval;
        }

        public Long pushTime() {
            return this.pushTime;
        }

        public ParseQuery.State<ParseInstallation> queryState() {
            return this.queryState;
        }
    }

    public ParsePush() {
        this(new State.Builder());
    }

    private ParsePush(State.Builder builder2) {
        this.builder = builder2;
    }

    public ParsePush(ParsePush parsePush) {
        this(new State.Builder(parsePush.builder.build()));
    }

    /* access modifiers changed from: private */
    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    static ParsePushChannelsController getPushChannelsController() {
        return ParseCorePlugins.getInstance().getPushChannelsController();
    }

    static ParsePushController getPushController() {
        return ParseCorePlugins.getInstance().getPushController();
    }

    /* access modifiers changed from: private */
    public static ParseObjectSubclassingController getSubclassingController() {
        return ParseCorePlugins.getInstance().getSubclassingController();
    }

    public static Task<Void> sendDataInBackground(JSONObject jSONObject, ParseQuery<ParseInstallation> parseQuery) {
        ParsePush parsePush = new ParsePush();
        parsePush.setQuery(parseQuery);
        parsePush.setData(jSONObject);
        return parsePush.sendInBackground();
    }

    public static void sendDataInBackground(JSONObject jSONObject, ParseQuery<ParseInstallation> parseQuery, SendCallback sendCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(sendDataInBackground(jSONObject, parseQuery), (ParseCallback1<ParseException>) sendCallback);
    }

    public static Task<Void> sendMessageInBackground(String str, ParseQuery<ParseInstallation> parseQuery) {
        ParsePush parsePush = new ParsePush();
        parsePush.setQuery(parseQuery);
        parsePush.setMessage(str);
        return parsePush.sendInBackground();
    }

    public static void sendMessageInBackground(String str, ParseQuery<ParseInstallation> parseQuery, SendCallback sendCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(sendMessageInBackground(str, parseQuery), (ParseCallback1<ParseException>) sendCallback);
    }

    public static Task<Void> subscribeInBackground(String str) {
        return getPushChannelsController().subscribeInBackground(str);
    }

    public static void subscribeInBackground(String str, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(subscribeInBackground(str), (ParseCallback1<ParseException>) saveCallback);
    }

    public static Task<Void> unsubscribeInBackground(String str) {
        return getPushChannelsController().unsubscribeInBackground(str);
    }

    public static void unsubscribeInBackground(String str, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unsubscribeInBackground(str), (ParseCallback1<ParseException>) saveCallback);
    }

    public void clearExpiration() {
        this.builder.expirationTime((Long) null);
        this.builder.expirationTimeInterval((Long) null);
    }

    public void send() {
        ParseTaskUtils.wait(sendInBackground());
    }

    public Task<Void> sendInBackground() {
        final State build = this.builder.build();
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParsePush.getPushController().sendInBackground(build, task.getResult());
            }
        });
    }

    public void sendInBackground(SendCallback sendCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(sendInBackground(), (ParseCallback1<ParseException>) sendCallback);
    }

    public void setChannel(String str) {
        this.builder.channelSet(Collections.singletonList(str));
    }

    public void setChannels(Collection<String> collection) {
        this.builder.channelSet(collection);
    }

    public void setData(JSONObject jSONObject) {
        this.builder.data(jSONObject);
    }

    public void setExpirationTime(long j) {
        this.builder.expirationTime(Long.valueOf(j));
    }

    public void setExpirationTimeInterval(long j) {
        this.builder.expirationTimeInterval(Long.valueOf(j));
    }

    public void setMessage(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_DATA_MESSAGE, str);
        } catch (JSONException e) {
            PLog.m8817e(TAG, "JSONException in setMessage", e);
        }
        setData(jSONObject);
    }

    public void setPushTime(long j) {
        this.builder.pushTime(Long.valueOf(j));
    }

    public void setQuery(ParseQuery<ParseInstallation> parseQuery) {
        this.builder.query(parseQuery);
    }
}
