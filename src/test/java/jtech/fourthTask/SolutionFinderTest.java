package jtech.fourthTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFinderTest {

    @Test
    void test() {
        SolutionFinder one = SolutionFinder.getInstance();
        assertEquals("you search for it on stackoverflow", one.getAnswer());
        SolutionFinder two = SolutionFinder.getInstance();
        assertEquals(one, two);
    }

}