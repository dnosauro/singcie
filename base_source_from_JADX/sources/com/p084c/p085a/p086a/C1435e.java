package com.p084c.p085a.p086a;

import com.p084c.p085a.p086a.C1432c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p172io.IOUtils;
import org.slf4j.Logger;

/* renamed from: com.c.a.a.e */
public abstract class C1435e {

    /* renamed from: a */
    private final int f4282a;

    /* renamed from: b */
    private final int f4283b;

    /* renamed from: com.c.a.a.e$a */
    public static class C1437a extends C1435e {

        /* renamed from: a */
        private int f4284a;

        /* renamed from: b */
        private int f4285b;

        public C1437a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.f4284a = i3;
            this.f4285b = i4;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo6906a() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            String str2;
            if (stackTraceElement != null) {
                if (stackTraceElement.getLineNumber() < 0) {
                    str2 = String.format("%s#%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName()});
                } else {
                    str2 = String.format("%s#%s:%d", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
                }
                return C1448h.m5465b(str2, this.f4284a, this.f4285b);
            }
            throw new IllegalArgumentException("Caller not found");
        }
    }

    /* renamed from: com.c.a.a.e$b */
    public static class C1438b {

        /* renamed from: a */
        private String f4286a;

        /* renamed from: b */
        private int f4287b;

        /* renamed from: c */
        private List<C1439c> f4288c;

        /* renamed from: d */
        private final Pattern f4289d = Pattern.compile("%%");

        /* renamed from: e */
        private final Pattern f4290e = Pattern.compile("%n");

        /* renamed from: f */
        private final Pattern f4291f = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?level");

        /* renamed from: g */
        private final Pattern f4292g = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?logger(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");

        /* renamed from: h */
        private final Pattern f4293h = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?caller(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");

        /* renamed from: i */
        private final Pattern f4294i = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?source");

        /* renamed from: j */
        private final Pattern f4295j = Pattern.compile("%date(\\{(.*?)\\})?");

        /* renamed from: k */
        private final Pattern f4296k = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?\\(");

        /* renamed from: l */
        private final Pattern f4297l = Pattern.compile("%d(\\{(.*?)\\})?");

        /* renamed from: m */
        private final Pattern f4298m = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?p");

        /* renamed from: n */
        private final Pattern f4299n = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?c(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");

        /* renamed from: o */
        private final Pattern f4300o = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?C(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");

        /* renamed from: p */
        private final Pattern f4301p = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?s");

        /* renamed from: q */
        private final Pattern f4302q = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?thread");

        /* renamed from: r */
        private final Pattern f4303r = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?t");

        /* renamed from: a */
        private Matcher m5442a(Pattern pattern) {
            Matcher matcher = pattern.matcher(this.f4286a);
            if (!matcher.find(this.f4287b) || matcher.start() != this.f4287b) {
                return null;
            }
            return matcher;
        }

        /* renamed from: a */
        private void m5443a() {
            Matcher matcher;
            C1439c cVar;
            C1435e eVar;
            Matcher matcher2;
            C1439c cVar2;
            C1435e aVar;
            C1439c cVar3;
            C1443g gVar;
            Matcher a = m5442a(this.f4289d);
            if (a != null) {
                List<C1439c> list = this.f4288c;
                cVar3 = list.get(list.size() - 1);
                gVar = new C1443g(0, 0, "%");
            } else {
                a = m5442a(this.f4290e);
                if (a != null) {
                    List<C1439c> list2 = this.f4288c;
                    cVar3 = list2.get(list2.size() - 1);
                    gVar = new C1443g(0, 0, IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    Matcher a2 = m5442a(this.f4291f);
                    if (a2 == null && (a2 = m5442a(this.f4298m)) == null) {
                        Matcher a3 = m5442a(this.f4293h);
                        if (a3 == null && (a3 = m5442a(this.f4300o)) == null) {
                            Matcher a4 = m5442a(this.f4294i);
                            if (a4 == null && (a4 = m5442a(this.f4301p)) == null) {
                                matcher2 = m5442a(this.f4292g);
                                if (matcher2 == null && (matcher2 = m5442a(this.f4299n)) == null) {
                                    Matcher a5 = m5442a(this.f4295j);
                                    if (a5 == null && (a5 = m5442a(this.f4297l)) == null) {
                                        matcher = m5442a(this.f4302q);
                                        if (matcher == null && (matcher = m5442a(this.f4303r)) == null) {
                                            matcher = m5442a(this.f4296k);
                                            if (matcher != null) {
                                                this.f4288c.add(new C1439c(Integer.parseInt(matcher.group(1) == null ? "0" : matcher.group(1)), Integer.parseInt(matcher.group(3) == null ? "0" : matcher.group(3)), new ArrayList()));
                                                this.f4287b = matcher.end();
                                            }
                                            throw new IllegalArgumentException();
                                        }
                                        int parseInt = Integer.parseInt(matcher.group(1) == null ? "0" : matcher.group(1));
                                        int parseInt2 = Integer.parseInt(matcher.group(3) == null ? "0" : matcher.group(3));
                                        List<C1439c> list3 = this.f4288c;
                                        cVar = list3.get(list3.size() - 1);
                                        eVar = new C1445i(parseInt, parseInt2);
                                    } else {
                                        String group = matcher.group(2);
                                        List<C1439c> list4 = this.f4288c;
                                        cVar = list4.get(list4.size() - 1);
                                        eVar = new C1440d(0, 0, group);
                                    }
                                } else {
                                    int parseInt3 = Integer.parseInt(matcher2.group(1) == null ? "0" : matcher2.group(1));
                                    int parseInt4 = Integer.parseInt(matcher2.group(3) == null ? "0" : matcher2.group(3));
                                    int parseInt5 = Integer.parseInt(matcher2.group(5) == null ? "0" : matcher2.group(5));
                                    int parseInt6 = Integer.parseInt(matcher2.group(7) == null ? "0" : matcher2.group(7));
                                    List<C1439c> list5 = this.f4288c;
                                    cVar2 = list5.get(list5.size() - 1);
                                    aVar = new C1442f(parseInt3, parseInt4, parseInt5, parseInt6);
                                }
                            } else {
                                int parseInt7 = Integer.parseInt(matcher.group(1) == null ? "0" : matcher.group(1));
                                int parseInt8 = Integer.parseInt(matcher.group(3) == null ? "0" : matcher.group(3));
                                List<C1439c> list6 = this.f4288c;
                                cVar = list6.get(list6.size() - 1);
                                eVar = new C1444h(parseInt7, parseInt8);
                            }
                        } else {
                            int parseInt9 = Integer.parseInt(matcher2.group(1) == null ? "0" : matcher2.group(1));
                            int parseInt10 = Integer.parseInt(matcher2.group(3) == null ? "0" : matcher2.group(3));
                            int parseInt11 = Integer.parseInt(matcher2.group(5) == null ? "0" : matcher2.group(5));
                            int parseInt12 = Integer.parseInt(matcher2.group(7) == null ? "0" : matcher2.group(7));
                            List<C1439c> list7 = this.f4288c;
                            cVar2 = list7.get(list7.size() - 1);
                            aVar = new C1437a(parseInt9, parseInt10, parseInt11, parseInt12);
                        }
                        cVar2.mo6909a(aVar);
                        this.f4287b = matcher.end();
                    }
                    int parseInt13 = Integer.parseInt(matcher.group(1) == null ? "0" : matcher.group(1));
                    int parseInt14 = Integer.parseInt(matcher.group(3) == null ? "0" : matcher.group(3));
                    List<C1439c> list8 = this.f4288c;
                    cVar = list8.get(list8.size() - 1);
                    eVar = new C1441e(parseInt13, parseInt14);
                    cVar.mo6909a(eVar);
                    this.f4287b = matcher.end();
                }
            }
            cVar3.mo6909a(gVar);
            this.f4287b = matcher.end();
        }

        /* renamed from: a */
        public C1435e mo6908a(String str) {
            if (str == null) {
                return null;
            }
            this.f4287b = 0;
            this.f4286a = str;
            this.f4288c = new ArrayList();
            this.f4288c.add(new C1439c(0, 0, new ArrayList()));
            while (true) {
                int length = str.length();
                int i = this.f4287b;
                if (length <= i) {
                    break;
                }
                int indexOf = str.indexOf("%", i);
                int indexOf2 = str.indexOf(")", this.f4287b);
                if (this.f4288c.size() > 1 && indexOf2 < indexOf) {
                    List<C1439c> list = this.f4288c;
                    list.get(list.size() - 1).mo6909a(new C1443g(0, 0, str.substring(this.f4287b, indexOf2)));
                    List<C1439c> list2 = this.f4288c;
                    List<C1439c> list3 = this.f4288c;
                    list2.get(list2.size() - 2).mo6909a(list3.remove(list3.size() - 1));
                    this.f4287b = indexOf2 + 1;
                }
                if (indexOf == -1) {
                    List<C1439c> list4 = this.f4288c;
                    list4.get(list4.size() - 1).mo6909a(new C1443g(0, 0, str.substring(this.f4287b)));
                    break;
                }
                List<C1439c> list5 = this.f4288c;
                list5.get(list5.size() - 1).mo6909a(new C1443g(0, 0, str.substring(this.f4287b, indexOf)));
                this.f4287b = indexOf;
                m5443a();
            }
            return this.f4288c.get(0);
        }
    }

    /* renamed from: com.c.a.a.e$c */
    public static class C1439c extends C1435e {

        /* renamed from: a */
        private final List<C1435e> f4304a;

        public C1439c(int i, int i2, List<C1435e> list) {
            super(i, i2);
            this.f4304a = new ArrayList(list);
        }

        /* renamed from: a */
        public void mo6909a(C1435e eVar) {
            this.f4304a.add(eVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo6906a() {
            for (C1435e a : this.f4304a) {
                if (a.mo6906a()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            StringBuilder sb = new StringBuilder();
            for (C1435e a : this.f4304a) {
                sb.append(a.mo6905a(stackTraceElement, str, aVar));
            }
            return sb.toString();
        }
    }

    /* renamed from: com.c.a.a.e$d */
    public static class C1440d extends C1435e {

        /* renamed from: a */
        private final SimpleDateFormat f4305a;

        public C1440d(int i, int i2, String str) {
            super(i, i2);
            this.f4305a = str != null ? new SimpleDateFormat(str) : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            return this.f4305a.format(new Date());
        }
    }

    /* renamed from: com.c.a.a.e$e */
    public static class C1441e extends C1435e {
        public C1441e(int i, int i2) {
            super(i, i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            return aVar.toString();
        }
    }

    /* renamed from: com.c.a.a.e$f */
    public static class C1442f extends C1435e {

        /* renamed from: a */
        private int f4306a;

        /* renamed from: b */
        private int f4307b;

        public C1442f(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.f4306a = i3;
            this.f4307b = i4;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            return C1448h.m5465b(str, this.f4306a, this.f4307b);
        }
    }

    /* renamed from: com.c.a.a.e$g */
    public static class C1443g extends C1435e {

        /* renamed from: a */
        private final String f4308a;

        public C1443g(int i, int i2, String str) {
            super(i, i2);
            this.f4308a = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            return this.f4308a;
        }
    }

    /* renamed from: com.c.a.a.e$h */
    public static class C1444h extends C1435e {
        public C1444h(int i, int i2) {
            super(i, i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo6906a() {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            String format;
            if (stackTraceElement != null) {
                StringBuilder sb = new StringBuilder();
                if (stackTraceElement.isNativeMethod()) {
                    format = "(native)";
                } else if (stackTraceElement.getFileName() == null) {
                    format = "(unknown)";
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    format = String.format("(%s:%d)", new Object[]{stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())});
                } else {
                    format = String.format("(%s)", new Object[]{stackTraceElement.getFileName()});
                }
                sb.append(format);
                return sb.toString();
            }
            throw new IllegalArgumentException("Caller not found");
        }
    }

    /* renamed from: com.c.a.a.e$i */
    public static class C1445i extends C1435e {
        public C1445i(int i, int i2) {
            super(i, i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
            return Thread.currentThread().getName();
        }
    }

    private C1435e(int i, int i2) {
        this.f4282a = i;
        this.f4283b = i2;
    }

    /* renamed from: a */
    public static C1435e m5436a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new C1438b().mo6908a(str);
        } catch (Exception e) {
            C1434d.m5431a(Logger.ROOT_LOGGER_NAME).mo6895a((Throwable) e, "cannot parse pattern: '%s'", str);
            return new C1443g(0, 0, str);
        }
    }

    /* renamed from: a */
    public final String mo6905a(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar) {
        return C1448h.m5463a(mo6907b(stackTraceElement, str, aVar), this.f4282a, this.f4283b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6906a() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo6907b(StackTraceElement stackTraceElement, String str, C1432c.C1433a aVar);
}
