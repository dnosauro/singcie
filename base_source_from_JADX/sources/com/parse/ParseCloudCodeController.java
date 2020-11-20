package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

class ParseCloudCodeController {
    final ParseHttpClient restClient;

    public ParseCloudCodeController(ParseHttpClient parseHttpClient) {
        this.restClient = parseHttpClient;
    }

    public <T> Task<T> callFunctionInBackground(String str, Map<String, ?> map, String str2) {
        return ParseRESTCloudCommand.callFunctionCommand(str, map, str2).executeAsync(this.restClient).onSuccess(new Continuation<JSONObject, T>() {
            public T then(Task<JSONObject> task) {
                return ParseCloudCodeController.this.convertCloudResponse(task.getResult());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Object convertCloudResponse(Object obj) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.isNull("result")) {
                return null;
            }
            obj = jSONObject.opt("result");
        }
        Object decode = ParseDecoder.get().decode(obj);
        return decode != null ? decode : obj;
    }
}
