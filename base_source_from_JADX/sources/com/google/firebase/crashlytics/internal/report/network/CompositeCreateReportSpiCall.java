package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;

public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        switch (createReportRequest.report.getType()) {
            case JAVA:
                this.javaReportSpiCall.invoke(createReportRequest, z);
                return true;
            case NATIVE:
                this.nativeReportSpiCall.invoke(createReportRequest, z);
                return true;
            default:
                return false;
        }
    }
}
