package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0159d;
import androidx.appcompat.widget.C0252aa;
import androidx.appcompat.widget.C0254ac;
import androidx.appcompat.widget.C0299av;
import androidx.appcompat.widget.C0331e;
import androidx.appcompat.widget.C0333g;
import androidx.appcompat.widget.C0334h;
import androidx.appcompat.widget.C0335i;
import androidx.appcompat.widget.C0339l;
import androidx.appcompat.widget.C0341n;
import androidx.appcompat.widget.C0343p;
import androidx.appcompat.widget.C0344q;
import androidx.appcompat.widget.C0347t;
import androidx.appcompat.widget.C0348u;
import androidx.appcompat.widget.C0349v;
import androidx.appcompat.widget.C0351x;
import androidx.core.p030h.C0656u;
import androidx.p018c.C0400a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new C0400a();
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {16843375};
    private final Object[] mConstructorArgs = new Object[2];

    /* renamed from: androidx.appcompat.app.AppCompatViewInflater$a */
    private static class C0085a implements View.OnClickListener {

        /* renamed from: a */
        private final View f173a;

        /* renamed from: b */
        private final String f174b;

        /* renamed from: c */
        private Method f175c;

        /* renamed from: d */
        private Context f176d;

        public C0085a(View view, String str) {
            this.f173a = view;
            this.f174b = str;
        }

        /* renamed from: a */
        private void m98a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f174b, new Class[]{View.class})) != null) {
                        this.f175c = method;
                        this.f176d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f173a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f173a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f174b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f173a.getClass() + str2);
        }

        public void onClick(View view) {
            if (this.f175c == null) {
                m98a(this.f173a.getContext(), this.f174b);
            }
            try {
                this.f175c.invoke(this.f176d, new Object[]{view});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || C0656u.m2570C(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0085a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) {
        String str3;
        Constructor<? extends U> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            sConstructorMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String createViewByPrefix : sClassPrefixList) {
                    View createViewByPrefix2 = createViewByPrefix(context, str, createViewByPrefix);
                    if (createViewByPrefix2 != null) {
                        return createViewByPrefix2;
                    }
                }
                Object[] objArr = this.mConstructorArgs;
                objArr[0] = null;
                objArr[1] = null;
                return null;
            }
            View createViewByPrefix3 = createViewByPrefix(context, str, (String) null);
            Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
            return createViewByPrefix3;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr3 = this.mConstructorArgs;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0059a.C0069j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(C0059a.C0069j.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? (!(context instanceof C0159d) || ((C0159d) context).mo1140a() != resourceId) ? new C0159d(context, resourceId) : context : context;
    }

    private void verifyNotNull(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    public C0331e createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0331e(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0333g createButton(Context context, AttributeSet attributeSet) {
        return new C0333g(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0334h createCheckBox(Context context, AttributeSet attributeSet) {
        return new C0334h(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0335i createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new C0335i(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0339l createEditText(Context context, AttributeSet attributeSet) {
        return new C0339l(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0341n createImageButton(Context context, AttributeSet attributeSet) {
        return new C0341n(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0343p createImageView(Context context, AttributeSet attributeSet) {
        return new C0343p(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0344q createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0344q(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0347t createRadioButton(Context context, AttributeSet attributeSet) {
        return new C0347t(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0348u createRatingBar(Context context, AttributeSet attributeSet) {
        return new C0348u(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0349v createSeekBar(Context context, AttributeSet attributeSet) {
        return new C0349v(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0351x createSpinner(Context context, AttributeSet attributeSet) {
        return new C0351x(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0252aa createTextView(Context context, AttributeSet attributeSet) {
        return new C0252aa(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0254ac createToggleButton(Context context, AttributeSet attributeSet) {
        return new C0254ac(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = C0299av.m1073a(context2);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c = 13;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view2 = createTextView(context2, attributeSet);
                break;
            case 1:
                view2 = createImageView(context2, attributeSet);
                break;
            case 2:
                view2 = createButton(context2, attributeSet);
                break;
            case 3:
                view2 = createEditText(context2, attributeSet);
                break;
            case 4:
                view2 = createSpinner(context2, attributeSet);
                break;
            case 5:
                view2 = createImageButton(context2, attributeSet);
                break;
            case 6:
                view2 = createCheckBox(context2, attributeSet);
                break;
            case 7:
                view2 = createRadioButton(context2, attributeSet);
                break;
            case 8:
                view2 = createCheckedTextView(context2, attributeSet);
                break;
            case 9:
                view2 = createAutoCompleteTextView(context2, attributeSet);
                break;
            case 10:
                view2 = createMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case 11:
                view2 = createRatingBar(context2, attributeSet);
                break;
            case 12:
                view2 = createSeekBar(context2, attributeSet);
                break;
            case 13:
                view2 = createToggleButton(context2, attributeSet);
                break;
            default:
                view2 = createView(context2, str, attributeSet);
                break;
        }
        verifyNotNull(view2, str);
        if (view2 == null && context != context2) {
            view2 = createViewFromTag(context2, str, attributeSet);
        }
        if (view2 != null) {
            checkOnClickListener(view2, attributeSet);
        }
        return view2;
    }
}
