package androidx.media;

import android.media.VolumeProvider;

/* renamed from: androidx.media.j */
class C0990j {

    /* renamed from: androidx.media.j$a */
    public interface C0992a {
        /* renamed from: a */
        void mo5176a(int i);

        /* renamed from: b */
        void mo5177b(int i);
    }

    /* renamed from: a */
    public static Object m3795a(int i, int i2, int i3, final C0992a aVar) {
        return new VolumeProvider(i, i2, i3) {
            public void onAdjustVolume(int i) {
                aVar.mo5177b(i);
            }

            public void onSetVolumeTo(int i) {
                aVar.mo5176a(i);
            }
        };
    }
}
