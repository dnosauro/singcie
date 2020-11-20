package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.C1156a;

public class IconCompatParcelizer {
    public static IconCompat read(C1156a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2195a = aVar.mo6231b(iconCompat.f2195a, 1);
        iconCompat.f2197c = aVar.mo6239b(iconCompat.f2197c, 2);
        iconCompat.f2198d = aVar.mo6232b(iconCompat.f2198d, 3);
        iconCompat.f2199e = aVar.mo6231b(iconCompat.f2199e, 4);
        iconCompat.f2200f = aVar.mo6231b(iconCompat.f2200f, 5);
        iconCompat.f2201g = (ColorStateList) aVar.mo6232b(iconCompat.f2201g, 6);
        iconCompat.f2203j = aVar.mo6235b(iconCompat.f2203j, 7);
        iconCompat.mo3621e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, C1156a aVar) {
        aVar.mo6227a(true, true);
        iconCompat.mo3617a(aVar.mo6230a());
        if (-1 != iconCompat.f2195a) {
            aVar.mo6215a(iconCompat.f2195a, 1);
        }
        if (iconCompat.f2197c != null) {
            aVar.mo6229a(iconCompat.f2197c, 2);
        }
        if (iconCompat.f2198d != null) {
            aVar.mo6217a(iconCompat.f2198d, 3);
        }
        if (iconCompat.f2199e != 0) {
            aVar.mo6215a(iconCompat.f2199e, 4);
        }
        if (iconCompat.f2200f != 0) {
            aVar.mo6215a(iconCompat.f2200f, 5);
        }
        if (iconCompat.f2201g != null) {
            aVar.mo6217a((Parcelable) iconCompat.f2201g, 6);
        }
        if (iconCompat.f2203j != null) {
            aVar.mo6224a(iconCompat.f2203j, 7);
        }
    }
}
