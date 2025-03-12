package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PathTest {
    @Test
    public void firstCase() {
        String path = "/home/";
        assertThat(Path.simplify(path)).isEqualTo("/home");
    }

    @Test
    public void secondCase() {
        String path = "/home//foo/";
        assertThat(Path.simplify(path)).isEqualTo("/home/foo");
    }

    @Test
    public void thirdCase() {
        String path = "/home/user/Documents/../Pictures";
        assertThat(Path.simplify(path)).isEqualTo("/home/user/Pictures");
    }

    @Test
    public void fourthCase() {
        String path = "/../";
        assertThat(Path.simplify(path)).isEqualTo("/");
    }

    @Test
    public void fifthCase() {
        String path = "/.../a/../b/c/../d/./";
        assertThat(Path.simplify(path)).isEqualTo("/.../b/d");
    }
}