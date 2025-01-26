package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCOunt = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        if (count > LOAD_FACTOR * capacity) {
            expand();
        }
        int index = (key == null) ? indexFor(0) : indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            rsl = true;
            modCOunt++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        Iterator<K> iterator = iterator();
        while (iterator.hasNext()) {
            K currentKey = iterator.next();
            MapEntry<K, V> currentElement = new MapEntry<>(currentKey, get(currentKey));
            int newIndex = indexFor(hash(currentKey.hashCode()));
            newTable[newIndex] = currentElement;
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = (key == null) ? indexFor(0) : indexFor(hash(key.hashCode()));
        return table[index] == null ? null : table[index].value;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = (key == null) ? indexFor(0) : indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            count--;
            modCOunt++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int expectedCount = modCOunt;
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                if (expectedCount != modCOunt) {
                    throw new ConcurrentModificationException();
                }
               while (indexIterator < table.length && table[indexIterator] == null) {
                    indexIterator++;
                }
                return indexIterator < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[indexIterator++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
