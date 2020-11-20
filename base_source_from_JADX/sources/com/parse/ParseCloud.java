package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;

public final class ParseCloud {
    private ParseCloud() {
    }

    public static <T> T callFunction(String str, Map<String, ?> map) {
        return ParseTaskUtils.wait(callFunctionInBackground(str, map));
    }

    public static <T> Task<T> callFunctionInBackground(final String str, final Map<String, ?> map) {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<T>>() {
            public Task<T> then(Task<String> task) {
                return ParseCloud.getCloudCodeController().callFunctionInBackground(str, map, task.getResult());
            }
        });
    }

    public static <T> void callFunctionInBackground(String str, Map<String, ?> map, FunctionCallback<T> functionCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(callFunctionInBackground(str, map), functionCallback);
    }

    static ParseCloudCodeController getCloudCodeController() {
        return ParseCorePlugins.getInstance().getCloudCodeController();
    }
}
