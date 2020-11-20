package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bolts.Task;

abstract class ParseSQLiteOpenHelper {
    private final SQLiteOpenHelper helper;

    public ParseSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this.helper = new SQLiteOpenHelper(context, str, cursorFactory, i) {
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                ParseSQLiteOpenHelper.this.onCreate(sQLiteDatabase);
            }

            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                super.onOpen(sQLiteDatabase);
                ParseSQLiteOpenHelper.this.onOpen(sQLiteDatabase);
            }

            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                ParseSQLiteOpenHelper.this.onUpgrade(sQLiteDatabase, i, i2);
            }
        };
    }

    private Task<ParseSQLiteDatabase> getDatabaseAsync(boolean z) {
        return ParseSQLiteDatabase.openDatabaseAsync(this.helper, z ^ true ? 1 : 0);
    }

    public Task<ParseSQLiteDatabase> getReadableDatabaseAsync() {
        return getDatabaseAsync(false);
    }

    public Task<ParseSQLiteDatabase> getWritableDatabaseAsync() {
        return getDatabaseAsync(true);
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
