package com.psaravan.filebrowserview.lib.p153d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.psaravan.filebrowserview.lib.C3043a;
import com.psaravan.filebrowserview.lib.View.C3039a;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import com.psaravan.filebrowserview.lib.p150a.C3049a;
import com.psaravan.filebrowserview.lib.p154e.C3065a;

/* renamed from: com.psaravan.filebrowserview.lib.d.a */
public class C3059a extends C3039a {

    /* renamed from: d */
    private PopupMenu.OnMenuItemClickListener f7125d = new PopupMenu.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == C3043a.C3045b.copy || itemId == C3043a.C3045b.paste || itemId == C3043a.C3045b.move || itemId == C3043a.C3045b.rename) {
                return false;
            }
            int i = C3043a.C3045b.delete;
            return false;
        }
    };

    /* renamed from: e */
    private View.OnClickListener f7126e = new View.OnClickListener() {
        public void onClick(View view) {
            C3059a.this.mo23910a(view);
        }
    };

    /* renamed from: com.psaravan.filebrowserview.lib.d.a$a */
    static class C3062a {

        /* renamed from: a */
        public TextView f7129a;

        /* renamed from: b */
        public TextView f7130b;

        /* renamed from: c */
        public ImageView f7131c;

        /* renamed from: d */
        public ImageButton f7132d;

        /* renamed from: e */
        public TextView f7133e;

        C3062a() {
        }
    }

    public C3059a(Context context, FileBrowserView fileBrowserView, C3049a aVar) {
        super(context, fileBrowserView, aVar.mo23897a());
        this.f7086a = context;
        this.f7087b = aVar;
        this.f7088c = fileBrowserView;
    }

    /* renamed from: a */
    public void mo23910a(View view) {
        PopupMenu popupMenu = new PopupMenu(this.f7086a, view);
        popupMenu.inflate(C3043a.C3047d.filesystem_ops_menu);
        popupMenu.setOnMenuItemClickListener(this.f7125d);
        popupMenu.show();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3062a aVar;
        int i2;
        ImageView imageView;
        int i3;
        int valueOf;
        ImageView imageView2;
        int i4;
        ImageView imageView3;
        int i5;
        int i6 = 4;
        int i7 = 8;
        int i8 = 0;
        if (view == null) {
            view = LayoutInflater.from(this.f7086a).inflate(C3043a.C3046c.list_view_item, viewGroup, false);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.height = (int) C3065a.m8879a(72.0f, this.f7086a);
            view.setLayoutParams(layoutParams);
            aVar = new C3062a();
            aVar.f7131c = (ImageView) view.findViewById(C3043a.C3045b.listViewLeftIcon);
            aVar.f7130b = (TextView) view.findViewById(C3043a.C3045b.listViewSubText);
            aVar.f7129a = (TextView) view.findViewById(C3043a.C3045b.listViewTitleText);
            aVar.f7132d = (ImageButton) view.findViewById(C3043a.C3045b.listViewOverflow);
            aVar.f7133e = (TextView) view.findViewById(C3043a.C3045b.listViewRightSubText);
            aVar.f7133e.setVisibility(4);
            if (!this.f7088c.mo23871d()) {
                ((View) aVar.f7130b.getParent()).setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.f7129a.getLayoutParams();
                layoutParams2.addRule(15);
                aVar.f7129a.setLayoutParams(layoutParams2);
            }
            if (!this.f7088c.mo23869c()) {
                aVar.f7132d.setVisibility(8);
            } else {
                aVar.f7132d.setImageResource(C3043a.C3044a.ic_action_overflow_universal);
                aVar.f7132d.setFocusable(false);
                aVar.f7132d.setFocusableInTouchMode(false);
                aVar.f7132d.setOnClickListener(this.f7126e);
            }
            if (!this.f7088c.mo23872e()) {
                aVar.f7131c.setVisibility(8);
            } else {
                aVar.f7131c.setVisibility(0);
            }
            view.setTag(aVar);
        } else {
            aVar = (C3062a) view.getTag();
        }
        aVar.f7129a.setText(mo23885a().get(i));
        aVar.f7130b.setText(mo23889d().get(i));
        if (this.f7088c.mo23872e()) {
            if (mo23887b().get(i).intValue() == 200) {
                aVar.f7131c.setImageResource(C3043a.C3044a.icon_folderblue);
                i2 = C3043a.C3048e.type;
                valueOf = 200;
            } else {
                if (mo23887b().get(i).intValue() == 0) {
                    imageView2 = aVar.f7131c;
                    i4 = C3043a.C3044a.icon_mp3;
                } else {
                    int i9 = 2;
                    if (mo23887b().get(i).intValue() == 2) {
                        imageView3 = aVar.f7131c;
                        i5 = C3043a.C3044a.icon_png;
                    } else {
                        i9 = 1;
                        if (mo23887b().get(i).intValue() == 1) {
                            imageView3 = aVar.f7131c;
                            i5 = C3043a.C3044a.icon_avi;
                        } else {
                            i9 = 5;
                            if (mo23887b().get(i).intValue() == 5) {
                                imageView3 = aVar.f7131c;
                                i5 = C3043a.C3044a.icon_word;
                            } else {
                                i9 = 7;
                                if (mo23887b().get(i).intValue() == 7) {
                                    imageView3 = aVar.f7131c;
                                    i5 = C3043a.C3044a.icon_ppt;
                                } else {
                                    i9 = 6;
                                    if (mo23887b().get(i).intValue() == 6) {
                                        imageView3 = aVar.f7131c;
                                        i5 = C3043a.C3044a.icon_spreadsheet;
                                    } else {
                                        if (mo23887b().get(i).intValue() == 8) {
                                            imageView = aVar.f7131c;
                                            i3 = C3043a.C3044a.icon_text;
                                        } else {
                                            i8 = 3;
                                            if (mo23887b().get(i).intValue() == 3) {
                                                imageView2 = aVar.f7131c;
                                                i4 = C3043a.C3044a.icon_pdf;
                                            } else {
                                                if (mo23887b().get(i).intValue() == 4) {
                                                    aVar.f7131c.setImageResource(C3043a.C3044a.icon_p7m);
                                                    i2 = C3043a.C3048e.type;
                                                } else {
                                                    i7 = 9;
                                                    if (mo23887b().get(i).intValue() == 9) {
                                                        imageView = aVar.f7131c;
                                                        i3 = C3043a.C3044a.icon_apk;
                                                    } else {
                                                        i7 = 10;
                                                        if (mo23887b().get(i).intValue() == 10) {
                                                            imageView = aVar.f7131c;
                                                            i3 = C3043a.C3044a.icon_archive;
                                                        } else {
                                                            aVar.f7131c.setImageResource(C3043a.C3044a.icon_default);
                                                            i2 = C3043a.C3048e.type;
                                                            i6 = 100;
                                                        }
                                                    }
                                                }
                                                valueOf = Integer.valueOf(i6);
                                            }
                                        }
                                        imageView.setImageResource(i3);
                                        i2 = C3043a.C3048e.type;
                                        valueOf = Integer.valueOf(i7);
                                    }
                                }
                            }
                        }
                    }
                    imageView3.setImageResource(i5);
                    i2 = C3043a.C3048e.type;
                    valueOf = Integer.valueOf(i9);
                }
                imageView2.setImageResource(i4);
                i2 = C3043a.C3048e.type;
                valueOf = Integer.valueOf(i8);
            }
            view.setTag(i2, valueOf);
        }
        view.setTag(C3043a.C3048e.path, mo23888c().get(i));
        return view;
    }
}
