package androidx.room.p057b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0820e;
import androidx.room.C1138i;
import java.util.ArrayList;

/* renamed from: androidx.room.b.b */
public class C1110b {
    /* renamed from: a */
    public static Cursor m4409a(C1138i iVar, C0820e eVar, boolean z) {
        Cursor a = iVar.mo6155a(eVar);
        if (!z || !(a instanceof AbstractWindowedCursor)) {
            return a;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) a;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? C1109a.m4408a(abstractWindowedCursor) : a;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static void m4410a(C0813b bVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor b = bVar.mo4615b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b.moveToNext()) {
            try {
                arrayList.add(b.getString(0));
            } catch (Throwable th) {
                b.close();
                throw th;
            }
        }
        b.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.mo4618c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
