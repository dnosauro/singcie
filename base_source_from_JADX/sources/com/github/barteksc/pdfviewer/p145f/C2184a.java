package com.github.barteksc.pdfviewer.p145f;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;

/* renamed from: com.github.barteksc.pdfviewer.f.a */
public class C2184a implements C2185b {

    /* renamed from: a */
    private byte[] f6793a;

    public C2184a(byte[] bArr) {
        this.f6793a = bArr;
    }

    /* renamed from: a */
    public PdfDocument mo9165a(Context context, PdfiumCore pdfiumCore, String str) {
        return pdfiumCore.mo23994a(this.f6793a, str);
    }
}
