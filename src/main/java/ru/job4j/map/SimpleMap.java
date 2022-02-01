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
        return hash & (table.length - 1);
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
       V rsl = null;
        for (MapEntry<K, V> currentMap : table) {
            if (currentMap == null) {
                continue;
            }
            if (currentMap.key.equals(key)) {
                rsl = currentMap.value;
                break;
            }
       }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        for (int index = 0; index < table.length; index++) {
            if (table[index] != null && table[index].key.equals(key)) {
                table[index] = null;
                count--;
                rsl = true;
                modCOunt++;
                break;
            }
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
               while (table[indexIterator] == null && indexIterator < table.length - 1) {
                    indexIterator++;
                }
                return indexIterator < table.length - 1;
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
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
