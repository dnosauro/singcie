package com.parse;

import bolts.Task;
import com.parse.ParsePush;

class ParsePushController {
    private final ParseHttpClient restClient;

    public ParsePushController(ParseHttpClient parseHttpClient) {
        this.restClient = parseHttpClient;
    }

    /* access modifiers changed from: package-private */
    public ParseRESTCommand buildRESTSendPushCommand(ParsePush.State state, String str) {
        return ParseRESTPushCommand.sendPushCommand(state.queryState(), state.channelSet(), state.expirationTime(), state.expirationTimeInterval(), state.pushTime(), state.data(), str);
    }

    public Task<Void> sendInBackground(ParsePush.State state, String str) {
        return buildRESTSendPushCommand(state, str).executeAsync(this.restClient).makeVoid();
    }
}
