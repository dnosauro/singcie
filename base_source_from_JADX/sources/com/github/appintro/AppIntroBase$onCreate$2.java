package com.github.appintro;

import android.view.View;

final class AppIntroBase$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ AppIntroBase this$0;

    AppIntroBase$onCreate$2(AppIntroBase appIntroBase) {
        this.this$0 = appIntroBase;
    }

    public final void onClick(View view) {
        this.this$0.dispatchVibration();
        AppIntroBase appIntroBase = this.this$0;
        appIntroBase.onSkipPressed(AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(this.this$0).getCurrentItem()));
    }
}
