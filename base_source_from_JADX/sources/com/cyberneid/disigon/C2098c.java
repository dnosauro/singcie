package com.cyberneid.disigon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.C0490a;
import androidx.core.content.C0529a;
import com.cyberneid.disigon.C2098c;
import com.cyberneid.disigon.p134b.C2073a;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigon.p134b.C2081e;
import com.cyberneid.disigoncie.R;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.p135d.p136a.C2132a;
import com.p137e.p139b.C2138b;
import p066b.p067a.p068a.p072d.C1366e;

/* renamed from: com.cyberneid.disigon.c */
public abstract class C2098c extends C2072b {

    /* renamed from: h */
    private static int f6526h = 30000;

    /* renamed from: a */
    protected AlertDialog f6527a;

    /* renamed from: b */
    protected AlertDialog f6528b;

    /* renamed from: c */
    protected C1366e f6529c;

    /* renamed from: d */
    protected String f6530d;

    /* renamed from: e */
    protected boolean f6531e;

    /* renamed from: f */
    protected AsyncTask<Void, Void, Void> f6532f;

    /* renamed from: g */
    boolean f6533g = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C2073a f6534i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CancellationSignal f6535j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2116a f6536k;

    /* renamed from: com.cyberneid.disigon.c$a */
    public interface C2116a {
        /* renamed from: a */
        void mo8529a();
    }

    /* renamed from: a */
    private C2073a.C2074a m8321a(final boolean z) {
        return new C2073a.C2074a() {
            /* renamed from: a */
            public void mo8693a(int i, String str) {
                Log.d("BaseNFCActivity", "Help needed - " + str);
                try {
                    if (C2098c.this.f6528b != null && C2098c.this.f6528b.isShowing()) {
                        C2098c.this.f6528b.dismiss();
                    }
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
                if (C2098c.this.f6536k != null) {
                    C2098c.this.f6536k.mo8529a();
                }
            }

            /* renamed from: a */
            public void mo8694a(String str) {
                if (C2098c.this.f6528b != null && C2098c.this.f6528b.isShowing()) {
                    C2098c.this.f6528b.dismiss();
                }
                if (z) {
                    Log.d("BaseNFCActivity", "Success!!! Pass = ######");
                    C2098c cVar = C2098c.this;
                    cVar.f6530d = str;
                    cVar.mo8717a();
                    return;
                }
                Log.d("BaseNFCActivity", "Encrypted pass = " + str);
                C2078b.m8282b("FINGERPRINT_ENABLED", true);
                C2078b.m8282b("FINGERPRINT_ENROLLED", true);
                C2098c cVar2 = C2098c.this;
                C2081e.m8300a((Context) cVar2, cVar2.getResources().getString(R.string.app_name), C2098c.this.getResources().getString(R.string.fingerprint_enabled_message), (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                        if (C2098c.this.f6536k != null) {
                            C2098c.this.f6536k.mo8529a();
                        }
                    }
                });
            }

            /* renamed from: b */
            public void mo8695b(String str) {
                Log.d("BaseNFCActivity", "Failed - " + str);
                try {
                    if (C2098c.this.f6528b != null && C2098c.this.f6528b.isShowing()) {
                        C2098c.this.f6528b.dismiss();
                    }
                    C2098c cVar = C2098c.this;
                    String string = C2098c.this.getResources().getString(R.string.app_name);
                    C2081e.m8300a((Context) cVar, string, C2098c.this.getResources().getString(R.string.fingerprint_error) + " " + str, (C2081e.C2094c) new C2081e.C2094c() {
                        /* renamed from: a */
                        public void mo8543a() {
                            if (C2098c.this.f6536k != null) {
                                C2098c.this.f6536k.mo8529a();
                            }
                            C2098c.this.f6533g = false;
                            C2098c.this.mo8720c();
                        }
                    });
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                    if (C2098c.this.f6536k != null) {
                        C2098c.this.f6536k.mo8529a();
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8323a(Tag tag) {
        if (tag != null) {
            IsoDep isoDep = IsoDep.get(tag);
            isoDep.setTimeout(f6526h);
            try {
                isoDep.connect();
                this.f6529c = new C1366e(isoDep);
                Log.d("BaseNFCActivity", "IAS ok");
                mo8520b();
                this.f6532f.execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m8326b(int i) {
        String str;
        Resources resources;
        int i2;
        String string = getResources().getString(R.string.app_name);
        if (i == 201) {
            resources = getResources();
            i2 = R.string.ge_ok_pin_change;
        } else if (i == 202) {
            resources = getResources();
            i2 = R.string.ge_ok_pin_unlocked;
        } else if (i == 100) {
            resources = getResources();
            i2 = R.string.unable_connect_reader;
        } else if (i == 101) {
            resources = getResources();
            i2 = R.string.not_cie_error;
        } else if (i == 104) {
            resources = getResources();
            i2 = R.string.cie_readfile_error;
        } else if (i == 103) {
            resources = getResources();
            i2 = R.string.cie_lost_error;
        } else {
            if (i == 2 || i == 1) {
                string = getResources().getString(R.string.wrong_pin);
                str = C2125f.m8361a(getApplicationContext(), i);
            } else {
                str = getResources().getString(R.string.error_msg) + " (" + C2138b.m8395a(i) + ")";
            }
            C2081e.m8300a((Context) this, string, str, (C2081e.C2094c) new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                }
            });
        }
        str = resources.getString(i2);
        C2081e.m8300a((Context) this, string, str, (C2081e.C2094c) new C2081e.C2094c() {
            /* renamed from: a */
            public void mo8543a() {
            }
        });
    }

    /* renamed from: d */
    private void m8327d() {
        if (C0529a.m2099b((Context) this, "android.permission.USE_FINGERPRINT") != 0 && !C0490a.m1951a((Activity) this, "android.permission.USE_FINGERPRINT")) {
            C0490a.m1950a(this, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8717a() {
        IllegalStateException illegalStateException;
        try {
            this.f6527a.show();
            C2132a.m8385a(this).enableReaderMode(this, new NfcAdapter.ReaderCallback() {
                /* access modifiers changed from: private */
                /* renamed from: a */
                public /* synthetic */ void m8334a(Tag tag) {
                    C2098c.this.f6527a.dismiss();
                    C2098c.this.m8323a(tag);
                }

                public void onTagDiscovered(Tag tag) {
                    C2098c.this.runOnUiThread(new Runnable(tag) {
                        private final /* synthetic */ Tag f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            C2098c.C210010.this.m8334a(this.f$1);
                        }
                    });
                }
            }, 399, (Bundle) null);
            return;
        } catch (IllegalStateException e) {
            this.f6527a.hide();
            e.printStackTrace();
            illegalStateException = e;
        } catch (Throwable th) {
            this.f6527a.hide();
            th.printStackTrace();
            illegalStateException = th;
        }
        FirebaseCrashlytics.getInstance().recordException(illegalStateException);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8718a(int i) {
        runOnUiThread(new Runnable(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C2098c.this.m8326b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8719a(final C2116a aVar) {
        this.f6536k = aVar;
        if (!this.f6531e) {
            aVar.mo8529a();
        } else if (C0490a.m2099b(getApplicationContext(), "android.permission.USE_FINGERPRINT") != 0) {
            m8327d();
        } else {
            this.f6528b = C2081e.m8294a((Context) this, (C2081e.C2094c) new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                    C2098c.this.f6535j.cancel();
                    aVar.mo8529a();
                }
            });
            try {
                if (!this.f6534i.mo8692b()) {
                    C2081e.m8300a((Context) this, getResources().getString(R.string.fingerprint_error), this.f6534i.mo8687a(), (C2081e.C2094c) new C2081e.C2094c() {
                        /* renamed from: a */
                        public void mo8543a() {
                            C2098c.this.f6528b.dismiss();
                            aVar.mo8529a();
                        }
                    });
                } else if (Build.VERSION.SDK_INT >= 23) {
                    this.f6535j = new CancellationSignal();
                    this.f6534i.mo8690a(this.f6530d, this.f6535j, m8321a(false));
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
                C2081e.m8300a((Context) this, getResources().getString(R.string.fingerprint_error), this.f6534i.mo8687a(), (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                        C2098c.this.f6528b.dismiss();
                        aVar.mo8529a();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo8520b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8720c() {
        if (!this.f6533g || !C2078b.m8280a("FINGERPRINT_ENROLLED", false) || !C2078b.m8280a("FINGERPRINT_ENABLED", false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
            View inflate = LayoutInflater.from(this).inflate(R.layout.input_pin_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.titleDialogMessage);
            final PinEntryEditText pinEntryEditText = (PinEntryEditText) inflate.findViewById(R.id.pinEntry);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkboxFingerprint);
            if (C2078b.m8280a("FINGERPRINT_ENROLLED", false) || !this.f6533g) {
                checkBox.setVisibility(8);
            } else if (C2078b.m8280a("FINGERPRINT_ENABLED", false)) {
                checkBox.setChecked(true);
            }
            textView.setText(getString(R.string.insert_pin));
            builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    C2098c.this.f6531e = checkBox.isChecked();
                    C2098c.this.f6530d = pinEntryEditText.getText().toString();
                    C2098c.this.mo8717a();
                }
            });
            builder.setCancelable(false);
            builder.setView(inflate);
            final AlertDialog create = builder.create();
            pinEntryEditText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (pinEntryEditText.getText().length() != 8) {
                        return false;
                    }
                    create.dismiss();
                    C2098c.this.f6531e = checkBox.isChecked();
                    C2098c.this.f6530d = pinEntryEditText.getText().toString();
                    C2098c.this.mo8717a();
                    return false;
                }
            });
            create.show();
            return;
        }
        this.f6528b = C2081e.m8294a((Context) this, (C2081e.C2094c) new C2081e.C2094c() {
            /* renamed from: a */
            public void mo8543a() {
                C2098c.this.f6535j.cancel();
                C2073a unused = C2098c.this.f6534i = null;
                C2098c cVar = C2098c.this;
                cVar.f6533g = false;
                cVar.mo8720c();
            }
        });
        try {
            if (!this.f6534i.mo8692b()) {
                C2078b.m8282b("FINGERPRINT_ENROLLED", false);
                C2078b.m8282b("FINGERPRINT_ENABLED", false);
                C2081e.m8300a((Context) this, getResources().getString(R.string.fingerprint_error), this.f6534i.mo8687a(), (C2081e.C2094c) new C2081e.C2094c() {
                    /* renamed from: a */
                    public void mo8543a() {
                        C2098c.this.f6528b.dismiss();
                        C2098c.this.mo8720c();
                    }
                });
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.f6535j = new CancellationSignal();
                this.f6534i.mo8689a(this.f6535j, m8321a(true));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            C2081e.m8300a((Context) this, getResources().getString(R.string.fingerprint_error), this.f6534i.mo8687a(), (C2081e.C2094c) new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                    C2098c.this.f6528b.dismiss();
                    C2098c.this.f6536k.mo8529a();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6527a = C2081e.m8295a((Context) this, getResources().getString(R.string.wait_nfc), (C2081e.C2092a) new C2081e.C2092a() {
            /* renamed from: a */
            public void mo8716a() {
                C2132a.m8385a(C2098c.this).disableReaderMode(C2098c.this);
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                this.f6534i = new C2073a(this);
                this.f6533g = this.f6534i.mo8692b();
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
                this.f6534i = null;
                this.f6533g = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f6528b != null && this.f6528b.isShowing()) {
                this.f6528b.dismiss();
                if (this.f6536k != null) {
                    this.f6536k.mo8529a();
                }
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f6527a.dismiss();
        m8323a((Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            NfcAdapter a = C2132a.m8385a(this);
            if (a != null) {
                a.disableReaderMode(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Permission not granted", 1).show();
                setResult(0);
                finish();
                return;
            }
            mo8719a(this.f6536k);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        String str2;
        C2081e.C2094c r2;
        super.onResume();
        NfcAdapter a = C2132a.m8385a(this);
        if (a == null) {
            str = "NFC non presente";
            str2 = "Questo dispositivo mobile non è dotato di sensore NFC";
            r2 = new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                }
            };
        } else if (!a.isEnabled()) {
            str = "NFC non attivato";
            str2 = "Per usare la CIE occorre attivare l'NFC";
            r2 = new C2081e.C2094c() {
                /* renamed from: a */
                public void mo8543a() {
                    C2098c.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                }
            };
        } else {
            return;
        }
        C2081e.m8300a((Context) this, str, str2, r2);
    }
}
