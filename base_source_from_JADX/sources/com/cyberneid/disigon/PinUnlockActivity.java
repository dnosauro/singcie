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
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigon.p133a.C2071c;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;

public class PinUnlockActivity extends C2098c {

    /* renamed from: h */
    private TextView f6414h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Button f6415i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinearLayout f6416j;

    /* renamed from: k */
    private LinearLayout f6417k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PinEntryEditText f6418l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public PinEntryEditText f6419m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public PinEntryEditText f6420n;

    /* renamed from: o */
    private C2068a f6421o;

    /* renamed from: com.cyberneid.disigon.PinUnlockActivity$a */
    private class C2047a implements View.OnClickListener {
        private C2047a() {
        }

        public void onClick(View view) {
            PinUnlockActivity pinUnlockActivity = PinUnlockActivity.this;
            pinUnlockActivity.f6530d = pinUnlockActivity.f6419m.getText().toString();
            if (PinUnlockActivity.this.f6420n.getText().toString().equals(PinUnlockActivity.this.f6419m.getText().toString())) {
                PinUnlockActivity.this.mo8717a();
                return;
            }
            C2081e.m8302b(PinUnlockActivity.this, PinUnlockActivity.this.getResources().getString(R.string.error_msg), PinUnlockActivity.this.getResources().getString(R.string.pin_not_equals)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8203d() {
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.unlock_pin_gray);
        drawable.setBounds(0, 0, integer, integer);
        this.f6415i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f6415i.setTextColor(getResources().getColor(R.color.fontGray));
        this.f6415i.setEnabled(false);
        this.f6416j.setEnabled(false);
        this.f6416j.setBackgroundColor(getResources().getColor(R.color.digitalSignatureBackgroundGray));
        this.f6419m.setText((CharSequence) null);
        this.f6420n.setText((CharSequence) null);
        this.f6418l.setText((CharSequence) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8520b() {
        this.f6532f = new AsyncTask<Void, Void, Void>() {

            /* renamed from: b */
            private int f6430b;

            /* renamed from: c */
            private AlertDialog f6431c;

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                C2071c cVar = new C2071c(PinUnlockActivity.this.getApplicationContext());
                cVar.mo8684a(PinUnlockActivity.this.f6529c);
                this.f6430b = cVar.mo8685b(PinUnlockActivity.this.f6418l.getText().toString(), PinUnlockActivity.this.f6419m.getText().toString());
                return null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(Void voidR) {
                super.onPostExecute(voidR);
                this.f6431c.dismiss();
                PinUnlockActivity.this.mo8718a(this.f6430b);
                PinUnlockActivity.this.m8203d();
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                super.onPreExecute();
                this.f6430b = 0;
                PinUnlockActivity pinUnlockActivity = PinUnlockActivity.this;
                this.f6431c = C2081e.m8296a((Context) pinUnlockActivity, pinUnlockActivity.getResources().getString(R.string.please_wait), PinUnlockActivity.this.getResources().getString(R.string.wait_unlock_pin));
                this.f6431c.show();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pin_unlock);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f6421o = new C2068a(this);
        int integer = getResources().getInteger(R.integer.icon_size_right);
        final Drawable drawable = getResources().getDrawable(R.drawable.unlock_pin_white);
        drawable.setBounds(0, 0, integer, integer);
        final Drawable drawable2 = getResources().getDrawable(R.drawable.unlock_pin_gray);
        drawable2.setBounds(0, 0, integer, integer);
        this.f6418l = (PinEntryEditText) findViewById(R.id.puk_entry);
        this.f6419m = (PinEntryEditText) findViewById(R.id.new_pin_entry);
        this.f6420n = (PinEntryEditText) findViewById(R.id.repeat_pin_entry);
        this.f6418l.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinUnlockActivity.this.f6418l.getText().length() != 8) {
                    return false;
                }
                PinUnlockActivity.this.f6419m.requestFocus();
                return false;
            }
        });
        this.f6419m.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinUnlockActivity.this.f6419m.getText().length() != 8) {
                    return false;
                }
                PinUnlockActivity.this.f6420n.requestFocus();
                return false;
            }
        });
        final C2047a aVar = new C2047a();
        this.f6420n.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (PinUnlockActivity.this.f6420n.getText().length() != 8) {
                    return false;
                }
                aVar.onClick(PinUnlockActivity.this.f6415i);
                return false;
            }
        });
        this.f6414h = (TextView) findViewById(R.id.pinUnlockTextView);
        this.f6414h.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.f6415i = (Button) findViewById(R.id.pinUnlockButton);
        this.f6415i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
        this.f6415i.setOnClickListener(aVar);
        this.f6415i.setEnabled(false);
        this.f6416j = (LinearLayout) findViewById(R.id.pinUnlockLayout);
        this.f6416j.setOnClickListener(aVar);
        this.f6416j.setEnabled(false);
        this.f6417k = (LinearLayout) findViewById(R.id.pinEditLayout);
        this.f6417k.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                boolean z;
                Button button;
                int integer = PinUnlockActivity.this.getResources().getInteger(R.integer.puk_length);
                int integer2 = PinUnlockActivity.this.getResources().getInteger(R.integer.pin_length);
                if (PinUnlockActivity.this.f6418l.getText().toString().length() == integer && PinUnlockActivity.this.f6419m.getText().toString().length() == integer2 && PinUnlockActivity.this.f6420n.getText().toString().length() == PinUnlockActivity.this.f6419m.getText().toString().length()) {
                    PinUnlockActivity.this.f6415i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    PinUnlockActivity.this.f6416j.setBackgroundColor(PinUnlockActivity.this.getResources().getColor(R.color.colorAccent));
                    PinUnlockActivity.this.f6415i.setTextColor(PinUnlockActivity.this.getResources().getColor(R.color.colorPrimary));
                    button = PinUnlockActivity.this.f6415i;
                    z = true;
                } else {
                    PinUnlockActivity.this.f6415i.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
                    PinUnlockActivity.this.f6416j.setBackgroundColor(PinUnlockActivity.this.getResources().getColor(R.color.pinManagerBackgroundGray));
                    PinUnlockActivity.this.f6415i.setTextColor(PinUnlockActivity.this.getResources().getColor(R.color.fontGray));
                    button = PinUnlockActivity.this.f6415i;
                    z = false;
                }
                button.setEnabled(z);
                PinUnlockActivity.this.f6416j.setEnabled(z);
            }
        });
    }
}
