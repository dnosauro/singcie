package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import com.parse.ParseUser;
import java.util.Map;
import org.json.JSONObject;

class NetworkUserController implements ParseUserController {
    private static final int STATUS_CODE_CREATED = 201;
    private final ParseHttpClient client;
    /* access modifiers changed from: private */
    public final ParseObjectCoder coder;
    private final boolean revocableSession;

    public NetworkUserController(ParseHttpClient parseHttpClient) {
        this(parseHttpClient, false);
    }

    public NetworkUserController(ParseHttpClient parseHttpClient, boolean z) {
        this.client = parseHttpClient;
        this.coder = ParseObjectCoder.get();
        this.revocableSession = z;
    }

    public Task<ParseUser.State> getUserAsync(String str) {
        return ParseRESTUserCommand.getCurrentUserCommand(str).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseUser.State>() {
            public ParseUser.State then(Task<JSONObject> task) {
                return ((ParseUser.State.Builder) ((ParseUser.State.Builder) NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), task.getResult(), ParseDecoder.get())).isComplete(true)).build();
            }
        });
    }

    public Task<ParseUser.State> logInAsync(ParseUser.State state, ParseOperationSet parseOperationSet) {
        final ParseRESTUserCommand serviceLogInUserCommand = ParseRESTUserCommand.serviceLogInUserCommand(this.coder.encode(state, parseOperationSet, PointerEncoder.get()), state.sessionToken(), this.revocableSession);
        return serviceLogInUserCommand.executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseUser.State>() {
            public ParseUser.State then(Task<JSONObject> task) {
                JSONObject result = task.getResult();
                boolean z = serviceLogInUserCommand.getStatusCode() == 201;
                return ((ParseUser.State.Builder) ((ParseUser.State.Builder) NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), result, ParseDecoder.get())).isComplete(!z)).isNew(z).build();
            }
        });
    }

    public Task<ParseUser.State> logInAsync(String str, String str2) {
        return ParseRESTUserCommand.logInUserCommand(str, str2, this.revocableSession).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseUser.State>() {
            public ParseUser.State then(Task<JSONObject> task) {
                return ((ParseUser.State.Builder) ((ParseUser.State.Builder) NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), task.getResult(), ParseDecoder.get())).isComplete(true)).build();
            }
        });
    }

    public Task<ParseUser.State> logInAsync(final String str, final Map<String, String> map) {
        final ParseRESTUserCommand serviceLogInUserCommand = ParseRESTUserCommand.serviceLogInUserCommand(str, map, this.revocableSession);
        return serviceLogInUserCommand.executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseUser.State>() {
            public ParseUser.State then(Task<JSONObject> task) {
                boolean z = true;
                ParseUser.State.Builder builder = (ParseUser.State.Builder) ((ParseUser.State.Builder) NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), task.getResult(), ParseDecoder.get())).isComplete(true);
                if (serviceLogInUserCommand.getStatusCode() != 201) {
                    z = false;
                }
                return builder.isNew(z).putAuthData(str, map).build();
            }
        });
    }

    public Task<Void> requestPasswordResetAsync(String str) {
        return ParseRESTUserCommand.resetPasswordResetCommand(str).executeAsync(this.client).makeVoid();
    }

    public Task<ParseUser.State> signUpAsync(ParseObject.State state, ParseOperationSet parseOperationSet, String str) {
        return ParseRESTUserCommand.signUpUserCommand(this.coder.encode(state, parseOperationSet, PointerEncoder.get()), str, this.revocableSession).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseUser.State>() {
            public ParseUser.State then(Task<JSONObject> task) {
                return ((ParseUser.State.Builder) ((ParseUser.State.Builder) NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), task.getResult(), ParseDecoder.get())).isComplete(false)).isNew(true).build();
            }
        });
    }
}
