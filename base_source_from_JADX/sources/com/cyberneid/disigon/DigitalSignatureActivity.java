package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.C0490a;
import androidx.core.content.FileProvider;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigon.p134b.C2097f;
import com.cyberneid.disigoncie.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DigitalSignatureActivity extends C2072b {

    /* renamed from: a */
    private final int f6169a = 101;

    /* renamed from: b */
    private C2068a f6170b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C2120e f6171c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ArrayList<C2131j> f6172d;

    /* renamed from: e */
    private AdView f6173e;

    /* renamed from: f */
    private final int f6174f = 1;

    /* renamed from: g */
    private final int f6175g = 2;

    /* renamed from: h */
    private final int f6176h = 3;

    /* renamed from: a */
    private void m8009a() {
        if (m8019c()) {
            m8014b();
        } else {
            m8012a(getResources().getString(R.string.cannot_access_to_external_storage));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8011a(File file) {
        String b = C2125f.m8367b(file.getName());
        if (b != null) {
            Intent intent = new Intent(this, VerifyActivity.class);
            intent.setType(b);
            intent.setAction("android.intent.action.SEND");
            Uri a = FileProvider.m2082a(this, getString(R.string.file_provider_authority), file);
            intent.putExtra("android.intent.extra.STREAM", a);
            intent.putExtra("filename", C2125f.m8366b(this, a, b));
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m8012a(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(DigitalSignatureActivity.this, str, 1).show();
            }
        });
    }

    /* renamed from: b */
    private void m8014b() {
        Log.d("DigitalSignActivity", "loading signed file list");
        File b = C2125f.m8365b();
        if (b != null) {
            File[] listFiles = b.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.getName().toLowerCase().endsWith("pdf") || file.getName().toLowerCase().endsWith("p7m");
                }
            });
            if (listFiles != null) {
                this.f6172d.clear();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (File file : listFiles) {
                    long lastModified = file.lastModified();
                    Date date = new Date(lastModified);
                    String name = file.getName();
                    C2131j jVar = new C2131j(name, name.substring(name.length() - 3), simpleDateFormat.format(date), lastModified);
                    Iterator<C2131j> it = this.f6172d.iterator();
                    boolean z = false;
                    int i = 0;
                    while (it.hasNext() && !z) {
                        if (it.next().mo8743d() < jVar.mo8743d()) {
                            z = true;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        this.f6172d.add(i, jVar);
                    } else {
                        this.f6172d.add(jVar);
                    }
                }
            }
        } else {
            m8012a(getResources().getString(R.string.cannot_access_to_external_storage));
        }
        ListView listView = (ListView) findViewById(R.id.signedFilesList);
        if (this.f6171c.isEmpty()) {
            findViewById(R.id.layoutEmptyList).setVisibility(0);
            listView.setVisibility(8);
            return;
        }
        findViewById(R.id.layoutEmptyList).setVisibility(8);
        listView.setVisibility(0);
        this.f6171c.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8016b(File file) {
        Log.i("DigitalSignActivity", "Show file broeser.");
        this.f6170b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_FILE_TO_DELETE), file.getName(), C2125f.m8367b(file.getName()));
        try {
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8018c(File file) {
        Log.d("DigitalSignActivity", "sentToApp");
        String b = C2125f.m8367b(file.getName());
        this.f6170b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_FILE_TO_SEND), file.getName(), b);
        Intent intent = new Intent();
        intent.setType(b);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
        startActivity(Intent.createChooser(intent, getResources().getText(R.string.send_to)));
    }

    /* renamed from: c */
    private boolean m8019c() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8021d(File file) {
        Intent intent;
        Log.d("DigitalSignActivity", "openPreview");
        String b = C2125f.m8367b(file.getName());
        this.f6170b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_FILE_TO_SIGN), file.getName(), b);
        if (b != null) {
            if (b.equalsIgnoreCase("application/pdf") || (file.getName().toLowerCase().endsWith(".p7m") && file.getName().toLowerCase().contains(".pdf"))) {
                intent = new Intent(this, PDFNativeViewerActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("filename", file.getName());
                intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
            } else {
                intent = new Intent(this, FileViewerActivity.class);
                intent.setType(b);
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(this, getString(R.string.file_provider_authority), file));
                intent.putExtra("filename", file.getName());
            }
            startActivity(intent);
        }
    }

    /* renamed from: d */
    private boolean m8022d() {
        int b = C0490a.m2099b((Context) this, "android.permission.READ_EXTERNAL_STORAGE");
        int b2 = C0490a.m2099b((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE");
        final ArrayList arrayList = new ArrayList();
        if (b != 0) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (b2 != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        C2081e.m8297a((Context) this, (int) R.layout.dialog_permission, (int) R.style.MyDialogThemeDark, (C2081e.C2094c) new C2081e.C2094c() {
            /* renamed from: a */
            public void mo8543a() {
                DigitalSignatureActivity digitalSignatureActivity = DigitalSignatureActivity.this;
                List list = arrayList;
                C0490a.m1950a(digitalSignatureActivity, (String[]) list.toArray(new String[list.size()]), 101);
            }
        });
        return false;
    }

    /* renamed from: e */
    private boolean m8023e() {
        int b = C0490a.m2099b((Context) this, "android.permission.CAMERA");
        ArrayList arrayList = new ArrayList();
        if (b != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        C0490a.m1950a(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 101);
        return false;
    }

    /* renamed from: a */
    public void mo8531a(Uri uri) {
        Intent intent;
        Log.d("DigitalSignActivity", "onFileOpened " + uri);
        String type = getContentResolver().getType(uri);
        if (type == null) {
            type = C2125f.m8367b(uri.getLastPathSegment());
        }
        String a = C2097f.m8313a(this, uri);
        if (a == null) {
            a = uri.getLastPathSegment();
        }
        if (type.equalsIgnoreCase("application/pdf") || a.toLowerCase().contains(".pdf.")) {
            intent = new Intent(this, PDFNativeViewerActivity.class);
            intent.setType(type);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("filename", a);
            boolean a2 = C2125f.m8364a(this, uri, type);
            intent.putExtra("signatureType", "pdf");
            intent.putExtra("isFirstSignature", !a2);
        } else {
            intent = (type.equalsIgnoreCase("application/pkcs7-mime") || type.equalsIgnoreCase("application/x-pkcs7-mime") || a.toLowerCase().contains(".p7m.") || a.toLowerCase().contains(".p7s.")) ? new Intent(this, FileViewerActivity.class) : new Intent(this, FileSignerActivity.class);
            intent.setType(type);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("isFirstSignature", !C2125f.m8364a(this, uri, type));
            intent.putExtra("filename", a);
        }
        intent.putExtra("signNow", true);
        startActivity(intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r4.getData() != null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r2, int r3, android.content.Intent r4) {
        /*
            r1 = this;
            super.onActivityResult(r2, r3, r4)
            r0 = -1
            if (r3 != r0) goto L_0x0041
            r3 = 1
            if (r2 != r3) goto L_0x0012
            if (r4 == 0) goto L_0x0041
            android.net.Uri r2 = r4.getData()
            if (r2 == 0) goto L_0x0041
            goto L_0x0017
        L_0x0012:
            r3 = 2
            if (r2 != r3) goto L_0x0024
            if (r4 == 0) goto L_0x0048
        L_0x0017:
            android.net.Uri r2 = r4.getData()
            java.io.PrintStream r3 = java.lang.System.out
            r3.println(r2)
            r1.mo8531a((android.net.Uri) r2)
            goto L_0x0048
        L_0x0024:
            r3 = 3
            if (r2 != r3) goto L_0x0048
            if (r4 == 0) goto L_0x0048
            android.net.Uri r2 = r4.getData()
            if (r2 == 0) goto L_0x0048
            android.net.Uri r2 = r4.getData()
            java.io.PrintStream r3 = java.lang.System.out
            r3.println(r2)
            com.cyberneid.disigon.DigitalSignatureActivity$5 r3 = new com.cyberneid.disigon.DigitalSignatureActivity$5
            r3.<init>(r2)
            com.p137e.p139b.C2140d.m8401a(r3)
            goto L_0x0048
        L_0x0041:
            java.lang.String r2 = "DigitalSignActivity"
            java.lang.String r3 = "User cancelled file browsing {}"
            android.util.Log.d(r2, r3)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.disigon.DigitalSignatureActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6170b = new C2068a(this);
        setContentView((int) R.layout.activity_digital_signature);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6173e = (AdView) findViewById(R.id.adView);
        this.f6173e.loadAd(new AdRequest.Builder().build());
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.hand_sign);
        drawable.setBounds(0, 0, integer, integer);
        ((TextView) findViewById(R.id.digitalSignatureTextView)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f6172d = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.signedFilesList);
        this.f6171c = new C2120e(this, R.layout.item_digital_signature, this.f6172d);
        listView.setAdapter(this.f6171c);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DigitalSignatureActivity.this.m8021d(C2125f.m8371d(((C2131j) DigitalSignatureActivity.this.f6172d.get(i)).mo8740a()));
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                final C2131j jVar = (C2131j) DigitalSignatureActivity.this.f6172d.get(i);
                final String string = DigitalSignatureActivity.this.getResources().getString(R.string.action_open);
                final String string2 = DigitalSignatureActivity.this.getResources().getString(R.string.action_delete);
                final String string3 = DigitalSignatureActivity.this.getResources().getString(R.string.action_share);
                final String string4 = DigitalSignatureActivity.this.getResources().getString(R.string.action_verify);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.MyDialogTheme);
                String[] strArr = {string, string2, string3, string4};
                final String[] strArr2 = strArr;
                final View view2 = view;
                builder.setItems(strArr, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final File d = C2125f.m8371d(jVar.mo8740a());
                        if (strArr2[i].equals(string)) {
                            DigitalSignatureActivity.this.m8021d(d);
                        } else if (strArr2[i].equals(string2)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view2.getContext(), R.style.MyDialogTheme);
                            builder.setTitle(DigitalSignatureActivity.this.getResources().getString(R.string.confirm_delete_action_title));
                            builder.setMessage(DigitalSignatureActivity.this.getResources().getString(R.string.message_confirm_delete_action));
                            builder.setPositiveButton(DigitalSignatureActivity.this.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    DigitalSignatureActivity.this.m8016b(d);
                                    DigitalSignatureActivity.this.f6172d.remove(jVar);
                                    DigitalSignatureActivity.this.f6171c.notifyDataSetChanged();
                                }
                            });
                            builder.setNegativeButton(DigitalSignatureActivity.this.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null);
                            builder.show();
                        } else if (strArr2[i].equals(string3)) {
                            DigitalSignatureActivity.this.m8018c(d);
                        } else if (strArr2[i].equals(string4)) {
                            DigitalSignatureActivity.this.m8011a(d);
                        }
                    }
                });
                builder.setTitle(DigitalSignatureActivity.this.getResources().getString(R.string.digital_signature_long_click_actions_title));
                builder.show();
                return true;
            }
        });
    }

    public void onOpenCamera(View view) {
        if (m8023e()) {
            C2127h.m8380c("SCAN_DOCUMENT");
            startActivityForResult(new Intent(this, ScanDocumentActivity.class), 2);
        }
    }

    public void onOpenDocuments(View view) {
        C2127h.m8380c("OPEN_DOCUMENT");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setFlags(65);
        intent.setType("*/*");
        String[] strArr = {"application/pdf", "image/*"};
        if (strArr.length > 0) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        startActivityForResult(intent, 1);
    }

    public void onOpenFolder(View view) {
        C2127h.m8380c("OPEN_FOLDER");
        startActivityForResult(new Intent(this, ListActivity.class), 1);
    }

    public void onOpenGallery(View view) {
        C2127h.m8380c("OPEN_GALLERY");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(intent, 3);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 101) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                this.f6170b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_EXTERNAL_STORAGE_PERMISSION), getResources().getString(R.string.FRBS_EXTERNAL_STORAGE_PERMISSION_DENIED_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_EXTERNAL_STORAGE_PERMISSION_DENIED));
                m8012a("Impossibile firmare file e visualizzare file firmati");
            } else {
                m8009a();
                Log.i("DigitalSignActivity", "permesso");
                this.f6170b.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_EXTERNAL_STORAGE_PERMISSION), getResources().getString(R.string.FRBS_EXTERNAL_STORAGE_PERMISSION_ALLOWED_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_EXTERNAL_STORAGE_PERMISSION_ALLOWED));
            }
            if (strArr[0] == "android.permission.CAMERA") {
                onOpenCamera((View) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT < 23 || m8022d()) {
            m8009a();
        }
    }
}
