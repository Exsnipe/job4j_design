package ru.job4j;

import java.util.Objects;

public class Box {
    private static final String UNKNOWN = "Unknown object";

    private int vertex;
    private final int edge;
    private String type = "";

    public Box(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
        init();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Box box = (Box) o;
        return vertex == box.vertex && edge == box.edge && Objects.equals(type, box.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex, edge, type);
    }

    private void init() {
        type = switch (vertex) {
            case 0 -> "Sphere";
            case 4 -> "Tetrahedron";
            case 8 -> "Cube";
            default -> UNKNOWN;
        };
        if (UNKNOWN.equals(type)) {
            vertex = -1;
        }
        if (edge <= 0) {
            vertex = -1; type = UNKNOWN;
        }
    }

    public String whatsThis() {
        return this.type;
    }

    public int getNumberOfVertices() {
        return this.vertex;
    }

    public boolean isExist() {
        return this.vertex != -1;
    }

    public double getArea() {
        double a = edge;
        return switch (vertex) {
            case 0 -> 4 * Math.PI * (a * a);
            case 4 -> Math.sqrt(3) * (a * a);
            case 8 -> 6 * (a * a);
            default -> 0;
        };
    }
}