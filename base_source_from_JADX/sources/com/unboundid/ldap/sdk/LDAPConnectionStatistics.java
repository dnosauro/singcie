package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicLong;

public final class LDAPConnectionStatistics implements Serializable {
    private static final long serialVersionUID = -1096417617572481790L;
    private final AtomicLong numAbandonRequests = new AtomicLong(0);
    private final AtomicLong numAddRequests = new AtomicLong(0);
    private final AtomicLong numAddResponses = new AtomicLong(0);
    private final AtomicLong numBindRequests = new AtomicLong(0);
    private final AtomicLong numBindResponses = new AtomicLong(0);
    private final AtomicLong numCompareRequests = new AtomicLong(0);
    private final AtomicLong numCompareResponses = new AtomicLong(0);
    private final AtomicLong numConnects = new AtomicLong(0);
    private final AtomicLong numDeleteRequests = new AtomicLong(0);
    private final AtomicLong numDeleteResponses = new AtomicLong(0);
    private final AtomicLong numDisconnects = new AtomicLong(0);
    private final AtomicLong numExtendedRequests = new AtomicLong(0);
    private final AtomicLong numExtendedResponses = new AtomicLong(0);
    private final AtomicLong numModifyDNRequests = new AtomicLong(0);
    private final AtomicLong numModifyDNResponses = new AtomicLong(0);
    private final AtomicLong numModifyRequests = new AtomicLong(0);
    private final AtomicLong numModifyResponses = new AtomicLong(0);
    private final AtomicLong numSearchDoneResponses = new AtomicLong(0);
    private final AtomicLong numSearchEntryResponses = new AtomicLong(0);
    private final AtomicLong numSearchReferenceResponses = new AtomicLong(0);
    private final AtomicLong numSearchRequests = new AtomicLong(0);
    private final AtomicLong numUnbindRequests = new AtomicLong(0);
    private final AtomicLong totalAddResponseTime = new AtomicLong(0);
    private final AtomicLong totalBindResponseTime = new AtomicLong(0);
    private final AtomicLong totalCompareResponseTime = new AtomicLong(0);
    private final AtomicLong totalDeleteResponseTime = new AtomicLong(0);
    private final AtomicLong totalExtendedResponseTime = new AtomicLong(0);
    private final AtomicLong totalModifyDNResponseTime = new AtomicLong(0);
    private final AtomicLong totalModifyResponseTime = new AtomicLong(0);
    private final AtomicLong totalSearchResponseTime = new AtomicLong(0);

    public double getAverageAddResponseTimeMillis() {
        long j = this.totalAddResponseTime.get();
        long j2 = this.numAddResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageAddResponseTimeNanos() {
        long j = this.totalAddResponseTime.get();
        long j2 = this.numAddResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageBindResponseTimeMillis() {
        long j = this.totalBindResponseTime.get();
        long j2 = this.numBindResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageBindResponseTimeNanos() {
        long j = this.totalBindResponseTime.get();
        long j2 = this.numBindResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageCompareResponseTimeMillis() {
        long j = this.totalCompareResponseTime.get();
        long j2 = this.numCompareResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageCompareResponseTimeNanos() {
        long j = this.totalCompareResponseTime.get();
        long j2 = this.numCompareResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageDeleteResponseTimeMillis() {
        long j = this.totalDeleteResponseTime.get();
        long j2 = this.numDeleteResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageDeleteResponseTimeNanos() {
        long j = this.totalDeleteResponseTime.get();
        long j2 = this.numDeleteResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageExtendedResponseTimeMillis() {
        long j = this.totalExtendedResponseTime.get();
        long j2 = this.numExtendedResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageExtendedResponseTimeNanos() {
        long j = this.totalExtendedResponseTime.get();
        long j2 = this.numExtendedResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageModifyDNResponseTimeMillis() {
        long j = this.totalModifyDNResponseTime.get();
        long j2 = this.numModifyDNResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageModifyDNResponseTimeNanos() {
        long j = this.totalModifyDNResponseTime.get();
        long j2 = this.numModifyDNResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageModifyResponseTimeMillis() {
        long j = this.totalModifyResponseTime.get();
        long j2 = this.numModifyResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageModifyResponseTimeNanos() {
        long j = this.totalModifyResponseTime.get();
        long j2 = this.numModifyResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageSearchResponseTimeMillis() {
        long j = this.totalSearchResponseTime.get();
        long j2 = this.numSearchDoneResponses.get();
        if (j > 0) {
            return (((double) j) / 1000000.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public double getAverageSearchResponseTimeNanos() {
        long j = this.totalSearchResponseTime.get();
        long j2 = this.numSearchDoneResponses.get();
        if (j > 0) {
            return (((double) j) * 1.0d) / ((double) j2);
        }
        return Double.NaN;
    }

    public long getNumAbandonRequests() {
        return this.numAbandonRequests.get();
    }

    public long getNumAddRequests() {
        return this.numAddRequests.get();
    }

    public long getNumAddResponses() {
        return this.numAddResponses.get();
    }

    public long getNumBindRequests() {
        return this.numBindRequests.get();
    }

    public long getNumBindResponses() {
        return this.numBindResponses.get();
    }

    public long getNumCompareRequests() {
        return this.numCompareRequests.get();
    }

    public long getNumCompareResponses() {
        return this.numCompareResponses.get();
    }

    public long getNumConnects() {
        return this.numConnects.get();
    }

    public long getNumDeleteRequests() {
        return this.numDeleteRequests.get();
    }

    public long getNumDeleteResponses() {
        return this.numDeleteResponses.get();
    }

    public long getNumDisconnects() {
        return this.numDisconnects.get();
    }

    public long getNumExtendedRequests() {
        return this.numExtendedRequests.get();
    }

    public long getNumExtendedResponses() {
        return this.numExtendedResponses.get();
    }

    public long getNumModifyDNRequests() {
        return this.numModifyDNRequests.get();
    }

    public long getNumModifyDNResponses() {
        return this.numModifyDNResponses.get();
    }

    public long getNumModifyRequests() {
        return this.numModifyRequests.get();
    }

    public long getNumModifyResponses() {
        return this.numModifyResponses.get();
    }

    public long getNumSearchDoneResponses() {
        return this.numSearchDoneResponses.get();
    }

    public long getNumSearchEntryResponses() {
        return this.numSearchEntryResponses.get();
    }

    public long getNumSearchReferenceResponses() {
        return this.numSearchReferenceResponses.get();
    }

    public long getNumSearchRequests() {
        return this.numSearchRequests.get();
    }

    public long getNumUnbindRequests() {
        return this.numUnbindRequests.get();
    }

    public long getTotalAddResponseTimeMillis() {
        return Math.round(((double) this.totalAddResponseTime.get()) / 1000000.0d);
    }

    public long getTotalAddResponseTimeNanos() {
        return this.totalAddResponseTime.get();
    }

    public long getTotalBindResponseTimeMillis() {
        return Math.round(((double) this.totalBindResponseTime.get()) / 1000000.0d);
    }

    public long getTotalBindResponseTimeNanos() {
        return this.totalBindResponseTime.get();
    }

    public long getTotalCompareResponseTimeMillis() {
        return Math.round(((double) this.totalCompareResponseTime.get()) / 1000000.0d);
    }

    public long getTotalCompareResponseTimeNanos() {
        return this.totalCompareResponseTime.get();
    }

    public long getTotalDeleteResponseTimeMillis() {
        return Math.round(((double) this.totalDeleteResponseTime.get()) / 1000000.0d);
    }

    public long getTotalDeleteResponseTimeNanos() {
        return this.totalDeleteResponseTime.get();
    }

    public long getTotalExtendedResponseTimeMillis() {
        return Math.round(((double) this.totalExtendedResponseTime.get()) / 1000000.0d);
    }

    public long getTotalExtendedResponseTimeNanos() {
        return this.totalExtendedResponseTime.get();
    }

    public long getTotalModifyDNResponseTimeMillis() {
        return Math.round(((double) this.totalModifyDNResponseTime.get()) / 1000000.0d);
    }

    public long getTotalModifyDNResponseTimeNanos() {
        return this.totalModifyDNResponseTime.get();
    }

    public long getTotalModifyResponseTimeMillis() {
        return Math.round(((double) this.totalModifyResponseTime.get()) / 1000000.0d);
    }

    public long getTotalModifyResponseTimeNanos() {
        return this.totalModifyResponseTime.get();
    }

    public long getTotalSearchResponseTimeMillis() {
        return Math.round(((double) this.totalSearchResponseTime.get()) / 1000000.0d);
    }

    public long getTotalSearchResponseTimeNanos() {
        return this.totalSearchResponseTime.get();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumAbandonRequests() {
        this.numAbandonRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumAddRequests() {
        this.numAddRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumAddResponses(long j) {
        this.numAddResponses.incrementAndGet();
        if (j > 0) {
            this.totalAddResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumBindRequests() {
        this.numBindRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumBindResponses(long j) {
        this.numBindResponses.incrementAndGet();
        if (j > 0) {
            this.totalBindResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumCompareRequests() {
        this.numCompareRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumCompareResponses(long j) {
        this.numCompareResponses.incrementAndGet();
        if (j > 0) {
            this.totalCompareResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumConnects() {
        this.numConnects.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumDeleteRequests() {
        this.numDeleteRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumDeleteResponses(long j) {
        this.numDeleteResponses.incrementAndGet();
        if (j > 0) {
            this.totalDeleteResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumDisconnects() {
        this.numDisconnects.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumExtendedRequests() {
        this.numExtendedRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumExtendedResponses(long j) {
        this.numExtendedResponses.incrementAndGet();
        if (j > 0) {
            this.totalExtendedResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumModifyDNRequests() {
        this.numModifyDNRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumModifyDNResponses(long j) {
        this.numModifyDNResponses.incrementAndGet();
        if (j > 0) {
            this.totalModifyDNResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumModifyRequests() {
        this.numModifyRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumModifyResponses(long j) {
        this.numModifyResponses.incrementAndGet();
        if (j > 0) {
            this.totalModifyResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSearchRequests() {
        this.numSearchRequests.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void incrementNumSearchResponses(int i, int i2, long j) {
        this.numSearchEntryResponses.addAndGet((long) i);
        this.numSearchReferenceResponses.addAndGet((long) i2);
        this.numSearchDoneResponses.incrementAndGet();
        if (j > 0) {
            this.totalSearchResponseTime.addAndGet(j);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementNumUnbindRequests() {
        this.numUnbindRequests.incrementAndGet();
    }

    public void reset() {
        this.numAbandonRequests.set(0);
        this.numAddRequests.set(0);
        this.numAddResponses.set(0);
        this.numBindRequests.set(0);
        this.numBindResponses.set(0);
        this.numCompareRequests.set(0);
        this.numCompareResponses.set(0);
        this.numConnects.set(0);
        this.numDeleteRequests.set(0);
        this.numDeleteResponses.set(0);
        this.numDisconnects.set(0);
        this.numExtendedRequests.set(0);
        this.numExtendedResponses.set(0);
        this.numModifyRequests.set(0);
        this.numModifyResponses.set(0);
        this.numModifyDNRequests.set(0);
        this.numModifyDNResponses.set(0);
        this.numSearchRequests.set(0);
        this.numSearchEntryResponses.set(0);
        this.numSearchReferenceResponses.set(0);
        this.numSearchDoneResponses.set(0);
        this.numUnbindRequests.set(0);
        this.totalAddResponseTime.set(0);
        this.totalBindResponseTime.set(0);
        this.totalCompareResponseTime.set(0);
        this.totalDeleteResponseTime.set(0);
        this.totalExtendedResponseTime.set(0);
        this.totalModifyResponseTime.set(0);
        this.totalModifyDNResponseTime.set(0);
        this.totalSearchResponseTime.set(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        StringBuilder sb2 = sb;
        long j = this.numConnects.get();
        long j2 = this.numDisconnects.get();
        long j3 = this.numAbandonRequests.get();
        long j4 = this.numAddRequests.get();
        long j5 = this.numAddResponses.get();
        long j6 = this.totalAddResponseTime.get();
        long j7 = this.numBindRequests.get();
        long j8 = this.numBindResponses.get();
        long j9 = this.totalBindResponseTime.get();
        long j10 = this.numCompareRequests.get();
        long j11 = this.numCompareResponses.get();
        long j12 = this.totalCompareResponseTime.get();
        long j13 = this.numDeleteRequests.get();
        long j14 = this.numDeleteResponses.get();
        long j15 = this.totalDeleteResponseTime.get();
        long j16 = this.numExtendedRequests.get();
        long j17 = this.numExtendedResponses.get();
        long j18 = this.totalExtendedResponseTime.get();
        long j19 = this.numModifyRequests.get();
        long j20 = this.numModifyResponses.get();
        long j21 = this.totalModifyResponseTime.get();
        long j22 = this.numModifyDNRequests.get();
        long j23 = this.numModifyDNResponses.get();
        long j24 = this.totalModifyDNResponseTime.get();
        long j25 = this.numSearchRequests.get();
        long j26 = this.numSearchEntryResponses.get();
        long j27 = this.numSearchReferenceResponses.get();
        long j28 = this.numSearchDoneResponses.get();
        long j29 = this.totalSearchResponseTime.get();
        long j30 = this.numUnbindRequests.get();
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        sb2.append("LDAPConnectionStatistics(numConnects=");
        sb2.append(j);
        sb2.append(", numDisconnects=");
        sb2.append(j2);
        sb2.append(", numAbandonRequests=");
        sb2.append(j3);
        sb2.append(", numAddRequests=");
        sb2.append(j4);
        sb2.append(", numAddResponses=");
        sb2.append(j5);
        sb2.append(", totalAddResponseTimeNanos=");
        sb2.append(j6);
        if (j6 > 0) {
            sb2.append(", averageAddResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j5) * 1.0d) / ((double) j6)));
        }
        sb2.append(", numBindRequests=");
        sb2.append(j7);
        sb2.append(", numBindResponses=");
        long j31 = j8;
        sb2.append(j31);
        sb2.append(", totalBindResponseTimeNanos=");
        long j32 = j9;
        sb2.append(j32);
        if (j32 > 0) {
            sb2.append(", averageBindResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j31) * 1.0d) / ((double) j32)));
        }
        sb2.append(", numCompareRequests=");
        sb2.append(j10);
        sb2.append(", numCompareResponses=");
        long j33 = j11;
        sb2.append(j33);
        sb2.append(", totalCompareResponseTimeNanos=");
        long j34 = j12;
        sb2.append(j34);
        if (j34 > 0) {
            sb2.append(", averageCompareResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j33) * 1.0d) / ((double) j34)));
        }
        sb2.append(", numDeleteRequests=");
        sb2.append(j13);
        sb2.append(", numDeleteResponses=");
        long j35 = j14;
        sb2.append(j35);
        sb2.append(", totalDeleteResponseTimeNanos=");
        long j36 = j15;
        sb2.append(j36);
        if (j36 > 0) {
            sb2.append(", averageDeleteResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j35) * 1.0d) / ((double) j36)));
        }
        sb2.append(", numExtendedRequests=");
        sb2.append(j16);
        sb2.append(", numExtendedResponses=");
        long j37 = j17;
        sb2.append(j37);
        sb2.append(", totalExtendedResponseTimeNanos=");
        long j38 = j18;
        sb2.append(j38);
        if (j38 > 0) {
            sb2.append(", averageExtendedResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j37) * 1.0d) / ((double) j38)));
        }
        sb2.append(", numModifyRequests=");
        sb2.append(j19);
        sb2.append(", numModifyResponses=");
        long j39 = j20;
        sb2.append(j39);
        sb2.append(", totalModifyResponseTimeNanos=");
        long j40 = j21;
        sb2.append(j40);
        if (j40 > 0) {
            sb2.append(", averageModifyResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j39) * 1.0d) / ((double) j40)));
        }
        sb2.append(", numModifyDNRequests=");
        sb2.append(j22);
        sb2.append(", numModifyDNResponses=");
        long j41 = j23;
        sb2.append(j41);
        sb2.append(", totalModifyDNResponseTimeNanos=");
        long j42 = j24;
        sb2.append(j42);
        if (j42 > 0) {
            sb2.append(", averageModifyDNResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j41) * 1.0d) / ((double) j42)));
        }
        sb2.append(", numSearchRequests=");
        sb2.append(j25);
        sb2.append(", numSearchEntries=");
        sb2.append(j26);
        sb2.append(", numSearchReferences=");
        sb2.append(j27);
        sb2.append(", numSearchDone=");
        long j43 = j28;
        sb2.append(j43);
        sb2.append(", totalSearchResponseTimeNanos=");
        long j44 = j29;
        sb2.append(j44);
        if (j44 > 0) {
            sb2.append(", averageSearchResponseTimeNanos=");
            sb2.append(decimalFormat.format((((double) j43) * 1.0d) / ((double) j44)));
        }
        sb2.append(", numUnbindRequests=");
        sb2.append(j30);
        sb2.append(')');
    }
}
