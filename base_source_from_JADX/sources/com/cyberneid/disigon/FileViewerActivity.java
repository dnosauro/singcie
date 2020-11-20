package com.cyberneid.disigon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1451a;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileViewerActivity extends C2072b {

    /* renamed from: a */
    private LinearLayout f6215a;

    /* renamed from: b */
    private TextView f6216b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Uri f6217c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f6218d;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8046a() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", this.f6217c);
        intent.setType("application/p7m");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    /* renamed from: a */
    private void m8047a(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        this.f6217c = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        this.f6218d = C2125f.m8366b(this, this.f6217c, type);
        if (this.f6217c == null) {
            this.f6217c = intent.getData();
        }
        Uri uri = this.f6217c;
        if (uri == null) {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            instance.log("action " + action);
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.log("type " + type);
            FirebaseCrashlytics instance3 = FirebaseCrashlytics.getInstance();
            instance3.log("filename " + this.f6218d);
            FirebaseCrashlytics.getInstance().log(intent.toString());
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("fileUri is null"));
            return;
        }
        setTitle(uri.getLastPathSegment());
        ((TextView) findViewById(R.id.fileNameTextView)).setText(this.f6217c.getLastPathSegment());
        try {
            FileInputStream fileInputStream = new FileInputStream(getContentResolver().openFileDescriptor(this.f6217c, "r").getFileDescriptor());
            C1451a a = C1451a.m5466a((InputStream) fileInputStream);
            fileInputStream.close();
            int a2 = a.mo6910a();
            if (a.mo6916e()) {
                C2081e.m8300a((Context) this, "Attenzione", "Il file firmato è in formato \"detached\" e pertanto il suo contenuto non è disponibile", (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                    }
                });
                return;
            }
            byte[] c = a.mo6914c();
            while (true) {
                try {
                    C1451a a3 = C1451a.m5469a(c);
                    Log.d("FileViewerActivity", "Internal signature found");
                    byte[] c2 = a3.mo6914c();
                    a2 += a3.mo6910a();
                    c = c2;
                } catch (Exception unused) {
                    if (a2 > 0) {
                        ((TextView) findViewById(R.id.signatureInfoTextView)).setText(getResources().getQuantityString(R.plurals.no_of_signatures, a2, new Object[]{Integer.valueOf(a2)}));
                        findViewById(R.id.signatureInfoView).setVisibility(0);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8049b() {
        String b = C2125f.m8367b(this.f6218d);
        Intent intent = new Intent(this, FileSignerActivity.class);
        intent.setType(b);
        intent.setAction(getIntent().getAction());
        intent.putExtra("android.intent.extra.STREAM", this.f6217c);
        intent.putExtra("filename", C2125f.m8366b(this, this.f6217c, b));
        intent.putExtra("command", "sign");
        intent.putExtra("signatureType", "p7m");
        if ("android.intent.action.SIGN_AND_RETURN".equals(getIntent().getAction())) {
            startActivityForResult(intent, 1);
        } else {
            startActivity(intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), DigitalSignatureActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fileviewer);
        this.f6215a = (LinearLayout) findViewById(R.id.readLayout);
        this.f6216b = (TextView) findViewById(R.id.fileNameTextView);
        int integer = getResources().getInteger(R.integer.icon_size_button);
        getResources().getDrawable(R.drawable.file).setBounds(0, 0, integer, integer);
        ((Button) findViewById(R.id.buttonShare)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileViewerActivity.this.m8046a();
            }
        });
        ((LinearLayout) findViewById(R.id.buttonShareLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileViewerActivity.this.m8046a();
            }
        });
        ((Button) findViewById(R.id.buttonSign)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileViewerActivity.this.m8049b();
            }
        });
        ((ImageButton) findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileViewerActivity.this.startActivity(new Intent(FileViewerActivity.this.getApplicationContext(), DigitalSignatureActivity.class));
            }
        });
        ((LinearLayout) findViewById(R.id.buttonCancelLayout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileViewerActivity.this.startActivity(new Intent(FileViewerActivity.this.getApplicationContext(), DigitalSignatureActivity.class));
            }
        });
        ((Button) findViewById(R.id.buttonSignature)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String b = C2125f.m8367b(FileViewerActivity.this.f6218d);
                Intent intent = new Intent(FileViewerActivity.this, VerifyActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", FileViewerActivity.this.f6217c);
                FileViewerActivity fileViewerActivity = FileViewerActivity.this;
                intent.putExtra("filename", C2125f.m8366b(fileViewerActivity, fileViewerActivity.f6217c, b));
                FileViewerActivity.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m8047a(getIntent());
    }
}
