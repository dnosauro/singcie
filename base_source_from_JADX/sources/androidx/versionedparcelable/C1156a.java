package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.p018c.C0400a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.versionedparcelable.a */
public abstract class C1156a {

    /* renamed from: a */
    protected final C0400a<String, Method> f3626a;

    /* renamed from: b */
    protected final C0400a<String, Method> f3627b;

    /* renamed from: c */
    protected final C0400a<String, Class> f3628c;

    public C1156a(C0400a<String, Method> aVar, C0400a<String, Method> aVar2, C0400a<String, Class> aVar3) {
        this.f3626a = aVar;
        this.f3627b = aVar2;
        this.f3628c = aVar3;
    }

    /* renamed from: a */
    private Method m4541a(Class cls) {
        Method method = this.f3627b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class b = m4542b((Class<? extends C1158c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = b.getDeclaredMethod("write", new Class[]{cls, C1156a.class});
        this.f3627b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* renamed from: b */
    private Class m4542b(Class<? extends C1158c> cls) {
        Class cls2 = this.f3628c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f3628c.put(cls.getName(), cls3);
        return cls3;
    }

    /* renamed from: b */
    private Method m4543b(String str) {
        Method method = this.f3626a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, C1156a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{C1156a.class});
        this.f3626a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* renamed from: b */
    private void m4544b(C1158c cVar) {
        try {
            mo6223a(m4542b((Class<? extends C1158c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C1158c> T mo6213a(String str, C1156a aVar) {
        try {
            return (C1158c) m4543b(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6214a(int i);

    /* renamed from: a */
    public void mo6215a(int i, int i2) {
        mo6241c(i2);
        mo6214a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6216a(Parcelable parcelable);

    /* renamed from: a */
    public void mo6217a(Parcelable parcelable, int i) {
        mo6241c(i);
        mo6216a(parcelable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6218a(C1158c cVar) {
        if (cVar == null) {
            mo6223a((String) null);
            return;
        }
        m4544b(cVar);
        C1156a c = mo6240c();
        mo6220a(cVar, c);
        c.mo6236b();
    }

    /* renamed from: a */
    public void mo6219a(C1158c cVar, int i) {
        mo6241c(i);
        mo6218a(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C1158c> void mo6220a(T t, C1156a aVar) {
        try {
            m4541a((Class) t.getClass()).invoke((Object) null, new Object[]{t, aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6221a(CharSequence charSequence);

    /* renamed from: a */
    public void mo6222a(CharSequence charSequence, int i) {
        mo6241c(i);
        mo6221a(charSequence);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6223a(String str);

    /* renamed from: a */
    public void mo6224a(String str, int i) {
        mo6241c(i);
        mo6223a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6225a(boolean z);

    /* renamed from: a */
    public void mo6226a(boolean z, int i) {
        mo6241c(i);
        mo6225a(z);
    }

    /* renamed from: a */
    public void mo6227a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6228a(byte[] bArr);

    /* renamed from: a */
    public void mo6229a(byte[] bArr, int i) {
        mo6241c(i);
        mo6228a(bArr);
    }

    /* renamed from: a */
    public boolean mo6230a() {
        return false;
    }

    /* renamed from: b */
    public int mo6231b(int i, int i2) {
        return !mo6237b(i2) ? i : mo6242d();
    }

    /* renamed from: b */
    public <T extends Parcelable> T mo6232b(T t, int i) {
        return !mo6237b(i) ? t : mo6246h();
    }

    /* renamed from: b */
    public <T extends C1158c> T mo6233b(T t, int i) {
        return !mo6237b(i) ? t : mo6248j();
    }

    /* renamed from: b */
    public CharSequence mo6234b(CharSequence charSequence, int i) {
        return !mo6237b(i) ? charSequence : mo6245g();
    }

    /* renamed from: b */
    public String mo6235b(String str, int i) {
        return !mo6237b(i) ? str : mo6243e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo6236b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo6237b(int i);

    /* renamed from: b */
    public boolean mo6238b(boolean z, int i) {
        return !mo6237b(i) ? z : mo6247i();
    }

    /* renamed from: b */
    public byte[] mo6239b(byte[] bArr, int i) {
        return !mo6237b(i) ? bArr : mo6244f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract C1156a mo6240c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo6241c(int i);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract int mo6242d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract String mo6243e();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract byte[] mo6244f();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract CharSequence mo6245g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract <T extends Parcelable> T mo6246h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract boolean mo6247i();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public <T extends C1158c> T mo6248j() {
        String e = mo6243e();
        if (e == null) {
            return null;
        }
        return mo6213a(e, mo6240c());
    }
}
