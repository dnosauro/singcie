package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.C0189j;
import androidx.appcompat.widget.C0257af;
import androidx.appcompat.widget.C0302ay;
import androidx.core.p021a.p022a.C0486a;
import androidx.core.p030h.C0634b;
import androidx.core.p030h.C0642g;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.view.g */
public class C0163g extends MenuInflater {

    /* renamed from: a */
    static final Class<?>[] f448a = {Context.class};

    /* renamed from: b */
    static final Class<?>[] f449b = f448a;

    /* renamed from: c */
    final Object[] f450c;

    /* renamed from: d */
    final Object[] f451d = this.f450c;

    /* renamed from: e */
    Context f452e;

    /* renamed from: f */
    private Object f453f;

    /* renamed from: androidx.appcompat.view.g$a */
    private static class C0164a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f454a = {MenuItem.class};

        /* renamed from: b */
        private Object f455b;

        /* renamed from: c */
        private Method f456c;

        public C0164a(Object obj, String str) {
            this.f455b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f456c = cls.getMethod(str, f454a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f456c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f456c.invoke(this.f455b, new Object[]{menuItem})).booleanValue();
                }
                this.f456c.invoke(this.f455b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.g$b */
    private class C0165b {

        /* renamed from: A */
        private String f457A;

        /* renamed from: B */
        private String f458B;

        /* renamed from: C */
        private CharSequence f459C;

        /* renamed from: D */
        private CharSequence f460D;

        /* renamed from: E */
        private ColorStateList f461E = null;

        /* renamed from: F */
        private PorterDuff.Mode f462F = null;

        /* renamed from: a */
        C0634b f463a;

        /* renamed from: c */
        private Menu f465c;

        /* renamed from: d */
        private int f466d;

        /* renamed from: e */
        private int f467e;

        /* renamed from: f */
        private int f468f;

        /* renamed from: g */
        private int f469g;

        /* renamed from: h */
        private boolean f470h;

        /* renamed from: i */
        private boolean f471i;

        /* renamed from: j */
        private boolean f472j;

        /* renamed from: k */
        private int f473k;

        /* renamed from: l */
        private int f474l;

        /* renamed from: m */
        private CharSequence f475m;

        /* renamed from: n */
        private CharSequence f476n;

        /* renamed from: o */
        private int f477o;

        /* renamed from: p */
        private char f478p;

        /* renamed from: q */
        private int f479q;

        /* renamed from: r */
        private char f480r;

        /* renamed from: s */
        private int f481s;

        /* renamed from: t */
        private int f482t;

        /* renamed from: u */
        private boolean f483u;

        /* renamed from: v */
        private boolean f484v;

        /* renamed from: w */
        private boolean f485w;

        /* renamed from: x */
        private int f486x;

        /* renamed from: y */
        private int f487y;

        /* renamed from: z */
        private String f488z;

        public C0165b(Menu menu) {
            this.f465c = menu;
            mo1169a();
        }

        /* renamed from: a */
        private char m504a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private <T> T m505a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C0163g.this.f452e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* renamed from: a */
        private void m506a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f483u).setVisible(this.f484v).setEnabled(this.f485w).setCheckable(this.f482t >= 1).setTitleCondensed(this.f476n).setIcon(this.f477o);
            int i = this.f486x;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f458B != null) {
                if (!C0163g.this.f452e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new C0164a(C0163g.this.mo1166a(), this.f458B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof C0187i;
            if (z2) {
                C0187i iVar = (C0187i) menuItem;
            }
            if (this.f482t >= 2) {
                if (z2) {
                    ((C0187i) menuItem).mo1456a(true);
                } else if (menuItem instanceof C0189j) {
                    ((C0189j) menuItem).mo1512a(true);
                }
            }
            String str = this.f488z;
            if (str != null) {
                menuItem.setActionView((View) m505a(str, C0163g.f448a, C0163g.this.f450c));
                z = true;
            }
            int i2 = this.f487y;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0634b bVar = this.f463a;
            if (bVar != null) {
                C0642g.m2533a(menuItem, bVar);
            }
            C0642g.m2537a(menuItem, this.f459C);
            C0642g.m2539b(menuItem, this.f460D);
            C0642g.m2538b(menuItem, this.f478p, this.f479q);
            C0642g.m2534a(menuItem, this.f480r, this.f481s);
            PorterDuff.Mode mode = this.f462F;
            if (mode != null) {
                C0642g.m2536a(menuItem, mode);
            }
            ColorStateList colorStateList = this.f461E;
            if (colorStateList != null) {
                C0642g.m2535a(menuItem, colorStateList);
            }
        }

        /* renamed from: a */
        public void mo1169a() {
            this.f466d = 0;
            this.f467e = 0;
            this.f468f = 0;
            this.f469g = 0;
            this.f470h = true;
            this.f471i = true;
        }

        /* renamed from: a */
        public void mo1170a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0163g.this.f452e.obtainStyledAttributes(attributeSet, C0059a.C0069j.MenuGroup);
            this.f466d = obtainStyledAttributes.getResourceId(C0059a.C0069j.MenuGroup_android_id, 0);
            this.f467e = obtainStyledAttributes.getInt(C0059a.C0069j.MenuGroup_android_menuCategory, 0);
            this.f468f = obtainStyledAttributes.getInt(C0059a.C0069j.MenuGroup_android_orderInCategory, 0);
            this.f469g = obtainStyledAttributes.getInt(C0059a.C0069j.MenuGroup_android_checkableBehavior, 0);
            this.f470h = obtainStyledAttributes.getBoolean(C0059a.C0069j.MenuGroup_android_visible, true);
            this.f471i = obtainStyledAttributes.getBoolean(C0059a.C0069j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void mo1171b() {
            this.f472j = true;
            m506a(this.f465c.add(this.f466d, this.f473k, this.f474l, this.f475m));
        }

        /* renamed from: b */
        public void mo1172b(AttributeSet attributeSet) {
            C0302ay a = C0302ay.m1077a(C0163g.this.f452e, attributeSet, C0059a.C0069j.MenuItem);
            this.f473k = a.mo2423g(C0059a.C0069j.MenuItem_android_id, 0);
            this.f474l = (a.mo2407a(C0059a.C0069j.MenuItem_android_menuCategory, this.f467e) & -65536) | (a.mo2407a(C0059a.C0069j.MenuItem_android_orderInCategory, this.f468f) & 65535);
            this.f475m = a.mo2416c(C0059a.C0069j.MenuItem_android_title);
            this.f476n = a.mo2416c(C0059a.C0069j.MenuItem_android_titleCondensed);
            this.f477o = a.mo2423g(C0059a.C0069j.MenuItem_android_icon, 0);
            this.f478p = m504a(a.mo2418d(C0059a.C0069j.MenuItem_android_alphabeticShortcut));
            this.f479q = a.mo2407a(C0059a.C0069j.MenuItem_alphabeticModifiers, 4096);
            this.f480r = m504a(a.mo2418d(C0059a.C0069j.MenuItem_android_numericShortcut));
            this.f481s = a.mo2407a(C0059a.C0069j.MenuItem_numericModifiers, 4096);
            this.f482t = a.mo2424g(C0059a.C0069j.MenuItem_android_checkable) ? a.mo2411a(C0059a.C0069j.MenuItem_android_checkable, false) : this.f469g;
            this.f483u = a.mo2411a(C0059a.C0069j.MenuItem_android_checked, false);
            this.f484v = a.mo2411a(C0059a.C0069j.MenuItem_android_visible, this.f470h);
            this.f485w = a.mo2411a(C0059a.C0069j.MenuItem_android_enabled, this.f471i);
            this.f486x = a.mo2407a(C0059a.C0069j.MenuItem_showAsAction, -1);
            this.f458B = a.mo2418d(C0059a.C0069j.MenuItem_android_onClick);
            this.f487y = a.mo2423g(C0059a.C0069j.MenuItem_actionLayout, 0);
            this.f488z = a.mo2418d(C0059a.C0069j.MenuItem_actionViewClass);
            this.f457A = a.mo2418d(C0059a.C0069j.MenuItem_actionProviderClass);
            boolean z = this.f457A != null;
            if (z && this.f487y == 0 && this.f488z == null) {
                this.f463a = (C0634b) m505a(this.f457A, C0163g.f449b, C0163g.this.f451d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f463a = null;
            }
            this.f459C = a.mo2416c(C0059a.C0069j.MenuItem_contentDescription);
            this.f460D = a.mo2416c(C0059a.C0069j.MenuItem_tooltipText);
            if (a.mo2424g(C0059a.C0069j.MenuItem_iconTintMode)) {
                this.f462F = C0257af.m914a(a.mo2407a(C0059a.C0069j.MenuItem_iconTintMode, -1), this.f462F);
            } else {
                this.f462F = null;
            }
            if (a.mo2424g(C0059a.C0069j.MenuItem_iconTint)) {
                this.f461E = a.mo2420e(C0059a.C0069j.MenuItem_iconTint);
            } else {
                this.f461E = null;
            }
            a.mo2410a();
            this.f472j = false;
        }

        /* renamed from: c */
        public SubMenu mo1173c() {
            this.f472j = true;
            SubMenu addSubMenu = this.f465c.addSubMenu(this.f466d, this.f473k, this.f474l, this.f475m);
            m506a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean mo1174d() {
            return this.f472j;
        }
    }

    public C0163g(Context context) {
        super(context);
        this.f452e = context;
        this.f450c = new Object[]{context};
    }

    /* renamed from: a */
    private Object m501a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m501a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: a */
    private void m502a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        C0165b bVar = new C0165b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (i) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (!name2.equals("group")) {
                            if (!name2.equals("item")) {
                                if (!name2.equals("menu")) {
                                    str = name2;
                                    z2 = true;
                                    break;
                                } else {
                                    m502a(xmlPullParser, attributeSet, bVar.mo1173c());
                                    break;
                                }
                            } else {
                                bVar.mo1172b(attributeSet);
                                break;
                            }
                        } else {
                            bVar.mo1170a(attributeSet);
                            break;
                        }
                    } else {
                        break;
                    }
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z2 || !name3.equals(str)) {
                        if (!name3.equals("group")) {
                            if (!name3.equals("item")) {
                                if (!name3.equals("menu")) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else if (!bVar.mo1174d()) {
                                if (bVar.f463a != null && bVar.f463a.mo1570c()) {
                                    bVar.mo1173c();
                                    break;
                                } else {
                                    bVar.mo1171b();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            bVar.mo1169a();
                            break;
                        }
                    } else {
                        str = null;
                        z2 = false;
                        break;
                    }
            }
            i = xmlPullParser.next();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo1166a() {
        if (this.f453f == null) {
            this.f453f = m501a(this.f452e);
        }
        return this.f453f;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof C0486a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f452e.getResources().getLayout(i);
            m502a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
