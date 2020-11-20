package com.p084c.p085a.p086a;

import android.util.Log;
import com.p084c.p085a.p086a.C1432c;

/* renamed from: com.c.a.a.f */
public class C1446f implements C1431b {

    /* renamed from: a */
    private final C1432c.C1433a f4309a;

    /* renamed from: b */
    private final String f4310b;

    /* renamed from: c */
    private final String f4311c;

    /* renamed from: d */
    private final C1435e f4312d;

    /* renamed from: e */
    private final C1435e f4313e;

    public C1446f(C1432c.C1433a aVar, String str, String str2) {
        this.f4309a = aVar;
        this.f4310b = str;
        this.f4312d = C1435e.m5436a(str);
        this.f4311c = str2;
        this.f4313e = C1435e.m5436a(str2);
    }

    /* renamed from: a */
    public void mo6897a(String str, C1432c.C1433a aVar, Throwable th, String str2) {
        C1435e eVar;
        if (mo6899a(aVar)) {
            if (str2 == null) {
                str2 = th == null ? "" : Log.getStackTraceString(th);
            } else if (th != null) {
                str2 = str2 + 10 + Log.getStackTraceString(th);
            }
            StackTraceElement stackTraceElement = null;
            C1435e eVar2 = this.f4312d;
            if ((eVar2 != null && eVar2.mo6906a()) || ((eVar = this.f4313e) != null && eVar.mo6906a())) {
                stackTraceElement = C1448h.m5461a();
            }
            C1435e eVar3 = this.f4312d;
            String a = eVar3 == null ? "" : eVar3.mo6905a(stackTraceElement, str, aVar);
            C1435e eVar4 = this.f4313e;
            String a2 = eVar4 == null ? "" : eVar4.mo6905a(stackTraceElement, str, aVar);
            if (a2.length() > 0 && !Character.isWhitespace(a2.charAt(0))) {
                a2 = a2 + " ";
            }
            Log.println(aVar.mo6903a(), a, a2 + str2);
        }
    }

    /* renamed from: a */
    public void mo6898a(String str, C1432c.C1433a aVar, Throwable th, String str2, Object... objArr) {
        if (!mo6899a(aVar)) {
            return;
        }
        if (str2 != null || objArr == null || objArr.length <= 0) {
            mo6897a(str, aVar, th, str2 == null ? null : String.format(str2, objArr));
            return;
        }
        throw new IllegalArgumentException("message format is not set but arguments are presented");
    }

    /* renamed from: a */
    public boolean mo6899a(C1432c.C1433a aVar) {
        C1432c.C1433a aVar2 = this.f4309a;
        return (aVar2 == null || aVar == null || !aVar2.mo6904a(aVar)) ? false : true;
    }
}
