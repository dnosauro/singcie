package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import org.json.JSONObject;

class NetworkSessionController implements ParseSessionController {
    private final ParseHttpClient client;
    /* access modifiers changed from: private */
    public final ParseObjectCoder coder = ParseObjectCoder.get();

    public NetworkSessionController(ParseHttpClient parseHttpClient) {
        this.client = parseHttpClient;
    }

    public Task<ParseObject.State> getSessionAsync(String str) {
        return ParseRESTSessionCommand.getCurrentSessionCommand(str).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseObject.State>() {
            public ParseObject.State then(Task<JSONObject> task) {
                return ((ParseObject.State.Builder) ((ParseObject.State.Builder) NetworkSessionController.this.coder.decode(new ParseObject.State.Builder("_Session"), task.getResult(), ParseDecoder.get())).isComplete(true)).build();
            }
        });
    }

    public Task<Void> revokeAsync(String str) {
        return ParseRESTSessionCommand.revoke(str).executeAsync(this.client).makeVoid();
    }

    public Task<ParseObject.State> upgradeToRevocable(String str) {
        return ParseRESTSessionCommand.upgradeToRevocableSessionCommand(str).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseObject.State>() {
            public ParseObject.State then(Task<JSONObject> task) {
                return ((ParseObject.State.Builder) ((ParseObject.State.Builder) NetworkSessionController.this.coder.decode(new ParseObject.State.Builder("_Session"), task.getResult(), ParseDecoder.get())).isComplete(true)).build();
            }
        });
    }
}
