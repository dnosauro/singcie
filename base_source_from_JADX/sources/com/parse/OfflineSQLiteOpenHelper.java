package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

class OfflineSQLiteOpenHelper extends ParseSQLiteOpenHelper {
    private static final String DATABASE_NAME = "ParseOfflineStore";
    private static final int DATABASE_VERSION = 4;
    static final String KEY_CLASS_NAME = "className";
    static final String KEY_IS_DELETING_EVENTUALLY = "isDeletingEventually";
    static final String KEY_JSON = "json";
    static final String KEY_KEY = "key";
    static final String KEY_OBJECT_ID = "objectId";
    static final String KEY_UUID = "uuid";
    static final String TABLE_DEPENDENCIES = "Dependencies";
    static final String TABLE_OBJECTS = "ParseObjects";

    public OfflineSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 4);
    }

    private void createSchema(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ParseObjects (uuid TEXT PRIMARY KEY, className TEXT NOT NULL, objectId TEXT, json TEXT, isDeletingEventually INTEGER DEFAULT 0, UNIQUE(className, objectId));");
        sQLiteDatabase.execSQL("CREATE TABLE Dependencies (key TEXT NOT NULL, uuid TEXT NOT NULL, PRIMARY KEY(key, uuid));");
    }

    public void clearDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createSchema(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
