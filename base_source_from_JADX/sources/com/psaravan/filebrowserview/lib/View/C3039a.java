package com.psaravan.filebrowserview.lib.View;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.psaravan.filebrowserview.lib.p150a.C3049a;
import java.util.ArrayList;

/* renamed from: com.psaravan.filebrowserview.lib.View.a */
public abstract class C3039a extends ArrayAdapter<String> {

    /* renamed from: a */
    protected Context f7086a;

    /* renamed from: b */
    protected C3049a f7087b;

    /* renamed from: c */
    protected FileBrowserView f7088c;

    public C3039a(Context context, FileBrowserView fileBrowserView, ArrayList<String> arrayList) {
        super(context, -1, arrayList);
        this.f7086a = context;
        this.f7088c = fileBrowserView;
    }

    /* renamed from: a */
    public ArrayList<String> mo23885a() {
        C3049a aVar = this.f7087b;
        return aVar != null ? aVar.mo23897a() : new ArrayList<>();
    }

    /* renamed from: a */
    public void mo23886a(C3049a aVar) {
        this.f7087b = aVar;
    }

    /* renamed from: b */
    public ArrayList<Integer> mo23887b() {
        C3049a aVar = this.f7087b;
        return aVar != null ? aVar.mo23898b() : new ArrayList<>();
    }

    /* renamed from: c */
    public ArrayList<String> mo23888c() {
        C3049a aVar = this.f7087b;
        return aVar != null ? aVar.mo23899c() : new ArrayList<>();
    }

    /* renamed from: d */
    public ArrayList<String> mo23889d() {
        C3049a aVar = this.f7087b;
        return aVar != null ? aVar.mo23900d() : new ArrayList<>();
    }

    public int getCount() {
        return mo23885a().size();
    }
}
