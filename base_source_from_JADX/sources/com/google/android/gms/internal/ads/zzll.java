package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzmd;

final class zzll {
    private static final int zzayv = zzpt.zzbh("nam");
    private static final int zzayw = zzpt.zzbh("trk");
    private static final int zzayx = zzpt.zzbh("cmt");
    private static final int zzayy = zzpt.zzbh("day");
    private static final int zzayz = zzpt.zzbh("ART");
    private static final int zzaza = zzpt.zzbh("too");
    private static final int zzazb = zzpt.zzbh("alb");
    private static final int zzazc = zzpt.zzbh("com");
    private static final int zzazd = zzpt.zzbh("wrt");
    private static final int zzaze = zzpt.zzbh("lyr");
    private static final int zzazf = zzpt.zzbh("gen");
    private static final int zzazg = zzpt.zzbh("covr");
    private static final int zzazh = zzpt.zzbh("gnre");
    private static final int zzazi = zzpt.zzbh("grp");
    private static final int zzazj = zzpt.zzbh("disk");
    private static final int zzazk = zzpt.zzbh("trkn");
    private static final int zzazl = zzpt.zzbh("tmpo");
    private static final int zzazm = zzpt.zzbh("cpil");
    private static final int zzazn = zzpt.zzbh("aART");
    private static final int zzazo = zzpt.zzbh("sonm");
    private static final int zzazp = zzpt.zzbh("soal");
    private static final int zzazq = zzpt.zzbh("soar");
    private static final int zzazr = zzpt.zzbh("soaa");
    private static final int zzazs = zzpt.zzbh("soco");
    private static final int zzazt = zzpt.zzbh("rtng");
    private static final int zzazu = zzpt.zzbh("pgap");
    private static final int zzazv = zzpt.zzbh("sosn");
    private static final int zzazw = zzpt.zzbh("tvsh");
    private static final int zzazx = zzpt.zzbh("----");
    private static final String[] zzazy = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzmk zza(int i, String str, zzpn zzpn, boolean z, boolean z2) {
        int zze = zze(zzpn);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze >= 0) {
            return z ? new zzmn(str, (String) null, Integer.toString(zze)) : new zzmj("und", str, Integer.toString(zze));
        }
        String valueOf = String.valueOf(zzks.zzaq(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzmn zza(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == zzks.zzavv) {
            zzpn.zzbm(8);
            return new zzmn(str, (String) null, zzpn.zzbn(readInt - 16));
        }
        String valueOf = String.valueOf(zzks.zzaq(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzmn zzb(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == zzks.zzavv && readInt >= 22) {
            zzpn.zzbm(10);
            int readUnsignedShort = zzpn.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpn.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzks.zzaq(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static zzmd.zza zzd(zzpn zzpn) {
        String str;
        String str2;
        zzmn zzmn;
        int position = zzpn.getPosition() + zzpn.readInt();
        int readInt = zzpn.readInt();
        int i = readInt >>> 24;
        zzmk zzmk = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzayx) {
                int readInt2 = zzpn.readInt();
                if (zzpn.readInt() == zzks.zzavv) {
                    zzpn.zzbm(8);
                    String zzbn = zzpn.zzbn(readInt2 - 16);
                    zzmk = new zzmj("und", zzbn, zzbn);
                } else {
                    String valueOf = String.valueOf(zzks.zzaq(readInt));
                    Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                }
                zzpn.zzbl(position);
                return zzmk;
            }
            if (i2 != zzayv) {
                if (i2 != zzayw) {
                    if (i2 != zzazc) {
                        if (i2 != zzazd) {
                            if (i2 == zzayy) {
                                zzmn zza = zza(readInt, "TDRC", zzpn);
                                zzpn.zzbl(position);
                                return zza;
                            } else if (i2 == zzayz) {
                                zzmn zza2 = zza(readInt, "TPE1", zzpn);
                                zzpn.zzbl(position);
                                return zza2;
                            } else if (i2 == zzaza) {
                                zzmn zza3 = zza(readInt, "TSSE", zzpn);
                                zzpn.zzbl(position);
                                return zza3;
                            } else if (i2 == zzazb) {
                                zzmn zza4 = zza(readInt, "TALB", zzpn);
                                zzpn.zzbl(position);
                                return zza4;
                            } else if (i2 == zzaze) {
                                zzmn zza5 = zza(readInt, "USLT", zzpn);
                                zzpn.zzbl(position);
                                return zza5;
                            } else if (i2 == zzazf) {
                                zzmn zza6 = zza(readInt, "TCON", zzpn);
                                zzpn.zzbl(position);
                                return zza6;
                            } else if (i2 == zzazi) {
                                zzmn zza7 = zza(readInt, "TIT1", zzpn);
                                zzpn.zzbl(position);
                                return zza7;
                            }
                        }
                    }
                    zzmn zza8 = zza(readInt, "TCOM", zzpn);
                    zzpn.zzbl(position);
                    return zza8;
                }
            }
            zzmn zza9 = zza(readInt, "TIT2", zzpn);
            zzpn.zzbl(position);
            return zza9;
        }
        try {
            if (readInt == zzazh) {
                int zze = zze(zzpn);
                String str3 = (zze <= 0 || zze > zzazy.length) ? null : zzazy[zze - 1];
                if (str3 != null) {
                    zzmn = new zzmn("TCON", (String) null, str3);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzmn = null;
                }
                return zzmn;
            } else if (readInt == zzazj) {
                zzmn zzb = zzb(readInt, "TPOS", zzpn);
                zzpn.zzbl(position);
                return zzb;
            } else if (readInt == zzazk) {
                zzmn zzb2 = zzb(readInt, "TRCK", zzpn);
                zzpn.zzbl(position);
                return zzb2;
            } else if (readInt == zzazl) {
                zzmk zza10 = zza(readInt, "TBPM", zzpn, true, false);
                zzpn.zzbl(position);
                return zza10;
            } else if (readInt == zzazm) {
                zzmk zza11 = zza(readInt, "TCMP", zzpn, true, true);
                zzpn.zzbl(position);
                return zza11;
            } else if (readInt == zzazg) {
                int readInt3 = zzpn.readInt();
                if (zzpn.readInt() == zzks.zzavv) {
                    int zzap = zzks.zzap(zzpn.readInt());
                    String str4 = zzap == 13 ? "image/jpeg" : zzap == 14 ? "image/png" : null;
                    if (str4 == null) {
                        str = "MetadataUtil";
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzap);
                        str2 = sb.toString();
                    } else {
                        zzpn.zzbm(4);
                        byte[] bArr = new byte[(readInt3 - 16)];
                        zzpn.zze(bArr, 0, bArr.length);
                        zzmk = new zzmh(str4, (String) null, 3, bArr);
                        zzpn.zzbl(position);
                        return zzmk;
                    }
                } else {
                    str = "MetadataUtil";
                    str2 = "Failed to parse cover art attribute";
                }
                Log.w(str, str2);
                zzpn.zzbl(position);
                return zzmk;
            } else if (readInt == zzazn) {
                zzmn zza12 = zza(readInt, "TPE2", zzpn);
                zzpn.zzbl(position);
                return zza12;
            } else if (readInt == zzazo) {
                zzmn zza13 = zza(readInt, "TSOT", zzpn);
                zzpn.zzbl(position);
                return zza13;
            } else if (readInt == zzazp) {
                zzmn zza14 = zza(readInt, "TSO2", zzpn);
                zzpn.zzbl(position);
                return zza14;
            } else if (readInt == zzazq) {
                zzmn zza15 = zza(readInt, "TSOA", zzpn);
                zzpn.zzbl(position);
                return zza15;
            } else if (readInt == zzazr) {
                zzmn zza16 = zza(readInt, "TSOP", zzpn);
                zzpn.zzbl(position);
                return zza16;
            } else if (readInt == zzazs) {
                zzmn zza17 = zza(readInt, "TSOC", zzpn);
                zzpn.zzbl(position);
                return zza17;
            } else if (readInt == zzazt) {
                zzmk zza18 = zza(readInt, "ITUNESADVISORY", zzpn, false, false);
                zzpn.zzbl(position);
                return zza18;
            } else if (readInt == zzazu) {
                zzmk zza19 = zza(readInt, "ITUNESGAPLESS", zzpn, false, true);
                zzpn.zzbl(position);
                return zza19;
            } else if (readInt == zzazv) {
                zzmn zza20 = zza(readInt, "TVSHOWSORT", zzpn);
                zzpn.zzbl(position);
                return zza20;
            } else if (readInt == zzazw) {
                zzmn zza21 = zza(readInt, "TVSHOW", zzpn);
                zzpn.zzbl(position);
                return zza21;
            } else if (readInt == zzazx) {
                String str5 = null;
                String str6 = null;
                int i3 = -1;
                int i4 = -1;
                while (zzpn.getPosition() < position) {
                    int position2 = zzpn.getPosition();
                    int readInt4 = zzpn.readInt();
                    int readInt5 = zzpn.readInt();
                    zzpn.zzbm(4);
                    if (readInt5 == zzks.zzavt) {
                        str5 = zzpn.zzbn(readInt4 - 12);
                    } else if (readInt5 == zzks.zzavu) {
                        str6 = zzpn.zzbn(readInt4 - 12);
                    } else {
                        if (readInt5 == zzks.zzavv) {
                            i3 = position2;
                            i4 = readInt4;
                        }
                        zzpn.zzbm(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str5) && "iTunSMPB".equals(str6)) {
                    if (i3 != -1) {
                        zzpn.zzbl(i3);
                        zzpn.zzbm(16);
                        zzmk = new zzmj("und", str6, zzpn.zzbn(i4 - 16));
                    }
                }
                zzpn.zzbl(position);
                return zzmk;
            }
        } finally {
            zzpn.zzbl(position);
        }
        String valueOf2 = String.valueOf(zzks.zzaq(readInt));
        Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
        zzpn.zzbl(position);
        return null;
    }

    private static int zze(zzpn zzpn) {
        zzpn.zzbm(4);
        if (zzpn.readInt() == zzks.zzavv) {
            zzpn.zzbm(8);
            return zzpn.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
