package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.p018c.C0400a;
import java.lang.reflect.Method;

/* renamed from: androidx.versionedparcelable.b */
class C1157b extends C1156a {

    /* renamed from: d */
    private final SparseIntArray f3629d;

    /* renamed from: e */
    private final Parcel f3630e;

    /* renamed from: f */
    private final int f3631f;

    /* renamed from: g */
    private final int f3632g;

    /* renamed from: h */
    private final String f3633h;

    /* renamed from: i */
    private int f3634i;

    /* renamed from: j */
    private int f3635j;

    /* renamed from: k */
    private int f3636k;

    C1157b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0400a(), new C0400a(), new C0400a());
    }

    private C1157b(Parcel parcel, int i, int i2, String str, C0400a<String, Method> aVar, C0400a<String, Method> aVar2, C0400a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f3629d = new SparseIntArray();
        this.f3634i = -1;
        this.f3635j = 0;
        this.f3636k = -1;
        this.f3630e = parcel;
        this.f3631f = i;
        this.f3632g = i2;
        this.f3635j = this.f3631f;
        this.f3633h = str;
    }

    /* renamed from: a */
    public void mo6214a(int i) {
        this.f3630e.writeInt(i);
    }

    /* renamed from: a */
    public void mo6216a(Parcelable parcelable) {
        this.f3630e.writeParcelable(parcelable, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6221a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3630e, 0);
    }

    /* renamed from: a */
    public void mo6223a(String str) {
        this.f3630e.writeString(str);
    }

    /* renamed from: a */
    public void mo6225a(boolean z) {
        this.f3630e.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public void mo6228a(byte[] bArr) {
        if (bArr != null) {
            this.f3630e.writeInt(bArr.length);
            this.f3630e.writeByteArray(bArr);
            return;
        }
        this.f3630e.writeInt(-1);
    }

    /* renamed from: b */
    public void mo6236b() {
        int i = this.f3634i;
        if (i >= 0) {
            int i2 = this.f3629d.get(i);
            int dataPosition = this.f3630e.dataPosition();
            this.f3630e.setDataPosition(i2);
            this.f3630e.writeInt(dataPosition - i2);
            this.f3630e.setDataPosition(dataPosition);
        }
    }

    /* renamed from: b */
    public boolean mo6237b(int i) {
        while (this.f3635j < this.f3632g) {
            int i2 = this.f3636k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f3630e.setDataPosition(this.f3635j);
            int readInt = this.f3630e.readInt();
            this.f3636k = this.f3630e.readInt();
            this.f3635j += readInt;
        }
        return this.f3636k == i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1156a mo6240c() {
        Parcel parcel = this.f3630e;
        int dataPosition = parcel.dataPosition();
        int i = this.f3635j;
        if (i == this.f3631f) {
            i = this.f3632g;
        }
        int i2 = i;
        return new C1157b(parcel, dataPosition, i2, this.f3633h + "  ", this.f3626a, this.f3627b, this.f3628c);
    }

    /* renamed from: c */
    public void mo6241c(int i) {
        mo6236b();
        this.f3634i = i;
        this.f3629d.put(i, this.f3630e.dataPosition());
        mo6214a(0);
        mo6214a(i);
    }

    /* renamed from: d */
    public int mo6242d() {
        return this.f3630e.readInt();
    }

    /* renamed from: e */
    public String mo6243e() {
        return this.f3630e.readString();
    }

    /* renamed from: f */
    public byte[] mo6244f() {
        int readInt = this.f3630e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f3630e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public CharSequence mo6245g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3630e);
    }

    /* renamed from: h */
    public <T extends Parcelable> T mo6246h() {
        return this.f3630e.readParcelable(getClass().getClassLoader());
    }

    /* renamed from: i */
    public boolean mo6247i() {
        return this.f3630e.readInt() != 0;
    }
}
