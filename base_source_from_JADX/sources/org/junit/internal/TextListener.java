package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.apache.commons.p172io.FilenameUtils;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TextListener extends RunListener {
    private final PrintStream writer;

    public TextListener(PrintStream printStream) {
        this.writer = printStream;
    }

    public TextListener(JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    private PrintStream getWriter() {
        return this.writer;
    }

    /* access modifiers changed from: protected */
    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    /* access modifiers changed from: protected */
    public void printFailure(Failure failure, String str) {
        PrintStream writer2 = getWriter();
        writer2.println(str + ") " + failure.getTestHeader());
        getWriter().print(failure.getTrace());
    }

    /* access modifiers changed from: protected */
    public void printFailures(Result result) {
        String str;
        StringBuilder sb;
        PrintStream printStream;
        List<Failure> failures = result.getFailures();
        if (failures.size() != 0) {
            int i = 1;
            if (failures.size() == 1) {
                printStream = getWriter();
                sb = new StringBuilder();
                sb.append("There was ");
                sb.append(failures.size());
                str = " failure:";
            } else {
                printStream = getWriter();
                sb = new StringBuilder();
                sb.append("There were ");
                sb.append(failures.size());
                str = " failures:";
            }
            sb.append(str);
            printStream.println(sb.toString());
            for (Failure printFailure : failures) {
                printFailure(printFailure, "" + i);
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void printFooter(Result result) {
        StringBuilder sb;
        PrintStream printStream;
        if (result.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            printStream = getWriter();
            sb = new StringBuilder();
            sb.append(" (");
            sb.append(result.getRunCount());
            sb.append(" test");
            sb.append(result.getRunCount() == 1 ? "" : "s");
            sb.append(")");
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            printStream = getWriter();
            sb = new StringBuilder();
            sb.append("Tests run: ");
            sb.append(result.getRunCount());
            sb.append(",  Failures: ");
            sb.append(result.getFailureCount());
        }
        printStream.println(sb.toString());
        getWriter().println();
    }

    /* access modifiers changed from: protected */
    public void printHeader(long j) {
        getWriter().println();
        PrintStream writer2 = getWriter();
        writer2.println("Time: " + elapsedTimeAsString(j));
    }

    public void testFailure(Failure failure) {
        this.writer.append('E');
    }

    public void testIgnored(Description description) {
        this.writer.append('I');
    }

    public void testRunFinished(Result result) {
        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    public void testStarted(Description description) {
        this.writer.append(FilenameUtils.EXTENSION_SEPARATOR);
    }
}
