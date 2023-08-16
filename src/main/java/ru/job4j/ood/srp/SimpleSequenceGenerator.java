package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleSequenceGenerator implements SequenceGenerator<Integer> {
    @Override
    public List<Integer> generate(int size) {
       Random random = new Random();
       return IntStream.range(0, size)
               .map(i -> random.nextInt()).boxed()
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SequenceGenerator<Integer> sequenceGenerator = new SimpleSequenceGenerator();
        System.out.println(sequenceGenerator.generate(5));
    }
}
