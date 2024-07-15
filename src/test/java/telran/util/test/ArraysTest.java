package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
    private static final int N_ELEMENTS = 1000;
    int[] numbers = {10, 7, 12, -4, 13, 3, 14};
    @Test
        void searchTest() {
            assertEquals(0,search(numbers, 10));
            assertEquals(6,search(numbers, 14));
            assertEquals(3,search(numbers, -4));
            assertEquals(-1, search(numbers, 100));
        }
    @Test   
        void addTest() {
            int newNumber = 100;
            int[] expected = {10, 7, 12, -4, 13, 3, 14, 100};
            assertArrayEquals(expected, add(numbers, newNumber));
        }
    @Test
        void insertTest() {
            int index = 3;
            int number = 5;
            int[] expected = {10, 7, 12, 5, -4, 13, 3, 14};
            assertArrayEquals(expected, insert(numbers, index, number));
        }
    @Test
        void removeTest() {
            int index = 3;
            int [] expected = {10, 7, 12, 13, 3, 14};
            assertArrayEquals(expected, remove(numbers, index));
        }
    /*@Test
        void pushMaxAtEndTest() {
            int[] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
            pushMaxAtEnd(testNumbers);
            assertEquals(14, testNumbers[testNumbers.length - 1]);
            assertEquals(13, testNumbers[testNumbers.length - 2]);
            testNumbers = new int[] {20, -10, 10, -17};
            pushMaxAtEnd(testNumbers);
            assertEquals(20, testNumbers[testNumbers.length - 1]);
        }*/
    @Test
        void sortTest() {
            int[] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
            int[] expected = {-4, 3, 7, 10, 12, 13, 14};
            sort(testNumbers);
            assertArrayEquals(expected, testNumbers);
        }
    @Test
        void sortTestRandomArray() {
            int[] array = getRandomArray(N_ELEMENTS);
            int limit = array.length - 1;
            sort(array);
            for(int i = 0; i < limit; i++) {
                assertTrue(array[i] <= array[i + 1]);
            }
        }
            private int[] getRandomArray(int nElements) {
                int[] res = new int[nElements];
                Random random = new Random();
                for(int i = 0; i < nElements; i++) {
                    res[i] = random.nextInt();
                }
                return res;
            }
    @Test
        void binarySearchTest() {
            int[] ar = {-4, 3, 7, 10, 12, 13, 14};
            assertEquals(1, binarySearch(ar, 3));
            assertEquals(-1,binarySearch(ar, 9));
        }
    @Test
        void insertSortedTest() {
            int[] arSorted = {-4, 3, 7, 10, 12, 13, 14};
            int[] expected = {-4, 3, 7, 9, 10, 12, 13, 14};
            assertArrayEquals(expected, insertSorted(arSorted, 9) );
            assertArrayEquals(arSorted, insertSorted(arSorted, 10) );
        }
    @Test
        void isOneSwapTest() {
            int[] array = {-4, 12, 3, 7, 13, 14};
            int[] arrayTwo = {-4, 3, 12, 7, 13, 14};
            assertEquals(false, isOneSwap(array));
            assertEquals(true, isOneSwap(arrayTwo));
        }
}
