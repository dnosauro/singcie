package androidx.room;

import android.content.Context;
import androidx.room.C1138i;
import org.apache.commons.p172io.FilenameUtils;

/* renamed from: androidx.room.h */
public class C1137h {
    /* renamed from: a */
    public static <T extends C1138i> C1138i.C1139a<T> m4457a(Context context, Class<T> cls) {
        return new C1138i.C1139a<>(context, cls, (String) null);
    }

    /* renamed from: a */
    public static <T extends C1138i> C1138i.C1139a<T> m4458a(Context context, Class<T> cls, String str) {
        if (str != null && str.trim().length() != 0) {
            return new C1138i.C1139a<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    /* renamed from: a */
    static <T, C> T m4459a(Class<C> cls, String str) {
        String str2;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str3 = canonicalName.replace(FilenameUtils.EXTENSION_SEPARATOR, '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + "." + str3;
            }
            return Class.forName(str2).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
