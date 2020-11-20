package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseQuery;
import java.util.List;

abstract class AbstractQueryController implements ParseQueryController {
    AbstractQueryController() {
    }

    public <T extends ParseObject> Task<T> getFirstAsync(ParseQuery.State<T> state, ParseUser parseUser, Task<Void> task) {
        return findAsync(state, parseUser, task).continueWith(new Continuation<List<T>, T>() {
            public T then(Task<List<T>> task) {
                if (task.isFaulted()) {
                    throw task.getError();
                } else if (task.getResult() != null && task.getResult().size() > 0) {
                    return (ParseObject) task.getResult().get(0);
                } else {
                    throw new ParseException(101, "no results found for query");
                }
            }
        });
    }
}
