package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpb;
import com.parse.ParseQuery;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzoy<T extends zzpb> extends Handler implements Runnable {
    private volatile boolean zzagh;
    private final T zzbji;
    private final zzoz<T> zzbjj;
    public final int zzbjk;
    private final long zzbjl;
    private IOException zzbjm;
    private int zzbjn;
    private volatile Thread zzbjo;
    private final /* synthetic */ zzow zzbjp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzoy(zzow zzow, Looper looper, T t, zzoz<T> zzoz, int i, long j) {
        super(looper);
        this.zzbjp = zzow;
        this.zzbji = t;
        this.zzbjj = zzoz;
        this.zzbjk = i;
        this.zzbjl = j;
    }

    private final void execute() {
        this.zzbjm = null;
        this.zzbjp.zzbjd.execute(this.zzbjp.zzbje);
    }

    private final void finish() {
        zzoy unused = this.zzbjp.zzbje = null;
    }

    public final void handleMessage(Message message) {
        if (!this.zzagh) {
            if (message.what == 0) {
                execute();
            } else if (message.what != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbjl;
                if (this.zzbji.zzhx()) {
                    this.zzbjj.zza(this.zzbji, elapsedRealtime, j, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.zzbjj.zza(this.zzbji, elapsedRealtime, j, false);
                        return;
                    case 2:
                        this.zzbjj.zza(this.zzbji, elapsedRealtime, j);
                        return;
                    case 3:
                        this.zzbjm = (IOException) message.obj;
                        int zza = this.zzbjj.zza(this.zzbji, elapsedRealtime, j, this.zzbjm);
                        if (zza == 3) {
                            IOException unused = this.zzbjp.zzbjf = this.zzbjm;
                            return;
                        } else if (zza != 2) {
                            this.zzbjn = zza == 1 ? 1 : this.zzbjn + 1;
                            zzek((long) Math.min((this.zzbjn - 1) * ParseQuery.MAX_LIMIT, 5000));
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        try {
            this.zzbjo = Thread.currentThread();
            if (!this.zzbji.zzhx()) {
                String valueOf = String.valueOf(this.zzbji.getClass().getSimpleName());
                zzpq.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                this.zzbji.zzhy();
                zzpq.endSection();
            }
            if (!this.zzagh) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzagh) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzpc.checkState(this.zzbji.zzhx());
            if (!this.zzagh) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzagh) {
                obtainMessage(3, new zzpa(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzagh) {
                obtainMessage(3, new zzpa(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzagh) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzpq.endSection();
            throw th;
        }
    }

    public final void zzbg(int i) {
        IOException iOException = this.zzbjm;
        if (iOException != null && this.zzbjn > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzpc.checkState(this.zzbjp.zzbje == null);
        zzoy unused = this.zzbjp.zzbje = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzagh = z;
        this.zzbjm = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbji.cancelLoad();
            if (this.zzbjo != null) {
                this.zzbjo.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjj.zza(this.zzbji, elapsedRealtime, elapsedRealtime - this.zzbjl, true);
        }
    }
}
