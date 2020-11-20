package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.cyberneid.disigon.C2098c;
import com.cyberneid.disigon.p133a.C2069a;
import com.cyberneid.disigon.p133a.C2070b;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1451a;
import com.cyberneid.p087a.C1454c;
import com.cyberneid.p087a.C1458g;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.spongycastle.cert.X509CertificateHolder;

public class FileSignerActivity extends C2098c {

    /* renamed from: h */
    private ParcelFileDescriptor f6197h;

    /* renamed from: i */
    private Uri f6198i;

    /* renamed from: j */
    private C2069a f6199j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f6200k;

    /* renamed from: l */
    private String f6201l;

    /* renamed from: m */
    private C2068a f6202m;

    /* renamed from: com.cyberneid.disigon.FileSignerActivity$a */
    private class C1973a implements View.OnClickListener {
        private C1973a() {
        }

        public void onClick(View view) {
            FileSignerActivity.this.mo8720c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1451a m8028a(String str) {
        this.f6199j = C2070b.m8242a().mo8680a(this.f6529c);
        try {
            if (this.f6199j.mo8674a(0) == 0) {
                Log.d("FileSignerActivity", "open session succeded");
                int a = this.f6199j.mo8675a(str);
                if (a == 0) {
                    Log.d("FileSignerActivity", "login succeded");
                    FileInputStream fileInputStream = new FileInputStream(this.f6197h.getFileDescriptor());
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    X509CertificateHolder b = this.f6199j.mo8678b((C1454c) null);
                    C1451a a2 = this.f6199j.mo6924a(bArr, (C1454c) null, true, false, true);
                    this.f6199j.mo8679b();
                    this.f6199j.mo8676a();
                    File filesDir = getFilesDir();
                    File file = new File(filesDir, b.getSerialNumber().toString() + ".cer");
                    if (!file.exists()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(b.getEncoded());
                        fileOutputStream.close();
                    }
                    return a2;
                }
                Log.d("FileSignerActivity", "error " + a);
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                instance.recordException(new RuntimeException("error: " + a));
                this.f6200k = a;
                return null;
            }
            Log.d("FileSignerActivity", "open session failed");
            this.f6200k = 301;
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.recordException(new RuntimeException("STATUS_OPEN_SESSION_FAILED: " + this.f6200k));
            return null;
        } catch (Exception e) {
            this.f6199j.mo8676a();
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            throw new C1458g(-2130706261);
        }
    }

    /* renamed from: a */
    private void m8030a(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        if (("android.intent.action.SEND".equals(action) || "android.intent.action.VIEW".equals(action)) && type != null) {
            this.f6198i = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            this.f6201l = intent.getStringExtra("filename");
            if (this.f6198i == null) {
                this.f6198i = intent.getData();
            }
            Uri uri = this.f6198i;
            if (uri == null) {
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                instance.log("action " + action);
                FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
                instance2.log("type " + type);
                FirebaseCrashlytics instance3 = FirebaseCrashlytics.getInstance();
                instance3.log("filename " + this.f6201l);
                FirebaseCrashlytics.getInstance().log(intent.toString());
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("fileUri is null"));
                return;
            }
            setTitle(uri.getLastPathSegment());
            ((TextView) findViewById(R.id.fileNameTextView)).setText(this.f6201l);
            try {
                this.f6197h = getContentResolver().openFileDescriptor(this.f6198i, "r");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if ("sign".equals(intent.getStringExtra("command"))) {
                mo8720c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8031a(C1451a aVar, final File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            aVar.mo6912a((OutputStream) fileOutputStream);
            fileOutputStream.close();
            Log.d("FileSignerActivity", "file saved, open preview");
            this.f6202m.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_NEW_SIGNATURE), getResources().getString(R.string.FRBS_GENERIC_FILE), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
            if (!C2078b.m8280a("DIKE_MESSAGE", false)) {
                C2081e.m8299a(this, "Avviso", getResources().getString(R.string.dike_message), R.layout.dialog_dike_message, new C2081e.C2093b() {
                    /* renamed from: a */
                    public void mo8552a(boolean z) {
                        if (z) {
                            C2078b.m8282b("DIKE_MESSAGE", true);
                        }
                        FileSignerActivity.this.m8034a(file);
                    }
                });
            } else {
                m8034a(file);
            }
        } catch (Exception e) {
            Log.d("FileSignerActivity", "IOException: file not saved");
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8034a(File file) {
        try {
            if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
                setResult(-1, intent);
            } else {
                Intent intent2 = this.f6201l.toLowerCase().contains(".pdf.") ? new Intent(this, PDFNativeViewerActivity.class) : new Intent(this, FileViewerActivity.class);
                intent2.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
                intent2.putExtra("filename", this.f6201l);
                intent2.setAction("android.intent.action.SEND");
                intent2.setType("application/p7m");
                startActivity(intent2);
            }
            finish();
        } catch (Exception e) {
            Log.d("FileSignerActivity", "IOException: file not saved");
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public File m8036d() {
        String str;
        if (!C2125f.m8369c(this.f6201l).equals("p7m")) {
            str = this.f6201l + ".p7m";
        } else {
            str = this.f6201l;
        }
        return C2125f.m8360a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8520b() {
        this.f6532f = new AsyncTask<Void, Void, Void>() {

            /* renamed from: a */
            C1451a f6207a;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public boolean f6209c;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public File f6210d;

            /* renamed from: e */
            private AlertDialog f6211e;

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                try {
                    Log.d("FileSignerActivity", "starting signature");
                    this.f6207a = FileSignerActivity.this.m8028a(FileSignerActivity.this.f6530d);
                    if (this.f6207a != null) {
                        Log.d("FileSignerActivity", "signature succeded");
                        this.f6210d = FileSignerActivity.this.m8036d();
                        if (this.f6210d.exists()) {
                            this.f6209c = true;
                            return null;
                        }
                        this.f6209c = false;
                        return null;
                    }
                    Log.d("FileSignerActivity", "signature failed: " + FileSignerActivity.this.f6200k);
                    return null;
                } catch (C1458g e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    int unused = FileSignerActivity.this.f6200k = (int) e.mo6921a();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e2);
                    int unused2 = FileSignerActivity.this.f6200k = 300;
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(Void voidR) {
                FileSignerActivity fileSignerActivity;
                int i;
                Resources resources;
                String str;
                super.onPostExecute(voidR);
                this.f6211e.dismiss();
                int b = FileSignerActivity.this.f6200k;
                if (b != 0) {
                    switch (b) {
                        case 300:
                            fileSignerActivity = FileSignerActivity.this;
                            str = fileSignerActivity.getResources().getString(R.string.app_name);
                            resources = FileSignerActivity.this.getResources();
                            i = R.string.generic_error;
                            break;
                        case 301:
                            fileSignerActivity = FileSignerActivity.this;
                            str = fileSignerActivity.getResources().getString(R.string.app_name);
                            resources = FileSignerActivity.this.getResources();
                            i = R.string.no_device_found;
                            break;
                        default:
                            FileSignerActivity fileSignerActivity2 = FileSignerActivity.this;
                            fileSignerActivity2.mo8718a(fileSignerActivity2.f6200k);
                            return;
                    }
                    C2081e.m8302b(fileSignerActivity, str, resources.getString(i)).show();
                    return;
                }
                FileSignerActivity.this.mo8719a((C2098c.C2116a) new C2098c.C2116a() {
                    /* renamed from: a */
                    public void mo8529a() {
                        if (C19704.this.f6209c) {
                            C2081e.m8301a((Context) FileSignerActivity.this, FileSignerActivity.this.getResources().getString(R.string.overwrite_file_title), FileSignerActivity.this.getResources().getString(R.string.overwrite_file), (C2081e.C2096e) new C2081e.C2096e() {
                                /* renamed from: a */
                                public void mo8558a() {
                                    FileSignerActivity.this.m8031a(C19704.this.f6207a, C19704.this.f6210d);
                                }

                                /* renamed from: b */
                                public void mo8559b() {
                                    if ("android.intent.action.SIGN_AND_RETURN".equals(FileSignerActivity.this.getIntent().getAction())) {
                                        FileSignerActivity.this.setResult(0);
                                    }
                                    FileSignerActivity.this.finish();
                                }
                            });
                        } else {
                            FileSignerActivity.this.m8031a(C19704.this.f6207a, C19704.this.f6210d);
                        }
                    }
                });
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                int unused = FileSignerActivity.this.f6200k = 0;
                this.f6209c = false;
                FileSignerActivity fileSignerActivity = FileSignerActivity.this;
                this.f6211e = C2081e.m8296a((Context) fileSignerActivity, fileSignerActivity.getResources().getString(R.string.please_wait), FileSignerActivity.this.getResources().getString(R.string.wait_signing));
                this.f6211e.show();
            }
        };
    }

    public void onBackPressed() {
        if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
            setResult(0);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_filesigner);
        this.f6202m = new C2068a(this);
        int integer = getResources().getInteger(R.integer.icon_size_button);
        Drawable drawable = getResources().getDrawable(R.drawable.file);
        drawable.setBounds(0, 0, integer, integer);
        ((TextView) findViewById(R.id.fileNameTextView)).setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        C1973a aVar = new C1973a();
        ((Button) findViewById(R.id.buttonSign)).setOnClickListener(aVar);
        ((LinearLayout) findViewById(R.id.buttonSignLayout)).setOnClickListener(aVar);
        ((ImageButton) findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ("android.intent.action.SIGN_AND_RETURN".equals(FileSignerActivity.this.getIntent().getAction())) {
                    FileSignerActivity.this.setResult(0);
                }
                FileSignerActivity.this.finish();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonCancelLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ("android.intent.action.SIGN_AND_RETURN".equals(FileSignerActivity.this.getIntent().getAction())) {
                    FileSignerActivity.this.setResult(0);
                }
                FileSignerActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        m8030a(getIntent());
        super.onStart();
    }
}
