package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.cyberneid.disigon.C2098c;
import com.cyberneid.disigon.PDFSignerNativeViewerActivity;
import com.cyberneid.disigon.p133a.C2069a;
import com.cyberneid.disigon.p133a.C2070b;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1451a;
import com.cyberneid.p087a.C1454c;
import com.cyberneid.p087a.C1458g;
import com.cyberneid.p087a.C1462k;
import com.cyberneid.p087a.C1468p;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p118b.C1766a;
import com.cyberneid.p105d.p114g.p120d.C1830z;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.p142c.C2164d;
import com.github.barteksc.pdfviewer.p142c.C2166f;
import com.github.barteksc.pdfviewer.p142c.C2167g;
import com.github.barteksc.pdfviewer.p142c.C2169i;
import com.github.barteksc.pdfviewer.p144e.C2180a;
import com.github.barteksc.pdfviewer.p144e.C2182b;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p137e.p139b.C2139c;
import com.p137e.p139b.C2140d;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shockwave.pdfium.util.SizeF;
import com.wang.avi.AVLoadingIndicatorView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.IETFUtils;
import org.spongycastle.cert.X509CertificateHolder;

public class PDFSignerNativeViewerActivity extends C2098c implements View.OnTouchListener, C2164d, C2166f, C2167g, C2169i {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static int f6321A;

    /* renamed from: B */
    private C2069a f6322B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f6323C;

    /* renamed from: D */
    private boolean f6324D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public String f6325E;

    /* renamed from: F */
    private C2068a f6326F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public AVLoadingIndicatorView f6327G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public RelativeLayout f6328H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f6329I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f6330J;

    /* renamed from: K */
    private float f6331K;

    /* renamed from: L */
    private boolean f6332L = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RelativeLayout f6333h;

    /* renamed from: i */
    private TextView f6334i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f6335j;

    /* renamed from: k */
    private ImageView f6336k;

    /* renamed from: l */
    private RelativeLayout f6337l;

    /* renamed from: m */
    private SignaturePad f6338m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Bitmap f6339n;

    /* renamed from: o */
    private ImageView f6340o;

    /* renamed from: p */
    private ImageView f6341p;

    /* renamed from: q */
    private ImageView f6342q;

    /* renamed from: r */
    private ImageView f6343r;

    /* renamed from: s */
    private int f6344s;

    /* renamed from: t */
    private int f6345t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ParcelFileDescriptor f6346u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f6347v = 0;

    /* renamed from: w */
    private float f6348w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public PDFView f6349x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C1783c f6350y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Uri f6351z;

    /* renamed from: com.cyberneid.disigon.PDFSignerNativeViewerActivity$a */
    private class C2030a implements View.OnClickListener {
        private C2030a() {
        }

        public void onClick(View view) {
            if (PDFSignerNativeViewerActivity.this.f6350y != null) {
                C1766a j = PDFSignerNativeViewerActivity.this.f6350y.mo8072j();
                if (PDFSignerNativeViewerActivity.this.f6350y.mo8064c() || (j != null && (!j.mo7968d() || j.mo7978j()))) {
                    PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                    C2081e.m8300a((Context) pDFSignerNativeViewerActivity, pDFSignerNativeViewerActivity.getResources().getString(R.string.app_name), "Il PDF è protetto da una policy definita dall'autore e pertanto non può essere firmato.", (C2081e.C2094c) new C2081e.C2094c() {
                        /* renamed from: a */
                        public void mo8543a() {
                        }
                    });
                    return;
                }
                PDFSignerNativeViewerActivity.this.mo8720c();
            }
        }
    }

    /* renamed from: a */
    private void m8132a(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        this.f6351z = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        this.f6324D = intent.getBooleanExtra("isFirstSignature", false);
        this.f6325E = intent.getStringExtra("filename");
        if (this.f6351z == null) {
            this.f6351z = intent.getData();
        }
        Uri uri = this.f6351z;
        if (uri == null) {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            instance.log("action " + action);
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.log("type " + type);
            FirebaseCrashlytics instance3 = FirebaseCrashlytics.getInstance();
            instance3.log("filename " + this.f6325E);
            FirebaseCrashlytics.getInstance().log(intent.toString());
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("pdfUri is null"));
            return;
        }
        setTitle(uri.getLastPathSegment());
        ((TextView) findViewById(R.id.fileNameTextView)).setText(this.f6325E);
        m8134a(this.f6351z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8142b(Bitmap bitmap) {
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        int width2 = this.f6333h.getWidth() / 7;
        int i = (int) (((float) width2) / width);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6335j.getLayoutParams();
        layoutParams.leftMargin = (this.f6333h.getWidth() - width2) / 2;
        layoutParams.topMargin = (this.f6333h.getHeight() - i) / 2;
        layoutParams.height = i;
        layoutParams.width = width2;
        this.f6335j.setLayoutParams(layoutParams);
        this.f6335j.setOnTouchListener(this);
        this.f6342q.setOnTouchListener(this);
        this.f6338m.mo9195b();
        this.f6337l.setVisibility(8);
        this.f6329I = 0;
        this.f6330J = 0;
        this.f6336k.setImageBitmap(bitmap);
        this.f6335j.setVisibility(0);
        this.f6341p.setVisibility(0);
        this.f6343r.setVisibility(0);
        this.f6340o.setVisibility(0);
        this.f6342q.setVisibility(0);
    }

    /* renamed from: a */
    private void m8134a(final Uri uri) {
        this.f6328H.setVisibility(0);
        this.f6327G.show();
        this.f6335j.setVisibility(8);
        C2140d.m8401a(new Runnable() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8170a() {
                PDFSignerNativeViewerActivity.this.f6327G.hide();
                PDFSignerNativeViewerActivity.this.f6328H.setVisibility(4);
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8171a(final Exception exc) {
                try {
                    if (PDFSignerNativeViewerActivity.this.f6350y != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        PDFSignerNativeViewerActivity.this.f6350y.mo8061a((OutputStream) byteArrayOutputStream);
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
            public /* synthetic */ void m8172a(byte[] bArr) {
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
            public /* synthetic */ void m8173a(byte[] bArr, byte[] bArr2) {
                try {
                    new FileInputStream(PDFSignerNativeViewerActivity.this.f6346u.getFileDescriptor());
                    PDFSignerNativeViewerActivity.this.f6349x.mo8953a(bArr).mo9024a(PDFSignerNativeViewerActivity.f6321A).mo9026a((C2166f) PDFSignerNativeViewerActivity.this).mo9030a(true).mo9025a((C2164d) PDFSignerNativeViewerActivity.this).mo9029a((C2182b) new C2180a(PDFSignerNativeViewerActivity.this)).mo9032b(10).mo9027a((C2167g) PDFSignerNativeViewerActivity.this).mo9028a((C2169i) PDFSignerNativeViewerActivity.this).mo9034c(true).mo9033b(true).mo9035d(true).mo9031a();
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    C2140d.m8401a(new Runnable(bArr2) {
                        private final /* synthetic */ byte[] f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            PDFSignerNativeViewerActivity.C20226.this.m8172a(this.f$1);
                        }
                    });
                }
                PDFSignerNativeViewerActivity.this.f6327G.hide();
                PDFSignerNativeViewerActivity.this.f6328H.setVisibility(4);
                PDFSignerNativeViewerActivity.this.f6333h.setVisibility(0);
            }

            public void run() {
                try {
                    ParcelFileDescriptor unused = PDFSignerNativeViewerActivity.this.f6346u = PDFSignerNativeViewerActivity.this.getContentResolver().openFileDescriptor(uri, "r");
                    FileInputStream fileInputStream = new FileInputStream(PDFSignerNativeViewerActivity.this.f6346u.getFileDescriptor());
                    byte[] a = C2139c.m8400a(fileInputStream);
                    fileInputStream.close();
                    C1783c unused2 = PDFSignerNativeViewerActivity.this.f6350y = C1783c.m7200a(a);
                    int unused3 = PDFSignerNativeViewerActivity.this.f6347v = PDFSignerNativeViewerActivity.this.f6350y.mo8071i();
                    int unused4 = PDFSignerNativeViewerActivity.f6321A = PDFSignerNativeViewerActivity.this.getIntent().getIntExtra("currentPage", 0);
                    PDFSignerNativeViewerActivity.this.f6349x.post(new Runnable(a, a) {
                        private final /* synthetic */ byte[] f$1;
                        private final /* synthetic */ byte[] f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            PDFSignerNativeViewerActivity.C20226.this.m8173a(this.f$1, this.f$2);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    C2140d.m8401a(new Runnable(e) {
                        private final /* synthetic */ Exception f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            PDFSignerNativeViewerActivity.C20226.this.m8171a(this.f$1);
                        }
                    });
                    PDFSignerNativeViewerActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            PDFSignerNativeViewerActivity.C20226.this.m8170a();
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8136a(final byte[] bArr, final File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            if (this.f6350y != null) {
                this.f6350y.close();
            }
            Log.d("o", "file saved, open preview");
            if (!C2078b.m8280a("DIKE_MESSAGE", false)) {
                C2081e.m8299a(this, "Avviso", getResources().getString(R.string.dike_message), R.layout.dialog_dike_message, new C2081e.C2093b() {
                    /* renamed from: a */
                    public void mo8552a(boolean z) {
                        if (z) {
                            C2078b.m8282b("DIKE_MESSAGE", true);
                        }
                        PDFSignerNativeViewerActivity.this.m8145b(bArr, file);
                    }
                });
            } else {
                m8145b(bArr, file);
            }
        } catch (Exception e) {
            Log.d("o", "IOException: file not saved");
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public byte[] m8138a(String str) {
        byte[] bArr;
        C1830z zVar;
        float f;
        float f2;
        float f3;
        float f4;
        String str2;
        float f5;
        this.f6322B = C2070b.m8242a().mo8680a(this.f6529c);
        try {
            if (this.f6322B.mo8674a(0) == 0) {
                Log.d("o", "open session succeded");
                int a = this.f6322B.mo8675a(str);
                if (a == 0) {
                    Log.d("o", "login succeded");
                    C1462k kVar = new C1462k(this.f6350y);
                    f6321A = this.f6349x.getCurrentPage();
                    this.f6350y.mo8054a(f6321A);
                    float f6 = 0.0f;
                    if (this.f6335j.getVisibility() == 0) {
                        C2127h.m8376a("pdf-stamp");
                        SizeF d = this.f6349x.mo8982d(f6321A);
                        float zoom = this.f6349x.getZoom();
                        float height = (((float) this.f6349x.getHeight()) - d.mo24007b()) / 2.0f;
                        float width = (((float) this.f6349x.getWidth()) - d.mo24006a()) / 2.0f;
                        int i = (zoom > 1.0f ? 1 : (zoom == 1.0f ? 0 : -1));
                        if (i > 0) {
                            float currentYOffset = this.f6349x.getCurrentYOffset();
                            float currentXOffset = this.f6349x.getCurrentXOffset();
                            if (f6321A > 0) {
                                currentYOffset += this.f6348w * zoom * ((float) f6321A);
                            }
                            height *= zoom;
                            width *= zoom;
                            float f7 = currentXOffset;
                            f5 = currentYOffset;
                            f6 = f7;
                        } else {
                            f5 = 0.0f;
                        }
                        float left = (float) this.f6336k.getLeft();
                        float top = (float) this.f6336k.getTop();
                        int width2 = this.f6335j.getWidth() - this.f6336k.getWidth();
                        if (i > 0) {
                            left = (-left) * zoom;
                            top = (-top) * zoom;
                        }
                        int left2 = (int) ((((((float) this.f6335j.getLeft()) - width) - f6) + left) - ((float) this.f6333h.getLeft()));
                        int top2 = (int) (((((float) this.f6335j.getTop()) - height) - f5) + top);
                        float width3 = ((float) (this.f6335j.getWidth() - width2)) / d.mo24006a();
                        float height2 = ((float) (this.f6335j.getHeight() - width2)) / d.mo24007b();
                        float a2 = (((float) left2) / d.mo24006a()) / zoom;
                        float b = (((float) top2) / d.mo24007b()) / zoom;
                        C1830z zVar2 = C1830z.f5929j;
                        Bitmap bitmap = this.f6339n;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        zVar = zVar2;
                        bArr = byteArrayOutputStream.toByteArray();
                        f = height2;
                        f2 = width3;
                        f3 = b;
                        f4 = a2;
                    } else {
                        C2127h.m8376a("pdf");
                        zVar = null;
                        bArr = null;
                        f4 = 0.0f;
                        f3 = 0.0f;
                        f2 = 0.0f;
                        f = 0.0f;
                    }
                    X509CertificateHolder b2 = this.f6322B.mo8678b((C1454c) null);
                    X500Name subject = b2.getSubject();
                    RDN rdn = subject.getRDNs(BCStyle.GIVENNAME)[0];
                    RDN rdn2 = subject.getRDNs(BCStyle.SURNAME)[0];
                    String valueToString = IETFUtils.valueToString(rdn.getFirst().getValue());
                    String valueToString2 = IETFUtils.valueToString(rdn2.getFirst().getValue());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    int i2 = f6321A;
                    String format = simpleDateFormat.format(new Date());
                    if (this.f6332L) {
                        str2 = null;
                    } else {
                        str2 = valueToString + " " + valueToString2;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Firmo con CIE-");
                    X509CertificateHolder x509CertificateHolder = b2;
                    sb.append(System.currentTimeMillis());
                    kVar.mo6929a(i2, f4, f3, f2, f, zVar, format, (String) null, str2, (String) null, sb.toString(), "ETSI.CAdES.detached", bArr);
                    byte[] a3 = kVar.mo6930a(this.f6322B, (C1454c) null, true, false, (C1468p) null);
                    this.f6322B.mo8679b();
                    this.f6322B.mo8676a();
                    Log.d("o", "close session succeded");
                    File file = new File(getFilesDir(), x509CertificateHolder.getSerialNumber().toString() + ".cer");
                    if (!file.exists()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(x509CertificateHolder.getEncoded());
                        fileOutputStream.close();
                    }
                    return a3;
                }
                Log.d("o", "error: " + a);
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("Error: " + a));
                this.f6323C = a;
                return null;
            }
            Log.d("o", "open session failed");
            this.f6322B.mo8676a();
            this.f6323C = 301;
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("STATUS_OPEN_SESSION_FAILED: " + this.f6323C));
            return null;
        } catch (C1458g e) {
            this.f6322B.mo8676a();
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().log(e.toString());
            FirebaseCrashlytics.getInstance().recordException(e);
            throw e;
        } catch (Exception e2) {
            this.f6322B.mo8676a();
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().log(e2.toString());
            FirebaseCrashlytics.getInstance().recordException(e2);
            throw new C1458g(-2130706261);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8145b(byte[] bArr, File file) {
        try {
            this.f6326F.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_NEW_SIGNATURE), getResources().getString(R.string.FRBS_PDF_DOCUMENT), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
            if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
                setResult(-1, intent);
            } else {
                Intent intent2 = new Intent(this, PDFNativeViewerActivity.class);
                intent2.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
                intent2.setAction("android.intent.action.SEND");
                intent2.setType("application/pdf");
                intent2.putExtra("filename", file.getName());
                intent2.putExtra("currentPage", f6321A);
                startActivity(intent2);
            }
            finish();
        } catch (Exception e) {
            Log.d("o", "IOException: file not saved");
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public byte[] m8147b(String str) {
        this.f6322B = C2070b.m8242a().mo8680a(this.f6529c);
        try {
            if (this.f6322B.mo8674a(0) == 0) {
                Log.d("o", "open session succeded");
                int a = this.f6322B.mo8675a(str);
                if (a == 0) {
                    Log.d("o", "login succeded");
                    this.f6346u = getContentResolver().openFileDescriptor(this.f6351z, "r");
                    FileInputStream fileInputStream = new FileInputStream(this.f6346u.getFileDescriptor());
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    X509CertificateHolder b = this.f6322B.mo8678b((C1454c) null);
                    C1451a a2 = this.f6322B.mo6924a(bArr, (C1454c) null, true, false, false);
                    this.f6322B.mo8679b();
                    this.f6322B.mo8676a();
                    C2127h.m8376a("p7m");
                    byte[] d = a2.mo6915d();
                    File filesDir = getFilesDir();
                    File file = new File(filesDir, b.getSerialNumber().toString() + ".cer");
                    if (!file.exists()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(b.getEncoded());
                        fileOutputStream.close();
                    }
                    return d;
                }
                Log.d("o", "error: " + a);
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                instance.recordException(new RuntimeException("Error: " + a));
                this.f6323C = a;
                return null;
            }
            Log.d("o", "open session failed");
            this.f6323C = 301;
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.recordException(new RuntimeException("STATUS_OPEN_SESSION_FAILED: " + this.f6323C));
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().log(e.toString());
            FirebaseCrashlytics.getInstance().recordException(e);
            this.f6322B.mo8676a();
            throw new C1458g(-2130706261);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public File m8154e() {
        String str = this.f6325E;
        if (getIntent().getStringExtra("signatureType").equals("p7m")) {
            if (!C2125f.m8369c(this.f6325E).equals("p7m")) {
                str = this.f6325E + ".p7m";
            } else {
                str = this.f6325E;
            }
        }
        return C2125f.m8360a(str);
    }

    /* renamed from: f */
    private boolean m8156f() {
        float f;
        float zoom = this.f6349x.getZoom();
        int currentPage = this.f6349x.getCurrentPage();
        SizeF d = this.f6349x.mo8982d(currentPage);
        float height = (((float) this.f6349x.getHeight()) - d.mo24007b()) / 2.0f;
        float width = (((float) this.f6349x.getWidth()) - d.mo24006a()) / 2.0f;
        float f2 = 0.0f;
        if (zoom > 1.0f) {
            float currentYOffset = this.f6349x.getCurrentYOffset();
            float currentXOffset = this.f6349x.getCurrentXOffset();
            if (currentPage > 0) {
                currentYOffset += this.f6348w * zoom * ((float) currentPage);
            }
            height *= zoom;
            width *= zoom;
            f = currentYOffset;
            f2 = currentXOffset;
        } else {
            f = 0.0f;
        }
        int left = (int) ((((((float) this.f6335j.getLeft()) - width) - f2) + ((float) this.f6336k.getLeft())) - ((float) this.f6333h.getLeft()));
        int top = (int) (((((float) this.f6335j.getTop()) - height) - f) + ((float) this.f6336k.getTop()));
        return left >= 0 && ((float) (this.f6335j.getWidth() + left)) <= d.mo24006a() && top >= 0 && ((float) (this.f6335j.getHeight() + top)) <= d.mo24007b();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m8158g() {
        PDFView pDFView = this.f6349x;
        pDFView.mo8961a(pDFView.getPageCount() - 1);
        this.f6348w = Math.abs(this.f6349x.getCurrentYOffset() / ((float) (this.f6349x.getPageCount() - 1)));
        this.f6349x.mo8961a(f6321A);
        this.f6349x.setVisibility(0);
    }

    /* renamed from: a */
    public void mo8584a(float f) {
        Log.d("o", "zoom " + f);
        if (this.f6335j.getVisibility() == 0) {
            if (this.f6329I == 0) {
                this.f6329I = this.f6335j.getWidth();
                this.f6330J = this.f6335j.getHeight();
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6335j.getLayoutParams();
            int i = (int) (((float) this.f6329I) * f);
            int i2 = (int) (((float) this.f6330J) * f);
            layoutParams.width = i;
            layoutParams.height = i2;
            this.f6335j.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f6336k.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            this.f6336k.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    public void mo8585a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo8586a(int i, Throwable th) {
        Log.e("o", "Cannot load page " + i);
    }

    /* renamed from: a_ */
    public void mo8587a_(int i) {
        this.f6349x.post(new Runnable() {
            public final void run() {
                PDFSignerNativeViewerActivity.this.m8158g();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8520b() {
        this.f6532f = new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: private */

            /* renamed from: b */
            public boolean f6367b;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public byte[] f6368c;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public File f6369d;

            /* renamed from: e */
            private AlertDialog f6370e;

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                try {
                    Log.d("o", "starting signature");
                    this.f6368c = PDFSignerNativeViewerActivity.this.getIntent().getStringExtra("signatureType").equals("pdf") ? PDFSignerNativeViewerActivity.this.m8138a(PDFSignerNativeViewerActivity.this.f6530d) : PDFSignerNativeViewerActivity.this.m8147b(PDFSignerNativeViewerActivity.this.f6530d);
                    if (this.f6368c != null) {
                        Log.d("o", "signature succeded");
                        this.f6369d = PDFSignerNativeViewerActivity.this.m8154e();
                        if (this.f6369d.exists()) {
                            this.f6367b = true;
                            return null;
                        }
                        this.f6367b = false;
                        return null;
                    }
                    Log.d("o", "signature failed");
                    return null;
                } catch (C1458g e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    int unused = PDFSignerNativeViewerActivity.this.f6323C = (int) e.mo6921a();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    int unused2 = PDFSignerNativeViewerActivity.this.f6323C = 300;
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(Void voidR) {
                PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity;
                C2081e.C2094c cVar;
                String str;
                String str2;
                super.onPostExecute(voidR);
                this.f6370e.dismiss();
                int l = PDFSignerNativeViewerActivity.this.f6323C;
                if (l != 0) {
                    switch (l) {
                        case 300:
                            pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                            str2 = pDFSignerNativeViewerActivity.getResources().getString(R.string.app_name);
                            str = PDFSignerNativeViewerActivity.this.getResources().getString(R.string.generic_error);
                            cVar = new C2081e.C2094c() {
                                /* renamed from: a */
                                public void mo8543a() {
                                }
                            };
                            break;
                        case 301:
                            pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                            str2 = pDFSignerNativeViewerActivity.getResources().getString(R.string.app_name);
                            str = PDFSignerNativeViewerActivity.this.getResources().getString(R.string.no_device_found);
                            cVar = new C2081e.C2094c() {
                                /* renamed from: a */
                                public void mo8543a() {
                                }
                            };
                            break;
                        default:
                            PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity2 = PDFSignerNativeViewerActivity.this;
                            pDFSignerNativeViewerActivity2.mo8718a(pDFSignerNativeViewerActivity2.f6323C);
                            return;
                    }
                    C2081e.m8300a((Context) pDFSignerNativeViewerActivity, str2, str, cVar);
                    return;
                }
                PDFSignerNativeViewerActivity.this.mo8719a((C2098c.C2116a) new C2098c.C2116a() {
                    /* renamed from: a */
                    public void mo8529a() {
                        if (C20257.this.f6367b) {
                            C2081e.m8301a((Context) PDFSignerNativeViewerActivity.this, PDFSignerNativeViewerActivity.this.getResources().getString(R.string.overwrite_file_title), PDFSignerNativeViewerActivity.this.getResources().getString(R.string.overwrite_file), (C2081e.C2096e) new C2081e.C2096e() {
                                /* renamed from: a */
                                public void mo8558a() {
                                    PDFSignerNativeViewerActivity.this.m8136a(C20257.this.f6368c, C20257.this.f6369d);
                                }

                                /* renamed from: b */
                                public void mo8559b() {
                                    if ("android.intent.action.SIGN_AND_RETURN".equals(PDFSignerNativeViewerActivity.this.getIntent().getAction())) {
                                        PDFSignerNativeViewerActivity.this.setResult(0);
                                    }
                                    PDFSignerNativeViewerActivity.this.finish();
                                }
                            });
                        } else {
                            PDFSignerNativeViewerActivity.this.m8136a(C20257.this.f6368c, C20257.this.f6369d);
                        }
                    }
                });
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                int unused = PDFSignerNativeViewerActivity.this.f6323C = 0;
                this.f6367b = false;
                PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                this.f6370e = C2081e.m8296a((Context) pDFSignerNativeViewerActivity, pDFSignerNativeViewerActivity.getResources().getString(R.string.please_wait), PDFSignerNativeViewerActivity.this.getResources().getString(R.string.wait_signing));
                this.f6370e.show();
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Log.d("o", "User cancelled file browsing {}");
        } else if (i == 3 && intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            System.out.println(data);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data));
                this.f6339n = decodeStream;
                this.f6335j.postDelayed(new Runnable(decodeStream) {
                    private final /* synthetic */ Bitmap f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        PDFSignerNativeViewerActivity.this.m8142b(this.f$1);
                    }
                }, 200);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        if (this.f6337l.getVisibility() == 0) {
            this.f6337l.setVisibility(8);
            return;
        }
        try {
            if (this.f6350y != null) {
                this.f6350y.close();
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
        this.f6343r.setVisibility(8);
        this.f6341p.setVisibility(8);
        this.f6340o.setVisibility(8);
        this.f6342q.setVisibility(8);
        this.f6335j.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pdfsignernativeviewer);
        this.f6326F = new C2068a(this);
        this.f6333h = (RelativeLayout) findViewById(R.id.readLayout);
        this.f6337l = (RelativeLayout) findViewById(R.id.signatureLayout);
        this.f6338m = (SignaturePad) findViewById(R.id.signature_pad);
        this.f6349x = (PDFView) this.f6333h.findViewById(R.id.pdfView);
        this.f6334i = (TextView) findViewById(R.id.fileNameTextView);
        this.f6327G = (AVLoadingIndicatorView) findViewById(R.id.avi);
        this.f6328H = (RelativeLayout) findViewById(R.id.aviView);
        this.f6335j = findViewById(R.id.signaturePlaceholder);
        this.f6336k = (ImageView) findViewById(R.id.signatureIcon);
        this.f6341p = (ImageView) findViewById(R.id.useHandButton);
        this.f6340o = (ImageView) findViewById(R.id.cancelSignatureButton);
        this.f6342q = (ImageView) findViewById(R.id.expandSignatureButton);
        this.f6343r = (ImageView) findViewById(R.id.loadImageButton);
        Intent intent = getIntent();
        if (!"pdf".equals(intent.getStringExtra("signatureType")) || !intent.getBooleanExtra("stamp", true)) {
            this.f6335j.setVisibility(8);
        } else {
            this.f6335j.postDelayed(new Runnable() {
                public void run() {
                    PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                    Bitmap unused = pDFSignerNativeViewerActivity.f6339n = BitmapFactory.decodeResource(pDFSignerNativeViewerActivity.getResources(), R.drawable.disigon_cie_new_rounded_logo_semi);
                    PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity2 = PDFSignerNativeViewerActivity.this;
                    pDFSignerNativeViewerActivity2.m8142b(pDFSignerNativeViewerActivity2.f6339n);
                    PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity3 = PDFSignerNativeViewerActivity.this;
                    int unused2 = pDFSignerNativeViewerActivity3.f6329I = pDFSignerNativeViewerActivity3.f6335j.getWidth();
                    PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity4 = PDFSignerNativeViewerActivity.this;
                    int unused3 = pDFSignerNativeViewerActivity4.f6330J = pDFSignerNativeViewerActivity4.f6335j.getHeight();
                }
            }, 100);
        }
        int integer = getResources().getInteger(R.integer.icon_size_button);
        Drawable drawable = getResources().getDrawable(R.drawable.pdf_file);
        drawable.setBounds(0, 0, integer, integer);
        this.f6334i.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        C2030a aVar = new C2030a();
        ((Button) findViewById(R.id.buttonSign)).setOnClickListener(aVar);
        ((LinearLayout) findViewById(R.id.buttonSignLayout)).setOnClickListener(aVar);
        ((ImageButton) findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ("android.intent.action.SIGN_AND_RETURN".equals(PDFSignerNativeViewerActivity.this.getIntent().getAction())) {
                    PDFSignerNativeViewerActivity.this.setResult(0);
                }
                PDFSignerNativeViewerActivity.this.finish();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonCancelLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ("android.intent.action.SIGN_AND_RETURN".equals(PDFSignerNativeViewerActivity.this.getIntent().getAction())) {
                    PDFSignerNativeViewerActivity.this.setResult(0);
                }
                PDFSignerNativeViewerActivity.this.finish();
            }
        });
        ((Button) findViewById(R.id.buttonSignature)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (PDFSignerNativeViewerActivity.this.f6350y != null) {
                        PDFSignerNativeViewerActivity.this.f6350y.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String b = C2125f.m8367b(PDFSignerNativeViewerActivity.this.f6325E);
                Intent intent = new Intent(PDFSignerNativeViewerActivity.this, VerifyActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", PDFSignerNativeViewerActivity.this.f6351z);
                PDFSignerNativeViewerActivity pDFSignerNativeViewerActivity = PDFSignerNativeViewerActivity.this;
                intent.putExtra("filename", C2125f.m8366b(pDFSignerNativeViewerActivity, pDFSignerNativeViewerActivity.f6351z, b));
                PDFSignerNativeViewerActivity.this.startActivity(intent);
            }
        });
        this.f6331K = getResources().getDisplayMetrics().density;
    }

    public void onLoadImage(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(intent, 3);
    }

    public void onSignatureCancel(View view) {
        this.f6338m.mo9195b();
        this.f6337l.setVisibility(8);
        this.f6343r.setVisibility(0);
        this.f6341p.setVisibility(0);
        this.f6340o.setVisibility(0);
        this.f6342q.setVisibility(0);
        this.f6335j.setVisibility(0);
    }

    public void onSignatureClear(View view) {
        this.f6338m.mo9195b();
    }

    public void onSignatureOK(View view) {
        this.f6339n = this.f6338m.getTransparentSignatureBitmap();
        m8142b(this.f6339n);
        this.f6332L = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        m8132a(getIntent());
        super.onStart();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        View view2;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (view == this.f6335j) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    this.f6344s = rawX - layoutParams.leftMargin;
                    this.f6345t = rawY - layoutParams.topMargin;
                    break;
                case 2:
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams2.leftMargin = rawX - this.f6344s;
                    layoutParams2.topMargin = rawY - this.f6345t;
                    view.setLayoutParams(layoutParams2);
                    if (this.f6349x.getZoom() != 1.0f || m8156f()) {
                        view2 = this.f6335j;
                        i = R.drawable.signature_border;
                    } else {
                        view2 = this.f6335j;
                        i = R.drawable.signature_border_red;
                    }
                    view2.setBackgroundResource(i);
                    break;
            }
        } else if ((motionEvent.getAction() & 255) == 2) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f6335j.getLayoutParams();
            int i2 = rawX - layoutParams3.leftMargin;
            int i3 = (int) (((float) i2) / ((float) (layoutParams3.width / layoutParams3.height)));
            int integer = (int) (((float) getResources().getInteger(R.integer.stamp_min_size)) * this.f6331K);
            if (i2 > integer && i3 >= integer) {
                layoutParams3.width = i2;
                layoutParams3.height = i3;
                this.f6335j.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f6336k.getLayoutParams();
                layoutParams4.width = i2;
                layoutParams4.height = i3;
                this.f6336k.setLayoutParams(layoutParams4);
                this.f6329I = this.f6335j.getWidth();
                this.f6330J = this.f6335j.getHeight();
            }
        }
        return true;
    }

    public void onUseHand(View view) {
        this.f6337l.setVisibility(0);
        this.f6343r.setVisibility(8);
        this.f6341p.setVisibility(8);
        this.f6340o.setVisibility(8);
        this.f6342q.setVisibility(8);
        this.f6335j.setVisibility(8);
    }
}
