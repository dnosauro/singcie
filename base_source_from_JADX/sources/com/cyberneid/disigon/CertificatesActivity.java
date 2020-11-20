package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigon.C2098c;
import com.cyberneid.disigon.CertificatesActivity;
import com.cyberneid.disigon.p133a.C2069a;
import com.cyberneid.disigon.p133a.C2070b;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1454c;
import com.cyberneid.p087a.C1458g;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.jce.provider.X509CertificateObject;

public class CertificatesActivity extends C2098c {

    /* renamed from: h */
    private C2068a f6153h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C2117d f6154i;

    /* renamed from: j */
    private ArrayList<String> f6155j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<X509Certificate> f6156k;

    /* renamed from: l */
    private AdView f6157l;

    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<X509Certificate> m8001d() {
        this.f6156k = new ArrayList();
        this.f6155j.clear();
        File[] listFiles = getFilesDir().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".cer");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    C2126g.m8374a(new FileInputStream(file), byteArrayOutputStream);
                    try {
                        try {
                            X509CertificateObject x509CertificateObject = new X509CertificateObject(Certificate.getInstance(ASN1Primitive.fromByteArray(byteArrayOutputStream.toByteArray())));
                            this.f6155j.add(x509CertificateObject.getSubjectDN().toString());
                            this.f6156k.add(x509CertificateObject);
                        } catch (CertificateParsingException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        throw new C1458g(-2130706268);
                    } catch (C1458g e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return this.f6156k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8520b() {
        this.f6532f = new AsyncTask<Void, Void, Void>() {

            /* renamed from: a */
            X509CertificateHolder f6161a = null;

            /* renamed from: b */
            int f6162b;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public AlertDialog f6164d;

            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8004a() {
                CertificatesActivity certificatesActivity = CertificatesActivity.this;
                C2081e.m8302b(certificatesActivity, "Error", certificatesActivity.getResources().getString(R.string.error_msg)).show();
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public /* synthetic */ void m8005b() {
                CertificatesActivity.this.mo8719a((C2098c.C2116a) new C2098c.C2116a() {
                    /* renamed from: a */
                    public void mo8529a() {
                    }
                });
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                try {
                    Log.d("CertificatesActivity", "starting reading certificate");
                    C2069a a = C2070b.m8242a().mo8680a(CertificatesActivity.this.f6529c);
                    this.f6162b = a.mo8674a(0);
                    if (this.f6162b == 0) {
                        Log.d("CertificatesActivity", "open session succeeded");
                        this.f6162b = a.mo8675a(CertificatesActivity.this.f6530d);
                        if (this.f6162b == 0) {
                            Log.d("CertificatesActivity", "login succeded");
                            this.f6161a = a.mo8678b((C1454c) null);
                            Log.d("CertificatesActivity", "cert " + this.f6161a);
                            a.mo8679b();
                            a.mo8676a();
                            CertificatesActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    C19534.this.f6164d.dismiss();
                                }
                            });
                            if (this.f6161a != null) {
                                File filesDir = CertificatesActivity.this.getFilesDir();
                                File file = new File(filesDir, this.f6161a.getSerialNumber().toString() + ".cer");
                                if (!file.exists()) {
                                    Log.d("CertificatesActivity", "save cert " + this.f6161a);
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    fileOutputStream.write(this.f6161a.getEncoded());
                                    fileOutputStream.close();
                                    List unused = CertificatesActivity.this.f6156k = CertificatesActivity.this.m8001d();
                                    CertificatesActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            CertificatesActivity.this.f6154i.notifyDataSetChanged();
                                        }
                                    });
                                } else {
                                    Log.d("CertificatesActivity", "cert exists " + this.f6161a.getSerialNumber().toString());
                                }
                            }
                            CertificatesActivity.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    CertificatesActivity.C19534.this.m8005b();
                                }
                            });
                        } else {
                            CertificatesActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    C19534.this.f6164d.dismiss();
                                }
                            });
                            CertificatesActivity.this.mo8718a(this.f6162b);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    CertificatesActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            CertificatesActivity.C19534.this.m8004a();
                        }
                    });
                }
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                CertificatesActivity certificatesActivity = CertificatesActivity.this;
                this.f6164d = C2081e.m8296a((Context) certificatesActivity, certificatesActivity.getResources().getString(R.string.please_wait), CertificatesActivity.this.getResources().getString(R.string.wait_reading));
                this.f6164d.show();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6153h = new C2068a(this);
        setContentView((int) R.layout.activity_certificates);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6157l = (AdView) findViewById(R.id.adView);
        this.f6157l.loadAd(new AdRequest.Builder().build());
        this.f6155j = new ArrayList<>();
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.certificate_white);
        drawable.setBounds(0, 0, integer, integer);
        ((TextView) findViewById(R.id.certificatesTextView)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CertificatesActivity.this.mo8720c();
            }
        });
        ListView listView = (ListView) findViewById(R.id.certificatesList);
        this.f6154i = new C2117d(this, R.layout.item_certificates, this.f6155j);
        listView.setAdapter(this.f6154i);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(view.getContext(), CertificateDetailActivity.class);
                X509Certificate x509Certificate = (X509Certificate) CertificatesActivity.this.f6156k.get(i);
                try {
                    intent.putExtra("subjectName", C2125f.m8373e(x509Certificate));
                    intent.putExtra("issuedTo", C2125f.m8372d(x509Certificate));
                    intent.putExtra("issuedBy", C2125f.m8370c(x509Certificate));
                    intent.putExtra("validFrom", C2125f.m8362a(x509Certificate));
                    intent.putExtra("validTo", C2125f.m8368b(x509Certificate));
                    intent.putExtra("keyUsage", x509Certificate.getKeyUsage());
                    intent.putExtra("extendedKeyUsage", x509Certificate.getExtendedKeyUsage().get(0));
                    CertificatesActivity.this.startActivity(intent);
                } catch (CertificateParsingException e) {
                    e.printStackTrace();
                }
            }
        });
        this.f6156k = m8001d();
    }
}
