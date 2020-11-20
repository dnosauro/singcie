package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.C0510i;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.core.app.j */
class C0517j implements C0509h {

    /* renamed from: a */
    private final Notification.Builder f2021a;

    /* renamed from: b */
    private final C0510i.C0515e f2022b;

    /* renamed from: c */
    private RemoteViews f2023c;

    /* renamed from: d */
    private RemoteViews f2024d;

    /* renamed from: e */
    private final List<Bundle> f2025e = new ArrayList();

    /* renamed from: f */
    private final Bundle f2026f = new Bundle();

    /* renamed from: g */
    private int f2027g;

    /* renamed from: h */
    private RemoteViews f2028h;

    C0517j(C0510i.C0515e eVar) {
        String str;
        Bundle bundle;
        this.f2022b = eVar;
        this.f2021a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(eVar.f1991a, eVar.f1982I) : new Notification.Builder(eVar.f1991a);
        Notification notification = eVar.f1989P;
        this.f2021a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f1998h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f1994d).setContentText(eVar.f1995e).setContentInfo(eVar.f2000j).setContentIntent(eVar.f1996f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f1997g, (notification.flags & 128) != 0).setLargeIcon(eVar.f1999i).setNumber(eVar.f2001k).setProgress(eVar.f2008r, eVar.f2009s, eVar.f2010t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2021a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2021a.setSubText(eVar.f2006p).setUsesChronometer(eVar.f2004n).setPriority(eVar.f2002l);
            Iterator<C0510i.C0511a> it = eVar.f1992b.iterator();
            while (it.hasNext()) {
                m2042a(it.next());
            }
            if (eVar.f1975B != null) {
                this.f2026f.putAll(eVar.f1975B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.f2014x) {
                    this.f2026f.putBoolean("android.support.localOnly", true);
                }
                if (eVar.f2011u != null) {
                    this.f2026f.putString("android.support.groupKey", eVar.f2011u);
                    if (eVar.f2012v) {
                        bundle = this.f2026f;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f2026f;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                if (eVar.f2013w != null) {
                    this.f2026f.putString("android.support.sortKey", eVar.f2013w);
                }
            }
            this.f2023c = eVar.f1979F;
            this.f2024d = eVar.f1980G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2021a.setShowWhen(eVar.f2003m);
            if (Build.VERSION.SDK_INT < 21 && eVar.f1990Q != null && !eVar.f1990Q.isEmpty()) {
                this.f2026f.putStringArray("android.people", (String[]) eVar.f1990Q.toArray(new String[eVar.f1990Q.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2021a.setLocalOnly(eVar.f2014x).setGroup(eVar.f2011u).setGroupSummary(eVar.f2012v).setSortKey(eVar.f2013w);
            this.f2027g = eVar.f1986M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2021a.setCategory(eVar.f1974A).setColor(eVar.f1976C).setVisibility(eVar.f1977D).setPublicVersion(eVar.f1978E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = eVar.f1990Q.iterator();
            while (it2.hasNext()) {
                this.f2021a.addPerson(it2.next());
            }
            this.f2028h = eVar.f1981H;
            if (eVar.f1993c.size() > 0) {
                Bundle bundle2 = eVar.mo3456a().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle();
                for (int i = 0; i < eVar.f1993c.size(); i++) {
                    bundle3.putBundle(Integer.toString(i), C0518k.m2048a(eVar.f1993c.get(i)));
                }
                bundle2.putBundle("invisible_actions", bundle3);
                eVar.mo3456a().putBundle("android.car.EXTENSIONS", bundle2);
                this.f2026f.putBundle("android.car.EXTENSIONS", bundle2);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2021a.setExtras(eVar.f1975B).setRemoteInputHistory(eVar.f2007q);
            if (eVar.f1979F != null) {
                this.f2021a.setCustomContentView(eVar.f1979F);
            }
            if (eVar.f1980G != null) {
                this.f2021a.setCustomBigContentView(eVar.f1980G);
            }
            if (eVar.f1981H != null) {
                this.f2021a.setCustomHeadsUpContentView(eVar.f1981H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2021a.setBadgeIconType(eVar.f1983J).setShortcutId(eVar.f1984K).setTimeoutAfter(eVar.f1985L).setGroupAlertBehavior(eVar.f1986M);
            if (eVar.f2016z) {
                this.f2021a.setColorized(eVar.f2015y);
            }
            if (!TextUtils.isEmpty(eVar.f1982I)) {
                this.f2021a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2021a.setAllowSystemGeneratedContextualActions(eVar.f1987N);
            this.f2021a.setBubbleMetadata(C0510i.C0514d.m2000a(eVar.f1988O));
        }
    }

    /* renamed from: a */
    private void m2041a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    /* renamed from: a */
    private void m2042a(C0510i.C0511a aVar) {
        Notification.Action.Builder builder;
        if (Build.VERSION.SDK_INT >= 20) {
            if (Build.VERSION.SDK_INT >= 23) {
                IconCompat b = aVar.mo3435b();
                builder = new Notification.Action.Builder(b == null ? null : b.mo3620d(), aVar.mo3436c(), aVar.mo3437d());
            } else {
                builder = new Notification.Action.Builder(aVar.mo3434a(), aVar.mo3436c(), aVar.mo3437d());
            }
            if (aVar.mo3440g() != null) {
                for (RemoteInput addRemoteInput : C0520m.m2055a(aVar.mo3440g())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = aVar.mo3438e() != null ? new Bundle(aVar.mo3438e()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3439f());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.mo3439f());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.mo3441h());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.mo3441h());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.mo3442i());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.mo3444k());
            builder.addExtras(bundle);
            this.f2021a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f2025e.add(C0518k.m2046a(this.f2021a, aVar));
        }
    }

    /* renamed from: a */
    public Notification.Builder mo3433a() {
        return this.f2021a;
    }

    /* renamed from: b */
    public Notification mo3485b() {
        Bundle a;
        RemoteViews d;
        RemoteViews c;
        C0510i.C0516f fVar = this.f2022b.f2005o;
        if (fVar != null) {
            fVar.mo3446a((C0509h) this);
        }
        RemoteViews b = fVar != null ? fVar.mo3482b(this) : null;
        Notification c2 = mo3486c();
        if (b == null) {
            if (this.f2022b.f1979F != null) {
                b = this.f2022b.f1979F;
            }
            if (!(Build.VERSION.SDK_INT < 16 || fVar == null || (c = fVar.mo3483c(this)) == null)) {
                c2.bigContentView = c;
            }
            if (!(Build.VERSION.SDK_INT < 21 || fVar == null || (d = this.f2022b.f2005o.mo3484d(this)) == null)) {
                c2.headsUpContentView = d;
            }
            if (!(Build.VERSION.SDK_INT < 16 || fVar == null || (a = C0510i.m1983a(c2)) == null)) {
                fVar.mo3480a(a);
            }
            return c2;
        }
        c2.contentView = b;
        c2.bigContentView = c;
        c2.headsUpContentView = d;
        fVar.mo3480a(a);
        return c2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Notification mo3486c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2021a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f2021a.build();
            if (this.f2027g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2027g != 2)) {
                    m2041a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2027g == 1) {
                    m2041a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f2021a.setExtras(this.f2026f);
            Notification build2 = this.f2021a.build();
            RemoteViews remoteViews = this.f2023c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2024d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2028h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2027g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2027g != 2)) {
                    m2041a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2027g == 1) {
                    m2041a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f2021a.setExtras(this.f2026f);
            Notification build3 = this.f2021a.build();
            RemoteViews remoteViews4 = this.f2023c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2024d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2027g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2027g != 2)) {
                    m2041a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2027g == 1) {
                    m2041a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a = C0518k.m2050a(this.f2025e);
            if (a != null) {
                this.f2026f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f2021a.setExtras(this.f2026f);
            Notification build4 = this.f2021a.build();
            RemoteViews remoteViews6 = this.f2023c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2024d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT < 16) {
            return this.f2021a.getNotification();
        } else {
            Notification build5 = this.f2021a.build();
            Bundle a2 = C0510i.m1983a(build5);
            Bundle bundle = new Bundle(this.f2026f);
            for (String str : this.f2026f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = C0518k.m2050a(this.f2025e);
            if (a3 != null) {
                C0510i.m1983a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews8 = this.f2023c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2024d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
