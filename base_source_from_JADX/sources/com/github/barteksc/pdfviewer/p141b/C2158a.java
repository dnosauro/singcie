package com.github.barteksc.pdfviewer.p141b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.p143d.C2173a;

/* renamed from: com.github.barteksc.pdfviewer.b.a */
public class C2158a implements C2159b {

    /* renamed from: a */
    private static final String f6704a = "a";

    /* renamed from: b */
    private PDFView f6705b;

    public C2158a(PDFView pDFView) {
        this.f6705b = pDFView;
    }

    /* renamed from: a */
    private void m8508a(int i) {
        this.f6705b.mo8961a(i);
    }

    /* renamed from: a */
    private void m8509a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.f6705b.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        String str2 = f6704a;
        Log.w(str2, "No activity found for URI: " + str);
    }

    /* renamed from: a */
    public void mo9067a(C2173a aVar) {
        String b = aVar.mo9118a().mo23987b();
        Integer a = aVar.mo9118a().mo23986a();
        if (b != null && !b.isEmpty()) {
            m8509a(b);
        } else if (a != null) {
            m8508a(a.intValue());
        }
    }
}
