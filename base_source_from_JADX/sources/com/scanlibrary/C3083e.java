package com.scanlibrary;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.scanlibrary.C3076d;
import java.io.IOException;

/* renamed from: com.scanlibrary.e */
public class C3083e extends Fragment {

    /* renamed from: k */
    private static C3074c f7168k;

    /* renamed from: a */
    private View f7169a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f7170b;

    /* renamed from: c */
    private ImageButton f7171c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bitmap f7172d;

    /* renamed from: e */
    private ImageButton f7173e;

    /* renamed from: f */
    private ImageButton f7174f;

    /* renamed from: g */
    private ImageButton f7175g;

    /* renamed from: h */
    private ImageButton f7176h;

    /* renamed from: i */
    private ImageButton f7177i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Bitmap f7178j;

    /* renamed from: com.scanlibrary.e$a */
    private class C3085a implements View.OnClickListener {
        private C3085a() {
        }

        public void onClick(final View view) {
            C3083e eVar = C3083e.this;
            eVar.mo23951a(eVar.getResources().getString(C3076d.C3082f.applying_filter));
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        Bitmap unused = C3083e.this.f7178j = ((ScanActivity) C3083e.this.getActivity()).getBWBitmap(C3083e.this.f7172d);
                    } catch (OutOfMemoryError e) {
                        C3083e.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                Bitmap unused = C3083e.this.f7178j = C3083e.this.f7172d;
                                C3083e.this.f7170b.setImageBitmap(C3083e.this.f7172d);
                                e.printStackTrace();
                                C3083e.this.mo23949a();
                                C3085a.this.onClick(view);
                            }
                        });
                    }
                    C3083e.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            C3083e.this.f7170b.setImageBitmap(C3083e.this.f7178j);
                            C3083e.this.mo23949a();
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.scanlibrary.e$b */
    private class C3089b implements View.OnClickListener {
        private C3089b() {
        }

        public void onClick(View view) {
            C3083e.this.getFragmentManager().popBackStack();
        }
    }

    /* renamed from: com.scanlibrary.e$c */
    private class C3090c implements View.OnClickListener {
        private C3090c() {
        }

        public void onClick(View view) {
            C3083e eVar = C3083e.this;
            eVar.mo23951a(eVar.getResources().getString(C3076d.C3082f.loading));
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        Intent intent = new Intent();
                        Bitmap a = C3083e.this.f7178j;
                        if (a == null) {
                            a = C3083e.this.f7172d;
                        }
                        intent.setData(C3111i.m8940a((Context) C3083e.this.getActivity(), a));
                        C3083e.this.getActivity().setResult(-1, intent);
                        C3083e.this.f7172d.recycle();
                        System.gc();
                        C3083e.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                C3083e.this.mo23949a();
                                C3083e.this.getActivity().finish();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: com.scanlibrary.e$d */
    private class C3093d implements View.OnClickListener {
        private C3093d() {
        }

        public void onClick(final View view) {
            C3083e eVar = C3083e.this;
            eVar.mo23951a(eVar.getResources().getString(C3076d.C3082f.applying_filter));
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        Bitmap unused = C3083e.this.f7178j = ((ScanActivity) C3083e.this.getActivity()).getGrayBitmap(C3083e.this.f7172d);
                    } catch (OutOfMemoryError e) {
                        C3083e.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                Bitmap unused = C3083e.this.f7178j = C3083e.this.f7172d;
                                C3083e.this.f7170b.setImageBitmap(C3083e.this.f7172d);
                                e.printStackTrace();
                                C3083e.this.mo23949a();
                                C3093d.this.onClick(view);
                            }
                        });
                    }
                    C3083e.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            C3083e.this.f7170b.setImageBitmap(C3083e.this.f7178j);
                            C3083e.this.mo23949a();
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.scanlibrary.e$e */
    private class C3097e implements View.OnClickListener {
        private C3097e() {
        }

        public void onClick(final View view) {
            C3083e eVar = C3083e.this;
            eVar.mo23951a(eVar.getResources().getString(C3076d.C3082f.applying_filter));
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        Bitmap unused = C3083e.this.f7178j = ((ScanActivity) C3083e.this.getActivity()).getMagicColorBitmap(C3083e.this.f7172d);
                    } catch (OutOfMemoryError e) {
                        C3083e.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                Bitmap unused = C3083e.this.f7178j = C3083e.this.f7172d;
                                C3083e.this.f7170b.setImageBitmap(C3083e.this.f7172d);
                                e.printStackTrace();
                                C3083e.this.mo23949a();
                                C3097e.this.onClick(view);
                            }
                        });
                    }
                    C3083e.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            C3083e.this.f7170b.setImageBitmap(C3083e.this.f7178j);
                            C3083e.this.mo23949a();
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.scanlibrary.e$f */
    private class C3101f implements View.OnClickListener {
        private C3101f() {
        }

        public void onClick(View view) {
            try {
                C3083e.this.mo23951a(C3083e.this.getResources().getString(C3076d.C3082f.applying_filter));
                Bitmap unused = C3083e.this.f7178j = C3083e.this.f7172d;
                C3083e.this.f7170b.setImageBitmap(C3083e.this.f7172d);
                C3083e.this.mo23949a();
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                C3083e.this.mo23949a();
            }
        }
    }

    /* renamed from: b */
    private void m8906b() {
        this.f7170b = (ImageView) this.f7169a.findViewById(C3076d.C3080d.scannedImage);
        this.f7173e = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.original);
        this.f7173e.setOnClickListener(new C3101f());
        this.f7174f = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.magicColor);
        this.f7174f.setOnClickListener(new C3097e());
        this.f7175g = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.grayMode);
        this.f7175g.setOnClickListener(new C3093d());
        this.f7177i = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.BWMode);
        this.f7177i.setOnClickListener(new C3085a());
        mo23950a(m8907c());
        this.f7171c = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.doneButton);
        this.f7171c.setOnClickListener(new C3090c());
        this.f7176h = (ImageButton) this.f7169a.findViewById(C3076d.C3080d.cancelButton);
        this.f7176h.setOnClickListener(new C3089b());
    }

    /* renamed from: c */
    private Bitmap m8907c() {
        Uri d = m8909d();
        try {
            this.f7172d = C3111i.m8939a((Context) getActivity(), d);
            getActivity().getContentResolver().delete(d, (String) null, (String[]) null);
            return this.f7172d;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private Uri m8909d() {
        return (Uri) getArguments().getParcelable("scannedResult");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo23949a() {
        f7168k.dismissAllowingStateLoss();
    }

    /* renamed from: a */
    public void mo23950a(Bitmap bitmap) {
        this.f7170b.setImageBitmap(bitmap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo23951a(String str) {
        if (f7168k != null && f7168k.isVisible()) {
            f7168k.dismissAllowingStateLoss();
        }
        f7168k = null;
        f7168k = new C3074c(str);
        f7168k.show(getFragmentManager(), C3074c.class.toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7169a = layoutInflater.inflate(C3076d.C3081e.result_layout, (ViewGroup) null);
        m8906b();
        return this.f7169a;
    }
}
