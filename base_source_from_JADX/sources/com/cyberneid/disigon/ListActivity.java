package com.cyberneid.disigon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import com.cyberneid.disigoncie.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p137e.p139b.C2140d;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import com.psaravan.filebrowserview.lib.p152c.C3058a;
import com.wang.avi.AVLoadingIndicatorView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListActivity extends C2072b {

    /* renamed from: a */
    private Context f6227a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2068a f6228b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FileBrowserView f6229c;

    /* renamed from: d */
    private ImageView f6230d;

    /* renamed from: e */
    private ImageView f6231e;

    /* renamed from: f */
    private ImageView f6232f;

    /* renamed from: g */
    private ArrayList<C1986a> f6233g;

    /* renamed from: h */
    private HashMap<String, C1986a> f6234h;

    /* renamed from: i */
    private HashMap<String, File> f6235i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AVLoadingIndicatorView f6236j;

    /* renamed from: k */
    private AdView f6237k;

    /* renamed from: l */
    private C3058a f6238l = new C3058a() {
        /* renamed from: a */
        public void mo8571a(File file) {
            ListActivity.this.setTitle(file.getAbsolutePath());
            ListActivity.this.f6236j.hide();
        }

        /* renamed from: b */
        public void mo8572b(File file) {
            Intent intent;
            Log.d("ListActivity", "onFileOpened");
            String b = C2125f.m8367b(file.getName());
            ListActivity.this.f6228b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, ListActivity.this.getResources().getString(R.string.FRBS_FILE_TO_SIGN), file.getName(), b);
            if (b.equalsIgnoreCase("application/pdf") || file.getName().toLowerCase().contains(".pdf.")) {
                intent = new Intent(ListActivity.this, PDFNativeViewerActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                ListActivity listActivity = ListActivity.this;
                Uri a = FileProvider.m2082a(listActivity, listActivity.getString(R.string.file_provider_authority), file);
                intent.putExtra("android.intent.extra.STREAM", a);
                intent.putExtra("filename", C2125f.m8366b(ListActivity.this, a, b));
                boolean a2 = C2125f.m8364a(ListActivity.this, a, b);
                intent.putExtra("signatureType", "pdf");
                intent.putExtra("isFirstSignature", !a2);
            } else {
                intent = (b.equalsIgnoreCase("application/pkcs7-mime") || b.equalsIgnoreCase("application/x-pkcs7-mime") || file.getName().toLowerCase().contains(".p7m.") || file.getName().toLowerCase().contains(".p7s.")) ? new Intent(ListActivity.this, FileViewerActivity.class) : new Intent(ListActivity.this, FileSignerActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                ListActivity listActivity2 = ListActivity.this;
                Uri a3 = FileProvider.m2082a(listActivity2, listActivity2.getString(R.string.file_provider_authority), file);
                intent.putExtra("android.intent.extra.STREAM", a3);
                boolean a4 = C2125f.m8364a(ListActivity.this, a3, b);
                String b2 = C2125f.m8366b(ListActivity.this, a3, b);
                intent.putExtra("isFirstSignature", !a4);
                intent.putExtra("filename", b2);
            }
            intent.putExtra("signNow", true);
            ListActivity.this.startActivity(intent);
        }

        /* renamed from: c */
        public void mo8573c(File file) {
            Log.d("ListActivity", "onFileFolderOpenFailed");
            ListActivity.this.f6236j.hide();
        }
    };

    /* renamed from: com.cyberneid.disigon.ListActivity$a */
    private static class C1986a {

        /* renamed from: a */
        public String f6246a;

        /* renamed from: b */
        public int f6247b;

        /* renamed from: c */
        public String f6248c;

        /* renamed from: d */
        public String f6249d;

        /* renamed from: e */
        public String f6250e;

        private C1986a() {
        }
    }

    /* renamed from: a */
    private String m8055a(File file) {
        String str;
        String absolutePath = file.getAbsolutePath();
        Map.Entry entry = null;
        for (Map.Entry next : this.f6235i.entrySet()) {
            String path = ((File) next.getValue()).getPath();
            if (absolutePath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                entry = next;
            }
        }
        if (entry != null) {
            String path2 = ((File) entry.getValue()).getPath();
            if (path2.equals(absolutePath)) {
                str = "";
            } else {
                str = absolutePath.substring(path2.endsWith("/") ? path2.length() : path2.length() + 1);
            }
            return ((String) entry.getKey()) + ':' + str;
        }
        throw new FileNotFoundException("Failed to find root that contains " + absolutePath);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050 A[Catch:{ FileNotFoundException -> 0x0108, Exception -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[Catch:{ FileNotFoundException -> 0x0108, Exception -> 0x0130 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m8056a() {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0130 }
            r3.<init>()     // Catch:{ Exception -> 0x0130 }
            r11.f6233g = r3     // Catch:{ Exception -> 0x0130 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0130 }
            r3.<init>()     // Catch:{ Exception -> 0x0130 }
            r11.f6234h = r3     // Catch:{ Exception -> 0x0130 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0130 }
            r3.<init>()     // Catch:{ Exception -> 0x0130 }
            r11.f6235i = r3     // Catch:{ Exception -> 0x0130 }
            com.cyberneid.disigon.b.c r3 = new com.cyberneid.disigon.b.c     // Catch:{ Exception -> 0x0130 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0130 }
            java.util.List r3 = r3.mo8701a()     // Catch:{ Exception -> 0x0130 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0130 }
            r4 = 0
        L_0x0026:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x0130 }
            if (r5 == 0) goto L_0x013b
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0130 }
            com.cyberneid.disigon.b.d r5 = (com.cyberneid.disigon.p134b.C2080d) r5     // Catch:{ Exception -> 0x0130 }
            java.io.File r6 = r5.mo8704c()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = androidx.core.p026d.C0546a.m2167a(r6)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "mounted"
            boolean r8 = r8.equals(r7)     // Catch:{ Exception -> 0x0130 }
            if (r8 != 0) goto L_0x004d
            java.lang.String r8 = "mounted_ro"
            boolean r7 = r8.equals(r7)     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r7 = 0
            goto L_0x004e
        L_0x004d:
            r7 = 1
        L_0x004e:
            if (r7 != 0) goto L_0x0051
            goto L_0x0026
        L_0x0051:
            boolean r7 = r5.f6506b     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x005e
            boolean r7 = r5.f6505a     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x005e
            java.lang.String r5 = "primary"
            java.lang.String r7 = "Memoria Esterna"
            goto L_0x00b0
        L_0x005e:
            java.lang.String r7 = r5.mo8705d()     // Catch:{ Exception -> 0x0130 }
            if (r7 == 0) goto L_0x010f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r7.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "secondary"
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = r5.mo8702a()     // Catch:{ Exception -> 0x0130 }
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r5.mo8702a()     // Catch:{ Exception -> 0x0130 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0130 }
            if (r8 != 0) goto L_0x0084
            goto L_0x00ab
        L_0x0084:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r5.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "Memoria Esterna"
            r5.append(r8)     // Catch:{ Exception -> 0x0130 }
            if (r4 <= 0) goto L_0x00a2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r8.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r9 = " "
            r8.append(r9)     // Catch:{ Exception -> 0x0130 }
            r8.append(r4)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0130 }
            goto L_0x00a4
        L_0x00a2:
            java.lang.String r8 = ""
        L_0x00a4:
            r5.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0130 }
        L_0x00ab:
            int r4 = r4 + 1
            r10 = r7
            r7 = r5
            r5 = r10
        L_0x00b0:
            java.util.HashMap<java.lang.String, java.io.File> r8 = r11.f6235i     // Catch:{ Exception -> 0x0130 }
            boolean r8 = r8.containsKey(r5)     // Catch:{ Exception -> 0x0130 }
            if (r8 == 0) goto L_0x00d5
            java.lang.String r6 = "ListActivity"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r7.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "Duplicate UUID "
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            r7.append(r5)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = "; skipping"
            r7.append(r5)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0130 }
            android.util.Log.w(r6, r5)     // Catch:{ Exception -> 0x0130 }
            goto L_0x0026
        L_0x00d5:
            java.io.File[] r8 = r6.listFiles()     // Catch:{ FileNotFoundException -> 0x0108 }
            if (r8 != 0) goto L_0x00dd
            goto L_0x0026
        L_0x00dd:
            java.util.HashMap<java.lang.String, java.io.File> r8 = r11.f6235i     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.put(r5, r6)     // Catch:{ FileNotFoundException -> 0x0108 }
            com.cyberneid.disigon.ListActivity$a r8 = new com.cyberneid.disigon.ListActivity$a     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.f6246a = r5     // Catch:{ FileNotFoundException -> 0x0108 }
            r9 = 393243(0x6001b, float:5.51051E-40)
            r8.f6247b = r9     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.f6248c = r7     // Catch:{ FileNotFoundException -> 0x0108 }
            java.lang.String r7 = r11.m8055a((java.io.File) r6)     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.f6249d = r7     // Catch:{ FileNotFoundException -> 0x0108 }
            java.lang.String r6 = r6.getPath()     // Catch:{ FileNotFoundException -> 0x0108 }
            r8.f6250e = r6     // Catch:{ FileNotFoundException -> 0x0108 }
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r6 = r11.f6233g     // Catch:{ FileNotFoundException -> 0x0108 }
            r6.add(r8)     // Catch:{ FileNotFoundException -> 0x0108 }
            java.util.HashMap<java.lang.String, com.cyberneid.disigon.ListActivity$a> r6 = r11.f6234h     // Catch:{ FileNotFoundException -> 0x0108 }
            r6.put(r5, r8)     // Catch:{ FileNotFoundException -> 0x0108 }
            goto L_0x0026
        L_0x0108:
            r3 = move-exception
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0130 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0130 }
            throw r4     // Catch:{ Exception -> 0x0130 }
        L_0x010f:
            java.lang.String r6 = "ListActivity"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r7.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r8 = "Missing UUID for "
            r7.append(r8)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r5.mo8703b()     // Catch:{ Exception -> 0x0130 }
            r7.append(r5)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = "; skipping"
            r7.append(r5)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0130 }
            android.util.Log.d(r6, r5)     // Catch:{ Exception -> 0x0130 }
            goto L_0x0026
        L_0x0130:
            r3 = move-exception
            r3.printStackTrace()
            com.google.firebase.crashlytics.FirebaseCrashlytics r4 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r4.recordException(r3)
        L_0x013b:
            java.lang.String r3 = "ListActivity"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "After updating volumes, found "
            r4.append(r5)
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r5 = r11.f6233g
            int r5 = r5.size()
            r4.append(r5)
            java.lang.String r5 = " active roots"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r3 = r11.f6233g
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0174
            java.io.File r3 = new java.io.File
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r4 = r11.f6233g
            java.lang.Object r0 = r4.get(r0)
            com.cyberneid.disigon.ListActivity$a r0 = (com.cyberneid.disigon.ListActivity.C1986a) r0
            java.lang.String r0 = r0.f6250e
            r3.<init>(r0)
            goto L_0x0175
        L_0x0174:
            r3 = r2
        L_0x0175:
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r0 = r11.f6233g
            int r0 = r0.size()
            if (r0 <= r1) goto L_0x018d
            java.io.File r0 = new java.io.File
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r4 = r11.f6233g
            java.lang.Object r1 = r4.get(r1)
            com.cyberneid.disigon.ListActivity$a r1 = (com.cyberneid.disigon.ListActivity.C1986a) r1
            java.lang.String r1 = r1.f6250e
            r0.<init>(r1)
            goto L_0x018e
        L_0x018d:
            r0 = r2
        L_0x018e:
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r1 = r11.f6233g
            int r1 = r1.size()
            r4 = 2
            if (r1 <= r4) goto L_0x01a6
            java.io.File r2 = new java.io.File
            java.util.ArrayList<com.cyberneid.disigon.ListActivity$a> r1 = r11.f6233g
            java.lang.Object r1 = r1.get(r4)
            com.cyberneid.disigon.ListActivity$a r1 = (com.cyberneid.disigon.ListActivity.C1986a) r1
            java.lang.String r1 = r1.f6250e
            r2.<init>(r1)
        L_0x01a6:
            com.cyberneid.disigon.-$$Lambda$ListActivity$NoYXMBTVsl7tyXLN6td9ou5dHRM r1 = new com.cyberneid.disigon.-$$Lambda$ListActivity$NoYXMBTVsl7tyXLN6td9ou5dHRM
            r1.<init>(r0, r2, r3)
            r11.runOnUiThread(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.ListActivity.m8056a():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8057a(final File file, final File file2, final File file3) {
        this.f6236j.hide();
        if (file == null && file2 == null) {
            findViewById(R.id.driverBar).setVisibility(8);
        }
        if (file == null) {
            this.f6231e.setVisibility(8);
        }
        if (file2 == null) {
            this.f6232f.setVisibility(8);
        } else {
            PrintStream printStream = System.out;
            printStream.println("usb " + file2);
        }
        this.f6230d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListActivity.this.f6236j.bringToFront();
                ListActivity.this.f6236j.show();
                try {
                    ListActivity.this.f6229c.mo23863a(file3).mo23865a();
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        });
        this.f6231e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListActivity.this.f6236j.bringToFront();
                ListActivity.this.f6236j.show();
                try {
                    ListActivity.this.f6229c.mo23863a(file).mo23865a();
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        });
        this.f6232f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListActivity.this.f6236j.bringToFront();
                ListActivity.this.f6236j.show();
                try {
                    ListActivity.this.f6229c.mo23863a(file2).mo23865a();
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        });
    }

    public void onBackPressed() {
        FileBrowserView fileBrowserView = this.f6229c;
        if (fileBrowserView != null) {
            try {
                File parentDir = fileBrowserView.getParentDir();
                if (parentDir != null) {
                    try {
                        this.f6229c.getFileBrowserEngine().mo23901a(parentDir);
                        this.f6229c.mo23863a(parentDir);
                        this.f6229c.mo23865a();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                super.onBackPressed();
            } catch (Exception unused) {
                super.onBackPressed();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6228b = new C2068a(this);
        setContentView((int) R.layout.activity_file_browser_view);
        this.f6227a = getApplicationContext();
        this.f6237k = (AdView) findViewById(R.id.adView);
        this.f6237k.loadAd(new AdRequest.Builder().build());
        this.f6229c = (FileBrowserView) findViewById(R.id.fileBrowserView);
        this.f6236j = (AVLoadingIndicatorView) findViewById(R.id.avi);
        try {
            this.f6229c.mo23860a(0).mo23863a(Environment.getExternalStorageDirectory()).mo23864a(true).mo23868c(true).mo23866b(false).mo23870d(true).mo23862a(this.f6238l).mo23865a();
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        this.f6230d = (ImageView) findViewById(R.id.storageImageView);
        this.f6231e = (ImageView) findViewById(R.id.sdImageView);
        this.f6232f = (ImageView) findViewById(R.id.usbImageView);
        this.f6236j.bringToFront();
        this.f6236j.show();
        C2140d.m8401a(new Runnable() {
            public final void run() {
                ListActivity.this.m8056a();
            }
        });
    }
}
