package com.psaravan.filebrowserview.lib.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.psaravan.filebrowserview.lib.p152c.C3058a;
import java.io.File;

/* renamed from: com.psaravan.filebrowserview.lib.View.b */
public abstract class C3040b extends View {

    /* renamed from: a */
    protected Context f7089a;

    /* renamed from: b */
    protected AbsListView f7090b;

    /* renamed from: c */
    protected C3058a f7091c;

    public C3040b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7089a = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23891a(File file);

    public AbsListView getAbsListView() {
        return this.f7090b;
    }

    public void setNavigationInterface(C3058a aVar) {
        this.f7091c = aVar;
    }
}
