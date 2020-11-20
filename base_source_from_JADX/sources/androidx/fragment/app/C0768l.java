package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.l */
final class C0768l implements Parcelable {
    public static final Parcelable.Creator<C0768l> CREATOR = new Parcelable.Creator<C0768l>() {
        /* renamed from: a */
        public C0768l createFromParcel(Parcel parcel) {
            return new C0768l(parcel);
        }

        /* renamed from: a */
        public C0768l[] newArray(int i) {
            return new C0768l[i];
        }
    };

    /* renamed from: a */
    ArrayList<C0773o> f2615a;

    /* renamed from: b */
    ArrayList<String> f2616b;

    /* renamed from: c */
    C0731b[] f2617c;

    /* renamed from: d */
    String f2618d = null;

    /* renamed from: e */
    int f2619e;

    public C0768l() {
    }

    public C0768l(Parcel parcel) {
        this.f2615a = parcel.createTypedArrayList(C0773o.CREATOR);
        this.f2616b = parcel.createStringArrayList();
        this.f2617c = (C0731b[]) parcel.createTypedArray(C0731b.CREATOR);
        this.f2618d = parcel.readString();
        this.f2619e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2615a);
        parcel.writeStringList(this.f2616b);
        parcel.writeTypedArray(this.f2617c, i);
        parcel.writeString(this.f2618d);
        parcel.writeInt(this.f2619e);
    }
}
