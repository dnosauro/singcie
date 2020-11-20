package com.parse;

import bolts.Task;
import java.util.Map;

class ParseAnalyticsController {
    ParseEventuallyQueue eventuallyQueue;

    public ParseAnalyticsController(ParseEventuallyQueue parseEventuallyQueue) {
        this.eventuallyQueue = parseEventuallyQueue;
    }

    public Task<Void> trackAppOpenedInBackground(String str, String str2) {
        return this.eventuallyQueue.enqueueEventuallyAsync(ParseRESTAnalyticsCommand.trackAppOpenedCommand(str, str2), (ParseObject) null).makeVoid();
    }

    public Task<Void> trackEventInBackground(String str, Map<String, String> map, String str2) {
        return this.eventuallyQueue.enqueueEventuallyAsync(ParseRESTAnalyticsCommand.trackEventCommand(str, map, str2), (ParseObject) null).makeVoid();
    }
}
