package p076c.p078b;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

/* renamed from: c.b.i */
public class C1404i implements C1398d {

    /* renamed from: a */
    private String f4209a;

    /* renamed from: b */
    private Vector<C1398d> f4210b = new Vector<>(10);

    public C1404i() {
    }

    public C1404i(Class<?> cls) {
        m5337b(cls);
    }

    public C1404i(String str) {
        mo6865b(str);
    }

    /* renamed from: a */
    public static C1398d m5331a(Class<?> cls, String str) {
        String str2;
        StringBuilder sb;
        String str3;
        Object obj;
        try {
            Constructor<?> a = m5334a(cls);
            try {
                if (a.getParameterTypes().length == 0) {
                    obj = a.newInstance(new Object[0]);
                    if (obj instanceof C1399e) {
                        ((C1399e) obj).mo6843c(str);
                    }
                } else {
                    obj = a.newInstance(new Object[]{str});
                }
                return (C1398d) obj;
            } catch (InstantiationException e) {
                e = e;
                sb = new StringBuilder();
                str3 = "Cannot instantiate test case: ";
                sb.append(str3);
                sb.append(str);
                sb.append(" (");
                sb.append(m5333a(e));
                sb.append(")");
                str2 = sb.toString();
                return m5332a(str2);
            } catch (InvocationTargetException e2) {
                sb = new StringBuilder();
                sb.append("Exception in constructor: ");
                sb.append(str);
                sb.append(" (");
                e = e2.getTargetException();
                sb.append(m5333a(e));
                sb.append(")");
                str2 = sb.toString();
                return m5332a(str2);
            } catch (IllegalAccessException e3) {
                e = e3;
                sb = new StringBuilder();
                str3 = "Cannot access test case: ";
                sb.append(str3);
                sb.append(str);
                sb.append(" (");
                sb.append(m5333a(e));
                sb.append(")");
                str2 = sb.toString();
                return m5332a(str2);
            }
        } catch (NoSuchMethodException unused) {
            str2 = "Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()";
            return m5332a(str2);
        }
    }

    /* renamed from: a */
    public static C1398d m5332a(final String str) {
        return new C1399e("warning") {
            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void mo6842c() {
                m5311b(str);
            }
        };
    }

    /* renamed from: a */
    private static String m5333a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static Constructor<?> m5334a(Class<?> cls) {
        try {
            return cls.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    /* renamed from: a */
    private void m5335a(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (!list.contains(name)) {
            if (m5336a(method)) {
                list.add(name);
                mo6862a(m5331a(cls, name));
            } else if (m5338b(method)) {
                mo6862a(m5332a("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
            }
        }
    }

    /* renamed from: a */
    private boolean m5336a(Method method) {
        return m5338b(method) && Modifier.isPublic(method.getModifiers());
    }

    /* renamed from: b */
    private void m5337b(Class<?> cls) {
        StringBuilder sb;
        String str;
        this.f4209a = cls.getName();
        try {
            m5334a(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                sb = new StringBuilder();
                sb.append("Class ");
                sb.append(cls.getName());
                str = " is not public";
                sb.append(str);
                mo6862a(m5332a(sb.toString()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; C1398d.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method a : MethodSorter.getDeclaredMethods(cls2)) {
                    m5335a(a, arrayList, cls);
                }
            }
            if (this.f4210b.size() == 0) {
                mo6862a(m5332a("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            sb = new StringBuilder();
            sb.append("Class ");
            sb.append(cls.getName());
            str = " has no public constructor TestCase(String name) or TestCase()";
        }
    }

    /* renamed from: b */
    private boolean m5338b(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    /* renamed from: a */
    public int mo6835a() {
        Iterator<C1398d> it = this.f4210b.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().mo6835a();
        }
        return i;
    }

    /* renamed from: a */
    public C1398d mo6861a(int i) {
        return this.f4210b.get(i);
    }

    /* renamed from: a */
    public void mo6862a(C1398d dVar) {
        this.f4210b.add(dVar);
    }

    /* renamed from: a */
    public void mo6863a(C1398d dVar, C1402h hVar) {
        dVar.mo6838b(hVar);
    }

    /* renamed from: b */
    public String mo6864b() {
        return this.f4209a;
    }

    /* renamed from: b */
    public void mo6838b(C1402h hVar) {
        Iterator<C1398d> it = this.f4210b.iterator();
        while (it.hasNext()) {
            C1398d next = it.next();
            if (!hVar.mo6859a()) {
                mo6863a(next, hVar);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void mo6865b(String str) {
        this.f4209a = str;
    }

    /* renamed from: c */
    public int mo6866c() {
        return this.f4210b.size();
    }

    public String toString() {
        return mo6864b() != null ? mo6864b() : super.toString();
    }
}
