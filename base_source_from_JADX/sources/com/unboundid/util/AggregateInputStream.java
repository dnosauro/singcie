package com.unboundid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class AggregateInputStream extends InputStream {
    private volatile InputStream activeInputStream;
    private final Iterator<InputStream> streamIterator;

    public AggregateInputStream(Collection<? extends InputStream> collection) {
        Validator.ensureNotNull(collection);
        this.streamIterator = new ArrayList(collection).iterator();
        this.activeInputStream = null;
    }

    public AggregateInputStream(File... fileArr) {
        IOException e;
        Validator.ensureNotNull(fileArr);
        ArrayList arrayList = new ArrayList(fileArr.length);
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            try {
                arrayList.add(new FileInputStream(fileArr[i]));
                i++;
            } catch (IOException e2) {
                e = e2;
                Debug.debugException(e);
            }
        }
        e = null;
        if (e != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                InputStream inputStream = (InputStream) it.next();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        Debug.debugException(e3);
                    }
                }
            }
            throw e;
        }
        this.streamIterator = arrayList.iterator();
        this.activeInputStream = null;
    }

    public AggregateInputStream(InputStream... inputStreamArr) {
        this((Collection<? extends InputStream>) StaticUtils.toList(inputStreamArr));
    }

    public int available() {
        if (this.activeInputStream == null) {
            if (!this.streamIterator.hasNext()) {
                return 0;
            }
            this.activeInputStream = this.streamIterator.next();
        }
        return this.activeInputStream.available();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f A[SYNTHETIC] */
    public void close() {
        /*
            r2 = this;
            java.io.InputStream r0 = r2.activeInputStream
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.io.InputStream r0 = r2.activeInputStream     // Catch:{ IOException -> 0x000c }
            r0.close()     // Catch:{ IOException -> 0x000c }
            r0 = r1
            goto L_0x0010
        L_0x000c:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
        L_0x0010:
            r2.activeInputStream = r1
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            java.util.Iterator<java.io.InputStream> r1 = r2.streamIterator
            boolean r1 = r1.hasNext()
            if (r1 == 0) goto L_0x002f
            java.util.Iterator<java.io.InputStream> r1 = r2.streamIterator
            java.lang.Object r1 = r1.next()
            java.io.InputStream r1 = (java.io.InputStream) r1
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x0014
        L_0x0028:
            r1 = move-exception
            com.unboundid.util.Debug.debugException(r1)
            if (r0 != 0) goto L_0x0014
            goto L_0x0013
        L_0x002f:
            if (r0 != 0) goto L_0x0032
            return
        L_0x0032:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.AggregateInputStream.close():void");
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        InputStream inputStream;
        while (true) {
            if (this.activeInputStream != null) {
                int read = this.activeInputStream.read();
                if (read >= 0) {
                    return read;
                }
                this.activeInputStream.close();
                inputStream = null;
            } else if (!this.streamIterator.hasNext()) {
                return -1;
            } else {
                inputStream = this.streamIterator.next();
            }
            this.activeInputStream = inputStream;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        InputStream inputStream;
        while (true) {
            if (this.activeInputStream != null) {
                int read = this.activeInputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                this.activeInputStream.close();
                inputStream = null;
            } else if (!this.streamIterator.hasNext()) {
                return -1;
            } else {
                inputStream = this.streamIterator.next();
            }
            this.activeInputStream = inputStream;
        }
    }

    public void reset() {
        throw new IOException(UtilityMessages.ERR_AGGREGATE_INPUT_STREAM_MARK_NOT_SUPPORTED.get());
    }

    public long skip(long j) {
        if (this.activeInputStream == null) {
            if (!this.streamIterator.hasNext()) {
                return 0;
            }
            this.activeInputStream = this.streamIterator.next();
        }
        return this.activeInputStream.skip(j);
    }
}
