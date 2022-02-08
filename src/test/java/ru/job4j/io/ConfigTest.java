package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan Ivanov"));
    }

    @Test
    public void  whenPairWithCommentAndEmptyLines() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("ff"), is("ff"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void  whenPairWithException() {
        String path = "./data/pair_with_exception.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("ff"), is("ff"));
    }
}
