package androidx.p032d.p033a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.p032d.p033a.C0695b;

/* renamed from: androidx.d.a.a */
public abstract class C0692a extends BaseAdapter implements Filterable, C0695b.C0696a {

    /* renamed from: a */
    protected boolean f2421a;

    /* renamed from: b */
    protected boolean f2422b;

    /* renamed from: c */
    protected Cursor f2423c;

    /* renamed from: d */
    protected Context f2424d;

    /* renamed from: e */
    protected int f2425e;

    /* renamed from: f */
    protected C0693a f2426f;

    /* renamed from: g */
    protected DataSetObserver f2427g;

    /* renamed from: h */
    protected C0695b f2428h;

    /* renamed from: i */
    protected FilterQueryProvider f2429i;

    /* renamed from: androidx.d.a.a$a */
    private class C0693a extends ContentObserver {
        C0693a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            C0692a.this.mo3961b();
        }
    }

    /* renamed from: androidx.d.a.a$b */
    private class C0694b extends DataSetObserver {
        C0694b() {
        }

        public void onChanged() {
            C0692a aVar = C0692a.this;
            aVar.f2421a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            C0692a aVar = C0692a.this;
            aVar.f2421a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public C0692a(Context context, Cursor cursor, boolean z) {
        mo3959a(context, cursor, z ? 1 : 2);
    }

    /* renamed from: a */
    public Cursor mo3958a() {
        return this.f2423c;
    }

    /* renamed from: a */
    public Cursor mo2332a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f2429i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f2423c;
    }

    /* renamed from: a */
    public abstract View mo2334a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3959a(Context context, Cursor cursor, int i) {
        C0694b bVar;
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f2422b = true;
        } else {
            this.f2422b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f2423c = cursor;
        this.f2421a = z;
        this.f2424d = context;
        this.f2425e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f2426f = new C0693a();
            bVar = new C0694b();
        } else {
            bVar = null;
            this.f2426f = null;
        }
        this.f2427g = bVar;
        if (z) {
            C0693a aVar = this.f2426f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2427g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: a */
    public void mo2336a(Cursor cursor) {
        Cursor c = mo3962c(cursor);
        if (c != null) {
            c.close();
        }
    }

    /* renamed from: a */
    public abstract void mo2337a(View view, Context context, Cursor cursor);

    /* renamed from: b */
    public View mo3960b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo2334a(context, cursor, viewGroup);
    }

    /* renamed from: b */
    public CharSequence mo2338b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3961b() {
        Cursor cursor;
        if (this.f2422b && (cursor = this.f2423c) != null && !cursor.isClosed()) {
            this.f2421a = this.f2423c.requery();
        }
    }

    /* renamed from: c */
    public Cursor mo3962c(Cursor cursor) {
        Cursor cursor2 = this.f2423c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0693a aVar = this.f2426f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f2427g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2423c = cursor;
        if (cursor != null) {
            C0693a aVar2 = this.f2426f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f2427g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f2425e = cursor.getColumnIndexOrThrow("_id");
            this.f2421a = true;
            notifyDataSetChanged();
        } else {
            this.f2425e = -1;
            this.f2421a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f2421a || (cursor = this.f2423c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2421a) {
            return null;
        }
        this.f2423c.moveToPosition(i);
        if (view == null) {
            view = mo3960b(this.f2424d, this.f2423c, viewGroup);
        }
        mo2337a(view, this.f2424d, this.f2423c);
        return view;
    }

    public Filter getFilter() {
        if (this.f2428h == null) {
            this.f2428h = new C0695b(this);
        }
        return this.f2428h;
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f2421a || (cursor = this.f2423c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f2423c;
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.f2421a || (cursor = this.f2423c) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.f2423c.getLong(this.f2425e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2421a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2423c.moveToPosition(i)) {
            if (view == null) {
                view = mo2334a(this.f2424d, this.f2423c, viewGroup);
            }
            mo2337a(view, this.f2424d, this.f2423c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
