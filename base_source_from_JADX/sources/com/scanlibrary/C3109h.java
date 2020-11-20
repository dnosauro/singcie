package com.scanlibrary;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

@SuppressLint({"ValidFragment"})
/* renamed from: com.scanlibrary.h */
public class C3109h extends DialogFragment {

    /* renamed from: a */
    protected int f7219a;

    /* renamed from: b */
    protected String f7220b;

    /* renamed from: c */
    protected String f7221c;

    /* renamed from: d */
    protected boolean f7222d;

    public C3109h(int i, String str, String str2, boolean z) {
        this.f7219a = i;
        this.f7220b = str;
        this.f7221c = str2;
        this.f7222d = z;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(this.f7221c).setCancelable(this.f7222d).setMessage(this.f7220b).setPositiveButton(this.f7219a, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create();
    }
}
