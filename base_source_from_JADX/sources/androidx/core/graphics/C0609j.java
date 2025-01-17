package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: androidx.core.graphics.j */
public class C0609j {
    /* renamed from: a */
    public static File m2394a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (i < 100) {
            File file = new File(cacheDir, str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static ByteBuffer m2395a(Context context, Resources resources, int i) {
        File a = m2394a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!m2399a(a, resources, i)) {
                return null;
            }
            ByteBuffer a2 = m2397a(a);
            a.delete();
            return a2;
        } finally {
            a.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        r7 = r1;
        r1 = r10;
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004e, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0052, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        r7 = r10;
        r10 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004d A[ExcHandler: all (th java.lang.Throwable)] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer m2396a(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch:{ IOException -> 0x0067 }
            if (r8 != 0) goto L_0x0013
            if (r8 == 0) goto L_0x0012
            r8.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            r9.<init>(r10)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch:{ Throwable -> 0x0038, all -> 0x0035 }
            long r5 = r1.size()     // Catch:{ Throwable -> 0x0038, all -> 0x0035 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x0038, all -> 0x0035 }
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch:{ Throwable -> 0x0038, all -> 0x0035 }
            r9.close()     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            if (r8 == 0) goto L_0x0034
            r8.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0034:
            return r10
        L_0x0035:
            r10 = move-exception
            r1 = r0
            goto L_0x003e
        L_0x0038:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L_0x003e:
            if (r1 == 0) goto L_0x0049
            r9.close()     // Catch:{ Throwable -> 0x0044, all -> 0x004d }
            goto L_0x004c
        L_0x0044:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            goto L_0x004c
        L_0x0049:
            r9.close()     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
        L_0x004c:
            throw r10     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
        L_0x004d:
            r9 = move-exception
            r10 = r0
            goto L_0x0056
        L_0x0050:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0056:
            if (r8 == 0) goto L_0x0066
            if (r10 == 0) goto L_0x0063
            r8.close()     // Catch:{ Throwable -> 0x005e }
            goto L_0x0066
        L_0x005e:
            r8 = move-exception
            r10.addSuppressed(r8)     // Catch:{ IOException -> 0x0067 }
            goto L_0x0066
        L_0x0063:
            r8.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0066:
            throw r9     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.C0609j.m2396a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r8 = r2;
        r2 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r2 = null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer m2397a(java.io.File r9) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0032 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x0032 }
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            long r6 = r2.size()     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch:{ Throwable -> 0x001d, all -> 0x001a }
            r1.close()     // Catch:{ IOException -> 0x0032 }
            return r9
        L_0x001a:
            r9 = move-exception
            r2 = r0
            goto L_0x0023
        L_0x001d:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x001f }
        L_0x001f:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L_0x0023:
            if (r2 == 0) goto L_0x002e
            r1.close()     // Catch:{ Throwable -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ IOException -> 0x0032 }
            goto L_0x0031
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0031:
            throw r9     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.C0609j.m2397a(java.io.File):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    public static void m2398a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m2399a(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean a = m2400a(file, inputStream);
                m2398a((Closeable) inputStream);
                return a;
            } catch (Throwable th) {
                th = th;
                m2398a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            m2398a((Closeable) inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m2400a(File file, InputStream inputStream) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        m2398a((Closeable) fileOutputStream2);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m2398a((Closeable) fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    m2398a((Closeable) fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                m2398a((Closeable) fileOutputStream);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            m2398a((Closeable) fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        }
    }
}
