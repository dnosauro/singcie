package androidx.media;

import androidx.versionedparcelable.C1156a;
import androidx.versionedparcelable.C1158c;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(C1156a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3117a = (C0973a) aVar.mo6233b(audioAttributesCompat.f3117a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, C1156a aVar) {
        aVar.mo6227a(false, false);
        aVar.mo6219a((C1158c) audioAttributesCompat.f3117a, 1);
    }
}
