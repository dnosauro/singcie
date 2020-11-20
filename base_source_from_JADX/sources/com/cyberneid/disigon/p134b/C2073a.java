package com.cyberneid.disigon.p134b;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.core.app.C0490a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyStore;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.cyberneid.disigon.b.a */
public class C2073a {

    /* renamed from: g */
    private static final char[] f6489g = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    private KeyguardManager f6490a;

    /* renamed from: b */
    private FingerprintManager f6491b;

    /* renamed from: c */
    private Context f6492c;

    /* renamed from: d */
    private KeyStore f6493d;

    /* renamed from: e */
    private KeyGenerator f6494e;

    /* renamed from: f */
    private String f6495f;

    /* renamed from: com.cyberneid.disigon.b.a$a */
    public interface C2074a {
        /* renamed from: a */
        void mo8693a(int i, String str);

        /* renamed from: a */
        void mo8694a(String str);

        /* renamed from: b */
        void mo8695b(String str);
    }

    /* renamed from: com.cyberneid.disigon.b.a$b */
    protected class C2075b extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a */
        protected final C2074a f6496a;

        public C2075b(C2074a aVar) {
            this.f6496a = aVar;
        }

        /* renamed from: a */
        public C2074a mo8696a() {
            return this.f6496a;
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
            C2074a aVar = this.f6496a;
            aVar.mo8695b("Authentication error [" + i + "] " + charSequence);
        }

        public void onAuthenticationFailed() {
            this.f6496a.mo8695b("Authentication failed");
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.f6496a.mo8693a(i, charSequence.toString());
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        }
    }

    /* renamed from: com.cyberneid.disigon.b.a$c */
    protected class C2076c extends C2075b {
        public C2076c(C2074a aVar) {
            super(aVar);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            try {
                String a = C2073a.this.m8256a(authenticationResult.getCryptoObject().getCipher());
                if (a != null) {
                    this.f6496a.mo8694a(a);
                } else {
                    this.f6496a.mo8695b("Failed deciphering");
                }
            } catch (Exception e) {
                C2074a aVar = this.f6496a;
                aVar.mo8695b("Deciphering failed " + e.getMessage());
            }
        }
    }

    /* renamed from: com.cyberneid.disigon.b.a$d */
    private class C2077d extends C2075b {

        /* renamed from: d */
        private final String f6500d;

        public C2077d(C2074a aVar, String str) {
            super(aVar);
            this.f6500d = str;
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            try {
                if (C2073a.this.mo8691a(authenticationResult.getCryptoObject().getCipher(), this.f6500d)) {
                    this.f6496a.mo8694a("Encrypted");
                } else {
                    this.f6496a.mo8695b("Encryption failed");
                }
            } catch (Exception e) {
                C2074a aVar = this.f6496a;
                aVar.mo8695b("Encryption failed " + e.getMessage());
            }
        }
    }

    public C2073a(Context context) {
        this.f6492c = context;
    }

    /* renamed from: a */
    private static int m8254a(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if ('A' > c || c > 'F') {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m8256a(Cipher cipher) {
        String e = m8265e();
        if (e == null) {
            return null;
        }
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(m8261b(e)), cipher);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read = cipherInputStream.read();
            if (read == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
        }
        cipherInputStream.close();
        byte[] bArr = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return new String(bArr, Charset.defaultCharset());
    }

    /* renamed from: a */
    private Cipher m8257a(int i) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        Key key = this.f6493d.getKey("MY_APP_ALIAS", (char[]) null);
        if (key == null) {
            return null;
        }
        if (i == 1) {
            instance.init(i, key);
            m8260b(instance.getIV());
        } else {
            instance.init(i, key, new IvParameterSpec(m8266f()));
        }
        return instance;
    }

    /* renamed from: a */
    private void m8258a(CancellationSignal cancellationSignal, C2075b bVar, int i) {
        try {
            if (m8268h()) {
                this.f6491b.authenticate(new FingerprintManager.CryptoObject(m8257a(i)), cancellationSignal, 0, bVar, (Handler) null);
                return;
            }
            bVar.mo8696a().mo8695b("User hasn't granted permission to use Fingerprint");
        } catch (Throwable th) {
            C2074a a = bVar.mo8696a();
            a.mo8695b("An error occurred: " + th.getMessage());
        }
    }

    /* renamed from: a */
    private void m8259a(String str) {
        SharedPreferences.Editor edit = m8267g().edit();
        edit.putString("ENCRYPTED_PASS_SHARED_PREF_KEY", str);
        edit.commit();
    }

    /* renamed from: b */
    private void m8260b(byte[] bArr) {
        SharedPreferences.Editor edit = m8267g().edit();
        edit.putString("LAST_USED_IV_SHARED_PREF_KEY", mo8688a(bArr));
        edit.commit();
    }

    /* renamed from: b */
    private byte[] m8261b(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                int a = m8254a(str.charAt(i));
                int a2 = m8254a(str.charAt(i + 1));
                if (a == -1 || a2 == -1) {
                    throw new IllegalArgumentException("contains illegal character for hexBinary: " + str);
                }
                bArr[i / 2] = (byte) ((a * 16) + a2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
    }

    /* renamed from: c */
    private KeyGenParameterSpec m8262c() {
        return new KeyGenParameterSpec.Builder("MY_APP_ALIAS", 3).setBlockModes(new String[]{"CBC"}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{"PKCS7Padding"}).build();
    }

    /* renamed from: c */
    private void m8263c(String str) {
        this.f6495f = str;
        Log.w("FingerPrintAuthHelper", this.f6495f);
    }

    /* renamed from: d */
    private boolean m8264d() {
        try {
            this.f6493d = KeyStore.getInstance("AndroidKeyStore");
            this.f6494e = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            this.f6493d.load((KeyStore.LoadStoreParameter) null);
            if (m8266f() != null) {
                return true;
            }
            this.f6494e.init(m8262c());
            this.f6494e.generateKey();
            return true;
        } catch (Throwable th) {
            m8263c("Failed init of keyStore & keyGenerator: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    private String m8265e() {
        SharedPreferences g = m8267g();
        if (g != null) {
            return g.getString("ENCRYPTED_PASS_SHARED_PREF_KEY", (String) null);
        }
        return null;
    }

    /* renamed from: f */
    private byte[] m8266f() {
        String string;
        SharedPreferences g = m8267g();
        if (g == null || (string = g.getString("LAST_USED_IV_SHARED_PREF_KEY", (String) null)) == null) {
            return null;
        }
        return m8261b(string);
    }

    /* renamed from: g */
    private SharedPreferences m8267g() {
        return this.f6492c.getSharedPreferences("FingerPrintAuthHelper", 0);
    }

    /* renamed from: h */
    private boolean m8268h() {
        return C0490a.m2099b(this.f6492c, "android.permission.USE_FINGERPRINT") == 0;
    }

    /* renamed from: a */
    public String mo8687a() {
        return this.f6495f;
    }

    /* renamed from: a */
    public String mo8688a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f6489g[(b >> 4) & 15]);
            sb.append(f6489g[b & 15]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo8689a(CancellationSignal cancellationSignal, C2074a aVar) {
        m8258a(cancellationSignal, (C2075b) new C2076c(aVar), 2);
    }

    /* renamed from: a */
    public void mo8690a(String str, CancellationSignal cancellationSignal, C2074a aVar) {
        m8258a(cancellationSignal, (C2075b) new C2077d(aVar, str), 1);
    }

    /* renamed from: a */
    public boolean mo8691a(Cipher cipher, String str) {
        try {
            if (str.isEmpty()) {
                m8263c("Password is empty");
                return false;
            } else if (cipher == null) {
                m8263c("Could not create cipher");
                return false;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
                cipherOutputStream.write(str.getBytes(Charset.defaultCharset()));
                cipherOutputStream.flush();
                cipherOutputStream.close();
                m8259a(mo8688a(byteArrayOutputStream.toByteArray()));
                return true;
            }
        } catch (Throwable th) {
            m8263c("Encryption failed " + th.getMessage());
            return false;
        }
    }

    @TargetApi(23)
    /* renamed from: b */
    public boolean mo8692b() {
        String str;
        if (Build.VERSION.SDK_INT < 23) {
            str = "This Android version does not support fingerprint authentication";
        } else {
            this.f6490a = (KeyguardManager) this.f6492c.getSystemService("keyguard");
            this.f6491b = (FingerprintManager) this.f6492c.getSystemService("fingerprint");
            if (this.f6491b == null) {
                str = "Fingerprint service not available";
            } else {
                KeyguardManager keyguardManager = this.f6490a;
                if (keyguardManager == null) {
                    str = "keyguard service not available";
                } else if (!keyguardManager.isKeyguardSecure()) {
                    str = "User hasn't enabled Lock Screen";
                } else if (!m8268h()) {
                    str = "User hasn't granted permission to use Fingerprint";
                } else if (this.f6491b.hasEnrolledFingerprints()) {
                    return m8264d();
                } else {
                    str = "User hasn't registered any fingerprints";
                }
            }
        }
        m8263c(str);
        return false;
    }
}
