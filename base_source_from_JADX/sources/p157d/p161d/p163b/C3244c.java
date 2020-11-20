package p157d.p161d.p163b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.p172io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3216d;
import p157d.C3257e;
import p157d.p158a.C3191g;
import p157d.p158a.C3207w;
import p157d.p161d.C3217a;
import p157d.p161d.p162a.C3218a;
import p157d.p161d.p162a.C3219b;
import p157d.p161d.p162a.C3220c;
import p157d.p161d.p162a.C3221d;
import p157d.p161d.p162a.C3222e;
import p157d.p161d.p162a.C3223f;
import p157d.p161d.p162a.C3224g;
import p157d.p161d.p162a.C3225h;
import p157d.p161d.p162a.C3226i;
import p157d.p161d.p162a.C3227j;
import p157d.p161d.p162a.C3228k;
import p157d.p161d.p162a.C3229l;
import p157d.p161d.p162a.C3230m;
import p157d.p161d.p162a.C3231n;
import p157d.p161d.p162a.C3232o;
import p157d.p161d.p162a.C3233p;
import p157d.p161d.p162a.C3234q;
import p157d.p161d.p162a.C3235r;
import p157d.p161d.p162a.C3236s;
import p157d.p161d.p162a.C3237t;
import p157d.p161d.p162a.C3238u;
import p157d.p161d.p162a.C3239v;
import p157d.p161d.p162a.C3240w;
import p157d.p165f.C3268b;
import p157d.p166g.C3278f;

/* renamed from: d.d.b.c */
public final class C3244c implements C3243b, C3268b<Object> {

    /* renamed from: a */
    public static final C3245a f7294a = new C3245a((C3247e) null);

    /* renamed from: c */
    private static final Map<Class<? extends Object<?>>, Integer> f7295c;

    /* renamed from: d */
    private static final HashMap<String, String> f7296d;

    /* renamed from: e */
    private static final HashMap<String, String> f7297e;

    /* renamed from: f */
    private static final HashMap<String, String> f7298f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Map<String, String> f7299g;
    @NotNull

    /* renamed from: b */
    private final Class<?> f7300b;

    /* renamed from: d.d.b.c$a */
    public static final class C3245a {
        private C3245a() {
        }

        public /* synthetic */ C3245a(C3247e eVar) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String mo25697a(@org.jetbrains.annotations.NotNull java.lang.Class<?> r6) {
            /*
                r5 = this;
                java.lang.String r0 = "jClass"
                p157d.p161d.p163b.C3250h.m9056b(r6, r0)
                boolean r0 = r6.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto L_0x000e
                goto L_0x00ca
            L_0x000e:
                boolean r0 = r6.isLocalClass()
                if (r0 == 0) goto L_0x0077
                java.lang.String r0 = r6.getSimpleName()
                java.lang.reflect.Method r2 = r6.getEnclosingMethod()
                r3 = 2
                if (r2 == 0) goto L_0x0041
                java.lang.String r4 = "name"
                p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r0, (java.lang.String) r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r2 = r2.getName()
                r4.append(r2)
                java.lang.String r2 = "$"
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                java.lang.String r2 = p157d.p166g.C3278f.m9096a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r1, (int) r3, (java.lang.Object) r1)
                if (r2 == 0) goto L_0x0041
                r6 = r2
                goto L_0x0067
            L_0x0041:
                java.lang.reflect.Constructor r6 = r6.getEnclosingConstructor()
                if (r6 == 0) goto L_0x0066
                java.lang.String r2 = "name"
                p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r0, (java.lang.String) r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = r6.getName()
                r2.append(r6)
                java.lang.String r6 = "$"
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                java.lang.String r6 = p157d.p166g.C3278f.m9096a((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r1, (int) r3, (java.lang.Object) r1)
                goto L_0x0067
            L_0x0066:
                r6 = r1
            L_0x0067:
                if (r6 == 0) goto L_0x006b
                r1 = r6
                goto L_0x00ca
            L_0x006b:
                java.lang.String r6 = "name"
                p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r0, (java.lang.String) r6)
                r6 = 36
                java.lang.String r1 = p157d.p166g.C3278f.m9093a((java.lang.String) r0, (char) r6, (java.lang.String) r1, (int) r3, (java.lang.Object) r1)
                goto L_0x00ca
            L_0x0077:
                boolean r0 = r6.isArray()
                if (r0 == 0) goto L_0x00b4
                java.lang.Class r6 = r6.getComponentType()
                java.lang.String r0 = "componentType"
                p157d.p161d.p163b.C3250h.m9053a((java.lang.Object) r6, (java.lang.String) r0)
                boolean r0 = r6.isPrimitive()
                if (r0 == 0) goto L_0x00ae
                java.util.Map r0 = p157d.p161d.p163b.C3244c.f7299g
                java.lang.String r6 = r6.getName()
                java.lang.Object r6 = r0.get(r6)
                java.lang.String r6 = (java.lang.String) r6
                if (r6 == 0) goto L_0x00ae
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                java.lang.String r6 = "Array"
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                r1 = r6
            L_0x00ae:
                if (r1 == 0) goto L_0x00b1
                goto L_0x00ca
            L_0x00b1:
                java.lang.String r1 = "Array"
                goto L_0x00ca
            L_0x00b4:
                java.util.Map r0 = p157d.p161d.p163b.C3244c.f7299g
                java.lang.String r1 = r6.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x00c6
                goto L_0x00ca
            L_0x00c6:
                java.lang.String r1 = r6.getSimpleName()
            L_0x00ca:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p157d.p161d.p163b.C3244c.C3245a.mo25697a(java.lang.Class):java.lang.String");
        }
    }

    static {
        int i = 0;
        Iterable a = C3191g.m8985a((T[]) new Class[]{C3218a.class, C3219b.class, C3230m.class, C3234q.class, C3235r.class, C3236s.class, C3237t.class, C3238u.class, C3239v.class, C3240w.class, C3220c.class, C3221d.class, C3222e.class, C3223f.class, C3224g.class, C3225h.class, C3226i.class, C3227j.class, C3228k.class, C3229l.class, C3231n.class, C3232o.class, C3233p.class});
        Collection arrayList = new ArrayList(C3191g.m8988a(a, 10));
        for (Object next : a) {
            int i2 = i + 1;
            if (i < 0) {
                C3191g.m8987b();
            }
            arrayList.add(C3257e.m9066a((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        f7295c = C3207w.m9017a((List) arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f7296d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f7297e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f7296d);
        hashMap3.putAll(f7297e);
        Collection<String> values = f7296d.values();
        C3250h.m9053a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C3250h.m9053a((Object) str, "kotlinName");
            sb.append(C3278f.m9102b(str, FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            C3216d a2 = C3257e.m9066a(sb2, str + ".Companion");
            hashMap3.put(a2.mo25682a(), a2.mo25683b());
        }
        Map map = hashMap3;
        for (Map.Entry next2 : f7295c.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f7298f = hashMap3;
        Map map2 = f7298f;
        Map<String, String> linkedHashMap = new LinkedHashMap<>(C3207w.m9013a(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), C3278f.m9102b((String) entry.getValue(), FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null));
        }
        f7299g = linkedHashMap;
    }

    public C3244c(@NotNull Class<?> cls) {
        C3250h.m9056b(cls, "jClass");
        this.f7300b = cls;
    }

    @NotNull
    /* renamed from: a */
    public Class<?> mo25692a() {
        return this.f7300b;
    }

    @Nullable
    /* renamed from: b */
    public String mo25693b() {
        return f7294a.mo25697a(mo25692a());
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C3244c) && C3250h.m9055a((Object) C3217a.m9031a(this), (Object) C3217a.m9031a((C3268b) obj));
    }

    public int hashCode() {
        return C3217a.m9031a(this).hashCode();
    }

    @NotNull
    public String toString() {
        return mo25692a().toString() + " (Kotlin reflection is not available)";
    }
}
