package com.github.appintro.internal.viewpager;

import androidx.fragment.app.C0735d;
import androidx.fragment.app.C0750j;
import androidx.fragment.app.C0772n;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class PagerAdapter extends C0772n {
    private final List<C0735d> fragments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerAdapter(@NotNull C0750j jVar, @NotNull List<? extends C0735d> list) {
        super(jVar, 1);
        C3250h.m9056b(jVar, "fragmentManager");
        C3250h.m9056b(list, "fragments");
        this.fragments = list;
    }

    public int getCount() {
        return this.fragments.size();
    }

    @NotNull
    public C0735d getItem(int i) {
        return this.fragments.get(i);
    }
}
