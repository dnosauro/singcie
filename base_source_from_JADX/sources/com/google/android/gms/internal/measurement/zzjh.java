package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;
import org.apache.commons.p172io.IOUtils;

final class zzjh {
    static String zza(zzjg zzjg, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzjg, sb, 0);
        return sb.toString();
    }

    private static final String zza(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01fe, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0210, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0221, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0233, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L_0x0200;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0268  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzjg r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r13.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x001a:
            if (r6 >= r4) goto L_0x0049
            r7 = r3[r6]
            java.lang.String r8 = r7.getName()
            r1.put(r8, r7)
            java.lang.Class[] r8 = r7.getParameterTypes()
            int r8 = r8.length
            if (r8 != 0) goto L_0x0046
            java.lang.String r8 = r7.getName()
            r0.put(r8, r7)
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "get"
            boolean r8 = r8.startsWith(r9)
            if (r8 == 0) goto L_0x0046
            java.lang.String r7 = r7.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0281
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "get"
            boolean r4 = r3.startsWith(r4)
            r6 = 3
            if (r4 == 0) goto L_0x0067
            java.lang.String r4 = r3.substring(r6)
            goto L_0x0068
        L_0x0067:
            r4 = r3
        L_0x0068:
            java.lang.String r7 = "List"
            boolean r7 = r4.endsWith(r7)
            r8 = 1
            if (r7 == 0) goto L_0x00cf
            java.lang.String r7 = "OrBuilderList"
            boolean r7 = r4.endsWith(r7)
            if (r7 != 0) goto L_0x00cf
            java.lang.String r7 = "List"
            boolean r7 = r4.equals(r7)
            if (r7 != 0) goto L_0x00cf
            java.lang.String r7 = r4.substring(r5, r8)
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r9 = r4.length()
            int r9 = r9 + -4
            java.lang.String r9 = r4.substring(r8, r9)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r10 = r9.length()
            if (r10 == 0) goto L_0x00a6
            java.lang.String r7 = r7.concat(r9)
            goto L_0x00ac
        L_0x00a6:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r7)
            r7 = r9
        L_0x00ac:
            java.lang.Object r9 = r0.get(r3)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r9 == 0) goto L_0x00cf
            java.lang.Class r10 = r9.getReturnType()
            java.lang.Class<java.util.List> r11 = java.util.List.class
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00cf
            java.lang.String r3 = zza(r7)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zza((java.lang.reflect.Method) r9, (java.lang.Object) r13, (java.lang.Object[]) r4)
            zza(r14, r15, r3, r4)
            goto L_0x004d
        L_0x00cf:
            java.lang.String r7 = "Map"
            boolean r7 = r4.endsWith(r7)
            if (r7 == 0) goto L_0x013d
            java.lang.String r7 = "Map"
            boolean r7 = r4.equals(r7)
            if (r7 != 0) goto L_0x013d
            java.lang.String r7 = r4.substring(r5, r8)
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r9 = r4.length()
            int r9 = r9 - r6
            java.lang.String r6 = r4.substring(r8, r9)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r9 = r6.length()
            if (r9 == 0) goto L_0x0103
            java.lang.String r6 = r7.concat(r6)
            goto L_0x0108
        L_0x0103:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r7)
        L_0x0108:
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x013d
            java.lang.Class r7 = r3.getReturnType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x013d
            java.lang.Class<java.lang.Deprecated> r7 = java.lang.Deprecated.class
            boolean r7 = r3.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x013d
            int r7 = r3.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isPublic(r7)
            if (r7 == 0) goto L_0x013d
            java.lang.String r4 = zza(r6)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zza((java.lang.reflect.Method) r3, (java.lang.Object) r13, (java.lang.Object[]) r6)
            zza(r14, r15, r4, r3)
            goto L_0x004d
        L_0x013d:
            java.lang.String r3 = "set"
            java.lang.String r6 = java.lang.String.valueOf(r4)
            int r7 = r6.length()
            if (r7 == 0) goto L_0x014e
            java.lang.String r3 = r3.concat(r6)
            goto L_0x0154
        L_0x014e:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x0154:
            java.lang.Object r3 = r1.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "Bytes"
            boolean r3 = r4.endsWith(r3)
            if (r3 == 0) goto L_0x018b
            java.lang.String r3 = "get"
            int r6 = r4.length()
            int r6 = r6 + -5
            java.lang.String r6 = r4.substring(r5, r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r7 = r6.length()
            if (r7 == 0) goto L_0x017f
            java.lang.String r3 = r3.concat(r6)
            goto L_0x0185
        L_0x017f:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x0185:
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x004d
        L_0x018b:
            java.lang.String r3 = r4.substring(r5, r8)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r6 = r4.substring(r8)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r7 = r6.length()
            if (r7 == 0) goto L_0x01aa
            java.lang.String r3 = r3.concat(r6)
            goto L_0x01b0
        L_0x01aa:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x01b0:
            java.lang.String r6 = "get"
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r9 = r7.length()
            if (r9 == 0) goto L_0x01c1
            java.lang.String r6 = r6.concat(r7)
            goto L_0x01c7
        L_0x01c1:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r6)
            r6 = r7
        L_0x01c7:
            java.lang.Object r6 = r0.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            java.lang.String r7 = "has"
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r9 = r4.length()
            if (r9 == 0) goto L_0x01de
            java.lang.String r4 = r7.concat(r4)
            goto L_0x01e3
        L_0x01de:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r7)
        L_0x01e3:
            java.lang.Object r4 = r0.get(r4)
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            if (r6 == 0) goto L_0x004d
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzhv.zza((java.lang.reflect.Method) r6, (java.lang.Object) r13, (java.lang.Object[]) r7)
            if (r4 != 0) goto L_0x026a
            boolean r4 = r6 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x0205
            r4 = r6
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0203
        L_0x0200:
            r4 = 1
            goto L_0x0264
        L_0x0203:
            r4 = 0
            goto L_0x0264
        L_0x0205:
            boolean r4 = r6 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0213
            r4 = r6
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x0203
            goto L_0x0200
        L_0x0213:
            boolean r4 = r6 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0224
            r4 = r6
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x0203
            goto L_0x0200
        L_0x0224:
            boolean r4 = r6 instanceof java.lang.Double
            if (r4 == 0) goto L_0x0236
            r4 = r6
            java.lang.Double r4 = (java.lang.Double) r4
            double r9 = r4.doubleValue()
            r11 = 0
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x0203
            goto L_0x0200
        L_0x0236:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x0241
            java.lang.String r4 = ""
        L_0x023c:
            boolean r4 = r6.equals(r4)
            goto L_0x0264
        L_0x0241:
            boolean r4 = r6 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r4 == 0) goto L_0x0248
            com.google.android.gms.internal.measurement.zzgm r4 = com.google.android.gms.internal.measurement.zzgm.zza
            goto L_0x023c
        L_0x0248:
            boolean r4 = r6 instanceof com.google.android.gms.internal.measurement.zzjg
            if (r4 == 0) goto L_0x0256
            r4 = r6
            com.google.android.gms.internal.measurement.zzjg r4 = (com.google.android.gms.internal.measurement.zzjg) r4
            com.google.android.gms.internal.measurement.zzjg r4 = r4.zzbv()
            if (r6 != r4) goto L_0x0203
            goto L_0x0200
        L_0x0256:
            boolean r4 = r6 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x0203
            r4 = r6
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r4 = r4.ordinal()
            if (r4 != 0) goto L_0x0203
            goto L_0x0200
        L_0x0264:
            if (r4 != 0) goto L_0x0268
            r4 = 1
            goto L_0x0276
        L_0x0268:
            r4 = 0
            goto L_0x0276
        L_0x026a:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zza((java.lang.reflect.Method) r4, (java.lang.Object) r13, (java.lang.Object[]) r7)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
        L_0x0276:
            if (r4 == 0) goto L_0x004d
            java.lang.String r3 = zza(r3)
            zza(r14, r15, r3, r6)
            goto L_0x004d
        L_0x0281:
            boolean r0 = r13 instanceof com.google.android.gms.internal.measurement.zzhv.zzd
            if (r0 == 0) goto L_0x02a7
            r0 = r13
            com.google.android.gms.internal.measurement.zzhv$zzd r0 = (com.google.android.gms.internal.measurement.zzhv.zzd) r0
            com.google.android.gms.internal.measurement.zzho<com.google.android.gms.internal.measurement.zzhv$zzc> r0 = r0.zzc
            java.util.Iterator r0 = r0.zzd()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0295
            goto L_0x02a7
        L_0x0295:
            java.lang.Object r13 = r0.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r13 = r13.getKey()
            com.google.android.gms.internal.measurement.zzhv$zzc r13 = (com.google.android.gms.internal.measurement.zzhv.zzc) r13
            java.lang.NoSuchMethodError r13 = new java.lang.NoSuchMethodError
            r13.<init>()
            throw r13
        L_0x02a7:
            com.google.android.gms.internal.measurement.zzhv r13 = (com.google.android.gms.internal.measurement.zzhv) r13
            com.google.android.gms.internal.measurement.zzkq r0 = r13.zzb
            if (r0 == 0) goto L_0x02b2
            com.google.android.gms.internal.measurement.zzkq r13 = r13.zzb
            r13.zza((java.lang.StringBuilder) r14, (int) r15)
        L_0x02b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjh.zza(com.google.android.gms.internal.measurement.zzjg, java.lang.StringBuilder, int):void");
    }

    static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza : (List) obj) {
                zza(sb, i, str, zza);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza2 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzkj.zza(zzgm.zza((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzgm) {
                sb.append(": \"");
                sb.append(zzkj.zza((zzgm) obj));
                sb.append('\"');
            } else if (obj instanceof zzhv) {
                sb.append(" {");
                zza((zzhv) obj, sb, i + 2);
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry.getKey());
                zza(sb, i4, "value", entry.getValue());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }
}
