package com.parse;

import android.os.Parcel;

class ParseParcelDecoder {
    private static final ParseParcelDecoder INSTANCE = new ParseParcelDecoder();

    ParseParcelDecoder() {
    }

    public static ParseParcelDecoder get() {
        return INSTANCE;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(android.os.Parcel r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.readString()
            int r1 = r0.hashCode()
            r2 = 0
            switch(r1) {
                case -1968751561: goto L_0x00a5;
                case -1939501217: goto L_0x009b;
                case -1910450513: goto L_0x0090;
                case -628296377: goto L_0x0086;
                case -489791972: goto L_0x007b;
                case 65642: goto L_0x0070;
                case 77116: goto L_0x0065;
                case 2122702: goto L_0x005b;
                case 2189724: goto L_0x0051;
                case 2439591: goto L_0x0046;
                case 64671819: goto L_0x003b;
                case 252152510: goto L_0x002f;
                case 1264047645: goto L_0x0024;
                case 1267133722: goto L_0x0019;
                case 1884169439: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x00b0
        L_0x000e:
            java.lang.String r1 = "GeoPoint"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 6
            goto L_0x00b1
        L_0x0019:
            java.lang.String r1 = "Polygon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 7
            goto L_0x00b1
        L_0x0024:
            java.lang.String r1 = "Pointer"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 1
            goto L_0x00b1
        L_0x002f:
            java.lang.String r1 = "Collection"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 11
            goto L_0x00b1
        L_0x003b:
            java.lang.String r1 = "Bytes"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 3
            goto L_0x00b1
        L_0x0046:
            java.lang.String r1 = "Null"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 13
            goto L_0x00b1
        L_0x0051:
            java.lang.String r1 = "File"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 5
            goto L_0x00b1
        L_0x005b:
            java.lang.String r1 = "Date"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 2
            goto L_0x00b1
        L_0x0065:
            java.lang.String r1 = "Map"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 10
            goto L_0x00b1
        L_0x0070:
            java.lang.String r1 = "Acl"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 8
            goto L_0x00b1
        L_0x007b:
            java.lang.String r1 = "Relation"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 9
            goto L_0x00b1
        L_0x0086:
            java.lang.String r1 = "Operation"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 4
            goto L_0x00b1
        L_0x0090:
            java.lang.String r1 = "JsonNull"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 12
            goto L_0x00b1
        L_0x009b:
            java.lang.String r1 = "Object"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 0
            goto L_0x00b1
        L_0x00a5:
            java.lang.String r1 = "Native"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b0
            r0 = 14
            goto L_0x00b1
        L_0x00b0:
            r0 = -1
        L_0x00b1:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0135;
                case 1: goto L_0x0130;
                case 2: goto L_0x0123;
                case 3: goto L_0x0119;
                case 4: goto L_0x0114;
                case 5: goto L_0x010e;
                case 6: goto L_0x0108;
                case 7: goto L_0x0102;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00f6;
                case 10: goto L_0x00dc;
                case 11: goto L_0x00c6;
                case 12: goto L_0x00c3;
                case 13: goto L_0x00c2;
                case 14: goto L_0x00bd;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r0 = "Could not unparcel objects from this Parcel."
            r6.<init>(r0)
            throw r6
        L_0x00bd:
            java.lang.Object r6 = r6.readValue(r1)
            return r6
        L_0x00c2:
            return r1
        L_0x00c3:
            java.lang.Object r6 = org.json.JSONObject.NULL
            return r6
        L_0x00c6:
            int r0 = r6.readInt()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x00cf:
            if (r2 >= r0) goto L_0x00db
            java.lang.Object r3 = r5.decode(r6)
            r1.add(r2, r3)
            int r2 = r2 + 1
            goto L_0x00cf
        L_0x00db:
            return r1
        L_0x00dc:
            int r0 = r6.readInt()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r0)
        L_0x00e5:
            if (r2 >= r0) goto L_0x00f5
            java.lang.String r3 = r6.readString()
            java.lang.Object r4 = r5.decode(r6)
            r1.put(r3, r4)
            int r2 = r2 + 1
            goto L_0x00e5
        L_0x00f5:
            return r1
        L_0x00f6:
            com.parse.ParseRelation r0 = new com.parse.ParseRelation
            r0.<init>((android.os.Parcel) r6, (com.parse.ParseParcelDecoder) r5)
            return r0
        L_0x00fc:
            com.parse.ParseACL r0 = new com.parse.ParseACL
            r0.<init>(r6, r5)
            return r0
        L_0x0102:
            com.parse.ParsePolygon r0 = new com.parse.ParsePolygon
            r0.<init>(r6, r5)
            return r0
        L_0x0108:
            com.parse.ParseGeoPoint r0 = new com.parse.ParseGeoPoint
            r0.<init>((android.os.Parcel) r6, (com.parse.ParseParcelDecoder) r5)
            return r0
        L_0x010e:
            com.parse.ParseFile r0 = new com.parse.ParseFile
            r0.<init>((android.os.Parcel) r6, (com.parse.ParseParcelDecoder) r5)
            return r0
        L_0x0114:
            com.parse.ParseFieldOperation r6 = com.parse.ParseFieldOperations.decode((android.os.Parcel) r6, (com.parse.ParseParcelDecoder) r5)
            return r6
        L_0x0119:
            int r0 = r6.readInt()
            byte[] r0 = new byte[r0]
            r6.readByteArray(r0)
            return r0
        L_0x0123:
            java.lang.String r6 = r6.readString()
            com.parse.ParseDateFormat r0 = com.parse.ParseDateFormat.getInstance()
            java.util.Date r6 = r0.parse(r6)
            return r6
        L_0x0130:
            com.parse.ParseObject r6 = r5.decodePointer(r6)
            return r6
        L_0x0135:
            com.parse.ParseObject r6 = r5.decodeParseObject(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseParcelDecoder.decode(android.os.Parcel):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public ParseObject decodeParseObject(Parcel parcel) {
        return ParseObject.createFromParcel(parcel, this);
    }

    /* access modifiers changed from: protected */
    public ParseObject decodePointer(Parcel parcel) {
        return ParseObject.createWithoutData(parcel.readString(), parcel.readString());
    }
}
