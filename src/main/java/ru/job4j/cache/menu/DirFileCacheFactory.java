package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

public class DirFileCacheFactory implements AbstractCacheFactory {

    @Override
    public AbstractCache<String, String> getCacheInstance(String dir) {
        return new DirFileCache(dir);
    }
}
