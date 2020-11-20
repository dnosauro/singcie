package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzc = new ConcurrentHashMap<>();

    @VisibleForTesting
    protected LibraryVersion() {
    }

    @KeepForSdk
    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[Catch:{ all -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad A[Catch:{ all -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r9.zzc
            boolean r0 = r0.containsKey(r10)
            if (r0 == 0) goto L_0x0016
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r9.zzc
            java.lang.Object r10 = r0.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            return r10
        L_0x0016:
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "/%s.properties"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0096 }
            r4 = 0
            r3[r4] = r10     // Catch:{ IOException -> 0x0096 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ IOException -> 0x0096 }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r3 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r2 = r3.getResourceAsStream(r2)     // Catch:{ IOException -> 0x0096 }
            if (r2 == 0) goto L_0x0068
            r0.load(r2)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            java.lang.String r3 = "version"
            java.lang.String r1 = r0.getProperty(r3, r1)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            java.lang.String r3 = "LibraryVersion"
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            int r4 = r4.length()     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            int r4 = r4 + 12
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            int r5 = r5.length()     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r5.append(r10)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            java.lang.String r4 = " version is "
            r5.append(r4)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r5.append(r1)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r0.mo11643v(r3, r4)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            goto L_0x0086
        L_0x0068:
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            java.lang.String r3 = "LibraryVersion"
            java.lang.String r4 = "Failed to get app version for libraryName: "
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            int r6 = r5.length()     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            if (r6 == 0) goto L_0x007d
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            goto L_0x0083
        L_0x007d:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
            r4 = r5
        L_0x0083:
            r0.mo11645w(r3, r4)     // Catch:{ IOException -> 0x008e, all -> 0x008c }
        L_0x0086:
            if (r2 == 0) goto L_0x00bc
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            goto L_0x00bc
        L_0x008c:
            r10 = move-exception
            goto L_0x00cf
        L_0x008e:
            r0 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0098
        L_0x0093:
            r10 = move-exception
            r2 = r1
            goto L_0x00cf
        L_0x0096:
            r0 = move-exception
            r2 = r1
        L_0x0098:
            com.google.android.gms.common.internal.GmsLogger r3 = zza     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = "LibraryVersion"
            java.lang.String r5 = "Failed to get app version for libraryName: "
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0093 }
            int r7 = r6.length()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x00ad
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x00b3
        L_0x00ad:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r5 = r6
        L_0x00b3:
            r3.mo11637e(r4, r5, r0)     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x00bb
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r1)
        L_0x00bb:
            r1 = r2
        L_0x00bc:
            if (r1 != 0) goto L_0x00c9
            java.lang.String r1 = "UNKNOWN"
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            java.lang.String r2 = "LibraryVersion"
            java.lang.String r3 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.mo11634d(r2, r3)
        L_0x00c9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r9.zzc
            r0.put(r10, r1)
            return r1
        L_0x00cf:
            if (r2 == 0) goto L_0x00d4
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
        L_0x00d4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
