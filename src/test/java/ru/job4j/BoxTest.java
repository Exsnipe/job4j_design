package ru.job4j;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.assertj.core.api.Assertions.*;

public class BoxTest {

    @Test
    void whenTypeIsTetrahedron() {
        Box box = new Box(4, 2);
        String type = box.whatsThis();
        assertThat(type).isNotNull()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenUnknown() {
        Box box = new Box(3, 2);
        String type = box.whatsThis();
        assertThat(type).isEqualTo("Unknown object");
    }

    @Test
    void whenUnknownByVertex() {
        Box box = new Box(4, -1);
        String type = box.whatsThis();
        assertThat(type).isEqualTo("Unknown object");
    }

    @Test
    void whenVertexMinus() {
        Box box = new Box(3, 2);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(-1);
    }

    @Test
    void whenDoesNotExist() {
        Box box = new Box(8, -1);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void whenExist() {
        Box box = new Box(4, 3);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenDefault() {
        Box box = new Box(3, 2);
        double square = box.getArea();
        assertThat(square).isEqualTo(0d);
    }

    @Test
    void whenSquareOfCube() {
        Box box = new Box(8, 2);
        assertThat(box.getArea()).isEqualTo(24d, withPrecision(0.01d));
    }

}