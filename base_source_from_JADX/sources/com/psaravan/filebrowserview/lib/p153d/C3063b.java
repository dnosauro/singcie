package com.psaravan.filebrowserview.lib.p153d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.psaravan.filebrowserview.lib.C3043a;
import com.psaravan.filebrowserview.lib.View.C3039a;
import com.psaravan.filebrowserview.lib.View.C3040b;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import com.psaravan.filebrowserview.lib.p150a.C3049a;
import java.io.File;

/* renamed from: com.psaravan.filebrowserview.lib.d.b */
public class C3063b extends C3040b {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f7134d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FileBrowserView f7135e;

    /* renamed from: f */
    private AdapterView.OnItemClickListener f7136f = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Context d;
            int i2;
            File file = null;
            try {
                File file2 = new File(C3063b.this.f7135e.getFileBrowserAdapter().mo23888c().get(i));
                try {
                    C3063b.this.mo23891a(file2);
                } catch (Exception e) {
                    e = e;
                    file = file2;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (C3063b.this.f7091c != null) {
                    C3063b.this.f7091c.mo8573c(file);
                }
                if (file != null && file.isDirectory()) {
                    d = C3063b.this.f7134d;
                    i2 = C3043a.C3048e.unable_to_load_dir;
                } else if (file != null && !file.isDirectory()) {
                    d = C3063b.this.f7134d;
                    i2 = C3043a.C3048e.unable_to_open_file;
                } else {
                    return;
                }
                Toast.makeText(d, i2, 0).show();
            }
        }
    };

    public C3063b(Context context, AttributeSet attributeSet, FileBrowserView fileBrowserView) {
        super(context, attributeSet);
        this.f7134d = context;
        this.f7135e = fileBrowserView;
    }

    /* renamed from: a */
    public C3063b mo23914a(ViewGroup viewGroup) {
        View.inflate(this.f7134d, C3043a.C3046c.simple_list_file_browser, viewGroup);
        this.f7090b = (ListView) viewGroup.findViewById(C3043a.C3045b.file_browser_list_view);
        mo23891a(this.f7135e.getDefaultDirectory());
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23891a(File file) {
        if (file.isDirectory()) {
            if (this.f7091c != null) {
                this.f7091c.mo8571a(file);
            }
            C3049a a = this.f7135e.getFileBrowserEngine().mo23901a(file);
            if (this.f7135e.getFileBrowserAdapter() != null) {
                this.f7135e.getFileBrowserAdapter().mo23886a(a);
            } else {
                this.f7135e.mo23861a((C3039a) new C3059a(this.f7134d, this.f7135e, a));
            }
            this.f7090b.setAdapter(this.f7135e.getFileBrowserAdapter());
            this.f7090b.setOnItemClickListener(this.f7136f);
        } else if (this.f7091c != null) {
            this.f7091c.mo8572b(file);
        }
    }
}
