package androidx.p032d.p033a;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: androidx.d.a.b */
class C0695b extends Filter {

    /* renamed from: a */
    C0696a f2432a;

    /* renamed from: androidx.d.a.b$a */
    interface C0696a {
        /* renamed from: a */
        Cursor mo3958a();

        /* renamed from: a */
        Cursor mo2332a(CharSequence charSequence);

        /* renamed from: a */
        void mo2336a(Cursor cursor);

        /* renamed from: b */
        CharSequence mo2338b(Cursor cursor);
    }

    C0695b(C0696a aVar) {
        this.f2432a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2432a.mo2338b((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f2432a.mo2332a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
        } else {
            filterResults.count = 0;
            a = null;
        }
        filterResults.values = a;
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor a = this.f2432a.mo3958a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f2432a.mo2336a((Cursor) filterResults.values);
        }
    }
}
