package com.google.android.gms.internal.ads;

import org.apache.commons.p172io.IOUtils;

final class zzenb {
    static String zzan(zzeiu zzeiu) {
        String str;
        zzene zzene = new zzene(zzeiu);
        StringBuilder sb = new StringBuilder(zzene.size());
        for (int i = 0; i < zzene.size(); i++) {
            int zzfy = zzene.zzfy(i);
            if (zzfy == 34) {
                str = "\\\"";
            } else if (zzfy == 39) {
                str = "\\'";
            } else if (zzfy != 92) {
                switch (zzfy) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zzfy < 32 || zzfy > 126) {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zzfy >>> 6) & 3) + 48));
                            sb.append((char) (((zzfy >>> 3) & 7) + 48));
                            zzfy = (zzfy & 7) + 48;
                        }
                        sb.append((char) zzfy);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
