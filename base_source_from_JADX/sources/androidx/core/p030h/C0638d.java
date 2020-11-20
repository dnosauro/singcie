package androidx.core.p030h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.h.d */
public class C0638d {

    /* renamed from: a */
    private static boolean f2293a = false;

    /* renamed from: b */
    private static Method f2294b = null;

    /* renamed from: c */
    private static boolean f2295c = false;

    /* renamed from: d */
    private static Field f2296d;

    /* renamed from: androidx.core.h.d$a */
    public interface C0639a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    /* renamed from: a */
    private static DialogInterface.OnKeyListener m2521a(Dialog dialog) {
        if (!f2295c) {
            try {
                f2296d = Dialog.class.getDeclaredField("mOnKeyListener");
                f2296d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2295c = true;
        }
        Field field = f2296d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m2522a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2293a) {
            try {
                f2294b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2293a = true;
        }
        Method method = f2294b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2523a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m2522a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0656u.m2608b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: a */
    private static boolean m2524a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener a = m2521a(dialog);
        if (a != null && a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0656u.m2608b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    /* renamed from: a */
    public static boolean m2525a(View view, KeyEvent keyEvent) {
        return C0656u.m2602a(view, keyEvent);
    }

    /* renamed from: a */
    public static boolean m2526a(C0639a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? aVar.superDispatchKeyEvent(keyEvent) : callback instanceof Activity ? m2523a((Activity) callback, keyEvent) : callback instanceof Dialog ? m2524a((Dialog) callback, keyEvent) : (view != null && C0656u.m2608b(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent);
    }
}
