package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.C0207r;

public class NavigationSubMenu extends C0207r {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, C0187i iVar) {
        super(context, navigationMenu, iVar);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((C0183g) getParentMenu()).onItemsChanged(z);
    }
}
