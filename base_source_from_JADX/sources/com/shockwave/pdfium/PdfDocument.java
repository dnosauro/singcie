package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import androidx.p018c.C0400a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PdfDocument {

    /* renamed from: a */
    long f7224a;

    /* renamed from: b */
    ParcelFileDescriptor f7225b;

    /* renamed from: c */
    final Map<Integer, Long> f7226c = new C0400a();

    public static class Bookmark {

        /* renamed from: a */
        String f7227a;

        /* renamed from: b */
        long f7228b;

        /* renamed from: c */
        long f7229c;

        /* renamed from: d */
        private List<Bookmark> f7230d = new ArrayList();

        /* renamed from: a */
        public List<Bookmark> mo23985a() {
            return this.f7230d;
        }
    }

    public static class Link {

        /* renamed from: a */
        private RectF f7231a;

        /* renamed from: b */
        private Integer f7232b;

        /* renamed from: c */
        private String f7233c;

        public Link(RectF rectF, Integer num, String str) {
            this.f7231a = rectF;
            this.f7232b = num;
            this.f7233c = str;
        }

        /* renamed from: a */
        public Integer mo23986a() {
            return this.f7232b;
        }

        /* renamed from: b */
        public String mo23987b() {
            return this.f7233c;
        }

        /* renamed from: c */
        public RectF mo23988c() {
            return this.f7231a;
        }
    }

    public static class Meta {

        /* renamed from: a */
        String f7234a;

        /* renamed from: b */
        String f7235b;

        /* renamed from: c */
        String f7236c;

        /* renamed from: d */
        String f7237d;

        /* renamed from: e */
        String f7238e;

        /* renamed from: f */
        String f7239f;

        /* renamed from: g */
        String f7240g;

        /* renamed from: h */
        String f7241h;
    }

    PdfDocument() {
    }
}
