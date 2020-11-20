package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.c */
public class C0092c extends C0118h implements DialogInterface {

    /* renamed from: a */
    final AlertController f178a = new AlertController(getContext(), this, getWindow());

    /* renamed from: androidx.appcompat.app.c$a */
    public static class C0093a {

        /* renamed from: P */
        private final AlertController.C0077a f179P;
        private final int mTheme;

        public C0093a(Context context) {
            this(context, C0092c.m124a(context, 0));
        }

        public C0093a(Context context, int i) {
            this.f179P = new AlertController.C0077a(new ContextThemeWrapper(context, C0092c.m124a(context, i)));
            this.mTheme = i;
        }

        public C0092c create() {
            C0092c cVar = new C0092c(this.f179P.f134a, this.mTheme);
            this.f179P.mo702a(cVar.f178a);
            cVar.setCancelable(this.f179P.f151r);
            if (this.f179P.f151r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f179P.f152s);
            cVar.setOnDismissListener(this.f179P.f153t);
            if (this.f179P.f154u != null) {
                cVar.setOnKeyListener(this.f179P.f154u);
            }
            return cVar;
        }

        public Context getContext() {
            return this.f179P.f134a;
        }

        public C0093a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f156w = listAdapter;
            aVar.f157x = onClickListener;
            return this;
        }

        public C0093a setCancelable(boolean z) {
            this.f179P.f151r = z;
            return this;
        }

        public C0093a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f127K = cursor;
            aVar.f128L = str;
            aVar.f157x = onClickListener;
            return this;
        }

        public C0093a setCustomTitle(View view) {
            this.f179P.f140g = view;
            return this;
        }

        public C0093a setIcon(int i) {
            this.f179P.f136c = i;
            return this;
        }

        public C0093a setIcon(Drawable drawable) {
            this.f179P.f137d = drawable;
            return this;
        }

        public C0093a setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f179P.f134a.getTheme().resolveAttribute(i, typedValue, true);
            this.f179P.f136c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public C0093a setInverseBackgroundForced(boolean z) {
            this.f179P.f130N = z;
            return this;
        }

        public C0093a setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = aVar.f134a.getResources().getTextArray(i);
            this.f179P.f157x = onClickListener;
            return this;
        }

        public C0093a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = charSequenceArr;
            aVar.f157x = onClickListener;
            return this;
        }

        public C0093a setMessage(int i) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f141h = aVar.f134a.getText(i);
            return this;
        }

        public C0093a setMessage(CharSequence charSequence) {
            this.f179P.f141h = charSequence;
            return this;
        }

        public C0093a setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = aVar.f134a.getResources().getTextArray(i);
            AlertController.C0077a aVar2 = this.f179P;
            aVar2.f126J = onMultiChoiceClickListener;
            aVar2.f122F = zArr;
            aVar2.f123G = true;
            return this;
        }

        public C0093a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f127K = cursor;
            aVar.f126J = onMultiChoiceClickListener;
            aVar.f129M = str;
            aVar.f128L = str2;
            aVar.f123G = true;
            return this;
        }

        public C0093a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = charSequenceArr;
            aVar.f126J = onMultiChoiceClickListener;
            aVar.f122F = zArr;
            aVar.f123G = true;
            return this;
        }

        public C0093a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f145l = aVar.f134a.getText(i);
            this.f179P.f147n = onClickListener;
            return this;
        }

        public C0093a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f145l = charSequence;
            aVar.f147n = onClickListener;
            return this;
        }

        public C0093a setNegativeButtonIcon(Drawable drawable) {
            this.f179P.f146m = drawable;
            return this;
        }

        public C0093a setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f148o = aVar.f134a.getText(i);
            this.f179P.f150q = onClickListener;
            return this;
        }

        public C0093a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f148o = charSequence;
            aVar.f150q = onClickListener;
            return this;
        }

        public C0093a setNeutralButtonIcon(Drawable drawable) {
            this.f179P.f149p = drawable;
            return this;
        }

        public C0093a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f179P.f152s = onCancelListener;
            return this;
        }

        public C0093a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f179P.f153t = onDismissListener;
            return this;
        }

        public C0093a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f179P.f131O = onItemSelectedListener;
            return this;
        }

        public C0093a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f179P.f154u = onKeyListener;
            return this;
        }

        public C0093a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f142i = aVar.f134a.getText(i);
            this.f179P.f144k = onClickListener;
            return this;
        }

        public C0093a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f142i = charSequence;
            aVar.f144k = onClickListener;
            return this;
        }

        public C0093a setPositiveButtonIcon(Drawable drawable) {
            this.f179P.f143j = drawable;
            return this;
        }

        public C0093a setRecycleOnMeasureEnabled(boolean z) {
            this.f179P.f133Q = z;
            return this;
        }

        public C0093a setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = aVar.f134a.getResources().getTextArray(i);
            AlertController.C0077a aVar2 = this.f179P;
            aVar2.f157x = onClickListener;
            aVar2.f125I = i2;
            aVar2.f124H = true;
            return this;
        }

        public C0093a setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f127K = cursor;
            aVar.f157x = onClickListener;
            aVar.f125I = i;
            aVar.f128L = str;
            aVar.f124H = true;
            return this;
        }

        public C0093a setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f156w = listAdapter;
            aVar.f157x = onClickListener;
            aVar.f125I = i;
            aVar.f124H = true;
            return this;
        }

        public C0093a setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f155v = charSequenceArr;
            aVar.f157x = onClickListener;
            aVar.f125I = i;
            aVar.f124H = true;
            return this;
        }

        public C0093a setTitle(int i) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f139f = aVar.f134a.getText(i);
            return this;
        }

        public C0093a setTitle(CharSequence charSequence) {
            this.f179P.f139f = charSequence;
            return this;
        }

        public C0093a setView(int i) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f159z = null;
            aVar.f158y = i;
            aVar.f121E = false;
            return this;
        }

        public C0093a setView(View view) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f159z = view;
            aVar.f158y = 0;
            aVar.f121E = false;
            return this;
        }

        @Deprecated
        public C0093a setView(View view, int i, int i2, int i3, int i4) {
            AlertController.C0077a aVar = this.f179P;
            aVar.f159z = view;
            aVar.f158y = 0;
            aVar.f121E = true;
            aVar.f117A = i;
            aVar.f118B = i2;
            aVar.f119C = i3;
            aVar.f120D = i4;
            return this;
        }

        public C0092c show() {
            C0092c create = create();
            create.show();
            return create;
        }
    }

    protected C0092c(Context context, int i) {
        super(context, m124a(context, i));
    }

    /* renamed from: a */
    static int m124a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0059a.C0060a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public ListView mo754a() {
        return this.f178a.mo688b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f178a.mo681a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f178a.mo687a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f178a.mo692b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f178a.mo686a(charSequence);
    }
}
