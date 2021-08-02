package jtech.secondTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateElementTest {


    @Test
    void test() {
        List<Long> numbers = List.of(1L,3L,1L,3L);
        DuplicateElement duplicateElement = new DuplicateElement(numbers);
        System.out.println(duplicateElement.getDuplicate());
        numbers = List.of(1L,3L,1L,3L,2L);
        DuplicateElement duplicateElement2 = new DuplicateElement(numbers);
        System.out.println(duplicateElement2.getDuplicate());
    }

    @Test
    void test2() {
        List<Long> numbers = new ArrayList<>();
        Random rnd = new Random();
        long n = 1000000L;
        for (int i = 1; i <= n+1; i++) {
            long number = (long)(1+Math.random()*n);
            numbers.add(number);
        }
        DuplicateElement duplicateElement = new DuplicateElement(numbers);
        System.out.println(duplicateElement.getDuplicate());
    }

   @Test
    void print() {
       List<Long> numbers = List.of(1L,3L,1L,3L,2L);
       DuplicateElement duplicateElement = new DuplicateElement(numbers);
       duplicateElement.printDuplicate();
   }

   @Test
    void print2() {
       List<Long> numbers = new ArrayList<>();
       Random rnd = new Random();
       long n = 1000000L;
       for (int i = 1; i <= n+1; i++) {
           long number = (long)(1+Math.random()*n);
           numbers.add(number);
       }
       DuplicateElement duplicateElement = new DuplicateElement(numbers);
       duplicateElement.printDuplicate();
   }

    @Test
    void print3() {
        List<Long> numbers = new ArrayList<>();
        Random rnd = new Random();
        long n = 50L;
        for (int i = 1; i <= n+1; i++) {
            long number = (long)(1+Math.random()*n);
            numbers.add(number);
        }
        DuplicateElement duplicateElement = new DuplicateElement(numbers);
        duplicateElement.printDuplicate();
    }
}