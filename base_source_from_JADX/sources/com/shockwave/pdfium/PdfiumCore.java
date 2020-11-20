package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PdfiumCore {

    /* renamed from: a */
    private static final String f7242a = "com.shockwave.pdfium.PdfiumCore";

    /* renamed from: b */
    private static final Class f7243b = FileDescriptor.class;

    /* renamed from: c */
    private static final Object f7244c = new Object();

    /* renamed from: d */
    private static Field f7245d = null;

    /* renamed from: e */
    private int f7246e;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            String str = f7242a;
            Log.e(str, "Native libraries failed to load - " + e);
        }
    }

    public PdfiumCore(Context context) {
        this.f7246e = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(f7242a, "Starting PdfiumAndroid 1.9.0");
    }

    /* renamed from: a */
    public static int m8945a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f7245d == null) {
                f7245d = f7243b.getDeclaredField("descriptor");
                f7245d.setAccessible(true);
            }
            return f7245d.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    private void m8946a(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.f7229c = j;
        bookmark.f7227a = nativeGetBookmarkTitle(j);
        bookmark.f7228b = nativeGetBookmarkDestIndex(pdfDocument.f7224a, j);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f7224a, Long.valueOf(j));
        if (nativeGetFirstChildBookmark != null) {
            m8946a(bookmark.mo23985a(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.f7224a, j);
        if (nativeGetSiblingBookmark != null) {
            m8946a(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    private native void nativeCloseDocument(long j);

    private native void nativeClosePage(long j);

    private native long nativeGetBookmarkDestIndex(long j, long j2);

    private native String nativeGetBookmarkTitle(long j);

    private native Integer nativeGetDestPageIndex(long j, long j2);

    private native String nativeGetDocumentMetaText(long j, String str);

    private native Long nativeGetFirstChildBookmark(long j, Long l);

    private native RectF nativeGetLinkRect(long j);

    private native String nativeGetLinkURI(long j, long j2);

    private native int nativeGetPageCount(long j);

    private native long[] nativeGetPageLinks(long j);

    private native Size nativeGetPageSizeByIndex(long j, int i, int i2);

    private native Long nativeGetSiblingBookmark(long j, long j2);

    private native long nativeLoadPage(long j, int i);

    private native long nativeOpenDocument(int i, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    private native void nativeRenderPageBitmap(long j, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z);

    /* renamed from: a */
    public int mo23989a(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (f7244c) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.f7224a);
        }
        return nativeGetPageCount;
    }

    /* renamed from: a */
    public long mo23990a(PdfDocument pdfDocument, int i) {
        long nativeLoadPage;
        synchronized (f7244c) {
            nativeLoadPage = nativeLoadPage(pdfDocument.f7224a, i);
            pdfDocument.f7226c.put(Integer.valueOf(i), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    /* renamed from: a */
    public Point mo23991a(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        return nativePageCoordsToDevice(pdfDocument.f7226c.get(Integer.valueOf(i)).longValue(), i2, i3, i4, i5, i6, d, d2);
    }

    /* renamed from: a */
    public RectF mo23992a(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, RectF rectF) {
        RectF rectF2 = rectF;
        Point a = mo23991a(pdfDocument, i, i2, i3, i4, i5, i6, (double) rectF2.left, (double) rectF2.top);
        Point a2 = mo23991a(pdfDocument, i, i2, i3, i4, i5, i6, (double) rectF2.right, (double) rectF2.bottom);
        return new RectF((float) a.x, (float) a.y, (float) a2.x, (float) a2.y);
    }

    /* renamed from: a */
    public PdfDocument mo23993a(ParcelFileDescriptor parcelFileDescriptor, String str) {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.f7225b = parcelFileDescriptor;
        synchronized (f7244c) {
            pdfDocument.f7224a = nativeOpenDocument(m8945a(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    /* renamed from: a */
    public PdfDocument mo23994a(byte[] bArr, String str) {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (f7244c) {
            pdfDocument.f7224a = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }

    /* renamed from: a */
    public void mo23995a(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (f7244c) {
            try {
                try {
                    nativeRenderPageBitmap(pdfDocument.f7226c.get(Integer.valueOf(i)).longValue(), bitmap, this.f7246e, i2, i3, i4, i5, z);
                } catch (NullPointerException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                    Log.e(f7242a, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (NullPointerException e3) {
                e = e3;
                Log.e(f7242a, "mContext may be null");
                e.printStackTrace();
            } catch (Exception e4) {
                e = e4;
                Log.e(f7242a, "Exception throw from native");
                e.printStackTrace();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: b */
    public Size mo23996b(PdfDocument pdfDocument, int i) {
        Size nativeGetPageSizeByIndex;
        synchronized (f7244c) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.f7224a, i, this.f7246e);
        }
        return nativeGetPageSizeByIndex;
    }

    /* renamed from: b */
    public void mo23997b(PdfDocument pdfDocument) {
        synchronized (f7244c) {
            for (Integer num : pdfDocument.f7226c.keySet()) {
                nativeClosePage(pdfDocument.f7226c.get(num).longValue());
            }
            pdfDocument.f7226c.clear();
            nativeCloseDocument(pdfDocument.f7224a);
            if (pdfDocument.f7225b != null) {
                try {
                    pdfDocument.f7225b.close();
                } catch (IOException unused) {
                }
                pdfDocument.f7225b = null;
            }
        }
    }

    /* renamed from: c */
    public PdfDocument.Meta mo23998c(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (f7244c) {
            meta = new PdfDocument.Meta();
            meta.f7234a = nativeGetDocumentMetaText(pdfDocument.f7224a, "Title");
            meta.f7235b = nativeGetDocumentMetaText(pdfDocument.f7224a, "Author");
            meta.f7236c = nativeGetDocumentMetaText(pdfDocument.f7224a, "Subject");
            meta.f7237d = nativeGetDocumentMetaText(pdfDocument.f7224a, "Keywords");
            meta.f7238e = nativeGetDocumentMetaText(pdfDocument.f7224a, "Creator");
            meta.f7239f = nativeGetDocumentMetaText(pdfDocument.f7224a, "Producer");
            meta.f7240g = nativeGetDocumentMetaText(pdfDocument.f7224a, "CreationDate");
            meta.f7241h = nativeGetDocumentMetaText(pdfDocument.f7224a, "ModDate");
        }
        return meta;
    }

    /* renamed from: c */
    public List<PdfDocument.Link> mo23999c(PdfDocument pdfDocument, int i) {
        synchronized (f7244c) {
            ArrayList arrayList = new ArrayList();
            Long l = pdfDocument.f7226c.get(Integer.valueOf(i));
            if (l == null) {
                return arrayList;
            }
            for (long j : nativeGetPageLinks(l.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.f7224a, j);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.f7224a, j);
                RectF nativeGetLinkRect = nativeGetLinkRect(j);
                if (!(nativeGetLinkRect == null || (nativeGetDestPageIndex == null && nativeGetLinkURI == null))) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    /* renamed from: d */
    public List<PdfDocument.Bookmark> mo24000d(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (f7244c) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.f7224a, (Long) null);
            if (nativeGetFirstChildBookmark != null) {
                m8946a(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }
}
