package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.http.ParseHttpRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@ParseClassName("_EventuallyPin")
class EventuallyPin extends ParseObject {
    public static final String PIN_NAME = "_eventuallyPin";
    public static final int TYPE_COMMAND = 3;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SAVE = 1;

    public EventuallyPin() {
        super("_EventuallyPin");
    }

    public static Task<List<EventuallyPin>> findAllPinned() {
        return findAllPinned((Collection<String>) null);
    }

    public static Task<List<EventuallyPin>> findAllPinned(Collection<String> collection) {
        ParseQuery orderByAscending = new ParseQuery(EventuallyPin.class).fromPin(PIN_NAME).ignoreACLs().orderByAscending("time");
        if (collection != null) {
            orderByAscending.whereNotContainedIn("uuid", collection);
        }
        return orderByAscending.findInBackground().onSuccessTask(new Continuation<List<EventuallyPin>, Task<List<EventuallyPin>>>() {
            public Task<List<EventuallyPin>> then(Task<List<EventuallyPin>> task) {
                final List<EventuallyPin> result = task.getResult();
                ArrayList arrayList = new ArrayList();
                for (EventuallyPin object : result) {
                    ParseObject object2 = object.getObject();
                    if (object2 != null) {
                        arrayList.add(object2.fetchFromLocalDatastoreAsync().makeVoid());
                    }
                }
                return Task.whenAll(arrayList).continueWithTask(new Continuation<Void, Task<List<EventuallyPin>>>() {
                    public Task<List<EventuallyPin>> then(Task<Void> task) {
                        return Task.forResult(result);
                    }
                });
            }
        });
    }

    private static Task<EventuallyPin> pinEventuallyCommand(int i, ParseObject parseObject, String str, String str2, JSONObject jSONObject) {
        EventuallyPin eventuallyPin = new EventuallyPin();
        eventuallyPin.put("uuid", UUID.randomUUID().toString());
        eventuallyPin.put("time", new Date());
        eventuallyPin.put("type", Integer.valueOf(i));
        if (parseObject != null) {
            eventuallyPin.put("object", parseObject);
        }
        if (str != null) {
            eventuallyPin.put("operationSetUUID", str);
        }
        if (str2 != null) {
            eventuallyPin.put("sessionToken", str2);
        }
        if (jSONObject != null) {
            eventuallyPin.put("command", jSONObject);
        }
        return eventuallyPin.pinInBackground(PIN_NAME).continueWith(new Continuation<Void, EventuallyPin>(eventuallyPin) {
            final /* synthetic */ EventuallyPin val$pin;

            {
                this.val$pin = r1;
            }

            public EventuallyPin then(Task<Void> task) {
                return this.val$pin;
            }
        });
    }

    public static Task<EventuallyPin> pinEventuallyCommand(ParseObject parseObject, ParseRESTCommand parseRESTCommand) {
        int i = 3;
        JSONObject jSONObject = null;
        if (!parseRESTCommand.httpPath.startsWith("classes")) {
            jSONObject = parseRESTCommand.toJSONObject();
        } else if (parseRESTCommand.method == ParseHttpRequest.Method.POST || parseRESTCommand.method == ParseHttpRequest.Method.PUT) {
            i = 1;
        } else if (parseRESTCommand.method == ParseHttpRequest.Method.DELETE) {
            i = 2;
        }
        return pinEventuallyCommand(i, parseObject, parseRESTCommand.getOperationSetUUID(), parseRESTCommand.getSessionToken(), jSONObject);
    }

    public ParseRESTCommand getCommand() {
        JSONObject jSONObject = getJSONObject("command");
        if (ParseRESTCommand.isValidCommandJSONObject(jSONObject)) {
            return ParseRESTCommand.fromJSONObject(jSONObject);
        }
        if (ParseRESTCommand.isValidOldFormatCommandJSONObject(jSONObject)) {
            return null;
        }
        throw new JSONException("Failed to load command from JSON.");
    }

    public ParseObject getObject() {
        return getParseObject("object");
    }

    public String getOperationSetUUID() {
        return getString("operationSetUUID");
    }

    public String getSessionToken() {
        return getString("sessionToken");
    }

    public int getType() {
        return getInt("type");
    }

    public String getUUID() {
        return getString("uuid");
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }
}
