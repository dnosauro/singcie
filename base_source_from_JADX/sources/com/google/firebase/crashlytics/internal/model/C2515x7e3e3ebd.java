package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread */
final class C2515x7e3e3ebd extends CrashlyticsReport.Session.Event.Application.Execution.Thread {
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private final int importance;
    private final String name;

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
        private Integer importance;
        private String name;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread build() {
            String str = "";
            if (this.name == null) {
                str = str + " name";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (this.frames == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new C2515x7e3e3ebd(this.name, this.importance.intValue(), this.frames);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            if (immutableList != null) {
                this.frames = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    private C2515x7e3e3ebd(String str, int i, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
        this.name = str;
        this.importance = i;
        this.frames = immutableList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        return this.name.equals(thread.getName()) && this.importance == thread.getImportance() && this.frames.equals(thread.getFrames());
    }

    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.frames;
    }

    public int getImportance() {
        return this.importance;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.importance) * 1000003) ^ this.frames.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.name + ", importance=" + this.importance + ", frames=" + this.frames + "}";
    }
}
