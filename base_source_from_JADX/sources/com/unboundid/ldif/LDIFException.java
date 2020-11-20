package com.unboundid.ldif;

import com.unboundid.util.LDAPSDKException;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class LDIFException extends LDAPSDKException {
    private static final long serialVersionUID = 1665883395956836732L;
    private final List<String> dataLines;
    private final long lineNumber;
    private final boolean mayContinueReading;

    public LDIFException(String str, long j, boolean z) {
        this(str, j, z, (List<? extends CharSequence>) null, (Throwable) null);
    }

    public LDIFException(String str, long j, boolean z, Throwable th) {
        this(str, j, z, (List<? extends CharSequence>) null, th);
    }

    public LDIFException(String str, long j, boolean z, List<? extends CharSequence> list, Throwable th) {
        super(str, th);
        List<String> unmodifiableList;
        Validator.ensureNotNull(str);
        this.lineNumber = j;
        this.mayContinueReading = z;
        if (list == null) {
            unmodifiableList = null;
        } else {
            ArrayList arrayList = new ArrayList(list.size());
            for (CharSequence obj : list) {
                arrayList.add(obj.toString());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.dataLines = unmodifiableList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LDIFException(String str, long j, boolean z, CharSequence[] charSequenceArr, Throwable th) {
        this(str, j, z, (List<? extends CharSequence>) charSequenceArr == null ? null : Arrays.asList(charSequenceArr), th);
    }

    public List<String> getDataLines() {
        return this.dataLines;
    }

    public String getExceptionMessage() {
        return toString();
    }

    public long getLineNumber() {
        return this.lineNumber;
    }

    public boolean mayContinueReading() {
        return this.mayContinueReading;
    }

    public void toString(StringBuilder sb) {
        sb.append("LDIFException(lineNumber=");
        sb.append(this.lineNumber);
        sb.append(", mayContinueReading=");
        sb.append(this.mayContinueReading);
        sb.append(", message='");
        sb.append(getMessage());
        if (this.dataLines != null) {
            sb.append("', dataLines='");
            for (String append : this.dataLines) {
                sb.append(append);
                sb.append("{end-of-line}");
            }
        }
        Throwable cause = getCause();
        if (cause == null) {
            sb.append("')");
            return;
        }
        sb.append("', cause=");
        StaticUtils.getStackTrace(cause, sb);
        sb.append(')');
    }
}
