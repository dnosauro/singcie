package com.cyberneid.disigon;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigoncie.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p080a.p081a.C1414b;
import com.parse.ParseObject;
import java.util.Locale;

public class MainActivity extends C2072b {

    /* renamed from: a */
    private Button f6251a;

    /* renamed from: b */
    private Button f6252b;

    /* renamed from: c */
    private Button f6253c;

    /* renamed from: d */
    private Button f6254d;

    /* renamed from: e */
    private ImageView f6255e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2068a f6256f;

    /* renamed from: a */
    private void m8064a(Intent intent) {
        Intent intent2;
        Log.d("MainActivity", "manageIntent " + intent);
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            Log.d("MainActivity", "action: " + action + ", type: " + type);
            if (type == null || (!"android.intent.action.SEND".equals(action) && !"android.intent.action.VIEW".equals(action) && !"android.intent.action.SIGN_AND_RETURN".equals(action))) {
                setIntent((Intent) null);
                if (C2078b.m8280a("FIRST_OPEN", true)) {
                    Log.d("MainActivity", "open intro");
                    intent2 = new Intent(this, DisigonAppIntro.class);
                } else if (!C2078b.m8279a("HELP_VERSION", "0").equals("1.1.5")) {
                    Log.d("MainActivity", "open new version intro");
                    intent2 = new Intent(this, NewsAppIntro.class);
                } else {
                    return;
                }
                startActivity(intent2);
                return;
            }
            this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_RECEIVE_FILE), getResources().getString(R.string.FRBS_RECEIVE_FILE_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
            Uri data = intent.hasExtra("android.intent.extra.STREAM") ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM") : intent.getData();
            Log.d("MainActivity", "Intent " + intent.toString());
            if (data == null) {
                FirebaseCrashlytics.getInstance().log(intent.toString());
                FirebaseCrashlytics.getInstance().log(intent.getExtras().toString());
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("Intent with null URL"));
                return;
            }
            Log.d("MainActivity", "uri " + data.toString());
            if (C2125f.m8364a(this, data, type)) {
                m8065c(intent, data);
            } else {
                m8066d(intent, data);
            }
        }
    }

    /* renamed from: c */
    private void m8065c(Intent intent, Uri uri) {
        if ("application/pdf".equals(intent.getType())) {
            m8067e(intent, uri);
        } else {
            m8068f(intent, uri);
        }
    }

    /* renamed from: d */
    private void m8066d(Intent intent, Uri uri) {
        if ("application/pdf".equals(intent.getType())) {
            mo8574a(intent, uri);
        } else {
            mo8575b(intent, uri);
        }
    }

    /* renamed from: e */
    private void m8067e(Intent intent, Uri uri) {
        C2127h.m8380c("handlePdf4Verify");
        Intent intent2 = new Intent(this, VerifyActivity.class);
        intent2.putExtra("android.intent.extra.STREAM", uri);
        intent2.putExtra("isFirstSignature", false);
        intent2.setAction(intent.getAction());
        intent2.putExtra("filename", C2125f.m8366b(this, uri, intent.getType()));
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        if ("android.intent.action.VERIFY_AND_RETURN".equals(intent.getAction())) {
            startActivityForResult(intent2, 1);
        } else {
            startActivity(intent2);
        }
    }

    /* renamed from: f */
    private void m8068f(Intent intent, Uri uri) {
        C2127h.m8380c("handleFile4Verify");
        Intent intent2 = new Intent(this, VerifyActivity.class);
        intent2.putExtra("android.intent.extra.STREAM", uri);
        intent2.putExtra("isFirstSignature", false);
        intent2.setAction(intent.getAction());
        intent2.putExtra("filename", C2125f.m8366b(this, uri, intent.getType()));
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        if ("android.intent.action.VERIFY_AND_RETURN".equals(intent.getAction())) {
            startActivityForResult(intent2, 1);
        } else {
            startActivity(intent2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8574a(Intent intent, Uri uri) {
        C2127h.m8380c("handlePdf4Sign");
        this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_RECEIVE_PDF), getResources().getString(R.string.FRBS_RECEIVE_PDF_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
        Intent intent2 = new Intent(this, PDFNativeViewerActivity.class);
        intent2.putExtra("android.intent.extra.STREAM", uri);
        intent2.setAction(intent.getAction());
        intent2.putExtra("isFirstSignature", true);
        intent2.putExtra("filename", C2125f.m8366b(this, uri, intent.getType()));
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        if ("android.intent.action.SIGN_AND_RETURN".equals(intent.getAction())) {
            startActivityForResult(intent2, 1);
        } else {
            startActivity(intent2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8575b(Intent intent, Uri uri) {
        C2127h.m8380c("handleFile4Sign");
        this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, getResources().getString(R.string.FRBS_RECEIVE_FILE), getResources().getString(R.string.FRBS_RECEIVE_FILE_NAME), getResources().getString(R.string.FRBS_CONTENT_TYPE_FILE));
        Intent intent2 = new Intent(this, FileSignerActivity.class);
        intent2.putExtra("android.intent.extra.STREAM", uri);
        intent2.setAction(intent.getAction());
        intent2.putExtra("isFirstSignature", true);
        intent2.putExtra("filename", C2125f.m8366b(this, uri, intent.getType()));
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        if ("android.intent.action.SIGN_AND_RETURN".equals(intent.getAction())) {
            startActivityForResult(intent2, 1);
        } else {
            startActivity(intent2);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setTheme(R.style.EizmaTheme);
        super.onCreate(bundle);
        this.f6256f = new C2068a(this);
        this.f6256f.mo8672a(FirebaseAnalytics.Event.APP_OPEN);
        setContentView((int) R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().mo734a(false);
        this.f6255e = (ImageView) findViewById(R.id.info);
        this.f6255e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(view.getContext(), InfoActivity.class));
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.logo);
        int integer = getResources().getInteger(R.integer.icon_size_top);
        Drawable drawable = getResources().getDrawable(R.drawable.hand_sign);
        drawable.setBounds(0, 0, integer, integer);
        Drawable drawable2 = getResources().getDrawable(R.drawable.certificate_white);
        drawable2.setBounds(0, 0, integer, integer);
        Drawable drawable3 = getResources().getDrawable(R.drawable.lock_password_white);
        drawable3.setBounds(0, 0, integer, integer);
        this.f6251a = (Button) findViewById(R.id.digitalSignatureButton);
        this.f6251a.setCompoundDrawables((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        this.f6251a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, MainActivity.this.getResources().getString(R.string.FRBS_DIGITAL_SIGNATURE_BUTTON), MainActivity.this.getResources().getString(R.string.FRBS_DIGITAL_SIGNATURE_BUTTON_NAME), MainActivity.this.getResources().getString(R.string.FRBS_CONTENT_TYPE_BUTTON));
                C2127h.m8380c("OPEN DigitalSignatureActivity");
                MainActivity.this.startActivity(new Intent(view.getContext(), DigitalSignatureActivity.class));
                Log.d("MainActivity", "on click");
            }
        });
        this.f6252b = (Button) findViewById(R.id.certificatesButton);
        this.f6252b.setCompoundDrawables((Drawable) null, drawable2, (Drawable) null, (Drawable) null);
        this.f6252b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, MainActivity.this.getResources().getString(R.string.FRBS_CERTIFICATES_BUTTON), MainActivity.this.getResources().getString(R.string.FRBS_CERTIFICATES_BUTTON_NAME), MainActivity.this.getResources().getString(R.string.FRBS_CONTENT_TYPE_BUTTON));
                C2127h.m8380c("OPEN CertificatesActivity");
                MainActivity.this.startActivity(new Intent(view.getContext(), CertificatesActivity.class));
                Log.d("MainActivity", "on click");
            }
        });
        this.f6253c = (Button) findViewById(R.id.pinManagerButton);
        this.f6253c.setCompoundDrawables((Drawable) null, drawable3, (Drawable) null, (Drawable) null);
        this.f6253c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, MainActivity.this.getResources().getString(R.string.FRBS_PIN_MANAGER_BUTTON), MainActivity.this.getResources().getString(R.string.FRBS_PIN_MANAGER_BUTTON_NAME), MainActivity.this.getResources().getString(R.string.FRBS_CONTENT_TYPE_BUTTON));
                C2127h.m8380c("OPEN PinManagerActivity");
                MainActivity.this.startActivity(new Intent(view.getContext(), PinManagerActivity.class));
                Log.d("MainActivity", "on click");
            }
        });
        Drawable drawable4 = getResources().getDrawable(R.drawable.settings_white);
        drawable4.setBounds(0, 0, integer, integer);
        this.f6254d = (Button) findViewById(R.id.settingsButton);
        this.f6254d.setCompoundDrawables((Drawable) null, drawable4, (Drawable) null, (Drawable) null);
        this.f6254d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.f6256f.mo8673a(FirebaseAnalytics.Event.SELECT_CONTENT, MainActivity.this.getResources().getString(R.string.FRBS_SETTINGS_BUTTON), MainActivity.this.getResources().getString(R.string.FRBS_SETTINGS_BUTTON_NAME), MainActivity.this.getResources().getString(R.string.FRBS_CONTENT_TYPE_BUTTON));
                C2127h.m8380c("OPEN SettingsActivity");
                MainActivity.this.startActivity(new Intent(view.getContext(), SettingsActivity.class));
            }
        });
        new C1414b.C1417a(this).mo6873a(3.0f).mo6874a(6).mo6876a("Come è stata la tua esperienza con Firmo con CIE?").mo6880d("Invia suggerimenti").mo6881e("Dicci come possiamo miglioare l'app").mo6882f("Invia").mo6883g("Annulla").mo6878b("Non Ora").mo6879c("Mai").mo6875a((C1414b.C1417a.C1418a) new C1414b.C1417a.C1418a() {
            /* renamed from: a */
            public void mo6884a(String str) {
                ParseObject create = ParseObject.create("Feedback");
                create.put("feedback", str);
                create.put("deviceId", MainApplication.m8079e());
                create.put("model", MainApplication.m8078d());
                create.put("type", "Android");
                create.put("brand", Build.BRAND);
                create.put("device", Build.DEVICE);
                create.put("product", Build.PRODUCT);
                create.put("board", Build.BOARD);
                create.put("serial", Build.SERIAL);
                create.put("country", Locale.getDefault().getCountry());
                create.saveInBackground();
            }
        }).mo6877a().show();
        m8064a(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("MainActivity", "onNewIntent " + intent);
        m8064a(intent);
    }
}
