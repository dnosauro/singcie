package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.p046i.p047a.C0813b;
import androidx.room.p056a.C1107a;
import androidx.work.impl.utils.C1316e;

/* renamed from: androidx.work.impl.g */
public class C1284g {

    /* renamed from: a */
    public static C1107a f3982a = new C1107a(1, 2) {
        /* renamed from: a */
        public void mo6106a(C0813b bVar) {
            bVar.mo4618c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.mo4618c("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.mo4618c("DROP TABLE IF EXISTS alarmInfo");
            bVar.mo4618c("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };

    /* renamed from: b */
    public static C1107a f3983b = new C1107a(3, 4) {
        /* renamed from: a */
        public void mo6106a(C0813b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.mo4618c("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };

    /* renamed from: c */
    public static C1107a f3984c = new C1107a(4, 5) {
        /* renamed from: a */
        public void mo6106a(C0813b bVar) {
            bVar.mo4618c("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.mo4618c("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* renamed from: androidx.work.impl.g$a */
    public static class C1288a extends C1107a {

        /* renamed from: c */
        final Context f3985c;

        public C1288a(Context context, int i, int i2) {
            super(i, i2);
            this.f3985c = context;
        }

        /* renamed from: a */
        public void mo6106a(C0813b bVar) {
            new C1316e(this.f3985c).mo6655a(true);
        }
    }
}
