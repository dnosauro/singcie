package p066b.p067a.p068a.p072d;

import java.security.SecureRandom;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.crypto.tls.CipherSuite;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3256m;

/* renamed from: b.a.a.d.b */
public final class C1358b {

    /* renamed from: a */
    public static final C1360b f4157a = new C1360b((C3247e) null);

    /* renamed from: b.a.a.d.b$a */
    public static final class C1359a extends IllegalArgumentException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1359a(@NotNull String str) {
            super(str);
            C3250h.m9056b(str, "message");
        }
    }

    /* renamed from: b.a.a.d.b$b */
    public static final class C1360b {
        private C1360b() {
        }

        public /* synthetic */ C1360b(C3247e eVar) {
            this();
        }

        /* renamed from: a */
        public static /* synthetic */ void m5222a(C1360b bVar, byte[] bArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = bArr.length - 1;
            }
            bVar.mo6719b(bArr, i);
        }

        /* renamed from: a */
        public final int mo6709a(byte b) {
            return b & 255;
        }

        /* renamed from: a */
        public final int mo6710a(int i, int i2) {
            return Byte.compare((byte) i, (byte) i2);
        }

        /* renamed from: a */
        public final int mo6711a(@Nullable byte[] bArr) {
            if (bArr == null) {
                return 0;
            }
            byte b = 0;
            for (byte b2 : bArr) {
                b = (b << 8) | b2;
            }
            return b;
        }

        /* renamed from: a */
        public final boolean mo6712a(byte b, byte b2) {
            return Byte.compare(b, b2) == 0;
        }

        /* renamed from: a */
        public final boolean mo6713a(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
            C3250h.m9056b(bArr, "a");
            C3250h.m9056b(bArr2, "b");
            if (bArr.length == bArr2.length) {
                int length = bArr.length;
                for (int i = 0; i < length; i++) {
                    if (mo6712a(bArr[i], bArr2[i])) {
                        return false;
                    }
                }
            }
            return true;
        }

        @NotNull
        /* renamed from: a */
        public final byte[] mo6714a(int i) {
            return new byte[]{(byte) (i >>> 8), (byte) i};
        }

        @NotNull
        /* renamed from: a */
        public final byte[] mo6715a(@NotNull byte[] bArr, byte b) {
            C3250h.m9056b(bArr, "a");
            byte[] bArr2 = new byte[(bArr.length + 1)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = b;
            return bArr2;
        }

        @NotNull
        /* renamed from: a */
        public final byte[] mo6716a(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            C1360b bVar = this;
            byte[] d = bVar.mo6725d(i);
            byte[] c = bVar.mo6723c(bArr.length);
            byte[] bArr2 = new byte[(d.length + c.length + bArr.length)];
            System.arraycopy(d, 0, bArr2, 0, d.length);
            System.arraycopy(c, 0, bArr2, d.length, c.length);
            System.arraycopy(bArr, 0, bArr2, d.length + c.length, bArr.length);
            return bArr2;
        }

        @NotNull
        /* renamed from: a */
        public final byte[] mo6717a(@NotNull byte[] bArr, int i, int i2) {
            C3250h.m9056b(bArr, "array");
            if (Math.signum((float) i2) < ((float) 0)) {
                i2 &= 255;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            return bArr2;
        }

        /* renamed from: b */
        public final byte mo6718b(int i) {
            return (byte) (i & 255);
        }

        /* renamed from: b */
        public final void mo6719b(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            if (C3250h.m9049a((int) bArr[i], (int) (byte) 255) == 0) {
                bArr[i] = 0;
                mo6719b(bArr, i - 1);
                return;
            }
            bArr[i] = (byte) (bArr[i] + 1);
        }

        @NotNull
        /* renamed from: b */
        public final byte[] mo6720b(@NotNull byte[] bArr) {
            C3250h.m9056b(bArr, "data");
            byte[] bArr2 = new byte[(((bArr.length & 7) == 0 ? bArr.length : bArr.length - (bArr.length & 7)) + 8)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = (byte) 128;
            int length = bArr2.length;
            for (int length2 = bArr.length + 1; length2 < length; length2++) {
                bArr2[length2] = 0;
            }
            return bArr2;
        }

        @NotNull
        /* renamed from: b */
        public final byte[] mo6721b(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
            C3250h.m9056b(bArr, "a");
            C3250h.m9056b(bArr2, "b");
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        @NotNull
        /* renamed from: c */
        public final String mo6722c(@NotNull byte[] bArr) {
            C3250h.m9056b(bArr, "bytes");
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                C3256m mVar = C3256m.f7307a;
                Object[] objArr = {Byte.valueOf(bArr[i])};
                String format = String.format("%02x", Arrays.copyOf(objArr, objArr.length));
                C3250h.m9053a((Object) format, "java.lang.String.format(format, *args)");
                if (format != null) {
                    String upperCase = format.toUpperCase();
                    C3250h.m9053a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                    sb.append(upperCase);
                    i++;
                } else {
                    throw new C3266f("null cannot be cast to non-null type java.lang.String");
                }
            }
            String sb2 = sb.toString();
            C3250h.m9053a((Object) sb2, "sb.toString()");
            return sb2;
        }

        @NotNull
        /* renamed from: c */
        public final byte[] mo6723c(int i) {
            if (i < 128) {
                return new byte[]{(byte) i};
            } else if (i <= 255) {
                return new byte[]{(byte) 129, (byte) i};
            } else if (i <= 65535) {
                return new byte[]{(byte) 130, (byte) (i >> 8), (byte) (i & 255)};
            } else if (i <= 16777215) {
                return new byte[]{(byte) 131, (byte) (i >> 16), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            } else if (i <= -1) {
                return new byte[]{(byte) CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, (byte) (i >> 24), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            } else {
                throw new C1359a("dati troppo lunghi");
            }
        }

        @NotNull
        /* renamed from: c */
        public final byte[] mo6724c(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            byte[] bArr2 = new byte[(bArr.length - i)];
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            return bArr2;
        }

        @NotNull
        /* renamed from: d */
        public final byte[] mo6725d(int i) {
            if (i <= 255) {
                return new byte[]{mo6718b(i)};
            } else if (i <= 65535) {
                return new byte[]{(byte) (i >> 8), (byte) (i & 255)};
            } else if (i <= 16777215) {
                return new byte[]{(byte) (i >> 16), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            } else if (i <= -1) {
                return new byte[]{(byte) (i >> 24), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
            } else {
                throw new C1359a("tag troppo lungo");
            }
        }

        @NotNull
        /* renamed from: d */
        public final byte[] mo6726d(@NotNull byte[] bArr) {
            C3250h.m9056b(bArr, "data");
            int length = bArr.length - 1;
            while (length >= 0 && bArr[length] != ((byte) 128)) {
                if (bArr[length] == 0) {
                    length--;
                } else {
                    throw new C1359a("Padding ISO non presente");
                }
            }
            return mo6729f(bArr, length);
        }

        @NotNull
        /* renamed from: d */
        public final byte[] mo6727d(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            byte[] generateSeed = new SecureRandom().generateSeed(i);
            C3250h.m9053a((Object) generateSeed, "random.generateSeed(numByte)");
            return generateSeed;
        }

        @NotNull
        /* renamed from: e */
        public final byte[] mo6728e(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            if (i > bArr.length) {
                return (byte[]) bArr.clone();
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, bArr.length - i, bArr2, 0, i);
            return bArr2;
        }

        @NotNull
        /* renamed from: f */
        public final byte[] mo6729f(@NotNull byte[] bArr, int i) {
            C3250h.m9056b(bArr, "array");
            if (i > bArr.length) {
                return (byte[]) bArr.clone();
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }
}
