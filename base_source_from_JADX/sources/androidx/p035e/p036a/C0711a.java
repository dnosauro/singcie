package androidx.p035e.p036a;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.e.a.a */
public abstract class C0711a implements Parcelable {
    public static final Parcelable.Creator<C0711a> CREATOR = new Parcelable.ClassLoaderCreator<C0711a>() {
        /* renamed from: a */
        public C0711a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: a */
        public C0711a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return C0711a.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public C0711a[] newArray(int i) {
            return new C0711a[i];
        }
    };
    public static final C0711a EMPTY_STATE = new C0711a() {
    };
    private final Parcelable mSuperState;

    private C0711a() {
        this.mSuperState = null;
    }

    protected C0711a(Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    protected C0711a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }

    protected C0711a(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
