package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import static telran.util.Arrays.*;

//import java.util.Comparator;

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
    @Test
        void sortAnyTypeTest(){
            String [] strings = {"lmn", "cfta", "w", "aa"};
            String [] expectedASCII ={"aa", "cfta", "lmn", "w"};
            String [] expectedLength = {"w", "aa", "lmn", "cfta"};
            sort(strings, new ComparatorASCII());
            assertArrayEquals(expectedASCII, strings);
            sort(strings, new ComparatorLength());
            assertArrayEquals(expectedLength, strings);
        }
    @Test
        void binaryAnyTypeSearchTest() {
            String [] stringsASCII ={"aa", "cfta", "lmn", "w"};
            String [] stringsLength = {"w", "aa", "lmn", "cfta"};
            Integer [] numbers = {1000,2000};
            assertEquals(3, binarySearch(stringsASCII, "w", new ComparatorASCII()));
            assertEquals(0, binarySearch(stringsASCII, "aa", new ComparatorASCII()));
            assertEquals(1, binarySearch(stringsASCII, "cfta", new ComparatorASCII()));
            assertEquals(-1, binarySearch(stringsASCII, "a", new ComparatorASCII()));
            assertEquals(3, binarySearch(stringsLength, "cfta", new ComparatorLength()));
            assertEquals(0, binarySearch(stringsLength, "w", new ComparatorLength()));
            assertEquals(1, binarySearch(stringsLength, "aa", new ComparatorLength()));
            assertEquals(0, binarySearch(stringsLength, "a", new ComparatorLength()));
            assertEquals(0, binarySearch(numbers, 1000, new ComparatorNumbers()));
            assertEquals(-3, binarySearch(numbers, 3000, new ComparatorNumbers()));
        }
    @Test
        void binarySearchNoComparatorTest() {
            String [] strings = {"aa", "cfta", "lmn", "w"};
            Person prs1 = new Person(10, "Vasya");
            Person prs2 = new Person(20, "Itay");
            Person prs3 = new Person(30, "Sara");
            Person [] persons = {prs1, prs2, prs3};
            assertEquals(1, /*java.util.Arrays.*/binarySearch(strings, "cfta"));
            assertEquals(0, /*java.util.Arrays.*/binarySearch(persons, prs1));
            assertEquals(-1, /*java.util.Arrays.*/binarySearch(persons, new Person(5, "Serg")));

        }
    @Test
        void evenOddSorting() {
            Integer[] array = {7, -8, 10, -100, 13, -10, 99};
            Integer[] expected = {-100, -10, -8, 10,  99, 13, 7}; 
            sort(array, new EvenOddComparator());
            assertArrayEquals(expected, array);
        }
    @Test
        void findTest() {
            Integer[] array = {7, -8, 10, -100, 13, -10, 99};
            Integer[] expected = {7, 13, 99};
            assertArrayEquals(expected, find(array, new OddNumbersPredicate()));
        }
    @Test
    void removeIfTest() {
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {-8, 10, -100, -10};
        assertArrayEquals(expected, removeIf(array, new OddNumbersPredicate()));
    }
}       