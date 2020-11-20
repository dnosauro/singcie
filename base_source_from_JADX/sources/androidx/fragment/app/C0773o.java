package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.C0947e;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.o */
final class C0773o implements Parcelable {
    public static final Parcelable.Creator<C0773o> CREATOR = new Parcelable.Creator<C0773o>() {
        /* renamed from: a */
        public C0773o createFromParcel(Parcel parcel) {
            return new C0773o(parcel);
        }

        /* renamed from: a */
        public C0773o[] newArray(int i) {
            return new C0773o[i];
        }
    };

    /* renamed from: a */
    final String f2627a;

    /* renamed from: b */
    final String f2628b;

    /* renamed from: c */
    final boolean f2629c;

    /* renamed from: d */
    final int f2630d;

    /* renamed from: e */
    final int f2631e;

    /* renamed from: f */
    final String f2632f;

    /* renamed from: g */
    final boolean f2633g;

    /* renamed from: h */
    final boolean f2634h;

    /* renamed from: i */
    final boolean f2635i;

    /* renamed from: j */
    final Bundle f2636j;

    /* renamed from: k */
    final boolean f2637k;

    /* renamed from: l */
    final int f2638l;

    /* renamed from: m */
    Bundle f2639m;

    /* renamed from: n */
    C0735d f2640n;

    C0773o(Parcel parcel) {
        this.f2627a = parcel.readString();
        this.f2628b = parcel.readString();
        boolean z = true;
        this.f2629c = parcel.readInt() != 0;
        this.f2630d = parcel.readInt();
        this.f2631e = parcel.readInt();
        this.f2632f = parcel.readString();
        this.f2633g = parcel.readInt() != 0;
        this.f2634h = parcel.readInt() != 0;
        this.f2635i = parcel.readInt() != 0;
        this.f2636j = parcel.readBundle();
        this.f2637k = parcel.readInt() == 0 ? false : z;
        this.f2639m = parcel.readBundle();
        this.f2638l = parcel.readInt();
    }

    C0773o(C0735d dVar) {
        this.f2627a = dVar.getClass().getName();
        this.f2628b = dVar.mWho;
        this.f2629c = dVar.mFromLayout;
        this.f2630d = dVar.mFragmentId;
        this.f2631e = dVar.mContainerId;
        this.f2632f = dVar.mTag;
        this.f2633g = dVar.mRetainInstance;
        this.f2634h = dVar.mRemoving;
        this.f2635i = dVar.mDetached;
        this.f2636j = dVar.mArguments;
        this.f2637k = dVar.mHidden;
        this.f2638l = dVar.mMaxState.ordinal();
    }

    /* renamed from: a */
    public C0735d mo4514a(ClassLoader classLoader, C0748h hVar) {
        Bundle bundle;
        C0735d dVar;
        if (this.f2640n == null) {
            Bundle bundle2 = this.f2636j;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            this.f2640n = hVar.mo4354c(classLoader, this.f2627a);
            this.f2640n.setArguments(this.f2636j);
            Bundle bundle3 = this.f2639m;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                dVar = this.f2640n;
                bundle = this.f2639m;
            } else {
                dVar = this.f2640n;
                bundle = new Bundle();
            }
            dVar.mSavedFragmentState = bundle;
            C0735d dVar2 = this.f2640n;
            dVar2.mWho = this.f2628b;
            dVar2.mFromLayout = this.f2629c;
            dVar2.mRestored = true;
            dVar2.mFragmentId = this.f2630d;
            dVar2.mContainerId = this.f2631e;
            dVar2.mTag = this.f2632f;
            dVar2.mRetainInstance = this.f2633g;
            dVar2.mRemoving = this.f2634h;
            dVar2.mDetached = this.f2635i;
            dVar2.mHidden = this.f2637k;
            dVar2.mMaxState = C0947e.C0949b.values()[this.f2638l];
            if (C0753k.f2551b) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f2640n);
            }
        }
        return this.f2640n;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2627a);
        sb.append(" (");
        sb.append(this.f2628b);
        sb.append(")}:");
        if (this.f2629c) {
            sb.append(" fromLayout");
        }
        if (this.f2631e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2631e));
        }
        String str = this.f2632f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2632f);
        }
        if (this.f2633g) {
            sb.append(" retainInstance");
        }
        if (this.f2634h) {
            sb.append(" removing");
        }
        if (this.f2635i) {
            sb.append(" detached");
        }
        if (this.f2637k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2627a);
        parcel.writeString(this.f2628b);
        parcel.writeInt(this.f2629c ? 1 : 0);
        parcel.writeInt(this.f2630d);
        parcel.writeInt(this.f2631e);
        parcel.writeString(this.f2632f);
        parcel.writeInt(this.f2633g ? 1 : 0);
        parcel.writeInt(this.f2634h ? 1 : 0);
        parcel.writeInt(this.f2635i ? 1 : 0);
        parcel.writeBundle(this.f2636j);
        parcel.writeInt(this.f2637k ? 1 : 0);
        parcel.writeBundle(this.f2639m);
        parcel.writeInt(this.f2638l);
    }
}
