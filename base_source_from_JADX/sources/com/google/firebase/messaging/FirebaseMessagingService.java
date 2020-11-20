package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.zzaw;
import java.util.ArrayDeque;
import java.util.Queue;

public class FirebaseMessagingService extends zzf {
    private static final Queue<String> zza = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public final Intent zza(Intent intent) {
        return zzaw.zza().zzb();
    }

    public final boolean zzb(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzp.zzd(intent)) {
            return true;
        }
        zzp.zza(intent);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f7, code lost:
        if (r0.equals("send_event") == false) goto L_0x0118;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(android.content.Intent r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.getAction()
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0059
            java.lang.String r1 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0015
            goto L_0x0059
        L_0x0015:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0027
            boolean r0 = com.google.firebase.messaging.zzp.zzd(r11)
            if (r0 == 0) goto L_0x0058
            com.google.firebase.messaging.zzp.zzb(r11)
            return
        L_0x0027:
            java.lang.String r1 = "com.google.firebase.messaging.NEW_TOKEN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "token"
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.onNewToken(r11)
            return
        L_0x0039:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "Unknown intent action: "
            java.lang.String r11 = r11.getAction()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r2 = r11.length()
            if (r2 == 0) goto L_0x0050
            java.lang.String r11 = r1.concat(r11)
            goto L_0x0055
        L_0x0050:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r1)
        L_0x0055:
            android.util.Log.d(r0, r11)
        L_0x0058:
            return
        L_0x0059:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r3 = 2
            if (r1 == 0) goto L_0x006c
            com.google.android.gms.tasks.Task r1 = com.google.android.gms.tasks.Tasks.forResult(r2)
            goto L_0x007e
        L_0x006c:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r4 = "google.message_id"
            r1.putString(r4, r0)
            com.google.firebase.iid.zzab r4 = com.google.firebase.iid.zzab.zza((android.content.Context) r10)
            com.google.android.gms.tasks.Task r1 = r4.zza(r3, r1)
        L_0x007e:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            r5 = 1
            r6 = 3
            r7 = 0
            if (r4 == 0) goto L_0x0089
        L_0x0087:
            r0 = 0
            goto L_0x00cb
        L_0x0089:
            java.util.Queue<java.lang.String> r4 = zza
            boolean r4 = r4.contains(r0)
            if (r4 == 0) goto L_0x00b6
            java.lang.String r4 = "FirebaseMessaging"
            boolean r4 = android.util.Log.isLoggable(r4, r6)
            if (r4 == 0) goto L_0x00b4
            java.lang.String r4 = "FirebaseMessaging"
            java.lang.String r8 = "Received duplicate message: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r9 = r0.length()
            if (r9 == 0) goto L_0x00ac
            java.lang.String r0 = r8.concat(r0)
            goto L_0x00b1
        L_0x00ac:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r8)
        L_0x00b1:
            android.util.Log.d(r4, r0)
        L_0x00b4:
            r0 = 1
            goto L_0x00cb
        L_0x00b6:
            java.util.Queue<java.lang.String> r4 = zza
            int r4 = r4.size()
            r8 = 10
            if (r4 < r8) goto L_0x00c5
            java.util.Queue<java.lang.String> r4 = zza
            r4.remove()
        L_0x00c5:
            java.util.Queue<java.lang.String> r4 = zza
            r4.add(r0)
            goto L_0x0087
        L_0x00cb:
            if (r0 != 0) goto L_0x01e4
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 != 0) goto L_0x00d7
            java.lang.String r0 = "gcm"
        L_0x00d7:
            r4 = -1
            int r8 = r0.hashCode()
            r9 = -2062414158(0xffffffff85120eb2, float:-6.867586E-36)
            if (r8 == r9) goto L_0x010e
            r5 = 102161(0x18f11, float:1.43158E-40)
            if (r8 == r5) goto L_0x0104
            r5 = 814694033(0x308f3e91, float:1.0422402E-9)
            if (r8 == r5) goto L_0x00fa
            r5 = 814800675(0x3090df23, float:1.0540798E-9)
            if (r8 == r5) goto L_0x00f1
            goto L_0x0118
        L_0x00f1:
            java.lang.String r5 = "send_event"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x0118
            goto L_0x0119
        L_0x00fa:
            java.lang.String r3 = "send_error"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0118
            r3 = 3
            goto L_0x0119
        L_0x0104:
            java.lang.String r3 = "gcm"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0118
            r3 = 0
            goto L_0x0119
        L_0x010e:
            java.lang.String r3 = "deleted_messages"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0118
            r3 = 1
            goto L_0x0119
        L_0x0118:
            r3 = -1
        L_0x0119:
            switch(r3) {
                case 0: goto L_0x015e;
                case 1: goto L_0x0159;
                case 2: goto L_0x014e;
                case 3: goto L_0x0130;
                default: goto L_0x011c;
            }
        L_0x011c:
            java.lang.String r11 = "FirebaseMessaging"
            java.lang.String r2 = "Received message with unknown type: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x01dc
            java.lang.String r0 = r2.concat(r0)
            goto L_0x01e1
        L_0x0130:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 != 0) goto L_0x013e
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
        L_0x013e:
            com.google.firebase.messaging.SendException r2 = new com.google.firebase.messaging.SendException
            java.lang.String r3 = "error"
            java.lang.String r11 = r11.getStringExtra(r3)
            r2.<init>(r11)
            r10.onSendError(r0, r2)
            goto L_0x01e4
        L_0x014e:
            java.lang.String r0 = "google.message_id"
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.onMessageSent(r11)
            goto L_0x01e4
        L_0x0159:
            r10.onDeletedMessages()
            goto L_0x01e4
        L_0x015e:
            boolean r0 = com.google.firebase.messaging.zzp.zzd(r11)
            if (r0 == 0) goto L_0x0167
            com.google.firebase.messaging.zzp.zza((android.content.Intent) r11, (com.google.android.datatransport.Transport<java.lang.String>) r2)
        L_0x0167:
            boolean r0 = com.google.firebase.messaging.zzp.zze(r11)
            if (r0 == 0) goto L_0x018c
            com.google.android.datatransport.TransportFactory r0 = com.google.firebase.messaging.FirebaseMessaging.zza
            if (r0 == 0) goto L_0x0185
            java.lang.String r2 = "FCM_CLIENT_EVENT_LOGGING"
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.String r4 = "json"
            com.google.android.datatransport.Encoding r4 = com.google.android.datatransport.Encoding.m8671of(r4)
            com.google.android.datatransport.Transformer r5 = com.google.firebase.messaging.zzn.zza
            com.google.android.datatransport.Transport r0 = r0.getTransport(r2, r3, r4, r5)
            com.google.firebase.messaging.zzp.zza((android.content.Intent) r11, (com.google.android.datatransport.Transport<java.lang.String>) r0)
            goto L_0x018c
        L_0x0185:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r2 = "TransportFactory is null. Skip exporting message delivery metrics to Big Query"
            android.util.Log.e(r0, r2)
        L_0x018c:
            android.os.Bundle r0 = r11.getExtras()
            if (r0 != 0) goto L_0x0197
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x0197:
            java.lang.String r2 = "androidx.contentpager.content.wakelockid"
            r0.remove(r2)
            boolean r2 = com.google.firebase.messaging.zzr.zza((android.os.Bundle) r0)
            if (r2 == 0) goto L_0x01d3
            com.google.firebase.messaging.zzr r2 = new com.google.firebase.messaging.zzr
            r2.<init>(r0)
            com.google.android.gms.common.util.concurrent.NamedThreadFactory r3 = new com.google.android.gms.common.util.concurrent.NamedThreadFactory
            java.lang.String r4 = "Firebase-Messaging-Network-Io"
            r3.<init>(r4)
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor(r3)
            com.google.firebase.messaging.zzc r4 = new com.google.firebase.messaging.zzc
            r4.<init>(r10, r2, r3)
            boolean r2 = r4.zza()     // Catch:{ all -> 0x01ce }
            if (r2 == 0) goto L_0x01c1
            r3.shutdown()
            goto L_0x01e4
        L_0x01c1:
            r3.shutdown()
            boolean r2 = com.google.firebase.messaging.zzp.zzd(r11)
            if (r2 == 0) goto L_0x01d3
            com.google.firebase.messaging.zzp.zzc(r11)
            goto L_0x01d3
        L_0x01ce:
            r11 = move-exception
            r3.shutdown()
            throw r11
        L_0x01d3:
            com.google.firebase.messaging.RemoteMessage r11 = new com.google.firebase.messaging.RemoteMessage
            r11.<init>(r0)
            r10.onMessageReceived(r11)
            goto L_0x01e4
        L_0x01dc:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x01e1:
            android.util.Log.w(r11, r0)
        L_0x01e4:
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x01f6, InterruptedException -> 0x01f4, TimeoutException -> 0x01f2 }
            r2 = 1
            long r2 = r11.toMillis(r2)     // Catch:{ ExecutionException -> 0x01f6, InterruptedException -> 0x01f4, TimeoutException -> 0x01f2 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x01f6, InterruptedException -> 0x01f4, TimeoutException -> 0x01f2 }
            com.google.android.gms.tasks.Tasks.await(r1, r2, r11)     // Catch:{ ExecutionException -> 0x01f6, InterruptedException -> 0x01f4, TimeoutException -> 0x01f2 }
            return
        L_0x01f2:
            r11 = move-exception
            goto L_0x01f7
        L_0x01f4:
            r11 = move-exception
            goto L_0x01f7
        L_0x01f6:
            r11 = move-exception
        L_0x01f7:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = java.lang.String.valueOf(r11)
            int r1 = r1.length()
            int r1 = r1 + 20
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Message ack failed: "
            r2.append(r1)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.w(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzc(android.content.Intent):void");
    }
}
