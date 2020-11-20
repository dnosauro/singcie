package com.psaravan.filebrowserview.lib.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.psaravan.filebrowserview.lib.C3043a;
import com.psaravan.filebrowserview.lib.p151b.C3056b;
import com.psaravan.filebrowserview.lib.p153d.C3063b;
import java.io.File;

/* renamed from: com.psaravan.filebrowserview.lib.View.c */
public class C3041c extends View {

    /* renamed from: a */
    protected TabHost f7092a;

    /* renamed from: b */
    protected TabWidget f7093b;

    /* renamed from: c */
    protected ImageView f7094c;

    /* renamed from: d */
    protected FrameLayout f7095d;

    /* renamed from: e */
    private Context f7096e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FileBrowserView f7097f;

    /* renamed from: g */
    private View.OnClickListener f7098g = new View.OnClickListener() {
        public void onClick(View view) {
            C3041c cVar = C3041c.this;
            cVar.mo23895a(cVar.f7097f.getDefaultDirectory());
        }
    };

    public C3041c(Context context, AttributeSet attributeSet, FileBrowserView fileBrowserView) {
        super(context, attributeSet);
        this.f7096e = context;
        this.f7097f = fileBrowserView;
    }

    /* renamed from: a */
    public C3040b mo23894a(ViewGroup viewGroup) {
        View inflate = View.inflate(this.f7096e, C3043a.C3046c.tabbed_browser_container, viewGroup);
        this.f7092a = (TabHost) inflate.findViewById(C3043a.C3045b.tabHost);
        this.f7093b = (TabWidget) inflate.findViewById(16908307);
        this.f7094c = (ImageView) inflate.findViewById(C3043a.C3045b.new_tab_button);
        this.f7095d = (FrameLayout) inflate.findViewById(16908305);
        this.f7094c.setOnClickListener(this.f7098g);
        this.f7092a.setup();
        return mo23895a(this.f7097f.getDefaultDirectory());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3040b mo23895a(File file) {
        C3040b a = this.f7097f.getFileBrowserLayoutType() == 0 ? new C3063b(this.f7096e, this.f7097f.getAttributeSet(), this.f7097f).mo23914a((ViewGroup) this.f7095d) : new C3056b(this.f7096e, this.f7097f.getAttributeSet(), this.f7097f).mo23908a((ViewGroup) this.f7095d);
        a.setId(this.f7092a.getTabWidget().getTabCount() + 1);
        this.f7095d.addView(a);
        String name = file.getAbsoluteFile().getName();
        TabHost.TabSpec newTabSpec = this.f7092a.newTabSpec(name);
        newTabSpec.setIndicator(name);
        newTabSpec.setContent(this.f7092a.getTabWidget().getTabCount() + 1);
        this.f7092a.addTab(newTabSpec);
        return a;
    }
}
