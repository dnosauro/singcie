package com.parse;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

@TargetApi(16)
class TaskStackBuilderHelper {
    TaskStackBuilderHelper() {
    }

    public static void startActivities(Context context, Class<? extends Activity> cls, Intent intent) {
        TaskStackBuilder create = TaskStackBuilder.create(context);
        create.addParentStack(cls);
        create.addNextIntent(intent);
        create.startActivities();
    }
}
