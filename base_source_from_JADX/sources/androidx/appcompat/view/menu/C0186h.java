package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.C0092c;
import androidx.appcompat.view.menu.C0198m;

/* renamed from: androidx.appcompat.view.menu.h */
class C0186h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, C0198m.C0199a {

    /* renamed from: a */
    C0180e f622a;

    /* renamed from: b */
    private C0183g f623b;

    /* renamed from: c */
    private C0092c f624c;

    /* renamed from: d */
    private C0198m.C0199a f625d;

    public C0186h(C0183g gVar) {
        this.f623b = gVar;
    }

    /* renamed from: a */
    public void mo1446a() {
        C0092c cVar = this.f624c;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    /* renamed from: a */
    public void mo1447a(IBinder iBinder) {
        C0183g gVar = this.f623b;
        C0092c.C0093a aVar = new C0092c.C0093a(gVar.getContext());
        this.f622a = new C0180e(aVar.getContext(), C0059a.C0066g.abc_list_menu_item_layout);
        this.f622a.setCallback(this);
        this.f623b.addMenuPresenter(this.f622a);
        aVar.setAdapter(this.f622a.mo1344a(), this);
        View headerView = gVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(gVar.getHeaderIcon()).setTitle(gVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        this.f624c = aVar.create();
        this.f624c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f624c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f624c.show();
    }

    /* renamed from: a */
    public void mo914a(C0183g gVar, boolean z) {
        if (z || gVar == this.f623b) {
            mo1446a();
        }
        C0198m.C0199a aVar = this.f625d;
        if (aVar != null) {
            aVar.mo914a(gVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo915a(C0183g gVar) {
        C0198m.C0199a aVar = this.f625d;
        if (aVar != null) {
            return aVar.mo915a(gVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f623b.performItemAction((C0187i) this.f622a.mo1344a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f622a.onCloseMenu(this.f623b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f624c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f624c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f623b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f623b.performShortcut(i, keyEvent, 0);
    }
}
