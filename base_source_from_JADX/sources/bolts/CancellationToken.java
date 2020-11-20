package bolts;

import java.util.Locale;

public class CancellationToken {
    private final CancellationTokenSource tokenSource;

    CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.tokenSource = cancellationTokenSource;
    }

    public boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public CancellationTokenRegistration register(Runnable runnable) {
        return this.tokenSource.register(runnable);
    }

    public void throwIfCancellationRequested() {
        this.tokenSource.throwIfCancellationRequested();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())});
    }
}