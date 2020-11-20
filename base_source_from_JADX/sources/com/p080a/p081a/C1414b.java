package com.p080a.p081a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0118h;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import com.p080a.p081a.C1407a;

/* renamed from: com.a.a.b */
public class C1414b extends C0118h implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    /* renamed from: a */
    private String f4213a = "RatingDialog";

    /* renamed from: b */
    private SharedPreferences f4214b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f4215c;

    /* renamed from: d */
    private C1417a f4216d;

    /* renamed from: e */
    private TextView f4217e;

    /* renamed from: f */
    private TextView f4218f;

    /* renamed from: g */
    private TextView f4219g;

    /* renamed from: h */
    private TextView f4220h;

    /* renamed from: i */
    private TextView f4221i;

    /* renamed from: j */
    private TextView f4222j;

    /* renamed from: k */
    private RatingBar f4223k;

    /* renamed from: l */
    private ImageView f4224l;

    /* renamed from: m */
    private EditText f4225m;

    /* renamed from: n */
    private LinearLayout f4226n;

    /* renamed from: o */
    private LinearLayout f4227o;

    /* renamed from: p */
    private float f4228p;

    /* renamed from: q */
    private int f4229q;

    /* renamed from: r */
    private boolean f4230r = true;

    /* renamed from: com.a.a.b$a */
    public static class C1417a {

        /* renamed from: a */
        private final Context f4233a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f4234b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f4235c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f4236d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f4237e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f4238f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String f4239g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public String f4240h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public String f4241i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public int f4242j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f4243k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public int f4244l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public int f4245m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public int f4246n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public int f4247o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public int f4248p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public int f4249q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public C1420c f4250r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public C1421d f4251s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public C1418a f4252t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public C1419b f4253u;
        /* access modifiers changed from: private */

        /* renamed from: v */
        public Drawable f4254v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public int f4255w = 1;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public float f4256x = 1.0f;

        /* renamed from: com.a.a.b$a$a */
        public interface C1418a {
            /* renamed from: a */
            void mo6884a(String str);
        }

        /* renamed from: com.a.a.b$a$b */
        public interface C1419b {
            /* renamed from: a */
            void mo6885a(float f, boolean z);
        }

        /* renamed from: com.a.a.b$a$c */
        public interface C1420c {
            /* renamed from: a */
            void mo6871a(C1414b bVar, float f, boolean z);
        }

        /* renamed from: com.a.a.b$a$d */
        public interface C1421d {
            /* renamed from: a */
            void mo6872a(C1414b bVar, float f, boolean z);
        }

        public C1417a(Context context) {
            this.f4233a = context;
            this.f4237e = "market://details?id=" + context.getPackageName();
            m5365b();
        }

        /* renamed from: b */
        private void m5365b() {
            this.f4234b = this.f4233a.getString(C1407a.C1413f.rating_dialog_experience);
            this.f4235c = this.f4233a.getString(C1407a.C1413f.rating_dialog_maybe_later);
            this.f4236d = this.f4233a.getString(C1407a.C1413f.rating_dialog_never);
            this.f4238f = this.f4233a.getString(C1407a.C1413f.rating_dialog_feedback_title);
            this.f4239g = this.f4233a.getString(C1407a.C1413f.rating_dialog_submit);
            this.f4240h = this.f4233a.getString(C1407a.C1413f.rating_dialog_cancel);
            this.f4241i = this.f4233a.getString(C1407a.C1413f.rating_dialog_suggestions);
        }

        /* renamed from: a */
        public C1417a mo6873a(float f) {
            this.f4256x = f;
            return this;
        }

        /* renamed from: a */
        public C1417a mo6874a(int i) {
            this.f4255w = i;
            return this;
        }

        /* renamed from: a */
        public C1417a mo6875a(C1418a aVar) {
            this.f4252t = aVar;
            return this;
        }

        /* renamed from: a */
        public C1417a mo6876a(String str) {
            this.f4234b = str;
            return this;
        }

        /* renamed from: a */
        public C1414b mo6877a() {
            return new C1414b(this.f4233a, this);
        }

        /* renamed from: b */
        public C1417a mo6878b(String str) {
            this.f4235c = str;
            return this;
        }

        /* renamed from: c */
        public C1417a mo6879c(String str) {
            this.f4236d = str;
            return this;
        }

        /* renamed from: d */
        public C1417a mo6880d(String str) {
            this.f4238f = str;
            return this;
        }

        /* renamed from: e */
        public C1417a mo6881e(String str) {
            this.f4241i = str;
            return this;
        }

        /* renamed from: f */
        public C1417a mo6882f(String str) {
            this.f4239g = str;
            return this;
        }

        /* renamed from: g */
        public C1417a mo6883g(String str) {
            this.f4240h = str;
            return this;
        }
    }

    public C1414b(Context context, C1417a aVar) {
        super(context);
        this.f4215c = context;
        this.f4216d = aVar;
        this.f4229q = aVar.f4255w;
        this.f4228p = aVar.f4256x;
    }

    /* renamed from: a */
    private void m5350a() {
        int i;
        Context context;
        int i2;
        Context context2;
        int i3;
        Context context3;
        int i4;
        Context context4;
        this.f4217e.setText(this.f4216d.f4234b);
        this.f4219g.setText(this.f4216d.f4235c);
        this.f4218f.setText(this.f4216d.f4236d);
        this.f4220h.setText(this.f4216d.f4238f);
        this.f4221i.setText(this.f4216d.f4239g);
        this.f4222j.setText(this.f4216d.f4240h);
        this.f4225m.setHint(this.f4216d.f4241i);
        TypedValue typedValue = new TypedValue();
        this.f4215c.getTheme().resolveAttribute(C1407a.C1409b.colorAccent, typedValue, true);
        int i5 = typedValue.data;
        TextView textView = this.f4217e;
        if (this.f4216d.f4244l != 0) {
            context = this.f4215c;
            i = this.f4216d.f4244l;
        } else {
            context = this.f4215c;
            i = C1407a.C1410c.black;
        }
        textView.setTextColor(C0529a.m2102c(context, i));
        this.f4219g.setTextColor(this.f4216d.f4242j != 0 ? C0529a.m2102c(this.f4215c, this.f4216d.f4242j) : i5);
        TextView textView2 = this.f4218f;
        if (this.f4216d.f4243k != 0) {
            context2 = this.f4215c;
            i2 = this.f4216d.f4243k;
        } else {
            context2 = this.f4215c;
            i2 = C1407a.C1410c.grey_500;
        }
        textView2.setTextColor(C0529a.m2102c(context2, i2));
        TextView textView3 = this.f4220h;
        if (this.f4216d.f4244l != 0) {
            context3 = this.f4215c;
            i3 = this.f4216d.f4244l;
        } else {
            context3 = this.f4215c;
            i3 = C1407a.C1410c.black;
        }
        textView3.setTextColor(C0529a.m2102c(context3, i3));
        TextView textView4 = this.f4221i;
        if (this.f4216d.f4242j != 0) {
            i5 = C0529a.m2102c(this.f4215c, this.f4216d.f4242j);
        }
        textView4.setTextColor(i5);
        TextView textView5 = this.f4222j;
        if (this.f4216d.f4243k != 0) {
            context4 = this.f4215c;
            i4 = this.f4216d.f4243k;
        } else {
            context4 = this.f4215c;
            i4 = C1407a.C1410c.grey_500;
        }
        textView5.setTextColor(C0529a.m2102c(context4, i4));
        if (this.f4216d.f4247o != 0) {
            this.f4225m.setTextColor(C0529a.m2102c(this.f4215c, this.f4216d.f4247o));
        }
        if (this.f4216d.f4248p != 0) {
            this.f4219g.setBackgroundResource(this.f4216d.f4248p);
            this.f4221i.setBackgroundResource(this.f4216d.f4248p);
        }
        if (this.f4216d.f4249q != 0) {
            this.f4218f.setBackgroundResource(this.f4216d.f4249q);
            this.f4222j.setBackgroundResource(this.f4216d.f4249q);
        }
        if (this.f4216d.f4245m != 0) {
            if (Build.VERSION.SDK_INT > 19) {
                LayerDrawable layerDrawable = (LayerDrawable) this.f4223k.getProgressDrawable();
                layerDrawable.getDrawable(2).setColorFilter(C0529a.m2102c(this.f4215c, this.f4216d.f4245m), PorterDuff.Mode.SRC_ATOP);
                layerDrawable.getDrawable(1).setColorFilter(C0529a.m2102c(this.f4215c, this.f4216d.f4245m), PorterDuff.Mode.SRC_ATOP);
                layerDrawable.getDrawable(0).setColorFilter(C0529a.m2102c(this.f4215c, this.f4216d.f4246n != 0 ? this.f4216d.f4246n : C1407a.C1410c.grey_200), PorterDuff.Mode.SRC_ATOP);
            } else {
                C0595a.m2317a(this.f4223k.getProgressDrawable(), C0529a.m2102c(this.f4215c, this.f4216d.f4245m));
            }
        }
        Drawable applicationIcon = this.f4215c.getPackageManager().getApplicationIcon(this.f4215c.getApplicationInfo());
        ImageView imageView = this.f4224l;
        if (this.f4216d.f4254v != null) {
            applicationIcon = this.f4216d.f4254v;
        }
        imageView.setImageDrawable(applicationIcon);
        this.f4223k.setOnRatingBarChangeListener(this);
        this.f4219g.setOnClickListener(this);
        this.f4218f.setOnClickListener(this);
        this.f4221i.setOnClickListener(this);
        this.f4222j.setOnClickListener(this);
        if (this.f4229q == 1) {
            this.f4218f.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5351a(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f4216d.f4237e)));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "Couldn't find PlayStore on this device", 0).show();
        }
    }

    /* renamed from: a */
    private boolean m5353a(int i) {
        SharedPreferences.Editor edit;
        String str;
        int i2;
        if (i == 1) {
            return true;
        }
        this.f4214b = this.f4215c.getSharedPreferences(this.f4213a, 0);
        if (this.f4214b.getBoolean("show_never", false)) {
            return false;
        }
        int i3 = this.f4214b.getInt("session_count", 1);
        if (i == i3) {
            SharedPreferences.Editor edit2 = this.f4214b.edit();
            edit2.putInt("session_count", 1);
            edit2.commit();
            return true;
        }
        if (i > i3) {
            i2 = i3 + 1;
            edit = this.f4214b.edit();
            str = "session_count";
        } else {
            edit = this.f4214b.edit();
            str = "session_count";
            i2 = 2;
        }
        edit.putInt(str, i2);
        edit.commit();
        return false;
    }

    /* renamed from: b */
    private void m5354b() {
        C1417a.C1420c unused = this.f4216d.f4250r = new C1417a.C1420c() {
            /* renamed from: a */
            public void mo6871a(C1414b bVar, float f, boolean z) {
                C1414b bVar2 = C1414b.this;
                bVar2.m5351a(bVar2.f4215c);
                C1414b.this.dismiss();
            }
        };
    }

    /* renamed from: c */
    private void m5356c() {
        C1417a.C1421d unused = this.f4216d.f4251s = new C1417a.C1421d() {
            /* renamed from: a */
            public void mo6872a(C1414b bVar, float f, boolean z) {
                C1414b.this.m5357d();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5357d() {
        this.f4220h.setVisibility(0);
        this.f4225m.setVisibility(0);
        this.f4227o.setVisibility(0);
        this.f4226n.setVisibility(8);
        this.f4224l.setVisibility(8);
        this.f4217e.setVisibility(8);
        this.f4223k.setVisibility(8);
    }

    /* renamed from: e */
    private void m5358e() {
        this.f4214b = this.f4215c.getSharedPreferences(this.f4213a, 0);
        SharedPreferences.Editor edit = this.f4214b.edit();
        edit.putBoolean("show_never", true);
        edit.commit();
    }

    public void onClick(View view) {
        if (view.getId() != C1407a.C1411d.dialog_rating_button_negative) {
            if (view.getId() != C1407a.C1411d.dialog_rating_button_positive) {
                if (view.getId() == C1407a.C1411d.dialog_rating_button_feedback_submit) {
                    String trim = this.f4225m.getText().toString().trim();
                    if (TextUtils.isEmpty(trim)) {
                        this.f4225m.startAnimation(AnimationUtils.loadAnimation(this.f4215c, C1407a.C1408a.shake));
                        return;
                    } else if (this.f4216d.f4252t != null) {
                        this.f4216d.f4252t.mo6884a(trim);
                    }
                } else if (view.getId() != C1407a.C1411d.dialog_rating_button_feedback_cancel) {
                    return;
                }
            }
            dismiss();
            return;
        }
        dismiss();
        m5358e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(C1407a.C1412e.dialog_rating);
        this.f4217e = (TextView) findViewById(C1407a.C1411d.dialog_rating_title);
        this.f4218f = (TextView) findViewById(C1407a.C1411d.dialog_rating_button_negative);
        this.f4219g = (TextView) findViewById(C1407a.C1411d.dialog_rating_button_positive);
        this.f4220h = (TextView) findViewById(C1407a.C1411d.dialog_rating_feedback_title);
        this.f4221i = (TextView) findViewById(C1407a.C1411d.dialog_rating_button_feedback_submit);
        this.f4222j = (TextView) findViewById(C1407a.C1411d.dialog_rating_button_feedback_cancel);
        this.f4223k = (RatingBar) findViewById(C1407a.C1411d.dialog_rating_rating_bar);
        this.f4224l = (ImageView) findViewById(C1407a.C1411d.dialog_rating_icon);
        this.f4225m = (EditText) findViewById(C1407a.C1411d.dialog_rating_feedback);
        this.f4226n = (LinearLayout) findViewById(C1407a.C1411d.dialog_rating_buttons);
        this.f4227o = (LinearLayout) findViewById(C1407a.C1411d.dialog_rating_feedback_buttons);
        m5350a();
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (ratingBar.getRating() >= this.f4228p) {
            this.f4230r = true;
            if (this.f4216d.f4250r == null) {
                m5354b();
            }
            this.f4216d.f4250r.mo6871a(this, ratingBar.getRating(), this.f4230r);
        } else {
            this.f4230r = false;
            if (this.f4216d.f4251s == null) {
                m5356c();
            }
            this.f4216d.f4251s.mo6872a(this, ratingBar.getRating(), this.f4230r);
        }
        if (this.f4216d.f4253u != null) {
            this.f4216d.f4253u.mo6885a(ratingBar.getRating(), this.f4230r);
        }
        m5358e();
    }

    public void show() {
        if (m5353a(this.f4229q)) {
            super.show();
        }
    }
}
