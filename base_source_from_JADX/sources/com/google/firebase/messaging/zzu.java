package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.p018c.C0400a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.iid.zzt;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

final class zzu {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static final Pattern zzb = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final FirebaseInstanceId zzc;
    private final Context zzd;
    private final zzao zze;
    private final zzt zzf;
    private final ScheduledExecutorService zzg;
    private boolean zzh;
    private int zzi;
    private final Map<Integer, TaskCompletionSource<Void>> zzj;
    private final zzv zzk;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzu(com.google.firebase.FirebaseApp r14, com.google.firebase.iid.FirebaseInstanceId r15, com.google.firebase.iid.zzao r16, com.google.firebase.platforminfo.UserAgentPublisher r17, com.google.firebase.heartbeatinfo.HeartBeatInfo r18, com.google.firebase.installations.FirebaseInstallationsApi r19, android.content.Context r20, java.util.concurrent.Executor r21, java.util.concurrent.ScheduledExecutorService r22) {
        /*
            r13 = this;
            com.google.firebase.messaging.zzv r3 = new com.google.firebase.messaging.zzv
            r5 = r20
            r3.<init>(r5)
            com.google.firebase.iid.zzt r4 = new com.google.firebase.iid.zzt
            r6 = r4
            r7 = r14
            r8 = r16
            r9 = r21
            r10 = r17
            r11 = r18
            r12 = r19
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0 = r13
            r1 = r15
            r2 = r16
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzu.<init>(com.google.firebase.FirebaseApp, com.google.firebase.iid.FirebaseInstanceId, com.google.firebase.iid.zzao, com.google.firebase.platforminfo.UserAgentPublisher, com.google.firebase.heartbeatinfo.HeartBeatInfo, com.google.firebase.installations.FirebaseInstallationsApi, android.content.Context, java.util.concurrent.Executor, java.util.concurrent.ScheduledExecutorService):void");
    }

    private zzu(FirebaseInstanceId firebaseInstanceId, zzao zzao, zzv zzv, zzt zzt, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzh = false;
        this.zzi = 0;
        this.zzj = new C0400a();
        this.zzc = firebaseInstanceId;
        this.zze = zzao;
        this.zzk = zzv;
        this.zzf = zzt;
        this.zzd = context;
        this.zzg = scheduledExecutorService;
    }

    private static <T> T zza(Task<T> task) {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        }
    }

    private static String zza(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 78);
            sb.append("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in ");
            sb.append(str2);
            sb.append(".");
            Log.w("FirebaseMessaging", sb.toString());
            str = str.substring(8);
        }
        if (str != null && zzb.matcher(str).matches()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 79);
        sb2.append("Invalid topic name: ");
        sb2.append(str);
        sb2.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}.");
        throw new IllegalArgumentException(sb2.toString());
    }

    private final synchronized Task<Void> zzc(String str) {
        String zza2;
        TaskCompletionSource taskCompletionSource;
        synchronized (this.zzk) {
            zza2 = this.zzk.zza();
            zzv zzv = this.zzk;
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 1 + String.valueOf(str).length());
            sb.append(zza2);
            sb.append(",");
            sb.append(str);
            zzv.zza(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource();
        this.zzj.put(Integer.valueOf(this.zzi + (TextUtils.isEmpty(zza2) ? 0 : zza2.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    static boolean zzc() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    private final synchronized boolean zzd() {
        return zzf() != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        android.util.Log.d(r8, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "!"
            java.lang.String[] r0 = r8.split(r0)
            int r1 = r0.length
            r2 = 1
            r3 = 2
            if (r1 != r3) goto L_0x0145
            r1 = 0
            r3 = r0[r1]
            r0 = r0[r2]
            r4 = -1
            int r5 = r3.hashCode()     // Catch:{ IOException -> 0x00f2 }
            r6 = 83
            if (r5 == r6) goto L_0x0028
            r6 = 85
            if (r5 == r6) goto L_0x001e
            goto L_0x0031
        L_0x001e:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x00f2 }
            if (r3 == 0) goto L_0x0031
            r4 = 1
            goto L_0x0031
        L_0x0028:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x00f2 }
            if (r3 == 0) goto L_0x0031
            r4 = 0
        L_0x0031:
            switch(r4) {
                case 0: goto L_0x0084;
                case 1: goto L_0x003a;
                default: goto L_0x0034;
            }     // Catch:{ IOException -> 0x00f2 }
        L_0x0034:
            boolean r0 = zzc()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00ca
        L_0x003a:
            com.google.firebase.iid.FirebaseInstanceId r8 = r7.zzc     // Catch:{ IOException -> 0x00f2 }
            com.google.android.gms.tasks.Task r8 = r8.getInstanceId()     // Catch:{ IOException -> 0x00f2 }
            java.lang.Object r8 = zza(r8)     // Catch:{ IOException -> 0x00f2 }
            com.google.firebase.iid.InstanceIdResult r8 = (com.google.firebase.iid.InstanceIdResult) r8     // Catch:{ IOException -> 0x00f2 }
            com.google.firebase.iid.zzt r3 = r7.zzf     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r4 = r8.getId()     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r8 = r8.getToken()     // Catch:{ IOException -> 0x00f2 }
            com.google.android.gms.tasks.Task r8 = r3.zzd(r4, r8, r0)     // Catch:{ IOException -> 0x00f2 }
            zza(r8)     // Catch:{ IOException -> 0x00f2 }
            boolean r8 = zzc()     // Catch:{ IOException -> 0x00f2 }
            if (r8 == 0) goto L_0x0145
            java.lang.String r8 = "FirebaseMessaging"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3 + 35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r3 = "Unsubscribe from topic: "
            r4.append(r3)     // Catch:{ IOException -> 0x00f2 }
            r4.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r0 = " succeeded."
            r4.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x00f2 }
        L_0x007f:
            android.util.Log.d(r8, r0)     // Catch:{ IOException -> 0x00f2 }
            goto L_0x0145
        L_0x0084:
            com.google.firebase.iid.FirebaseInstanceId r8 = r7.zzc     // Catch:{ IOException -> 0x00f2 }
            com.google.android.gms.tasks.Task r8 = r8.getInstanceId()     // Catch:{ IOException -> 0x00f2 }
            java.lang.Object r8 = zza(r8)     // Catch:{ IOException -> 0x00f2 }
            com.google.firebase.iid.InstanceIdResult r8 = (com.google.firebase.iid.InstanceIdResult) r8     // Catch:{ IOException -> 0x00f2 }
            com.google.firebase.iid.zzt r3 = r7.zzf     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r4 = r8.getId()     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r8 = r8.getToken()     // Catch:{ IOException -> 0x00f2 }
            com.google.android.gms.tasks.Task r8 = r3.zzc(r4, r8, r0)     // Catch:{ IOException -> 0x00f2 }
            zza(r8)     // Catch:{ IOException -> 0x00f2 }
            boolean r8 = zzc()     // Catch:{ IOException -> 0x00f2 }
            if (r8 == 0) goto L_0x0145
            java.lang.String r8 = "FirebaseMessaging"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3 + 31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r3 = "Subscribe to topic: "
            r4.append(r3)     // Catch:{ IOException -> 0x00f2 }
            r4.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r0 = " succeeded."
            r4.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x007f
        L_0x00ca:
            if (r0 == 0) goto L_0x0145
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x00f2 }
            int r3 = r3 + 24
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r3 = "Unknown topic operation"
            r4.append(r3)     // Catch:{ IOException -> 0x00f2 }
            r4.append(r8)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r8 = "."
            r4.append(r8)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r8 = r4.toString()     // Catch:{ IOException -> 0x00f2 }
            android.util.Log.d(r0, r8)     // Catch:{ IOException -> 0x00f2 }
            goto L_0x0145
        L_0x00f2:
            r8 = move-exception
            java.lang.String r0 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r2 = r8.getMessage()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x011b
            java.lang.String r0 = "INTERNAL_SERVER_ERROR"
            java.lang.String r2 = r8.getMessage()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x010c
            goto L_0x011b
        L_0x010c:
            java.lang.String r0 = r8.getMessage()
            if (r0 != 0) goto L_0x011a
            java.lang.String r8 = "FirebaseMessaging"
            java.lang.String r0 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r8, r0)
            return r1
        L_0x011a:
            throw r8
        L_0x011b:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r8 = r8.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r8)
            int r2 = r2.length()
            int r2 = r2 + 53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Topic operation failed: "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r8 = ". Will retry Topic operation."
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            android.util.Log.e(r0, r8)
            return r1
        L_0x0145:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzu.zzd(java.lang.String):boolean");
    }

    private final synchronized void zze() {
        if (!this.zzh) {
            zza(0);
        }
    }

    private final String zzf() {
        String zza2;
        synchronized (this.zzk) {
            zza2 = this.zzk.zza();
        }
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        String[] split = zza2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> zza(String str) {
        String valueOf = String.valueOf("S!");
        String valueOf2 = String.valueOf(zza(str, "subscribeToTopic"));
        Task<Void> zzc2 = zzc(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zza();
        return zzc2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza() {
        if (zzd()) {
            zze();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j) {
        zza((Runnable) new zzx(this, this.zzd, this.zze, Math.min(Math.max(30, j << 1), zza)), j);
        this.zzh = true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(Runnable runnable, long j) {
        this.zzg.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzh = z;
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> zzb(String str) {
        String valueOf = String.valueOf("U!");
        String valueOf2 = String.valueOf(zza(str, "unsubscribeFromTopic"));
        Task<Void> zzc2 = zzc(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zza();
        return zzc2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (zzd(r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r5.zzj.remove(java.lang.Integer.valueOf(r5.zzi));
        r3 = r5.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.zzk.zzb(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r5.zzi++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        r2.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb() {
        /*
            r5 = this;
        L_0x0000:
            monitor-enter(r5)
            java.lang.String r0 = r5.zzf()     // Catch:{ all -> 0x004b }
            r1 = 1
            if (r0 != 0) goto L_0x0017
            boolean r0 = zzc()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r2 = "topic sync succeeded"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x004b }
        L_0x0015:
            monitor-exit(r5)     // Catch:{ all -> 0x004b }
            return r1
        L_0x0017:
            monitor-exit(r5)     // Catch:{ all -> 0x004b }
            boolean r2 = r5.zzd(r0)
            if (r2 != 0) goto L_0x0020
            r0 = 0
            return r0
        L_0x0020:
            monitor-enter(r5)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r5.zzj     // Catch:{ all -> 0x0048 }
            int r3 = r5.zzi     // Catch:{ all -> 0x0048 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0048 }
            com.google.firebase.messaging.zzv r3 = r5.zzk     // Catch:{ all -> 0x0048 }
            monitor-enter(r3)     // Catch:{ all -> 0x0048 }
            com.google.firebase.messaging.zzv r4 = r5.zzk     // Catch:{ all -> 0x0045 }
            r4.zzb(r0)     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            int r0 = r5.zzi     // Catch:{ all -> 0x0048 }
            int r0 = r0 + r1
            r5.zzi = r0     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0000
            r0 = 0
            r2.setResult(r0)
            goto L_0x0000
        L_0x0045:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            throw r0
        L_0x004b:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x004b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzu.zzb():boolean");
    }
}
