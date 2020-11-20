package com.parse;

import android.os.Parcel;

interface ParseFieldOperation {
    Object apply(Object obj, String str);

    Object encode(ParseEncoder parseEncoder);

    void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder);

    ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation);
}
