package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p019a.C0446f;
import androidx.constraintlayout.p019a.p020a.C0425f;
import androidx.constraintlayout.p019a.p020a.C0428g;
import androidx.constraintlayout.p019a.p020a.C0430i;
import androidx.constraintlayout.widget.C0462f;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a */
    SparseArray<View> f1701a = new SparseArray<>();

    /* renamed from: b */
    C0428g f1702b = new C0428g();

    /* renamed from: c */
    int f1703c = -1;

    /* renamed from: d */
    int f1704d = -1;

    /* renamed from: e */
    int f1705e = 0;

    /* renamed from: f */
    int f1706f = 0;

    /* renamed from: g */
    private ArrayList<C0455b> f1707g = new ArrayList<>(4);

    /* renamed from: h */
    private final ArrayList<C0425f> f1708h = new ArrayList<>(100);

    /* renamed from: i */
    private int f1709i = 0;

    /* renamed from: j */
    private int f1710j = 0;

    /* renamed from: k */
    private int f1711k = Integer.MAX_VALUE;

    /* renamed from: l */
    private int f1712l = Integer.MAX_VALUE;

    /* renamed from: m */
    private boolean f1713m = true;

    /* renamed from: n */
    private int f1714n = 7;

    /* renamed from: o */
    private C0456c f1715o = null;

    /* renamed from: p */
    private int f1716p = -1;

    /* renamed from: q */
    private HashMap<String, Integer> f1717q = new HashMap<>();

    /* renamed from: r */
    private int f1718r = -1;

    /* renamed from: s */
    private int f1719s = -1;

    /* renamed from: t */
    private C0446f f1720t;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a */
    public static class C0452a extends ViewGroup.MarginLayoutParams {

        /* renamed from: A */
        public float f1721A = 0.5f;

        /* renamed from: B */
        public String f1722B = null;

        /* renamed from: C */
        float f1723C = 0.0f;

        /* renamed from: D */
        int f1724D = 1;

        /* renamed from: E */
        public float f1725E = -1.0f;

        /* renamed from: F */
        public float f1726F = -1.0f;

        /* renamed from: G */
        public int f1727G = 0;

        /* renamed from: H */
        public int f1728H = 0;

        /* renamed from: I */
        public int f1729I = 0;

        /* renamed from: J */
        public int f1730J = 0;

        /* renamed from: K */
        public int f1731K = 0;

        /* renamed from: L */
        public int f1732L = 0;

        /* renamed from: M */
        public int f1733M = 0;

        /* renamed from: N */
        public int f1734N = 0;

        /* renamed from: O */
        public float f1735O = 1.0f;

        /* renamed from: P */
        public float f1736P = 1.0f;

        /* renamed from: Q */
        public int f1737Q = -1;

        /* renamed from: R */
        public int f1738R = -1;

        /* renamed from: S */
        public int f1739S = -1;

        /* renamed from: T */
        public boolean f1740T = false;

        /* renamed from: U */
        public boolean f1741U = false;

        /* renamed from: V */
        boolean f1742V = true;

        /* renamed from: W */
        boolean f1743W = true;

        /* renamed from: X */
        boolean f1744X = false;

        /* renamed from: Y */
        boolean f1745Y = false;

        /* renamed from: Z */
        boolean f1746Z = false;

        /* renamed from: a */
        public int f1747a = -1;

        /* renamed from: aa */
        boolean f1748aa = false;

        /* renamed from: ab */
        int f1749ab = -1;

        /* renamed from: ac */
        int f1750ac = -1;

        /* renamed from: ad */
        int f1751ad = -1;

        /* renamed from: ae */
        int f1752ae = -1;

        /* renamed from: af */
        int f1753af = -1;

        /* renamed from: ag */
        int f1754ag = -1;

        /* renamed from: ah */
        float f1755ah = 0.5f;

        /* renamed from: ai */
        int f1756ai;

        /* renamed from: aj */
        int f1757aj;

        /* renamed from: ak */
        float f1758ak;

        /* renamed from: al */
        C0425f f1759al = new C0425f();

        /* renamed from: am */
        public boolean f1760am = false;

        /* renamed from: b */
        public int f1761b = -1;

        /* renamed from: c */
        public float f1762c = -1.0f;

        /* renamed from: d */
        public int f1763d = -1;

        /* renamed from: e */
        public int f1764e = -1;

        /* renamed from: f */
        public int f1765f = -1;

        /* renamed from: g */
        public int f1766g = -1;

        /* renamed from: h */
        public int f1767h = -1;

        /* renamed from: i */
        public int f1768i = -1;

        /* renamed from: j */
        public int f1769j = -1;

        /* renamed from: k */
        public int f1770k = -1;

        /* renamed from: l */
        public int f1771l = -1;

        /* renamed from: m */
        public int f1772m = -1;

        /* renamed from: n */
        public int f1773n = 0;

        /* renamed from: o */
        public float f1774o = 0.0f;

        /* renamed from: p */
        public int f1775p = -1;

        /* renamed from: q */
        public int f1776q = -1;

        /* renamed from: r */
        public int f1777r = -1;

        /* renamed from: s */
        public int f1778s = -1;

        /* renamed from: t */
        public int f1779t = -1;

        /* renamed from: u */
        public int f1780u = -1;

        /* renamed from: v */
        public int f1781v = -1;

        /* renamed from: w */
        public int f1782w = -1;

        /* renamed from: x */
        public int f1783x = -1;

        /* renamed from: y */
        public int f1784y = -1;

        /* renamed from: z */
        public float f1785z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a */
        private static class C0453a {

            /* renamed from: a */
            public static final SparseIntArray f1786a = new SparseIntArray();

            static {
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_android_orientation, 1);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f1786a.append(C0462f.C0464b.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public C0452a(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0216, code lost:
            android.util.Log.e(r4, r6);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0452a(android.content.Context r10, android.util.AttributeSet r11) {
            /*
                r9 = this;
                r9.<init>(r10, r11)
                r0 = -1
                r9.f1747a = r0
                r9.f1761b = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r9.f1762c = r1
                r9.f1763d = r0
                r9.f1764e = r0
                r9.f1765f = r0
                r9.f1766g = r0
                r9.f1767h = r0
                r9.f1768i = r0
                r9.f1769j = r0
                r9.f1770k = r0
                r9.f1771l = r0
                r9.f1772m = r0
                r2 = 0
                r9.f1773n = r2
                r3 = 0
                r9.f1774o = r3
                r9.f1775p = r0
                r9.f1776q = r0
                r9.f1777r = r0
                r9.f1778s = r0
                r9.f1779t = r0
                r9.f1780u = r0
                r9.f1781v = r0
                r9.f1782w = r0
                r9.f1783x = r0
                r9.f1784y = r0
                r4 = 1056964608(0x3f000000, float:0.5)
                r9.f1785z = r4
                r9.f1721A = r4
                r5 = 0
                r9.f1722B = r5
                r9.f1723C = r3
                r5 = 1
                r9.f1724D = r5
                r9.f1725E = r1
                r9.f1726F = r1
                r9.f1727G = r2
                r9.f1728H = r2
                r9.f1729I = r2
                r9.f1730J = r2
                r9.f1731K = r2
                r9.f1732L = r2
                r9.f1733M = r2
                r9.f1734N = r2
                r1 = 1065353216(0x3f800000, float:1.0)
                r9.f1735O = r1
                r9.f1736P = r1
                r9.f1737Q = r0
                r9.f1738R = r0
                r9.f1739S = r0
                r9.f1740T = r2
                r9.f1741U = r2
                r9.f1742V = r5
                r9.f1743W = r5
                r9.f1744X = r2
                r9.f1745Y = r2
                r9.f1746Z = r2
                r9.f1748aa = r2
                r9.f1749ab = r0
                r9.f1750ac = r0
                r9.f1751ad = r0
                r9.f1752ae = r0
                r9.f1753af = r0
                r9.f1754ag = r0
                r9.f1755ah = r4
                androidx.constraintlayout.a.a.f r1 = new androidx.constraintlayout.a.a.f
                r1.<init>()
                r9.f1759al = r1
                r9.f1760am = r2
                int[] r1 = androidx.constraintlayout.widget.C0462f.C0464b.ConstraintLayout_Layout
                android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r1)
                int r11 = r10.getIndexCount()
                r1 = 0
            L_0x009a:
                if (r1 >= r11) goto L_0x03db
                int r4 = r10.getIndex(r1)
                android.util.SparseIntArray r6 = androidx.constraintlayout.widget.ConstraintLayout.C0452a.C0453a.f1786a
                int r6 = r6.get(r4)
                r7 = -2
                switch(r6) {
                    case 0: goto L_0x03d7;
                    case 1: goto L_0x03cf;
                    case 2: goto L_0x03bc;
                    case 3: goto L_0x03b3;
                    case 4: goto L_0x039c;
                    case 5: goto L_0x0393;
                    case 6: goto L_0x038a;
                    case 7: goto L_0x0381;
                    case 8: goto L_0x036e;
                    case 9: goto L_0x035b;
                    case 10: goto L_0x0347;
                    case 11: goto L_0x0333;
                    case 12: goto L_0x031f;
                    case 13: goto L_0x030b;
                    case 14: goto L_0x02f7;
                    case 15: goto L_0x02e3;
                    case 16: goto L_0x02cf;
                    case 17: goto L_0x02bb;
                    case 18: goto L_0x02a7;
                    case 19: goto L_0x0293;
                    case 20: goto L_0x027f;
                    case 21: goto L_0x0275;
                    case 22: goto L_0x026b;
                    case 23: goto L_0x0261;
                    case 24: goto L_0x0257;
                    case 25: goto L_0x024d;
                    case 26: goto L_0x0243;
                    case 27: goto L_0x0239;
                    case 28: goto L_0x022f;
                    case 29: goto L_0x0225;
                    case 30: goto L_0x021b;
                    case 31: goto L_0x0208;
                    case 32: goto L_0x01f9;
                    case 33: goto L_0x01e2;
                    case 34: goto L_0x01cb;
                    case 35: goto L_0x01bd;
                    case 36: goto L_0x01a6;
                    case 37: goto L_0x018f;
                    case 38: goto L_0x0181;
                    case 39: goto L_0x03d7;
                    case 40: goto L_0x03d7;
                    case 41: goto L_0x03d7;
                    case 42: goto L_0x03d7;
                    case 43: goto L_0x00aa;
                    case 44: goto L_0x00e4;
                    case 45: goto L_0x00da;
                    case 46: goto L_0x00d0;
                    case 47: goto L_0x00c8;
                    case 48: goto L_0x00c0;
                    case 49: goto L_0x00b6;
                    case 50: goto L_0x00ac;
                    default: goto L_0x00aa;
                }
            L_0x00aa:
                goto L_0x03d7
            L_0x00ac:
                int r6 = r9.f1738R
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.f1738R = r4
                goto L_0x03d7
            L_0x00b6:
                int r6 = r9.f1737Q
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.f1737Q = r4
                goto L_0x03d7
            L_0x00c0:
                int r4 = r10.getInt(r4, r2)
                r9.f1728H = r4
                goto L_0x03d7
            L_0x00c8:
                int r4 = r10.getInt(r4, r2)
                r9.f1727G = r4
                goto L_0x03d7
            L_0x00d0:
                float r6 = r9.f1726F
                float r4 = r10.getFloat(r4, r6)
                r9.f1726F = r4
                goto L_0x03d7
            L_0x00da:
                float r6 = r9.f1725E
                float r4 = r10.getFloat(r4, r6)
                r9.f1725E = r4
                goto L_0x03d7
            L_0x00e4:
                java.lang.String r4 = r10.getString(r4)
                r9.f1722B = r4
                r4 = 2143289344(0x7fc00000, float:NaN)
                r9.f1723C = r4
                r9.f1724D = r0
                java.lang.String r4 = r9.f1722B
                if (r4 == 0) goto L_0x03d7
                int r4 = r4.length()
                java.lang.String r6 = r9.f1722B
                r7 = 44
                int r6 = r6.indexOf(r7)
                if (r6 <= 0) goto L_0x0124
                int r7 = r4 + -1
                if (r6 >= r7) goto L_0x0124
                java.lang.String r7 = r9.f1722B
                java.lang.String r7 = r7.substring(r2, r6)
                java.lang.String r8 = "W"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0117
                r9.f1724D = r2
                goto L_0x0121
            L_0x0117:
                java.lang.String r8 = "H"
                boolean r7 = r7.equalsIgnoreCase(r8)
                if (r7 == 0) goto L_0x0121
                r9.f1724D = r5
            L_0x0121:
                int r6 = r6 + 1
                goto L_0x0125
            L_0x0124:
                r6 = 0
            L_0x0125:
                java.lang.String r7 = r9.f1722B
                r8 = 58
                int r7 = r7.indexOf(r8)
                if (r7 < 0) goto L_0x0170
                int r4 = r4 + -1
                if (r7 >= r4) goto L_0x0170
                java.lang.String r4 = r9.f1722B
                java.lang.String r4 = r4.substring(r6, r7)
                java.lang.String r6 = r9.f1722B
                int r7 = r7 + 1
                java.lang.String r6 = r6.substring(r7)
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x03d7
                int r7 = r6.length()
                if (r7 <= 0) goto L_0x03d7
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03d7 }
                float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x03d7 }
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03d7
                int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03d7
                int r7 = r9.f1724D     // Catch:{ NumberFormatException -> 0x03d7 }
                if (r7 != r5) goto L_0x016a
                float r6 = r6 / r4
                float r4 = java.lang.Math.abs(r6)     // Catch:{ NumberFormatException -> 0x03d7 }
            L_0x0166:
                r9.f1723C = r4     // Catch:{ NumberFormatException -> 0x03d7 }
                goto L_0x03d7
            L_0x016a:
                float r4 = r4 / r6
                float r4 = java.lang.Math.abs(r4)     // Catch:{ NumberFormatException -> 0x03d7 }
                goto L_0x0166
            L_0x0170:
                java.lang.String r4 = r9.f1722B
                java.lang.String r4 = r4.substring(r6)
                int r6 = r4.length()
                if (r6 <= 0) goto L_0x03d7
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03d7 }
                goto L_0x0166
            L_0x0181:
                float r6 = r9.f1736P
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.f1736P = r4
                goto L_0x03d7
            L_0x018f:
                int r6 = r9.f1734N     // Catch:{ Exception -> 0x0199 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x0199 }
                r9.f1734N = r6     // Catch:{ Exception -> 0x0199 }
                goto L_0x03d7
            L_0x0199:
                int r6 = r9.f1734N
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03d7
                r9.f1734N = r7
                goto L_0x03d7
            L_0x01a6:
                int r6 = r9.f1732L     // Catch:{ Exception -> 0x01b0 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01b0 }
                r9.f1732L = r6     // Catch:{ Exception -> 0x01b0 }
                goto L_0x03d7
            L_0x01b0:
                int r6 = r9.f1732L
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03d7
                r9.f1732L = r7
                goto L_0x03d7
            L_0x01bd:
                float r6 = r9.f1735O
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.f1735O = r4
                goto L_0x03d7
            L_0x01cb:
                int r6 = r9.f1733M     // Catch:{ Exception -> 0x01d5 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01d5 }
                r9.f1733M = r6     // Catch:{ Exception -> 0x01d5 }
                goto L_0x03d7
            L_0x01d5:
                int r6 = r9.f1733M
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03d7
                r9.f1733M = r7
                goto L_0x03d7
            L_0x01e2:
                int r6 = r9.f1731K     // Catch:{ Exception -> 0x01ec }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01ec }
                r9.f1731K = r6     // Catch:{ Exception -> 0x01ec }
                goto L_0x03d7
            L_0x01ec:
                int r6 = r9.f1731K
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03d7
                r9.f1731K = r7
                goto L_0x03d7
            L_0x01f9:
                int r4 = r10.getInt(r4, r2)
                r9.f1730J = r4
                int r4 = r9.f1730J
                if (r4 != r5) goto L_0x03d7
                java.lang.String r4 = "ConstraintLayout"
                java.lang.String r6 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
                goto L_0x0216
            L_0x0208:
                int r4 = r10.getInt(r4, r2)
                r9.f1729I = r4
                int r4 = r9.f1729I
                if (r4 != r5) goto L_0x03d7
                java.lang.String r4 = "ConstraintLayout"
                java.lang.String r6 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
            L_0x0216:
                android.util.Log.e(r4, r6)
                goto L_0x03d7
            L_0x021b:
                float r6 = r9.f1721A
                float r4 = r10.getFloat(r4, r6)
                r9.f1721A = r4
                goto L_0x03d7
            L_0x0225:
                float r6 = r9.f1785z
                float r4 = r10.getFloat(r4, r6)
                r9.f1785z = r4
                goto L_0x03d7
            L_0x022f:
                boolean r6 = r9.f1741U
                boolean r4 = r10.getBoolean(r4, r6)
                r9.f1741U = r4
                goto L_0x03d7
            L_0x0239:
                boolean r6 = r9.f1740T
                boolean r4 = r10.getBoolean(r4, r6)
                r9.f1740T = r4
                goto L_0x03d7
            L_0x0243:
                int r6 = r9.f1784y
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1784y = r4
                goto L_0x03d7
            L_0x024d:
                int r6 = r9.f1783x
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1783x = r4
                goto L_0x03d7
            L_0x0257:
                int r6 = r9.f1782w
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1782w = r4
                goto L_0x03d7
            L_0x0261:
                int r6 = r9.f1781v
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1781v = r4
                goto L_0x03d7
            L_0x026b:
                int r6 = r9.f1780u
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1780u = r4
                goto L_0x03d7
            L_0x0275:
                int r6 = r9.f1779t
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1779t = r4
                goto L_0x03d7
            L_0x027f:
                int r6 = r9.f1778s
                int r6 = r10.getResourceId(r4, r6)
                r9.f1778s = r6
                int r6 = r9.f1778s
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1778s = r4
                goto L_0x03d7
            L_0x0293:
                int r6 = r9.f1777r
                int r6 = r10.getResourceId(r4, r6)
                r9.f1777r = r6
                int r6 = r9.f1777r
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1777r = r4
                goto L_0x03d7
            L_0x02a7:
                int r6 = r9.f1776q
                int r6 = r10.getResourceId(r4, r6)
                r9.f1776q = r6
                int r6 = r9.f1776q
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1776q = r4
                goto L_0x03d7
            L_0x02bb:
                int r6 = r9.f1775p
                int r6 = r10.getResourceId(r4, r6)
                r9.f1775p = r6
                int r6 = r9.f1775p
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1775p = r4
                goto L_0x03d7
            L_0x02cf:
                int r6 = r9.f1771l
                int r6 = r10.getResourceId(r4, r6)
                r9.f1771l = r6
                int r6 = r9.f1771l
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1771l = r4
                goto L_0x03d7
            L_0x02e3:
                int r6 = r9.f1770k
                int r6 = r10.getResourceId(r4, r6)
                r9.f1770k = r6
                int r6 = r9.f1770k
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1770k = r4
                goto L_0x03d7
            L_0x02f7:
                int r6 = r9.f1769j
                int r6 = r10.getResourceId(r4, r6)
                r9.f1769j = r6
                int r6 = r9.f1769j
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1769j = r4
                goto L_0x03d7
            L_0x030b:
                int r6 = r9.f1768i
                int r6 = r10.getResourceId(r4, r6)
                r9.f1768i = r6
                int r6 = r9.f1768i
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1768i = r4
                goto L_0x03d7
            L_0x031f:
                int r6 = r9.f1767h
                int r6 = r10.getResourceId(r4, r6)
                r9.f1767h = r6
                int r6 = r9.f1767h
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1767h = r4
                goto L_0x03d7
            L_0x0333:
                int r6 = r9.f1766g
                int r6 = r10.getResourceId(r4, r6)
                r9.f1766g = r6
                int r6 = r9.f1766g
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1766g = r4
                goto L_0x03d7
            L_0x0347:
                int r6 = r9.f1765f
                int r6 = r10.getResourceId(r4, r6)
                r9.f1765f = r6
                int r6 = r9.f1765f
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1765f = r4
                goto L_0x03d7
            L_0x035b:
                int r6 = r9.f1764e
                int r6 = r10.getResourceId(r4, r6)
                r9.f1764e = r6
                int r6 = r9.f1764e
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1764e = r4
                goto L_0x03d7
            L_0x036e:
                int r6 = r9.f1763d
                int r6 = r10.getResourceId(r4, r6)
                r9.f1763d = r6
                int r6 = r9.f1763d
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1763d = r4
                goto L_0x03d7
            L_0x0381:
                float r6 = r9.f1762c
                float r4 = r10.getFloat(r4, r6)
                r9.f1762c = r4
                goto L_0x03d7
            L_0x038a:
                int r6 = r9.f1761b
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.f1761b = r4
                goto L_0x03d7
            L_0x0393:
                int r6 = r9.f1747a
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.f1747a = r4
                goto L_0x03d7
            L_0x039c:
                float r6 = r9.f1774o
                float r4 = r10.getFloat(r4, r6)
                r6 = 1135869952(0x43b40000, float:360.0)
                float r4 = r4 % r6
                r9.f1774o = r4
                float r4 = r9.f1774o
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 >= 0) goto L_0x03d7
                float r4 = r6 - r4
                float r4 = r4 % r6
                r9.f1774o = r4
                goto L_0x03d7
            L_0x03b3:
                int r6 = r9.f1773n
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.f1773n = r4
                goto L_0x03d7
            L_0x03bc:
                int r6 = r9.f1772m
                int r6 = r10.getResourceId(r4, r6)
                r9.f1772m = r6
                int r6 = r9.f1772m
                if (r6 != r0) goto L_0x03d7
                int r4 = r10.getInt(r4, r0)
                r9.f1772m = r4
                goto L_0x03d7
            L_0x03cf:
                int r6 = r9.f1739S
                int r4 = r10.getInt(r4, r6)
                r9.f1739S = r4
            L_0x03d7:
                int r1 = r1 + 1
                goto L_0x009a
            L_0x03db:
                r10.recycle()
                r9.mo3241a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.C0452a.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public C0452a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public void mo3241a() {
            this.f1745Y = false;
            this.f1742V = true;
            this.f1743W = true;
            if (this.width == -2 && this.f1740T) {
                this.f1742V = false;
                this.f1729I = 1;
            }
            if (this.height == -2 && this.f1741U) {
                this.f1743W = false;
                this.f1730J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f1742V = false;
                if (this.width == 0 && this.f1729I == 1) {
                    this.width = -2;
                    this.f1740T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f1743W = false;
                if (this.height == 0 && this.f1730J == 1) {
                    this.height = -2;
                    this.f1741U = true;
                }
            }
            if (this.f1762c != -1.0f || this.f1747a != -1 || this.f1761b != -1) {
                this.f1745Y = true;
                this.f1742V = true;
                this.f1743W = true;
                if (!(this.f1759al instanceof C0430i)) {
                    this.f1759al = new C0430i();
                }
                ((C0430i) this.f1759al).mo2996a(this.f1739S);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d6, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e5, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.f1751ad = r7
                r6.f1752ae = r7
                r6.f1749ab = r7
                r6.f1750ac = r7
                r6.f1753af = r7
                r6.f1754ag = r7
                int r2 = r6.f1779t
                r6.f1753af = r2
                int r2 = r6.f1781v
                r6.f1754ag = r2
                float r2 = r6.f1785z
                r6.f1755ah = r2
                int r2 = r6.f1747a
                r6.f1756ai = r2
                int r2 = r6.f1761b
                r6.f1757aj = r2
                float r2 = r6.f1762c
                r6.f1758ak = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x0098
                int r2 = r6.f1775p
                if (r2 == r7) goto L_0x0041
                r6.f1751ad = r2
            L_0x003f:
                r3 = 1
                goto L_0x0048
            L_0x0041:
                int r2 = r6.f1776q
                if (r2 == r7) goto L_0x0048
                r6.f1752ae = r2
                goto L_0x003f
            L_0x0048:
                int r2 = r6.f1777r
                if (r2 == r7) goto L_0x004f
                r6.f1750ac = r2
                r3 = 1
            L_0x004f:
                int r2 = r6.f1778s
                if (r2 == r7) goto L_0x0056
                r6.f1749ab = r2
                r3 = 1
            L_0x0056:
                int r2 = r6.f1783x
                if (r2 == r7) goto L_0x005c
                r6.f1754ag = r2
            L_0x005c:
                int r2 = r6.f1784y
                if (r2 == r7) goto L_0x0062
                r6.f1753af = r2
            L_0x0062:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x006c
                float r3 = r6.f1785z
                float r3 = r2 - r3
                r6.f1755ah = r3
            L_0x006c:
                boolean r3 = r6.f1745Y
                if (r3 == 0) goto L_0x00bc
                int r3 = r6.f1739S
                if (r3 != r4) goto L_0x00bc
                float r3 = r6.f1762c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0084
                float r2 = r2 - r3
                r6.f1758ak = r2
                r6.f1756ai = r7
                r6.f1757aj = r7
                goto L_0x00bc
            L_0x0084:
                int r2 = r6.f1747a
                if (r2 == r7) goto L_0x008f
                r6.f1757aj = r2
                r6.f1756ai = r7
            L_0x008c:
                r6.f1758ak = r4
                goto L_0x00bc
            L_0x008f:
                int r2 = r6.f1761b
                if (r2 == r7) goto L_0x00bc
                r6.f1756ai = r2
                r6.f1757aj = r7
                goto L_0x008c
            L_0x0098:
                int r2 = r6.f1775p
                if (r2 == r7) goto L_0x009e
                r6.f1750ac = r2
            L_0x009e:
                int r2 = r6.f1776q
                if (r2 == r7) goto L_0x00a4
                r6.f1749ab = r2
            L_0x00a4:
                int r2 = r6.f1777r
                if (r2 == r7) goto L_0x00aa
                r6.f1751ad = r2
            L_0x00aa:
                int r2 = r6.f1778s
                if (r2 == r7) goto L_0x00b0
                r6.f1752ae = r2
            L_0x00b0:
                int r2 = r6.f1783x
                if (r2 == r7) goto L_0x00b6
                r6.f1753af = r2
            L_0x00b6:
                int r2 = r6.f1784y
                if (r2 == r7) goto L_0x00bc
                r6.f1754ag = r2
            L_0x00bc:
                int r2 = r6.f1777r
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1778s
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1776q
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1775p
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1765f
                if (r2 == r7) goto L_0x00db
                r6.f1751ad = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e8
                if (r1 <= 0) goto L_0x00e8
            L_0x00d8:
                r6.rightMargin = r1
                goto L_0x00e8
            L_0x00db:
                int r2 = r6.f1766g
                if (r2 == r7) goto L_0x00e8
                r6.f1752ae = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e8
                if (r1 <= 0) goto L_0x00e8
                goto L_0x00d8
            L_0x00e8:
                int r1 = r6.f1763d
                if (r1 == r7) goto L_0x00f7
                r6.f1749ab = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
            L_0x00f4:
                r6.leftMargin = r0
                goto L_0x0104
            L_0x00f7:
                int r1 = r6.f1764e
                if (r1 == r7) goto L_0x0104
                r6.f1750ac = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                goto L_0x00f4
            L_0x0104:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.C0452a.resolveLayoutDirection(int):void");
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1861b(attributeSet);
    }

    /* renamed from: a */
    private void m1857a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0452a aVar = (C0452a) childAt.getLayoutParams();
                C0425f fVar = aVar.f1759al;
                if (!aVar.f1745Y && !aVar.f1746Z) {
                    fVar.mo3058e(childAt.getVisibility());
                    int i8 = aVar.width;
                    int i9 = aVar.height;
                    if (aVar.f1742V || aVar.f1743W || (!aVar.f1742V && aVar.f1729I == 1) || aVar.width == -1 || (!aVar.f1743W && (aVar.f1730J == 1 || aVar.height == -1))) {
                        if (i8 == 0) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -2);
                            z2 = true;
                        } else if (i8 == -1) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i8 == -2;
                            i3 = getChildMeasureSpec(i5, paddingLeft, i8);
                        }
                        if (i9 == 0) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -2);
                            z = true;
                        } else if (i9 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -1);
                            z = false;
                        } else {
                            z = i9 == -2;
                            i4 = getChildMeasureSpec(i6, paddingTop, i9);
                        }
                        childAt.measure(i3, i4);
                        C0446f fVar2 = this.f1720t;
                        if (fVar2 != null) {
                            fVar2.f1652a++;
                        }
                        fVar.mo3048b(i8 == -2);
                        fVar.mo3053c(i9 == -2);
                        i8 = childAt.getMeasuredWidth();
                        i9 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fVar.mo3070j(i8);
                    fVar.mo3072k(i9);
                    if (z2) {
                        fVar.mo3078n(i8);
                    }
                    if (z) {
                        fVar.mo3080o(i9);
                    }
                    if (aVar.f1744X && (baseline = childAt.getBaseline()) != -1) {
                        fVar.mo3084q(baseline);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private final C0425f m1858b(int i) {
        if (i == 0) {
            return this.f1702b;
        }
        View view = this.f1701a.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1702b;
        }
        if (view == null) {
            return null;
        }
        return ((C0452a) view.getLayoutParams()).f1759al;
    }

    /* renamed from: b */
    private void m1859b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.f1708h.clear();
            m1862c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02cc  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1860b(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00de
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d6
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r10 = (androidx.constraintlayout.widget.ConstraintLayout.C0452a) r10
            androidx.constraintlayout.a.a.f r15 = r10.f1759al
            boolean r6 = r10.f1745Y
            if (r6 != 0) goto L_0x00d6
            boolean r6 = r10.f1746Z
            if (r6 == 0) goto L_0x0042
            goto L_0x00d6
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.mo3058e(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c6
            if (r13 != 0) goto L_0x0053
            goto L_0x00c6
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.a.f r11 = r0.f1720t
            if (r11 == 0) goto L_0x0077
            r12 = r3
            long r2 = r11.f1652a
            long r2 = r2 + r8
            r11.f1652a = r2
            goto L_0x0078
        L_0x0077:
            r12 = r3
        L_0x0078:
            r2 = -2
            if (r6 != r2) goto L_0x007d
            r3 = 1
            goto L_0x007e
        L_0x007d:
            r3 = 0
        L_0x007e:
            r15.mo3048b((boolean) r3)
            if (r13 != r2) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            r15.mo3053c((boolean) r2)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.mo3070j(r2)
            r15.mo3072k(r3)
            if (r16 == 0) goto L_0x009c
            r15.mo3078n(r2)
        L_0x009c:
            if (r17 == 0) goto L_0x00a1
            r15.mo3080o(r3)
        L_0x00a1:
            boolean r6 = r10.f1744X
            if (r6 == 0) goto L_0x00af
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00af
            r15.mo3084q(r6)
        L_0x00af:
            boolean r6 = r10.f1742V
            if (r6 == 0) goto L_0x00d7
            boolean r6 = r10.f1743W
            if (r6 == 0) goto L_0x00d7
            androidx.constraintlayout.a.a.n r6 = r15.mo3067i()
            r6.mo3137a(r2)
            androidx.constraintlayout.a.a.n r2 = r15.mo3069j()
            r2.mo3137a(r3)
            goto L_0x00d7
        L_0x00c6:
            r12 = r3
            androidx.constraintlayout.a.a.n r2 = r15.mo3067i()
            r2.mo3140e()
            androidx.constraintlayout.a.a.n r2 = r15.mo3069j()
            r2.mo3140e()
            goto L_0x00d7
        L_0x00d6:
            r12 = r3
        L_0x00d7:
            int r7 = r7 + 1
            r3 = r12
            r2 = r25
            goto L_0x001d
        L_0x00de:
            r12 = r3
            androidx.constraintlayout.a.a.g r2 = r0.f1702b
            r2.mo3104P()
            r2 = 0
        L_0x00e5:
            if (r2 >= r5) goto L_0x02e2
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x00f3
            goto L_0x02ce
        L_0x00f3:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r6 = (androidx.constraintlayout.widget.ConstraintLayout.C0452a) r6
            androidx.constraintlayout.a.a.f r7 = r6.f1759al
            boolean r11 = r6.f1745Y
            if (r11 != 0) goto L_0x02ce
            boolean r11 = r6.f1746Z
            if (r11 == 0) goto L_0x0105
            goto L_0x02ce
        L_0x0105:
            int r11 = r3.getVisibility()
            r7.mo3058e(r11)
            int r11 = r6.width
            int r13 = r6.height
            if (r11 == 0) goto L_0x0116
            if (r13 == 0) goto L_0x0116
            goto L_0x02ce
        L_0x0116:
            androidx.constraintlayout.a.a.e$c r14 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            androidx.constraintlayout.a.a.e r14 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r14)
            androidx.constraintlayout.a.a.m r14 = r14.mo3004a()
            androidx.constraintlayout.a.a.e$c r15 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e r15 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r15)
            androidx.constraintlayout.a.a.m r15 = r15.mo3004a()
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            androidx.constraintlayout.a.a.e r10 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r10)
            androidx.constraintlayout.a.a.e r10 = r10.mo3014g()
            if (r10 == 0) goto L_0x0144
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e r10 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r10)
            androidx.constraintlayout.a.a.e r10 = r10.mo3014g()
            if (r10 == 0) goto L_0x0144
            r10 = 1
            goto L_0x0145
        L_0x0144:
            r10 = 0
        L_0x0145:
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e r8 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r8)
            androidx.constraintlayout.a.a.m r8 = r8.mo3004a()
            androidx.constraintlayout.a.a.e$c r9 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e r9 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r9)
            androidx.constraintlayout.a.a.m r9 = r9.mo3004a()
            r17 = r5
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e r5 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r5)
            androidx.constraintlayout.a.a.e r5 = r5.mo3014g()
            if (r5 == 0) goto L_0x0175
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e r5 = r7.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r5)
            androidx.constraintlayout.a.a.e r5 = r5.mo3014g()
            if (r5 == 0) goto L_0x0175
            r5 = 1
            goto L_0x0176
        L_0x0175:
            r5 = 0
        L_0x0176:
            if (r11 != 0) goto L_0x0188
            if (r13 != 0) goto L_0x0188
            if (r10 == 0) goto L_0x0188
            if (r5 == 0) goto L_0x0188
            r20 = r2
            r3 = -1
            r5 = r25
            r10 = -2
            r18 = 1
            goto L_0x02d8
        L_0x0188:
            r20 = r2
            androidx.constraintlayout.a.a.g r2 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r2 = r2.mo3024F()
            r21 = r6
            androidx.constraintlayout.a.a.f$a r6 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r2 == r6) goto L_0x0198
            r6 = 1
            goto L_0x0199
        L_0x0198:
            r6 = 0
        L_0x0199:
            androidx.constraintlayout.a.a.g r2 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r2 = r2.mo3025G()
            androidx.constraintlayout.a.a.f$a r0 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r2 == r0) goto L_0x01a5
            r0 = 1
            goto L_0x01a6
        L_0x01a5:
            r0 = 0
        L_0x01a6:
            if (r6 != 0) goto L_0x01af
            androidx.constraintlayout.a.a.n r2 = r7.mo3067i()
            r2.mo3140e()
        L_0x01af:
            if (r0 != 0) goto L_0x01b8
            androidx.constraintlayout.a.a.n r2 = r7.mo3069j()
            r2.mo3140e()
        L_0x01b8:
            if (r11 != 0) goto L_0x01f0
            if (r6 == 0) goto L_0x01e7
            boolean r2 = r7.mo3057d()
            if (r2 == 0) goto L_0x01e7
            if (r10 == 0) goto L_0x01e7
            boolean r2 = r14.mo3142g()
            if (r2 == 0) goto L_0x01e7
            boolean r2 = r15.mo3142g()
            if (r2 == 0) goto L_0x01e7
            float r2 = r15.mo3135d()
            float r10 = r14.mo3135d()
            float r2 = r2 - r10
            int r11 = (int) r2
            androidx.constraintlayout.a.a.n r2 = r7.mo3067i()
            r2.mo3137a(r11)
            int r2 = getChildMeasureSpec(r1, r4, r11)
            r14 = r2
            goto L_0x01f8
        L_0x01e7:
            r2 = -2
            int r6 = getChildMeasureSpec(r1, r4, r2)
            r14 = r6
            r2 = 1
            r6 = 0
            goto L_0x0204
        L_0x01f0:
            r2 = -2
            r10 = -1
            if (r11 != r10) goto L_0x01fa
            int r14 = getChildMeasureSpec(r1, r4, r10)
        L_0x01f8:
            r2 = 0
            goto L_0x0204
        L_0x01fa:
            if (r11 != r2) goto L_0x01fe
            r2 = 1
            goto L_0x01ff
        L_0x01fe:
            r2 = 0
        L_0x01ff:
            int r10 = getChildMeasureSpec(r1, r4, r11)
            r14 = r10
        L_0x0204:
            if (r13 != 0) goto L_0x0240
            if (r0 == 0) goto L_0x0236
            boolean r10 = r7.mo3060e()
            if (r10 == 0) goto L_0x0236
            if (r5 == 0) goto L_0x0236
            boolean r5 = r8.mo3142g()
            if (r5 == 0) goto L_0x0236
            boolean r5 = r9.mo3142g()
            if (r5 == 0) goto L_0x0236
            float r5 = r9.mo3135d()
            float r8 = r8.mo3135d()
            float r5 = r5 - r8
            int r13 = (int) r5
            androidx.constraintlayout.a.a.n r5 = r7.mo3069j()
            r5.mo3137a(r13)
            r5 = r25
            int r8 = getChildMeasureSpec(r5, r12, r13)
            r9 = r0
            r0 = r8
            goto L_0x024c
        L_0x0236:
            r5 = r25
            r8 = -2
            int r0 = getChildMeasureSpec(r5, r12, r8)
            r8 = 1
            r9 = 0
            goto L_0x025c
        L_0x0240:
            r5 = r25
            r8 = -2
            r9 = -1
            if (r13 != r9) goto L_0x024e
            int r10 = getChildMeasureSpec(r5, r12, r9)
            r9 = r0
            r0 = r10
        L_0x024c:
            r8 = 0
            goto L_0x025c
        L_0x024e:
            if (r13 != r8) goto L_0x0252
            r8 = 1
            goto L_0x0253
        L_0x0252:
            r8 = 0
        L_0x0253:
            int r9 = getChildMeasureSpec(r5, r12, r13)
            r22 = r9
            r9 = r0
            r0 = r22
        L_0x025c:
            r3.measure(r14, r0)
            r0 = r23
            androidx.constraintlayout.a.f r10 = r0.f1720t
            if (r10 == 0) goto L_0x026e
            long r14 = r10.f1652a
            r18 = 1
            long r14 = r14 + r18
            r10.f1652a = r14
            goto L_0x0270
        L_0x026e:
            r18 = 1
        L_0x0270:
            r10 = -2
            if (r11 != r10) goto L_0x0275
            r11 = 1
            goto L_0x0276
        L_0x0275:
            r11 = 0
        L_0x0276:
            r7.mo3048b((boolean) r11)
            if (r13 != r10) goto L_0x027d
            r11 = 1
            goto L_0x027e
        L_0x027d:
            r11 = 0
        L_0x027e:
            r7.mo3053c((boolean) r11)
            int r11 = r3.getMeasuredWidth()
            int r13 = r3.getMeasuredHeight()
            r7.mo3070j(r11)
            r7.mo3072k(r13)
            if (r2 == 0) goto L_0x0294
            r7.mo3078n(r11)
        L_0x0294:
            if (r8 == 0) goto L_0x0299
            r7.mo3080o(r13)
        L_0x0299:
            if (r6 == 0) goto L_0x02a3
            androidx.constraintlayout.a.a.n r2 = r7.mo3067i()
            r2.mo3137a(r11)
            goto L_0x02aa
        L_0x02a3:
            androidx.constraintlayout.a.a.n r2 = r7.mo3067i()
            r2.mo3138c()
        L_0x02aa:
            if (r9 == 0) goto L_0x02b4
            androidx.constraintlayout.a.a.n r2 = r7.mo3069j()
            r2.mo3137a(r13)
            goto L_0x02bb
        L_0x02b4:
            androidx.constraintlayout.a.a.n r2 = r7.mo3069j()
            r2.mo3138c()
        L_0x02bb:
            r6 = r21
            boolean r2 = r6.f1744X
            if (r2 == 0) goto L_0x02cc
            int r2 = r3.getBaseline()
            r3 = -1
            if (r2 == r3) goto L_0x02d8
            r7.mo3084q(r2)
            goto L_0x02d8
        L_0x02cc:
            r3 = -1
            goto L_0x02d8
        L_0x02ce:
            r20 = r2
            r17 = r5
            r18 = r8
            r3 = -1
            r5 = r25
            r10 = -2
        L_0x02d8:
            int r2 = r20 + 1
            r5 = r17
            r8 = r18
            r10 = 8
            goto L_0x00e5
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m1860b(int, int):void");
    }

    /* renamed from: b */
    private void m1861b(AttributeSet attributeSet) {
        this.f1702b.mo3039a((Object) this);
        this.f1701a.put(getId(), this);
        this.f1715o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0462f.C0464b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0462f.C0464b.ConstraintLayout_Layout_android_minWidth) {
                    this.f1709i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1709i);
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_android_minHeight) {
                    this.f1710j = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1710j);
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1711k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1711k);
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1712l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1712l);
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1714n = obtainStyledAttributes.getInt(index, this.f1714n);
                } else if (index == C0462f.C0464b.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f1715o = new C0456c();
                        this.f1715o.mo3262a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f1715o = null;
                    }
                    this.f1716p = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1702b.mo2996a(this.f1714n);
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03a9  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1862c() {
        /*
            r26 = this;
            r0 = r26
            boolean r1 = r26.isInEditMode()
            int r2 = r26.getChildCount()
            r3 = 0
            r4 = -1
            if (r1 == 0) goto L_0x0048
            r5 = 0
        L_0x000f:
            if (r5 >= r2) goto L_0x0048
            android.view.View r6 = r0.getChildAt(r5)
            android.content.res.Resources r7 = r26.getResources()     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            r0.mo3214a(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0045 }
            r8 = 47
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            if (r8 == r4) goto L_0x003a
            int r8 = r8 + 1
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x003a:
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            androidx.constraintlayout.a.a.f r6 = r0.m1858b((int) r6)     // Catch:{ NotFoundException -> 0x0045 }
            r6.mo3040a((java.lang.String) r7)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x0045:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x0048:
            r5 = 0
        L_0x0049:
            if (r5 >= r2) goto L_0x005c
            android.view.View r6 = r0.getChildAt(r5)
            androidx.constraintlayout.a.a.f r6 = r0.mo3210a((android.view.View) r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            r6.mo3062f()
        L_0x0059:
            int r5 = r5 + 1
            goto L_0x0049
        L_0x005c:
            int r5 = r0.f1716p
            if (r5 == r4) goto L_0x007e
            r5 = 0
        L_0x0061:
            if (r5 >= r2) goto L_0x007e
            android.view.View r6 = r0.getChildAt(r5)
            int r7 = r6.getId()
            int r8 = r0.f1716p
            if (r7 != r8) goto L_0x007b
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.C0459d
            if (r7 == 0) goto L_0x007b
            androidx.constraintlayout.widget.d r6 = (androidx.constraintlayout.widget.C0459d) r6
            androidx.constraintlayout.widget.c r6 = r6.getConstraintSet()
            r0.f1715o = r6
        L_0x007b:
            int r5 = r5 + 1
            goto L_0x0061
        L_0x007e:
            androidx.constraintlayout.widget.c r5 = r0.f1715o
            if (r5 == 0) goto L_0x0085
            r5.mo3263a((androidx.constraintlayout.widget.ConstraintLayout) r0)
        L_0x0085:
            androidx.constraintlayout.a.a.g r5 = r0.f1702b
            r5.mo3148U()
            java.util.ArrayList<androidx.constraintlayout.widget.b> r5 = r0.f1707g
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00a3
            r6 = 0
        L_0x0093:
            if (r6 >= r5) goto L_0x00a3
            java.util.ArrayList<androidx.constraintlayout.widget.b> r7 = r0.f1707g
            java.lang.Object r7 = r7.get(r6)
            androidx.constraintlayout.widget.b r7 = (androidx.constraintlayout.widget.C0455b) r7
            r7.mo3254a((androidx.constraintlayout.widget.ConstraintLayout) r0)
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00a3:
            r5 = 0
        L_0x00a4:
            if (r5 >= r2) goto L_0x00b6
            android.view.View r6 = r0.getChildAt(r5)
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.C0461e
            if (r7 == 0) goto L_0x00b3
            androidx.constraintlayout.widget.e r6 = (androidx.constraintlayout.widget.C0461e) r6
            r6.mo3275a(r0)
        L_0x00b3:
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x00b6:
            r5 = 0
        L_0x00b7:
            if (r5 >= r2) goto L_0x03dc
            android.view.View r6 = r0.getChildAt(r5)
            androidx.constraintlayout.a.a.f r13 = r0.mo3210a((android.view.View) r6)
            if (r13 != 0) goto L_0x00c5
            goto L_0x03d8
        L_0x00c5:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            r14 = r7
            androidx.constraintlayout.widget.ConstraintLayout$a r14 = (androidx.constraintlayout.widget.ConstraintLayout.C0452a) r14
            r14.mo3241a()
            boolean r7 = r14.f1760am
            if (r7 == 0) goto L_0x00d6
            r14.f1760am = r3
            goto L_0x0108
        L_0x00d6:
            if (r1 == 0) goto L_0x0108
            android.content.res.Resources r7 = r26.getResources()     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0107 }
            r0.mo3214a(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0107 }
            java.lang.String r8 = "id/"
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r8 + 3
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0107 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0107 }
            androidx.constraintlayout.a.a.f r8 = r0.m1858b((int) r8)     // Catch:{ NotFoundException -> 0x0107 }
            r8.mo3040a((java.lang.String) r7)     // Catch:{ NotFoundException -> 0x0107 }
            goto L_0x0108
        L_0x0107:
        L_0x0108:
            int r7 = r6.getVisibility()
            r13.mo3058e(r7)
            boolean r7 = r14.f1748aa
            if (r7 == 0) goto L_0x0118
            r7 = 8
            r13.mo3058e(r7)
        L_0x0118:
            r13.mo3039a((java.lang.Object) r6)
            androidx.constraintlayout.a.a.g r6 = r0.f1702b
            r6.mo3149b(r13)
            boolean r6 = r14.f1743W
            if (r6 == 0) goto L_0x0128
            boolean r6 = r14.f1742V
            if (r6 != 0) goto L_0x012d
        L_0x0128:
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r6 = r0.f1708h
            r6.add(r13)
        L_0x012d:
            boolean r6 = r14.f1745Y
            r7 = 17
            if (r6 == 0) goto L_0x015e
            androidx.constraintlayout.a.a.i r13 = (androidx.constraintlayout.p019a.p020a.C0430i) r13
            int r6 = r14.f1756ai
            int r8 = r14.f1757aj
            float r9 = r14.f1758ak
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 >= r7) goto L_0x0145
            int r6 = r14.f1747a
            int r8 = r14.f1761b
            float r9 = r14.f1762c
        L_0x0145:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0150
            r13.mo3119e(r9)
            goto L_0x03d8
        L_0x0150:
            if (r6 == r4) goto L_0x0157
            r13.mo3120u(r6)
            goto L_0x03d8
        L_0x0157:
            if (r8 == r4) goto L_0x03d8
            r13.mo3121v(r8)
            goto L_0x03d8
        L_0x015e:
            int r6 = r14.f1763d
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1764e
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1765f
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1766g
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1776q
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1775p
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1777r
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1778s
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1767h
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1768i
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1769j
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1770k
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1771l
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1737Q
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1738R
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.f1772m
            if (r6 != r4) goto L_0x01a6
            int r6 = r14.width
            if (r6 == r4) goto L_0x01a6
            int r6 = r14.height
            if (r6 != r4) goto L_0x03d8
        L_0x01a6:
            int r6 = r14.f1749ab
            int r8 = r14.f1750ac
            int r9 = r14.f1751ad
            int r10 = r14.f1752ae
            int r11 = r14.f1753af
            int r12 = r14.f1754ag
            float r15 = r14.f1755ah
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 >= r7) goto L_0x01f1
            int r3 = r14.f1763d
            int r6 = r14.f1764e
            int r9 = r14.f1765f
            int r10 = r14.f1766g
            int r7 = r14.f1779t
            int r8 = r14.f1781v
            float r15 = r14.f1785z
            if (r3 != r4) goto L_0x01d7
            if (r6 != r4) goto L_0x01d7
            int r11 = r14.f1776q
            if (r11 == r4) goto L_0x01d1
            int r3 = r14.f1776q
            goto L_0x01d7
        L_0x01d1:
            int r11 = r14.f1775p
            if (r11 == r4) goto L_0x01d7
            int r6 = r14.f1775p
        L_0x01d7:
            r25 = r6
            r6 = r3
            r3 = r25
            if (r9 != r4) goto L_0x01ed
            if (r10 != r4) goto L_0x01ed
            int r11 = r14.f1777r
            if (r11 == r4) goto L_0x01e7
            int r9 = r14.f1777r
            goto L_0x01ed
        L_0x01e7:
            int r11 = r14.f1778s
            if (r11 == r4) goto L_0x01ed
            int r10 = r14.f1778s
        L_0x01ed:
            r12 = r7
            r16 = r8
            goto L_0x01f5
        L_0x01f1:
            r3 = r8
            r16 = r12
            r12 = r11
        L_0x01f5:
            r11 = r10
            r10 = r15
            r15 = r9
            int r7 = r14.f1772m
            if (r7 == r4) goto L_0x020d
            int r3 = r14.f1772m
            androidx.constraintlayout.a.a.f r3 = r0.m1858b((int) r3)
            if (r3 == 0) goto L_0x0329
            float r6 = r14.f1774o
            int r7 = r14.f1773n
            r13.mo3037a((androidx.constraintlayout.p019a.p020a.C0425f) r3, (float) r6, (int) r7)
            goto L_0x0329
        L_0x020d:
            if (r6 == r4) goto L_0x022a
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r6)
            if (r9 == 0) goto L_0x0225
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            int r6 = r14.leftMargin
            r7 = r13
            r17 = r10
            r10 = r3
            r3 = r11
            r11 = r6
            r7.mo3034a(r8, r9, r10, r11, r12)
            goto L_0x0228
        L_0x0225:
            r17 = r10
            r3 = r11
        L_0x0228:
            r6 = r3
            goto L_0x023f
        L_0x022a:
            r17 = r10
            r6 = r11
            if (r3 == r4) goto L_0x023f
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r3)
            if (r9 == 0) goto L_0x023f
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            int r11 = r14.leftMargin
            r7 = r13
            r7.mo3034a(r8, r9, r10, r11, r12)
        L_0x023f:
            if (r15 == r4) goto L_0x024c
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r15)
            if (r9 == 0) goto L_0x0260
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            goto L_0x0258
        L_0x024c:
            if (r6 == r4) goto L_0x0260
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r6)
            if (r9 == 0) goto L_0x0260
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
        L_0x0258:
            int r11 = r14.rightMargin
            r7 = r13
            r12 = r16
            r7.mo3034a(r8, r9, r10, r11, r12)
        L_0x0260:
            int r3 = r14.f1767h
            if (r3 == r4) goto L_0x0271
            int r3 = r14.f1767h
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r3)
            if (r9 == 0) goto L_0x0289
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            goto L_0x0281
        L_0x0271:
            int r3 = r14.f1768i
            if (r3 == r4) goto L_0x0289
            int r3 = r14.f1768i
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r3)
            if (r9 == 0) goto L_0x0289
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
        L_0x0281:
            int r11 = r14.topMargin
            int r12 = r14.f1780u
            r7 = r13
            r7.mo3034a(r8, r9, r10, r11, r12)
        L_0x0289:
            int r3 = r14.f1769j
            if (r3 == r4) goto L_0x029a
            int r3 = r14.f1769j
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r3)
            if (r9 == 0) goto L_0x02b2
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            goto L_0x02aa
        L_0x029a:
            int r3 = r14.f1770k
            if (r3 == r4) goto L_0x02b2
            int r3 = r14.f1770k
            androidx.constraintlayout.a.a.f r9 = r0.m1858b((int) r3)
            if (r9 == 0) goto L_0x02b2
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
        L_0x02aa:
            int r11 = r14.bottomMargin
            int r12 = r14.f1782w
            r7 = r13
            r7.mo3034a(r8, r9, r10, r11, r12)
        L_0x02b2:
            int r3 = r14.f1771l
            if (r3 == r4) goto L_0x0308
            android.util.SparseArray<android.view.View> r3 = r0.f1701a
            int r6 = r14.f1771l
            java.lang.Object r3 = r3.get(r6)
            android.view.View r3 = (android.view.View) r3
            int r6 = r14.f1771l
            androidx.constraintlayout.a.a.f r6 = r0.m1858b((int) r6)
            if (r6 == 0) goto L_0x0308
            if (r3 == 0) goto L_0x0308
            android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
            boolean r7 = r7 instanceof androidx.constraintlayout.widget.ConstraintLayout.C0452a
            if (r7 == 0) goto L_0x0308
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r3 = (androidx.constraintlayout.widget.ConstraintLayout.C0452a) r3
            r7 = 1
            r14.f1744X = r7
            r3.f1744X = r7
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BASELINE
            androidx.constraintlayout.a.a.e r18 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BASELINE
            androidx.constraintlayout.a.a.e r19 = r6.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            r20 = 0
            r21 = -1
            androidx.constraintlayout.a.a.e$b r22 = androidx.constraintlayout.p019a.p020a.C0420e.C0423b.STRONG
            r23 = 0
            r24 = 1
            r18.mo3007a(r19, r20, r21, r22, r23, r24)
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            r3.mo3016i()
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            r3.mo3016i()
        L_0x0308:
            r3 = 1056964608(0x3f000000, float:0.5)
            r6 = 0
            r15 = r17
            int r7 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r7 < 0) goto L_0x0318
            int r7 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0318
            r13.mo3029a((float) r15)
        L_0x0318:
            float r7 = r14.f1721A
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0329
            float r6 = r14.f1721A
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0329
            float r3 = r14.f1721A
            r13.mo3042b((float) r3)
        L_0x0329:
            if (r1 == 0) goto L_0x033a
            int r3 = r14.f1737Q
            if (r3 != r4) goto L_0x0333
            int r3 = r14.f1738R
            if (r3 == r4) goto L_0x033a
        L_0x0333:
            int r3 = r14.f1737Q
            int r6 = r14.f1738R
            r13.mo3030a(r3, r6)
        L_0x033a:
            boolean r3 = r14.f1742V
            if (r3 != 0) goto L_0x0363
            int r3 = r14.width
            if (r3 != r4) goto L_0x035c
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_PARENT
            r13.mo3035a((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r3)
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            int r6 = r14.leftMargin
            r3.f1444d = r6
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            int r6 = r14.rightMargin
            r3.f1444d = r6
            goto L_0x036d
        L_0x035c:
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            r13.mo3035a((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r3)
            r3 = 0
            goto L_0x036a
        L_0x0363:
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r13.mo3035a((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r3)
            int r3 = r14.width
        L_0x036a:
            r13.mo3070j(r3)
        L_0x036d:
            boolean r3 = r14.f1743W
            if (r3 != 0) goto L_0x039a
            int r3 = r14.height
            if (r3 != r4) goto L_0x0390
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_PARENT
            r13.mo3045b((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r3)
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            int r6 = r14.topMargin
            r3.f1444d = r6
            androidx.constraintlayout.a.a.e$c r3 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e r3 = r13.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r3)
            int r6 = r14.bottomMargin
            r3.f1444d = r6
            r3 = 0
            goto L_0x03a5
        L_0x0390:
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            r13.mo3045b((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r3)
            r3 = 0
            r13.mo3072k(r3)
            goto L_0x03a5
        L_0x039a:
            r3 = 0
            androidx.constraintlayout.a.a.f$a r6 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r13.mo3045b((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r6)
            int r6 = r14.height
            r13.mo3072k(r6)
        L_0x03a5:
            java.lang.String r6 = r14.f1722B
            if (r6 == 0) goto L_0x03ae
            java.lang.String r6 = r14.f1722B
            r13.mo3047b((java.lang.String) r6)
        L_0x03ae:
            float r6 = r14.f1725E
            r13.mo3049c((float) r6)
            float r6 = r14.f1726F
            r13.mo3054d((float) r6)
            int r6 = r14.f1727G
            r13.mo3086r(r6)
            int r6 = r14.f1728H
            r13.mo3088s(r6)
            int r6 = r14.f1729I
            int r7 = r14.f1731K
            int r8 = r14.f1733M
            float r9 = r14.f1735O
            r13.mo3032a((int) r6, (int) r7, (int) r8, (float) r9)
            int r6 = r14.f1730J
            int r7 = r14.f1732L
            int r8 = r14.f1734N
            float r9 = r14.f1736P
            r13.mo3044b(r6, r7, r8, r9)
        L_0x03d8:
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x03dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m1862c():void");
    }

    /* renamed from: c */
    private void m1863c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        C0425f.C0427a aVar = C0425f.C0427a.FIXED;
        C0425f.C0427a aVar2 = C0425f.C0427a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = C0425f.C0427a.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.f1711k, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = C0425f.C0427a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = C0425f.C0427a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f1712l, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = C0425f.C0427a.WRAP_CONTENT;
        }
        this.f1702b.mo3074l(0);
        this.f1702b.mo3076m(0);
        this.f1702b.mo3035a(aVar);
        this.f1702b.mo3070j(size);
        this.f1702b.mo3045b(aVar2);
        this.f1702b.mo3072k(size2);
        this.f1702b.mo3074l((this.f1709i - getPaddingLeft()) - getPaddingRight());
        this.f1702b.mo3076m((this.f1710j - getPaddingTop()) - getPaddingBottom());
    }

    /* renamed from: d */
    private void m1864d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C0461e) {
                ((C0461e) childAt).mo3276b(this);
            }
        }
        int size = this.f1707g.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f1707g.get(i2).mo3256c(this);
            }
        }
    }

    /* renamed from: a */
    public View mo3209a(int i) {
        return this.f1701a.get(i);
    }

    /* renamed from: a */
    public final C0425f mo3210a(View view) {
        if (view == this) {
            return this.f1702b;
        }
        if (view == null) {
            return null;
        }
        return ((C0452a) view.getLayoutParams()).f1759al;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0452a generateDefaultLayoutParams() {
        return new C0452a(-2, -2);
    }

    /* renamed from: a */
    public C0452a generateLayoutParams(AttributeSet attributeSet) {
        return new C0452a(getContext(), attributeSet);
    }

    /* renamed from: a */
    public Object mo3213a(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f1717q;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1717q.get(str);
    }

    /* renamed from: a */
    public void mo3214a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1717q == null) {
                this.f1717q = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1717q.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3215a(String str) {
        this.f1702b.mo3102N();
        C0446f fVar = this.f1720t;
        if (fVar != null) {
            fVar.f1654c++;
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0452a;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = (float) i2;
                        float f2 = (float) (i2 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f3 = (float) i3;
                        float f4 = f;
                        float f5 = f;
                        float f6 = f3;
                        Paint paint2 = paint;
                        float f7 = f2;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f4, f6, f7, f3, paint3);
                        float parseInt4 = (float) (i3 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f2;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f6, f7, f9, paint3);
                        float f10 = parseInt4;
                        float f11 = f5;
                        canvas2.drawLine(f8, f10, f11, f9, paint3);
                        float f12 = f5;
                        canvas2.drawLine(f12, f10, f11, f3, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f13 = f2;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f12, f3, f13, parseInt4, paint6);
                        canvas2.drawLine(f12, parseInt4, f13, f3, paint6);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0452a(layoutParams);
    }

    public int getMaxHeight() {
        return this.f1712l;
    }

    public int getMaxWidth() {
        return this.f1711k;
    }

    public int getMinHeight() {
        return this.f1710j;
    }

    public int getMinWidth() {
        return this.f1709i;
    }

    public int getOptimizationLevel() {
        return this.f1702b.mo3098J();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0452a aVar = (C0452a) childAt.getLayoutParams();
            C0425f fVar = aVar.f1759al;
            if ((childAt.getVisibility() != 8 || aVar.f1745Y || aVar.f1746Z || isInEditMode) && !aVar.f1748aa) {
                int t = fVar.mo3089t();
                int u = fVar.mo3092u();
                int p = fVar.mo3081p() + t;
                int r = fVar.mo3085r() + u;
                childAt.layout(t, u, p, r);
                if ((childAt instanceof C0461e) && (content = ((C0461e) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(t, u, p, r);
                }
            }
        }
        int size = this.f1707g.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f1707g.get(i6).mo3255b(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r25)
            int r4 = android.view.View.MeasureSpec.getSize(r25)
            int r5 = android.view.View.MeasureSpec.getMode(r26)
            int r6 = android.view.View.MeasureSpec.getSize(r26)
            int r7 = r24.getPaddingLeft()
            int r8 = r24.getPaddingTop()
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            r9.mo3065h(r7)
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            r9.mo3068i(r8)
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            int r10 = r0.f1711k
            r9.mo3050c((int) r10)
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            int r10 = r0.f1712l
            r9.mo3055d((int) r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 0
            r11 = 1
            r12 = 17
            if (r9 < r12) goto L_0x004f
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            int r12 = r24.getLayoutDirection()
            if (r12 != r11) goto L_0x004b
            r12 = 1
            goto L_0x004c
        L_0x004b:
            r12 = 0
        L_0x004c:
            r9.mo3110a((boolean) r12)
        L_0x004f:
            r24.m1863c(r25, r26)
            androidx.constraintlayout.a.a.g r9 = r0.f1702b
            int r9 = r9.mo3081p()
            androidx.constraintlayout.a.a.g r12 = r0.f1702b
            int r12 = r12.mo3085r()
            boolean r13 = r0.f1713m
            if (r13 == 0) goto L_0x0069
            r0.f1713m = r10
            r24.m1859b()
            r13 = 1
            goto L_0x006a
        L_0x0069:
            r13 = 0
        L_0x006a:
            int r14 = r0.f1714n
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r14 == 0) goto L_0x0084
            androidx.constraintlayout.a.a.g r15 = r0.f1702b
            r15.mo3103O()
            androidx.constraintlayout.a.a.g r15 = r0.f1702b
            r15.mo3112f(r9, r12)
            r24.m1860b(r25, r26)
            goto L_0x0087
        L_0x0084:
            r24.m1857a((int) r25, (int) r26)
        L_0x0087:
            r24.m1864d()
            int r15 = r24.getChildCount()
            if (r15 <= 0) goto L_0x0097
            if (r13 == 0) goto L_0x0097
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            androidx.constraintlayout.p019a.p020a.C0416a.m1581a((androidx.constraintlayout.p019a.p020a.C0428g) r13)
        L_0x0097:
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            boolean r13 = r13.f1564as
            if (r13 == 0) goto L_0x00d7
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            boolean r13 = r13.f1565at
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == 0) goto L_0x00bb
            if (r3 != r15) goto L_0x00bb
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            int r13 = r13.f1567av
            if (r13 >= r4) goto L_0x00b4
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            int r11 = r13.f1567av
            r13.mo3070j(r11)
        L_0x00b4:
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r11.mo3035a((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r13)
        L_0x00bb:
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            boolean r11 = r11.f1566au
            if (r11 == 0) goto L_0x00d7
            if (r5 != r15) goto L_0x00d7
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            int r11 = r11.f1568aw
            if (r11 >= r6) goto L_0x00d0
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            int r13 = r11.f1568aw
            r11.mo3072k(r13)
        L_0x00d0:
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r11.mo3045b((androidx.constraintlayout.p019a.p020a.C0425f.C0427a) r13)
        L_0x00d7:
            int r11 = r0.f1714n
            r13 = 32
            r11 = r11 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r11 != r13) goto L_0x0133
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            int r11 = r11.mo3081p()
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            int r13 = r13.mo3085r()
            int r10 = r0.f1718r
            if (r10 == r11) goto L_0x00fa
            if (r3 != r15) goto L_0x00fa
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.f1563ar
            r10 = 0
            androidx.constraintlayout.p019a.p020a.C0416a.m1583a((java.util.List<androidx.constraintlayout.p019a.p020a.C0429h>) r3, (int) r10, (int) r11)
        L_0x00fa:
            int r3 = r0.f1719s
            if (r3 == r13) goto L_0x0108
            if (r5 != r15) goto L_0x0108
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.f1563ar
            r5 = 1
            androidx.constraintlayout.p019a.p020a.C0416a.m1583a((java.util.List<androidx.constraintlayout.p019a.p020a.C0429h>) r3, (int) r5, (int) r13)
        L_0x0108:
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            boolean r3 = r3.f1565at
            if (r3 == 0) goto L_0x011d
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            int r3 = r3.f1567av
            if (r3 <= r4) goto L_0x011d
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.f1563ar
            r10 = 0
            androidx.constraintlayout.p019a.p020a.C0416a.m1583a((java.util.List<androidx.constraintlayout.p019a.p020a.C0429h>) r3, (int) r10, (int) r4)
            goto L_0x011e
        L_0x011d:
            r10 = 0
        L_0x011e:
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            boolean r3 = r3.f1566au
            if (r3 == 0) goto L_0x0133
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            int r3 = r3.f1568aw
            if (r3 <= r6) goto L_0x0133
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.f1563ar
            r4 = 1
            androidx.constraintlayout.p019a.p020a.C0416a.m1583a((java.util.List<androidx.constraintlayout.p019a.p020a.C0429h>) r3, (int) r4, (int) r6)
            goto L_0x0134
        L_0x0133:
            r4 = 1
        L_0x0134:
            int r3 = r24.getChildCount()
            if (r3 <= 0) goto L_0x013f
            java.lang.String r3 = "First pass"
            r0.mo3215a((java.lang.String) r3)
        L_0x013f:
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r3 = r0.f1708h
            int r3 = r3.size()
            int r5 = r24.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r24.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x0371
            androidx.constraintlayout.a.a.g r6 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r6 = r6.mo3024F()
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r6 != r11) goto L_0x015d
            r6 = 1
            goto L_0x015e
        L_0x015d:
            r6 = 0
        L_0x015e:
            androidx.constraintlayout.a.a.g r11 = r0.f1702b
            androidx.constraintlayout.a.a.f$a r11 = r11.mo3025G()
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r11 != r13) goto L_0x016a
            r11 = 1
            goto L_0x016b
        L_0x016a:
            r11 = 0
        L_0x016b:
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            int r13 = r13.mo3081p()
            int r4 = r0.f1709i
            int r4 = java.lang.Math.max(r13, r4)
            androidx.constraintlayout.a.a.g r13 = r0.f1702b
            int r13 = r13.mo3085r()
            int r10 = r0.f1710j
            int r10 = java.lang.Math.max(r13, r10)
            r13 = r4
            r5 = r10
            r4 = 0
            r10 = 0
            r17 = 0
        L_0x0189:
            r18 = 1
            if (r4 >= r3) goto L_0x02ca
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r15 = r0.f1708h
            java.lang.Object r15 = r15.get(r4)
            androidx.constraintlayout.a.a.f r15 = (androidx.constraintlayout.p019a.p020a.C0425f) r15
            java.lang.Object r20 = r15.mo3020B()
            r21 = r3
            r3 = r20
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x01a9
            r20 = r9
            r23 = r10
            r22 = r12
            goto L_0x02b6
        L_0x01a9:
            android.view.ViewGroup$LayoutParams r20 = r3.getLayoutParams()
            r22 = r12
            r12 = r20
            androidx.constraintlayout.widget.ConstraintLayout$a r12 = (androidx.constraintlayout.widget.ConstraintLayout.C0452a) r12
            r20 = r9
            boolean r9 = r12.f1746Z
            if (r9 != 0) goto L_0x02b4
            boolean r9 = r12.f1745Y
            if (r9 == 0) goto L_0x01bf
            goto L_0x02b4
        L_0x01bf:
            int r9 = r3.getVisibility()
            r23 = r10
            r10 = 8
            if (r9 != r10) goto L_0x01cb
        L_0x01c9:
            goto L_0x02b6
        L_0x01cb:
            if (r14 == 0) goto L_0x01e2
            androidx.constraintlayout.a.a.n r9 = r15.mo3067i()
            boolean r9 = r9.mo3142g()
            if (r9 == 0) goto L_0x01e2
            androidx.constraintlayout.a.a.n r9 = r15.mo3069j()
            boolean r9 = r9.mo3142g()
            if (r9 == 0) goto L_0x01e2
            goto L_0x01c9
        L_0x01e2:
            int r9 = r12.width
            r10 = -2
            if (r9 != r10) goto L_0x01f2
            boolean r9 = r12.f1742V
            if (r9 == 0) goto L_0x01f2
            int r9 = r12.width
            int r9 = getChildMeasureSpec(r1, r7, r9)
            goto L_0x01fc
        L_0x01f2:
            int r9 = r15.mo3081p()
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
        L_0x01fc:
            int r10 = r12.height
            r1 = -2
            if (r10 != r1) goto L_0x020c
            boolean r1 = r12.f1743W
            if (r1 == 0) goto L_0x020c
            int r1 = r12.height
            int r1 = getChildMeasureSpec(r2, r8, r1)
            goto L_0x0216
        L_0x020c:
            int r1 = r15.mo3085r()
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
        L_0x0216:
            r3.measure(r9, r1)
            androidx.constraintlayout.a.f r1 = r0.f1720t
            if (r1 == 0) goto L_0x0223
            long r9 = r1.f1653b
            long r9 = r9 + r18
            r1.f1653b = r9
        L_0x0223:
            int r1 = r3.getMeasuredWidth()
            int r9 = r3.getMeasuredHeight()
            int r10 = r15.mo3081p()
            if (r1 == r10) goto L_0x025a
            r15.mo3070j(r1)
            if (r14 == 0) goto L_0x023d
            androidx.constraintlayout.a.a.n r10 = r15.mo3067i()
            r10.mo3137a(r1)
        L_0x023d:
            if (r6 == 0) goto L_0x0258
            int r1 = r15.mo3095x()
            if (r1 <= r13) goto L_0x0258
            int r1 = r15.mo3095x()
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            androidx.constraintlayout.a.a.e r10 = r15.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r10)
            int r10 = r10.mo3012e()
            int r1 = r1 + r10
            int r13 = java.lang.Math.max(r13, r1)
        L_0x0258:
            r23 = 1
        L_0x025a:
            int r1 = r15.mo3085r()
            if (r9 == r1) goto L_0x028a
            r15.mo3072k(r9)
            if (r14 == 0) goto L_0x026c
            androidx.constraintlayout.a.a.n r1 = r15.mo3069j()
            r1.mo3137a(r9)
        L_0x026c:
            if (r11 == 0) goto L_0x0288
            int r1 = r15.mo3096y()
            if (r1 <= r5) goto L_0x0288
            int r1 = r15.mo3096y()
            androidx.constraintlayout.a.a.e$c r9 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            androidx.constraintlayout.a.a.e r9 = r15.mo3028a((androidx.constraintlayout.p019a.p020a.C0420e.C0424c) r9)
            int r9 = r9.mo3012e()
            int r1 = r1 + r9
            int r1 = java.lang.Math.max(r5, r1)
            r5 = r1
        L_0x0288:
            r23 = 1
        L_0x028a:
            boolean r1 = r12.f1744X
            if (r1 == 0) goto L_0x02a0
            int r1 = r3.getBaseline()
            r9 = -1
            if (r1 == r9) goto L_0x02a0
            int r9 = r15.mo3019A()
            if (r1 == r9) goto L_0x02a0
            r15.mo3084q(r1)
            r23 = 1
        L_0x02a0:
            int r1 = android.os.Build.VERSION.SDK_INT
            r9 = 11
            if (r1 < r9) goto L_0x02b1
            int r1 = r3.getMeasuredState()
            r3 = r17
            int r17 = combineMeasuredStates(r3, r1)
            goto L_0x02ba
        L_0x02b1:
            r3 = r17
            goto L_0x02ba
        L_0x02b4:
            r23 = r10
        L_0x02b6:
            r3 = r17
            r17 = r3
        L_0x02ba:
            r10 = r23
            int r4 = r4 + 1
            r9 = r20
            r3 = r21
            r12 = r22
            r1 = r25
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x0189
        L_0x02ca:
            r21 = r3
            r20 = r9
            r23 = r10
            r22 = r12
            r3 = r17
            if (r23 == 0) goto L_0x0319
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            r4 = r20
            r1.mo3070j(r4)
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            r4 = r22
            r1.mo3072k(r4)
            if (r14 == 0) goto L_0x02eb
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            r1.mo3104P()
        L_0x02eb:
            java.lang.String r1 = "2nd pass"
            r0.mo3215a((java.lang.String) r1)
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            int r1 = r1.mo3081p()
            if (r1 >= r13) goto L_0x02ff
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            r1.mo3070j(r13)
            r11 = 1
            goto L_0x0300
        L_0x02ff:
            r11 = 0
        L_0x0300:
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            int r1 = r1.mo3085r()
            if (r1 >= r5) goto L_0x0310
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            r1.mo3072k(r5)
            r16 = 1
            goto L_0x0312
        L_0x0310:
            r16 = r11
        L_0x0312:
            if (r16 == 0) goto L_0x0319
            java.lang.String r1 = "3rd pass"
            r0.mo3215a((java.lang.String) r1)
        L_0x0319:
            r1 = r21
            r4 = 0
        L_0x031c:
            if (r4 >= r1) goto L_0x0372
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r5 = r0.f1708h
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.a.a.f r5 = (androidx.constraintlayout.p019a.p020a.C0425f) r5
            java.lang.Object r6 = r5.mo3020B()
            android.view.View r6 = (android.view.View) r6
            if (r6 != 0) goto L_0x0333
        L_0x032e:
            r10 = 8
        L_0x0330:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x036e
        L_0x0333:
            int r9 = r6.getMeasuredWidth()
            int r10 = r5.mo3081p()
            if (r9 != r10) goto L_0x0347
            int r9 = r6.getMeasuredHeight()
            int r10 = r5.mo3085r()
            if (r9 == r10) goto L_0x032e
        L_0x0347:
            int r9 = r5.mo3073l()
            r10 = 8
            if (r9 == r10) goto L_0x0330
            int r9 = r5.mo3081p()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r5 = r5.mo3085r()
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            r6.measure(r9, r5)
            androidx.constraintlayout.a.f r5 = r0.f1720t
            if (r5 == 0) goto L_0x036e
            long r12 = r5.f1653b
            long r12 = r12 + r18
            r5.f1653b = r12
        L_0x036e:
            int r4 = r4 + 1
            goto L_0x031c
        L_0x0371:
            r3 = 0
        L_0x0372:
            androidx.constraintlayout.a.a.g r1 = r0.f1702b
            int r1 = r1.mo3081p()
            int r1 = r1 + r7
            androidx.constraintlayout.a.a.g r4 = r0.f1702b
            int r4 = r4.mo3085r()
            int r4 = r4 + r8
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 11
            if (r5 < r6) goto L_0x03bf
            r5 = r25
            int r1 = resolveSizeAndState(r1, r5, r3)
            int r3 = r3 << 16
            int r2 = resolveSizeAndState(r4, r2, r3)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.f1711k
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.f1712l
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            boolean r3 = r3.mo3099K()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x03ae
            r1 = r1 | r4
        L_0x03ae:
            androidx.constraintlayout.a.a.g r3 = r0.f1702b
            boolean r3 = r3.mo3100L()
            if (r3 == 0) goto L_0x03b7
            r2 = r2 | r4
        L_0x03b7:
            r0.setMeasuredDimension(r1, r2)
            r0.f1718r = r1
            r0.f1719s = r2
            goto L_0x03c6
        L_0x03bf:
            r0.setMeasuredDimension(r1, r4)
            r0.f1718r = r1
            r0.f1719s = r4
        L_0x03c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        C0425f a = mo3210a(view);
        if ((view instanceof Guideline) && !(a instanceof C0430i)) {
            C0452a aVar = (C0452a) view.getLayoutParams();
            aVar.f1759al = new C0430i();
            aVar.f1745Y = true;
            ((C0430i) aVar.f1759al).mo2996a(aVar.f1739S);
        }
        if (view instanceof C0455b) {
            C0455b bVar = (C0455b) view;
            bVar.mo3253a();
            ((C0452a) view.getLayoutParams()).f1746Z = true;
            if (!this.f1707g.contains(bVar)) {
                this.f1707g.add(bVar);
            }
        }
        this.f1701a.put(view.getId(), view);
        this.f1713m = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f1701a.remove(view.getId());
        C0425f a = mo3210a(view);
        this.f1702b.mo3150c(a);
        this.f1707g.remove(view);
        this.f1708h.remove(a);
        this.f1713m = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.f1713m = true;
        this.f1718r = -1;
        this.f1719s = -1;
        this.f1703c = -1;
        this.f1704d = -1;
        this.f1705e = 0;
        this.f1706f = 0;
    }

    public void setConstraintSet(C0456c cVar) {
        this.f1715o = cVar;
    }

    public void setId(int i) {
        this.f1701a.remove(getId());
        super.setId(i);
        this.f1701a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.f1712l) {
            this.f1712l = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.f1711k) {
            this.f1711k = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f1710j) {
            this.f1710j = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.f1709i) {
            this.f1709i = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.f1702b.mo2996a(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
