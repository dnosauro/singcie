package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Runner;

public abstract class RunnerBuilder {
    private final Set<Class<?>> parents = new HashSet();

    private List<Runner> runners(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> safeRunnerForClass : clsArr) {
            Runner safeRunnerForClass2 = safeRunnerForClass(safeRunnerForClass);
            if (safeRunnerForClass2 != null) {
                arrayList.add(safeRunnerForClass2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Class<?> addParent(Class<?> cls) {
        if (this.parents.add(cls)) {
            return cls;
        }
        throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", new Object[]{cls.getName()}));
    }

    /* access modifiers changed from: package-private */
    public void removeParent(Class<?> cls) {
        this.parents.remove(cls);
    }

    public abstract Runner runnerForClass(Class<?> cls);

    public List<Runner> runners(Class<?> cls, List<Class<?>> list) {
        return runners(cls, (Class<?>[]) (Class[]) list.toArray(new Class[0]));
    }

    public List<Runner> runners(Class<?> cls, Class<?>[] clsArr) {
        addParent(cls);
        try {
            return runners(clsArr);
        } finally {
            removeParent(cls);
        }
    }

    public Runner safeRunnerForClass(Class<?> cls) {
        try {
            return runnerForClass(cls);
        } catch (Throwable th) {
            return new ErrorReportingRunner(cls, th);
        }
    }
}
