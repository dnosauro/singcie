package org.apache.commons.p172io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: org.apache.commons.io.comparator.CompositeFileComparator */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
    private final Comparator<File>[] delegates;

    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        Object array;
        if (iterable == null) {
            array = NO_COMPARATORS;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Comparator<File> add : iterable) {
                arrayList.add(add);
            }
            array = arrayList.toArray(new Comparator[arrayList.size()]);
        }
        this.delegates = (Comparator[]) array;
    }

    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        if (comparatorArr == null) {
            this.delegates = (Comparator[]) NO_COMPARATORS;
            return;
        }
        this.delegates = (Comparator[]) new Comparator[comparatorArr.length];
        System.arraycopy(comparatorArr, 0, this.delegates, 0, comparatorArr.length);
    }

    public int compare(File file, File file2) {
        int i = 0;
        for (Comparator<File> compare : this.delegates) {
            i = compare.compare(file, file2);
            if (i != 0) {
                break;
            }
        }
        return i;
    }

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('{');
        for (int i = 0; i < this.delegates.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this.delegates[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
