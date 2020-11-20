package com.parse;

import bolts.Task;
import com.parse.ParseQuery;
import java.util.List;

class OfflineQueryController extends AbstractQueryController {
    private final ParseQueryController networkController;
    private final OfflineStore offlineStore;

    public OfflineQueryController(OfflineStore offlineStore2, ParseQueryController parseQueryController) {
        this.offlineStore = offlineStore2;
        this.networkController = parseQueryController;
    }

    public <T extends ParseObject> Task<Integer> countAsync(ParseQuery.State<T> state, ParseUser parseUser, Task<Void> task) {
        return state.isFromLocalDatastore() ? this.offlineStore.countFromPinAsync(state.pinName(), state, parseUser) : this.networkController.countAsync(state, parseUser, task);
    }

    public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> state, ParseUser parseUser, Task<Void> task) {
        return state.isFromLocalDatastore() ? this.offlineStore.findFromPinAsync(state.pinName(), state, parseUser) : this.networkController.findAsync(state, parseUser, task);
    }
}
