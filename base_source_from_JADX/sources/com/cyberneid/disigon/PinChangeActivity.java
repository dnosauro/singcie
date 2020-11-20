package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigon.p133a.C2071c;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class PinChangeActivity extends C2098c {

    /* renamed from: h */
    private TextView f6377h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Button f6378i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinearLayout f6379j;

    /* renamed from: k */
    private LinearLayout f6380k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PinEntryEditText f6381l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public PinEntryEditText f6382m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public PinEntryEditText f6383n;

    /* renamed from: o */
    private ProgressBar f6384o;

    /* renamed from: p */
    private C2068a f6385p;

    /* renamed from: q */
    private AdView f6386q;

    /* renamed from: com.cyberneid.disigon.PinChangeActivity$a */
    private class C2037a implements View.OnClickListener {
        private C2037a() {
        }

        public void onClick(View view) {
            PinChangeActivity pinChangeActivity = PinChangeActivity.this;
            pinChangeActivity.f6530d = pinChangeActivity.f6381l.getText().toString();
            if (PinChangeActivity.this.f6383n.getText().toString().equals(PinChangeActivity.this.f6382m.getText().toString())) {
                PinChangeActivity.this.mo8717a();
                return;
            }
            C2081e.m8302b(PinChangeActivity.this, PinChangeActivity.this.getResources().getString(R.string.error_msg), PinChangeActivity.this.getResources().getString(R.string.pin_not_equals)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8189d() {
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.change_pin_gray);
        drawable.setBounds(0, 0, integer, integer);
        this.f6378i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f6378i.setTextColor(getResources().getColor(R.color.fontGray));
        this.f6378i.setEnabled(false);
        this.f6379j.setEnabled(false);
        this.f6379j.setBackgroundColor(getResources().getColor(R.color.pinManagerBackgroundGray));
        this.f6383n.setText((CharSequence) null);
        this.f6382m.setText((CharSequence) null);
        this.f6381l.setText((CharSequence) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8520b() {
        this.f6532f = new AsyncTask<Void, Void, Void>() {

            /* renamed from: b */
            private AlertDialog f6395b;

            /* renamed from: c */
            private int f6396c;

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                C2071c cVar = new C2071c(PinChangeActivity.this.getApplicationContext());
                cVar.mo8684a(PinChangeActivity.this.f6529c);
                this.f6396c = cVar.mo8683a(PinChangeActivity.this.f6381l.getText().toString(), PinChangeActivity.this.f6382m.getText().toString());
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(Void voidR) {
                super.onPostExecute(voidR);
                this.f6395b.dismiss();
                PinChangeActivity.this.mo8718a(this.f6396c);
                PinChangeActivity.this.m8189d();
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                PinChangeActivity pinChangeActivity = PinChangeActivity.this;
                this.f6395b = C2081e.m8296a((Context) pinChangeActivity, pinChangeActivity.getResources().getString(R.string.please_wait), PinChangeActivity.this.getResources().getString(R.string.wait_change_pin));
                this.f6395b.show();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pin_change);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6386q = (AdView) findViewById(R.id.adView);
        this.f6386q.loadAd(new AdRequest.Builder().build());
        this.f6385p = new C2068a(this);
        this.f6384o = (ProgressBar) findViewById(R.id.progressBar);
        int integer = getResources().getInteger(R.integer.icon_size_right);
        final Drawable drawable = getResources().getDrawable(R.drawable.change_pin_white);
        drawable.setBounds(0, 0, integer, integer);
        final Drawable drawable2 = getResources().getDrawable(R.drawable.change_pin_gray);
        drawable2.setBounds(0, 0, integer, integer);
        this.f6381l = (PinEntryEditText) findViewById(R.id.old_pin_entry);
        this.f6382m = (PinEntryEditText) findViewById(R.id.new_pin_entry);
        this.f6383n = (PinEntryEditText) findViewById(R.id.repeat_pin_entry);
        this.f6381l.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinChangeActivity.this.f6381l.getText().length() != 8) {
                    return false;
                }
                PinChangeActivity.this.f6382m.requestFocus();
                return false;
            }
        });
        this.f6382m.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinChangeActivity.this.f6382m.getText().length() != 8) {
                    return false;
                }
                PinChangeActivity.this.f6383n.requestFocus();
                return false;
            }
        });
        final C2037a aVar = new C2037a();
        this.f6383n.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinChangeActivity.this.f6383n.getText().length() != 8) {
                    return false;
                }
                aVar.onClick(PinChangeActivity.this.f6378i);
                return false;
            }
        });
        this.f6377h = (TextView) findViewById(R.id.pinManagerTextView);
        this.f6377h.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f6378i = (Button) findViewById(R.id.pinChangeButton);
        this.f6378i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
        this.f6378i.setOnClickListener(aVar);
        this.f6378i.setEnabled(false);
        this.f6379j = (LinearLayout) findViewById(R.id.pinChangeLayout);
        this.f6379j.setOnClickListener(aVar);
        this.f6379j.setEnabled(false);
        this.f6380k = (LinearLayout) findViewById(R.id.pinEditLayout);
        this.f6380k.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                boolean z;
                Button button;
                int integer = PinChangeActivity.this.getResources().getInteger(R.integer.pin_length);
                if (PinChangeActivity.this.f6381l.getText().toString().length() == integer && PinChangeActivity.this.f6382m.getText().toString().length() == integer && PinChangeActivity.this.f6383n.getText().toString().length() == PinChangeActivity.this.f6382m.getText().toString().length()) {
                    PinChangeActivity.this.f6378i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    PinChangeActivity.this.f6379j.setBackgroundColor(PinChangeActivity.this.getResources().getColor(R.color.colorAccent));
                    PinChangeActivity.this.f6378i.setTextColor(PinChangeActivity.this.getResources().getColor(R.color.colorPrimary));
                    button = PinChangeActivity.this.f6378i;
                    z = true;
                } else {
                    PinChangeActivity.this.f6378i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
                    PinChangeActivity.this.f6379j.setBackgroundColor(PinChangeActivity.this.getResources().getColor(R.color.pinManagerBackgroundGray));
                    PinChangeActivity.this.f6378i.setTextColor(PinChangeActivity.this.getResources().getColor(R.color.fontGray));
                    button = PinChangeActivity.this.f6378i;
                    z = false;
                }
                button.setEnabled(z);
                PinChangeActivity.this.f6379j.setEnabled(z);
            }
        });
    }
}
