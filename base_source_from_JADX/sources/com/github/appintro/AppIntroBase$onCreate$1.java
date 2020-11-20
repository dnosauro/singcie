package com.github.appintro;

import android.view.View;

final class AppIntroBase$onCreate$1 implements View.OnClickListener {
    final /* synthetic */ AppIntroBase this$0;

    AppIntroBase$onCreate$1(AppIntroBase appIntroBase) {
        this.this$0 = appIntroBase;
    }

    public final void onClick(View view) {
        AppIntroBase.access$getPager$p(this.this$0).goToPreviousSlide();
    }
}
