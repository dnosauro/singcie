package bolts;

import bolts.Task;

class UnobservedErrorNotifier {
    private Task<?> task;

    public UnobservedErrorNotifier(Task<?> task2) {
        this.task = task2;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        try {
            Task<?> task2 = this.task;
            if (!(task2 == null || (unobservedExceptionHandler = Task.getUnobservedExceptionHandler()) == null)) {
                unobservedExceptionHandler.unobservedException(task2, new UnobservedTaskException(task2.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    public void setObserved() {
        this.task = null;
    }
}
