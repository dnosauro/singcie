package com.scanlibrary;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.core.content.FileProvider;
import com.scanlibrary.C3076d;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.scanlibrary.b */
public class C3070b extends Fragment {

    /* renamed from: a */
    Bitmap f7157a = null;

    /* renamed from: b */
    private View f7158b;

    /* renamed from: c */
    private ImageButton f7159c;

    /* renamed from: d */
    private ImageButton f7160d;

    /* renamed from: e */
    private Uri f7161e;

    /* renamed from: f */
    private C3069a f7162f;

    /* renamed from: com.scanlibrary.b$a */
    private class C3072a implements View.OnClickListener {
        private C3072a() {
        }

        public void onClick(View view) {
            C3070b.this.mo23939b();
        }
    }

    /* renamed from: com.scanlibrary.b$b */
    private class C3073b implements View.OnClickListener {
        private C3073b() {
        }

        public void onClick(View view) {
            C3070b.this.mo23937a();
        }
    }

    /* renamed from: a */
    private static int m8895a(int i) {
        if (i == 6) {
            return 90;
        }
        return i == 3 ? CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 : i == 8 ? 270 : 0;
    }

    /* renamed from: a */
    private Bitmap m8896a(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 3;
        AssetFileDescriptor openAssetFileDescriptor = getActivity().getContentResolver().openAssetFileDescriptor(uri, "r");
        Matrix matrix = new Matrix();
        try {
            int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
            int a = m8895a(attributeInt);
            if (((float) attributeInt) != 0.0f) {
                matrix.preRotate((float) a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor.getFileDescriptor(), (Rect) null, options);
        return Bitmap.createBitmap(decodeFileDescriptor, 0, 0, decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight(), matrix, true);
    }

    /* renamed from: c */
    private void m8897c() {
        this.f7159c = (ImageButton) this.f7158b.findViewById(C3076d.C3080d.cameraButton);
        this.f7159c.setOnClickListener(new C3072a());
        this.f7160d = (ImageButton) this.f7158b.findViewById(C3076d.C3080d.selectButton);
        this.f7160d.setOnClickListener(new C3073b());
    }

    /* renamed from: d */
    private void m8898d() {
        try {
            for (File delete : new File(C3102f.f7202a).listFiles()) {
                delete.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private File m8899e() {
        m8898d();
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String str = C3102f.f7202a;
        File file = new File(str, "IMG_" + format + ".jpg");
        this.f7161e = Uri.fromFile(file);
        return file;
    }

    /* renamed from: a */
    public void mo23937a() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23938a(Bitmap bitmap) {
        Uri a = C3111i.m8940a((Context) getActivity(), bitmap);
        bitmap.recycle();
        this.f7162f.mo23926a(a);
    }

    /* renamed from: b */
    public void mo23939b() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File e = m8899e();
        boolean mkdirs = e.getParentFile().mkdirs();
        Log.d("", "openCamera: isDirectoryCreated: " + mkdirs);
        intent.putExtra("output", Build.VERSION.SDK_INT >= 24 ? FileProvider.m2082a(getActivity().getApplicationContext(), "com.cyberneid.disigoncie.fileprovider", e) : Uri.fromFile(e));
        startActivityForResult(intent, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033 A[Catch:{ Exception -> 0x0039 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onActivityResult"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r0 = -1
            if (r5 != r0) goto L_0x003e
            switch(r4) {
                case 1: goto L_0x0026;
                case 2: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x002f
        L_0x001d:
            android.net.Uri r4 = r3.f7161e     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap r4 = r3.m8896a((android.net.Uri) r4)     // Catch:{ Exception -> 0x0039 }
        L_0x0023:
            r3.f7157a = r4     // Catch:{ Exception -> 0x0039 }
            goto L_0x002f
        L_0x0026:
            android.net.Uri r4 = r6.getData()     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap r4 = r3.m8896a((android.net.Uri) r4)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0023
        L_0x002f:
            android.graphics.Bitmap r4 = r3.f7157a     // Catch:{ Exception -> 0x0039 }
            if (r4 == 0) goto L_0x0045
            android.graphics.Bitmap r4 = r3.f7157a     // Catch:{ Exception -> 0x0039 }
            r3.mo23938a((android.graphics.Bitmap) r4)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0045
        L_0x0039:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0045
        L_0x003e:
            android.app.Activity r4 = r3.getActivity()
            r4.finish()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scanlibrary.C3070b.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C3069a) {
            this.f7162f = (C3069a) activity;
            return;
        }
        throw new ClassCastException("Activity must implement IScanner");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        System.out.println("onCreateView");
        this.f7157a = null;
        this.f7158b = layoutInflater.inflate(C3076d.C3081e.pick_image_fragment, (ViewGroup) null);
        m8897c();
        return this.f7158b;
    }

    public void onPause() {
        super.onPause();
        System.out.println("pause");
        this.f7157a = null;
    }

    public void onResume() {
        super.onResume();
        System.out.println("onResume");
        if (this.f7157a == null) {
            mo23939b();
        }
    }
}
