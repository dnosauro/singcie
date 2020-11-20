package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.C0775p;
import androidx.lifecycle.C0947e;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.b */
final class C0731b implements Parcelable {
    public static final Parcelable.Creator<C0731b> CREATOR = new Parcelable.Creator<C0731b>() {
        /* renamed from: a */
        public C0731b createFromParcel(Parcel parcel) {
            return new C0731b(parcel);
        }

        /* renamed from: a */
        public C0731b[] newArray(int i) {
            return new C0731b[i];
        }
    };

    /* renamed from: a */
    final int[] f2500a;

    /* renamed from: b */
    final ArrayList<String> f2501b;

    /* renamed from: c */
    final int[] f2502c;

    /* renamed from: d */
    final int[] f2503d;

    /* renamed from: e */
    final int f2504e;

    /* renamed from: f */
    final int f2505f;

    /* renamed from: g */
    final String f2506g;

    /* renamed from: h */
    final int f2507h;

    /* renamed from: i */
    final int f2508i;

    /* renamed from: j */
    final CharSequence f2509j;

    /* renamed from: k */
    final int f2510k;

    /* renamed from: l */
    final CharSequence f2511l;

    /* renamed from: m */
    final ArrayList<String> f2512m;

    /* renamed from: n */
    final ArrayList<String> f2513n;

    /* renamed from: o */
    final boolean f2514o;

    public C0731b(Parcel parcel) {
        this.f2500a = parcel.createIntArray();
        this.f2501b = parcel.createStringArrayList();
        this.f2502c = parcel.createIntArray();
        this.f2503d = parcel.createIntArray();
        this.f2504e = parcel.readInt();
        this.f2505f = parcel.readInt();
        this.f2506g = parcel.readString();
        this.f2507h = parcel.readInt();
        this.f2508i = parcel.readInt();
        this.f2509j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2510k = parcel.readInt();
        this.f2511l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2512m = parcel.createStringArrayList();
        this.f2513n = parcel.createStringArrayList();
        this.f2514o = parcel.readInt() != 0;
    }

    public C0731b(C0730a aVar) {
        int size = aVar.f2641d.size();
        this.f2500a = new int[(size * 5)];
        if (aVar.f2648k) {
            this.f2501b = new ArrayList<>(size);
            this.f2502c = new int[size];
            this.f2503d = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                C0775p.C0776a aVar2 = (C0775p.C0776a) aVar.f2641d.get(i);
                int i3 = i2 + 1;
                this.f2500a[i2] = aVar2.f2659a;
                this.f2501b.add(aVar2.f2660b != null ? aVar2.f2660b.mWho : null);
                int i4 = i3 + 1;
                this.f2500a[i3] = aVar2.f2661c;
                int i5 = i4 + 1;
                this.f2500a[i4] = aVar2.f2662d;
                int i6 = i5 + 1;
                this.f2500a[i5] = aVar2.f2663e;
                this.f2500a[i6] = aVar2.f2664f;
                this.f2502c[i] = aVar2.f2665g.ordinal();
                this.f2503d[i] = aVar2.f2666h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.f2504e = aVar.f2646i;
            this.f2505f = aVar.f2647j;
            this.f2506g = aVar.f2650m;
            this.f2507h = aVar.f2499c;
            this.f2508i = aVar.f2651n;
            this.f2509j = aVar.f2652o;
            this.f2510k = aVar.f2653p;
            this.f2511l = aVar.f2654q;
            this.f2512m = aVar.f2655r;
            this.f2513n = aVar.f2656s;
            this.f2514o = aVar.f2657t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /* renamed from: a */
    public C0730a mo4082a(C0753k kVar) {
        C0730a aVar = new C0730a(kVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f2500a.length) {
            C0775p.C0776a aVar2 = new C0775p.C0776a();
            int i3 = i + 1;
            aVar2.f2659a = this.f2500a[i];
            if (C0753k.f2551b) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f2500a[i3]);
            }
            String str = this.f2501b.get(i2);
            aVar2.f2660b = str != null ? kVar.f2563g.get(str) : null;
            aVar2.f2665g = C0947e.C0949b.values()[this.f2502c[i2]];
            aVar2.f2666h = C0947e.C0949b.values()[this.f2503d[i2]];
            int[] iArr = this.f2500a;
            int i4 = i3 + 1;
            aVar2.f2661c = iArr[i3];
            int i5 = i4 + 1;
            aVar2.f2662d = iArr[i4];
            int i6 = i5 + 1;
            aVar2.f2663e = iArr[i5];
            aVar2.f2664f = iArr[i6];
            aVar.f2642e = aVar2.f2661c;
            aVar.f2643f = aVar2.f2662d;
            aVar.f2644g = aVar2.f2663e;
            aVar.f2645h = aVar2.f2664f;
            aVar.mo4525a(aVar2);
            i2++;
            i = i6 + 1;
        }
        aVar.f2646i = this.f2504e;
        aVar.f2647j = this.f2505f;
        aVar.f2650m = this.f2506g;
        aVar.f2499c = this.f2507h;
        aVar.f2648k = true;
        aVar.f2651n = this.f2508i;
        aVar.f2652o = this.f2509j;
        aVar.f2653p = this.f2510k;
        aVar.f2654q = this.f2511l;
        aVar.f2655r = this.f2512m;
        aVar.f2656s = this.f2513n;
        aVar.f2657t = this.f2514o;
        aVar.mo4062a(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2500a);
        parcel.writeStringList(this.f2501b);
        parcel.writeIntArray(this.f2502c);
        parcel.writeIntArray(this.f2503d);
        parcel.writeInt(this.f2504e);
        parcel.writeInt(this.f2505f);
        parcel.writeString(this.f2506g);
        parcel.writeInt(this.f2507h);
        parcel.writeInt(this.f2508i);
        TextUtils.writeToParcel(this.f2509j, parcel, 0);
        parcel.writeInt(this.f2510k);
        TextUtils.writeToParcel(this.f2511l, parcel, 0);
        parcel.writeStringList(this.f2512m);
        parcel.writeStringList(this.f2513n);
        parcel.writeInt(this.f2514o ? 1 : 0);
    }
}
