package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.p172io.IOUtils;

public class AggregateException extends Exception {
    private static final String DEFAULT_MESSAGE = "There were multiple errors.";
    private static final long serialVersionUID = 1;
    private List<Throwable> innerThrowables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : (Throwable) list.get(0));
        this.innerThrowables = Collections.unmodifiableList(list);
    }

    public AggregateException(String str, Throwable[] thArr) {
        this(str, (List<? extends Throwable>) Arrays.asList(thArr));
    }

    public AggregateException(List<? extends Throwable> list) {
        this(DEFAULT_MESSAGE, list);
    }

    @Deprecated
    public Throwable[] getCauses() {
        List<Throwable> list = this.innerThrowables;
        return (Throwable[]) list.toArray(new Throwable[list.size()]);
    }

    @Deprecated
    public List<Exception> getErrors() {
        ArrayList arrayList = new ArrayList();
        List<Throwable> list = this.innerThrowables;
        if (list == null) {
            return arrayList;
        }
        for (Throwable next : list) {
            if (next instanceof Exception) {
                arrayList.add((Exception) next);
            } else {
                arrayList.add(new Exception(next));
            }
        }
        return arrayList;
    }

    public List<Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable printStackTrace : this.innerThrowables) {
            printStream.append(IOUtils.LINE_SEPARATOR_UNIX);
            printStream.append("  Inner throwable #");
            i++;
            printStream.append(Integer.toString(i));
            printStream.append(": ");
            printStackTrace.printStackTrace(printStream);
            printStream.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable printStackTrace : this.innerThrowables) {
            printWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
            printWriter.append("  Inner throwable #");
            i++;
            printWriter.append(Integer.toString(i));
            printWriter.append(": ");
            printStackTrace.printStackTrace(printWriter);
            printWriter.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
    }
}
