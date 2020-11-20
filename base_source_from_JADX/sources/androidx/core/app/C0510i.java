package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.C0481a;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* renamed from: androidx.core.app.i */
public class C0510i {

    /* renamed from: androidx.core.app.i$a */
    public static class C0511a {

        /* renamed from: a */
        final Bundle f1953a;

        /* renamed from: b */
        boolean f1954b;
        @Deprecated

        /* renamed from: c */
        public int f1955c;

        /* renamed from: d */
        public CharSequence f1956d;

        /* renamed from: e */
        public PendingIntent f1957e;

        /* renamed from: f */
        private IconCompat f1958f;

        /* renamed from: g */
        private final C0520m[] f1959g;

        /* renamed from: h */
        private final C0520m[] f1960h;

        /* renamed from: i */
        private boolean f1961i;

        /* renamed from: j */
        private final int f1962j;

        /* renamed from: k */
        private final boolean f1963k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public C0511a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.m2305a((Resources) null, "", i) : null, charSequence, pendingIntent);
        }

        public C0511a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (C0520m[]) null, (C0520m[]) null, true, 0, true, false);
        }

        C0511a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C0520m[] mVarArr, C0520m[] mVarArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f1954b = true;
            this.f1958f = iconCompat;
            if (iconCompat != null && iconCompat.mo3616a() == 2) {
                this.f1955c = iconCompat.mo3619c();
            }
            this.f1956d = C0515e.m2010d(charSequence);
            this.f1957e = pendingIntent;
            this.f1953a = bundle == null ? new Bundle() : bundle;
            this.f1959g = mVarArr;
            this.f1960h = mVarArr2;
            this.f1961i = z;
            this.f1962j = i;
            this.f1954b = z2;
            this.f1963k = z3;
        }

        @Deprecated
        /* renamed from: a */
        public int mo3434a() {
            return this.f1955c;
        }

        /* renamed from: b */
        public IconCompat mo3435b() {
            int i;
            if (this.f1958f == null && (i = this.f1955c) != 0) {
                this.f1958f = IconCompat.m2305a((Resources) null, "", i);
            }
            return this.f1958f;
        }

        /* renamed from: c */
        public CharSequence mo3436c() {
            return this.f1956d;
        }

        /* renamed from: d */
        public PendingIntent mo3437d() {
            return this.f1957e;
        }

        /* renamed from: e */
        public Bundle mo3438e() {
            return this.f1953a;
        }

        /* renamed from: f */
        public boolean mo3439f() {
            return this.f1961i;
        }

        /* renamed from: g */
        public C0520m[] mo3440g() {
            return this.f1959g;
        }

        /* renamed from: h */
        public int mo3441h() {
            return this.f1962j;
        }

        /* renamed from: i */
        public boolean mo3442i() {
            return this.f1963k;
        }

        /* renamed from: j */
        public C0520m[] mo3443j() {
            return this.f1960h;
        }

        /* renamed from: k */
        public boolean mo3444k() {
            return this.f1954b;
        }
    }

    /* renamed from: androidx.core.app.i$b */
    public static class C0512b extends C0516f {

        /* renamed from: e */
        private Bitmap f1964e;

        /* renamed from: f */
        private Bitmap f1965f;

        /* renamed from: g */
        private boolean f1966g;

        /* renamed from: a */
        public C0512b mo3445a(Bitmap bitmap) {
            this.f1964e = bitmap;
            return this;
        }

        /* renamed from: a */
        public void mo3446a(C0509h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(hVar.mo3433a()).setBigContentTitle(this.f2018b).bigPicture(this.f1964e);
                if (this.f1966g) {
                    bigPicture.bigLargeIcon(this.f1965f);
                }
                if (this.f2020d) {
                    bigPicture.setSummaryText(this.f2019c);
                }
            }
        }

        /* renamed from: b */
        public C0512b mo3447b(Bitmap bitmap) {
            this.f1965f = bitmap;
            this.f1966g = true;
            return this;
        }
    }

    /* renamed from: androidx.core.app.i$c */
    public static class C0513c extends C0516f {

        /* renamed from: e */
        private CharSequence f1967e;

        /* renamed from: a */
        public C0513c mo3448a(CharSequence charSequence) {
            this.f1967e = C0515e.m2010d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo3446a(C0509h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(hVar.mo3433a()).setBigContentTitle(this.f2018b).bigText(this.f1967e);
                if (this.f2020d) {
                    bigText.setSummaryText(this.f2019c);
                }
            }
        }
    }

    /* renamed from: androidx.core.app.i$d */
    public static final class C0514d {

        /* renamed from: a */
        private PendingIntent f1968a;

        /* renamed from: b */
        private PendingIntent f1969b;

        /* renamed from: c */
        private IconCompat f1970c;

        /* renamed from: d */
        private int f1971d;

        /* renamed from: e */
        private int f1972e;

        /* renamed from: f */
        private int f1973f;

        /* renamed from: a */
        public static Notification.BubbleMetadata m2000a(C0514d dVar) {
            if (dVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(dVar.mo3454f()).setDeleteIntent(dVar.mo3450b()).setIcon(dVar.mo3451c().mo3620d()).setIntent(dVar.mo3449a()).setSuppressNotification(dVar.mo3455g());
            if (dVar.mo3452d() != 0) {
                suppressNotification.setDesiredHeight(dVar.mo3452d());
            }
            if (dVar.mo3453e() != 0) {
                suppressNotification.setDesiredHeightResId(dVar.mo3453e());
            }
            return suppressNotification.build();
        }

        /* renamed from: a */
        public PendingIntent mo3449a() {
            return this.f1968a;
        }

        /* renamed from: b */
        public PendingIntent mo3450b() {
            return this.f1969b;
        }

        /* renamed from: c */
        public IconCompat mo3451c() {
            return this.f1970c;
        }

        /* renamed from: d */
        public int mo3452d() {
            return this.f1971d;
        }

        /* renamed from: e */
        public int mo3453e() {
            return this.f1972e;
        }

        /* renamed from: f */
        public boolean mo3454f() {
            return (this.f1973f & 1) != 0;
        }

        /* renamed from: g */
        public boolean mo3455g() {
            return (this.f1973f & 2) != 0;
        }
    }

    /* renamed from: androidx.core.app.i$e */
    public static class C0515e {

        /* renamed from: A */
        String f1974A;

        /* renamed from: B */
        Bundle f1975B;

        /* renamed from: C */
        int f1976C;

        /* renamed from: D */
        int f1977D;

        /* renamed from: E */
        Notification f1978E;

        /* renamed from: F */
        RemoteViews f1979F;

        /* renamed from: G */
        RemoteViews f1980G;

        /* renamed from: H */
        RemoteViews f1981H;

        /* renamed from: I */
        String f1982I;

        /* renamed from: J */
        int f1983J;

        /* renamed from: K */
        String f1984K;

        /* renamed from: L */
        long f1985L;

        /* renamed from: M */
        int f1986M;

        /* renamed from: N */
        boolean f1987N;

        /* renamed from: O */
        C0514d f1988O;

        /* renamed from: P */
        Notification f1989P;
        @Deprecated

        /* renamed from: Q */
        public ArrayList<String> f1990Q;

        /* renamed from: a */
        public Context f1991a;

        /* renamed from: b */
        public ArrayList<C0511a> f1992b;

        /* renamed from: c */
        ArrayList<C0511a> f1993c;

        /* renamed from: d */
        CharSequence f1994d;

        /* renamed from: e */
        CharSequence f1995e;

        /* renamed from: f */
        PendingIntent f1996f;

        /* renamed from: g */
        PendingIntent f1997g;

        /* renamed from: h */
        RemoteViews f1998h;

        /* renamed from: i */
        Bitmap f1999i;

        /* renamed from: j */
        CharSequence f2000j;

        /* renamed from: k */
        int f2001k;

        /* renamed from: l */
        int f2002l;

        /* renamed from: m */
        boolean f2003m;

        /* renamed from: n */
        boolean f2004n;

        /* renamed from: o */
        C0516f f2005o;

        /* renamed from: p */
        CharSequence f2006p;

        /* renamed from: q */
        CharSequence[] f2007q;

        /* renamed from: r */
        int f2008r;

        /* renamed from: s */
        int f2009s;

        /* renamed from: t */
        boolean f2010t;

        /* renamed from: u */
        String f2011u;

        /* renamed from: v */
        boolean f2012v;

        /* renamed from: w */
        String f2013w;

        /* renamed from: x */
        boolean f2014x;

        /* renamed from: y */
        boolean f2015y;

        /* renamed from: z */
        boolean f2016z;

        @Deprecated
        public C0515e(Context context) {
            this(context, (String) null);
        }

        public C0515e(Context context, String str) {
            this.f1992b = new ArrayList<>();
            this.f1993c = new ArrayList<>();
            this.f2003m = true;
            this.f2014x = false;
            this.f1976C = 0;
            this.f1977D = 0;
            this.f1983J = 0;
            this.f1986M = 0;
            this.f1989P = new Notification();
            this.f1991a = context;
            this.f1982I = str;
            this.f1989P.when = System.currentTimeMillis();
            this.f1989P.audioStreamType = -1;
            this.f2002l = 0;
            this.f1990Q = new ArrayList<>();
            this.f1987N = true;
        }

        /* renamed from: a */
        private void m2008a(int i, boolean z) {
            Notification notification;
            int i2;
            if (z) {
                notification = this.f1989P;
                i2 = i | notification.flags;
            } else {
                notification = this.f1989P;
                i2 = (~i) & notification.flags;
            }
            notification.flags = i2;
        }

        /* renamed from: b */
        private Bitmap m2009b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f1991a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0481a.C0483b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0481a.C0483b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        /* renamed from: d */
        protected static CharSequence m2010d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: a */
        public Bundle mo3456a() {
            if (this.f1975B == null) {
                this.f1975B = new Bundle();
            }
            return this.f1975B;
        }

        /* renamed from: a */
        public C0515e mo3457a(int i) {
            this.f1989P.icon = i;
            return this;
        }

        /* renamed from: a */
        public C0515e mo3458a(int i, int i2, int i3) {
            Notification notification = this.f1989P;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            int i4 = (notification.ledOnMS == 0 || this.f1989P.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.f1989P;
            notification2.flags = i4 | (notification2.flags & -2);
            return this;
        }

        /* renamed from: a */
        public C0515e mo3459a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1992b.add(new C0511a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public C0515e mo3460a(long j) {
            this.f1989P.when = j;
            return this;
        }

        /* renamed from: a */
        public C0515e mo3461a(PendingIntent pendingIntent) {
            this.f1996f = pendingIntent;
            return this;
        }

        /* renamed from: a */
        public C0515e mo3462a(Bitmap bitmap) {
            this.f1999i = m2009b(bitmap);
            return this;
        }

        /* renamed from: a */
        public C0515e mo3463a(Uri uri) {
            Notification notification = this.f1989P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1989P.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* renamed from: a */
        public C0515e mo3464a(C0516f fVar) {
            if (this.f2005o != fVar) {
                this.f2005o = fVar;
                C0516f fVar2 = this.f2005o;
                if (fVar2 != null) {
                    fVar2.mo3481a(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public C0515e mo3465a(CharSequence charSequence) {
            this.f1994d = m2010d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0515e mo3466a(String str) {
            this.f1982I = str;
            return this;
        }

        /* renamed from: a */
        public C0515e mo3467a(boolean z) {
            this.f2003m = z;
            return this;
        }

        /* renamed from: a */
        public C0515e mo3468a(long[] jArr) {
            this.f1989P.vibrate = jArr;
            return this;
        }

        /* renamed from: b */
        public Notification mo3469b() {
            return new C0517j(this).mo3485b();
        }

        /* renamed from: b */
        public C0515e mo3470b(int i) {
            this.f2001k = i;
            return this;
        }

        /* renamed from: b */
        public C0515e mo3471b(PendingIntent pendingIntent) {
            this.f1989P.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: b */
        public C0515e mo3472b(CharSequence charSequence) {
            this.f1995e = m2010d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0515e mo3473b(boolean z) {
            m2008a(16, z);
            return this;
        }

        /* renamed from: c */
        public C0515e mo3474c(int i) {
            Notification notification = this.f1989P;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        /* renamed from: c */
        public C0515e mo3475c(CharSequence charSequence) {
            this.f1989P.tickerText = m2010d(charSequence);
            return this;
        }

        /* renamed from: c */
        public C0515e mo3476c(boolean z) {
            this.f2014x = z;
            return this;
        }

        /* renamed from: d */
        public C0515e mo3477d(int i) {
            this.f2002l = i;
            return this;
        }

        /* renamed from: e */
        public C0515e mo3478e(int i) {
            this.f1976C = i;
            return this;
        }

        /* renamed from: f */
        public C0515e mo3479f(int i) {
            this.f1977D = i;
            return this;
        }
    }

    /* renamed from: androidx.core.app.i$f */
    public static abstract class C0516f {

        /* renamed from: a */
        protected C0515e f2017a;

        /* renamed from: b */
        CharSequence f2018b;

        /* renamed from: c */
        CharSequence f2019c;

        /* renamed from: d */
        boolean f2020d = false;

        /* renamed from: a */
        public void mo3480a(Bundle bundle) {
        }

        /* renamed from: a */
        public void mo3446a(C0509h hVar) {
        }

        /* renamed from: a */
        public void mo3481a(C0515e eVar) {
            if (this.f2017a != eVar) {
                this.f2017a = eVar;
                C0515e eVar2 = this.f2017a;
                if (eVar2 != null) {
                    eVar2.mo3464a(this);
                }
            }
        }

        /* renamed from: b */
        public RemoteViews mo3482b(C0509h hVar) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews mo3483c(C0509h hVar) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews mo3484d(C0509h hVar) {
            return null;
        }
    }

    /* renamed from: a */
    public static Bundle m1983a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return C0518k.m2047a(notification);
        }
        return null;
    }
}
