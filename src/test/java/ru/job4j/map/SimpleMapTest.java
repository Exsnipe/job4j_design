package ru.job4j.map;

import org.junit.Test;

import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleMapTest {

    @Test
    public void whenPutAndGet() {
        Map<Integer, Integer> map = new SimpleMap<>();
        assertTrue(map.put(1, 1));
        assertThat(map.get(1), is(1));
    }

    @Test
    public void whenPutTwice() {
        Map<Integer, Integer> map = new SimpleMap<>();
        assertTrue(map.put(1, 1));
        assertFalse(map.put(1, 2));
    }

    @Test
    public void whenNotGet() {
        Map<Integer, Integer> map = new SimpleMap<>();
        assertNull(map.get(1));
        map.put(2, 2);
        assertNull(map.get(1));
        assertThat(map.get(2), is(2));
    }

    @Test
    public void whenRemove() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        assertTrue(map.remove(1));
        assertNull(map.get(1));
    }

    @Test
    public void whenNotRemove() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        assertFalse(map.remove(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenException() {
        Map<Integer, Integer> map = new SimpleMap<>();
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
    }

    @Test
    public void whenHasNext() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.next();
        assertThat(map.get(3), is(3));
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCMException() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        Iterator<Integer> iterator = map.iterator();
        map.put(2, 2);
        assertTrue(iterator.hasNext());
    }

    @Test
    public void whenCheckIterator() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }


}