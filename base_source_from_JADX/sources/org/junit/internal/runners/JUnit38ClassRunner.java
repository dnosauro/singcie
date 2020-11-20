package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import p076c.p077a.C1394a;
import p076c.p078b.C1396b;
import p076c.p078b.C1398d;
import p076c.p078b.C1399e;
import p076c.p078b.C1401g;
import p076c.p078b.C1402h;
import p076c.p078b.C1404i;

public class JUnit38ClassRunner extends Runner implements Filterable, Sortable {
    private volatile C1398d test;

    private static final class OldTestClassAdaptingListener implements C1401g {
        private final RunNotifier notifier;

        private OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }

        private Description asDescription(C1398d dVar) {
            return dVar instanceof Describable ? ((Describable) dVar).getDescription() : Description.createTestDescription(getEffectiveClass(dVar), getName(dVar));
        }

        private Class<? extends C1398d> getEffectiveClass(C1398d dVar) {
            return dVar.getClass();
        }

        private String getName(C1398d dVar) {
            return dVar instanceof C1399e ? ((C1399e) dVar).mo6846f() : dVar.toString();
        }

        public void addError(C1398d dVar, Throwable th) {
            this.notifier.fireTestFailure(new Failure(asDescription(dVar), th));
        }

        public void addFailure(C1398d dVar, C1396b bVar) {
            addError(dVar, bVar);
        }

        public void endTest(C1398d dVar) {
            this.notifier.fireTestFinished(asDescription(dVar));
        }

        public void startTest(C1398d dVar) {
            this.notifier.fireTestStarted(asDescription(dVar));
        }
    }

    public JUnit38ClassRunner(C1398d dVar) {
        setTest(dVar);
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this((C1398d) new C1404i((Class<?>) cls.asSubclass(C1399e.class)));
    }

    private static String createSuiteDescription(C1404i iVar) {
        String str;
        int a = iVar.mo6835a();
        if (a == 0) {
            str = "";
        } else {
            str = String.format(" [example: %s]", new Object[]{iVar.mo6861a(0)});
        }
        return String.format("TestSuite with %s tests%s", new Object[]{Integer.valueOf(a), str});
    }

    private static Annotation[] getAnnotations(C1399e eVar) {
        try {
            return eVar.getClass().getMethod(eVar.mo6846f(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private C1398d getTest() {
        return this.test;
    }

    private static Description makeDescription(C1398d dVar) {
        if (dVar instanceof C1399e) {
            C1399e eVar = (C1399e) dVar;
            return Description.createTestDescription(eVar.getClass(), eVar.mo6846f(), getAnnotations(eVar));
        } else if (!(dVar instanceof C1404i)) {
            return dVar instanceof Describable ? ((Describable) dVar).getDescription() : dVar instanceof C1394a ? makeDescription(((C1394a) dVar).mo6837b()) : Description.createSuiteDescription(dVar.getClass());
        } else {
            C1404i iVar = (C1404i) dVar;
            Description createSuiteDescription = Description.createSuiteDescription(iVar.mo6864b() == null ? createSuiteDescription(iVar) : iVar.mo6864b(), new Annotation[0]);
            int c = iVar.mo6866c();
            for (int i = 0; i < c; i++) {
                createSuiteDescription.addChild(makeDescription(iVar.mo6861a(i)));
            }
            return createSuiteDescription;
        }
    }

    private void setTest(C1398d dVar) {
        this.test = dVar;
    }

    public C1401g createAdaptingListener(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    public void filter(Filter filter) {
        if (getTest() instanceof Filterable) {
            ((Filterable) getTest()).filter(filter);
        } else if (getTest() instanceof C1404i) {
            C1404i iVar = (C1404i) getTest();
            C1404i iVar2 = new C1404i(iVar.mo6864b());
            int c = iVar.mo6866c();
            for (int i = 0; i < c; i++) {
                C1398d a = iVar.mo6861a(i);
                if (filter.shouldRun(makeDescription(a))) {
                    iVar2.mo6862a(a);
                }
            }
            setTest(iVar2);
            if (iVar2.mo6866c() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    public Description getDescription() {
        return makeDescription(getTest());
    }

    public void run(RunNotifier runNotifier) {
        C1402h hVar = new C1402h();
        hVar.mo6858a(createAdaptingListener(runNotifier));
        getTest().mo6838b(hVar);
    }

    public void sort(Sorter sorter) {
        if (getTest() instanceof Sortable) {
            ((Sortable) getTest()).sort(sorter);
        }
    }
}
