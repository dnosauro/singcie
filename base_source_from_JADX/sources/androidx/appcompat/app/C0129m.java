package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.C0545b;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Calendar;

/* renamed from: androidx.appcompat.app.m */
class C0129m {

    /* renamed from: a */
    private static C0129m f306a;

    /* renamed from: b */
    private final Context f307b;

    /* renamed from: c */
    private final LocationManager f308c;

    /* renamed from: d */
    private final C0130a f309d = new C0130a();

    /* renamed from: androidx.appcompat.app.m$a */
    private static class C0130a {

        /* renamed from: a */
        boolean f310a;

        /* renamed from: b */
        long f311b;

        /* renamed from: c */
        long f312c;

        /* renamed from: d */
        long f313d;

        /* renamed from: e */
        long f314e;

        /* renamed from: f */
        long f315f;

        C0130a() {
        }
    }

    C0129m(Context context, LocationManager locationManager) {
        this.f307b = context;
        this.f308c = locationManager;
    }

    /* renamed from: a */
    private Location m304a(String str) {
        try {
            if (this.f308c.isProviderEnabled(str)) {
                return this.f308c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* renamed from: a */
    static C0129m m305a(Context context) {
        if (f306a == null) {
            Context applicationContext = context.getApplicationContext();
            f306a = new C0129m(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
        }
        return f306a;
    }

    /* renamed from: a */
    private void m306a(Location location) {
        long j;
        C0130a aVar = this.f309d;
        long currentTimeMillis = System.currentTimeMillis();
        C0128l a = C0128l.m302a();
        C0128l lVar = a;
        lVar.mo966a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f303a;
        lVar.mo966a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f305c == 1;
        long j3 = a.f304b;
        long j4 = j2;
        long j5 = a.f303a;
        long j6 = j3;
        boolean z2 = z;
        a.mo966a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a.f304b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f310a = z2;
        aVar.f311b = j4;
        aVar.f312c = j6;
        aVar.f313d = j5;
        aVar.f314e = j7;
        aVar.f315f = j;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m307b() {
        Location location = null;
        Location a = C0545b.m2165a(this.f307b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m304a("network") : null;
        if (C0545b.m2165a(this.f307b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m304a("gps");
        }
        return (location == null || a == null) ? location != null ? location : a : location.getTime() > a.getTime() ? location : a;
    }

    /* renamed from: c */
    private boolean m308c() {
        return this.f309d.f315f > System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo967a() {
        C0130a aVar = this.f309d;
        if (m308c()) {
            return aVar.f310a;
        }
        Location b = m307b();
        if (b != null) {
            m306a(b);
            return aVar.f310a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
