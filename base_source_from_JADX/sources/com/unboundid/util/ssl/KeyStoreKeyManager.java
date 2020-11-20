package com.unboundid.util.ssl;

import java.io.File;
import java.io.Serializable;
import java.security.KeyStore;

public final class KeyStoreKeyManager extends WrapperKeyManager implements Serializable {
    private static final long serialVersionUID = -5202641256733094253L;
    private final String keyStoreFile;
    private final String keyStoreFormat;

    public KeyStoreKeyManager(File file, char[] cArr) {
        this(file.getAbsolutePath(), cArr, (String) null, (String) null);
    }

    public KeyStoreKeyManager(File file, char[] cArr, String str, String str2) {
        this(file.getAbsolutePath(), cArr, str, str2);
    }

    public KeyStoreKeyManager(String str, char[] cArr) {
        this(str, cArr, (String) null, (String) null);
    }

    public KeyStoreKeyManager(String str, char[] cArr, String str2, String str3) {
        super(getKeyManagers(str, cArr, str2), str3);
        this.keyStoreFile = str;
        if (str2 == null) {
            this.keyStoreFormat = KeyStore.getDefaultType();
        } else {
            this.keyStoreFormat = str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[SYNTHETIC, Splitter:B:31:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.net.ssl.KeyManager[] getKeyManagers(java.lang.String r9, char[] r10, java.lang.String r11) {
        /*
            com.unboundid.util.Validator.ensureNotNull(r9)
            if (r11 != 0) goto L_0x000a
            java.lang.String r0 = java.security.KeyStore.getDefaultType()
            goto L_0x000b
        L_0x000a:
            r0 = r11
        L_0x000b:
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            boolean r2 = r1.exists()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x008a
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r0)
            r5 = 0
            r6 = 2
            r7 = 3
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0063 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0063 }
            r2.load(r8, r10)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r8.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
        L_0x002f:
            java.lang.String r0 = javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x003f }
            javax.net.ssl.KeyManagerFactory r0 = javax.net.ssl.KeyManagerFactory.getInstance(r0)     // Catch:{ Exception -> 0x003f }
            r0.init(r2, r10)     // Catch:{ Exception -> 0x003f }
            javax.net.ssl.KeyManager[] r9 = r0.getKeyManagers()     // Catch:{ Exception -> 0x003f }
            return r9
        L_0x003f:
            r10 = move-exception
            com.unboundid.util.Debug.debugException(r10)
            java.security.KeyStoreException r0 = new java.security.KeyStoreException
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.ERR_KEYSTORE_CANNOT_GET_KEY_MANAGERS
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r3] = r9
            r2[r4] = r11
            java.lang.String r9 = java.lang.String.valueOf(r10)
            r2[r6] = r9
            java.lang.String r9 = r1.get(r2)
            r0.<init>(r9, r10)
            throw r0
        L_0x005b:
            r9 = move-exception
            r5 = r8
            goto L_0x007f
        L_0x005e:
            r10 = move-exception
            r5 = r8
            goto L_0x0064
        L_0x0061:
            r9 = move-exception
            goto L_0x007f
        L_0x0063:
            r10 = move-exception
        L_0x0064:
            com.unboundid.util.Debug.debugException(r10)     // Catch:{ all -> 0x0061 }
            java.security.KeyStoreException r11 = new java.security.KeyStoreException     // Catch:{ all -> 0x0061 }
            com.unboundid.util.ssl.SSLMessages r1 = com.unboundid.util.ssl.SSLMessages.ERR_KEYSTORE_CANNOT_LOAD     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x0061 }
            r2[r3] = r9     // Catch:{ all -> 0x0061 }
            r2[r4] = r0     // Catch:{ all -> 0x0061 }
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0061 }
            r2[r6] = r9     // Catch:{ all -> 0x0061 }
            java.lang.String r9 = r1.get(r2)     // Catch:{ all -> 0x0061 }
            r11.<init>(r9, r10)     // Catch:{ all -> 0x0061 }
            throw r11     // Catch:{ all -> 0x0061 }
        L_0x007f:
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ Exception -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r10 = move-exception
            com.unboundid.util.Debug.debugException(r10)
        L_0x0089:
            throw r9
        L_0x008a:
            java.security.KeyStoreException r10 = new java.security.KeyStoreException
            com.unboundid.util.ssl.SSLMessages r11 = com.unboundid.util.ssl.SSLMessages.ERR_KEYSTORE_NO_SUCH_FILE
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r9
            java.lang.String r9 = r11.get(r0)
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ssl.KeyStoreKeyManager.getKeyManagers(java.lang.String, char[], java.lang.String):javax.net.ssl.KeyManager[]");
    }

    public String getKeyStoreFile() {
        return this.keyStoreFile;
    }

    public String getKeyStoreFormat() {
        return this.keyStoreFormat;
    }
}
