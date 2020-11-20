package com.cyberneid.disigon.p134b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.disigon.b.c */
public final class C2079c {

    /* renamed from: a */
    private StorageManager f6502a;

    /* renamed from: b */
    private ActivityManager f6503b;

    /* renamed from: c */
    private Context f6504c;

    public C2079c(Context context) {
        this.f6504c = context;
        this.f6502a = (StorageManager) context.getSystemService("storage");
        this.f6503b = (ActivityManager) context.getSystemService("activity");
    }

    /* renamed from: a */
    private String m8283a(Object obj) {
        Field declaredField = obj.getClass().getDeclaredField("mPath");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        return C2097f.m8316b() ? ((File) obj2).toString() : (String) obj2;
    }

    /* renamed from: a */
    private String m8284a(Object obj, boolean z) {
        if (z) {
            Field declaredField = obj.getClass().getDeclaredField("mDescriptionId");
            declaredField.setAccessible(true);
            return this.f6504c.getResources().getString(declaredField.getInt(obj));
        }
        Field declaredField2 = obj.getClass().getDeclaredField("mDescription");
        declaredField2.setAccessible(true);
        return (String) declaredField2.get(obj);
    }

    /* renamed from: b */
    private String m8285b(Object obj) {
        if (!C2097f.m8319d() && C2097f.m8314a()) {
            try {
                return m8284a(obj, true);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return m8284a(obj, false);
    }

    /* renamed from: c */
    private String m8286c(Object obj) {
        if (!C2097f.m8318c()) {
            return "";
        }
        Field declaredField = obj.getClass().getDeclaredField("mUserLabel");
        declaredField.setAccessible(true);
        String str = (String) declaredField.get(obj);
        return TextUtils.isEmpty(str) ? m8285b(obj) : str;
    }

    /* renamed from: d */
    private boolean m8287d(Object obj) {
        Field declaredField = obj.getClass().getDeclaredField("mPrimary");
        declaredField.setAccessible(true);
        return declaredField.getBoolean(obj);
    }

    /* renamed from: e */
    private boolean m8288e(Object obj) {
        if (!C2097f.m8316b()) {
            return false;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("mEmulated");
            declaredField.setAccessible(true);
            return declaredField.getBoolean(obj);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public List<C2080d> mo8701a() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        try {
            Object[] objArr = (Object[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(this.f6502a, new Object[0]);
            if (objArr == null) {
                return arrayList;
            }
            boolean z2 = false;
            for (Object obj : objArr) {
                String a = m8283a(obj);
                boolean e = m8288e(obj);
                if (C2097f.m8316b()) {
                    z = m8287d(obj);
                } else if (!z2) {
                    z2 = true;
                    z = true;
                } else {
                    z = false;
                }
                C2080d dVar = new C2080d(Build.VERSION.SDK_INT == 19 ? m8286c(obj) : m8285b(obj), a);
                dVar.f6505a = e;
                dVar.f6506b = z;
                arrayList.add(dVar);
            }
            return arrayList;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
    }
}
