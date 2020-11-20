package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

class JUnitCommandLineParseResult {
    private final List<Class<?>> classes = new ArrayList();
    private final List<String> filterSpecs = new ArrayList();
    private final List<Throwable> parserErrors = new ArrayList();

    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }

    JUnitCommandLineParseResult() {
    }

    private Request applyFilterSpecs(Request request) {
        try {
            for (String createFilterFromFilterSpec : this.filterSpecs) {
                request = request.filterWith(FilterFactories.createFilterFromFilterSpec(request, createFilterFromFilterSpec));
            }
            return request;
        } catch (FilterFactory.FilterNotCreatedException e) {
            return errorReport(e);
        }
    }

    private String[] copyArray(String[] strArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i != i2) {
            arrayList.add(strArr[i]);
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private Request errorReport(Throwable th) {
        return Request.errorReport(JUnitCommandLineParseResult.class, th);
    }

    public static JUnitCommandLineParseResult parse(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(String[] strArr) {
        parseParameters(parseOptions(strArr));
    }

    public Request createRequest(Computer computer) {
        if (!this.parserErrors.isEmpty()) {
            return errorReport(new InitializationError(this.parserErrors));
        }
        List<Class<?>> list = this.classes;
        return applyFilterSpecs(Request.classes(computer, (Class[]) list.toArray(new Class[list.size()])));
    }

    public List<Class<?>> getClasses() {
        return Collections.unmodifiableList(this.classes);
    }

    public List<String> getFilterSpecs() {
        return Collections.unmodifiableList(this.filterSpecs);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        return new java.lang.String[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] parseOptions(java.lang.String... r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r8.length
            if (r1 == r2) goto L_0x0092
            r2 = r8[r1]
            java.lang.String r3 = "--"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0017
            int r1 = r1 + 1
        L_0x0011:
            int r0 = r8.length
            java.lang.String[] r8 = r7.copyArray(r8, r1, r0)
            return r8
        L_0x0017:
            java.lang.String r3 = "--"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = "--filter="
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0051
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0030
            goto L_0x0051
        L_0x0030:
            java.util.List<java.lang.Throwable> r3 = r7.parserErrors
            org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError r4 = new org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "JUnit knows nothing about the "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " option"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2)
            r3.add(r4)
            goto L_0x008e
        L_0x0051:
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x007d
            int r1 = r1 + 1
            int r3 = r8.length
            if (r1 >= r3) goto L_0x0061
            r2 = r8[r1]
            goto L_0x0089
        L_0x0061:
            java.util.List<java.lang.Throwable> r8 = r7.parserErrors
            org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError r1 = new org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " value not specified"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            r8.add(r1)
            goto L_0x0092
        L_0x007d:
            r3 = 61
            int r3 = r2.indexOf(r3)
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)
        L_0x0089:
            java.util.List<java.lang.String> r3 = r7.filterSpecs
            r3.add(r2)
        L_0x008e:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0092:
            java.lang.String[] r8 = new java.lang.String[r0]
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.JUnitCommandLineParseResult.parseOptions(java.lang.String[]):java.lang.String[]");
    }

    /* access modifiers changed from: package-private */
    public void parseParameters(String[] strArr) {
        for (String str : strArr) {
            try {
                this.classes.add(Classes.getClass(str));
            } catch (ClassNotFoundException e) {
                this.parserErrors.add(new IllegalArgumentException("Could not find class [" + str + "]", e));
            }
        }
    }
}
