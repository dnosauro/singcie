package com.cyberneid.p105d.p114g.p118b;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p131h.C1933a;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cyberneid.d.g.b.q */
public final class C1782q extends C1778m {

    /* renamed from: c */
    public static final Class<?> f5775c = C1781p.class;

    /* renamed from: d */
    private static final byte[] f5776d = {40, -65, 78, 94, 78, 117, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 65, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 62, Byte.MIN_VALUE, 47, 12, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -2, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 83, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 122};

    /* renamed from: e */
    private static final String[] f5777e = {McElieceCCA2KeyGenParameterSpec.SHA256, McElieceCCA2KeyGenParameterSpec.SHA384, McElieceCCA2KeyGenParameterSpec.SHA512};

    /* renamed from: f */
    private C1781p f5778f;

    /* renamed from: a */
    private int m7174a(int i) {
        if (i < 2 && !this.f5778f.mo8044a().mo7979k()) {
            return 2;
        }
        if (i == 5) {
            return 6;
        }
        return (i == 2 || i == 3 || this.f5778f.mo8044a().mo7979k()) ? 3 : 4;
    }

    /* renamed from: a */
    private void m7175a(C1771f fVar, int i, boolean z) {
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(2, new SecretKeySpec(this.f5762b, "AES"));
            byte[] doFinal = instance.doFinal(fVar.mo8015o());
            if (!(doFinal[9] == 97 && doFinal[10] == 100 && doFinal[11] == 98)) {
                Log.w("PdfBox-Android", "Verification of permissions failed (constant)");
            }
            byte b = (doFinal[0] & 255) | (doFinal[1] & 65280) | (doFinal[2] & 16711680) | (doFinal[3] & -16777216);
            if (b != i) {
                Log.w("PdfBox-Android", "Verification of permissions failed (" + b + " != " + i + ")");
            }
            if ((z && doFinal[8] != 84) || (!z && doFinal[8] != 70)) {
                Log.w("PdfBox-Android", "Verification of permissions failed (EncryptMetadata)");
            }
        } catch (GeneralSecurityException e) {
            m7189d();
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    private void m7176a(String str, String str2, C1771f fVar, int i) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            this.f5762b = new byte[32];
            secureRandom.nextBytes(this.f5762b);
            byte[] b = m7185b(str2.getBytes(C1933a.f6112e));
            byte[] bArr = new byte[8];
            byte[] bArr2 = new byte[8];
            secureRandom.nextBytes(bArr);
            secureRandom.nextBytes(bArr2);
            byte[] d = m7190d(m7186b(m7182a(b, bArr), b, (byte[]) null), bArr, bArr2);
            instance.init(1, new SecretKeySpec(m7186b(m7182a(b, bArr2), b, (byte[]) null), "AES"), new IvParameterSpec(new byte[16]));
            byte[] doFinal = instance.doFinal(this.f5762b);
            byte[] b2 = m7185b(str.getBytes(C1933a.f6112e));
            byte[] bArr3 = new byte[8];
            byte[] bArr4 = new byte[8];
            secureRandom.nextBytes(bArr3);
            secureRandom.nextBytes(bArr4);
            byte[] d2 = m7190d(m7186b(m7190d(b2, bArr3, d), b2, d), bArr3, bArr4);
            instance.init(1, new SecretKeySpec(m7186b(m7190d(b2, bArr4, d), b2, d), "AES"), new IvParameterSpec(new byte[16]));
            byte[] doFinal2 = instance.doFinal(this.f5762b);
            fVar.mo7996b(d);
            fVar.mo8003d(doFinal);
            fVar.mo7990a(d2);
            fVar.mo8000c(doFinal2);
            C1770e eVar = new C1770e();
            eVar.mo7982a(C1613i.f5342i);
            eVar.mo7981a(this.f5761a);
            fVar.mo7988a(eVar);
            fVar.mo7994b(C1613i.f5246gJ);
            fVar.mo7999c(C1613i.f5246gJ);
            mo8040b(true);
            byte[] bArr5 = new byte[16];
            bArr5[0] = (byte) i;
            bArr5[1] = (byte) (i >>> 8);
            bArr5[2] = (byte) (i >>> 16);
            bArr5[3] = (byte) (i >>> 24);
            bArr5[4] = -1;
            bArr5[5] = -1;
            bArr5[6] = -1;
            bArr5[7] = -1;
            bArr5[8] = 84;
            bArr5[9] = LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE;
            bArr5[10] = LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY;
            bArr5[11] = 98;
            for (int i2 = 12; i2 <= 15; i2++) {
                bArr5[i2] = (byte) secureRandom.nextInt();
            }
        } catch (GeneralSecurityException e) {
            m7189d();
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    private void m7177a(String str, String str2, C1771f fVar, int i, C1783c cVar, int i2, int i3) {
        String str3 = str;
        String str4 = str2;
        C1771f fVar2 = fVar;
        C1604a h = cVar.mo8053a().mo7574h();
        if (h == null || h.mo7494b() < 2) {
            MessageDigest a = C1769d.m7088a();
            a.update(BigInteger.valueOf(System.currentTimeMillis()).toByteArray());
            a.update(str3.getBytes(C1933a.f6111d));
            a.update(str4.getBytes(C1933a.f6111d));
            a.update(cVar.mo8053a().toString().getBytes(C1933a.f6111d));
            C1622p pVar = new C1622p(a.digest(toString().getBytes(C1933a.f6111d)));
            h = new C1604a();
            h.mo7490a((C1605b) pVar);
            h.mo7490a((C1605b) pVar);
            cVar.mo8053a().mo7563a(h);
        }
        C1622p pVar2 = (C1622p) h.mo7485a(0);
        byte[] b = mo8052b(str3.getBytes(C1933a.f6111d), str4.getBytes(C1933a.f6111d), i2, i3);
        byte[] bArr = b;
        byte[] a2 = mo8049a(str4.getBytes(C1933a.f6111d), bArr, i, pVar2.mo7643c(), i2, i3, true);
        this.f5762b = mo8050a(str4.getBytes(C1933a.f6111d), bArr, (byte[]) null, (byte[]) null, (byte[]) null, i, pVar2.mo7643c(), i2, i3, true, false);
        fVar2.mo7990a(b);
        fVar2.mo7996b(a2);
    }

    /* renamed from: a */
    private byte[] m7178a(C1604a aVar) {
        return (aVar == null || aVar.mo7494b() < 1) ? new byte[0] : ((C1622p) aVar.mo7485a(0)).mo7643c();
    }

    /* renamed from: a */
    private byte[] m7179a(byte[] bArr) {
        byte[] bArr2 = new byte[f5776d.length];
        int min = Math.min(bArr.length, bArr2.length);
        System.arraycopy(bArr, 0, bArr2, 0, min);
        byte[] bArr3 = f5776d;
        System.arraycopy(bArr3, 0, bArr2, min, bArr3.length - min);
        return bArr2;
    }

    /* renamed from: a */
    private byte[] m7180a(byte[] bArr, int i, int i2) {
        MessageDigest a = C1769d.m7088a();
        byte[] digest = a.digest(m7179a(bArr));
        if (i == 3 || i == 4) {
            byte[] bArr2 = digest;
            for (int i3 = 0; i3 < 50; i3++) {
                a.update(bArr2, 0, i2);
                bArr2 = a.digest();
            }
            digest = bArr2;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(digest, 0, bArr3, 0, i2);
        return bArr3;
    }

    /* renamed from: a */
    private byte[] m7181a(byte[] bArr, boolean z, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i) {
        byte[] bArr6;
        if (z) {
            byte[] bArr7 = new byte[8];
            System.arraycopy(bArr2, 40, bArr7, 0, 8);
            bArr6 = i == 5 ? m7188c(bArr, bArr7, bArr3) : m7184a(bArr, bArr7, bArr3);
        } else {
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArr3, 40, bArr8, 0, 8);
            bArr6 = i == 5 ? m7188c(bArr, bArr8, (byte[]) null) : m7184a(bArr, bArr8, (byte[]) null);
            bArr4 = bArr5;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, new SecretKeySpec(bArr6, "AES"), new IvParameterSpec(new byte[16]));
            return instance.doFinal(bArr4);
        } catch (GeneralSecurityException e) {
            m7189d();
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    private static byte[] m7182a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private byte[] m7183a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, boolean z, int i2, int i3) {
        byte[] a = m7179a(bArr);
        MessageDigest a2 = C1769d.m7088a();
        a2.update(a);
        a2.update(bArr2);
        a2.update((byte) i);
        a2.update((byte) (i >>> 8));
        a2.update((byte) (i >>> 16));
        a2.update((byte) (i >>> 24));
        a2.update(bArr3);
        if (i3 == 4 && !z) {
            a2.update(new byte[]{-1, -1, -1, -1});
        }
        byte[] digest = a2.digest();
        if (i3 == 3 || i3 == 4) {
            for (int i4 = 0; i4 < 50; i4++) {
                a2.update(digest, 0, i2);
                digest = a2.digest();
            }
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(digest, 0, bArr4, 0, i2);
        return bArr4;
    }

    /* renamed from: a */
    private byte[] m7184a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null) {
            bArr3 = new byte[0];
        } else if (bArr3.length < 48) {
            throw new IOException("Bad U length");
        } else if (bArr3.length > 48) {
            byte[] bArr4 = new byte[48];
            System.arraycopy(bArr3, 0, bArr4, 0, 48);
            bArr3 = bArr4;
        }
        byte[] b = m7185b(bArr);
        return m7186b(m7190d(b, bArr2, bArr3), b, bArr3);
    }

    /* renamed from: b */
    private static byte[] m7185b(byte[] bArr) {
        if (bArr.length <= 127) {
            return bArr;
        }
        byte[] bArr2 = new byte[CertificateBody.profileType];
        System.arraycopy(bArr, 0, bArr2, 0, CertificateBody.profileType);
        return bArr2;
    }

    /* renamed from: b */
    private static byte[] m7186b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] bArr4 = null;
            byte[] digest = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA256).digest(bArr);
            int i = 0;
            while (true) {
                if (i >= 64) {
                    if ((bArr4[bArr4.length - 1] & 255) <= i - 32) {
                        break;
                    }
                }
                byte[] bArr5 = (bArr3 == null || bArr3.length < 48) ? new byte[((bArr2.length + digest.length) * 64)] : new byte[((bArr2.length + digest.length + 48) * 64)];
                int i2 = 0;
                for (int i3 = 0; i3 < 64; i3++) {
                    System.arraycopy(bArr2, 0, bArr5, i2, bArr2.length);
                    int length = i2 + bArr2.length;
                    System.arraycopy(digest, 0, bArr5, length, digest.length);
                    i2 = length + digest.length;
                    if (bArr3 != null && bArr3.length >= 48) {
                        System.arraycopy(bArr3, 0, bArr5, i2, 48);
                        i2 += 48;
                    }
                }
                byte[] bArr6 = new byte[16];
                byte[] bArr7 = new byte[16];
                System.arraycopy(digest, 0, bArr6, 0, 16);
                System.arraycopy(digest, 16, bArr7, 0, 16);
                Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
                instance.init(1, new SecretKeySpec(bArr6, "AES"), new IvParameterSpec(bArr7));
                byte[] doFinal = instance.doFinal(bArr5);
                byte[] bArr8 = new byte[16];
                System.arraycopy(doFinal, 0, bArr8, 0, 16);
                i++;
                byte[] bArr9 = doFinal;
                digest = MessageDigest.getInstance(f5777e[new BigInteger(1, bArr8).mod(new BigInteger("3")).intValue()]).digest(doFinal);
                bArr4 = bArr9;
            }
            if (digest.length <= 32) {
                return digest;
            }
            byte[] bArr10 = new byte[32];
            System.arraycopy(digest, 0, bArr10, 0, 32);
            return bArr10;
        } catch (GeneralSecurityException e) {
            m7189d();
            throw new IOException(e);
        }
    }

    /* renamed from: c */
    private int m7187c() {
        if (this.f5761a == 40) {
            return 1;
        }
        return this.f5761a == 256 ? 5 : 2;
    }

    /* renamed from: c */
    private static byte[] m7188c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            MessageDigest instance = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA256);
            instance.update(bArr);
            instance.update(bArr2);
            return bArr3 == null ? instance.digest() : instance.digest(bArr3);
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: d */
    private static void m7189d() {
        try {
            if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {
                Log.w("PdfBox-Android", "JCE unlimited strength jurisdiction policy files are not installed");
            }
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    /* renamed from: d */
    private static byte[] m7190d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[(bArr.length + bArr2.length + bArr3.length)];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8023a(com.cyberneid.p105d.p114g.p118b.C1771f r22, com.cyberneid.p105d.p108b.C1604a r23, com.cyberneid.p105d.p114g.p118b.C1767b r24) {
        /*
            r21 = this;
            r12 = r21
            r0 = r24
            boolean r1 = r0 instanceof com.cyberneid.p105d.p114g.p118b.C1780o
            if (r1 == 0) goto L_0x0141
            boolean r1 = r22.mo8012l()
            r12.mo8036a((boolean) r1)
            com.cyberneid.d.g.b.o r0 = (com.cyberneid.p105d.p114g.p118b.C1780o) r0
            java.lang.String r0 = r0.mo8043a()
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = ""
        L_0x0019:
            r9 = r0
            int r13 = r22.mo8011k()
            int r14 = r22.mo8006f()
            int r0 = r22.mo8001d()
            r15 = 1
            r11 = 5
            if (r0 != r15) goto L_0x002e
            r0 = r23
            r10 = 5
            goto L_0x0037
        L_0x002e:
            int r0 = r22.mo8004e()
            int r0 = r0 / 8
            r10 = r0
            r0 = r23
        L_0x0037:
            byte[] r16 = r12.m7178a((com.cyberneid.p105d.p108b.C1604a) r0)
            boolean r8 = r22.mo8012l()
            byte[] r17 = r22.mo8008h()
            byte[] r7 = r22.mo8007g()
            java.nio.charset.Charset r0 = com.cyberneid.p105d.p131h.C1933a.f6111d
            r1 = 0
            r6 = 6
            if (r14 == r6) goto L_0x0056
            if (r14 != r11) goto L_0x0050
            goto L_0x0056
        L_0x0050:
            r5 = r0
            r18 = r1
            r19 = r18
            goto L_0x0065
        L_0x0056:
            java.nio.charset.Charset r0 = com.cyberneid.p105d.p131h.C1933a.f6112e
            byte[] r1 = r22.mo8010j()
            byte[] r2 = r22.mo8009i()
            r5 = r0
            r19 = r1
            r18 = r2
        L_0x0065:
            byte[] r1 = r9.getBytes(r5)
            r0 = r21
            r2 = r17
            r3 = r7
            r4 = r13
            r15 = r5
            r5 = r16
            r11 = 6
            r6 = r14
            r20 = r7
            r7 = r10
            r23 = r8
            boolean r0 = r0.mo8047a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x00b1
            com.cyberneid.d.g.b.a r0 = com.cyberneid.p105d.p114g.p118b.C1766a.m7067a()
            r12.mo8035a((com.cyberneid.p105d.p114g.p118b.C1766a) r0)
            if (r14 == r11) goto L_0x0099
            r8 = 5
            if (r14 != r8) goto L_0x008e
            r7 = r20
            goto L_0x009c
        L_0x008e:
            byte[] r0 = r9.getBytes(r15)
            r7 = r20
            byte[] r0 = r12.mo8048a((byte[]) r0, (byte[]) r7, (int) r14, (int) r10)
            goto L_0x00a0
        L_0x0099:
            r7 = r20
            r8 = 5
        L_0x009c:
            byte[] r0 = r9.getBytes(r15)
        L_0x00a0:
            r1 = r0
            r15 = 1
            r0 = r21
            r2 = r7
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r13
            r7 = r16
            r16 = 5
            goto L_0x00e3
        L_0x00b1:
            r7 = r20
            byte[] r1 = r9.getBytes(r15)
            r0 = r21
            r2 = r17
            r3 = r7
            r4 = r13
            r5 = r16
            r6 = r14
            r11 = r7
            r7 = r10
            r8 = r23
            boolean r0 = r0.mo8051b(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x0139
            com.cyberneid.d.g.b.a r0 = new com.cyberneid.d.g.b.a
            r0.<init>((int) r13)
            r12.mo8035a((com.cyberneid.p105d.p114g.p118b.C1766a) r0)
            byte[] r1 = r9.getBytes(r15)
            r15 = 0
            r0 = r21
            r2 = r11
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r13
            r7 = r16
        L_0x00e3:
            r8 = r14
            r9 = r10
            r10 = r23
            r11 = r15
            byte[] r0 = r0.mo8050a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.f5762b = r0
            r0 = 6
            if (r14 == r0) goto L_0x00f8
            r0 = 5
            if (r14 != r0) goto L_0x00f5
            goto L_0x00f9
        L_0x00f5:
            r1 = r22
            goto L_0x0100
        L_0x00f8:
            r0 = 5
        L_0x00f9:
            r1 = r22
            r2 = r23
            r12.m7175a((com.cyberneid.p105d.p114g.p118b.C1771f) r1, (int) r13, (boolean) r2)
        L_0x0100:
            int r2 = r22.mo8001d()
            r3 = 4
            if (r2 == r3) goto L_0x010d
            int r2 = r22.mo8001d()
            if (r2 != r0) goto L_0x0138
        L_0x010d:
            com.cyberneid.d.g.b.e r0 = r22.mo8014n()
            if (r0 == 0) goto L_0x0138
            com.cyberneid.d.b.i r0 = r0.mo7983b()
            if (r0 == 0) goto L_0x0138
            java.lang.String r1 = "AESV2"
            java.lang.String r2 = r0.mo7596a()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x0134
            java.lang.String r1 = "AESV3"
            java.lang.String r0 = r0.mo7596a()
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r15 = 0
            goto L_0x0135
        L_0x0134:
            r15 = 1
        L_0x0135:
            r12.mo8040b(r15)
        L_0x0138:
            return
        L_0x0139:
            com.cyberneid.d.g.b.c r0 = new com.cyberneid.d.g.b.c
            java.lang.String r1 = "Cannot decrypt PDF, the password is incorrect"
            r0.<init>(r1)
            throw r0
        L_0x0141:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Decryption material is not compatible with the document"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p118b.C1782q.mo8023a(com.cyberneid.d.g.b.f, com.cyberneid.d.b.a, com.cyberneid.d.g.b.b):void");
    }

    /* renamed from: a */
    public void mo8024a(C1783c cVar) {
        C1771f d = cVar.mo8066d();
        if (d == null) {
            d = new C1771f();
        }
        int c = m7187c();
        int a = m7174a(c);
        d.mo7989a("Standard");
        d.mo7986a(c);
        if (!(c == 4 || c == 5)) {
            d.mo8016p();
        }
        d.mo7998c(a);
        d.mo7993b(this.f5761a);
        String b = this.f5778f.mo8045b();
        String c2 = this.f5778f.mo8046c();
        if (b == null) {
            b = "";
        }
        if (c2 == null) {
            c2 = "";
        }
        String str = c2;
        String str2 = b.isEmpty() ? str : b;
        int c3 = this.f5778f.mo8044a().mo7965c();
        d.mo8002d(c3);
        int i = this.f5761a / 8;
        if (a == 6) {
            m7176a(str2, str, d, c3);
        } else {
            m7177a(str2, str, d, c3, cVar, a, i);
        }
        cVar.mo8056a(d);
        cVar.mo8053a().mo7566b(d.mo7992b());
    }

    /* renamed from: a */
    public boolean mo8025a() {
        return this.f5778f != null;
    }

    /* renamed from: a */
    public boolean mo8047a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, int i2, int i3, boolean z) {
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        int i4 = i2;
        if (i4 == 6 || i4 == 5) {
            byte[] bArr7 = bArr;
            byte[] b = m7185b(bArr);
            byte[] bArr8 = new byte[32];
            byte[] bArr9 = new byte[8];
            System.arraycopy(bArr3, 0, bArr8, 0, 32);
            System.arraycopy(bArr3, 32, bArr9, 0, 8);
            return Arrays.equals(i4 == 5 ? m7188c(b, bArr9, bArr2) : m7184a(b, bArr9, bArr2), bArr8);
        }
        byte[] bArr10 = bArr;
        int i5 = i3;
        return mo8051b(mo8048a(bArr, bArr3, i4, i5), bArr2, bArr3, i, bArr4, i2, i5, z);
    }

    /* renamed from: a */
    public byte[] mo8048a(byte[] bArr, byte[] bArr2, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] a = m7180a(bArr, i, i2);
        if (i == 2) {
            mo8038a(a, bArr2, (OutputStream) byteArrayOutputStream);
        } else if (i == 3 || i == 4) {
            byte[] bArr3 = new byte[a.length];
            byte[] bArr4 = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            for (int i3 = 19; i3 >= 0; i3--) {
                System.arraycopy(a, 0, bArr3, 0, a.length);
                for (int i4 = 0; i4 < bArr3.length; i4++) {
                    bArr3[i4] = (byte) (bArr3[i4] ^ ((byte) i3));
                }
                byteArrayOutputStream.reset();
                mo8038a(bArr3, bArr4, (OutputStream) byteArrayOutputStream);
                bArr4 = byteArrayOutputStream.toByteArray();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public byte[] mo8049a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, int i3, boolean z) {
        int i4 = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] a = mo8050a(bArr, bArr2, (byte[]) null, (byte[]) null, (byte[]) null, i, bArr3, i2, i3, z, true);
        if (i4 == 2) {
            mo8038a(a, f5776d, (OutputStream) byteArrayOutputStream);
        } else if (i4 == 3 || i4 == 4) {
            MessageDigest a2 = C1769d.m7088a();
            a2.update(f5776d);
            a2.update(bArr3);
            byteArrayOutputStream.write(a2.digest());
            byte[] bArr4 = new byte[a.length];
            for (int i5 = 0; i5 < 20; i5++) {
                System.arraycopy(a, 0, bArr4, 0, bArr4.length);
                for (int i6 = 0; i6 < bArr4.length; i6++) {
                    bArr4[i6] = (byte) (bArr4[i6] ^ i5);
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
                mo8037a(bArr4, (InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream);
            }
            byte[] bArr5 = new byte[32];
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr5, 0, 16);
            System.arraycopy(f5776d, 0, bArr5, 16, 16);
            byteArrayOutputStream.reset();
            byteArrayOutputStream.write(bArr5);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public byte[] mo8050a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i, byte[] bArr6, int i2, int i3, boolean z, boolean z2) {
        int i4 = i2;
        return (i4 == 6 || i4 == 5) ? m7181a(bArr, z2, bArr2, bArr3, bArr4, bArr5, i2) : m7183a(bArr, bArr2, i, bArr6, z, i3, i2);
    }

    /* renamed from: b */
    public boolean mo8051b(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, int i2, int i3, boolean z) {
        byte[] copyOf;
        byte[] bArr5;
        byte[] bArr6 = bArr2;
        int i4 = i2;
        if (i4 == 2) {
            copyOf = mo8049a(bArr, bArr3, i, bArr4, i2, i3, z);
        } else if (i4 == 3 || i4 == 4) {
            byte[] a = mo8049a(bArr, bArr3, i, bArr4, i2, i3, z);
            byte[] copyOf2 = Arrays.copyOf(bArr2, 16);
            copyOf = Arrays.copyOf(a, 16);
        } else if (i4 == 6 || i4 == 5) {
            byte[] b = m7185b(bArr);
            byte[] bArr7 = new byte[32];
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArr2, 0, bArr7, 0, 32);
            System.arraycopy(bArr2, 32, bArr8, 0, 8);
            if (i4 == 5) {
                bArr5 = m7188c(b, bArr8, (byte[]) null);
            } else {
                bArr5 = m7184a(b, bArr8, (byte[]) null);
            }
            return Arrays.equals(bArr5, bArr7);
        } else {
            throw new IOException("Unknown Encryption Revision " + i4);
        }
        return Arrays.equals(bArr2, copyOf);
    }

    /* renamed from: b */
    public byte[] mo8052b(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (i != 2 || i2 == 5) {
            byte[] a = m7180a(bArr, i, i2);
            byte[] a2 = m7179a(bArr2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mo8037a(a, (InputStream) new ByteArrayInputStream(a2), (OutputStream) byteArrayOutputStream);
            if (i == 3 || i == 4) {
                byte[] bArr3 = new byte[a.length];
                for (int i3 = 1; i3 < 20; i3++) {
                    System.arraycopy(a, 0, bArr3, 0, a.length);
                    for (int i4 = 0; i4 < bArr3.length; i4++) {
                        bArr3[i4] = (byte) (bArr3[i4] ^ ((byte) i3));
                    }
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                    mo8037a(bArr3, (InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("Expected length=5 actual=" + i2);
    }
}
