package org.junit.runner;

import java.io.PrintStream;
import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import p076c.p078b.C1398d;
import p076c.p079c.C1406a;

public class JUnitCore {
    private final RunNotifier notifier = new RunNotifier();

    static Computer defaultComputer() {
        return new Computer();
    }

    public static void main(String... strArr) {
        System.exit(new JUnitCore().runMain(new RealSystem(), strArr).wasSuccessful() ^ true ? 1 : 0);
    }

    public static Result runClasses(Computer computer, Class<?>... clsArr) {
        return new JUnitCore().run(computer, clsArr);
    }

    public static Result runClasses(Class<?>... clsArr) {
        return runClasses(defaultComputer(), clsArr);
    }

    public void addListener(RunListener runListener) {
        this.notifier.addListener(runListener);
    }

    public String getVersion() {
        return C1406a.m5348a();
    }

    public void removeListener(RunListener runListener) {
        this.notifier.removeListener(runListener);
    }

    public Result run(C1398d dVar) {
        return run((Runner) new JUnit38ClassRunner(dVar));
    }

    public Result run(Computer computer, Class<?>... clsArr) {
        return run(Request.classes(computer, clsArr));
    }

    public Result run(Request request) {
        return run(request.getRunner());
    }

    public Result run(Runner runner) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        this.notifier.addFirstListener(createListener);
        try {
            this.notifier.fireTestRunStarted(runner.getDescription());
            runner.run(this.notifier);
            this.notifier.fireTestRunFinished(result);
            return result;
        } finally {
            removeListener(createListener);
        }
    }

    public Result run(Class<?>... clsArr) {
        return run(defaultComputer(), clsArr);
    }

    /* access modifiers changed from: package-private */
    public Result runMain(JUnitSystem jUnitSystem, String... strArr) {
        PrintStream out = jUnitSystem.out();
        out.println("JUnit version " + C1406a.m5348a());
        JUnitCommandLineParseResult parse = JUnitCommandLineParseResult.parse(strArr);
        addListener(new TextListener(jUnitSystem));
        return run(parse.createRequest(defaultComputer()));
    }
}
