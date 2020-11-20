package androidx.work.impl.p062b;

import androidx.work.C1184a;
import androidx.work.C1198i;
import androidx.work.C1335n;

/* renamed from: androidx.work.impl.b.p */
public class C1258p {
    /* renamed from: a */
    public static int m4947a(C1184a aVar) {
        switch (aVar) {
            case EXPONENTIAL:
                return 0;
            case LINEAR:
                return 1;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    /* renamed from: a */
    public static int m4948a(C1198i iVar) {
        switch (iVar) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                return 3;
            case METERED:
                return 4;
            default:
                throw new IllegalArgumentException("Could not convert " + iVar + " to int");
        }
    }

    /* renamed from: a */
    public static int m4949a(C1335n.C1336a aVar) {
        switch (aVar) {
            case ENQUEUED:
                return 0;
            case RUNNING:
                return 1;
            case SUCCEEDED:
                return 2;
            case FAILED:
                return 3;
            case BLOCKED:
                return 4;
            case CANCELLED:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC, Splitter:B:25:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC, Splitter:B:36:0x005a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0033=Splitter:B:15:0x0033, B:29:0x004e=Splitter:B:29:0x004e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.C1190d m4950a(byte[] r6) {
        /*
            androidx.work.d r0 = new androidx.work.d
            r0.<init>()
            if (r6 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            int r6 = r2.readInt()     // Catch:{ IOException -> 0x0037 }
        L_0x0017:
            if (r6 <= 0) goto L_0x002b
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x0037 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x0037 }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x0037 }
            r0.mo6399a(r3, r4)     // Catch:{ IOException -> 0x0037 }
            int r6 = r6 + -1
            goto L_0x0017
        L_0x002b:
            r2.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0033:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0037:
            r6 = move-exception
            goto L_0x0041
        L_0x0039:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x0058
        L_0x003d:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0041:
            r6.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004e:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
        L_0x0058:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.p062b.C1258p.m4950a(byte[]):androidx.work.d");
    }

    /* renamed from: a */
    public static C1335n.C1336a m4951a(int i) {
        switch (i) {
            case 0:
                return C1335n.C1336a.ENQUEUED;
            case 1:
                return C1335n.C1336a.RUNNING;
            case 2:
                return C1335n.C1336a.SUCCEEDED;
            case 3:
                return C1335n.C1336a.FAILED;
            case 4:
                return C1335n.C1336a.BLOCKED;
            case 5:
                return C1335n.C1336a.CANCELLED;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to State");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[SYNTHETIC, Splitter:B:37:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0062=Splitter:B:30:0x0062, B:15:0x0048=Splitter:B:15:0x0048} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4952a(androidx.work.C1190d r4) {
        /*
            int r0 = r4.mo6400b()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0054 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0054 }
            int r1 = r4.mo6400b()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.util.Set r4 = r4.mo6398a()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
        L_0x0021:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            androidx.work.d$a r1 = (androidx.work.C1190d.C1191a) r1     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            android.net.Uri r3 = r1.mo6403a()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            boolean r1 = r1.mo6404b()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeBoolean(r1)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            goto L_0x0021
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x004c:
            r4 = move-exception
            goto L_0x006f
        L_0x004e:
            r4 = move-exception
            r1 = r2
            goto L_0x0055
        L_0x0051:
            r4 = move-exception
            r2 = r1
            goto L_0x006f
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0062:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006a:
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x006f:
            if (r2 == 0) goto L_0x0079
            r2.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0079:
            r0.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0081:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.p062b.C1258p.m4952a(androidx.work.d):byte[]");
    }

    /* renamed from: b */
    public static C1184a m4953b(int i) {
        switch (i) {
            case 0:
                return C1184a.EXPONENTIAL;
            case 1:
                return C1184a.LINEAR;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
        }
    }

    /* renamed from: c */
    public static C1198i m4954c(int i) {
        switch (i) {
            case 0:
                return C1198i.NOT_REQUIRED;
            case 1:
                return C1198i.CONNECTED;
            case 2:
                return C1198i.UNMETERED;
            case 3:
                return C1198i.NOT_ROAMING;
            case 4:
                return C1198i.METERED;
            default:
                throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
        }
    }
}
