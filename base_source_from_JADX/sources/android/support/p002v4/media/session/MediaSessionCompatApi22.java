package android.support.p002v4.media.session;

import android.media.session.MediaSession;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi22 */
class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object obj, int i) {
        ((MediaSession) obj).setRatingType(i);
    }
}
