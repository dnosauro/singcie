package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzekc {
    DOUBLE(0, zzeke.SCALAR, zzeku.DOUBLE),
    FLOAT(1, zzeke.SCALAR, zzeku.FLOAT),
    INT64(2, zzeke.SCALAR, zzeku.LONG),
    UINT64(3, zzeke.SCALAR, zzeku.LONG),
    INT32(4, zzeke.SCALAR, zzeku.INT),
    FIXED64(5, zzeke.SCALAR, zzeku.LONG),
    FIXED32(6, zzeke.SCALAR, zzeku.INT),
    BOOL(7, zzeke.SCALAR, zzeku.BOOLEAN),
    STRING(8, zzeke.SCALAR, zzeku.STRING),
    MESSAGE(9, zzeke.SCALAR, zzeku.MESSAGE),
    BYTES(10, zzeke.SCALAR, zzeku.BYTE_STRING),
    UINT32(11, zzeke.SCALAR, zzeku.INT),
    ENUM(12, zzeke.SCALAR, zzeku.ENUM),
    SFIXED32(13, zzeke.SCALAR, zzeku.INT),
    SFIXED64(14, zzeke.SCALAR, zzeku.LONG),
    SINT32(15, zzeke.SCALAR, zzeku.INT),
    SINT64(16, zzeke.SCALAR, zzeku.LONG),
    GROUP(17, zzeke.SCALAR, zzeku.MESSAGE),
    DOUBLE_LIST(18, zzeke.VECTOR, zzeku.DOUBLE),
    FLOAT_LIST(19, zzeke.VECTOR, zzeku.FLOAT),
    INT64_LIST(20, zzeke.VECTOR, zzeku.LONG),
    UINT64_LIST(21, zzeke.VECTOR, zzeku.LONG),
    INT32_LIST(22, zzeke.VECTOR, zzeku.INT),
    FIXED64_LIST(23, zzeke.VECTOR, zzeku.LONG),
    FIXED32_LIST(24, zzeke.VECTOR, zzeku.INT),
    BOOL_LIST(25, zzeke.VECTOR, zzeku.BOOLEAN),
    STRING_LIST(26, zzeke.VECTOR, zzeku.STRING),
    MESSAGE_LIST(27, zzeke.VECTOR, zzeku.MESSAGE),
    BYTES_LIST(28, zzeke.VECTOR, zzeku.BYTE_STRING),
    UINT32_LIST(29, zzeke.VECTOR, zzeku.INT),
    ENUM_LIST(30, zzeke.VECTOR, zzeku.ENUM),
    SFIXED32_LIST(31, zzeke.VECTOR, zzeku.INT),
    SFIXED64_LIST(32, zzeke.VECTOR, zzeku.LONG),
    SINT32_LIST(33, zzeke.VECTOR, zzeku.INT),
    SINT64_LIST(34, zzeke.VECTOR, zzeku.LONG),
    DOUBLE_LIST_PACKED(35, zzeke.PACKED_VECTOR, zzeku.DOUBLE),
    FLOAT_LIST_PACKED(36, zzeke.PACKED_VECTOR, zzeku.FLOAT),
    INT64_LIST_PACKED(37, zzeke.PACKED_VECTOR, zzeku.LONG),
    UINT64_LIST_PACKED(38, zzeke.PACKED_VECTOR, zzeku.LONG),
    INT32_LIST_PACKED(39, zzeke.PACKED_VECTOR, zzeku.INT),
    FIXED64_LIST_PACKED(40, zzeke.PACKED_VECTOR, zzeku.LONG),
    FIXED32_LIST_PACKED(41, zzeke.PACKED_VECTOR, zzeku.INT),
    BOOL_LIST_PACKED(42, zzeke.PACKED_VECTOR, zzeku.BOOLEAN),
    UINT32_LIST_PACKED(43, zzeke.PACKED_VECTOR, zzeku.INT),
    ENUM_LIST_PACKED(44, zzeke.PACKED_VECTOR, zzeku.ENUM),
    SFIXED32_LIST_PACKED(45, zzeke.PACKED_VECTOR, zzeku.INT),
    SFIXED64_LIST_PACKED(46, zzeke.PACKED_VECTOR, zzeku.LONG),
    SINT32_LIST_PACKED(47, zzeke.PACKED_VECTOR, zzeku.INT),
    SINT64_LIST_PACKED(48, zzeke.PACKED_VECTOR, zzeku.LONG),
    GROUP_LIST(49, zzeke.VECTOR, zzeku.MESSAGE),
    MAP(50, zzeke.MAP, zzeku.VOID);
    
    private static final zzekc[] zzimy = null;
    private static final Type[] zzimz = null;

    /* renamed from: id */
    private final int f6899id;
    private final zzeku zzimu;
    private final zzeke zzimv;
    private final Class<?> zzimw;
    private final boolean zzimx;

    static {
        int i;
        zzimz = new Type[0];
        zzekc[] values = values();
        zzimy = new zzekc[values.length];
        for (zzekc zzekc : values) {
            zzimy[zzekc.f6899id] = zzekc;
        }
    }

    private zzekc(int i, zzeke zzeke, zzeku zzeku) {
        Class<?> zzbis;
        this.f6899id = i;
        this.zzimv = zzeke;
        this.zzimu = zzeku;
        switch (zzekb.zzikt[zzeke.ordinal()]) {
            case 1:
            case 2:
                zzbis = zzeku.zzbis();
                break;
            default:
                zzbis = null;
                break;
        }
        this.zzimw = zzbis;
        boolean z = false;
        if (zzeke == zzeke.SCALAR) {
            switch (zzekb.zziku[zzeku.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzimx = z;
    }

    /* renamed from: id */
    public final int mo15664id() {
        return this.f6899id;
    }
}
