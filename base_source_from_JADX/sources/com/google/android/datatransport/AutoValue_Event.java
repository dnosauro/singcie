package com.google.android.datatransport;

final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;

    AutoValue_Event(Integer num, T t, Priority priority2) {
        this.code = num;
        if (t != null) {
            this.payload = t;
            if (priority2 != null) {
                this.priority = priority2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            return this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority());
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public T getPayload() {
        return this.payload;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public int hashCode() {
        Integer num = this.code;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + "}";
    }
}
