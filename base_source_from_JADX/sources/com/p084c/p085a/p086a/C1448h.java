package com.p084c.p085a.p086a;

import org.apache.commons.p172io.FilenameUtils;

/* renamed from: com.c.a.a.h */
public final class C1448h {

    /* renamed from: a */
    private static final String f4315a = C1432c.class.getPackage().getName();

    /* renamed from: b */
    private static final C1450a f4316b = new C1450a();

    /* renamed from: com.c.a.a.h$a */
    private static final class C1450a extends SecurityManager {
        private C1450a() {
        }
    }

    /* renamed from: a */
    public static StackTraceElement m5461a() {
        return m5464b();
    }

    /* renamed from: a */
    private static String m5462a(String str, int i) {
        int length;
        String substring;
        if (str == null) {
            return null;
        }
        if (i == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        if (i > 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= str.length()) {
                    break;
                }
                int indexOf = str.indexOf(46, i3);
                if (indexOf == -1) {
                    length = sb.length();
                    substring = str.substring(i3, str.length());
                    break;
                } else if (i2 == i) {
                    length = sb.length();
                    substring = str.substring(i3, indexOf);
                    break;
                } else {
                    int i4 = indexOf + 1;
                    sb.insert(sb.length(), str.substring(i3, i4));
                    i2++;
                    i3 = i4;
                }
            }
            sb.insert(length, substring);
        } else if (i < 0) {
            String a = m5462a(str, -i);
            if (str.equals(a)) {
                sb.insert(sb.length(), str.substring(str.lastIndexOf(46) + 1, str.length()));
            } else {
                return str.replaceFirst(a + FilenameUtils.EXTENSION_SEPARATOR, "");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5463a(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (Math.abs(i2) < str.length()) {
            str = i2 < 0 ? str.substring(str.length() + i2, str.length()) : i2 > 0 ? str.substring(0, i2) : str;
        }
        if (Math.abs(i) <= str.length()) {
            return str;
        }
        return String.format("%" + i + "s", new Object[]{str});
    }

    /* renamed from: b */
    private static StackTraceElement m5464b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!z) {
                if (stackTraceElement.getClassName().startsWith(f4315a)) {
                    z = true;
                }
            } else if (!stackTraceElement.getClassName().startsWith(f4315a)) {
                return stackTraceElement;
            }
        }
        return stackTrace[stackTrace.length - 1];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        r3.insert(r3.length(), '*');
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m5465b(java.lang.String r8, int r9, int r10) {
        /*
            java.lang.String r8 = m5462a(r8, r9)
            if (r8 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            if (r10 != 0) goto L_0x000b
            return r8
        L_0x000b:
            int r9 = r8.length()
            if (r10 <= r9) goto L_0x0012
            return r8
        L_0x0012:
            r9 = -1
            r0 = 46
            r1 = 42
            r2 = 0
            if (r10 >= 0) goto L_0x006c
            int r10 = -r10
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r8.length()
            int r4 = r4 + -1
        L_0x0026:
            if (r4 <= 0) goto L_0x0067
            int r5 = r8.lastIndexOf(r0, r4)
            if (r5 != r9) goto L_0x0045
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x003e
            int r6 = r3.length()
            int r6 = r6 + r4
            int r6 = r6 + 1
            if (r6 <= r10) goto L_0x003e
            goto L_0x0057
        L_0x003e:
            int r4 = r4 + 1
            java.lang.String r4 = r8.substring(r2, r4)
            goto L_0x0061
        L_0x0045:
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x005b
            int r6 = r3.length()
            int r7 = r4 + 1
            int r7 = r7 - r5
            int r6 = r6 + r7
            int r6 = r6 + 1
            if (r6 <= r10) goto L_0x005b
        L_0x0057:
            r3.insert(r2, r1)
            goto L_0x0067
        L_0x005b:
            int r4 = r4 + 1
            java.lang.String r4 = r8.substring(r5, r4)
        L_0x0061:
            r3.insert(r2, r4)
            int r4 = r5 + -1
            goto L_0x0026
        L_0x0067:
            java.lang.String r8 = r3.toString()
            return r8
        L_0x006c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0071:
            int r4 = r8.length()
            if (r2 >= r4) goto L_0x00b5
            int r4 = r8.indexOf(r0, r2)
            if (r4 != r9) goto L_0x009b
            int r9 = r3.length()
            if (r9 <= 0) goto L_0x008b
        L_0x0083:
            int r8 = r3.length()
            r3.insert(r8, r1)
            goto L_0x00b5
        L_0x008b:
            int r9 = r3.length()
            int r10 = r8.length()
            java.lang.String r8 = r8.substring(r2, r10)
            r3.insert(r9, r8)
            goto L_0x00b5
        L_0x009b:
            int r5 = r3.length()
            if (r5 <= 0) goto L_0x00a6
            int r5 = r4 + 1
            if (r5 <= r10) goto L_0x00a6
            goto L_0x0083
        L_0x00a6:
            int r5 = r3.length()
            int r4 = r4 + 1
            java.lang.String r2 = r8.substring(r2, r4)
            r3.insert(r5, r2)
            r2 = r4
            goto L_0x0071
        L_0x00b5:
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p084c.p085a.p086a.C1448h.m5465b(java.lang.String, int, int):java.lang.String");
    }
}
