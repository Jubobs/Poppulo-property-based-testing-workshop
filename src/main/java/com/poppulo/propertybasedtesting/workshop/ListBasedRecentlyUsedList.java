package com.poppulo.propertybasedtesting.workshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListBasedRecentlyUsedList<T> implements RecentlyUsedList<T> {

    private final int capacity;
    private final List<T> backingList;

    private ListBasedRecentlyUsedList(int capacity) {
        if (capacity < 1) {
            String msg = String.format("nonpositive capacity: %d", capacity);
            throw new IllegalArgumentException(msg);
        }

        this.capacity = capacity;
        this.backingList = new ArrayList<>();
    }

    public static <T> ListBasedRecentlyUsedList<T> newInstance(int capacity) {
        return new ListBasedRecentlyUsedList<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    @Override
    public int size() {
        return backingList.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T newHead) {
        backingList.add(0, newHead);
    }

    @Override
    public T elementAt(int index) {
        return backingList.get(index);
    }

    @Override
    public List<T> toList() {
        return Collections.unmodifiableList(backingList);
    }

}

