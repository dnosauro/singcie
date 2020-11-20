package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.util.ByteStringBuffer;
import com.unboundid.util.Debug;
import com.unboundid.util.LDAPSDKThreadFactory;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import com.unboundid.util.parallel.ParallelProcessor;
import com.unboundid.util.parallel.Processor;
import com.unboundid.util.parallel.Result;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LDIFWriter {
    private static final int DEFAULT_BUFFER_SIZE = 131072;
    private final ByteStringBuffer buffer;
    private final ParallelProcessor<LDIFRecord, ByteStringBuffer> toLdifBytesInvoker;
    private int wrapColumn;
    private int wrapColumnMinusTwo;
    private final BufferedOutputStream writer;

    public LDIFWriter(File file) {
        this((OutputStream) new FileOutputStream(file));
    }

    public LDIFWriter(OutputStream outputStream) {
        this(outputStream, 0);
    }

    public LDIFWriter(OutputStream outputStream, int i) {
        boolean z = false;
        this.wrapColumn = 0;
        this.wrapColumnMinusTwo = -2;
        Validator.ensureNotNull(outputStream);
        Validator.ensureTrue(i >= 0 ? true : z, "LDIFWriter.parallelThreads must not be negative.");
        this.buffer = new ByteStringBuffer();
        if (outputStream instanceof BufferedOutputStream) {
            this.writer = (BufferedOutputStream) outputStream;
        } else {
            this.writer = new BufferedOutputStream(outputStream, 131072);
        }
        this.toLdifBytesInvoker = i != 0 ? new ParallelProcessor<>(new Processor<LDIFRecord, ByteStringBuffer>() {
            public ByteStringBuffer process(LDIFRecord lDIFRecord) {
                return LDIFWriter.this.toLDIFBytes(lDIFRecord);
            }
        }, new LDAPSDKThreadFactory("LDIFWriter Worker", true, (ThreadGroup) null), i, 5) : null;
    }

    public LDIFWriter(String str) {
        this((OutputStream) new FileOutputStream(str));
    }

    public static String encodeNameAndValue(String str, ASN1OctetString aSN1OctetString) {
        StringBuilder sb = new StringBuilder();
        encodeNameAndValue(str, aSN1OctetString, sb);
        return sb.toString();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static void encodeNameAndValue(java.lang.String r8, com.unboundid.asn1.ASN1OctetString r9, com.unboundid.util.ByteStringBuffer r10, int r11) {
        /*
            int r0 = r10.length()
            r1 = 2
            r2 = 32
            r3 = 0
            r10.append((java.lang.CharSequence) r8)     // Catch:{ all -> 0x01c6 }
            r8 = 58
            r10.append((char) r8)     // Catch:{ all -> 0x01c6 }
            byte[] r9 = r9.getValue()     // Catch:{ all -> 0x01c6 }
            int r4 = r9.length     // Catch:{ all -> 0x01c6 }
            if (r4 != 0) goto L_0x0053
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x0052
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x0052
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x0043:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x0052
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x0043
        L_0x0052:
            return
        L_0x0053:
            byte r5 = r9[r3]     // Catch:{ all -> 0x01c6 }
            if (r5 == r2) goto L_0x0184
            if (r5 == r8) goto L_0x0184
            r6 = 60
            if (r5 == r6) goto L_0x0184
            int r5 = r4 + -1
            byte r5 = r9[r5]     // Catch:{ all -> 0x01c6 }
            if (r5 != r2) goto L_0x00a5
            r10.append((char) r8)     // Catch:{ all -> 0x01c6 }
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            com.unboundid.util.Base64.encode((byte[]) r9, (com.unboundid.util.ByteStringBuffer) r10)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x00a4
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x00a4
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x0095:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x00a4
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x0095
        L_0x00a4:
            return
        L_0x00a5:
            r5 = 0
        L_0x00a6:
            if (r5 >= r4) goto L_0x0145
            byte r6 = r9[r5]     // Catch:{ all -> 0x01c6 }
            r6 = r6 & 127(0x7f, float:1.78E-43)
            byte r7 = r9[r5]     // Catch:{ all -> 0x01c6 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            if (r6 == r7) goto L_0x00f4
            r10.append((char) r8)     // Catch:{ all -> 0x01c6 }
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            com.unboundid.util.Base64.encode((byte[]) r9, (com.unboundid.util.ByteStringBuffer) r10)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x00f3
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x00f3
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x00e4:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x00f3
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x00e4
        L_0x00f3:
            return
        L_0x00f4:
            byte r6 = r9[r5]     // Catch:{ all -> 0x01c6 }
            if (r6 == 0) goto L_0x0103
            r7 = 10
            if (r6 == r7) goto L_0x0103
            r7 = 13
            if (r6 == r7) goto L_0x0103
            int r5 = r5 + 1
            goto L_0x00a6
        L_0x0103:
            r10.append((char) r8)     // Catch:{ all -> 0x01c6 }
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            com.unboundid.util.Base64.encode((byte[]) r9, (com.unboundid.util.ByteStringBuffer) r10)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x0144
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x0144
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x0135:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x0144
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x0135
        L_0x0144:
            return
        L_0x0145:
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            r10.append((byte[]) r9)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x0183
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x0183
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x0174:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x0183
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x0174
        L_0x0183:
            return
        L_0x0184:
            r10.append((char) r8)     // Catch:{ all -> 0x01c6 }
            r10.append((char) r2)     // Catch:{ all -> 0x01c6 }
            com.unboundid.util.Base64.encode((byte[]) r9, (com.unboundid.util.ByteStringBuffer) r10)     // Catch:{ all -> 0x01c6 }
            if (r11 <= r1) goto L_0x01c5
            int r8 = r10.length()
            int r8 = r8 - r0
            if (r8 <= r11) goto L_0x01c5
            byte[] r8 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r8 = r8.length
            int r8 = r8 + 1
            byte[] r8 = new byte[r8]
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            java.lang.System.arraycopy(r9, r3, r8, r3, r1)
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            r8[r9] = r2
            int r9 = r0 + r11
            r10.insert((int) r9, (byte[]) r8)
            int r9 = r11 * 2
            int r0 = r0 + r9
            int r9 = r8.length
            int r0 = r0 + r9
            int r0 = r0 + -1
        L_0x01b6:
            int r9 = r10.length()
            if (r0 >= r9) goto L_0x01c5
            r10.insert((int) r0, (byte[]) r8)
            int r9 = r11 + -1
            int r1 = r8.length
            int r9 = r9 + r1
            int r0 = r0 + r9
            goto L_0x01b6
        L_0x01c5:
            return
        L_0x01c6:
            r8 = move-exception
            if (r11 <= r1) goto L_0x01ff
            int r9 = r10.length()
            int r9 = r9 - r0
            if (r9 <= r11) goto L_0x01ff
            byte[] r9 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r9 = r9.length
            int r9 = r9 + 1
            byte[] r9 = new byte[r9]
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            byte[] r4 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r4 = r4.length
            java.lang.System.arraycopy(r1, r3, r9, r3, r4)
            byte[] r1 = com.unboundid.util.StaticUtils.EOL_BYTES
            int r1 = r1.length
            r9[r1] = r2
            int r1 = r0 + r11
            r10.insert((int) r1, (byte[]) r9)
            int r1 = r11 * 2
            int r0 = r0 + r1
            int r1 = r9.length
            int r0 = r0 + r1
            int r0 = r0 + -1
        L_0x01f0:
            int r1 = r10.length()
            if (r0 >= r1) goto L_0x01ff
            r10.insert((int) r0, (byte[]) r9)
            int r1 = r11 + -1
            int r2 = r9.length
            int r1 = r1 + r2
            int r0 = r0 + r1
            goto L_0x01f0
        L_0x01ff:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFWriter.encodeNameAndValue(java.lang.String, com.unboundid.asn1.ASN1OctetString, com.unboundid.util.ByteStringBuffer, int):void");
    }

    public static void encodeNameAndValue(String str, ASN1OctetString aSN1OctetString, StringBuilder sb) {
        encodeNameAndValue(str, aSN1OctetString, sb, 0);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static void encodeNameAndValue(java.lang.String r7, com.unboundid.asn1.ASN1OctetString r8, java.lang.StringBuilder r9, int r10) {
        /*
            int r0 = r9.length()
            r1 = 32
            r2 = 2
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            r7 = 58
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            byte[] r3 = r8.getValue()     // Catch:{ all -> 0x01d7 }
            int r4 = r3.length     // Catch:{ all -> 0x01d7 }
            if (r4 != 0) goto L_0x0055
            r9.append(r1)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x0054
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x0054
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x0042:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x0054
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x0042
        L_0x0054:
            return
        L_0x0055:
            r5 = 0
            byte r6 = r3[r5]     // Catch:{ all -> 0x01d7 }
            if (r6 == r1) goto L_0x0193
            if (r6 == r7) goto L_0x0193
            r7 = 60
            if (r6 == r7) goto L_0x0193
            int r7 = r4 + -1
            byte r7 = r3[r7]     // Catch:{ all -> 0x01d7 }
            if (r7 != r1) goto L_0x00aa
            java.lang.String r7 = ": "
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            com.unboundid.util.Base64.encode((byte[]) r3, (java.lang.StringBuilder) r9)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x00a9
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x0097:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x00a9
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x0097
        L_0x00a9:
            return
        L_0x00aa:
            if (r5 >= r4) goto L_0x014d
            byte r7 = r3[r5]     // Catch:{ all -> 0x01d7 }
            r7 = r7 & 127(0x7f, float:1.78E-43)
            byte r6 = r3[r5]     // Catch:{ all -> 0x01d7 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r7 == r6) goto L_0x00fa
            java.lang.String r7 = ": "
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            com.unboundid.util.Base64.encode((byte[]) r3, (java.lang.StringBuilder) r9)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x00f9
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x00f9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x00e7:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x00f9
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x00e7
        L_0x00f9:
            return
        L_0x00fa:
            byte r7 = r3[r5]     // Catch:{ all -> 0x01d7 }
            if (r7 == 0) goto L_0x0109
            r6 = 10
            if (r7 == r6) goto L_0x0109
            r6 = 13
            if (r7 == r6) goto L_0x0109
            int r5 = r5 + 1
            goto L_0x00aa
        L_0x0109:
            java.lang.String r7 = ": "
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            com.unboundid.util.Base64.encode((byte[]) r3, (java.lang.StringBuilder) r9)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x014c
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x014c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x013a:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x014c
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x013a
        L_0x014c:
            return
        L_0x014d:
            r9.append(r1)     // Catch:{ all -> 0x01d7 }
            java.lang.String r7 = r8.stringValue()     // Catch:{ all -> 0x01d7 }
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x0192
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x0192
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x0180:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x0192
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x0180
        L_0x0192:
            return
        L_0x0193:
            java.lang.String r7 = ": "
            r9.append(r7)     // Catch:{ all -> 0x01d7 }
            com.unboundid.util.Base64.encode((byte[]) r3, (java.lang.StringBuilder) r9)     // Catch:{ all -> 0x01d7 }
            if (r10 <= r2) goto L_0x01d6
            int r7 = r9.length()
            int r7 = r7 - r0
            if (r7 <= r10) goto L_0x01d6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.unboundid.util.StaticUtils.EOL
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            int r8 = r0 + r10
            r9.insert(r8, r7)
            int r8 = r10 * 2
            int r0 = r0 + r8
            int r8 = r7.length()
            int r0 = r0 + r8
            int r0 = r0 + -1
        L_0x01c4:
            int r8 = r9.length()
            if (r0 >= r8) goto L_0x01d6
            r9.insert(r0, r7)
            int r8 = r10 + -1
            int r1 = r7.length()
            int r8 = r8 + r1
            int r0 = r0 + r8
            goto L_0x01c4
        L_0x01d6:
            return
        L_0x01d7:
            r7 = move-exception
            if (r10 <= r2) goto L_0x0213
            int r8 = r9.length()
            int r8 = r8 - r0
            if (r8 <= r10) goto L_0x0213
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = com.unboundid.util.StaticUtils.EOL
            r8.append(r2)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            int r1 = r0 + r10
            r9.insert(r1, r8)
            int r1 = r10 * 2
            int r0 = r0 + r1
            int r1 = r8.length()
            int r0 = r0 + r1
            int r0 = r0 + -1
        L_0x0201:
            int r1 = r9.length()
            if (r0 >= r1) goto L_0x0213
            r9.insert(r0, r8)
            int r1 = r10 + -1
            int r2 = r8.length()
            int r1 = r1 + r2
            int r0 = r0 + r1
            goto L_0x0201
        L_0x0213:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFWriter.encodeNameAndValue(java.lang.String, com.unboundid.asn1.ASN1OctetString, java.lang.StringBuilder, int):void");
    }

    static void rethrow(Throwable th) {
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw ((Error) th);
            } else {
                throw new IOException(StaticUtils.getExceptionMessage(th));
            }
        }
    }

    /* access modifiers changed from: private */
    public ByteStringBuffer toLDIFBytes(LDIFRecord lDIFRecord) {
        ByteStringBuffer byteStringBuffer = new ByteStringBuffer(200);
        lDIFRecord.toLDIF(byteStringBuffer, this.wrapColumn);
        return byteStringBuffer;
    }

    public static List<String> wrapLines(int i, List<String> list) {
        if (i <= 2) {
            return new ArrayList(list);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            int length = next.length();
            if (length > i) {
                arrayList.add(next.substring(0, i));
                int i2 = i;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if ((length - i2) + 1 <= i) {
                        next = ' ' + next.substring(i2);
                        break;
                    } else {
                        arrayList.add(' ' + next.substring(i2, (i2 + i) - 1));
                        i2 += i + -1;
                    }
                }
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public static List<String> wrapLines(int i, String... strArr) {
        return wrapLines(i, (List<String>) Arrays.asList(strArr));
    }

    private void writeLDIF(LDIFRecord lDIFRecord) {
        this.buffer.clear();
        lDIFRecord.toLDIF(this.buffer, this.wrapColumn);
        this.buffer.append(StaticUtils.EOL_BYTES);
        this.buffer.write(this.writer);
    }

    private void writeSingleLineComment(String str) {
        int i;
        boolean z;
        ByteStringBuffer byteStringBuffer;
        int i2 = this.wrapColumn <= 0 ? 77 : this.wrapColumnMinusTwo;
        this.buffer.clear();
        int length = str.length();
        if (length <= i2) {
            this.buffer.append((CharSequence) "# ");
            byteStringBuffer = this.buffer;
        } else {
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (length - i3 <= i2) {
                    break;
                } else {
                    int i4 = i3 + i2;
                    int i5 = i4;
                    while (true) {
                        if (i <= i3) {
                            z = false;
                            break;
                        } else if (str.charAt(i) == ' ') {
                            z = true;
                            break;
                        } else {
                            i5 = i - 1;
                        }
                    }
                    if (!z) {
                        i = i4 + 1;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (str.charAt(i) == ' ') {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            break;
                        }
                    }
                    this.buffer.append((CharSequence) "# ");
                    this.buffer.append((CharSequence) str.substring(i3, i));
                    this.buffer.append(StaticUtils.EOL_BYTES);
                    i3 = i + 1;
                    while (i3 < length && str.charAt(i3) == ' ') {
                        i3++;
                    }
                }
            }
            this.buffer.append((CharSequence) "# ");
            byteStringBuffer = this.buffer;
            str = str.substring(i3);
        }
        byteStringBuffer.append((CharSequence) str);
        this.buffer.append(StaticUtils.EOL_BYTES);
        this.buffer.write(this.writer);
    }

    public void close() {
        try {
            if (this.toLdifBytesInvoker != null) {
                this.toLdifBytesInvoker.shutdown();
            }
        } catch (InterruptedException e) {
            Debug.debugException(e);
        } catch (Throwable th) {
            this.writer.close();
            throw th;
        }
        this.writer.close();
    }

    public void flush() {
        this.writer.flush();
    }

    public int getWrapColumn() {
        return this.wrapColumn;
    }

    public void setWrapColumn(int i) {
        this.wrapColumn = i;
        this.wrapColumnMinusTwo = i - 2;
    }

    public void writeChangeRecord(LDIFChangeRecord lDIFChangeRecord) {
        Validator.ensureNotNull(lDIFChangeRecord);
        Debug.debugLDIFWrite(lDIFChangeRecord);
        writeLDIF(lDIFChangeRecord);
    }

    public void writeChangeRecord(LDIFChangeRecord lDIFChangeRecord, String str) {
        Validator.ensureNotNull(lDIFChangeRecord);
        Debug.debugLDIFWrite(lDIFChangeRecord);
        if (str != null) {
            writeComment(str, false, false);
        }
        writeLDIF(lDIFChangeRecord);
    }

    public void writeComment(String str, boolean z, boolean z2) {
        Validator.ensureNotNull(str);
        if (z) {
            this.writer.write(StaticUtils.EOL_BYTES);
        }
        if (str.indexOf(10) < 0) {
            writeSingleLineComment(str);
        } else {
            for (String writeSingleLineComment : str.split("\\r?\\n")) {
                writeSingleLineComment(writeSingleLineComment);
            }
        }
        if (z2) {
            this.writer.write(StaticUtils.EOL_BYTES);
        }
    }

    public void writeEntry(Entry entry) {
        Validator.ensureNotNull(entry);
        Debug.debugLDIFWrite(entry);
        writeLDIF(entry);
    }

    public void writeEntry(Entry entry, String str) {
        Validator.ensureNotNull(entry);
        if (str != null) {
            writeComment(str, false, false);
        }
        writeEntry(entry);
    }

    public void writeLDIFRecord(LDIFRecord lDIFRecord) {
        Validator.ensureNotNull(lDIFRecord);
        Debug.debugLDIFWrite(lDIFRecord);
        writeLDIF(lDIFRecord);
    }

    public void writeLDIFRecord(LDIFRecord lDIFRecord, String str) {
        Validator.ensureNotNull(lDIFRecord);
        Debug.debugLDIFWrite(lDIFRecord);
        if (str != null) {
            writeComment(str, false, false);
        }
        writeLDIF(lDIFRecord);
    }

    public void writeLDIFRecords(List<? extends LDIFRecord> list) {
        ParallelProcessor<LDIFRecord, ByteStringBuffer> parallelProcessor = this.toLdifBytesInvoker;
        if (parallelProcessor == null) {
            for (LDIFRecord writeLDIFRecord : list) {
                writeLDIFRecord(writeLDIFRecord);
            }
            return;
        }
        for (Result next : parallelProcessor.processAll(list)) {
            rethrow(next.getFailureCause());
            ((ByteStringBuffer) next.getOutput()).write(this.writer);
            this.writer.write(StaticUtils.EOL_BYTES);
        }
    }
}
