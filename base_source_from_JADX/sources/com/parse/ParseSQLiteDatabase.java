package com.parse;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ParseSQLiteDatabase {
    /* access modifiers changed from: private */
    public static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();
    private static final TaskQueue taskQueue = new TaskQueue();
    /* access modifiers changed from: private */
    public Task<Void> current = null;
    /* access modifiers changed from: private */
    public final Object currentLock = new Object();
    /* access modifiers changed from: private */

    /* renamed from: db */
    public SQLiteDatabase f7070db;
    /* access modifiers changed from: private */
    public int openFlags;
    /* access modifiers changed from: private */
    public final TaskCompletionSource<Void> tcs = new TaskCompletionSource<>();

    private ParseSQLiteDatabase(int i) {
        this.openFlags = i;
        taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                synchronized (ParseSQLiteDatabase.this.currentLock) {
                    Task unused = ParseSQLiteDatabase.this.current = task;
                }
                return ParseSQLiteDatabase.this.tcs.getTask();
            }
        });
    }

    static Task<ParseSQLiteDatabase> openDatabaseAsync(SQLiteOpenHelper sQLiteOpenHelper, int i) {
        ParseSQLiteDatabase parseSQLiteDatabase = new ParseSQLiteDatabase(i);
        return parseSQLiteDatabase.open(sQLiteOpenHelper).continueWithTask(new Continuation<Void, Task<ParseSQLiteDatabase>>(parseSQLiteDatabase) {
            final /* synthetic */ ParseSQLiteDatabase val$db;

            {
                this.val$db = r1;
            }

            public Task<ParseSQLiteDatabase> then(Task<Void> task) {
                return Task.forResult(this.val$db);
            }
        });
    }

    public Task<Void> beginTransactionAsync() {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            this.current = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    ParseSQLiteDatabase.this.f7070db.beginTransaction();
                    return task;
                }
            }, (Executor) dbExecutor);
            continueWithTask = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public Task<Void> closeAsync() {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            this.current = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                /* JADX INFO: finally extract failed */
                public Task<Void> then(Task<Void> task) {
                    try {
                        ParseSQLiteDatabase.this.f7070db.close();
                        ParseSQLiteDatabase.this.tcs.setResult(null);
                        return ParseSQLiteDatabase.this.tcs.getTask();
                    } catch (Throwable th) {
                        ParseSQLiteDatabase.this.tcs.setResult(null);
                        throw th;
                    }
                }
            }, (Executor) dbExecutor);
            continueWithTask = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public Task<Void> deleteAsync(final String str, final String str2, final String[] strArr) {
        Task<Void> makeVoid;
        synchronized (this.currentLock) {
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Integer>() {
                public Integer then(Task<Void> task) {
                    return Integer.valueOf(ParseSQLiteDatabase.this.f7070db.delete(str, str2, strArr));
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            makeVoid = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Integer, Task<Integer>>() {
                public Task<Integer> then(Task<Integer> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return makeVoid;
    }

    public Task<Void> endTransactionAsync() {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            this.current = this.current.continueWith(new Continuation<Void, Void>() {
                public Void then(Task<Void> task) {
                    ParseSQLiteDatabase.this.f7070db.endTransaction();
                    return null;
                }
            }, (Executor) dbExecutor);
            continueWithTask = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public boolean inTransaction() {
        return this.f7070db.inTransaction();
    }

    public Task<Void> insertOrThrowAsync(final String str, final ContentValues contentValues) {
        Task<Void> makeVoid;
        synchronized (this.currentLock) {
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Long>() {
                public Long then(Task<Void> task) {
                    return Long.valueOf(ParseSQLiteDatabase.this.f7070db.insertOrThrow(str, (String) null, contentValues));
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            makeVoid = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Long, Task<Long>>() {
                public Task<Long> then(Task<Long> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return makeVoid;
    }

    public Task<Void> insertWithOnConflict(final String str, final ContentValues contentValues, final int i) {
        Task<Void> makeVoid;
        synchronized (this.currentLock) {
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Long>() {
                public Long then(Task<Void> task) {
                    return Long.valueOf(ParseSQLiteDatabase.this.f7070db.insertWithOnConflict(str, (String) null, contentValues, i));
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            makeVoid = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Long, Task<Long>>() {
                public Task<Long> then(Task<Long> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return makeVoid;
    }

    public Task<Boolean> isOpenAsync() {
        Task<TContinuationResult> continueWith;
        synchronized (this.currentLock) {
            continueWith = this.current.continueWith(new Continuation<Void, Boolean>() {
                public Boolean then(Task<Void> task) {
                    return Boolean.valueOf(ParseSQLiteDatabase.this.f7070db.isOpen());
                }
            });
            this.current = continueWith.makeVoid();
        }
        return continueWith;
    }

    public Task<Boolean> isReadOnlyAsync() {
        Task<TContinuationResult> continueWith;
        synchronized (this.currentLock) {
            continueWith = this.current.continueWith(new Continuation<Void, Boolean>() {
                public Boolean then(Task<Void> task) {
                    return Boolean.valueOf(ParseSQLiteDatabase.this.f7070db.isReadOnly());
                }
            });
            this.current = continueWith.makeVoid();
        }
        return continueWith;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> open(final SQLiteOpenHelper sQLiteOpenHelper) {
        Task<Void> task;
        synchronized (this.currentLock) {
            this.current = this.current.continueWith(new Continuation<Void, SQLiteDatabase>() {
                public SQLiteDatabase then(Task<Void> task) {
                    return (ParseSQLiteDatabase.this.openFlags & 1) == 1 ? sQLiteOpenHelper.getReadableDatabase() : sQLiteOpenHelper.getWritableDatabase();
                }
            }, (Executor) dbExecutor).continueWithTask(new Continuation<SQLiteDatabase, Task<Void>>() {
                public Task<Void> then(Task<SQLiteDatabase> task) {
                    SQLiteDatabase unused = ParseSQLiteDatabase.this.f7070db = task.getResult();
                    return task.makeVoid();
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
            task = this.current;
        }
        return task;
    }

    public Task<Cursor> queryAsync(String str, String[] strArr, String str2, String[] strArr2) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            final String str3 = str;
            final String[] strArr3 = strArr;
            final String str4 = str2;
            final String[] strArr4 = strArr2;
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Cursor>() {
                public Cursor then(Task<Void> task) {
                    return ParseSQLiteDatabase.this.f7070db.query(str3, strArr3, str4, strArr4, (String) null, (String) null, (String) null);
                }
            }, (Executor) dbExecutor).onSuccess(new Continuation<Cursor, Cursor>() {
                public Cursor then(Task<Cursor> task) {
                    Cursor create = ParseSQLiteCursor.create(task.getResult(), ParseSQLiteDatabase.dbExecutor);
                    create.getCount();
                    return create;
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            continueWithTask = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Cursor, Task<Cursor>>() {
                public Task<Cursor> then(Task<Cursor> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public Task<Cursor> rawQueryAsync(final String str, final String[] strArr) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Cursor>() {
                public Cursor then(Task<Void> task) {
                    return ParseSQLiteDatabase.this.f7070db.rawQuery(str, strArr);
                }
            }, (Executor) dbExecutor).onSuccess(new Continuation<Cursor, Cursor>() {
                public Cursor then(Task<Cursor> task) {
                    Cursor create = ParseSQLiteCursor.create(task.getResult(), ParseSQLiteDatabase.dbExecutor);
                    create.getCount();
                    return create;
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            continueWithTask = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Cursor, Task<Cursor>>() {
                public Task<Cursor> then(Task<Cursor> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public Task<Void> setTransactionSuccessfulAsync() {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            this.current = this.current.onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    ParseSQLiteDatabase.this.f7070db.setTransactionSuccessful();
                    return task;
                }
            }, (Executor) dbExecutor);
            continueWithTask = this.current.continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }

    public Task<Integer> updateAsync(String str, ContentValues contentValues, String str2, String[] strArr) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.currentLock) {
            final String str3 = str;
            final ContentValues contentValues2 = contentValues;
            final String str4 = str2;
            final String[] strArr2 = strArr;
            Task<TContinuationResult> onSuccess = this.current.onSuccess(new Continuation<Void, Integer>() {
                public Integer then(Task<Void> task) {
                    return Integer.valueOf(ParseSQLiteDatabase.this.f7070db.update(str3, contentValues2, str4, strArr2));
                }
            }, (Executor) dbExecutor);
            this.current = onSuccess.makeVoid();
            continueWithTask = onSuccess.continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation<Integer, Task<Integer>>() {
                public Task<Integer> then(Task<Integer> task) {
                    return task;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
        }
        return continueWithTask;
    }
}
