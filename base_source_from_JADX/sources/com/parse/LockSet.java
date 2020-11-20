package com.parse;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

class LockSet {
    private static long nextStableId = 0;
    private static final WeakHashMap<Lock, Long> stableIds = new WeakHashMap<>();
    private final Set<Lock> locks = new TreeSet(new Comparator<Lock>() {
        public int compare(Lock lock, Lock lock2) {
            return LockSet.getStableId(lock).compareTo(LockSet.getStableId(lock2));
        }
    });

    public LockSet(Collection<Lock> collection) {
        this.locks.addAll(collection);
    }

    /* access modifiers changed from: private */
    public static Long getStableId(Lock lock) {
        synchronized (stableIds) {
            if (stableIds.containsKey(lock)) {
                Long l = stableIds.get(lock);
                return l;
            }
            long j = nextStableId;
            nextStableId = 1 + j;
            stableIds.put(lock, Long.valueOf(j));
            Long valueOf = Long.valueOf(j);
            return valueOf;
        }
    }

    public void lock() {
        for (Lock lock : this.locks) {
            lock.lock();
        }
    }

    public void unlock() {
        for (Lock unlock : this.locks) {
            unlock.unlock();
        }
    }
}
