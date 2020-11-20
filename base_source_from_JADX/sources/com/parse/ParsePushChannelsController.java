package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Collections;
import java.util.List;

class ParsePushChannelsController {
    ParsePushChannelsController() {
    }

    private static ParseCurrentInstallationController getCurrentInstallationController() {
        return ParseCorePlugins.getInstance().getCurrentInstallationController();
    }

    public Task<Void> subscribeInBackground(final String str) {
        if (str != null) {
            return getCurrentInstallationController().getAsync().onSuccessTask(new Continuation<ParseInstallation, Task<Void>>() {
                public Task<Void> then(Task<ParseInstallation> task) {
                    ParseInstallation result = task.getResult();
                    List list = result.getList("channels");
                    if (list != null && !result.isDirty("channels") && list.contains(str)) {
                        return Task.forResult(null);
                    }
                    result.addUnique("channels", str);
                    return result.saveInBackground();
                }
            });
        }
        throw new IllegalArgumentException("Can't subscribe to null channel.");
    }

    public Task<Void> unsubscribeInBackground(final String str) {
        if (str != null) {
            return getCurrentInstallationController().getAsync().onSuccessTask(new Continuation<ParseInstallation, Task<Void>>() {
                public Task<Void> then(Task<ParseInstallation> task) {
                    ParseInstallation result = task.getResult();
                    List list = result.getList("channels");
                    if (list == null || !list.contains(str)) {
                        return Task.forResult(null);
                    }
                    result.removeAll("channels", Collections.singletonList(str));
                    return result.saveInBackground();
                }
            });
        }
        throw new IllegalArgumentException("Can't unsubscribe from null channel.");
    }
}
