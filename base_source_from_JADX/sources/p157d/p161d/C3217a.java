package p157d.p161d;

import org.jetbrains.annotations.NotNull;
import p157d.C3266f;
import p157d.p161d.p163b.C3243b;
import p157d.p161d.p163b.C3250h;
import p157d.p165f.C3268b;

/* renamed from: d.d.a */
public final class C3217a {
    @NotNull
    /* renamed from: a */
    public static final <T> Class<T> m9031a(@NotNull C3268b<T> bVar) {
        C3250h.m9056b(bVar, "$this$javaObjectType");
        Class a = ((C3243b) bVar).mo25692a();
        if (a.isPrimitive()) {
            String name = a.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            a = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            a = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            a = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            a = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            a = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            a = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            a = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            a = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            a = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (a != null) {
                return a;
            }
            throw new C3266f("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (a != null) {
            return a;
        } else {
            throw new C3266f("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }
}
