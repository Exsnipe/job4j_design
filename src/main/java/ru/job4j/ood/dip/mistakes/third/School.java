package ru.job4j.ood.dip.mistakes.third;

import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;
    
    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    } 
}
