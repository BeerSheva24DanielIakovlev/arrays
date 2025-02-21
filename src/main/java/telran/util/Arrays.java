package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

public class Arrays {
    public static int search(int[] ar, int key) {
        int index = 0;
        while(index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int [] ar, int number) {
        int [] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    public static int[] insert(int[] ar, int index, int number) {
        int [] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[index] = number;
        System.arraycopy (ar, index, res, index + 1, ar.length - index);
        return res; 
    }

    public static int[] remove(int[] numbers, int index) {
        int [] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
        System.arraycopy(numbers, index + 1, res, index, numbers.length - index - 1);
        return res;
    }

    public static boolean pushMaxAtEnd(int[] ar, int length) {
        boolean res = true;
        for(int i = 0; i < length; i++) {
            if(ar[i] > ar[i + 1]) {
                res = false;
                swap(ar, i, i + 1);
            }
        }
        return res;
    }

        private static void swap(int[] ar, int i, int j) {
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }

    public static void sort(int [] ar) {
        int length = ar.length;
        boolean flSorted = false;
        while(!flSorted) {
            length--;
            flSorted = pushMaxAtEnd(ar, length);
        } 
    }

    public static int binarySearch(int [] ar, int key) {
        int left = 0;
        int right = ar.length - 1;
        int middle = (left + right) / 2;
        
        while (left <= right && ar[middle] != key) {
            if (key < ar[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle;
    }
    

    public static int[] insertSorted(int[] arSorted, int number) {
        int start = 0;
        int finish = arSorted.length - 1;
        
        while (start <= finish) {
            int mid = start + (finish - start) / 2;
            
            if (arSorted[mid] == number) {
                return arSorted;
            }
            
            else if (arSorted[mid] > number) {
                finish = mid - 1;
            }
            
            else {
                start = mid + 1;
            }
        }
        int index = start;
        
        int [] res = java.util.Arrays.copyOf(arSorted, arSorted.length + 1);
        res[index] = number;
        System.arraycopy (arSorted, index, res, index + 1, arSorted.length - index);
        return res;
    }

    public static boolean isOneSwap(int [] array) {
        int length = array.length;
        int counter = 0;
        boolean res = true;
        
        while (res) {
            res = false;
        
            for(int i = 1; i < length; i++) {
                if(array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    counter++;
                }
                
                res = true;
                
            }
            length--;
        }
        return counter == 1;
    }
    
     public static <T> void sort(T[] array, Comparator<T> comparator) {
       int length = array.length;
       boolean flSort = false;
       do {
            length--;
            flSort = true;
            for(int i = 0; i < length; i++) {
                if(comparator.compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    flSort = false;
                }
            }
       }while(!flSort);
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2; 
        while (left <= right && comp.compare(key, array[middle]) != 0) {
            if (comp.compare(key, array[middle]) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle;
    }

    /*public static <T extends Comparable<? super T>>  int binarySearch(T[] array, T key) {
        return binarySearch(array, key, Comparator.naturalOrder());
    }*/

   /* @SuppressWarnings("unchecked")
    public static <T> int binarySearch(T[] array, T key) {
        return binarySearch(array, key, (a, b) -> ((Comparable<? super T>) a).compareTo(b));
    }*/

    @SuppressWarnings("unchecked")
    public static <T> int binarySearch(T[] array, T key) {
        //The code should be based on binarySearch with comparator
        return binarySearch(array, key, (Comparator<T>)Comparator.naturalOrder());
    } 

    public static <T> T[] insert(T [] array, int index, T item) {
        //T [] resultArr = new T [10];
        T [] res = java.util.Arrays.copyOf(array, array.length + 1);
        System.arraycopy (array, index, res, index + 1, array.length - index);
        res[index] = item;
        return res;
    }

    public static <T> T[] find(T [] array, Predicate<T> predicate) {
        T[] result = java.util.Arrays.copyOf(array, 0);
        for(int i = 0; i < array.length; i++) {
            if(predicate.test(array[i])) {
                result = insert(result, result.length, array[i]);
            }
        }
        return result;
    }

    public static <T> T[] removeIf (T[] array, Predicate<T> predicate) {
        return find(array, predicate.negate());
    }

    public static String matchesRules(char[] chars, CharacterRule[] mustBeRules, CharacterRule[] mustNotBeRule){
        String result = "";
 
        for(int p = 0; p < mustBeRules.length; p++) {
            int i = 0;
            int counter = 0;
            do{
                if (mustBeRules[p].predicate.test(chars[i]) != mustBeRules[p].flag){
                    counter++;
                }
                i++;
            } while((i) < chars.length);
            if (counter == chars.length){
                result += mustBeRules[p].errorMessage + "."; 
            }

        }

        for(int u = 0; u < mustNotBeRule.length; u++) {
         int i = 0;
         int counter = 0;
            do {
                if (mustNotBeRule[u].predicate.test(chars[i]) != mustNotBeRule[u].flag){
                    counter++;
                }
                i++;
            } while( (i) < chars.length);
            if (counter > 0){
                result += mustNotBeRule[u].errorMessage + "."; 
            }

        }
        return result;
    }

}