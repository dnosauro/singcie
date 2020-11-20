package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* renamed from: androidx.appcompat.view.menu.m */
public interface C0198m {

    /* renamed from: androidx.appcompat.view.menu.m$a */
    public interface C0199a {
        /* renamed from: a */
        void mo914a(C0183g gVar, boolean z);

        /* renamed from: a */
        boolean mo915a(C0183g gVar);
    }

    boolean collapseItemActionView(C0183g gVar, C0187i iVar);

    boolean expandItemActionView(C0183g gVar, C0187i iVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, C0183g gVar);

    void onCloseMenu(C0183g gVar, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(C0207r rVar);

    void setCallback(C0199a aVar);

    void updateMenuView(boolean z);
}
