package com.psaravan.filebrowserview.lib.p151b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.psaravan.filebrowserview.lib.C3043a;
import com.psaravan.filebrowserview.lib.View.C3039a;
import com.psaravan.filebrowserview.lib.View.C3040b;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import com.psaravan.filebrowserview.lib.p150a.C3049a;
import java.io.File;

/* renamed from: com.psaravan.filebrowserview.lib.b.b */
public class C3056b extends C3040b {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f7121d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FileBrowserView f7122e;

    /* renamed from: f */
    private AdapterView.OnItemClickListener f7123f = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Context d;
            int i2;
            File file = null;
            try {
                File file2 = new File(C3056b.this.f7122e.getFileBrowserAdapter().mo23888c().get(i));
                try {
                    C3056b.this.mo23891a(file2);
                } catch (Exception e) {
                    e = e;
                    file = file2;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (C3056b.this.f7091c != null) {
                    C3056b.this.f7091c.mo8573c(file);
                }
                if (file != null && file.isDirectory()) {
                    d = C3056b.this.f7121d;
                    i2 = C3043a.C3048e.unable_to_load_dir;
                } else if (file != null && !file.isDirectory()) {
                    d = C3056b.this.f7121d;
                    i2 = C3043a.C3048e.unable_to_open_file;
                } else {
                    return;
                }
                Toast.makeText(d, i2, 0).show();
            }
        }
    };

    public C3056b(Context context, AttributeSet attributeSet, FileBrowserView fileBrowserView) {
        super(context, attributeSet);
        this.f7121d = context;
        this.f7122e = fileBrowserView;
    }

    /* renamed from: a */
    public C3056b mo23908a(ViewGroup viewGroup) {
        View.inflate(this.f7121d, C3043a.C3046c.simple_grid_file_browser, viewGroup);
        this.f7090b = (GridView) viewGroup.findViewById(C3043a.C3045b.file_browser_grid_view);
        mo23891a(this.f7122e.getDefaultDirectory());
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23891a(File file) {
        if (file.isDirectory()) {
            if (this.f7091c != null) {
                this.f7091c.mo8571a(file);
            }
            C3049a a = this.f7122e.getFileBrowserEngine().mo23901a(file);
            if (this.f7122e.getFileBrowserAdapter() != null) {
                this.f7122e.getFileBrowserAdapter().mo23886a(a);
            } else {
                this.f7122e.mo23861a((C3039a) new C3052a(this.f7121d, this.f7122e, a));
            }
            this.f7090b.setAdapter(this.f7122e.getFileBrowserAdapter());
            this.f7090b.setOnItemClickListener(this.f7123f);
        } else if (this.f7091c != null) {
            this.f7091c.mo8572b(file);
        }
    }
}
