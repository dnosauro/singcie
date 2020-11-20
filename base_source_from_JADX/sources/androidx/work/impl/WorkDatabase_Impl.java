package androidx.work.impl;

import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0814c;
import androidx.room.C1106a;
import androidx.room.C1124f;
import androidx.room.C1138i;
import androidx.room.C1144k;
import androidx.room.p057b.C1110b;
import androidx.room.p057b.C1112d;
import androidx.work.impl.p062b.C1228b;
import androidx.work.impl.p062b.C1229c;
import androidx.work.impl.p062b.C1232e;
import androidx.work.impl.p062b.C1233f;
import androidx.work.impl.p062b.C1237h;
import androidx.work.impl.p062b.C1238i;
import androidx.work.impl.p062b.C1243k;
import androidx.work.impl.p062b.C1244l;
import androidx.work.impl.p062b.C1255n;
import androidx.work.impl.p062b.C1256o;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: d */
    private volatile C1243k f3771d;

    /* renamed from: e */
    private volatile C1228b f3772e;

    /* renamed from: f */
    private volatile C1255n f3773f;

    /* renamed from: g */
    private volatile C1232e f3774g;

    /* renamed from: h */
    private volatile C1237h f3775h;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0814c mo6161b(C1106a aVar) {
        return aVar.f3478a.mo4636a(C0814c.C0816b.m3382a(aVar.f3479b).mo4652a(aVar.f3480c).mo4651a((C0814c.C0815a) new C1144k(aVar, new C1144k.C1145a(6) {
            /* renamed from: a */
            public void mo6182a(C0813b bVar) {
                bVar.mo4618c("DROP TABLE IF EXISTS `Dependency`");
                bVar.mo4618c("DROP TABLE IF EXISTS `WorkSpec`");
                bVar.mo4618c("DROP TABLE IF EXISTS `WorkTag`");
                bVar.mo4618c("DROP TABLE IF EXISTS `SystemIdInfo`");
                bVar.mo4618c("DROP TABLE IF EXISTS `WorkName`");
            }

            /* renamed from: b */
            public void mo6183b(C0813b bVar) {
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.mo4618c("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                bVar.mo4618c("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                bVar.mo4618c("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.mo4618c("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.mo4618c("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                bVar.mo4618c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.mo4618c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c84d23ade98552f1cec71088c1f0794c')");
            }

            /* renamed from: c */
            public void mo6184c(C0813b bVar) {
                C0813b unused = WorkDatabase_Impl.this.f3564a = bVar;
                bVar.mo4618c("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.mo6158a(bVar);
                if (WorkDatabase_Impl.this.f3566c != null) {
                    int size = WorkDatabase_Impl.this.f3566c.size();
                    for (int i = 0; i < size; i++) {
                        ((C1138i.C1140b) WorkDatabase_Impl.this.f3566c.get(i)).mo6178b(bVar);
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public void mo6185d(C0813b bVar) {
                if (WorkDatabase_Impl.this.f3566c != null) {
                    int size = WorkDatabase_Impl.this.f3566c.size();
                    for (int i = 0; i < size; i++) {
                        ((C1138i.C1140b) WorkDatabase_Impl.this.f3566c.get(i)).mo6177a(bVar);
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: e */
            public void mo6186e(C0813b bVar) {
                C0813b bVar2 = bVar;
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new C1112d.C1113a("work_spec_id", "TEXT", true, 1));
                hashMap.put("prerequisite_id", new C1112d.C1113a("prerequisite_id", "TEXT", true, 2));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new C1112d.C1114b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new C1112d.C1114b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new C1112d.C1116d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                hashSet2.add(new C1112d.C1116d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
                C1112d dVar = new C1112d("Dependency", hashMap, hashSet, hashSet2);
                C1112d a = C1112d.m4414a(bVar2, "Dependency");
                if (dVar.equals(a)) {
                    HashMap hashMap2 = new HashMap(23);
                    hashMap2.put("id", new C1112d.C1113a("id", "TEXT", true, 1));
                    hashMap2.put("state", new C1112d.C1113a("state", "INTEGER", true, 0));
                    hashMap2.put("worker_class_name", new C1112d.C1113a("worker_class_name", "TEXT", true, 0));
                    hashMap2.put("input_merger_class_name", new C1112d.C1113a("input_merger_class_name", "TEXT", false, 0));
                    hashMap2.put("input", new C1112d.C1113a("input", "BLOB", true, 0));
                    hashMap2.put("output", new C1112d.C1113a("output", "BLOB", true, 0));
                    hashMap2.put("initial_delay", new C1112d.C1113a("initial_delay", "INTEGER", true, 0));
                    hashMap2.put("interval_duration", new C1112d.C1113a("interval_duration", "INTEGER", true, 0));
                    hashMap2.put("flex_duration", new C1112d.C1113a("flex_duration", "INTEGER", true, 0));
                    hashMap2.put("run_attempt_count", new C1112d.C1113a("run_attempt_count", "INTEGER", true, 0));
                    hashMap2.put("backoff_policy", new C1112d.C1113a("backoff_policy", "INTEGER", true, 0));
                    hashMap2.put("backoff_delay_duration", new C1112d.C1113a("backoff_delay_duration", "INTEGER", true, 0));
                    hashMap2.put("period_start_time", new C1112d.C1113a("period_start_time", "INTEGER", true, 0));
                    hashMap2.put("minimum_retention_duration", new C1112d.C1113a("minimum_retention_duration", "INTEGER", true, 0));
                    hashMap2.put("schedule_requested_at", new C1112d.C1113a("schedule_requested_at", "INTEGER", true, 0));
                    hashMap2.put("required_network_type", new C1112d.C1113a("required_network_type", "INTEGER", false, 0));
                    hashMap2.put("requires_charging", new C1112d.C1113a("requires_charging", "INTEGER", true, 0));
                    hashMap2.put("requires_device_idle", new C1112d.C1113a("requires_device_idle", "INTEGER", true, 0));
                    hashMap2.put("requires_battery_not_low", new C1112d.C1113a("requires_battery_not_low", "INTEGER", true, 0));
                    hashMap2.put("requires_storage_not_low", new C1112d.C1113a("requires_storage_not_low", "INTEGER", true, 0));
                    hashMap2.put("trigger_content_update_delay", new C1112d.C1113a("trigger_content_update_delay", "INTEGER", true, 0));
                    hashMap2.put("trigger_max_content_delay", new C1112d.C1113a("trigger_max_content_delay", "INTEGER", true, 0));
                    hashMap2.put("content_uri_triggers", new C1112d.C1113a("content_uri_triggers", "BLOB", false, 0));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(1);
                    hashSet4.add(new C1112d.C1116d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                    C1112d dVar2 = new C1112d("WorkSpec", hashMap2, hashSet3, hashSet4);
                    C1112d a2 = C1112d.m4414a(bVar2, "WorkSpec");
                    if (dVar2.equals(a2)) {
                        HashMap hashMap3 = new HashMap(2);
                        hashMap3.put("tag", new C1112d.C1113a("tag", "TEXT", true, 1));
                        hashMap3.put("work_spec_id", new C1112d.C1113a("work_spec_id", "TEXT", true, 2));
                        HashSet hashSet5 = new HashSet(1);
                        hashSet5.add(new C1112d.C1114b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                        HashSet hashSet6 = new HashSet(1);
                        hashSet6.add(new C1112d.C1116d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                        C1112d dVar3 = new C1112d("WorkTag", hashMap3, hashSet5, hashSet6);
                        C1112d a3 = C1112d.m4414a(bVar2, "WorkTag");
                        if (dVar3.equals(a3)) {
                            HashMap hashMap4 = new HashMap(2);
                            hashMap4.put("work_spec_id", new C1112d.C1113a("work_spec_id", "TEXT", true, 1));
                            hashMap4.put("system_id", new C1112d.C1113a("system_id", "INTEGER", true, 0));
                            HashSet hashSet7 = new HashSet(1);
                            hashSet7.add(new C1112d.C1114b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                            C1112d dVar4 = new C1112d("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                            C1112d a4 = C1112d.m4414a(bVar2, "SystemIdInfo");
                            if (dVar4.equals(a4)) {
                                HashMap hashMap5 = new HashMap(2);
                                hashMap5.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new C1112d.C1113a(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", true, 1));
                                hashMap5.put("work_spec_id", new C1112d.C1113a("work_spec_id", "TEXT", true, 2));
                                HashSet hashSet8 = new HashSet(1);
                                hashSet8.add(new C1112d.C1114b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                                HashSet hashSet9 = new HashSet(1);
                                hashSet9.add(new C1112d.C1116d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                                C1112d dVar5 = new C1112d("WorkName", hashMap5, hashSet8, hashSet9);
                                C1112d a5 = C1112d.m4414a(bVar2, "WorkName");
                                if (!dVar5.equals(a5)) {
                                    throw new IllegalStateException("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar5 + "\n Found:\n" + a5);
                                }
                                return;
                            }
                            throw new IllegalStateException("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar4 + "\n Found:\n" + a4);
                        }
                        throw new IllegalStateException("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar3 + "\n Found:\n" + a3);
                    }
                    throw new IllegalStateException("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar2 + "\n Found:\n" + a2);
                }
                throw new IllegalStateException("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + a);
            }

            /* renamed from: f */
            public void mo6187f(C0813b bVar) {
                C1110b.m4410a(bVar);
            }

            /* renamed from: g */
            public void mo6188g(C0813b bVar) {
            }
        }, "c84d23ade98552f1cec71088c1f0794c", "1db8206f0da6aa81bbdd2d99a82d9e14")).mo4653a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1124f mo6162c() {
        return new C1124f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName");
    }

    /* renamed from: o */
    public C1243k mo6422o() {
        C1243k kVar;
        if (this.f3771d != null) {
            return this.f3771d;
        }
        synchronized (this) {
            if (this.f3771d == null) {
                this.f3771d = new C1244l(this);
            }
            kVar = this.f3771d;
        }
        return kVar;
    }

    /* renamed from: p */
    public C1228b mo6423p() {
        C1228b bVar;
        if (this.f3772e != null) {
            return this.f3772e;
        }
        synchronized (this) {
            if (this.f3772e == null) {
                this.f3772e = new C1229c(this);
            }
            bVar = this.f3772e;
        }
        return bVar;
    }

    /* renamed from: q */
    public C1255n mo6424q() {
        C1255n nVar;
        if (this.f3773f != null) {
            return this.f3773f;
        }
        synchronized (this) {
            if (this.f3773f == null) {
                this.f3773f = new C1256o(this);
            }
            nVar = this.f3773f;
        }
        return nVar;
    }

    /* renamed from: r */
    public C1232e mo6425r() {
        C1232e eVar;
        if (this.f3774g != null) {
            return this.f3774g;
        }
        synchronized (this) {
            if (this.f3774g == null) {
                this.f3774g = new C1233f(this);
            }
            eVar = this.f3774g;
        }
        return eVar;
    }

    /* renamed from: s */
    public C1237h mo6426s() {
        C1237h hVar;
        if (this.f3775h != null) {
            return this.f3775h;
        }
        synchronized (this) {
            if (this.f3775h == null) {
                this.f3775h = new C1238i(this);
            }
            hVar = this.f3775h;
        }
        return hVar;
    }
}
