package com.cyberneid.disigon;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigoncie.R;

public class InfoActivity extends C2072b {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_info);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            str = getString(R.string.version_txt) + " " + packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            str = getString(R.string.version_txt) + " " + getString(R.string.no_version_name);
            e.printStackTrace();
        }
        int integer = getResources().getInteger(R.integer.icon_size_info_right);
        Drawable drawable = getResources().getDrawable(R.drawable.info_white);
        drawable.setBounds(0, 0, integer, integer);
        ((TextView) findViewById(R.id.infoTitle)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        ((TextView) findViewById(R.id.version)).setText(str);
        ((TextView) findViewById(R.id.cyberneidTextView)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InfoActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.cyberneid.com")));
            }
        });
    }
}
