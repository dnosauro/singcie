package com.cyberneid.p089b.p096g;

/* renamed from: com.cyberneid.b.g.b */
class C1580b {

    /* renamed from: a */
    static final C1581a f4762a = C1581a.STRING;

    /* renamed from: b */
    static final C1581a f4763b = C1581a.NAME;

    /* renamed from: c */
    static final C1581a f4764c = C1581a.LITERAL;

    /* renamed from: d */
    static final C1581a f4765d = C1581a.REAL;

    /* renamed from: e */
    static final C1581a f4766e = C1581a.INTEGER;

    /* renamed from: f */
    static final C1581a f4767f = C1581a.START_ARRAY;

    /* renamed from: g */
    static final C1581a f4768g = C1581a.END_ARRAY;

    /* renamed from: h */
    static final C1581a f4769h = C1581a.START_PROC;

    /* renamed from: i */
    static final C1581a f4770i = C1581a.END_PROC;

    /* renamed from: j */
    static final C1581a f4771j = C1581a.CHARSTRING;

    /* renamed from: k */
    private String f4772k;

    /* renamed from: l */
    private byte[] f4773l;

    /* renamed from: m */
    private final C1581a f4774m;

    /* renamed from: com.cyberneid.b.g.b$a */
    enum C1581a {
        NONE,
        STRING,
        NAME,
        LITERAL,
        REAL,
        INTEGER,
        START_ARRAY,
        END_ARRAY,
        START_PROC,
        END_PROC,
        CHARSTRING
    }

    C1580b(char c, C1581a aVar) {
        this.f4772k = Character.toString(c);
        this.f4774m = aVar;
    }

    C1580b(String str, C1581a aVar) {
        this.f4772k = str;
        this.f4774m = aVar;
    }

    C1580b(byte[] bArr, C1581a aVar) {
        this.f4773l = bArr;
        this.f4774m = aVar;
    }

    /* renamed from: a */
    public String mo7375a() {
        return this.f4772k;
    }

    /* renamed from: b */
    public C1581a mo7376b() {
        return this.f4774m;
    }

    /* renamed from: c */
    public int mo7377c() {
        return (int) Float.parseFloat(this.f4772k);
    }

    /* renamed from: d */
    public float mo7378d() {
        return Float.parseFloat(this.f4772k);
    }

    /* renamed from: e */
    public boolean mo7379e() {
        return this.f4772k.equals("true");
    }

    /* renamed from: f */
    public byte[] mo7380f() {
        return this.f4773l;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.f4774m == f4771j) {
            sb = new StringBuilder();
            sb.append("Token[kind=CHARSTRING, data=");
            sb.append(this.f4773l.length);
            str = " bytes]";
        } else {
            sb = new StringBuilder();
            sb.append("Token[kind=");
            sb.append(this.f4774m);
            sb.append(", text=");
            sb.append(this.f4772k);
            str = "]";
        }
        sb.append(str);
        return sb.toString();
    }
}
