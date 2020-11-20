package com.cyberneid.disigon.p134b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cyberneid.disigoncie.R;

/* renamed from: com.cyberneid.disigon.b.e */
public class C2081e {

    /* renamed from: com.cyberneid.disigon.b.e$a */
    public interface C2092a {
        /* renamed from: a */
        void mo8716a();
    }

    /* renamed from: com.cyberneid.disigon.b.e$b */
    public interface C2093b {
        /* renamed from: a */
        void mo8552a(boolean z);
    }

    /* renamed from: com.cyberneid.disigon.b.e$c */
    public interface C2094c {
        /* renamed from: a */
        void mo8543a();
    }

    /* renamed from: com.cyberneid.disigon.b.e$d */
    public interface C2095d {
        /* renamed from: a */
        void mo8599a();

        /* renamed from: b */
        void mo8600b();

        /* renamed from: c */
        void mo8601c();
    }

    /* renamed from: com.cyberneid.disigon.b.e$e */
    public interface C2096e {
        /* renamed from: a */
        void mo8558a();

        /* renamed from: b */
        void mo8559b();
    }

    /* renamed from: a */
    public static AlertDialog m8294a(Context context, final C2094c cVar) {
        AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogThemeDark).setPositiveButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                cVar.mo8543a();
            }
        }).create();
        create.setView(LayoutInflater.from(context).inflate(R.layout.dialog_fingerprint, (ViewGroup) null));
        create.setCancelable(false);
        create.show();
        return create;
    }

    /* renamed from: a */
    public static AlertDialog m8295a(Context context, String str, final C2092a aVar) {
        AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogThemeDark).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                aVar.mo8716a();
            }
        }).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_nfc, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.messageDialog)).setText(str);
        create.setView(inflate);
        create.setCancelable(false);
        return create;
    }

    /* renamed from: a */
    public static AlertDialog m8296a(Context context, String str, String str2) {
        AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogTheme).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_progress_bar, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.titleDialog)).setText(str);
        ((TextView) inflate.findViewById(R.id.messageDialog)).setText(str2);
        create.setView(inflate);
        create.setCancelable(false);
        return create;
    }

    /* renamed from: a */
    public static void m8297a(Context context, int i, int i2, final C2094c cVar) {
        AlertDialog create = new AlertDialog.Builder(context, i2).setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                cVar.mo8543a();
            }
        }).create();
        create.setView(LayoutInflater.from(context).inflate(i, (ViewGroup) null));
        create.show();
    }

    /* renamed from: a */
    public static void m8298a(Context context, final C2095d dVar) {
        final AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogThemeDark).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                dVar.mo8601c();
            }
        }).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_select_signature_new, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.pdfImageView);
        View findViewById2 = inflate.findViewById(R.id.p7mImageView);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
                dVar.mo8599a();
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
                dVar.mo8600b();
            }
        });
        create.setView(inflate);
        create.setCancelable(false);
        create.show();
    }

    /* renamed from: a */
    public static void m8299a(Context context, String str, String str2, int i, final C2093b bVar) {
        CharSequence charSequence;
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.messageDialogMessage);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox);
        if (Build.VERSION.SDK_INT >= 26) {
            textView.setJustificationMode(1);
            charSequence = str2;
        } else {
            charSequence = str2;
            if (Build.VERSION.SDK_INT >= 24) {
                charSequence = Html.fromHtml("<p style=\"text-align: justify\">" + str2 + "</p>", 63);
            }
        }
        textView.setText(charSequence);
        AlertDialog create = builder.setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                bVar.mo8552a(checkBox.isChecked());
            }
        }).setTitle(str).setView(inflate).create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    /* renamed from: a */
    public static void m8300a(Context context, String str, String str2, final C2094c cVar) {
        AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogTheme).setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                cVar.mo8543a();
            }
        }).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_message, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.titleDialogMessage)).setText(str);
        ((TextView) inflate.findViewById(R.id.messageDialogMessage)).setText(str2);
        create.setView(inflate);
        create.show();
    }

    /* renamed from: a */
    public static void m8301a(Context context, String str, String str2, final C2096e eVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_message, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.messageDialogMessage)).setText(str2);
        ((TextView) inflate.findViewById(R.id.titleDialogMessage)).setText(str);
        AlertDialog create = builder.setPositiveButton(context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                eVar.mo8558a();
            }
        }).setNegativeButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                eVar.mo8559b();
            }
        }).setView(inflate).create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    /* renamed from: b */
    public static AlertDialog m8302b(Context context, String str, String str2) {
        AlertDialog create = new AlertDialog.Builder(context, R.style.MyDialogTheme).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_message, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.titleDialogMessage)).setText(str);
        ((TextView) inflate.findViewById(R.id.messageDialogMessage)).setText(str2);
        create.setView(inflate);
        return create;
    }
}
