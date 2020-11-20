package com.parse;

import java.util.AbstractList;
import java.util.List;

class Lists {

    private static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        public Partition(List<T> list2, int i) {
            this.list = list2;
            this.size = i;
        }

        public List<T> get(int i) {
            int i2 = this.size;
            int i3 = i * i2;
            return this.list.subList(i3, Math.min(i2 + i3, this.list.size()));
        }

        public int size() {
            return (int) Math.ceil(((double) this.list.size()) / ((double) this.size));
        }
    }

    Lists() {
    }

    static <T> List<List<T>> partition(List<T> list, int i) {
        return new Partition(list, i);
    }
}
