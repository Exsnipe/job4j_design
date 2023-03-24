package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void whenArrayEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is");
    }

    @Test
    void whenNoEqual() {
        NameLoad nameLoad = new NameLoad();
        String[] input = {"d=f", "rt=jh", "ExceptionName"};
        assertThatThrownBy(() -> nameLoad.parse(input))
                .hasMessageContaining("This name: ExceptionName");
    }

    @Test
    void whenNoKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("h=a", "ujj=sf", "=noKeyWord"))
                .hasMessageContaining("This name: =noKeyWord does not contain a key");
    }

    @Test
    void whenNoValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("noValueWord=", "fgb=wsg"))
                .hasMessageContaining("This name: noValueWord= does not contain a values");
    }

    @Test
    void whenAllRight() {
        NameLoad nameLoad = new NameLoad();
        nameLoad.parse("     ff=fff   ", "fdg=fhnfg", "q=g        ");
        assertThat(nameLoad.getMap()).isNotEmpty();
    }

}