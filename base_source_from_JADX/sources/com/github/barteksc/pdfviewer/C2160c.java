package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.p145f.C2185b;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;

/* renamed from: com.github.barteksc.pdfviewer.c */
class C2160c extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a */
    private boolean f6706a = false;

    /* renamed from: b */
    private WeakReference<PDFView> f6707b;

    /* renamed from: c */
    private PdfiumCore f6708c;

    /* renamed from: d */
    private String f6709d;

    /* renamed from: e */
    private C2185b f6710e;

    /* renamed from: f */
    private int[] f6711f;

    /* renamed from: g */
    private C2183f f6712g;

    C2160c(C2185b bVar, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f6710e = bVar;
        this.f6711f = iArr;
        this.f6707b = new WeakReference<>(pDFView);
        this.f6709d = str;
        this.f6708c = pdfiumCore;
    }

    /* renamed from: a */
    private Size m8512a(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = (PDFView) this.f6707b.get();
            if (pDFView == null) {
                return new NullPointerException("pdfView == null");
            }
            this.f6712g = new C2183f(this.f6708c, this.f6710e.mo9165a(pDFView.getContext(), this.f6708c, this.f6709d), pDFView.getPageFitPolicy(), m8512a(pDFView), this.f6711f, pDFView.mo9006m(), pDFView.getSpacingPx(), pDFView.mo9012p(), pDFView.mo9014r());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Throwable th) {
        PDFView pDFView = (PDFView) this.f6707b.get();
        if (pDFView == null) {
            return;
        }
        if (th != null) {
            pDFView.mo8966a(th);
        } else if (!this.f6706a) {
            pDFView.mo8965a(this.f6712g);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.f6706a = true;
    }
}
