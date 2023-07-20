package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;

public interface AbstractCacheFactory {
    AbstractCache getCacheInstance(String key);
}
