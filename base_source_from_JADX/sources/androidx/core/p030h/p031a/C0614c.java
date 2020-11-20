package androidx.core.p030h.p031a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.C0481a;
import androidx.core.p030h.p031a.C0622f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: androidx.core.h.a.c */
public class C0614c {

    /* renamed from: d */
    private static int f2238d;

    /* renamed from: a */
    public int f2239a = -1;

    /* renamed from: b */
    private final AccessibilityNodeInfo f2240b;

    /* renamed from: c */
    private int f2241c = -1;

    /* renamed from: androidx.core.h.a.c$a */
    public static class C0615a {

        /* renamed from: A */
        public static final C0615a f2242A = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: B */
        public static final C0615a f2243B = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: C */
        public static final C0615a f2244C = new C0615a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: D */
        public static final C0615a f2245D = new C0615a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: E */
        public static final C0615a f2246E = new C0615a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: F */
        public static final C0615a f2247F = new C0615a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: G */
        public static final C0615a f2248G = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: H */
        public static final C0615a f2249H = new C0615a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (C0622f) null, C0622f.C0628f.class);

        /* renamed from: I */
        public static final C0615a f2250I = new C0615a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (C0622f) null, C0622f.C0626d.class);

        /* renamed from: J */
        public static final C0615a f2251J = new C0615a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: K */
        public static final C0615a f2252K;

        /* renamed from: a */
        public static final C0615a f2253a = new C0615a(1, (CharSequence) null);

        /* renamed from: b */
        public static final C0615a f2254b = new C0615a(2, (CharSequence) null);

        /* renamed from: c */
        public static final C0615a f2255c = new C0615a(4, (CharSequence) null);

        /* renamed from: d */
        public static final C0615a f2256d = new C0615a(8, (CharSequence) null);

        /* renamed from: e */
        public static final C0615a f2257e = new C0615a(16, (CharSequence) null);

        /* renamed from: f */
        public static final C0615a f2258f = new C0615a(32, (CharSequence) null);

        /* renamed from: g */
        public static final C0615a f2259g = new C0615a(64, (CharSequence) null);

        /* renamed from: h */
        public static final C0615a f2260h = new C0615a(128, (CharSequence) null);

        /* renamed from: i */
        public static final C0615a f2261i = new C0615a(256, (CharSequence) null, C0622f.C0624b.class);

        /* renamed from: j */
        public static final C0615a f2262j = new C0615a(512, (CharSequence) null, C0622f.C0624b.class);

        /* renamed from: k */
        public static final C0615a f2263k = new C0615a(1024, (CharSequence) null, C0622f.C0625c.class);

        /* renamed from: l */
        public static final C0615a f2264l = new C0615a(2048, (CharSequence) null, C0622f.C0625c.class);

        /* renamed from: m */
        public static final C0615a f2265m = new C0615a(4096, (CharSequence) null);

        /* renamed from: n */
        public static final C0615a f2266n = new C0615a(PKIFailureInfo.certRevoked, (CharSequence) null);

        /* renamed from: o */
        public static final C0615a f2267o = new C0615a(16384, (CharSequence) null);

        /* renamed from: p */
        public static final C0615a f2268p = new C0615a(32768, (CharSequence) null);

        /* renamed from: q */
        public static final C0615a f2269q = new C0615a(PKIFailureInfo.notAuthorized, (CharSequence) null);

        /* renamed from: r */
        public static final C0615a f2270r = new C0615a(131072, (CharSequence) null, C0622f.C0629g.class);

        /* renamed from: s */
        public static final C0615a f2271s = new C0615a(PKIFailureInfo.transactionIdInUse, (CharSequence) null);

        /* renamed from: t */
        public static final C0615a f2272t = new C0615a(PKIFailureInfo.signerNotTrusted, (CharSequence) null);

        /* renamed from: u */
        public static final C0615a f2273u = new C0615a(PKIFailureInfo.badCertTemplate, (CharSequence) null);

        /* renamed from: v */
        public static final C0615a f2274v = new C0615a(PKIFailureInfo.badSenderNonce, (CharSequence) null, C0622f.C0630h.class);

        /* renamed from: w */
        public static final C0615a f2275w = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: x */
        public static final C0615a f2276x = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (C0622f) null, C0622f.C0627e.class);

        /* renamed from: y */
        public static final C0615a f2277y = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: z */
        public static final C0615a f2278z = new C0615a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);

        /* renamed from: L */
        final Object f2279L;

        /* renamed from: M */
        protected final C0622f f2280M;

        /* renamed from: N */
        private final int f2281N;

        /* renamed from: O */
        private final Class<? extends C0622f.C0623a> f2282O;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            f2252K = new C0615a(accessibilityAction, 16908357, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);
        }

        public C0615a(int i, CharSequence charSequence) {
            this((Object) null, i, charSequence, (C0622f) null, (Class<? extends C0622f.C0623a>) null);
        }

        private C0615a(int i, CharSequence charSequence, Class<? extends C0622f.C0623a> cls) {
            this((Object) null, i, charSequence, (C0622f) null, cls);
        }

        C0615a(Object obj) {
            this(obj, 0, (CharSequence) null, (C0622f) null, (Class<? extends C0622f.C0623a>) null);
        }

        C0615a(Object obj, int i, CharSequence charSequence, C0622f fVar, Class<? extends C0622f.C0623a> cls) {
            this.f2281N = i;
            this.f2280M = fVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            }
            this.f2279L = obj;
            this.f2282O = cls;
        }

        /* renamed from: a */
        public int mo3763a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2279L).getId();
            }
            return 0;
        }

        /* renamed from: a */
        public C0615a mo3764a(CharSequence charSequence, C0622f fVar) {
            return new C0615a((Object) null, this.f2281N, charSequence, fVar, this.f2282O);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo3765a(android.view.View r6, android.os.Bundle r7) {
            /*
                r5 = this;
                androidx.core.h.a.f r0 = r5.f2280M
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.h.a.f$a> r2 = r5.f2282O
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.h.a.f$a r1 = (androidx.core.p030h.p031a.C0622f.C0623a) r1     // Catch:{ Exception -> 0x0020 }
                r1.mo3781a(r7)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r7 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r7 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.h.a.f$a> r1 = r5.f2282O
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.String r2 = "A11yActionCompat"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Failed to execute command with argument class ViewCommandArgument: "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                android.util.Log.e(r2, r1, r7)
            L_0x0042:
                androidx.core.h.a.f r7 = r5.f2280M
                boolean r6 = r7.perform(r6, r0)
                return r6
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p030h.p031a.C0614c.C0615a.mo3765a(android.view.View, android.os.Bundle):boolean");
        }

        /* renamed from: b */
        public CharSequence mo3766b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2279L).getLabel();
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C0615a)) {
                return false;
            }
            C0615a aVar = (C0615a) obj;
            Object obj2 = this.f2279L;
            return obj2 == null ? aVar.f2279L == null : obj2.equals(aVar.f2279L);
        }

        public int hashCode() {
            Object obj = this.f2279L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* renamed from: androidx.core.h.a.c$b */
    public static class C0616b {

        /* renamed from: a */
        final Object f2283a;

        C0616b(Object obj) {
            this.f2283a = obj;
        }

        /* renamed from: a */
        public static C0616b m2480a(int i, int i2, boolean z) {
            return Build.VERSION.SDK_INT >= 19 ? new C0616b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new C0616b((Object) null);
        }

        /* renamed from: a */
        public static C0616b m2481a(int i, int i2, boolean z, int i3) {
            return Build.VERSION.SDK_INT >= 21 ? new C0616b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3)) : Build.VERSION.SDK_INT >= 19 ? new C0616b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new C0616b((Object) null);
        }
    }

    /* renamed from: androidx.core.h.a.c$c */
    public static class C0617c {

        /* renamed from: a */
        final Object f2284a;

        C0617c(Object obj) {
            this.f2284a = obj;
        }

        /* renamed from: a */
        public static C0617c m2482a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return Build.VERSION.SDK_INT >= 21 ? new C0617c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : Build.VERSION.SDK_INT >= 19 ? new C0617c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new C0617c((Object) null);
        }
    }

    private C0614c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2240b = accessibilityNodeInfo;
    }

    /* renamed from: a */
    private int m2403a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f2238d;
        f2238d = i2 + 1;
        return i2;
    }

    /* renamed from: a */
    public static C0614c m2404a(View view) {
        return m2405a(AccessibilityNodeInfo.obtain(view));
    }

    /* renamed from: a */
    public static C0614c m2405a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0614c(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public static C0614c m2406a(C0614c cVar) {
        return m2405a(AccessibilityNodeInfo.obtain(cVar.f2240b));
    }

    /* renamed from: a */
    private List<Integer> m2407a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2240b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f2240b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m2408a(int i, boolean z) {
        Bundle v = mo3761v();
        if (v != null) {
            int i2 = v.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            v.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    /* renamed from: a */
    private void m2409a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    /* renamed from: b */
    public static C0614c m2410b() {
        return m2405a(AccessibilityNodeInfo.obtain());
    }

    /* renamed from: b */
    private boolean m2411b(int i) {
        Bundle v = mo3761v();
        return v != null && (v.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    /* renamed from: c */
    private SparseArray<WeakReference<ClickableSpan>> m2412c(View view) {
        SparseArray<WeakReference<ClickableSpan>> d = m2414d(view);
        if (d != null) {
            return d;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(C0481a.C0484c.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    /* renamed from: c */
    private static String m2413c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                switch (i) {
                                    case 4:
                                        return "ACTION_SELECT";
                                    case 8:
                                        return "ACTION_CLEAR_SELECTION";
                                    case 16:
                                        return "ACTION_CLICK";
                                    case 32:
                                        return "ACTION_LONG_CLICK";
                                    case 64:
                                        return "ACTION_ACCESSIBILITY_FOCUS";
                                    case 128:
                                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                                    case 256:
                                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                                    case 512:
                                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                                    case 1024:
                                        return "ACTION_NEXT_HTML_ELEMENT";
                                    case 2048:
                                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                                    case 4096:
                                        return "ACTION_SCROLL_FORWARD";
                                    case PKIFailureInfo.certRevoked /*8192*/:
                                        return "ACTION_SCROLL_BACKWARD";
                                    case 16384:
                                        return "ACTION_COPY";
                                    case 32768:
                                        return "ACTION_PASTE";
                                    case PKIFailureInfo.notAuthorized /*65536*/:
                                        return "ACTION_CUT";
                                    case 131072:
                                        return "ACTION_SET_SELECTION";
                                    case PKIFailureInfo.transactionIdInUse /*262144*/:
                                        return "ACTION_EXPAND";
                                    case PKIFailureInfo.signerNotTrusted /*524288*/:
                                        return "ACTION_COLLAPSE";
                                    case PKIFailureInfo.badSenderNonce /*2097152*/:
                                        return "ACTION_SET_TEXT";
                                    case 16908354:
                                        return "ACTION_MOVE_WINDOW";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* renamed from: d */
    private SparseArray<WeakReference<ClickableSpan>> m2414d(View view) {
        return (SparseArray) view.getTag(C0481a.C0484c.tag_accessibility_clickable_spans);
    }

    /* renamed from: d */
    public static ClickableSpan[] m2415d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: e */
    private void m2416e(View view) {
        SparseArray<WeakReference<ClickableSpan>> d = m2414d(view);
        if (d != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < d.size(); i++) {
                if (d.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    /* renamed from: x */
    private boolean m2417x() {
        return !m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: y */
    private void m2418y() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2240b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2240b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2240b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    /* renamed from: a */
    public AccessibilityNodeInfo mo3703a() {
        return this.f2240b;
    }

    /* renamed from: a */
    public void mo3704a(int i) {
        this.f2240b.addAction(i);
    }

    @Deprecated
    /* renamed from: a */
    public void mo3705a(Rect rect) {
        this.f2240b.getBoundsInParent(rect);
    }

    /* renamed from: a */
    public void mo3706a(View view, int i) {
        this.f2241c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2240b.setSource(view, i);
        }
    }

    /* renamed from: a */
    public void mo3707a(C0615a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2240b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2279L);
        }
    }

    /* renamed from: a */
    public void mo3708a(CharSequence charSequence) {
        this.f2240b.setPackageName(charSequence);
    }

    /* renamed from: a */
    public void mo3709a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            m2418y();
            m2416e(view);
            ClickableSpan[] d = m2415d(charSequence);
            if (d != null && d.length > 0) {
                mo3761v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", C0481a.C0484c.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> c = m2412c(view);
                int i = 0;
                while (d != null && i < d.length) {
                    int a = m2403a(d[i], c);
                    c.put(a, new WeakReference(d[i]));
                    m2409a(d[i], (Spanned) charSequence, a);
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3710a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0616b) obj).f2283a);
        }
    }

    /* renamed from: a */
    public void mo3711a(boolean z) {
        this.f2240b.setCheckable(z);
    }

    /* renamed from: a */
    public boolean mo3712a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2240b.performAction(i, bundle);
        }
        return false;
    }

    @Deprecated
    /* renamed from: b */
    public void mo3713b(Rect rect) {
        this.f2240b.setBoundsInParent(rect);
    }

    /* renamed from: b */
    public void mo3714b(View view) {
        this.f2239a = -1;
        this.f2240b.setParent(view);
    }

    /* renamed from: b */
    public void mo3715b(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2240b.addChild(view, i);
        }
    }

    /* renamed from: b */
    public void mo3716b(CharSequence charSequence) {
        this.f2240b.setClassName(charSequence);
    }

    /* renamed from: b */
    public void mo3717b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0617c) obj).f2284a);
        }
    }

    /* renamed from: b */
    public void mo3718b(boolean z) {
        this.f2240b.setChecked(z);
    }

    /* renamed from: c */
    public int mo3719c() {
        return this.f2240b.getChildCount();
    }

    /* renamed from: c */
    public void mo3720c(Rect rect) {
        this.f2240b.getBoundsInScreen(rect);
    }

    /* renamed from: c */
    public void mo3721c(View view, int i) {
        this.f2239a = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2240b.setParent(view, i);
        }
    }

    /* renamed from: c */
    public void mo3722c(CharSequence charSequence) {
        this.f2240b.setText(charSequence);
    }

    /* renamed from: c */
    public void mo3723c(boolean z) {
        this.f2240b.setFocusable(z);
    }

    /* renamed from: d */
    public int mo3724d() {
        return this.f2240b.getActions();
    }

    /* renamed from: d */
    public void mo3725d(Rect rect) {
        this.f2240b.setBoundsInScreen(rect);
    }

    /* renamed from: d */
    public void mo3726d(boolean z) {
        this.f2240b.setFocused(z);
    }

    /* renamed from: e */
    public void mo3727e(CharSequence charSequence) {
        this.f2240b.setContentDescription(charSequence);
    }

    /* renamed from: e */
    public void mo3728e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2240b.setVisibleToUser(z);
        }
    }

    /* renamed from: e */
    public boolean mo3729e() {
        return this.f2240b.isCheckable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0614c)) {
            return false;
        }
        C0614c cVar = (C0614c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2240b;
        if (accessibilityNodeInfo == null) {
            if (cVar.f2240b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f2240b)) {
            return false;
        }
        return this.f2241c == cVar.f2241c && this.f2239a == cVar.f2239a;
    }

    /* renamed from: f */
    public void mo3731f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2240b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* renamed from: f */
    public void mo3732f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2240b.setAccessibilityFocused(z);
        }
    }

    /* renamed from: f */
    public boolean mo3733f() {
        return this.f2240b.isChecked();
    }

    /* renamed from: g */
    public void mo3734g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2240b.setError(charSequence);
        }
    }

    /* renamed from: g */
    public void mo3735g(boolean z) {
        this.f2240b.setClickable(z);
    }

    /* renamed from: g */
    public boolean mo3736g() {
        return this.f2240b.isFocusable();
    }

    /* renamed from: h */
    public void mo3737h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2240b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    /* renamed from: h */
    public void mo3738h(boolean z) {
        this.f2240b.setEnabled(z);
    }

    /* renamed from: h */
    public boolean mo3739h() {
        return this.f2240b.isFocused();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2240b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* renamed from: i */
    public void mo3741i(boolean z) {
        this.f2240b.setScrollable(z);
    }

    /* renamed from: i */
    public boolean mo3742i() {
        return this.f2240b.isSelected();
    }

    /* renamed from: j */
    public void mo3743j(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.setContentInvalid(z);
        }
    }

    /* renamed from: j */
    public boolean mo3744j() {
        return this.f2240b.isClickable();
    }

    /* renamed from: k */
    public void mo3745k(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2240b.setDismissable(z);
        }
    }

    /* renamed from: k */
    public boolean mo3746k() {
        return this.f2240b.isLongClickable();
    }

    /* renamed from: l */
    public void mo3747l(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2240b.setScreenReaderFocusable(z);
        } else {
            m2408a(1, z);
        }
    }

    /* renamed from: l */
    public boolean mo3748l() {
        return this.f2240b.isEnabled();
    }

    /* renamed from: m */
    public void mo3749m(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2240b.setShowingHintText(z);
        } else {
            m2408a(4, z);
        }
    }

    /* renamed from: m */
    public boolean mo3750m() {
        return this.f2240b.isPassword();
    }

    /* renamed from: n */
    public void mo3751n(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2240b.setHeading(z);
        } else {
            m2408a(2, z);
        }
    }

    /* renamed from: n */
    public boolean mo3752n() {
        return this.f2240b.isScrollable();
    }

    /* renamed from: o */
    public CharSequence mo3753o() {
        return this.f2240b.getPackageName();
    }

    /* renamed from: p */
    public CharSequence mo3754p() {
        return this.f2240b.getClassName();
    }

    /* renamed from: q */
    public CharSequence mo3755q() {
        if (!m2417x()) {
            return this.f2240b.getText();
        }
        List<Integer> a = m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a2 = m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a3 = m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a4 = m2407a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2240b.getText(), 0, this.f2240b.getText().length()));
        for (int i = 0; i < a.size(); i++) {
            spannableString.setSpan(new C0612a(a4.get(i).intValue(), this, mo3761v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a.get(i).intValue(), a2.get(i).intValue(), a3.get(i).intValue());
        }
        return spannableString;
    }

    /* renamed from: r */
    public CharSequence mo3756r() {
        return this.f2240b.getContentDescription();
    }

    /* renamed from: s */
    public void mo3757s() {
        this.f2240b.recycle();
    }

    /* renamed from: t */
    public String mo3758t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2240b.getViewIdResourceName();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        mo3705a(rect);
        sb.append("; boundsInParent: " + rect);
        mo3720c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(mo3753o());
        sb.append("; className: ");
        sb.append(mo3754p());
        sb.append("; text: ");
        sb.append(mo3755q());
        sb.append("; contentDescription: ");
        sb.append(mo3756r());
        sb.append("; viewId: ");
        sb.append(mo3758t());
        sb.append("; checkable: ");
        sb.append(mo3729e());
        sb.append("; checked: ");
        sb.append(mo3733f());
        sb.append("; focusable: ");
        sb.append(mo3736g());
        sb.append("; focused: ");
        sb.append(mo3739h());
        sb.append("; selected: ");
        sb.append(mo3742i());
        sb.append("; clickable: ");
        sb.append(mo3744j());
        sb.append("; longClickable: ");
        sb.append(mo3746k());
        sb.append("; enabled: ");
        sb.append(mo3748l());
        sb.append("; password: ");
        sb.append(mo3750m());
        sb.append("; scrollable: " + mo3752n());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<C0615a> u = mo3760u();
            for (int i = 0; i < u.size(); i++) {
                C0615a aVar = u.get(i);
                String c = m2413c(aVar.mo3763a());
                if (c.equals("ACTION_UNKNOWN") && aVar.mo3766b() != null) {
                    c = aVar.mo3766b().toString();
                }
                sb.append(c);
                if (i != u.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int d = mo3724d();
            while (d != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d);
                d &= ~numberOfTrailingZeros;
                sb.append(m2413c(numberOfTrailingZeros));
                if (d != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: u */
    public List<C0615a> mo3760u() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f2240b.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new C0615a(actionList.get(i)));
        }
        return arrayList;
    }

    /* renamed from: v */
    public Bundle mo3761v() {
        return Build.VERSION.SDK_INT >= 19 ? this.f2240b.getExtras() : new Bundle();
    }

    /* renamed from: w */
    public boolean mo3762w() {
        return Build.VERSION.SDK_INT >= 26 ? this.f2240b.isShowingHintText() : m2411b(4);
    }
}
