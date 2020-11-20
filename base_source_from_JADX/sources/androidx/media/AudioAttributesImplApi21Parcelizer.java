package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.C1156a;

public final class AudioAttributesImplApi21Parcelizer {
    public static C0976b read(C1156a aVar) {
        C0976b bVar = new C0976b();
        bVar.f3122a = (AudioAttributes) aVar.mo6232b(bVar.f3122a, 1);
        bVar.f3123b = aVar.mo6231b(bVar.f3123b, 2);
        return bVar;
    }

    public static void write(C0976b bVar, C1156a aVar) {
        aVar.mo6227a(false, false);
        aVar.mo6217a((Parcelable) bVar.f3122a, 1);
        aVar.mo6215a(bVar.f3123b, 2);
    }
}
