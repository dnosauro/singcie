package com.cyberneid.p105d.p131h.p132a;

import com.cyberneid.p105d.p131h.C1933a;
import com.unboundid.ldap.protocol.LDAPMessage;

/* renamed from: com.cyberneid.d.h.a.c */
public final class C1937c {

    /* renamed from: a */
    private static final C1934a<C1936b> f6135a = new C1934a<>();

    static {
        f6135a.mo8474a(C1936b.UNKNOWN);
        f6135a.mo8475a(C1936b.JPEG, new byte[]{-1, -40});
        f6135a.mo8475a(C1936b.TIFF, "II".getBytes(C1933a.f6111d), new byte[]{42, 0});
        f6135a.mo8475a(C1936b.TIFF, "MM".getBytes(C1933a.f6111d), new byte[]{0, 42});
        f6135a.mo8475a(C1936b.PSD, "8BPS".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.PNG, new byte[]{-119, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82});
        f6135a.mo8475a(C1936b.BMP, "BM".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.GIF, "GIF87a".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.GIF, "GIF89a".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.ICO, new byte[]{0, 0, 1, 0});
        f6135a.mo8475a(C1936b.PCX, new byte[]{10, 0, 1});
        f6135a.mo8475a(C1936b.PCX, new byte[]{10, 2, 1});
        f6135a.mo8475a(C1936b.PCX, new byte[]{10, 3, 1});
        f6135a.mo8475a(C1936b.PCX, new byte[]{10, 5, 1});
        f6135a.mo8475a(C1936b.RIFF, "RIFF".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.CRW, "II".getBytes(C1933a.f6111d), new byte[]{26, 0, 0, 0}, "HEAPCCDR".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.CR2, "II".getBytes(C1933a.f6111d), new byte[]{42, 0, Tnaf.POW_2_WIDTH, 0, 0, 0, 67, 82});
        f6135a.mo8475a(C1936b.NEF, "MM".getBytes(C1933a.f6111d), new byte[]{0, 42, 0, 0, 0, Byte.MIN_VALUE, 0});
        f6135a.mo8475a(C1936b.ORF, "IIRO".getBytes(C1933a.f6111d), new byte[]{8, 0});
        f6135a.mo8475a(C1936b.ORF, "IIRS".getBytes(C1933a.f6111d), new byte[]{8, 0});
        f6135a.mo8475a(C1936b.RAF, "FUJIFILMCCD-RAW".getBytes(C1933a.f6111d));
        f6135a.mo8475a(C1936b.RW2, "II".getBytes(C1933a.f6111d), new byte[]{85, 0});
    }

    /* renamed from: a */
    public static C1936b m7977a(byte[] bArr) {
        return f6135a.mo8473a(bArr);
    }
}
