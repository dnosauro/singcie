package p066b.p067a.p068a.p072d;

import android.nfc.tech.IsoDep;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.parse.ParseException;
import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;
import p066b.p067a.p068a.p071c.C1349a;
import p066b.p067a.p068a.p071c.C1351c;
import p066b.p067a.p068a.p071c.C1352d;
import p066b.p067a.p068a.p071c.C1353e;
import p066b.p067a.p068a.p072d.C1358b;
import p066b.p067a.p068a.p072d.p073a.C1355a;
import p066b.p067a.p068a.p072d.p073a.C1356b;
import p066b.p067a.p068a.p072d.p073a.C1357c;
import p066b.p067a.p068a.p072d.p074b.C1361a;
import p066b.p067a.p068a.p075e.C1373a;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;
import p157d.p166g.C3275d;
import p157d.p166g.C3278f;

/* renamed from: b.a.a.d.e */
public final class C1366e {
    @NotNull

    /* renamed from: B */
    private static byte[] f4169B = new byte[0];

    /* renamed from: a */
    public static final C1367a f4170a = new C1367a((C3247e) null);
    @NotNull

    /* renamed from: A */
    private final IsoDep f4171A;

    /* renamed from: b */
    private int f4172b;

    /* renamed from: c */
    private final byte[] f4173c;

    /* renamed from: d */
    private byte[] f4174d = new byte[0];

    /* renamed from: e */
    private byte[] f4175e = new byte[0];

    /* renamed from: f */
    private byte[] f4176f = new byte[0];

    /* renamed from: g */
    private byte[] f4177g = new byte[0];

    /* renamed from: h */
    private byte[] f4178h = new byte[0];

    /* renamed from: i */
    private byte[] f4179i = new byte[0];

    /* renamed from: j */
    private byte[] f4180j = new byte[0];

    /* renamed from: k */
    private byte[] f4181k = new byte[0];

    /* renamed from: l */
    private byte[] f4182l = new byte[0];

    /* renamed from: m */
    private byte[] f4183m = new byte[0];

    /* renamed from: n */
    private byte[] f4184n = new byte[0];

    /* renamed from: o */
    private byte[] f4185o = new byte[0];

    /* renamed from: p */
    private byte[] f4186p = new byte[0];

    /* renamed from: q */
    private byte[] f4187q = new byte[0];

    /* renamed from: r */
    private byte[] f4188r = new byte[0];

    /* renamed from: s */
    private final byte f4189s;

    /* renamed from: t */
    private final byte f4190t;

    /* renamed from: u */
    private final byte f4191u;

    /* renamed from: v */
    private final byte f4192v;

    /* renamed from: w */
    private final byte[] f4193w;

    /* renamed from: x */
    private final byte[] f4194x;

    /* renamed from: y */
    private final byte[] f4195y;
    @NotNull

    /* renamed from: z */
    private final byte[] f4196z;

    /* renamed from: b.a.a.d.e$a */
    public static final class C1367a {
        private C1367a() {
        }

        public /* synthetic */ C1367a(C3247e eVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final int mo6760a(byte b) {
            return b & 255;
        }
    }

    /* renamed from: b.a.a.d.e$b */
    public static final class C1368b extends IllegalArgumentException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1368b(@NotNull String str) {
            super(str);
            C3250h.m9056b(str, "message");
        }
    }

    /* renamed from: b.a.a.d.e$c */
    public static final class C1369c extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1369c(@NotNull String str) {
            super(str);
            C3250h.m9056b(str, "error");
        }
    }

    /* renamed from: b.a.a.d.e$d */
    public static final class C1370d extends Throwable {
    }

    /* renamed from: b.a.a.d.e$e */
    public static final class C1371e extends IllegalArgumentException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1371e(@NotNull String str) {
            super(str);
            C3250h.m9056b(str, "message");
        }
    }

    /* renamed from: b.a.a.d.e$f */
    public static final class C1372f extends IllegalArgumentException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1372f(@NotNull String str) {
            super(str);
            C3250h.m9056b(str, "message");
        }
    }

    public C1366e(@NotNull IsoDep isoDep) {
        IsoDep isoDep2 = isoDep;
        C3250h.m9056b(isoDep2, "isoDep");
        this.f4171A = isoDep2;
        byte b = (byte) 160;
        this.f4173c = new byte[]{b, 0, 0, 0, 0, 57};
        byte b2 = (byte) CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
        this.f4189s = b2;
        byte b3 = (byte) 129;
        this.f4190t = b3;
        byte b4 = (byte) 130;
        this.f4191u = b4;
        this.f4192v = b3;
        byte b5 = (byte) CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256;
        byte b6 = (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384;
        byte b7 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384;
        byte b8 = (byte) CipherSuite.TLS_PSK_WITH_NULL_SHA384;
        byte b9 = (byte) 228;
        byte b10 = (byte) CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256;
        byte b11 = (byte) 221;
        byte b12 = (byte) 224;
        byte b13 = (byte) 241;
        byte b14 = (byte) ParseException.INVALID_SESSION_TOKEN;
        byte b15 = b13;
        byte b16 = (byte) 239;
        byte b17 = b16;
        byte b18 = (byte) CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256;
        byte b19 = (byte) 247;
        byte b20 = b19;
        byte b21 = (byte) CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA;
        byte b22 = b21;
        byte b23 = (byte) 226;
        byte b24 = b3;
        byte b25 = (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256;
        byte b26 = b9;
        byte b27 = (byte) 135;
        byte b28 = b27;
        byte b29 = (byte) CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256;
        byte b30 = b29;
        byte b31 = (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA;
        byte b32 = b;
        byte b33 = (byte) CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256;
        byte b34 = b33;
        byte b35 = (byte) 216;
        byte b36 = b35;
        byte b37 = (byte) CipherSuite.TLS_PSK_WITH_RC4_128_SHA;
        byte b38 = (byte) ParseException.UNSUPPORTED_SERVICE;
        byte b39 = b5;
        byte b40 = (byte) CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384;
        byte b41 = b31;
        byte b42 = (byte) 217;
        byte b43 = b14;
        byte b44 = (byte) CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
        byte b45 = (byte) ParseException.EMAIL_NOT_FOUND;
        byte b46 = b44;
        byte b47 = (byte) 141;
        byte b48 = b47;
        byte b49 = (byte) CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA;
        byte b50 = b45;
        byte b51 = (byte) ParseException.INVALID_LINKED_SESSION;
        byte b52 = b51;
        byte b53 = (byte) CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
        byte b54 = b53;
        byte b55 = (byte) 253;
        byte b56 = b11;
        byte b57 = (byte) CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384;
        byte b58 = b55;
        byte b59 = (byte) 199;
        byte b60 = b37;
        byte b61 = (byte) 222;
        byte b62 = b10;
        byte b63 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA;
        byte b64 = b63;
        byte b65 = (byte) 240;
        byte b66 = b4;
        byte b67 = (byte) CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384;
        byte b68 = b67;
        byte b69 = (byte) CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256;
        byte b70 = b8;
        byte b71 = (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256;
        byte b72 = (byte) CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA;
        byte b73 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA;
        byte b74 = b72;
        byte b75 = (byte) 155;
        byte b76 = b73;
        byte b77 = (byte) 131;
        byte b78 = b69;
        byte b79 = (byte) ParseException.EMAIL_TAKEN;
        byte b80 = b79;
        byte b81 = (byte) CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256;
        byte b82 = b77;
        byte b83 = (byte) ParseException.ACCOUNT_ALREADY_LINKED;
        byte b84 = b83;
        byte b85 = (byte) CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA;
        byte b86 = b85;
        byte b87 = (byte) 219;
        byte b88 = b87;
        byte b89 = (byte) 246;
        byte b90 = b81;
        byte b91 = (byte) 243;
        byte b92 = (byte) CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384;
        byte b93 = b92;
        byte b94 = (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
        byte b95 = b57;
        byte b96 = (byte) 227;
        byte b97 = b96;
        byte b98 = (byte) 235;
        byte b99 = b98;
        byte b100 = (byte) CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256;
        byte b101 = b61;
        byte b102 = (byte) CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256;
        byte b103 = b100;
        byte b104 = (byte) 233;
        byte b105 = (byte) 237;
        byte b106 = (byte) CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
        byte b107 = (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256;
        byte b108 = (byte) ParseException.LINKED_ID_MISSING;
        byte b109 = b59;
        byte b110 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384;
        byte b111 = b110;
        byte b112 = (byte) CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256;
        byte b113 = b40;
        byte b114 = (byte) 236;
        byte b115 = (byte) CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
        this.f4193w = new byte[]{b5, 40, 55, b6, 76, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, (byte) CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA256, 39, 87, 123, (byte) 255, 78, b7, b8, b9, b10, b11, b12, b13, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 20, b14, b16, 36, b18, b7, 92, b19, 15, b8, 44, b14, b21, 77, 20, b23, b3, 75, b25, b27, 126, b29, 0, (byte) 225, 117, b31, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 118, (byte) CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 98, b5, 83, 89, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, b33, b35, (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, 5, 29, b37, b38, 116, 7, b40, b42, 25, 82, b44, 3, b18, 6, b45, b40, b47, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, b49, b51, 13, b37, b53, b55, b11, b57, b59, 25, 21, b49, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, b61, b63, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, b65, 42, b8, 3, b23, b4, b67, 14, 113, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, b69, 60, (byte) 218, 91, b38, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 35, 43, 9, b25, b71, b59, 7, 69, b72, b73, 73, 9, b75, 68, b77, b79, b81, 98, b83, 9, b85, 116, b87, b89, b91, b75, 114, 35, b92, b57, b94, b96, 63, 26, 12, b61, b61, b98, b100, b102, 85, 23, b6, b104, b94, 10, b6, 36, 14, 30, b40, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 40, 58, 39, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, b49, b42, 59, 75, 29, 25, b91, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, (byte) CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 62, (byte) 139, 95, b89, b40, b12, b105, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, b2, (byte) 213, b6, b12, 60, 89, (byte) 231, 52, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 24, 117, 93, 117, 54, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, (byte) CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 65, 54, b65, b106, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 61, b59, 10, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, b6, b107, b89, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 19, b40, b71, b108, b110, 5, 44, b112, b114, b62, 81, b23, b90, b43, 77, 22, b12, b41, 37, 77, b102, b89, 78, b106, b103, b60, b82, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, b39, (byte) 153, b101, b108, b80, b115, b112, 19, b90, b105, b42, 58, b86, 21, 39, 61};
        byte b116 = (byte) 140;
        byte b117 = b102;
        byte b118 = (byte) ParseException.EMAIL_MISSING;
        byte b119 = b115;
        byte b120 = (byte) 242;
        byte b121 = (byte) Primes.SMALL_FACTOR_LIMIT;
        byte b122 = (byte) CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384;
        byte b123 = (byte) CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384;
        byte b124 = (byte) 244;
        byte b125 = (byte) CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA;
        byte b126 = b121;
        byte b127 = (byte) 192;
        byte b128 = (byte) ParseException.MUST_CREATE_USER_THROUGH_SIGNUP;
        byte b129 = (byte) ParseException.PASSWORD_MISSING;
        byte[] bArr = {71, 22, b78, b115, b116, b118, 122, 7, b54, 21, b99, 26, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 117, b120, b107, b32, b26, b62, (byte) 234, b15, b39, 117, b80, b32, b49, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 75, 4, b36, 17, 24, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, b121, b23, b118, b36, b122, 77, 60, 92, b89, b34, 87, 83, b65, b105, b76, b28, (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 11, 60, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 37, b60, 1, 70, 15, (byte) 232, 76, 46, b101, 87, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, (byte) 238, (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, b62, 55, b52, b76, b50, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, (byte) ParseException.SESSION_MISSING, b123, 9, b124, b70, 53, 124, 39, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 20, b6, 67, b114, 91, 60, b17, (byte) CipherSuite.TLS_PSK_WITH_NULL_SHA256, 64, 63, b125, b22, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, (byte) 142, 46, b127, b49, 73, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, b104, b28, 117, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, b48, (byte) CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, b113, 1, b106, (byte) ParseException.USERNAME_TAKEN, 117, b68, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, b116, 76, b128, b49, 27, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 71, b26, b101, 86, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 58, b20, 11, 32, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 23, b62, 94, b99, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, b125, 52, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, (byte) 215, 82, b109, b124, 18, b88, 39, 117, 65, 87, 90, b32, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, b95, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, (byte) 188, b118, b48, b28, (byte) 230, 23, 11, 51, 67, b49, 44, b74, b120, b42, 126, 24, b127, b30, 35, 67, b112, 1, 42, 91, b70, b66, 40, 8, b65, 27, 92, b58, (byte) CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 58, b127, b86, 76, 95, 60, b58, 45, b123, b24, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 53, (byte) CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, b93, b111, b122, b97, b20, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 19, 70, 28, 27, b129, 19, (byte) 220, b49, b127, b6, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, b126, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, b20, 124, b122, ASN1Constants.UNIVERSAL_SET_TYPE, b64, b129, b60, b93, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, b36, b62, b56, 85, 81, 37, b68, (byte) 229, b46, b128, 79, b119, b65, b117, b58, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 12, b126, b84, 86, 67, b74, 56, b58, b24};
        this.f4194x = bArr;
        this.f4195y = new byte[]{0, 1, 0, 1};
        this.f4196z = new byte[]{b32, 0, 0, 0, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, (byte) 128, 0, 0, 0, 9, b24, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 1};
    }

    /* renamed from: a */
    private final C1354a m5270a(C1354a aVar) {
        byte[] bArr = new byte[0];
        if (!(aVar.mo6698a().length == 0)) {
            bArr = C1358b.f4157a.mo6721b(bArr, aVar.mo6698a());
        }
        int d = aVar.mo6701d();
        while (true) {
            if (C1358b.f4157a.mo6710a(d >> 8, 97) == 0) {
                byte b = (byte) (d & 255);
                if (b != 0) {
                    aVar = m5275b(new byte[]{0, (byte) 192, 0, 0, b});
                    bArr = C1358b.f4157a.mo6721b(bArr, aVar.mo6698a());
                    if (aVar.mo6701d() == 36864 || C1358b.f4157a.mo6710a(aVar.mo6701d() >> 8, 97) != 0) {
                        break;
                    }
                } else {
                    aVar = m5275b(new byte[]{0, (byte) 192, 0, 0, 0});
                    bArr = C1358b.f4157a.mo6721b(bArr, aVar.mo6698a());
                }
            } else {
                byte b2 = (byte) 0;
                if (!C1358b.f4157a.mo6713a(aVar.mo6699b(), new byte[]{(byte) CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, b2})) {
                    if (!C1358b.f4157a.mo6713a(aVar.mo6699b(), new byte[]{(byte) 107, b2})) {
                        if (!C1358b.f4157a.mo6713a(aVar.mo6699b(), new byte[]{(byte) 98, (byte) 130})) {
                            return new C1354a(new byte[0], new byte[]{(byte) d});
                        }
                    }
                }
            }
        }
        return m5281d(this.f4182l, this.f4183m, bArr);
    }

    /* renamed from: a */
    private final C1354a m5271a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4;
        C1354a a;
        int length = bArr2.length;
        if (length < f4170a.mo6760a((byte) 231)) {
            byte[] b = C1358b.f4157a.mo6721b(C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(new byte[0], bArr), (byte) length), bArr2);
            if (bArr3 != null) {
                b = C1358b.f4157a.mo6721b(b, bArr3);
            }
            return m5270a(m5275b(m5279c(this.f4182l, this.f4183m, b)));
        }
        byte b2 = bArr[0];
        int i = 0;
        do {
            byte[] bArr5 = new byte[0];
            byte[] a2 = C1358b.f4157a.mo6717a(bArr2, i, Math.min(bArr2.length - i, 231));
            i += a2.length;
            if (i != bArr2.length) {
                bArr[0] = (byte) (b2 | Tnaf.POW_2_WIDTH);
            } else {
                bArr[0] = b2;
            }
            if (!(a2.length == 0)) {
                bArr4 = C1358b.f4157a.mo6721b(C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(new byte[0], bArr), (byte) a2.length), a2);
                if (bArr3 != null) {
                    bArr4 = C1358b.f4157a.mo6721b(bArr4, new byte[0]);
                }
            } else {
                bArr4 = C1358b.f4157a.mo6721b(new byte[0], bArr);
                if (bArr3 != null) {
                    bArr4 = C1358b.f4157a.mo6721b(bArr4, bArr3);
                }
            }
            a = m5270a(m5275b(m5279c(this.f4182l, this.f4183m, bArr4)));
        } while (i != bArr2.length);
        return a;
    }

    /* renamed from: a */
    private final void m5272a(int... iArr) {
        int length = iArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += Math.signum((float) iArr[i2]) < ((float) 0) ? iArr[i2] & 255 : iArr[i2];
        }
        this.f4172b = i;
    }

    /* renamed from: a */
    private final byte[] m5273a(int i) {
        C1354a a;
        byte[] a2;
        FirebaseCrashlytics.getInstance().log("readFileSM");
        byte[] bArr = new byte[0];
        C1354a a3 = m5271a(new byte[]{0, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 2, 4}, new byte[]{m5278c(i), m5280d(i)}, (byte[]) null);
        if (!(!C3250h.m9055a((Object) a3.mo6700c(), (Object) "9000"))) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = {0, (byte) CipherSuite.TLS_PSK_WITH_NULL_SHA256, m5278c(i2), m5280d(i2)};
                a = m5271a(bArr2, new byte[0], new byte[]{(byte) 256});
                a2 = a.mo6698a();
                if (Byte.compare((byte) (a.mo6701d() >> 8), (byte) 108) == 0) {
                    a2 = m5271a(bArr2, new byte[0], new byte[]{C1358b.f4157a.mo6718b(a.mo6701d() & 255)}).mo6698a();
                }
                if (!C3250h.m9055a((Object) a.mo6700c(), (Object) "9000")) {
                    break;
                }
                bArr = C1358b.f4157a.mo6721b(bArr, a2);
                i2 += a2.length;
            }
            if (C3250h.m9055a((Object) a.mo6700c(), (Object) "6282")) {
                return C1358b.f4157a.mo6721b(bArr, a2);
            }
            if (!(!C3250h.m9055a((Object) a.mo6700c(), (Object) "6b00"))) {
                return bArr;
            }
            throw new C1369c(a.mo6700c());
        }
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        instance.log("apdu resp:" + a3.mo6700c());
        throw new C1369c(a3.mo6700c());
    }

    /* renamed from: b */
    private final C1354a m5274b(C1354a aVar) {
        byte[] a = aVar.mo6698a();
        int d = aVar.mo6701d();
        byte[] bArr = new byte[0];
        if (!(a.length == 0)) {
            bArr = C1358b.f4157a.mo6721b(bArr, a);
        }
        byte b = (byte) 0;
        byte[] bArr2 = {b, (byte) 192, 0, 0};
        while (C1358b.f4157a.mo6710a(d >> 8, 97) == 0) {
            byte b2 = (byte) (d & 255);
            if (b2 != 0) {
                C1354a b3 = m5275b(C1358b.f4157a.mo6715a(bArr2, b2));
                byte[] b4 = C1358b.f4157a.mo6721b(bArr, b3.mo6698a());
                C1358b.C1360b bVar = C1358b.f4157a;
                String c = b3.mo6700c();
                Charset charset = C3275d.f7318a;
                if (c != null) {
                    byte[] bytes = c.getBytes(charset);
                    C3250h.m9053a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    return new C1354a(bVar.mo6721b(b4, bytes));
                }
                throw new C3266f("null cannot be cast to non-null type java.lang.String");
            }
            C1354a b5 = m5275b(C1358b.f4157a.mo6715a(bArr2, b));
            int d2 = b5.mo6701d();
            bArr = C1358b.f4157a.mo6721b(bArr, b5.mo6698a());
            d = d2;
        }
        return aVar;
    }

    /* renamed from: b */
    private final C1354a m5275b(byte[] bArr) {
        C1373a.C1374a aVar = C1373a.f4197a;
        aVar.mo6761a("APDU: " + C1358b.f4157a.mo6722c(bArr));
        byte[] transceive = this.f4171A.transceive(bArr);
        C3250h.m9053a((Object) transceive, "isoDep.transceive(apdu)");
        C1354a aVar2 = new C1354a(transceive);
        C1373a.C1374a aVar3 = C1373a.f4197a;
        aVar3.mo6761a("RESPONSE: " + C1358b.f4157a.mo6722c(aVar2.mo6698a()));
        C1373a.C1374a aVar4 = C1373a.f4197a;
        aVar4.mo6761a("SW: " + C1358b.f4157a.mo6722c(aVar2.mo6699b()));
        return aVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r12 != null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r12 != null) goto L_0x008e;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final p066b.p067a.p068a.p072d.C1354a m5276b(byte[] r10, byte[] r11, byte[] r12) {
        /*
            r9 = this;
            r0 = 0
            byte[] r1 = new byte[r0]
            int r2 = r11.length
            r3 = 255(0xff, float:3.57E-43)
            r4 = 1
            if (r2 <= r3) goto L_0x0068
            byte r1 = r10[r0]
            r2 = 0
        L_0x000c:
            byte[] r5 = new byte[r0]
            b.a.a.d.b$b r6 = p066b.p067a.p068a.p072d.C1358b.f4157a
            int r7 = r11.length
            int r7 = r7 - r2
            int r7 = java.lang.Math.min(r7, r3)
            byte[] r6 = r6.mo6717a(r11, r2, r7)
            int r7 = r6.length
            int r2 = r2 + r7
            int r7 = r11.length
            if (r2 == r7) goto L_0x0025
            r7 = r1 | 16
            byte r7 = (byte) r7
            r10[r0] = r7
            goto L_0x0027
        L_0x0025:
            r10[r0] = r1
        L_0x0027:
            b.a.a.d.b$b r7 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r5 = r7.mo6721b((byte[]) r5, (byte[]) r10)
            b.a.a.d.b$b r7 = p066b.p067a.p068a.p072d.C1358b.f4157a
            int r8 = r6.length
            byte r8 = (byte) r8
            byte[] r5 = r7.mo6715a((byte[]) r5, (byte) r8)
            b.a.a.d.b$b r7 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r5 = r7.mo6721b((byte[]) r5, (byte[]) r6)
            if (r12 == 0) goto L_0x0043
            b.a.a.d.b$b r6 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r5 = r6.mo6721b((byte[]) r5, (byte[]) r12)
        L_0x0043:
            b.a.a.d.a r5 = r9.m5275b((byte[]) r5)
            java.lang.String r6 = r5.mo6700c()
            java.lang.String r7 = "9000"
            boolean r6 = p157d.p161d.p163b.C3250h.m9055a((java.lang.Object) r6, (java.lang.Object) r7)
            r6 = r6 ^ r4
            if (r6 != 0) goto L_0x005c
            int r6 = r11.length
            if (r2 != r6) goto L_0x000c
            b.a.a.d.a r10 = r9.m5274b((p066b.p067a.p068a.p072d.C1354a) r5)
            return r10
        L_0x005c:
            b.a.a.d.e$f r10 = new b.a.a.d.e$f
            java.lang.String r11 = r5.mo6700c()
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        L_0x0068:
            int r2 = r11.length
            if (r2 != 0) goto L_0x006c
            r0 = 1
        L_0x006c:
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0086
            b.a.a.d.b$b r0 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r10 = r0.mo6721b((byte[]) r1, (byte[]) r10)
            b.a.a.d.b$b r0 = p066b.p067a.p068a.p072d.C1358b.f4157a
            int r1 = r11.length
            byte r1 = (byte) r1
            byte[] r10 = r0.mo6715a((byte[]) r10, (byte) r1)
            b.a.a.d.b$b r0 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r10 = r0.mo6721b((byte[]) r10, (byte[]) r11)
            if (r12 == 0) goto L_0x0094
            goto L_0x008e
        L_0x0086:
            b.a.a.d.b$b r11 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r10 = r11.mo6721b((byte[]) r1, (byte[]) r10)
            if (r12 == 0) goto L_0x0094
        L_0x008e:
            b.a.a.d.b$b r11 = p066b.p067a.p068a.p072d.C1358b.f4157a
            byte[] r10 = r11.mo6721b((byte[]) r10, (byte[]) r12)
        L_0x0094:
            b.a.a.d.a r10 = r9.m5275b((byte[]) r10)
            b.a.a.d.a r10 = r9.m5274b((p066b.p067a.p068a.p072d.C1354a) r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p066b.p067a.p068a.p072d.C1366e.m5276b(byte[], byte[], byte[]):b.a.a.d.a");
    }

    /* renamed from: b */
    private final byte[] m5277b(int i) {
        C1354a b;
        byte[] a;
        byte[] bArr = new byte[0];
        m5276b(new byte[]{0, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 2, 4}, new byte[]{m5278c(i), m5280d(i)}, (byte[]) null);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = {0, (byte) CipherSuite.TLS_PSK_WITH_NULL_SHA256, m5278c(i2), m5280d(i2)};
            b = m5276b(bArr2, new byte[0], new byte[]{(byte) 256});
            a = b.mo6698a();
            if (C3250h.m9049a((int) (byte) (b.mo6701d() >> 8), (int) (byte) 108) == 0) {
                a = m5276b(bArr2, new byte[0], new byte[]{C1358b.f4157a.mo6718b(b.mo6701d() & 255)}).mo6698a();
            }
            if (!C3250h.m9055a((Object) b.mo6700c(), (Object) "9000")) {
                break;
            }
            bArr = C1358b.f4157a.mo6721b(bArr, a);
            i2 += a.length;
        }
        if (C3250h.m9055a((Object) b.mo6700c(), (Object) "6282")) {
            return C1358b.f4157a.mo6721b(bArr, a);
        }
        if (!(!C3250h.m9055a((Object) b.mo6700c(), (Object) "6b00"))) {
            return bArr;
        }
        throw new C1369c(b.mo6700c());
    }

    /* renamed from: c */
    private final byte m5278c(int i) {
        return (byte) ((i >> 8) & 255);
    }

    /* renamed from: c */
    private final byte[] m5279c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        C1358b.C1360b bVar;
        C1358b.C1360b.m5222a(C1358b.f4157a, f4169B, 0, 2, (Object) null);
        byte[] f = C1358b.f4157a.mo6729f(bArr3, 4);
        f[0] = (byte) (f[0] | 12);
        byte[] b = C1358b.f4157a.mo6720b(C1358b.f4157a.mo6721b(f4169B, f));
        byte[] bArr4 = new byte[0];
        if (bArr3[4] != 0 && bArr3.length > 5) {
            byte[] b2 = C1355a.f4153a.mo6704b(bArr, C1358b.f4157a.mo6720b(C1358b.f4157a.mo6717a(bArr3, 5, bArr3[4])));
            if ((bArr3[1] & 1) == 0) {
                bVar = C1358b.f4157a;
                b2 = C1358b.f4157a.mo6721b(new byte[]{1}, b2);
                i = 135;
            } else {
                bVar = C1358b.f4157a;
                i = CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA;
            }
            byte[] a = bVar.mo6716a(b2, i);
            b = C1358b.f4157a.mo6721b(b, a);
            bArr4 = C1358b.f4157a.mo6721b(bArr4, a);
        }
        if (bArr3.length == 5 || bArr3.length == bArr3[4] + 6) {
            byte[] a2 = C1358b.f4157a.mo6716a(new byte[]{bArr3[bArr3.length - 1]}, (int) (byte) CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA);
            b = C1358b.f4157a.mo6721b(b, a2);
            bArr4 = C1358b.f4157a.mo6721b(bArr4, a2);
        }
        byte[] b3 = C1358b.f4157a.mo6721b(bArr4, C1358b.f4157a.mo6716a(C1355a.f4153a.mo6703a(bArr2, C1358b.f4157a.mo6720b(b)), 142));
        return C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(f, new byte[]{(byte) b3.length}), b3), (byte) 0);
    }

    /* renamed from: d */
    private final byte m5280d(int i) {
        return (byte) i;
    }

    /* JADX WARNING: type inference failed for: r6v14, types: [byte] */
    /* JADX WARNING: type inference failed for: r6v31, types: [byte] */
    /* renamed from: d */
    private final C1354a m5281d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] a;
        byte[] a2;
        byte[] a3;
        byte[] a4;
        int[] iArr;
        int[] iArr2;
        byte[] bArr4 = bArr3;
        boolean z = false;
        C1358b.C1360b.m5222a(C1358b.f4157a, f4169B, 0, 2, (Object) null);
        m5272a(0);
        byte[] bArr5 = new byte[0];
        byte[] bArr6 = new byte[0];
        byte[] bArr7 = new byte[0];
        byte b = 0;
        while (true) {
            if (C3250h.m9049a((int) bArr4[this.f4172b], (int) (byte) 153) == 0) {
                if (C3250h.m9049a((int) bArr4[this.f4172b + 1], (int) (byte) 2) == 0) {
                    bArr7 = C1358b.f4157a.mo6717a(bArr4, this.f4172b, 4);
                    int i = this.f4172b;
                    byte b2 = (bArr4[i + 2] << 8) | bArr4[i + 3];
                    m5272a(i, 4);
                    byte[] bArr8 = bArr2;
                    b = b2;
                } else {
                    throw new C1371e("Errore nella verifica del SM - lunghezza del DataObject");
                }
            } else if (C3250h.m9049a((int) bArr4[this.f4172b], (int) (byte) 142) == 0) {
                byte[] a5 = C1355a.f4153a.mo6703a(bArr2, C1358b.f4157a.mo6720b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(f4169B, bArr6), bArr7)));
                m5272a(this.f4172b, 1);
                if (C3250h.m9049a((int) bArr4[this.f4172b], (int) (byte) 8) == 0) {
                    m5272a(this.f4172b, 1);
                    if (Arrays.equals(a5, C1358b.f4157a.mo6717a(bArr4, this.f4172b, 8))) {
                        m5272a(this.f4172b, 8);
                    } else {
                        throw new C1371e("Errore nella verifica del SM - MAC non corrispondente");
                    }
                } else {
                    throw new C1371e("Errore nella verifica del SM - lunghezza del MAC errata");
                }
            } else {
                byte[] bArr9 = bArr2;
                int i2 = this.f4172b;
                if (bArr4[i2] == ((byte) 135)) {
                    if (C1358b.f4157a.mo6709a(bArr4[this.f4172b + 1]) > C1358b.f4157a.mo6709a((byte) 128)) {
                        int a6 = C1358b.f4157a.mo6709a(bArr4[this.f4172b + 1]) - 128;
                        int a7 = a6 == 1 ? C1358b.f4157a.mo6709a(bArr4[this.f4172b + 2]) : 0;
                        if (a6 == 2) {
                            int i3 = this.f4172b;
                            a7 = bArr4[i3 + 3] | (bArr4[i3 + 2] << 8);
                        }
                        a3 = C1358b.f4157a.mo6717a(bArr4, this.f4172b, a6 + a7 + 2);
                        a4 = C1358b.f4157a.mo6717a(bArr4, this.f4172b + a6 + 3, a7 - 1);
                        iArr = new int[]{this.f4172b, a6, a7, 2};
                    } else {
                        C1358b.C1360b bVar = C1358b.f4157a;
                        int i4 = this.f4172b;
                        a = bVar.mo6717a(bArr4, i4, bArr4[i4 + 1] + 2);
                        C1358b.C1360b bVar2 = C1358b.f4157a;
                        int i5 = this.f4172b;
                        a2 = bVar2.mo6717a(bArr4, i5 + 3, bArr4[i5 + 1] - 1);
                        int i6 = this.f4172b;
                        iArr2 = new int[]{i6, bArr4[i6 + 1], 2};
                        m5272a(iArr2);
                        bArr6 = a3;
                        bArr5 = a4;
                    }
                } else if (Byte.compare(bArr4[i2], (byte) CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA) != 0) {
                    throw new C1371e("Tag non previsto nella risposta in SM");
                } else if (Byte.compare(bArr4[this.f4172b + 1], (byte) 128) > 0) {
                    int i7 = this.f4172b;
                    int i8 = bArr4[i7 + 1] - 128;
                    int i9 = i8 == 1 ? bArr4[i7 + 2] : 0;
                    if (i8 == 2) {
                        int i10 = this.f4172b;
                        i9 = bArr4[i10 + 3] | (bArr4[i10 + 2] << 8);
                    }
                    a3 = C1358b.f4157a.mo6717a(bArr4, this.f4172b, i8 + i9 + 2);
                    a4 = C1358b.f4157a.mo6717a(bArr4, this.f4172b + i8 + 2, i9);
                    iArr = new int[]{this.f4172b, i8, i9, 2};
                } else {
                    C1358b.C1360b bVar3 = C1358b.f4157a;
                    int i11 = this.f4172b;
                    a = bVar3.mo6717a(bArr4, i11, bArr4[i11 + 1] + 2);
                    C1358b.C1360b bVar4 = C1358b.f4157a;
                    int i12 = this.f4172b;
                    a2 = bVar4.mo6717a(bArr4, i12 + 2, bArr4[i12 + 1]);
                    int i13 = this.f4172b;
                    iArr2 = new int[]{i13, bArr4[i13 + 1], 2};
                    m5272a(iArr2);
                    bArr6 = a3;
                    bArr5 = a4;
                }
                m5272a(iArr);
                bArr6 = a3;
                bArr5 = a4;
            }
            if (this.f4172b >= bArr4.length) {
                if (bArr5.length == 0) {
                    z = true;
                }
                if (!(!z)) {
                    return new C1354a(C1358b.f4157a.mo6714a((int) b));
                }
                return new C1354a(C1358b.f4157a.mo6726d(C1355a.f4153a.mo6705c(bArr, bArr5)), C1358b.f4157a.mo6714a((int) b));
            }
            byte[] bArr10 = bArr;
        }
    }

    /* renamed from: d */
    private final void m5282d() {
        C1373a.f4197a.mo6761a("dApp()");
        byte[] bArr = this.f4193w;
        byte[] bArr2 = this.f4195y;
        byte[] bArr3 = this.f4194x;
        byte[] bArr4 = {32, 0, 0, 0, 0, 0, 0, 1};
        byte b = (byte) CipherSuite.TLS_PSK_WITH_RC4_128_SHA;
        C1358b.C1360b bVar = C1358b.f4157a;
        byte[] b2 = C1358b.f4157a.mo6721b(bVar.mo6721b(new byte[0], new byte[]{0, 0, 0, 0}), bArr4);
        byte[] a = C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(new byte[0], this.f4179i), (byte) 1);
        byte b3 = (byte) 129;
        C1358b.C1360b bVar2 = C1358b.f4157a;
        byte[] a2 = C1358b.f4157a.mo6715a(bVar2.mo6721b(new byte[0], new byte[]{42, b3, 34, (byte) 244, 42, 2, 4, 1}), (byte) 4);
        byte[] b4 = C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6715a(new byte[0], b), this.f4177g), b2), a), a2), bArr), bArr2);
        byte[] a3 = C1357c.f4156a.mo6708a(b4);
        byte[] f = C1358b.f4157a.mo6729f(b4, (this.f4180j.length - 32) - 2);
        byte b5 = (byte) 106;
        byte b6 = (byte) 188;
        byte[] a4 = new C1356b(this.f4180j, this.f4187q).mo6707a(C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6715a(new byte[0], b5), f), a3), b6));
        C1358b.C1360b bVar3 = C1358b.f4157a;
        byte[] bArr5 = this.f4180j;
        byte[] a5 = bVar3.mo6717a(b4, (bArr5.length - 32) - 2, b4.length - ((bArr5.length - 32) - 2));
        byte[] a6 = C1358b.f4157a.mo6716a(a4, 24375);
        byte[] a7 = C1358b.f4157a.mo6716a(a5, 24376);
        byte[] a8 = C1358b.f4157a.mo6716a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(a6, a7), C1358b.f4157a.mo6716a(this.f4177g, 66)), 32545);
        m5271a(new byte[]{0, 34, b3, (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256}, C1358b.f4157a.mo6721b(C1358b.f4157a.mo6716a(new byte[]{65}, 128), C1358b.f4157a.mo6716a(new byte[]{this.f4189s}, 131)), (byte[]) null);
        m5271a(new byte[]{0, 42, 0, (byte) CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256}, a8, (byte[]) null);
        byte b7 = (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256;
        m5271a(new byte[]{0, 34, b3, b7}, C1358b.f4157a.mo6716a(b2, 131), (byte[]) null);
        byte b8 = (byte) 0;
        C1354a a9 = m5271a(new byte[]{b8, (byte) CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, b8, b8}, new byte[0], new byte[]{8});
        C1358b.C1360b bVar4 = C1358b.f4157a;
        byte[] d = bVar4.mo6727d(new byte[0], (bArr.length - 32) - 2);
        byte[] a10 = C1357c.f4156a.mo6708a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(new byte[0], d), this.f4184n), bArr4), a9.mo6698a()), this.f4185o), this.f4174d), this.f4175e), this.f4176f));
        byte[] a11 = new C1356b(bArr, bArr3).mo6707a(C1358b.f4157a.mo6715a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6715a(new byte[0], b5), d), a10), b6));
        byte b9 = (byte) 130;
        byte[] bArr6 = {0, b9, 0, 0};
        m5271a(bArr6, C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(new byte[0], bArr4), a11), (byte[]) null);
        m5271a(new byte[]{0, 34, 65, b7}, C1358b.f4157a.mo6721b(C1358b.f4157a.mo6716a(new byte[]{b9}, (int) CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA), C1358b.f4157a.mo6716a(new byte[]{(byte) 155}, 128)), (byte[]) null);
        byte[] d2 = C1358b.f4157a.mo6727d(new byte[0], 8);
        C1354a a12 = m5271a(new byte[]{0, (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 0, 0}, d2, (byte[]) null);
        byte[] a13 = C1358b.f4157a.mo6717a(a12.mo6698a(), 0, 8);
        byte[] a14 = new C1356b(this.f4186p, this.f4178h).mo6707a(C1358b.f4157a.mo6717a(a12.mo6698a(), 8, a12.mo6698a().length - 8));
        if (Byte.compare(a14[0], b5) == 0) {
            byte[] a15 = C1358b.f4157a.mo6717a(a14, 1, (a14.length - 32) - 2);
            byte[] a16 = C1358b.f4157a.mo6717a(a14, a15.length + 1, 32);
            if (!C3250h.m9055a((Object) C1358b.f4157a.mo6722c(C1357c.f4156a.mo6708a(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(new byte[0], a15), this.f4185o), a13), d2), this.f4184n), this.f4174d), this.f4175e), this.f4176f))), (Object) C1358b.f4157a.mo6722c(a16))) {
                throw new C1368b("Errore nell'autenticazione del chip (calcHashIFD,hashICC)");
            } else if (Byte.compare(a14[a14.length - 1], b6) == 0) {
                f4169B = C1358b.f4157a.mo6721b(C1358b.f4157a.mo6728e(a9.mo6698a(), 4), C1358b.f4157a.mo6728e(d2, 4));
            } else {
                throw new C1368b("Errore nell'autenticazione del chip AppUtil.byteCompare(intAuthResp[intAuthResp.length - 1],0xcb");
            }
        } else {
            throw new C1368b("Errore nell'autenticazione del chip- Byte.compare(intAuthResp[0], (byte)0x6a) != 0");
        }
    }

    /* renamed from: e */
    private final void m5283e() {
        C1373a.f4197a.mo6761a("dhKeyExchange()");
        byte[] bArr = new byte[0];
        do {
            bArr = C1358b.f4157a.mo6727d(bArr, this.f4176f.length);
        } while (C3250h.m9049a((int) this.f4176f[0], (int) bArr[0]) < 0);
        this.f4184n = new C1356b(this.f4175e, bArr).mo6707a((byte[]) this.f4174d.clone());
        byte[] b = C1358b.f4157a.mo6721b(C1358b.f4157a.mo6721b(C1358b.f4157a.mo6716a(new byte[]{(byte) 155}, 128), C1358b.f4157a.mo6716a(new byte[]{(byte) 129}, 131)), C1358b.f4157a.mo6716a(this.f4184n, (int) CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA));
        byte b2 = (byte) CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256;
        m5276b(new byte[]{0, 34, 65, b2}, b, (byte[]) null);
        C1363c a = C1363c.f4159a.mo6749a(m5276b(new byte[]{0, (byte) ParseException.EMAIL_TAKEN, 63, (byte) 255}, new byte[]{77, 4, b2, 2, (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 0}, (byte[]) null).mo6698a(), true);
        if (a == null) {
            C3250h.m9052a();
        }
        this.f4185o = a.mo6732a(0).mo6741b();
        byte[] a2 = new C1356b(this.f4175e, bArr).mo6707a(this.f4185o);
        this.f4182l = C1358b.f4157a.mo6729f(C1357c.f4156a.mo6708a(C1358b.f4157a.mo6721b(a2, new byte[]{0, 0, 0, 1})), 16);
        this.f4183m = C1358b.f4157a.mo6729f(C1357c.f4156a.mo6708a(C1358b.f4157a.mo6721b(a2, new byte[]{0, 0, 0, 2})), 16);
        f4169B = new byte[8];
        f4169B[7] = 1;
    }

    /* renamed from: f */
    private final void m5284f() {
        C1373a.f4197a.mo6761a("initExtAuthParam()");
        byte b = (byte) 255;
        byte[] bArr = {0, (byte) ParseException.EMAIL_TAKEN, 63, b};
        byte b2 = (byte) CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256;
        byte b3 = (byte) 160;
        C1363c a = C1363c.f4159a.mo6749a(m5276b(bArr, new byte[]{77, 9, 112, 7, b2, b3, 4, 3, Byte.MAX_VALUE, 73, (byte) 128}, (byte[]) null).mo6698a(), true);
        if (a == null) {
            C3250h.m9052a();
        }
        byte b4 = (byte) 129;
        this.f4180j = a.mo6732a(0).mo6732a(0).mo6733a(0, b4).mo6741b();
        this.f4181k = a.mo6732a(0).mo6732a(0).mo6733a(1, (byte) 130).mo6741b();
        byte b5 = (byte) 140;
        byte b6 = (byte) 220;
        byte b7 = (byte) 248;
        byte b8 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA;
        byte b9 = (byte) ParseException.ACCOUNT_ALREADY_LINKED;
        byte b10 = (byte) CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
        byte b11 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384;
        byte b12 = (byte) CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256;
        C1363c cVar = a;
        byte b13 = (byte) 141;
        byte b14 = (byte) 228;
        byte b15 = (byte) ParseException.PASSWORD_MISSING;
        byte b16 = (byte) 230;
        byte b17 = b13;
        byte b18 = (byte) 212;
        byte b19 = b6;
        byte b20 = (byte) 155;
        byte b21 = b3;
        byte b22 = (byte) 224;
        byte b23 = (byte) CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA;
        byte b24 = (byte) CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256;
        byte b25 = b23;
        byte b26 = (byte) CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256;
        byte b27 = b24;
        byte b28 = (byte) 227;
        byte b29 = b18;
        byte b30 = (byte) ParseException.UNSUPPORTED_SERVICE;
        byte b31 = b11;
        byte b32 = (byte) CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA;
        byte b33 = (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
        byte b34 = b33;
        byte b35 = (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256;
        byte b36 = (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA;
        byte b37 = b2;
        byte b38 = (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA;
        byte b39 = (byte) 231;
        byte b40 = (byte) 217;
        byte b41 = (byte) ParseException.LINKED_ID_MISSING;
        byte b42 = (byte) CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
        byte b43 = (byte) CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256;
        byte[] bArr2 = {24, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, ASN1Constants.UNIVERSAL_SET_TYPE, 72, b5, 37, b6, b7, 93, b8, 61, 54, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, (byte) 192, b9, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, (byte) CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 28, 106, b10, 69, b4, b11, 37, 79, 59, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 25, b12, (byte) 215, 44, (byte) ParseException.USERNAME_TAKEN, 62, 92, b6, 90, 30, 83, 22, 87, b13, 117, b8, 79, (byte) 247, 59, 35, 123, 83, 44, (byte) CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, b13, b14, b10, (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, b15, 17, 56, 90, 35, b16, 62, 51, b14, 126, b14, 94, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, (byte) 239, b18, b20, 24, b22, 44, b, (byte) 135, 89, b5, 57, Tnaf.POW_2_WIDTH, (byte) CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, b23, (byte) CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, b24, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, b26, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 36, (byte) CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, b28, b30, b11, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 93, (byte) ParseException.EMAIL_NOT_FOUND, b2, b32, b15, b12, b14, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 50, 26, (byte) 245, 59, 81, 125, 4, Tnaf.POW_2_WIDTH, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, b33, 10, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 123, b35, 15, b7, 19, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 52, 112, b16, b12, 0, b36, (byte) ParseException.SESSION_MISSING, b4, b9, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, (byte) 226, 4, b28, 81, (byte) CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, 58, b22, (byte) CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, b36, 125, (byte) 142, b38, b26, (byte) 253, 92, 10, 21, 35, 60, 52, (byte) CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 82, 21, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, b16, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 33, b12, (byte) Primes.SMALL_FACTOR_LIMIT, 52, b32, b39, 25, b38, (byte) 234, 36, 71, 59, 41, (byte) 241, 71, 95, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, b40, b35, 57, (byte) CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, (byte) 225, b20, b29, 116, b41, (byte) ParseException.INVALID_SESSION_TOKEN, b42, 30, b21, b19, (byte) 210, b30, 22, b15, b37, b41, 7, 27, (byte) 254, b43, (byte) CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 36, 21, 24, 72, 17, b43, b32, 95, b37, b28, b39, b42, (byte) 244, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 75, 60, b17, b41, b42, b40, 12, (byte) 236, b30, 94, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, b17, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 62, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 98, (byte) 198, 44, (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, b32, 52, 18, 113, 20, b20, b27, b34, 22, 46, (byte) 199, b9, b28, 70, b25, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, (byte) CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, b42, b31, 26, (byte) CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 126, 55, b37, b43};
        this.f4188r = bArr2;
        this.f4187q = this.f4188r;
        C1363c cVar2 = cVar;
        C1363c b44 = cVar2.mo6732a(0).mo6732a(0).mo6739b(new byte[]{95, 76});
        if (b44 == null) {
            C3250h.m9052a();
        }
        byte[] b45 = b44.mo6741b();
        C1363c b46 = cVar2.mo6732a(0).mo6732a(0).mo6739b(new byte[]{95, 32});
        if (b46 == null) {
            C3250h.m9052a();
        }
        this.f4177g = C1358b.f4157a.mo6724c(b46.mo6741b(), 4);
        this.f4179i = C1358b.f4157a.mo6729f(b45, 6);
    }

    /* renamed from: g */
    private final void m5285g() {
        C1373a.f4197a.mo6761a("initDHParam()");
        byte[] bArr = {0, (byte) ParseException.EMAIL_TAKEN, 63, (byte) 255};
        byte b = (byte) CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256;
        byte b2 = (byte) CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384;
        byte b3 = (byte) CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
        C1363c a = C1363c.f4159a.mo6749a(m5276b(bArr, new byte[]{77, 10, 112, 8, b, b2, 1, 4, b3, 2, (byte) CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 0}, (byte[]) null).mo6698a(), false);
        if (a == null) {
            C3250h.m9052a();
        }
        this.f4174d = a.mo6732a(0).mo6732a(0).mo6732a(0).mo6741b();
        C1363c a2 = C1363c.f4159a.mo6749a(m5276b(bArr, new byte[]{77, 10, 112, 8, b, b2, 1, 4, b3, 2, (byte) CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 0}, (byte[]) null).mo6698a(), false);
        if (a2 == null) {
            C3250h.m9052a();
        }
        this.f4175e = a2.mo6732a(0).mo6732a(0).mo6732a(0).mo6741b();
        C1363c a3 = C1363c.f4159a.mo6749a(m5276b(bArr, new byte[]{77, 10, 112, 8, b, b2, 1, 4, b3, 2, (byte) 153, 0}, (byte[]) null).mo6698a(), false);
        if (a3 == null) {
            C3250h.m9052a();
        }
        this.f4176f = a3.mo6732a(0).mo6732a(0).mo6732a(0).mo6741b();
    }

    /* renamed from: h */
    private final void m5286h() {
        C1373a.f4197a.mo6761a("readDappPubKey()");
        byte[] b = m5277b(4100);
        this.f4186p = new byte[0];
        if (!(!(this.f4178h.length == 0))) {
            C1363c a = C1363c.f4159a.mo6749a(b, false);
            if (a == null) {
                C3250h.m9052a();
            }
            byte[] b2 = a.mo6732a(0).mo6741b();
            while (true) {
                this.f4186p = b2;
                if (this.f4186p[0] != 0) {
                    break;
                }
                C1358b.C1360b bVar = C1358b.f4157a;
                byte[] bArr = this.f4186p;
                b2 = bVar.mo6717a(bArr, 1, bArr.length - 1);
            }
            byte[] b3 = a.mo6732a(1).mo6741b();
            while (true) {
                this.f4178h = b3;
                if (this.f4178h[0] == 0) {
                    C1358b.C1360b bVar2 = C1358b.f4157a;
                    byte[] bArr2 = this.f4178h;
                    b3 = bVar2.mo6717a(bArr2, 1, bArr2.length - 1);
                } else {
                    return;
                }
            }
        } else {
            throw new C1370d();
        }
    }

    /* renamed from: i */
    private final C1354a m5287i() {
        C1373a.f4197a.mo6761a("selectAidCie()");
        return m5276b(new byte[]{0, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 4, 12}, this.f4173c, (byte[]) null);
    }

    /* renamed from: j */
    private final C1354a m5288j() {
        C1373a.f4197a.mo6761a("selectAidIas()");
        return m5276b(new byte[]{0, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 4, 12}, this.f4196z, (byte[]) null);
    }

    /* renamed from: a */
    public final int mo6751a(@NotNull String str, @NotNull String str2) {
        C3250h.m9056b(str, "pin");
        C3250h.m9056b(str2, "newpin");
        C1373a.f4197a.mo6761a("changePin()");
        if (str.length() != 8) {
            throw new C1352d();
        } else if (str2.length() == 8) {
            C1358b.C1360b bVar = C1358b.f4157a;
            byte[] bytes = str.getBytes(C3275d.f7318a);
            C3250h.m9053a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] b = bVar.mo6721b(new byte[0], bytes);
            C1358b.C1360b bVar2 = C1358b.f4157a;
            byte[] bytes2 = str2.getBytes(C3275d.f7318a);
            C3250h.m9053a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
            C1354a a = m5271a(new byte[]{0, 36, 0, -127}, bVar2.mo6721b(b, bytes2), (byte[]) null);
            String c = C1358b.f4157a.mo6722c(a.mo6699b());
            if (C3278f.m9082a(c, "9000", true)) {
                return 0;
            }
            if (C3278f.m9082a(c, "ffc2", true)) {
                return 2;
            }
            if (C3278f.m9082a(c, "ffc1", true)) {
                return 1;
            }
            return a.mo6699b()[1] + (a.mo6699b()[0] * 256);
        } else {
            throw new C1352d();
        }
    }

    /* renamed from: a */
    public final void mo6752a() {
        m5288j();
        m5287i();
        m5285g();
        if (this.f4178h.length == 0) {
            m5286h();
        }
        m5284f();
        m5283e();
        m5282d();
    }

    /* renamed from: a */
    public final void mo6753a(@NotNull String str) {
        C3250h.m9056b(str, "pin");
        m5288j();
        m5287i();
        m5285g();
        if (this.f4178h.length == 0) {
            m5286h();
        }
        m5284f();
        m5283e();
        m5282d();
        int b = mo6755b(str);
        if (b >= 3) {
            return;
        }
        if (b == 0) {
            throw new C1349a();
        }
        throw new C1353e(b);
    }

    @Nullable
    /* renamed from: a */
    public final byte[] mo6754a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "dataToSign");
        C1373a.f4197a.mo6761a("sign()");
        m5271a(new byte[]{0, 34, 65, (byte) CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256}, C1358b.f4157a.mo6721b(C1358b.f4157a.mo6716a(new byte[]{2}, 128), C1358b.f4157a.mo6716a(new byte[]{this.f4192v}, (int) CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA)), (byte[]) null);
        return m5271a(new byte[]{0, (byte) CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 0, 0}, bArr, (byte[]) null).mo6698a();
    }

    /* renamed from: b */
    public final int mo6755b(@NotNull String str) {
        C3250h.m9056b(str, "pin");
        C1373a.f4197a.mo6761a("verifyPin()");
        if (str.length() == 8) {
            byte[] bArr = {0, 32, 0, this.f4190t};
            byte[] bytes = str.getBytes(C3275d.f7318a);
            C3250h.m9053a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            C1354a a = m5271a(bArr, bytes, (byte[]) null);
            String c = C1358b.f4157a.mo6722c(a.mo6699b());
            if (C3278f.m9082a(c, "9000", true)) {
                return 0;
            }
            if (C3278f.m9082a(c, "ffc2", true)) {
                return 2;
            }
            if (C3278f.m9082a(c, "ffc1", true)) {
                return 1;
            }
            return a.mo6699b()[1] + (a.mo6699b()[0] * 256);
        }
        throw new C1352d();
    }

    @NotNull
    /* renamed from: b */
    public final String mo6756b() {
        C1373a.f4197a.mo6761a("getIdServizi()");
        m5275b(C1361a.m5245a("00A4040C0DA0000000308000000009816001"));
        m5275b(C1361a.m5245a("00A4040406A00000000039"));
        m5275b(C1361a.m5245a("00a40204021001"));
        C1354a b = m5275b(C1361a.m5245a("00b000000c"));
        if (!(!C3250h.m9055a((Object) b.mo6700c(), (Object) "9000"))) {
            return C1358b.f4157a.mo6722c(b.mo6698a());
        }
        throw new C1351c();
    }

    /* renamed from: c */
    public final int mo6757c(@NotNull String str) {
        C3250h.m9056b(str, "puk");
        C1373a.f4197a.mo6761a("verifyPuk()");
        if (str.length() == 8) {
            byte[] bArr = {0, 32, 0, this.f4191u};
            byte[] bytes = str.getBytes(C3275d.f7318a);
            C3250h.m9053a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            C1354a a = m5271a(bArr, bytes, (byte[]) null);
            String c = C1358b.f4157a.mo6722c(a.mo6699b());
            if (C3278f.m9082a(c, "9000", true)) {
                return 0;
            }
            if (C3278f.m9082a(c, "ffc2", true)) {
                return 2;
            }
            if (C3278f.m9082a(c, "ffc1", true)) {
                return 1;
            }
            return a.mo6699b()[1] + (a.mo6699b()[0] * 256);
        }
        throw new C1352d();
    }

    @NotNull
    /* renamed from: c */
    public final byte[] mo6758c() {
        C1373a.f4197a.mo6761a("readCie()");
        return m5273a(4099);
    }

    /* renamed from: d */
    public final int mo6759d(@NotNull String str) {
        C3250h.m9056b(str, "pin");
        C1373a.f4197a.mo6761a("changePin()");
        if (str.length() == 8) {
            byte[] bArr = {0, 44, 2, this.f4190t};
            byte[] bytes = str.getBytes(C3275d.f7318a);
            C3250h.m9053a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            C1354a a = m5271a(bArr, bytes, (byte[]) null);
            if (C3278f.m9082a(C1358b.f4157a.mo6722c(a.mo6699b()), "9000", true)) {
                return 0;
            }
            return a.mo6699b()[1] + (a.mo6699b()[0] * 256);
        }
        throw new C1352d();
    }
}
