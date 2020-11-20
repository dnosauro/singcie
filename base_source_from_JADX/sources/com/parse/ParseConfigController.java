package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

class ParseConfigController {
    /* access modifiers changed from: private */
    public ParseCurrentConfigController currentConfigController;
    private final ParseHttpClient restClient;

    public ParseConfigController(ParseHttpClient parseHttpClient, ParseCurrentConfigController parseCurrentConfigController) {
        this.restClient = parseHttpClient;
        this.currentConfigController = parseCurrentConfigController;
    }

    public Task<ParseConfig> getAsync(String str) {
        return ParseRESTConfigCommand.fetchConfigCommand(str).executeAsync(this.restClient).onSuccessTask(new Continuation<JSONObject, Task<ParseConfig>>() {
            public Task<ParseConfig> then(Task<JSONObject> task) {
                final ParseConfig decode = ParseConfig.decode(task.getResult(), ParseDecoder.get());
                return ParseConfigController.this.currentConfigController.setCurrentConfigAsync(decode).continueWith(new Continuation<Void, ParseConfig>() {
                    public ParseConfig then(Task<Void> task) {
                        return decode;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ParseCurrentConfigController getCurrentConfigController() {
        return this.currentConfigController;
    }
}
