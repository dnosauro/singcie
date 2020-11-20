package com.cyberneid.disigon;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.cyberneid.disigoncie.R;

public class PinManagerActivity extends C2072b {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pin_manager);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        Button button = (Button) findViewById(R.id.unlockPin);
        Button button2 = (Button) findViewById(R.id.changePin);
        int integer = getResources().getInteger(R.integer.icon_size_right);
        Drawable drawable = getResources().getDrawable(R.drawable.lock_password_white);
        drawable.setBounds(0, 0, integer, integer);
        ((TextView) findViewById(R.id.pinManagerTextView)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        int integer2 = getResources().getInteger(R.integer.icon_size_top);
        Drawable drawable2 = getResources().getDrawable(R.drawable.unlock_pin);
        drawable2.setBounds(0, 0, integer2, integer2);
        button.setCompoundDrawables((Drawable) null, drawable2, (Drawable) null, (Drawable) null);
        Drawable drawable3 = getResources().getDrawable(R.drawable.change_pin);
        drawable3.setBounds(0, 0, integer2, integer2);
        button2.setCompoundDrawables((Drawable) null, drawable3, (Drawable) null, (Drawable) null);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PinManagerActivity.this.startActivity(new Intent(view.getContext(), PinChangeActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PinManagerActivity.this.startActivity(new Intent(view.getContext(), PinUnlockActivity.class));
            }
        });
    }
}
