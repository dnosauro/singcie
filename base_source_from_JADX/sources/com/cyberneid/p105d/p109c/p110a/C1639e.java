package com.cyberneid.p105d.p109c.p110a;

import com.parse.ParseException;
import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.io.IOException;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.signers.PSSSigner;

/* renamed from: com.cyberneid.d.c.a.e */
public final class C1639e {

    /* renamed from: o */
    private static final int[] f5417o = {0, 1, 3, 7, 15, 31, 63, CertificateBody.profileType, 255};

    /* renamed from: p */
    private static final int[] f5418p = {0, 128, 192, 224, 240, 248, ParseException.UNSUPPORTED_SERVICE, 254, 255};

    /* renamed from: q */
    private static final byte[] f5419q = {0, Byte.MIN_VALUE, 64, -64, 32, -96, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -32, Tnaf.POW_2_WIDTH, -112, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -48, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -80, 112, -16, 8, -120, 72, -56, 40, Filter.FILTER_TYPE_APPROXIMATE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -24, 24, -104, 88, -40, 56, -72, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -8, 4, -124, 68, -60, 36, Filter.FILTER_TYPE_SUBSTRING, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -28, 20, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, 44, -84, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -20, 28, -100, 92, -36, 60, PSSSigner.TRAILER_IMPLICIT, 124, -4, 2, MatchingRule.SUBSTRING_TYPE_SUBFINAL, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -62, 34, Filter.FILTER_TYPE_NOT, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -54, 42, -86, 106, -22, 26, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, Filter.FILTER_TYPE_LESS_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -18, 30, -98, 94, -34, 62, -66, 126, -2, 1, -127, 65, -63, 33, Filter.FILTER_TYPE_OR, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, -31, 17, -111, 81, -47, ASN1Constants.UNIVERSAL_SET_TYPE, -79, 113, -15, 9, -119, 73, -55, 41, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -23, 25, -103, 89, -39, 57, -71, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -7, 5, -123, 69, -59, 37, Filter.FILTER_TYPE_GREATER_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -29, 19, -109, 83, -45, 51, -77, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -13, 11, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, 75, -53, 43, -85, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -21, 27, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -25, 23, -105, 87, -41, 55, -73, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -9, 15, -113, 79, -49, 47, -81, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -17, 31, -97, 95, -33, 63, -65, Byte.MAX_VALUE, -1};

    /* renamed from: r */
    private static final short[] f5420r = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};

    /* renamed from: s */
    private static final short[] f5421s = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};

    /* renamed from: t */
    private static final short[] f5422t = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};

    /* renamed from: u */
    private static final short[] f5423u = {292, 260, 226, 226};

    /* renamed from: v */
    private static final short[] f5424v = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};

    /* renamed from: w */
    private static final byte[] f5425w = {LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 88, 23, 71, 30, 30, 62, 62, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};

    /* renamed from: a */
    private int f5426a;

    /* renamed from: b */
    private int f5427b;

    /* renamed from: c */
    private byte[] f5428c;

    /* renamed from: d */
    private int f5429d;

    /* renamed from: e */
    private int f5430e;

    /* renamed from: f */
    private int f5431f;

    /* renamed from: g */
    private int f5432g = 0;

    /* renamed from: h */
    private int[] f5433h;

    /* renamed from: i */
    private int[] f5434i;

    /* renamed from: j */
    private int f5435j = 0;

    /* renamed from: k */
    private int f5436k = 2;

    /* renamed from: l */
    private int f5437l = 0;

    /* renamed from: m */
    private int f5438m = 0;

    /* renamed from: n */
    private int f5439n;

    public C1639e(int i, int i2, int i3) {
        this.f5431f = i;
        this.f5429d = i2;
        this.f5430e = i3;
        this.f5426a = 0;
        this.f5427b = 0;
        int i4 = i2 + 1;
        this.f5433h = new int[i4];
        this.f5434i = new int[i4];
    }

    /* renamed from: a */
    private int m6574a() {
        boolean z = true;
        int i = 0;
        while (z) {
            int a = m6575a(10);
            short s = f5420r[a];
            short s2 = s & 1;
            int i2 = (s >>> 1) & 15;
            if (i2 == 12) {
                short s3 = f5421s[m6579b(2) | ((a << 2) & 12)];
                i += (s3 >>> 4) & 4095;
                m6581c(4 - ((s3 >>> 1) & 7));
            } else if (i2 == 0) {
                throw new IOException("TIFFFaxDecoder: Invalid code encountered.");
            } else if (i2 != 15) {
                i += (s >>> 5) & 2047;
                m6581c(10 - i2);
                if (s2 == 0) {
                    z = false;
                }
            } else {
                throw new IOException("TIFFFaxDecoder: EOL encountered in white run.");
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m6575a(int r12) {
        /*
            r11 = this;
            byte[] r0 = r11.f5428c
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r11.f5427b
            int r4 = r11.f5431f
            r5 = 2
            r6 = 0
            if (r4 != r2) goto L_0x0024
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0014
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            goto L_0x004d
        L_0x0014:
            int r7 = r3 + 1
            if (r7 != r1) goto L_0x001b
            byte r0 = r0[r7]
            goto L_0x0012
        L_0x001b:
            byte r1 = r0[r7]
            int r3 = r3 + r5
            byte r0 = r0[r3]
        L_0x0020:
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x004d
        L_0x0024:
            if (r4 != r5) goto L_0x0091
            byte[] r4 = f5419q
            byte r7 = r0[r3]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r4[r7]
            if (r3 != r1) goto L_0x0032
            r4 = r7
            goto L_0x0011
        L_0x0032:
            int r8 = r3 + 1
            if (r8 != r1) goto L_0x003e
            byte r0 = r0[r8]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0012
        L_0x003e:
            byte r1 = r0[r8]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r4[r1]
            int r3 = r3 + r5
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0020
        L_0x004d:
            int r3 = r11.f5426a
            r5 = 8
            int r3 = 8 - r3
            int r12 = r12 - r3
            if (r12 <= r5) goto L_0x005c
            int r7 = r12 + -8
            r8 = r7
            r7 = 8
            goto L_0x005e
        L_0x005c:
            r7 = r12
            r8 = 0
        L_0x005e:
            int r9 = r11.f5427b
            int r9 = r9 + r2
            r11.f5427b = r9
            int[] r9 = f5417o
            r3 = r9[r3]
            r3 = r3 & r4
            int r12 = r3 << r12
            int[] r3 = f5418p
            r4 = r3[r7]
            r0 = r0 & r4
            int r4 = 8 - r7
            int r0 = r0 >>> r4
            if (r8 == 0) goto L_0x0083
            int r0 = r0 << r8
            r3 = r3[r8]
            r1 = r1 & r3
            int r5 = r5 - r8
            int r1 = r1 >>> r5
            r0 = r0 | r1
            int r1 = r11.f5427b
            int r1 = r1 + r2
            r11.f5427b = r1
            r11.f5426a = r8
            goto L_0x008f
        L_0x0083:
            if (r7 != r5) goto L_0x008d
            r11.f5426a = r6
            int r1 = r11.f5427b
            int r1 = r1 + r2
            r11.f5427b = r1
            goto L_0x008f
        L_0x008d:
            r11.f5426a = r7
        L_0x008f:
            r12 = r12 | r0
            return r12
        L_0x0091:
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = "TIFFFaxDecoder: TIFF_FILL_ORDER tag must be either 1 or 2."
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p109c.p110a.C1639e.m6575a(int):int");
    }

    /* renamed from: a */
    private void m6576a(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.f5433h;
        int i2 = this.f5432g;
        int i3 = this.f5435j;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & -2 : i4 | 1;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.f5435j = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    /* renamed from: a */
    private void m6577a(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b = (byte) (b | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    /* renamed from: b */
    private int m6578b() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = f5422t[m6579b(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & 2047;
            if (i3 == 100) {
                short s2 = f5424v[m6575a(9)];
                short s3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                int i5 = (s2 >>> 5) & 2047;
                if (i4 == 12) {
                    m6581c(5);
                    short s4 = f5421s[m6579b(4)];
                    i += (s4 >>> 4) & 4095;
                    m6581c(4 - ((s4 >>> 1) & 7));
                } else if (i4 != 15) {
                    i += i5;
                    m6581c(9 - i4);
                    if (s3 != 0) {
                    }
                } else {
                    throw new IOException("TIFFFaxDecoder: EOL encountered in black run.");
                }
            } else if (i3 == 200) {
                short s5 = f5423u[m6579b(2)];
                i += (s5 >>> 5) & 2047;
                m6581c(2 - ((s5 >>> 1) & 15));
            } else {
                i += i3;
                m6581c(4 - i2);
            }
            z = true;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m6579b(int r10) {
        /*
            r9 = this;
            byte[] r0 = r9.f5428c
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r9.f5427b
            int r4 = r9.f5431f
            r5 = 0
            if (r4 != r2) goto L_0x0016
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x002d
        L_0x0012:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            goto L_0x002d
        L_0x0016:
            r6 = 2
            if (r4 != r6) goto L_0x0065
            byte[] r4 = f5419q
            byte r6 = r0[r3]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r4[r6]
            if (r3 != r1) goto L_0x0025
            r4 = r6
            goto L_0x0010
        L_0x0025:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r6
        L_0x002d:
            int r1 = r9.f5426a
            r3 = 8
            int r6 = 8 - r1
            int r7 = r10 - r6
            int r8 = r6 - r10
            if (r8 < 0) goto L_0x004e
            int[] r0 = f5417o
            r0 = r0[r6]
            r0 = r0 & r4
            int r0 = r0 >>> r8
            int r1 = r1 + r10
            r9.f5426a = r1
            int r10 = r9.f5426a
            if (r10 != r3) goto L_0x0064
            r9.f5426a = r5
            int r10 = r9.f5427b
            int r10 = r10 + r2
            r9.f5427b = r10
            goto L_0x0064
        L_0x004e:
            int[] r10 = f5417o
            r10 = r10[r6]
            r10 = r10 & r4
            int r1 = -r8
            int r10 = r10 << r1
            int[] r1 = f5418p
            r1 = r1[r7]
            r0 = r0 & r1
            int r3 = r3 - r7
            int r0 = r0 >>> r3
            r0 = r0 | r10
            int r10 = r9.f5427b
            int r10 = r10 + r2
            r9.f5427b = r10
            r9.f5426a = r7
        L_0x0064:
            return r0
        L_0x0065:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r0 = "TIFFFaxDecoder: TIFF_FILL_ORDER tag must be either 1 or 2."
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p109c.p110a.C1639e.m6579b(int):int");
    }

    /* renamed from: c */
    private int m6580c() {
        int a;
        int i = this.f5438m;
        if (i == 0) {
            if (m6575a(12) != 1) {
                throw new IOException("TIFFFaxDecoder: Scanline must begin with EOL.");
            }
        } else if (i == 1) {
            int i2 = 8 - this.f5426a;
            if (m6575a(i2) != 0) {
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            } else if (i2 >= 4 || m6575a(8) == 0) {
                do {
                    a = m6575a(8);
                    if (a != 1) {
                    }
                } while (a == 0);
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            } else {
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            }
        }
        if (this.f5439n == 0) {
            return 1;
        }
        return m6579b(1);
    }

    /* renamed from: c */
    private void m6581c(int i) {
        int i2 = this.f5426a - i;
        if (i2 < 0) {
            this.f5427b--;
            i2 += 8;
        }
        this.f5426a = i2;
    }

    /* renamed from: d */
    private boolean m6582d() {
        if (this.f5426a != 0) {
            this.f5427b++;
            this.f5426a = 0;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r12.f5436k == 2) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        m6582d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0119, code lost:
        if (r12.f5436k == 2) goto L_0x006e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7678a(byte[] r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 0
            r12.f5432g = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            int r3 = r12.f5429d
            if (r15 >= r3) goto L_0x011d
        L_0x0009:
            r3 = 12
            r4 = 2
            r5 = 15
            r6 = 4
            if (r2 == 0) goto L_0x0066
            r7 = 10
            int r8 = r12.m6575a(r7)
            short[] r9 = f5420r
            short r9 = r9[r8]
            r10 = r9 & 1
            int r11 = r9 >>> 1
            r11 = r11 & r5
            if (r11 != r3) goto L_0x003b
            int r4 = r12.m6579b(r4)
            int r5 = r8 << 2
            r3 = r3 & r5
            r3 = r3 | r4
            short[] r4 = f5421s
            short r3 = r4[r3]
            int r4 = r3 >>> 1
            r4 = r4 & 7
            int r3 = r3 >>> r6
            r3 = r3 & 4095(0xfff, float:5.738E-42)
            int r15 = r15 + r3
            int r6 = r6 - r4
            r12.m6581c(r6)
            goto L_0x0009
        L_0x003b:
            if (r11 == 0) goto L_0x005e
            if (r11 == r5) goto L_0x0056
            int r3 = r9 >>> 5
            r3 = r3 & 2047(0x7ff, float:2.868E-42)
            int r15 = r15 + r3
            int r7 = r7 - r11
            r12.m6581c(r7)
            if (r10 != 0) goto L_0x0009
            int[] r2 = r12.f5434i
            int r3 = r12.f5432g
            int r4 = r3 + 1
            r12.f5432g = r4
            r2[r3] = r15
            r2 = 0
            goto L_0x0009
        L_0x0056:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "TIFFFaxDecoder: EOL encountered in white run."
            r13.<init>(r14)
            throw r13
        L_0x005e:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "TIFFFaxDecoder: Invalid code encountered."
            r13.<init>(r14)
            throw r13
        L_0x0066:
            int r7 = r12.f5429d
            if (r15 != r7) goto L_0x0073
            int r13 = r12.f5436k
            if (r13 != r4) goto L_0x011d
        L_0x006e:
            r12.m6582d()
            goto L_0x011d
        L_0x0073:
            if (r2 != 0) goto L_0x0113
            int r7 = r12.m6579b(r6)
            short[] r8 = f5422t
            short r7 = r8[r7]
            int r8 = r7 >>> 1
            r8 = r8 & r5
            r9 = 5
            int r7 = r7 >>> r9
            r7 = r7 & 2047(0x7ff, float:2.868E-42)
            r10 = 100
            if (r7 != r10) goto L_0x00d7
            r7 = 9
            int r8 = r12.m6575a(r7)
            short[] r10 = f5424v
            short r8 = r10[r8]
            r10 = r8 & 1
            int r11 = r8 >>> 1
            r11 = r11 & r5
            int r8 = r8 >>> r9
            r8 = r8 & 2047(0x7ff, float:2.868E-42)
            if (r11 != r3) goto L_0x00b8
            r12.m6581c(r9)
            int r7 = r12.m6579b(r6)
            short[] r8 = f5421s
            short r7 = r8[r7]
            int r8 = r7 >>> 1
            r8 = r8 & 7
            int r7 = r7 >>> r6
            r7 = r7 & 4095(0xfff, float:5.738E-42)
            r12.m6577a(r13, r14, r15, r7)
            int r15 = r15 + r7
            int r7 = 4 - r8
            r12.m6581c(r7)
            goto L_0x0073
        L_0x00b8:
            if (r11 == r5) goto L_0x00cf
            r12.m6577a(r13, r14, r15, r8)
            int r15 = r15 + r8
            int r7 = r7 - r11
            r12.m6581c(r7)
            if (r10 != 0) goto L_0x0073
            int[] r2 = r12.f5434i
            int r7 = r12.f5432g
            int r8 = r7 + 1
            r12.f5432g = r8
            r2[r7] = r15
            goto L_0x0110
        L_0x00cf:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "TIFFFaxDecoder: EOL encountered in black run."
            r13.<init>(r14)
            throw r13
        L_0x00d7:
            r2 = 200(0xc8, float:2.8E-43)
            if (r7 != r2) goto L_0x00fd
            int r2 = r12.m6579b(r4)
            short[] r7 = f5423u
            short r2 = r7[r2]
            int r7 = r2 >>> 5
            r7 = r7 & 2047(0x7ff, float:2.868E-42)
            int r2 = r2 >>> r1
            r2 = r2 & r5
            r12.m6577a(r13, r14, r15, r7)
            int r15 = r15 + r7
            int r2 = 2 - r2
            r12.m6581c(r2)
            int[] r2 = r12.f5434i
            int r7 = r12.f5432g
            int r8 = r7 + 1
            r12.f5432g = r8
            r2[r7] = r15
            goto L_0x0110
        L_0x00fd:
            r12.m6577a(r13, r14, r15, r7)
            int r15 = r15 + r7
            int r2 = 4 - r8
            r12.m6581c(r2)
            int[] r2 = r12.f5434i
            int r7 = r12.f5432g
            int r8 = r7 + 1
            r12.f5432g = r8
            r2[r7] = r15
        L_0x0110:
            r2 = 1
            goto L_0x0073
        L_0x0113:
            int r3 = r12.f5429d
            if (r15 != r3) goto L_0x0005
            int r13 = r12.f5436k
            if (r13 != r4) goto L_0x011d
            goto L_0x006e
        L_0x011d:
            int[] r13 = r12.f5434i
            int r14 = r12.f5432g
            int r0 = r14 + 1
            r12.f5432g = r0
            r13[r14] = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p109c.p110a.C1639e.mo7678a(byte[], int, int):void");
    }

    /* renamed from: a */
    public void mo7679a(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int i3;
        byte[] bArr3 = bArr;
        int i4 = i;
        this.f5428c = bArr2;
        this.f5436k = 3;
        int i5 = 0;
        this.f5426a = 0;
        this.f5427b = 0;
        int i6 = (this.f5429d + 7) / 8;
        int[] iArr = new int[2];
        this.f5439n = (int) (j & 1);
        char c = 1;
        this.f5437l = (int) ((j & 2) >> 1);
        this.f5438m = (int) ((j & 4) >> 2);
        if (m6580c() == 1) {
            mo7678a(bArr3, 0, i4);
            int i7 = i6 + 0;
            int i8 = 1;
            int i9 = i2;
            while (i8 < i9) {
                if (m6580c() == 0) {
                    int[] iArr2 = this.f5433h;
                    this.f5433h = this.f5434i;
                    this.f5434i = iArr2;
                    this.f5435j = i5;
                    int i10 = i4;
                    boolean z = true;
                    int i11 = 0;
                    int i12 = -1;
                    while (i10 < this.f5429d) {
                        m6576a(i12, z, iArr);
                        int i13 = iArr[i5];
                        i12 = iArr[c];
                        byte b = f5425w[m6579b(7)] & 255;
                        int i14 = (b & LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE) >>> 3;
                        byte b2 = b & 7;
                        if (i14 == 0) {
                            if (!z) {
                                m6577a(bArr3, i7, i10, i12 - i10);
                            }
                            m6581c(7 - b2);
                            i10 = i12;
                        } else if (i14 == 1) {
                            m6581c(7 - b2);
                            if (z) {
                                int a = i10 + m6574a();
                                int i15 = i11 + 1;
                                this.f5434i[i11] = a;
                                int b3 = m6578b();
                                m6577a(bArr3, i7, a, b3);
                                i10 = a + b3;
                                i3 = i15 + 1;
                                this.f5434i[i15] = i10;
                            } else {
                                int b4 = m6578b();
                                m6577a(bArr3, i7, i10, b4);
                                int i16 = i10 + b4;
                                int i17 = i11 + 1;
                                this.f5434i[i11] = i16;
                                i10 = i16 + m6574a();
                                i3 = i17 + 1;
                                this.f5434i[i17] = i10;
                            }
                            i11 = i3;
                            i12 = i10;
                        } else if (i14 <= 8) {
                            int i18 = i13 + (i14 - 5);
                            int i19 = i11 + 1;
                            this.f5434i[i11] = i18;
                            if (!z) {
                                m6577a(bArr3, i7, i10, i18 - i10);
                            }
                            z = !z;
                            m6581c(7 - b2);
                            i10 = i18;
                            i12 = i10;
                            i11 = i19;
                        } else {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 3 compressed data.");
                        }
                        i5 = 0;
                        c = 1;
                    }
                    this.f5434i[i11] = i10;
                    this.f5432g = i11 + 1;
                } else {
                    mo7678a(bArr3, i7, i4);
                }
                i7 += i6;
                i8++;
                i5 = 0;
                c = 1;
            }
            return;
        }
        throw new IOException("TIFFFaxDecoder: First scanline must be 1D encoded.");
    }

    /* renamed from: a */
    public synchronized void mo7680a(byte[] bArr, byte[] bArr2, int i, int i2, long j, boolean z) {
        byte b;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        byte[] bArr3 = bArr;
        synchronized (this) {
            this.f5428c = bArr2;
            this.f5436k = 4;
            int i6 = 0;
            this.f5426a = 0;
            this.f5427b = 0;
            byte b2 = 7;
            int i7 = (this.f5429d + 7) / 8;
            int[] iArr = new int[2];
            int i8 = 1;
            this.f5437l = (int) ((j & 2) >> 1);
            int[] iArr2 = this.f5434i;
            this.f5432g = 0;
            int i9 = this.f5432g;
            this.f5432g = i9 + 1;
            iArr2[i9] = this.f5429d;
            int i10 = this.f5432g;
            this.f5432g = i10 + 1;
            iArr2[i10] = this.f5429d;
            int i11 = i2;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                if (z && this.f5426a != 0) {
                    this.f5426a = i6;
                    this.f5427b += i8;
                }
                int[] iArr3 = this.f5433h;
                this.f5433h = this.f5434i;
                this.f5434i = iArr3;
                this.f5435j = i6;
                int i14 = i;
                int i15 = -1;
                boolean z4 = true;
                int i16 = 0;
                while (i14 < this.f5429d) {
                    m6576a(i15, z4, iArr);
                    int i17 = iArr[i6];
                    int i18 = iArr[i8];
                    byte b3 = f5425w[m6579b(b)] & 255;
                    int[] iArr4 = iArr;
                    int i19 = (b3 & LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE) >>> 3;
                    byte b4 = b3 & b;
                    if (i19 == 0) {
                        if (!z4) {
                            m6577a(bArr3, i13, i14, i18 - i14);
                        }
                        m6581c(7 - b4);
                        i14 = i18;
                        i15 = i14;
                    } else {
                        if (i19 == 1) {
                            m6581c(7 - b4);
                            if (z4) {
                                int a = i14 + m6574a();
                                int i20 = i16 + 1;
                                iArr3[i16] = a;
                                int b5 = m6578b();
                                m6577a(bArr3, i13, a, b5);
                                i4 = a + b5;
                                i5 = i20 + 1;
                                iArr3[i20] = i4;
                            } else {
                                int b6 = m6578b();
                                m6577a(bArr3, i13, i14, b6);
                                int i21 = i14 + b6;
                                int i22 = i16 + 1;
                                iArr3[i16] = i21;
                                i4 = i21 + m6574a();
                                i5 = i22 + 1;
                                iArr3[i22] = i4;
                            }
                            i16 = i5;
                            i15 = i4;
                        } else if (i19 <= 8) {
                            i15 = i17 + (i19 - 5);
                            int i23 = i16 + 1;
                            iArr3[i16] = i15;
                            if (!z4) {
                                m6577a(bArr3, i13, i14, i15 - i14);
                            }
                            z4 = !z4;
                            m6581c(7 - b4);
                            i16 = i23;
                        } else if (i19 != 11) {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 4 compressed data.");
                        } else if (m6579b(3) == b) {
                            boolean z5 = false;
                            int i24 = 0;
                            while (!z5) {
                                while (m6579b(1) != 1) {
                                    i24++;
                                }
                                if (i24 > 5) {
                                    i24 -= 6;
                                    if (!z4 && i24 > 0) {
                                        iArr3[i16] = i14;
                                        i16++;
                                    }
                                    i14 += i24;
                                    if (i24 > 0) {
                                        i3 = 1;
                                        z4 = true;
                                    } else {
                                        i3 = 1;
                                    }
                                    if (m6579b(i3) == 0) {
                                        if (!z4) {
                                            iArr3[i16] = i14;
                                            i16++;
                                        }
                                        z3 = true;
                                    } else {
                                        if (z4) {
                                            iArr3[i16] = i14;
                                            i16++;
                                        }
                                        z3 = false;
                                    }
                                    z5 = true;
                                }
                                if (i24 == 5) {
                                    if (!z4) {
                                        iArr3[i16] = i14;
                                        i16++;
                                    }
                                    i14 += i24;
                                    b = 7;
                                    z2 = true;
                                } else {
                                    int i25 = i14 + i24;
                                    iArr3[i16] = i25;
                                    m6577a(bArr3, i13, i25, 1);
                                    i14 = i25 + 1;
                                    i16++;
                                    b = 7;
                                    z2 = false;
                                }
                            }
                        } else {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 4 compressed data.");
                        }
                        i14 = i15;
                    }
                    iArr = iArr4;
                    i6 = 0;
                    i8 = 1;
                }
                int[] iArr5 = iArr;
                if (iArr3.length == i16) {
                    break;
                }
                iArr3[i16] = i14;
                this.f5432g = i16 + 1;
                i13 += i7;
                i12++;
                iArr = iArr5;
                i6 = 0;
                b2 = 7;
                i8 = 1;
            }
        }
    }
}
