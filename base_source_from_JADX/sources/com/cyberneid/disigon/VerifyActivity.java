package com.cyberneid.disigon;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.C0094d;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1451a;
import com.cyberneid.p087a.C1458g;
import com.cyberneid.p087a.C1464l;
import com.cyberneid.p087a.C1467o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p137e.p139b.C2140d;
import com.wang.avi.AVLoadingIndicatorView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerifyActivity extends C0094d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Uri f6450a;

    /* renamed from: b */
    private ParcelFileDescriptor f6451b;

    /* renamed from: c */
    private TextView f6452c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f6453d = "";

    /* renamed from: e */
    private String f6454e = "";

    /* renamed from: f */
    private ProgressBar f6455f;

    /* renamed from: g */
    private String f6456g = "";

    /* renamed from: h */
    private C2068a f6457h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AVLoadingIndicatorView f6458i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public RelativeLayout f6459j;

    /* renamed from: com.cyberneid.disigon.VerifyActivity$a */
    private class C2064a implements View.OnClickListener {
        private C2064a() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(10:15|16|17|(1:19)|20|21|22|23|24|31) */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00e9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r7) {
            /*
                r6 = this;
                com.cyberneid.disigon.VerifyActivity r7 = com.cyberneid.disigon.VerifyActivity.this
                java.lang.String r7 = r7.f6453d
                java.lang.String r7 = com.cyberneid.disigon.C2125f.m8367b((java.lang.String) r7)
                java.lang.String r0 = "application/pdf"
                boolean r0 = r0.equals(r7)
                if (r0 != 0) goto L_0x0109
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this
                java.lang.String r0 = r0.f6453d
                java.lang.String r0 = r0.toLowerCase()
                java.lang.String r1 = ".p7m"
                boolean r0 = r0.endsWith(r1)
                if (r0 == 0) goto L_0x0038
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this
                java.lang.String r0 = r0.f6453d
                java.lang.String r0 = r0.toLowerCase()
                java.lang.String r1 = "pdf"
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x0038
                goto L_0x0109
            L_0x0038:
                r7 = 1
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.disigon.VerifyActivity r1 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                android.net.Uri r1 = r1.f6450a     // Catch:{ Throwable -> 0x00f9 }
                java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.a.a r1 = com.cyberneid.p087a.C1451a.m5466a((java.io.InputStream) r0)     // Catch:{ Throwable -> 0x00f9 }
                r0.close()     // Catch:{ Throwable -> 0x00f9 }
                boolean r0 = r1.mo6916e()     // Catch:{ Throwable -> 0x00f9 }
                if (r0 == 0) goto L_0x0065
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r1 = "Attenzione"
                java.lang.String r2 = "Il file firmato è in formato \"detached\" e pertanto il suo contenuto nonn è disponibile"
                com.cyberneid.disigon.VerifyActivity$a$1 r3 = new com.cyberneid.disigon.VerifyActivity$a$1     // Catch:{ Throwable -> 0x00f9 }
                r3.<init>()     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.disigon.p134b.C2081e.m8300a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (com.cyberneid.disigon.p134b.C2081e.C2094c) r3)     // Catch:{ Throwable -> 0x00f9 }
                return
            L_0x0065:
                byte[] r0 = r1.mo6914c()     // Catch:{ Throwable -> 0x00f9 }
            L_0x0069:
                com.cyberneid.a.a r1 = com.cyberneid.p087a.C1451a.m5469a((byte[]) r0)     // Catch:{ Exception -> 0x0079 }
                java.lang.String r2 = "VerifyActivity"
                java.lang.String r3 = "Internal signature found"
                android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x0079 }
                byte[] r0 = r1.mo6914c()     // Catch:{ Exception -> 0x0079 }
                goto L_0x0069
            L_0x0079:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ Throwable -> 0x00f9 }
                com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()     // Catch:{ Throwable -> 0x00f9 }
                r2.recordException(r1)     // Catch:{ Throwable -> 0x00f9 }
                java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00f9 }
                java.io.File r2 = com.cyberneid.disigon.MainApplication.m8077c()     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r3 = "Temp"
                r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x00f9 }
                java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r3 = "Plaintext"
                r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x00f9 }
                boolean r1 = r2.exists()     // Catch:{ Throwable -> 0x00f9 }
                if (r1 != 0) goto L_0x009f
                r2.mkdirs()     // Catch:{ Throwable -> 0x00f9 }
            L_0x009f:
                java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.disigon.VerifyActivity r3 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r3 = r3.f6453d     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r4 = ".p7m"
                java.lang.String r5 = ""
                java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ Throwable -> 0x00f9 }
                r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x00f9 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x00f9 }
                r2.<init>(r1)     // Catch:{ Throwable -> 0x00f9 }
                r2.write(r0)     // Catch:{ Throwable -> 0x00f9 }
                r2.close()     // Catch:{ Throwable -> 0x00f9 }
                android.net.Uri r0 = android.net.Uri.fromFile(r1)     // Catch:{ Throwable -> 0x00f9 }
                android.content.Intent r1 = new android.content.Intent     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r2 = "android.intent.action.VIEW"
                r1.<init>(r2)     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.disigon.VerifyActivity r2 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r2 = r2.f6453d     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r2 = com.cyberneid.disigon.C2125f.m8367b((java.lang.String) r2)     // Catch:{ Throwable -> 0x00f9 }
                r1.setType(r2)     // Catch:{ Throwable -> 0x00f9 }
                r1.setData(r0)     // Catch:{ Throwable -> 0x00f9 }
                r0 = 268435456(0x10000000, float:2.5243549E-29)
                r1.addFlags(r0)     // Catch:{ Throwable -> 0x00f9 }
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Exception -> 0x00e9 }
                java.lang.String r2 = "Open With"
                android.content.Intent r1 = android.content.Intent.createChooser(r1, r2)     // Catch:{ Exception -> 0x00e9 }
                r0.startActivity(r1)     // Catch:{ Exception -> 0x00e9 }
                goto L_0x0135
            L_0x00e9:
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this     // Catch:{ Throwable -> 0x00f9 }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Throwable -> 0x00f9 }
                java.lang.String r1 = "Error: No app found to open the document."
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)     // Catch:{ Throwable -> 0x00f9 }
                r0.show()     // Catch:{ Throwable -> 0x00f9 }
                goto L_0x0135
            L_0x00f9:
                com.cyberneid.disigon.VerifyActivity r0 = com.cyberneid.disigon.VerifyActivity.this
                android.content.Context r0 = r0.getApplicationContext()
                java.lang.String r1 = "Unable to open the document"
                android.widget.Toast r7 = android.widget.Toast.makeText(r0, r1, r7)
                r7.show()
                goto L_0x0135
            L_0x0109:
                android.content.Intent r0 = new android.content.Intent
                com.cyberneid.disigon.VerifyActivity r1 = com.cyberneid.disigon.VerifyActivity.this
                java.lang.Class<com.cyberneid.disigon.PDFNativeViewerActivity> r2 = com.cyberneid.disigon.PDFNativeViewerActivity.class
                r0.<init>(r1, r2)
                r0.setType(r7)
                java.lang.String r7 = "android.intent.action.SEND"
                r0.setAction(r7)
                java.lang.String r7 = "android.intent.extra.STREAM"
                com.cyberneid.disigon.VerifyActivity r1 = com.cyberneid.disigon.VerifyActivity.this
                android.net.Uri r1 = r1.f6450a
                r0.putExtra(r7, r1)
                java.lang.String r7 = "filename"
                com.cyberneid.disigon.VerifyActivity r1 = com.cyberneid.disigon.VerifyActivity.this
                java.lang.String r1 = r1.f6453d
                r0.putExtra(r7, r1)
                com.cyberneid.disigon.VerifyActivity r7 = com.cyberneid.disigon.VerifyActivity.this
                r7.startActivity(r0)
            L_0x0135:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.VerifyActivity.C2064a.onClick(android.view.View):void");
        }
    }

    /* renamed from: com.cyberneid.disigon.VerifyActivity$b */
    public static class C2066b extends BaseAdapter {

        /* renamed from: a */
        private static SimpleDateFormat f6468a = new SimpleDateFormat("dd/MM/yy hh:mm");
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Context f6469b;

        /* renamed from: c */
        private List<C1467o> f6470c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public HashMap<C1467o, Integer> f6471d = new HashMap<>();

        public C2066b(Context context, List<C1467o> list) {
            this.f6469b = context;
            this.f6470c = list;
        }

        public int getCount() {
            return this.f6470c.size();
        }

        public Object getItem(int i) {
            return this.f6470c.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|(1:9)(1:11)|10|12|19) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0114 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r22, android.view.View r23, android.view.ViewGroup r24) {
            /*
                r21 = this;
                r11 = r21
                android.content.Context r0 = r11.f6469b
                java.lang.String r1 = "layout_inflater"
                java.lang.Object r0 = r0.getSystemService(r1)
                android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
                r12 = 0
                r1 = 2131492962(0x7f0c0062, float:1.860939E38)
                r2 = r24
                android.view.View r13 = r0.inflate(r1, r2, r12)
                r0 = 2131296679(0x7f0901a7, float:1.8211281E38)
                android.view.View r0 = r13.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r1 = 2131296390(0x7f090086, float:1.8210695E38)
                android.view.View r1 = r13.findViewById(r1)
                r14 = r1
                android.widget.TextView r14 = (android.widget.TextView) r14
                r1 = 2131296405(0x7f090095, float:1.8210726E38)
                android.view.View r1 = r13.findViewById(r1)
                r15 = r1
                android.widget.TextView r15 = (android.widget.TextView) r15
                r1 = 2131296674(0x7f0901a2, float:1.8211271E38)
                android.view.View r1 = r13.findViewById(r1)
                r4 = r1
                android.widget.TextView r4 = (android.widget.TextView) r4
                r1 = 2131296371(0x7f090073, float:1.8210657E38)
                android.view.View r1 = r13.findViewById(r1)
                r8 = r1
                android.widget.TextView r8 = (android.widget.TextView) r8
                r1 = 2131296700(0x7f0901bc, float:1.8211324E38)
                android.view.View r1 = r13.findViewById(r1)
                r10 = r1
                android.widget.TextView r10 = (android.widget.TextView) r10
                r1 = 2131296360(0x7f090068, float:1.8210634E38)
                android.view.View r1 = r13.findViewById(r1)
                r9 = r1
                android.widget.TextView r9 = (android.widget.TextView) r9
                r1 = 2131296669(0x7f09019d, float:1.8211261E38)
                android.view.View r1 = r13.findViewById(r1)
                r6 = r1
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                r1 = 2131296370(0x7f090072, float:1.8210655E38)
                android.view.View r1 = r13.findViewById(r1)
                r7 = r1
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                r1 = 2131296699(0x7f0901bb, float:1.8211322E38)
                android.view.View r1 = r13.findViewById(r1)
                r5 = r1
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r1 = 2131296333(0x7f09004d, float:1.821058E38)
                android.view.View r1 = r13.findViewById(r1)
                r16 = r1
                com.wang.avi.AVLoadingIndicatorView r16 = (com.wang.avi.AVLoadingIndicatorView) r16
                r16.show()
                java.util.List<com.cyberneid.a.o> r1 = r11.f6470c     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r2 = r22
                java.lang.Object r1 = r1.get(r2)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r17 = r1
                com.cyberneid.a.o r17 = (com.cyberneid.p087a.C1467o) r17     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r5.setVisibility(r12)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                com.cyberneid.disigon.VerifyActivity$b$1 r18 = new com.cyberneid.disigon.VerifyActivity$b$1     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r1 = r18
                r2 = r21
                r3 = r17
                r19 = r5
                r5 = r16
                r20 = r9
                r9 = r19
                r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                com.p137e.p139b.C2140d.m8401a(r18)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                java.security.cert.X509Certificate r1 = r17.mo6947a()     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                org.spongycastle.cert.X509CertificateHolder r2 = new org.spongycastle.cert.X509CertificateHolder     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                byte[] r3 = r1.getEncoded()     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r2.<init>((byte[]) r3)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                org.spongycastle.asn1.x500.X500Name r2 = r2.getSubject()     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x500.style.BCStyle.GIVENNAME     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.RDN[] r3 = r2.getRDNs(r3)     // Catch:{ Exception -> 0x0114 }
                r3 = r3[r12]     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.x500.style.BCStyle.SURNAME     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.RDN[] r4 = r2.getRDNs(r4)     // Catch:{ Exception -> 0x0114 }
                r4 = r4[r12]     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x500.style.BCStyle.f7390CN     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.RDN[] r5 = r2.getRDNs(r5)     // Catch:{ Exception -> 0x0114 }
                r5 = r5[r12]     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.AttributeTypeAndValue r3 = r3.getFirst()     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.ASN1Encodable r3 = r3.getValue()     // Catch:{ Exception -> 0x0114 }
                java.lang.String r3 = org.spongycastle.asn1.x500.style.IETFUtils.valueToString(r3)     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.AttributeTypeAndValue r4 = r4.getFirst()     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.ASN1Encodable r4 = r4.getValue()     // Catch:{ Exception -> 0x0114 }
                java.lang.String r4 = org.spongycastle.asn1.x500.style.IETFUtils.valueToString(r4)     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.x500.AttributeTypeAndValue r5 = r5.getFirst()     // Catch:{ Exception -> 0x0114 }
                org.spongycastle.asn1.ASN1Encodable r5 = r5.getValue()     // Catch:{ Exception -> 0x0114 }
                java.lang.String r5 = org.spongycastle.asn1.x500.style.IETFUtils.valueToString(r5)     // Catch:{ Exception -> 0x0114 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0114 }
                r6.<init>()     // Catch:{ Exception -> 0x0114 }
                r6.append(r3)     // Catch:{ Exception -> 0x0114 }
                java.lang.String r3 = " "
                r6.append(r3)     // Catch:{ Exception -> 0x0114 }
                r6.append(r4)     // Catch:{ Exception -> 0x0114 }
                java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x0114 }
                r0.setText(r3)     // Catch:{ Exception -> 0x0114 }
                r14.setText(r5)     // Catch:{ Exception -> 0x0114 }
                goto L_0x0124
            L_0x0114:
                java.lang.String r2 = r2.toString()     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r3 = 5
                r0.setLines(r3)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r0.setText(r2)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r0 = 8
                r14.setVisibility(r0)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
            L_0x0124:
                java.util.Date r0 = r17.mo6949c()     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                if (r0 == 0) goto L_0x0139
                java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                java.lang.String r3 = "dd/MM/yyyy HH:mm:ss"
                r2.<init>(r3)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                java.lang.String r0 = r2.format(r0)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
            L_0x0135:
                r15.setText(r0)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                goto L_0x013c
            L_0x0139:
                java.lang.String r0 = "non disponibile"
                goto L_0x0135
            L_0x013c:
                java.lang.String r0 = com.cyberneid.disigon.C2125f.m8370c((java.security.cert.X509Certificate) r1)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                r1 = r20
                r1.setText(r0)     // Catch:{ g -> 0x0150, CertificateEncodingException -> 0x014b, IOException -> 0x0146 }
                goto L_0x0154
            L_0x0146:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0154
            L_0x014b:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0154
            L_0x0150:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0154:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.VerifyActivity.C2066b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    /* renamed from: a */
    private void m8216a(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        if (("android.intent.action.SEND".equals(action) || "android.intent.action.VIEW".equals(action)) && type != null) {
            this.f6450a = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            this.f6453d = intent.getStringExtra("filename");
            if (this.f6450a == null) {
                this.f6450a = intent.getData();
            }
            Uri uri = this.f6450a;
            if (uri == null) {
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                instance.log("action " + action);
                FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
                instance2.log("type " + type);
                FirebaseCrashlytics instance3 = FirebaseCrashlytics.getInstance();
                instance3.log("filename " + this.f6453d);
                FirebaseCrashlytics.getInstance().log(intent.toString());
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("pdfUri is null"));
                return;
            }
            setTitle(uri.getLastPathSegment());
            try {
                this.f6451b = getContentResolver().openFileDescriptor(this.f6450a, "r");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            m8219a(type);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8217a(TextView textView, ArrayList arrayList) {
        textView.setText(this.f6456g);
        C2066b bVar = new C2066b(this, arrayList);
        ((ListView) findViewById(R.id.signerListView)).setAdapter(bVar);
        bVar.notifyDataSetChanged();
        this.f6458i.hide();
        this.f6459j.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8218a(InputStream inputStream, TextView textView) {
        Runnable r7;
        C2127h.m8378b("p7m");
        ArrayList arrayList = new ArrayList();
        try {
            C1451a a = C1451a.m5466a(inputStream);
            int a2 = a.mo6910a();
            for (int i = 0; i < a2; i++) {
                arrayList.add(a.mo6911a(i));
            }
            if (a.mo6916e()) {
                r7 = new Runnable() {
                    public void run() {
                        C2081e.m8300a((Context) VerifyActivity.this, "Attenzione", "Il file firmato è in formato \"detached\" e pertanto non può essere verificato senza il  suo contenuto originale", (C2081e.C2094c) new C2081e.C2094c() {
                            /* renamed from: a */
                            public void mo8543a() {
                            }
                        });
                    }
                };
                runOnUiThread(r7);
                return;
            }
            try {
                byte[] c = a.mo6914c();
                while (true) {
                    C1451a a3 = C1451a.m5469a(c);
                    Log.d("VerifyActivity", "Internal signature found");
                    byte[] c2 = a3.mo6914c();
                    int a4 = a3.mo6910a();
                    for (int i2 = 0; i2 < a4; i2++) {
                        arrayList.add(a3.mo6911a(i2));
                    }
                    c = c2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                r7 = new Runnable(arrayList, textView) {
                    private final /* synthetic */ ArrayList f$1;
                    private final /* synthetic */ TextView f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        VerifyActivity.this.m8220a(this.f$1, this.f$2);
                    }
                };
            }
        } catch (C1458g e2) {
            e2.printStackTrace();
            r7 = new Runnable() {
                public void run() {
                    VerifyActivity.this.f6458i.hide();
                    VerifyActivity.this.f6459j.setVisibility(4);
                    C2081e.m8300a((Context) VerifyActivity.this, "Errore", "Il file firmato non è valido e non può essere verificato", (C2081e.C2094c) new C2081e.C2094c() {
                        /* renamed from: a */
                        public void mo8543a() {
                        }
                    });
                }
            };
        }
    }

    /* renamed from: a */
    private void m8219a(String str) {
        this.f6457h.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_NEW_VERIFICATION), getResources().getString(R.string.FRBS_NEW_VERIFICATION_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
        try {
            InputStream openInputStream = getContentResolver().openInputStream(this.f6450a);
            ((TextView) findViewById(R.id.fileName)).setText(this.f6453d);
            TextView textView = (TextView) findViewById(R.id.nrSigners);
            this.f6459j.setVisibility(0);
            this.f6458i.show();
            C2140d.m8402a("application/pdf".equals(str) ? new Runnable(openInputStream, textView) {
                private final /* synthetic */ InputStream f$1;
                private final /* synthetic */ TextView f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    VerifyActivity.this.m8222b(this.f$1, this.f$2);
                }
            } : new Runnable(openInputStream, textView) {
                private final /* synthetic */ InputStream f$1;
                private final /* synthetic */ TextView f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    VerifyActivity.this.m8218a(this.f$1, this.f$2);
                }
            }, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8220a(ArrayList arrayList, TextView textView) {
        this.f6454e = "";
        this.f6456g = "" + arrayList.size();
        textView.setText(this.f6456g);
        C2066b bVar = new C2066b(this, arrayList);
        ((ListView) findViewById(R.id.signerListView)).setAdapter(bVar);
        bVar.notifyDataSetChanged();
        this.f6458i.hide();
        this.f6459j.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m8222b(InputStream inputStream, TextView textView) {
        C2127h.m8378b("pdf");
        ArrayList arrayList = new ArrayList();
        C1464l lVar = new C1464l();
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            lVar.mo6940a(bArr);
            Integer valueOf = Integer.valueOf(lVar.mo6939a());
            this.f6456g = valueOf.toString();
            for (int i = 0; i < valueOf.intValue(); i++) {
                try {
                    arrayList.add(lVar.mo6941a(i).mo6911a(0));
                } catch (C1458g e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        runOnUiThread(new Runnable(textView, arrayList) {
            private final /* synthetic */ TextView f$1;
            private final /* synthetic */ ArrayList f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                VerifyActivity.this.m8217a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6457h = new C2068a(this);
        setContentView((int) R.layout.activity_verify);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6452c = (TextView) findViewById(R.id.verifyTextView);
        this.f6455f = (ProgressBar) findViewById(R.id.progressBar);
        ((TextView) findViewById(R.id.fileName)).setMovementMethod(new ScrollingMovementMethod());
        this.f6458i = (AVLoadingIndicatorView) findViewById(R.id.avi);
        this.f6459j = (RelativeLayout) findViewById(R.id.aviView);
        int integer = (int) (((double) getResources().getInteger(R.integer.icon_size_right)) * 0.8d);
        Drawable drawable = getResources().getDrawable(R.drawable.hand_sign);
        drawable.setBounds(0, 0, integer, integer);
        this.f6452c.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        C2064a aVar = new C2064a();
        ((Button) findViewById(R.id.buttonSign)).setOnClickListener(aVar);
        ((LinearLayout) findViewById(R.id.buttonSignLayout)).setOnClickListener(aVar);
        ((ImageButton) findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VerifyActivity.this.finish();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonCancelLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VerifyActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m8216a(getIntent());
    }
}
