package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import telran.util.CharacterRule;

import static telran.util.Arrays.*;

import java.util.Comparator;

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
            int [] arSorted = {10, 20, 30, 40, 50};
            assertEquals(0, binarySearch(arSorted, 10));
            assertEquals(4, binarySearch(arSorted, 50));
            assertEquals(2, binarySearch(arSorted, 30));
            assertEquals(-1, binarySearch(arSorted, 5));
            assertEquals(-3, binarySearch(arSorted, 25));
            assertEquals(-6, binarySearch(arSorted, 55));
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
            sort(strings, (a,b) -> a.compareTo(b));
            assertArrayEquals(expectedASCII, strings);
            sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));
            assertArrayEquals(expectedLength, strings);
        }
    @Test
        void binaryAnyTypeSearchTest() {
            String [] strings ={"aa", "cfta", "lmn", "w"};
            //String [] stringsLength = {"w", "aa", "lmn", "cfta"};
            Integer [] numbers = {1000,2000};
            Comparator<String> compStrings = (a,b) -> a.compareTo(b);
            Comparator<Integer> compInteger = Integer::compare;
            assertEquals(3, binarySearch(strings, "w", compStrings));
            assertEquals(0, binarySearch(strings, "aa", compStrings));
            assertEquals(1, binarySearch(strings, "cfta", compStrings));
            assertEquals(-1, binarySearch(strings, "a", compStrings));
            /*assertEquals(3, binarySearch(stringsLength, "cfta", new ComparatorLength()));
            assertEquals(0, binarySearch(stringsLength, "w", new ComparatorLength()));
            assertEquals(1, binarySearch(stringsLength, "aa", new ComparatorLength()));
            assertEquals(0, binarySearch(stringsLength, "a", new ComparatorLength()));*/
            assertEquals(0, binarySearch(numbers, 1000, compInteger));
            assertEquals(-3, binarySearch(numbers, 3000, compInteger));
        }
    @Test
        void binarySearchNoComparatorTest() {
            String [] strings = {"aa", "cfta", "lmn", "w"};
            Person prs1 = new Person(10, "Vasya");
            Person prs2 = new Person(20, "Itay");
            Person prs3 = new Person(30, "Sara");
            Person [] persons = {prs1, prs2, prs3};
            assertEquals(1, binarySearch(strings, "cfta"));
            assertEquals(0, binarySearch(persons, prs1));
            assertEquals(-1, binarySearch(persons, new Person(5, "Serg")));

        }
    @Test
        void evenOddSorting() {
            Integer[] array = {-3, 7, -8, 10, -100, 13, -10, 99};
            Integer[] expected = {-100, -10, -8, 10, 99, 13, 7, -3};
            sort(array, (a,b) -> {
                boolean isArg0Even = a % 2 == 0;
                boolean isArg1Even = b % 2 == 0;
                boolean noSwapFlag = (isArg0Even && !isArg1Even) ||
                (isArg0Even && isArg1Even && a <= b) ||
                (!isArg0Even && !isArg1Even && a >= b); 
                return noSwapFlag ? -1 : 1;
            });
            assertArrayEquals(expected, array);
        }
    @Test
        void findTest() {
            Integer[] array = {7, -8, 10, -100, 13, -10, 99};
            Integer [] expected = {7, 13, 99};
            assertArrayEquals(expected, find(array, n -> n % 2 != 0));
}
    @Test
    void removeIfTest() {
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {-8, 10, -100, -10};
        Integer[] actual = removeIf(array, n -> n % 2 != 0);
        assertArrayEquals(expected, actual);
    }
    @Test
    void matchesRulesTest() {
        //TODO
        // Must be rules: at least one capital letter, at least one lower case letter, at least one digit, at least one dot(.)
        // Must not be rules: space is disallowed
        //examples: mathes - {'a', 'n', '*', 'G', '.', '.', '1'}
        //mismatches - {'a', 'n', '*', 'G', '.', '.', '1'}-> "space disallowed"
        // {'a', 'n', '*', '.', '.', '1'} -> "no capital" 
        // {'a', 'n', '*', 'G', '.', '.'} -> "no digit"
        char[] array = {'g'};
        char[] array2 = {'a', 'n', '*', 'F', '.', '.', '1'};
        CharacterRule rule1 = new CharacterRule(true, (n) -> Character.isLowerCase(n), "contain capital letter" ); //MustBeRules
        CharacterRule rule2 = new CharacterRule(true, (n) -> Character.isDigit(n), "no contain digit");
        CharacterRule rule3 = new CharacterRule(true, (n) -> Character.isLetter(n), "contain no letter");
        CharacterRule unRule1 = new CharacterRule(false, (n) -> Character.isWhitespace(n), "contain space");//MustNotBeRules
        CharacterRule unRule2 = new CharacterRule(false, (n) -> Character.isLetterOrDigit(n), "containLetter or Digit");
        CharacterRule unRule3 = new CharacterRule(false, (n) -> Character.isUpperCase(n), "contain capital letter!");
        CharacterRule rules[] = {rule1};
        CharacterRule rules2[] = {rule1, rule2, rule3};
        CharacterRule rules3[] = {rule2};
        CharacterRule unRules[] = {unRule1};
        CharacterRule unRules2[] = {unRule1, unRule2, unRule3};
        CharacterRule unRules3[] = {unRule3};
        assertEquals("", matchesRules(array, rules, unRules));
        assertEquals("contain capital letter!.", matchesRules(array2, rules3, unRules3));
        assertEquals("containLetter or Digit.contain capital letter!.", matchesRules(array2, rules, unRules2));
        assertEquals("containLetter or Digit.contain capital letter!.", matchesRules(array2, rules2, unRules2));
    }
}       