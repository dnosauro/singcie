package com.parse;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import bolts.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

class ParseSQLiteCursor implements Cursor {
    /* access modifiers changed from: private */
    public Cursor cursor;
    private Executor executor;

    private ParseSQLiteCursor(Cursor cursor2, Executor executor2) {
        this.cursor = cursor2;
        this.executor = executor2;
    }

    public static Cursor create(Cursor cursor2, Executor executor2) {
        return Build.VERSION.SDK_INT >= 14 ? cursor2 : new ParseSQLiteCursor(cursor2, executor2);
    }

    public void close() {
        Task.call(new Callable<Void>() {
            public Void call() {
                ParseSQLiteCursor.this.cursor.close();
                return null;
            }
        }, this.executor);
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        this.cursor.copyStringToBuffer(i, charArrayBuffer);
    }

    @Deprecated
    public void deactivate() {
        this.cursor.deactivate();
    }

    public byte[] getBlob(int i) {
        return this.cursor.getBlob(i);
    }

    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    public int getColumnIndex(String str) {
        return this.cursor.getColumnIndex(str);
    }

    public int getColumnIndexOrThrow(String str) {
        return this.cursor.getColumnIndexOrThrow(str);
    }

    public String getColumnName(int i) {
        return this.cursor.getColumnName(i);
    }

    public String[] getColumnNames() {
        return this.cursor.getColumnNames();
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public double getDouble(int i) {
        return this.cursor.getDouble(i);
    }

    public Bundle getExtras() {
        return this.cursor.getExtras();
    }

    public float getFloat(int i) {
        return this.cursor.getFloat(i);
    }

    public int getInt(int i) {
        return this.cursor.getInt(i);
    }

    public long getLong(int i) {
        return this.cursor.getLong(i);
    }

    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.cursor.getNotificationUri();
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    public short getShort(int i) {
        return this.cursor.getShort(i);
    }

    public String getString(int i) {
        return this.cursor.getString(i);
    }

    @TargetApi(11)
    public int getType(int i) {
        return this.cursor.getType(i);
    }

    public boolean getWantsAllOnMoveCalls() {
        return this.cursor.getWantsAllOnMoveCalls();
    }

    public boolean isAfterLast() {
        return this.cursor.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return this.cursor.isBeforeFirst();
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public boolean isFirst() {
        return this.cursor.isFirst();
    }

    public boolean isLast() {
        return this.cursor.isLast();
    }

    public boolean isNull(int i) {
        return this.cursor.isNull(i);
    }

    public boolean move(int i) {
        return this.cursor.move(i);
    }

    public boolean moveToFirst() {
        return this.cursor.moveToFirst();
    }

    public boolean moveToLast() {
        return this.cursor.moveToLast();
    }

    public boolean moveToNext() {
        return this.cursor.moveToNext();
    }

    public boolean moveToPosition(int i) {
        return this.cursor.moveToPosition(i);
    }

    public boolean moveToPrevious() {
        return this.cursor.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.cursor.registerContentObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.cursor.registerDataSetObserver(dataSetObserver);
    }

    @Deprecated
    public boolean requery() {
        return this.cursor.requery();
    }

    public Bundle respond(Bundle bundle) {
        return this.cursor.respond(bundle);
    }

    @TargetApi(23)
    public void setExtras(Bundle bundle) {
        this.cursor.setExtras(bundle);
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.cursor.setNotificationUri(contentResolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.cursor.unregisterContentObserver(contentObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.cursor.unregisterDataSetObserver(dataSetObserver);
    }
}
