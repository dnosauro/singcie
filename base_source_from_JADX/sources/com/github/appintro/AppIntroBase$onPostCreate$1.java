package com.github.appintro;

import androidx.fragment.app.C0735d;

final class AppIntroBase$onPostCreate$1 implements Runnable {
    final /* synthetic */ AppIntroBase this$0;

    AppIntroBase$onPostCreate$1(AppIntroBase appIntroBase) {
        this.this$0 = appIntroBase;
    }

    public final void run() {
        if (AppIntroBase.access$getPagerAdapter$p(this.this$0).getItem(AppIntroBase.access$getPager$p(this.this$0).getCurrentItem()) != null) {
            AppIntroBase appIntroBase = this.this$0;
            appIntroBase.dispatchSlideChangedCallbacks((C0735d) null, AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(this.this$0).getCurrentItem()));
            return;
        }
        this.this$0.finish();
    }
}
