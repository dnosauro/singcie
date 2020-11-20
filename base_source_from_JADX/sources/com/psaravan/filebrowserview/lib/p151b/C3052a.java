package com.psaravan.filebrowserview.lib.p151b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.psaravan.filebrowserview.lib.C3043a;
import com.psaravan.filebrowserview.lib.View.C3039a;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import com.psaravan.filebrowserview.lib.p150a.C3049a;

/* renamed from: com.psaravan.filebrowserview.lib.b.a */
public class C3052a extends C3039a {

    /* renamed from: d */
    private PopupMenu.OnMenuItemClickListener f7113d = new PopupMenu.OnMenuItemClickListener() {
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
    private View.OnClickListener f7114e = new View.OnClickListener() {
        public void onClick(View view) {
            C3052a.this.mo23904a(view);
        }
    };

    /* renamed from: com.psaravan.filebrowserview.lib.b.a$a */
    static class C3055a {

        /* renamed from: a */
        public TextView f7117a;

        /* renamed from: b */
        public TextView f7118b;

        /* renamed from: c */
        public ImageView f7119c;

        /* renamed from: d */
        public ImageButton f7120d;

        C3055a() {
        }
    }

    public C3052a(Context context, FileBrowserView fileBrowserView, C3049a aVar) {
        super(context, fileBrowserView, aVar.mo23897a());
        this.f7086a = context;
        this.f7087b = aVar;
        this.f7088c = fileBrowserView;
    }

    /* renamed from: a */
    public void mo23904a(View view) {
        PopupMenu popupMenu = new PopupMenu(this.f7086a, view);
        popupMenu.inflate(C3043a.C3047d.filesystem_ops_menu);
        popupMenu.setOnMenuItemClickListener(this.f7113d);
        popupMenu.show();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3055a aVar;
        int i2;
        ImageView imageView;
        int i3;
        int valueOf;
        ImageView imageView2;
        int i4;
        int i5 = 8;
        int i6 = 0;
        if (view == null) {
            view = LayoutInflater.from(this.f7086a).inflate(C3043a.C3046c.grid_view_item, viewGroup, false);
            aVar = new C3055a();
            aVar.f7119c = (ImageView) view.findViewById(C3043a.C3045b.gridViewImage);
            aVar.f7118b = (TextView) view.findViewById(C3043a.C3045b.gridViewSubText);
            aVar.f7117a = (TextView) view.findViewById(C3043a.C3045b.gridViewTitleText);
            aVar.f7120d = (ImageButton) view.findViewById(C3043a.C3045b.gridViewOverflowButton);
            if (!this.f7088c.mo23871d()) {
                ((View) aVar.f7118b.getParent()).setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f7117a.getLayoutParams();
                layoutParams.addRule(15);
                aVar.f7117a.setLayoutParams(layoutParams);
            }
            if (!this.f7088c.mo23869c()) {
                aVar.f7120d.setVisibility(8);
            } else {
                aVar.f7120d.setImageResource(C3043a.C3044a.ic_action_overflow_universal);
                aVar.f7120d.setFocusable(false);
                aVar.f7120d.setFocusableInTouchMode(false);
                aVar.f7120d.setOnClickListener(this.f7114e);
            }
            if (!this.f7088c.mo23872e()) {
                aVar.f7119c.setVisibility(8);
            } else {
                aVar.f7119c.setVisibility(0);
            }
            view.setTag(aVar);
        } else {
            aVar = (C3055a) view.getTag();
        }
        aVar.f7117a.setText(mo23885a().get(i));
        aVar.f7118b.setText(mo23889d().get(i));
        if (this.f7088c.mo23872e()) {
            if (mo23887b().get(i).intValue() == 200) {
                aVar.f7119c.setImageResource(C3043a.C3044a.icon_folderblue);
                i2 = C3043a.C3048e.type;
                valueOf = 200;
            } else {
                if (mo23887b().get(i).intValue() == 0) {
                    imageView = aVar.f7119c;
                    i3 = C3043a.C3044a.icon_mp3;
                } else {
                    int i7 = 2;
                    if (mo23887b().get(i).intValue() == 2) {
                        imageView2 = aVar.f7119c;
                        i4 = C3043a.C3044a.icon_png;
                    } else {
                        i7 = 1;
                        if (mo23887b().get(i).intValue() == 1) {
                            imageView2 = aVar.f7119c;
                            i4 = C3043a.C3044a.icon_avi;
                        } else {
                            i7 = 5;
                            if (mo23887b().get(i).intValue() == 5) {
                                imageView2 = aVar.f7119c;
                                i4 = C3043a.C3044a.icon_word;
                            } else {
                                i7 = 7;
                                if (mo23887b().get(i).intValue() == 7) {
                                    imageView2 = aVar.f7119c;
                                    i4 = C3043a.C3044a.icon_ppt;
                                } else {
                                    i7 = 6;
                                    if (mo23887b().get(i).intValue() == 6) {
                                        imageView2 = aVar.f7119c;
                                        i4 = C3043a.C3044a.icon_spreadsheet;
                                    } else {
                                        if (mo23887b().get(i).intValue() == 8) {
                                            aVar.f7119c.setImageResource(C3043a.C3044a.icon_text);
                                            i2 = C3043a.C3048e.type;
                                        } else {
                                            i6 = 3;
                                            if (mo23887b().get(i).intValue() == 3) {
                                                imageView = aVar.f7119c;
                                                i3 = C3043a.C3044a.icon_pdf;
                                            } else {
                                                i6 = 4;
                                                if (mo23887b().get(i).intValue() == 4) {
                                                    imageView = aVar.f7119c;
                                                    i3 = C3043a.C3044a.icon_p7m;
                                                } else {
                                                    i6 = 9;
                                                    if (mo23887b().get(i).intValue() == 9) {
                                                        imageView = aVar.f7119c;
                                                        i3 = C3043a.C3044a.icon_apk;
                                                    } else {
                                                        i6 = 10;
                                                        if (mo23887b().get(i).intValue() == 10) {
                                                            imageView = aVar.f7119c;
                                                            i3 = C3043a.C3044a.icon_archive;
                                                        } else {
                                                            aVar.f7119c.setImageResource(C3043a.C3044a.icon_default);
                                                            i2 = C3043a.C3048e.type;
                                                            i5 = 100;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        valueOf = Integer.valueOf(i5);
                                    }
                                }
                            }
                        }
                    }
                    imageView2.setImageResource(i4);
                    i2 = C3043a.C3048e.type;
                    valueOf = Integer.valueOf(i7);
                }
                imageView.setImageResource(i3);
                i2 = C3043a.C3048e.type;
                valueOf = Integer.valueOf(i6);
            }
            view.setTag(i2, valueOf);
        }
        view.setTag(C3043a.C3048e.path, mo23888c().get(i));
        return view;
    }
}
