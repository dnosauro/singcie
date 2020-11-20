package com.github.barteksc.pdfviewer.p145f;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;

/* renamed from: com.github.barteksc.pdfviewer.f.c */
public class C2186c implements C2185b {

    /* renamed from: a */
    private File f6794a;

    public C2186c(File file) {
        this.f6794a = file;
    }

    /* renamed from: a */
    public PdfDocument mo9165a(Context context, PdfiumCore pdfiumCore, String str) {
        return pdfiumCore.mo23993a(ParcelFileDescriptor.open(this.f6794a, 268435456), str);
    }
}
