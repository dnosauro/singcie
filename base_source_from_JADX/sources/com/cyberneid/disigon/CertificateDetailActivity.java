package com.cyberneid.disigon;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigoncie.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import org.apache.commons.p172io.IOUtils;

public class CertificateDetailActivity extends C2072b {

    /* renamed from: a */
    private AdView f6152a;

    /* renamed from: a */
    private String m7996a(int i) {
        switch (i) {
            case 0:
                return "Digital signature";
            case 1:
                return "Non repudiation";
            case 2:
                return "Key encipherment";
            case 3:
                return "Data encipherment";
            case 4:
                return "Key agreement";
            case 5:
                return "Key cert sign";
            case 6:
                return "cRL sign";
            case 7:
                return "Encipher only";
            case 8:
                return "Decipher only";
            default:
                return "Undefined!";
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_certificate_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6152a = (AdView) findViewById(R.id.adView);
        this.f6152a.loadAd(new AdRequest.Builder().build());
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.certificate_white);
        drawable.setBounds(0, 0, integer, integer);
        getIntent().getStringExtra("subjectName");
        String stringExtra = getIntent().getStringExtra("issuedTo");
        String stringExtra2 = getIntent().getStringExtra("issuedBy");
        String stringExtra3 = getIntent().getStringExtra("validFrom");
        String stringExtra4 = getIntent().getStringExtra("validTo");
        boolean[] booleanArrayExtra = getIntent().getBooleanArrayExtra("keyUsage");
        String stringExtra5 = getIntent().getStringExtra("extendedKeyUsage");
        String str = "";
        if (stringExtra == null || stringExtra2 == null) {
            FirebaseCrashlytics.getInstance().log(getIntent().toString());
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("issuedTo == null || issuedBy == null"));
        }
        ((TextView) findViewById(R.id.certificatesTextView)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        ((TextView) findViewById(R.id.issuedTo)).setText(stringExtra != null ? stringExtra.replace(",", IOUtils.LINE_SEPARATOR_UNIX) : "n.a.");
        ((TextView) findViewById(R.id.issuedBy)).setText(stringExtra2 != null ? stringExtra2.replace(",", IOUtils.LINE_SEPARATOR_UNIX) : "n.a.");
        ((TextView) findViewById(R.id.validFrom)).setText(stringExtra3);
        ((TextView) findViewById(R.id.validTo)).setText(stringExtra4);
        TextView textView = (TextView) findViewById(R.id.keyUsage);
        for (int i = 0; i < booleanArrayExtra.length; i++) {
            if (booleanArrayExtra[i]) {
                str = str + "- " + m7996a(i) + IOUtils.LINE_SEPARATOR_UNIX;
            }
        }
        textView.setText(str);
        ((TextView) findViewById(R.id.extKeyUsage)).setText(stringExtra5);
    }
}
