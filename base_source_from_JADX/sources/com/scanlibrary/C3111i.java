package com.scanlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.ByteArrayOutputStream;

/* renamed from: com.scanlibrary.i */
public class C3111i {
    /* renamed from: a */
    public static Bitmap m8939a(Context context, Uri uri) {
        return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
    }

    /* renamed from: a */
    public static Uri m8940a(Context context, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", (String) null));
    }
}
