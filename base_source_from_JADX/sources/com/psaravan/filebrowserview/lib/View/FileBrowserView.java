package com.psaravan.filebrowserview.lib.View;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.psaravan.filebrowserview.lib.p150a.C3050b;
import com.psaravan.filebrowserview.lib.p150a.C3051c;
import com.psaravan.filebrowserview.lib.p151b.C3056b;
import com.psaravan.filebrowserview.lib.p152c.C3058a;
import com.psaravan.filebrowserview.lib.p153d.C3063b;
import java.io.File;

public class FileBrowserView extends FrameLayout {

    /* renamed from: a */
    private Context f7071a;

    /* renamed from: b */
    private AttributeSet f7072b;

    /* renamed from: c */
    private int f7073c = 0;

    /* renamed from: d */
    private C3040b f7074d;

    /* renamed from: e */
    private C3050b f7075e;

    /* renamed from: f */
    private C3039a f7076f;

    /* renamed from: g */
    private File f7077g = null;

    /* renamed from: h */
    private boolean f7078h = false;

    /* renamed from: i */
    private boolean f7079i = true;

    /* renamed from: j */
    private boolean f7080j = true;

    /* renamed from: k */
    private boolean f7081k = true;

    /* renamed from: l */
    private C3058a f7082l;

    /* renamed from: m */
    private boolean f7083m = false;

    /* renamed from: n */
    private C3051c f7084n;

    /* renamed from: o */
    private boolean f7085o = true;

    public FileBrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7071a = context;
        this.f7072b = attributeSet;
    }

    /* renamed from: a */
    public FileBrowserView mo23860a(int i) {
        this.f7073c = i;
        return this;
    }

    /* renamed from: a */
    public FileBrowserView mo23861a(C3039a aVar) {
        if (aVar instanceof C3039a) {
            this.f7076f = aVar;
            return this;
        }
        throw new IllegalArgumentException("The adapter you pass into setCustomAdapter() must extend AbstractFileBrowserAdapter.");
    }

    /* renamed from: a */
    public FileBrowserView mo23862a(C3058a aVar) {
        this.f7082l = aVar;
        return this;
    }

    /* renamed from: a */
    public FileBrowserView mo23863a(File file) {
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException("You must use a File object that points to a valid, accessible directory.");
        } else if (file.canRead()) {
            this.f7077g = file;
            return this;
        } else {
            throw new IllegalArgumentException("Could not read the specified default directory. Make sure you have permission to read the directory.");
        }
    }

    /* renamed from: a */
    public FileBrowserView mo23864a(boolean z) {
        this.f7078h = z;
        return this;
    }

    /* renamed from: a */
    public void mo23865a() {
        if (getDefaultDirectory() == null) {
            mo23863a(Environment.getExternalStorageDirectory());
        }
        this.f7075e = new C3050b(this.f7071a, this);
        this.f7074d = mo23873f() ? new C3041c(this.f7071a, this.f7072b, this).mo23894a((ViewGroup) this) : getFileBrowserLayoutType() == 0 ? new C3063b(this.f7071a, this.f7072b, this).mo23914a((ViewGroup) this) : new C3056b(this.f7071a, this.f7072b, this).mo23908a((ViewGroup) this);
        this.f7074d.setNavigationInterface(this.f7082l);
    }

    /* renamed from: b */
    public FileBrowserView mo23866b(boolean z) {
        this.f7079i = z;
        return this;
    }

    /* renamed from: b */
    public boolean mo23867b() {
        return this.f7078h;
    }

    /* renamed from: c */
    public FileBrowserView mo23868c(boolean z) {
        this.f7080j = z;
        return this;
    }

    /* renamed from: c */
    public boolean mo23869c() {
        return this.f7079i;
    }

    /* renamed from: d */
    public FileBrowserView mo23870d(boolean z) {
        this.f7081k = z;
        return this;
    }

    /* renamed from: d */
    public boolean mo23871d() {
        return this.f7080j;
    }

    /* renamed from: e */
    public boolean mo23872e() {
        return this.f7081k;
    }

    /* renamed from: f */
    public boolean mo23873f() {
        return this.f7083m;
    }

    /* renamed from: g */
    public boolean mo23874g() {
        return this.f7085o;
    }

    public AbsListView getAbsListView() {
        return this.f7074d.getAbsListView();
    }

    public AttributeSet getAttributeSet() {
        return this.f7072b;
    }

    public File getCurrentDir() {
        return this.f7075e.mo23902a();
    }

    public File getDefaultDirectory() {
        return this.f7077g;
    }

    public C3039a getFileBrowserAdapter() {
        return this.f7076f;
    }

    public C3050b getFileBrowserEngine() {
        return this.f7075e;
    }

    public int getFileBrowserLayoutType() {
        return this.f7073c;
    }

    public C3051c getFileExtensionFilter() {
        return this.f7084n;
    }

    public File getParentDir() {
        return getCurrentDir().getParentFile();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }
}
