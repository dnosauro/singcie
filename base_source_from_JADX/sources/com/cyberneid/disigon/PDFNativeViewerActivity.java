package com.cyberneid.disigon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberneid.disigon.PDFNativeViewerActivity;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.C1831e;
import com.cyberneid.p105d.p114g.C1867f;
import com.cyberneid.p105d.p114g.p122e.p125c.C1861e;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.p142c.C2164d;
import com.github.barteksc.pdfviewer.p142c.C2166f;
import com.github.barteksc.pdfviewer.p142c.C2167g;
import com.github.barteksc.pdfviewer.p142c.C2169i;
import com.github.barteksc.pdfviewer.p144e.C2180a;
import com.github.barteksc.pdfviewer.p144e.C2182b;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p082b.p083a.C1422a;
import com.p137e.p139b.C2140d;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shockwave.pdfium.util.SizeF;
import com.tolstykh.textviewrichdrawable.ButtonRichDrawable;
import com.wang.avi.AVLoadingIndicatorView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PDFNativeViewerActivity extends C2072b implements View.OnTouchListener, C2164d, C2166f, C2167g, C2169i {

    /* renamed from: x */
    private static int f6270x;

    /* renamed from: a */
    float f6271a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RelativeLayout f6272b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RelativeLayout f6273c;

    /* renamed from: d */
    private TextView f6274d;

    /* renamed from: e */
    private Bitmap f6275e;

    /* renamed from: f */
    private View f6276f;

    /* renamed from: g */
    private ImageView f6277g;

    /* renamed from: h */
    private EditText f6278h;

    /* renamed from: i */
    private ImageView f6279i;

    /* renamed from: j */
    private ImageView f6280j;

    /* renamed from: k */
    private ImageView f6281k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ParcelFileDescriptor f6282l;

    /* renamed from: m */
    private int f6283m = 0;

    /* renamed from: n */
    private float f6284n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1783c f6285o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f6286p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public PDFView f6287q;

    /* renamed from: r */
    private int f6288r;

    /* renamed from: s */
    private int f6289s;

    /* renamed from: t */
    private float f6290t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Uri f6291u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public AVLoadingIndicatorView f6292v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public RelativeLayout f6293w;

    /* renamed from: y */
    private C1422a f6294y;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8087a() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", this.f6291u);
            intent.setType("application/pdf");
            startActivity(Intent.createChooser(intent, "Share"));
        } catch (Exception e) {
            e.printStackTrace();
            C2081e.m8300a((Context) this, "Errore", "Il file non può essere condiviso", (C2081e.C2094c) new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                }
            });
        }
    }

    /* renamed from: a */
    private void m8088a(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        this.f6291u = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        this.f6286p = intent.getStringExtra("filename");
        TextView textView = (TextView) findViewById(R.id.fileNameTextView);
        if (this.f6291u == null) {
            this.f6291u = intent.getData();
        }
        Uri uri = this.f6291u;
        if (uri == null) {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            instance.log("action " + action);
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.log("type " + type);
            FirebaseCrashlytics instance3 = FirebaseCrashlytics.getInstance();
            instance3.log("filename " + this.f6286p);
            FirebaseCrashlytics.getInstance().log(intent.toString());
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("pdfUri is null"));
            return;
        }
        textView.setText(uri.getLastPathSegment());
        setTitle(this.f6291u.getLastPathSegment());
        m8089a(this.f6291u);
    }

    /* renamed from: a */
    private void m8089a(final Uri uri) {
        this.f6293w.setVisibility(0);
        this.f6292v.show();
        C2140d.m8401a(new Runnable() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8116a() {
                PDFNativeViewerActivity.this.f6292v.hide();
                PDFNativeViewerActivity.this.f6293w.setVisibility(4);
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8117a(int i) {
                PDFNativeViewerActivity.this.f6272b.setVisibility(0);
                if (i > 0) {
                    ((TextView) PDFNativeViewerActivity.this.findViewById(R.id.signatureInfoTextView)).setText(PDFNativeViewerActivity.this.getResources().getQuantityString(R.plurals.no_of_signatures, i, new Object[]{Integer.valueOf(i)}));
                    PDFNativeViewerActivity.this.findViewById(R.id.signatureInfoView).setVisibility(0);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8118a(final Exception exc) {
                try {
                    if (PDFNativeViewerActivity.this.f6285o != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        PDFNativeViewerActivity.this.f6285o.mo8061a((OutputStream) byteArrayOutputStream);
                        final ParseFile parseFile = new ParseFile(byteArrayOutputStream.toByteArray());
                        parseFile.saveInBackground((SaveCallback) new SaveCallback() {
                            public void done(ParseException parseException) {
                                if (parseException == null) {
                                    StringWriter stringWriter = new StringWriter();
                                    exc.printStackTrace(new PrintWriter(stringWriter));
                                    ParseObject create = ParseObject.create("PDF");
                                    create.put("pdf", parseFile);
                                    create.put("exception", stringWriter.toString());
                                    create.saveInBackground();
                                    return;
                                }
                                FirebaseCrashlytics.getInstance().recordException(parseException);
                            }
                        });
                    }
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8119a(byte[] bArr) {
                try {
                    final ParseFile parseFile = new ParseFile(bArr);
                    parseFile.saveInBackground((SaveCallback) new SaveCallback() {
                        public void done(ParseException parseException) {
                            if (parseException == null) {
                                StringWriter stringWriter = new StringWriter();
                                parseException.printStackTrace(new PrintWriter(stringWriter));
                                ParseObject create = ParseObject.create("PDF");
                                create.put("pdf", parseFile);
                                create.put("exception", stringWriter.toString());
                                create.saveInBackground();
                                return;
                            }
                            FirebaseCrashlytics.getInstance().recordException(parseException);
                        }
                    });
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8120a(byte[] bArr, int i) {
                try {
                    PDFNativeViewerActivity.this.f6287q.mo8953a(bArr).mo9024a(i).mo9026a((C2166f) PDFNativeViewerActivity.this).mo9030a(true).mo9025a((C2164d) PDFNativeViewerActivity.this).mo9029a((C2182b) new C2180a(PDFNativeViewerActivity.this)).mo9032b(10).mo9027a((C2167g) PDFNativeViewerActivity.this).mo9034c(true).mo9033b(true).mo9035d(true).mo9031a();
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    C2140d.m8401a(new Runnable(bArr) {
                        private final /* synthetic */ byte[] f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            PDFNativeViewerActivity.C20055.this.m8119a(this.f$1);
                        }
                    });
                }
                PDFNativeViewerActivity.this.f6292v.hide();
                PDFNativeViewerActivity.this.f6293w.setVisibility(4);
                PDFNativeViewerActivity.this.f6272b.setVisibility(0);
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public /* synthetic */ void m8121b() {
                PDFNativeViewerActivity.this.f6292v.hide();
                PDFNativeViewerActivity.this.f6293w.setVisibility(4);
                PDFNativeViewerActivity pDFNativeViewerActivity = PDFNativeViewerActivity.this;
                C2081e.m8300a((Context) pDFNativeViewerActivity, pDFNativeViewerActivity.getResources().getString(R.string.app_name), "Il PDF è protetto da password e pertanto non può essere visualizzato e firmato.", (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                        PDFNativeViewerActivity.this.setResult(0, (Intent) null);
                        PDFNativeViewerActivity.this.finish();
                    }
                });
            }

            /* access modifiers changed from: private */
            /* renamed from: c */
            public /* synthetic */ void m8122c() {
                PDFNativeViewerActivity pDFNativeViewerActivity = PDFNativeViewerActivity.this;
                C2081e.m8300a((Context) pDFNativeViewerActivity, pDFNativeViewerActivity.getResources().getString(R.string.app_name), "Il PDF è protetto da password e pertanto non può essere visualizzato e firmato.", (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                    }
                });
            }

            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ff, code lost:
                r0 = e;
             */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00ff A[ExcHandler: c (e com.cyberneid.d.g.b.c), PHI: r3 
              PHI: (r3v7 int) = (r3v9 int), (r3v18 int), (r3v19 int), (r3v19 int), (r3v19 int) binds: [B:20:0x0074, B:5:0x0040, B:11:0x0055, B:15:0x006b, B:16:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x0055] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this
                    android.content.ContentResolver r0 = r0.getContentResolver()
                    r1 = 0
                    com.cyberneid.disigon.PDFNativeViewerActivity r2 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    android.net.Uri r3 = r3     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.lang.String r4 = "r"
                    android.os.ParcelFileDescriptor r0 = r0.openFileDescriptor(r3, r4)     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    android.os.ParcelFileDescriptor unused = r2.f6282l = r0     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    com.cyberneid.disigon.PDFNativeViewerActivity r2 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    android.os.ParcelFileDescriptor r2 = r2.f6282l     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.io.FileDescriptor r2 = r2.getFileDescriptor()     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    r0.<init>(r2)     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    com.cyberneid.disigon.PDFNativeViewerActivity r2 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.lang.String r2 = r2.f6286p     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.lang.String r2 = r2.toLowerCase()     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    java.lang.String r3 = ".p7m"
                    boolean r2 = r2.endsWith(r3)     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    if (r2 == 0) goto L_0x006f
                    com.cyberneid.a.a r2 = com.cyberneid.p087a.C1451a.m5466a((java.io.InputStream) r0)     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    r0.close()     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    int r3 = r2.mo6910a()     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    boolean r4 = r2.mo6916e()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x0051
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.disigon.PDFNativeViewerActivity$5$1 r1 = new com.cyberneid.disigon.PDFNativeViewerActivity$5$1     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r1.<init>()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r0.runOnUiThread(r1)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    return
                L_0x0051:
                    byte[] r2 = r2.mo6914c()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                L_0x0055:
                    com.cyberneid.a.a r4 = com.cyberneid.p087a.C1451a.m5469a((byte[]) r2)     // Catch:{ Exception -> 0x006a, c -> 0x00ff }
                    java.lang.String r5 = "PDFNativeViewerActivity"
                    java.lang.String r6 = "Internal signature found"
                    android.util.Log.d(r5, r6)     // Catch:{ Exception -> 0x006a, c -> 0x00ff }
                    byte[] r2 = r4.mo6914c()     // Catch:{ Exception -> 0x006a, c -> 0x00ff }
                    int r4 = r4.mo6910a()     // Catch:{ Exception -> 0x006a, c -> 0x00ff }
                    int r3 = r3 + r4
                    goto L_0x0055
                L_0x006a:
                    r4 = move-exception
                    r4.printStackTrace()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    goto L_0x0074
                L_0x006f:
                    byte[] r2 = com.p137e.p139b.C2139c.m8400a(r0)     // Catch:{ c -> 0x0124, Exception -> 0x0101 }
                    r3 = 0
                L_0x0074:
                    r0.close()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.d.e.f r0 = new com.cyberneid.d.e.f     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.d.d.d r4 = new com.cyberneid.d.d.d     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r4.<init>(r2)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r0.<init>(r4)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r0.mo7799B()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.d.g.c r0 = r0.mo7800z()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    boolean r4 = r0.mo8064c()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x0099
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$uZA-DWyAvYLSUwvTJVeLY8imVgM r1 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$uZA-DWyAvYLSUwvTJVeLY8imVgM     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r1.<init>()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r0.runOnUiThread(r1)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    return
                L_0x0099:
                    com.cyberneid.d.g.b.a r4 = r0.mo8072j()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x00c5
                    boolean r5 = r4.mo7968d()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    if (r5 == 0) goto L_0x00ab
                    boolean r4 = r4.mo7978j()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x00c5
                L_0x00ab:
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.disigon.PDFNativeViewerActivity r1 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    android.content.res.Resources r1 = r1.getResources()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r2 = 2131755080(0x7f100048, float:1.914103E38)
                    java.lang.String r1 = r1.getString(r2)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    java.lang.String r2 = "Il PDF è protetto da una policy definita dall'autore e pertanto non può essere firmato."
                    com.cyberneid.disigon.PDFNativeViewerActivity$5$3 r4 = new com.cyberneid.disigon.PDFNativeViewerActivity$5$3     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    r4.<init>()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.disigon.p134b.C2081e.m8300a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (com.cyberneid.disigon.p134b.C2081e.C2094c) r4)     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    return
                L_0x00c5:
                    com.cyberneid.disigon.PDFNativeViewerActivity r4 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.p105d.p114g.C1783c unused = r4.f6285o = r0     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    com.cyberneid.d.g.c r0 = r0.f6285o     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    java.util.List r0 = r0.mo8067e()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    int r0 = r0.size()     // Catch:{ c -> 0x00ff, Exception -> 0x00fd }
                    int r0 = r0 + r3
                    com.cyberneid.disigon.PDFNativeViewerActivity r3 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    android.content.Intent r3 = r3.getIntent()     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    java.lang.String r4 = "currentPage"
                    int r1 = r3.getIntExtra(r4, r1)     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    com.cyberneid.disigon.PDFNativeViewerActivity r3 = com.cyberneid.disigon.PDFNativeViewerActivity.this     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    com.github.barteksc.pdfviewer.PDFView r3 = r3.f6287q     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$q6hXBJSb_i_W_uGUd7TtgRviVPA r4 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$q6hXBJSb_i_W_uGUd7TtgRviVPA     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    r4.<init>(r2, r1)     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    r3.post(r4)     // Catch:{ c -> 0x00f9, Exception -> 0x00f5 }
                    r3 = r0
                    goto L_0x013e
                L_0x00f5:
                    r1 = move-exception
                    r3 = r0
                    r0 = r1
                    goto L_0x0103
                L_0x00f9:
                    r1 = move-exception
                    r3 = r0
                    r0 = r1
                    goto L_0x0126
                L_0x00fd:
                    r0 = move-exception
                    goto L_0x0103
                L_0x00ff:
                    r0 = move-exception
                    goto L_0x0126
                L_0x0101:
                    r0 = move-exception
                    r3 = 0
                L_0x0103:
                    r0.printStackTrace()
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
                    r1.recordException(r0)
                    com.cyberneid.disigon.PDFNativeViewerActivity r1 = com.cyberneid.disigon.PDFNativeViewerActivity.this
                    com.github.barteksc.pdfviewer.PDFView r1 = r1.f6287q
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$doNFCe0ri2Mnq0fZFpbJjISq4VE r2 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$doNFCe0ri2Mnq0fZFpbJjISq4VE
                    r2.<init>()
                    r1.post(r2)
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$SqaxvKdA0bZ3dkJgJjNGCfSz4Rw r1 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$SqaxvKdA0bZ3dkJgJjNGCfSz4Rw
                    r1.<init>(r0)
                    com.p137e.p139b.C2140d.m8401a(r1)
                    goto L_0x013e
                L_0x0124:
                    r0 = move-exception
                    r3 = 0
                L_0x0126:
                    r0.printStackTrace()
                    com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
                    r1.recordException(r0)
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this
                    com.github.barteksc.pdfviewer.PDFView r0 = r0.f6287q
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$8P5YWAtWA5Dt_ndWGBGXn_etUMc r1 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$8P5YWAtWA5Dt_ndWGBGXn_etUMc
                    r1.<init>()
                    r0.post(r1)
                L_0x013e:
                    com.cyberneid.disigon.PDFNativeViewerActivity r0 = com.cyberneid.disigon.PDFNativeViewerActivity.this
                    com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$xnPxNNfJt70uHJsq_M4e1f7dVwE r1 = new com.cyberneid.disigon.-$$Lambda$PDFNativeViewerActivity$5$xnPxNNfJt70uHJsq_M4e1f7dVwE
                    r1.<init>(r3)
                    r0.runOnUiThread(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.PDFNativeViewerActivity.C20055.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8090a(File file) {
        this.f6287q.mo8952a(file).mo9024a(f6270x).mo9026a((C2166f) this).mo9030a(true).mo9029a((C2182b) new C2180a(this)).mo9032b(10).mo9027a((C2167g) this).mo9034c(true).mo9033b(true).mo9035d(true).mo9031a();
        this.f6292v.hide();
        this.f6293w.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8091b() {
        this.f6273c.setVisibility(0);
        findViewById(R.id.buttonWriteLayout).setEnabled(false);
        findViewById(R.id.buttonWrite).setEnabled(false);
        findViewById(R.id.buttonSignLayout).setEnabled(false);
        findViewById(R.id.buttonSign).setEnabled(false);
        this.f6278h.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8093c() {
        final String b = C2125f.m8367b(this.f6286p);
        if (b.equalsIgnoreCase("application/pdf") || this.f6286p.toLowerCase().endsWith(".pdf.")) {
            final Intent intent = new Intent(this, PDFSignerNativeViewerActivity.class);
            intent.setType(b);
            intent.setAction(getIntent().getAction());
            intent.putExtra("android.intent.extra.STREAM", this.f6291u);
            intent.putExtra("filename", C2125f.m8366b(this, this.f6291u, b));
            intent.putExtra("currentPage", this.f6287q.getCurrentPage());
            C2081e.m8298a((Context) this, (C2081e.C2095d) new C2081e.C2095d() {
                /* renamed from: a */
                public void mo8599a() {
                    try {
                        if (PDFNativeViewerActivity.this.f6285o != null) {
                            PDFNativeViewerActivity.this.f6285o.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PDFNativeViewerActivity pDFNativeViewerActivity = PDFNativeViewerActivity.this;
                    intent.putExtra("isFirstSignature", !C2125f.m8364a(pDFNativeViewerActivity, pDFNativeViewerActivity.f6291u, b));
                    intent.putExtra("signatureType", "pdf");
                    intent.putExtra("stamp", true);
                    if ("android.intent.action.SIGN_AND_RETURN".equals(PDFNativeViewerActivity.this.getIntent().getAction())) {
                        PDFNativeViewerActivity.this.startActivityForResult(intent, 1);
                    } else {
                        PDFNativeViewerActivity.this.startActivity(intent);
                    }
                }

                /* renamed from: b */
                public void mo8600b() {
                    try {
                        if (PDFNativeViewerActivity.this.f6285o != null) {
                            PDFNativeViewerActivity.this.f6285o.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    intent.putExtra("signatureType", "p7m");
                    if ("android.intent.action.SIGN_AND_RETURN".equals(PDFNativeViewerActivity.this.getIntent().getAction())) {
                        PDFNativeViewerActivity.this.startActivityForResult(intent, 1);
                    } else {
                        PDFNativeViewerActivity.this.startActivity(intent);
                    }
                }

                /* renamed from: c */
                public void mo8601c() {
                }
            });
            return;
        }
        try {
            if (this.f6285o != null) {
                this.f6285o.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent2 = new Intent(this, FileSignerActivity.class);
        intent2.setType(b);
        intent2.setAction(getIntent().getAction());
        intent2.putExtra("android.intent.extra.STREAM", this.f6291u);
        intent2.putExtra("filename", C2125f.m8366b(this, this.f6291u, b));
        intent2.putExtra("command", "sign");
        intent2.putExtra("signatureType", "p7m");
        if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
            startActivityForResult(intent2, 1);
        } else {
            startActivity(intent2);
        }
    }

    /* renamed from: d */
    private boolean m8096d() {
        float f;
        float zoom = this.f6287q.getZoom();
        int currentPage = this.f6287q.getCurrentPage();
        SizeF d = this.f6287q.mo8982d(currentPage);
        float height = (((float) this.f6287q.getHeight()) - d.mo24007b()) / 2.0f;
        float width = (((float) this.f6287q.getWidth()) - d.mo24006a()) / 2.0f;
        PrintStream printStream = System.out;
        printStream.println("offsetX0: " + width);
        PrintStream printStream2 = System.out;
        printStream2.println("offsetY0: " + height);
        PrintStream printStream3 = System.out;
        printStream3.println("size: " + d);
        PrintStream printStream4 = System.out;
        printStream4.println("size: " + this.f6287q.getWidth() + ", " + this.f6287q.getHeight());
        float f2 = 0.0f;
        if (zoom > 1.0f) {
            float currentYOffset = this.f6287q.getCurrentYOffset();
            float currentXOffset = this.f6287q.getCurrentXOffset();
            PrintStream printStream5 = System.out;
            printStream5.println("offsetX: " + currentXOffset);
            PrintStream printStream6 = System.out;
            printStream6.println("offsetY: " + currentYOffset);
            if (currentPage > 0) {
                currentYOffset += this.f6284n * zoom * ((float) currentPage);
                PrintStream printStream7 = System.out;
                printStream7.println("offsetX: " + currentXOffset);
                PrintStream printStream8 = System.out;
                printStream8.println("offsetY: " + currentYOffset);
            }
            height *= zoom;
            width *= zoom;
            PrintStream printStream9 = System.out;
            printStream9.println("offsetX0: " + width);
            PrintStream printStream10 = System.out;
            printStream10.println("offsetY0: " + height);
            f = currentYOffset;
            f2 = currentXOffset;
        } else {
            f = 0.0f;
        }
        this.f6276f.getWidth();
        this.f6277g.getWidth();
        int left = (int) ((((((float) this.f6276f.getLeft()) - width) - f2) + ((float) this.f6277g.getLeft())) - ((float) this.f6272b.getLeft()));
        int top = (int) (((((float) this.f6276f.getTop()) - height) - f) + ((float) this.f6277g.getTop()));
        int width2 = this.f6276f.getWidth() + left;
        int height2 = this.f6276f.getHeight() + top;
        float a = d.mo24006a();
        float b = d.mo24007b();
        System.out.println(String.format("x0: %d, y0: %d, x1: %d, y1: %d, w: %f, h: %f", new Object[]{Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(width2), Integer.valueOf(height2), Float.valueOf(a), Float.valueOf(b)}));
        return left >= 0 && ((float) width2) <= a && top >= 0 && ((float) height2) <= b;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m8098e() {
        float f;
        C1831e a = this.f6285o.mo8054a(f6270x);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f6275e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            C1783c cVar = this.f6285o;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C1861e a2 = C1861e.m7709a(cVar, byteArray, "signature" + System.currentTimeMillis());
            C1867f fVar = new C1867f(this.f6285o, a, true, true, true);
            float zoom = this.f6287q.getZoom();
            PrintStream printStream = System.out;
            printStream.println("zoom:" + zoom);
            SizeF d = this.f6287q.mo8982d(f6270x);
            float height = (((float) this.f6287q.getHeight()) - d.mo24007b()) / 2.0f;
            float width = (((float) this.f6287q.getWidth()) - d.mo24006a()) / 2.0f;
            PrintStream printStream2 = System.out;
            printStream2.println("offsetX0: " + width);
            PrintStream printStream3 = System.out;
            printStream3.println("offsetY0: " + height);
            PrintStream printStream4 = System.out;
            printStream4.println("size: " + d);
            PrintStream printStream5 = System.out;
            printStream5.println("size: " + this.f6287q.getWidth() + ", " + this.f6287q.getHeight());
            float f2 = 0.0f;
            if (zoom > 1.0f) {
                f = this.f6287q.getCurrentYOffset();
                f2 = this.f6287q.getCurrentXOffset();
                PrintStream printStream6 = System.out;
                printStream6.println("offsetX: " + f2);
                PrintStream printStream7 = System.out;
                printStream7.println("offsetY: " + f);
                if (f6270x > 0) {
                    f += this.f6284n * zoom * ((float) f6270x);
                    PrintStream printStream8 = System.out;
                    printStream8.println("offsetX: " + f2);
                    PrintStream printStream9 = System.out;
                    printStream9.println("offsetY: " + f);
                }
                height *= zoom;
                width *= zoom;
                PrintStream printStream10 = System.out;
                printStream10.println("offsetX0: " + width);
                PrintStream printStream11 = System.out;
                printStream11.println("offsetY0: " + height);
            } else {
                f = 0.0f;
            }
            int width2 = this.f6276f.getWidth() - this.f6277g.getWidth();
            float left = (((float) this.f6276f.getLeft()) - width) - f2;
            int top = (int) (((((float) this.f6276f.getTop()) - height) - f) + ((float) this.f6277g.getTop()));
            float width3 = (((float) (this.f6276f.getWidth() - width2)) / d.mo24006a()) / zoom;
            float height2 = (((float) (this.f6276f.getHeight() - width2)) / d.mo24007b()) / zoom;
            float left2 = ((float) ((int) ((left + ((float) this.f6277g.getLeft())) - ((float) this.f6272b.getLeft())))) / d.mo24006a();
            float b = ((float) top) / d.mo24007b();
            PrintStream printStream12 = System.out;
            printStream12.println("x0:" + left2 + " y0: " + b);
            float f3 = left2 / zoom;
            float f4 = b / zoom;
            PrintStream printStream13 = System.out;
            printStream13.println("x0:" + f3 + " y0: " + f4);
            int h = (int) (width3 * a.mo8248g().mo7952h());
            int i = (int) (height2 * a.mo8248g().mo7953i());
            int h2 = (int) (f3 * a.mo8248g().mo7952h());
            int i2 = ((int) (a.mo8248g().mo7953i() - (f4 * a.mo8248g().mo7953i()))) - i;
            PrintStream printStream14 = System.out;
            printStream14.println("x: " + h2 + " y: " + i2);
            fVar.mo8322a(a2, (float) h2, (float) i2, (float) h, (float) i);
            fVar.close();
            File file = new File(getFilesDir(), this.f6286p);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.f6285o.mo8061a((OutputStream) fileOutputStream);
            fileOutputStream.close();
            this.f6291u = Uri.fromFile(file);
            getIntent().setData(this.f6291u);
            this.f6287q.post(new Runnable(file) {
                private final /* synthetic */ File f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PDFNativeViewerActivity.this.m8090a(this.f$1);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m8100f() {
        PDFView pDFView = this.f6287q;
        pDFView.mo8961a(pDFView.getPageCount() - 1);
        this.f6284n = Math.abs(this.f6287q.getCurrentYOffset() / ((float) (this.f6287q.getPageCount() - 1)));
        PrintStream printStream = System.out;
        printStream.println("deltaOffsetY:" + this.f6284n);
        this.f6287q.mo8961a(f6270x);
        this.f6287q.setVisibility(0);
    }

    /* renamed from: a */
    public void mo8584a(float f) {
        Log.d("PDFNativeViewerActivity", "zoom " + f);
        if (this.f6276f.getVisibility() == 0) {
            this.f6276f.setScaleX(f);
            this.f6276f.setScaleY(f);
        }
    }

    /* renamed from: a */
    public void mo8585a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo8586a(int i, Throwable th) {
        Log.e("PDFNativeViewerActivity", "Cannot load page " + i);
    }

    /* renamed from: a_ */
    public void mo8587a_(int i) {
        this.f6287q.post(new Runnable() {
            public final void run() {
                PDFNativeViewerActivity.this.m8100f();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i, intent);
        finish();
    }

    public void onBackPressed() {
        if (this.f6273c.getVisibility() == 0) {
            this.f6273c.setVisibility(8);
            this.f6278h.setText("");
            findViewById(R.id.buttonWriteLayout).setEnabled(true);
            findViewById(R.id.buttonWrite).setEnabled(true);
            findViewById(R.id.buttonSignLayout).setEnabled(true);
            findViewById(R.id.buttonSign).setEnabled(true);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f6278h.getWindowToken(), 0);
            return;
        }
        try {
            if (this.f6285o != null) {
                this.f6285o.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
            setResult(0);
        }
        super.onBackPressed();
    }

    public void onCancelPlaceholder(View view) {
        findViewById(R.id.buttonSignLayout).setEnabled(true);
        findViewById(R.id.buttonSign).setEnabled(true);
        findViewById(R.id.buttonWriteLayout).setEnabled(true);
        findViewById(R.id.buttonWrite).setEnabled(true);
        this.f6280j.setVisibility(8);
        this.f6279i.setVisibility(8);
        this.f6281k.setVisibility(8);
        this.f6276f.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pdfnativeviewer);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f6271a = displayMetrics.xdpi;
        this.f6292v = (AVLoadingIndicatorView) findViewById(R.id.avi);
        this.f6293w = (RelativeLayout) findViewById(R.id.aviView);
        this.f6272b = (RelativeLayout) findViewById(R.id.readLayout);
        this.f6287q = (PDFView) this.f6272b.findViewById(R.id.pdfView);
        this.f6274d = (TextView) findViewById(R.id.fileNameTextView);
        this.f6273c = (RelativeLayout) findViewById(R.id.textLayout);
        this.f6294y = new C1422a(this);
        this.f6294y.mo6887a((C1422a.C1423a) new C1422a.C1423a() {
            /* renamed from: a */
            public void mo6888a(int i) {
                PrintStream printStream = System.out;
                printStream.println("onHeightChanged " + i);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PDFNativeViewerActivity.this.f6273c.getLayoutParams();
                layoutParams.bottomMargin = i;
                PDFNativeViewerActivity.this.f6273c.setLayoutParams(layoutParams);
            }
        });
        this.f6278h = (EditText) findViewById(R.id.editText);
        this.f6276f = findViewById(R.id.signaturePlaceholder);
        this.f6277g = (ImageView) findViewById(R.id.signatureIcon);
        this.f6280j = (ImageView) findViewById(R.id.setSignatureButton);
        this.f6279i = (ImageView) findViewById(R.id.cancelSignatureButton);
        this.f6281k = (ImageView) findViewById(R.id.expandSignatureButton);
        int integer = getResources().getInteger(R.integer.icon_size_button);
        Drawable drawable = getResources().getDrawable(R.drawable.pdf_file);
        drawable.setBounds(0, 0, integer, integer);
        this.f6274d.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        ((ButtonRichDrawable) findViewById(R.id.buttonShare)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.m8087a();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonShareLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.m8087a();
            }
        });
        ((ButtonRichDrawable) findViewById(R.id.buttonSign)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.m8093c();
            }
        });
        ((ButtonRichDrawable) findViewById(R.id.buttonWrite)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.m8091b();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonWriteLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.m8091b();
            }
        });
        ((ImageButton) findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (PDFNativeViewerActivity.this.f6285o != null) {
                        PDFNativeViewerActivity.this.f6285o.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (PDFNativeViewerActivity.this.getIntent().getBooleanExtra("signNow", false)) {
                    PDFNativeViewerActivity.this.onBackPressed();
                    return;
                }
                Intent intent = new Intent(PDFNativeViewerActivity.this.getApplicationContext(), DigitalSignatureActivity.class);
                intent.setFlags(32768);
                PDFNativeViewerActivity.this.startActivity(intent);
            }
        });
        ((LinearLayout) findViewById(R.id.buttonCancelLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (PDFNativeViewerActivity.this.f6285o != null) {
                        PDFNativeViewerActivity.this.f6285o.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (PDFNativeViewerActivity.this.getIntent().getBooleanExtra("signNow", false)) {
                    PDFNativeViewerActivity.this.onBackPressed();
                    return;
                }
                Intent intent = new Intent(PDFNativeViewerActivity.this.getApplicationContext(), DigitalSignatureActivity.class);
                intent.setFlags(32768);
                PDFNativeViewerActivity.this.startActivity(intent);
            }
        });
        ((Button) findViewById(R.id.buttonSignature)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (PDFNativeViewerActivity.this.f6285o != null) {
                        PDFNativeViewerActivity.this.f6285o.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String b = C2125f.m8367b(PDFNativeViewerActivity.this.f6286p);
                Intent intent = new Intent(PDFNativeViewerActivity.this, VerifyActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", PDFNativeViewerActivity.this.f6291u);
                PDFNativeViewerActivity pDFNativeViewerActivity = PDFNativeViewerActivity.this;
                intent.putExtra("filename", C2125f.m8366b(pDFNativeViewerActivity, pDFNativeViewerActivity.f6291u, b));
                PDFNativeViewerActivity.this.startActivity(intent);
            }
        });
        this.f6287q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PDFNativeViewerActivity.this.findViewById(R.id.appBarLayout).setVisibility(8);
                PDFNativeViewerActivity.this.findViewById(R.id.signatureInfoView).setVisibility(8);
            }
        });
        this.f6290t = getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f6294y.mo6886a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f6294y.mo6886a();
        m8088a(getIntent());
    }

    public void onSetPlaceholder(View view) {
        findViewById(R.id.buttonSignLayout).setEnabled(true);
        findViewById(R.id.buttonSign).setEnabled(true);
        findViewById(R.id.buttonWriteLayout).setEnabled(true);
        findViewById(R.id.buttonWrite).setEnabled(true);
        this.f6280j.setVisibility(8);
        this.f6279i.setVisibility(8);
        this.f6281k.setVisibility(8);
        this.f6276f.setVisibility(8);
        f6270x = this.f6287q.getCurrentPage();
        this.f6293w.setVisibility(0);
        this.f6292v.show();
        C2140d.m8401a(new Runnable() {
            public final void run() {
                PDFNativeViewerActivity.this.m8098e();
            }
        });
    }

    public void onTextCancel(View view) {
        this.f6278h.setText("");
        this.f6273c.setVisibility(8);
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f6278h.getWindowToken(), 0);
        findViewById(R.id.buttonWriteLayout).setEnabled(true);
        findViewById(R.id.buttonWrite).setEnabled(true);
        findViewById(R.id.buttonSignLayout).setEnabled(true);
        findViewById(R.id.buttonSign).setEnabled(true);
    }

    public void onTextClear(View view) {
        this.f6278h.setText("");
    }

    public void onTextOK(View view) {
        findViewById(R.id.buttonWriteLayout).setEnabled(true);
        findViewById(R.id.buttonWrite).setEnabled(true);
        findViewById(R.id.buttonSignLayout).setEnabled(true);
        findViewById(R.id.buttonSign).setEnabled(true);
        String obj = this.f6278h.getText().toString();
        if (!obj.isEmpty()) {
            Paint paint = new Paint();
            paint.setColor(-16777216);
            paint.setTypeface(Typeface.DEFAULT);
            paint.setTextSize(150.0f);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            Rect rect = new Rect();
            paint.getTextBounds(obj, 0, obj.length(), rect);
            int height = rect.height();
            this.f6275e = Bitmap.createBitmap((int) (((double) ((float) rect.width())) * 1.5d), this.f6273c.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f6275e).drawText(obj, 10.0f, (float) ((this.f6275e.getHeight() + height) / 2), paint);
            this.f6277g.setImageBitmap(this.f6275e);
            ViewGroup.LayoutParams layoutParams = this.f6277g.getLayoutParams();
            layoutParams.height = this.f6275e.getHeight() / 2;
            layoutParams.width = this.f6275e.getWidth() / 2;
            this.f6277g.setLayoutParams(layoutParams);
            this.f6276f.setVisibility(0);
            this.f6280j.setVisibility(0);
            this.f6279i.setVisibility(0);
            this.f6281k.setVisibility(0);
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i2);
            layoutParams2.leftMargin = (this.f6272b.getWidth() - i) / 2;
            layoutParams2.topMargin = (this.f6272b.getHeight() - i2) / 2;
            layoutParams2.height = i2;
            layoutParams2.width = i;
            this.f6276f.setLayoutParams(layoutParams2);
            this.f6276f.setOnTouchListener(this);
            this.f6281k.setOnTouchListener(this);
            this.f6278h.setText("");
        }
        this.f6273c.setVisibility(8);
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f6278h.getWindowToken(), 0);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        View view2;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (view == this.f6276f) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    this.f6288r = rawX - layoutParams.leftMargin;
                    this.f6289s = rawY - layoutParams.topMargin;
                    break;
                case 2:
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams2.leftMargin = rawX - this.f6288r;
                    layoutParams2.topMargin = rawY - this.f6289s;
                    view.setLayoutParams(layoutParams2);
                    PrintStream printStream = System.out;
                    printStream.println("left:" + layoutParams2.leftMargin + " top: " + layoutParams2.topMargin);
                    PrintStream printStream2 = System.out;
                    printStream2.println("right:" + layoutParams2.rightMargin + " bottom: " + layoutParams2.bottomMargin);
                    if (!m8096d()) {
                        System.out.println("bad");
                        view2 = this.f6276f;
                        i = R.drawable.signature_border_red;
                    } else {
                        System.out.println("good");
                        view2 = this.f6276f;
                        i = R.drawable.signature_border;
                    }
                    view2.setBackgroundResource(i);
                    break;
            }
        } else if ((motionEvent.getAction() & 255) == 2) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f6276f.getLayoutParams();
            int i2 = rawX - layoutParams3.leftMargin;
            int i3 = (int) (((float) i2) / ((float) (layoutParams3.width / layoutParams3.height)));
            int integer = (int) (((float) getResources().getInteger(R.integer.stamp_min_size)) * this.f6290t);
            if (i2 > integer && i3 >= integer) {
                layoutParams3.width = i2;
                layoutParams3.height = i3;
                this.f6276f.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f6277g.getLayoutParams();
                layoutParams4.width = i2;
                layoutParams4.height = i3;
                this.f6277g.setLayoutParams(layoutParams4);
            }
        }
        return true;
    }
}
