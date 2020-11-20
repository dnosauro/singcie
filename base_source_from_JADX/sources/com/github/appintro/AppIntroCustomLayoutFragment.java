package com.github.appintro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0735d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class AppIntroCustomLayoutFragment extends C0735d {
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    public static final Companion Companion = new Companion((C3247e) null);
    private int layoutResId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C3247e eVar) {
            this();
        }

        @NotNull
        public final AppIntroCustomLayoutFragment newInstance(int i) {
            AppIntroCustomLayoutFragment appIntroCustomLayoutFragment = new AppIntroCustomLayoutFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AppIntroCustomLayoutFragment.ARG_LAYOUT_RES_ID, i);
            appIntroCustomLayoutFragment.setArguments(bundle);
            return appIntroCustomLayoutFragment;
        }
    }

    @NotNull
    public static final AppIntroCustomLayoutFragment newInstance(int i) {
        return Companion.newInstance(i);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.layoutResId = arguments != null ? arguments.getInt(ARG_LAYOUT_RES_ID) : 0;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C3250h.m9056b(layoutInflater, "inflater");
        return layoutInflater.inflate(this.layoutResId, viewGroup, false);
    }
}
