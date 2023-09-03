package ru.job4j;

public class TestObject implements Cloneable {
    int num;
    Object obj = new Object();

    public static void main(String[] args) throws CloneNotSupportedException {
       TestObject testObject1 = new TestObject();
       testObject1.num = 5;
       TestObject testObject2 = testObject1.clone();
       testObject2.num = 10;
        System.out.println(testObject1.num);
        System.out.println(testObject2.num);
        System.out.println(testObject1.obj == testObject2.obj);
    }

    @Override
    public TestObject clone() throws CloneNotSupportedException {
        return (TestObject) super.clone();
    }
}
