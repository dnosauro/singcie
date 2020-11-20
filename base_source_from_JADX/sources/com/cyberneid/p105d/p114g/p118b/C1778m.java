package com.cyberneid.p105d.p114g.p118b;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p114g.C1783c;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cyberneid.d.g.b.m */
public abstract class C1778m {

    /* renamed from: c */
    private static final byte[] f5760c = {LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 65, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 84};

    /* renamed from: a */
    protected int f5761a = 40;

    /* renamed from: b */
    protected byte[] f5762b;

    /* renamed from: d */
    private final C1777l f5763d = new C1777l();

    /* renamed from: e */
    private boolean f5764e;

    /* renamed from: f */
    private final Set<C1605b> f5765f = new HashSet();

    /* renamed from: g */
    private boolean f5766g;

    /* renamed from: h */
    private C1766a f5767h = null;

    /* renamed from: a */
    private void m7147a(long j, long j2, InputStream inputStream, OutputStream outputStream, boolean z) {
        if (this.f5766g && this.f5762b.length == 32) {
            m7151a(inputStream, outputStream, z);
        } else if (!this.f5766g || z) {
            byte[] a = m7153a(j, j2);
            if (this.f5766g) {
                m7152a(a, inputStream, outputStream, z);
            } else {
                mo8037a(a, inputStream, outputStream);
            }
        } else {
            throw new IllegalArgumentException("AES encryption with key length other than 256 bits is not yet implemented.");
        }
        outputStream.flush();
    }

    /* renamed from: a */
    private void m7148a(C1604a aVar, long j, long j2) {
        for (int i = 0; i < aVar.mo7494b(); i++) {
            mo8031a(aVar.mo7495b(i), j, j2);
        }
    }

    /* renamed from: a */
    private void m7149a(C1607d dVar, long j, long j2) {
        if (dVar.mo7554k(C1613i.f4960ap) == null && !C1613i.f5286gx.equals(dVar.mo7554k(C1613i.f5338hw)) && !C1613i.f5286gx.equals(dVar.mo7554k(C1613i.f5044cT))) {
            for (Map.Entry<C1613i, C1605b> value : dVar.mo7546f()) {
                C1605b bVar = (C1605b) value.getValue();
                if ((bVar instanceof C1622p) || (bVar instanceof C1604a) || (bVar instanceof C1607d)) {
                    mo8031a(bVar, j, j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7150a(C1622p pVar, long j, long j2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pVar.mo7643c());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7147a(j, j2, byteArrayInputStream, byteArrayOutputStream, true);
        pVar.mo7639a(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    private void m7151a(InputStream inputStream, OutputStream outputStream, boolean z) {
        byte[] bArr = new byte[16];
        if (z) {
            inputStream.read(bArr);
        } else {
            new SecureRandom().nextBytes(bArr);
            outputStream.write(bArr);
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(z ? 2 : 1, new SecretKeySpec(this.f5762b, "AES"), new IvParameterSpec(bArr));
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, instance);
            try {
                C1654a.m6618a(cipherInputStream, outputStream);
            } catch (IOException e) {
                if (e.getCause() instanceof GeneralSecurityException) {
                    Log.d("PdfBox-Android", "A GeneralSecurityException occured when decrypting some stream data", e);
                } else {
                    throw e;
                }
            } catch (Throwable th) {
                cipherInputStream.close();
                throw th;
            }
            cipherInputStream.close();
        } catch (GeneralSecurityException e2) {
            throw new IOException(e2);
        }
    }

    /* renamed from: a */
    private void m7152a(byte[] bArr, InputStream inputStream, OutputStream outputStream, boolean z) {
        byte[] bArr2 = new byte[16];
        int read = inputStream.read(bArr2);
        if (read == bArr2.length) {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(z ? 2 : 1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
                byte[] bArr3 = new byte[256];
                while (true) {
                    int read2 = inputStream.read(bArr3);
                    if (read2 != -1) {
                        outputStream.write(instance.update(bArr3, 0, read2));
                    } else {
                        outputStream.write(instance.doFinal());
                        return;
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (InvalidKeyException e2) {
                throw new IOException(e2);
            } catch (InvalidAlgorithmParameterException e3) {
                throw new IOException(e3);
            } catch (NoSuchPaddingException e4) {
                throw new IOException(e4);
            } catch (IllegalBlockSizeException e5) {
                throw new IOException(e5);
            } catch (BadPaddingException e6) {
                throw new IOException(e6);
            }
        } else {
            throw new IOException("AES initialization vector not fully read: only " + read + " bytes read instead of " + bArr2.length);
        }
    }

    /* renamed from: a */
    private byte[] m7153a(long j, long j2) {
        byte[] bArr = this.f5762b;
        byte[] bArr2 = new byte[(bArr.length + 5)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr2.length - 5] = (byte) ((int) (j & 255));
        bArr2[bArr2.length - 4] = (byte) ((int) ((j >> 8) & 255));
        bArr2[bArr2.length - 3] = (byte) ((int) ((j >> 16) & 255));
        bArr2[bArr2.length - 2] = (byte) ((int) (j2 & 255));
        bArr2[bArr2.length - 1] = (byte) ((int) ((j2 >> 8) & 255));
        MessageDigest a = C1769d.m7088a();
        a.update(bArr2);
        if (this.f5766g) {
            a.update(f5760c);
        }
        byte[] digest = a.digest();
        int min = Math.min(bArr2.length, 16);
        byte[] bArr3 = new byte[min];
        System.arraycopy(digest, 0, bArr3, 0, min);
        return bArr3;
    }

    /* renamed from: a */
    public void mo8031a(C1605b bVar, long j, long j2) {
        if (!this.f5765f.contains(bVar)) {
            this.f5765f.add(bVar);
            if (bVar instanceof C1622p) {
                m7150a((C1622p) bVar, j, j2);
            } else if (bVar instanceof C1619o) {
                mo8033a((C1619o) bVar, j, j2);
            } else if (bVar instanceof C1607d) {
                m7149a((C1607d) bVar, j, j2);
            } else if (bVar instanceof C1604a) {
                m7148a((C1604a) bVar, j, j2);
            }
        }
    }

    /* renamed from: a */
    public void mo8032a(C1619o oVar, long j, int i) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C1654a.m6620a(oVar.mo7626k()));
        OutputStream p = oVar.mo7631p();
        try {
            m7147a(j, (long) i, byteArrayInputStream, p, false);
        } finally {
            p.close();
        }
    }

    /* renamed from: a */
    public void mo8033a(C1619o oVar, long j, long j2) {
        if ((this.f5764e || !C1613i.f5173eq.equals(oVar.mo7543d(C1613i.f5338hw))) && !C1613i.f5315hZ.equals(oVar.mo7543d(C1613i.f5338hw))) {
            m7149a((C1607d) oVar, j, j2);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C1654a.m6620a(oVar.mo7625j()));
            OutputStream p = oVar.mo7631p();
            try {
                m7147a(j, j2, byteArrayInputStream, p, true);
            } finally {
                p.close();
            }
        }
    }

    /* renamed from: a */
    public void mo8034a(C1622p pVar, long j, int i) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pVar.mo7643c());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7147a(j, (long) i, byteArrayInputStream, byteArrayOutputStream, false);
        pVar.mo7639a(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    public void mo8035a(C1766a aVar) {
        this.f5767h = aVar;
    }

    /* renamed from: a */
    public abstract void mo8023a(C1771f fVar, C1604a aVar, C1767b bVar);

    /* renamed from: a */
    public abstract void mo8024a(C1783c cVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8036a(boolean z) {
        this.f5764e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8037a(byte[] bArr, InputStream inputStream, OutputStream outputStream) {
        this.f5763d.mo8028a(bArr);
        this.f5763d.mo8027a(inputStream, outputStream);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8038a(byte[] bArr, byte[] bArr2, OutputStream outputStream) {
        this.f5763d.mo8028a(bArr);
        this.f5763d.mo8030a(bArr2, outputStream);
    }

    /* renamed from: a */
    public abstract boolean mo8025a();

    /* renamed from: b */
    public C1766a mo8039b() {
        return this.f5767h;
    }

    /* renamed from: b */
    public void mo8040b(boolean z) {
        this.f5766g = z;
    }
}
