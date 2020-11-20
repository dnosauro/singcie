package com.cyberneid.disigon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.cyberneid.disigoncie.R;
import java.io.File;
import java.util.List;

/* renamed from: com.cyberneid.disigon.e */
public class C2120e extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f6567a;

    /* renamed from: b */
    private int f6568b;

    /* renamed from: c */
    private LayoutInflater f6569c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<C2131j> f6570d;

    /* renamed from: com.cyberneid.disigon.e$a */
    private static class C2124a {

        /* renamed from: a */
        ImageView f6583a;

        /* renamed from: b */
        TextView f6584b;

        /* renamed from: c */
        TextView f6585c;

        /* renamed from: d */
        ImageView f6586d;

        private C2124a() {
        }
    }

    public C2120e(Context context, int i, List<C2131j> list) {
        this.f6568b = i;
        this.f6569c = LayoutInflater.from(context);
        this.f6570d = list;
        this.f6567a = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8352a(File file) {
        Log.i("DigitalSignatureAdapter", "Show file browser.");
        C2125f.m8367b(file.getName());
        try {
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8355b(File file) {
        Log.d("DigitalSignatureAdapter", "sentToApp");
        String b = C2125f.m8367b(file.getName());
        Intent intent = new Intent();
        intent.setType(b);
        intent.setAction("android.intent.action.SEND");
        Context context = this.f6567a;
        intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(context, context.getString(R.string.file_provider_authority), file));
        Context context2 = this.f6567a;
        context2.startActivity(Intent.createChooser(intent, context2.getResources().getText(R.string.send_to)));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8357c(File file) {
        Log.d("DigitalSignatureAdapter", "openPreview");
        String b = C2125f.m8367b(file.getName());
        if (b != null) {
            Intent intent = (b.equalsIgnoreCase("application/pdf") || (file.getName().toLowerCase().endsWith(".p7m") && file.getName().toLowerCase().contains(".pdf"))) ? new Intent(this.f6567a, PDFNativeViewerActivity.class) : new Intent(this.f6567a, FileViewerActivity.class);
            intent.setType(b);
            intent.setAction("android.intent.action.SEND");
            Context context = this.f6567a;
            intent.putExtra("android.intent.extra.STREAM", FileProvider.m2082a(context, context.getString(R.string.file_provider_authority), file));
            intent.putExtra("filename", file.getName());
            this.f6567a.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8359d(File file) {
        String b = C2125f.m8367b(file.getName());
        if (b != null) {
            Intent intent = new Intent(this.f6567a, VerifyActivity.class);
            intent.setType(b);
            intent.setAction("android.intent.action.SEND");
            Context context = this.f6567a;
            Uri a = FileProvider.m2082a(context, context.getString(R.string.file_provider_authority), file);
            String b2 = C2125f.m8366b(this.f6567a, a, b);
            intent.putExtra("android.intent.extra.STREAM", a);
            intent.putExtra("filename", b2);
            this.f6567a.startActivity(intent);
        }
    }

    public int getCount() {
        List<C2131j> list = this.f6570d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        List<C2131j> list = this.f6570d;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f6570d.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        C2124a aVar;
        int i2;
        ImageView imageView;
        C2131j jVar = (C2131j) getItem(i);
        if (jVar != null) {
            if (view == null) {
                view = this.f6569c.inflate(this.f6568b, viewGroup, false);
                aVar = new C2124a();
                aVar.f6583a = (ImageView) view.findViewById(R.id.iconFile);
                aVar.f6584b = (TextView) view.findViewById(R.id.fileSignedName);
                aVar.f6585c = (TextView) view.findViewById(R.id.fileSignedDate);
                aVar.f6586d = (ImageView) view.findViewById(R.id.menu);
                view.setTag(aVar);
            } else {
                aVar = (C2124a) view.getTag();
            }
            if (jVar != null) {
                if (jVar.mo8741b().toUpperCase().equals("PDF")) {
                    imageView = aVar.f6583a;
                    i2 = R.drawable.pdf_file_red;
                } else {
                    imageView = aVar.f6583a;
                    i2 = R.drawable.p7m_file_blu;
                }
                imageView.setImageResource(i2);
                aVar.f6584b.setText(jVar.mo8740a());
                aVar.f6585c.setText(jVar.mo8742c());
                aVar.f6586d.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final C2131j jVar = (C2131j) C2120e.this.f6570d.get(i);
                        final String string = C2120e.this.f6567a.getResources().getString(R.string.action_open);
                        final String string2 = C2120e.this.f6567a.getResources().getString(R.string.action_delete);
                        final String string3 = C2120e.this.f6567a.getResources().getString(R.string.action_share);
                        final String string4 = C2120e.this.f6567a.getResources().getString(R.string.action_verify);
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.MyDialogTheme);
                        String[] strArr = {string, string2, string3, string4};
                        final String[] strArr2 = strArr;
                        final View view2 = view;
                        builder.setItems(strArr, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final File d = C2125f.m8371d(jVar.mo8740a());
                                if (strArr2[i].equals(string)) {
                                    C2120e.this.m8357c(d);
                                } else if (strArr2[i].equals(string2)) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(view2.getContext(), R.style.MyDialogTheme);
                                    builder.setTitle(C2120e.this.f6567a.getResources().getString(R.string.confirm_delete_action_title));
                                    builder.setMessage(C2120e.this.f6567a.getResources().getString(R.string.message_confirm_delete_action));
                                    builder.setPositiveButton(C2120e.this.f6567a.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            C2120e.this.m8352a(d);
                                            C2120e.this.f6570d.remove(jVar);
                                            C2120e.this.notifyDataSetChanged();
                                        }
                                    });
                                    builder.setNegativeButton(C2120e.this.f6567a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null);
                                    builder.show();
                                } else if (strArr2[i].equals(string3)) {
                                    C2120e.this.m8355b(d);
                                } else if (strArr2[i].equals(string4)) {
                                    C2120e.this.m8359d(d);
                                }
                            }
                        });
                        builder.setTitle(C2120e.this.f6567a.getResources().getString(R.string.digital_signature_long_click_actions_title));
                        builder.show();
                    }
                });
            }
        }
        return view;
    }
}
