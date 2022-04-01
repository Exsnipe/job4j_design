package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
       String name = "Ivan ivanov";
       int age = 31;
       char symbol = 'd';
       float weight = 70.5f;
       double koff = 0.4;
       boolean isOpen = true;
       byte home = 7;
       short typeKey = 8;
       long status = 785848484585L;
       LOG.debug("User info name: {}, age: {}, weight: {}", name, age, weight);
       LOG.debug("Symbol is: {}, koff: {}, isOpen: {}", symbol, koff, isOpen);
       LOG.debug("home: {}, typeKey: {}, status: {}", home, typeKey, status);
    }
}
