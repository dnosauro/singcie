package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

class ParseNotificationManager {
    private final AtomicInteger notificationCount = new AtomicInteger(0);

    private static class Singleton {
        /* access modifiers changed from: private */
        public static final ParseNotificationManager INSTANCE = new ParseNotificationManager();

        private Singleton() {
        }
    }

    ParseNotificationManager() {
    }

    public static ParseNotificationManager getInstance() {
        return Singleton.INSTANCE;
    }

    public void showNotification(Context context, Notification notification) {
        if (context != null && notification != null) {
            this.notificationCount.incrementAndGet();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int currentTimeMillis = (int) System.currentTimeMillis();
            try {
                notificationManager.notify(currentTimeMillis, notification);
            } catch (SecurityException unused) {
                notification.defaults = 5;
                notificationManager.notify(currentTimeMillis, notification);
            }
        }
    }
}
