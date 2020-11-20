package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.C1156a;
import androidx.versionedparcelable.C1158c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(C1156a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1918a = (IconCompat) aVar.mo6233b(remoteActionCompat.f1918a, 1);
        remoteActionCompat.f1919b = aVar.mo6234b(remoteActionCompat.f1919b, 2);
        remoteActionCompat.f1920c = aVar.mo6234b(remoteActionCompat.f1920c, 3);
        remoteActionCompat.f1921d = (PendingIntent) aVar.mo6232b(remoteActionCompat.f1921d, 4);
        remoteActionCompat.f1922e = aVar.mo6238b(remoteActionCompat.f1922e, 5);
        remoteActionCompat.f1923f = aVar.mo6238b(remoteActionCompat.f1923f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, C1156a aVar) {
        aVar.mo6227a(false, false);
        aVar.mo6219a((C1158c) remoteActionCompat.f1918a, 1);
        aVar.mo6222a(remoteActionCompat.f1919b, 2);
        aVar.mo6222a(remoteActionCompat.f1920c, 3);
        aVar.mo6217a((Parcelable) remoteActionCompat.f1921d, 4);
        aVar.mo6226a(remoteActionCompat.f1922e, 5);
        aVar.mo6226a(remoteActionCompat.f1923f, 6);
    }
}
