package com.cyberneid.disigon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.C0094d;
import com.cyberneid.disigon.ScanDocumentActivity;
import com.cyberneid.disigon.p134b.C2097f;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p105d.p114g.C1783c;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p137e.p139b.C2140d;
import com.scanlibrary.ScanActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ScanDocumentActivity extends C0094d {

    /* renamed from: a */
    private final int f6433a = 2;

    /* renamed from: b */
    private ListView f6434b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<Bitmap> f6435c;

    /* renamed from: d */
    private C2128i f6436d;

    /* renamed from: e */
    private AdView f6437e;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8210a() {
        this.f6436d.notifyDataSetChanged();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 2) {
            Log.d("ScanDocumentActivity", "User cancelled file browsing {}");
        } else if (i2 != -1) {
            finish();
        } else if (intent != null) {
            Uri data = intent.getData();
            System.out.println(data);
            try {
                this.f6435c.add(C2097f.m8317c(this, data));
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ScanDocumentActivity.this.m8210a();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scan_document);
        this.f6437e = (AdView) findViewById(R.id.adView);
        this.f6437e.loadAd(new AdRequest.Builder().build());
        this.f6434b = (ListView) findViewById(R.id.pageListView);
        this.f6435c = new ArrayList<>();
        this.f6436d = new C2128i(this, this.f6435c);
        this.f6434b.setAdapter(this.f6436d);
        ((ImageButton) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ScanDocumentActivity.this.setResult(0);
                ScanDocumentActivity.this.finish();
            }
        });
        ((ImageButton) findViewById(R.id.addButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ScanDocumentActivity.this, ScanActivity.class);
                intent.putExtra("selectContent", 4);
                ScanDocumentActivity.this.startActivityForResult(intent, 2);
            }
        });
        ((ImageButton) findViewById(R.id.saveButton)).setOnClickListener(new View.OnClickListener() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void m8211a() {
                try {
                    C1783c a = C2097f.m8312a((ArrayList<Bitmap>) ScanDocumentActivity.this.f6435c);
                    File createTempFile = File.createTempFile("document", ".pdf", ScanDocumentActivity.this.getFilesDir());
                    a.mo8060a(createTempFile);
                    a.close();
                    Uri fromFile = Uri.fromFile(createTempFile);
                    Intent intent = new Intent();
                    intent.setData(fromFile);
                    ScanDocumentActivity.this.setResult(-1, intent);
                    ScanDocumentActivity.this.finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void onClick(View view) {
                C2140d.m8401a(new Runnable() {
                    public final void run() {
                        ScanDocumentActivity.C20503.this.m8211a();
                    }
                });
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.f6435c.size() == 0) {
            FirebaseCrashlytics.getInstance().log("scan from camera");
            Intent intent = new Intent(this, ScanActivity.class);
            intent.putExtra("selectContent", 4);
            startActivityForResult(intent, 2);
        }
    }
}
