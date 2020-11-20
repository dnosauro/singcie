package com.scanlibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks2;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.scanlibrary.C3076d;

public class ScanActivity extends Activity implements ComponentCallbacks2, C3069a {
    static {
        System.loadLibrary("opencv_java3");
        System.loadLibrary("Scanner");
    }

    /* renamed from: c */
    private void m8887c() {
        C3070b bVar = new C3070b();
        Bundle bundle = new Bundle();
        bundle.putInt("selectContent", mo23927b());
        bVar.setArguments(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(C3076d.C3080d.content, bVar);
        beginTransaction.addToBackStack(C3070b.class.toString());
        beginTransaction.commit();
    }

    /* renamed from: a */
    public void mo23925a() {
        getFragmentManager().popBackStack();
        m8887c();
    }

    /* renamed from: a */
    public void mo23926a(Uri uri) {
        C3103g gVar = new C3103g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedBitmap", uri);
        gVar.setArguments(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(C3076d.C3080d.content, gVar);
        beginTransaction.addToBackStack(C3103g.class.toString());
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo23927b() {
        return getIntent().getIntExtra("selectContent", 0);
    }

    /* renamed from: b */
    public void mo23928b(Uri uri) {
        C3083e eVar = new C3083e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("scannedResult", uri);
        eVar.setArguments(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(C3076d.C3080d.content, eVar);
        beginTransaction.addToBackStack(C3083e.class.toString());
        beginTransaction.commit();
    }

    public native Bitmap getBWBitmap(Bitmap bitmap);

    public native Bitmap getGrayBitmap(Bitmap bitmap);

    public native Bitmap getMagicColorBitmap(Bitmap bitmap);

    public native float[] getPoints(Bitmap bitmap);

    public native Bitmap getScannedBitmap(Bitmap bitmap, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C3076d.C3081e.scan_layout);
        m8887c();
    }

    public void onTrimMemory(int i) {
        if (i != 5 && i != 10 && i != 15 && i != 20) {
            if (i == 40 || i == 60 || i == 80) {
                new AlertDialog.Builder(this).setTitle(C3076d.C3082f.low_memory).setMessage(C3076d.C3082f.low_memory_message).create().show();
            }
        }
    }
}
