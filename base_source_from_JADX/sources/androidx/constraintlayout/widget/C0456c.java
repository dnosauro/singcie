package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.C0459d;
import androidx.constraintlayout.widget.C0462f;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.constraintlayout.widget.c */
public class C0456c {

    /* renamed from: a */
    private static final int[] f1796a = {0, 4, 8};

    /* renamed from: c */
    private static SparseIntArray f1797c = new SparseIntArray();

    /* renamed from: b */
    private HashMap<Integer, C0458a> f1798b = new HashMap<>();

    /* renamed from: androidx.constraintlayout.widget.c$a */
    private static class C0458a {

        /* renamed from: A */
        public int f1799A;

        /* renamed from: B */
        public int f1800B;

        /* renamed from: C */
        public int f1801C;

        /* renamed from: D */
        public int f1802D;

        /* renamed from: E */
        public int f1803E;

        /* renamed from: F */
        public int f1804F;

        /* renamed from: G */
        public int f1805G;

        /* renamed from: H */
        public int f1806H;

        /* renamed from: I */
        public int f1807I;

        /* renamed from: J */
        public int f1808J;

        /* renamed from: K */
        public int f1809K;

        /* renamed from: L */
        public int f1810L;

        /* renamed from: M */
        public int f1811M;

        /* renamed from: N */
        public int f1812N;

        /* renamed from: O */
        public int f1813O;

        /* renamed from: P */
        public int f1814P;

        /* renamed from: Q */
        public float f1815Q;

        /* renamed from: R */
        public float f1816R;

        /* renamed from: S */
        public int f1817S;

        /* renamed from: T */
        public int f1818T;

        /* renamed from: U */
        public float f1819U;

        /* renamed from: V */
        public boolean f1820V;

        /* renamed from: W */
        public float f1821W;

        /* renamed from: X */
        public float f1822X;

        /* renamed from: Y */
        public float f1823Y;

        /* renamed from: Z */
        public float f1824Z;

        /* renamed from: a */
        boolean f1825a;

        /* renamed from: aa */
        public float f1826aa;

        /* renamed from: ab */
        public float f1827ab;

        /* renamed from: ac */
        public float f1828ac;

        /* renamed from: ad */
        public float f1829ad;

        /* renamed from: ae */
        public float f1830ae;

        /* renamed from: af */
        public float f1831af;

        /* renamed from: ag */
        public float f1832ag;

        /* renamed from: ah */
        public boolean f1833ah;

        /* renamed from: ai */
        public boolean f1834ai;

        /* renamed from: aj */
        public int f1835aj;

        /* renamed from: ak */
        public int f1836ak;

        /* renamed from: al */
        public int f1837al;

        /* renamed from: am */
        public int f1838am;

        /* renamed from: an */
        public int f1839an;

        /* renamed from: ao */
        public int f1840ao;

        /* renamed from: ap */
        public float f1841ap;

        /* renamed from: aq */
        public float f1842aq;

        /* renamed from: ar */
        public boolean f1843ar;

        /* renamed from: as */
        public int f1844as;

        /* renamed from: at */
        public int f1845at;

        /* renamed from: au */
        public int[] f1846au;

        /* renamed from: av */
        public String f1847av;

        /* renamed from: b */
        public int f1848b;

        /* renamed from: c */
        public int f1849c;

        /* renamed from: d */
        int f1850d;

        /* renamed from: e */
        public int f1851e;

        /* renamed from: f */
        public int f1852f;

        /* renamed from: g */
        public float f1853g;

        /* renamed from: h */
        public int f1854h;

        /* renamed from: i */
        public int f1855i;

        /* renamed from: j */
        public int f1856j;

        /* renamed from: k */
        public int f1857k;

        /* renamed from: l */
        public int f1858l;

        /* renamed from: m */
        public int f1859m;

        /* renamed from: n */
        public int f1860n;

        /* renamed from: o */
        public int f1861o;

        /* renamed from: p */
        public int f1862p;

        /* renamed from: q */
        public int f1863q;

        /* renamed from: r */
        public int f1864r;

        /* renamed from: s */
        public int f1865s;

        /* renamed from: t */
        public int f1866t;

        /* renamed from: u */
        public float f1867u;

        /* renamed from: v */
        public float f1868v;

        /* renamed from: w */
        public String f1869w;

        /* renamed from: x */
        public int f1870x;

        /* renamed from: y */
        public int f1871y;

        /* renamed from: z */
        public float f1872z;

        private C0458a() {
            this.f1825a = false;
            this.f1851e = -1;
            this.f1852f = -1;
            this.f1853g = -1.0f;
            this.f1854h = -1;
            this.f1855i = -1;
            this.f1856j = -1;
            this.f1857k = -1;
            this.f1858l = -1;
            this.f1859m = -1;
            this.f1860n = -1;
            this.f1861o = -1;
            this.f1862p = -1;
            this.f1863q = -1;
            this.f1864r = -1;
            this.f1865s = -1;
            this.f1866t = -1;
            this.f1867u = 0.5f;
            this.f1868v = 0.5f;
            this.f1869w = null;
            this.f1870x = -1;
            this.f1871y = 0;
            this.f1872z = 0.0f;
            this.f1799A = -1;
            this.f1800B = -1;
            this.f1801C = -1;
            this.f1802D = -1;
            this.f1803E = -1;
            this.f1804F = -1;
            this.f1805G = -1;
            this.f1806H = -1;
            this.f1807I = -1;
            this.f1808J = 0;
            this.f1809K = -1;
            this.f1810L = -1;
            this.f1811M = -1;
            this.f1812N = -1;
            this.f1813O = -1;
            this.f1814P = -1;
            this.f1815Q = 0.0f;
            this.f1816R = 0.0f;
            this.f1817S = 0;
            this.f1818T = 0;
            this.f1819U = 1.0f;
            this.f1820V = false;
            this.f1821W = 0.0f;
            this.f1822X = 0.0f;
            this.f1823Y = 0.0f;
            this.f1824Z = 0.0f;
            this.f1826aa = 1.0f;
            this.f1827ab = 1.0f;
            this.f1828ac = Float.NaN;
            this.f1829ad = Float.NaN;
            this.f1830ae = 0.0f;
            this.f1831af = 0.0f;
            this.f1832ag = 0.0f;
            this.f1833ah = false;
            this.f1834ai = false;
            this.f1835aj = 0;
            this.f1836ak = 0;
            this.f1837al = -1;
            this.f1838am = -1;
            this.f1839an = -1;
            this.f1840ao = -1;
            this.f1841ap = 1.0f;
            this.f1842aq = 1.0f;
            this.f1843ar = false;
            this.f1844as = -1;
            this.f1845at = -1;
        }

        /* renamed from: a */
        private void m1887a(int i, ConstraintLayout.C0452a aVar) {
            this.f1850d = i;
            this.f1854h = aVar.f1763d;
            this.f1855i = aVar.f1764e;
            this.f1856j = aVar.f1765f;
            this.f1857k = aVar.f1766g;
            this.f1858l = aVar.f1767h;
            this.f1859m = aVar.f1768i;
            this.f1860n = aVar.f1769j;
            this.f1861o = aVar.f1770k;
            this.f1862p = aVar.f1771l;
            this.f1863q = aVar.f1775p;
            this.f1864r = aVar.f1776q;
            this.f1865s = aVar.f1777r;
            this.f1866t = aVar.f1778s;
            this.f1867u = aVar.f1785z;
            this.f1868v = aVar.f1721A;
            this.f1869w = aVar.f1722B;
            this.f1870x = aVar.f1772m;
            this.f1871y = aVar.f1773n;
            this.f1872z = aVar.f1774o;
            this.f1799A = aVar.f1737Q;
            this.f1800B = aVar.f1738R;
            this.f1801C = aVar.f1739S;
            this.f1853g = aVar.f1762c;
            this.f1851e = aVar.f1747a;
            this.f1852f = aVar.f1761b;
            this.f1848b = aVar.width;
            this.f1849c = aVar.height;
            this.f1802D = aVar.leftMargin;
            this.f1803E = aVar.rightMargin;
            this.f1804F = aVar.topMargin;
            this.f1805G = aVar.bottomMargin;
            this.f1815Q = aVar.f1726F;
            this.f1816R = aVar.f1725E;
            this.f1818T = aVar.f1728H;
            this.f1817S = aVar.f1727G;
            this.f1833ah = aVar.f1740T;
            this.f1834ai = aVar.f1741U;
            this.f1835aj = aVar.f1729I;
            this.f1836ak = aVar.f1730J;
            this.f1833ah = aVar.f1740T;
            this.f1837al = aVar.f1733M;
            this.f1838am = aVar.f1734N;
            this.f1839an = aVar.f1731K;
            this.f1840ao = aVar.f1732L;
            this.f1841ap = aVar.f1735O;
            this.f1842aq = aVar.f1736P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f1806H = aVar.getMarginEnd();
                this.f1807I = aVar.getMarginStart();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1888a(int i, C0459d.C0460a aVar) {
            m1887a(i, (ConstraintLayout.C0452a) aVar);
            this.f1819U = aVar.f1874an;
            this.f1822X = aVar.f1877aq;
            this.f1823Y = aVar.f1878ar;
            this.f1824Z = aVar.f1879as;
            this.f1826aa = aVar.f1880at;
            this.f1827ab = aVar.f1881au;
            this.f1828ac = aVar.f1882av;
            this.f1829ad = aVar.f1883aw;
            this.f1830ae = aVar.f1884ax;
            this.f1831af = aVar.f1885ay;
            this.f1832ag = aVar.f1886az;
            this.f1821W = aVar.f1876ap;
            this.f1820V = aVar.f1875ao;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1889a(C0455b bVar, int i, C0459d.C0460a aVar) {
            m1888a(i, aVar);
            if (bVar instanceof C0454a) {
                this.f1845at = 1;
                C0454a aVar2 = (C0454a) bVar;
                this.f1844as = aVar2.getType();
                this.f1846au = aVar2.getReferencedIds();
            }
        }

        /* renamed from: a */
        public C0458a clone() {
            C0458a aVar = new C0458a();
            aVar.f1825a = this.f1825a;
            aVar.f1848b = this.f1848b;
            aVar.f1849c = this.f1849c;
            aVar.f1851e = this.f1851e;
            aVar.f1852f = this.f1852f;
            aVar.f1853g = this.f1853g;
            aVar.f1854h = this.f1854h;
            aVar.f1855i = this.f1855i;
            aVar.f1856j = this.f1856j;
            aVar.f1857k = this.f1857k;
            aVar.f1858l = this.f1858l;
            aVar.f1859m = this.f1859m;
            aVar.f1860n = this.f1860n;
            aVar.f1861o = this.f1861o;
            aVar.f1862p = this.f1862p;
            aVar.f1863q = this.f1863q;
            aVar.f1864r = this.f1864r;
            aVar.f1865s = this.f1865s;
            aVar.f1866t = this.f1866t;
            aVar.f1867u = this.f1867u;
            aVar.f1868v = this.f1868v;
            aVar.f1869w = this.f1869w;
            aVar.f1799A = this.f1799A;
            aVar.f1800B = this.f1800B;
            aVar.f1867u = this.f1867u;
            aVar.f1867u = this.f1867u;
            aVar.f1867u = this.f1867u;
            aVar.f1867u = this.f1867u;
            aVar.f1867u = this.f1867u;
            aVar.f1801C = this.f1801C;
            aVar.f1802D = this.f1802D;
            aVar.f1803E = this.f1803E;
            aVar.f1804F = this.f1804F;
            aVar.f1805G = this.f1805G;
            aVar.f1806H = this.f1806H;
            aVar.f1807I = this.f1807I;
            aVar.f1808J = this.f1808J;
            aVar.f1809K = this.f1809K;
            aVar.f1810L = this.f1810L;
            aVar.f1811M = this.f1811M;
            aVar.f1812N = this.f1812N;
            aVar.f1813O = this.f1813O;
            aVar.f1814P = this.f1814P;
            aVar.f1815Q = this.f1815Q;
            aVar.f1816R = this.f1816R;
            aVar.f1817S = this.f1817S;
            aVar.f1818T = this.f1818T;
            aVar.f1819U = this.f1819U;
            aVar.f1820V = this.f1820V;
            aVar.f1821W = this.f1821W;
            aVar.f1822X = this.f1822X;
            aVar.f1823Y = this.f1823Y;
            aVar.f1824Z = this.f1824Z;
            aVar.f1826aa = this.f1826aa;
            aVar.f1827ab = this.f1827ab;
            aVar.f1828ac = this.f1828ac;
            aVar.f1829ad = this.f1829ad;
            aVar.f1830ae = this.f1830ae;
            aVar.f1831af = this.f1831af;
            aVar.f1832ag = this.f1832ag;
            aVar.f1833ah = this.f1833ah;
            aVar.f1834ai = this.f1834ai;
            aVar.f1835aj = this.f1835aj;
            aVar.f1836ak = this.f1836ak;
            aVar.f1837al = this.f1837al;
            aVar.f1838am = this.f1838am;
            aVar.f1839an = this.f1839an;
            aVar.f1840ao = this.f1840ao;
            aVar.f1841ap = this.f1841ap;
            aVar.f1842aq = this.f1842aq;
            aVar.f1844as = this.f1844as;
            aVar.f1845at = this.f1845at;
            int[] iArr = this.f1846au;
            if (iArr != null) {
                aVar.f1846au = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.f1870x = this.f1870x;
            aVar.f1871y = this.f1871y;
            aVar.f1872z = this.f1872z;
            aVar.f1843ar = this.f1843ar;
            return aVar;
        }

        /* renamed from: a */
        public void mo3266a(ConstraintLayout.C0452a aVar) {
            aVar.f1763d = this.f1854h;
            aVar.f1764e = this.f1855i;
            aVar.f1765f = this.f1856j;
            aVar.f1766g = this.f1857k;
            aVar.f1767h = this.f1858l;
            aVar.f1768i = this.f1859m;
            aVar.f1769j = this.f1860n;
            aVar.f1770k = this.f1861o;
            aVar.f1771l = this.f1862p;
            aVar.f1775p = this.f1863q;
            aVar.f1776q = this.f1864r;
            aVar.f1777r = this.f1865s;
            aVar.f1778s = this.f1866t;
            aVar.leftMargin = this.f1802D;
            aVar.rightMargin = this.f1803E;
            aVar.topMargin = this.f1804F;
            aVar.bottomMargin = this.f1805G;
            aVar.f1783x = this.f1814P;
            aVar.f1784y = this.f1813O;
            aVar.f1785z = this.f1867u;
            aVar.f1721A = this.f1868v;
            aVar.f1772m = this.f1870x;
            aVar.f1773n = this.f1871y;
            aVar.f1774o = this.f1872z;
            aVar.f1722B = this.f1869w;
            aVar.f1737Q = this.f1799A;
            aVar.f1738R = this.f1800B;
            aVar.f1726F = this.f1815Q;
            aVar.f1725E = this.f1816R;
            aVar.f1728H = this.f1818T;
            aVar.f1727G = this.f1817S;
            aVar.f1740T = this.f1833ah;
            aVar.f1741U = this.f1834ai;
            aVar.f1729I = this.f1835aj;
            aVar.f1730J = this.f1836ak;
            aVar.f1733M = this.f1837al;
            aVar.f1734N = this.f1838am;
            aVar.f1731K = this.f1839an;
            aVar.f1732L = this.f1840ao;
            aVar.f1735O = this.f1841ap;
            aVar.f1736P = this.f1842aq;
            aVar.f1739S = this.f1801C;
            aVar.f1762c = this.f1853g;
            aVar.f1747a = this.f1851e;
            aVar.f1761b = this.f1852f;
            aVar.width = this.f1848b;
            aVar.height = this.f1849c;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.f1807I);
                aVar.setMarginEnd(this.f1806H);
            }
            aVar.mo3241a();
        }
    }

    static {
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_editor_absoluteX, 6);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_editor_absoluteY, 7);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintGuide_begin, 17);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintGuide_end, 18);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintGuide_percent, 19);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_orientation, 27);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginLeft, 13);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginTop, 16);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginRight, 14);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginBottom, 11);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginStart, 15);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_goneMarginEnd, 12);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintVertical_weight, 40);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintVertical_bias, 37);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintLeft_creator, 75);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintTop_creator, 75);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintRight_creator, 75);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintBottom_creator, 75);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginLeft, 24);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginRight, 28);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginStart, 31);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginEnd, 8);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginTop, 34);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_marginBottom, 2);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_width, 23);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_layout_height, 21);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_visibility, 22);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_alpha, 43);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_elevation, 44);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_rotationX, 45);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_rotationY, 46);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_rotation, 60);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_scaleX, 47);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_scaleY, 48);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_transformPivotX, 49);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_transformPivotY, 50);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_translationX, 51);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_translationY, 52);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_translationZ, 53);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintWidth_default, 54);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHeight_default, 55);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintWidth_max, 56);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHeight_max, 57);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintWidth_min, 58);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHeight_min, 59);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintCircle, 61);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintCircleRadius, 62);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintCircleAngle, 63);
        f1797c.append(C0462f.C0464b.ConstraintSet_android_id, 38);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintWidth_percent, 69);
        f1797c.append(C0462f.C0464b.ConstraintSet_layout_constraintHeight_percent, 70);
        f1797c.append(C0462f.C0464b.ConstraintSet_chainUseRtl, 71);
        f1797c.append(C0462f.C0464b.ConstraintSet_barrierDirection, 72);
        f1797c.append(C0462f.C0464b.ConstraintSet_constraint_referenced_ids, 73);
        f1797c.append(C0462f.C0464b.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* renamed from: a */
    private static int m1880a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* renamed from: a */
    private C0458a m1881a(Context context, AttributeSet attributeSet) {
        C0458a aVar = new C0458a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0462f.C0464b.ConstraintSet);
        m1882a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: a */
    private void m1882a(C0458a aVar, TypedArray typedArray) {
        String str;
        StringBuilder sb;
        String str2;
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f1797c.get(index);
            switch (i2) {
                case 1:
                    aVar.f1862p = m1880a(typedArray, index, aVar.f1862p);
                    break;
                case 2:
                    aVar.f1805G = typedArray.getDimensionPixelSize(index, aVar.f1805G);
                    break;
                case 3:
                    aVar.f1861o = m1880a(typedArray, index, aVar.f1861o);
                    break;
                case 4:
                    aVar.f1860n = m1880a(typedArray, index, aVar.f1860n);
                    break;
                case 5:
                    aVar.f1869w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.f1799A = typedArray.getDimensionPixelOffset(index, aVar.f1799A);
                    break;
                case 7:
                    aVar.f1800B = typedArray.getDimensionPixelOffset(index, aVar.f1800B);
                    break;
                case 8:
                    aVar.f1806H = typedArray.getDimensionPixelSize(index, aVar.f1806H);
                    break;
                case 9:
                    aVar.f1866t = m1880a(typedArray, index, aVar.f1866t);
                    break;
                case 10:
                    aVar.f1865s = m1880a(typedArray, index, aVar.f1865s);
                    break;
                case 11:
                    aVar.f1812N = typedArray.getDimensionPixelSize(index, aVar.f1812N);
                    break;
                case 12:
                    aVar.f1813O = typedArray.getDimensionPixelSize(index, aVar.f1813O);
                    break;
                case 13:
                    aVar.f1809K = typedArray.getDimensionPixelSize(index, aVar.f1809K);
                    break;
                case 14:
                    aVar.f1811M = typedArray.getDimensionPixelSize(index, aVar.f1811M);
                    break;
                case 15:
                    aVar.f1814P = typedArray.getDimensionPixelSize(index, aVar.f1814P);
                    break;
                case 16:
                    aVar.f1810L = typedArray.getDimensionPixelSize(index, aVar.f1810L);
                    break;
                case 17:
                    aVar.f1851e = typedArray.getDimensionPixelOffset(index, aVar.f1851e);
                    break;
                case 18:
                    aVar.f1852f = typedArray.getDimensionPixelOffset(index, aVar.f1852f);
                    break;
                case 19:
                    aVar.f1853g = typedArray.getFloat(index, aVar.f1853g);
                    break;
                case 20:
                    aVar.f1867u = typedArray.getFloat(index, aVar.f1867u);
                    break;
                case 21:
                    aVar.f1849c = typedArray.getLayoutDimension(index, aVar.f1849c);
                    break;
                case 22:
                    aVar.f1808J = typedArray.getInt(index, aVar.f1808J);
                    aVar.f1808J = f1796a[aVar.f1808J];
                    break;
                case 23:
                    aVar.f1848b = typedArray.getLayoutDimension(index, aVar.f1848b);
                    break;
                case 24:
                    aVar.f1802D = typedArray.getDimensionPixelSize(index, aVar.f1802D);
                    break;
                case 25:
                    aVar.f1854h = m1880a(typedArray, index, aVar.f1854h);
                    break;
                case 26:
                    aVar.f1855i = m1880a(typedArray, index, aVar.f1855i);
                    break;
                case 27:
                    aVar.f1801C = typedArray.getInt(index, aVar.f1801C);
                    break;
                case 28:
                    aVar.f1803E = typedArray.getDimensionPixelSize(index, aVar.f1803E);
                    break;
                case 29:
                    aVar.f1856j = m1880a(typedArray, index, aVar.f1856j);
                    break;
                case 30:
                    aVar.f1857k = m1880a(typedArray, index, aVar.f1857k);
                    break;
                case 31:
                    aVar.f1807I = typedArray.getDimensionPixelSize(index, aVar.f1807I);
                    break;
                case 32:
                    aVar.f1863q = m1880a(typedArray, index, aVar.f1863q);
                    break;
                case 33:
                    aVar.f1864r = m1880a(typedArray, index, aVar.f1864r);
                    break;
                case 34:
                    aVar.f1804F = typedArray.getDimensionPixelSize(index, aVar.f1804F);
                    break;
                case 35:
                    aVar.f1859m = m1880a(typedArray, index, aVar.f1859m);
                    break;
                case 36:
                    aVar.f1858l = m1880a(typedArray, index, aVar.f1858l);
                    break;
                case 37:
                    aVar.f1868v = typedArray.getFloat(index, aVar.f1868v);
                    break;
                case 38:
                    aVar.f1850d = typedArray.getResourceId(index, aVar.f1850d);
                    break;
                case 39:
                    aVar.f1816R = typedArray.getFloat(index, aVar.f1816R);
                    break;
                case 40:
                    aVar.f1815Q = typedArray.getFloat(index, aVar.f1815Q);
                    break;
                case 41:
                    aVar.f1817S = typedArray.getInt(index, aVar.f1817S);
                    break;
                case 42:
                    aVar.f1818T = typedArray.getInt(index, aVar.f1818T);
                    break;
                case 43:
                    aVar.f1819U = typedArray.getFloat(index, aVar.f1819U);
                    break;
                case 44:
                    aVar.f1820V = true;
                    aVar.f1821W = typedArray.getDimension(index, aVar.f1821W);
                    break;
                case 45:
                    aVar.f1823Y = typedArray.getFloat(index, aVar.f1823Y);
                    break;
                case 46:
                    aVar.f1824Z = typedArray.getFloat(index, aVar.f1824Z);
                    break;
                case 47:
                    aVar.f1826aa = typedArray.getFloat(index, aVar.f1826aa);
                    break;
                case 48:
                    aVar.f1827ab = typedArray.getFloat(index, aVar.f1827ab);
                    break;
                case 49:
                    aVar.f1828ac = typedArray.getFloat(index, aVar.f1828ac);
                    break;
                case 50:
                    aVar.f1829ad = typedArray.getFloat(index, aVar.f1829ad);
                    break;
                case 51:
                    aVar.f1830ae = typedArray.getDimension(index, aVar.f1830ae);
                    break;
                case 52:
                    aVar.f1831af = typedArray.getDimension(index, aVar.f1831af);
                    break;
                case 53:
                    aVar.f1832ag = typedArray.getDimension(index, aVar.f1832ag);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.f1822X = typedArray.getFloat(index, aVar.f1822X);
                            break;
                        case 61:
                            aVar.f1870x = m1880a(typedArray, index, aVar.f1870x);
                            break;
                        case 62:
                            aVar.f1871y = typedArray.getDimensionPixelSize(index, aVar.f1871y);
                            break;
                        case 63:
                            aVar.f1872z = typedArray.getFloat(index, aVar.f1872z);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    aVar.f1841ap = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 70:
                                    aVar.f1842aq = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    continue;
                                case 72:
                                    aVar.f1844as = typedArray.getInt(index, aVar.f1844as);
                                    continue;
                                case 73:
                                    aVar.f1847av = typedArray.getString(index);
                                    continue;
                                case 74:
                                    aVar.f1843ar = typedArray.getBoolean(index, aVar.f1843ar);
                                    continue;
                                case 75:
                                    str = "ConstraintSet";
                                    sb = new StringBuilder();
                                    str2 = "unused attribute 0x";
                                    break;
                                default:
                                    str = "ConstraintSet";
                                    sb = new StringBuilder();
                                    str2 = "Unknown attribute 0x";
                                    break;
                            }
                            sb.append(str2);
                            sb.append(Integer.toHexString(index));
                            sb.append("   ");
                            sb.append(f1797c.get(index));
                            Log.w(str, sb.toString());
                            break;
                    }
            }
        }
    }

    /* renamed from: a */
    private int[] m1883a(View view, String str) {
        int i;
        Object a;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = C0462f.C0463a.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a = ((ConstraintLayout) view.getParent()).mo3213a(0, (Object) trim)) != null && (a instanceof Integer)) {
                i = ((Integer) a).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    /* renamed from: a */
    public void mo3262a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xml.getName();
                            C0458a a = m1881a(context, Xml.asAttributeSet(xml));
                            if (name.equalsIgnoreCase("Guideline")) {
                                a.f1825a = true;
                            }
                            this.f1798b.put(Integer.valueOf(a.f1850d), a);
                            break;
                        case 3:
                            break;
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3263a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1798b.keySet());
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f1798b.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    C0458a aVar = this.f1798b.get(Integer.valueOf(id));
                    if (childAt instanceof C0454a) {
                        aVar.f1845at = 1;
                    }
                    if (aVar.f1845at != -1 && aVar.f1845at == 1) {
                        C0454a aVar2 = (C0454a) childAt;
                        aVar2.setId(id);
                        aVar2.setType(aVar.f1844as);
                        aVar2.setAllowsGoneWidget(aVar.f1843ar);
                        if (aVar.f1846au == null) {
                            if (aVar.f1847av != null) {
                                aVar.f1846au = m1883a((View) aVar2, aVar.f1847av);
                            }
                        }
                        aVar2.setReferencedIds(aVar.f1846au);
                    }
                    ConstraintLayout.C0452a aVar3 = (ConstraintLayout.C0452a) childAt.getLayoutParams();
                    aVar.mo3266a(aVar3);
                    childAt.setLayoutParams(aVar3);
                    childAt.setVisibility(aVar.f1808J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(aVar.f1819U);
                        childAt.setRotation(aVar.f1822X);
                        childAt.setRotationX(aVar.f1823Y);
                        childAt.setRotationY(aVar.f1824Z);
                        childAt.setScaleX(aVar.f1826aa);
                        childAt.setScaleY(aVar.f1827ab);
                        if (!Float.isNaN(aVar.f1828ac)) {
                            childAt.setPivotX(aVar.f1828ac);
                        }
                        if (!Float.isNaN(aVar.f1829ad)) {
                            childAt.setPivotY(aVar.f1829ad);
                        }
                        childAt.setTranslationX(aVar.f1830ae);
                        childAt.setTranslationY(aVar.f1831af);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(aVar.f1832ag);
                            if (aVar.f1820V) {
                                childAt.setElevation(aVar.f1821W);
                            }
                        }
                    }
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0458a aVar4 = this.f1798b.get(num);
            if (aVar4.f1845at != -1 && aVar4.f1845at == 1) {
                C0454a aVar5 = new C0454a(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                if (aVar4.f1846au == null) {
                    if (aVar4.f1847av != null) {
                        aVar4.f1846au = m1883a((View) aVar5, aVar4.f1847av);
                    }
                    aVar5.setType(aVar4.f1844as);
                    ConstraintLayout.C0452a a = constraintLayout.generateDefaultLayoutParams();
                    aVar5.mo3253a();
                    aVar4.mo3266a(a);
                    constraintLayout.addView(aVar5, a);
                }
                aVar5.setReferencedIds(aVar4.f1846au);
                aVar5.setType(aVar4.f1844as);
                ConstraintLayout.C0452a a2 = constraintLayout.generateDefaultLayoutParams();
                aVar5.mo3253a();
                aVar4.mo3266a(a2);
                constraintLayout.addView(aVar5, a2);
            }
            if (aVar4.f1825a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.C0452a a3 = constraintLayout.generateDefaultLayoutParams();
                aVar4.mo3266a(a3);
                constraintLayout.addView(guideline, a3);
            }
        }
    }

    /* renamed from: a */
    public void mo3264a(C0459d dVar) {
        int childCount = dVar.getChildCount();
        this.f1798b.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = dVar.getChildAt(i);
            C0459d.C0460a aVar = (C0459d.C0460a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1798b.containsKey(Integer.valueOf(id))) {
                    this.f1798b.put(Integer.valueOf(id), new C0458a());
                }
                C0458a aVar2 = this.f1798b.get(Integer.valueOf(id));
                if (childAt instanceof C0455b) {
                    aVar2.m1889a((C0455b) childAt, id, aVar);
                }
                aVar2.m1888a(id, aVar);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }
}
