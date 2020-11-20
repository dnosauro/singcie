package com.cyberneid.p089b.p096g;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.commons.p172io.IOUtils;

/* renamed from: com.cyberneid.b.g.e */
class C1584e {

    /* renamed from: a */
    private final ByteBuffer f4823a;

    /* renamed from: b */
    private C1580b f4824b;

    /* renamed from: c */
    private int f4825c = 0;

    C1584e(byte[] bArr) {
        this.f4823a = ByteBuffer.wrap(bArr);
        this.f4824b = m6239a((C1580b) null);
    }

    /* renamed from: a */
    private C1580b m6238a(int i) {
        this.f4823a.get();
        byte[] bArr = new byte[i];
        this.f4823a.get(bArr);
        return new C1580b(bArr, C1580b.f4771j);
    }

    /* renamed from: a */
    private C1580b m6239a(C1580b bVar) {
        boolean z;
        do {
            z = false;
            while (this.f4823a.hasRemaining()) {
                char c = m6240c();
                if (c == '%') {
                    m6243f();
                } else if (c == '(') {
                    return m6244g();
                } else {
                    if (c == ')') {
                        throw new IOException("unexpected closing parenthesis");
                    } else if (c == '[') {
                        return new C1580b(c, C1580b.f4767f);
                    } else {
                        if (c == '{') {
                            return new C1580b(c, C1580b.f4769h);
                        }
                        if (c == ']') {
                            return new C1580b(c, C1580b.f4768g);
                        }
                        if (c == '}') {
                            return new C1580b(c, C1580b.f4770i);
                        }
                        if (c == '/') {
                            return new C1580b(m6242e(), C1580b.f4764c);
                        }
                        if (!Character.isWhitespace(c)) {
                            if (c == 0) {
                                Log.w("PdfBox-Android", "NULL byte in font, skipped");
                            } else {
                                ByteBuffer byteBuffer = this.f4823a;
                                byteBuffer.position(byteBuffer.position() - 1);
                                C1580b d = m6241d();
                                if (d != null) {
                                    return d;
                                }
                                String e = m6242e();
                                if (e == null) {
                                    throw new C1579a("Could not read token at position " + this.f4823a.position());
                                } else if (!e.equals("RD") && !e.equals("-|")) {
                                    return new C1580b(e, C1580b.f4763b);
                                } else {
                                    if (bVar.mo7376b() == C1580b.f4766e) {
                                        return m6238a(bVar.mo7377c());
                                    }
                                    throw new IOException("expected INTEGER before -| or RD");
                                }
                            }
                        }
                        z = true;
                    }
                }
            }
        } while (z);
        return null;
    }

    /* renamed from: c */
    private char m6240c() {
        return (char) this.f4823a.get();
    }

    /* renamed from: d */
    private C1580b m6241d() {
        StringBuilder sb;
        char c;
        this.f4823a.mark();
        StringBuilder sb2 = new StringBuilder();
        char c2 = m6240c();
        boolean z = false;
        if (c2 == '+' || c2 == '-') {
            sb2.append(c2);
            c2 = m6240c();
        }
        while (Character.isDigit(c2)) {
            sb2.append(c2);
            c2 = m6240c();
            z = true;
        }
        if (c2 == '.') {
            sb2.append(c2);
            c = m6240c();
            sb = null;
        } else if (c2 == '#') {
            sb = sb2;
            sb2 = new StringBuilder();
            c = m6240c();
        } else {
            if (sb2.length() != 0 && z) {
                ByteBuffer byteBuffer = this.f4823a;
                byteBuffer.position(byteBuffer.position() - 1);
                return new C1580b(sb2.toString(), C1580b.f4766e);
            }
            this.f4823a.reset();
            return null;
        }
        if (Character.isDigit(c)) {
            do {
                sb2.append(c);
                c = m6240c();
            } while (Character.isDigit(c));
            if (c == 'E') {
                sb2.append(c);
                char c3 = m6240c();
                if (c3 == '-') {
                    sb2.append(c3);
                    c3 = m6240c();
                }
                if (Character.isDigit(c3)) {
                    do {
                        sb2.append(c3);
                        c3 = m6240c();
                    } while (Character.isDigit(c3));
                }
            }
            ByteBuffer byteBuffer2 = this.f4823a;
            byteBuffer2.position(byteBuffer2.position() - 1);
            return sb != null ? new C1580b(Integer.valueOf(Integer.parseInt(sb2.toString(), Integer.parseInt(sb.toString()))).toString(), C1580b.f4766e) : new C1580b(sb2.toString(), C1580b.f4765d);
        }
        this.f4823a.reset();
        return null;
    }

    /* renamed from: e */
    private String m6242e() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!this.f4823a.hasRemaining()) {
                break;
            }
            this.f4823a.mark();
            char c = m6240c();
            if (Character.isWhitespace(c) || c == '(' || c == ')' || c == '<' || c == '>' || c == '[' || c == ']' || c == '{' || c == '}' || c == '/' || c == '%') {
                this.f4823a.reset();
            } else {
                sb.append(c);
            }
        }
        this.f4823a.reset();
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            return null;
        }
        return sb2;
    }

    /* renamed from: f */
    private String m6243f() {
        char c;
        StringBuilder sb = new StringBuilder();
        while (this.f4823a.hasRemaining() && (c = m6240c()) != 13 && c != 10) {
            sb.append(c);
        }
        return sb.toString();
    }

    /* renamed from: g */
    private C1580b m6244g() {
        StringBuilder sb = new StringBuilder();
        while (this.f4823a.hasRemaining()) {
            char c = m6240c();
            char c2 = '(';
            if (c == '(') {
                this.f4825c++;
                sb.append('(');
            } else if (c != ')') {
                if (c == '\\') {
                    char c3 = m6240c();
                    if (c3 == '\\') {
                        sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    } else if (c3 != 'b') {
                        if (c3 == 'f') {
                            c2 = 12;
                        } else if (c3 == 'n' || c3 == 'r') {
                            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                        } else if (c3 != 't') {
                            switch (c3) {
                                case '(':
                                    break;
                                case ')':
                                    sb.append(')');
                                    break;
                            }
                        } else {
                            c2 = 9;
                        }
                        sb.append(c2);
                    } else {
                        sb.append(8);
                    }
                    if (Character.isDigit(c3)) {
                        c = (char) Integer.valueOf(Integer.parseInt(String.valueOf(new char[]{c3, m6240c(), m6240c()}), 8)).intValue();
                    } else {
                        continue;
                    }
                } else if (c == 13 || c == 10) {
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                sb.append(c);
            } else if (this.f4825c == 0) {
                return new C1580b(sb.toString(), C1580b.f4762a);
            } else {
                sb.append(')');
                this.f4825c--;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1580b mo7385a() {
        C1580b bVar = this.f4824b;
        this.f4824b = m6239a(bVar);
        return bVar;
    }

    /* renamed from: b */
    public C1580b mo7386b() {
        return this.f4824b;
    }
}
