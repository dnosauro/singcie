package com.google.android.gms.internal.ads;

import com.unboundid.ldap.sdk.Filter;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class zzb {
    private static int zza(int i) {
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                switch (i) {
                    case 513:
                        return 1;
                    case 514:
                        return 2;
                    default:
                        String valueOf = String.valueOf(Long.toHexString((long) i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
                }
        }
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zza(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(93);
            sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    private static ByteBuffer zza(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    return slice;
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    throw th;
                }
            } else {
                StringBuilder sb = new StringBuilder(41);
                sb.append("end > capacity: ");
                sb.append(i2);
                sb.append(" > ");
                sb.append(capacity);
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("end < start: ");
            sb2.append(i2);
            sb2.append(" < 8");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static void zza(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        r4 = android.util.Pair.create(r4, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.X509Certificate[] zza(java.nio.ByteBuffer r20, java.util.Map<java.lang.Integer, byte[]> r21, java.security.cert.CertificateFactory r22) {
        /*
            java.nio.ByteBuffer r0 = zza((java.nio.ByteBuffer) r20)
            java.nio.ByteBuffer r1 = zza((java.nio.ByteBuffer) r20)
            byte[] r2 = zzb((java.nio.ByteBuffer) r20)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -1
            r5 = 0
            r6 = 0
            r9 = r5
            r7 = -1
            r8 = 0
        L_0x0017:
            boolean r10 = r1.hasRemaining()
            r11 = 8
            r12 = 769(0x301, float:1.078E-42)
            r13 = 1
            if (r10 == 0) goto L_0x00d5
            int r8 = r8 + 1
            java.nio.ByteBuffer r10 = zza((java.nio.ByteBuffer) r1)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            int r14 = r10.remaining()     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            if (r14 < r11) goto L_0x00b1
            int r11 = r10.getInt()     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r3.add(r14)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            if (r11 == r12) goto L_0x0043
            switch(r11) {
                case 257: goto L_0x0043;
                case 258: goto L_0x0043;
                case 259: goto L_0x0043;
                case 260: goto L_0x0043;
                default: goto L_0x003e;
            }     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x003e:
            switch(r11) {
                case 513: goto L_0x0043;
                case 514: goto L_0x0043;
                default: goto L_0x0041;
            }     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x0041:
            r12 = 0
            goto L_0x0044
        L_0x0043:
            r12 = 1
        L_0x0044:
            if (r12 != 0) goto L_0x0047
            goto L_0x0017
        L_0x0047:
            if (r7 == r4) goto L_0x00a9
            int r12 = zza((int) r11)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            int r14 = zza((int) r7)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r15 = 37
            switch(r12) {
                case 1: goto L_0x0073;
                case 2: goto L_0x0059;
                default: goto L_0x0056;
            }     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x0056:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            goto L_0x0094
        L_0x0059:
            switch(r14) {
                case 1: goto L_0x007c;
                case 2: goto L_0x007b;
                default: goto L_0x005c;
            }     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.<init>(r15)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r2 = "Unknown digestAlgorithm2: "
            r1.append(r2)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.append(r14)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            throw r0     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x0073:
            switch(r14) {
                case 1: goto L_0x007b;
                case 2: goto L_0x0079;
                default: goto L_0x0076;
            }     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x0076:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            goto L_0x007f
        L_0x0079:
            r13 = -1
            goto L_0x007c
        L_0x007b:
            r13 = 0
        L_0x007c:
            if (r13 <= 0) goto L_0x0017
            goto L_0x00a9
        L_0x007f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.<init>(r15)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r2 = "Unknown digestAlgorithm2: "
            r1.append(r2)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.append(r14)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            throw r0     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x0094:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.<init>(r15)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r2 = "Unknown digestAlgorithm1: "
            r1.append(r2)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r1.append(r12)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            throw r0     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x00a9:
            byte[] r7 = zzb((java.nio.ByteBuffer) r10)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            r9 = r7
            r7 = r11
            goto L_0x0017
        L_0x00b1:
            java.lang.SecurityException r0 = new java.lang.SecurityException     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            java.lang.String r1 = "Signature record too short"
            r0.<init>(r1)     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
            throw r0     // Catch:{ IOException -> 0x00bb, BufferUnderflowException -> 0x00b9 }
        L_0x00b9:
            r0 = move-exception
            goto L_0x00bc
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            java.lang.SecurityException r1 = new java.lang.SecurityException
            r2 = 45
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to parse signature record #"
            r3.append(r2)
            r3.append(r8)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00d5:
            if (r7 != r4) goto L_0x00e9
            if (r8 != 0) goto L_0x00e1
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No signatures found"
            r0.<init>(r1)
            throw r0
        L_0x00e1:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No supported signatures found"
            r0.<init>(r1)
            throw r0
        L_0x00e9:
            if (r7 == r12) goto L_0x0119
            switch(r7) {
                case 257: goto L_0x0116;
                case 258: goto L_0x0116;
                case 259: goto L_0x0116;
                case 260: goto L_0x0116;
                default: goto L_0x00ee;
            }
        L_0x00ee:
            switch(r7) {
                case 513: goto L_0x0113;
                case 514: goto L_0x0113;
                default: goto L_0x00f1;
            }
        L_0x00f1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown signature algorithm: 0x"
            long r2 = (long) r7
            java.lang.String r2 = java.lang.Long.toHexString(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0109
            java.lang.String r1 = r1.concat(r2)
            goto L_0x010f
        L_0x0109:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x010f:
            r0.<init>(r1)
            throw r0
        L_0x0113:
            java.lang.String r1 = "EC"
            goto L_0x011b
        L_0x0116:
            java.lang.String r1 = "RSA"
            goto L_0x011b
        L_0x0119:
            java.lang.String r1 = "DSA"
        L_0x011b:
            if (r7 == r12) goto L_0x017f
            switch(r7) {
                case 257: goto L_0x0168;
                case 258: goto L_0x0155;
                case 259: goto L_0x014e;
                case 260: goto L_0x014b;
                default: goto L_0x0120;
            }
        L_0x0120:
            switch(r7) {
                case 513: goto L_0x0148;
                case 514: goto L_0x0145;
                default: goto L_0x0123;
            }
        L_0x0123:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown signature algorithm: 0x"
            long r2 = (long) r7
            java.lang.String r2 = java.lang.Long.toHexString(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x013b
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0141
        L_0x013b:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0141:
            r0.<init>(r1)
            throw r0
        L_0x0145:
            java.lang.String r4 = "SHA512withECDSA"
            goto L_0x0150
        L_0x0148:
            java.lang.String r4 = "SHA256withECDSA"
            goto L_0x0150
        L_0x014b:
            java.lang.String r4 = "SHA512withRSA"
            goto L_0x0150
        L_0x014e:
            java.lang.String r4 = "SHA256withRSA"
        L_0x0150:
            android.util.Pair r4 = android.util.Pair.create(r4, r5)
            goto L_0x0182
        L_0x0155:
            java.lang.String r4 = "SHA512withRSA/PSS"
            java.security.spec.PSSParameterSpec r8 = new java.security.spec.PSSParameterSpec
            java.lang.String r15 = "SHA-512"
            java.lang.String r16 = "MGF1"
            java.security.spec.MGF1ParameterSpec r17 = java.security.spec.MGF1ParameterSpec.SHA512
            r18 = 64
            r19 = 1
            r14 = r8
            r14.<init>(r15, r16, r17, r18, r19)
            goto L_0x017a
        L_0x0168:
            java.lang.String r4 = "SHA256withRSA/PSS"
            java.security.spec.PSSParameterSpec r8 = new java.security.spec.PSSParameterSpec
            java.lang.String r15 = "SHA-256"
            java.lang.String r16 = "MGF1"
            java.security.spec.MGF1ParameterSpec r17 = java.security.spec.MGF1ParameterSpec.SHA256
            r18 = 32
            r19 = 1
            r14 = r8
            r14.<init>(r15, r16, r17, r18, r19)
        L_0x017a:
            android.util.Pair r4 = android.util.Pair.create(r4, r8)
            goto L_0x0182
        L_0x017f:
            java.lang.String r4 = "SHA256withDSA"
            goto L_0x0150
        L_0x0182:
            java.lang.Object r8 = r4.first
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r4 = r4.second
            java.security.spec.AlgorithmParameterSpec r4 = (java.security.spec.AlgorithmParameterSpec) r4
            java.security.KeyFactory r1 = java.security.KeyFactory.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            java.security.spec.X509EncodedKeySpec r10 = new java.security.spec.X509EncodedKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            r10.<init>(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            java.security.PublicKey r1 = r1.generatePublic(r10)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            java.security.Signature r10 = java.security.Signature.getInstance(r8)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            r10.initVerify(r1)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            if (r4 == 0) goto L_0x01a3
            r10.setParameter(r4)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
        L_0x01a3:
            r10.update(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            boolean r1 = r10.verify(r9)     // Catch:{ NoSuchAlgorithmException -> 0x02d0, InvalidKeySpecException -> 0x02ce, InvalidKeyException -> 0x02cc, InvalidAlgorithmParameterException -> 0x02ca, SignatureException -> 0x02c8 }
            if (r1 == 0) goto L_0x02b8
            r0.clear()
            java.nio.ByteBuffer r1 = zza((java.nio.ByteBuffer) r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r8 = r5
            r5 = 0
        L_0x01ba:
            boolean r9 = r1.hasRemaining()
            if (r9 == 0) goto L_0x0201
            int r5 = r5 + r13
            java.nio.ByteBuffer r9 = zza((java.nio.ByteBuffer) r1)     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            int r10 = r9.remaining()     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            if (r10 < r11) goto L_0x01dd
            int r10 = r9.getInt()     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            r4.add(r12)     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            if (r10 != r7) goto L_0x01ba
            byte[] r8 = zzb((java.nio.ByteBuffer) r9)     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            goto L_0x01ba
        L_0x01dd:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            java.lang.String r1 = "Record too short"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
            throw r0     // Catch:{ IOException -> 0x01e7, BufferUnderflowException -> 0x01e5 }
        L_0x01e5:
            r0 = move-exception
            goto L_0x01e8
        L_0x01e7:
            r0 = move-exception
        L_0x01e8:
            java.io.IOException r1 = new java.io.IOException
            r2 = 42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to parse digest record #"
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0201:
            boolean r1 = r3.equals(r4)
            if (r1 == 0) goto L_0x02b0
            int r1 = zza((int) r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4 = r21
            java.lang.Object r3 = r4.put(r3, r8)
            byte[] r3 = (byte[]) r3
            if (r3 == 0) goto L_0x0234
            boolean r3 = java.security.MessageDigest.isEqual(r3, r8)
            if (r3 == 0) goto L_0x0220
            goto L_0x0234
        L_0x0220:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = zzb((int) r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " contents digest does not match the digest specified by a preceding signer"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x0234:
            java.nio.ByteBuffer r0 = zza((java.nio.ByteBuffer) r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 0
        L_0x023e:
            boolean r4 = r0.hasRemaining()
            if (r4 == 0) goto L_0x0279
            int r3 = r3 + r13
            byte[] r4 = zzb((java.nio.ByteBuffer) r0)
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x025f }
            r5.<init>(r4)     // Catch:{ CertificateException -> 0x025f }
            r7 = r22
            java.security.cert.Certificate r5 = r7.generateCertificate(r5)     // Catch:{ CertificateException -> 0x025f }
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch:{ CertificateException -> 0x025f }
            com.google.android.gms.internal.ads.zzg r8 = new com.google.android.gms.internal.ads.zzg
            r8.<init>(r5, r4)
            r1.add(r8)
            goto L_0x023e
        L_0x025f:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            r2 = 41
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = "Failed to decode certificate #"
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0279:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x02a8
            java.lang.Object r0 = r1.get(r6)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.security.PublicKey r0 = r0.getPublicKey()
            byte[] r0 = r0.getEncoded()
            boolean r0 = java.util.Arrays.equals(r2, r0)
            if (r0 == 0) goto L_0x02a0
            int r0 = r1.size()
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.security.cert.X509Certificate[] r0 = (java.security.cert.X509Certificate[]) r0
            return r0
        L_0x02a0:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Public key mismatch between certificate and signature record"
            r0.<init>(r1)
            throw r0
        L_0x02a8:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No certificates listed"
            r0.<init>(r1)
            throw r0
        L_0x02b0:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Signature algorithms don't match between digests and signatures records"
            r0.<init>(r1)
            throw r0
        L_0x02b8:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = java.lang.String.valueOf(r8)
            java.lang.String r2 = " signature did not verify"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x02c8:
            r0 = move-exception
            goto L_0x02d1
        L_0x02ca:
            r0 = move-exception
            goto L_0x02d1
        L_0x02cc:
            r0 = move-exception
            goto L_0x02d1
        L_0x02ce:
            r0 = move-exception
            goto L_0x02d1
        L_0x02d0:
            r0 = move-exception
        L_0x02d1:
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.String r2 = java.lang.String.valueOf(r8)
            int r2 = r2.length()
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to verify "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r2 = " signature"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] zza(int[] iArr, zzc[] zzcArr) {
        long j;
        int[] iArr2 = iArr;
        zzc[] zzcArr2 = zzcArr;
        int length = zzcArr2.length;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (true) {
            j = 1048576;
            if (i >= length) {
                break;
            }
            j3 += ((zzcArr2[i].size() + 1048576) - 1) / 1048576;
            i++;
        }
        if (j3 < 2097151) {
            int i2 = (int) j3;
            byte[][] bArr = new byte[iArr2.length][];
            for (int i3 = 0; i3 < iArr2.length; i3++) {
                byte[] bArr2 = new byte[((zzc(iArr2[i3]) * i2) + 5)];
                bArr2[0] = 90;
                zza(i2, bArr2, 1);
                bArr[i3] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = Filter.FILTER_TYPE_GREATER_OR_EQUAL;
            MessageDigest[] messageDigestArr = new MessageDigest[iArr2.length];
            int i4 = 0;
            while (i4 < iArr2.length) {
                String zzb = zzb(iArr2[i4]);
                try {
                    messageDigestArr[i4] = MessageDigest.getInstance(zzb);
                    i4++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(String.valueOf(zzb).concat(" digest not supported"), e);
                }
            }
            int length2 = zzcArr2.length;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length2) {
                zzc zzc = zzcArr2[i5];
                long j4 = j2;
                long size = zzc.size();
                while (size > j2) {
                    int min = (int) Math.min(size, j);
                    zza(min, bArr3, 1);
                    for (MessageDigest update : messageDigestArr) {
                        update.update(bArr3);
                    }
                    long j5 = j4;
                    try {
                        zzc.zza(messageDigestArr, j5, min);
                        int i8 = 0;
                        while (i8 < iArr2.length) {
                            int i9 = iArr2[i8];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i8];
                            int zzc2 = zzc(i9);
                            zzc zzc3 = zzc;
                            MessageDigest messageDigest = messageDigestArr[i8];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i6 * zzc2) + 5, zzc2);
                            if (digest == zzc2) {
                                i8++;
                                bArr3 = bArr4;
                                zzc = zzc3;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        zzc zzc4 = zzc;
                        MessageDigest[] messageDigestArr3 = messageDigestArr;
                        long j6 = (long) min;
                        long j7 = j5 + j6;
                        size -= j6;
                        i6++;
                        bArr3 = bArr3;
                        zzc[] zzcArr3 = zzcArr;
                        j = 1048576;
                        j4 = j7;
                        j2 = 0;
                    } catch (IOException e2) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i6);
                        sb2.append(" of section #");
                        sb2.append(i7);
                        throw new DigestException(sb2.toString(), e2);
                    }
                }
                byte[] bArr6 = bArr3;
                MessageDigest[] messageDigestArr4 = messageDigestArr;
                i7++;
                i5++;
                zzcArr2 = zzcArr;
                j2 = 0;
                j = 1048576;
            }
            byte[][] bArr7 = new byte[iArr2.length][];
            int i10 = 0;
            while (i10 < iArr2.length) {
                int i11 = iArr2[i10];
                byte[] bArr8 = bArr[i10];
                String zzb2 = zzb(i11);
                try {
                    bArr7[i10] = MessageDigest.getInstance(zzb2).digest(bArr8);
                    i10++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(String.valueOf(zzb2).concat(" digest not supported"), e3);
                }
            }
            return bArr7;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j3);
        throw new DigestException(sb3.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039 A[Catch:{ all -> 0x0293 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0269 A[Catch:{ all -> 0x0293 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r18) {
        /*
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r0 = "r"
            r2 = r18
            r1.<init>(r2, r0)
            android.util.Pair r0 = com.google.android.gms.internal.ads.zzi.zza(r1)     // Catch:{ all -> 0x0293 }
            if (r0 == 0) goto L_0x0271
            java.lang.Object r2 = r0.first     // Catch:{ all -> 0x0293 }
            r11 = r2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11     // Catch:{ all -> 0x0293 }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x0293 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0293 }
            long r9 = r0.longValue()     // Catch:{ all -> 0x0293 }
            r2 = 20
            long r2 = r9 - r2
            r0 = 1
            r4 = 0
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0036
            r1.seek(r2)     // Catch:{ all -> 0x0293 }
            int r2 = r1.readInt()     // Catch:{ all -> 0x0293 }
            r3 = 1347094023(0x504b0607, float:1.36246794E10)
            if (r2 != r3) goto L_0x0036
            r2 = 1
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 != 0) goto L_0x0269
            long r7 = com.google.android.gms.internal.ads.zzi.zzc(r11)     // Catch:{ all -> 0x0293 }
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0248
            long r2 = com.google.android.gms.internal.ads.zzi.zzd(r11)     // Catch:{ all -> 0x0293 }
            long r2 = r2 + r7
            int r12 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x0240
            r2 = 32
            int r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x0227
            r2 = 24
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ all -> 0x0293 }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0293 }
            r3.order(r12)     // Catch:{ all -> 0x0293 }
            int r12 = r3.capacity()     // Catch:{ all -> 0x0293 }
            long r12 = (long) r12     // Catch:{ all -> 0x0293 }
            long r12 = r7 - r12
            r1.seek(r12)     // Catch:{ all -> 0x0293 }
            byte[] r12 = r3.array()     // Catch:{ all -> 0x0293 }
            int r13 = r3.arrayOffset()     // Catch:{ all -> 0x0293 }
            int r14 = r3.capacity()     // Catch:{ all -> 0x0293 }
            r1.readFully(r12, r13, r14)     // Catch:{ all -> 0x0293 }
            r12 = 8
            long r13 = r3.getLong(r12)     // Catch:{ all -> 0x0293 }
            r15 = 2334950737559900225(0x20676953204b5041, double:1.3968830566012645E-152)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x021f
            r13 = 16
            long r13 = r3.getLong(r13)     // Catch:{ all -> 0x0293 }
            r15 = 3617552046287187010(0x3234206b636f6c42, double:7.465385175170059E-67)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x021f
            long r13 = r3.getLong(r6)     // Catch:{ all -> 0x0293 }
            int r3 = r3.capacity()     // Catch:{ all -> 0x0293 }
            long r2 = (long) r3     // Catch:{ all -> 0x0293 }
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 < 0) goto L_0x0205
            r2 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 > 0) goto L_0x0205
            r2 = 8
            long r2 = r2 + r13
            int r3 = (int) r2     // Catch:{ all -> 0x0293 }
            r15 = r13
            long r12 = (long) r3     // Catch:{ all -> 0x0293 }
            long r12 = r7 - r12
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x01ec
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ all -> 0x0293 }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0293 }
            r3.order(r4)     // Catch:{ all -> 0x0293 }
            r1.seek(r12)     // Catch:{ all -> 0x0293 }
            byte[] r4 = r3.array()     // Catch:{ all -> 0x0293 }
            int r5 = r3.arrayOffset()     // Catch:{ all -> 0x0293 }
            int r14 = r3.capacity()     // Catch:{ all -> 0x0293 }
            r1.readFully(r4, r5, r14)     // Catch:{ all -> 0x0293 }
            long r4 = r3.getLong(r6)     // Catch:{ all -> 0x0293 }
            int r14 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r14 != 0) goto L_0x01ca
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0293 }
            android.util.Pair r3 = android.util.Pair.create(r3, r4)     // Catch:{ all -> 0x0293 }
            java.lang.Object r4 = r3.first     // Catch:{ all -> 0x0293 }
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch:{ all -> 0x0293 }
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x0293 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0293 }
            long r12 = r3.longValue()     // Catch:{ all -> 0x0293 }
            java.nio.ByteOrder r3 = r4.order()     // Catch:{ all -> 0x0293 }
            java.nio.ByteOrder r5 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0293 }
            if (r3 != r5) goto L_0x01c2
            int r3 = r4.capacity()     // Catch:{ all -> 0x0293 }
            r5 = 24
            int r3 = r3 - r5
            r2 = 8
            java.nio.ByteBuffer r3 = zza((java.nio.ByteBuffer) r4, (int) r2, (int) r3)     // Catch:{ all -> 0x0293 }
        L_0x00fe:
            boolean r4 = r3.hasRemaining()     // Catch:{ all -> 0x0293 }
            if (r4 == 0) goto L_0x01ba
            int r6 = r6 + r0
            int r4 = r3.remaining()     // Catch:{ all -> 0x0293 }
            if (r4 < r2) goto L_0x01a1
            long r4 = r3.getLong()     // Catch:{ all -> 0x0293 }
            r14 = 4
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0180
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 > 0) goto L_0x0180
            int r5 = (int) r4     // Catch:{ all -> 0x0293 }
            int r4 = r3.position()     // Catch:{ all -> 0x0293 }
            int r4 = r4 + r5
            int r14 = r3.remaining()     // Catch:{ all -> 0x0293 }
            if (r5 > r14) goto L_0x0153
            int r14 = r3.getInt()     // Catch:{ all -> 0x0293 }
            r15 = 1896449818(0x7109871a, float:6.810044E29)
            if (r14 != r15) goto L_0x014f
            int r5 = r5 + -4
            java.nio.ByteBuffer r4 = zza((java.nio.ByteBuffer) r3, (int) r5)     // Catch:{ all -> 0x0293 }
            com.google.android.gms.internal.ads.zze r0 = new com.google.android.gms.internal.ads.zze     // Catch:{ all -> 0x0293 }
            r2 = 0
            r3 = r0
            r5 = r12
            r12 = r2
            r3.<init>(r4, r5, r7, r9, r11)     // Catch:{ all -> 0x0293 }
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch:{ all -> 0x0293 }
            java.security.cert.X509Certificate[][] r0 = zza((java.nio.channels.FileChannel) r2, (com.google.android.gms.internal.ads.zze) r0)     // Catch:{ all -> 0x0293 }
            r1.close()     // Catch:{ all -> 0x0293 }
            r1.close()     // Catch:{ IOException -> 0x014e }
        L_0x014e:
            return r0
        L_0x014f:
            r3.position(r4)     // Catch:{ all -> 0x0293 }
            goto L_0x00fe
        L_0x0153:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            int r2 = r3.remaining()     // Catch:{ all -> 0x0293 }
            r3 = 91
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r4.<init>(r3)     // Catch:{ all -> 0x0293 }
            java.lang.String r3 = "APK Signing Block entry #"
            r4.append(r3)     // Catch:{ all -> 0x0293 }
            r4.append(r6)     // Catch:{ all -> 0x0293 }
            java.lang.String r3 = " size out of range: "
            r4.append(r3)     // Catch:{ all -> 0x0293 }
            r4.append(r5)     // Catch:{ all -> 0x0293 }
            java.lang.String r3 = ", available: "
            r4.append(r3)     // Catch:{ all -> 0x0293 }
            r4.append(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0180:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 76
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "APK Signing Block entry #"
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r6)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = " size out of range: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r4)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x01a1:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 70
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "Insufficient data to read size of APK Signing Block entry #"
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r6)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x01ba:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "No APK Signature Scheme v2 block in APK Signing Block"
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x01c2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "ByteBuffer byte order must be little endian"
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x01ca:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "APK Signing Block sizes in header and footer do not match: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r4)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = " vs "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r4 = r15
            r3.append(r4)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x01ec:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "APK Signing Block offset out of range: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r12)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0205:
            r4 = r13
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "APK Signing Block size out of range: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r4)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x021f:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "No APK Signing Block before ZIP Central Directory"
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0227:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 87
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "APK too small for APK Signing Block. ZIP Central Directory offset: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r7)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0240:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "ZIP Central Directory is not immediately followed by End of Central Directory"
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0248:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            r2 = 122(0x7a, float:1.71E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r3.<init>(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "ZIP Central Directory offset out of range: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r7)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = ". ZIP End of Central Directory offset: "
            r3.append(r2)     // Catch:{ all -> 0x0293 }
            r3.append(r9)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0269:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = "ZIP64 APK not supported"
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0271:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x0293 }
            long r2 = r1.length()     // Catch:{ all -> 0x0293 }
            r4 = 102(0x66, float:1.43E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0293 }
            r5.<init>(r4)     // Catch:{ all -> 0x0293 }
            java.lang.String r4 = "Not an APK file: ZIP End of Central Directory record not found in file with "
            r5.append(r4)     // Catch:{ all -> 0x0293 }
            r5.append(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = " bytes"
            r5.append(r2)     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0293 }
            r0.<init>(r2)     // Catch:{ all -> 0x0293 }
            throw r0     // Catch:{ all -> 0x0293 }
        L_0x0293:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0297 }
        L_0x0297:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static X509Certificate[][] zza(FileChannel fileChannel, zze zze) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zza = zza(zze.zzb);
                int i = 0;
                int i2 = 0;
                while (zza.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(zza(zza(zza), (Map<Integer, byte[]>) hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i2);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    long zzb = zze.zzc;
                    long zzc = zze.zzd;
                    long zzd = zze.zze;
                    ByteBuffer zze2 = zze.zzf;
                    if (!hashMap.isEmpty()) {
                        FileChannel fileChannel2 = fileChannel;
                        zzf zzf = new zzf(fileChannel2, 0, zzb);
                        zzf zzf2 = new zzf(fileChannel2, zzc, zzd - zzc);
                        ByteBuffer duplicate = zze2.duplicate();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        zzi.zza(duplicate, zzb);
                        zzd zzd2 = new zzd(duplicate);
                        int[] iArr = new int[hashMap.size()];
                        int i3 = 0;
                        for (Integer intValue : hashMap.keySet()) {
                            iArr[i3] = intValue.intValue();
                            i3++;
                        }
                        try {
                            byte[][] zza2 = zza(iArr, new zzc[]{zzf, zzf2, zzd2});
                            while (i < iArr.length) {
                                int i4 = iArr[i];
                                if (MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i4)), zza2[i])) {
                                    i++;
                                } else {
                                    throw new SecurityException(String.valueOf(zzb(i4)).concat(" digest of contents did not verify"));
                                }
                            }
                            return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                        } catch (DigestException e2) {
                            throw new SecurityException("Failed to compute digest(s) of contents", e2);
                        }
                    } else {
                        throw new SecurityException("No digests provided");
                    }
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    private static String zzb(int i) {
        switch (i) {
            case 1:
                return McElieceCCA2KeyGenParameterSpec.SHA256;
            case 2:
                return McElieceCCA2KeyGenParameterSpec.SHA512;
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    private static byte[] zzb(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
    }

    private static int zzc(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }
}
