package jtech.secondTask;

import java.util.*;

public class DuplicateElement {

    private final List<Integer> numbers;

    public DuplicateElement(List<Integer> numbers) {
        this.numbers = numbers;
    }

//    public Set<Long> getDuplicate() {
//        Map<Long, Long> duplicateCounter = new HashMap<>();
//        Set<Long> duplicatedNumbers = new HashSet<>();
//        for (Long number : numbers) {
//            if (duplicateCounter.containsKey(number)) {
//                duplicateCounter.put(number, duplicateCounter.get(number) + 1);
//                duplicatedNumbers.add(number);
//            } else {
//                duplicateCounter.put(number, 1L);
//            }
//        }
//        return duplicatedNumbers;
//    }
//
//    public void printDuplicate() {
//        Map<Long, Long> duplicateCounter = new HashMap<>();
//        for (Long number : numbers) {
//            if (duplicateCounter.containsKey(number)) {
//                duplicateCounter.put(number, duplicateCounter.get(number) + 1);
//                if (duplicateCounter.get(number) == 2L) {
//                    System.out.print(number + ", ");
//                }
//            } else {
//                duplicateCounter.put(number, 1L);
//            }
//        }
//    }

    public void printDuplicateWithOutCollections() {
        int[] counter = new int[numbers.size() - 1];
        for (int i = 0; i < numbers.size(); i++) {
            int counterNumber = counter[numbers.get(i) - 1];
            counter[numbers.get(i) - 1] = counterNumber + 1;
            if (counterNumber == 1) {
                System.out.print(numbers.get(i) + " ,");
            }
        }
    }

}
